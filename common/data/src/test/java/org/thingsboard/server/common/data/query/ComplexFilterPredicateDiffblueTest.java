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
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ComplexFilterPredicateDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ComplexFilterPredicate#equals(Object)}
   *   <li>{@link ComplexFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ComplexFilterPredicate complexFilterPredicate = new ComplexFilterPredicate();
    complexFilterPredicate.setOperation(ComplexFilterPredicate.ComplexOperation.AND);
    complexFilterPredicate.setPredicates(new ArrayList<>());

    ComplexFilterPredicate complexFilterPredicate2 = new ComplexFilterPredicate();
    complexFilterPredicate2.setOperation(ComplexFilterPredicate.ComplexOperation.AND);
    complexFilterPredicate2.setPredicates(new ArrayList<>());

    // Act and Assert
    assertEquals(complexFilterPredicate, complexFilterPredicate2);
    int expectedHashCodeResult = complexFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, complexFilterPredicate2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ComplexFilterPredicate#equals(Object)}
   *   <li>{@link ComplexFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ComplexFilterPredicate complexFilterPredicate = new ComplexFilterPredicate();
    complexFilterPredicate.setOperation(null);
    complexFilterPredicate.setPredicates(new ArrayList<>());

    ComplexFilterPredicate complexFilterPredicate2 = new ComplexFilterPredicate();
    complexFilterPredicate2.setOperation(null);
    complexFilterPredicate2.setPredicates(new ArrayList<>());

    // Act and Assert
    assertEquals(complexFilterPredicate, complexFilterPredicate2);
    int expectedHashCodeResult = complexFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, complexFilterPredicate2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ComplexFilterPredicate#equals(Object)}
   *   <li>{@link ComplexFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ComplexFilterPredicate complexFilterPredicate = new ComplexFilterPredicate();
    complexFilterPredicate.setOperation(ComplexFilterPredicate.ComplexOperation.AND);
    complexFilterPredicate.setPredicates(new ArrayList<>());

    // Act and Assert
    assertEquals(complexFilterPredicate, complexFilterPredicate);
    int expectedHashCodeResult = complexFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, complexFilterPredicate.hashCode());
  }

  /**
   * Method under test: {@link ComplexFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ComplexFilterPredicate complexFilterPredicate = new ComplexFilterPredicate();
    complexFilterPredicate.setOperation(null);
    complexFilterPredicate.setPredicates(new ArrayList<>());

    ComplexFilterPredicate complexFilterPredicate2 = new ComplexFilterPredicate();
    complexFilterPredicate2.setOperation(ComplexFilterPredicate.ComplexOperation.AND);
    complexFilterPredicate2.setPredicates(new ArrayList<>());

    // Act and Assert
    assertNotEquals(complexFilterPredicate, complexFilterPredicate2);
  }

  /**
   * Method under test: {@link ComplexFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ComplexFilterPredicate complexFilterPredicate = new ComplexFilterPredicate();
    complexFilterPredicate.setOperation(ComplexFilterPredicate.ComplexOperation.OR);
    complexFilterPredicate.setPredicates(new ArrayList<>());

    ComplexFilterPredicate complexFilterPredicate2 = new ComplexFilterPredicate();
    complexFilterPredicate2.setOperation(ComplexFilterPredicate.ComplexOperation.AND);
    complexFilterPredicate2.setPredicates(new ArrayList<>());

    // Act and Assert
    assertNotEquals(complexFilterPredicate, complexFilterPredicate2);
  }

  /**
   * Method under test: {@link ComplexFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<KeyFilterPredicate> predicates = new ArrayList<>();
    predicates.add(mock(KeyFilterPredicate.class));

    ComplexFilterPredicate complexFilterPredicate = new ComplexFilterPredicate();
    complexFilterPredicate.setOperation(ComplexFilterPredicate.ComplexOperation.AND);
    complexFilterPredicate.setPredicates(predicates);

    ComplexFilterPredicate complexFilterPredicate2 = new ComplexFilterPredicate();
    complexFilterPredicate2.setOperation(ComplexFilterPredicate.ComplexOperation.AND);
    complexFilterPredicate2.setPredicates(new ArrayList<>());

    // Act and Assert
    assertNotEquals(complexFilterPredicate, complexFilterPredicate2);
  }

  /**
   * Method under test: {@link ComplexFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ComplexFilterPredicate complexFilterPredicate = new ComplexFilterPredicate();
    complexFilterPredicate.setOperation(ComplexFilterPredicate.ComplexOperation.AND);
    complexFilterPredicate.setPredicates(new ArrayList<>());

    // Act and Assert
    assertNotEquals(complexFilterPredicate, null);
  }

  /**
   * Method under test: {@link ComplexFilterPredicate#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ComplexFilterPredicate complexFilterPredicate = new ComplexFilterPredicate();
    complexFilterPredicate.setOperation(ComplexFilterPredicate.ComplexOperation.AND);
    complexFilterPredicate.setPredicates(new ArrayList<>());

    // Act and Assert
    assertNotEquals(complexFilterPredicate, "Different type to ComplexFilterPredicate");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ComplexFilterPredicate}
   *   <li>
   * {@link ComplexFilterPredicate#setOperation(ComplexFilterPredicate.ComplexOperation)}
   *   <li>{@link ComplexFilterPredicate#setPredicates(List)}
   *   <li>{@link ComplexFilterPredicate#toString()}
   *   <li>{@link ComplexFilterPredicate#getOperation()}
   *   <li>{@link ComplexFilterPredicate#getPredicates()}
   *   <li>{@link ComplexFilterPredicate#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ComplexFilterPredicate actualComplexFilterPredicate = new ComplexFilterPredicate();
    actualComplexFilterPredicate.setOperation(ComplexFilterPredicate.ComplexOperation.AND);
    ArrayList<KeyFilterPredicate> predicates = new ArrayList<>();
    actualComplexFilterPredicate.setPredicates(predicates);
    String actualToStringResult = actualComplexFilterPredicate.toString();
    ComplexFilterPredicate.ComplexOperation actualOperation = actualComplexFilterPredicate.getOperation();
    List<KeyFilterPredicate> actualPredicates = actualComplexFilterPredicate.getPredicates();

    // Assert that nothing has changed
    assertEquals("ComplexFilterPredicate(operation=AND, predicates=[])", actualToStringResult);
    assertEquals(ComplexFilterPredicate.ComplexOperation.AND, actualOperation);
    assertEquals(FilterPredicateType.COMPLEX, actualComplexFilterPredicate.getType());
    assertTrue(actualPredicates.isEmpty());
    assertSame(predicates, actualPredicates);
  }
}
