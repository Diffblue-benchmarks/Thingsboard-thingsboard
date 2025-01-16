package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.Test;

public class SqlTsPartitionDateDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SqlTsPartitionDate#getPattern()}
   *   <li>{@link SqlTsPartitionDate#getTruncateUnit()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    SqlTsPartitionDate valueOfResult = SqlTsPartitionDate.valueOf("DAYS");

    // Act
    String actualPattern = valueOfResult.getPattern();
    valueOfResult.getTruncateUnit();

    // Assert
    assertEquals("yyyy_MM_dd", actualPattern);
  }

  /**
   * Test {@link SqlTsPartitionDate#parse(String)}.
   * <ul>
   *   <li>When {@code DAYS}.</li>
   *   <li>Then return {@link Optional#get()} is {@code DAYS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlTsPartitionDate#parse(String)}
   */
  @Test
  public void testParse_whenDays_thenReturnGetIsDays() {
    // Arrange and Act
    Optional<SqlTsPartitionDate> actualParseResult = SqlTsPartitionDate.parse("DAYS");

    // Assert
    assertEquals(SqlTsPartitionDate.DAYS, actualParseResult.get());
    assertTrue(actualParseResult.isPresent());
  }

  /**
   * Test {@link SqlTsPartitionDate#parse(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlTsPartitionDate#parse(String)}
   */
  @Test
  public void testParse_whenName_thenReturnNotPresent() {
    // Arrange and Act
    Optional<SqlTsPartitionDate> actualParseResult = SqlTsPartitionDate.parse("Name");

    // Assert
    assertFalse(actualParseResult.isPresent());
  }

  /**
   * Test {@link SqlTsPartitionDate#parse(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlTsPartitionDate#parse(String)}
   */
  @Test
  public void testParse_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<SqlTsPartitionDate> actualParseResult = SqlTsPartitionDate.parse(null);

    // Assert
    assertFalse(actualParseResult.isPresent());
  }

  /**
   * Test {@link SqlTsPartitionDate#plusTo(LocalDateTime)}.
   * <ul>
   *   <li>Given {@code DAYS}.</li>
   *   <li>When {@link SqlTsPartitionDate#EPOCH_START}.</li>
   *   <li>Then return toLocalDate toString is {@code 1970-01-02}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlTsPartitionDate#plusTo(LocalDateTime)}
   */
  @Test
  public void testPlusTo_givenDays_whenEpoch_start_thenReturnToLocalDateToStringIs19700102() {
    // Arrange and Act
    LocalDateTime actualPlusToResult = SqlTsPartitionDate.DAYS.plusTo(SqlTsPartitionDate.EPOCH_START);

    // Assert
    assertEquals("00:00", actualPlusToResult.toLocalTime().toString());
    assertEquals("1970-01-02", actualPlusToResult.toLocalDate().toString());
  }

  /**
   * Test {@link SqlTsPartitionDate#plusTo(LocalDateTime)}.
   * <ul>
   *   <li>Given {@code INDEFINITE}.</li>
   *   <li>When {@link SqlTsPartitionDate#EPOCH_START}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlTsPartitionDate#plusTo(LocalDateTime)}
   */
  @Test
  public void testPlusTo_givenIndefinite_whenEpoch_start_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> SqlTsPartitionDate.INDEFINITE.plusTo(SqlTsPartitionDate.EPOCH_START));
  }

  /**
   * Test {@link SqlTsPartitionDate#plusTo(LocalDateTime)}.
   * <ul>
   *   <li>Given {@code MONTHS}.</li>
   *   <li>When {@link SqlTsPartitionDate#EPOCH_START}.</li>
   *   <li>Then return toLocalDate toString is {@code 1970-02-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlTsPartitionDate#plusTo(LocalDateTime)}
   */
  @Test
  public void testPlusTo_givenMonths_whenEpoch_start_thenReturnToLocalDateToStringIs19700201() {
    // Arrange and Act
    LocalDateTime actualPlusToResult = SqlTsPartitionDate.MONTHS.plusTo(SqlTsPartitionDate.EPOCH_START);

    // Assert
    assertEquals("00:00", actualPlusToResult.toLocalTime().toString());
    assertEquals("1970-02-01", actualPlusToResult.toLocalDate().toString());
  }

  /**
   * Test {@link SqlTsPartitionDate#plusTo(LocalDateTime)}.
   * <ul>
   *   <li>Given {@code YEARS}.</li>
   *   <li>When {@link SqlTsPartitionDate#EPOCH_START}.</li>
   *   <li>Then return toLocalDate toString is {@code 1971-01-01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlTsPartitionDate#plusTo(LocalDateTime)}
   */
  @Test
  public void testPlusTo_givenYears_whenEpoch_start_thenReturnToLocalDateToStringIs19710101() {
    // Arrange and Act
    LocalDateTime actualPlusToResult = SqlTsPartitionDate.YEARS.plusTo(SqlTsPartitionDate.EPOCH_START);

    // Assert
    assertEquals("00:00", actualPlusToResult.toLocalTime().toString());
    assertEquals("1971-01-01", actualPlusToResult.toLocalDate().toString());
  }

  /**
   * Test {@link SqlTsPartitionDate#trancateTo(LocalDateTime)}.
   * <ul>
   *   <li>Given {@code DAYS}.</li>
   *   <li>When {@link SqlTsPartitionDate#EPOCH_START}.</li>
   *   <li>Then return {@link SqlTsPartitionDate#EPOCH_START}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlTsPartitionDate#trancateTo(LocalDateTime)}
   */
  @Test
  public void testTrancateTo_givenDays_whenEpoch_start_thenReturnEpoch_start() {
    // Arrange
    LocalDateTime time = SqlTsPartitionDate.EPOCH_START;

    // Act and Assert
    assertSame(time, SqlTsPartitionDate.DAYS.trancateTo(time));
  }

  /**
   * Test {@link SqlTsPartitionDate#trancateTo(LocalDateTime)}.
   * <ul>
   *   <li>Given {@code INDEFINITE}.</li>
   *   <li>When {@link SqlTsPartitionDate#EPOCH_START}.</li>
   *   <li>Then return {@link SqlTsPartitionDate#EPOCH_START}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlTsPartitionDate#trancateTo(LocalDateTime)}
   */
  @Test
  public void testTrancateTo_givenIndefinite_whenEpoch_start_thenReturnEpoch_start() {
    // Arrange
    LocalDateTime time = SqlTsPartitionDate.EPOCH_START;

    // Act and Assert
    assertSame(time, SqlTsPartitionDate.INDEFINITE.trancateTo(time));
  }

  /**
   * Test {@link SqlTsPartitionDate#trancateTo(LocalDateTime)}.
   * <ul>
   *   <li>Given {@code MONTHS}.</li>
   *   <li>When {@link SqlTsPartitionDate#EPOCH_START}.</li>
   *   <li>Then return {@link SqlTsPartitionDate#EPOCH_START}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlTsPartitionDate#trancateTo(LocalDateTime)}
   */
  @Test
  public void testTrancateTo_givenMonths_whenEpoch_start_thenReturnEpoch_start() {
    // Arrange
    LocalDateTime time = SqlTsPartitionDate.EPOCH_START;

    // Act and Assert
    assertSame(time, SqlTsPartitionDate.MONTHS.trancateTo(time));
  }

  /**
   * Test {@link SqlTsPartitionDate#trancateTo(LocalDateTime)}.
   * <ul>
   *   <li>Given {@code YEARS}.</li>
   *   <li>When {@link SqlTsPartitionDate#EPOCH_START}.</li>
   *   <li>Then return {@link SqlTsPartitionDate#EPOCH_START}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlTsPartitionDate#trancateTo(LocalDateTime)}
   */
  @Test
  public void testTrancateTo_givenYears_whenEpoch_start_thenReturnEpoch_start() {
    // Arrange
    LocalDateTime time = SqlTsPartitionDate.EPOCH_START;

    // Act and Assert
    assertSame(time, SqlTsPartitionDate.YEARS.trancateTo(time));
  }
}
