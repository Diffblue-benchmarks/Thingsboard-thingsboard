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

public class NoSqlTsPartitionDateDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NoSqlTsPartitionDate#getPattern()}
   *   <li>{@link NoSqlTsPartitionDate#getTruncateUnit()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String NoSqlTsPartitionDate.getPattern()",
    "TemporalUnit NoSqlTsPartitionDate.getTruncateUnit()"
  })
  public void testGettersAndSetters() {
    // Arrange
    NoSqlTsPartitionDate valueOfResult = NoSqlTsPartitionDate.valueOf("MINUTES");

    // Act
    String actualPattern = valueOfResult.getPattern();
    TemporalUnit actualTruncateUnit = valueOfResult.getTruncateUnit();

    // Assert
    assertTrue(actualTruncateUnit instanceof ChronoUnit);
    assertEquals("yyyy-MM-dd-HH-mm", actualPattern);
    assertEquals(ChronoUnit.MINUTES, actualTruncateUnit);
  }

  /**
   * Test {@link NoSqlTsPartitionDate#truncatedTo(LocalDateTime)}.
   *
   * <ul>
   *   <li>Given {@code INDEFINITE}.
   *   <li>When {@link NoSqlTsPartitionDate#EPOCH_START}.
   *   <li>Then return {@link NoSqlTsPartitionDate#EPOCH_START}.
   * </ul>
   *
   * <p>Method under test: {@link NoSqlTsPartitionDate#truncatedTo(LocalDateTime)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime NoSqlTsPartitionDate.truncatedTo(LocalDateTime)"})
  public void testTruncatedTo_givenIndefinite_whenEpoch_start_thenReturnEpoch_start() {
    // Arrange
    LocalDateTime time = NoSqlTsPartitionDate.EPOCH_START;

    // Act
    LocalDateTime actualTruncatedToResult = NoSqlTsPartitionDate.INDEFINITE.truncatedTo(time);

    // Assert
    assertSame(time, actualTruncatedToResult);
  }

  /**
   * Test {@link NoSqlTsPartitionDate#truncatedTo(LocalDateTime)}.
   *
   * <ul>
   *   <li>Given {@code MINUTES}.
   *   <li>When {@link NoSqlTsPartitionDate#EPOCH_START}.
   *   <li>Then return {@link NoSqlTsPartitionDate#EPOCH_START}.
   * </ul>
   *
   * <p>Method under test: {@link NoSqlTsPartitionDate#truncatedTo(LocalDateTime)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime NoSqlTsPartitionDate.truncatedTo(LocalDateTime)"})
  public void testTruncatedTo_givenMinutes_whenEpoch_start_thenReturnEpoch_start() {
    // Arrange
    LocalDateTime time = NoSqlTsPartitionDate.EPOCH_START;

    // Act
    LocalDateTime actualTruncatedToResult = NoSqlTsPartitionDate.MINUTES.truncatedTo(time);

    // Assert
    assertSame(time, actualTruncatedToResult);
  }

  /**
   * Test {@link NoSqlTsPartitionDate#truncatedTo(LocalDateTime)}.
   *
   * <ul>
   *   <li>Given {@code MONTHS}.
   *   <li>When {@link NoSqlTsPartitionDate#EPOCH_START}.
   *   <li>Then return {@link NoSqlTsPartitionDate#EPOCH_START}.
   * </ul>
   *
   * <p>Method under test: {@link NoSqlTsPartitionDate#truncatedTo(LocalDateTime)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime NoSqlTsPartitionDate.truncatedTo(LocalDateTime)"})
  public void testTruncatedTo_givenMonths_whenEpoch_start_thenReturnEpoch_start() {
    // Arrange
    LocalDateTime time = NoSqlTsPartitionDate.EPOCH_START;

    // Act
    LocalDateTime actualTruncatedToResult = NoSqlTsPartitionDate.MONTHS.truncatedTo(time);

    // Assert
    assertSame(time, actualTruncatedToResult);
  }

  /**
   * Test {@link NoSqlTsPartitionDate#truncatedTo(LocalDateTime)}.
   *
   * <ul>
   *   <li>Given {@code YEARS}.
   *   <li>When {@link NoSqlTsPartitionDate#EPOCH_START}.
   *   <li>Then return {@link NoSqlTsPartitionDate#EPOCH_START}.
   * </ul>
   *
   * <p>Method under test: {@link NoSqlTsPartitionDate#truncatedTo(LocalDateTime)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime NoSqlTsPartitionDate.truncatedTo(LocalDateTime)"})
  public void testTruncatedTo_givenYears_whenEpoch_start_thenReturnEpoch_start() {
    // Arrange
    LocalDateTime time = NoSqlTsPartitionDate.EPOCH_START;

    // Act
    LocalDateTime actualTruncatedToResult = NoSqlTsPartitionDate.YEARS.truncatedTo(time);

    // Assert
    assertSame(time, actualTruncatedToResult);
  }

  /**
   * Test {@link NoSqlTsPartitionDate#parse(String)}.
   *
   * <ul>
   *   <li>When {@code DAYS}.
   *   <li>Then return {@link Optional#get()} is {@code DAYS}.
   * </ul>
   *
   * <p>Method under test: {@link NoSqlTsPartitionDate#parse(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional NoSqlTsPartitionDate.parse(String)"})
  public void testParse_whenDays_thenReturnGetIsDays() {
    // Arrange and Act
    Optional<NoSqlTsPartitionDate> actualParseResult = NoSqlTsPartitionDate.parse("DAYS");

    // Assert
    assertEquals(NoSqlTsPartitionDate.DAYS, actualParseResult.get());
    assertTrue(actualParseResult.isPresent());
  }

  /**
   * Test {@link NoSqlTsPartitionDate#parse(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link NoSqlTsPartitionDate#parse(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional NoSqlTsPartitionDate.parse(String)"})
  public void testParse_whenName_thenReturnNotPresent() {
    // Arrange and Act
    Optional<NoSqlTsPartitionDate> actualParseResult = NoSqlTsPartitionDate.parse("Name");

    // Assert
    assertFalse(actualParseResult.isPresent());
  }

  /**
   * Test {@link NoSqlTsPartitionDate#parse(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link NoSqlTsPartitionDate#parse(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional NoSqlTsPartitionDate.parse(String)"})
  public void testParse_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<NoSqlTsPartitionDate> actualParseResult = NoSqlTsPartitionDate.parse(null);

    // Assert
    assertFalse(actualParseResult.isPresent());
  }
}
