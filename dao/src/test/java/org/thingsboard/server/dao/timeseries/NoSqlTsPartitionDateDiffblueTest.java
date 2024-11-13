package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.Test;

public class NoSqlTsPartitionDateDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NoSqlTsPartitionDate#getPattern()}
   *   <li>{@link NoSqlTsPartitionDate#getTruncateUnit()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    NoSqlTsPartitionDate valueOfResult = NoSqlTsPartitionDate.valueOf("MINUTES");

    // Act
    String actualPattern = valueOfResult.getPattern();
    valueOfResult.getTruncateUnit();

    // Assert
    assertEquals("yyyy-MM-dd-HH-mm", actualPattern);
  }

  /**
   * Test {@link NoSqlTsPartitionDate#parse(String)}.
   * <ul>
   *   <li>When {@code DAYS}.</li>
   *   <li>Then return {@link Optional#get()} is {@code DAYS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoSqlTsPartitionDate#parse(String)}
   */
  @Test
  public void testParse_whenDays_thenReturnGetIsDays() {
    // Arrange and Act
    Optional<NoSqlTsPartitionDate> actualParseResult = NoSqlTsPartitionDate.parse("DAYS");

    // Assert
    assertEquals(NoSqlTsPartitionDate.DAYS, actualParseResult.get());
    assertTrue(actualParseResult.isPresent());
  }

  /**
   * Test {@link NoSqlTsPartitionDate#parse(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoSqlTsPartitionDate#parse(String)}
   */
  @Test
  public void testParse_whenName_thenReturnNotPresent() {
    // Arrange and Act
    Optional<NoSqlTsPartitionDate> actualParseResult = NoSqlTsPartitionDate.parse("Name");

    // Assert
    assertFalse(actualParseResult.isPresent());
  }

  /**
   * Test {@link NoSqlTsPartitionDate#parse(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoSqlTsPartitionDate#parse(String)}
   */
  @Test
  public void testParse_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<NoSqlTsPartitionDate> actualParseResult = NoSqlTsPartitionDate.parse(null);

    // Assert
    assertFalse(actualParseResult.isPresent());
  }

  /**
   * Test {@link NoSqlTsPartitionDate#truncatedTo(LocalDateTime)}.
   * <ul>
   *   <li>Given {@code INDEFINITE}.</li>
   *   <li>When {@link NoSqlTsPartitionDate#EPOCH_START}.</li>
   *   <li>Then return {@link NoSqlTsPartitionDate#EPOCH_START}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoSqlTsPartitionDate#truncatedTo(LocalDateTime)}
   */
  @Test
  public void testTruncatedTo_givenIndefinite_whenEpoch_start_thenReturnEpoch_start() {
    // Arrange
    LocalDateTime time = NoSqlTsPartitionDate.EPOCH_START;

    // Act and Assert
    assertSame(time, NoSqlTsPartitionDate.INDEFINITE.truncatedTo(time));
  }

  /**
   * Test {@link NoSqlTsPartitionDate#truncatedTo(LocalDateTime)}.
   * <ul>
   *   <li>Given {@code MINUTES}.</li>
   *   <li>When {@link NoSqlTsPartitionDate#EPOCH_START}.</li>
   *   <li>Then return {@link NoSqlTsPartitionDate#EPOCH_START}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoSqlTsPartitionDate#truncatedTo(LocalDateTime)}
   */
  @Test
  public void testTruncatedTo_givenMinutes_whenEpoch_start_thenReturnEpoch_start() {
    // Arrange
    LocalDateTime time = NoSqlTsPartitionDate.EPOCH_START;

    // Act and Assert
    assertSame(time, NoSqlTsPartitionDate.MINUTES.truncatedTo(time));
  }

  /**
   * Test {@link NoSqlTsPartitionDate#truncatedTo(LocalDateTime)}.
   * <ul>
   *   <li>Given {@code MONTHS}.</li>
   *   <li>When {@link NoSqlTsPartitionDate#EPOCH_START}.</li>
   *   <li>Then return {@link NoSqlTsPartitionDate#EPOCH_START}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoSqlTsPartitionDate#truncatedTo(LocalDateTime)}
   */
  @Test
  public void testTruncatedTo_givenMonths_whenEpoch_start_thenReturnEpoch_start() {
    // Arrange
    LocalDateTime time = NoSqlTsPartitionDate.EPOCH_START;

    // Act and Assert
    assertSame(time, NoSqlTsPartitionDate.MONTHS.truncatedTo(time));
  }

  /**
   * Test {@link NoSqlTsPartitionDate#truncatedTo(LocalDateTime)}.
   * <ul>
   *   <li>Given {@code YEARS}.</li>
   *   <li>When {@link NoSqlTsPartitionDate#EPOCH_START}.</li>
   *   <li>Then return {@link NoSqlTsPartitionDate#EPOCH_START}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoSqlTsPartitionDate#truncatedTo(LocalDateTime)}
   */
  @Test
  public void testTruncatedTo_givenYears_whenEpoch_start_thenReturnEpoch_start() {
    // Arrange
    LocalDateTime time = NoSqlTsPartitionDate.EPOCH_START;

    // Act and Assert
    assertSame(time, NoSqlTsPartitionDate.YEARS.truncatedTo(time));
  }
}
