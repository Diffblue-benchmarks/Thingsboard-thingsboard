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
package org.thingsboard.server.dao.sql;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.SettableFuture;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Meter.Id;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import io.micrometer.core.instrument.noop.NoopCounter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.stats.DefaultMessagesStats;
import org.thingsboard.server.common.stats.MessagesStats;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.dao.sql.TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class TbSqlBlockingQueueDiffblueTest {
  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <p>Method under test: {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function,
   * Comparator, Function, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbSqlBlockingQueue.init(ScheduledLogExecutorComponent, Function, Comparator, Function, int)"
  })
  public void testInit() {
    // Arrange
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();
    AtomicInteger aiCounter = new AtomicInteger();
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");
    AtomicInteger aiCounter2 = new AtomicInteger();
    StatsCounter successfulCounter =
        new StatsCounter(aiCounter2, new CumulativeCounter(null), "Name");
    AtomicInteger aiCounter3 = new AtomicInteger();
    StatsCounter failedCounter = new StatsCounter(aiCounter3, new CumulativeCounter(null), "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);

    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing()
        .when(logExecutor)
        .scheduleAtFixedRate(
            Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());

    // Act
    tbSqlBlockingQueue.init(
        logExecutor, mock(Function.class), mock(Comparator.class), mock(Function.class), 1);

    // Assert
    verify(logExecutor)
        .scheduleAtFixedRate(isA(Runnable.class), eq(42L), eq(42L), eq(TimeUnit.MILLISECONDS));
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <p>Method under test: {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function,
   * Comparator, Function, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbSqlBlockingQueue.init(ScheduledLogExecutorComponent, Function, Comparator, Function, int)"
  })
  public void testInit2() {
    // Arrange
    NoopCounter micrometerCounter = mock(NoopCounter.class);
    doNothing().when(micrometerCounter).increment(anyDouble());
    StatsCounter totalCounter = new StatsCounter(new AtomicInteger(), micrometerCounter, "Name");
    StatsCounter successfulCounter = new StatsCounter(null, new CumulativeCounter(null), "Name");
    AtomicInteger aiCounter = new AtomicInteger();
    StatsCounter failedCounter = new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(0L)
            .withResponse(true)
            .build();

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);
    tbSqlBlockingQueue.add("Element");

    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing()
        .when(logExecutor)
        .scheduleAtFixedRate(
            Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());
    Function<List<Object>, List<Object>> saveFunction = mock(Function.class);
    Comparator<Object> batchUpdateComparator = mock(Comparator.class);

    Function<List<TbSqlQueueElement<Object, Object>>, List<TbSqlQueueElement<Object, Object>>>
        filter = mock(Function.class);
    when(filter.apply(Mockito.<List<TbSqlQueueElement<Object, Object>>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    tbSqlBlockingQueue.init(logExecutor, saveFunction, batchUpdateComparator, filter, 1);

    // Assert
    verify(micrometerCounter).increment(1.0d);
    verify(logExecutor)
        .scheduleAtFixedRate(isA(Runnable.class), eq(0L), eq(0L), eq(TimeUnit.MILLISECONDS));
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <p>Method under test: {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function,
   * Comparator, Function, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbSqlBlockingQueue.init(ScheduledLogExecutorComponent, Function, Comparator, Function, int)"
  })
  public void testInit3() {
    // Arrange
    MessagesStats stats = mock(MessagesStats.class);
    doNothing().when(stats).incrementTotal();
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(1)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(1L)
            .withResponse(true)
            .build();

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);
    tbSqlBlockingQueue.add("Element");

    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing()
        .when(logExecutor)
        .scheduleAtFixedRate(
            Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());

    Function<List<Object>, List<Object>> saveFunction = mock(Function.class);
    when(saveFunction.apply(Mockito.<List<Object>>any())).thenReturn(new ArrayList<>());
    Comparator<Object> batchUpdateComparator = mock(Comparator.class);

    Function<List<TbSqlQueueElement<Object, Object>>, List<TbSqlQueueElement<Object, Object>>>
        filter = mock(Function.class);
    when(filter.apply(Mockito.<List<TbSqlQueueElement<Object, Object>>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    tbSqlBlockingQueue.init(logExecutor, saveFunction, batchUpdateComparator, filter, 1);

    // Assert
    verify(stats).incrementTotal();
    verify(logExecutor)
        .scheduleAtFixedRate(isA(Runnable.class), eq(1L), eq(1L), eq(TimeUnit.MILLISECONDS));
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <p>Method under test: {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function,
   * Comparator, Function, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbSqlBlockingQueue.init(ScheduledLogExecutorComponent, Function, Comparator, Function, int)"
  })
  public void testInit4() {
    // Arrange
    TbSqlBlockingQueueParamsBuilder tbSqlBlockingQueueParamsBuilder =
        mock(TbSqlBlockingQueueParamsBuilder.class);
    when(tbSqlBlockingQueueParamsBuilder.batchSortEnabled(anyBoolean()))
        .thenReturn(new TbSqlBlockingQueueParamsBuilder());

    TbSqlBlockingQueueParamsBuilder tbSqlBlockingQueueParamsBuilder2 =
        mock(TbSqlBlockingQueueParamsBuilder.class);
    when(tbSqlBlockingQueueParamsBuilder2.batchSize(anyInt()))
        .thenReturn(tbSqlBlockingQueueParamsBuilder);
    TbSqlBlockingQueueParams params =
        tbSqlBlockingQueueParamsBuilder2
            .batchSize(1)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(1L)
            .withResponse(true)
            .build();

    MessagesStats stats = mock(MessagesStats.class);
    doNothing().when(stats).incrementTotal();

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);
    tbSqlBlockingQueue.add(null);

    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing()
        .when(logExecutor)
        .scheduleAtFixedRate(
            Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());
    Function<List<Object>, List<Object>> saveFunction = mock(Function.class);
    Comparator<Object> batchUpdateComparator = mock(Comparator.class);

    Function<List<TbSqlQueueElement<Object, Object>>, List<TbSqlQueueElement<Object, Object>>>
        filter = mock(Function.class);
    when(filter.apply(Mockito.<List<TbSqlQueueElement<Object, Object>>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    tbSqlBlockingQueue.init(logExecutor, saveFunction, batchUpdateComparator, filter, 1);

    // Assert
    verify(stats).incrementTotal();
    verify(logExecutor)
        .scheduleAtFixedRate(isA(Runnable.class), eq(1L), eq(1L), eq(TimeUnit.MILLISECONDS));
    verify(tbSqlBlockingQueueParamsBuilder2).batchSize(1);
    verify(tbSqlBlockingQueueParamsBuilder).batchSortEnabled(true);
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       TbSqlQueueElement#TbSqlQueueElement(SettableFuture, Object)} with future is create and
   *       {@code Entity}.
   * </ul>
   *
   * <p>Method under test: {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function,
   * Comparator, Function, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbSqlBlockingQueue.init(ScheduledLogExecutorComponent, Function, Comparator, Function, int)"
  })
  public void testInit_givenArrayListAddTbSqlQueueElementWithFutureIsCreateAndEntity() {
    // Arrange
    MessagesStats stats = mock(MessagesStats.class);
    doNothing().when(stats).incrementTotal();
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(1)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(1L)
            .withResponse(true)
            .build();

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);
    tbSqlBlockingQueue.add("Element");

    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing()
        .when(logExecutor)
        .scheduleAtFixedRate(
            Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());
    Function<List<Object>, List<Object>> saveFunction = mock(Function.class);
    Comparator<Object> batchUpdateComparator = mock(Comparator.class);

    ArrayList<TbSqlQueueElement<Object, Object>> tbSqlQueueElementList = new ArrayList<>();
    SettableFuture<Object> future = SettableFuture.create();
    tbSqlQueueElementList.add(new TbSqlQueueElement<>(future, "Entity"));

    Function<List<TbSqlQueueElement<Object, Object>>, List<TbSqlQueueElement<Object, Object>>>
        filter = mock(Function.class);
    when(filter.apply(Mockito.<List<TbSqlQueueElement<Object, Object>>>any()))
        .thenReturn(tbSqlQueueElementList);

    // Act
    tbSqlBlockingQueue.init(logExecutor, saveFunction, batchUpdateComparator, filter, 1);

    // Assert
    verify(stats).incrementTotal();
    verify(logExecutor)
        .scheduleAtFixedRate(isA(Runnable.class), eq(1L), eq(1L), eq(TimeUnit.MILLISECONDS));
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.
   *   <li>Then calls {@link NoopCounter#increment(double)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function,
   * Comparator, Function, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbSqlBlockingQueue.init(ScheduledLogExecutorComponent, Function, Comparator, Function, int)"
  })
  public void testInit_givenAtomicIntegerWithOne_thenCallsIncrement() {
    // Arrange
    NoopCounter micrometerCounter = mock(NoopCounter.class);
    doNothing().when(micrometerCounter).increment(anyDouble());
    StatsCounter totalCounter = new StatsCounter(new AtomicInteger(), micrometerCounter, "Name");
    StatsCounter successfulCounter = new StatsCounter(null, new CumulativeCounter(null), "Name");
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter failedCounter = new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(1L)
            .withResponse(true)
            .build();

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);
    tbSqlBlockingQueue.add("Element");

    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing()
        .when(logExecutor)
        .scheduleAtFixedRate(
            Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());

    Function<List<Object>, List<Object>> saveFunction = mock(Function.class);
    when(saveFunction.apply(Mockito.<List<Object>>any())).thenReturn(new ArrayList<>());
    Comparator<Object> batchUpdateComparator = mock(Comparator.class);

    Function<List<TbSqlQueueElement<Object, Object>>, List<TbSqlQueueElement<Object, Object>>>
        filter = mock(Function.class);
    when(filter.apply(Mockito.<List<TbSqlQueueElement<Object, Object>>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    tbSqlBlockingQueue.init(logExecutor, saveFunction, batchUpdateComparator, filter, 1);

    // Assert
    verify(micrometerCounter).increment(1.0d);
    verify(logExecutor)
        .scheduleAtFixedRate(isA(Runnable.class), eq(1L), eq(1L), eq(TimeUnit.MILLISECONDS));
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <ul>
   *   <li>Given {@link TbSqlBlockingQueueParamsBuilder} {@link
   *       TbSqlBlockingQueueParamsBuilder#batchSortEnabled(boolean)} return builder.
   * </ul>
   *
   * <p>Method under test: {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function,
   * Comparator, Function, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbSqlBlockingQueue.init(ScheduledLogExecutorComponent, Function, Comparator, Function, int)"
  })
  public void testInit_givenTbSqlBlockingQueueParamsBuilderBatchSortEnabledReturnBuilder() {
    // Arrange
    TbSqlBlockingQueueParamsBuilder tbSqlBlockingQueueParamsBuilder =
        mock(TbSqlBlockingQueueParamsBuilder.class);
    when(tbSqlBlockingQueueParamsBuilder.batchSortEnabled(anyBoolean()))
        .thenReturn(TbSqlBlockingQueueParams.builder());

    TbSqlBlockingQueueParamsBuilder tbSqlBlockingQueueParamsBuilder2 =
        mock(TbSqlBlockingQueueParamsBuilder.class);
    when(tbSqlBlockingQueueParamsBuilder2.batchSize(anyInt()))
        .thenReturn(tbSqlBlockingQueueParamsBuilder);
    TbSqlBlockingQueueParams params =
        tbSqlBlockingQueueParamsBuilder2
            .batchSize(1)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(5L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(1L)
            .withResponse(true)
            .build();

    MessagesStats stats = mock(MessagesStats.class);
    doNothing().when(stats).incrementTotal();

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");

    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing()
        .when(logExecutor)
        .scheduleAtFixedRate(
            Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());

    Function<List<Object>, List<Object>> saveFunction = mock(Function.class);
    when(saveFunction.apply(Mockito.<List<Object>>any())).thenReturn(new ArrayList<>());
    Comparator<Object> batchUpdateComparator = mock(Comparator.class);

    Function<List<TbSqlQueueElement<Object, Object>>, List<TbSqlQueueElement<Object, Object>>>
        filter = mock(Function.class);
    when(filter.apply(Mockito.<List<TbSqlQueueElement<Object, Object>>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    tbSqlBlockingQueue.init(logExecutor, saveFunction, batchUpdateComparator, filter, 1);

    // Assert
    verify(stats, atLeast(1)).incrementTotal();
    verify(logExecutor)
        .scheduleAtFixedRate(isA(Runnable.class), eq(1L), eq(1L), eq(TimeUnit.MILLISECONDS));
    verify(tbSqlBlockingQueueParamsBuilder2).batchSize(1);
    verify(tbSqlBlockingQueueParamsBuilder).batchSortEnabled(true);
  }

  /**
   * Test {@link TbSqlBlockingQueue#destroy()}.
   *
   * <p>Method under test: {@link TbSqlBlockingQueue#destroy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqlBlockingQueue.destroy()"})
  public void testDestroy() {
    // Arrange
    TbSqlBlockingQueueParamsBuilder tbSqlBlockingQueueParamsBuilder =
        mock(TbSqlBlockingQueueParamsBuilder.class);
    when(tbSqlBlockingQueueParamsBuilder.batchSize(anyInt()))
        .thenReturn(new TbSqlBlockingQueueParamsBuilder());
    TbSqlBlockingQueueParams params =
        tbSqlBlockingQueueParamsBuilder
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();
    AtomicInteger aiCounter = new AtomicInteger();
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");
    AtomicInteger aiCounter2 = new AtomicInteger();
    StatsCounter successfulCounter =
        new StatsCounter(aiCounter2, new CumulativeCounter(null), "Name");
    AtomicInteger aiCounter3 = new AtomicInteger();
    StatsCounter failedCounter = new StatsCounter(aiCounter3, new CumulativeCounter(null), "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);

    // Act
    tbSqlBlockingQueue.destroy();

    // Assert
    verify(tbSqlBlockingQueueParamsBuilder).batchSize(3);
  }

  /**
   * Test {@link TbSqlBlockingQueue#destroy()}.
   *
   * <p>Method under test: {@link TbSqlBlockingQueue#destroy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqlBlockingQueue.destroy()"})
  public void testDestroy2() {
    // Arrange
    TbSqlBlockingQueueParamsBuilder tbSqlBlockingQueueParamsBuilder =
        mock(TbSqlBlockingQueueParamsBuilder.class);
    when(tbSqlBlockingQueueParamsBuilder.batchSize(anyInt()))
        .thenReturn(TbSqlBlockingQueueParams.builder());
    TbSqlBlockingQueueParams params =
        tbSqlBlockingQueueParamsBuilder
            .batchSize(Integer.MIN_VALUE)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();
    AtomicInteger aiCounter = new AtomicInteger();
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");
    AtomicInteger aiCounter2 = new AtomicInteger();
    StatsCounter successfulCounter =
        new StatsCounter(aiCounter2, new CumulativeCounter(null), "Name");
    AtomicInteger aiCounter3 = new AtomicInteger();
    StatsCounter failedCounter = new StatsCounter(aiCounter3, new CumulativeCounter(null), "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);

    // Act
    tbSqlBlockingQueue.destroy();

    // Assert
    verify(tbSqlBlockingQueueParamsBuilder).batchSize(-2147483648);
  }

  /**
   * Test {@link TbSqlBlockingQueue#destroy()}.
   *
   * <p>Method under test: {@link TbSqlBlockingQueue#destroy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqlBlockingQueue.destroy()"})
  public void testDestroy3() {
    // Arrange
    TbSqlBlockingQueueParamsBuilder tbSqlBlockingQueueParamsBuilder =
        mock(TbSqlBlockingQueueParamsBuilder.class);
    when(tbSqlBlockingQueueParamsBuilder.batchSize(anyInt()))
        .thenReturn(TbSqlBlockingQueueParams.builder());
    TbSqlBlockingQueueParams params =
        tbSqlBlockingQueueParamsBuilder
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();
    StatsCounter totalCounter = new StatsCounter(new AtomicInteger(), null, "Name");
    AtomicInteger aiCounter = new AtomicInteger();
    StatsCounter successfulCounter =
        new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");
    AtomicInteger aiCounter2 = new AtomicInteger();
    StatsCounter failedCounter = new StatsCounter(aiCounter2, new CumulativeCounter(null), "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);

    // Act
    tbSqlBlockingQueue.destroy();

    // Assert
    verify(tbSqlBlockingQueueParamsBuilder).batchSize(3);
  }

  /**
   * Test {@link TbSqlBlockingQueue#destroy()}.
   *
   * <ul>
   *   <li>Given {@link TbSqlBlockingQueueParamsBuilder} {@link
   *       TbSqlBlockingQueueParamsBuilder#batchSize(int)} return builder.
   * </ul>
   *
   * <p>Method under test: {@link TbSqlBlockingQueue#destroy()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSqlBlockingQueue.destroy()"})
  public void testDestroy_givenTbSqlBlockingQueueParamsBuilderBatchSizeReturnBuilder() {
    // Arrange
    TbSqlBlockingQueueParamsBuilder tbSqlBlockingQueueParamsBuilder =
        mock(TbSqlBlockingQueueParamsBuilder.class);
    when(tbSqlBlockingQueueParamsBuilder.batchSize(anyInt()))
        .thenReturn(TbSqlBlockingQueueParams.builder());
    TbSqlBlockingQueueParams params =
        tbSqlBlockingQueueParamsBuilder
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();
    AtomicInteger aiCounter = new AtomicInteger();
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");
    AtomicInteger aiCounter2 = new AtomicInteger();
    StatsCounter successfulCounter =
        new StatsCounter(aiCounter2, new CumulativeCounter(null), "Name");
    AtomicInteger aiCounter3 = new AtomicInteger();
    StatsCounter failedCounter = new StatsCounter(aiCounter3, new CumulativeCounter(null), "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);

    // Act
    tbSqlBlockingQueue.destroy();

    // Assert
    verify(tbSqlBlockingQueueParamsBuilder).batchSize(3);
  }

  /**
   * Test {@link TbSqlBlockingQueue#add(Object)}.
   *
   * <p>Method under test: {@link TbSqlBlockingQueue#add(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture TbSqlBlockingQueue.add(Object)"
  })
  public void testAdd() {
    // Arrange
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();
    AtomicInteger aiCounter = new AtomicInteger();
    CumulativeCounter micrometerCounter = new CumulativeCounter(mock(Id.class));

    StatsCounter totalCounter = new StatsCounter(aiCounter, micrometerCounter, "Name");
    AtomicInteger aiCounter2 = new AtomicInteger();
    CumulativeCounter micrometerCounter2 = new CumulativeCounter(mock(Id.class));

    StatsCounter successfulCounter = new StatsCounter(aiCounter2, micrometerCounter2, "Name");
    AtomicInteger aiCounter3 = new AtomicInteger();
    CumulativeCounter micrometerCounter3 = new CumulativeCounter(mock(Id.class));

    StatsCounter failedCounter = new StatsCounter(aiCounter3, micrometerCounter3, "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);

    // Act and Assert
    assertTrue(tbSqlBlockingQueue.add("Element") instanceof SettableFuture);
  }

  /**
   * Test {@link TbSqlBlockingQueue#add(Object)}.
   *
   * <p>Method under test: {@link TbSqlBlockingQueue#add(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture TbSqlBlockingQueue.add(Object)"
  })
  public void testAdd2() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger();
    CumulativeCounter micrometerCounter = new CumulativeCounter(mock(Id.class));

    StatsCounter totalCounter = new StatsCounter(aiCounter, micrometerCounter, "Name");
    AtomicInteger aiCounter2 = new AtomicInteger();
    CumulativeCounter micrometerCounter2 = new CumulativeCounter(mock(Id.class));

    StatsCounter successfulCounter = new StatsCounter(aiCounter2, micrometerCounter2, "Name");
    AtomicInteger aiCounter3 = new AtomicInteger();
    CumulativeCounter micrometerCounter3 = new CumulativeCounter(mock(Id.class));

    StatsCounter failedCounter = new StatsCounter(aiCounter3, micrometerCounter3, "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);
    stats.incrementTotal(0);
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);

    // Act and Assert
    assertTrue(tbSqlBlockingQueue.add("Element") instanceof SettableFuture);
  }

  /**
   * Test {@link TbSqlBlockingQueue#add(Object)}.
   *
   * <p>Method under test: {@link TbSqlBlockingQueue#add(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture TbSqlBlockingQueue.add(Object)"
  })
  public void testAdd3() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger();
    CumulativeCounter micrometerCounter = new CumulativeCounter(mock(Id.class));

    StatsCounter totalCounter = new StatsCounter(aiCounter, micrometerCounter, "Name");
    AtomicInteger aiCounter2 = new AtomicInteger();
    CumulativeCounter micrometerCounter2 = new CumulativeCounter(mock(Id.class));

    StatsCounter successfulCounter = new StatsCounter(aiCounter2, micrometerCounter2, "Name");
    AtomicInteger aiCounter3 = new AtomicInteger();
    CumulativeCounter micrometerCounter3 = new CumulativeCounter(mock(Id.class));

    StatsCounter failedCounter = new StatsCounter(aiCounter3, micrometerCounter3, "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);
    stats.incrementTotal(0);
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(0L)
            .withResponse(true)
            .build();

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);

    // Act and Assert
    assertTrue(tbSqlBlockingQueue.add("Element") instanceof SettableFuture);
  }

  /**
   * Test {@link TbSqlBlockingQueue#add(Object)}.
   *
   * <p>Method under test: {@link TbSqlBlockingQueue#add(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture TbSqlBlockingQueue.add(Object)"
  })
  public void testAdd4() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger();
    CumulativeCounter micrometerCounter = new CumulativeCounter(mock(Id.class));

    StatsCounter totalCounter = new StatsCounter(aiCounter, micrometerCounter, "");
    AtomicInteger aiCounter2 = new AtomicInteger();
    CumulativeCounter micrometerCounter2 = new CumulativeCounter(mock(Id.class));

    StatsCounter successfulCounter = new StatsCounter(aiCounter2, micrometerCounter2, "Name");
    AtomicInteger aiCounter3 = new AtomicInteger();
    CumulativeCounter micrometerCounter3 = new CumulativeCounter(mock(Id.class));

    StatsCounter failedCounter = new StatsCounter(aiCounter3, micrometerCounter3, "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);
    stats.incrementTotal(0);
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(0L)
            .withResponse(true)
            .build();

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);

    // Act and Assert
    assertTrue(tbSqlBlockingQueue.add("Element") instanceof SettableFuture);
  }

  /**
   * Test {@link TbSqlBlockingQueue#add(Object)}.
   *
   * <p>Method under test: {@link TbSqlBlockingQueue#add(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture TbSqlBlockingQueue.add(Object)"
  })
  public void testAdd5() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger();
    CumulativeCounter micrometerCounter = new CumulativeCounter(mock(Id.class));

    StatsCounter totalCounter = new StatsCounter(aiCounter, micrometerCounter, "");
    AtomicInteger aiCounter2 = new AtomicInteger();
    CumulativeCounter micrometerCounter2 = new CumulativeCounter(mock(Id.class));

    StatsCounter successfulCounter = new StatsCounter(aiCounter2, micrometerCounter2, "Name");
    AtomicInteger aiCounter3 = new AtomicInteger();
    CumulativeCounter micrometerCounter3 = new CumulativeCounter(mock(Id.class));

    StatsCounter failedCounter = new StatsCounter(aiCounter3, micrometerCounter3, "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);
    stats.incrementTotal(0);
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(-1)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(1L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(0L)
            .withResponse(true)
            .build();

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);

    // Act and Assert
    assertTrue(tbSqlBlockingQueue.add("Element") instanceof SettableFuture);
  }
}
