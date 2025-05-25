package org.thingsboard.server.transport.mqtt.session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.DynamicMessage.Builder;
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
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
import org.thingsboard.server.transport.mqtt.adaptors.MqttTransportAdaptor;

class DeviceSessionCtxDiffblueTest {
  /**
   * Test {@link DeviceSessionCtx#nextMsgId()}.
   * <p>
   * Method under test: {@link DeviceSessionCtx#nextMsgId()}
   */
  @Test
  @DisplayName("Test nextMsgId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DeviceSessionCtx.nextMsgId()"})
  void testNextMsgId() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertEquals(1, (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).nextMsgId());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceSessionCtx.isDeviceTelemetryTopic(String)"})
  void testIsDeviceTelemetryTopic_whenTopicName_thenReturnFalse() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceSessionCtx.isDeviceTelemetryTopic(String)"})
  void testIsDeviceTelemetryTopic_whenV1DevicesMeTelemetry_thenReturnTrue() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertTrue((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .isDeviceTelemetryTopic("v1/devices/me/telemetry"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceSessionCtx.isDeviceAttributesTopic(String)"})
  void testIsDeviceAttributesTopic_whenTopicName_thenReturnFalse() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceSessionCtx.isDeviceAttributesTopic(String)"})
  void testIsDeviceAttributesTopic_whenV1DevicesMeAttributes_thenReturnTrue() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertTrue((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .isDeviceAttributesTopic("v1/devices/me/attributes"));
  }

  /**
   * Test {@link DeviceSessionCtx#isDeviceSubscriptionAttributesTopic(String)}.
   * <ul>
   *   <li>When {@code Topic Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#isDeviceSubscriptionAttributesTopic(String)}
   */
  @Test
  @DisplayName("Test isDeviceSubscriptionAttributesTopic(String); when 'Topic Name'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceSessionCtx.isDeviceSubscriptionAttributesTopic(String)"})
  void testIsDeviceSubscriptionAttributesTopic_whenTopicName_thenReturnFalse() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
   * Method under test: {@link DeviceSessionCtx#isDeviceSubscriptionAttributesTopic(String)}
   */
  @Test
  @DisplayName("Test isDeviceSubscriptionAttributesTopic(String); when 'v1/devices/me/attributes'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceSessionCtx.isDeviceSubscriptionAttributesTopic(String)"})
  void testIsDeviceSubscriptionAttributesTopic_whenV1DevicesMeAttributes_thenReturnTrue() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceSessionCtx.isJsonPayloadType()"})
  void testIsJsonPayloadType() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertTrue((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).isJsonPayloadType());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Descriptors.Descriptor DeviceSessionCtx.getAttributesDynamicMessageDescriptor()",
      "ChannelHandlerContext DeviceSessionCtx.getChannel()", "MqttTransportContext DeviceSessionCtx.getContext()",
      "MqttVersion DeviceSessionCtx.getMqttVersion()", "Lock DeviceSessionCtx.getMsgQueueProcessorLock()",
      "MqttTransportAdaptor DeviceSessionCtx.getPayloadAdaptor()",
      "TransportPayloadType DeviceSessionCtx.getPayloadType()",
      "TransportPayloadType DeviceSessionCtx.getProvisionPayloadType()",
      "Builder DeviceSessionCtx.getRpcRequestDynamicMessageBuilder()",
      "Descriptors.Descriptor DeviceSessionCtx.getRpcResponseDynamicMessageDescriptor()",
      "Descriptors.Descriptor DeviceSessionCtx.getTelemetryDynamicMsgDescriptor()",
      "boolean DeviceSessionCtx.isDeviceProfileMqttTransportType()", "boolean DeviceSessionCtx.isProvisionOnly()",
      "boolean DeviceSessionCtx.isSendAckOnValidationException()",
      "void DeviceSessionCtx.setChannel(ChannelHandlerContext)", "void DeviceSessionCtx.setMqttVersion(MqttVersion)",
      "void DeviceSessionCtx.setProvisionOnly(boolean)",
      "void DeviceSessionCtx.setProvisionPayloadType(TransportPayloadType)"})
  void testGettersAndSetters() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    MqttTransportContext context = new MqttTransportContext();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, context);
    ChannelHandlerContext channel = mock(ChannelHandlerContext.class);

    // Act
    deviceSessionCtx.setChannel(channel);
    deviceSessionCtx.setMqttVersion(MqttVersion.MQTT_3_1);
    deviceSessionCtx.setProvisionOnly(true);
    deviceSessionCtx.setProvisionPayloadType(TransportPayloadType.JSON);
    Descriptor actualAttributesDynamicMessageDescriptor = deviceSessionCtx.getAttributesDynamicMessageDescriptor();
    ChannelHandlerContext actualChannel = deviceSessionCtx.getChannel();
    MqttTransportContext actualContext = deviceSessionCtx.getContext();
    MqttVersion actualMqttVersion = deviceSessionCtx.getMqttVersion();
    Lock actualMsgQueueProcessorLock = deviceSessionCtx.getMsgQueueProcessorLock();
    MqttTransportAdaptor actualPayloadAdaptor = deviceSessionCtx.getPayloadAdaptor();
    TransportPayloadType actualPayloadType = deviceSessionCtx.getPayloadType();
    TransportPayloadType actualProvisionPayloadType = deviceSessionCtx.getProvisionPayloadType();
    Builder actualRpcRequestDynamicMessageBuilder = deviceSessionCtx.getRpcRequestDynamicMessageBuilder();
    Descriptor actualRpcResponseDynamicMessageDescriptor = deviceSessionCtx.getRpcResponseDynamicMessageDescriptor();
    Descriptor actualTelemetryDynamicMsgDescriptor = deviceSessionCtx.getTelemetryDynamicMsgDescriptor();
    boolean actualIsDeviceProfileMqttTransportTypeResult = deviceSessionCtx.isDeviceProfileMqttTransportType();
    boolean actualIsProvisionOnlyResult = deviceSessionCtx.isProvisionOnly();

    // Assert
    assertTrue(actualMsgQueueProcessorLock instanceof ReentrantLock);
    assertNull(actualAttributesDynamicMessageDescriptor);
    assertNull(actualRpcResponseDynamicMessageDescriptor);
    assertNull(actualTelemetryDynamicMsgDescriptor);
    assertNull(actualRpcRequestDynamicMessageBuilder);
    assertNull(actualPayloadAdaptor);
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
   * <p>
   * Method under test: {@link DeviceSessionCtx#setDeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test setDeviceProfile(DeviceProfile)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceSessionCtx.setDeviceProfile(DeviceProfile)"})
  void testSetDeviceProfile() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceSessionCtx.setDeviceProfile(DeviceProfile)"})
  void testSetDeviceProfile_thenCallsGetTransportConfiguration() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    DeviceSessionCtx deviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
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
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
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
    assertFalse(deviceSessionCtx.isSparkplug());
    assertSame(deviceProfile, deviceSessionCtx.getDeviceProfile());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttTransportAdaptor DeviceSessionCtx.getAdaptor(TopicType)"})
  void testGetAdaptor_whenV1() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttTransportAdaptor DeviceSessionCtx.getAdaptor(TopicType)"})
  void testGetAdaptor_whenV2() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttTransportAdaptor DeviceSessionCtx.getAdaptor(TopicType)"})
  void testGetAdaptor_whenV2Json() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MqttTransportAdaptor DeviceSessionCtx.getAdaptor(TopicType)"})
  void testGetAdaptor_whenV2Proto() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertNull(
        (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getAdaptor(TopicType.V2_PROTO));
  }

  /**
   * Test {@link DeviceSessionCtx#addToQueue(MqttMessage)}.
   * <ul>
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link MqttTransportAdaptor#ALLOCATOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#addToQueue(MqttMessage)}
   */
  @Test
  @DisplayName("Test addToQueue(MqttMessage); when EmptyByteBuf(ByteBufAllocator) with alloc is ALLOCATOR")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceSessionCtx.addToQueue(MqttMessage)"})
  void testAddToQueue_whenEmptyByteBufWithAllocIsAllocator() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
   * Test {@link DeviceSessionCtx#addToQueue(MqttMessage)}.
   * <ul>
   *   <li>When {@link MqttMessage#MqttMessage(MqttFixedHeader)} with mqttFixedHeader is {@link MqttFixedHeader#MqttFixedHeader(MqttMessageType, boolean, MqttQoS, boolean, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceSessionCtx#addToQueue(MqttMessage)}
   */
  @Test
  @DisplayName("Test addToQueue(MqttMessage); when MqttMessage(MqttFixedHeader) with mqttFixedHeader is MqttFixedHeader(MqttMessageType, boolean, MqttQoS, boolean, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceSessionCtx.addToQueue(MqttMessage)"})
  void testAddToQueue_whenMqttMessageWithMqttFixedHeaderIsMqttFixedHeader() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
   * Test {@link DeviceSessionCtx#getMsgQueueSize()}.
   * <p>
   * Method under test: {@link DeviceSessionCtx#getMsgQueueSize()}
   */
  @Test
  @DisplayName("Test getMsgQueueSize()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DeviceSessionCtx.getMsgQueueSize()"})
  void testGetMsgQueueSize() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertEquals(0, (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getMsgQueueSize());
  }

  /**
   * Test {@link DeviceSessionCtx#release()}.
   * <p>
   * Method under test: {@link DeviceSessionCtx#release()}
   */
  @Test
  @DisplayName("Test release()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceSessionCtx.release()"})
  void testRelease() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceSessionCtx.release()"})
  void testRelease2() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceSessionCtx.release()"})
  void testRelease3() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceSessionCtx.release()"})
  void testRelease4() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Collection DeviceSessionCtx.getMsgQueueSnapshot()"})
  void testGetMsgQueueSnapshot() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertTrue(
        (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getMsgQueueSnapshot().isEmpty());
  }
}
