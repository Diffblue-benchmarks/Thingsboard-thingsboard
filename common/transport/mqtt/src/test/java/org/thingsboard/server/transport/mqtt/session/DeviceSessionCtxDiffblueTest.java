package org.thingsboard.server.transport.mqtt.session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.handler.codec.mqtt.MqttVersion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.TransportPayloadType;
import org.thingsboard.server.common.data.device.profile.DeviceProfileAlarm;
import org.thingsboard.server.common.data.device.profile.DeviceProfileConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileData;
import org.thingsboard.server.common.data.device.profile.DeviceProfileProvisionConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.X509CertificateChainProvisionConfiguration;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;
import org.thingsboard.server.transport.mqtt.TopicType;
import org.thingsboard.server.transport.mqtt.adaptors.JsonMqttAdaptor;
import org.thingsboard.server.transport.mqtt.adaptors.MqttTransportAdaptor;

class DeviceSessionCtxDiffblueTest {
  /**
   * Test
   * {@link DeviceSessionCtx#DeviceSessionCtx(UUID, ConcurrentMap, MqttTransportContext)}.
   * <ul>
   *   <li>Then PayloadAdaptor return {@link JsonMqttAdaptor}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceSessionCtx#DeviceSessionCtx(UUID, ConcurrentMap, MqttTransportContext)}
   */
  @Test
  @DisplayName("Test new DeviceSessionCtx(UUID, ConcurrentMap, MqttTransportContext); then PayloadAdaptor return JsonMqttAdaptor")
  void testNewDeviceSessionCtx_thenPayloadAdaptorReturnJsonMqttAdaptor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    MqttTransportContext context = mock(MqttTransportContext.class);
    JsonMqttAdaptor jsonMqttAdaptor = new JsonMqttAdaptor();
    when(context.getJsonMqttAdaptor()).thenReturn(jsonMqttAdaptor);

