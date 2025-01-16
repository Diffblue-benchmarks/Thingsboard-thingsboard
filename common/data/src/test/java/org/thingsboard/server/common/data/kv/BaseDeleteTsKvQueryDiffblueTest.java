package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseDeleteTsKvQueryDiffblueTest {
  /**
   * Test {@link BaseDeleteTsKvQuery#equals(Object)}, and
   * {@link BaseDeleteTsKvQuery#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseDeleteTsKvQuery#equals(Object)}
   *   <li>{@link BaseDeleteTsKvQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L);
    BaseDeleteTsKvQuery baseDeleteTsKvQuery2 = new BaseDeleteTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertEquals(baseDeleteTsKvQuery, baseDeleteTsKvQuery2);
    int expectedHashCodeResult = baseDeleteTsKvQuery.hashCode();
    assertEquals(expectedHashCodeResult, baseDeleteTsKvQuery2.hashCode());
  }

  /**
   * Test {@link BaseDeleteTsKvQuery#equals(Object)}, and
   * {@link BaseDeleteTsKvQuery#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseDeleteTsKvQuery#equals(Object)}
   *   <li>{@link BaseDeleteTsKvQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertEquals(baseDeleteTsKvQuery, baseDeleteTsKvQuery);
    int expectedHashCodeResult = baseDeleteTsKvQuery.hashCode();
    assertEquals(expectedHashCodeResult, baseDeleteTsKvQuery.hashCode());
  }

  /**
   * Test {@link BaseDeleteTsKvQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDeleteTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L, true);

    // Act and Assert
    assertNotEquals(baseDeleteTsKvQuery, new BaseDeleteTsKvQuery("Key", 1L, 1L));
  }

  /**
   * Test {@link BaseDeleteTsKvQuery#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDeleteTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseDeleteTsKvQuery("Key", 1L, 1L), null);
  }

  /**
   * Test {@link BaseDeleteTsKvQuery#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDeleteTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseDeleteTsKvQuery("Key", 1L, 1L), "Different type to BaseDeleteTsKvQuery");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseDeleteTsKvQuery#toString()}
   *   <li>{@link BaseDeleteTsKvQuery#getDeleteLatest()}
   *   <li>{@link BaseDeleteTsKvQuery#getRewriteLatestIfDeleted()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L);

    // Act
    String actualToStringResult = baseDeleteTsKvQuery.toString();
    Boolean actualDeleteLatest = baseDeleteTsKvQuery.getDeleteLatest();

    // Assert
    assertEquals("BaseDeleteTsKvQuery(rewriteLatestIfDeleted=false, deleteLatest=true)", actualToStringResult);
    assertFalse(baseDeleteTsKvQuery.getRewriteLatestIfDeleted());
    assertTrue(actualDeleteLatest);
  }
}
