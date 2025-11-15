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

class BooleanFilterPredicateDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BooleanFilterPredicate#equals(Object)}
   *   <li>{@link BooleanFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(BooleanFilterPredicate.BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate.setValue(value);

    BooleanFilterPredicate booleanFilterPredicate2 = new BooleanFilterPredicate();
    booleanFilterPredicate2.setOperation(BooleanFilterPredicate.BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value2 = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate2.setValue(value2);

    // Act and Assert
    assertEquals(booleanFilterPredicate, booleanFilterPredicate2);
    int expectedHashCodeResult = booleanFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, booleanFilterPredicate2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BooleanFilterPredicate#equals(Object)}
   *   <li>{@link BooleanFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(null);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate.setValue(value);

    BooleanFilterPredicate booleanFilterPredicate2 = new BooleanFilterPredicate();
    booleanFilterPredicate2.setOperation(null);
    FilterPredicateValue<Boolean> value2 = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate2.setValue(value2);

    // Act and Assert
    assertEquals(booleanFilterPredicate, booleanFilterPredicate2);
    int expectedHashCodeResult = booleanFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, booleanFilterPredicate2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BooleanFilterPredicate#equals(Object)}
   *   <li>{@link BooleanFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(BooleanFilterPredicate.BooleanOperation.EQUAL);
    booleanFilterPredicate.setValue(null);

    BooleanFilterPredicate booleanFilterPredicate2 = new BooleanFilterPredicate();
    booleanFilterPredicate2.setOperation(BooleanFilterPredicate.BooleanOperation.EQUAL);
    booleanFilterPredicate2.setValue(null);

    // Act and Assert
    assertEquals(booleanFilterPredicate, booleanFilterPredicate2);
    int expectedHashCodeResult = booleanFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, booleanFilterPredicate2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BooleanFilterPredicate#equals(Object)}
   *   <li>{@link BooleanFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(BooleanFilterPredicate.BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate.setValue(value);

    // Act and Assert
    assertEquals(booleanFilterPredicate, booleanFilterPredicate);
    int expectedHashCodeResult = booleanFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, booleanFilterPredicate.hashCode());
  }

  /**
   * Method under test: {@link BooleanFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(null);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate.setValue(value);

    BooleanFilterPredicate booleanFilterPredicate2 = new BooleanFilterPredicate();
    booleanFilterPredicate2.setOperation(BooleanFilterPredicate.BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value2 = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(booleanFilterPredicate, booleanFilterPredicate2);
  }

  /**
   * Method under test: {@link BooleanFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(BooleanFilterPredicate.BooleanOperation.NOT_EQUAL);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate.setValue(value);

    BooleanFilterPredicate booleanFilterPredicate2 = new BooleanFilterPredicate();
    booleanFilterPredicate2.setOperation(BooleanFilterPredicate.BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value2 = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(booleanFilterPredicate, booleanFilterPredicate2);
  }

  /**
   * Method under test: {@link BooleanFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(BooleanFilterPredicate.BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(false);
    booleanFilterPredicate.setValue(value);

    BooleanFilterPredicate booleanFilterPredicate2 = new BooleanFilterPredicate();
    booleanFilterPredicate2.setOperation(BooleanFilterPredicate.BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value2 = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(booleanFilterPredicate, booleanFilterPredicate2);
  }

  /**
   * Method under test: {@link BooleanFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(BooleanFilterPredicate.BooleanOperation.EQUAL);
    booleanFilterPredicate.setValue(null);

    BooleanFilterPredicate booleanFilterPredicate2 = new BooleanFilterPredicate();
    booleanFilterPredicate2.setOperation(BooleanFilterPredicate.BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate2.setValue(value);

    // Act and Assert
    assertNotEquals(booleanFilterPredicate, booleanFilterPredicate2);
  }

  /**
   * Method under test: {@link BooleanFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(BooleanFilterPredicate.BooleanOperation.EQUAL);
    booleanFilterPredicate.setValue(mock(FilterPredicateValue.class));

    BooleanFilterPredicate booleanFilterPredicate2 = new BooleanFilterPredicate();
    booleanFilterPredicate2.setOperation(BooleanFilterPredicate.BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate2.setValue(value);

    // Act and Assert
    assertNotEquals(booleanFilterPredicate, booleanFilterPredicate2);
  }

  /**
   * Method under test: {@link BooleanFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(BooleanFilterPredicate.BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate.setValue(value);

    // Act and Assert
    assertNotEquals(booleanFilterPredicate, null);
  }

  /**
   * Method under test: {@link BooleanFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(BooleanFilterPredicate.BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate.setValue(value);

    // Act and Assert
    assertNotEquals(booleanFilterPredicate, "Different type to BooleanFilterPredicate");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BooleanFilterPredicate}
   *   <li>
   * {@link BooleanFilterPredicate#setOperation(BooleanFilterPredicate.BooleanOperation)}
   *   <li>{@link BooleanFilterPredicate#setValue(FilterPredicateValue)}
   *   <li>{@link BooleanFilterPredicate#toString()}
   *   <li>{@link BooleanFilterPredicate#getOperation()}
   *   <li>{@link BooleanFilterPredicate#getType()}
   *   <li>{@link BooleanFilterPredicate#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    BooleanFilterPredicate actualBooleanFilterPredicate = new BooleanFilterPredicate();
    actualBooleanFilterPredicate.setOperation(BooleanFilterPredicate.BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    actualBooleanFilterPredicate.setValue(value);
    String actualToStringResult = actualBooleanFilterPredicate.toString();
    BooleanFilterPredicate.BooleanOperation actualOperation = actualBooleanFilterPredicate.getOperation();
    FilterPredicateType actualType = actualBooleanFilterPredicate.getType();

    // Assert that nothing has changed
    assertEquals("BooleanFilterPredicate(operation=EQUAL, value=FilterPredicateValue(defaultValue=true, userValue=null,"
        + " dynamicValue=null))", actualToStringResult);
    assertEquals(BooleanFilterPredicate.BooleanOperation.EQUAL, actualOperation);
    assertEquals(FilterPredicateType.BOOLEAN, actualType);
    assertSame(value, actualBooleanFilterPredicate.getValue());
  }
}
