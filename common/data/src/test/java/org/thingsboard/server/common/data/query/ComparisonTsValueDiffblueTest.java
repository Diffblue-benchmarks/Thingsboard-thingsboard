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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class ComparisonTsValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ComparisonTsValue#equals(Object)}
   *   <li>{@link ComparisonTsValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ComparisonTsValue comparisonTsValue = new ComparisonTsValue();
    ComparisonTsValue comparisonTsValue2 = new ComparisonTsValue();

    // Act and Assert
    assertEquals(comparisonTsValue, comparisonTsValue2);
    int expectedHashCodeResult = comparisonTsValue.hashCode();
    assertEquals(expectedHashCodeResult, comparisonTsValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ComparisonTsValue#equals(Object)}
   *   <li>{@link ComparisonTsValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ComparisonTsValue comparisonTsValue = new ComparisonTsValue(TsValue.EMPTY, TsValue.EMPTY);
    ComparisonTsValue comparisonTsValue2 = new ComparisonTsValue(TsValue.EMPTY, TsValue.EMPTY);

    // Act and Assert
    assertEquals(comparisonTsValue, comparisonTsValue2);
    int expectedHashCodeResult = comparisonTsValue.hashCode();
    assertEquals(expectedHashCodeResult, comparisonTsValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ComparisonTsValue#equals(Object)}
   *   <li>{@link ComparisonTsValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ComparisonTsValue comparisonTsValue = new ComparisonTsValue();

    // Act and Assert
    assertEquals(comparisonTsValue, comparisonTsValue);
    int expectedHashCodeResult = comparisonTsValue.hashCode();
    assertEquals(expectedHashCodeResult, comparisonTsValue.hashCode());
  }

  /**
   * Method under test: {@link ComparisonTsValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ComparisonTsValue comparisonTsValue = new ComparisonTsValue(TsValue.EMPTY, TsValue.EMPTY);

    // Act and Assert
    assertNotEquals(comparisonTsValue, new ComparisonTsValue());
  }

  /**
   * Method under test: {@link ComparisonTsValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ComparisonTsValue comparisonTsValue = new ComparisonTsValue();

    // Act and Assert
    assertNotEquals(comparisonTsValue, new ComparisonTsValue(TsValue.EMPTY, TsValue.EMPTY));
  }

  /**
   * Method under test: {@link ComparisonTsValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ComparisonTsValue comparisonTsValue = new ComparisonTsValue();
    comparisonTsValue.setPrevious(TsValue.EMPTY);

    // Act and Assert
    assertNotEquals(comparisonTsValue, new ComparisonTsValue());
  }

  /**
   * Method under test: {@link ComparisonTsValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ComparisonTsValue comparisonTsValue = new ComparisonTsValue(mock(TsValue.class), TsValue.EMPTY);

    // Act and Assert
    assertNotEquals(comparisonTsValue, new ComparisonTsValue());
  }

  /**
   * Method under test: {@link ComparisonTsValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ComparisonTsValue comparisonTsValue = new ComparisonTsValue();

    ComparisonTsValue comparisonTsValue2 = new ComparisonTsValue();
    comparisonTsValue2.setPrevious(TsValue.EMPTY);

    // Act and Assert
    assertNotEquals(comparisonTsValue, comparisonTsValue2);
  }

  /**
   * Method under test: {@link ComparisonTsValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ComparisonTsValue(), null);
  }

  /**
   * Method under test: {@link ComparisonTsValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ComparisonTsValue(), "Different type to ComparisonTsValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ComparisonTsValue#ComparisonTsValue()}
   *   <li>{@link ComparisonTsValue#setCurrent(TsValue)}
   *   <li>{@link ComparisonTsValue#setPrevious(TsValue)}
   *   <li>{@link ComparisonTsValue#toString()}
   *   <li>{@link ComparisonTsValue#getCurrent()}
   *   <li>{@link ComparisonTsValue#getPrevious()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ComparisonTsValue actualComparisonTsValue = new ComparisonTsValue();
    actualComparisonTsValue.setCurrent(TsValue.EMPTY);
    actualComparisonTsValue.setPrevious(TsValue.EMPTY);
    String actualToStringResult = actualComparisonTsValue.toString();
    TsValue actualCurrent = actualComparisonTsValue.getCurrent();
    TsValue actualPrevious = actualComparisonTsValue.getPrevious();

    // Assert that nothing has changed
    assertEquals(
        "ComparisonTsValue(current=TsValue(ts=0, value=, count=null), previous=TsValue(ts=0, value=," + " count=null))",
        actualToStringResult);
    TsValue tsValue = actualPrevious.EMPTY;
    assertSame(tsValue, actualCurrent);
    assertSame(tsValue, actualPrevious);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ComparisonTsValue#ComparisonTsValue(TsValue, TsValue)}
   *   <li>{@link ComparisonTsValue#setCurrent(TsValue)}
   *   <li>{@link ComparisonTsValue#setPrevious(TsValue)}
   *   <li>{@link ComparisonTsValue#toString()}
   *   <li>{@link ComparisonTsValue#getCurrent()}
   *   <li>{@link ComparisonTsValue#getPrevious()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    ComparisonTsValue actualComparisonTsValue = new ComparisonTsValue(TsValue.EMPTY, TsValue.EMPTY);
    actualComparisonTsValue.setCurrent(TsValue.EMPTY);
    actualComparisonTsValue.setPrevious(TsValue.EMPTY);
    String actualToStringResult = actualComparisonTsValue.toString();
    TsValue actualCurrent = actualComparisonTsValue.getCurrent();
    TsValue actualPrevious = actualComparisonTsValue.getPrevious();

    // Assert that nothing has changed
    assertEquals(
        "ComparisonTsValue(current=TsValue(ts=0, value=, count=null), previous=TsValue(ts=0, value=," + " count=null))",
        actualToStringResult);
    TsValue tsValue = actualPrevious.EMPTY;
    assertSame(tsValue, actualCurrent);
    assertSame(tsValue, actualPrevious);
  }
}
