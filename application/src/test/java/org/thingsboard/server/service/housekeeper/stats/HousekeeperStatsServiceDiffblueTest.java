package org.thingsboard.server.service.housekeeper.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Meter.Id;
import io.micrometer.core.instrument.Meter.Type;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import io.micrometer.core.instrument.noop.NoopTimer;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTaskType;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.common.stats.StatsFactory;
import org.thingsboard.server.common.stats.StatsTimer;
import org.thingsboard.server.common.stats.StatsType;
import org.thingsboard.server.service.housekeeper.stats.HousekeeperStatsService.HousekeeperStats;

@ExtendWith(MockitoExtension.class)
class HousekeeperStatsServiceDiffblueTest {
  @Mock
  private StatsFactory statsFactory;

  /**
   * Test HousekeeperStats {@link HousekeeperStats#HousekeeperStats(HousekeeperTaskType, StatsFactory)}.
   * <p>
   * Method under test: {@link HousekeeperStats#HousekeeperStats(HousekeeperTaskType, StatsFactory)}
   */
  @Test
  @DisplayName("Test HousekeeperStats new HousekeeperStats(HousekeeperTaskType, StatsFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HousekeeperStats.<init>(HousekeeperTaskType, StatsFactory)"})
  void testHousekeeperStatsNewHousekeeperStats() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter statsCounter = new StatsCounter(aiCounter,
        new CumulativeCounter(
            new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
        "Name");

    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    StatsTimer statsTimer = new StatsTimer("Name", new NoopTimer(
        new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)));

    when(statsFactory.createTimer(Mockito.<StatsType>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsTimer);

    // Act
    HousekeeperStats actualHousekeeperStats = new HousekeeperStats(HousekeeperTaskType.DELETE_ATTRIBUTES, statsFactory);

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
   * <ul>
   *   <li>Given {@link NoopTimer#NoopTimer(Id)} with id is {@link Meter.Id#Id(String, Tags, String, String, Type)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperStats#reset()}
   */
  @Test
  @DisplayName("Test HousekeeperStats reset(); given NoopTimer(Id) with id is Id(String, Tags, String, String, Type)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HousekeeperStats.reset()"})
  void testHousekeeperStatsReset_givenNoopTimerWithIdIsId() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter,
            new CumulativeCounter(
                new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
            "Name"));
    when(statsFactory.createTimer(Mockito.<StatsType>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsTimer("Name", new NoopTimer(
            new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER))));
    HousekeeperStats housekeeperStats = new HousekeeperStats(HousekeeperTaskType.DELETE_ATTRIBUTES, statsFactory);

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
   * Method under test: {@link HousekeeperStats#reset()}
   */
  @Test
  @DisplayName("Test HousekeeperStats reset(); given StatsTimer reset() does nothing; then calls reset()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HousekeeperStats.reset()"})
  void testHousekeeperStatsReset_givenStatsTimerResetDoesNothing_thenCallsReset() {
    // Arrange
    StatsTimer statsTimer = mock(StatsTimer.class);
    doNothing().when(statsTimer).reset();
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter,
            new CumulativeCounter(
                new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
            "Name"));
    when(statsFactory.createTimer(Mockito.<StatsType>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsTimer);
    HousekeeperStats housekeeperStats = new HousekeeperStats(HousekeeperTaskType.DELETE_ATTRIBUTES, statsFactory);

    // Act
    housekeeperStats.reset();

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("housekeeper"), Mockito.<String>any(), isA(String[].class));
    verify(statsFactory).createTimer(eq(StatsType.HOUSEKEEPER), eq("processingTime"), isA(String[].class));
    verify(statsTimer).reset();
    assertEquals(0, housekeeperStats.getFailedProcessingCounter().get());
  }
}
