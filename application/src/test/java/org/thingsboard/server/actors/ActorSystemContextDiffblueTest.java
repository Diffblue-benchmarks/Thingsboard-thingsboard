package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.common.util.ThingsBoardThreadFactory;

class ActorSystemContextDiffblueTest {
  /**
   * Test {@link ActorSystemContext#getScheduler()}.
   * <ul>
   *   <li>Then return {@link ScheduledThreadPoolExecutor}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActorSystemContext#getScheduler()}
   */
  @Test
  @DisplayName("Test getScheduler(); then return ScheduledThreadPoolExecutor")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ScheduledExecutorService ActorSystemContext.getScheduler()"})
  void testGetScheduler_thenReturnScheduledThreadPoolExecutor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    ActorSystemContext actorSystemContext = new ActorSystemContext();
    actorSystemContext.setActorSystem(new DefaultTbActorSystem(new TbActorSystemSettings(1, 3, 3)));

    // Act
    ScheduledExecutorService actualScheduler = actorSystemContext.getScheduler();

    // Assert
    assertTrue(actualScheduler instanceof ScheduledThreadPoolExecutor);
    assertTrue(((ScheduledThreadPoolExecutor) actualScheduler).getThreadFactory() instanceof ThingsBoardThreadFactory);
    assertEquals(0, ((ScheduledThreadPoolExecutor) actualScheduler).getActiveCount());
    assertEquals(0, ((ScheduledThreadPoolExecutor) actualScheduler).getLargestPoolSize());
    assertEquals(0, ((ScheduledThreadPoolExecutor) actualScheduler).getPoolSize());
    assertEquals(0L, ((ScheduledThreadPoolExecutor) actualScheduler).getCompletedTaskCount());
    assertEquals(0L, ((ScheduledThreadPoolExecutor) actualScheduler).getTaskCount());
    assertEquals(3, ((ScheduledThreadPoolExecutor) actualScheduler).getCorePoolSize());
    assertFalse(((ScheduledThreadPoolExecutor) actualScheduler).getContinueExistingPeriodicTasksAfterShutdownPolicy());
    assertFalse(((ScheduledThreadPoolExecutor) actualScheduler).getRemoveOnCancelPolicy());
    assertTrue(((ScheduledThreadPoolExecutor) actualScheduler).getQueue().isEmpty());
    assertTrue(((ScheduledThreadPoolExecutor) actualScheduler).getExecuteExistingDelayedTasksAfterShutdownPolicy());
    assertEquals(Integer.MAX_VALUE, ((ScheduledThreadPoolExecutor) actualScheduler).getMaximumPoolSize());
  }
}
