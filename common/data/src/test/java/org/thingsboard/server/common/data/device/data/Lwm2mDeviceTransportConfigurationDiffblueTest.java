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

class Lwm2mDeviceTransportConfigurationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Lwm2mDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link Lwm2mDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Lwm2mDeviceTransportConfiguration lwm2mDeviceTransportConfiguration = new Lwm2mDeviceTransportConfiguration();
    Lwm2mDeviceTransportConfiguration lwm2mDeviceTransportConfiguration2 = new Lwm2mDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(lwm2mDeviceTransportConfiguration, lwm2mDeviceTransportConfiguration2);
    int expectedHashCodeResult = lwm2mDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, lwm2mDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Method under test:
   * {@link Lwm2mDeviceTransportConfiguration#put(String, Object)}
   */
  @Test
  void testPut() {
    // Arrange
    Lwm2mDeviceTransportConfiguration lwm2mDeviceTransportConfiguration = new Lwm2mDeviceTransportConfiguration();

    // Act
    lwm2mDeviceTransportConfiguration.put("Name", "Value");

    // Assert
    Map<String, Object> properties = lwm2mDeviceTransportConfiguration.getProperties();
    assertEquals(1, properties.size());
    assertEquals("Value", properties.get("Name"));
  }

  /**
   * Method under test:
   * {@link Lwm2mDeviceTransportConfiguration#put(String, Object)}
   */
  @Test
  void testPut2() {
    // Arrange
    HashMap<String, Object> properties = new HashMap<>();
    properties.computeIfPresent("foo", mock(BiFunction.class));

    Lwm2mDeviceTransportConfiguration lwm2mDeviceTransportConfiguration = new Lwm2mDeviceTransportConfiguration();
    lwm2mDeviceTransportConfiguration.setProperties(properties);

    // Act
    lwm2mDeviceTransportConfiguration.put("Name", "Value");

    // Assert
    Map<String, Object> properties2 = lwm2mDeviceTransportConfiguration.getProperties();
    assertEquals(1, properties2.size());
    assertEquals("Value", properties2.get("Name"));
    assertSame(properties, properties2);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Lwm2mDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link Lwm2mDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Lwm2mDeviceTransportConfiguration lwm2mDeviceTransportConfiguration = new Lwm2mDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(lwm2mDeviceTransportConfiguration, lwm2mDeviceTransportConfiguration);
    int expectedHashCodeResult = lwm2mDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, lwm2mDeviceTransportConfiguration.hashCode());
  }

  /**
   * Method under test: {@link Lwm2mDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Lwm2mDeviceTransportConfiguration lwm2mDeviceTransportConfiguration = new Lwm2mDeviceTransportConfiguration();
    lwm2mDeviceTransportConfiguration.put("Name", "Value");

    // Act and Assert
    assertNotEquals(lwm2mDeviceTransportConfiguration, new Lwm2mDeviceTransportConfiguration());
  }

  /**
   * Method under test: {@link Lwm2mDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Lwm2mDeviceTransportConfiguration(), null);
  }

  /**
   * Method under test: {@link Lwm2mDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Lwm2mDeviceTransportConfiguration(), "Different type to Lwm2mDeviceTransportConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link Lwm2mDeviceTransportConfiguration}
   *   <li>{@link Lwm2mDeviceTransportConfiguration#setProperties(Map)}
   *   <li>{@link Lwm2mDeviceTransportConfiguration#toString()}
   *   <li>{@link Lwm2mDeviceTransportConfiguration#getProperties()}
   *   <li>{@link Lwm2mDeviceTransportConfiguration#getType()}
   *   <li>{@link Lwm2mDeviceTransportConfiguration#properties()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Lwm2mDeviceTransportConfiguration actualLwm2mDeviceTransportConfiguration = new Lwm2mDeviceTransportConfiguration();
    HashMap<String, Object> properties = new HashMap<>();
    actualLwm2mDeviceTransportConfiguration.setProperties(properties);
    String actualToStringResult = actualLwm2mDeviceTransportConfiguration.toString();
    Map<String, Object> actualProperties = actualLwm2mDeviceTransportConfiguration.getProperties();
    DeviceTransportType actualType = actualLwm2mDeviceTransportConfiguration.getType();
    Map<String, Object> actualPropertiesResult = actualLwm2mDeviceTransportConfiguration.properties();

    // Assert that nothing has changed
    assertEquals("Lwm2mDeviceTransportConfiguration(properties={})", actualToStringResult);
    assertEquals(DeviceTransportType.LWM2M, actualType);
    assertTrue(actualProperties.isEmpty());
    assertSame(properties, actualProperties);
    assertSame(properties, actualPropertiesResult);
  }
}
