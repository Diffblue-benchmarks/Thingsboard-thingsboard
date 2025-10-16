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
package org.thingsboard.server.queue.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PropertyUtilsDiffblueTest {
  /**
   * Test {@link PropertyUtils#getProps(Map, String, Function)} with {@code defaultProperties},
   * {@code propertiesStr}, {@code parser}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PropertyUtils#getProps(Map, String, Function)}
   */
  @Test
  @DisplayName(
      "Test getProps(Map, String, Function) with 'defaultProperties', 'propertiesStr', 'parser'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PropertyUtils.getProps(Map, String, Function)"})
  void testGetPropsWithDefaultPropertiesPropertiesStrParser_thenReturnSizeIsOne() {
    // Arrange
    HashMap<String, String> defaultProperties = new HashMap<>();

    // Act
    Map<String, String> actualProps =
        PropertyUtils.getProps(defaultProperties, ":", PropertyUtils::getProps);

    // Assert
    assertEquals(1, actualProps.size());
    assertEquals("", actualProps.get(""));
  }

  /**
   * Test {@link PropertyUtils#getProps(Map, String, Function)} with {@code defaultProperties},
   * {@code propertiesStr}, {@code parser}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PropertyUtils#getProps(Map, String, Function)}
   */
  @Test
  @DisplayName(
      "Test getProps(Map, String, Function) with 'defaultProperties', 'propertiesStr', 'parser'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PropertyUtils.getProps(Map, String, Function)"})
  void testGetPropsWithDefaultPropertiesPropertiesStrParser_whenEmptyString() {
    // Arrange
    HashMap<String, String> defaultProperties = new HashMap<>();

    // Act
    Map<String, String> actualProps =
        PropertyUtils.getProps(defaultProperties, "", PropertyUtils::getProps);

    // Assert
    assertTrue(actualProps.isEmpty());
  }

  /**
   * Test {@link PropertyUtils#getProps(Map, String, Function)} with {@code defaultProperties},
   * {@code propertiesStr}, {@code parser}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PropertyUtils#getProps(Map, String, Function)}
   */
  @Test
  @DisplayName(
      "Test getProps(Map, String, Function) with 'defaultProperties', 'propertiesStr', 'parser'; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PropertyUtils.getProps(Map, String, Function)"})
  void testGetPropsWithDefaultPropertiesPropertiesStrParser_whenNull_thenReturnEmpty() {
    // Arrange
    HashMap<String, String> defaultProperties = new HashMap<>();

    // Act
    Map<String, String> actualProps =
        PropertyUtils.getProps(defaultProperties, null, PropertyUtils::getProps);

    // Assert
    assertTrue(actualProps.isEmpty());
  }

  /**
   * Test {@link PropertyUtils#getProps(Map, String, Function)} with {@code defaultProperties},
   * {@code propertiesStr}, {@code parser}.
   *
   * <ul>
   *   <li>When {@code ;}.
   * </ul>
   *
   * <p>Method under test: {@link PropertyUtils#getProps(Map, String, Function)}
   */
  @Test
  @DisplayName(
      "Test getProps(Map, String, Function) with 'defaultProperties', 'propertiesStr', 'parser'; when ';'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PropertyUtils.getProps(Map, String, Function)"})
  void testGetPropsWithDefaultPropertiesPropertiesStrParser_whenSemicolon() {
    // Arrange
    HashMap<String, String> defaultProperties = new HashMap<>();

    // Act
    Map<String, String> actualProps =
        PropertyUtils.getProps(defaultProperties, ";", PropertyUtils::getProps);

    // Assert
    assertTrue(actualProps.isEmpty());
  }

  /**
   * Test {@link PropertyUtils#getProps(Map, String)} with {@code defaultProperties}, {@code
   * propertiesStr}.
   *
   * <ul>
   *   <li>When {@code :}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PropertyUtils#getProps(Map, String)}
   */
  @Test
  @DisplayName(
      "Test getProps(Map, String) with 'defaultProperties', 'propertiesStr'; when ':'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PropertyUtils.getProps(Map, String)"})
  void testGetPropsWithDefaultPropertiesPropertiesStr_whenColon_thenReturnSizeIsOne() {
    // Arrange and Act
    Map<String, String> actualProps = PropertyUtils.getProps(new HashMap<>(), ":");

    // Assert
    assertEquals(1, actualProps.size());
    assertEquals("", actualProps.get(""));
  }

  /**
   * Test {@link PropertyUtils#getProps(Map, String)} with {@code defaultProperties}, {@code
   * propertiesStr}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PropertyUtils#getProps(Map, String)}
   */
  @Test
  @DisplayName(
      "Test getProps(Map, String) with 'defaultProperties', 'propertiesStr'; when empty string; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PropertyUtils.getProps(Map, String)"})
  void testGetPropsWithDefaultPropertiesPropertiesStr_whenEmptyString_thenReturnEmpty() {
    // Arrange and Act
    Map<String, String> actualProps = PropertyUtils.getProps(new HashMap<>(), "");

    // Assert
    assertTrue(actualProps.isEmpty());
  }

  /**
   * Test {@link PropertyUtils#getProps(Map, String)} with {@code defaultProperties}, {@code
   * propertiesStr}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PropertyUtils#getProps(Map, String)}
   */
  @Test
  @DisplayName(
      "Test getProps(Map, String) with 'defaultProperties', 'propertiesStr'; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PropertyUtils.getProps(Map, String)"})
  void testGetPropsWithDefaultPropertiesPropertiesStr_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Map<String, String> actualProps = PropertyUtils.getProps(new HashMap<>(), null);

    // Assert
    assertTrue(actualProps.isEmpty());
  }

  /**
   * Test {@link PropertyUtils#getProps(Map, String)} with {@code defaultProperties}, {@code
   * propertiesStr}.
   *
   * <ul>
   *   <li>When {@code ;}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PropertyUtils#getProps(Map, String)}
   */
  @Test
  @DisplayName(
      "Test getProps(Map, String) with 'defaultProperties', 'propertiesStr'; when ';'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PropertyUtils.getProps(Map, String)"})
  void testGetPropsWithDefaultPropertiesPropertiesStr_whenSemicolon_thenReturnEmpty() {
    // Arrange and Act
    Map<String, String> actualProps = PropertyUtils.getProps(new HashMap<>(), ";");

    // Assert
    assertTrue(actualProps.isEmpty());
  }

  /**
   * Test {@link PropertyUtils#getProps(String)} with {@code properties}.
   *
   * <ul>
   *   <li>When {@code :}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PropertyUtils#getProps(String)}
   */
  @Test
  @DisplayName("Test getProps(String) with 'properties'; when ':'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PropertyUtils.getProps(String)"})
  void testGetPropsWithProperties_whenColon_thenReturnSizeIsOne() {
    // Arrange and Act
    Map<String, String> actualProps = PropertyUtils.getProps(":");

    // Assert
    assertEquals(1, actualProps.size());
    assertEquals("", actualProps.get(""));
  }

  /**
   * Test {@link PropertyUtils#getProps(String)} with {@code properties}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PropertyUtils#getProps(String)}
   */
  @Test
  @DisplayName("Test getProps(String) with 'properties'; when empty string; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PropertyUtils.getProps(String)"})
  void testGetPropsWithProperties_whenEmptyString_thenReturnEmpty() {
    // Arrange and Act
    Map<String, String> actualProps = PropertyUtils.getProps("");

    // Assert
    assertTrue(actualProps.isEmpty());
  }

  /**
   * Test {@link PropertyUtils#getProps(String)} with {@code properties}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PropertyUtils#getProps(String)}
   */
  @Test
  @DisplayName("Test getProps(String) with 'properties'; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PropertyUtils.getProps(String)"})
  void testGetPropsWithProperties_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Map<String, String> actualProps = PropertyUtils.getProps(null);

    // Assert
    assertTrue(actualProps.isEmpty());
  }

  /**
   * Test {@link PropertyUtils#getProps(String)} with {@code properties}.
   *
   * <ul>
   *   <li>When {@code ;:}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PropertyUtils#getProps(String)}
   */
  @Test
  @DisplayName("Test getProps(String) with 'properties'; when ';:'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PropertyUtils.getProps(String)"})
  void testGetPropsWithProperties_whenSemicolonColon_thenReturnSizeIsOne() {
    // Arrange and Act
    Map<String, String> actualProps = PropertyUtils.getProps(";:");

    // Assert
    assertEquals(1, actualProps.size());
    assertEquals("", actualProps.get(""));
  }

  /**
   * Test {@link PropertyUtils#getProps(String)} with {@code properties}.
   *
   * <ul>
   *   <li>When {@code ;}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PropertyUtils#getProps(String)}
   */
  @Test
  @DisplayName("Test getProps(String) with 'properties'; when ';'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PropertyUtils.getProps(String)"})
  void testGetPropsWithProperties_whenSemicolon_thenReturnEmpty() {
    // Arrange and Act
    Map<String, String> actualProps = PropertyUtils.getProps(";");

    // Assert
    assertTrue(actualProps.isEmpty());
  }
}
