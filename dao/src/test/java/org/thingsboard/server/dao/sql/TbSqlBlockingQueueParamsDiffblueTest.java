package org.thingsboard.server.dao.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.dao.sql.TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder;

@ContextConfiguration(classes = {TbSqlBlockingQueueParamsBuilder.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TbSqlBlockingQueueParamsDiffblueTest {
  @Autowired
  private TbSqlBlockingQueueParamsBuilder tbSqlBlockingQueueParamsBuilder;

  /**
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}, and {@link TbSqlBlockingQueueParams#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbSqlBlockingQueueParams.equals(Object)", "int TbSqlBlockingQueueParams.hashCode()"})
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
   * Test {@link TbSqlBlockingQueueParams#equals(Object)}, and {@link TbSqlBlockingQueueParams#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbSqlBlockingQueueParams.equals(Object)", "int TbSqlBlockingQueueParams.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbSqlBlockingQueueParams.equals(Object)", "int TbSqlBlockingQueueParams.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbSqlBlockingQueueParamsBuilder tbSqlBlockingQueueParamsBuilder = mock(TbSqlBlockingQueueParamsBuilder.class);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbSqlBlockingQueueParams.equals(Object)", "int TbSqlBlockingQueueParams.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbSqlBlockingQueueParams.equals(Object)", "int TbSqlBlockingQueueParams.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int TbSqlBlockingQueueParams.getBatchSize()", "String TbSqlBlockingQueueParams.getLogName()",
      "long TbSqlBlockingQueueParams.getMaxDelay()", "String TbSqlBlockingQueueParams.getStatsNamePrefix()",
      "long TbSqlBlockingQueueParams.getStatsPrintIntervalMs()",
      "boolean TbSqlBlockingQueueParams.isBatchSortEnabled()", "boolean TbSqlBlockingQueueParams.isWithResponse()",
      "String TbSqlBlockingQueueParams.toString()"})
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
   * Test {@link TbSqlBlockingQueueParams#TbSqlBlockingQueueParams(String, int, long, long, String, boolean, boolean)}.
   * <p>
   * Method under test: {@link TbSqlBlockingQueueParams#TbSqlBlockingQueueParams(String, int, long, long, String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TbSqlBlockingQueueParams.<init>(String, int, long, long, String, boolean, boolean)"})
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
   * Test TbSqlBlockingQueueParamsBuilder {@link TbSqlBlockingQueueParamsBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSqlBlockingQueueParamsBuilder#build()}
   *   <li>{@link TbSqlBlockingQueueParamsBuilder#batchSize(int)}
   *   <li>{@link TbSqlBlockingQueueParamsBuilder#batchSortEnabled(boolean)}
   *   <li>{@link TbSqlBlockingQueueParamsBuilder#logName(String)}
   *   <li>{@link TbSqlBlockingQueueParamsBuilder#maxDelay(long)}
   *   <li>{@link TbSqlBlockingQueueParamsBuilder#statsNamePrefix(String)}
   *   <li>{@link TbSqlBlockingQueueParamsBuilder#statsPrintIntervalMs(long)}
   *   <li>{@link TbSqlBlockingQueueParamsBuilder#withResponse(boolean)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TbSqlBlockingQueueParamsBuilder.<init>()",
      "TbSqlBlockingQueueParamsBuilder TbSqlBlockingQueueParamsBuilder.batchSize(int)",
      "TbSqlBlockingQueueParamsBuilder TbSqlBlockingQueueParamsBuilder.batchSortEnabled(boolean)",
      "TbSqlBlockingQueueParams TbSqlBlockingQueueParamsBuilder.build()",
      "TbSqlBlockingQueueParamsBuilder TbSqlBlockingQueueParamsBuilder.logName(String)",
      "TbSqlBlockingQueueParamsBuilder TbSqlBlockingQueueParamsBuilder.maxDelay(long)",
      "TbSqlBlockingQueueParamsBuilder TbSqlBlockingQueueParamsBuilder.statsNamePrefix(String)",
      "TbSqlBlockingQueueParamsBuilder TbSqlBlockingQueueParamsBuilder.statsPrintIntervalMs(long)",
      "String TbSqlBlockingQueueParamsBuilder.toString()",
      "TbSqlBlockingQueueParamsBuilder TbSqlBlockingQueueParamsBuilder.withResponse(boolean)"})
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
