package org.thingsboard.server.dao.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Meter.Id;
import io.micrometer.core.instrument.Meter.Type;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.common.stats.DefaultMessagesStats;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.common.stats.StatsFactory;
import org.thingsboard.server.dao.sql.TbSqlBlockingQueueParams.TbSqlBlockingQueueParamsBuilder;

public class TbSqlBlockingQueueWrapperDiffblueTest {
  /**
   * Test {@link TbSqlBlockingQueueWrapper#init(ScheduledLogExecutorComponent, Consumer, Comparator)} with {@code logExecutor}, {@code saveFunction}, {@code batchUpdateComparator}.
   * <p>
   * Method under test: {@link TbSqlBlockingQueueWrapper#init(ScheduledLogExecutorComponent, Consumer, Comparator)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TbSqlBlockingQueueWrapper.init(ScheduledLogExecutorComponent, Consumer, Comparator)"})
  public void testInitWithLogExecutorSaveFunctionBatchUpdateComparator() {
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
    Function<Object, Integer> hashCodeFunction = mock(Function.class);
    TbSqlBlockingQueueWrapper<Object, Object> tbSqlBlockingQueueWrapper = new TbSqlBlockingQueueWrapper<>(params,
        hashCodeFunction, 0, new DefaultStatsFactory());

    // Act
    tbSqlBlockingQueueWrapper.init(new ScheduledLogExecutorComponent(), mock(Consumer.class), mock(Comparator.class));

    // Assert that nothing has changed
    assertTrue(tbSqlBlockingQueueWrapper.getQueues().isEmpty());
  }

  /**
   * Test {@link TbSqlBlockingQueueWrapper#init(ScheduledLogExecutorComponent, Consumer, Comparator)} with {@code logExecutor}, {@code saveFunction}, {@code batchUpdateComparator}.
   * <p>
   * Method under test: {@link TbSqlBlockingQueueWrapper#init(ScheduledLogExecutorComponent, Consumer, Comparator)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TbSqlBlockingQueueWrapper.init(ScheduledLogExecutorComponent, Consumer, Comparator)"})
  public void testInitWithLogExecutorSaveFunctionBatchUpdateComparator2() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter totalCounter = new StatsCounter(aiCounter,
        new CumulativeCounter(
            new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
        "Name");

    AtomicInteger aiCounter2 = new AtomicInteger(1);
    StatsCounter successfulCounter = new StatsCounter(aiCounter2,
        new CumulativeCounter(
            new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
        "Name");

    AtomicInteger aiCounter3 = new AtomicInteger(1);
    when(statsFactory.createMessagesStats(Mockito.<String>any()))
        .thenReturn(new DefaultMessagesStats(totalCounter, successfulCounter,
            new StatsCounter(aiCounter3, new CumulativeCounter(
                new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
                "Name")));
    TbSqlBlockingQueueParams params = TbSqlBlockingQueueParams.builder()
        .batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();
    TbSqlBlockingQueueWrapper<Object, Object> tbSqlBlockingQueueWrapper = new TbSqlBlockingQueueWrapper<>(params,
        mock(Function.class), 3, statsFactory);
    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing().when(logExecutor)
        .scheduleAtFixedRate(Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());

    // Act
    tbSqlBlockingQueueWrapper.init(logExecutor, mock(Consumer.class), mock(Comparator.class));

    // Assert
    verify(statsFactory, atLeast(1)).createMessagesStats(Mockito.<String>any());
    verify(logExecutor, atLeast(1)).scheduleAtFixedRate(Mockito.<Runnable>any(), eq(42L), eq(42L),
        eq(TimeUnit.MILLISECONDS));
    assertEquals(3, tbSqlBlockingQueueWrapper.getQueues().size());
  }

  /**
   * Test {@link TbSqlBlockingQueueWrapper#init(ScheduledLogExecutorComponent, Function, Comparator, Function)} with {@code logExecutor}, {@code saveFunction}, {@code batchUpdateComparator}, {@code filter}.
   * <p>
   * Method under test: {@link TbSqlBlockingQueueWrapper#init(ScheduledLogExecutorComponent, Function, Comparator, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void TbSqlBlockingQueueWrapper.init(ScheduledLogExecutorComponent, Function, Comparator, Function)"})
  public void testInitWithLogExecutorSaveFunctionBatchUpdateComparatorFilter() {
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
    Function<Object, Integer> hashCodeFunction = mock(Function.class);
    TbSqlBlockingQueueWrapper<Object, Object> tbSqlBlockingQueueWrapper = new TbSqlBlockingQueueWrapper<>(params,
        hashCodeFunction, 0, new DefaultStatsFactory());

    // Act
    tbSqlBlockingQueueWrapper.init(new ScheduledLogExecutorComponent(), mock(Function.class), mock(Comparator.class),
        mock(Function.class));

    // Assert that nothing has changed
    assertTrue(tbSqlBlockingQueueWrapper.getQueues().isEmpty());
  }

  /**
   * Test {@link TbSqlBlockingQueueWrapper#init(ScheduledLogExecutorComponent, Function, Comparator, Function)} with {@code logExecutor}, {@code saveFunction}, {@code batchUpdateComparator}, {@code filter}.
   * <p>
   * Method under test: {@link TbSqlBlockingQueueWrapper#init(ScheduledLogExecutorComponent, Function, Comparator, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void TbSqlBlockingQueueWrapper.init(ScheduledLogExecutorComponent, Function, Comparator, Function)"})
  public void testInitWithLogExecutorSaveFunctionBatchUpdateComparatorFilter2() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter totalCounter = new StatsCounter(aiCounter,
        new CumulativeCounter(
            new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
        "Name");

    AtomicInteger aiCounter2 = new AtomicInteger(1);
    StatsCounter successfulCounter = new StatsCounter(aiCounter2,
        new CumulativeCounter(
            new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
        "Name");

    AtomicInteger aiCounter3 = new AtomicInteger(1);
    when(statsFactory.createMessagesStats(Mockito.<String>any()))
        .thenReturn(new DefaultMessagesStats(totalCounter, successfulCounter,
            new StatsCounter(aiCounter3, new CumulativeCounter(
                new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
                "Name")));
    TbSqlBlockingQueueParams params = TbSqlBlockingQueueParams.builder()
        .batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();
    TbSqlBlockingQueueWrapper<Object, Object> tbSqlBlockingQueueWrapper = new TbSqlBlockingQueueWrapper<>(params,
        mock(Function.class), 3, statsFactory);
    ScheduledLogExecutorComponent logExecutor = mock(ScheduledLogExecutorComponent.class);
    doNothing().when(logExecutor)
        .scheduleAtFixedRate(Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any());

    // Act
    tbSqlBlockingQueueWrapper.init(logExecutor, mock(Function.class), mock(Comparator.class), mock(Function.class));

    // Assert
    verify(statsFactory, atLeast(1)).createMessagesStats(Mockito.<String>any());
    verify(logExecutor, atLeast(1)).scheduleAtFixedRate(Mockito.<Runnable>any(), eq(42L), eq(42L),
        eq(TimeUnit.MILLISECONDS));
    assertEquals(3, tbSqlBlockingQueueWrapper.getQueues().size());
  }

  /**
   * Test {@link TbSqlBlockingQueueWrapper#equals(Object)}, and {@link TbSqlBlockingQueueWrapper#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSqlBlockingQueueWrapper#equals(Object)}
   *   <li>{@link TbSqlBlockingQueueWrapper#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbSqlBlockingQueueWrapper.equals(Object)", "int TbSqlBlockingQueueWrapper.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
    Function<Object, Integer> hashCodeFunction = mock(Function.class);
    TbSqlBlockingQueueWrapper<Object, Object> tbSqlBlockingQueueWrapper = new TbSqlBlockingQueueWrapper<>(params,
        hashCodeFunction, 3, new DefaultStatsFactory());

    // Act and Assert
    assertEquals(tbSqlBlockingQueueWrapper, tbSqlBlockingQueueWrapper);
    int expectedHashCodeResult = tbSqlBlockingQueueWrapper.hashCode();
    assertEquals(expectedHashCodeResult, tbSqlBlockingQueueWrapper.hashCode());
  }

  /**
   * Test {@link TbSqlBlockingQueueWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSqlBlockingQueueWrapper#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbSqlBlockingQueueWrapper.equals(Object)", "int TbSqlBlockingQueueWrapper.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
    Function<Object, Integer> hashCodeFunction = mock(Function.class);
    TbSqlBlockingQueueWrapper<Object, Object> tbSqlBlockingQueueWrapper = new TbSqlBlockingQueueWrapper<>(params,
        hashCodeFunction, 3, new DefaultStatsFactory());
    TbSqlBlockingQueueParams params2 = TbSqlBlockingQueueParams.builder()
        .batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();
    Function<Object, Integer> hashCodeFunction2 = mock(Function.class);

    // Act and Assert
    assertNotEquals(tbSqlBlockingQueueWrapper,
        new TbSqlBlockingQueueWrapper<>(params2, hashCodeFunction2, 3, new DefaultStatsFactory()));
  }

  /**
   * Test {@link TbSqlBlockingQueueWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSqlBlockingQueueWrapper#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbSqlBlockingQueueWrapper.equals(Object)", "int TbSqlBlockingQueueWrapper.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbSqlBlockingQueueParamsBuilder tbSqlBlockingQueueParamsBuilder = mock(TbSqlBlockingQueueParamsBuilder.class);
    when(tbSqlBlockingQueueParamsBuilder.batchSize(anyInt())).thenReturn(TbSqlBlockingQueueParams.builder());
    TbSqlBlockingQueueParams params = tbSqlBlockingQueueParamsBuilder.batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();
    Function<Object, Integer> hashCodeFunction = mock(Function.class);
    TbSqlBlockingQueueWrapper<Object, Object> tbSqlBlockingQueueWrapper = new TbSqlBlockingQueueWrapper<>(params,
        hashCodeFunction, 3, new DefaultStatsFactory());
    TbSqlBlockingQueueParams params2 = TbSqlBlockingQueueParams.builder()
        .batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();
    Function<Object, Integer> hashCodeFunction2 = mock(Function.class);

    // Act and Assert
    assertNotEquals(tbSqlBlockingQueueWrapper,
        new TbSqlBlockingQueueWrapper<>(params2, hashCodeFunction2, 3, new DefaultStatsFactory()));
  }

  /**
   * Test {@link TbSqlBlockingQueueWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSqlBlockingQueueWrapper#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbSqlBlockingQueueWrapper.equals(Object)", "int TbSqlBlockingQueueWrapper.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbSqlBlockingQueueParamsBuilder tbSqlBlockingQueueParamsBuilder = mock(TbSqlBlockingQueueParamsBuilder.class);
    when(tbSqlBlockingQueueParamsBuilder.batchSize(anyInt())).thenReturn(TbSqlBlockingQueueParams.builder());
    TbSqlBlockingQueueParams params = tbSqlBlockingQueueParamsBuilder.batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();
    Function<Object, Integer> hashCodeFunction = mock(Function.class);
    TbSqlBlockingQueueWrapper<Object, Object> tbSqlBlockingQueueWrapper = new TbSqlBlockingQueueWrapper<>(params,
        hashCodeFunction, 1, new DefaultStatsFactory());
    TbSqlBlockingQueueParams params2 = TbSqlBlockingQueueParams.builder()
        .batchSize(3)
        .batchSortEnabled(true)
        .logName("Log Name")
        .maxDelay(1L)
        .statsNamePrefix("Stats Name Prefix")
        .statsPrintIntervalMs(42L)
        .withResponse(true)
        .build();
    Function<Object, Integer> hashCodeFunction2 = mock(Function.class);

    // Act and Assert
    assertNotEquals(tbSqlBlockingQueueWrapper,
        new TbSqlBlockingQueueWrapper<>(params2, hashCodeFunction2, 3, new DefaultStatsFactory()));
  }

  /**
   * Test {@link TbSqlBlockingQueueWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSqlBlockingQueueWrapper#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbSqlBlockingQueueWrapper.equals(Object)", "int TbSqlBlockingQueueWrapper.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
    Function<Object, Integer> hashCodeFunction = mock(Function.class);
    TbSqlBlockingQueueWrapper<Object, Object> tbSqlBlockingQueueWrapper = new TbSqlBlockingQueueWrapper<>(params,
        hashCodeFunction, 3, new DefaultStatsFactory());

    // Act and Assert
    assertNotEquals(tbSqlBlockingQueueWrapper, null);
  }

  /**
   * Test {@link TbSqlBlockingQueueWrapper#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSqlBlockingQueueWrapper#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TbSqlBlockingQueueWrapper.equals(Object)", "int TbSqlBlockingQueueWrapper.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
    Function<Object, Integer> hashCodeFunction = mock(Function.class);
    TbSqlBlockingQueueWrapper<Object, Object> tbSqlBlockingQueueWrapper = new TbSqlBlockingQueueWrapper<>(params,
        hashCodeFunction, 3, new DefaultStatsFactory());

    // Act and Assert
    assertNotEquals(tbSqlBlockingQueueWrapper, "Different type to TbSqlBlockingQueueWrapper");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSqlBlockingQueueWrapper#TbSqlBlockingQueueWrapper(TbSqlBlockingQueueParams, Function, int, StatsFactory)}
   *   <li>{@link TbSqlBlockingQueueWrapper#toString()}
   *   <li>{@link TbSqlBlockingQueueWrapper#getHashCodeFunction()}
   *   <li>{@link TbSqlBlockingQueueWrapper#getMaxThreads()}
   *   <li>{@link TbSqlBlockingQueueWrapper#getParams()}
   *   <li>{@link TbSqlBlockingQueueWrapper#getQueues()}
   *   <li>{@link TbSqlBlockingQueueWrapper#getStatsFactory()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TbSqlBlockingQueueWrapper.<init>(TbSqlBlockingQueueParams, Function, int, StatsFactory)",
      "Function TbSqlBlockingQueueWrapper.getHashCodeFunction()", "int TbSqlBlockingQueueWrapper.getMaxThreads()",
      "TbSqlBlockingQueueParams TbSqlBlockingQueueWrapper.getParams()",
      "CopyOnWriteArrayList TbSqlBlockingQueueWrapper.getQueues()",
      "StatsFactory TbSqlBlockingQueueWrapper.getStatsFactory()", "String TbSqlBlockingQueueWrapper.toString()"})
  public void testGettersAndSetters() {
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
    Function<Object, Integer> hashCodeFunction = mock(Function.class);
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();

    // Act
    TbSqlBlockingQueueWrapper<Object, Object> actualTbSqlBlockingQueueWrapper = new TbSqlBlockingQueueWrapper<>(params,
        hashCodeFunction, 3, statsFactory);
    actualTbSqlBlockingQueueWrapper.toString();
    Function<Object, Integer> actualHashCodeFunction = actualTbSqlBlockingQueueWrapper.getHashCodeFunction();
    int actualMaxThreads = actualTbSqlBlockingQueueWrapper.getMaxThreads();
    TbSqlBlockingQueueParams actualParams = actualTbSqlBlockingQueueWrapper.getParams();
    CopyOnWriteArrayList<TbSqlBlockingQueue<Object, Object>> actualQueues = actualTbSqlBlockingQueueWrapper.getQueues();
    StatsFactory actualStatsFactory = actualTbSqlBlockingQueueWrapper.getStatsFactory();

    // Assert
    assertTrue(actualStatsFactory instanceof DefaultStatsFactory);
    assertEquals(3, actualMaxThreads);
    assertTrue(actualQueues.isEmpty());
    assertSame(statsFactory, actualStatsFactory);
    assertSame(params, actualParams);
    assertSame(hashCodeFunction, actualHashCodeFunction);
  }
}
