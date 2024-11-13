package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ThingsBoardExecutorsDiffblueTest {
  /**
   * Test {@link ThingsBoardExecutors#newWorkStealingPool(int, Class)} with
   * {@code parallelism}, {@code clazz}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@link ForkJoinPool}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ThingsBoardExecutors#newWorkStealingPool(int, Class)}
   */
  @Test
  @DisplayName("Test newWorkStealingPool(int, Class) with 'parallelism', 'clazz'; when one; then return ForkJoinPool")
  void testNewWorkStealingPoolWithParallelismClazz_whenOne_thenReturnForkJoinPool() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act
    ExecutorService actualNewWorkStealingPoolResult = ThingsBoardExecutors.newWorkStealingPool(1, clazz);

    // Assert
    assertTrue(actualNewWorkStealingPoolResult instanceof ForkJoinPool);
    assertTrue(((ForkJoinPool) actualNewWorkStealingPoolResult)
        .getFactory() instanceof ThingsBoardForkJoinWorkerThreadFactory);
    assertNull(((ForkJoinPool) actualNewWorkStealingPoolResult).getUncaughtExceptionHandler());
    assertEquals(0, ((ForkJoinPool) actualNewWorkStealingPoolResult).getActiveThreadCount());
    assertEquals(0, ((ForkJoinPool) actualNewWorkStealingPoolResult).getPoolSize());
    assertEquals(0, ((ForkJoinPool) actualNewWorkStealingPoolResult).getQueuedSubmissionCount());
    assertEquals(0, ((ForkJoinPool) actualNewWorkStealingPoolResult).getRunningThreadCount());
    assertEquals(0L, ((ForkJoinPool) actualNewWorkStealingPoolResult).getQueuedTaskCount());
    assertEquals(0L, ((ForkJoinPool) actualNewWorkStealingPoolResult).getStealCount());
    assertEquals(1, ((ForkJoinPool) actualNewWorkStealingPoolResult).getParallelism());
    assertFalse(((ForkJoinPool) actualNewWorkStealingPoolResult).hasQueuedSubmissions());
    assertFalse(((ForkJoinPool) actualNewWorkStealingPoolResult).isTerminating());
    assertTrue(((ForkJoinPool) actualNewWorkStealingPoolResult).getAsyncMode());
    assertTrue(((ForkJoinPool) actualNewWorkStealingPoolResult).isQuiescent());
  }

  /**
   * Test {@link ThingsBoardExecutors#newWorkStealingPool(int, String)} with
   * {@code parallelism}, {@code namePrefix}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@link ForkJoinPool}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ThingsBoardExecutors#newWorkStealingPool(int, String)}
   */
  @Test
  @DisplayName("Test newWorkStealingPool(int, String) with 'parallelism', 'namePrefix'; when one; then return ForkJoinPool")
  void testNewWorkStealingPoolWithParallelismNamePrefix_whenOne_thenReturnForkJoinPool() {
    // Arrange and Act
    ExecutorService actualNewWorkStealingPoolResult = ThingsBoardExecutors.newWorkStealingPool(1, "Name Prefix");

    // Assert
    assertTrue(actualNewWorkStealingPoolResult instanceof ForkJoinPool);
    assertTrue(((ForkJoinPool) actualNewWorkStealingPoolResult)
        .getFactory() instanceof ThingsBoardForkJoinWorkerThreadFactory);
    assertNull(((ForkJoinPool) actualNewWorkStealingPoolResult).getUncaughtExceptionHandler());
    assertEquals(0, ((ForkJoinPool) actualNewWorkStealingPoolResult).getActiveThreadCount());
    assertEquals(0, ((ForkJoinPool) actualNewWorkStealingPoolResult).getPoolSize());
    assertEquals(0, ((ForkJoinPool) actualNewWorkStealingPoolResult).getQueuedSubmissionCount());
    assertEquals(0, ((ForkJoinPool) actualNewWorkStealingPoolResult).getRunningThreadCount());
    assertEquals(0L, ((ForkJoinPool) actualNewWorkStealingPoolResult).getQueuedTaskCount());
    assertEquals(0L, ((ForkJoinPool) actualNewWorkStealingPoolResult).getStealCount());
    assertEquals(1, ((ForkJoinPool) actualNewWorkStealingPoolResult).getParallelism());
    assertFalse(((ForkJoinPool) actualNewWorkStealingPoolResult).hasQueuedSubmissions());
    assertFalse(((ForkJoinPool) actualNewWorkStealingPoolResult).isTerminating());
    assertTrue(((ForkJoinPool) actualNewWorkStealingPoolResult).getAsyncMode());
    assertTrue(((ForkJoinPool) actualNewWorkStealingPoolResult).isQuiescent());
  }
}
