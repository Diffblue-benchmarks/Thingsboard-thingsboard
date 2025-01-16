package org.thingsboard.server.queue.scheduler;

import static org.mockito.Mockito.mock;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.awaitility.core.FieldSupplierBuilder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {DefaultSchedulerComponent.class})
@ExtendWith(SpringExtension.class)
class DefaultSchedulerComponentDiffblueTest {
  @Autowired
  private DefaultSchedulerComponent defaultSchedulerComponent;

  /**
   * Test {@link DefaultSchedulerComponent#init()}.
   * <p>
   * Method under test: {@link DefaultSchedulerComponent#init()}
   */
  @Test
  @DisplayName("Test init()")
  void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    defaultSchedulerComponent.init();
  }

  /**
   * Test {@link DefaultSchedulerComponent#destroy()}.
   * <p>
   * Method under test: {@link DefaultSchedulerComponent#destroy()}
   */
  @Test
  @DisplayName("Test destroy()")
  void testDestroy() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    defaultSchedulerComponent.destroy();
  }

  /**
   * Test {@link DefaultSchedulerComponent#schedule(Callable, long, TimeUnit)}
   * with {@code callable}, {@code delay}, {@code unit}.
   * <ul>
   *   <li>When {@link Callable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSchedulerComponent#schedule(Callable, long, TimeUnit)}
   */
  @Test
  @DisplayName("Test schedule(Callable, long, TimeUnit) with 'callable', 'delay', 'unit'; when Callable")
  void testScheduleWithCallableDelayUnit_whenCallable() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    defaultSchedulerComponent.<Object>schedule(mock(Callable.class), 1L, TimeUnit.NANOSECONDS);
  }

  /**
   * Test {@link DefaultSchedulerComponent#schedule(Callable, long, TimeUnit)}
   * with {@code callable}, {@code delay}, {@code unit}.
   * <ul>
   *   <li>When {@link FieldSupplierBuilder#FieldSupplierBuilder(Object)} with
   * {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSchedulerComponent#schedule(Callable, long, TimeUnit)}
   */
  @Test
  @DisplayName("Test schedule(Callable, long, TimeUnit) with 'callable', 'delay', 'unit'; when FieldSupplierBuilder(Object) with 'Object'")
  @Disabled("TODO: Complete this test")
  void testScheduleWithCallableDelayUnit_whenFieldSupplierBuilderWithObject() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask@47c4bea9[Not completed, task = org.awaitility.core.FieldSupplierBuilder$AnnotationFieldSupplier@2214fd50] rejected from java.util.concurrent.ScheduledThreadPoolExecutor@558dee82[Terminated, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
    //       at java.base/java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2065)
    //       at java.base/java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:833)
    //       at java.base/java.util.concurrent.ScheduledThreadPoolExecutor.delayedExecute(ScheduledThreadPoolExecutor.java:340)
    //       at java.base/java.util.concurrent.ScheduledThreadPoolExecutor.schedule(ScheduledThreadPoolExecutor.java:579)
    //       at java.base/java.util.concurrent.Executors$DelegatedScheduledExecutorService.schedule(Executors.java:816)
    //       at org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent.schedule(DefaultSchedulerComponent.java:53)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    defaultSchedulerComponent.schedule((new FieldSupplierBuilder("Object")).new AnnotationFieldSupplier(), 1L,
        TimeUnit.NANOSECONDS);
  }

  /**
   * Test {@link DefaultSchedulerComponent#schedule(Runnable, long, TimeUnit)}
   * with {@code command}, {@code delay}, {@code unit}.
   * <p>
   * Method under test:
   * {@link DefaultSchedulerComponent#schedule(Runnable, long, TimeUnit)}
   */
  @Test
  @DisplayName("Test schedule(Runnable, long, TimeUnit) with 'command', 'delay', 'unit'")
  @Disabled("TODO: Complete this test")
  void testScheduleWithCommandDelayUnit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask@7905266c[Not completed, task = java.util.concurrent.Executors$RunnableAdapter@54c11cb6[Wrapped task = Mock for Runnable, hashCode: 1762099296]] rejected from java.util.concurrent.ScheduledThreadPoolExecutor@4ed6429d[Terminated, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
    //       at java.base/java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2065)
    //       at java.base/java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:833)
    //       at java.base/java.util.concurrent.ScheduledThreadPoolExecutor.delayedExecute(ScheduledThreadPoolExecutor.java:340)
    //       at java.base/java.util.concurrent.ScheduledThreadPoolExecutor.schedule(ScheduledThreadPoolExecutor.java:562)
    //       at java.base/java.util.concurrent.Executors$DelegatedScheduledExecutorService.schedule(Executors.java:813)
    //       at org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent.schedule(DefaultSchedulerComponent.java:49)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    defaultSchedulerComponent.schedule(mock(Runnable.class), 1L, TimeUnit.NANOSECONDS);
  }

  /**
   * Test
   * {@link DefaultSchedulerComponent#scheduleAtFixedRate(Runnable, long, long, TimeUnit)}.
   * <p>
   * Method under test:
   * {@link DefaultSchedulerComponent#scheduleAtFixedRate(Runnable, long, long, TimeUnit)}
   */
  @Test
  @DisplayName("Test scheduleAtFixedRate(Runnable, long, long, TimeUnit)")
  @Disabled("TODO: Complete this test")
  void testScheduleAtFixedRate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask@1681e2c6[Not completed, task = java.util.concurrent.Executors$RunnableAdapter@7a6f0298[Wrapped task = org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent$$Lambda$3126/0x000001d155126cb0@1f7f6b42]] rejected from java.util.concurrent.ScheduledThreadPoolExecutor@2faa8643[Terminated, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 1]
    //       at java.base/java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2065)
    //       at java.base/java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:833)
    //       at java.base/java.util.concurrent.ScheduledThreadPoolExecutor.delayedExecute(ScheduledThreadPoolExecutor.java:340)
    //       at java.base/java.util.concurrent.ScheduledThreadPoolExecutor.scheduleAtFixedRate(ScheduledThreadPoolExecutor.java:632)
    //       at java.base/java.util.concurrent.Executors$DelegatedScheduledExecutorService.scheduleAtFixedRate(Executors.java:819)
    //       at org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent.scheduleAtFixedRate(DefaultSchedulerComponent.java:57)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    defaultSchedulerComponent.scheduleAtFixedRate(mock(Runnable.class), 1L, 1L, TimeUnit.NANOSECONDS);
  }

  /**
   * Test
   * {@link DefaultSchedulerComponent#scheduleWithFixedDelay(Runnable, long, long, TimeUnit)}.
   * <ul>
   *   <li>When {@link Runnable}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSchedulerComponent#scheduleWithFixedDelay(Runnable, long, long, TimeUnit)}
   */
  @Test
  @DisplayName("Test scheduleWithFixedDelay(Runnable, long, long, TimeUnit); when Runnable")
  void testScheduleWithFixedDelay_whenRunnable() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    defaultSchedulerComponent.scheduleWithFixedDelay(mock(Runnable.class), 1L, 1L, TimeUnit.NANOSECONDS);
  }

  /**
   * Test
   * {@link DefaultSchedulerComponent#scheduleWithFixedDelay(Runnable, long, long, TimeUnit)}.
   * <ul>
   *   <li>When {@link Thread#Thread()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSchedulerComponent#scheduleWithFixedDelay(Runnable, long, long, TimeUnit)}
   */
  @Test
  @DisplayName("Test scheduleWithFixedDelay(Runnable, long, long, TimeUnit); when Thread()")
  @Disabled("TODO: Complete this test")
  void testScheduleWithFixedDelay_whenThread() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask@787d1fb[Not completed, task = java.util.concurrent.Executors$RunnableAdapter@1c411f07[Wrapped task = org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent$$Lambda$3127/0x000001d1551275d0@1258c8e2]] rejected from java.util.concurrent.ScheduledThreadPoolExecutor@61731577[Terminated, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
    //       at java.base/java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2065)
    //       at java.base/java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:833)
    //       at java.base/java.util.concurrent.ScheduledThreadPoolExecutor.delayedExecute(ScheduledThreadPoolExecutor.java:340)
    //       at java.base/java.util.concurrent.ScheduledThreadPoolExecutor.scheduleWithFixedDelay(ScheduledThreadPoolExecutor.java:680)
    //       at java.base/java.util.concurrent.Executors$DelegatedScheduledExecutorService.scheduleWithFixedDelay(Executors.java:822)
    //       at org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent.scheduleWithFixedDelay(DefaultSchedulerComponent.java:61)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    defaultSchedulerComponent.scheduleWithFixedDelay(new Thread(), 1L, 1L, TimeUnit.NANOSECONDS);
  }
}
