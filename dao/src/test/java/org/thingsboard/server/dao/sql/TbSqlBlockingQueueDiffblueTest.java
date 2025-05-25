package org.thingsboard.server.dao.sql;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.SettableFuture;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Meter.Id;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.stats.DefaultMessagesStats;
import org.thingsboard.server.common.stats.StatsCounter;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class TbSqlBlockingQueueDiffblueTest {
  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator, Function, int)}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.</li>
   *   <li>When one.</li>
   *   <li>Then calls {@link ScheduledLogExecutorComponent#scheduleAtFixedRate(Runnable, long, long, TimeUnit)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator, Function, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void TbSqlBlockingQueue.init(ScheduledLogExecutorComponent, Function, Comparator, Function, int)"})
  public void testInit_givenAtomicIntegerWithOne_whenOne_thenCallsScheduleAtFixedRate() {
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
   * Test {@link TbSqlBlockingQueue#add(Object)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSqlBlockingQueue#add(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"com.google.common.util.concurrent.ListenableFuture TbSqlBlockingQueue.add(Object)"})
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
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(mock(Id.class)), "Name");

    AtomicInteger aiCounter2 = new AtomicInteger(1);
    StatsCounter successfulCounter = new StatsCounter(aiCounter2, new CumulativeCounter(mock(Id.class)), "Name");

    AtomicInteger aiCounter3 = new AtomicInteger(1);
    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, new DefaultMessagesStats(
        totalCounter, successfulCounter, new StatsCounter(aiCounter3, new CumulativeCounter(mock(Id.class)), "Name")));

    // Act and Assert
    assertTrue(tbSqlBlockingQueue.add("Element") instanceof SettableFuture);
  }
}
