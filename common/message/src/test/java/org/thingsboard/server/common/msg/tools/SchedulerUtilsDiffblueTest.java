package org.thingsboard.server.common.msg.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SchedulerUtilsDiffblueTest {
  /**
   * Test {@link SchedulerUtils#getZoneId(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return toString is {@code UTC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchedulerUtils#getZoneId(String)}
   */
  @Test
  @DisplayName("Test getZoneId(String); when empty string; then return toString is 'UTC'")
  void testGetZoneId_whenEmptyString_thenReturnToStringIsUtc() {
    // Arrange, Act and Assert
    assertEquals("UTC", SchedulerUtils.getZoneId("").toString());
  }

  /**
   * Test {@link SchedulerUtils#getZoneId(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return toString is {@code UTC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchedulerUtils#getZoneId(String)}
   */
  @Test
  @DisplayName("Test getZoneId(String); when 'null'; then return toString is 'UTC'")
  void testGetZoneId_whenNull_thenReturnToStringIsUtc() {
    // Arrange, Act and Assert
    assertEquals("UTC", SchedulerUtils.getZoneId(null).toString());
  }

  /**
   * Test {@link SchedulerUtils#firstDayOfNextNextMonth()}.
   * <ul>
   *   <li>Then return adjustInto ofEpochDay one toString is
   * {@code 1970-03-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchedulerUtils#firstDayOfNextNextMonth()}
   */
  @Test
  @DisplayName("Test firstDayOfNextNextMonth(); then return adjustInto ofEpochDay one toString is '1970-03-01'")
  void testFirstDayOfNextNextMonth_thenReturnAdjustIntoOfEpochDayOneToStringIs19700301() {
    // Arrange, Act and Assert
    assertEquals("1970-03-01",
        SchedulerUtils.firstDayOfNextNextMonth().adjustInto(LocalDate.ofEpochDay(1L)).toString());
  }
}
