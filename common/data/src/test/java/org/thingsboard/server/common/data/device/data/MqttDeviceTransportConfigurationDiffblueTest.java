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
package org.thingsboard.server.common.data.device.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceTransportType;

class MqttDeviceTransportConfigurationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MqttDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link MqttDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MqttDeviceTransportConfiguration mqttDeviceTransportConfiguration = new MqttDeviceTransportConfiguration();
    MqttDeviceTransportConfiguration mqttDeviceTransportConfiguration2 = new MqttDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(mqttDeviceTransportConfiguration, mqttDeviceTransportConfiguration2);
    int expectedHashCodeResult = mqttDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, mqttDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Method under test:
   * {@link MqttDeviceTransportConfiguration#put(String, Object)}
   */
  @Test
  void testPut() {
    // Arrange
    MqttDeviceTransportConfiguration mqttDeviceTransportConfiguration = new MqttDeviceTransportConfiguration();

    // Act
    mqttDeviceTransportConfiguration.put("Name", "Value");

    // Assert
    Map<String, Object> properties = mqttDeviceTransportConfiguration.getProperties();
    assertEquals(1, properties.size());
    assertEquals("Value", properties.get("Name"));
  }

  /**
   * Method under test:
   * {@link MqttDeviceTransportConfiguration#put(String, Object)}
   */
  @Test
  void testPut2() {
    // Arrange
    HashMap<String, Object> properties = new HashMap<>();
    properties.computeIfPresent("foo", mock(BiFunction.class));

    MqttDeviceTransportConfiguration mqttDeviceTransportConfiguration = new MqttDeviceTransportConfiguration();
    mqttDeviceTransportConfiguration.setProperties(properties);

    // Act
    mqttDeviceTransportConfiguration.put("Name", "Value");

    // Assert
    Map<String, Object> properties2 = mqttDeviceTransportConfiguration.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Value", properties2.get("Name"));
    assertSame(properties, properties2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MqttDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link MqttDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MqttDeviceTransportConfiguration mqttDeviceTransportConfiguration = new MqttDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(mqttDeviceTransportConfiguration, mqttDeviceTransportConfiguration);
    int expectedHashCodeResult = mqttDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, mqttDeviceTransportConfiguration.hashCode());
  }

  /**
   * Method under test: {@link MqttDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MqttDeviceTransportConfiguration mqttDeviceTransportConfiguration = new MqttDeviceTransportConfiguration();
    mqttDeviceTransportConfiguration.put("Name", "Value");

    // Act and Assert
    assertNotEquals(mqttDeviceTransportConfiguration, new MqttDeviceTransportConfiguration());
  }

  /**
   * Method under test: {@link MqttDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MqttDeviceTransportConfiguration mqttDeviceTransportConfiguration = new MqttDeviceTransportConfiguration();
    mqttDeviceTransportConfiguration.put("Name", new MqttDeviceTransportConfiguration());

    MqttDeviceTransportConfiguration mqttDeviceTransportConfiguration2 = new MqttDeviceTransportConfiguration();
    mqttDeviceTransportConfiguration2.put("Name", "Value");

    // Act and Assert
    assertNotEquals(mqttDeviceTransportConfiguration, mqttDeviceTransportConfiguration2);
  }

  /**
   * Method under test: {@link MqttDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttDeviceTransportConfiguration(), null);
  }

  /**
   * Method under test: {@link MqttDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttDeviceTransportConfiguration(), "Different type to MqttDeviceTransportConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link MqttDeviceTransportConfiguration}
   *   <li>{@link MqttDeviceTransportConfiguration#setProperties(Map)}
   *   <li>{@link MqttDeviceTransportConfiguration#toString()}
   *   <li>{@link MqttDeviceTransportConfiguration#getProperties()}
   *   <li>{@link MqttDeviceTransportConfiguration#getType()}
   *   <li>{@link MqttDeviceTransportConfiguration#properties()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    MqttDeviceTransportConfiguration actualMqttDeviceTransportConfiguration = new MqttDeviceTransportConfiguration();
    HashMap<String, Object> properties = new HashMap<>();
    actualMqttDeviceTransportConfiguration.setProperties(properties);
    String actualToStringResult = actualMqttDeviceTransportConfiguration.toString();
    Map<String, Object> actualProperties = actualMqttDeviceTransportConfiguration.getProperties();
    DeviceTransportType actualType = actualMqttDeviceTransportConfiguration.getType();
    Map<String, Object> actualPropertiesResult = actualMqttDeviceTransportConfiguration.properties();

    // Assert that nothing has changed
    assertEquals("MqttDeviceTransportConfiguration(properties={})", actualToStringResult);
    assertEquals(DeviceTransportType.MQTT, actualType);
    assertTrue(actualProperties.isEmpty());
    assertSame(properties, actualProperties);
    assertSame(properties, actualPropertiesResult);
  }
}
