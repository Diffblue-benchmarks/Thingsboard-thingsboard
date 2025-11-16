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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfileType;

class DefaultDeviceConfigurationDiffblueTest {
  /**
   * Test {@link DefaultDeviceConfiguration#equals(Object)}, and {@link
   * DefaultDeviceConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultDeviceConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultDeviceConfiguration.equals(Object)",
    "int DefaultDeviceConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultDeviceConfiguration defaultDeviceConfiguration = new DefaultDeviceConfiguration();
    DefaultDeviceConfiguration defaultDeviceConfiguration2 = new DefaultDeviceConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceConfiguration, defaultDeviceConfiguration2);
    assertEquals(defaultDeviceConfiguration.hashCode(), defaultDeviceConfiguration2.hashCode());
  }

  /**
   * Test {@link DefaultDeviceConfiguration#equals(Object)}, and {@link
   * DefaultDeviceConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultDeviceConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultDeviceConfiguration.equals(Object)",
    "int DefaultDeviceConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultDeviceConfiguration defaultDeviceConfiguration = new DefaultDeviceConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceConfiguration, defaultDeviceConfiguration);
    int expectedHashCodeResult = defaultDeviceConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceConfiguration.hashCode());
  }

  /**
   * Test {@link DefaultDeviceConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultDeviceConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultDeviceConfiguration.equals(Object)",
    "int DefaultDeviceConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceConfiguration(), 1);
  }

  /**
   * Test {@link DefaultDeviceConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultDeviceConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultDeviceConfiguration.equals(Object)",
    "int DefaultDeviceConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceConfiguration(), null);
  }

  /**
   * Test {@link DefaultDeviceConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultDeviceConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultDeviceConfiguration.equals(Object)",
    "int DefaultDeviceConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DefaultDeviceConfiguration(), "Different type to DefaultDeviceConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DefaultDeviceConfiguration}
   *   <li>{@link DefaultDeviceConfiguration#toString()}
   *   <li>{@link DefaultDeviceConfiguration#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultDeviceConfiguration.<init>()",
    "DeviceProfileType DefaultDeviceConfiguration.getType()",
    "String DefaultDeviceConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultDeviceConfiguration actualDefaultDeviceConfiguration = new DefaultDeviceConfiguration();
    String actualToStringResult = actualDefaultDeviceConfiguration.toString();

    // Assert
    assertEquals("DefaultDeviceConfiguration()", actualToStringResult);
    assertEquals(DeviceProfileType.DEFAULT, actualDefaultDeviceConfiguration.getType());
  }
}
