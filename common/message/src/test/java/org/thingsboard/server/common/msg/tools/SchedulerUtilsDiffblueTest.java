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
package org.thingsboard.server.common.msg.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneId;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ZoneId SchedulerUtils.getZoneId(String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ZoneId SchedulerUtils.getZoneId(String)"})
  void testGetZoneId_whenNull_thenReturnToStringIsUtc() {
    // Arrange and Act
    ZoneId actualZoneId = SchedulerUtils.getZoneId(null);

    // Assert
    assertEquals("UTC", actualZoneId.toString());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ZoneId SchedulerUtils.getZoneId(String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
