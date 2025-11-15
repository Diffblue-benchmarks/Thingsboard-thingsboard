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

class LongDataEntryDiffblueTest {
  /**
   * Method under test: {@link LongDataEntry#getLongValue()}
   */
  @Test
  void testGetLongValue() {
    // Arrange and Act
    Optional<Long> actualLongValue = (new LongDataEntry("Key", 42L)).getLongValue();

    // Assert
    assertEquals(42L, actualLongValue.get().longValue());
    assertTrue(actualLongValue.isPresent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LongDataEntry#equals(Object)}
   *   <li>{@link LongDataEntry#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LongDataEntry longDataEntry = new LongDataEntry("Key", 42L);
    LongDataEntry longDataEntry2 = new LongDataEntry("Key", 42L);

    // Act and Assert
    assertEquals(longDataEntry, longDataEntry2);
    int expectedHashCodeResult = longDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, longDataEntry2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LongDataEntry#equals(Object)}
   *   <li>{@link LongDataEntry#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LongDataEntry longDataEntry = new LongDataEntry("Key", 42L);

    // Act and Assert
    assertEquals(longDataEntry, longDataEntry);
    int expectedHashCodeResult = longDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, longDataEntry.hashCode());
  }

  /**
   * Method under test: {@link LongDataEntry#getValueAsString()}
   */
  @Test
  void testGetValueAsString() {
    // Arrange, Act and Assert
    assertEquals("42", (new LongDataEntry("Key", 42L)).getValueAsString());
  }

  /**
   * Method under test: {@link LongDataEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LongDataEntry longDataEntry = new LongDataEntry("org.thingsboard.server.common.data.kv.LongDataEntry", 42L);

    // Act and Assert
    assertNotEquals(longDataEntry, new LongDataEntry("Key", 42L));
  }

  /**
   * Method under test: {@link LongDataEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new LongDataEntry("Key", 42L), mock(BooleanDataEntry.class));
  }

  /**
   * Method under test: {@link LongDataEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LongDataEntry("Key", 42L), null);
  }

  /**
   * Method under test: {@link LongDataEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LongDataEntry("Key", 42L), "Different type to LongDataEntry");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LongDataEntry#LongDataEntry(String, Long)}
   *   <li>{@link LongDataEntry#toString()}
   *   <li>{@link LongDataEntry#getDataType()}
   *   <li>{@link LongDataEntry#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    LongDataEntry actualLongDataEntry = new LongDataEntry("Key", 42L);
    String actualToStringResult = actualLongDataEntry.toString();
    DataType actualDataType = actualLongDataEntry.getDataType();
    actualLongDataEntry.getValue();

    // Assert
    assertEquals("Key", actualLongDataEntry.getKey());
    assertEquals("LongDataEntry{value=42} BasicKvEntry{key='Key'}", actualToStringResult);
    assertEquals(DataType.LONG, actualDataType);
  }
}
