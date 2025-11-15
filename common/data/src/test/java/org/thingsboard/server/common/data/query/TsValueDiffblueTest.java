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
package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class TsValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TsValue#equals(Object)}
   *   <li>{@link TsValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsValue tsValue = TsValue.EMPTY;
    TsValue tsValue2 = TsValue.EMPTY;

    // Act and Assert
    assertEquals(tsValue, tsValue2);
    int expectedHashCodeResult = tsValue.hashCode();
    assertEquals(expectedHashCodeResult, tsValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TsValue#equals(Object)}
   *   <li>{@link TsValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TsValue tsValue = new TsValue(1L, "42");
    TsValue tsValue2 = new TsValue(1L, "42");

    // Act and Assert
    assertEquals(tsValue, tsValue2);
    int expectedHashCodeResult = tsValue.hashCode();
    assertEquals(expectedHashCodeResult, tsValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TsValue#equals(Object)}
   *   <li>{@link TsValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TsValue tsValue = new TsValue(1L, "42", 3L);
    TsValue tsValue2 = new TsValue(1L, "42", 3L);

    // Act and Assert
    assertEquals(tsValue, tsValue2);
    int expectedHashCodeResult = tsValue.hashCode();
    assertEquals(expectedHashCodeResult, tsValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TsValue#equals(Object)}
   *   <li>{@link TsValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsValue tsValue = TsValue.EMPTY;

    // Act and Assert
    assertEquals(tsValue, tsValue);
    int expectedHashCodeResult = tsValue.hashCode();
    assertEquals(expectedHashCodeResult, tsValue.hashCode());
  }

  /**
   * Method under test: {@link TsValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsValue(1L, "42"), TsValue.EMPTY);
    assertNotEquals(new TsValue(0L, "42"), TsValue.EMPTY);
    assertNotEquals(new TsValue(0L, null), TsValue.EMPTY);
  }

  /**
   * Method under test: {@link TsValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TsValue tsValue = new TsValue(1L, "42");

    // Act and Assert
    assertNotEquals(tsValue, new TsValue(1L, "42", 3L));
  }

  /**
   * Method under test: {@link TsValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TsValue tsValue = new TsValue(1L, "42", 3L);

    // Act and Assert
    assertNotEquals(tsValue, new TsValue(1L, "42"));
  }

  /**
   * Method under test: {@link TsValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TsValue.EMPTY, null);
  }

  /**
   * Method under test: {@link TsValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TsValue.EMPTY, "Different type to TsValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TsValue#toString()}
   *   <li>{@link TsValue#getCount()}
   *   <li>{@link TsValue#getTs()}
   *   <li>{@link TsValue#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TsValue tsValue = new TsValue(1L, "42");

    // Act
    String actualToStringResult = tsValue.toString();
    Long actualCount = tsValue.getCount();
    long actualTs = tsValue.getTs();

    // Assert
    assertEquals("42", tsValue.getValue());
    assertEquals("TsValue(ts=1, value=42, count=null)", actualToStringResult);
    assertNull(actualCount);
    assertEquals(1L, actualTs);
  }

  /**
   * Method under test: {@link TsValue#TsValue(long, String)}
   */
  @Test
  void testNewTsValue() {
    // Arrange and Act
    TsValue actualTsValue = new TsValue(1L, "42");

    // Assert
    assertEquals("42", actualTsValue.getValue());
    assertNull(actualTsValue.getCount());
    assertEquals(1L, actualTsValue.getTs());
  }

  /**
   * Method under test: {@link TsValue#TsValue(long, String, Long)}
   */
  @Test
  void testNewTsValue2() {
    // Arrange and Act
    TsValue actualTsValue = new TsValue(1L, "42", 3L);

    // Assert
    assertEquals("42", actualTsValue.getValue());
    assertEquals(1L, actualTsValue.getTs());
    assertEquals(3L, actualTsValue.getCount().longValue());
  }
}
