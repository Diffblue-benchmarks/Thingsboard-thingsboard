package org.thingsboard.server.common.msg.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SchedulerUtilsDiffblueTest {
  /**
   * Test {@link SchedulerUtils#getZoneId(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return toString is {@code UTC}.
   * </ul>
   *
   * <p>Method under test: {@link SchedulerUtils#getZoneId(String)}
   */
  @Test
  @DisplayName("Test getZoneId(String); when empty string; then return toString is 'UTC'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.time.ZoneId SchedulerUtils.getZoneId(String)"})
  void testGetZoneId_whenEmptyString_thenReturnToStringIsUtc() {
    // Arrange, Act and Assert
    assertEquals("UTC", SchedulerUtils.getZoneId("").toString());
  }

  /**
   * Test {@link SchedulerUtils#getZoneId(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return toString is {@code UTC}.
   * </ul>
   *
   * <p>Method under test: {@link SchedulerUtils#getZoneId(String)}
   */
  @Test
  @DisplayName("Test getZoneId(String); when 'null'; then return toString is 'UTC'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.time.ZoneId SchedulerUtils.getZoneId(String)"})
  void testGetZoneId_whenNull_thenReturnToStringIsUtc() {
    // Arrange, Act and Assert
    assertEquals("UTC", SchedulerUtils.getZoneId(null).toString());
  }

  /**
   * Test {@link SchedulerUtils#getZoneId(String)}.
   *
   * <ul>
   *   <li>When {@code UTC}.
   *   <li>Then return toString is {@code UTC}.
   * </ul>
   *
   * <p>Method under test: {@link SchedulerUtils#getZoneId(String)}
   */
  @Test
  @DisplayName("Test getZoneId(String); when 'UTC'; then return toString is 'UTC'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.time.ZoneId SchedulerUtils.getZoneId(String)"})
  void testGetZoneId_whenUtc_thenReturnToStringIsUtc() {
    // Arrange, Act and Assert
    assertEquals("UTC", SchedulerUtils.getZoneId("UTC").toString());
  }

  /**
   * Test {@link SchedulerUtils#firstDayOfNextNextMonth()}.
   *
   * <ul>
   *   <li>Then return adjustInto ofEpochDay one toString is {@code 1970-03-01}.
   * </ul>
   *
   * <p>Method under test: {@link SchedulerUtils#firstDayOfNextNextMonth()}
   */
  @Test
  @DisplayName(
      "Test firstDayOfNextNextMonth(); then return adjustInto ofEpochDay one toString is '1970-03-01'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.time.temporal.TemporalAdjuster SchedulerUtils.firstDayOfNextNextMonth()"
  })
  void testFirstDayOfNextNextMonth_thenReturnAdjustIntoOfEpochDayOneToStringIs19700301() {
    // Arrange, Act and Assert
    assertEquals(
        "1970-03-01",
        SchedulerUtils.firstDayOfNextNextMonth().adjustInto(LocalDate.ofEpochDay(1L)).toString());
  }
}