    // Act
    DeviceSessionCtx actualDeviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, context);

    // Assert
    verify(context).getJsonMqttAdaptor();
    MqttTransportAdaptor payloadAdaptor = actualDeviceSessionCtx.getPayloadAdaptor();
    assertTrue(payloadAdaptor instanceof JsonMqttAdaptor);
    assertSame(jsonMqttAdaptor, payloadAdaptor);
    assertSame(context, actualDeviceSessionCtx.getContext());
  }

  /**
   * Test
   * {@link DeviceSessionCtx#DeviceSessionCtx(UUID, ConcurrentMap, MqttTransportContext)}.
   * <ul>
   *   <li>When {@link MqttTransportContext} (default constructor).</li>
   *   <li>Then return PayloadAdaptor is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceSessionCtx#DeviceSessionCtx(UUID, ConcurrentMap, MqttTransportContext)}
   */
  @Test
  @DisplayName("Test new DeviceSessionCtx(UUID, ConcurrentMap, MqttTransportContext); when MqttTransportContext (default constructor); then return PayloadAdaptor is 'null'")
  void testNewDeviceSessionCtx_whenMqttTransportContext_thenReturnPayloadAdaptorIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    MqttTransportContext context = new MqttTransportContext();

    // Act
    DeviceSessionCtx actualDeviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, context);

    // Assert
    assertNull(actualDeviceSessionCtx.getPayloadAdaptor());
    assertSame(context, actualDeviceSessionCtx.getContext());
  }

  /**
   * Test {@link DeviceSessionCtx#nextMsgId()}.
   * <p>
   * Method under test: {@link DeviceSessionCtx#nextMsgId()}
   */
  @Test
  @DisplayName("Test nextMsgId()")
  void testNextMsgId() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertEquals(1, (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).nextMsgId());
  }

  /**
   * Test {@link DeviceSessionCtx#nextMsgId()}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#nextMsgId()}
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

    // Act
    int actualNextMsgIdResult = (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).nextMsgId();

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertEquals(1, actualNextMsgIdResult);
  }

  /**
   * Test {@link DeviceSessionCtx#isDeviceTelemetryTopic(String)}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#isDeviceTelemetryTopic(String)}
   */
  @Test
  @DisplayName("Test isDeviceTelemetryTopic(String); given Function apply(Object) return one; then calls apply(Object)")
  void testIsDeviceTelemetryTopic_givenFunctionApplyReturnOne_thenCallsApply() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("v1/devices/me/telemetry"), function);
    UUID sessionId = UUID.randomUUID();

    // Act
    boolean actualIsDeviceTelemetryTopicResult = (new DeviceSessionCtx(sessionId, mqttQoSMap,
        new MqttTransportContext())).isDeviceTelemetryTopic("Topic Name");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertFalse(actualIsDeviceTelemetryTopicResult);
  }

  /**
   * Test {@link DeviceSessionCtx#isDeviceTelemetryTopic(String)}.
   * <ul>
   *   <li>When {@code Topic Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#isDeviceTelemetryTopic(String)}
   */
  @Test
  @DisplayName("Test isDeviceTelemetryTopic(String); when 'Topic Name'; then return 'false'")
  void testIsDeviceTelemetryTopic_whenTopicName_thenReturnFalse() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertFalse(
        (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).isDeviceTelemetryTopic("Topic Name"));
  }

  /**
   * Test {@link DeviceSessionCtx#isDeviceTelemetryTopic(String)}.
   * <ul>
   *   <li>When {@code v1/devices/me/telemetry}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#isDeviceTelemetryTopic(String)}
   */
  @Test
  @DisplayName("Test isDeviceTelemetryTopic(String); when 'v1/devices/me/telemetry'; then return 'true'")
  void testIsDeviceTelemetryTopic_whenV1DevicesMeTelemetry_thenReturnTrue() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertTrue((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .isDeviceTelemetryTopic("v1/devices/me/telemetry"));
  }

  /**
   * Test {@link DeviceSessionCtx#isDeviceAttributesTopic(String)}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#isDeviceAttributesTopic(String)}
   */
  @Test
  @DisplayName("Test isDeviceAttributesTopic(String); given Function apply(Object) return one; then calls apply(Object)")
  void testIsDeviceAttributesTopic_givenFunctionApplyReturnOne_thenCallsApply() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("v1/devices/me/attributes"), function);
    UUID sessionId = UUID.randomUUID();

    // Act
    boolean actualIsDeviceAttributesTopicResult = (new DeviceSessionCtx(sessionId, mqttQoSMap,
        new MqttTransportContext())).isDeviceAttributesTopic("Topic Name");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertFalse(actualIsDeviceAttributesTopicResult);
  }

  /**
   * Test {@link DeviceSessionCtx#isDeviceAttributesTopic(String)}.
   * <ul>
   *   <li>When {@code Topic Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#isDeviceAttributesTopic(String)}
   */
  @Test
  @DisplayName("Test isDeviceAttributesTopic(String); when 'Topic Name'; then return 'false'")
  void testIsDeviceAttributesTopic_whenTopicName_thenReturnFalse() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertFalse((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .isDeviceAttributesTopic("Topic Name"));
  }

  /**
   * Test {@link DeviceSessionCtx#isDeviceAttributesTopic(String)}.
   * <ul>
   *   <li>When {@code v1/devices/me/attributes}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#isDeviceAttributesTopic(String)}
   */
  @Test
  @DisplayName("Test isDeviceAttributesTopic(String); when 'v1/devices/me/attributes'; then return 'true'")
  void testIsDeviceAttributesTopic_whenV1DevicesMeAttributes_thenReturnTrue() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertTrue((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .isDeviceAttributesTopic("v1/devices/me/attributes"));
  }

  /**
   * Test {@link DeviceSessionCtx#isDeviceSubscriptionAttributesTopic(String)}.
   * <ul>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceSessionCtx#isDeviceSubscriptionAttributesTopic(String)}
   */
  @Test
  @DisplayName("Test isDeviceSubscriptionAttributesTopic(String); then calls apply(Object)")
  void testIsDeviceSubscriptionAttributesTopic_thenCallsApply() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("v1/devices/me/attributes"), function);
    UUID sessionId = UUID.randomUUID();

    // Act
    boolean actualIsDeviceSubscriptionAttributesTopicResult = (new DeviceSessionCtx(sessionId, mqttQoSMap,
        new MqttTransportContext())).isDeviceSubscriptionAttributesTopic("Topic Name");

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertFalse(actualIsDeviceSubscriptionAttributesTopicResult);
  }

  /**
   * Test {@link DeviceSessionCtx#isDeviceSubscriptionAttributesTopic(String)}.
   * <ul>
   *   <li>When {@code Topic Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceSessionCtx#isDeviceSubscriptionAttributesTopic(String)}
   */
  @Test
  @DisplayName("Test isDeviceSubscriptionAttributesTopic(String); when 'Topic Name'; then return 'false'")
  void testIsDeviceSubscriptionAttributesTopic_whenTopicName_thenReturnFalse() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertFalse((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .isDeviceSubscriptionAttributesTopic("Topic Name"));
  }

  /**
   * Test {@link DeviceSessionCtx#isDeviceSubscriptionAttributesTopic(String)}.
   * <ul>
   *   <li>When {@code v1/devices/me/attributes}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceSessionCtx#isDeviceSubscriptionAttributesTopic(String)}
   */
  @Test
  @DisplayName("Test isDeviceSubscriptionAttributesTopic(String); when 'v1/devices/me/attributes'; then return 'true'")
  void testIsDeviceSubscriptionAttributesTopic_whenV1DevicesMeAttributes_thenReturnTrue() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertTrue((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .isDeviceSubscriptionAttributesTopic("v1/devices/me/attributes"));
  }

  /**
   * Test {@link DeviceSessionCtx#isJsonPayloadType()}.
   * <p>
   * Method under test: {@link DeviceSessionCtx#isJsonPayloadType()}
   */
  @Test
  @DisplayName("Test isJsonPayloadType()")
  void testIsJsonPayloadType() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertTrue((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).isJsonPayloadType());
  }

  /**
   * Test {@link DeviceSessionCtx#isJsonPayloadType()}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#isJsonPayloadType()}
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

    // Act
    boolean actualIsJsonPayloadTypeResult = (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .isJsonPayloadType();

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertTrue(actualIsJsonPayloadTypeResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceSessionCtx#setChannel(ChannelHandlerContext)}
   *   <li>{@link DeviceSessionCtx#setMqttVersion(MqttVersion)}
   *   <li>{@link DeviceSessionCtx#setProvisionOnly(boolean)}
   *   <li>{@link DeviceSessionCtx#setProvisionPayloadType(TransportPayloadType)}
   *   <li>{@link DeviceSessionCtx#getAttributesDynamicMessageDescriptor()}
   *   <li>{@link DeviceSessionCtx#getChannel()}
   *   <li>{@link DeviceSessionCtx#getContext()}
   *   <li>{@link DeviceSessionCtx#getMqttVersion()}
   *   <li>{@link DeviceSessionCtx#getMsgQueueProcessorLock()}
   *   <li>{@link DeviceSessionCtx#getPayloadAdaptor()}
   *   <li>{@link DeviceSessionCtx#getPayloadType()}
   *   <li>{@link DeviceSessionCtx#getProvisionPayloadType()}
   *   <li>{@link DeviceSessionCtx#getRpcRequestDynamicMessageBuilder()}
   *   <li>{@link DeviceSessionCtx#getRpcResponseDynamicMessageDescriptor()}
   *   <li>{@link DeviceSessionCtx#getTelemetryDynamicMsgDescriptor()}
   *   <li>{@link DeviceSessionCtx#isDeviceProfileMqttTransportType()}
   *   <li>{@link DeviceSessionCtx#isProvisionOnly()}
   *   <li>{@link DeviceSessionCtx#isSendAckOnValidationException()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    MqttTransportContext context = new MqttTransportContext();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, context);
    ChannelHandlerContext channel = mock(ChannelHandlerContext.class);

    // Act
    deviceSessionCtx.setChannel(channel);
    deviceSessionCtx.setMqttVersion(MqttVersion.MQTT_3_1);
    deviceSessionCtx.setProvisionOnly(true);
    deviceSessionCtx.setProvisionPayloadType(TransportPayloadType.JSON);
    deviceSessionCtx.getAttributesDynamicMessageDescriptor();
    ChannelHandlerContext actualChannel = deviceSessionCtx.getChannel();
    MqttTransportContext actualContext = deviceSessionCtx.getContext();
    MqttVersion actualMqttVersion = deviceSessionCtx.getMqttVersion();
    Lock actualMsgQueueProcessorLock = deviceSessionCtx.getMsgQueueProcessorLock();
    deviceSessionCtx.getPayloadAdaptor();
    TransportPayloadType actualPayloadType = deviceSessionCtx.getPayloadType();
    TransportPayloadType actualProvisionPayloadType = deviceSessionCtx.getProvisionPayloadType();
    deviceSessionCtx.getRpcRequestDynamicMessageBuilder();
    deviceSessionCtx.getRpcResponseDynamicMessageDescriptor();
    deviceSessionCtx.getTelemetryDynamicMsgDescriptor();
    boolean actualIsDeviceProfileMqttTransportTypeResult = deviceSessionCtx.isDeviceProfileMqttTransportType();
    boolean actualIsProvisionOnlyResult = deviceSessionCtx.isProvisionOnly();

    // Assert that nothing has changed
    assertTrue(actualMsgQueueProcessorLock instanceof ReentrantLock);
    assertEquals(MqttVersion.MQTT_3_1, actualMqttVersion);
    assertEquals(TransportPayloadType.JSON, actualPayloadType);
    assertEquals(TransportPayloadType.JSON, actualProvisionPayloadType);
    assertFalse(actualIsDeviceProfileMqttTransportTypeResult);
    assertFalse(deviceSessionCtx.isSendAckOnValidationException());
    assertTrue(actualIsProvisionOnlyResult);
    assertSame(context, actualContext);
    assertSame(channel, actualChannel);
  }

  /**
   * Test {@link DeviceSessionCtx#setDeviceProfile(DeviceProfile)}.
   * <ul>
   *   <li>Given {@link DeviceProfileData} (default constructor) Alarms is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#setDeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test setDeviceProfile(DeviceProfile); given DeviceProfileData (default constructor) Alarms is ArrayList()")
  void testSetDeviceProfile_givenDeviceProfileDataAlarmsIsArrayList() {
    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, new ConcurrentHashMap<>(), context);
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act
    deviceSessionCtx.setDeviceProfile(deviceProfile);

    // Assert
    verify(deviceProfile).getProfileData();
    verify(transportConfiguration).getType();
    verify(context, atLeast(1)).getJsonMqttAdaptor();
    assertFalse(deviceSessionCtx.isSparkplug());
    assertSame(deviceProfile, deviceSessionCtx.getDeviceProfile());
  }

  /**
   * Test {@link DeviceSessionCtx#setDeviceProfile(DeviceProfile)}.
   * <ul>
   *   <li>Then calls {@link DeviceProfileData#getTransportConfiguration()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#setDeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test setDeviceProfile(DeviceProfile); then calls getTransportConfiguration()")
  void testSetDeviceProfile_thenCallsGetTransportConfiguration() {
    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, new ConcurrentHashMap<>(), context);
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);
    DeviceProfileTransportConfiguration deviceProfileTransportConfiguration = mock(
        DeviceProfileTransportConfiguration.class);
    when(deviceProfileTransportConfiguration.getType()).thenReturn(DeviceTransportType.MQTT);
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getTransportConfiguration()).thenReturn(deviceProfileTransportConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(transportConfiguration);
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act
    deviceSessionCtx.setDeviceProfile(deviceProfile);

    // Assert
    verify(deviceProfile).getProfileData();
    verify(deviceProfileData).getTransportConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
    verify(deviceProfileTransportConfiguration).getType();
    verify(context, atLeast(1)).getJsonMqttAdaptor();
    assertFalse(deviceSessionCtx.isSparkplug());
    assertSame(deviceProfile, deviceSessionCtx.getDeviceProfile());
  }

  /**
   * Test {@link DeviceSessionCtx#getAdaptor(TopicType)}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>When {@code V1}.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#getAdaptor(TopicType)}
   */
  @Test
  @DisplayName("Test getAdaptor(TopicType); given Function apply(Object) return one; when 'V1'; then calls apply(Object)")
  void testGetAdaptor_givenFunctionApplyReturnOne_whenV1_thenCallsApply() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();

    // Act
    MqttTransportAdaptor actualAdaptor = (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .getAdaptor(TopicType.V1);

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertNull(actualAdaptor);
  }

  /**
   * Test {@link DeviceSessionCtx#getAdaptor(TopicType)}.
   * <ul>
   *   <li>When {@code V1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#getAdaptor(TopicType)}
   */
  @Test
  @DisplayName("Test getAdaptor(TopicType); when 'V1'")
  void testGetAdaptor_whenV1() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertNull((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getAdaptor(TopicType.V1));
  }

  /**
   * Test {@link DeviceSessionCtx#getAdaptor(TopicType)}.
   * <ul>
   *   <li>When {@code V2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#getAdaptor(TopicType)}
   */
  @Test
  @DisplayName("Test getAdaptor(TopicType); when 'V2'")
  void testGetAdaptor_whenV2() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertNull((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getAdaptor(TopicType.V2));
  }

  /**
   * Test {@link DeviceSessionCtx#getAdaptor(TopicType)}.
   * <ul>
   *   <li>When {@code V2_JSON}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#getAdaptor(TopicType)}
   */
  @Test
  @DisplayName("Test getAdaptor(TopicType); when 'V2_JSON'")
  void testGetAdaptor_whenV2Json() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertNull((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getAdaptor(TopicType.V2_JSON));
  }

  /**
   * Test {@link DeviceSessionCtx#getAdaptor(TopicType)}.
   * <ul>
   *   <li>When {@code V2_PROTO}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#getAdaptor(TopicType)}
   */
  @Test
  @DisplayName("Test getAdaptor(TopicType); when 'V2_PROTO'")
  void testGetAdaptor_whenV2Proto() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertNull(
        (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getAdaptor(TopicType.V2_PROTO));
  }

  /**
   * Test {@link DeviceSessionCtx#addToQueue(MqttMessage)}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#addToQueue(MqttMessage)}
   */
  @Test
  @DisplayName("Test addToQueue(MqttMessage); given Function apply(Object) return one; then calls apply(Object)")
  void testAddToQueue_givenFunctionApplyReturnOne_thenCallsApply() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    deviceSessionCtx
        .addToQueue(new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertEquals(1, deviceSessionCtx.getMsgQueueSnapshot().size());
    assertEquals(1, deviceSessionCtx.getMsgQueueSize());
  }

  /**
   * Test {@link DeviceSessionCtx#addToQueue(MqttMessage)}.
   * <ul>
   *   <li>When {@link MqttMessage#MqttMessage(MqttFixedHeader)} with
   * mqttFixedHeader is
   * {@link MqttFixedHeader#MqttFixedHeader(MqttMessageType, boolean, MqttQoS, boolean, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#addToQueue(MqttMessage)}
   */
  @Test
  @DisplayName("Test addToQueue(MqttMessage); when MqttMessage(MqttFixedHeader) with mqttFixedHeader is MqttFixedHeader(MqttMessageType, boolean, MqttQoS, boolean, int)")
  void testAddToQueue_whenMqttMessageWithMqttFixedHeaderIsMqttFixedHeader() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    deviceSessionCtx
        .addToQueue(new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    assertEquals(1, deviceSessionCtx.getMsgQueueSnapshot().size());
    assertEquals(1, deviceSessionCtx.getMsgQueueSize());
  }

  /**
   * Test {@link DeviceSessionCtx#addToQueue(MqttMessage)}.
   * <ul>
   *   <li>When
   * {@link MqttPublishVariableHeader#MqttPublishVariableHeader(String, int)} with
   * {@code Topic Name} and packetId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#addToQueue(MqttMessage)}
   */
  @Test
  @DisplayName("Test addToQueue(MqttMessage); when MqttPublishVariableHeader(String, int) with 'Topic Name' and packetId is one")
  void testAddToQueue_whenMqttPublishVariableHeaderWithTopicNameAndPacketIdIsOne() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    // Act
    deviceSessionCtx.addToQueue(new MqttPublishMessage(mqttFixedHeader, variableHeader,
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));

    // Assert
    assertEquals(1, deviceSessionCtx.getMsgQueueSnapshot().size());
    assertEquals(1, deviceSessionCtx.getMsgQueueSize());
  }

  /**
   * Test {@link DeviceSessionCtx#tryProcessQueuedMsgs(Consumer)}.
   * <ul>
   *   <li>Then calls {@link MqttTransportContext#getJsonMqttAdaptor()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#tryProcessQueuedMsgs(Consumer)}
   */
  @Test
  @DisplayName("Test tryProcessQueuedMsgs(Consumer); then calls getJsonMqttAdaptor()")
  void testTryProcessQueuedMsgs_thenCallsGetJsonMqttAdaptor() {
    // Arrange
    MqttTransportContext context = mock(MqttTransportContext.class);
    when(context.getJsonMqttAdaptor()).thenReturn(new JsonMqttAdaptor());
    UUID sessionId = UUID.randomUUID();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, new ConcurrentHashMap<>(), context);

    // Act
    deviceSessionCtx.tryProcessQueuedMsgs(deviceSessionCtx::addToQueue);

    // Assert that nothing has changed
    verify(context).getJsonMqttAdaptor();
  }

  /**
   * Test {@link DeviceSessionCtx#getMsgQueueSize()}.
   * <p>
   * Method under test: {@link DeviceSessionCtx#getMsgQueueSize()}
   */
  @Test
  @DisplayName("Test getMsgQueueSize()")
  void testGetMsgQueueSize() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertEquals(0, (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getMsgQueueSize());
  }

  /**
   * Test {@link DeviceSessionCtx#getMsgQueueSize()}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#getMsgQueueSize()}
   */
  @Test
  @DisplayName("Test getMsgQueueSize(); given Function apply(Object) return one; then calls apply(Object)")
  void testGetMsgQueueSize_givenFunctionApplyReturnOne_thenCallsApply() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();

    // Act
    int actualMsgQueueSize = (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .getMsgQueueSize();

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertEquals(0, actualMsgQueueSize);
  }

  /**
   * Test {@link DeviceSessionCtx#release()}.
   * <p>
   * Method under test: {@link DeviceSessionCtx#release()}
   */
  @Test
  @DisplayName("Test release()")
  void testRelease() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    deviceSessionCtx.release();

    // Assert that nothing has changed
    assertTrue(deviceSessionCtx.getMsgQueueSnapshot().isEmpty());
  }

  /**
   * Test {@link DeviceSessionCtx#release()}.
   * <p>
   * Method under test: {@link DeviceSessionCtx#release()}
   */
  @Test
  @DisplayName("Test release()")
  void testRelease2() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx
        .addToQueue(new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Act
    deviceSessionCtx.release();

    // Assert
    assertTrue(deviceSessionCtx.getMsgQueueSnapshot().isEmpty());
  }

  /**
   * Test {@link DeviceSessionCtx#release()}.
   * <p>
   * Method under test: {@link DeviceSessionCtx#release()}
   */
  @Test
  @DisplayName("Test release()")
  void testRelease3() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx
        .addToQueue(new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));
    deviceSessionCtx
        .addToQueue(new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Act
    deviceSessionCtx.release();

    // Assert
    assertTrue(deviceSessionCtx.getMsgQueueSnapshot().isEmpty());
  }

  /**
   * Test {@link DeviceSessionCtx#release()}.
   * <p>
   * Method under test: {@link DeviceSessionCtx#release()}
   */
  @Test
  @DisplayName("Test release()")
  void testRelease4() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.setChannel(mock(ChannelHandlerContext.class));
    deviceSessionCtx
        .addToQueue(new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Act
    deviceSessionCtx.release();

    // Assert
    assertTrue(deviceSessionCtx.getMsgQueueSnapshot().isEmpty());
  }

  /**
   * Test {@link DeviceSessionCtx#release()}.
   * <p>
   * Method under test: {@link DeviceSessionCtx#release()}
   */
  @Test
  @DisplayName("Test release()")
  void testRelease5() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader(
        "doDisconnect for device {} but unprocessed messages {} left in the msg queue", 1);

    deviceSessionCtx.addToQueue(new MqttPublishMessage(mqttFixedHeader, variableHeader,
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR))));

    // Act
    deviceSessionCtx.release();

    // Assert
    assertTrue(deviceSessionCtx.getMsgQueueSnapshot().isEmpty());
  }

  /**
   * Test {@link DeviceSessionCtx#getMsgQueueSnapshot()}.
   * <p>
   * Method under test: {@link DeviceSessionCtx#getMsgQueueSnapshot()}
   */
  @Test
  @DisplayName("Test getMsgQueueSnapshot()")
  void testGetMsgQueueSnapshot() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertTrue(
        (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getMsgQueueSnapshot().isEmpty());
  }

  /**
   * Test {@link DeviceSessionCtx#getMsgQueueSnapshot()}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return one.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#getMsgQueueSnapshot()}
   */
  @Test
  @DisplayName("Test getMsgQueueSnapshot(); given Function apply(Object) return one; then calls apply(Object)")
  void testGetMsgQueueSnapshot_givenFunctionApplyReturnOne_thenCallsApply() {
    // Arrange
    Function<MqttTopicMatcher, Integer> function = mock(Function.class);
    when(function.apply(Mockito.<MqttTopicMatcher>any())).thenReturn(1);

    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    mqttQoSMap.computeIfAbsent(new MqttTopicMatcher("Topic"), function);
    UUID sessionId = UUID.randomUUID();

    // Act
    Collection<MqttMessage> actualMsgQueueSnapshot = (new DeviceSessionCtx(sessionId, mqttQoSMap,
        new MqttTransportContext())).getMsgQueueSnapshot();

    // Assert
    verify(function).apply(isA(MqttTopicMatcher.class));
    assertTrue(actualMsgQueueSnapshot.isEmpty());
  }
}
