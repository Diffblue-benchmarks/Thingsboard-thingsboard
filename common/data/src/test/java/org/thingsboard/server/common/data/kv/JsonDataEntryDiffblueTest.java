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
package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JsonDataEntryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonDataEntry#JsonDataEntry(String, String)}
   *   <li>{@link JsonDataEntry#toString()}
   *   <li>{@link JsonDataEntry#getDataType()}
   *   <li>{@link JsonDataEntry#getValue()}
   *   <li>{@link JsonDataEntry#getValueAsString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JsonDataEntry.<init>(String, String)",
    "DataType JsonDataEntry.getDataType()",
    "Object JsonDataEntry.getValue()",
    "String JsonDataEntry.getValueAsString()",
    "String JsonDataEntry.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    JsonDataEntry actualJsonDataEntry = new JsonDataEntry("Key", "42");
    String actualToStringResult = actualJsonDataEntry.toString();
    DataType actualDataType = actualJsonDataEntry.getDataType();
    Object actualValue = actualJsonDataEntry.getValue();

    // Assert
    assertEquals("42", actualJsonDataEntry.getValueAsString());
    assertEquals("42", actualValue);
    assertEquals("JsonDataEntry{value=42} BasicKvEntry{key='Key'}", actualToStringResult);
    assertEquals("Key", actualJsonDataEntry.getKey());
    assertEquals(DataType.JSON, actualDataType);
  }

  /**
   * Test {@link JsonDataEntry#getJsonValue()}.
   *
   * <p>Method under test: {@link JsonDataEntry#getJsonValue()}
   */
  @Test
  @DisplayName("Test getJsonValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JsonDataEntry.getJsonValue()"})
  void testGetJsonValue() {
    // Arrange and Act
    Optional<String> actualJsonValue = new JsonDataEntry("Key", "42").getJsonValue();

    // Assert
    assertEquals("42", actualJsonValue.get());
    assertTrue(actualJsonValue.isPresent());
  }

  /**
   * Test {@link JsonDataEntry#equals(Object)}, and {@link JsonDataEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonDataEntry#equals(Object)}
   *   <li>{@link JsonDataEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonDataEntry.equals(Object)", "int JsonDataEntry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsonDataEntry jsonDataEntry = new JsonDataEntry("Key", "42");
    JsonDataEntry jsonDataEntry2 = new JsonDataEntry("Key", "42");

    // Act and Assert
    assertEquals(jsonDataEntry, jsonDataEntry2);
    assertEquals(jsonDataEntry.hashCode(), jsonDataEntry2.hashCode());
  }

  /**
   * Test {@link JsonDataEntry#equals(Object)}, and {@link JsonDataEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonDataEntry#equals(Object)}
   *   <li>{@link JsonDataEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonDataEntry.equals(Object)", "int JsonDataEntry.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsonDataEntry jsonDataEntry = new JsonDataEntry("Key", "42");

    // Act and Assert
    assertEquals(jsonDataEntry, jsonDataEntry);
    int expectedHashCodeResult = jsonDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, jsonDataEntry.hashCode());
  }

  /**
   * Test {@link JsonDataEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonDataEntry.equals(Object)", "int JsonDataEntry.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JsonDataEntry jsonDataEntry =
        new JsonDataEntry("org.thingsboard.server.common.data.kv.JsonDataEntry", "42");

    // Act and Assert
    assertNotEquals(jsonDataEntry, new JsonDataEntry("Key", "42"));
  }

  /**
   * Test {@link JsonDataEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonDataEntry.equals(Object)", "int JsonDataEntry.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonDataEntry("Key", "42"), null);
  }

  /**
   * Test {@link JsonDataEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonDataEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonDataEntry.equals(Object)", "int JsonDataEntry.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonDataEntry("Key", "42"), "Different type to JsonDataEntry");
  }
}
