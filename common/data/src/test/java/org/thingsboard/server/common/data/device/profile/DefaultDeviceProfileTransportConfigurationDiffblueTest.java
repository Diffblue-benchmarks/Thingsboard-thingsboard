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
import org.thingsboard.server.common.data.DeviceTransportType;

class DefaultDeviceProfileTransportConfigurationDiffblueTest {
  /**
   * Test {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}, and {@link DefaultDeviceProfileTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultDeviceProfileTransportConfiguration.equals(Object)",
      "int DefaultDeviceProfileTransportConfiguration.hashCode()"})
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
   * Test {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}, and {@link DefaultDeviceProfileTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link DefaultDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultDeviceProfileTransportConfiguration.equals(Object)",
      "int DefaultDeviceProfileTransportConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultDeviceProfileTransportConfiguration defaultDeviceProfileTransportConfiguration = new DefaultDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(defaultDeviceProfileTransportConfiguration, defaultDeviceProfileTransportConfiguration);
    int expectedHashCodeResult = defaultDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultDeviceProfileTransportConfiguration.hashCode());
  }

  /**
   * Test {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultDeviceProfileTransportConfiguration.equals(Object)",
      "int DefaultDeviceProfileTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceProfileTransportConfiguration(), 1);
  }

  /**
   * Test {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultDeviceProfileTransportConfiguration.equals(Object)",
      "int DefaultDeviceProfileTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceProfileTransportConfiguration(), null);
  }

  /**
   * Test {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultDeviceProfileTransportConfiguration.equals(Object)",
      "int DefaultDeviceProfileTransportConfiguration.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DefaultDeviceProfileTransportConfiguration(),
        "Different type to DefaultDeviceProfileTransportConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DefaultDeviceProfileTransportConfiguration}
   *   <li>{@link DefaultDeviceProfileTransportConfiguration#toString()}
   *   <li>{@link DefaultDeviceProfileTransportConfiguration#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultDeviceProfileTransportConfiguration.<init>()",
      "DeviceTransportType DefaultDeviceProfileTransportConfiguration.getType()",
      "String DefaultDeviceProfileTransportConfiguration.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultDeviceProfileTransportConfiguration actualDefaultDeviceProfileTransportConfiguration = new DefaultDeviceProfileTransportConfiguration();
    String actualToStringResult = actualDefaultDeviceProfileTransportConfiguration.toString();

    // Assert
    assertEquals("DefaultDeviceProfileTransportConfiguration()", actualToStringResult);
    assertEquals(DeviceTransportType.DEFAULT, actualDefaultDeviceProfileTransportConfiguration.getType());
  }
}
