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

class BooleanDataEntryDiffblueTest {
  /**
   * Method under test: {@link BooleanDataEntry#getBooleanValue()}
   */
  @Test
  void testGetBooleanValue() {
    // Arrange and Act
    Optional<Boolean> actualBooleanValue = (new BooleanDataEntry("Key", true)).getBooleanValue();

    // Assert
    assertTrue(actualBooleanValue.get());
    assertTrue(actualBooleanValue.isPresent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BooleanDataEntry#equals(Object)}
   *   <li>{@link BooleanDataEntry#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BooleanDataEntry booleanDataEntry = new BooleanDataEntry("Key", true);
    BooleanDataEntry booleanDataEntry2 = new BooleanDataEntry("Key", true);

    // Act and Assert
    assertEquals(booleanDataEntry, booleanDataEntry2);
    int expectedHashCodeResult = booleanDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, booleanDataEntry2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BooleanDataEntry#equals(Object)}
   *   <li>{@link BooleanDataEntry#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BooleanDataEntry booleanDataEntry = new BooleanDataEntry("Key", true);

    // Act and Assert
    assertEquals(booleanDataEntry, booleanDataEntry);
    int expectedHashCodeResult = booleanDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, booleanDataEntry.hashCode());
  }

  /**
   * Method under test: {@link BooleanDataEntry#getValueAsString()}
   */
  @Test
  void testGetValueAsString() {
    // Arrange and Act
    String actualValueAsString = (new BooleanDataEntry("Key", true)).getValueAsString();

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualValueAsString);
  }

  /**
   * Method under test: {@link BooleanDataEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BooleanDataEntry booleanDataEntry = new BooleanDataEntry("org.thingsboard.server.common.data.kv.BooleanDataEntry",
        true);

    // Act and Assert
    assertNotEquals(booleanDataEntry, new BooleanDataEntry("Key", true));
  }

  /**
   * Method under test: {@link BooleanDataEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new BooleanDataEntry("Key", true), mock(DoubleDataEntry.class));
  }

  /**
   * Method under test: {@link BooleanDataEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BooleanDataEntry("Key", true), null);
  }

  /**
   * Method under test: {@link BooleanDataEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BooleanDataEntry("Key", true), "Different type to BooleanDataEntry");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BooleanDataEntry#BooleanDataEntry(String, Boolean)}
   *   <li>{@link BooleanDataEntry#toString()}
   *   <li>{@link BooleanDataEntry#getDataType()}
   *   <li>{@link BooleanDataEntry#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    BooleanDataEntry actualBooleanDataEntry = new BooleanDataEntry("Key", true);
    String actualToStringResult = actualBooleanDataEntry.toString();
    DataType actualDataType = actualBooleanDataEntry.getDataType();
    actualBooleanDataEntry.getValue();

    // Assert
    assertEquals("BooleanDataEntry{value=true} BasicKvEntry{key='Key'}", actualToStringResult);
    assertEquals("Key", actualBooleanDataEntry.getKey());
    assertEquals(DataType.BOOLEAN, actualDataType);
  }
}
