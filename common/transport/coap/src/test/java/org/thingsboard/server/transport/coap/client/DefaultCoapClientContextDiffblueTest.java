package org.thingsboard.server.transport.coap.client;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.DescriptorProtos.DescriptorProto;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.MessageOptions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAP.Code;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.Option;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.Exchange.Origin;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.elements.AddressEndpointContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.coapserver.CoapServerContext;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.device.profile.CoapDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportDeviceProfileCache;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.SessionEventMsg;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.gen.transport.TransportProtos.SubscribeToAttributeUpdatesMsg;
import org.thingsboard.server.gen.transport.TransportProtos.SubscribeToRPCMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcResponseMsg;
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
import org.thingsboard.server.transport.coap.CoapTransportContext;
import org.thingsboard.server.transport.coap.client.DefaultCoapClientContext.CoapSessionListener;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class DefaultCoapClientContextDiffblueTest {
  @Mock private CoapTransportContext coapTransportContext;

  @InjectMocks private DefaultCoapClientContext defaultCoapClientContext;

  @Mock private TransportDeviceProfileCache transportDeviceProfileCache;

  @Mock private TransportService transportService;

  /**
   * Test CoapSessionListener {@link CoapSessionListener#onToDeviceRpcRequest(UUID,
   * ToDeviceRpcRequestMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultTransportService#process(SessionInfoProto,
   *       ToDeviceRpcResponseMsg, TransportServiceCallback)}.
   * </ul>
   *
   * <p>Method under test: {@link CoapSessionListener#onToDeviceRpcRequest(UUID,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test CoapSessionListener onToDeviceRpcRequest(UUID, ToDeviceRpcRequestMsg); then calls process(SessionInfoProto, ToDeviceRpcResponseMsg, TransportServiceCallback)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CoapSessionListener.onToDeviceRpcRequest(UUID, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testCoapSessionListenerOnToDeviceRpcRequest_thenCallsProcess() {
    // Arrange
    DefaultTransportService transportService = mock(DefaultTransportService.class);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<ToDeviceRpcResponseMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    CoapServerContext config = new CoapServerContext();
    CoapTransportContext transportContext = new CoapTransportContext();
    DefaultTransportDeviceProfileCache profileCache = new DefaultTransportDeviceProfileCache();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());

    DefaultCoapClientContext defaultCoapClientContext =
        new DefaultCoapClientContext(
            config, transportContext, transportService, profileCache, partitionService);
    CoapSessionListener coapSessionListener =
        defaultCoapClientContext.new CoapSessionListener(new TbCoapClientState(null));

    // Act
    coapSessionListener.onToDeviceRpcRequest(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
        ToDeviceRpcRequestMsg.getDefaultInstance());

    // Assert
    verify(transportService)
        .process(
            (SessionInfoProto) isNull(),
            isA(ToDeviceRpcResponseMsg.class),
            isA(TransportServiceCallback.class));
  }

  /**
   * Test CoapSessionListener {@link CoapSessionListener#onToDeviceRpcRequest(UUID,
   * ToDeviceRpcRequestMsg)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link CoapSessionListener#onToDeviceRpcRequest(UUID,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test CoapSessionListener onToDeviceRpcRequest(UUID, ToDeviceRpcRequestMsg); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CoapSessionListener.onToDeviceRpcRequest(UUID, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testCoapSessionListenerOnToDeviceRpcRequest_thenThrowRuntimeException() {
    // Arrange
    DefaultCoapClientContext defaultCoapClientContext = mock(DefaultCoapClientContext.class);
    when(defaultCoapClientContext.getNextMsgId()).thenThrow(new RuntimeException());
    CoapSessionListener coapSessionListener =
        defaultCoapClientContext.new CoapSessionListener(new TbCoapClientState(null));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            coapSessionListener.onToDeviceRpcRequest(
                UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
                ToDeviceRpcRequestMsg.getDefaultInstance()));
    verify(defaultCoapClientContext).getNextMsgId();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation() throws UnsupportedEncodingException {
    // Arrange
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Exchange");
    exchange2.setLocationQuery("Exchange");
    exchange2.setMaxAge(60L);
    exchange2.setETag("AXAXAXAX".getBytes("UTF-8"));
    TbCoapObservationState attrs = new TbCoapObservationState(exchange2, "ABC123");
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange4 = new CoapExchange(exchange3);
    exchange4.setLocationPath("Exchange");
    exchange4.setLocationQuery("Exchange");
    exchange4.setMaxAge(60L);
    exchange4.setETag("AXAXAXAX".getBytes("UTF-8"));
    TbCoapObservationState rpc = new TbCoapObservationState(exchange4, "ABC123");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(rpc);
    clientState.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange5 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertFalse(
        defaultCoapClientContext.registerAttributeObservation(
            clientState, "ABC123", new CoapExchange(exchange5)));
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation2() throws UnsupportedEncodingException {
    // Arrange
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<GetAttributeRequestMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Exchange");
    exchange2.setLocationQuery("Exchange");
    exchange2.setMaxAge(60L);
    exchange2.setETag("AXAXAXAX".getBytes("UTF-8"));
    TbCoapObservationState rpc = new TbCoapObservationState(exchange2, "ABC123");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(null);
    clientState.setRpc(rpc);
    clientState.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange4 = new CoapExchange(exchange3);

    // Act
    boolean actualRegisterAttributeObservationResult =
        defaultCoapClientContext.registerAttributeObservation(clientState, "ABC123", exchange4);

    // Assert
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(GetAttributeRequestMsg.class),
            isA(TransportServiceCallback.class));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToAttributeUpdatesMsg.class),
            isA(TransportServiceCallback.class));
    TbCoapObservationState attrs = clientState.getAttrs();
    assertEquals("ABC123", attrs.getToken());
    assertNull(attrs.getObserveRelation());
    AtomicInteger observeCounter = attrs.getObserveCounter();
    assertEquals(0, observeCounter.get());
    assertEquals(0, observeCounter.getAcquire());
    assertEquals(0, observeCounter.getOpaque());
    assertEquals(0, observeCounter.getPlain());
    assertTrue(actualRegisterAttributeObservationResult);
    assertSame(exchange4, attrs.getExchange());
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation3() throws UnsupportedEncodingException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Exchange");
    exchange2.setLocationQuery("Exchange");
    exchange2.setMaxAge(60L);
    exchange2.setETag("AXAXAXAX".getBytes("UTF-8"));
    TbCoapObservationState rpc = new TbCoapObservationState(exchange2, "ABC123");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(null);
    clientState.setRpc(rpc);
    clientState.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState, "ABC123", new CoapExchange(exchange3)));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToAttributeUpdatesMsg.class),
            isA(TransportServiceCallback.class));
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation4() throws UnsupportedEncodingException {
    // Arrange
    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getToken()).thenReturn("ABC123");
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Exchange");
    exchange2.setLocationQuery("Exchange");
    exchange2.setMaxAge(60L);
    exchange2.setETag("AXAXAXAX".getBytes("UTF-8"));
    TbCoapObservationState rpc = new TbCoapObservationState(exchange2, "ABC123");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(rpc);
    clientState.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    boolean actualRegisterAttributeObservationResult =
        defaultCoapClientContext.registerAttributeObservation(
            clientState, "ABC123", new CoapExchange(exchange3));

    // Assert
    verify(attrs).getToken();
    assertFalse(actualRegisterAttributeObservationResult);
    assertArrayEquals(new byte[] {}, clientState.getRpc().getExchange().getRequestPayload());
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation5() throws UnsupportedEncodingException {
    // Arrange
    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getToken()).thenThrow(new IllegalArgumentException());
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Exchange");
    exchange2.setLocationQuery("Exchange");
    exchange2.setMaxAge(60L);
    exchange2.setETag("AXAXAXAX".getBytes("UTF-8"));
    TbCoapObservationState rpc = new TbCoapObservationState(exchange2, "ABC123");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(rpc);
    clientState.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState, "ABC123", new CoapExchange(exchange3)));
    verify(attrs).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation6() throws UnsupportedEncodingException {
    // Arrange
    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getExchange()).thenThrow(new IllegalArgumentException());
    when(attrs.getToken()).thenReturn("foo");
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Exchange");
    exchange2.setLocationQuery("Exchange");
    exchange2.setMaxAge(60L);
    exchange2.setETag("AXAXAXAX".getBytes("UTF-8"));
    TbCoapObservationState rpc = new TbCoapObservationState(exchange2, "ABC123");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(rpc);
    clientState.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState, "ABC123", new CoapExchange(exchange3)));
    verify(attrs).getExchange();
    verify(attrs).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test registerAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation7() throws UnsupportedEncodingException {
    // Arrange
    Exchange exchange = mock(Exchange.class);
    when(exchange.getCurrentRequest()).thenThrow(new IllegalArgumentException());

    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getExchange()).thenReturn(new CoapExchange(exchange));
    when(attrs.getToken()).thenReturn("foo");
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange3 = new CoapExchange(exchange2);
    exchange3.setLocationPath("Exchange");
    exchange3.setLocationQuery("Exchange");
    exchange3.setMaxAge(60L);
    exchange3.setETag("AXAXAXAX".getBytes("UTF-8"));
    TbCoapObservationState rpc = new TbCoapObservationState(exchange3, "ABC123");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(rpc);
    clientState.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange4 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState, "ABC123", new CoapExchange(exchange4)));
    verify(exchange).getCurrentRequest();
    verify(attrs).getExchange();
    verify(attrs).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link CoapTransportContext#getNodeId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerAttributeObservation(TbCoapClientState, String, CoapExchange); then calls getNodeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation_thenCallsGetNodeId() {
    // Arrange
    when(coapTransportContext.getNodeId()).thenThrow(new IllegalArgumentException());
    TbCoapClientState clientState = new TbCoapClientState(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState, "ABC123", new CoapExchange(exchange)));
    verify(coapTransportContext).getNodeId();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link Request#getOptions()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerAttributeObservation(TbCoapClientState, String, CoapExchange); then calls getOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation_thenCallsGetOptions() throws UnsupportedEncodingException {
    // Arrange
    Request request = mock(Request.class);
    when(request.isMulticast()).thenThrow(new IllegalArgumentException());
    when(request.isObserve()).thenReturn(true);
    when(request.getOptions()).thenReturn(new OptionSet());
    when(request.getSourceContext()).thenReturn(new AddressEndpointContext("42", 8080));
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getExchange()).thenReturn(new CoapExchange(exchange));
    when(attrs.getToken()).thenReturn("foo");
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange3 = new CoapExchange(exchange2);
    exchange3.setLocationPath("Exchange");
    exchange3.setLocationQuery("Exchange");
    exchange3.setMaxAge(60L);
    exchange3.setETag("AXAXAXAX".getBytes("UTF-8"));
    TbCoapObservationState rpc = new TbCoapObservationState(exchange3, "ABC123");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(rpc);
    clientState.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange4 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState, "ABC123", new CoapExchange(exchange4)));
    verify(request).getOptions();
    verify(request).getSourceContext();
    verify(request).isMulticast();
    verify(request).isObserve();
    verify(attrs).getExchange();
    verify(attrs).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link AddressEndpointContext#getPeerAddress()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerAttributeObservation(TbCoapClientState, String, CoapExchange); then calls getPeerAddress()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation_thenCallsGetPeerAddress()
      throws UnsupportedEncodingException {
    // Arrange
    AddressEndpointContext addressEndpointContext = mock(AddressEndpointContext.class);
    when(addressEndpointContext.getPeerAddress()).thenThrow(new IllegalArgumentException());

    Request request = mock(Request.class);
    when(request.isObserve()).thenReturn(true);
    when(request.getSourceContext()).thenReturn(addressEndpointContext);
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getExchange()).thenReturn(new CoapExchange(exchange));
    when(attrs.getToken()).thenReturn("foo");
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange3 = new CoapExchange(exchange2);
    exchange3.setLocationPath("Exchange");
    exchange3.setLocationQuery("Exchange");
    exchange3.setMaxAge(60L);
    exchange3.setETag("AXAXAXAX".getBytes("UTF-8"));
    TbCoapObservationState rpc = new TbCoapObservationState(exchange3, "ABC123");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(rpc);
    clientState.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange4 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.registerAttributeObservation(
                clientState, "ABC123", new CoapExchange(exchange4)));
    verify(request).getSourceContext();
    verify(request).isObserve();
    verify(addressEndpointContext).getPeerAddress();
    verify(attrs).getExchange();
    verify(attrs).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link CoapExchange#respond(ResponseCode)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerAttributeObservation(TbCoapClientState, String, CoapExchange); then calls respond(ResponseCode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation_thenCallsRespond() throws UnsupportedEncodingException {
    // Arrange
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<GetAttributeRequestMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    CoapExchange coapExchange = mock(CoapExchange.class);
    doNothing().when(coapExchange).respond(Mockito.<ResponseCode>any());

    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getExchange()).thenReturn(coapExchange);
    when(attrs.getToken()).thenReturn("foo");
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Exchange");
    exchange2.setLocationQuery("Exchange");
    exchange2.setMaxAge(60L);
    exchange2.setETag("AXAXAXAX".getBytes("UTF-8"));
    TbCoapObservationState rpc = new TbCoapObservationState(exchange2, "ABC123");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(rpc);
    clientState.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange4 = new CoapExchange(exchange3);

    // Act
    boolean actualRegisterAttributeObservationResult =
        defaultCoapClientContext.registerAttributeObservation(clientState, "ABC123", exchange4);

    // Assert
    verify(coapExchange).respond(ResponseCode.DELETED);
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(GetAttributeRequestMsg.class),
            isA(TransportServiceCallback.class));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToAttributeUpdatesMsg.class),
            isA(TransportServiceCallback.class));
    verify(attrs).getExchange();
    verify(attrs).getToken();
    TbCoapObservationState attrs2 = clientState.getAttrs();
    assertEquals("ABC123", attrs2.getToken());
    assertNull(attrs2.getObserveRelation());
    AtomicInteger observeCounter = attrs2.getObserveCounter();
    assertEquals(0, observeCounter.get());
    assertEquals(0, observeCounter.getAcquire());
    assertEquals(0, observeCounter.getOpaque());
    assertEquals(0, observeCounter.getPlain());
    assertTrue(actualRegisterAttributeObservationResult);
    assertSame(exchange4, attrs2.getExchange());
  }

  /**
   * Test {@link DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then calls {@link Exchange#sendResponse(Response)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#registerAttributeObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test registerAttributeObservation(TbCoapClientState, String, CoapExchange); then calls sendResponse(Response)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultCoapClientContext.registerAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testRegisterAttributeObservation_thenCallsSendResponse()
      throws UnsupportedEncodingException {
    // Arrange
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<GetAttributeRequestMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());

    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getExchange()).thenReturn(new CoapExchange(exchange));
    when(attrs.getToken()).thenReturn("foo");
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    CoapExchange exchange3 = new CoapExchange(exchange2);
    exchange3.setLocationPath("Exchange");
    exchange3.setLocationQuery("Exchange");
    exchange3.setMaxAge(60L);
    exchange3.setETag("AXAXAXAX".getBytes("UTF-8"));
    TbCoapObservationState rpc = new TbCoapObservationState(exchange3, "ABC123");

    TbCoapClientState clientState = new TbCoapClientState(null);
    clientState.setAttrs(attrs);
    clientState.setRpc(rpc);
    clientState.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange4 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange5 = new CoapExchange(exchange4);

    // Act
    boolean actualRegisterAttributeObservationResult =
        defaultCoapClientContext.registerAttributeObservation(clientState, "ABC123", exchange5);

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(GetAttributeRequestMsg.class),
            isA(TransportServiceCallback.class));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToAttributeUpdatesMsg.class),
            isA(TransportServiceCallback.class));
    verify(attrs).getExchange();
    verify(attrs).getToken();
    TbCoapObservationState attrs2 = clientState.getAttrs();
    assertEquals("ABC123", attrs2.getToken());
    assertNull(attrs2.getObserveRelation());
    AtomicInteger observeCounter = attrs2.getObserveCounter();
    assertEquals(0, observeCounter.get());
    assertEquals(0, observeCounter.getAcquire());
    assertEquals(0, observeCounter.getOpaque());
    assertEquals(0, observeCounter.getPlain());
    assertTrue(actualRegisterAttributeObservationResult);
    assertSame(exchange5, attrs2.getExchange());
  }

  /**
   * Test {@link DefaultCoapClientContext#getNotificationCounterByToken(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#getNotificationCounterByToken(String)}
   */
  @Test
  @DisplayName("Test getNotificationCounterByToken(String); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AtomicInteger DefaultCoapClientContext.getNotificationCounterByToken(String)"
  })
  void testGetNotificationCounterByToken_thenReturnNull() {
    // Arrange
    CoapServerContext config = new CoapServerContext();
    CoapTransportContext transportContext = new CoapTransportContext();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider2,
            coreSettings,
            storage,
            new TopicService());
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings2,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider3,
            transportApiSettings2,
            transportNotificationSettings2,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TbRuleEngineProducerService ruleEngineProducerService =
        new TbRuleEngineProducerService(partitionService2);
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService transportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService2,
            serviceInfoProvider5,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    DefaultTransportDeviceProfileCache profileCache = new DefaultTransportDeviceProfileCache();
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService3 =
        new HashPartitionService(
            serviceInfoProvider6,
            tenantRoutingInfoService3,
            applicationEventPublisher3,
            queueRoutingInfoService3,
            new TopicService());

    DefaultCoapClientContext defaultCoapClientContext =
        new DefaultCoapClientContext(
            config, transportContext, transportService, profileCache, partitionService3);

    // Act and Assert
    assertNull(defaultCoapClientContext.getNotificationCounterByToken("ABC123"));
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation() {
    // Arrange
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setAttrs(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setRpc(new TbCoapObservationState(new CoapExchange(exchange2), "ABC123"));
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    defaultCoapClientContext.deregisterAttributeObservation(
        state, "ABC123", new CoapExchange(exchange3));

    // Assert
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToAttributeUpdatesMsg.class),
            isA(TransportServiceCallback.class));
    CoapExchange exchange4 = state.getRpc().getExchange();
    List<Option> others = exchange4.getRequestOptions().getOthers();
    assertTrue(others.isEmpty());
    Descriptor descriptorForType = state.getSession().getDescriptorForType();
    DescriptorProto toProtoResult = descriptorForType.toProto();
    assertSame(others, toProtoResult.getEnumTypeList());
    assertSame(others, toProtoResult.getEnumTypeOrBuilderList());
    assertSame(others, toProtoResult.getExtensionList());
    assertSame(others, toProtoResult.getExtensionOrBuilderList());
    assertSame(others, toProtoResult.getExtensionRangeList());
    assertSame(others, toProtoResult.getExtensionRangeOrBuilderList());
    assertSame(others, toProtoResult.getNestedTypeList());
    assertSame(others, toProtoResult.getNestedTypeOrBuilderList());
    assertSame(others, toProtoResult.getReservedRangeList());
    assertSame(others, toProtoResult.getReservedRangeOrBuilderList());
    MessageOptions options = descriptorForType.getOptions();
    assertSame(others, options.getUninterpretedOptionList());
    assertSame(others, options.getUninterpretedOptionOrBuilderList());
    assertArrayEquals(new byte[] {}, exchange4.getRequestPayload());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation2() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setAttrs(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setRpc(new TbCoapObservationState(new CoapExchange(exchange2), "ABC123"));
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.deregisterAttributeObservation(
                state, "ABC123", new CoapExchange(exchange3)));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToAttributeUpdatesMsg.class),
            isA(TransportServiceCallback.class));
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation3() {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setAttrs(new TbCoapObservationState(new CoapExchange(exchange), "Token"));
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setRpc(new TbCoapObservationState(new CoapExchange(exchange2), "ABC123"));
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert that nothing has changed
    assertDoesNotThrow(
        () ->
            defaultCoapClientContext.deregisterAttributeObservation(
                state, "ABC123", new CoapExchange(exchange3)));
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation4() {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    state.setAttrs(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setRpc(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert that nothing has changed
    assertDoesNotThrow(
        () ->
            defaultCoapClientContext.deregisterAttributeObservation(
                state, "ABC123", new CoapExchange(exchange2)));
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation5() {
    // Arrange
    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getToken()).thenThrow(new IllegalArgumentException());

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    state.setAttrs(attrs);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setRpc(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.deregisterAttributeObservation(
                state, "ABC123", new CoapExchange(exchange2)));
    verify(attrs).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation6() {
    // Arrange
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    when(attrs.getExchange()).thenReturn(new CoapExchange(exchange));
    when(attrs.getToken()).thenReturn("ABC123");

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    state.setAttrs(attrs);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setRpc(new TbCoapObservationState(new CoapExchange(exchange2), "ABC123"));
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    defaultCoapClientContext.deregisterAttributeObservation(
        state, "ABC123", new CoapExchange(exchange3));

    // Assert
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToAttributeUpdatesMsg.class),
            isA(TransportServiceCallback.class));
    verify(attrs).getExchange();
    verify(attrs, atLeast(1)).getToken();
    assertNull(state.getAttrs());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation7() {
    // Arrange
    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    when(attrs.getExchange()).thenThrow(new IllegalArgumentException());
    when(attrs.getToken()).thenReturn("ABC123");

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    state.setAttrs(attrs);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setRpc(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.deregisterAttributeObservation(
                state, "ABC123", new CoapExchange(exchange2)));
    verify(attrs).getExchange();
    verify(attrs, atLeast(1)).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation8() {
    // Arrange
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SessionEventMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    when(attrs.getExchange()).thenReturn(new CoapExchange(exchange));
    when(attrs.getToken()).thenReturn("ABC123");

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    state.setAttrs(attrs);
    state.setRpc(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange3 = new CoapExchange(exchange2);

    // Act
    defaultCoapClientContext.deregisterAttributeObservation(state, "ABC123", exchange3);

    // Assert
    verify(transportService).deregisterSession(isA(SessionInfoProto.class));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SessionEventMsg.class),
            (TransportServiceCallback<Void>) isNull());
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToAttributeUpdatesMsg.class),
            isA(TransportServiceCallback.class));
    verify(attrs).getExchange();
    verify(attrs, atLeast(1)).getToken();
    assertEquals("", exchange3.getRequestText());
    assertNull(state.getSession());
    assertEquals(0, exchange3.getRequestPayloadSize());
    assertEquals(Code.DELETE, exchange3.getRequestCode());
    assertFalse(exchange3.isMulticastRequest());
    assertArrayEquals(new byte[] {}, exchange3.getRequestPayload());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation9() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SessionEventMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToAttributeUpdatesMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    TbCoapObservationState attrs = mock(TbCoapObservationState.class);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    when(attrs.getExchange()).thenReturn(new CoapExchange(exchange));
    when(attrs.getToken()).thenReturn("ABC123");

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    state.setAttrs(attrs);
    state.setRpc(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.deregisterAttributeObservation(
                state, "ABC123", new CoapExchange(exchange2)));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SessionEventMsg.class),
            (TransportServiceCallback<Void>) isNull());
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToAttributeUpdatesMsg.class),
            isA(TransportServiceCallback.class));
    verify(attrs).getExchange();
    verify(attrs, atLeast(1)).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>When {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterAttributeObservation(TbCoapClientState, String,
   * CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test deregisterAttributeObservation(TbCoapClientState, String, CoapExchange); when TbCoapClientState(DeviceId) with deviceId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterAttributeObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterAttributeObservation_whenTbCoapClientStateWithDeviceIdIsNull() {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange2 = new CoapExchange(exchange);

    // Act
    defaultCoapClientContext.deregisterAttributeObservation(state, "ABC123", exchange2);

    // Assert that nothing has changed
    assertEquals("", exchange2.getRequestText());
    assertEquals(0, exchange2.getRequestPayloadSize());
    assertEquals(Code.DELETE, exchange2.getRequestCode());
    assertFalse(exchange2.isMulticastRequest());
    assertArrayEquals(new byte[] {}, exchange2.getRequestPayload());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation() {
    // Arrange
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToRPCMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setRpc(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setAttrs(new TbCoapObservationState(new CoapExchange(exchange2), "ABC123"));
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    defaultCoapClientContext.deregisterRpcObservation(state, "ABC123", new CoapExchange(exchange3));

    // Assert
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToRPCMsg.class),
            isA(TransportServiceCallback.class));
    FileDescriptorProto toProtoResult =
        state.getSession().getDescriptorForType().getFile().toProto();
    assertEquals(6, toProtoResult.getAllFields().size());
    assertTrue(toProtoResult.findInitializationErrors().isEmpty());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation2() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToRPCMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setRpc(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setAttrs(new TbCoapObservationState(new CoapExchange(exchange2), "ABC123"));
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.deregisterRpcObservation(
                state, "ABC123", new CoapExchange(exchange3)));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToRPCMsg.class),
            isA(TransportServiceCallback.class));
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation3() {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    SessionInfoProto session = SessionInfoProto.getDefaultInstance();
    state.setSession(session);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    TbCoapObservationState rpc = new TbCoapObservationState(new CoapExchange(exchange), "Token");
    state.setRpc(rpc);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setAttrs(new TbCoapObservationState(new CoapExchange(exchange2), "ABC123"));
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    defaultCoapClientContext.deregisterRpcObservation(state, "ABC123", new CoapExchange(exchange3));

    // Assert that nothing has changed
    assertSame(rpc, state.getRpc());
    assertSame(session, state.getSession());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation4() {
    // Arrange
    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    when(rpc.getToken()).thenThrow(new IllegalArgumentException());

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    state.setRpc(rpc);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setAttrs(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.deregisterRpcObservation(
                state, "ABC123", new CoapExchange(exchange2)));
    verify(rpc).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation5() {
    // Arrange
    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    when(rpc.getExchange()).thenThrow(new IllegalArgumentException());
    when(rpc.getToken()).thenReturn("ABC123");

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    state.setRpc(rpc);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setAttrs(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.deregisterRpcObservation(
                state, "ABC123", new CoapExchange(exchange2)));
    verify(rpc).getExchange();
    verify(rpc, atLeast(1)).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation6() {
    // Arrange
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SessionEventMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToRPCMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    when(rpc.getExchange()).thenReturn(new CoapExchange(exchange));
    when(rpc.getToken()).thenReturn("ABC123");

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    state.setRpc(rpc);
    state.setAttrs(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange3 = new CoapExchange(exchange2);

    // Act
    defaultCoapClientContext.deregisterRpcObservation(state, "ABC123", exchange3);

    // Assert
    verify(transportService).deregisterSession(isA(SessionInfoProto.class));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SessionEventMsg.class),
            (TransportServiceCallback<Void>) isNull());
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToRPCMsg.class),
            isA(TransportServiceCallback.class));
    verify(rpc).getExchange();
    verify(rpc, atLeast(1)).getToken();
    assertEquals("", exchange3.getRequestText());
    assertNull(state.getSession());
    assertEquals(0, exchange3.getRequestPayloadSize());
    assertEquals(Code.DELETE, exchange3.getRequestCode());
    assertFalse(exchange3.isMulticastRequest());
    assertArrayEquals(new byte[] {}, exchange3.getRequestPayload());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName("Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation7() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SessionEventMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToRPCMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    when(rpc.getExchange()).thenReturn(new CoapExchange(exchange));
    when(rpc.getToken()).thenReturn("ABC123");

    TbCoapClientState state = new TbCoapClientState(null);
    state.setSession(SessionInfoProto.getDefaultInstance());
    state.setRpc(rpc);
    state.setAttrs(null);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCoapClientContext.deregisterRpcObservation(
                state, "ABC123", new CoapExchange(exchange2)));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SessionEventMsg.class),
            (TransportServiceCallback<Void>) isNull());
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToRPCMsg.class),
            isA(TransportServiceCallback.class));
    verify(rpc).getExchange();
    verify(rpc, atLeast(1)).getToken();
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>Then {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId is {@code null}
   *       Rpc is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange); then TbCoapClientState(DeviceId) with deviceId is 'null' Rpc is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation_thenTbCoapClientStateWithDeviceIdIsNullRpcIsNull() {
    // Arrange
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscribeToRPCMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    TbCoapObservationState rpc = mock(TbCoapObservationState.class);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    when(rpc.getExchange()).thenReturn(new CoapExchange(exchange));
    when(rpc.getToken()).thenReturn("ABC123");

    TbCoapClientState state = new TbCoapClientState(null);
    SessionInfoProto session = SessionInfoProto.getDefaultInstance();
    state.setSession(session);
    state.setRpc(rpc);
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setAttrs(new TbCoapObservationState(new CoapExchange(exchange2), "ABC123"));
    Exchange exchange3 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    defaultCoapClientContext.deregisterRpcObservation(state, "ABC123", new CoapExchange(exchange3));

    // Assert
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscribeToRPCMsg.class),
            isA(TransportServiceCallback.class));
    verify(rpc).getExchange();
    verify(rpc, atLeast(1)).getToken();
    assertNull(state.getRpc());
    assertSame(session, state.getSession());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>When {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange); when TbCoapClientState(DeviceId) with deviceId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation_whenTbCoapClientStateWithDeviceIdIsNull() {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange2 = new CoapExchange(exchange);

    // Act
    defaultCoapClientContext.deregisterRpcObservation(state, "ABC123", exchange2);

    // Assert that nothing has changed
    assertEquals("", exchange2.getRequestText());
    assertEquals(0, exchange2.getRequestPayloadSize());
    assertEquals(Code.DELETE, exchange2.getRequestCode());
    assertFalse(exchange2.isMulticastRequest());
    assertArrayEquals(new byte[] {}, exchange2.getRequestPayload());
  }

  /**
   * Test {@link DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String,
   * CoapExchange)}.
   *
   * <ul>
   *   <li>When {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId is {@code null}
   *       Rpc is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCoapClientContext#deregisterRpcObservation(TbCoapClientState, String, CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test deregisterRpcObservation(TbCoapClientState, String, CoapExchange); when TbCoapClientState(DeviceId) with deviceId is 'null' Rpc is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCoapClientContext.deregisterRpcObservation(TbCoapClientState, String, CoapExchange)"
  })
  void testDeregisterRpcObservation_whenTbCoapClientStateWithDeviceIdIsNullRpcIsNull() {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    SessionInfoProto session = SessionInfoProto.getDefaultInstance();
    state.setSession(session);
    state.setRpc(null);
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    state.setAttrs(new TbCoapObservationState(new CoapExchange(exchange), "ABC123"));
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    defaultCoapClientContext.deregisterRpcObservation(state, "ABC123", new CoapExchange(exchange2));

    // Assert that nothing has changed
    assertSame(session, state.getSession());
  }

  /**
   * Test {@link DefaultCoapClientContext#getNewSyncSession(TbCoapClientState)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#getNewSyncSession(TbCoapClientState)}
   */
  @Test
  @DisplayName("Test getNewSyncSession(TbCoapClientState); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TransportProtos.SessionInfoProto DefaultCoapClientContext.getNewSyncSession(TbCoapClientState)"
  })
  void testGetNewSyncSession_thenThrowIllegalArgumentException() {
    // Arrange
    when(coapTransportContext.getNodeId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultCoapClientContext.getNewSyncSession(new TbCoapClientState(null)));
    verify(coapTransportContext).getNodeId();
  }

  /**
   * Test {@link DefaultCoapClientContext#awake(TbCoapClientState)} with {@code client}.
   *
   * <ul>
   *   <li>When {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#awake(TbCoapClientState)}
   */
  @Test
  @DisplayName(
      "Test awake(TbCoapClientState) with 'client'; when TbCoapClientState(DeviceId) with deviceId is 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultCoapClientContext.awake(TbCoapClientState)"})
  void testAwakeWithClient_whenTbCoapClientStateWithDeviceIdIsNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(defaultCoapClientContext.awake(new TbCoapClientState(null)));
  }

  /**
   * Test {@link DefaultCoapClientContext#getProfile(DeviceProfileId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfile} {@link DeviceProfile#getTransportType()} return {@code MQTT}.
   *   <li>Then calls {@link DefaultTransportDeviceProfileCache#get(DeviceProfileId)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#getProfile(DeviceProfileId)}
   */
  @Test
  @DisplayName(
      "Test getProfile(DeviceProfileId); given DeviceProfile getTransportType() return 'MQTT'; then calls get(DeviceProfileId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DefaultCoapClientContext.getProfile(DeviceProfileId)"})
  void testGetProfile_givenDeviceProfileGetTransportTypeReturnMqtt_thenCallsGet() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.MQTT);

    DefaultTransportDeviceProfileCache profileCache =
        mock(DefaultTransportDeviceProfileCache.class);
    when(profileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);
    CoapServerContext config = new CoapServerContext();
    CoapTransportContext transportContext = new CoapTransportContext();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider2,
            coreSettings,
            storage,
            new TopicService());
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings2,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider3,
            transportApiSettings2,
            transportNotificationSettings2,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TbRuleEngineProducerService ruleEngineProducerService =
        new TbRuleEngineProducerService(partitionService2);
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService transportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService2,
            serviceInfoProvider5,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService3 =
        new HashPartitionService(
            serviceInfoProvider6,
            tenantRoutingInfoService3,
            applicationEventPublisher3,
            queueRoutingInfoService3,
            new TopicService());

    DefaultCoapClientContext defaultCoapClientContext =
        new DefaultCoapClientContext(
            config, transportContext, transportService, profileCache, partitionService3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCoapClientContext.getProfile(null));
    verify(deviceProfile, atLeast(1)).getTransportType();
    verify(profileCache).get(isNull());
  }

  /**
   * Test {@link DefaultCoapClientContext#getProfile(DeviceProfileId)}.
   *
   * <ul>
   *   <li>Given {@link TransportDeviceProfileCache} {@link
   *       TransportDeviceProfileCache#get(DeviceProfileId)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#getProfile(DeviceProfileId)}
   */
  @Test
  @DisplayName(
      "Test getProfile(DeviceProfileId); given TransportDeviceProfileCache get(DeviceProfileId) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DefaultCoapClientContext.getProfile(DeviceProfileId)"})
  void testGetProfile_givenTransportDeviceProfileCacheGetThrowIllegalArgumentException() {
    // Arrange
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCoapClientContext.getProfile(null));
    verify(transportDeviceProfileCache).get(isNull());
  }

  /**
   * Test {@link DefaultCoapClientContext#getProfile(DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getProfileData()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#getProfile(DeviceProfileId)}
   */
  @Test
  @DisplayName("Test getProfile(DeviceProfileId); then calls getProfileData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DefaultCoapClientContext.getProfile(DeviceProfileId)"})
  void testGetProfile_thenCallsGetProfileData() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenThrow(new IllegalArgumentException());
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.COAP);
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCoapClientContext.getProfile(null));
    verify(deviceProfile).getProfileData();
    verify(deviceProfile).getTransportType();
    verify(transportDeviceProfileCache).get(isNull());
  }

  /**
   * Test {@link DefaultCoapClientContext#getProfile(DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCoapClientContext#getProfile(DeviceProfileId)}
   */
  @Test
  @DisplayName("Test getProfile(DeviceProfileId); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DefaultCoapClientContext.getProfile(DeviceProfileId)"})
  void testGetProfile_thenReturnNotPresent() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTransportType()).thenReturn(DeviceTransportType.DEFAULT);

    DefaultTransportDeviceProfileCache profileCache =
        mock(DefaultTransportDeviceProfileCache.class);
    when(profileCache.get(Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);
    CoapServerContext config = new CoapServerContext();
    CoapTransportContext transportContext = new CoapTransportContext();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider2,
            coreSettings,
            storage,
            new TopicService());
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings2,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider3,
            transportApiSettings2,
            transportNotificationSettings2,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TbRuleEngineProducerService ruleEngineProducerService =
        new TbRuleEngineProducerService(partitionService2);
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService transportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService2,
            serviceInfoProvider5,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService3 =
        new HashPartitionService(
            serviceInfoProvider6,
            tenantRoutingInfoService3,
            applicationEventPublisher3,
            queueRoutingInfoService3,
            new TopicService());

    DefaultCoapClientContext defaultCoapClientContext =
        new DefaultCoapClientContext(
            config, transportContext, transportService, profileCache, partitionService3);

    // Act
    Optional<CoapDeviceProfileTransportConfiguration> actualProfile =
        defaultCoapClientContext.getProfile(null);

    // Assert
    verify(deviceProfile, atLeast(1)).getTransportType();
    verify(profileCache).get(isNull());
    assertFalse(actualProfile.isPresent());
  }
}
