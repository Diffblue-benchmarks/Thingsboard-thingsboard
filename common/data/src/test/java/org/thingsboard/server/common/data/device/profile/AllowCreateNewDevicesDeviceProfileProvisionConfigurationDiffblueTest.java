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
import org.thingsboard.server.common.data.DeviceProfileProvisionType;

class AllowCreateNewDevicesDeviceProfileProvisionConfigurationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AllowCreateNewDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   *   <li>
   * {@link AllowCreateNewDevicesDeviceProfileProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AllowCreateNewDevicesDeviceProfileProvisionConfiguration allowCreateNewDevicesDeviceProfileProvisionConfiguration = new AllowCreateNewDevicesDeviceProfileProvisionConfiguration(
        "Provision Device Secret");
    AllowCreateNewDevicesDeviceProfileProvisionConfiguration allowCreateNewDevicesDeviceProfileProvisionConfiguration2 = new AllowCreateNewDevicesDeviceProfileProvisionConfiguration(
        "Provision Device Secret");

    // Act and Assert
    assertEquals(allowCreateNewDevicesDeviceProfileProvisionConfiguration,
        allowCreateNewDevicesDeviceProfileProvisionConfiguration2);
    int expectedHashCodeResult = allowCreateNewDevicesDeviceProfileProvisionConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, allowCreateNewDevicesDeviceProfileProvisionConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AllowCreateNewDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   *   <li>
   * {@link AllowCreateNewDevicesDeviceProfileProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AllowCreateNewDevicesDeviceProfileProvisionConfiguration allowCreateNewDevicesDeviceProfileProvisionConfiguration = new AllowCreateNewDevicesDeviceProfileProvisionConfiguration(
        null);
    AllowCreateNewDevicesDeviceProfileProvisionConfiguration allowCreateNewDevicesDeviceProfileProvisionConfiguration2 = new AllowCreateNewDevicesDeviceProfileProvisionConfiguration(
        null);

    // Act and Assert
    assertEquals(allowCreateNewDevicesDeviceProfileProvisionConfiguration,
        allowCreateNewDevicesDeviceProfileProvisionConfiguration2);
    int expectedHashCodeResult = allowCreateNewDevicesDeviceProfileProvisionConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, allowCreateNewDevicesDeviceProfileProvisionConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AllowCreateNewDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   *   <li>
   * {@link AllowCreateNewDevicesDeviceProfileProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AllowCreateNewDevicesDeviceProfileProvisionConfiguration allowCreateNewDevicesDeviceProfileProvisionConfiguration = new AllowCreateNewDevicesDeviceProfileProvisionConfiguration(
        "Provision Device Secret");

    // Act and Assert
    assertEquals(allowCreateNewDevicesDeviceProfileProvisionConfiguration,
        allowCreateNewDevicesDeviceProfileProvisionConfiguration);
    int expectedHashCodeResult = allowCreateNewDevicesDeviceProfileProvisionConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, allowCreateNewDevicesDeviceProfileProvisionConfiguration.hashCode());
  }

  /**
   * Method under test:
   * {@link AllowCreateNewDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AllowCreateNewDevicesDeviceProfileProvisionConfiguration allowCreateNewDevicesDeviceProfileProvisionConfiguration = new AllowCreateNewDevicesDeviceProfileProvisionConfiguration(
        null);

    // Act and Assert
    assertNotEquals(allowCreateNewDevicesDeviceProfileProvisionConfiguration,
        new AllowCreateNewDevicesDeviceProfileProvisionConfiguration("Provision Device Secret"));
  }

  /**
   * Method under test:
   * {@link AllowCreateNewDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AllowCreateNewDevicesDeviceProfileProvisionConfiguration allowCreateNewDevicesDeviceProfileProvisionConfiguration = new AllowCreateNewDevicesDeviceProfileProvisionConfiguration(
        "org.thingsboard.server.common.data.device.profile.AllowCreateNewDevicesDeviceProfileProvisionCon"
            + "figuration");

    // Act and Assert
    assertNotEquals(allowCreateNewDevicesDeviceProfileProvisionConfiguration,
        new AllowCreateNewDevicesDeviceProfileProvisionConfiguration("Provision Device Secret"));
  }

  /**
   * Method under test:
   * {@link AllowCreateNewDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AllowCreateNewDevicesDeviceProfileProvisionConfiguration("Provision Device Secret"), null);
  }

  /**
   * Method under test:
   * {@link AllowCreateNewDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AllowCreateNewDevicesDeviceProfileProvisionConfiguration("Provision Device Secret"),
        "Different type to AllowCreateNewDevicesDeviceProfileProvisionConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AllowCreateNewDevicesDeviceProfileProvisionConfiguration#AllowCreateNewDevicesDeviceProfileProvisionConfiguration(String)}
   *   <li>
   * {@link AllowCreateNewDevicesDeviceProfileProvisionConfiguration#toString()}
   *   <li>
   * {@link AllowCreateNewDevicesDeviceProfileProvisionConfiguration#getProvisionDeviceSecret()}
   *   <li>
   * {@link AllowCreateNewDevicesDeviceProfileProvisionConfiguration#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AllowCreateNewDevicesDeviceProfileProvisionConfiguration actualAllowCreateNewDevicesDeviceProfileProvisionConfiguration = new AllowCreateNewDevicesDeviceProfileProvisionConfiguration(
        "Provision Device Secret");
    String actualToStringResult = actualAllowCreateNewDevicesDeviceProfileProvisionConfiguration.toString();
    String actualProvisionDeviceSecret = actualAllowCreateNewDevicesDeviceProfileProvisionConfiguration
        .getProvisionDeviceSecret();

    // Assert
    assertEquals(
        "AllowCreateNewDevicesDeviceProfileProvisionConfiguration(provisionDeviceSecret=Provision Device" + " Secret)",
        actualToStringResult);
    assertEquals("Provision Device Secret", actualProvisionDeviceSecret);
    assertEquals(DeviceProfileProvisionType.ALLOW_CREATE_NEW_DEVICES,
        actualAllowCreateNewDevicesDeviceProfileProvisionConfiguration.getType());
  }
}
