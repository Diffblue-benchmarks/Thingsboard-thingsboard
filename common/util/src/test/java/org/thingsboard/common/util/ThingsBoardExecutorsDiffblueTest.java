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
package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ThingsBoardExecutorsDiffblueTest {
  /**
   * Test {@link ThingsBoardExecutors#newWorkStealingPool(int, Class)} with {@code parallelism}, {@code clazz}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@link ForkJoinPool}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThingsBoardExecutors#newWorkStealingPool(int, Class)}
   */
  @Test
  @DisplayName("Test newWorkStealingPool(int, Class) with 'parallelism', 'clazz'; when one; then return ForkJoinPool")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExecutorService ThingsBoardExecutors.newWorkStealingPool(int, Class)"})
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
   * Test {@link ThingsBoardExecutors#newWorkStealingPool(int, String)} with {@code parallelism}, {@code namePrefix}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@link ForkJoinPool}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ThingsBoardExecutors#newWorkStealingPool(int, String)}
   */
  @Test
  @DisplayName("Test newWorkStealingPool(int, String) with 'parallelism', 'namePrefix'; when one; then return ForkJoinPool")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ExecutorService ThingsBoardExecutors.newWorkStealingPool(int, String)"})
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
