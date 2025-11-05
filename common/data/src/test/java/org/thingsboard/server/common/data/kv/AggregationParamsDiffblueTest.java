package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.ZoneId;
import java.time.ZoneOffset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AggregationParamsDiffblueTest {
  /**
   * Test {@link AggregationParams#none()}.
   *
   * <p>Method under test: {@link AggregationParams#none()}
   */
  @Test
  @DisplayName("Test none()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AggregationParams AggregationParams.none()"})
  void testNone() {
    // Arrange and Act
    AggregationParams actualNoneResult = AggregationParams.none();

    // Assert
    assertNull(actualNoneResult.getTzId());
    assertNull(actualNoneResult.getIntervalType());
    assertEquals(0L, actualNoneResult.getInterval());
    assertEquals(Aggregation.NONE, actualNoneResult.getAggregation());
  }

  /**
   * Test {@link AggregationParams#milliseconds(Aggregation, long)}.
   *
   * <p>Method under test: {@link AggregationParams#milliseconds(Aggregation, long)}
   */
  @Test
  @DisplayName("Test milliseconds(Aggregation, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AggregationParams AggregationParams.milliseconds(Aggregation, long)"})
  void testMilliseconds() {
    // Arrange and Act
    AggregationParams actualMillisecondsResult =
        AggregationParams.milliseconds(Aggregation.MIN, 42L);

    // Assert
    assertNull(actualMillisecondsResult.getTzId());
    assertEquals(42L, actualMillisecondsResult.getInterval());
    assertEquals(Aggregation.MIN, actualMillisecondsResult.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, actualMillisecondsResult.getIntervalType());
  }

  /**
   * Test {@link AggregationParams#calendar(Aggregation, IntervalType, ZoneId)} with {@code
   * aggregationType}, {@code intervalType}, {@code tzId}.
   *
   * <p>Method under test: {@link AggregationParams#calendar(Aggregation, IntervalType, ZoneId)}
   */
  @Test
  @DisplayName(
      "Test calendar(Aggregation, IntervalType, ZoneId) with 'aggregationType', 'intervalType', 'tzId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AggregationParams AggregationParams.calendar(Aggregation, IntervalType, ZoneId)"
  })
  void testCalendarWithAggregationTypeIntervalTypeTzId() {
    // Arrange
    ZoneOffset tzId = ZoneOffset.ofTotalSeconds(1);

    // Act
    AggregationParams actualCalendarResult =
        AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS, tzId);

    // Assert
    assertEquals(0L, actualCalendarResult.getInterval());
    assertEquals(Aggregation.MIN, actualCalendarResult.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, actualCalendarResult.getIntervalType());
    assertSame(tzId, actualCalendarResult.getTzId());
  }

  /**
   * Test {@link AggregationParams#calendar(Aggregation, IntervalType, String)} with {@code
   * aggregationType}, {@code intervalType}, {@code tzIdStr}.
   *
   * <p>Method under test: {@link AggregationParams#calendar(Aggregation, IntervalType, String)}
   */
  @Test
  @DisplayName(
      "Test calendar(Aggregation, IntervalType, String) with 'aggregationType', 'intervalType', 'tzIdStr'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AggregationParams AggregationParams.calendar(Aggregation, IntervalType, String)"
  })
  void testCalendarWithAggregationTypeIntervalTypeTzIdStr() {
    // Arrange and Act
    AggregationParams actualCalendarResult =
        AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS, "America/Phoenix");

    // Assert
    assertEquals("America/Phoenix", actualCalendarResult.getTzId().toString());
    assertEquals(0L, actualCalendarResult.getInterval());
    assertEquals(Aggregation.MIN, actualCalendarResult.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, actualCalendarResult.getIntervalType());
  }

  /**
   * Test {@link AggregationParams#calendar(Aggregation, IntervalType, String)} with {@code
   * aggregationType}, {@code intervalType}, {@code tzIdStr}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#calendar(Aggregation, IntervalType, String)}
   */
  @Test
  @DisplayName(
      "Test calendar(Aggregation, IntervalType, String) with 'aggregationType', 'intervalType', 'tzIdStr'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AggregationParams AggregationParams.calendar(Aggregation, IntervalType, String)"
  })
  void testCalendarWithAggregationTypeIntervalTypeTzIdStr_whenEmptyString() {
    // Arrange and Act
    AggregationParams actualCalendarResult =
        AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS, "");

    // Assert
    assertEquals(0L, actualCalendarResult.getInterval());
    assertEquals(Aggregation.MIN, actualCalendarResult.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, actualCalendarResult.getIntervalType());
  }

  /**
   * Test {@link AggregationParams#calendar(Aggregation, IntervalType, String)} with {@code
   * aggregationType}, {@code intervalType}, {@code tzIdStr}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#calendar(Aggregation, IntervalType, String)}
   */
  @Test
  @DisplayName(
      "Test calendar(Aggregation, IntervalType, String) with 'aggregationType', 'intervalType', 'tzIdStr'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AggregationParams AggregationParams.calendar(Aggregation, IntervalType, String)"
  })
  void testCalendarWithAggregationTypeIntervalTypeTzIdStr_whenNull() {
    // Arrange and Act
    AggregationParams actualCalendarResult =
        AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS, (String) null);

    // Assert
    assertEquals(0L, actualCalendarResult.getInterval());
    assertEquals(Aggregation.MIN, actualCalendarResult.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, actualCalendarResult.getIntervalType());
  }

  /**
   * Test {@link AggregationParams#calendar(Aggregation, IntervalType, String)} with {@code
   * aggregationType}, {@code intervalType}, {@code tzIdStr}.
   *
   * <ul>
   *   <li>When {@code Tz Id Str}.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#calendar(Aggregation, IntervalType, String)}
   */
  @Test
  @DisplayName(
      "Test calendar(Aggregation, IntervalType, String) with 'aggregationType', 'intervalType', 'tzIdStr'; when 'Tz Id Str'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AggregationParams AggregationParams.calendar(Aggregation, IntervalType, String)"
  })
  void testCalendarWithAggregationTypeIntervalTypeTzIdStr_whenTzIdStr() {
    // Arrange and Act
    AggregationParams actualCalendarResult =
        AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS, "Tz Id Str");

    // Assert
    assertEquals(0L, actualCalendarResult.getInterval());
    assertEquals(Aggregation.MIN, actualCalendarResult.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, actualCalendarResult.getIntervalType());
  }

  /**
   * Test {@link AggregationParams#of(Aggregation, IntervalType, ZoneId, long)}.
   *
   * <p>Method under test: {@link AggregationParams#of(Aggregation, IntervalType, ZoneId, long)}
   */
  @Test
  @DisplayName("Test of(Aggregation, IntervalType, ZoneId, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AggregationParams AggregationParams.of(Aggregation, IntervalType, ZoneId, long)"
  })
  void testOf() {
    // Arrange
    ZoneOffset tzId = ZoneOffset.ofTotalSeconds(1);

    // Act
    AggregationParams actualOfResult =
        AggregationParams.of(Aggregation.MIN, IntervalType.MILLISECONDS, tzId, 42L);

    // Assert
    assertEquals(42L, actualOfResult.getInterval());
    assertEquals(Aggregation.MIN, actualOfResult.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, actualOfResult.getIntervalType());
    assertSame(tzId, actualOfResult.getTzId());
  }

  /**
   * Test {@link AggregationParams#getInterval()}.
   *
   * <ul>
   *   <li>Given none.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#getInterval()}
   */
  @Test
  @DisplayName("Test getInterval(); given none; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AggregationParams.getInterval()"})
  void testGetInterval_givenNone_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, AggregationParams.none().getInterval());
  }

  /**
   * Test {@link AggregationParams#getInterval()}.
   *
   * <ul>
   *   <li>Then return {@code 604800000}.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#getInterval()}
   */
  @Test
  @DisplayName("Test getInterval(); then return '604800000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AggregationParams.getInterval()"})
  void testGetInterval_thenReturn604800000() {
    // Arrange, Act and Assert
    assertEquals(
        604800000L,
        new AggregationParams(Aggregation.MIN, IntervalType.WEEK, ZoneOffset.ofTotalSeconds(1), 42L)
            .getInterval());
  }

  /**
   * Test {@link AggregationParams#getInterval()}.
   *
   * <ul>
   *   <li>Then return {@code 2592000000}.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#getInterval()}
   */
  @Test
  @DisplayName("Test getInterval(); then return '2592000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AggregationParams.getInterval()"})
  void testGetInterval_thenReturn2592000000() {
    // Arrange, Act and Assert
    assertEquals(
        2592000000L,
        new AggregationParams(
                Aggregation.MIN, IntervalType.MONTH, ZoneOffset.ofTotalSeconds(1), 42L)
            .getInterval());
  }

  /**
   * Test {@link AggregationParams#getInterval()}.
   *
   * <ul>
   *   <li>Then return {@code 7776000000}.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#getInterval()}
   */
  @Test
  @DisplayName("Test getInterval(); then return '7776000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AggregationParams.getInterval()"})
  void testGetInterval_thenReturn7776000000() {
    // Arrange, Act and Assert
    assertEquals(
        7776000000L,
        new AggregationParams(
                Aggregation.MIN, IntervalType.QUARTER, ZoneOffset.ofTotalSeconds(1), 42L)
            .getInterval());
  }

  /**
   * Test {@link AggregationParams#getInterval()}.
   *
   * <ul>
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#getInterval()}
   */
  @Test
  @DisplayName("Test getInterval(); then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long AggregationParams.getInterval()"})
  void testGetInterval_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(
        42L,
        new AggregationParams(
                Aggregation.MIN, IntervalType.MILLISECONDS, ZoneOffset.ofTotalSeconds(1), 42L)
            .getInterval());
  }

  /**
   * Test {@link AggregationParams#equals(Object)}, and {@link AggregationParams#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AggregationParams#equals(Object)}
   *   <li>{@link AggregationParams#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AggregationParams.equals(Object)",
    "int AggregationParams.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AggregationParams noneResult = AggregationParams.none();
    AggregationParams noneResult2 = AggregationParams.none();

    // Act and Assert
    assertEquals(noneResult, noneResult2);
    assertEquals(noneResult.hashCode(), noneResult2.hashCode());
  }

  /**
   * Test {@link AggregationParams#equals(Object)}, and {@link AggregationParams#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AggregationParams#equals(Object)}
   *   <li>{@link AggregationParams#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AggregationParams.equals(Object)",
    "int AggregationParams.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AggregationParams millisecondsResult = AggregationParams.milliseconds(Aggregation.MIN, 42L);
    AggregationParams millisecondsResult2 = AggregationParams.milliseconds(Aggregation.MIN, 42L);

    // Act and Assert
    assertEquals(millisecondsResult, millisecondsResult2);
    assertEquals(millisecondsResult.hashCode(), millisecondsResult2.hashCode());
  }

  /**
   * Test {@link AggregationParams#equals(Object)}, and {@link AggregationParams#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AggregationParams#equals(Object)}
   *   <li>{@link AggregationParams#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AggregationParams.equals(Object)",
    "int AggregationParams.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AggregationParams calendarResult =
        AggregationParams.calendar(
            Aggregation.MIN, IntervalType.MILLISECONDS, ZoneOffset.ofTotalSeconds(1));
    AggregationParams calendarResult2 =
        AggregationParams.calendar(
            Aggregation.MIN, IntervalType.MILLISECONDS, ZoneOffset.ofTotalSeconds(1));

    // Act and Assert
    assertEquals(calendarResult, calendarResult2);
    assertEquals(calendarResult.hashCode(), calendarResult2.hashCode());
  }

  /**
   * Test {@link AggregationParams#equals(Object)}, and {@link AggregationParams#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AggregationParams#equals(Object)}
   *   <li>{@link AggregationParams#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AggregationParams.equals(Object)",
    "int AggregationParams.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AggregationParams noneResult = AggregationParams.none();

    // Act and Assert
    assertEquals(noneResult, noneResult);
    int expectedHashCodeResult = noneResult.hashCode();
    assertEquals(expectedHashCodeResult, noneResult.hashCode());
  }

  /**
   * Test {@link AggregationParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AggregationParams.equals(Object)",
    "int AggregationParams.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AggregationParams millisecondsResult = AggregationParams.milliseconds(Aggregation.MIN, 42L);

    // Act and Assert
    assertNotEquals(millisecondsResult, AggregationParams.none());
  }

  /**
   * Test {@link AggregationParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AggregationParams.equals(Object)",
    "int AggregationParams.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AggregationParams calendarResult =
        AggregationParams.calendar(
            Aggregation.MIN, IntervalType.MILLISECONDS, ZoneOffset.ofTotalSeconds(1));

    // Act and Assert
    assertNotEquals(calendarResult, AggregationParams.none());
  }

  /**
   * Test {@link AggregationParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AggregationParams.equals(Object)",
    "int AggregationParams.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AggregationParams calendarResult =
        AggregationParams.calendar(null, IntervalType.MILLISECONDS, ZoneOffset.ofTotalSeconds(1));

    // Act and Assert
    assertNotEquals(calendarResult, AggregationParams.none());
  }

  /**
   * Test {@link AggregationParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AggregationParams.equals(Object)",
    "int AggregationParams.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AggregationParams calendarResult =
        AggregationParams.calendar(
            Aggregation.MIN, IntervalType.WEEK, ZoneOffset.ofTotalSeconds(1));

    // Act and Assert
    assertNotEquals(calendarResult, AggregationParams.none());
  }

  /**
   * Test {@link AggregationParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AggregationParams.equals(Object)",
    "int AggregationParams.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AggregationParams calendarResult =
        AggregationParams.calendar(Aggregation.MIN, null, ZoneOffset.ofTotalSeconds(1));

    // Act and Assert
    assertNotEquals(
        calendarResult,
        AggregationParams.calendar(
            Aggregation.MIN, IntervalType.MILLISECONDS, ZoneOffset.ofTotalSeconds(1)));
  }

  /**
   * Test {@link AggregationParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AggregationParams.equals(Object)",
    "int AggregationParams.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AggregationParams calendarResult =
        AggregationParams.calendar(
            Aggregation.MIN, IntervalType.MILLISECONDS, ZoneOffset.ofTotalSeconds(3));

    // Act and Assert
    assertNotEquals(
        calendarResult,
        AggregationParams.calendar(
            Aggregation.MIN, IntervalType.MILLISECONDS, ZoneOffset.ofTotalSeconds(1)));
  }

  /**
   * Test {@link AggregationParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AggregationParams.equals(Object)",
    "int AggregationParams.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AggregationParams calendarResult =
        AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS, (ZoneId) null);

    // Act and Assert
    assertNotEquals(
        calendarResult,
        AggregationParams.calendar(
            Aggregation.MIN, IntervalType.MILLISECONDS, ZoneOffset.ofTotalSeconds(1)));
  }

  /**
   * Test {@link AggregationParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AggregationParams.equals(Object)",
    "int AggregationParams.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AggregationParams calendarResult =
        AggregationParams.calendar(
            Aggregation.MIN, IntervalType.MILLISECONDS, ZoneOffset.ofTotalSeconds(1));

    // Act and Assert
    assertNotEquals(
        calendarResult,
        AggregationParams.calendar(Aggregation.MIN, null, ZoneOffset.ofTotalSeconds(1)));
  }

  /**
   * Test {@link AggregationParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AggregationParams.equals(Object)",
    "int AggregationParams.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AggregationParams calendarResult =
        AggregationParams.calendar(
            Aggregation.MIN, IntervalType.MONTH, ZoneOffset.ofTotalSeconds(1));

    // Act and Assert
    assertNotEquals(calendarResult, AggregationParams.none());
  }

  /**
   * Test {@link AggregationParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AggregationParams.equals(Object)",
    "int AggregationParams.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AggregationParams calendarResult =
        AggregationParams.calendar(
            Aggregation.MIN, IntervalType.QUARTER, ZoneOffset.ofTotalSeconds(1));

    // Act and Assert
    assertNotEquals(calendarResult, AggregationParams.none());
  }

  /**
   * Test {@link AggregationParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AggregationParams.equals(Object)",
    "int AggregationParams.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AggregationParams.none(), null);
  }

  /**
   * Test {@link AggregationParams#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AggregationParams.equals(Object)",
    "int AggregationParams.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AggregationParams.none(), "Different type to AggregationParams");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AggregationParams#AggregationParams(Aggregation, IntervalType, ZoneId, long)}
   *   <li>{@link AggregationParams#getAggregation()}
   *   <li>{@link AggregationParams#getIntervalType()}
   *   <li>{@link AggregationParams#getTzId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AggregationParams.<init>(Aggregation, IntervalType, ZoneId, long)",
    "Aggregation AggregationParams.getAggregation()",
    "IntervalType AggregationParams.getIntervalType()",
    "ZoneId AggregationParams.getTzId()"
  })
  void testGettersAndSetters() {
    // Arrange
    ZoneOffset tzId = ZoneOffset.ofTotalSeconds(1);

    // Act
    AggregationParams actualAggregationParams =
        new AggregationParams(Aggregation.MIN, IntervalType.MILLISECONDS, tzId, 42L);
    Aggregation actualAggregation = actualAggregationParams.getAggregation();
    IntervalType actualIntervalType = actualAggregationParams.getIntervalType();
    ZoneId actualTzId = actualAggregationParams.getTzId();

    // Assert
    assertEquals("+00:00:01", actualTzId.toString());
    assertEquals(Aggregation.MIN, actualAggregation);
    assertEquals(IntervalType.MILLISECONDS, actualIntervalType);
    assertSame(tzId, actualTzId);
  }
}
