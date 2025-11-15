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
import org.thingsboard.server.common.data.DeviceProfileType;

class DefaultDeviceConfigurationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultDeviceConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultDeviceConfiguration defaultDeviceConfiguration = new DefaultDeviceConfiguration();
    DefaultDeviceConfiguration defaultDeviceConfiguration2 = new DefaultDeviceConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceConfiguration, defaultDeviceConfiguration2);
    int expectedHashCodeResult = defaultDeviceConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultDeviceConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultDeviceConfiguration defaultDeviceConfiguration = new DefaultDeviceConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceConfiguration, defaultDeviceConfiguration);
    int expectedHashCodeResult = defaultDeviceConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceConfiguration.hashCode());
  }

  /**
   * Method under test: {@link DefaultDeviceConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceConfiguration(), 1);
  }

  /**
   * Method under test: {@link DefaultDeviceConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceConfiguration(), null);
  }

  /**
   * Method under test: {@link DefaultDeviceConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceConfiguration(), "Different type to DefaultDeviceConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link DefaultDeviceConfiguration}
   *   <li>{@link DefaultDeviceConfiguration#toString()}
   *   <li>{@link DefaultDeviceConfiguration#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultDeviceConfiguration actualDefaultDeviceConfiguration = new DefaultDeviceConfiguration();
    String actualToStringResult = actualDefaultDeviceConfiguration.toString();

    // Assert
    assertEquals("DefaultDeviceConfiguration()", actualToStringResult);
    assertEquals(DeviceProfileType.DEFAULT, actualDefaultDeviceConfiguration.getType());
  }
}
