package org.thingsboard.server.dao.sql;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.SettableFuture;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.stats.DefaultMessagesStats;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.dao.sql.TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder;

public class TbSqlBlockingQueueDiffblueTest {
  /**
   * Test
   * {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator, Function, int)}.
   * <p>
   * Method under test:
   * {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator, Function, int)}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbSqlBlockingQueueParams params = TbSqlBlockingQueueParams.builder()
        .batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(5L)
        .withResponse(true)
        .build();
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");

    AtomicInteger aiCounter2 = new AtomicInteger(1);
    StatsCounter successfulCounter = new StatsCounter(aiCounter2, new CumulativeCounter(null), "Name");

    AtomicInteger aiCounter3 = new AtomicInteger(1);
    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, new DefaultMessagesStats(
        totalCounter, successfulCounter, new StatsCounter(aiCounter3, new CumulativeCounter(null), "Name")));
    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing().when(logExecutor)
        .scheduleAtFixedRate(Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());

    // Act
    tbSqlBlockingQueue.init(logExecutor, mock(Function.class), mock(Comparator.class), mock(Function.class), 1);

    // Assert
    verify(logExecutor).scheduleAtFixedRate(isA(Runnable.class), eq(5L), eq(5L), eq(TimeUnit.MILLISECONDS));
  }

  /**
   * Test
   * {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator, Function, int)}.
   * <p>
   * Method under test:
   * {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator, Function, int)}
   */
  @Test
  public void testInit2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbSqlBlockingQueueParams params = TbSqlBlockingQueueParams.builder()
        .batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(Long.MIN_VALUE)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(5L)
        .withResponse(true)
        .build();
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");

    AtomicInteger aiCounter2 = new AtomicInteger(1);
    StatsCounter successfulCounter = new StatsCounter(aiCounter2, new CumulativeCounter(null), "Name");

    AtomicInteger aiCounter3 = new AtomicInteger(1);
    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, new DefaultMessagesStats(
        totalCounter, successfulCounter, new StatsCounter(aiCounter3, new CumulativeCounter(null), "Name")));
    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing().when(logExecutor)
        .scheduleAtFixedRate(Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());

    // Act
    tbSqlBlockingQueue.init(logExecutor, mock(Function.class), mock(Comparator.class), mock(Function.class), 1);

    // Assert
    verify(logExecutor).scheduleAtFixedRate(isA(Runnable.class), eq(5L), eq(5L), eq(TimeUnit.MILLISECONDS));
  }

  /**
   * Test
   * {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator, Function, int)}.
   * <ul>
   *   <li>Then calls
   * {@link ScheduledLogExecutorComponent#scheduleAtFixedRate(Runnable, long, long, TimeUnit)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator, Function, int)}
   */
  @Test
  public void testInit_thenCallsScheduleAtFixedRate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbSqlBlockingQueueParams params = TbSqlBlockingQueueParams.builder()
        .batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");

    AtomicInteger aiCounter2 = new AtomicInteger(1);
    StatsCounter successfulCounter = new StatsCounter(aiCounter2, new CumulativeCounter(null), "Name");

    AtomicInteger aiCounter3 = new AtomicInteger(1);
    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, new DefaultMessagesStats(
        totalCounter, successfulCounter, new StatsCounter(aiCounter3, new CumulativeCounter(null), "Name")));
    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing().when(logExecutor)
        .scheduleAtFixedRate(Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());

    // Act
    tbSqlBlockingQueue.init(logExecutor, mock(Function.class), mock(Comparator.class), mock(Function.class), 1);

    // Assert
    verify(logExecutor).scheduleAtFixedRate(isA(Runnable.class), eq(42L), eq(42L), eq(TimeUnit.MILLISECONDS));
  }

  /**
   * Test {@link TbSqlBlockingQueue#destroy()}.
   * <ul>
   *   <li>Then calls {@link TbSqlBlockingQueueParamsBuilder#batchSize(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSqlBlockingQueue#destroy()}
   */
  @Test
  public void testDestroy_thenCallsBatchSize() {
    // Arrange
    TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder tbSqlBlockingQueueParamsBuilder = mock(
        TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder.class);
    when(tbSqlBlockingQueueParamsBuilder.batchSize(anyInt())).thenReturn(TbSqlBlockingQueueParams.builder());
    TbSqlBlockingQueueParams params = tbSqlBlockingQueueParamsBuilder.batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");

    AtomicInteger aiCounter2 = new AtomicInteger(1);
    StatsCounter successfulCounter = new StatsCounter(aiCounter2, new CumulativeCounter(null), "Name");

    AtomicInteger aiCounter3 = new AtomicInteger(1);
    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, new DefaultMessagesStats(
        totalCounter, successfulCounter, new StatsCounter(aiCounter3, new CumulativeCounter(null), "Name")));

    // Act
    tbSqlBlockingQueue.destroy();

    // Assert that nothing has changed
    verify(tbSqlBlockingQueueParamsBuilder).batchSize(eq(3));
  }

  /**
   * Test {@link TbSqlBlockingQueue#add(Object)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSqlBlockingQueue#add(Object)}
   */
  @Test
  public void testAdd_thenReturnSettableFuture() {
    // Arrange
    TbSqlBlockingQueueParams params = TbSqlBlockingQueueParams.builder()
        .batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(mock(Meter.Id.class)), "Name");

    AtomicInteger aiCounter2 = new AtomicInteger(1);
    StatsCounter successfulCounter = new StatsCounter(aiCounter2, new CumulativeCounter(mock(Meter.Id.class)), "Name");

    AtomicInteger aiCounter3 = new AtomicInteger(1);
    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params,
        new DefaultMessagesStats(totalCounter, successfulCounter,
            new StatsCounter(aiCounter3, new CumulativeCounter(mock(Meter.Id.class)), "Name")));

    // Act and Assert
    assertTrue(tbSqlBlockingQueue.add("Element") instanceof SettableFuture);
  }
}
