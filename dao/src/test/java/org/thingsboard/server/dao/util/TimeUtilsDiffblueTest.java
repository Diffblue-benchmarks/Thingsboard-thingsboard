package org.thingsboard.server.dao.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import java.time.ZoneId;
import java.time.ZoneOffset;
import org.junit.Test;
import org.thingsboard.server.common.data.kv.IntervalType;

public class TimeUtilsDiffblueTest {
  /**
   * Test {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}.
   * <ul>
   *   <li>When {@code MILLISECONDS}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}
   */
  @Test
  public void testCalculateIntervalEnd_whenMilliseconds_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> TimeUtils.calculateIntervalEnd(1L, IntervalType.MILLISECONDS, ZoneOffset.ofTotalSeconds(1)));
  }

  /**
   * Test {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}.
   * <ul>
   *   <li>When {@code MONTH}.</li>
   *   <li>Then return {@code 2678399000}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}
   */
  @Test
  public void testCalculateIntervalEnd_whenMonth_thenReturn2678399000() {
    // Arrange, Act and Assert
    assertEquals(2678399000L, TimeUtils.calculateIntervalEnd(1L, IntervalType.MONTH, ZoneOffset.ofTotalSeconds(1)));
  }

  /**
   * Test {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}.
   * <ul>
   *   <li>When {@code QUARTER}.</li>
   *   <li>Then return {@code 7775999000}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}
   */
  @Test
  public void testCalculateIntervalEnd_whenQuarter_thenReturn7775999000() {
    // Arrange, Act and Assert
    assertEquals(7775999000L, TimeUtils.calculateIntervalEnd(1L, IntervalType.QUARTER, ZoneOffset.ofTotalSeconds(1)));
  }

  /**
   * Test {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}.
   * <ul>
   *   <li>When {@code WEEK_ISO}.</li>
   *   <li>Then return {@code 345599000}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}
   */
  @Test
  public void testCalculateIntervalEnd_whenWeekIso_thenReturn345599000() {
    // Arrange, Act and Assert
    assertEquals(345599000L, TimeUtils.calculateIntervalEnd(1L, IntervalType.WEEK_ISO, ZoneOffset.ofTotalSeconds(1)));
  }

  /**
   * Test {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}.
   * <ul>
   *   <li>When {@code WEEK}.</li>
   *   <li>Then return {@code 259199000}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TimeUtils#calculateIntervalEnd(long, IntervalType, ZoneId)}
   */
  @Test
  public void testCalculateIntervalEnd_whenWeek_thenReturn259199000() {
    // Arrange, Act and Assert
    assertEquals(259199000L, TimeUtils.calculateIntervalEnd(1L, IntervalType.WEEK, ZoneOffset.ofTotalSeconds(1)));
  }
}
