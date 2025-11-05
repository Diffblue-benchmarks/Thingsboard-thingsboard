package org.thingsboard.server.common.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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

class MessagesStatsDiffblueTest {
  /**
   * Test {@link MessagesStats#incrementTotal()}.
   *
   * <p>Method under test: {@link MessagesStats#incrementTotal()}
   */
  @Test
  @DisplayName("Test incrementTotal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessagesStats.incrementTotal()"})
  void testIncrementTotal() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(id), "Name");
    AtomicInteger aiCounter2 = new AtomicInteger();
    Id id2 =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter successfulCounter =
        new StatsCounter(aiCounter2, new CumulativeCounter(id2), "Name");
    AtomicInteger aiCounter3 = new AtomicInteger();
    Id id3 =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter failedCounter = new StatsCounter(aiCounter3, new CumulativeCounter(id3), "Name");

    DefaultMessagesStats defaultMessagesStats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);

    // Act
    defaultMessagesStats.incrementTotal();

    // Assert
    assertEquals(1, defaultMessagesStats.getTotal());
  }

  /**
   * Test {@link MessagesStats#incrementSuccessful()}.
   *
   * <p>Method under test: {@link MessagesStats#incrementSuccessful()}
   */
  @Test
  @DisplayName("Test incrementSuccessful()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessagesStats.incrementSuccessful()"})
  void testIncrementSuccessful() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(id), "Name");
    AtomicInteger aiCounter2 = new AtomicInteger();
    Id id2 =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter successfulCounter =
        new StatsCounter(aiCounter2, new CumulativeCounter(id2), "Name");
    AtomicInteger aiCounter3 = new AtomicInteger();
    Id id3 =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter failedCounter = new StatsCounter(aiCounter3, new CumulativeCounter(id3), "Name");

    DefaultMessagesStats defaultMessagesStats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);

    // Act
    defaultMessagesStats.incrementSuccessful();

    // Assert
    assertEquals(1, defaultMessagesStats.getSuccessful());
  }

  /**
   * Test {@link MessagesStats#incrementFailed()}.
   *
   * <p>Method under test: {@link MessagesStats#incrementFailed()}
   */
  @Test
  @DisplayName("Test incrementFailed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MessagesStats.incrementFailed()"})
  void testIncrementFailed() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(id), "Name");
    AtomicInteger aiCounter2 = new AtomicInteger();
    Id id2 =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter successfulCounter =
        new StatsCounter(aiCounter2, new CumulativeCounter(id2), "Name");
    AtomicInteger aiCounter3 = new AtomicInteger();
    Id id3 =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter failedCounter = new StatsCounter(aiCounter3, new CumulativeCounter(id3), "Name");

    DefaultMessagesStats defaultMessagesStats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);

    // Act
    defaultMessagesStats.incrementFailed();

    // Assert
    assertEquals(1, defaultMessagesStats.getFailed());
  }
}
