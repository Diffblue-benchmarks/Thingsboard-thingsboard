package org.thingsboard.server.service.queue;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Meter.Id;
import io.micrometer.core.instrument.Meter.Type;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.common.stats.StatsFactory;

@ContextConfiguration(classes = {EdgeConsumerStats.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class EdgeConsumerStatsDiffblueTest {
  @Autowired
  private EdgeConsumerStats edgeConsumerStats;

  @MockBean
  private StatsFactory statsFactory;

  /**
   * Test {@link EdgeConsumerStats#EdgeConsumerStats(StatsFactory)}.
   * <p>
   * Method under test: {@link EdgeConsumerStats#EdgeConsumerStats(StatsFactory)}
   */
  @Test
  @DisplayName("Test new EdgeConsumerStats(StatsFactory)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeConsumerStats.<init>(StatsFactory)"})
  void testNewEdgeConsumerStats() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter,
            new CumulativeCounter(
                new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
            "Name"));

    // Act
    new EdgeConsumerStats(statsFactory);

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("edge"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link EdgeConsumerStats#printStats()}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.</li>
   *   <li>Then calls {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeConsumerStats#printStats()}
   */
  @Test
  @DisplayName("Test printStats(); given AtomicInteger(int) with one; then calls createStatsCounter(String, String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeConsumerStats.printStats()"})
  void testPrintStats_givenAtomicIntegerWithOne_thenCallsCreateStatsCounter() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter,
            new CumulativeCounter(
                new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
            "Name"));

    // Act
    (new EdgeConsumerStats(statsFactory)).printStats();

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("edge"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link EdgeConsumerStats#printStats()}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with zero.</li>
   *   <li>Then calls {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeConsumerStats#printStats()}
   */
  @Test
  @DisplayName("Test printStats(); given AtomicInteger(int) with zero; then calls createStatsCounter(String, String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeConsumerStats.printStats()"})
  void testPrintStats_givenAtomicIntegerWithZero_thenCallsCreateStatsCounter() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(0);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter,
            new CumulativeCounter(
                new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
            "Name"));

    // Act
    (new EdgeConsumerStats(statsFactory)).printStats();

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("edge"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link EdgeConsumerStats#reset()}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.</li>
   *   <li>Then calls {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeConsumerStats#reset()}
   */
  @Test
  @DisplayName("Test reset(); given AtomicInteger(int) with one; then calls createStatsCounter(String, String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeConsumerStats.reset()"})
  void testReset_givenAtomicIntegerWithOne_thenCallsCreateStatsCounter() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter,
            new CumulativeCounter(
                new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
            "Name"));

    // Act
    (new EdgeConsumerStats(statsFactory)).reset();

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("edge"), Mockito.<String>any(), isA(String[].class));
  }
}
