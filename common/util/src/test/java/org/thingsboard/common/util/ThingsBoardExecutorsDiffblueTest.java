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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import org.junit.jupiter.api.Test;

class ThingsBoardExecutorsDiffblueTest {
  /**
   * Method under test:
   * {@link ThingsBoardExecutors#newWorkStealingPool(int, Class)}
   */
  @Test
  void testNewWorkStealingPool() {
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
   * Method under test:
   * {@link ThingsBoardExecutors#newWorkStealingPool(int, String)}
   */
  @Test
  void testNewWorkStealingPool2() {
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
