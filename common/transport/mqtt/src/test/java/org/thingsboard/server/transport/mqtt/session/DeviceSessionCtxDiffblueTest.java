/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.transport.mqtt.session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.TransportPayloadType;
import org.thingsboard.server.common.data.device.profile.DeviceProfileConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileData;
import org.thingsboard.server.common.data.device.profile.DeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.MqttDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.X509CertificateChainProvisionConfiguration;
import org.thingsboard.server.transport.mqtt.MqttTransportContext;
import org.thingsboard.server.transport.mqtt.TopicType;
import org.thingsboard.server.transport.mqtt.adaptors.MqttTransportAdaptor;

class DeviceSessionCtxDiffblueTest {
  /**
   * Test {@link DeviceSessionCtx#DeviceSessionCtx(UUID, ConcurrentMap, MqttTransportContext)}.
   *
   * <p>Method under test: {@link DeviceSessionCtx#DeviceSessionCtx(UUID, ConcurrentMap,
   * MqttTransportContext)}
   */
  @Test
  @DisplayName("Test new DeviceSessionCtx(UUID, ConcurrentMap, MqttTransportContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceSessionCtx.<init>(UUID, ConcurrentMap, MqttTransportContext)"})
  void testNewDeviceSessionCtx() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    MqttTransportContext context = new MqttTransportContext();

    // Act
    DeviceSessionCtx actualDeviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, context);

    // Assert
    assertTrue(actualDeviceSessionCtx.getMsgQueueProcessorLock() instanceof ReentrantLock);
    assertNull(actualDeviceSessionCtx.getAttributesDynamicMessageDescriptor());
    assertNull(actualDeviceSessionCtx.getRpcResponseDynamicMessageDescriptor());
    assertNull(actualDeviceSessionCtx.getTelemetryDynamicMsgDescriptor());
    assertNull(actualDeviceSessionCtx.getRpcRequestDynamicMessageBuilder());
    assertNull(actualDeviceSessionCtx.getChannel());
    assertNull(actualDeviceSessionCtx.getMqttVersion());
    assertNull(actualDeviceSessionCtx.getDeviceProfile());
    assertNull(actualDeviceSessionCtx.getDeviceId());
    assertNull(actualDeviceSessionCtx.getTenantId());
    assertNull(actualDeviceSessionCtx.getDeviceInfo());
    assertNull(actualDeviceSessionCtx.getSessionInfo());
    assertNull(actualDeviceSessionCtx.getPayloadAdaptor());
    assertEquals(0, actualDeviceSessionCtx.getMsgQueueSize());
    assertEquals(TransportPayloadType.JSON, actualDeviceSessionCtx.getPayloadType());
    assertEquals(TransportPayloadType.JSON, actualDeviceSessionCtx.getProvisionPayloadType());
    assertFalse(actualDeviceSessionCtx.isConnected());
    assertFalse(actualDeviceSessionCtx.isDeviceProfileMqttTransportType());
    assertFalse(actualDeviceSessionCtx.isProvisionOnly());
    assertFalse(actualDeviceSessionCtx.isSendAckOnValidationException());
    assertTrue(actualDeviceSessionCtx.getMsgQueueSnapshot().isEmpty());
    ConcurrentMap<MqttTopicMatcher, Integer> mqttQoSMap2 = actualDeviceSessionCtx.getMqttQoSMap();
    assertTrue(mqttQoSMap2.isEmpty());
    assertTrue(actualDeviceSessionCtx.isJsonPayloadType());
    assertSame(mqttQoSMap, mqttQoSMap2);
    assertSame(context, actualDeviceSessionCtx.getContext());
    assertSame(sessionId, actualDeviceSessionCtx.getSessionId());
  }

  /**
   * Test {@link DeviceSessionCtx#nextMsgId()}.
   *
   * <p>Method under test: {@link DeviceSessionCtx#nextMsgId()}
   */
  @Test
  @DisplayName("Test nextMsgId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DeviceSessionCtx.nextMsgId()"})
  void testNextMsgId() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertEquals(1, deviceSessionCtx.nextMsgId());
  }

  /**
   * Test {@link DeviceSessionCtx#isDeviceTelemetryTopic(String)}.
   *
   * <ul>
   *   <li>When {@code Topic Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSessionCtx#isDeviceTelemetryTopic(String)}
   */
  @Test
  @DisplayName("Test isDeviceTelemetryTopic(String); when 'Topic Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceSessionCtx.isDeviceTelemetryTopic(String)"})
  void testIsDeviceTelemetryTopic_whenTopicName_thenReturnFalse() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertFalse(deviceSessionCtx.isDeviceTelemetryTopic("Topic Name"));
  }

  /**
   * Test {@link DeviceSessionCtx#isDeviceTelemetryTopic(String)}.
   *
   * <ul>
   *   <li>When {@code v1/devices/me/telemetry}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSessionCtx#isDeviceTelemetryTopic(String)}
   */
  @Test
  @DisplayName(
      "Test isDeviceTelemetryTopic(String); when 'v1/devices/me/telemetry'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceSessionCtx.isDeviceTelemetryTopic(String)"})
  void testIsDeviceTelemetryTopic_whenV1DevicesMeTelemetry_thenReturnTrue() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertTrue(deviceSessionCtx.isDeviceTelemetryTopic("v1/devices/me/telemetry"));
  }

  /**
   * Test {@link DeviceSessionCtx#isDeviceAttributesTopic(String)}.
   *
   * <ul>
   *   <li>When {@code Topic Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSessionCtx#isDeviceAttributesTopic(String)}
   */
  @Test
  @DisplayName("Test isDeviceAttributesTopic(String); when 'Topic Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceSessionCtx.isDeviceAttributesTopic(String)"})
  void testIsDeviceAttributesTopic_whenTopicName_thenReturnFalse() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertFalse(deviceSessionCtx.isDeviceAttributesTopic("Topic Name"));
  }

  /**
   * Test {@link DeviceSessionCtx#isDeviceAttributesTopic(String)}.
   *
   * <ul>
   *   <li>When {@code v1/devices/me/attributes}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSessionCtx#isDeviceAttributesTopic(String)}
   */
  @Test
  @DisplayName(
      "Test isDeviceAttributesTopic(String); when 'v1/devices/me/attributes'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceSessionCtx.isDeviceAttributesTopic(String)"})
  void testIsDeviceAttributesTopic_whenV1DevicesMeAttributes_thenReturnTrue() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertTrue(deviceSessionCtx.isDeviceAttributesTopic("v1/devices/me/attributes"));
  }

  /**
   * Test {@link DeviceSessionCtx#isDeviceSubscriptionAttributesTopic(String)}.
   *
   * <ul>
   *   <li>When {@code Topic Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSessionCtx#isDeviceSubscriptionAttributesTopic(String)}
   */
  @Test
  @DisplayName(
      "Test isDeviceSubscriptionAttributesTopic(String); when 'Topic Name'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceSessionCtx.isDeviceSubscriptionAttributesTopic(String)"})
  void testIsDeviceSubscriptionAttributesTopic_whenTopicName_thenReturnFalse() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertFalse(deviceSessionCtx.isDeviceSubscriptionAttributesTopic("Topic Name"));
  }

  /**
   * Test {@link DeviceSessionCtx#isDeviceSubscriptionAttributesTopic(String)}.
   *
   * <ul>
   *   <li>When {@code v1/devices/me/attributes}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSessionCtx#isDeviceSubscriptionAttributesTopic(String)}
   */
  @Test
  @DisplayName(
      "Test isDeviceSubscriptionAttributesTopic(String); when 'v1/devices/me/attributes'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceSessionCtx.isDeviceSubscriptionAttributesTopic(String)"})
  void testIsDeviceSubscriptionAttributesTopic_whenV1DevicesMeAttributes_thenReturnTrue() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertTrue(deviceSessionCtx.isDeviceSubscriptionAttributesTopic("v1/devices/me/attributes"));
  }

  /**
   * Test {@link DeviceSessionCtx#isJsonPayloadType()}.
   *
   * <p>Method under test: {@link DeviceSessionCtx#isJsonPayloadType()}
   */
  @Test
  @DisplayName("Test isJsonPayloadType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceSessionCtx.isJsonPayloadType()"})
  void testIsJsonPayloadType() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertTrue(deviceSessionCtx.isJsonPayloadType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Descriptors.Descriptor DeviceSessionCtx.getAttributesDynamicMessageDescriptor()",
    "ChannelHandlerContext DeviceSessionCtx.getChannel()",
    "MqttTransportContext DeviceSessionCtx.getContext()",
    "MqttVersion DeviceSessionCtx.getMqttVersion()",
    "Lock DeviceSessionCtx.getMsgQueueProcessorLock()",
    "MqttTransportAdaptor DeviceSessionCtx.getPayloadAdaptor()",
    "TransportPayloadType DeviceSessionCtx.getPayloadType()",
    "TransportPayloadType DeviceSessionCtx.getProvisionPayloadType()",
    "Builder DeviceSessionCtx.getRpcRequestDynamicMessageBuilder()",
    "Descriptors.Descriptor DeviceSessionCtx.getRpcResponseDynamicMessageDescriptor()",
    "Descriptors.Descriptor DeviceSessionCtx.getTelemetryDynamicMsgDescriptor()",
    "boolean DeviceSessionCtx.isDeviceProfileMqttTransportType()",
    "boolean DeviceSessionCtx.isProvisionOnly()",
    "boolean DeviceSessionCtx.isSendAckOnValidationException()",
    "void DeviceSessionCtx.setChannel(ChannelHandlerContext)",
    "void DeviceSessionCtx.setMqttVersion(MqttVersion)",
    "void DeviceSessionCtx.setProvisionOnly(boolean)",
    "void DeviceSessionCtx.setProvisionPayloadType(TransportPayloadType)"
  })
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
    Descriptor actualAttributesDynamicMessageDescriptor =
        deviceSessionCtx.getAttributesDynamicMessageDescriptor();
    ChannelHandlerContext actualChannel = deviceSessionCtx.getChannel();
    MqttTransportContext actualContext = deviceSessionCtx.getContext();
    MqttVersion actualMqttVersion = deviceSessionCtx.getMqttVersion();
    Lock actualMsgQueueProcessorLock = deviceSessionCtx.getMsgQueueProcessorLock();
    MqttTransportAdaptor actualPayloadAdaptor = deviceSessionCtx.getPayloadAdaptor();
    TransportPayloadType actualPayloadType = deviceSessionCtx.getPayloadType();
    TransportPayloadType actualProvisionPayloadType = deviceSessionCtx.getProvisionPayloadType();
    Builder actualRpcRequestDynamicMessageBuilder =
        deviceSessionCtx.getRpcRequestDynamicMessageBuilder();
    Descriptor actualRpcResponseDynamicMessageDescriptor =
        deviceSessionCtx.getRpcResponseDynamicMessageDescriptor();
    Descriptor actualTelemetryDynamicMsgDescriptor =
        deviceSessionCtx.getTelemetryDynamicMsgDescriptor();
    boolean actualIsDeviceProfileMqttTransportTypeResult =
        deviceSessionCtx.isDeviceProfileMqttTransportType();
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
   *
   * <p>Method under test: {@link DeviceSessionCtx#setDeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test setDeviceProfile(DeviceProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceSessionCtx.setDeviceProfile(DeviceProfile)"})
  void testSetDeviceProfile() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(new MqttDeviceProfileTransportConfiguration());

    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);

    // Act
    deviceSessionCtx.setDeviceProfile(deviceProfile);

    // Assert
    verify(deviceProfile).getProfileData();
    assertFalse(deviceSessionCtx.isSparkplug());
    assertTrue(deviceSessionCtx.isDeviceProfileMqttTransportType());
    assertSame(deviceProfile, deviceSessionCtx.getDeviceProfile());
  }

  /**
   * Test {@link DeviceSessionCtx#setDeviceProfile(DeviceProfile)}.
   *
   * <p>Method under test: {@link DeviceSessionCtx#setDeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test setDeviceProfile(DeviceProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceSessionCtx.setDeviceProfile(DeviceProfile)"})
  void testSetDeviceProfile2() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttDeviceProfileTransportConfiguration transportConfiguration =
        new MqttDeviceProfileTransportConfiguration();
    transportConfiguration.setDeviceTelemetryTopic(null);

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
    assertFalse(deviceSessionCtx.isSparkplug());
    assertTrue(deviceSessionCtx.isDeviceProfileMqttTransportType());
    assertSame(deviceProfile, deviceSessionCtx.getDeviceProfile());
  }

  /**
   * Test {@link DeviceSessionCtx#setDeviceProfile(DeviceProfile)}.
   *
   * <p>Method under test: {@link DeviceSessionCtx#setDeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test setDeviceProfile(DeviceProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceSessionCtx.setDeviceProfile(DeviceProfile)"})
  void testSetDeviceProfile3() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    MqttDeviceProfileTransportConfiguration transportConfiguration =
        new MqttDeviceProfileTransportConfiguration();
    transportConfiguration.setDeviceTelemetryTopic("");

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
    assertFalse(deviceSessionCtx.isSparkplug());
    assertTrue(deviceSessionCtx.isDeviceProfileMqttTransportType());
    assertSame(deviceProfile, deviceSessionCtx.getDeviceProfile());
  }

  /**
   * Test {@link DeviceSessionCtx#setDeviceProfile(DeviceProfile)}.
   *
   * <p>Method under test: {@link DeviceSessionCtx#setDeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test setDeviceProfile(DeviceProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceSessionCtx.setDeviceProfile(DeviceProfile)"})
  void testSetDeviceProfile4() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
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
    assertFalse(deviceSessionCtx.isDeviceProfileMqttTransportType());
    assertSame(deviceProfile, deviceSessionCtx.getDeviceProfile());
  }

  /**
   * Test {@link DeviceSessionCtx#setDeviceProfile(DeviceProfile)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfileTransportConfiguration} {@link
   *       DeviceProfileTransportConfiguration#getType()} return {@code MQTT}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSessionCtx#setDeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName(
      "Test setDeviceProfile(DeviceProfile); given DeviceProfileTransportConfiguration getType() return 'MQTT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceSessionCtx.setDeviceProfile(DeviceProfile)"})
  void testSetDeviceProfile_givenDeviceProfileTransportConfigurationGetTypeReturnMqtt() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.MQTT);

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
    assertFalse(deviceSessionCtx.isDeviceProfileMqttTransportType());
    assertSame(deviceProfile, deviceSessionCtx.getDeviceProfile());
  }

  /**
   * Test {@link DeviceSessionCtx#getAdaptor(TopicType)}.
   *
   * <ul>
   *   <li>When {@code V1}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSessionCtx#getAdaptor(TopicType)}
   */
  @Test
  @DisplayName("Test getAdaptor(TopicType); when 'V1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MqttTransportAdaptor DeviceSessionCtx.getAdaptor(TopicType)"})
  void testGetAdaptor_whenV1() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertNull(deviceSessionCtx.getAdaptor(TopicType.V1));
  }

  /**
   * Test {@link DeviceSessionCtx#getAdaptor(TopicType)}.
   *
   * <ul>
   *   <li>When {@code V2}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSessionCtx#getAdaptor(TopicType)}
   */
  @Test
  @DisplayName("Test getAdaptor(TopicType); when 'V2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MqttTransportAdaptor DeviceSessionCtx.getAdaptor(TopicType)"})
  void testGetAdaptor_whenV2() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertNull(deviceSessionCtx.getAdaptor(TopicType.V2));
  }

  /**
   * Test {@link DeviceSessionCtx#getAdaptor(TopicType)}.
   *
   * <ul>
   *   <li>When {@code V2_JSON}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSessionCtx#getAdaptor(TopicType)}
   */
  @Test
  @DisplayName("Test getAdaptor(TopicType); when 'V2_JSON'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MqttTransportAdaptor DeviceSessionCtx.getAdaptor(TopicType)"})
  void testGetAdaptor_whenV2Json() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertNull(deviceSessionCtx.getAdaptor(TopicType.V2_JSON));
  }

  /**
   * Test {@link DeviceSessionCtx#getAdaptor(TopicType)}.
   *
   * <ul>
   *   <li>When {@code V2_PROTO}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSessionCtx#getAdaptor(TopicType)}
   */
  @Test
  @DisplayName("Test getAdaptor(TopicType); when 'V2_PROTO'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MqttTransportAdaptor DeviceSessionCtx.getAdaptor(TopicType)"})
  void testGetAdaptor_whenV2Proto() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertNull(deviceSessionCtx.getAdaptor(TopicType.V2_PROTO));
  }

  /**
   * Test {@link DeviceSessionCtx#addToQueue(MqttMessage)}.
   *
   * <ul>
   *   <li>When {@link EmptyByteBuf#EmptyByteBuf(ByteBufAllocator)} with alloc is {@link
   *       MqttTransportAdaptor#ALLOCATOR}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSessionCtx#addToQueue(MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test addToQueue(MqttMessage); when EmptyByteBuf(ByteBufAllocator) with alloc is ALLOCATOR")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceSessionCtx.addToQueue(MqttMessage)"})
  void testAddToQueue_whenEmptyByteBufWithAllocIsAllocator() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage msg = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);

    // Act
    deviceSessionCtx.addToQueue(msg);

    // Assert
    assertEquals(1, deviceSessionCtx.getMsgQueueSnapshot().size());
    assertEquals(1, deviceSessionCtx.getMsgQueueSize());
  }

  /**
   * Test {@link DeviceSessionCtx#addToQueue(MqttMessage)}.
   *
   * <ul>
   *   <li>When {@link MqttMessage#MqttMessage(MqttFixedHeader)} with mqttFixedHeader is {@link
   *       MqttFixedHeader#MqttFixedHeader(MqttMessageType, boolean, MqttQoS, boolean, int)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSessionCtx#addToQueue(MqttMessage)}
   */
  @Test
  @DisplayName(
      "Test addToQueue(MqttMessage); when MqttMessage(MqttFixedHeader) with mqttFixedHeader is MqttFixedHeader(MqttMessageType, boolean, MqttQoS, boolean, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceSessionCtx.addToQueue(MqttMessage)"})
  void testAddToQueue_whenMqttMessageWithMqttFixedHeaderIsMqttFixedHeader() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    deviceSessionCtx.addToQueue(
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Assert
    assertEquals(1, deviceSessionCtx.getMsgQueueSnapshot().size());
    assertEquals(1, deviceSessionCtx.getMsgQueueSize());
  }

  /**
   * Test {@link DeviceSessionCtx#getMsgQueueSize()}.
   *
   * <p>Method under test: {@link DeviceSessionCtx#getMsgQueueSize()}
   */
  @Test
  @DisplayName("Test getMsgQueueSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DeviceSessionCtx.getMsgQueueSize()"})
  void testGetMsgQueueSize() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertEquals(0, deviceSessionCtx.getMsgQueueSize());
  }

  /**
   * Test {@link DeviceSessionCtx#release()}.
   *
   * <p>Method under test: {@link DeviceSessionCtx#release()}
   */
  @Test
  @DisplayName("Test release()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceSessionCtx.release()"})
  void testRelease() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act
    deviceSessionCtx.release();

    // Assert that nothing has changed
    assertTrue(deviceSessionCtx.getMsgQueueSnapshot().isEmpty());
  }

  /**
   * Test {@link DeviceSessionCtx#release()}.
   *
   * <p>Method under test: {@link DeviceSessionCtx#release()}
   */
  @Test
  @DisplayName("Test release()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceSessionCtx.release()"})
  void testRelease2() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.addToQueue(
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Act
    deviceSessionCtx.release();

    // Assert
    assertTrue(deviceSessionCtx.getMsgQueueSnapshot().isEmpty());
  }

  /**
   * Test {@link DeviceSessionCtx#release()}.
   *
   * <p>Method under test: {@link DeviceSessionCtx#release()}
   */
  @Test
  @DisplayName("Test release()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceSessionCtx.release()"})
  void testRelease3() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    deviceSessionCtx.addToQueue(
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));
    deviceSessionCtx.addToQueue(
        new MqttMessage(
            new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3)));

    // Act
    deviceSessionCtx.release();

    // Assert
    assertTrue(deviceSessionCtx.getMsgQueueSnapshot().isEmpty());
  }

  /**
   * Test {@link DeviceSessionCtx#release()}.
   *
   * <p>Method under test: {@link DeviceSessionCtx#release()}
   */
  @Test
  @DisplayName("Test release()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceSessionCtx.release()"})
  void testRelease4() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);
    MqttPublishVariableHeader variableHeader =
        new MqttPublishVariableHeader(
            "doDisconnect for device {} but unprocessed messages {} left in the msg queue", 1);
    DuplicatedByteBuf payload =
        new DuplicatedByteBuf(new EmptyByteBuf(MqttTransportAdaptor.ALLOCATOR));

    MqttPublishMessage msg = new MqttPublishMessage(mqttFixedHeader, variableHeader, payload);
    deviceSessionCtx.addToQueue(msg);

    // Act
    deviceSessionCtx.release();

    // Assert
    assertTrue(deviceSessionCtx.getMsgQueueSnapshot().isEmpty());
  }

  /**
   * Test {@link DeviceSessionCtx#getMsgQueueSnapshot()}.
   *
   * <p>Method under test: {@link DeviceSessionCtx#getMsgQueueSnapshot()}
   */
  @Test
  @DisplayName("Test getMsgQueueSnapshot()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Collection DeviceSessionCtx.getMsgQueueSnapshot()"})
  void testGetMsgQueueSnapshot() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    DeviceSessionCtx deviceSessionCtx =
        new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext());

    // Act and Assert
    assertTrue(deviceSessionCtx.getMsgQueueSnapshot().isEmpty());
  }
}
