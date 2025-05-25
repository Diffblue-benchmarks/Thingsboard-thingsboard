package org.thingsboard.server.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

class SchedulingConfigurationDiffblueTest {
  /**
   * Test {@link SchedulingConfiguration#configureTasks(ScheduledTaskRegistrar)}.
   * <ul>
   *   <li>Then {@link ScheduledTaskRegistrar} (default constructor) Scheduler PoolSize is twenty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchedulingConfiguration#configureTasks(ScheduledTaskRegistrar)}
   */
  @Test
  @DisplayName("Test configureTasks(ScheduledTaskRegistrar); then ScheduledTaskRegistrar (default constructor) Scheduler PoolSize is twenty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SchedulingConfiguration.configureTasks(ScheduledTaskRegistrar)"})
  void testConfigureTasks_thenScheduledTaskRegistrarSchedulerPoolSizeIsTwenty() {
    // Arrange
    SchedulingConfiguration schedulingConfiguration = new SchedulingConfiguration();
    ScheduledTaskRegistrar taskRegistrar = new ScheduledTaskRegistrar();

    // Act
    schedulingConfiguration.configureTasks(taskRegistrar);

    // Assert
    TaskScheduler scheduler = taskRegistrar.getScheduler();
    assertTrue(scheduler instanceof ThreadPoolTaskScheduler);
    assertEquals("TB-Scheduling-", ((ThreadPoolTaskScheduler) scheduler).getThreadNamePrefix());
    assertNull(((ThreadPoolTaskScheduler) scheduler).getThreadGroup());
    assertEquals(0, ((ThreadPoolTaskScheduler) scheduler).getActiveCount());
    assertEquals(20, ((ThreadPoolTaskScheduler) scheduler).getPoolSize());
    assertEquals(5, ((ThreadPoolTaskScheduler) scheduler).getThreadPriority());
    assertFalse(((ThreadPoolTaskScheduler) scheduler).isRunning());
    assertFalse(((ThreadPoolTaskScheduler) scheduler).isDaemon());
    assertTrue(((ThreadPoolTaskScheduler) scheduler).isAutoStartup());
    assertTrue(((ThreadPoolTaskScheduler) scheduler).isRemoveOnCancelPolicy());
    assertEquals(Integer.MAX_VALUE, ((ThreadPoolTaskScheduler) scheduler).getPhase());
  }

  /**
   * Test {@link SchedulingConfiguration#taskScheduler()}.
   * <ul>
   *   <li>Given {@link SchedulingConfiguration} (default constructor).</li>
   *   <li>Then return PoolSize is twenty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SchedulingConfiguration#taskScheduler()}
   */
  @Test
  @DisplayName("Test taskScheduler(); given SchedulingConfiguration (default constructor); then return PoolSize is twenty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TaskScheduler SchedulingConfiguration.taskScheduler()"})
  void testTaskScheduler_givenSchedulingConfiguration_thenReturnPoolSizeIsTwenty() {
    // Arrange and Act
    TaskScheduler actualTaskSchedulerResult = (new SchedulingConfiguration()).taskScheduler();

    // Assert
    assertTrue(actualTaskSchedulerResult instanceof ThreadPoolTaskScheduler);
    assertEquals("TB-Scheduling-", ((ThreadPoolTaskScheduler) actualTaskSchedulerResult).getThreadNamePrefix());
    assertNull(((ThreadPoolTaskScheduler) actualTaskSchedulerResult).getThreadGroup());
    assertEquals(0, ((ThreadPoolTaskScheduler) actualTaskSchedulerResult).getActiveCount());
    assertEquals(20, ((ThreadPoolTaskScheduler) actualTaskSchedulerResult).getPoolSize());
    assertEquals(5, ((ThreadPoolTaskScheduler) actualTaskSchedulerResult).getThreadPriority());
    assertFalse(((ThreadPoolTaskScheduler) actualTaskSchedulerResult).isRunning());
    assertFalse(((ThreadPoolTaskScheduler) actualTaskSchedulerResult).isDaemon());
    assertTrue(((ThreadPoolTaskScheduler) actualTaskSchedulerResult).isAutoStartup());
    assertTrue(((ThreadPoolTaskScheduler) actualTaskSchedulerResult).isRemoveOnCancelPolicy());
    assertEquals(Integer.MAX_VALUE, ((ThreadPoolTaskScheduler) actualTaskSchedulerResult).getPhase());
  }
}
