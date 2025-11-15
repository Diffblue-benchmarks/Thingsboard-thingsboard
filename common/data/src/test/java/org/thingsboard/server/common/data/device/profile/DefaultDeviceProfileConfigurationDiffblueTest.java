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
import org.thingsboard.server.common.data.DeviceProfileType;

class DefaultDeviceProfileConfigurationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultDeviceProfileConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceProfileConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultDeviceProfileConfiguration defaultDeviceProfileConfiguration = new DefaultDeviceProfileConfiguration();
    DefaultDeviceProfileConfiguration defaultDeviceProfileConfiguration2 = new DefaultDeviceProfileConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceProfileConfiguration, defaultDeviceProfileConfiguration2);
    int expectedHashCodeResult = defaultDeviceProfileConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceProfileConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultDeviceProfileConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceProfileConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultDeviceProfileConfiguration defaultDeviceProfileConfiguration = new DefaultDeviceProfileConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceProfileConfiguration, defaultDeviceProfileConfiguration);
    int expectedHashCodeResult = defaultDeviceProfileConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceProfileConfiguration.hashCode());
  }

  /**
   * Method under test: {@link DefaultDeviceProfileConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceProfileConfiguration(), 1);
  }

  /**
   * Method under test: {@link DefaultDeviceProfileConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceProfileConfiguration(), null);
  }

  /**
   * Method under test: {@link DefaultDeviceProfileConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceProfileConfiguration(), "Different type to DefaultDeviceProfileConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link DefaultDeviceProfileConfiguration}
   *   <li>{@link DefaultDeviceProfileConfiguration#toString()}
   *   <li>{@link DefaultDeviceProfileConfiguration#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultDeviceProfileConfiguration actualDefaultDeviceProfileConfiguration = new DefaultDeviceProfileConfiguration();
    String actualToStringResult = actualDefaultDeviceProfileConfiguration.toString();

    // Assert
    assertEquals("DefaultDeviceProfileConfiguration()", actualToStringResult);
    assertEquals(DeviceProfileType.DEFAULT, actualDefaultDeviceProfileConfiguration.getType());
  }
}
