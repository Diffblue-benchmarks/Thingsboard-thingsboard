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
import org.thingsboard.server.common.data.CoapDeviceType;

class EfentoCoapDeviceTypeConfigurationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EfentoCoapDeviceTypeConfiguration#equals(Object)}
   *   <li>{@link EfentoCoapDeviceTypeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EfentoCoapDeviceTypeConfiguration efentoCoapDeviceTypeConfiguration = new EfentoCoapDeviceTypeConfiguration();
    EfentoCoapDeviceTypeConfiguration efentoCoapDeviceTypeConfiguration2 = new EfentoCoapDeviceTypeConfiguration();

    // Act and Assert
    assertEquals(efentoCoapDeviceTypeConfiguration, efentoCoapDeviceTypeConfiguration2);
    int expectedHashCodeResult = efentoCoapDeviceTypeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, efentoCoapDeviceTypeConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EfentoCoapDeviceTypeConfiguration#equals(Object)}
   *   <li>{@link EfentoCoapDeviceTypeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EfentoCoapDeviceTypeConfiguration efentoCoapDeviceTypeConfiguration = new EfentoCoapDeviceTypeConfiguration();

    // Act and Assert
    assertEquals(efentoCoapDeviceTypeConfiguration, efentoCoapDeviceTypeConfiguration);
    int expectedHashCodeResult = efentoCoapDeviceTypeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, efentoCoapDeviceTypeConfiguration.hashCode());
  }

  /**
   * Method under test: {@link EfentoCoapDeviceTypeConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EfentoCoapDeviceTypeConfiguration(), 1);
  }

  /**
   * Method under test: {@link EfentoCoapDeviceTypeConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EfentoCoapDeviceTypeConfiguration(), null);
  }

  /**
   * Method under test: {@link EfentoCoapDeviceTypeConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EfentoCoapDeviceTypeConfiguration(), "Different type to EfentoCoapDeviceTypeConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link EfentoCoapDeviceTypeConfiguration}
   *   <li>{@link EfentoCoapDeviceTypeConfiguration#toString()}
   *   <li>{@link EfentoCoapDeviceTypeConfiguration#getCoapDeviceType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EfentoCoapDeviceTypeConfiguration actualEfentoCoapDeviceTypeConfiguration = new EfentoCoapDeviceTypeConfiguration();
    String actualToStringResult = actualEfentoCoapDeviceTypeConfiguration.toString();

    // Assert
    assertEquals("EfentoCoapDeviceTypeConfiguration()", actualToStringResult);
    assertEquals(CoapDeviceType.EFENTO, actualEfentoCoapDeviceTypeConfiguration.getCoapDeviceType());
  }
}
