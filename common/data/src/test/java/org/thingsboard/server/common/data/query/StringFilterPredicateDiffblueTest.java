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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class StringFilterPredicateDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StringFilterPredicate#equals(Object)}
   *   <li>{@link StringFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(StringFilterPredicate.StringOperation.EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate.setValue(value);

    StringFilterPredicate stringFilterPredicate2 = new StringFilterPredicate();
    stringFilterPredicate2.setIgnoreCase(true);
    stringFilterPredicate2.setOperation(StringFilterPredicate.StringOperation.EQUAL);
    FilterPredicateValue<String> value2 = FilterPredicateValue.fromString("42");
    stringFilterPredicate2.setValue(value2);

    // Act and Assert
    assertEquals(stringFilterPredicate, stringFilterPredicate2);
    int expectedHashCodeResult = stringFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, stringFilterPredicate2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StringFilterPredicate#equals(Object)}
   *   <li>{@link StringFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(null);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate.setValue(value);

    StringFilterPredicate stringFilterPredicate2 = new StringFilterPredicate();
    stringFilterPredicate2.setIgnoreCase(true);
    stringFilterPredicate2.setOperation(null);
    FilterPredicateValue<String> value2 = FilterPredicateValue.fromString("42");
    stringFilterPredicate2.setValue(value2);

    // Act and Assert
    assertEquals(stringFilterPredicate, stringFilterPredicate2);
    int expectedHashCodeResult = stringFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, stringFilterPredicate2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StringFilterPredicate#equals(Object)}
   *   <li>{@link StringFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(StringFilterPredicate.StringOperation.EQUAL);
    stringFilterPredicate.setValue(null);

    StringFilterPredicate stringFilterPredicate2 = new StringFilterPredicate();
    stringFilterPredicate2.setIgnoreCase(true);
    stringFilterPredicate2.setOperation(StringFilterPredicate.StringOperation.EQUAL);
    stringFilterPredicate2.setValue(null);

    // Act and Assert
    assertEquals(stringFilterPredicate, stringFilterPredicate2);
    int expectedHashCodeResult = stringFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, stringFilterPredicate2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StringFilterPredicate#equals(Object)}
   *   <li>{@link StringFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(StringFilterPredicate.StringOperation.EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate.setValue(value);

    // Act and Assert
    assertEquals(stringFilterPredicate, stringFilterPredicate);
    int expectedHashCodeResult = stringFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, stringFilterPredicate.hashCode());
  }

  /**
   * Method under test: {@link StringFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(false);
    stringFilterPredicate.setOperation(StringFilterPredicate.StringOperation.EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate.setValue(value);

    StringFilterPredicate stringFilterPredicate2 = new StringFilterPredicate();
    stringFilterPredicate2.setIgnoreCase(true);
    stringFilterPredicate2.setOperation(StringFilterPredicate.StringOperation.EQUAL);
    FilterPredicateValue<String> value2 = FilterPredicateValue.fromString("42");
    stringFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(stringFilterPredicate, stringFilterPredicate2);
  }

  /**
   * Method under test: {@link StringFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(null);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate.setValue(value);

    StringFilterPredicate stringFilterPredicate2 = new StringFilterPredicate();
    stringFilterPredicate2.setIgnoreCase(true);
    stringFilterPredicate2.setOperation(StringFilterPredicate.StringOperation.EQUAL);
    FilterPredicateValue<String> value2 = FilterPredicateValue.fromString("42");
    stringFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(stringFilterPredicate, stringFilterPredicate2);
  }

  /**
   * Method under test: {@link StringFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(StringFilterPredicate.StringOperation.NOT_EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate.setValue(value);

    StringFilterPredicate stringFilterPredicate2 = new StringFilterPredicate();
    stringFilterPredicate2.setIgnoreCase(true);
    stringFilterPredicate2.setOperation(StringFilterPredicate.StringOperation.EQUAL);
    FilterPredicateValue<String> value2 = FilterPredicateValue.fromString("42");
    stringFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(stringFilterPredicate, stringFilterPredicate2);
  }

  /**
   * Method under test: {@link StringFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(StringFilterPredicate.StringOperation.EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("Value");
    stringFilterPredicate.setValue(value);

    StringFilterPredicate stringFilterPredicate2 = new StringFilterPredicate();
    stringFilterPredicate2.setIgnoreCase(true);
    stringFilterPredicate2.setOperation(StringFilterPredicate.StringOperation.EQUAL);
    FilterPredicateValue<String> value2 = FilterPredicateValue.fromString("42");
    stringFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(stringFilterPredicate, stringFilterPredicate2);
  }

  /**
   * Method under test: {@link StringFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(StringFilterPredicate.StringOperation.EQUAL);
    stringFilterPredicate.setValue(null);

    StringFilterPredicate stringFilterPredicate2 = new StringFilterPredicate();
    stringFilterPredicate2.setIgnoreCase(true);
    stringFilterPredicate2.setOperation(StringFilterPredicate.StringOperation.EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate2.setValue(value);

    // Act and Assert
    assertNotEquals(stringFilterPredicate, stringFilterPredicate2);
  }

  /**
   * Method under test: {@link StringFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(StringFilterPredicate.StringOperation.EQUAL);
    stringFilterPredicate.setValue(mock(FilterPredicateValue.class));

    StringFilterPredicate stringFilterPredicate2 = new StringFilterPredicate();
    stringFilterPredicate2.setIgnoreCase(true);
    stringFilterPredicate2.setOperation(StringFilterPredicate.StringOperation.EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate2.setValue(value);

    // Act and Assert
    assertNotEquals(stringFilterPredicate, stringFilterPredicate2);
  }

  /**
   * Method under test: {@link StringFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(StringFilterPredicate.StringOperation.EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate.setValue(value);

    // Act and Assert
    assertNotEquals(stringFilterPredicate, null);
  }

  /**
   * Method under test: {@link StringFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(StringFilterPredicate.StringOperation.EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate.setValue(value);

    // Act and Assert
    assertNotEquals(stringFilterPredicate, "Different type to StringFilterPredicate");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StringFilterPredicate}
   *   <li>{@link StringFilterPredicate#setIgnoreCase(boolean)}
   *   <li>
   * {@link StringFilterPredicate#setOperation(StringFilterPredicate.StringOperation)}
   *   <li>{@link StringFilterPredicate#setValue(FilterPredicateValue)}
   *   <li>{@link StringFilterPredicate#toString()}
   *   <li>{@link StringFilterPredicate#getOperation()}
   *   <li>{@link StringFilterPredicate#getType()}
   *   <li>{@link StringFilterPredicate#getValue()}
   *   <li>{@link StringFilterPredicate#isIgnoreCase()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    StringFilterPredicate actualStringFilterPredicate = new StringFilterPredicate();
    actualStringFilterPredicate.setIgnoreCase(true);
    actualStringFilterPredicate.setOperation(StringFilterPredicate.StringOperation.EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    actualStringFilterPredicate.setValue(value);
    String actualToStringResult = actualStringFilterPredicate.toString();
    StringFilterPredicate.StringOperation actualOperation = actualStringFilterPredicate.getOperation();
    FilterPredicateType actualType = actualStringFilterPredicate.getType();
    FilterPredicateValue<String> actualValue = actualStringFilterPredicate.getValue();

    // Assert that nothing has changed
    assertEquals("StringFilterPredicate(operation=EQUAL, value=FilterPredicateValue(defaultValue=42, userValue=null,"
        + " dynamicValue=null), ignoreCase=true)", actualToStringResult);
    assertEquals(FilterPredicateType.STRING, actualType);
    assertEquals(StringFilterPredicate.StringOperation.EQUAL, actualOperation);
    assertTrue(actualStringFilterPredicate.isIgnoreCase());
    assertSame(value, actualValue);
  }
}
