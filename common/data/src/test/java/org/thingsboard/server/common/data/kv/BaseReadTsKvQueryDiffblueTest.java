package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BaseReadTsKvQueryDiffblueTest {
  /**
   * Test {@link BaseReadTsKvQuery#BaseReadTsKvQuery(String, long, long)}.
   *
   * <p>Method under test: {@link BaseReadTsKvQuery#BaseReadTsKvQuery(String, long, long)}
   */
  @Test
  @DisplayName("Test new BaseReadTsKvQuery(String, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseReadTsKvQuery.<init>(String, long, long)"})
  void testNewBaseReadTsKvQuery() {
    // Arrange and Act
    BaseReadTsKvQuery actualBaseReadTsKvQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Assert
    assertEquals("DESC", actualBaseReadTsKvQuery.getOrder());
    assertEquals("Key", actualBaseReadTsKvQuery.getKey());
    AggregationParams aggParameters = actualBaseReadTsKvQuery.getAggParameters();
    assertNull(aggParameters.getTzId());
    assertEquals(0L, aggParameters.getInterval());
    assertEquals(0L, actualBaseReadTsKvQuery.getInterval());
    assertEquals(1, actualBaseReadTsKvQuery.getLimit());
    assertEquals(1L, actualBaseReadTsKvQuery.getEndTs());
    assertEquals(1L, actualBaseReadTsKvQuery.getStartTs());
    assertEquals(Aggregation.AVG, aggParameters.getAggregation());
    assertEquals(Aggregation.AVG, actualBaseReadTsKvQuery.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, aggParameters.getIntervalType());
  }

  /**
   * Test {@link BaseReadTsKvQuery#BaseReadTsKvQuery(String, long, long, int, String)}.
   *
   * <p>Method under test: {@link BaseReadTsKvQuery#BaseReadTsKvQuery(String, long, long, int,
   * String)}
   */
  @Test
  @DisplayName("Test new BaseReadTsKvQuery(String, long, long, int, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseReadTsKvQuery.<init>(String, long, long, int, String)"})
  void testNewBaseReadTsKvQuery2() {
    // Arrange and Act
    BaseReadTsKvQuery actualBaseReadTsKvQuery = new BaseReadTsKvQuery("Key", 1L, 1L, 1, "Order");

    // Assert
    assertEquals("Key", actualBaseReadTsKvQuery.getKey());
    assertEquals("Order", actualBaseReadTsKvQuery.getOrder());
    AggregationParams aggParameters = actualBaseReadTsKvQuery.getAggParameters();
    assertNull(aggParameters.getTzId());
    assertNull(aggParameters.getIntervalType());
    assertEquals(0L, aggParameters.getInterval());
    assertEquals(0L, actualBaseReadTsKvQuery.getInterval());
    assertEquals(1, actualBaseReadTsKvQuery.getLimit());
    assertEquals(1L, actualBaseReadTsKvQuery.getEndTs());
    assertEquals(1L, actualBaseReadTsKvQuery.getStartTs());
    assertEquals(Aggregation.NONE, aggParameters.getAggregation());
    assertEquals(Aggregation.NONE, actualBaseReadTsKvQuery.getAggregation());
  }

  /**
   * Test {@link BaseReadTsKvQuery#BaseReadTsKvQuery(String, long, long, long, int, Aggregation)}.
   *
   * <p>Method under test: {@link BaseReadTsKvQuery#BaseReadTsKvQuery(String, long, long, long, int,
   * Aggregation)}
   */
  @Test
  @DisplayName("Test new BaseReadTsKvQuery(String, long, long, long, int, Aggregation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseReadTsKvQuery.<init>(String, long, long, long, int, Aggregation)"})
  void testNewBaseReadTsKvQuery3() {
    // Arrange and Act
    BaseReadTsKvQuery actualBaseReadTsKvQuery =
        new BaseReadTsKvQuery("Key", 1L, 1L, 42L, 1, Aggregation.MIN);

    // Assert
    assertEquals("DESC", actualBaseReadTsKvQuery.getOrder());
    assertEquals("Key", actualBaseReadTsKvQuery.getKey());
    assertEquals(1, actualBaseReadTsKvQuery.getLimit());
    assertEquals(1L, actualBaseReadTsKvQuery.getEndTs());
    assertEquals(1L, actualBaseReadTsKvQuery.getStartTs());
    AggregationParams aggParameters = actualBaseReadTsKvQuery.getAggParameters();
    assertEquals(42L, aggParameters.getInterval());
    assertEquals(42L, actualBaseReadTsKvQuery.getInterval());
    assertEquals(Aggregation.MIN, aggParameters.getAggregation());
    assertEquals(Aggregation.MIN, actualBaseReadTsKvQuery.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, aggParameters.getIntervalType());
  }

  /**
   * Test {@link BaseReadTsKvQuery#BaseReadTsKvQuery(String, long, long, long, int, Aggregation,
   * String)}.
   *
   * <p>Method under test: {@link BaseReadTsKvQuery#BaseReadTsKvQuery(String, long, long, long, int,
   * Aggregation, String)}
   */
  @Test
  @DisplayName("Test new BaseReadTsKvQuery(String, long, long, long, int, Aggregation, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseReadTsKvQuery.<init>(String, long, long, long, int, Aggregation, String)"
  })
  void testNewBaseReadTsKvQuery4() {
    // Arrange and Act
    BaseReadTsKvQuery actualBaseReadTsKvQuery =
        new BaseReadTsKvQuery("Key", 1L, 1L, 42L, 1, Aggregation.MIN, "Desc Order");

    // Assert
    assertEquals("Desc Order", actualBaseReadTsKvQuery.getOrder());
    assertEquals("Key", actualBaseReadTsKvQuery.getKey());
    assertEquals(1, actualBaseReadTsKvQuery.getLimit());
    assertEquals(1L, actualBaseReadTsKvQuery.getEndTs());
    assertEquals(1L, actualBaseReadTsKvQuery.getStartTs());
    AggregationParams aggParameters = actualBaseReadTsKvQuery.getAggParameters();
    assertEquals(42L, aggParameters.getInterval());
    assertEquals(42L, actualBaseReadTsKvQuery.getInterval());
    assertEquals(Aggregation.MIN, aggParameters.getAggregation());
    assertEquals(Aggregation.MIN, actualBaseReadTsKvQuery.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, aggParameters.getIntervalType());
  }

  /**
   * Test {@link BaseReadTsKvQuery#BaseReadTsKvQuery(String, long, long, AggregationParams, int)}.
   *
   * <p>Method under test: {@link BaseReadTsKvQuery#BaseReadTsKvQuery(String, long, long,
   * AggregationParams, int)}
   */
  @Test
  @DisplayName("Test new BaseReadTsKvQuery(String, long, long, AggregationParams, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseReadTsKvQuery.<init>(String, long, long, AggregationParams, int)"})
  void testNewBaseReadTsKvQuery5() {
    // Arrange
    AggregationParams parameters = AggregationParams.none();

    // Act
    BaseReadTsKvQuery actualBaseReadTsKvQuery = new BaseReadTsKvQuery("Key", 1L, 1L, parameters, 1);

    // Assert
    assertEquals("DESC", actualBaseReadTsKvQuery.getOrder());
    assertEquals("Key", actualBaseReadTsKvQuery.getKey());
    assertEquals(0L, actualBaseReadTsKvQuery.getInterval());
    assertEquals(1, actualBaseReadTsKvQuery.getLimit());
    assertEquals(1L, actualBaseReadTsKvQuery.getEndTs());
    assertEquals(1L, actualBaseReadTsKvQuery.getStartTs());
    assertEquals(Aggregation.NONE, actualBaseReadTsKvQuery.getAggregation());
    assertSame(parameters, actualBaseReadTsKvQuery.getAggParameters());
  }

  /**
   * Test {@link BaseReadTsKvQuery#BaseReadTsKvQuery(String, long, long, AggregationParams, int,
   * String)}.
   *
   * <p>Method under test: {@link BaseReadTsKvQuery#BaseReadTsKvQuery(String, long, long,
   * AggregationParams, int, String)}
   */
  @Test
  @DisplayName("Test new BaseReadTsKvQuery(String, long, long, AggregationParams, int, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseReadTsKvQuery.<init>(String, long, long, AggregationParams, int, String)"
  })
  void testNewBaseReadTsKvQuery6() {
    // Arrange
    AggregationParams parameters = AggregationParams.none();

    // Act
    BaseReadTsKvQuery actualBaseReadTsKvQuery =
        new BaseReadTsKvQuery("Key", 1L, 1L, parameters, 1, "Order");

    // Assert
    assertEquals("Key", actualBaseReadTsKvQuery.getKey());
    assertEquals("Order", actualBaseReadTsKvQuery.getOrder());
    assertEquals(0L, actualBaseReadTsKvQuery.getInterval());
    assertEquals(1, actualBaseReadTsKvQuery.getLimit());
    assertEquals(1L, actualBaseReadTsKvQuery.getEndTs());
    assertEquals(1L, actualBaseReadTsKvQuery.getStartTs());
    assertEquals(Aggregation.NONE, actualBaseReadTsKvQuery.getAggregation());
    assertSame(parameters, actualBaseReadTsKvQuery.getAggParameters());
  }

  /**
   * Test {@link BaseReadTsKvQuery#BaseReadTsKvQuery(ReadTsKvQuery, long, long)}.
   *
   * <p>Method under test: {@link BaseReadTsKvQuery#BaseReadTsKvQuery(ReadTsKvQuery, long, long)}
   */
  @Test
  @DisplayName("Test new BaseReadTsKvQuery(ReadTsKvQuery, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseReadTsKvQuery.<init>(ReadTsKvQuery, long, long)"})
  void testNewBaseReadTsKvQuery7() {
    // Arrange
    BaseReadTsKvQuery query = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Act
    BaseReadTsKvQuery actualBaseReadTsKvQuery = new BaseReadTsKvQuery(query, 1L, 1L);

    // Assert
    assertEquals(query, actualBaseReadTsKvQuery);
  }

  /**
   * Test {@link BaseReadTsKvQuery#equals(Object)}, and {@link BaseReadTsKvQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseReadTsKvQuery#equals(Object)}
   *   <li>{@link BaseReadTsKvQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseReadTsKvQuery.equals(Object)",
    "int BaseReadTsKvQuery.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseReadTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseReadTsKvQuery.equals(Object)",
    "int BaseReadTsKvQuery.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BaseReadTsKvQuery baseReadTsKvQuery = new BaseReadTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertNotEquals(baseReadTsKvQuery, new BaseReadTsKvQuery("Key", 1L, 1L));
  }

  /**
   * Test {@link BaseReadTsKvQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseReadTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseReadTsKvQuery.equals(Object)",
    "int BaseReadTsKvQuery.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseReadTsKvQuery("Key", 1L, 1L), null);
  }

  /**
   * Test {@link BaseReadTsKvQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BaseReadTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseReadTsKvQuery.equals(Object)",
    "int BaseReadTsKvQuery.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseReadTsKvQuery("Key", 1L, 1L), "Different type to BaseReadTsKvQuery");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BaseReadTsKvQuery#toString()}
   *   <li>{@link BaseReadTsKvQuery#getAggParameters()}
   *   <li>{@link BaseReadTsKvQuery#getLimit()}
   *   <li>{@link BaseReadTsKvQuery#getOrder()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AggregationParams BaseReadTsKvQuery.getAggParameters()",
    "int BaseReadTsKvQuery.getLimit()",
    "String BaseReadTsKvQuery.getOrder()",
    "String BaseReadTsKvQuery.toString()"
  })
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
