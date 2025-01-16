package org.thingsboard.server.common.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.noop.NoopTimer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatsTimerDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StatsTimer#StatsTimer(String, Timer)}
   *   <li>{@link StatsTimer#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Name", (new StatsTimer("Name", new NoopTimer(new Meter.Id("Name", Tags.empty(), "Base Unit",
        "The characteristics of someone or something", Meter.Type.COUNTER)))).getName());
  }

  /**
   * Test {@link StatsTimer#record(long)}.
   * <ul>
   *   <li>Then {@link StatsTimer#StatsTimer(String, Timer)} with {@code Name} and
   * micrometerTimer is {@link NoopTimer#NoopTimer(Id)} Avg is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatsTimer#record(long)}
   */
  @Test
  @DisplayName("Test record(long); then StatsTimer(String, Timer) with 'Name' and micrometerTimer is NoopTimer(Id) Avg is ten")
  void testRecord_thenStatsTimerWithNameAndMicrometerTimerIsNoopTimerAvgIsTen() {
    // Arrange
    StatsTimer statsTimer = new StatsTimer("Name", new NoopTimer(new Meter.Id("Name", Tags.empty(), "Base Unit",
        "The characteristics of someone or something", Meter.Type.COUNTER)));

    // Act
    statsTimer.record(10L);

    // Assert
    assertEquals(10.0d, statsTimer.getAvg());
  }

  /**
   * Test {@link StatsTimer#getAvg()}.
   * <p>
   * Method under test: {@link StatsTimer#getAvg()}
   */
  @Test
  @DisplayName("Test getAvg()")
  void testGetAvg() {
    // Arrange, Act and Assert
    assertEquals(0.0d, (new StatsTimer("Name", new NoopTimer(new Meter.Id("Name", Tags.empty(), "Base Unit",
        "The characteristics of someone or something", Meter.Type.COUNTER)))).getAvg());
  }
}
