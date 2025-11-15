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
package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.TransportPayloadType;

class MqttDeviceProfileTransportConfigurationDiffblueTest {
  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#getTransportPayloadTypeConfiguration()}
   */
  @Test
  void testGetTransportPayloadTypeConfiguration() {
    // Arrange and Act
    TransportPayloadTypeConfiguration actualTransportPayloadTypeConfiguration = (new MqttDeviceProfileTransportConfiguration())
        .getTransportPayloadTypeConfiguration();
    TransportPayloadType actualTransportPayloadType = actualTransportPayloadTypeConfiguration.getTransportPayloadType();

    // Assert
    assertTrue(actualTransportPayloadTypeConfiguration instanceof JsonTransportPayloadConfiguration);
    assertEquals(TransportPayloadType.JSON, actualTransportPayloadTypeConfiguration.getTransportPayloadType());
    assertEquals(TransportPayloadType.JSON, actualTransportPayloadType);
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#getTransportPayloadTypeConfiguration()}
   */
  @Test
  void testGetTransportPayloadTypeConfiguration2() {
    // Arrange
    TransportPayloadTypeConfiguration transportPayloadTypeConfiguration = mock(TransportPayloadTypeConfiguration.class);
    when(transportPayloadTypeConfiguration.getTransportPayloadType()).thenReturn(TransportPayloadType.JSON);

    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setTransportPayloadTypeConfiguration(transportPayloadTypeConfiguration);

    // Act
    TransportPayloadType actualTransportPayloadType = mqttDeviceProfileTransportConfiguration
        .getTransportPayloadTypeConfiguration()
        .getTransportPayloadType();

    // Assert
    verify(transportPayloadTypeConfiguration).getTransportPayloadType();
    assertEquals(TransportPayloadType.JSON, actualTransportPayloadType);
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#getDeviceTelemetryTopic()}
   */
  @Test
  void testGetDeviceTelemetryTopic() {
    // Arrange, Act and Assert
    assertEquals(MqttTopics.DEVICE_TELEMETRY_TOPIC,
        (new MqttDeviceProfileTransportConfiguration()).getDeviceTelemetryTopic());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#getDeviceTelemetryTopic()}
   */
  @Test
  void testGetDeviceTelemetryTopic2() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setDeviceTelemetryTopic(null);

    // Act and Assert
    assertEquals(MqttTopics.DEVICE_TELEMETRY_TOPIC, mqttDeviceProfileTransportConfiguration.getDeviceTelemetryTopic());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#getDeviceTelemetryTopic()}
   */
  @Test
  void testGetDeviceTelemetryTopic3() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setDeviceTelemetryTopic("");

    // Act and Assert
    assertEquals(MqttTopics.DEVICE_TELEMETRY_TOPIC, mqttDeviceProfileTransportConfiguration.getDeviceTelemetryTopic());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#getDeviceTelemetryTopic()}
   */
  @Test
  void testGetDeviceTelemetryTopic4() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));

    // Act and Assert
    assertEquals(MqttTopics.DEVICE_TELEMETRY_TOPIC, mqttDeviceProfileTransportConfiguration.getDeviceTelemetryTopic());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesTopic()}
   */
  @Test
  void testGetDeviceAttributesTopic() {
    // Arrange, Act and Assert
    assertEquals(MqttTopics.DEVICE_ATTRIBUTES_TOPIC,
        (new MqttDeviceProfileTransportConfiguration()).getDeviceAttributesTopic());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesTopic()}
   */
  @Test
  void testGetDeviceAttributesTopic2() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setDeviceAttributesTopic(null);

