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
package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Optional;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SqlTsPartitionDateDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SqlTsPartitionDate#getPattern()}
   *   <li>{@link SqlTsPartitionDate#getTruncateUnit()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SqlTsPartitionDate.getPattern()",
    "TemporalUnit SqlTsPartitionDate.getTruncateUnit()"
  })
  public void testGettersAndSetters() {
    // Arrange
    SqlTsPartitionDate valueOfResult = SqlTsPartitionDate.valueOf("DAYS");

    // Act
    String actualPattern = valueOfResult.getPattern();
    TemporalUnit actualTruncateUnit = valueOfResult.getTruncateUnit();

    // Assert
    assertTrue(actualTruncateUnit instanceof ChronoUnit);
    assertEquals("yyyy_MM_dd", actualPattern);
    assertEquals(ChronoUnit.DAYS, actualTruncateUnit);
  }

  /**
   * Test {@link SqlTsPartitionDate#trancateTo(LocalDateTime)}.
   *
   * <ul>
   *   <li>Given {@code DAYS}.
   *   <li>When {@link SqlTsPartitionDate#EPOCH_START}.
   *   <li>Then return {@link SqlTsPartitionDate#EPOCH_START}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTsPartitionDate#trancateTo(LocalDateTime)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime SqlTsPartitionDate.trancateTo(LocalDateTime)"})
  public void testTrancateTo_givenDays_whenEpoch_start_thenReturnEpoch_start() {
    // Arrange
    LocalDateTime time = SqlTsPartitionDate.EPOCH_START;

    // Act
    LocalDateTime actualTrancateToResult = SqlTsPartitionDate.DAYS.trancateTo(time);

    // Assert
    assertSame(time, actualTrancateToResult);
  }

  /**
   * Test {@link SqlTsPartitionDate#trancateTo(LocalDateTime)}.
   *
   * <ul>
   *   <li>Given {@code INDEFINITE}.
   *   <li>When {@link SqlTsPartitionDate#EPOCH_START}.
   *   <li>Then return {@link SqlTsPartitionDate#EPOCH_START}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTsPartitionDate#trancateTo(LocalDateTime)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime SqlTsPartitionDate.trancateTo(LocalDateTime)"})
  public void testTrancateTo_givenIndefinite_whenEpoch_start_thenReturnEpoch_start() {
    // Arrange
    LocalDateTime time = SqlTsPartitionDate.EPOCH_START;

    // Act
    LocalDateTime actualTrancateToResult = SqlTsPartitionDate.INDEFINITE.trancateTo(time);

    // Assert
    assertSame(time, actualTrancateToResult);
  }

  /**
   * Test {@link SqlTsPartitionDate#trancateTo(LocalDateTime)}.
   *
   * <ul>
   *   <li>Given {@code MONTHS}.
   *   <li>When {@link SqlTsPartitionDate#EPOCH_START}.
   *   <li>Then return {@link SqlTsPartitionDate#EPOCH_START}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTsPartitionDate#trancateTo(LocalDateTime)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime SqlTsPartitionDate.trancateTo(LocalDateTime)"})
  public void testTrancateTo_givenMonths_whenEpoch_start_thenReturnEpoch_start() {
    // Arrange
    LocalDateTime time = SqlTsPartitionDate.EPOCH_START;

    // Act
    LocalDateTime actualTrancateToResult = SqlTsPartitionDate.MONTHS.trancateTo(time);

    // Assert
    assertSame(time, actualTrancateToResult);
  }

  /**
   * Test {@link SqlTsPartitionDate#trancateTo(LocalDateTime)}.
   *
   * <ul>
   *   <li>Given {@code YEARS}.
   *   <li>When {@link SqlTsPartitionDate#EPOCH_START}.
   *   <li>Then return {@link SqlTsPartitionDate#EPOCH_START}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTsPartitionDate#trancateTo(LocalDateTime)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime SqlTsPartitionDate.trancateTo(LocalDateTime)"})
  public void testTrancateTo_givenYears_whenEpoch_start_thenReturnEpoch_start() {
    // Arrange
    LocalDateTime time = SqlTsPartitionDate.EPOCH_START;

    // Act
    LocalDateTime actualTrancateToResult = SqlTsPartitionDate.YEARS.trancateTo(time);

    // Assert
    assertSame(time, actualTrancateToResult);
  }

  /**
   * Test {@link SqlTsPartitionDate#plusTo(LocalDateTime)}.
   *
   * <ul>
   *   <li>Given {@code DAYS}.
   *   <li>When {@link SqlTsPartitionDate#EPOCH_START}.
   *   <li>Then return toLocalDate toString is {@code 1970-01-02}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTsPartitionDate#plusTo(LocalDateTime)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime SqlTsPartitionDate.plusTo(LocalDateTime)"})
  public void testPlusTo_givenDays_whenEpoch_start_thenReturnToLocalDateToStringIs19700102() {
    // Arrange and Act
    LocalDateTime actualPlusToResult =
        SqlTsPartitionDate.DAYS.plusTo(SqlTsPartitionDate.EPOCH_START);

    // Assert
    assertEquals("00:00", actualPlusToResult.toLocalTime().toString());
    assertEquals("1970-01-02", actualPlusToResult.toLocalDate().toString());
  }

  /**
   * Test {@link SqlTsPartitionDate#plusTo(LocalDateTime)}.
   *
   * <ul>
   *   <li>Given {@code INDEFINITE}.
   *   <li>When {@link SqlTsPartitionDate#EPOCH_START}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTsPartitionDate#plusTo(LocalDateTime)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime SqlTsPartitionDate.plusTo(LocalDateTime)"})
  public void testPlusTo_givenIndefinite_whenEpoch_start_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> SqlTsPartitionDate.INDEFINITE.plusTo(SqlTsPartitionDate.EPOCH_START));
  }

  /**
   * Test {@link SqlTsPartitionDate#plusTo(LocalDateTime)}.
   *
   * <ul>
   *   <li>Given {@code MONTHS}.
   *   <li>When {@link SqlTsPartitionDate#EPOCH_START}.
   *   <li>Then return toLocalDate toString is {@code 1970-02-01}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTsPartitionDate#plusTo(LocalDateTime)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime SqlTsPartitionDate.plusTo(LocalDateTime)"})
  public void testPlusTo_givenMonths_whenEpoch_start_thenReturnToLocalDateToStringIs19700201() {
    // Arrange and Act
    LocalDateTime actualPlusToResult =
        SqlTsPartitionDate.MONTHS.plusTo(SqlTsPartitionDate.EPOCH_START);

    // Assert
    assertEquals("00:00", actualPlusToResult.toLocalTime().toString());
    assertEquals("1970-02-01", actualPlusToResult.toLocalDate().toString());
  }

  /**
   * Test {@link SqlTsPartitionDate#plusTo(LocalDateTime)}.
   *
   * <ul>
   *   <li>Given {@code YEARS}.
   *   <li>When {@link SqlTsPartitionDate#EPOCH_START}.
   *   <li>Then return toLocalDate toString is {@code 1971-01-01}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTsPartitionDate#plusTo(LocalDateTime)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime SqlTsPartitionDate.plusTo(LocalDateTime)"})
  public void testPlusTo_givenYears_whenEpoch_start_thenReturnToLocalDateToStringIs19710101() {
    // Arrange and Act
    LocalDateTime actualPlusToResult =
        SqlTsPartitionDate.YEARS.plusTo(SqlTsPartitionDate.EPOCH_START);

    // Assert
    assertEquals("00:00", actualPlusToResult.toLocalTime().toString());
    assertEquals("1971-01-01", actualPlusToResult.toLocalDate().toString());
  }

  /**
   * Test {@link SqlTsPartitionDate#parse(String)}.
   *
   * <ul>
   *   <li>When {@code DAYS}.
   *   <li>Then return {@link Optional#get()} is {@code DAYS}.
   * </ul>
   *
   * <p>Method under test: {@link SqlTsPartitionDate#parse(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional SqlTsPartitionDate.parse(String)"})
  public void testParse_whenDays_thenReturnGetIsDays() {
    // Arrange and Act
    Optional<SqlTsPartitionDate> actualParseResult = SqlTsPartitionDate.parse("DAYS");

    // Assert
    assertEquals(SqlTsPartitionDate.DAYS, actualParseResult.get());
    assertTrue(actualParseResult.isPresent());
  }

  /**
   * Test {@link SqlTsPartitionDate#parse(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link SqlTsPartitionDate#parse(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional SqlTsPartitionDate.parse(String)"})
  public void testParse_whenName_thenReturnNotPresent() {
    // Arrange and Act
    Optional<SqlTsPartitionDate> actualParseResult = SqlTsPartitionDate.parse("Name");

    // Assert
    assertFalse(actualParseResult.isPresent());
  }

  /**
   * Test {@link SqlTsPartitionDate#parse(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link SqlTsPartitionDate#parse(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional SqlTsPartitionDate.parse(String)"})
  public void testParse_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<SqlTsPartitionDate> actualParseResult = SqlTsPartitionDate.parse(null);

    // Assert
    assertFalse(actualParseResult.isPresent());
  }
}
