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
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceTransportType;

class DefaultDeviceProfileTransportConfigurationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultDeviceProfileTransportConfiguration defaultDeviceProfileTransportConfiguration = new DefaultDeviceProfileTransportConfiguration();
    DefaultDeviceProfileTransportConfiguration defaultDeviceProfileTransportConfiguration2 = new DefaultDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceProfileTransportConfiguration, defaultDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = defaultDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultDeviceProfileTransportConfiguration defaultDeviceProfileTransportConfiguration = new DefaultDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceProfileTransportConfiguration, defaultDeviceProfileTransportConfiguration);
    int expectedHashCodeResult = defaultDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceProfileTransportConfiguration.hashCode());
  }

  /**
   * Method under test:
   * {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceProfileTransportConfiguration(), 1);
  }

  /**
   * Method under test:
   * {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceProfileTransportConfiguration(), null);
  }

  /**
   * Method under test:
   * {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceProfileTransportConfiguration(),
        "Different type to DefaultDeviceProfileTransportConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link DefaultDeviceProfileTransportConfiguration}
   *   <li>{@link DefaultDeviceProfileTransportConfiguration#toString()}
   *   <li>{@link DefaultDeviceProfileTransportConfiguration#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultDeviceProfileTransportConfiguration actualDefaultDeviceProfileTransportConfiguration = new DefaultDeviceProfileTransportConfiguration();
    String actualToStringResult = actualDefaultDeviceProfileTransportConfiguration.toString();

    // Assert
    assertEquals("DefaultDeviceProfileTransportConfiguration()", actualToStringResult);
    assertEquals(DeviceTransportType.DEFAULT, actualDefaultDeviceProfileTransportConfiguration.getType());
  }
}
