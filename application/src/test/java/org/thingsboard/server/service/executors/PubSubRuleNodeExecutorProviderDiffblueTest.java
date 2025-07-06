package org.thingsboard.server.service.executors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.common.util.ThingsBoardThreadFactory;

class PubSubRuleNodeExecutorProviderDiffblueTest {
  /**
   * Test {@link PubSubRuleNodeExecutorProvider#init()}.
   *
   * <p>Method under test: {@link PubSubRuleNodeExecutorProvider#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PubSubRuleNodeExecutorProvider.init()"})
  void testInit() {
    // Arrange
    PubSubRuleNodeExecutorProvider pubSubRuleNodeExecutorProvider =
        new PubSubRuleNodeExecutorProvider();

    // Act
    pubSubRuleNodeExecutorProvider.init();

    // Assert
    ScheduledExecutorService executor = pubSubRuleNodeExecutorProvider.getExecutor();
    assertTrue(executor instanceof ScheduledThreadPoolExecutor);
    assertTrue(
        ((ScheduledThreadPoolExecutor) executor).getThreadFactory()
            instanceof ThingsBoardThreadFactory);
    assertEquals(0, ((ScheduledThreadPoolExecutor) executor).getActiveCount());
    assertEquals(0, ((ScheduledThreadPoolExecutor) executor).getLargestPoolSize());
    assertEquals(0, ((ScheduledThreadPoolExecutor) executor).getPoolSize());
    assertEquals(0L, ((ScheduledThreadPoolExecutor) executor).getCompletedTaskCount());
    assertEquals(0L, ((ScheduledThreadPoolExecutor) executor).getTaskCount());
    assertEquals(100, ((ScheduledThreadPoolExecutor) executor).getCorePoolSize());
    assertFalse(
        ((ScheduledThreadPoolExecutor) executor)
            .getContinueExistingPeriodicTasksAfterShutdownPolicy());
    assertFalse(((ScheduledThreadPoolExecutor) executor).getRemoveOnCancelPolicy());
    assertTrue(((ScheduledThreadPoolExecutor) executor).getQueue().isEmpty());
    assertTrue(
        ((ScheduledThreadPoolExecutor) executor)
            .getExecuteExistingDelayedTasksAfterShutdownPolicy());
    assertEquals(Integer.MAX_VALUE, ((ScheduledThreadPoolExecutor) executor).getMaximumPoolSize());
  }

  /**
   * Test {@link PubSubRuleNodeExecutorProvider#getExecutor()}.
   *
   * <p>Method under test: {@link PubSubRuleNodeExecutorProvider#getExecutor()}
   */
  @Test
  @DisplayName("Test getExecutor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ScheduledExecutorService PubSubRuleNodeExecutorProvider.getExecutor()"})
  void testGetExecutor() {
    // Arrange, Act and Assert
    assertNull(new PubSubRuleNodeExecutorProvider().getExecutor());
  }
}
