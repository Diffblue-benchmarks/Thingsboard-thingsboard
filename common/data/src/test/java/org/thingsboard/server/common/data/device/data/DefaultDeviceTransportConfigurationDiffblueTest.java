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
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceTransportType;

class DefaultDeviceTransportConfigurationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultDeviceTransportConfiguration defaultDeviceTransportConfiguration = new DefaultDeviceTransportConfiguration();
    DefaultDeviceTransportConfiguration defaultDeviceTransportConfiguration2 = new DefaultDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceTransportConfiguration, defaultDeviceTransportConfiguration2);
    int expectedHashCodeResult = defaultDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultDeviceTransportConfiguration defaultDeviceTransportConfiguration = new DefaultDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceTransportConfiguration, defaultDeviceTransportConfiguration);
    int expectedHashCodeResult = defaultDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceTransportConfiguration.hashCode());
  }

  /**
   * Method under test: {@link DefaultDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceTransportConfiguration(), 1);
  }

  /**
   * Method under test: {@link DefaultDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceTransportConfiguration(), null);
  }

  /**
   * Method under test: {@link DefaultDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceTransportConfiguration(), "Different type to DefaultDeviceTransportConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link DefaultDeviceTransportConfiguration}
   *   <li>{@link DefaultDeviceTransportConfiguration#toString()}
   *   <li>{@link DefaultDeviceTransportConfiguration#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultDeviceTransportConfiguration actualDefaultDeviceTransportConfiguration = new DefaultDeviceTransportConfiguration();
    String actualToStringResult = actualDefaultDeviceTransportConfiguration.toString();

    // Assert
    assertEquals("DefaultDeviceTransportConfiguration()", actualToStringResult);
    assertEquals(DeviceTransportType.DEFAULT, actualDefaultDeviceTransportConfiguration.getType());
  }
}
