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
package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.time.ZoneId;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Test;

class AggregationParamsDiffblueTest {
  /**
   * Method under test: {@link AggregationParams#none()}
   */
  @Test
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
   * Method under test: {@link AggregationParams#milliseconds(Aggregation, long)}
   */
  @Test
  void testMilliseconds() {
    // Arrange and Act
    AggregationParams actualMillisecondsResult = AggregationParams.milliseconds(Aggregation.MIN, 42L);

    // Assert
    assertNull(actualMillisecondsResult.getTzId());
    assertEquals(42L, actualMillisecondsResult.getInterval());
    assertEquals(Aggregation.MIN, actualMillisecondsResult.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, actualMillisecondsResult.getIntervalType());
  }

  /**
   * Method under test:
   * {@link AggregationParams#calendar(Aggregation, IntervalType, String)}
   */
  @Test
  void testCalendar() {
    // Arrange and Act
    AggregationParams actualCalendarResult = AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS,
        "Tz Id Str");

    // Assert
    assertEquals(0L, actualCalendarResult.getInterval());
    assertEquals(Aggregation.MIN, actualCalendarResult.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, actualCalendarResult.getIntervalType());
  }

  /**
   * Method under test:
   * {@link AggregationParams#calendar(Aggregation, IntervalType, String)}
   */
  @Test
  void testCalendar2() {
    // Arrange and Act
    AggregationParams actualCalendarResult = AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS,
        (String) null);

