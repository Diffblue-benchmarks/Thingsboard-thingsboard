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
package org.thingsboard.server.common.data.page;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class SortOrderDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SortOrder#equals(Object)}
   *   <li>{@link SortOrder#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SortOrder sortOrder = SortOrder.BY_CREATED_TIME_DESC;
    SortOrder sortOrder2 = SortOrder.BY_CREATED_TIME_DESC;

    // Act and Assert
    assertEquals(sortOrder, sortOrder2);
    int expectedHashCodeResult = sortOrder.hashCode();
    assertEquals(expectedHashCodeResult, sortOrder2.hashCode());
  }

  /**
   * Method under test: {@link SortOrder#of(String, SortOrder.Direction)}
   */
  @Test
  void testOf() {
    // Arrange and Act
    SortOrder actualOfResult = SortOrder.of("Property", SortOrder.Direction.ASC);

    // Assert
    assertEquals("Property", actualOfResult.getProperty());
    assertEquals(SortOrder.Direction.ASC, actualOfResult.getDirection());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SortOrder#equals(Object)}
   *   <li>{@link SortOrder#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SortOrder ofResult = SortOrder.of("Property", SortOrder.Direction.ASC);
    SortOrder sortOrder = new SortOrder("Property");

    // Act and Assert
    assertEquals(ofResult, sortOrder);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, sortOrder.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SortOrder#equals(Object)}
   *   <li>{@link SortOrder#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SortOrder sortOrder = SortOrder.BY_CREATED_TIME_DESC;

    // Act and Assert
    assertEquals(sortOrder, sortOrder);
    int expectedHashCodeResult = sortOrder.hashCode();
    assertEquals(expectedHashCodeResult, sortOrder.hashCode());
  }

  /**
   * Method under test: {@link SortOrder#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SortOrder.of("Property", SortOrder.Direction.ASC), SortOrder.BY_CREATED_TIME_DESC);
    assertNotEquals(SortOrder.of("createdTime", SortOrder.Direction.ASC), SortOrder.BY_CREATED_TIME_DESC);
    assertNotEquals(SortOrder.of(null, SortOrder.Direction.ASC), SortOrder.BY_CREATED_TIME_DESC);
    assertNotEquals(SortOrder.of("createdTime", null), SortOrder.BY_CREATED_TIME_DESC);
  }

  /**
   * Method under test: {@link SortOrder#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SortOrder.BY_CREATED_TIME_DESC, null);
  }

  /**
   * Method under test: {@link SortOrder#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SortOrder.BY_CREATED_TIME_DESC, "Different type to SortOrder");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SortOrder#SortOrder(String, SortOrder.Direction)}
   *   <li>{@link SortOrder#toString()}
   *   <li>{@link SortOrder#getDirection()}
   *   <li>{@link SortOrder#getProperty()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SortOrder actualSortOrder = new SortOrder("Property", SortOrder.Direction.ASC);
    String actualToStringResult = actualSortOrder.toString();
    SortOrder.Direction actualDirection = actualSortOrder.getDirection();

    // Assert
    assertEquals("Property", actualSortOrder.getProperty());
    assertEquals("SortOrder(property=Property, direction=ASC)", actualToStringResult);
    assertEquals(SortOrder.Direction.ASC, actualDirection);
  }

  /**
   * Method under test: {@link SortOrder#SortOrder(String)}
   */
  @Test
  void testNewSortOrder() {
    // Arrange and Act
    SortOrder actualSortOrder = new SortOrder("Property");

    // Assert
    assertEquals("Property", actualSortOrder.getProperty());
    assertEquals(SortOrder.Direction.ASC, actualSortOrder.getDirection());
  }
}
