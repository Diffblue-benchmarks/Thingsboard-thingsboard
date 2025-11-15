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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.CoapDeviceType;
import org.thingsboard.server.common.data.TransportPayloadType;

class DefaultCoapDeviceTypeConfigurationDiffblueTest {
  /**
   * Test {@link DefaultCoapDeviceTypeConfiguration#getTransportPayloadTypeConfiguration()}.
   * <p>
   * Method under test: {@link DefaultCoapDeviceTypeConfiguration#getTransportPayloadTypeConfiguration()}
   */
  @Test
  @DisplayName("Test getTransportPayloadTypeConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TransportPayloadTypeConfiguration DefaultCoapDeviceTypeConfiguration.getTransportPayloadTypeConfiguration()"})
  void testGetTransportPayloadTypeConfiguration() {
    // Arrange
    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration.setTransportPayloadTypeConfiguration(null);

    // Act
    TransportPayloadTypeConfiguration actualTransportPayloadTypeConfiguration = defaultCoapDeviceTypeConfiguration
        .getTransportPayloadTypeConfiguration();
    TransportPayloadType actualTransportPayloadType = actualTransportPayloadTypeConfiguration.getTransportPayloadType();

    // Assert
    assertTrue(actualTransportPayloadTypeConfiguration instanceof JsonTransportPayloadConfiguration);
    assertEquals(TransportPayloadType.JSON, actualTransportPayloadTypeConfiguration.getTransportPayloadType());
    assertEquals(TransportPayloadType.JSON, actualTransportPayloadType);
  }

  /**
   * Test {@link DefaultCoapDeviceTypeConfiguration#getTransportPayloadTypeConfiguration()}.
   * <ul>
   *   <li>Given {@link DefaultCoapDeviceTypeConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCoapDeviceTypeConfiguration#getTransportPayloadTypeConfiguration()}
   */
  @Test
  @DisplayName("Test getTransportPayloadTypeConfiguration(); given DefaultCoapDeviceTypeConfiguration (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "TransportPayloadTypeConfiguration DefaultCoapDeviceTypeConfiguration.getTransportPayloadTypeConfiguration()"})
  void testGetTransportPayloadTypeConfiguration_givenDefaultCoapDeviceTypeConfiguration() {
    // Arrange and Act
    TransportPayloadTypeConfiguration actualTransportPayloadTypeConfiguration = (new DefaultCoapDeviceTypeConfiguration())
        .getTransportPayloadTypeConfiguration();
    TransportPayloadType actualTransportPayloadType = actualTransportPayloadTypeConfiguration.getTransportPayloadType();

    // Assert
    assertTrue(actualTransportPayloadTypeConfiguration instanceof JsonTransportPayloadConfiguration);
    assertEquals(TransportPayloadType.JSON, actualTransportPayloadTypeConfiguration.getTransportPayloadType());
    assertEquals(TransportPayloadType.JSON, actualTransportPayloadType);
  }

  /**
   * Test {@link DefaultCoapDeviceTypeConfiguration#equals(Object)}, and {@link DefaultCoapDeviceTypeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultCoapDeviceTypeConfiguration#equals(Object)}
   *   <li>{@link DefaultCoapDeviceTypeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultCoapDeviceTypeConfiguration.equals(Object)",
      "int DefaultCoapDeviceTypeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration.setTransportPayloadTypeConfiguration(null);

    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration2 = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration2.setTransportPayloadTypeConfiguration(new JsonTransportPayloadConfiguration());

    // Act and Assert
    assertEquals(defaultCoapDeviceTypeConfiguration, defaultCoapDeviceTypeConfiguration2);
    int expectedHashCodeResult = defaultCoapDeviceTypeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultCoapDeviceTypeConfiguration2.hashCode());
  }

  /**
   * Test {@link DefaultCoapDeviceTypeConfiguration#equals(Object)}, and {@link DefaultCoapDeviceTypeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultCoapDeviceTypeConfiguration#equals(Object)}
   *   <li>{@link DefaultCoapDeviceTypeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultCoapDeviceTypeConfiguration.equals(Object)",
      "int DefaultCoapDeviceTypeConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));

    // Act and Assert
    assertEquals(defaultCoapDeviceTypeConfiguration, defaultCoapDeviceTypeConfiguration);
    int expectedHashCodeResult = defaultCoapDeviceTypeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, defaultCoapDeviceTypeConfiguration.hashCode());
  }

  /**
   * Test {@link DefaultCoapDeviceTypeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCoapDeviceTypeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultCoapDeviceTypeConfiguration.equals(Object)",
      "int DefaultCoapDeviceTypeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));

    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration2 = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration2
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));

    // Act and Assert
    assertNotEquals(defaultCoapDeviceTypeConfiguration, defaultCoapDeviceTypeConfiguration2);
  }

  /**
   * Test {@link DefaultCoapDeviceTypeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCoapDeviceTypeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultCoapDeviceTypeConfiguration.equals(Object)",
      "int DefaultCoapDeviceTypeConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration.setTransportPayloadTypeConfiguration(null);

    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration2 = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration2
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));

    // Act and Assert
    assertNotEquals(defaultCoapDeviceTypeConfiguration, defaultCoapDeviceTypeConfiguration2);
  }

  /**
   * Test {@link DefaultCoapDeviceTypeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCoapDeviceTypeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultCoapDeviceTypeConfiguration.equals(Object)",
      "int DefaultCoapDeviceTypeConfiguration.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));

    // Act and Assert
    assertNotEquals(defaultCoapDeviceTypeConfiguration, null);
  }

  /**
   * Test {@link DefaultCoapDeviceTypeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCoapDeviceTypeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultCoapDeviceTypeConfiguration.equals(Object)",
      "int DefaultCoapDeviceTypeConfiguration.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));

    // Act and Assert
    assertNotEquals(defaultCoapDeviceTypeConfiguration, "Different type to DefaultCoapDeviceTypeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DefaultCoapDeviceTypeConfiguration}
   *   <li>{@link DefaultCoapDeviceTypeConfiguration#setTransportPayloadTypeConfiguration(TransportPayloadTypeConfiguration)}
   *   <li>{@link DefaultCoapDeviceTypeConfiguration#toString()}
   *   <li>{@link DefaultCoapDeviceTypeConfiguration#getCoapDeviceType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultCoapDeviceTypeConfiguration.<init>()",
      "CoapDeviceType DefaultCoapDeviceTypeConfiguration.getCoapDeviceType()",
      "void DefaultCoapDeviceTypeConfiguration.setTransportPayloadTypeConfiguration(TransportPayloadTypeConfiguration)",
      "java.lang.String DefaultCoapDeviceTypeConfiguration.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    DefaultCoapDeviceTypeConfiguration actualDefaultCoapDeviceTypeConfiguration = new DefaultCoapDeviceTypeConfiguration();
    actualDefaultCoapDeviceTypeConfiguration
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));
    actualDefaultCoapDeviceTypeConfiguration.toString();

    // Assert
    assertEquals(CoapDeviceType.DEFAULT, actualDefaultCoapDeviceTypeConfiguration.getCoapDeviceType());
  }
}
