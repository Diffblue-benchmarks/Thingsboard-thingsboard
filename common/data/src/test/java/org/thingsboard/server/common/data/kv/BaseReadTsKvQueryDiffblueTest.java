package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseReadTsKvQueryDiffblueTest {
  /**
   * Test {@link BaseReadTsKvQuery#BaseReadTsKvQuery(ReadTsKvQuery, long, long)}.
   * <p>
   * Method under test:
   * {@link BaseReadTsKvQuery#BaseReadTsKvQuery(ReadTsKvQuery, long, long)}
   */
  @Test
  @DisplayName("Test new BaseReadTsKvQuery(ReadTsKvQuery, long, long)")
  void testNewBaseReadTsKvQuery() {
    // Arrange
    BaseReadTsKvQuery query = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertEquals(query, new BaseReadTsKvQuery(query, 1L, 1L));
  }

  /**
   * Test {@link BaseReadTsKvQuery#equals(Object)}, and
   * {@link BaseReadTsKvQuery#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseReadTsKvQuery#equals(Object)}
   *   <li>{@link BaseReadTsKvQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BaseReadTsKvQuery baseReadTsKvQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertEquals(baseReadTsKvQuery, baseReadTsKvQuery);
    int expectedHashCodeResult = baseReadTsKvQuery.hashCode();
    assertEquals(expectedHashCodeResult, baseReadTsKvQuery.hashCode());
  }

  /**
   * Test {@link BaseReadTsKvQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseReadTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BaseReadTsKvQuery baseReadTsKvQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertNotEquals(baseReadTsKvQuery, new BaseReadTsKvQuery("Key", 1L, 1L));
  }

  /**
   * Test {@link BaseReadTsKvQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseReadTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseReadTsKvQuery("Key", 1L, 1L), mock(BaseDeleteTsKvQuery.class));
  }

  /**
   * Test {@link BaseReadTsKvQuery#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseReadTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseReadTsKvQuery("Key", 1L, 1L), null);
  }

  /**
   * Test {@link BaseReadTsKvQuery#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseReadTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseReadTsKvQuery("Key", 1L, 1L), "Different type to BaseReadTsKvQuery");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseReadTsKvQuery#toString()}
   *   <li>{@link BaseReadTsKvQuery#getAggParameters()}
   *   <li>{@link BaseReadTsKvQuery#getLimit()}
   *   <li>{@link BaseReadTsKvQuery#getOrder()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    BaseReadTsKvQuery baseReadTsKvQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Act
    baseReadTsKvQuery.toString();
    AggregationParams actualAggParameters = baseReadTsKvQuery.getAggParameters();
    int actualLimit = baseReadTsKvQuery.getLimit();

    // Assert
    assertEquals("DESC", baseReadTsKvQuery.getOrder());
    assertNull(actualAggParameters.getTzId());
    assertEquals(0L, actualAggParameters.getInterval());
    assertEquals(1, actualLimit);
    assertEquals(Aggregation.AVG, actualAggParameters.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, actualAggParameters.getIntervalType());
  }
}
