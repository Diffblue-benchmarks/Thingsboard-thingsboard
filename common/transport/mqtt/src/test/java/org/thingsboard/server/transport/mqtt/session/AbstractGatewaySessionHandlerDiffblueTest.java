package org.thingsboard.server.transport.mqtt.session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.gson.JsonSyntaxException;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import io.netty.buffer.AbstractByteBuf;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.ReadOnlyByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.handler.codec.mqtt.MqttReasonCodes;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.util.ConcurrentReferenceHashMap;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportContext;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.common.transport.auth.TransportDeviceInfo;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.common.TbRuleEngineProducerService;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory;
import org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;
import org.thingsboard.server.transport.mqtt.adaptors.JsonMqttAdaptor;
import org.thingsboard.server.transport.mqtt.adaptors.MqttTransportAdaptor;
import org.thingsboard.server.transport.mqtt.gateway.GatewayMetricsService;
import org.thingsboard.server.transport.mqtt.util.sparkplug.SparkplugConnectionState;

class AbstractGatewaySessionHandlerDiffblueTest {
  /**
   * Test {@link AbstractGatewaySessionHandler#createWeakMap()}.
   * <p>
   * Method under test: {@link AbstractGatewaySessionHandler#createWeakMap()}
   */
  @Test
  @DisplayName("Test createWeakMap()")
  void testCreateWeakMap() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act and Assert
    assertEquals(gatewaySessionHandler.mqttQoSMap, gatewaySessionHandler.createWeakMap());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#createWeakMap()}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractGatewaySessionHandler#createWeakMap()}
   */
  @Test
  @DisplayName("Test createWeakMap(); given Function apply(Object) return one; then return Empty")
  void testCreateWeakMap_givenFunctionApplyReturnOne_thenReturnEmpty() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    ConcurrentReferenceHashMap<String, Lock> actualCreateWeakMapResult = (new GatewaySessionHandler(deviceSessionCtx,
        UUID.randomUUID(), true)).createWeakMap();

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertTrue(actualCreateWeakMapResult.isEmpty());
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceDisconnect(MqttPublishMessage)}.
   * <ul>
   *   <li>Given {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is
   * {@link MqttTransportAdaptor#ALLOCATOR}.</li>
   *   <li>Then calls {@link MqttPublishMessage#payload()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceDisconnect(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceDisconnect(MqttPublishMessage); given EmptyByteBuf(ByteBufAllocator) with alloc is ALLOCATOR; then calls payload()")
  void testOnDeviceDisconnect_givenEmptyByteBufWithAllocIsAllocator_thenCallsPayload() throws AdaptorException {
    // Arrange
    TransportDeviceInfo transportDeviceInfo = mock(TransportDeviceInfo.class);
    doNothing().when(transportDeviceInfo).setDeviceProfileId(Mockito.<DeviceProfileId>any());
    doNothing().when(transportDeviceInfo).setDeviceType(Mockito.<String>any());
    doNothing().when(transportDeviceInfo).setEdrxCycle(Mockito.<Long>any());
    doNothing().when(transportDeviceInfo).setGateway(anyBoolean());
    doNothing().when(transportDeviceInfo).setPagingTransmissionWindow(Mockito.<Long>any());
    doNothing().when(transportDeviceInfo).setPowerMode(Mockito.<PowerMode>any());
    doNothing().when(transportDeviceInfo).setPsmActivityTimer(Mockito.<Long>any());
    doNothing().when(transportDeviceInfo).setTenantId(Mockito.<TenantId>any());
    doNothing().when(transportDeviceInfo).setDeviceId(Mockito.<DeviceId>any());
    doNothing().when(transportDeviceInfo).setDeviceName(Mockito.<String>any());
    doNothing().when(transportDeviceInfo).setAdditionalInfo(Mockito.<String>any());
    doNothing().when(transportDeviceInfo).setCustomerId(Mockito.<CustomerId>any());
    transportDeviceInfo.setAdditionalInfo("Additional Info");
    transportDeviceInfo.setCustomerId(new CustomerId(UUID.randomUUID()));
    transportDeviceInfo.setDeviceId(null);
    transportDeviceInfo.setDeviceName("Device Name");
    transportDeviceInfo.setDeviceProfileId(null);
    transportDeviceInfo.setDeviceType("Device Type");
    transportDeviceInfo.setEdrxCycle(1L);
    transportDeviceInfo.setGateway(true);
    transportDeviceInfo.setPagingTransmissionWindow(1L);
    transportDeviceInfo.setPowerMode(PowerMode.PSM);
    transportDeviceInfo.setPsmActivityTimer(1L);
    transportDeviceInfo.setTenantId(new TenantId(UUID.randomUUID()));
    DeviceSessionCtx deviceSessionCtx = mock(DeviceSessionCtx.class);
    when(deviceSessionCtx.isJsonPayloadType()).thenReturn(false);
    when(deviceSessionCtx.getChannel()).thenReturn(mock(ChannelHandlerContext.class));
    when(deviceSessionCtx.getMqttQoSMap()).thenReturn(new ConcurrentHashMap<>());
    when(deviceSessionCtx.getDeviceInfo()).thenReturn(transportDeviceInfo);
    when(deviceSessionCtx.getContext()).thenReturn(new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    new RuntimeException("foo");
    MqttPublishMessage mqttMsg = mock(MqttPublishMessage.class);
    when(mqttMsg.payload()).thenReturn(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> gatewaySessionHandler.onDeviceDisconnect(mqttMsg));
    verify(mqttMsg).payload();
    verify(transportDeviceInfo).setAdditionalInfo(eq("Additional Info"));
    verify(transportDeviceInfo).setCustomerId(isA(CustomerId.class));
    verify(transportDeviceInfo).setDeviceId(isNull());
    verify(transportDeviceInfo).setDeviceName(eq("Device Name"));
    verify(transportDeviceInfo).setDeviceProfileId(isNull());
    verify(transportDeviceInfo).setDeviceType(eq("Device Type"));
    verify(transportDeviceInfo).setEdrxCycle(eq(1L));
    verify(transportDeviceInfo).setGateway(eq(true));
    verify(transportDeviceInfo).setPagingTransmissionWindow(eq(1L));
    verify(transportDeviceInfo).setPowerMode(eq(PowerMode.PSM));
    verify(transportDeviceInfo).setPsmActivityTimer(eq(1L));
    verify(transportDeviceInfo).setTenantId(isA(TenantId.class));
    verify(deviceSessionCtx).getDeviceInfo();
    verify(deviceSessionCtx).getChannel();
    verify(deviceSessionCtx, atLeast(1)).getContext();
    verify(deviceSessionCtx).isJsonPayloadType();
    verify(deviceSessionCtx).getMqttQoSMap();
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceDisconnect(MqttPublishMessage)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then calls {@link AbstractByteBuf#maxCapacity()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceDisconnect(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceDisconnect(MqttPublishMessage); given three; then calls maxCapacity()")
  void testOnDeviceDisconnect_givenThree_thenCallsMaxCapacity() throws AdaptorException {
    // Arrange
    TransportDeviceInfo transportDeviceInfo = mock(TransportDeviceInfo.class);
    doNothing().when(transportDeviceInfo).setDeviceProfileId(Mockito.<DeviceProfileId>any());
    doNothing().when(transportDeviceInfo).setDeviceType(Mockito.<String>any());
    doNothing().when(transportDeviceInfo).setEdrxCycle(Mockito.<Long>any());
    doNothing().when(transportDeviceInfo).setGateway(anyBoolean());
    doNothing().when(transportDeviceInfo).setPagingTransmissionWindow(Mockito.<Long>any());
    doNothing().when(transportDeviceInfo).setPowerMode(Mockito.<PowerMode>any());
    doNothing().when(transportDeviceInfo).setPsmActivityTimer(Mockito.<Long>any());
    doNothing().when(transportDeviceInfo).setTenantId(Mockito.<TenantId>any());
    doNothing().when(transportDeviceInfo).setDeviceId(Mockito.<DeviceId>any());
    doNothing().when(transportDeviceInfo).setDeviceName(Mockito.<String>any());
    doNothing().when(transportDeviceInfo).setAdditionalInfo(Mockito.<String>any());
    doNothing().when(transportDeviceInfo).setCustomerId(Mockito.<CustomerId>any());
    transportDeviceInfo.setAdditionalInfo("Additional Info");
    transportDeviceInfo.setCustomerId(new CustomerId(UUID.randomUUID()));
    transportDeviceInfo.setDeviceId(null);
    transportDeviceInfo.setDeviceName("Device Name");
    transportDeviceInfo.setDeviceProfileId(null);
    transportDeviceInfo.setDeviceType("Device Type");
    transportDeviceInfo.setEdrxCycle(1L);
    transportDeviceInfo.setGateway(true);
    transportDeviceInfo.setPagingTransmissionWindow(1L);
    transportDeviceInfo.setPowerMode(PowerMode.PSM);
    transportDeviceInfo.setPsmActivityTimer(1L);
    transportDeviceInfo.setTenantId(new TenantId(UUID.randomUUID()));
    DeviceSessionCtx deviceSessionCtx = mock(DeviceSessionCtx.class);
    when(deviceSessionCtx.isJsonPayloadType()).thenReturn(false);
    when(deviceSessionCtx.getChannel()).thenReturn(mock(ChannelHandlerContext.class));
    when(deviceSessionCtx.getMqttQoSMap()).thenReturn(new ConcurrentHashMap<>());
    when(deviceSessionCtx.getDeviceInfo()).thenReturn(transportDeviceInfo);
    when(deviceSessionCtx.getContext()).thenReturn(new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    CompositeByteBuf buffer = mock(CompositeByteBuf.class);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    when(buffer.refCnt()).thenReturn(1);
    when(buffer.capacity()).thenReturn(3);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(buffer);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> gatewaySessionHandler.onDeviceDisconnect(
        new MqttPublishMessage(mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload)));
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
    verify(buffer).refCnt();
    verify(buffer).capacity();
    verify(transportDeviceInfo).setAdditionalInfo(eq("Additional Info"));
    verify(transportDeviceInfo).setCustomerId(isA(CustomerId.class));
    verify(transportDeviceInfo).setDeviceId(isNull());
    verify(transportDeviceInfo).setDeviceName(eq("Device Name"));
    verify(transportDeviceInfo).setDeviceProfileId(isNull());
    verify(transportDeviceInfo).setDeviceType(eq("Device Type"));
    verify(transportDeviceInfo).setEdrxCycle(eq(1L));
    verify(transportDeviceInfo).setGateway(eq(true));
    verify(transportDeviceInfo).setPagingTransmissionWindow(eq(1L));
    verify(transportDeviceInfo).setPowerMode(eq(PowerMode.PSM));
    verify(transportDeviceInfo).setPsmActivityTimer(eq(1L));
    verify(transportDeviceInfo).setTenantId(isA(TenantId.class));
    verify(deviceSessionCtx).getDeviceInfo();
    verify(deviceSessionCtx).getChannel();
    verify(deviceSessionCtx, atLeast(1)).getContext();
    verify(deviceSessionCtx).isJsonPayloadType();
    verify(deviceSessionCtx).getMqttQoSMap();
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceDisconnect(MqttPublishMessage)}.
   * <ul>
   *   <li>Then throw {@link AdaptorException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceDisconnect(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceDisconnect(MqttPublishMessage); then throw AdaptorException")
  void testOnDeviceDisconnect_thenThrowAdaptorException() throws AdaptorException {
    // Arrange
    TransportDeviceInfo transportDeviceInfo = mock(TransportDeviceInfo.class);
    doNothing().when(transportDeviceInfo).setDeviceProfileId(Mockito.<DeviceProfileId>any());
    doNothing().when(transportDeviceInfo).setDeviceType(Mockito.<String>any());
    doNothing().when(transportDeviceInfo).setEdrxCycle(Mockito.<Long>any());
    doNothing().when(transportDeviceInfo).setGateway(anyBoolean());
    doNothing().when(transportDeviceInfo).setPagingTransmissionWindow(Mockito.<Long>any());
    doNothing().when(transportDeviceInfo).setPowerMode(Mockito.<PowerMode>any());
    doNothing().when(transportDeviceInfo).setPsmActivityTimer(Mockito.<Long>any());
    doNothing().when(transportDeviceInfo).setTenantId(Mockito.<TenantId>any());
    doNothing().when(transportDeviceInfo).setDeviceId(Mockito.<DeviceId>any());
    doNothing().when(transportDeviceInfo).setDeviceName(Mockito.<String>any());
    doNothing().when(transportDeviceInfo).setAdditionalInfo(Mockito.<String>any());
    doNothing().when(transportDeviceInfo).setCustomerId(Mockito.<CustomerId>any());
    transportDeviceInfo.setAdditionalInfo("Additional Info");
    transportDeviceInfo.setCustomerId(new CustomerId(UUID.randomUUID()));
    transportDeviceInfo.setDeviceId(null);
    transportDeviceInfo.setDeviceName("Device Name");
    transportDeviceInfo.setDeviceProfileId(null);
    transportDeviceInfo.setDeviceType("Device Type");
    transportDeviceInfo.setEdrxCycle(1L);
    transportDeviceInfo.setGateway(true);
    transportDeviceInfo.setPagingTransmissionWindow(1L);
    transportDeviceInfo.setPowerMode(PowerMode.PSM);
    transportDeviceInfo.setPsmActivityTimer(1L);
    transportDeviceInfo.setTenantId(new TenantId(UUID.randomUUID()));
    DeviceSessionCtx deviceSessionCtx = mock(DeviceSessionCtx.class);
    when(deviceSessionCtx.isJsonPayloadType()).thenReturn(false);
    when(deviceSessionCtx.getChannel()).thenReturn(mock(ChannelHandlerContext.class));
    when(deviceSessionCtx.getMqttQoSMap()).thenReturn(new ConcurrentHashMap<>());
    when(deviceSessionCtx.getDeviceInfo()).thenReturn(transportDeviceInfo);
    when(deviceSessionCtx.getContext()).thenReturn(new MqttTransportContext());
    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> gatewaySessionHandler.onDeviceDisconnect(new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
    verify(transportDeviceInfo).setAdditionalInfo(eq("Additional Info"));
    verify(transportDeviceInfo).setCustomerId(isA(CustomerId.class));
    verify(transportDeviceInfo).setDeviceId(isNull());
    verify(transportDeviceInfo).setDeviceName(eq("Device Name"));
    verify(transportDeviceInfo).setDeviceProfileId(isNull());
    verify(transportDeviceInfo).setDeviceType(eq("Device Type"));
    verify(transportDeviceInfo).setEdrxCycle(eq(1L));
    verify(transportDeviceInfo).setGateway(eq(true));
    verify(transportDeviceInfo).setPagingTransmissionWindow(eq(1L));
    verify(transportDeviceInfo).setPowerMode(eq(PowerMode.PSM));
    verify(transportDeviceInfo).setPsmActivityTimer(eq(1L));
    verify(transportDeviceInfo).setTenantId(isA(TenantId.class));
    verify(deviceSessionCtx).getDeviceInfo();
    verify(deviceSessionCtx).getChannel();
    verify(deviceSessionCtx, atLeast(1)).getContext();
    verify(deviceSessionCtx).isJsonPayloadType();
    verify(deviceSessionCtx).getMqttQoSMap();
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceClaim(MqttPublishMessage)}.
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceClaim(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceClaim(MqttPublishMessage)")
  void testOnDeviceClaim() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceClaim(
        new MqttPublishMessage(mqttFixedHeader, variableHeader, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceClaim(MqttPublishMessage)}.
   * <ul>
   *   <li>When {@link DuplicatedByteBuf#DuplicatedByteBuf(ByteBuf)} with buffer is
   * compositeBuffer three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceClaim(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceClaim(MqttPublishMessage); when DuplicatedByteBuf(ByteBuf) with buffer is compositeBuffer three")
  void testOnDeviceClaim_whenDuplicatedByteBufWithBufferIsCompositeBufferThree() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceClaim(
        new MqttPublishMessage(mqttFixedHeader, variableHeader, new DuplicatedByteBuf(Unpooled.compositeBuffer(3)))));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDeviceClaim(MqttPublishMessage)}.
   * <ul>
   *   <li>When {@link DuplicatedByteBuf#DuplicatedByteBuf(ByteBuf)} with buffer is
   * {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceClaim(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceClaim(MqttPublishMessage); when DuplicatedByteBuf(ByteBuf) with buffer is EmptyByteBuf(ByteBufAllocator)")
  void testOnDeviceClaim_whenDuplicatedByteBufWithBufferIsEmptyByteBuf() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(JsonSyntaxException.class,
        () -> gatewaySessionHandler.onDeviceClaim(new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceAttributes(MqttPublishMessage)}.
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceAttributes(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceAttributes(MqttPublishMessage)")
  void testOnDeviceAttributes() throws AdaptorException {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(null, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(JsonSyntaxException.class,
        () -> gatewaySessionHandler.onDeviceAttributes(new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceAttributes(MqttPublishMessage)}.
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceAttributes(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceAttributes(MqttPublishMessage)")
  void testOnDeviceAttributes2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceAttributes(
        new MqttPublishMessage(mqttFixedHeader, variableHeader, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceAttributes(MqttPublishMessage)}.
   * <ul>
   *   <li>When {@link DuplicatedByteBuf#DuplicatedByteBuf(ByteBuf)} with buffer is
   * compositeBuffer three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceAttributes(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceAttributes(MqttPublishMessage); when DuplicatedByteBuf(ByteBuf) with buffer is compositeBuffer three")
  void testOnDeviceAttributes_whenDuplicatedByteBufWithBufferIsCompositeBufferThree() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceAttributes(
        new MqttPublishMessage(mqttFixedHeader, variableHeader, new DuplicatedByteBuf(Unpooled.compositeBuffer(3)))));
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceAttributes(MqttPublishMessage)}.
   * <ul>
   *   <li>When {@link DuplicatedByteBuf#DuplicatedByteBuf(ByteBuf)} with buffer is
   * {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceAttributes(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceAttributes(MqttPublishMessage); when DuplicatedByteBuf(ByteBuf) with buffer is EmptyByteBuf(ByteBufAllocator)")
  void testOnDeviceAttributes_whenDuplicatedByteBufWithBufferIsEmptyByteBuf() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(JsonSyntaxException.class,
        () -> gatewaySessionHandler.onDeviceAttributes(new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceAttributesRequest(MqttPublishMessage)}.
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceAttributesRequest(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceAttributesRequest(MqttPublishMessage)")
  void testOnDeviceAttributesRequest() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceAttributesRequest(
        new MqttPublishMessage(mqttFixedHeader, variableHeader, new DuplicatedByteBuf(Unpooled.compositeBuffer(3)))));
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceAttributesRequest(MqttPublishMessage)}.
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceAttributesRequest(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceAttributesRequest(MqttPublishMessage)")
  void testOnDeviceAttributesRequest2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceAttributesRequest(
        new MqttPublishMessage(mqttFixedHeader, variableHeader, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceAttributesRequest(MqttPublishMessage)}.
   * <ul>
   *   <li>When {@link DuplicatedByteBuf#DuplicatedByteBuf(ByteBuf)} with buffer is
   * {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceAttributesRequest(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceAttributesRequest(MqttPublishMessage); when DuplicatedByteBuf(ByteBuf) with buffer is EmptyByteBuf(ByteBufAllocator)")
  void testOnDeviceAttributesRequest_whenDuplicatedByteBufWithBufferIsEmptyByteBuf() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(JsonSyntaxException.class,
        () -> gatewaySessionHandler.onDeviceAttributesRequest(new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceRpcResponse(MqttPublishMessage)}
   * with {@code mqttMsg}.
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceRpcResponse(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceRpcResponse(MqttPublishMessage) with 'mqttMsg'")
  void testOnDeviceRpcResponseWithMqttMsg() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceRpcResponse(
        new MqttPublishMessage(mqttFixedHeader, variableHeader, new DuplicatedByteBuf(Unpooled.compositeBuffer(3)))));
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceRpcResponse(MqttPublishMessage)}
   * with {@code mqttMsg}.
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceRpcResponse(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceRpcResponse(MqttPublishMessage) with 'mqttMsg'")
  void testOnDeviceRpcResponseWithMqttMsg2() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceRpcResponse(
        new MqttPublishMessage(mqttFixedHeader, variableHeader, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceRpcResponse(MqttPublishMessage)}
   * with {@code mqttMsg}.
   * <ul>
   *   <li>When {@link DuplicatedByteBuf#DuplicatedByteBuf(ByteBuf)} with buffer is
   * {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceRpcResponse(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceRpcResponse(MqttPublishMessage) with 'mqttMsg'; when DuplicatedByteBuf(ByteBuf) with buffer is EmptyByteBuf(ByteBufAllocator)")
  void testOnDeviceRpcResponseWithMqttMsg_whenDuplicatedByteBufWithBufferIsEmptyByteBuf() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(JsonSyntaxException.class,
        () -> gatewaySessionHandler.onDeviceRpcResponse(new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onGatewayPing()}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractGatewaySessionHandler#onGatewayPing()}
   */
  @Test
  @DisplayName("Test onGatewayPing(); given Function apply(Object) return one; then calls apply(Object)")
  void testOnGatewayPing_givenFunctionApplyReturnOne_thenCallsApply() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    (new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true)).onGatewayPing();

    // Assert that nothing has changed
    verify(function).apply(isA(MqttTopicMatcher.class));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#onDevicesDisconnect()}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDevicesDisconnect()}
   */
  @Test
  @DisplayName("Test onDevicesDisconnect(); given Function apply(Object) return one; then calls apply(Object)")
  void testOnDevicesDisconnect_givenFunctionApplyReturnOne_thenCallsApply() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    (new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true)).onDevicesDisconnect();

    // Assert that nothing has changed
    verify(function).apply(isA(MqttTopicMatcher.class));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getNodeId()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractGatewaySessionHandler#getNodeId()}
   */
  @Test
  @DisplayName("Test getNodeId(); then return 'null'")
  void testGetNodeId_thenReturnNull() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);

    MqttTransportContext context = new MqttTransportContext();
    context.setServiceInfoProvider(new DefaultTbServiceInfoProvider());
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(UUID.randomUUID(), mqttQoSMap, context);

    // Act
    String actualNodeId = (new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true)).getNodeId();

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertNull(actualNodeId);
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getPayloadAdaptor()}.
   * <p>
   * Method under test: {@link AbstractGatewaySessionHandler#getPayloadAdaptor()}
   */
  @Test
  @DisplayName("Test getPayloadAdaptor()")
  void testGetPayloadAdaptor() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertNull((new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true)).getPayloadAdaptor());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getPayloadAdaptor()}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractGatewaySessionHandler#getPayloadAdaptor()}
   */
  @Test
  @DisplayName("Test getPayloadAdaptor(); given Function apply(Object) return one; then calls apply(Object)")
  void testGetPayloadAdaptor_givenFunctionApplyReturnOne_thenCallsApply() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    MqttTransportAdaptor actualPayloadAdaptor = (new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true))
        .getPayloadAdaptor();

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertNull(actualPayloadAdaptor);
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#writeAndFlush(MqttMessage)}.
   * <ul>
   *   <li>Then return {@link DefaultChannelProgressivePromise}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#writeAndFlush(MqttMessage)}
   */
  @Test
  @DisplayName("Test writeAndFlush(MqttMessage); then return DefaultChannelProgressivePromise")
  void testWriteAndFlush_thenReturnDefaultChannelProgressivePromise() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    ChannelHandlerContext channel = mock(ChannelHandlerContext.class);
    DefaultChannelProgressivePromise defaultChannelProgressivePromise = new DefaultChannelProgressivePromise(
        new EmbeddedChannel());
    when(channel.writeAndFlush(Mockito.<Object>any())).thenReturn(defaultChannelProgressivePromise);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setChannel(channel);
    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act
    ChannelFuture actualWriteAndFlushResult = gatewaySessionHandler.writeAndFlush(
        new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    verify(channel).writeAndFlush(isA(Object.class));
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertTrue(actualWriteAndFlushResult instanceof DefaultChannelProgressivePromise);
    assertSame(defaultChannelProgressivePromise, actualWriteAndFlushResult);
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#nextMsgId()}.
   * <p>
   * Method under test: {@link AbstractGatewaySessionHandler#nextMsgId()}
   */
  @Test
  @DisplayName("Test nextMsgId()")
  void testNextMsgId() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertEquals(1, (new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true)).nextMsgId());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#nextMsgId()}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractGatewaySessionHandler#nextMsgId()}
   */
  @Test
  @DisplayName("Test nextMsgId(); given Function apply(Object) return one; then calls apply(Object)")
  void testNextMsgId_givenFunctionApplyReturnOne_thenCallsApply() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    int actualNextMsgIdResult = (new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true)).nextMsgId();

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertEquals(1, actualNextMsgIdResult);
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#isJsonPayloadType()}.
   * <p>
   * Method under test: {@link AbstractGatewaySessionHandler#isJsonPayloadType()}
   */
  @Test
  @DisplayName("Test isJsonPayloadType()")
  void testIsJsonPayloadType() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertTrue((new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true)).isJsonPayloadType());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#isJsonPayloadType()}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractGatewaySessionHandler#isJsonPayloadType()}
   */
  @Test
  @DisplayName("Test isJsonPayloadType(); given Function apply(Object) return one; then calls apply(Object)")
  void testIsJsonPayloadType_givenFunctionApplyReturnOne_thenCallsApply() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    boolean actualIsJsonPayloadTypeResult = (new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true))
        .isJsonPayloadType();

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertTrue(actualIsJsonPayloadTypeResult);
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getMsgId(MqttPublishMessage)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>When {@link ByteBuf} {@link ByteBuf#capacity()} return three.</li>
   *   <li>Then calls {@link ByteBuf#capacity()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#getMsgId(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test getMsgId(MqttPublishMessage); given three; when ByteBuf capacity() return three; then calls capacity()")
  void testGetMsgId_givenThree_whenByteBufCapacityReturnThree_thenCallsCapacity() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(new ReadOnlyByteBuf(new DuplicatedByteBuf(buffer)));
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    // Act
    int actualMsgId = gatewaySessionHandler
        .getMsgId(new MqttPublishMessage(mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload));

    // Assert
    verify(buffer, atLeast(1)).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
    assertEquals(1, actualMsgId);
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getMsgId(MqttPublishMessage)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#getMsgId(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test getMsgId(MqttPublishMessage); then return one")
  void testGetMsgId_thenReturnOne() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertEquals(1, gatewaySessionHandler.getMsgId(new MqttPublishMessage(mqttFixedHeader, variableHeader,
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceConnectProto(MqttPublishMessage)}.
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceConnectProto(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceConnectProto(MqttPublishMessage)")
  void testOnDeviceConnectProto() throws AdaptorException {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(null, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> gatewaySessionHandler.onDeviceConnectProto(new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceConnectProto(MqttPublishMessage)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then calls {@link ByteBuf#capacity()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceConnectProto(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceConnectProto(MqttPublishMessage); given three; then calls capacity()")
  void testOnDeviceConnectProto_givenThree_thenCallsCapacity() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    when(buffer.refCnt()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(new ReadOnlyByteBuf(new DuplicatedByteBuf(buffer)));
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> gatewaySessionHandler.onDeviceConnectProto(
        new MqttPublishMessage(mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload)));
    verify(buffer, atLeast(1)).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
    verify(buffer).refCnt();
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceConnectProto(MqttPublishMessage)}.
   * <ul>
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is
   * {@link MqttTransportAdaptor#ALLOCATOR}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceConnectProto(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onDeviceConnectProto(MqttPublishMessage); when EmptyByteBuf(ByteBufAllocator) with alloc is ALLOCATOR")
  void testOnDeviceConnectProto_whenEmptyByteBufWithAllocIsAllocator() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> gatewaySessionHandler.onDeviceConnectProto(new MqttPublishMessage(mqttFixedHeader, variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onGatewayDeviceDisconnectProto(MqttPublishMessage)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then calls {@link ByteBuf#capacity()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onGatewayDeviceDisconnectProto(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onGatewayDeviceDisconnectProto(MqttPublishMessage); given three; then calls capacity()")
  void testOnGatewayDeviceDisconnectProto_givenThree_thenCallsCapacity() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    when(buffer.refCnt()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(new ReadOnlyByteBuf(new DuplicatedByteBuf(buffer)));
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    // Act and Assert
    assertThrows(AdaptorException.class, () -> gatewaySessionHandler.onGatewayDeviceDisconnectProto(
        new MqttPublishMessage(mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload)));
    verify(buffer, atLeast(1)).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
    verify(buffer).refCnt();
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onGatewayDeviceDisconnectProto(MqttPublishMessage)}.
   * <ul>
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is
   * {@link MqttTransportAdaptor#ALLOCATOR}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onGatewayDeviceDisconnectProto(MqttPublishMessage)}
   */
  @Test
  @DisplayName("Test onGatewayDeviceDisconnectProto(MqttPublishMessage); when EmptyByteBuf(ByteBufAllocator) with alloc is ALLOCATOR")
  void testOnGatewayDeviceDisconnectProto_whenEmptyByteBufWithAllocIsAllocator() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act and Assert
    assertThrows(AdaptorException.class,
        () -> gatewaySessionHandler.onGatewayDeviceDisconnectProto(new MqttPublishMessage(mqttFixedHeader,
            variableHeader, new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)))));
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceTelemetryJson(int, ByteBuf)}.
   * <ul>
   *   <li>Then calls {@link ByteBuf#capacity()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceTelemetryJson(int, ByteBuf)}
   */
  @Test
  @DisplayName("Test onDeviceTelemetryJson(int, ByteBuf); then calls capacity()")
  void testOnDeviceTelemetryJson_thenCallsCapacity() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.getBytes(anyInt(), Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenReturn(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(0);
    when(buffer.writerIndex()).thenReturn(1);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceTelemetryJson(1,
        new DuplicatedByteBuf(new ReadOnlyByteBuf(new DuplicatedByteBuf(buffer)))));
    verify(buffer, atLeast(1)).capacity();
    verify(buffer).getBytes(eq(0), isA(byte[].class), eq(0), eq(1));
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceTelemetryJson(int, ByteBuf)}.
   * <ul>
   *   <li>When {@link DuplicatedByteBuf#DuplicatedByteBuf(ByteBuf)} with buffer is
   * {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceTelemetryJson(int, ByteBuf)}
   */
  @Test
  @DisplayName("Test onDeviceTelemetryJson(int, ByteBuf); when DuplicatedByteBuf(ByteBuf) with buffer is EmptyByteBuf(ByteBufAllocator)")
  void testOnDeviceTelemetryJson_whenDuplicatedByteBufWithBufferIsEmptyByteBuf() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class, () -> gatewaySessionHandler.onDeviceTelemetryJson(1,
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceTelemetryJson(int, ByteBuf)}.
   * <ul>
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is
   * {@link MqttTransportAdaptor#ALLOCATOR}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceTelemetryJson(int, ByteBuf)}
   */
  @Test
  @DisplayName("Test onDeviceTelemetryJson(int, ByteBuf); when EmptyByteBuf(ByteBufAllocator) with alloc is ALLOCATOR")
  void testOnDeviceTelemetryJson_whenEmptyByteBufWithAllocIsAllocator() throws AdaptorException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act and Assert
    assertThrows(JsonSyntaxException.class,
        () -> gatewaySessionHandler.onDeviceTelemetryJson(1, new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#onDeviceTelemetryProto(int, ByteBuf)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then throw {@link AdaptorException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#onDeviceTelemetryProto(int, ByteBuf)}
   */
  @Test
  @DisplayName("Test onDeviceTelemetryProto(int, ByteBuf); given one; then throw AdaptorException")
  void testOnDeviceTelemetryProto_givenOne_thenThrowAdaptorException() throws AdaptorException {
    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    when(context.getGatewayMetricsService()).thenReturn(new GatewayMetricsService());
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, new ConcurrentHashMap<>(), context);

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    ByteBuf payload = mock(ByteBuf.class);
    when(payload.readableBytes()).thenReturn(1);
    when(payload.readerIndex()).thenReturn(1);
    when(payload.getBytes(anyInt(), Mockito.<byte[]>any()))
        .thenReturn(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));

    // Act and Assert
    assertThrows(AdaptorException.class, () -> gatewaySessionHandler.onDeviceTelemetryProto(1, payload));
    verify(payload).getBytes(eq(1), isA(byte[].class));
    verify(payload).readableBytes();
    verify(payload).readerIndex();
    verify(context).getTransportService();
    verify(context).getGatewayMetricsService();
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#postTelemetryMsgCreated(KeyValueProto, long)}.
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#postTelemetryMsgCreated(TransportProtos.KeyValueProto, long)}
   */
  @Test
  @DisplayName("Test postTelemetryMsgCreated(KeyValueProto, long)")
  void testPostTelemetryMsgCreated() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act
    TransportProtos.PostTelemetryMsg actualPostTelemetryMsgCreatedResult = gatewaySessionHandler
        .postTelemetryMsgCreated(TransportProtos.KeyValueProto.getDefaultInstance(), 1L);

    // Assert
    Descriptors.Descriptor descriptorForType = actualPostTelemetryMsgCreatedResult.getDescriptorForType();
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    List<TransportProtos.TsKvListProto> tsKvListList = actualPostTelemetryMsgCreatedResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    List<TransportProtos.KeyValueProto> kvList = tsKvListList.get(0).getKvList();
    assertEquals(1, kvList.size());
    ConcurrentMap<MqttTopicMatcher, Integer> mqttTopicMatcherIntegerMap = gatewaySessionHandler.mqttQoSMap;
    assertEquals(mqttTopicMatcherIntegerMap, fields.get(0).toProto().getDefaultInstanceForType().getAllFields());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult = file.toProto();
    assertEquals(mqttTopicMatcherIntegerMap, toProtoResult.getDefaultInstanceForType().getAllFields());
    assertEquals(mqttTopicMatcherIntegerMap, toProtoResult.getSourceCodeInfo().getAllFields());
    assertEquals(mqttTopicMatcherIntegerMap, kvList.get(0).getAllFields());
    DescriptorProtos.FileOptions defaultInstanceForType = file.getOptions().getDefaultInstanceForType();
    assertEquals(mqttTopicMatcherIntegerMap, defaultInstanceForType.getAllFields());
    assertEquals(mqttTopicMatcherIntegerMap, defaultInstanceForType.getAllFieldsRaw());
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#postTelemetryMsgCreated(KeyValueProto, long)}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#postTelemetryMsgCreated(TransportProtos.KeyValueProto, long)}
   */
  @Test
  @DisplayName("Test postTelemetryMsgCreated(KeyValueProto, long); given Function apply(Object) return one; then calls apply(Object)")
  void testPostTelemetryMsgCreated_givenFunctionApplyReturnOne_thenCallsApply() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act
    TransportProtos.PostTelemetryMsg actualPostTelemetryMsgCreatedResult = gatewaySessionHandler
        .postTelemetryMsgCreated(TransportProtos.KeyValueProto.getDefaultInstance(), 1L);

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertEquals(1, actualPostTelemetryMsgCreatedResult.getDescriptorForType().getFields().size());
    List<TransportProtos.TsKvListProto> tsKvListList = actualPostTelemetryMsgCreatedResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    assertEquals(1, tsKvListList.get(0).getKvList().size());
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#postTelemetryMsgCreated(KeyValueProto, long)}.
   * <ul>
   *   <li>Then return DescriptorForType toProto FieldList size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#postTelemetryMsgCreated(TransportProtos.KeyValueProto, long)}
   */
  @Test
  @DisplayName("Test postTelemetryMsgCreated(KeyValueProto, long); then return DescriptorForType toProto FieldList size is one")
  void testPostTelemetryMsgCreated_thenReturnDescriptorForTypeToProtoFieldListSizeIsOne() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(null, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act
    TransportProtos.PostTelemetryMsg actualPostTelemetryMsgCreatedResult = gatewaySessionHandler
        .postTelemetryMsgCreated(TransportProtos.KeyValueProto.getDefaultInstance(), 1L);

    // Assert
    Descriptors.Descriptor descriptorForType = actualPostTelemetryMsgCreatedResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult = descriptorForType.toProto();
    List<DescriptorProtos.FieldDescriptorProto> fieldList = toProtoResult.getFieldList();
    assertEquals(1, fieldList.size());
    List<Descriptors.FieldDescriptor> fields = descriptorForType.getFields();
    assertEquals(1, fields.size());
    List<TransportProtos.TsKvListProto> tsKvListList = actualPostTelemetryMsgCreatedResult.getTsKvListList();
    assertEquals(1, tsKvListList.size());
    TransportProtos.TsKvListProto getResult = tsKvListList.get(0);
    List<TransportProtos.KeyValueProto> kvList = getResult.getKvList();
    assertEquals(1, kvList.size());
    Descriptors.FileDescriptor file = descriptorForType.getFile();
    DescriptorProtos.FileDescriptorProto toProtoResult2 = file.toProto();
    List<DescriptorProtos.EnumDescriptorProto> enumTypeList = toProtoResult2.getEnumTypeList();
    assertEquals(10, enumTypeList.size());
    List<Descriptors.EnumDescriptor> enumTypes = file.getEnumTypes();
    assertEquals(10, enumTypes.size());
    List<DescriptorProtos.DescriptorProto> messageTypeList = toProtoResult2.getMessageTypeList();
    assertEquals(180, messageTypeList.size());
    List<Descriptors.Descriptor> messageTypes = file.getMessageTypes();
    assertEquals(180, messageTypes.size());
    ConcurrentMap<MqttTopicMatcher, Integer> mqttTopicMatcherIntegerMap = gatewaySessionHandler.mqttQoSMap;
    Descriptors.FieldDescriptor getResult2 = fields.get(0);
    DescriptorProtos.FieldDescriptorProto toProtoResult3 = getResult2.toProto();
    DescriptorProtos.FieldDescriptorProto defaultInstanceForType = toProtoResult3.getDefaultInstanceForType();
    assertEquals(mqttTopicMatcherIntegerMap, defaultInstanceForType.getAllFields());
    DescriptorProtos.FileDescriptorProto defaultInstanceForType2 = toProtoResult2.getDefaultInstanceForType();
    assertEquals(mqttTopicMatcherIntegerMap, defaultInstanceForType2.getAllFields());
    DescriptorProtos.SourceCodeInfo sourceCodeInfo = toProtoResult2.getSourceCodeInfo();
    assertEquals(mqttTopicMatcherIntegerMap, sourceCodeInfo.getAllFields());
    TransportProtos.KeyValueProto getResult3 = kvList.get(0);
    assertEquals(mqttTopicMatcherIntegerMap, getResult3.getAllFields());
    DescriptorProtos.FileOptions options = file.getOptions();
    DescriptorProtos.FileOptions defaultInstanceForType3 = options.getDefaultInstanceForType();
    assertEquals(mqttTopicMatcherIntegerMap, defaultInstanceForType3.getAllFields());
    assertEquals(mqttTopicMatcherIntegerMap, defaultInstanceForType3.getAllFieldsRaw());
    DescriptorProtos.DescriptorProto defaultInstanceForType4 = toProtoResult.getDefaultInstanceForType();
    assertSame(defaultInstanceForType4.getDefaultInstanceForType(),
        defaultInstanceForType4.getDefaultInstanceForType());
    Descriptors.Descriptor descriptorForType2 = toProtoResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult4 = descriptorForType2.toProto();
    DescriptorProtos.DescriptorProto defaultInstanceForType5 = toProtoResult4.getDefaultInstanceForType();
    DescriptorProtos.MessageOptions options2 = descriptorForType.getOptions();
    Descriptors.Descriptor descriptorForType3 = options2.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult5 = descriptorForType3.toProto();
    assertSame(defaultInstanceForType5, toProtoResult5.getDefaultInstanceForType());
    assertSame(defaultInstanceForType5, defaultInstanceForType5);
    Descriptors.Descriptor descriptorForType4 = getResult.getDescriptorForType();
    DescriptorProtos.DescriptorProto toProtoResult6 = descriptorForType4.toProto();
    assertSame(defaultInstanceForType5, toProtoResult6.getDefaultInstanceForType());
    assertSame(fieldList, toProtoResult.getFieldOrBuilderList());
    Parser<DescriptorProtos.DescriptorProto> parserForType = toProtoResult4.getParserForType();
    assertSame(parserForType, defaultInstanceForType4.getParserForType());
    assertSame(parserForType, toProtoResult5.getParserForType());
    assertSame(parserForType, parserForType);
    assertSame(parserForType, toProtoResult6.getParserForType());
    assertSame(toProtoResult4.getReservedNameList(), toProtoResult4.getReservedNameList());
    ProtocolStringList reservedNameList = toProtoResult.getReservedNameList();
    assertSame(reservedNameList, defaultInstanceForType4.getReservedNameList());
    assertSame(reservedNameList, toProtoResult5.getReservedNameList());
    assertSame(reservedNameList, toProtoResult6.getReservedNameList());
    assertSame(reservedNameList, defaultInstanceForType2.getDependencyList());
    assertSame(reservedNameList, toProtoResult2.getDependencyList());
    assertSame(defaultInstanceForType.getDefaultInstanceForType(), defaultInstanceForType.getDefaultInstanceForType());
    assertSame(defaultInstanceForType2.getDefaultInstanceForType(),
        defaultInstanceForType2.getDefaultInstanceForType());
    assertSame(enumTypeList, toProtoResult2.getEnumTypeOrBuilderList());
    assertSame(messageTypeList, toProtoResult2.getMessageTypeOrBuilderList());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfo());
    assertSame(sourceCodeInfo, defaultInstanceForType2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, toProtoResult2.getSourceCodeInfoOrBuilder());
    assertSame(sourceCodeInfo, sourceCodeInfo.getDefaultInstanceForType());
    assertSame(defaultInstanceForType3.getDefaultInstanceForType(),
        defaultInstanceForType3.getDefaultInstanceForType());
    DescriptorProtos.FeatureSet features = options2.getFeatures();
    assertSame(features, features.getDefaultInstanceForType());
    assertSame(file, descriptorForType4.getFile());
    Descriptors.Descriptor getResult4 = messageTypes.get(0);
    assertSame(file, getResult4.getFile());
    Descriptors.Descriptor getResult5 = messageTypes.get(1);
    assertSame(file, getResult5.getFile());
    Descriptors.Descriptor getResult6 = messageTypes.get(178);
    assertSame(file, getResult6.getFile());
    Descriptors.Descriptor getResult7 = messageTypes.get(179);
    assertSame(file, getResult7.getFile());
    assertSame(file, enumTypes.get(0).getFile());
    assertSame(file, enumTypes.get(1).getFile());
    assertSame(file, enumTypes.get(8).getFile());
    assertSame(file, enumTypes.get(9).getFile());
    assertSame(file, getResult2.getFile());
    DescriptorProtos.MessageOptions options3 = descriptorForType3.getOptions();
    assertSame(options3, defaultInstanceForType4.getOptions());
    assertSame(options3, toProtoResult5.getOptions());
    assertSame(options3, toProtoResult4.getOptions());
    assertSame(options3, toProtoResult6.getOptions());
    assertSame(options3, toProtoResult.getOptions());
    assertSame(options3, defaultInstanceForType4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult5.getOptionsOrBuilder());
    assertSame(options3, toProtoResult4.getOptionsOrBuilder());
    assertSame(options3, toProtoResult6.getOptionsOrBuilder());
    assertSame(options3, toProtoResult.getOptionsOrBuilder());
    assertSame(options3, features.getDescriptorForType().getOptions());
    assertSame(options3, options3);
    assertSame(options3, descriptorForType2.getOptions());
    DescriptorProtos.FieldOptions options4 = getResult2.getOptions();
    assertSame(options3, options4.getDescriptorForType().getOptions());
    assertSame(options3, options.getDescriptorForType().getOptions());
    assertSame(options3, toProtoResult2.getDescriptorForType().getOptions());
    assertSame(options3, descriptorForType4.getOptions());
    assertSame(options3, getResult4.getOptions());
    assertSame(options3, getResult5.getOptions());
    assertSame(options3, getResult6.getOptions());
    assertSame(options3, getResult7.getOptions());
    assertSame(options2, options2.getDefaultInstanceForType());
    assertSame(options4, options4.getDefaultInstanceForType());
    assertSame(toProtoResult3, fieldList.get(0));
    assertSame(descriptorForType4, getResult2.getMessageType());
    TransportProtos.TsKvListProto defaultInstanceForType6 = getResult.getDefaultInstanceForType();
    assertSame(descriptorForType4, defaultInstanceForType6.getDescriptorForType());
    assertSame(descriptorForType, getResult2.getContainingType());
    TransportProtos.PostTelemetryMsg defaultInstanceForType7 = actualPostTelemetryMsgCreatedResult
        .getDefaultInstanceForType();
    assertSame(descriptorForType, defaultInstanceForType7.getDescriptorForType());
    UnknownFieldSet unknownFields = actualPostTelemetryMsgCreatedResult.getUnknownFields();
    assertSame(unknownFields, defaultInstanceForType4.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType2.getUnknownFields());
    assertSame(unknownFields, sourceCodeInfo.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType3.getUnknownFields());
    assertSame(unknownFields, features.getUnknownFields());
    assertSame(unknownFields, options2.getUnknownFields());
    assertSame(unknownFields, toProtoResult5.getUnknownFields());
    assertSame(unknownFields, toProtoResult4.getUnknownFields());
    assertSame(unknownFields, toProtoResult6.getUnknownFields());
    assertSame(unknownFields, toProtoResult.getUnknownFields());
    assertSame(unknownFields, options4.getUnknownFields());
    assertSame(unknownFields, toProtoResult3.getUnknownFields());
    assertSame(unknownFields, options.getUnknownFields());
    assertSame(unknownFields, toProtoResult2.getUnknownFields());
    assertSame(unknownFields, getResult3.getUnknownFields());
    assertSame(unknownFields, getResult.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType7.getUnknownFields());
    assertSame(unknownFields, defaultInstanceForType6.getUnknownFields());
    assertSame(unknownFields, unknownFields.getDefaultInstanceForType());
    assertSame(defaultInstanceForType7.getDefaultInstanceForType(),
        defaultInstanceForType7.getDefaultInstanceForType());
    assertSame(tsKvListList, actualPostTelemetryMsgCreatedResult.getTsKvListOrBuilderList());
    assertSame(defaultInstanceForType6.getDefaultInstanceForType(),
        defaultInstanceForType6.getDefaultInstanceForType());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#checkDeviceName(String)}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>When {@code Device Name}.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#checkDeviceName(String)}
   */
  @Test
  @DisplayName("Test checkDeviceName(String); given Function apply(Object) return one; when 'Device Name'; then calls apply(Object)")
  void testCheckDeviceName_givenFunctionApplyReturnOne_whenDeviceName_thenCallsApply() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    String actualCheckDeviceNameResult = (new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true))
        .checkDeviceName("Device Name");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertEquals("Device Name", actualCheckDeviceNameResult);
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#checkDeviceName(String)}.
   * <ul>
   *   <li>When {@code Device Name}.</li>
   *   <li>Then return {@code Device Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#checkDeviceName(String)}
   */
  @Test
  @DisplayName("Test checkDeviceName(String); when 'Device Name'; then return 'Device Name'")
  void testCheckDeviceName_whenDeviceName_thenReturnDeviceName() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertEquals("Device Name",
        (new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true)).checkDeviceName("Device Name"));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#checkDeviceName(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#checkDeviceName(String)}
   */
  @Test
  @DisplayName("Test checkDeviceName(String); when empty string; then throw RuntimeException")
  void testCheckDeviceName_whenEmptyString_thenThrowRuntimeException() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true)).checkDeviceName(""));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#checkDeviceName(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#checkDeviceName(String)}
   */
  @Test
  @DisplayName("Test checkDeviceName(String); when 'null'; then throw RuntimeException")
  void testCheckDeviceName_whenNull_thenThrowRuntimeException() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true)).checkDeviceName(null));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getBytes(ByteBuf)}.
   * <p>
   * Method under test: {@link AbstractGatewaySessionHandler#getBytes(ByteBuf)}
   */
  @Test
  @DisplayName("Test getBytes(ByteBuf)")
  void testGetBytes() {
    // Arrange
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(null, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act and Assert
    assertEquals(0,
        gatewaySessionHandler.getBytes(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))).length);
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getBytes(ByteBuf)}.
   * <ul>
   *   <li>When {@link DuplicatedByteBuf#DuplicatedByteBuf(ByteBuf)} with buffer is
   * {@link ReadOnlyByteBuf#ReadOnlyByteBuf(ByteBuf)}.</li>
   *   <li>Then calls {@link ByteBuf#capacity()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractGatewaySessionHandler#getBytes(ByteBuf)}
   */
  @Test
  @DisplayName("Test getBytes(ByteBuf); when DuplicatedByteBuf(ByteBuf) with buffer is ReadOnlyByteBuf(ByteBuf); then calls capacity()")
  void testGetBytes_whenDuplicatedByteBufWithBufferIsReadOnlyByteBuf_thenCallsCapacity() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    when(buffer.getBytes(anyInt(), Mockito.<byte[]>any(), anyInt(), anyInt()))
        .thenReturn(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR)));

    // Act
    byte[] actualBytes = gatewaySessionHandler
        .getBytes(new DuplicatedByteBuf(new ReadOnlyByteBuf(new DuplicatedByteBuf(buffer))));

    // Assert
    verify(buffer, atLeast(1)).capacity();
    verify(buffer).getBytes(eq(1), isA(byte[].class), eq(0), eq(0));
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
    assertEquals(0, actualBytes.length);
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getBytes(ByteBuf)}.
   * <ul>
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is
   * {@link MqttTransportAdaptor#ALLOCATOR}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractGatewaySessionHandler#getBytes(ByteBuf)}
   */
  @Test
  @DisplayName("Test getBytes(ByteBuf); when EmptyByteBuf(ByteBufAllocator) with alloc is ALLOCATOR; then return array length is zero")
  void testGetBytes_whenEmptyByteBufWithAllocIsAllocator_thenReturnArrayLengthIsZero() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act and Assert
    assertEquals(0,
        gatewaySessionHandler.getBytes(new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))).length);
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#ack(int, PubAck)} with
   * {@code msgId}, {@code returnCode}.
   * <ul>
   *   <li>Then calls {@link ChannelOutboundInvoker#writeAndFlush(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#ack(int, MqttReasonCodes.PubAck)}
   */
  @Test
  @DisplayName("Test ack(int, PubAck) with 'msgId', 'returnCode'; then calls writeAndFlush(Object)")
  void testAckWithMsgIdReturnCode_thenCallsWriteAndFlush() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    ChannelHandlerContext channel = mock(ChannelHandlerContext.class);
    when(channel.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setChannel(channel);

    // Act
    (new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true)).ack(1, MqttReasonCodes.PubAck.SUCCESS);

    // Assert
    verify(channel).writeAndFlush(isA(Object.class));
    verify(function).apply(isA(MqttTopicMatcher.class));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#ack(int, PubAck)} with
   * {@code msgId}, {@code returnCode}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#ack(int, MqttReasonCodes.PubAck)}
   */
  @Test
  @DisplayName("Test ack(int, PubAck) with 'msgId', 'returnCode'; when zero; then calls apply(Object)")
  void testAckWithMsgIdReturnCode_whenZero_thenCallsApply() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setChannel(mock(ChannelHandlerContext.class));

    // Act
    (new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true)).ack(0, MqttReasonCodes.PubAck.SUCCESS);

    // Assert that nothing has changed
    verify(function).apply(isA(MqttTopicMatcher.class));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#ack(MqttPublishMessage, PubAck)}
   * with {@code msg}, {@code returnCode}.
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#ack(MqttPublishMessage, MqttReasonCodes.PubAck)}
   */
  @Test
  @DisplayName("Test ack(MqttPublishMessage, PubAck) with 'msg', 'returnCode'")
  void testAckWithMsgReturnCode() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setChannel(mock(ChannelHandlerContext.class));
    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(new ReadOnlyByteBuf(new DuplicatedByteBuf(buffer)));
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    // Act
    gatewaySessionHandler.ack(
        new MqttPublishMessage(mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 0), payload),
        MqttReasonCodes.PubAck.SUCCESS);

    // Assert that nothing has changed
    verify(buffer, atLeast(1)).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#ack(MqttPublishMessage, PubAck)}
   * with {@code msg}, {@code returnCode}.
   * <ul>
   *   <li>Then calls {@link ChannelOutboundInvoker#writeAndFlush(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#ack(MqttPublishMessage, MqttReasonCodes.PubAck)}
   */
  @Test
  @DisplayName("Test ack(MqttPublishMessage, PubAck) with 'msg', 'returnCode'; then calls writeAndFlush(Object)")
  void testAckWithMsgReturnCode_thenCallsWriteAndFlush() {
    // Arrange
    ChannelHandlerContext channel = mock(ChannelHandlerContext.class);
    when(channel.writeAndFlush(Mockito.<Object>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setChannel(channel);
    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    ByteBuf buffer = mock(ByteBuf.class);
    when(buffer.capacity()).thenReturn(3);
    when(buffer.maxCapacity()).thenReturn(3);
    when(buffer.readerIndex()).thenReturn(1);
    when(buffer.writerIndex()).thenReturn(1);
    DuplicatedByteBuf payload = new DuplicatedByteBuf(new ReadOnlyByteBuf(new DuplicatedByteBuf(buffer)));
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    // Act
    gatewaySessionHandler.ack(
        new MqttPublishMessage(mqttFixedHeader, new MqttPublishVariableHeader("Topic Name", 1), payload),
        MqttReasonCodes.PubAck.SUCCESS);

    // Assert
    verify(buffer, atLeast(1)).capacity();
    verify(buffer).maxCapacity();
    verify(buffer).readerIndex();
    verify(buffer).writerIndex();
    verify(channel).writeAndFlush(isA(Object.class));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#ackOrClose(int)}.
   * <ul>
   *   <li>Then calls {@link ChannelOutboundInvoker#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractGatewaySessionHandler#ackOrClose(int)}
   */
  @Test
  @DisplayName("Test ackOrClose(int); then calls close()")
  void testAckOrClose_thenCallsClose() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    ChannelHandlerContext channel = mock(ChannelHandlerContext.class);
    when(channel.close()).thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    UUID sessionId = UUID.randomUUID();

    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setChannel(channel);

    // Act
    (new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true)).ackOrClose(1);

    // Assert that nothing has changed
    verify(channel).close();
    verify(function).apply(isA(MqttTopicMatcher.class));
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#sendSparkplugStateOnTelemetry(SessionInfoProto, String, SparkplugConnectionState, long)}.
   * <ul>
   *   <li>Then calls {@link TransportContext#getTransportService()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#sendSparkplugStateOnTelemetry(TransportProtos.SessionInfoProto, String, SparkplugConnectionState, long)}
   */
  @Test
  @DisplayName("Test sendSparkplugStateOnTelemetry(SessionInfoProto, String, SparkplugConnectionState, long); then calls getTransportService()")
  void testSendSparkplugStateOnTelemetry_thenCallsGetTransportService() {
    // Arrange
    TransportService transportService = mock(TransportService.class);
    doNothing().when(transportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.PostTelemetryMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getTransportService()).thenReturn(transportService);
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    when(context.getGatewayMetricsService()).thenReturn(new GatewayMetricsService());
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, new ConcurrentHashMap<>(), context);

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act
    gatewaySessionHandler.sendSparkplugStateOnTelemetry(TransportProtos.SessionInfoProto.getDefaultInstance(),
        "Device Name", SparkplugConnectionState.OFFLINE, 1L);

    // Assert
    verify(context).getTransportService();
    verify(transportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.PostTelemetryMsg.class), isA(TransportServiceCallback.class));
    verify(context).getGatewayMetricsService();
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#process(ListenableFuture, Consumer, Consumer)}
   * with {@code deviceCtxFuture}, {@code onSuccess}, {@code onFailure}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#process(ListenableFuture, Consumer, Consumer)}
   */
  @Test
  @DisplayName("Test process(ListenableFuture, Consumer, Consumer) with 'deviceCtxFuture', 'onSuccess', 'onFailure'; given 'false'; then calls addListener(Runnable, Executor)")
  void testProcessWithDeviceCtxFutureOnSuccessOnFailure_givenFalse_thenCallsAddListener() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    ListenableFutureTask<Object> delegate = mock(ListenableFutureTask.class);
    when(delegate.isDone()).thenReturn(false);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());

    // Act
    gatewaySessionHandler.process(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))),
        mock(Consumer.class), mock(Consumer.class));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(delegate).isDone();
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#process(ListenableFuture, Consumer, Consumer)}
   * with {@code deviceCtxFuture}, {@code onSuccess}, {@code onFailure}.
   * <ul>
   *   <li>Given {@code Get}.</li>
   *   <li>Then calls {@link FutureTask#get()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#process(ListenableFuture, Consumer, Consumer)}
   */
  @Test
  @DisplayName("Test process(ListenableFuture, Consumer, Consumer) with 'deviceCtxFuture', 'onSuccess', 'onFailure'; given 'Get'; then calls get()")
  void testProcessWithDeviceCtxFutureOnSuccessOnFailure_givenGet_thenCallsGet()
      throws InterruptedException, ExecutionException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    ListenableFutureTask<Object> delegate = mock(ListenableFutureTask.class);
    when(delegate.get()).thenReturn("Get");
    when(delegate.isDone()).thenReturn(true);
    ApiFutureToListenableFuture<Object> deviceCtxFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    Consumer<Object> onSuccess = mock(Consumer.class);
    doNothing().when(onSuccess).accept(Mockito.<Object>any());

    // Act
    gatewaySessionHandler.process(deviceCtxFuture, onSuccess, mock(Consumer.class));

    // Assert that nothing has changed
    verify(delegate).get();
    verify(delegate).isDone();
    verify(onSuccess).accept(isA(Object.class));
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#process(ListenableFuture, Consumer, Consumer)}
   * with {@code deviceCtxFuture}, {@code onSuccess}, {@code onFailure}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#process(ListenableFuture, Consumer, Consumer)}
   */
  @Test
  @DisplayName("Test process(ListenableFuture, Consumer, Consumer) with 'deviceCtxFuture', 'onSuccess', 'onFailure'; then throw RuntimeException")
  void testProcessWithDeviceCtxFutureOnSuccessOnFailure_thenThrowRuntimeException()
      throws InterruptedException, ExecutionException {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);
    ListenableFutureTask<Object> delegate = mock(ListenableFutureTask.class);
    when(delegate.get()).thenReturn("Get");
    when(delegate.isDone()).thenReturn(true);
    ApiFutureToListenableFuture<Object> deviceCtxFuture = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    Consumer<Object> onSuccess = mock(Consumer.class);
    doThrow(new RuntimeException("foo")).when(onSuccess).accept(Mockito.<Object>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> gatewaySessionHandler.process(deviceCtxFuture, onSuccess, mock(Consumer.class)));
    verify(delegate).get();
    verify(delegate).isDone();
    verify(onSuccess).accept(isA(Object.class));
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getSessionId()}.
   * <p>
   * Method under test: {@link AbstractGatewaySessionHandler#getSessionId()}
   */
  @Test
  @DisplayName("Test getSessionId()")
  void testGetSessionId() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act and Assert
    assertSame(gatewaySessionHandler.sessionId, gatewaySessionHandler.getSessionId());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#getSessionId()}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractGatewaySessionHandler#getSessionId()}
   */
  @Test
  @DisplayName("Test getSessionId(); given Function apply(Object) return one; then calls apply(Object)")
  void testGetSessionId_givenFunctionApplyReturnOne_thenCallsApply() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    GatewaySessionHandler gatewaySessionHandler = new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true);

    // Act
    UUID actualSessionId = gatewaySessionHandler.getSessionId();

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertSame(gatewaySessionHandler.sessionId, actualSessionId);
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#isOverwriteDevicesActivity()}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#isOverwriteDevicesActivity()}
   */
  @Test
  @DisplayName("Test isOverwriteDevicesActivity(); given Function apply(Object) return one; then calls apply(Object)")
  void testIsOverwriteDevicesActivity_givenFunctionApplyReturnOne_thenCallsApply() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    boolean actualIsOverwriteDevicesActivityResult = (new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(),
        true)).isOverwriteDevicesActivity();

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertTrue(actualIsOverwriteDevicesActivityResult);
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#isOverwriteDevicesActivity()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#isOverwriteDevicesActivity()}
   */
  @Test
  @DisplayName("Test isOverwriteDevicesActivity(); then return 'false'")
  void testIsOverwriteDevicesActivity_thenReturnFalse() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertFalse((new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), false)).isOverwriteDevicesActivity());
  }

  /**
   * Test {@link AbstractGatewaySessionHandler#isOverwriteDevicesActivity()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#isOverwriteDevicesActivity()}
   */
  @Test
  @DisplayName("Test isOverwriteDevicesActivity(); then return 'true'")
  void testIsOverwriteDevicesActivity_thenReturnTrue() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertTrue((new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true)).isOverwriteDevicesActivity());
  }

  /**
   * Test
   * {@link AbstractGatewaySessionHandler#setOverwriteDevicesActivity(boolean)}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractGatewaySessionHandler#setOverwriteDevicesActivity(boolean)}
   */
  @Test
  @DisplayName("Test setOverwriteDevicesActivity(boolean); given Function apply(Object) return one; then calls apply(Object)")
  void testSetOverwriteDevicesActivity_givenFunctionApplyReturnOne_thenCallsApply() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    (new GatewaySessionHandler(deviceSessionCtx, UUID.randomUUID(), true)).setOverwriteDevicesActivity(true);

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
  }
}
