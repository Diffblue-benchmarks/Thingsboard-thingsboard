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
import org.thingsboard.server.common.data.DeviceTransportType;

class DefaultDeviceTransportConfigurationDiffblueTest {
  /**
   * Test {@link DefaultDeviceTransportConfiguration#equals(Object)}, and {@link
   * DefaultDeviceTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultDeviceTransportConfiguration.equals(Object)",
    "int DefaultDeviceTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultDeviceTransportConfiguration defaultDeviceTransportConfiguration =
        new DefaultDeviceTransportConfiguration();
    DefaultDeviceTransportConfiguration defaultDeviceTransportConfiguration2 =
        new DefaultDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceTransportConfiguration, defaultDeviceTransportConfiguration2);
    assertEquals(
        defaultDeviceTransportConfiguration.hashCode(),
        defaultDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link DefaultDeviceTransportConfiguration#equals(Object)}, and {@link
   * DefaultDeviceTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DefaultDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultDeviceTransportConfiguration.equals(Object)",
    "int DefaultDeviceTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultDeviceTransportConfiguration defaultDeviceTransportConfiguration =
        new DefaultDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceTransportConfiguration, defaultDeviceTransportConfiguration);
    int expectedHashCodeResult = defaultDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceTransportConfiguration.hashCode());
  }

  /**
   * Test {@link DefaultDeviceTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultDeviceTransportConfiguration.equals(Object)",
    "int DefaultDeviceTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceTransportConfiguration(), 1);
  }

  /**
   * Test {@link DefaultDeviceTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultDeviceTransportConfiguration.equals(Object)",
    "int DefaultDeviceTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceTransportConfiguration(), null);
  }

  /**
   * Test {@link DefaultDeviceTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DefaultDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultDeviceTransportConfiguration.equals(Object)",
    "int DefaultDeviceTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DefaultDeviceTransportConfiguration(),
        "Different type to DefaultDeviceTransportConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DefaultDeviceTransportConfiguration}
   *   <li>{@link DefaultDeviceTransportConfiguration#toString()}
   *   <li>{@link DefaultDeviceTransportConfiguration#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultDeviceTransportConfiguration.<init>()",
    "DeviceTransportType DefaultDeviceTransportConfiguration.getType()",
    "String DefaultDeviceTransportConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultDeviceTransportConfiguration actualDefaultDeviceTransportConfiguration =
        new DefaultDeviceTransportConfiguration();
    String actualToStringResult = actualDefaultDeviceTransportConfiguration.toString();

    // Assert
    assertEquals("DefaultDeviceTransportConfiguration()", actualToStringResult);
    assertEquals(DeviceTransportType.DEFAULT, actualDefaultDeviceTransportConfiguration.getType());
  }
}
