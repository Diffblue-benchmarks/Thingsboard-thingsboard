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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfileProvisionType;

class CheckPreProvisionedDevicesDeviceProfileProvisionConfigurationDiffblueTest {
  /**
   * Test {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}, and
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   *   <li>{@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.equals(Object)",
    "int CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration =
            new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(
                "Provision Device Secret");
    CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration2 =
            new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(
                "Provision Device Secret");

    // Act and Assert
    assertEquals(
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration,
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration2);
    assertEquals(
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration.hashCode(),
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration2.hashCode());
  }

  /**
   * Test {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}, and
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   *   <li>{@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.equals(Object)",
    "int CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration =
            new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(null);
    CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration2 =
            new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(null);

    // Act and Assert
    assertEquals(
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration,
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration2);
    assertEquals(
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration.hashCode(),
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration2.hashCode());
  }

  /**
   * Test {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}, and
   * {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   *   <li>{@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.equals(Object)",
    "int CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration =
            new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(
                "Provision Device Secret");

    // Act and Assert
    assertEquals(
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration,
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration);
    int expectedHashCodeResult =
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration.hashCode();
    assertEquals(
        expectedHashCodeResult,
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration.hashCode());
  }

  /**
   * Test {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.equals(Object)",
    "int CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration =
            new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(null);

    // Act and Assert
    assertNotEquals(
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration,
        new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(
            "Provision Device Secret"));
  }

  /**
   * Test {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.equals(Object)",
    "int CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration =
            new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(
                "org.thingsboard.server.common.data.device.profile.CheckPreProvisionedDevicesDeviceProfileProvisionCo"
                    + "nfiguration");

    // Act and Assert
    assertNotEquals(
        checkPreProvisionedDevicesDeviceProfileProvisionConfiguration,
        new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(
            "Provision Device Secret"));
  }

  /**
   * Test {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.equals(Object)",
    "int CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(
            "Provision Device Secret"),
        null);
  }

  /**
   * Test {@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.equals(Object)",
    "int CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(
            "Provision Device Secret"),
        "Different type to CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(String)}
   *   <li>{@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#toString()}
   *   <li>{@link
   *       CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#getProvisionDeviceSecret()}
   *   <li>{@link CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.<init>(String)",
    "String CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.getProvisionDeviceSecret()",
    "DeviceProfileProvisionType CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.getType()",
    "String CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration
        actualCheckPreProvisionedDevicesDeviceProfileProvisionConfiguration =
            new CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(
                "Provision Device Secret");
    String actualToStringResult =
        actualCheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.toString();
    String actualProvisionDeviceSecret =
        actualCheckPreProvisionedDevicesDeviceProfileProvisionConfiguration
            .getProvisionDeviceSecret();

    // Assert
    assertEquals(
        "CheckPreProvisionedDevicesDeviceProfileProvisionConfiguration(provisionDeviceSecret=Provision Device"
            + " Secret)",
        actualToStringResult);
    assertEquals("Provision Device Secret", actualProvisionDeviceSecret);
    assertEquals(
        DeviceProfileProvisionType.CHECK_PRE_PROVISIONED_DEVICES,
        actualCheckPreProvisionedDevicesDeviceProfileProvisionConfiguration.getType());
  }
}
