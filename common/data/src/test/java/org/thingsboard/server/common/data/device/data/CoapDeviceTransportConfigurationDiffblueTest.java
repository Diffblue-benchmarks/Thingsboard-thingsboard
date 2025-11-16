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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceTransportType;

class CoapDeviceTransportConfigurationDiffblueTest {
  /**
   * Test {@link CoapDeviceTransportConfiguration#put(String, Object)}.
   *
   * <p>Method under test: {@link CoapDeviceTransportConfiguration#put(String, Object)}
   */
  @Test
  @DisplayName("Test put(String, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapDeviceTransportConfiguration.put(String, Object)"})
  void testPut() {
    // Arrange
    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration =
        new CoapDeviceTransportConfiguration();

    // Act
    coapDeviceTransportConfiguration.put("Name", "Value");

    // Assert
    Map<String, Object> properties = coapDeviceTransportConfiguration.getProperties();
    assertEquals(1, properties.size());
    assertEquals("Value", properties.get("Name"));
  }

  /**
   * Test {@link CoapDeviceTransportConfiguration#equals(Object)}, and {@link
   * CoapDeviceTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CoapDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link CoapDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CoapDeviceTransportConfiguration.equals(Object)",
    "int CoapDeviceTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration =
        new CoapDeviceTransportConfiguration();
    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration2 =
        new CoapDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(coapDeviceTransportConfiguration, coapDeviceTransportConfiguration2);
    assertEquals(
        coapDeviceTransportConfiguration.hashCode(), coapDeviceTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link CoapDeviceTransportConfiguration#equals(Object)}, and {@link
   * CoapDeviceTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CoapDeviceTransportConfiguration#equals(Object)}
   *   <li>{@link CoapDeviceTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CoapDeviceTransportConfiguration.equals(Object)",
    "int CoapDeviceTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration =
        new CoapDeviceTransportConfiguration();

    // Act and Assert
    assertEquals(coapDeviceTransportConfiguration, coapDeviceTransportConfiguration);
    int expectedHashCodeResult = coapDeviceTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, coapDeviceTransportConfiguration.hashCode());
  }

  /**
   * Test {@link CoapDeviceTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CoapDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CoapDeviceTransportConfiguration.equals(Object)",
    "int CoapDeviceTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration =
        new CoapDeviceTransportConfiguration();
    coapDeviceTransportConfiguration.put("Name", "Value");

    // Act and Assert
    assertNotEquals(coapDeviceTransportConfiguration, new CoapDeviceTransportConfiguration());
  }

  /**
   * Test {@link CoapDeviceTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CoapDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CoapDeviceTransportConfiguration.equals(Object)",
    "int CoapDeviceTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration =
        new CoapDeviceTransportConfiguration();
    coapDeviceTransportConfiguration.put("Name", new CoapDeviceTransportConfiguration());

    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration2 =
        new CoapDeviceTransportConfiguration();
    coapDeviceTransportConfiguration2.put(
        "org.thingsboard.server.common.data.device.data.CoapDeviceTransportConfiguration", "Value");

    // Act and Assert
    assertNotEquals(coapDeviceTransportConfiguration, coapDeviceTransportConfiguration2);
  }

  /**
   * Test {@link CoapDeviceTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CoapDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CoapDeviceTransportConfiguration.equals(Object)",
    "int CoapDeviceTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CoapDeviceTransportConfiguration(), null);
  }

  /**
   * Test {@link CoapDeviceTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CoapDeviceTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CoapDeviceTransportConfiguration.equals(Object)",
    "int CoapDeviceTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CoapDeviceTransportConfiguration(),
        "Different type to CoapDeviceTransportConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CoapDeviceTransportConfiguration}
   *   <li>{@link CoapDeviceTransportConfiguration#setProperties(Map)}
   *   <li>{@link CoapDeviceTransportConfiguration#toString()}
   *   <li>{@link CoapDeviceTransportConfiguration#getProperties()}
   *   <li>{@link CoapDeviceTransportConfiguration#getType()}
   *   <li>{@link CoapDeviceTransportConfiguration#properties()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CoapDeviceTransportConfiguration.<init>()",
    "Map CoapDeviceTransportConfiguration.getProperties()",
    "DeviceTransportType CoapDeviceTransportConfiguration.getType()",
    "Map CoapDeviceTransportConfiguration.properties()",
    "void CoapDeviceTransportConfiguration.setProperties(Map)",
    "String CoapDeviceTransportConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    CoapDeviceTransportConfiguration actualCoapDeviceTransportConfiguration =
        new CoapDeviceTransportConfiguration();
    HashMap<String, Object> properties = new HashMap<>();
    actualCoapDeviceTransportConfiguration.setProperties(properties);
    String actualToStringResult = actualCoapDeviceTransportConfiguration.toString();
    Map<String, Object> actualProperties = actualCoapDeviceTransportConfiguration.getProperties();
    DeviceTransportType actualType = actualCoapDeviceTransportConfiguration.getType();
    Map<String, Object> actualPropertiesResult =
        actualCoapDeviceTransportConfiguration.properties();

    // Assert
    assertEquals("CoapDeviceTransportConfiguration(properties={})", actualToStringResult);
    assertNull(actualCoapDeviceTransportConfiguration.getEdrxCycle());
    assertNull(actualCoapDeviceTransportConfiguration.getPagingTransmissionWindow());
    assertNull(actualCoapDeviceTransportConfiguration.getPsmActivityTimer());
    assertNull(actualCoapDeviceTransportConfiguration.getPowerMode());
    assertEquals(DeviceTransportType.COAP, actualType);
    assertTrue(actualProperties.isEmpty());
    assertSame(properties, actualProperties);
    assertSame(properties, actualPropertiesResult);
  }
}
