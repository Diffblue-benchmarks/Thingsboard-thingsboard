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

class EntityDataSortOrderDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataSortOrder#equals(Object)}
   *   <li>{@link EntityDataSortOrder#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder = new EntityDataSortOrder();
    EntityDataSortOrder entityDataSortOrder2 = new EntityDataSortOrder();

    // Act and Assert
    assertEquals(entityDataSortOrder, entityDataSortOrder2);
    int expectedHashCodeResult = entityDataSortOrder.hashCode();
    assertEquals(expectedHashCodeResult, entityDataSortOrder2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataSortOrder#equals(Object)}
   *   <li>{@link EntityDataSortOrder#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder = new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    EntityDataSortOrder entityDataSortOrder2 = new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    // Act and Assert
    assertEquals(entityDataSortOrder, entityDataSortOrder2);
    int expectedHashCodeResult = entityDataSortOrder.hashCode();
    assertEquals(expectedHashCodeResult, entityDataSortOrder2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataSortOrder#equals(Object)}
   *   <li>{@link EntityDataSortOrder#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder = new EntityDataSortOrder();

    // Act and Assert
    assertEquals(entityDataSortOrder, entityDataSortOrder);
    int expectedHashCodeResult = entityDataSortOrder.hashCode();
    assertEquals(expectedHashCodeResult, entityDataSortOrder.hashCode());
  }

  /**
   * Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder = new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    // Act and Assert
    assertNotEquals(entityDataSortOrder, new EntityDataSortOrder());
  }

  /**
   * Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder = new EntityDataSortOrder();

    // Act and Assert
    assertNotEquals(entityDataSortOrder, new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key")));
  }

  /**
   * Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder = new EntityDataSortOrder();
    entityDataSortOrder.setDirection(EntityDataSortOrder.Direction.ASC);

    // Act and Assert
    assertNotEquals(entityDataSortOrder, new EntityDataSortOrder());
  }

  /**
   * Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder = new EntityDataSortOrder(mock(EntityKey.class));

    // Act and Assert
    assertNotEquals(entityDataSortOrder, new EntityDataSortOrder());
  }

  /**
   * Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder = new EntityDataSortOrder();

    EntityDataSortOrder entityDataSortOrder2 = new EntityDataSortOrder();
    entityDataSortOrder2.setDirection(EntityDataSortOrder.Direction.ASC);

    // Act and Assert
    assertNotEquals(entityDataSortOrder, entityDataSortOrder2);
  }

  /**
   * Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataSortOrder(), null);
  }

  /**
   * Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataSortOrder(), "Different type to EntityDataSortOrder");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataSortOrder#EntityDataSortOrder()}
   *   <li>{@link EntityDataSortOrder#setDirection(EntityDataSortOrder.Direction)}
   *   <li>{@link EntityDataSortOrder#setKey(EntityKey)}
   *   <li>{@link EntityDataSortOrder#toString()}
   *   <li>{@link EntityDataSortOrder#getDirection()}
   *   <li>{@link EntityDataSortOrder#getKey()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntityDataSortOrder actualEntityDataSortOrder = new EntityDataSortOrder();
    actualEntityDataSortOrder.setDirection(EntityDataSortOrder.Direction.ASC);
    EntityKey key = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");

    actualEntityDataSortOrder.setKey(key);
    String actualToStringResult = actualEntityDataSortOrder.toString();
    EntityDataSortOrder.Direction actualDirection = actualEntityDataSortOrder.getDirection();

    // Assert that nothing has changed
    assertEquals("EntityDataSortOrder(key=EntityKey(type=ATTRIBUTE, key=Key), direction=ASC)", actualToStringResult);
    assertEquals(EntityDataSortOrder.Direction.ASC, actualDirection);
    assertSame(key, actualEntityDataSortOrder.getKey());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityDataSortOrder#EntityDataSortOrder(EntityKey, EntityDataSortOrder.Direction)}
   *   <li>{@link EntityDataSortOrder#setDirection(EntityDataSortOrder.Direction)}
   *   <li>{@link EntityDataSortOrder#setKey(EntityKey)}
   *   <li>{@link EntityDataSortOrder#toString()}
   *   <li>{@link EntityDataSortOrder#getDirection()}
   *   <li>{@link EntityDataSortOrder#getKey()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    EntityDataSortOrder actualEntityDataSortOrder = new EntityDataSortOrder(
        new EntityKey(EntityKeyType.ATTRIBUTE, "Key"), EntityDataSortOrder.Direction.ASC);
    actualEntityDataSortOrder.setDirection(EntityDataSortOrder.Direction.ASC);
    EntityKey key = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");

    actualEntityDataSortOrder.setKey(key);
    String actualToStringResult = actualEntityDataSortOrder.toString();
    EntityDataSortOrder.Direction actualDirection = actualEntityDataSortOrder.getDirection();

    // Assert that nothing has changed
    assertEquals("EntityDataSortOrder(key=EntityKey(type=ATTRIBUTE, key=Key), direction=ASC)", actualToStringResult);
    assertEquals(EntityDataSortOrder.Direction.ASC, actualDirection);
    assertSame(key, actualEntityDataSortOrder.getKey());
  }

  /**
   * Method under test: {@link EntityDataSortOrder#EntityDataSortOrder(EntityKey)}
   */
  @Test
  void testNewEntityDataSortOrder() {
    // Arrange
    EntityKey key = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");

    // Act
    EntityDataSortOrder actualEntityDataSortOrder = new EntityDataSortOrder(key);

    // Assert
    assertEquals(EntityDataSortOrder.Direction.ASC, actualEntityDataSortOrder.getDirection());
    assertSame(key, actualEntityDataSortOrder.getKey());
  }
}
