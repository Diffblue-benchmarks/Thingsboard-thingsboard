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

class DoubleDataEntryDiffblueTest {
  /**
   * Method under test: {@link DoubleDataEntry#getDoubleValue()}
   */
  @Test
  void testGetDoubleValue() {
    // Arrange and Act
    Optional<Double> actualDoubleValue = (new DoubleDataEntry("Key", 10.0d)).getDoubleValue();

    // Assert
    assertEquals(10.0d, actualDoubleValue.get().doubleValue());
    assertTrue(actualDoubleValue.isPresent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DoubleDataEntry#equals(Object)}
   *   <li>{@link DoubleDataEntry#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DoubleDataEntry doubleDataEntry = new DoubleDataEntry("Key", 10.0d);
    DoubleDataEntry doubleDataEntry2 = new DoubleDataEntry("Key", 10.0d);

    // Act and Assert
    assertEquals(doubleDataEntry, doubleDataEntry2);
    int expectedHashCodeResult = doubleDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, doubleDataEntry2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DoubleDataEntry#equals(Object)}
   *   <li>{@link DoubleDataEntry#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DoubleDataEntry doubleDataEntry = new DoubleDataEntry("Key", 10.0d);

    // Act and Assert
    assertEquals(doubleDataEntry, doubleDataEntry);
    int expectedHashCodeResult = doubleDataEntry.hashCode();
    assertEquals(expectedHashCodeResult, doubleDataEntry.hashCode());
  }

  /**
   * Method under test: {@link DoubleDataEntry#getValueAsString()}
   */
  @Test
  void testGetValueAsString() {
    // Arrange, Act and Assert
    assertEquals("10.0", (new DoubleDataEntry("Key", 10.0d)).getValueAsString());
  }

  /**
   * Method under test: {@link DoubleDataEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DoubleDataEntry doubleDataEntry = new DoubleDataEntry("org.thingsboard.server.common.data.kv.DoubleDataEntry",
        10.0d);

    // Act and Assert
    assertNotEquals(doubleDataEntry, new DoubleDataEntry("Key", 10.0d));
  }

  /**
   * Method under test: {@link DoubleDataEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new DoubleDataEntry("Key", 10.0d), mock(BooleanDataEntry.class));
  }

  /**
   * Method under test: {@link DoubleDataEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoubleDataEntry("Key", 10.0d), null);
  }

  /**
   * Method under test: {@link DoubleDataEntry#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoubleDataEntry("Key", 10.0d), "Different type to DoubleDataEntry");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DoubleDataEntry#DoubleDataEntry(String, Double)}
   *   <li>{@link DoubleDataEntry#toString()}
   *   <li>{@link DoubleDataEntry#getDataType()}
   *   <li>{@link DoubleDataEntry#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DoubleDataEntry actualDoubleDataEntry = new DoubleDataEntry("Key", 10.0d);
    String actualToStringResult = actualDoubleDataEntry.toString();
    DataType actualDataType = actualDoubleDataEntry.getDataType();
    Object actualValue = actualDoubleDataEntry.getValue();

    // Assert
    assertEquals("DoubleDataEntry{value=10.0} BasicKvEntry{key='Key'}", actualToStringResult);
    assertEquals("Key", actualDoubleDataEntry.getKey());
    assertEquals(10.0d, ((Double) actualValue).doubleValue());
    assertEquals(DataType.DOUBLE, actualDataType);
  }
}
