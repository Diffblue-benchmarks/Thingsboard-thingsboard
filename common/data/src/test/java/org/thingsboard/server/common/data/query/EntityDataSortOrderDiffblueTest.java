package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EntityDataSortOrderDiffblueTest {
  /**
   * Test {@link EntityDataSortOrder#equals(Object)}, and
   * {@link EntityDataSortOrder#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataSortOrder#equals(Object)}
   *   <li>{@link EntityDataSortOrder#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link EntityDataSortOrder#equals(Object)}, and
   * {@link EntityDataSortOrder#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataSortOrder#equals(Object)}
   *   <li>{@link EntityDataSortOrder#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link EntityDataSortOrder#equals(Object)}, and
   * {@link EntityDataSortOrder#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataSortOrder#equals(Object)}
   *   <li>{@link EntityDataSortOrder#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder = new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));

    // Act and Assert
    assertNotEquals(entityDataSortOrder, new EntityDataSortOrder());
  }

  /**
   * Test {@link EntityDataSortOrder#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder = new EntityDataSortOrder();

    // Act and Assert
    assertNotEquals(entityDataSortOrder, new EntityDataSortOrder(new EntityKey(EntityKeyType.ATTRIBUTE, "Key")));
  }

  /**
   * Test {@link EntityDataSortOrder#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder = new EntityDataSortOrder();
    entityDataSortOrder.setDirection(EntityDataSortOrder.Direction.ASC);

    // Act and Assert
    assertNotEquals(entityDataSortOrder, new EntityDataSortOrder());
  }

  /**
   * Test {@link EntityDataSortOrder#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder = new EntityDataSortOrder(mock(EntityKey.class));

    // Act and Assert
    assertNotEquals(entityDataSortOrder, new EntityDataSortOrder());
  }

  /**
   * Test {@link EntityDataSortOrder#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityDataSortOrder entityDataSortOrder = new EntityDataSortOrder();

    EntityDataSortOrder entityDataSortOrder2 = new EntityDataSortOrder();
    entityDataSortOrder2.setDirection(EntityDataSortOrder.Direction.ASC);

    // Act and Assert
    assertNotEquals(entityDataSortOrder, entityDataSortOrder2);
  }

  /**
   * Test {@link EntityDataSortOrder#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataSortOrder(), null);
  }

  /**
   * Test {@link EntityDataSortOrder#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataSortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityDataSortOrder(), "Different type to EntityDataSortOrder");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@link EntityKey#EntityKey(EntityKeyType, String)} with type is
   * {@code ATTRIBUTE} and {@code Key}.</li>
   * </ul>
   * <p>
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
  @DisplayName("Test getters and setters; when EntityKey(EntityKeyType, String) with type is 'ATTRIBUTE' and 'Key'")
  void testGettersAndSetters_whenEntityKeyWithTypeIsAttributeAndKey() {
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
   * Test {@link EntityDataSortOrder#EntityDataSortOrder(EntityKey)}.
   * <p>
   * Method under test: {@link EntityDataSortOrder#EntityDataSortOrder(EntityKey)}
   */
  @Test
  @DisplayName("Test new EntityDataSortOrder(EntityKey)")
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
