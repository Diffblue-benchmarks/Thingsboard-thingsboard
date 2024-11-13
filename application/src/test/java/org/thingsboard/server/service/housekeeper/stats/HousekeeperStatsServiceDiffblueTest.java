package org.thingsboard.server.service.housekeeper.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Meter.Id;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import io.micrometer.core.instrument.noop.NoopTimer;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTaskType;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.common.stats.StatsFactory;
import org.thingsboard.server.common.stats.StatsTimer;
import org.thingsboard.server.common.stats.StatsType;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.service.housekeeper.stats.HousekeeperStatsService.HousekeeperStats;

class HousekeeperStatsServiceDiffblueTest {
  /**
   * Test HousekeeperStats
   * {@link HousekeeperStats#HousekeeperStats(HousekeeperTaskType, StatsFactory)}.
   * <ul>
   *   <li>Then return Counters size is four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HousekeeperStatsService.HousekeeperStats#HousekeeperStats(HousekeeperTaskType, StatsFactory)}
   */
  @Test
  @DisplayName("Test HousekeeperStats new HousekeeperStats(HousekeeperTaskType, StatsFactory); then return Counters size is four")
  void testHousekeeperStatsNewHousekeeperStats_thenReturnCountersSizeIsFour() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatsFactory statsFactory = mock(StatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(),
        "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    StatsTimer statsTimer = new StatsTimer("Name", new NoopTimer(new Meter.Id("Name", Tags.empty(), "Base Unit",
        "The characteristics of someone or something", Meter.Type.COUNTER)));

    when(statsFactory.createTimer(Mockito.<StatsType>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsTimer);

    // Act
    HousekeeperStatsService.HousekeeperStats actualHousekeeperStats = new HousekeeperStatsService.HousekeeperStats(
        HousekeeperTaskType.DELETE_ATTRIBUTES, statsFactory);

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("housekeeper"), Mockito.<String>any(), isA(String[].class));
    verify(statsFactory).createTimer(eq(StatsType.HOUSEKEEPER), eq("processingTime"), isA(String[].class));
    List<StatsCounter> counters = actualHousekeeperStats.getCounters();
    assertEquals(4, counters.size());
    assertEquals(HousekeeperTaskType.DELETE_ATTRIBUTES, actualHousekeeperStats.getTaskType());
    assertSame(statsCounter, counters.get(0));
    assertSame(statsCounter, counters.get(1));
    assertSame(statsCounter, counters.get(2));
    assertSame(statsCounter, counters.get(3));
    assertSame(statsCounter, actualHousekeeperStats.getFailedProcessingCounter());
    assertSame(statsCounter, actualHousekeeperStats.getFailedReprocessingCounter());
    assertSame(statsCounter, actualHousekeeperStats.getProcessedCounter());
    assertSame(statsCounter, actualHousekeeperStats.getReprocessedCounter());
    assertSame(statsTimer, actualHousekeeperStats.getProcessingTimer());
  }

  /**
   * Test HousekeeperStats {@link HousekeeperStats#reset()}.
   * <p>
   * Method under test: {@link HousekeeperStatsService.HousekeeperStats#reset()}
   */
  @Test
  @DisplayName("Test HousekeeperStats reset()")
  void testHousekeeperStatsReset() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    when(statsFactory.createTimer(Mockito.<StatsType>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsTimer("Name", new NoopTimer(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    HousekeeperStatsService.HousekeeperStats housekeeperStats = new HousekeeperStatsService.HousekeeperStats(
        HousekeeperTaskType.DELETE_ATTRIBUTES, statsFactory);

    // Act
    housekeeperStats.reset();

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("housekeeper"), Mockito.<String>any(), isA(String[].class));
    verify(statsFactory).createTimer(eq(StatsType.HOUSEKEEPER), eq("processingTime"), isA(String[].class));
    assertEquals(0, housekeeperStats.getFailedProcessingCounter().get());
  }

  /**
   * Test HousekeeperStats {@link HousekeeperStats#reset()}.
   * <ul>
   *   <li>Given {@link StatsTimer} {@link StatsTimer#reset()} does nothing.</li>
   *   <li>Then calls {@link StatsTimer#reset()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperStatsService.HousekeeperStats#reset()}
   */
  @Test
  @DisplayName("Test HousekeeperStats reset(); given StatsTimer reset() does nothing; then calls reset()")
  void testHousekeeperStatsReset_givenStatsTimerResetDoesNothing_thenCallsReset() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatsTimer statsTimer = mock(StatsTimer.class);
    doNothing().when(statsTimer).reset();
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    when(statsFactory.createTimer(Mockito.<StatsType>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsTimer);
    HousekeeperStatsService.HousekeeperStats housekeeperStats = new HousekeeperStatsService.HousekeeperStats(
        HousekeeperTaskType.DELETE_ATTRIBUTES, statsFactory);

    // Act
    housekeeperStats.reset();

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("housekeeper"), Mockito.<String>any(), isA(String[].class));
    verify(statsFactory).createTimer(eq(StatsType.HOUSEKEEPER), eq("processingTime"), isA(String[].class));
    verify(statsTimer).reset();
    assertEquals(0, housekeeperStats.getFailedProcessingCounter().get());
  }

  /**
   * Test
   * {@link HousekeeperStatsService#reportProcessed(HousekeeperTaskType, ToHousekeeperServiceMsg, long)}.
   * <ul>
   *   <li>Given {@link NoopTimer#NoopTimer(Id)} with id is
   * {@link Id#Id(String, Tags, String, String, Type)}.</li>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HousekeeperStatsService#reportProcessed(HousekeeperTaskType, TransportProtos.ToHousekeeperServiceMsg, long)}
   */
  @Test
  @DisplayName("Test reportProcessed(HousekeeperTaskType, ToHousekeeperServiceMsg, long); given NoopTimer(Id) with id is Id(String, Tags, String, String, Type); then calls createStatsCounter(String, String, String[])")
  void testReportProcessed_givenNoopTimerWithIdIsId_thenCallsCreateStatsCounter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    when(statsFactory.createTimer(Mockito.<StatsType>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsTimer("Name", new NoopTimer(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    HousekeeperStatsService housekeeperStatsService = new HousekeeperStatsService(statsFactory);

    // Act
    housekeeperStatsService.reportProcessed(HousekeeperTaskType.DELETE_ATTRIBUTES,
        TransportProtos.ToHousekeeperServiceMsg.getDefaultInstance(), 1L);

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("housekeeper"), Mockito.<String>any(), isA(String[].class));
    verify(statsFactory, atLeast(1)).createTimer(eq(StatsType.HOUSEKEEPER), eq("processingTime"), isA(String[].class));
  }

  /**
   * Test
   * {@link HousekeeperStatsService#reportProcessed(HousekeeperTaskType, ToHousekeeperServiceMsg, long)}.
   * <ul>
   *   <li>Given {@link StatsTimer} {@link StatsTimer#record(long)} does
   * nothing.</li>
   *   <li>Then calls {@link StatsTimer#record(long)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HousekeeperStatsService#reportProcessed(HousekeeperTaskType, TransportProtos.ToHousekeeperServiceMsg, long)}
   */
  @Test
  @DisplayName("Test reportProcessed(HousekeeperTaskType, ToHousekeeperServiceMsg, long); given StatsTimer record(long) does nothing; then calls record(long)")
  void testReportProcessed_givenStatsTimerRecordDoesNothing_thenCallsRecord() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatsTimer statsTimer = mock(StatsTimer.class);
    doNothing().when(statsTimer).record(anyLong());
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    when(statsFactory.createTimer(Mockito.<StatsType>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsTimer);
    HousekeeperStatsService housekeeperStatsService = new HousekeeperStatsService(statsFactory);

    // Act
    housekeeperStatsService.reportProcessed(HousekeeperTaskType.DELETE_ATTRIBUTES,
        TransportProtos.ToHousekeeperServiceMsg.getDefaultInstance(), 1L);

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("housekeeper"), Mockito.<String>any(), isA(String[].class));
    verify(statsFactory, atLeast(1)).createTimer(eq(StatsType.HOUSEKEEPER), eq("processingTime"), isA(String[].class));
    verify(statsTimer).record(eq(1L));
  }

  /**
   * Test
   * {@link HousekeeperStatsService#reportFailure(HousekeeperTaskType, ToHousekeeperServiceMsg)}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.</li>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HousekeeperStatsService#reportFailure(HousekeeperTaskType, TransportProtos.ToHousekeeperServiceMsg)}
   */
  @Test
  @DisplayName("Test reportFailure(HousekeeperTaskType, ToHousekeeperServiceMsg); given AtomicInteger(int) with one; then calls createStatsCounter(String, String, String[])")
  void testReportFailure_givenAtomicIntegerWithOne_thenCallsCreateStatsCounter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    when(statsFactory.createTimer(Mockito.<StatsType>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsTimer("Name", new NoopTimer(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    HousekeeperStatsService housekeeperStatsService = new HousekeeperStatsService(statsFactory);

    // Act
    housekeeperStatsService.reportFailure(HousekeeperTaskType.DELETE_ATTRIBUTES,
        TransportProtos.ToHousekeeperServiceMsg.getDefaultInstance());

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("housekeeper"), Mockito.<String>any(), isA(String[].class));
    verify(statsFactory, atLeast(1)).createTimer(eq(StatsType.HOUSEKEEPER), eq("processingTime"), isA(String[].class));
  }
}
