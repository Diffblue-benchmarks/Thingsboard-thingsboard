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
import io.micrometer.core.instrument.Meter.Type;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import io.micrometer.core.instrument.noop.NoopCounter;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.stats.DefaultMessagesStats;
import org.thingsboard.server.common.stats.MessagesStats;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.dao.sql.TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder;

@ContextConfiguration(classes = {TbSqlBlockingQueue.class, ScheduledLogExecutorComponent.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class TbSqlBlockingQueueDiffblueTest {
  @MockBean private MessagesStats messagesStats;

  @Autowired private ScheduledLogExecutorComponent scheduledLogExecutorComponent;

  @Autowired private TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue;

  @MockBean private TbSqlBlockingQueueParams tbSqlBlockingQueueParams;

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
    when(tbSqlBlockingQueueParams.getBatchSize()).thenReturn(1);
    when(tbSqlBlockingQueueParams.getMaxDelay()).thenReturn(1L);
    when(tbSqlBlockingQueueParams.getStatsPrintIntervalMs()).thenReturn(42L);
    when(tbSqlBlockingQueueParams.getLogName())
        .thenReturn("org.thingsboard.server.dao.sql.TbSqlBlockingQueueParams");

    // Act
    tbSqlBlockingQueue.init(
        scheduledLogExecutorComponent,
        mock(Function.class),
        mock(Comparator.class),
        mock(Function.class),
        1);

    // Assert
    verify(tbSqlBlockingQueueParams).getBatchSize();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getLogName();
    verify(tbSqlBlockingQueueParams).getMaxDelay();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getStatsPrintIntervalMs();
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
  public void testInit3() {
    // Arrange
    StatsCounter totalCounter = mock(StatsCounter.class);
    doNothing().when(totalCounter).add(anyInt());
    doNothing().when(totalCounter).increment();
    totalCounter.increment();
    AtomicInteger aiCounter = new AtomicInteger();

    StatsCounter successfulCounter =
        new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");
    successfulCounter.add(2);
    AtomicInteger aiCounter2 = new AtomicInteger();
    StatsCounter failedCounter = new StatsCounter(aiCounter2, new CumulativeCounter(null), "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(0L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");

    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing()
        .when(logExecutor)
        .scheduleAtFixedRate(
            Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());

    // Act
    tbSqlBlockingQueue.init(
        logExecutor, mock(Function.class), mock(Comparator.class), mock(Function.class), 1);

    // Assert
    verify(totalCounter, atLeast(1)).add(1);
    verify(totalCounter).increment();
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
  public void testInit4() {
    // Arrange
    StatsCounter totalCounter = mock(StatsCounter.class);
    doNothing().when(totalCounter).add(anyInt());
    doNothing().when(totalCounter).increment();
    totalCounter.increment();
    AtomicInteger aiCounter = new AtomicInteger();

    StatsCounter successfulCounter =
        new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");
    successfulCounter.add(2);
    AtomicInteger aiCounter2 = new AtomicInteger();
    StatsCounter failedCounter = new StatsCounter(aiCounter2, new CumulativeCounter(null), "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(1)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(0L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");

    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing()
        .when(logExecutor)
        .scheduleAtFixedRate(
            Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());

    // Act
    tbSqlBlockingQueue.init(
        logExecutor, mock(Function.class), mock(Comparator.class), mock(Function.class), 1);

    // Assert
    verify(totalCounter, atLeast(1)).add(1);
    verify(totalCounter).increment();
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
  public void testInit5() {
    // Arrange
    StatsCounter totalCounter = mock(StatsCounter.class);
    doNothing().when(totalCounter).add(anyInt());
    doNothing().when(totalCounter).increment();
    totalCounter.increment();
    AtomicInteger aiCounter = new AtomicInteger();

    StatsCounter successfulCounter =
        new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");
    successfulCounter.add(2);
    AtomicInteger aiCounter2 = new AtomicInteger();
    StatsCounter failedCounter = new StatsCounter(aiCounter2, new CumulativeCounter(null), "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(5)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(0L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");

    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing()
        .when(logExecutor)
        .scheduleAtFixedRate(
            Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());

    // Act
    tbSqlBlockingQueue.init(
        logExecutor, mock(Function.class), mock(Comparator.class), mock(Function.class), 1);

    // Assert
    verify(totalCounter, atLeast(1)).add(1);
    verify(totalCounter).increment();
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
  public void testInit6() {
    // Arrange
    StatsCounter totalCounter = mock(StatsCounter.class);
    doNothing().when(totalCounter).add(anyInt());
    doNothing().when(totalCounter).increment();
    totalCounter.increment();
    AtomicInteger aiCounter = new AtomicInteger();

    StatsCounter successfulCounter =
        new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");
    successfulCounter.add(5);
    successfulCounter.add(2);
    AtomicInteger aiCounter2 = new AtomicInteger();
    StatsCounter failedCounter = new StatsCounter(aiCounter2, new CumulativeCounter(null), "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(0L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");

    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing()
        .when(logExecutor)
        .scheduleAtFixedRate(
            Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());

    // Act
    tbSqlBlockingQueue.init(
        logExecutor, mock(Function.class), mock(Comparator.class), mock(Function.class), 1);

    // Assert
    verify(totalCounter, atLeast(1)).add(1);
    verify(totalCounter).increment();
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
  public void testInit7() {
    // Arrange
    StatsCounter totalCounter = mock(StatsCounter.class);
    doNothing().when(totalCounter).add(anyInt());
    doNothing().when(totalCounter).increment();
    totalCounter.increment();
    AtomicInteger aiCounter = new AtomicInteger();

    StatsCounter successfulCounter =
        new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");
    successfulCounter.add(2);
    AtomicInteger aiCounter2 = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter failedCounter = new StatsCounter(aiCounter2, new NoopCounter(id), "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(0L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");

    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing()
        .when(logExecutor)
        .scheduleAtFixedRate(
            Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());

    // Act
    tbSqlBlockingQueue.init(
        logExecutor, mock(Function.class), mock(Comparator.class), mock(Function.class), 1);

    // Assert
    verify(totalCounter, atLeast(1)).add(1);
    verify(totalCounter).increment();
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
  public void testInit8() {
    // Arrange
    StatsCounter totalCounter = mock(StatsCounter.class);
    doNothing().when(totalCounter).add(anyInt());
    doNothing().when(totalCounter).increment();
    totalCounter.increment();
    AtomicInteger aiCounter = new AtomicInteger();

    StatsCounter successfulCounter =
        new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");
    successfulCounter.add(2);
    AtomicInteger aiCounter2 = new AtomicInteger();
    StatsCounter failedCounter = new StatsCounter(aiCounter2, new CumulativeCounter(null), "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(3)
            .batchSortEnabled(true)
            .logName("Log Name")
            .maxDelay(0L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("org.thingsboard.server.dao.sql.TbSqlBlockingQueue");
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");

    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing()
        .when(logExecutor)
        .scheduleAtFixedRate(
            Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());

    // Act
    tbSqlBlockingQueue.init(
        logExecutor, mock(Function.class), mock(Comparator.class), mock(Function.class), 1);

    // Assert
    verify(totalCounter, atLeast(1)).add(1);
    verify(totalCounter).increment();
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
  public void testInit9() {
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
            .maxDelay(0L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    StatsCounter totalCounter = mock(StatsCounter.class);
    doNothing().when(totalCounter).add(anyInt());
    doNothing().when(totalCounter).increment();
    totalCounter.increment();
    AtomicInteger aiCounter = new AtomicInteger();

    StatsCounter successfulCounter =
        new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");
    successfulCounter.add(2);
    AtomicInteger aiCounter2 = new AtomicInteger();
    StatsCounter failedCounter = new StatsCounter(aiCounter2, new CumulativeCounter(null), "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);
    tbSqlBlockingQueue.add(2);
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");

    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing()
        .when(logExecutor)
        .scheduleAtFixedRate(
            Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());

    // Act
    tbSqlBlockingQueue.init(
        logExecutor, mock(Function.class), mock(Comparator.class), mock(Function.class), 1);

    // Assert
    verify(totalCounter, atLeast(1)).add(1);
    verify(totalCounter).increment();
    verify(logExecutor)
        .scheduleAtFixedRate(isA(Runnable.class), eq(42L), eq(42L), eq(TimeUnit.MILLISECONDS));
    verify(tbSqlBlockingQueueParamsBuilder).batchSize(3);
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
  public void testInit10() {
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
            .maxDelay(0L)
            .statsNamePrefix("Stats Name Prefix")
            .statsPrintIntervalMs(42L)
            .withResponse(true)
            .build();

    StatsCounter totalCounter = mock(StatsCounter.class);
    doNothing().when(totalCounter).add(anyInt());
    doNothing().when(totalCounter).increment();
    totalCounter.increment();
    AtomicInteger aiCounter = new AtomicInteger();

    StatsCounter successfulCounter =
        new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");
    successfulCounter.add(2);
    AtomicInteger aiCounter2 = new AtomicInteger();
    StatsCounter failedCounter = new StatsCounter(aiCounter2, new CumulativeCounter(null), "Name");

    DefaultMessagesStats stats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);

    TbSqlBlockingQueue<Object, Object> tbSqlBlockingQueue = new TbSqlBlockingQueue<>(params, stats);
    tbSqlBlockingQueue.add("org.thingsboard.server.dao.sql.TbSqlQueueElement");
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");
    tbSqlBlockingQueue.add("Element");

    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing()
        .when(logExecutor)
        .scheduleAtFixedRate(
            Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());

    // Act
    tbSqlBlockingQueue.init(
        logExecutor, mock(Function.class), mock(Comparator.class), mock(Function.class), 1);

    // Assert
    verify(totalCounter, atLeast(1)).add(1);
    verify(totalCounter).increment();
    verify(logExecutor)
        .scheduleAtFixedRate(isA(Runnable.class), eq(42L), eq(42L), eq(TimeUnit.MILLISECONDS));
    verify(tbSqlBlockingQueueParamsBuilder).batchSize(3);
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <ul>
   *   <li>Given {@link MessagesStats} {@link MessagesStats#getSuccessful()} return zero.
   *   <li>Then calls {@link TbSqlBlockingQueueParams#getBatchSize()}.
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
  public void testInit_givenMessagesStatsGetSuccessfulReturnZero_thenCallsGetBatchSize() {
    // Arrange
    when(tbSqlBlockingQueueParams.getBatchSize()).thenReturn(1);
    when(tbSqlBlockingQueueParams.getMaxDelay()).thenReturn(1L);
    when(tbSqlBlockingQueueParams.getStatsPrintIntervalMs()).thenReturn(42L);
    when(tbSqlBlockingQueueParams.getLogName()).thenReturn("Log Name");
    doNothing().when(messagesStats).reset();
    when(messagesStats.getFailed()).thenReturn(1);
    when(messagesStats.getSuccessful()).thenReturn(0);
    when(messagesStats.getTotal()).thenReturn(1);

    // Act
    tbSqlBlockingQueue.init(
        scheduledLogExecutorComponent,
        mock(Function.class),
        mock(Comparator.class),
        mock(Function.class),
        1);

    // Assert
    verify(tbSqlBlockingQueueParams).getBatchSize();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getLogName();
    verify(tbSqlBlockingQueueParams).getMaxDelay();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getStatsPrintIntervalMs();
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <ul>
   *   <li>Given {@link TbSqlBlockingQueueParams} {@link TbSqlBlockingQueueParams#getBatchSize()}
   *       return five.
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
  public void testInit_givenTbSqlBlockingQueueParamsGetBatchSizeReturnFive() {
    // Arrange
    when(tbSqlBlockingQueueParams.getBatchSize()).thenReturn(5);
    when(tbSqlBlockingQueueParams.getMaxDelay()).thenReturn(1L);
    when(tbSqlBlockingQueueParams.getStatsPrintIntervalMs()).thenReturn(42L);
    when(tbSqlBlockingQueueParams.getLogName()).thenReturn("Log Name");

    // Act
    tbSqlBlockingQueue.init(
        scheduledLogExecutorComponent,
        mock(Function.class),
        mock(Comparator.class),
        mock(Function.class),
        1);

    // Assert
    verify(tbSqlBlockingQueueParams).getBatchSize();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getLogName();
    verify(tbSqlBlockingQueueParams).getMaxDelay();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getStatsPrintIntervalMs();
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <ul>
   *   <li>Given {@link TbSqlBlockingQueueParams} {@link TbSqlBlockingQueueParams#getBatchSize()}
   *       return minus one.
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
  public void testInit_givenTbSqlBlockingQueueParamsGetBatchSizeReturnMinusOne() {
    // Arrange
    when(tbSqlBlockingQueueParams.getBatchSize()).thenReturn(-1);
    when(tbSqlBlockingQueueParams.getMaxDelay()).thenReturn(1L);
    when(tbSqlBlockingQueueParams.getStatsPrintIntervalMs()).thenReturn(42L);
    when(tbSqlBlockingQueueParams.getLogName()).thenReturn("Log Name");

    // Act
    tbSqlBlockingQueue.init(
        scheduledLogExecutorComponent,
        mock(Function.class),
        mock(Comparator.class),
        mock(Function.class),
        1);

    // Assert
    verify(tbSqlBlockingQueueParams).getBatchSize();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getLogName();
    verify(tbSqlBlockingQueueParams).getMaxDelay();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getStatsPrintIntervalMs();
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <ul>
   *   <li>Given {@link TbSqlBlockingQueueParams} {@link TbSqlBlockingQueueParams#getBatchSize()}
   *       return one.
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
  public void testInit_givenTbSqlBlockingQueueParamsGetBatchSizeReturnOne() {
    // Arrange
    when(tbSqlBlockingQueueParams.getBatchSize()).thenReturn(1);
    when(tbSqlBlockingQueueParams.getMaxDelay()).thenReturn(1L);
    when(tbSqlBlockingQueueParams.getStatsPrintIntervalMs()).thenReturn(42L);
    when(tbSqlBlockingQueueParams.getLogName()).thenReturn("Log Name");

    // Act
    tbSqlBlockingQueue.init(
        scheduledLogExecutorComponent,
        mock(Function.class),
        mock(Comparator.class),
        mock(Function.class),
        1);

    // Assert
    verify(tbSqlBlockingQueueParams).getBatchSize();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getLogName();
    verify(tbSqlBlockingQueueParams).getMaxDelay();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getStatsPrintIntervalMs();
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <ul>
   *   <li>Given {@link TbSqlBlockingQueueParams} {@link TbSqlBlockingQueueParams#getBatchSize()}
   *       return one.
   *   <li>When five.
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
  public void testInit_givenTbSqlBlockingQueueParamsGetBatchSizeReturnOne_whenFive() {
    // Arrange
    when(tbSqlBlockingQueueParams.getBatchSize()).thenReturn(1);
    when(tbSqlBlockingQueueParams.getMaxDelay()).thenReturn(1L);
    when(tbSqlBlockingQueueParams.getStatsPrintIntervalMs()).thenReturn(42L);
    when(tbSqlBlockingQueueParams.getLogName()).thenReturn("Log Name");
    doNothing().when(messagesStats).reset();
    when(messagesStats.getFailed()).thenReturn(1);
    when(messagesStats.getSuccessful()).thenReturn(1);
    when(messagesStats.getTotal()).thenReturn(1);

    // Act
    tbSqlBlockingQueue.init(
        scheduledLogExecutorComponent,
        mock(Function.class),
        mock(Comparator.class),
        mock(Function.class),
        5);

    // Assert
    verify(tbSqlBlockingQueueParams).getBatchSize();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getLogName();
    verify(tbSqlBlockingQueueParams).getMaxDelay();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getStatsPrintIntervalMs();
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <ul>
   *   <li>Given {@link TbSqlBlockingQueueParams} {@link TbSqlBlockingQueueParams#getBatchSize()}
   *       return three.
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
  public void testInit_givenTbSqlBlockingQueueParamsGetBatchSizeReturnThree() {
    // Arrange
    when(tbSqlBlockingQueueParams.getBatchSize()).thenReturn(3);
    when(tbSqlBlockingQueueParams.getMaxDelay()).thenReturn(1L);
    when(tbSqlBlockingQueueParams.getStatsPrintIntervalMs()).thenReturn(42L);
    when(tbSqlBlockingQueueParams.getLogName()).thenReturn("Log Name");

    // Act
    tbSqlBlockingQueue.init(
        scheduledLogExecutorComponent,
        mock(Function.class),
        mock(Comparator.class),
        mock(Function.class),
        1);

    // Assert
    verify(tbSqlBlockingQueueParams).getBatchSize();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getLogName();
    verify(tbSqlBlockingQueueParams).getMaxDelay();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getStatsPrintIntervalMs();
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <ul>
   *   <li>Given {@link TbSqlBlockingQueueParams} {@link TbSqlBlockingQueueParams#getBatchSize()}
   *       return zero.
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
  public void testInit_givenTbSqlBlockingQueueParamsGetBatchSizeReturnZero() {
    // Arrange
    when(tbSqlBlockingQueueParams.getBatchSize()).thenReturn(0);
    when(tbSqlBlockingQueueParams.getMaxDelay()).thenReturn(1L);
    when(tbSqlBlockingQueueParams.getStatsPrintIntervalMs()).thenReturn(42L);
    when(tbSqlBlockingQueueParams.getLogName()).thenReturn("Log Name");

    // Act
    tbSqlBlockingQueue.init(
        scheduledLogExecutorComponent,
        mock(Function.class),
        mock(Comparator.class),
        mock(Function.class),
        1);

    // Assert
    verify(tbSqlBlockingQueueParams).getBatchSize();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getLogName();
    verify(tbSqlBlockingQueueParams).getMaxDelay();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getStatsPrintIntervalMs();
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <ul>
   *   <li>Given {@link TbSqlBlockingQueueParams} {@link TbSqlBlockingQueueParams#getMaxDelay()}
   *       return five.
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
  public void testInit_givenTbSqlBlockingQueueParamsGetMaxDelayReturnFive() {
    // Arrange
    when(tbSqlBlockingQueueParams.getBatchSize()).thenReturn(3);
    when(tbSqlBlockingQueueParams.getMaxDelay()).thenReturn(5L);
    when(tbSqlBlockingQueueParams.getStatsPrintIntervalMs()).thenReturn(42L);
    when(tbSqlBlockingQueueParams.getLogName()).thenReturn("Log Name");

    // Act
    tbSqlBlockingQueue.init(
        scheduledLogExecutorComponent,
        mock(Function.class),
        mock(Comparator.class),
        mock(Function.class),
        1);

    // Assert
    verify(tbSqlBlockingQueueParams).getBatchSize();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getLogName();
    verify(tbSqlBlockingQueueParams).getMaxDelay();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getStatsPrintIntervalMs();
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <ul>
   *   <li>Given {@link TbSqlBlockingQueueParams} {@link
   *       TbSqlBlockingQueueParams#getStatsPrintIntervalMs()} return five.
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
  public void testInit_givenTbSqlBlockingQueueParamsGetStatsPrintIntervalMsReturnFive() {
    // Arrange
    when(tbSqlBlockingQueueParams.getBatchSize()).thenReturn(3);
    when(tbSqlBlockingQueueParams.getMaxDelay()).thenReturn(1L);
    when(tbSqlBlockingQueueParams.getStatsPrintIntervalMs()).thenReturn(5L);
    when(tbSqlBlockingQueueParams.getLogName()).thenReturn("Log Name");
    doNothing().when(messagesStats).reset();
    when(messagesStats.getFailed()).thenReturn(1);
    when(messagesStats.getSuccessful()).thenReturn(1);
    when(messagesStats.getTotal()).thenReturn(1);

    // Act
    tbSqlBlockingQueue.init(
        scheduledLogExecutorComponent,
        mock(Function.class),
        mock(Comparator.class),
        mock(Function.class),
        1);

    // Assert
    verify(tbSqlBlockingQueueParams).getBatchSize();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getLogName();
    verify(tbSqlBlockingQueueParams).getMaxDelay();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getStatsPrintIntervalMs();
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <ul>
   *   <li>Given {@link TbSqlBlockingQueueParams} {@link
   *       TbSqlBlockingQueueParams#getStatsPrintIntervalMs()} return four.
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
  public void testInit_givenTbSqlBlockingQueueParamsGetStatsPrintIntervalMsReturnFour() {
    // Arrange
    when(tbSqlBlockingQueueParams.getBatchSize()).thenReturn(3);
    when(tbSqlBlockingQueueParams.getMaxDelay()).thenReturn(1L);
    when(tbSqlBlockingQueueParams.getStatsPrintIntervalMs()).thenReturn(4L);
    when(tbSqlBlockingQueueParams.getLogName()).thenReturn("Log Name");

    // Act
    tbSqlBlockingQueue.init(
        scheduledLogExecutorComponent,
        mock(Function.class),
        mock(Comparator.class),
        mock(Function.class),
        1);

    // Assert
    verify(tbSqlBlockingQueueParams).getBatchSize();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getLogName();
    verify(tbSqlBlockingQueueParams).getMaxDelay();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getStatsPrintIntervalMs();
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <ul>
   *   <li>Given {@link TbSqlBlockingQueueParams} {@link
   *       TbSqlBlockingQueueParams#getStatsPrintIntervalMs()} return six.
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
  public void testInit_givenTbSqlBlockingQueueParamsGetStatsPrintIntervalMsReturnSix() {
    // Arrange
    when(tbSqlBlockingQueueParams.getBatchSize()).thenReturn(3);
    when(tbSqlBlockingQueueParams.getMaxDelay()).thenReturn(1L);
    when(tbSqlBlockingQueueParams.getStatsPrintIntervalMs()).thenReturn(6L);
    when(tbSqlBlockingQueueParams.getLogName()).thenReturn("Log Name");

    // Act
    tbSqlBlockingQueue.init(
        scheduledLogExecutorComponent,
        mock(Function.class),
        mock(Comparator.class),
        mock(Function.class),
        1);

    // Assert
    verify(tbSqlBlockingQueueParams).getBatchSize();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getLogName();
    verify(tbSqlBlockingQueueParams).getMaxDelay();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getStatsPrintIntervalMs();
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <ul>
   *   <li>Given {@link TbSqlBlockingQueueParams} {@link
   *       TbSqlBlockingQueueParams#getStatsPrintIntervalMs()} return three.
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
  public void testInit_givenTbSqlBlockingQueueParamsGetStatsPrintIntervalMsReturnThree() {
    // Arrange
    when(tbSqlBlockingQueueParams.getBatchSize()).thenReturn(3);
    when(tbSqlBlockingQueueParams.getMaxDelay()).thenReturn(1L);
    when(tbSqlBlockingQueueParams.getStatsPrintIntervalMs()).thenReturn(3L);
    when(tbSqlBlockingQueueParams.getLogName()).thenReturn("Log Name");
    doNothing().when(messagesStats).reset();
    when(messagesStats.getFailed()).thenReturn(1);
    when(messagesStats.getSuccessful()).thenReturn(1);
    when(messagesStats.getTotal()).thenReturn(1);

    // Act
    tbSqlBlockingQueue.init(
        scheduledLogExecutorComponent,
        mock(Function.class),
        mock(Comparator.class),
        mock(Function.class),
        1);

    // Assert
    verify(tbSqlBlockingQueueParams).getBatchSize();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getLogName();
    verify(tbSqlBlockingQueueParams).getMaxDelay();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getStatsPrintIntervalMs();
  }

  /**
   * Test {@link TbSqlBlockingQueue#init(ScheduledLogExecutorComponent, Function, Comparator,
   * Function, int)}.
   *
   * <ul>
   *   <li>Given {@link TbSqlBlockingQueueParams} {@link
   *       TbSqlBlockingQueueParams#getStatsPrintIntervalMs()} return two.
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
  public void testInit_givenTbSqlBlockingQueueParamsGetStatsPrintIntervalMsReturnTwo() {
    // Arrange
    when(tbSqlBlockingQueueParams.getBatchSize()).thenReturn(3);
    when(tbSqlBlockingQueueParams.getMaxDelay()).thenReturn(1L);
    when(tbSqlBlockingQueueParams.getStatsPrintIntervalMs()).thenReturn(2L);
    when(tbSqlBlockingQueueParams.getLogName()).thenReturn("Log Name");

    // Act
    tbSqlBlockingQueue.init(
        scheduledLogExecutorComponent,
        mock(Function.class),
        mock(Comparator.class),
        mock(Function.class),
        1);

    // Assert
    verify(tbSqlBlockingQueueParams).getBatchSize();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getLogName();
    verify(tbSqlBlockingQueueParams).getMaxDelay();
    verify(tbSqlBlockingQueueParams, atLeast(1)).getStatsPrintIntervalMs();
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
    stats.incrementFailed();
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(0)
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
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link TbSqlBlockingQueue#add(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture TbSqlBlockingQueue.add(Object)"
  })
  public void testAdd_givenAtomicIntegerAddAndGetOne_thenReturnSettableFuture() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger();
    aiCounter.addAndGet(1);
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
    stats.incrementFailed();
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(0)
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
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link TbSqlBlockingQueue#add(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture TbSqlBlockingQueue.add(Object)"
  })
  public void testAdd_thenReturnSettableFuture() {
    // Arrange
    TbSqlBlockingQueueParams params =
        TbSqlBlockingQueueParams.builder()
            .batchSize(0)
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
}
