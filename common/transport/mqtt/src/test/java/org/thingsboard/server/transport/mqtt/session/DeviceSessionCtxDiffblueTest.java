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
   * Method under test:
   * {@link DeviceSessionCtx#DeviceSessionCtx(UUID, ConcurrentMap, MqttTransportContext)}
   */
  @Test
  void testNewDeviceSessionCtx() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();
    MqttTransportContext context = new MqttTransportContext();

    // Act
    DeviceSessionCtx actualDeviceSessionCtx = new DeviceSessionCtx(sessionId, mqttQoSMap, context);

    // Assert
    Lock msgQueueProcessorLock = actualDeviceSessionCtx.getMsgQueueProcessorLock();
    assertTrue(msgQueueProcessorLock instanceof ReentrantLock);
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
    assertEquals(0, ((ReentrantLock) msgQueueProcessorLock).getHoldCount());
    assertEquals(0, ((ReentrantLock) msgQueueProcessorLock).getQueueLength());
    assertEquals(0, actualDeviceSessionCtx.getMsgQueueSize());
    assertEquals(TransportPayloadType.JSON, actualDeviceSessionCtx.getPayloadType());
    assertEquals(TransportPayloadType.JSON, actualDeviceSessionCtx.getProvisionPayloadType());
    assertFalse(((ReentrantLock) msgQueueProcessorLock).hasQueuedThreads());
    assertFalse(((ReentrantLock) msgQueueProcessorLock).isFair());
    assertFalse(((ReentrantLock) msgQueueProcessorLock).isHeldByCurrentThread());
    assertFalse(((ReentrantLock) msgQueueProcessorLock).isLocked());
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
   * Method under test:
   * {@link DeviceSessionCtx#DeviceSessionCtx(UUID, ConcurrentMap, MqttTransportContext)}
   */
  @Test
  void testNewDeviceSessionCtx2() {
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
    Lock msgQueueProcessorLock = actualDeviceSessionCtx.getMsgQueueProcessorLock();
    assertTrue(msgQueueProcessorLock instanceof ReentrantLock);
    MqttTransportAdaptor payloadAdaptor = actualDeviceSessionCtx.getPayloadAdaptor();
    assertTrue(payloadAdaptor instanceof JsonMqttAdaptor);
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
    assertEquals(0, ((ReentrantLock) msgQueueProcessorLock).getHoldCount());
    assertEquals(0, ((ReentrantLock) msgQueueProcessorLock).getQueueLength());
    assertEquals(0, actualDeviceSessionCtx.getMsgQueueSize());
    assertEquals(TransportPayloadType.JSON, actualDeviceSessionCtx.getPayloadType());
    assertEquals(TransportPayloadType.JSON, actualDeviceSessionCtx.getProvisionPayloadType());
    assertFalse(((ReentrantLock) msgQueueProcessorLock).hasQueuedThreads());
    assertFalse(((ReentrantLock) msgQueueProcessorLock).isFair());
    assertFalse(((ReentrantLock) msgQueueProcessorLock).isHeldByCurrentThread());
    assertFalse(((ReentrantLock) msgQueueProcessorLock).isLocked());
    assertFalse(actualDeviceSessionCtx.isConnected());
    assertFalse(actualDeviceSessionCtx.isDeviceProfileMqttTransportType());
    assertFalse(actualDeviceSessionCtx.isProvisionOnly());
    assertFalse(actualDeviceSessionCtx.isSendAckOnValidationException());
    assertTrue(actualDeviceSessionCtx.getMsgQueueSnapshot().isEmpty());
    ConcurrentMap<MqttTopicMatcher, Integer> mqttQoSMap2 = actualDeviceSessionCtx.getMqttQoSMap();
    assertTrue(mqttQoSMap2.isEmpty());
    assertTrue(actualDeviceSessionCtx.isJsonPayloadType());
    assertSame(mqttQoSMap, mqttQoSMap2);
    assertSame(jsonMqttAdaptor, payloadAdaptor);
    assertSame(sessionId, actualDeviceSessionCtx.getSessionId());
    assertSame(context, actualDeviceSessionCtx.getContext());
  }

  /**
   * Method under test: {@link DeviceSessionCtx#nextMsgId()}
   */
  @Test
  void testNextMsgId() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertEquals(1, (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).nextMsgId());
  }

  /**
   * Method under test: {@link DeviceSessionCtx#nextMsgId()}
   */
  @Test
  void testNextMsgId2() {
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
   * Method under test: {@link DeviceSessionCtx#isDeviceTelemetryTopic(String)}
   */
  @Test
  void testIsDeviceTelemetryTopic() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertFalse(
        (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).isDeviceTelemetryTopic("Topic Name"));
  }

  /**
   * Method under test: {@link DeviceSessionCtx#isDeviceTelemetryTopic(String)}
   */
  @Test
  void testIsDeviceTelemetryTopic2() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertTrue((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .isDeviceTelemetryTopic("v1/devices/me/telemetry"));
  }

  /**
   * Method under test: {@link DeviceSessionCtx#isDeviceTelemetryTopic(String)}
   */
  @Test
  void testIsDeviceTelemetryTopic3() {
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
   * Method under test: {@link DeviceSessionCtx#isDeviceAttributesTopic(String)}
   */
  @Test
  void testIsDeviceAttributesTopic() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertFalse((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .isDeviceAttributesTopic("Topic Name"));
  }

  /**
   * Method under test: {@link DeviceSessionCtx#isDeviceAttributesTopic(String)}
   */
  @Test
  void testIsDeviceAttributesTopic2() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertTrue((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .isDeviceAttributesTopic("v1/devices/me/attributes"));
  }

  /**
   * Method under test: {@link DeviceSessionCtx#isDeviceAttributesTopic(String)}
   */
  @Test
  void testIsDeviceAttributesTopic3() {
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
   * Method under test:
   * {@link DeviceSessionCtx#isDeviceSubscriptionAttributesTopic(String)}
   */
  @Test
  void testIsDeviceSubscriptionAttributesTopic() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertFalse((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .isDeviceSubscriptionAttributesTopic("Topic Name"));
  }

  /**
   * Method under test:
   * {@link DeviceSessionCtx#isDeviceSubscriptionAttributesTopic(String)}
   */
  @Test
  void testIsDeviceSubscriptionAttributesTopic2() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertTrue((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext()))
        .isDeviceSubscriptionAttributesTopic("v1/devices/me/attributes"));
  }

  /**
   * Method under test:
   * {@link DeviceSessionCtx#isDeviceSubscriptionAttributesTopic(String)}
   */
  @Test
  void testIsDeviceSubscriptionAttributesTopic3() {
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
   * Method under test: {@link DeviceSessionCtx#isJsonPayloadType()}
   */
  @Test
  void testIsJsonPayloadType() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertTrue((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).isJsonPayloadType());
  }

  /**
   * Method under test: {@link DeviceSessionCtx#isJsonPayloadType()}
   */
  @Test
  void testIsJsonPayloadType2() {
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
   * Method under test: {@link DeviceSessionCtx#setDeviceProfile(DeviceProfile)}
   */
  @Test
  void testSetDeviceProfile() {
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
   * Method under test: {@link DeviceSessionCtx#setDeviceProfile(DeviceProfile)}
   */
  @Test
  void testSetDeviceProfile2() {
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
   * Method under test: {@link DeviceSessionCtx#getAdaptor(TopicType)}
   */
  @Test
  void testGetAdaptor() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertNull((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getAdaptor(TopicType.V1));
  }

  /**
   * Method under test: {@link DeviceSessionCtx#getAdaptor(TopicType)}
   */
  @Test
  void testGetAdaptor2() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertNull((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getAdaptor(TopicType.V2));
  }

  /**
   * Method under test: {@link DeviceSessionCtx#getAdaptor(TopicType)}
   */
  @Test
  void testGetAdaptor3() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertNull((new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getAdaptor(TopicType.V2_JSON));
  }

  /**
   * Method under test: {@link DeviceSessionCtx#getAdaptor(TopicType)}
   */
  @Test
  void testGetAdaptor4() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertNull(
        (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getAdaptor(TopicType.V2_PROTO));
  }

  /**
   * Method under test: {@link DeviceSessionCtx#getAdaptor(TopicType)}
   */
  @Test
  void testGetAdaptor5() {
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
   * Method under test: {@link DeviceSessionCtx#addToQueue(MqttMessage)}
   */
  @Test
  void testAddToQueue() {
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
   * Method under test: {@link DeviceSessionCtx#addToQueue(MqttMessage)}
   */
  @Test
  void testAddToQueue2() {
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
   * Method under test: {@link DeviceSessionCtx#addToQueue(MqttMessage)}
   */
  @Test
  void testAddToQueue3() {
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
   * Method under test: {@link DeviceSessionCtx#tryProcessQueuedMsgs(Consumer)}
   */
  @Test
  void testTryProcessQueuedMsgs() {
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
   * Method under test: {@link DeviceSessionCtx#getMsgQueueSize()}
   */
  @Test
  void testGetMsgQueueSize() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertEquals(0, (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getMsgQueueSize());
  }

  /**
   * Method under test: {@link DeviceSessionCtx#getMsgQueueSize()}
   */
  @Test
  void testGetMsgQueueSize2() {
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
   * Method under test: {@link DeviceSessionCtx#release()}
   */
  @Test
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
   * Method under test: {@link DeviceSessionCtx#release()}
   */
  @Test
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
   * Method under test: {@link DeviceSessionCtx#release()}
   */
  @Test
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
   * Method under test: {@link DeviceSessionCtx#release()}
   */
  @Test
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
   * Method under test: {@link DeviceSessionCtx#release()}
   */
  @Test
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
   * Method under test: {@link DeviceSessionCtx#getMsgQueueSnapshot()}
   */
  @Test
  void testGetMsgQueueSnapshot() {
    // Arrange
    UUID sessionId = UUID.randomUUID();
    ConcurrentHashMap<MqttTopicMatcher, Integer> mqttQoSMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertTrue(
        (new DeviceSessionCtx(sessionId, mqttQoSMap, new MqttTransportContext())).getMsgQueueSnapshot().isEmpty());
  }

  /**
   * Method under test: {@link DeviceSessionCtx#getMsgQueueSnapshot()}
   */
  @Test
  void testGetMsgQueueSnapshot2() {
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

  /**
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
}
