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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.EntityDataSortOrder.Direction;

class EntityDataSortOrderDiffblueTest {
  /**
   * Test {@link EntityDataSortOrder#equals(Object)}, and {@link EntityDataSortOrder#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataSortOrder#equals(Object)}
   *   <li>{@link EntityDataSortOrder#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataSortOrder.equals(Object)",
    "int EntityDataSortOrder.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder = new EntityDataSortOrder();
    EntityDataSortOrder entityDataSortOrder2 = new EntityDataSortOrder();

    // Act and Assert
    assertEquals(entityDataSortOrder, entityDataSortOrder2);
    assertEquals(entityDataSortOrder.hashCode(), entityDataSortOrder2.hashCode());
  }

  /**
   * Test {@link EntityDataSortOrder#equals(Object)}, and {@link EntityDataSortOrder#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataSortOrder#equals(Object)}
   *   <li>{@link EntityDataSortOrder#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataSortOrder.equals(Object)",
    "int EntityDataSortOrder.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder =
        new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    EntityDataSortOrder entityDataSortOrder2 =
        new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    // Act and Assert
    assertEquals(entityDataSortOrder, entityDataSortOrder2);
    assertEquals(entityDataSortOrder.hashCode(), entityDataSortOrder2.hashCode());
  }

  /**
   * Test {@link EntityDataSortOrder#equals(Object)}, and {@link EntityDataSortOrder#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataSortOrder#equals(Object)}
   *   <li>{@link EntityDataSortOrder#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataSortOrder.equals(Object)",
    "int EntityDataSortOrder.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder = new EntityDataSortOrder();

    // Act and Assert
    assertEquals(entityDataSortOrder, entityDataSortOrder);
    int expectedHashCodeResult = entityDataSortOrder.hashCode();
    assertEquals(expectedHashCodeResult, entityDataSortOrder.hashCode());
  }

  /**
   * Test {@link EntityDataSortOrder#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataSortOrder.equals(Object)",
    "int EntityDataSortOrder.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder =
        new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    // Act and Assert
    assertNotEquals(entityDataSortOrder, new EntityDataSortOrder());
  }

  /**
   * Test {@link EntityDataSortOrder#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataSortOrder.equals(Object)",
    "int EntityDataSortOrder.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder = new EntityDataSortOrder();

    // Act and Assert
    assertNotEquals(
        entityDataSortOrder,
        new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key")));
  }

  /**
   * Test {@link EntityDataSortOrder#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataSortOrder.equals(Object)",
    "int EntityDataSortOrder.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder = new EntityDataSortOrder();
    entityDataSortOrder.setDirection(Direction.ASC);

    // Act and Assert
    assertNotEquals(entityDataSortOrder, new EntityDataSortOrder());
  }

  /**
   * Test {@link EntityDataSortOrder#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataSortOrder.equals(Object)",
    "int EntityDataSortOrder.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder = new EntityDataSortOrder();

    EntityDataSortOrder entityDataSortOrder2 = new EntityDataSortOrder();
    entityDataSortOrder2.setDirection(Direction.ASC);

    // Act and Assert
    assertNotEquals(entityDataSortOrder, entityDataSortOrder2);
  }

  /**
   * Test {@link EntityDataSortOrder#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataSortOrder.equals(Object)",
    "int EntityDataSortOrder.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataSortOrder(), null);
  }

  /**
   * Test {@link EntityDataSortOrder#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityDataSortOrder.equals(Object)",
    "int EntityDataSortOrder.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataSortOrder(), "Different type to EntityDataSortOrder");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataSortOrder#EntityDataSortOrder()}
   *   <li>{@link EntityDataSortOrder#setDirection(Direction)}
   *   <li>{@link EntityDataSortOrder#setKey(EntityKey)}
   *   <li>{@link EntityDataSortOrder#toString()}
   *   <li>{@link EntityDataSortOrder#getDirection()}
   *   <li>{@link EntityDataSortOrder#getKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDataSortOrder.<init>()",
    "void EntityDataSortOrder.<init>(EntityKey, Direction)",
    "Direction EntityDataSortOrder.getDirection()",
    "EntityKey EntityDataSortOrder.getKey()",
    "void EntityDataSortOrder.setDirection(Direction)",
    "void EntityDataSortOrder.setKey(EntityKey)",
    "String EntityDataSortOrder.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityDataSortOrder actualEntityDataSortOrder = new EntityDataSortOrder();
    actualEntityDataSortOrder.setDirection(Direction.ASC);
    EntityKey key = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");
    actualEntityDataSortOrder.setKey(key);
    String actualToStringResult = actualEntityDataSortOrder.toString();
    Direction actualDirection = actualEntityDataSortOrder.getDirection();

    // Assert
    assertEquals(
        "EntityDataSortOrder(key=EntityKey(type=ATTRIBUTE, key=Key), direction=ASC)",
        actualToStringResult);
    assertEquals(Direction.ASC, actualDirection);
    assertSame(key, actualEntityDataSortOrder.getKey());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link EntityKey#EntityKey(EntityKeyType, String)} with type is {@code ATTRIBUTE}
   *       and {@code Key}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityDataSortOrder#EntityDataSortOrder(EntityKey, Direction)}
   *   <li>{@link EntityDataSortOrder#setDirection(Direction)}
   *   <li>{@link EntityDataSortOrder#setKey(EntityKey)}
   *   <li>{@link EntityDataSortOrder#toString()}
   *   <li>{@link EntityDataSortOrder#getDirection()}
   *   <li>{@link EntityDataSortOrder#getKey()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when EntityKey(EntityKeyType, String) with type is 'ATTRIBUTE' and 'Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityDataSortOrder.<init>()",
    "void EntityDataSortOrder.<init>(EntityKey, Direction)",
    "Direction EntityDataSortOrder.getDirection()",
    "EntityKey EntityDataSortOrder.getKey()",
    "void EntityDataSortOrder.setDirection(Direction)",
    "void EntityDataSortOrder.setKey(EntityKey)",
    "String EntityDataSortOrder.toString()"
  })
  void testGettersAndSetters_whenEntityKeyWithTypeIsAttributeAndKey() {
    // Arrange and Act
    EntityDataSortOrder actualEntityDataSortOrder =
        new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"), Direction.ASC);
    actualEntityDataSortOrder.setDirection(Direction.ASC);
    EntityKey key = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");
    actualEntityDataSortOrder.setKey(key);
    String actualToStringResult = actualEntityDataSortOrder.toString();
    Direction actualDirection = actualEntityDataSortOrder.getDirection();

    // Assert
    assertEquals(
        "EntityDataSortOrder(key=EntityKey(type=ATTRIBUTE, key=Key), direction=ASC)",
        actualToStringResult);
    assertEquals(Direction.ASC, actualDirection);
    assertSame(key, actualEntityDataSortOrder.getKey());
  }

  /**
   * Test {@link EntityDataSortOrder#EntityDataSortOrder(EntityKey)}.
   *
   * <p>Method under test: {@link EntityDataSortOrder#EntityDataSortOrder(EntityKey)}
   */
  @Test
  @DisplayName("Test new EntityDataSortOrder(EntityKey)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityDataSortOrder.<init>(EntityKey)"})
  void testNewEntityDataSortOrder() {
    // Arrange
    EntityKey key = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");

    // Act
    EntityDataSortOrder actualEntityDataSortOrder = new EntityDataSortOrder(key);

    // Assert
    assertEquals(Direction.ASC, actualEntityDataSortOrder.getDirection());
    assertSame(key, actualEntityDataSortOrder.getKey());
  }
}
