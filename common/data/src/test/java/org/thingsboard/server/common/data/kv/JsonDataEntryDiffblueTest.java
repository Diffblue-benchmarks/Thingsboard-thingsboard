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
import static org.mockito.Mockito.mock;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class JsonDataEntryDiffblueTest {
  /**
   * Method under test: {@link JsonDataEntry#getJsonValue()}
   */
  @Test
  void testGetJsonValue() {
    // Arrange and Act
    Optional<String> actualJsonValue = (new JsonDataEntry("Key", "42")).getJsonValue();

    // Assert
    assertEquals("42", actualJsonValue.get());
    assertTrue(actualJsonValue.isPresent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsonDataEntry#equals(Object)}
   *   <li>{@link JsonDataEntry#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsonDataEntry jsonDataEntry = new JsonDataEntry("Key", "42");
    JsonDataEntry jsonDataEntry2 = new JsonDataEntry("Key", "42");

    // Act and Assert
    assertEquals(jsonDataEntry, jsonDataEntry2);
    int expectedHashCodeResult = jsonDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, jsonDataEntry2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsonDataEntry#equals(Object)}
   *   <li>{@link JsonDataEntry#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsonDataEntry jsonDataEntry = new JsonDataEntry("Key", "42");

    // Act and Assert
    assertEquals(jsonDataEntry, jsonDataEntry);
    int expectedHashCodeResult = jsonDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, jsonDataEntry.hashCode());
  }

  /**
   * Method under test: {@link JsonDataEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JsonDataEntry jsonDataEntry = new JsonDataEntry("org.thingsboard.server.common.data.kv.JsonDataEntry", "42");

    // Act and Assert
    assertNotEquals(jsonDataEntry, new JsonDataEntry("Key", "42"));
  }

  /**
   * Method under test: {@link JsonDataEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonDataEntry("Key", "42"), mock(BooleanDataEntry.class));
  }

  /**
   * Method under test: {@link JsonDataEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonDataEntry("Key", "42"), null);
  }

  /**
   * Method under test: {@link JsonDataEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonDataEntry("Key", "42"), "Different type to JsonDataEntry");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link JsonDataEntry#JsonDataEntry(String, String)}
   *   <li>{@link JsonDataEntry#toString()}
   *   <li>{@link JsonDataEntry#getDataType()}
   *   <li>{@link JsonDataEntry#getValue()}
   *   <li>{@link JsonDataEntry#getValueAsString()}
   * </ul>
   */
  @Test
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
}
