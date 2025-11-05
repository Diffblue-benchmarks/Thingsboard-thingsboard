package org.thingsboard.server.queue.scheduler;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DefaultSchedulerComponentDiffblueTest {
  @InjectMocks private DefaultSchedulerComponent defaultSchedulerComponent;

  @Mock private ScheduledExecutorService scheduledExecutorService;

  /**
   * Test {@link DefaultSchedulerComponent#destroy()}.
   *
   * <p>Method under test: {@link DefaultSchedulerComponent#destroy()}
   */
  @Test
  @DisplayName("Test destroy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultSchedulerComponent.destroy()"})
  void testDestroy() {
    // Arrange
    when(scheduledExecutorService.shutdownNow()).thenReturn(new ArrayList<>());

    // Act
    defaultSchedulerComponent.destroy();

    // Assert
    verify(scheduledExecutorService).shutdownNow();
  }

  /**
   * Test {@link DefaultSchedulerComponent#schedule(Callable, long, TimeUnit)} with {@code
   * callable}, {@code delay}, {@code unit}.
   *
   * <p>Method under test: {@link DefaultSchedulerComponent#schedule(Callable, long, TimeUnit)}
   */
  @Test
  @DisplayName("Test schedule(Callable, long, TimeUnit) with 'callable', 'delay', 'unit'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledFuture DefaultSchedulerComponent.schedule(Callable, long, TimeUnit)"
  })
  void testScheduleWithCallableDelayUnit() {
    // Arrange
    when(scheduledExecutorService.schedule(
            Mockito.<Callable<Object>>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);

    // Act
    ScheduledFuture<Object> actualScheduleResult =
        defaultSchedulerComponent.schedule(mock(Callable.class), 1L, TimeUnit.NANOSECONDS);

    // Assert
    verify(scheduledExecutorService)
        .schedule(isA(Callable.class), eq(1L), eq(TimeUnit.NANOSECONDS));
    assertNull(actualScheduleResult);
  }

  /**
   * Test {@link DefaultSchedulerComponent#schedule(Runnable, long, TimeUnit)} with {@code command},
   * {@code delay}, {@code unit}.
   *
   * <p>Method under test: {@link DefaultSchedulerComponent#schedule(Runnable, long, TimeUnit)}
   */
  @Test
  @DisplayName("Test schedule(Runnable, long, TimeUnit) with 'command', 'delay', 'unit'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledFuture DefaultSchedulerComponent.schedule(Runnable, long, TimeUnit)"
  })
  void testScheduleWithCommandDelayUnit() {
    // Arrange
    Mockito.<ScheduledFuture<?>>when(
            scheduledExecutorService.schedule(
                Mockito.<Runnable>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);

    // Act
    ScheduledFuture<?> actualScheduleResult =
        defaultSchedulerComponent.schedule(mock(Runnable.class), 1L, TimeUnit.NANOSECONDS);

    // Assert
    verify(scheduledExecutorService)
        .schedule(isA(Runnable.class), eq(1L), eq(TimeUnit.NANOSECONDS));
    assertNull(actualScheduleResult);
  }

  /**
   * Test {@link DefaultSchedulerComponent#scheduleAtFixedRate(Runnable, long, long, TimeUnit)}.
   *
   * <p>Method under test: {@link DefaultSchedulerComponent#scheduleAtFixedRate(Runnable, long,
   * long, TimeUnit)}
   */
  @Test
  @DisplayName("Test scheduleAtFixedRate(Runnable, long, long, TimeUnit)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledFuture DefaultSchedulerComponent.scheduleAtFixedRate(Runnable, long, long, TimeUnit)"
  })
  void testScheduleAtFixedRate() {
    // Arrange
    Mockito.<ScheduledFuture<?>>when(
            scheduledExecutorService.scheduleAtFixedRate(
                Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);

    // Act
    ScheduledFuture<?> actualScheduleAtFixedRateResult =
        defaultSchedulerComponent.scheduleAtFixedRate(
            mock(Runnable.class), 1L, 1L, TimeUnit.NANOSECONDS);

    // Assert
    verify(scheduledExecutorService)
        .scheduleAtFixedRate(isA(Runnable.class), eq(1L), eq(1L), eq(TimeUnit.NANOSECONDS));
    assertNull(actualScheduleAtFixedRateResult);
  }

  /**
   * Test {@link DefaultSchedulerComponent#scheduleWithFixedDelay(Runnable, long, long, TimeUnit)}.
   *
   * <p>Method under test: {@link DefaultSchedulerComponent#scheduleWithFixedDelay(Runnable, long,
   * long, TimeUnit)}
   */
  @Test
  @DisplayName("Test scheduleWithFixedDelay(Runnable, long, long, TimeUnit)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScheduledFuture DefaultSchedulerComponent.scheduleWithFixedDelay(Runnable, long, long, TimeUnit)"
  })
  void testScheduleWithFixedDelay() {
    // Arrange
    Mockito.<ScheduledFuture<?>>when(
            scheduledExecutorService.scheduleWithFixedDelay(
                Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);

    // Act
    ScheduledFuture<?> actualScheduleWithFixedDelayResult =
        defaultSchedulerComponent.scheduleWithFixedDelay(
            mock(Runnable.class), 1L, 1L, TimeUnit.NANOSECONDS);

    // Assert
    verify(scheduledExecutorService)
        .scheduleWithFixedDelay(isA(Runnable.class), eq(1L), eq(1L), eq(TimeUnit.NANOSECONDS));
    assertNull(actualScheduleWithFixedDelayResult);
  }
}
