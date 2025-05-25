package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NoSqlTsPartitionDate#getPattern()}
   *   <li>{@link NoSqlTsPartitionDate#getTruncateUnit()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NoSqlTsPartitionDate.getPattern()", "TemporalUnit NoSqlTsPartitionDate.getTruncateUnit()"})
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
   * <ul>
   *   <li>Given {@code INDEFINITE}.</li>
   *   <li>When {@link NoSqlTsPartitionDate#EPOCH_START}.</li>
   *   <li>Then return {@link NoSqlTsPartitionDate#EPOCH_START}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoSqlTsPartitionDate#truncatedTo(LocalDateTime)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LocalDateTime NoSqlTsPartitionDate.truncatedTo(LocalDateTime)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LocalDateTime NoSqlTsPartitionDate.truncatedTo(LocalDateTime)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LocalDateTime NoSqlTsPartitionDate.truncatedTo(LocalDateTime)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"LocalDateTime NoSqlTsPartitionDate.truncatedTo(LocalDateTime)"})
  public void testTruncatedTo_givenYears_whenEpoch_start_thenReturnEpoch_start() {
    // Arrange
    LocalDateTime time = NoSqlTsPartitionDate.EPOCH_START;

    // Act and Assert
    assertSame(time, NoSqlTsPartitionDate.YEARS.truncatedTo(time));
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
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link NoSqlTsPartitionDate#parse(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional NoSqlTsPartitionDate.parse(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional NoSqlTsPartitionDate.parse(String)"})
  public void testParse_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<NoSqlTsPartitionDate> actualParseResult = NoSqlTsPartitionDate.parse(null);

    // Assert
    assertFalse(actualParseResult.isPresent());
  }
}
