package org.thingsboard.server.dao.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.thingsboard.server.dao.sql.TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder;

public class TbSqlBlockingQueueParamsDiffblueTest {
  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}, and
   * {@link TbSqlBlockingQueueParams#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSqlBlockingQueueParams#equals(Object)}
   *   <li>{@link TbSqlBlockingQueueParams#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbSqlBlockingQueueParams buildResult = TbSqlBlockingQueueParams.builder()
        .batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();
    TbSqlBlockingQueueParams buildResult2 = TbSqlBlockingQueueParams.builder()
        .batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}, and
   * {@link TbSqlBlockingQueueParams#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSqlBlockingQueueParams#equals(Object)}
   *   <li>{@link TbSqlBlockingQueueParams#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbSqlBlockingQueueParams buildResult = TbSqlBlockingQueueParams.builder()
        .batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSqlBlockingQueueParams#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder tbSqlBlockingQueueParamsBuilder = mock(
        TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder.class);
    when(tbSqlBlockingQueueParamsBuilder.batchSize(anyInt())).thenReturn(TbSqlBlockingQueueParams.builder());
    TbSqlBlockingQueueParams buildResult = tbSqlBlockingQueueParamsBuilder.batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();
    TbSqlBlockingQueueParams buildResult2 = TbSqlBlockingQueueParams.builder()
        .batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSqlBlockingQueueParams#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TbSqlBlockingQueueParams buildResult = TbSqlBlockingQueueParams.builder()
        .batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSqlBlockingQueueParams#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TbSqlBlockingQueueParams buildResult = TbSqlBlockingQueueParams.builder()
        .batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to TbSqlBlockingQueueParams");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSqlBlockingQueueParams#toString()}
   *   <li>{@link TbSqlBlockingQueueParams#getBatchSize()}
   *   <li>{@link TbSqlBlockingQueueParams#getLogName()}
   *   <li>{@link TbSqlBlockingQueueParams#getMaxDelay()}
   *   <li>{@link TbSqlBlockingQueueParams#getStatsNamePrefix()}
   *   <li>{@link TbSqlBlockingQueueParams#getStatsPrintIntervalMs()}
   *   <li>{@link TbSqlBlockingQueueParams#isBatchSortEnabled()}
   *   <li>{@link TbSqlBlockingQueueParams#isWithResponse()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    TbSqlBlockingQueueParams buildResult = TbSqlBlockingQueueParams.builder()
        .batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();

    // Act
    String actualToStringResult = buildResult.toString();
    int actualBatchSize = buildResult.getBatchSize();
    String actualLogName = buildResult.getLogName();
    long actualMaxDelay = buildResult.getMaxDelay();
    String actualStatsNamePrefix = buildResult.getStatsNamePrefix();
    long actualStatsPrintIntervalMs = buildResult.getStatsPrintIntervalMs();
    boolean actualIsBatchSortEnabledResult = buildResult.isBatchSortEnabled();

    // Assert
    assertEquals("Log Name", actualLogName);
    assertEquals("Stats Name Prefix", actualStatsNamePrefix);
    assertEquals("TbSqlBlockingQueueParams(logName=Log Name, batchSize=3, maxDelay=1, statsPrintIntervalMs=42,"
        + " statsNamePrefix=Stats Name Prefix, batchSortEnabled=true, withResponse=true)", actualToStringResult);
    assertEquals(1L, actualMaxDelay);
    assertEquals(3, actualBatchSize);
    assertEquals(42L, actualStatsPrintIntervalMs);
    assertTrue(actualIsBatchSortEnabledResult);
    assertTrue(buildResult.isWithResponse());
  }

  /**
   * Test
   * {@link TbSqlBlockingQueueParams#TbSqlBlockingQueueParams(String, int, long, long, String, boolean, boolean)}.
   * <p>
   * Method under test:
   * {@link TbSqlBlockingQueueParams#TbSqlBlockingQueueParams(String, int, long, long, String, boolean, boolean)}
   */
  @Test
  public void testNewTbSqlBlockingQueueParams() {
    // Arrange and Act
    TbSqlBlockingQueueParams actualTbSqlBlockingQueueParams = new TbSqlBlockingQueueParams("Log Name", 3, 1L, 42L,
        "Stats Name Prefix", true, true);

    // Assert
    assertEquals("Log Name", actualTbSqlBlockingQueueParams.getLogName());
    assertEquals("Stats Name Prefix", actualTbSqlBlockingQueueParams.getStatsNamePrefix());
    assertEquals(1L, actualTbSqlBlockingQueueParams.getMaxDelay());
    assertEquals(3, actualTbSqlBlockingQueueParams.getBatchSize());
    assertEquals(42L, actualTbSqlBlockingQueueParams.getStatsPrintIntervalMs());
    assertTrue(actualTbSqlBlockingQueueParams.isBatchSortEnabled());
    assertTrue(actualTbSqlBlockingQueueParams.isWithResponse());
  }

  /**
   * Test TbSqlBlockingQueueParamsBuilder
   * {@link TbSqlBlockingQueueParamsBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder#build()}
   *   <li>
   * {@link TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder#batchSize(int)}
   *   <li>
   * {@link TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder#batchSortEnabled(boolean)}
   *   <li>
   * {@link TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder#logName(String)}
   *   <li>
   * {@link TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder#maxDelay(long)}
   *   <li>
   * {@link TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder#statsNamePrefix(String)}
   *   <li>
   * {@link TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder#statsPrintIntervalMs(long)}
   *   <li>
   * {@link TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder#withResponse(boolean)}
   * </ul>
   */
  @Test
  public void testTbSqlBlockingQueueParamsBuilderBuild() {
    // Arrange and Act
    TbSqlBlockingQueueParams actualBuildResult = TbSqlBlockingQueueParams.builder()
        .batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();

    // Assert
    assertEquals("Log Name", actualBuildResult.getLogName());
    assertEquals("Stats Name Prefix", actualBuildResult.getStatsNamePrefix());
    assertEquals(1L, actualBuildResult.getMaxDelay());
    assertEquals(3, actualBuildResult.getBatchSize());
    assertEquals(42L, actualBuildResult.getStatsPrintIntervalMs());
    assertTrue(actualBuildResult.isBatchSortEnabled());
    assertTrue(actualBuildResult.isWithResponse());
  }
}
