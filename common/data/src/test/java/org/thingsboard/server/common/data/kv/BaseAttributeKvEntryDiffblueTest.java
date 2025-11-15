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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class BaseAttributeKvEntryDiffblueTest {
  /**
   * Method under test: {@link BaseAttributeKvEntry#getKey()}
   */
  @Test
  void testGetKey() {
    // Arrange, Act and Assert
    assertEquals("Key", (new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"))).getKey());
    assertEquals("Key",
        (new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")))).getKey());
  }

  /**
   * Method under test: {@link BaseAttributeKvEntry#getDataType()}
   */
  @Test
  void testGetDataType() {
    // Arrange, Act and Assert
    assertEquals(DataType.JSON, (new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"))).getDataType());
    assertEquals(DataType.JSON,
        (new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")))).getDataType());
  }

  /**
   * Method under test: {@link BaseAttributeKvEntry#getStrValue()}
   */
  @Test
  void testGetStrValue() {
    // Arrange, Act and Assert
    assertFalse((new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"))).getStrValue().isPresent());
    assertFalse(
        (new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")))).getStrValue()
            .isPresent());
  }

  /**
   * Method under test: {@link BaseAttributeKvEntry#getLongValue()}
   */
  @Test
  void testGetLongValue() {
    // Arrange, Act and Assert
    assertFalse((new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"))).getLongValue().isPresent());
    assertFalse(
        (new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")))).getLongValue()
            .isPresent());
  }

  /**
   * Method under test: {@link BaseAttributeKvEntry#getBooleanValue()}
   */
  @Test
  void testGetBooleanValue() {
    // Arrange, Act and Assert
    assertFalse((new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"))).getBooleanValue().isPresent());
    assertFalse(
        (new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")))).getBooleanValue()
            .isPresent());
  }

  /**
   * Method under test: {@link BaseAttributeKvEntry#getDoubleValue()}
   */
  @Test
  void testGetDoubleValue() {
    // Arrange, Act and Assert
    assertFalse((new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"))).getDoubleValue().isPresent());
    assertFalse(
        (new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")))).getDoubleValue()
            .isPresent());
  }

  /**
   * Method under test: {@link BaseAttributeKvEntry#getJsonValue()}
   */
  @Test
  void testGetJsonValue() {
    // Arrange and Act
    Optional<String> actualJsonValue = (new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"))).getJsonValue();

    // Assert
    assertEquals("42", actualJsonValue.get());
    assertTrue(actualJsonValue.isPresent());
  }

  /**
   * Method under test: {@link BaseAttributeKvEntry#getJsonValue()}
   */
  @Test
  void testGetJsonValue2() {
    // Arrange and Act
    Optional<String> actualJsonValue = (new BaseAttributeKvEntry(1L,
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")))).getJsonValue();

    // Assert
    assertEquals("42", actualJsonValue.get());
    assertTrue(actualJsonValue.isPresent());
  }

  /**
   * Method under test: {@link BaseAttributeKvEntry#getValueAsString()}
   */
  @Test
  void testGetValueAsString() {
    // Arrange, Act and Assert
    assertEquals("42", (new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"))).getValueAsString());
    assertEquals("42", (new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"))))
        .getValueAsString());
  }

  /**
   * Method under test: {@link BaseAttributeKvEntry#getValue()}
   */
  @Test
  void testGetValue() {
    // Arrange, Act and Assert
    assertEquals("42", (new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"))).getValue());
    assertEquals("42",
        (new BaseAttributeKvEntry(1L, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")))).getValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BaseAttributeKvEntry#equals(Object)}
   *   <li>{@link BaseAttributeKvEntry#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));
    BaseAttributeKvEntry baseAttributeKvEntry2 = new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertEquals(baseAttributeKvEntry, baseAttributeKvEntry2);
    int expectedHashCodeResult = baseAttributeKvEntry.hashCode();
    assertEquals(expectedHashCodeResult, baseAttributeKvEntry2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BaseAttributeKvEntry#equals(Object)}
   *   <li>{@link BaseAttributeKvEntry#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(1L, null);
    BaseAttributeKvEntry baseAttributeKvEntry2 = new BaseAttributeKvEntry(1L, null);

    // Act and Assert
    assertEquals(baseAttributeKvEntry, baseAttributeKvEntry2);
    int expectedHashCodeResult = baseAttributeKvEntry.hashCode();
    assertEquals(expectedHashCodeResult, baseAttributeKvEntry2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BaseAttributeKvEntry#equals(Object)}
   *   <li>{@link BaseAttributeKvEntry#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(new JsonDataEntry("Key", "42"), 1L, 1L);
    BaseAttributeKvEntry baseAttributeKvEntry2 = new BaseAttributeKvEntry(new JsonDataEntry("Key", "42"), 1L, 1L);

    // Act and Assert
    assertEquals(baseAttributeKvEntry, baseAttributeKvEntry2);
    int expectedHashCodeResult = baseAttributeKvEntry.hashCode();
    assertEquals(expectedHashCodeResult, baseAttributeKvEntry2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BaseAttributeKvEntry#equals(Object)}
   *   <li>{@link BaseAttributeKvEntry#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertEquals(baseAttributeKvEntry, baseAttributeKvEntry);
    int expectedHashCodeResult = baseAttributeKvEntry.hashCode();
    assertEquals(expectedHashCodeResult, baseAttributeKvEntry.hashCode());
  }

  /**
   * Method under test: {@link BaseAttributeKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(3L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertNotEquals(baseAttributeKvEntry, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Method under test: {@link BaseAttributeKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(1L, new JsonDataEntry(null, "42"));

    // Act and Assert
    assertNotEquals(baseAttributeKvEntry, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Method under test: {@link BaseAttributeKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(1L,
        new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Act and Assert
    assertNotEquals(baseAttributeKvEntry, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Method under test: {@link BaseAttributeKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(1L, null);

    // Act and Assert
    assertNotEquals(baseAttributeKvEntry, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Method under test: {@link BaseAttributeKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(1L, mock(JsonDataEntry.class));

    // Act and Assert
    assertNotEquals(baseAttributeKvEntry, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Method under test: {@link BaseAttributeKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(new JsonDataEntry("Key", "42"), 1L, 1L);

    // Act and Assert
    assertNotEquals(baseAttributeKvEntry, new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")));
  }

  /**
   * Method under test: {@link BaseAttributeKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    BaseAttributeKvEntry baseAttributeKvEntry = new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertNotEquals(baseAttributeKvEntry, new BaseAttributeKvEntry(new JsonDataEntry("Key", "42"), 1L, 1L));
  }

  /**
   * Method under test: {@link BaseAttributeKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")), null);
  }

  /**
   * Method under test: {@link BaseAttributeKvEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseAttributeKvEntry(1L, new JsonDataEntry("Key", "42")),
        "Different type to BaseAttributeKvEntry");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BaseAttributeKvEntry#BaseAttributeKvEntry(long, KvEntry)}
   *   <li>{@link BaseAttributeKvEntry#toString()}
   *   <li>{@link BaseAttributeKvEntry#getKv()}
   *   <li>{@link BaseAttributeKvEntry#getLastUpdateTs()}
   *   <li>{@link BaseAttributeKvEntry#getVersion()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    JsonDataEntry kv = new JsonDataEntry("Key", "42");

    // Act
    BaseAttributeKvEntry actualBaseAttributeKvEntry = new BaseAttributeKvEntry(1L, kv);
    String actualToStringResult = actualBaseAttributeKvEntry.toString();
    KvEntry actualKv = actualBaseAttributeKvEntry.getKv();
    long actualLastUpdateTs = actualBaseAttributeKvEntry.getLastUpdateTs();

    // Assert
    assertEquals(
        "BaseAttributeKvEntry(lastUpdateTs=1, kv=JsonDataEntry{value=42} BasicKvEntry{key='Key'}," + " version=null)",
        actualToStringResult);
    assertNull(actualBaseAttributeKvEntry.getVersion());
    assertEquals(1L, actualLastUpdateTs);
    assertSame(kv, actualKv);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BaseAttributeKvEntry#BaseAttributeKvEntry(KvEntry, long)}
   *   <li>{@link BaseAttributeKvEntry#toString()}
   *   <li>{@link BaseAttributeKvEntry#getKv()}
   *   <li>{@link BaseAttributeKvEntry#getLastUpdateTs()}
   *   <li>{@link BaseAttributeKvEntry#getVersion()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    JsonDataEntry kv = new JsonDataEntry("Key", "42");

    // Act
    BaseAttributeKvEntry actualBaseAttributeKvEntry = new BaseAttributeKvEntry(kv, 1L);
    String actualToStringResult = actualBaseAttributeKvEntry.toString();
    KvEntry actualKv = actualBaseAttributeKvEntry.getKv();
    long actualLastUpdateTs = actualBaseAttributeKvEntry.getLastUpdateTs();

    // Assert
    assertEquals(
        "BaseAttributeKvEntry(lastUpdateTs=1, kv=JsonDataEntry{value=42} BasicKvEntry{key='Key'}," + " version=null)",
        actualToStringResult);
    assertNull(actualBaseAttributeKvEntry.getVersion());
    assertEquals(1L, actualLastUpdateTs);
    assertSame(kv, actualKv);
  }

  /**
   * Method under test:
   * {@link BaseAttributeKvEntry#BaseAttributeKvEntry(KvEntry, long, Long)}
   */
  @Test
  void testNewBaseAttributeKvEntry() {
    // Arrange
    JsonDataEntry kv = new JsonDataEntry("Key", "42");

    // Act
    BaseAttributeKvEntry actualBaseAttributeKvEntry = new BaseAttributeKvEntry(kv, 1L, 1L);

    // Assert
    Optional<String> jsonValue = actualBaseAttributeKvEntry.getJsonValue();
    assertEquals("42", jsonValue.get());
    assertEquals("42", actualBaseAttributeKvEntry.getValueAsString());
    assertEquals("42", actualBaseAttributeKvEntry.getValue());
    assertEquals("Key", actualBaseAttributeKvEntry.getKey());
    assertEquals(1L, actualBaseAttributeKvEntry.getVersion().longValue());
    assertEquals(1L, actualBaseAttributeKvEntry.getLastUpdateTs());
    assertEquals(DataType.JSON, actualBaseAttributeKvEntry.getDataType());
    Optional<Boolean> booleanValue = actualBaseAttributeKvEntry.getBooleanValue();
    assertFalse(booleanValue.isPresent());
    assertTrue(jsonValue.isPresent());
    assertSame(kv, actualBaseAttributeKvEntry.getKv());
    assertSame(booleanValue, actualBaseAttributeKvEntry.getDoubleValue());
    assertSame(booleanValue, actualBaseAttributeKvEntry.getLongValue());
    assertSame(booleanValue, actualBaseAttributeKvEntry.getStrValue());
  }
}