    // Act and Assert
    assertEquals(MqttTopics.DEVICE_ATTRIBUTES_TOPIC,
        mqttDeviceProfileTransportConfiguration.getDeviceAttributesTopic());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesTopic()}
   */
  @Test
  void testGetDeviceAttributesTopic3() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setDeviceAttributesTopic("");

    // Act and Assert
    assertEquals(MqttTopics.DEVICE_ATTRIBUTES_TOPIC,
        mqttDeviceProfileTransportConfiguration.getDeviceAttributesTopic());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesTopic()}
   */
  @Test
  void testGetDeviceAttributesTopic4() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));

    // Act and Assert
    assertEquals(MqttTopics.DEVICE_ATTRIBUTES_TOPIC,
        mqttDeviceProfileTransportConfiguration.getDeviceAttributesTopic());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesSubscribeTopic()}
   */
  @Test
  void testGetDeviceAttributesSubscribeTopic() {
    // Arrange, Act and Assert
    assertEquals(MqttTopics.DEVICE_ATTRIBUTES_TOPIC,
        (new MqttDeviceProfileTransportConfiguration()).getDeviceAttributesSubscribeTopic());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesSubscribeTopic()}
   */
  @Test
  void testGetDeviceAttributesSubscribeTopic2() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setDeviceAttributesSubscribeTopic(null);

    // Act and Assert
    assertEquals(MqttTopics.DEVICE_ATTRIBUTES_TOPIC,
        mqttDeviceProfileTransportConfiguration.getDeviceAttributesSubscribeTopic());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesSubscribeTopic()}
   */
  @Test
  void testGetDeviceAttributesSubscribeTopic3() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setDeviceAttributesSubscribeTopic("");

    // Act and Assert
    assertEquals(MqttTopics.DEVICE_ATTRIBUTES_TOPIC,
        mqttDeviceProfileTransportConfiguration.getDeviceAttributesSubscribeTopic());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesSubscribeTopic()}
   */
  @Test
  void testGetDeviceAttributesSubscribeTopic4() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));

    // Act and Assert
    assertEquals(MqttTopics.DEVICE_ATTRIBUTES_TOPIC,
        mqttDeviceProfileTransportConfiguration.getDeviceAttributesSubscribeTopic());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration2 = new MqttDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(mqttDeviceProfileTransportConfiguration, mqttDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = mqttDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, mqttDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setSparkplugAttributesMetricNames(new HashSet<>());

    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration2 = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration2.setSparkplugAttributesMetricNames(new HashSet<>());

    // Act and Assert
    assertEquals(mqttDeviceProfileTransportConfiguration, mqttDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = mqttDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, mqttDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(mqttDeviceProfileTransportConfiguration, mqttDeviceProfileTransportConfiguration);
    int expectedHashCodeResult = mqttDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, mqttDeviceProfileTransportConfiguration.hashCode());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();

    // Act and Assert
    assertNotEquals(mqttDeviceProfileTransportConfiguration, new JsonTransportPayloadConfiguration());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttDeviceProfileTransportConfiguration(), mock(JsonTransportPayloadConfiguration.class));
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setDeviceAttributesTopic(MqttTopics.DEVICE_TELEMETRY_TOPIC);

    // Act and Assert
    assertNotEquals(mqttDeviceProfileTransportConfiguration, new MqttDeviceProfileTransportConfiguration());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setDeviceAttributesSubscribeTopic(MqttTopics.DEVICE_TELEMETRY_TOPIC);

    // Act and Assert
    assertNotEquals(mqttDeviceProfileTransportConfiguration, new MqttDeviceProfileTransportConfiguration());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));

    // Act and Assert
    assertNotEquals(mqttDeviceProfileTransportConfiguration, new MqttDeviceProfileTransportConfiguration());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setSparkplug(true);

    // Act and Assert
    assertNotEquals(mqttDeviceProfileTransportConfiguration, new MqttDeviceProfileTransportConfiguration());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setSparkplugAttributesMetricNames(new HashSet<>());

    // Act and Assert
    assertNotEquals(mqttDeviceProfileTransportConfiguration, new MqttDeviceProfileTransportConfiguration());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setSendAckOnValidationException(true);

    // Act and Assert
    assertNotEquals(mqttDeviceProfileTransportConfiguration, new MqttDeviceProfileTransportConfiguration());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();

    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration2 = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration2.setSparkplugAttributesMetricNames(new HashSet<>());

    // Act and Assert
    assertNotEquals(mqttDeviceProfileTransportConfiguration, mqttDeviceProfileTransportConfiguration2);
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setDeviceTelemetryTopic("Device Telemetry Topic");

    // Act and Assert
    assertNotEquals(mqttDeviceProfileTransportConfiguration, new MqttDeviceProfileTransportConfiguration());
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttDeviceProfileTransportConfiguration(), null);
  }

  /**
   * Method under test:
   * {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttDeviceProfileTransportConfiguration(),
        "Different type to MqttDeviceProfileTransportConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link MqttDeviceProfileTransportConfiguration}
   *   <li>
   * {@link MqttDeviceProfileTransportConfiguration#setDeviceAttributesSubscribeTopic(String)}
   *   <li>
   * {@link MqttDeviceProfileTransportConfiguration#setDeviceAttributesTopic(String)}
   *   <li>
   * {@link MqttDeviceProfileTransportConfiguration#setDeviceTelemetryTopic(String)}
   *   <li>
   * {@link MqttDeviceProfileTransportConfiguration#setSendAckOnValidationException(boolean)}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#setSparkplug(boolean)}
   *   <li>
   * {@link MqttDeviceProfileTransportConfiguration#setSparkplugAttributesMetricNames(Set)}
   *   <li>
   * {@link MqttDeviceProfileTransportConfiguration#setTransportPayloadTypeConfiguration(TransportPayloadTypeConfiguration)}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#toString()}
   *   <li>
   * {@link MqttDeviceProfileTransportConfiguration#getSparkplugAttributesMetricNames()}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#getType()}
   *   <li>
   * {@link MqttDeviceProfileTransportConfiguration#isSendAckOnValidationException()}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#isSparkplug()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    MqttDeviceProfileTransportConfiguration actualMqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    actualMqttDeviceProfileTransportConfiguration
        .setDeviceAttributesSubscribeTopic("Device Attributes Subscribe Topic");
    actualMqttDeviceProfileTransportConfiguration.setDeviceAttributesTopic("Device Attributes Topic");
    actualMqttDeviceProfileTransportConfiguration.setDeviceTelemetryTopic("Device Telemetry Topic");
    actualMqttDeviceProfileTransportConfiguration.setSendAckOnValidationException(true);
    actualMqttDeviceProfileTransportConfiguration.setSparkplug(true);
    HashSet<String> sparkplugAttributesMetricNames = new HashSet<>();
    actualMqttDeviceProfileTransportConfiguration.setSparkplugAttributesMetricNames(sparkplugAttributesMetricNames);
    actualMqttDeviceProfileTransportConfiguration
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));
    actualMqttDeviceProfileTransportConfiguration.toString();
    Set<String> actualSparkplugAttributesMetricNames = actualMqttDeviceProfileTransportConfiguration
        .getSparkplugAttributesMetricNames();
    DeviceTransportType actualType = actualMqttDeviceProfileTransportConfiguration.getType();
    boolean actualIsSendAckOnValidationExceptionResult = actualMqttDeviceProfileTransportConfiguration
        .isSendAckOnValidationException();
    boolean actualIsSparkplugResult = actualMqttDeviceProfileTransportConfiguration.isSparkplug();

    // Assert that nothing has changed
    assertEquals(DeviceTransportType.MQTT, actualType);
    assertTrue(actualSparkplugAttributesMetricNames.isEmpty());
    assertTrue(actualIsSendAckOnValidationExceptionResult);
    assertTrue(actualIsSparkplugResult);
    assertSame(sparkplugAttributesMetricNames, actualSparkplugAttributesMetricNames);
  }
}
