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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class BasicKvEntryDiffblueTest {
  /**
   * Method under test: {@link BasicKvEntry#getKey()}
   */
  @Test
  void testGetKey() {
    // Arrange, Act and Assert
    assertEquals("Key", (new JsonDataEntry("Key", "42")).getKey());
  }

  /**
   * Method under test: {@link BasicKvEntry#getStrValue()}
   */
  @Test
  void testGetStrValue() {
    // Arrange, Act and Assert
    assertFalse((new JsonDataEntry("Key", "42")).getStrValue().isPresent());
  }

  /**
   * Method under test: {@link BasicKvEntry#getLongValue()}
   */
  @Test
  void testGetLongValue() {
    // Arrange, Act and Assert
    assertFalse((new JsonDataEntry("Key", "42")).getLongValue().isPresent());
  }

  /**
   * Method under test: {@link BasicKvEntry#getBooleanValue()}
   */
  @Test
  void testGetBooleanValue() {
    // Arrange, Act and Assert
    assertFalse((new JsonDataEntry("Key", "42")).getBooleanValue().isPresent());
  }

  /**
   * Method under test: {@link BasicKvEntry#getDoubleValue()}
   */
  @Test
  void testGetDoubleValue() {
    // Arrange, Act and Assert
    assertFalse((new JsonDataEntry("Key", "42")).getDoubleValue().isPresent());
  }

  /**
   * Method under test: {@link BasicKvEntry#getJsonValue()}
   */
  @Test
  void testGetJsonValue() {
    // Arrange, Act and Assert
    assertFalse((new StringDataEntry("Key", "42")).getJsonValue().isPresent());
  }

  /**
   * Method under test: {@link BasicKvEntry#equals(Object)}
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
   * Method under test: {@link BasicKvEntry#equals(Object)}
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
   * Method under test: {@link BasicKvEntry#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("JsonDataEntry{value=42} BasicKvEntry{key='Key'}", (new JsonDataEntry("Key", "42")).toString());
  }

  /**
   * Method under test: {@link BasicKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JsonDataEntry jsonDataEntry = new JsonDataEntry("org.thingsboard.server.common.data.kv.JsonDataEntry", "42");

    // Act and Assert
    assertNotEquals(jsonDataEntry, new JsonDataEntry("Key", "42"));
  }

  /**
   * Method under test: {@link BasicKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonDataEntry("Key", "42"), mock(JsonDataEntry.class));
  }

  /**
   * Method under test: {@link BasicKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonDataEntry("Key", "42"), null);
  }

  /**
   * Method under test: {@link BasicKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonDataEntry("Key", "42"), "Different type to BasicKvEntry");
  }
}
