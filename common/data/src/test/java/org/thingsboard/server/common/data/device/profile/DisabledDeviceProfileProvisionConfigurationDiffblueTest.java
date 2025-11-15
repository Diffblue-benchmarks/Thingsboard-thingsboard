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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfileProvisionType;

class DisabledDeviceProfileProvisionConfigurationDiffblueTest {
  /**
   * Test {@link DisabledDeviceProfileProvisionConfiguration#equals(Object)}, and {@link DisabledDeviceProfileProvisionConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DisabledDeviceProfileProvisionConfiguration#equals(Object)}
   *   <li>{@link DisabledDeviceProfileProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DisabledDeviceProfileProvisionConfiguration.equals(Object)",
      "int DisabledDeviceProfileProvisionConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DisabledDeviceProfileProvisionConfiguration disabledDeviceProfileProvisionConfiguration = new DisabledDeviceProfileProvisionConfiguration(
        "Provision Device Secret");
    DisabledDeviceProfileProvisionConfiguration disabledDeviceProfileProvisionConfiguration2 = new DisabledDeviceProfileProvisionConfiguration(
        "Provision Device Secret");

    // Act and Assert
    assertEquals(disabledDeviceProfileProvisionConfiguration, disabledDeviceProfileProvisionConfiguration2);
    int expectedHashCodeResult = disabledDeviceProfileProvisionConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, disabledDeviceProfileProvisionConfiguration2.hashCode());
  }

  /**
   * Test {@link DisabledDeviceProfileProvisionConfiguration#equals(Object)}, and {@link DisabledDeviceProfileProvisionConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DisabledDeviceProfileProvisionConfiguration#equals(Object)}
   *   <li>{@link DisabledDeviceProfileProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DisabledDeviceProfileProvisionConfiguration.equals(Object)",
      "int DisabledDeviceProfileProvisionConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DisabledDeviceProfileProvisionConfiguration disabledDeviceProfileProvisionConfiguration = new DisabledDeviceProfileProvisionConfiguration(
        null);
    DisabledDeviceProfileProvisionConfiguration disabledDeviceProfileProvisionConfiguration2 = new DisabledDeviceProfileProvisionConfiguration(
        null);

    // Act and Assert
    assertEquals(disabledDeviceProfileProvisionConfiguration, disabledDeviceProfileProvisionConfiguration2);
    int expectedHashCodeResult = disabledDeviceProfileProvisionConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, disabledDeviceProfileProvisionConfiguration2.hashCode());
  }

  /**
   * Test {@link DisabledDeviceProfileProvisionConfiguration#equals(Object)}, and {@link DisabledDeviceProfileProvisionConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DisabledDeviceProfileProvisionConfiguration#equals(Object)}
   *   <li>{@link DisabledDeviceProfileProvisionConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DisabledDeviceProfileProvisionConfiguration.equals(Object)",
      "int DisabledDeviceProfileProvisionConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DisabledDeviceProfileProvisionConfiguration disabledDeviceProfileProvisionConfiguration = new DisabledDeviceProfileProvisionConfiguration(
        "Provision Device Secret");

    // Act and Assert
    assertEquals(disabledDeviceProfileProvisionConfiguration, disabledDeviceProfileProvisionConfiguration);
    int expectedHashCodeResult = disabledDeviceProfileProvisionConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, disabledDeviceProfileProvisionConfiguration.hashCode());
  }

  /**
   * Test {@link DisabledDeviceProfileProvisionConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DisabledDeviceProfileProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DisabledDeviceProfileProvisionConfiguration.equals(Object)",
      "int DisabledDeviceProfileProvisionConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DisabledDeviceProfileProvisionConfiguration disabledDeviceProfileProvisionConfiguration = new DisabledDeviceProfileProvisionConfiguration(
        null);

    // Act and Assert
    assertNotEquals(disabledDeviceProfileProvisionConfiguration,
        new DisabledDeviceProfileProvisionConfiguration("Provision Device Secret"));
  }

  /**
   * Test {@link DisabledDeviceProfileProvisionConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DisabledDeviceProfileProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DisabledDeviceProfileProvisionConfiguration.equals(Object)",
      "int DisabledDeviceProfileProvisionConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DisabledDeviceProfileProvisionConfiguration disabledDeviceProfileProvisionConfiguration = new DisabledDeviceProfileProvisionConfiguration(
        "org.thingsboard.server.common.data.device.profile.DisabledDeviceProfileProvisionConfiguration");

    // Act and Assert
    assertNotEquals(disabledDeviceProfileProvisionConfiguration,
        new DisabledDeviceProfileProvisionConfiguration("Provision Device Secret"));
  }

  /**
   * Test {@link DisabledDeviceProfileProvisionConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DisabledDeviceProfileProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DisabledDeviceProfileProvisionConfiguration.equals(Object)",
      "int DisabledDeviceProfileProvisionConfiguration.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DisabledDeviceProfileProvisionConfiguration("Provision Device Secret"), null);
  }

  /**
   * Test {@link DisabledDeviceProfileProvisionConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DisabledDeviceProfileProvisionConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DisabledDeviceProfileProvisionConfiguration.equals(Object)",
      "int DisabledDeviceProfileProvisionConfiguration.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DisabledDeviceProfileProvisionConfiguration("Provision Device Secret"),
        "Different type to DisabledDeviceProfileProvisionConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DisabledDeviceProfileProvisionConfiguration#DisabledDeviceProfileProvisionConfiguration(String)}
   *   <li>{@link DisabledDeviceProfileProvisionConfiguration#toString()}
   *   <li>{@link DisabledDeviceProfileProvisionConfiguration#getProvisionDeviceSecret()}
   *   <li>{@link DisabledDeviceProfileProvisionConfiguration#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DisabledDeviceProfileProvisionConfiguration.<init>(String)",
      "String DisabledDeviceProfileProvisionConfiguration.getProvisionDeviceSecret()",
      "DeviceProfileProvisionType DisabledDeviceProfileProvisionConfiguration.getType()",
      "String DisabledDeviceProfileProvisionConfiguration.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    DisabledDeviceProfileProvisionConfiguration actualDisabledDeviceProfileProvisionConfiguration = new DisabledDeviceProfileProvisionConfiguration(
        "Provision Device Secret");
    String actualToStringResult = actualDisabledDeviceProfileProvisionConfiguration.toString();
    String actualProvisionDeviceSecret = actualDisabledDeviceProfileProvisionConfiguration.getProvisionDeviceSecret();

    // Assert
    assertEquals("DisabledDeviceProfileProvisionConfiguration(provisionDeviceSecret=Provision Device Secret)",
        actualToStringResult);
    assertEquals("Provision Device Secret", actualProvisionDeviceSecret);
    assertEquals(DeviceProfileProvisionType.DISABLED, actualDisabledDeviceProfileProvisionConfiguration.getType());
  }
}
