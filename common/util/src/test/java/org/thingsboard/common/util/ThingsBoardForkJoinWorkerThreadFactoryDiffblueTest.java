package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ThingsBoardForkJoinWorkerThreadFactoryDiffblueTest {
  /**
   * Test {@link
   * ThingsBoardForkJoinWorkerThreadFactory#ThingsBoardForkJoinWorkerThreadFactory(String)}.
   *
   * <p>Method under test: {@link
   * ThingsBoardForkJoinWorkerThreadFactory#ThingsBoardForkJoinWorkerThreadFactory(String)}
   */
  @Test
  @DisplayName("Test new ThingsBoardForkJoinWorkerThreadFactory(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ThingsBoardForkJoinWorkerThreadFactory.<init>(String)"})
  void testNewThingsBoardForkJoinWorkerThreadFactory() {
    // Arrange and Act
    ThingsBoardForkJoinWorkerThreadFactory actualThingsBoardForkJoinWorkerThreadFactory =
        new ThingsBoardForkJoinWorkerThreadFactory("Name Prefix");
    ForkJoinPool pool = ForkJoinPool.commonPool();
    ForkJoinWorkerThread actualNewThreadResult =
        actualThingsBoardForkJoinWorkerThreadFactory.newThread(pool);

    // Assert
    assertEquals(0, actualNewThreadResult.getPoolIndex());
    assertSame(pool, actualNewThreadResult.getPool());
  }

  /**
   * Test {@link ThingsBoardForkJoinWorkerThreadFactory#newThread(ForkJoinPool)}.
   *
   * <ul>
   *   <li>When commonPool.
   *   <li>Then return PoolIndex is zero.
   * </ul>
   *
   * <p>Method under test: {@link ThingsBoardForkJoinWorkerThreadFactory#newThread(ForkJoinPool)}
   */
  @Test
  @DisplayName("Test newThread(ForkJoinPool); when commonPool; then return PoolIndex is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ForkJoinWorkerThread ThingsBoardForkJoinWorkerThreadFactory.newThread(ForkJoinPool)"
  })
  void testNewThread_whenCommonPool_thenReturnPoolIndexIsZero() {
    // Arrange
    ThingsBoardForkJoinWorkerThreadFactory thingsBoardForkJoinWorkerThreadFactory =
        new ThingsBoardForkJoinWorkerThreadFactory("Name Prefix");
    ForkJoinPool pool = ForkJoinPool.commonPool();

    // Act
    ForkJoinWorkerThread actualNewThreadResult =
        thingsBoardForkJoinWorkerThreadFactory.newThread(pool);

    // Assert
    assertEquals(0, actualNewThreadResult.getPoolIndex());
    assertSame(pool, actualNewThreadResult.getPool());
  }

  /**
   * Test {@link ThingsBoardForkJoinWorkerThreadFactory#toString()}.
   *
   * <p>Method under test: {@link ThingsBoardForkJoinWorkerThreadFactory#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ThingsBoardForkJoinWorkerThreadFactory.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "ThingsBoardForkJoinWorkerThreadFactory(namePrefix=Name Prefix, threadNumber=1)",
        new ThingsBoardForkJoinWorkerThreadFactory("Name Prefix").toString());
  }
}
