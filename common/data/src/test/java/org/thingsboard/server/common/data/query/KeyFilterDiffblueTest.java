package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KeyFilterDiffblueTest {
  /**
   * Test {@link KeyFilter#equals(Object)}, and {@link KeyFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KeyFilter#equals(Object)}
   *   <li>{@link KeyFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(null);
    keyFilter.setValueType(EntityKeyValueType.STRING);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter2.setPredicate(null);
    keyFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertEquals(keyFilter, keyFilter2);
    int expectedHashCodeResult = keyFilter.hashCode();
    assertEquals(expectedHashCodeResult, keyFilter2.hashCode());
  }

  /**
   * Test {@link KeyFilter#equals(Object)}, and {@link KeyFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KeyFilter#equals(Object)}
   *   <li>{@link KeyFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertEquals(keyFilter, keyFilter);
    int expectedHashCodeResult = keyFilter.hashCode();
    assertEquals(expectedHashCodeResult, keyFilter.hashCode());
  }

  /**
   * Test {@link KeyFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.STRING);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter2.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(keyFilter, keyFilter2);
  }

  /**
   * Test {@link KeyFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(null, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.STRING);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter2.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(keyFilter, keyFilter2);
  }

  /**
   * Test {@link KeyFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(null);
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.STRING);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter2.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(keyFilter, keyFilter2);
  }

  /**
   * Test {@link KeyFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(null);
    keyFilter.setValueType(EntityKeyValueType.STRING);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter2.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(keyFilter, keyFilter2);
  }

  /**
   * Test {@link KeyFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(null);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter2.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(keyFilter, keyFilter2);
  }

  /**
   * Test {@link KeyFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.NUMERIC);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter2.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(keyFilter, keyFilter2);
  }

  /**
   * Test {@link KeyFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(null);
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.STRING);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(null);
    keyFilter2.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter2.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(keyFilter, keyFilter2);
  }

  /**
   * Test {@link KeyFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(null);

    KeyFilter keyFilter2 = new KeyFilter();
    keyFilter2.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter2.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter2.setValueType(null);

    // Act and Assert
    assertNotEquals(keyFilter, keyFilter2);
  }

  /**
   * Test {@link KeyFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(keyFilter, null);
  }

  /**
   * Test {@link KeyFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link KeyFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    KeyFilter keyFilter = new KeyFilter();
    keyFilter.setKey(new EntityKey(EntityKeyType.ATTRIBUTE, "Key"));
    keyFilter.setPredicate(mock(KeyFilterPredicate.class));
    keyFilter.setValueType(EntityKeyValueType.STRING);

    // Act and Assert
    assertNotEquals(keyFilter, "Different type to KeyFilter");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link KeyFilter}
   *   <li>{@link KeyFilter#setKey(EntityKey)}
   *   <li>{@link KeyFilter#setPredicate(KeyFilterPredicate)}
   *   <li>{@link KeyFilter#setValueType(EntityKeyValueType)}
   *   <li>{@link KeyFilter#toString()}
   *   <li>{@link KeyFilter#getKey()}
   *   <li>{@link KeyFilter#getPredicate()}
   *   <li>{@link KeyFilter#getValueType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    KeyFilter actualKeyFilter = new KeyFilter();
    EntityKey key = new EntityKey(EntityKeyType.ATTRIBUTE, "Key");

    actualKeyFilter.setKey(key);
    KeyFilterPredicate predicate = mock(KeyFilterPredicate.class);
    actualKeyFilter.setPredicate(predicate);
    actualKeyFilter.setValueType(EntityKeyValueType.STRING);
    actualKeyFilter.toString();
    EntityKey actualKey = actualKeyFilter.getKey();
    KeyFilterPredicate actualPredicate = actualKeyFilter.getPredicate();

    // Assert that nothing has changed
    assertEquals(EntityKeyValueType.STRING, actualKeyFilter.getValueType());
    assertSame(key, actualKey);
    assertSame(predicate, actualPredicate);
  }
}
