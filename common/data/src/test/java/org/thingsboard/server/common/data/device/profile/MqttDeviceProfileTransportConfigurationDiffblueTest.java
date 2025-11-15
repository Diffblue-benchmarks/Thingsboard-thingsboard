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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.TransportPayloadType;

class MqttDeviceProfileTransportConfigurationDiffblueTest {
  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#getTransportPayloadTypeConfiguration()}.
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#getTransportPayloadTypeConfiguration()}
   */
  @Test
  @DisplayName("Test getTransportPayloadTypeConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TransportPayloadTypeConfiguration MqttDeviceProfileTransportConfiguration.getTransportPayloadTypeConfiguration()"})
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
   * Test {@link MqttDeviceProfileTransportConfiguration#getDeviceTelemetryTopic()}.
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#getDeviceTelemetryTopic()}
   */
  @Test
  @DisplayName("Test getDeviceTelemetryTopic()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MqttDeviceProfileTransportConfiguration.getDeviceTelemetryTopic()"})
  void testGetDeviceTelemetryTopic() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setDeviceTelemetryTopic(null);

    // Act and Assert
    assertEquals(MqttTopics.DEVICE_TELEMETRY_TOPIC, mqttDeviceProfileTransportConfiguration.getDeviceTelemetryTopic());
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#getDeviceTelemetryTopic()}.
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#getDeviceTelemetryTopic()}
   */
  @Test
  @DisplayName("Test getDeviceTelemetryTopic()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MqttDeviceProfileTransportConfiguration.getDeviceTelemetryTopic()"})
  void testGetDeviceTelemetryTopic2() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setDeviceTelemetryTopic("");

    // Act and Assert
    assertEquals(MqttTopics.DEVICE_TELEMETRY_TOPIC, mqttDeviceProfileTransportConfiguration.getDeviceTelemetryTopic());
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#getDeviceTelemetryTopic()}.
   * <ul>
   *   <li>Given {@link MqttDeviceProfileTransportConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#getDeviceTelemetryTopic()}
   */
  @Test
  @DisplayName("Test getDeviceTelemetryTopic(); given MqttDeviceProfileTransportConfiguration (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MqttDeviceProfileTransportConfiguration.getDeviceTelemetryTopic()"})
  void testGetDeviceTelemetryTopic_givenMqttDeviceProfileTransportConfiguration() {
    // Arrange, Act and Assert
    assertEquals(MqttTopics.DEVICE_TELEMETRY_TOPIC,
        (new MqttDeviceProfileTransportConfiguration()).getDeviceTelemetryTopic());
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesTopic()}.
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesTopic()}
   */
  @Test
  @DisplayName("Test getDeviceAttributesTopic()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MqttDeviceProfileTransportConfiguration.getDeviceAttributesTopic()"})
  void testGetDeviceAttributesTopic() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setDeviceAttributesTopic(null);

    // Act and Assert
    assertEquals(MqttTopics.DEVICE_ATTRIBUTES_TOPIC,
        mqttDeviceProfileTransportConfiguration.getDeviceAttributesTopic());
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesTopic()}.
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesTopic()}
   */
  @Test
  @DisplayName("Test getDeviceAttributesTopic()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MqttDeviceProfileTransportConfiguration.getDeviceAttributesTopic()"})
  void testGetDeviceAttributesTopic2() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setDeviceAttributesTopic("");

    // Act and Assert
    assertEquals(MqttTopics.DEVICE_ATTRIBUTES_TOPIC,
        mqttDeviceProfileTransportConfiguration.getDeviceAttributesTopic());
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesTopic()}.
   * <ul>
   *   <li>Given {@link MqttDeviceProfileTransportConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesTopic()}
   */
  @Test
  @DisplayName("Test getDeviceAttributesTopic(); given MqttDeviceProfileTransportConfiguration (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MqttDeviceProfileTransportConfiguration.getDeviceAttributesTopic()"})
  void testGetDeviceAttributesTopic_givenMqttDeviceProfileTransportConfiguration() {
    // Arrange, Act and Assert
    assertEquals(MqttTopics.DEVICE_ATTRIBUTES_TOPIC,
        (new MqttDeviceProfileTransportConfiguration()).getDeviceAttributesTopic());
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesSubscribeTopic()}.
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesSubscribeTopic()}
   */
  @Test
  @DisplayName("Test getDeviceAttributesSubscribeTopic()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MqttDeviceProfileTransportConfiguration.getDeviceAttributesSubscribeTopic()"})
  void testGetDeviceAttributesSubscribeTopic() {
    // Arrange, Act and Assert
    assertEquals(MqttTopics.DEVICE_ATTRIBUTES_TOPIC,
        (new MqttDeviceProfileTransportConfiguration()).getDeviceAttributesSubscribeTopic());
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesSubscribeTopic()}.
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesSubscribeTopic()}
   */
  @Test
  @DisplayName("Test getDeviceAttributesSubscribeTopic()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MqttDeviceProfileTransportConfiguration.getDeviceAttributesSubscribeTopic()"})
  void testGetDeviceAttributesSubscribeTopic2() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setDeviceAttributesSubscribeTopic(null);

    // Act and Assert
    assertEquals(MqttTopics.DEVICE_ATTRIBUTES_TOPIC,
        mqttDeviceProfileTransportConfiguration.getDeviceAttributesSubscribeTopic());
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesSubscribeTopic()}.
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#getDeviceAttributesSubscribeTopic()}
   */
  @Test
  @DisplayName("Test getDeviceAttributesSubscribeTopic()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String MqttDeviceProfileTransportConfiguration.getDeviceAttributesSubscribeTopic()"})
  void testGetDeviceAttributesSubscribeTopic3() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setDeviceAttributesSubscribeTopic("");

    // Act and Assert
    assertEquals(MqttTopics.DEVICE_ATTRIBUTES_TOPIC,
        mqttDeviceProfileTransportConfiguration.getDeviceAttributesSubscribeTopic());
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#equals(Object)}, and {@link MqttDeviceProfileTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttDeviceProfileTransportConfiguration.equals(Object)",
      "int MqttDeviceProfileTransportConfiguration.hashCode()"})
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
   * Test {@link MqttDeviceProfileTransportConfiguration#equals(Object)}, and {@link MqttDeviceProfileTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttDeviceProfileTransportConfiguration.equals(Object)",
      "int MqttDeviceProfileTransportConfiguration.hashCode()"})
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
   * Test {@link MqttDeviceProfileTransportConfiguration#equals(Object)}, and {@link MqttDeviceProfileTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttDeviceProfileTransportConfiguration.equals(Object)",
      "int MqttDeviceProfileTransportConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(mqttDeviceProfileTransportConfiguration, mqttDeviceProfileTransportConfiguration);
    int expectedHashCodeResult = mqttDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, mqttDeviceProfileTransportConfiguration.hashCode());
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttDeviceProfileTransportConfiguration.equals(Object)",
      "int MqttDeviceProfileTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();

    // Act and Assert
    assertNotEquals(mqttDeviceProfileTransportConfiguration, new JsonTransportPayloadConfiguration());
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttDeviceProfileTransportConfiguration.equals(Object)",
      "int MqttDeviceProfileTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setDeviceAttributesTopic(MqttTopics.DEVICE_TELEMETRY_TOPIC);

    // Act and Assert
    assertNotEquals(mqttDeviceProfileTransportConfiguration, new MqttDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttDeviceProfileTransportConfiguration.equals(Object)",
      "int MqttDeviceProfileTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setDeviceAttributesSubscribeTopic(MqttTopics.DEVICE_TELEMETRY_TOPIC);

    // Act and Assert
    assertNotEquals(mqttDeviceProfileTransportConfiguration, new MqttDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttDeviceProfileTransportConfiguration.equals(Object)",
      "int MqttDeviceProfileTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));

    // Act and Assert
    assertNotEquals(mqttDeviceProfileTransportConfiguration, new MqttDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttDeviceProfileTransportConfiguration.equals(Object)",
      "int MqttDeviceProfileTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setSparkplug(true);

    // Act and Assert
    assertNotEquals(mqttDeviceProfileTransportConfiguration, new MqttDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttDeviceProfileTransportConfiguration.equals(Object)",
      "int MqttDeviceProfileTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setSparkplugAttributesMetricNames(new HashSet<>());

    // Act and Assert
    assertNotEquals(mqttDeviceProfileTransportConfiguration, new MqttDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttDeviceProfileTransportConfiguration.equals(Object)",
      "int MqttDeviceProfileTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setSendAckOnValidationException(true);

    // Act and Assert
    assertNotEquals(mqttDeviceProfileTransportConfiguration, new MqttDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttDeviceProfileTransportConfiguration.equals(Object)",
      "int MqttDeviceProfileTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();

    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration2 = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration2.setSparkplugAttributesMetricNames(new HashSet<>());

    // Act and Assert
    assertNotEquals(mqttDeviceProfileTransportConfiguration, mqttDeviceProfileTransportConfiguration2);
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttDeviceProfileTransportConfiguration.equals(Object)",
      "int MqttDeviceProfileTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MqttDeviceProfileTransportConfiguration mqttDeviceProfileTransportConfiguration = new MqttDeviceProfileTransportConfiguration();
    mqttDeviceProfileTransportConfiguration.setDeviceTelemetryTopic("Device Telemetry Topic");

    // Act and Assert
    assertNotEquals(mqttDeviceProfileTransportConfiguration, new MqttDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttDeviceProfileTransportConfiguration.equals(Object)",
      "int MqttDeviceProfileTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttDeviceProfileTransportConfiguration(), null);
  }

  /**
   * Test {@link MqttDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttDeviceProfileTransportConfiguration.equals(Object)",
      "int MqttDeviceProfileTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttDeviceProfileTransportConfiguration(),
        "Different type to MqttDeviceProfileTransportConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MqttDeviceProfileTransportConfiguration}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#setDeviceAttributesSubscribeTopic(String)}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#setDeviceAttributesTopic(String)}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#setDeviceTelemetryTopic(String)}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#setSendAckOnValidationException(boolean)}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#setSparkplug(boolean)}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#setSparkplugAttributesMetricNames(Set)}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#setTransportPayloadTypeConfiguration(TransportPayloadTypeConfiguration)}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#toString()}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#getSparkplugAttributesMetricNames()}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#getType()}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#isSendAckOnValidationException()}
   *   <li>{@link MqttDeviceProfileTransportConfiguration#isSparkplug()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttDeviceProfileTransportConfiguration.<init>()",
      "Set MqttDeviceProfileTransportConfiguration.getSparkplugAttributesMetricNames()",
      "DeviceTransportType MqttDeviceProfileTransportConfiguration.getType()",
      "boolean MqttDeviceProfileTransportConfiguration.isSendAckOnValidationException()",
      "boolean MqttDeviceProfileTransportConfiguration.isSparkplug()",
      "void MqttDeviceProfileTransportConfiguration.setDeviceAttributesSubscribeTopic(String)",
      "void MqttDeviceProfileTransportConfiguration.setDeviceAttributesTopic(String)",
      "void MqttDeviceProfileTransportConfiguration.setDeviceTelemetryTopic(String)",
      "void MqttDeviceProfileTransportConfiguration.setSendAckOnValidationException(boolean)",
      "void MqttDeviceProfileTransportConfiguration.setSparkplug(boolean)",
      "void MqttDeviceProfileTransportConfiguration.setSparkplugAttributesMetricNames(Set)",
      "void MqttDeviceProfileTransportConfiguration.setTransportPayloadTypeConfiguration(TransportPayloadTypeConfiguration)",
      "String MqttDeviceProfileTransportConfiguration.toString()"})
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

    // Assert
    assertEquals(DeviceTransportType.MQTT, actualType);
    assertTrue(actualSparkplugAttributesMetricNames.isEmpty());
    assertTrue(actualIsSendAckOnValidationExceptionResult);
    assertTrue(actualIsSparkplugResult);
    assertSame(sparkplugAttributesMetricNames, actualSparkplugAttributesMetricNames);
  }
}