    // Assert
    assertEquals(0L, actualCalendarResult.getInterval());
    assertEquals(Aggregation.MIN, actualCalendarResult.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, actualCalendarResult.getIntervalType());
  }

  /**
   * Method under test:
   * {@link AggregationParams#calendar(Aggregation, IntervalType, String)}
   */
  @Test
  void testCalendar3() {
    // Arrange and Act
    AggregationParams actualCalendarResult = AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS, "");

    // Assert
    assertEquals(0L, actualCalendarResult.getInterval());
    assertEquals(Aggregation.MIN, actualCalendarResult.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, actualCalendarResult.getIntervalType());
  }

  /**
   * Method under test:
   * {@link AggregationParams#calendar(Aggregation, IntervalType, String)}
   */
  @Test
  void testCalendar4() {
    // Arrange and Act
    AggregationParams actualCalendarResult = AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS,
        "America/Phoenix");

    // Assert
    assertEquals("America/Phoenix", actualCalendarResult.getTzId().toString());
    assertEquals(0L, actualCalendarResult.getInterval());
    assertEquals(Aggregation.MIN, actualCalendarResult.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, actualCalendarResult.getIntervalType());
  }

  /**
   * Method under test:
   * {@link AggregationParams#calendar(Aggregation, IntervalType, ZoneId)}
   */
  @Test
  void testCalendar5() {
    // Arrange
    ZoneOffset tzId = ZoneOffset.ofTotalSeconds(1);

    // Act
    AggregationParams actualCalendarResult = AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS,
        tzId);

    // Assert
    ZoneId tzId2 = actualCalendarResult.getTzId();
    assertEquals("+00:00:01", tzId2.toString());
    assertEquals(0L, actualCalendarResult.getInterval());
    assertEquals(Aggregation.MIN, actualCalendarResult.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, actualCalendarResult.getIntervalType());
    assertSame(tzId, tzId2);
  }

  /**
   * Method under test:
   * {@link AggregationParams#of(Aggregation, IntervalType, ZoneId, long)}
   */
  @Test
  void testOf() {
    // Arrange
    ZoneOffset tzId = ZoneOffset.ofTotalSeconds(1);

    // Act
    AggregationParams actualOfResult = AggregationParams.of(Aggregation.MIN, IntervalType.MILLISECONDS, tzId, 42L);

    // Assert
    ZoneId tzId2 = actualOfResult.getTzId();
    assertEquals("+00:00:01", tzId2.toString());
    assertEquals(42L, actualOfResult.getInterval());
    assertEquals(Aggregation.MIN, actualOfResult.getAggregation());
    assertEquals(IntervalType.MILLISECONDS, actualOfResult.getIntervalType());
    assertSame(tzId, tzId2);
  }

  /**
   * Method under test: {@link AggregationParams#getInterval()}
   */
  @Test
  void testGetInterval() {
    // Arrange, Act and Assert
    assertEquals(0L, AggregationParams.none().getInterval());
    assertEquals(42L, AggregationParams.milliseconds(Aggregation.MIN, 42L).getInterval());
    assertEquals(604800000L,
        AggregationParams.calendar(Aggregation.MIN, IntervalType.WEEK, ZoneOffset.ofTotalSeconds(1)).getInterval());
    assertEquals(2592000000L,
        AggregationParams.calendar(Aggregation.MIN, IntervalType.MONTH, ZoneOffset.ofTotalSeconds(1)).getInterval());
    assertEquals(7776000000L,
        AggregationParams.calendar(Aggregation.MIN, IntervalType.QUARTER, ZoneOffset.ofTotalSeconds(1)).getInterval());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AggregationParams#equals(Object)}
   *   <li>{@link AggregationParams#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AggregationParams noneResult = AggregationParams.none();
    AggregationParams noneResult2 = AggregationParams.none();

    // Act and Assert
    assertEquals(noneResult, noneResult2);
    int expectedHashCodeResult = noneResult.hashCode();
    assertEquals(expectedHashCodeResult, noneResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AggregationParams#equals(Object)}
   *   <li>{@link AggregationParams#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AggregationParams millisecondsResult = AggregationParams.milliseconds(Aggregation.MIN, 42L);
    AggregationParams millisecondsResult2 = AggregationParams.milliseconds(Aggregation.MIN, 42L);

    // Act and Assert
    assertEquals(millisecondsResult, millisecondsResult2);
    int expectedHashCodeResult = millisecondsResult.hashCode();
    assertEquals(expectedHashCodeResult, millisecondsResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AggregationParams#equals(Object)}
   *   <li>{@link AggregationParams#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AggregationParams calendarResult = AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS,
        ZoneOffset.ofTotalSeconds(1));
    AggregationParams calendarResult2 = AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS,
        ZoneOffset.ofTotalSeconds(1));

    // Act and Assert
    assertEquals(calendarResult, calendarResult2);
    int expectedHashCodeResult = calendarResult.hashCode();
    assertEquals(expectedHashCodeResult, calendarResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AggregationParams#equals(Object)}
   *   <li>{@link AggregationParams#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AggregationParams noneResult = AggregationParams.none();

    // Act and Assert
    assertEquals(noneResult, noneResult);
    int expectedHashCodeResult = noneResult.hashCode();
    assertEquals(expectedHashCodeResult, noneResult.hashCode());
  }

  /**
   * Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AggregationParams millisecondsResult = AggregationParams.milliseconds(Aggregation.MIN, 42L);

    // Act and Assert
    assertNotEquals(millisecondsResult, AggregationParams.none());
  }

  /**
   * Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AggregationParams calendarResult = AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS,
        ZoneOffset.ofTotalSeconds(1));

    // Act and Assert
    assertNotEquals(calendarResult, AggregationParams.none());
  }

  /**
   * Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AggregationParams calendarResult = AggregationParams.calendar(null, IntervalType.MILLISECONDS,
        ZoneOffset.ofTotalSeconds(1));

    // Act and Assert
    assertNotEquals(calendarResult, AggregationParams.none());
  }

  /**
   * Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AggregationParams calendarResult = AggregationParams.calendar(Aggregation.MIN, IntervalType.WEEK,
        ZoneOffset.ofTotalSeconds(1));

    // Act and Assert
    assertNotEquals(calendarResult, AggregationParams.none());
  }

  /**
   * Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AggregationParams calendarResult = AggregationParams.calendar(Aggregation.MIN, IntervalType.MONTH,
        ZoneOffset.ofTotalSeconds(1));

    // Act and Assert
    assertNotEquals(calendarResult, AggregationParams.none());
  }

  /**
   * Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AggregationParams calendarResult = AggregationParams.calendar(Aggregation.MIN, IntervalType.QUARTER,
        ZoneOffset.ofTotalSeconds(1));

    // Act and Assert
    assertNotEquals(calendarResult, AggregationParams.none());
  }

  /**
   * Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AggregationParams calendarResult = AggregationParams.calendar(Aggregation.MIN, null, ZoneOffset.ofTotalSeconds(1));

    // Act and Assert
    assertNotEquals(calendarResult,
        AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS, ZoneOffset.ofTotalSeconds(1)));
  }

  /**
   * Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AggregationParams calendarResult = AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS,
        ZoneOffset.ofTotalSeconds(3));

    // Act and Assert
    assertNotEquals(calendarResult,
        AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS, ZoneOffset.ofTotalSeconds(1)));
  }

  /**
   * Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AggregationParams calendarResult = AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS,
        (ZoneId) null);

    // Act and Assert
    assertNotEquals(calendarResult,
        AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS, ZoneOffset.ofTotalSeconds(1)));
  }

  /**
   * Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AggregationParams calendarResult = AggregationParams.calendar(Aggregation.MIN, IntervalType.MILLISECONDS,
        ZoneOffset.ofTotalSeconds(1));

    // Act and Assert
    assertNotEquals(calendarResult, AggregationParams.calendar(Aggregation.MIN, null, ZoneOffset.ofTotalSeconds(1)));
  }

  /**
   * Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AggregationParams.none(), null);
  }

  /**
   * Method under test: {@link AggregationParams#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(AggregationParams.none(), "Different type to AggregationParams");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AggregationParams#AggregationParams(Aggregation, IntervalType, ZoneId, long)}
   *   <li>{@link AggregationParams#getAggregation()}
   *   <li>{@link AggregationParams#getIntervalType()}
   *   <li>{@link AggregationParams#getTzId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ZoneOffset tzId = ZoneOffset.ofTotalSeconds(1);

    // Act
    AggregationParams actualAggregationParams = new AggregationParams(Aggregation.MIN, IntervalType.MILLISECONDS, tzId,
        42L);
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
