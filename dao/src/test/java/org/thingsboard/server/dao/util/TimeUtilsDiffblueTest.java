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
package org.thingsboard.server.dao.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.ZoneId;
import java.time.ZoneOffset;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.kv.IntervalType;

public class TimeUtilsDiffblueTest {
  /**
   * Test {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}.
   *
   * <ul>
   *   <li>When {@code MILLISECONDS}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TimeUtils.calculateIntervalEnd(long, IntervalType, ZoneId)"})
  public void testCalculateIntervalEnd_whenMilliseconds_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            TimeUtils.calculateIntervalEnd(
                1L, IntervalType.MILLISECONDS, ZoneOffset.ofTotalSeconds(1)));
  }

  /**
   * Test {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}.
   *
   * <ul>
   *   <li>When {@code MONTH}.
   *   <li>Then return {@code 2678399000}.
   * </ul>
   *
   * <p>Method under test: {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TimeUtils.calculateIntervalEnd(long, IntervalType, ZoneId)"})
  public void testCalculateIntervalEnd_whenMonth_thenReturn2678399000() {
    // Arrange, Act and Assert
    assertEquals(
        2678399000L,
        TimeUtils.calculateIntervalEnd(1L, IntervalType.MONTH, ZoneOffset.ofTotalSeconds(1)));
  }

  /**
   * Test {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}.
   *
   * <ul>
   *   <li>When {@code QUARTER}.
   *   <li>Then return {@code 7775999000}.
   * </ul>
   *
   * <p>Method under test: {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TimeUtils.calculateIntervalEnd(long, IntervalType, ZoneId)"})
  public void testCalculateIntervalEnd_whenQuarter_thenReturn7775999000() {
    // Arrange, Act and Assert
    assertEquals(
        7775999000L,
        TimeUtils.calculateIntervalEnd(1L, IntervalType.QUARTER, ZoneOffset.ofTotalSeconds(1)));
  }

  /**
   * Test {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}.
   *
   * <ul>
   *   <li>When {@code WEEK_ISO}.
   *   <li>Then return {@code 345599000}.
   * </ul>
   *
   * <p>Method under test: {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TimeUtils.calculateIntervalEnd(long, IntervalType, ZoneId)"})
  public void testCalculateIntervalEnd_whenWeekIso_thenReturn345599000() {
    // Arrange, Act and Assert
    assertEquals(
        345599000L,
        TimeUtils.calculateIntervalEnd(1L, IntervalType.WEEK_ISO, ZoneOffset.ofTotalSeconds(1)));
  }

  /**
   * Test {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}.
   *
   * <ul>
   *   <li>When {@code WEEK}.
   *   <li>Then return {@code 259199000}.
   * </ul>
   *
   * <p>Method under test: {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long TimeUtils.calculateIntervalEnd(long, IntervalType, ZoneId)"})
  public void testCalculateIntervalEnd_whenWeek_thenReturn259199000() {
    // Arrange, Act and Assert
    assertEquals(
        259199000L,
        TimeUtils.calculateIntervalEnd(1L, IntervalType.WEEK, ZoneOffset.ofTotalSeconds(1)));
  }
}
