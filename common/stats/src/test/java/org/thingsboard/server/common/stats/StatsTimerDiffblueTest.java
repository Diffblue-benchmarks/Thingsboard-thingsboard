package org.thingsboard.server.common.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Meter.Id;
import io.micrometer.core.instrument.Meter.Type;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.noop.NoopTimer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StatsTimerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StatsTimer#StatsTimer(String, Timer)}
   *   <li>{@link StatsTimer#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatsTimer.<init>(String, Timer)", "String StatsTimer.getName()"})
  void testGettersAndSetters() {
    // Arrange
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);

    // Act
    StatsTimer actualStatsTimer = new StatsTimer("Name", new NoopTimer(id));

    // Assert
    assertEquals("Name", actualStatsTimer.getName());
  }

  /**
   * Test {@link StatsTimer#record(long)}.
   *
   * <ul>
   *   <li>Then {@link StatsTimer#StatsTimer(String, Timer)} with {@code Name} and micrometerTimer
   *       is {@link NoopTimer#NoopTimer(Id)} Avg is ten.
   * </ul>
   *
   * <p>Method under test: {@link StatsTimer#record(long)}
   */
  @Test
  @DisplayName(
      "Test record(long); then StatsTimer(String, Timer) with 'Name' and micrometerTimer is NoopTimer(Id) Avg is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StatsTimer.record(long)"})
  void testRecord_thenStatsTimerWithNameAndMicrometerTimerIsNoopTimerAvgIsTen() {
    // Arrange
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsTimer statsTimer = new StatsTimer("Name", new NoopTimer(id));

    // Act
    statsTimer.record(10L);

    // Assert
    assertEquals(10.0d, statsTimer.getAvg());
  }

  /**
   * Test {@link StatsTimer#getAvg()}.
   *
   * <p>Method under test: {@link StatsTimer#getAvg()}
   */
  @Test
  @DisplayName("Test getAvg()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double StatsTimer.getAvg()"})
  void testGetAvg() {
    // Arrange
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsTimer statsTimer = new StatsTimer("Name", new NoopTimer(id));

    // Act and Assert
    assertEquals(0.0d, statsTimer.getAvg());
  }
}
