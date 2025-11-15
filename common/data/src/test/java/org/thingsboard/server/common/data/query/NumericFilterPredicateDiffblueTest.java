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

class NumericFilterPredicateDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NumericFilterPredicate#equals(Object)}
   *   <li>{@link NumericFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(NumericFilterPredicate.NumericOperation.EQUAL);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate.setValue(value);

    NumericFilterPredicate numericFilterPredicate2 = new NumericFilterPredicate();
    numericFilterPredicate2.setOperation(NumericFilterPredicate.NumericOperation.EQUAL);
    FilterPredicateValue<Double> value2 = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate2.setValue(value2);

    // Act and Assert
    assertEquals(numericFilterPredicate, numericFilterPredicate2);
    int expectedHashCodeResult = numericFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, numericFilterPredicate2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NumericFilterPredicate#equals(Object)}
   *   <li>{@link NumericFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(null);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate.setValue(value);

    NumericFilterPredicate numericFilterPredicate2 = new NumericFilterPredicate();
    numericFilterPredicate2.setOperation(null);
    FilterPredicateValue<Double> value2 = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate2.setValue(value2);

    // Act and Assert
    assertEquals(numericFilterPredicate, numericFilterPredicate2);
    int expectedHashCodeResult = numericFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, numericFilterPredicate2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NumericFilterPredicate#equals(Object)}
   *   <li>{@link NumericFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(NumericFilterPredicate.NumericOperation.EQUAL);
    numericFilterPredicate.setValue(null);

    NumericFilterPredicate numericFilterPredicate2 = new NumericFilterPredicate();
    numericFilterPredicate2.setOperation(NumericFilterPredicate.NumericOperation.EQUAL);
    numericFilterPredicate2.setValue(null);

    // Act and Assert
    assertEquals(numericFilterPredicate, numericFilterPredicate2);
    int expectedHashCodeResult = numericFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, numericFilterPredicate2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NumericFilterPredicate#equals(Object)}
   *   <li>{@link NumericFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(NumericFilterPredicate.NumericOperation.EQUAL);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate.setValue(value);

    // Act and Assert
    assertEquals(numericFilterPredicate, numericFilterPredicate);
    int expectedHashCodeResult = numericFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, numericFilterPredicate.hashCode());
  }

  /**
   * Method under test: {@link NumericFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(null);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate.setValue(value);

    NumericFilterPredicate numericFilterPredicate2 = new NumericFilterPredicate();
    numericFilterPredicate2.setOperation(NumericFilterPredicate.NumericOperation.EQUAL);
    FilterPredicateValue<Double> value2 = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(numericFilterPredicate, numericFilterPredicate2);
  }

  /**
   * Method under test: {@link NumericFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(NumericFilterPredicate.NumericOperation.NOT_EQUAL);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate.setValue(value);

    NumericFilterPredicate numericFilterPredicate2 = new NumericFilterPredicate();
    numericFilterPredicate2.setOperation(NumericFilterPredicate.NumericOperation.EQUAL);
    FilterPredicateValue<Double> value2 = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(numericFilterPredicate, numericFilterPredicate2);
  }

  /**
   * Method under test: {@link NumericFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(NumericFilterPredicate.NumericOperation.EQUAL);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(0.5d);
    numericFilterPredicate.setValue(value);

    NumericFilterPredicate numericFilterPredicate2 = new NumericFilterPredicate();
    numericFilterPredicate2.setOperation(NumericFilterPredicate.NumericOperation.EQUAL);
    FilterPredicateValue<Double> value2 = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(numericFilterPredicate, numericFilterPredicate2);
  }

  /**
   * Method under test: {@link NumericFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(NumericFilterPredicate.NumericOperation.EQUAL);
    numericFilterPredicate.setValue(null);

    NumericFilterPredicate numericFilterPredicate2 = new NumericFilterPredicate();
    numericFilterPredicate2.setOperation(NumericFilterPredicate.NumericOperation.EQUAL);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate2.setValue(value);

    // Act and Assert
    assertNotEquals(numericFilterPredicate, numericFilterPredicate2);
  }

  /**
   * Method under test: {@link NumericFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(NumericFilterPredicate.NumericOperation.EQUAL);
    numericFilterPredicate.setValue(mock(FilterPredicateValue.class));

    NumericFilterPredicate numericFilterPredicate2 = new NumericFilterPredicate();
    numericFilterPredicate2.setOperation(NumericFilterPredicate.NumericOperation.EQUAL);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate2.setValue(value);

    // Act and Assert
    assertNotEquals(numericFilterPredicate, numericFilterPredicate2);
  }

  /**
   * Method under test: {@link NumericFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(NumericFilterPredicate.NumericOperation.EQUAL);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate.setValue(value);

    // Act and Assert
    assertNotEquals(numericFilterPredicate, null);
  }

  /**
   * Method under test: {@link NumericFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(NumericFilterPredicate.NumericOperation.EQUAL);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate.setValue(value);

    // Act and Assert
    assertNotEquals(numericFilterPredicate, "Different type to NumericFilterPredicate");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NumericFilterPredicate}
   *   <li>
   * {@link NumericFilterPredicate#setOperation(NumericFilterPredicate.NumericOperation)}
   *   <li>{@link NumericFilterPredicate#setValue(FilterPredicateValue)}
   *   <li>{@link NumericFilterPredicate#toString()}
   *   <li>{@link NumericFilterPredicate#getOperation()}
   *   <li>{@link NumericFilterPredicate#getType()}
   *   <li>{@link NumericFilterPredicate#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    NumericFilterPredicate actualNumericFilterPredicate = new NumericFilterPredicate();
    actualNumericFilterPredicate.setOperation(NumericFilterPredicate.NumericOperation.EQUAL);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    actualNumericFilterPredicate.setValue(value);
    String actualToStringResult = actualNumericFilterPredicate.toString();
    NumericFilterPredicate.NumericOperation actualOperation = actualNumericFilterPredicate.getOperation();
    FilterPredicateType actualType = actualNumericFilterPredicate.getType();

    // Assert that nothing has changed
    assertEquals("NumericFilterPredicate(operation=EQUAL, value=FilterPredicateValue(defaultValue=10.0, userValue=null,"
        + " dynamicValue=null))", actualToStringResult);
    assertEquals(FilterPredicateType.NUMERIC, actualType);
    assertEquals(NumericFilterPredicate.NumericOperation.EQUAL, actualOperation);
    assertSame(value, actualNumericFilterPredicate.getValue());
  }
}
