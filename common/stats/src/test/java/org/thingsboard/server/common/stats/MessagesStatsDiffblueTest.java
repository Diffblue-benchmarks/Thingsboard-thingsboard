package org.thingsboard.server.common.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MessagesStatsDiffblueTest {
  /**
   * Test {@link MessagesStats#incrementTotal()}.
   * <p>
   * Method under test: {@link MessagesStats#incrementTotal()}
   */
  @Test
  @DisplayName("Test incrementTotal()")
  void testIncrementTotal() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(),
        "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    AtomicInteger aiCounter2 = new AtomicInteger(1);
    StatsCounter successfulCounter = new StatsCounter(aiCounter2, new CumulativeCounter(new Meter.Id("Name",
        Tags.empty(), "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    AtomicInteger aiCounter3 = new AtomicInteger(1);
    DefaultMessagesStats defaultMessagesStats = new DefaultMessagesStats(totalCounter, successfulCounter,
        new StatsCounter(aiCounter3, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));

    // Act
    defaultMessagesStats.incrementTotal();

    // Assert
    assertEquals(2, defaultMessagesStats.getTotal());
  }

  /**
   * Test {@link MessagesStats#incrementSuccessful()}.
   * <p>
   * Method under test: {@link MessagesStats#incrementSuccessful()}
   */
  @Test
  @DisplayName("Test incrementSuccessful()")
  void testIncrementSuccessful() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(),
        "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    AtomicInteger aiCounter2 = new AtomicInteger(1);
    StatsCounter successfulCounter = new StatsCounter(aiCounter2, new CumulativeCounter(new Meter.Id("Name",
        Tags.empty(), "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    AtomicInteger aiCounter3 = new AtomicInteger(1);
    DefaultMessagesStats defaultMessagesStats = new DefaultMessagesStats(totalCounter, successfulCounter,
        new StatsCounter(aiCounter3, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));

    // Act
    defaultMessagesStats.incrementSuccessful();

    // Assert
    assertEquals(2, defaultMessagesStats.getSuccessful());
  }

  /**
   * Test {@link MessagesStats#incrementFailed()}.
   * <p>
   * Method under test: {@link MessagesStats#incrementFailed()}
   */
  @Test
  @DisplayName("Test incrementFailed()")
  void testIncrementFailed() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(),
        "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    AtomicInteger aiCounter2 = new AtomicInteger(1);
    StatsCounter successfulCounter = new StatsCounter(aiCounter2, new CumulativeCounter(new Meter.Id("Name",
        Tags.empty(), "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    AtomicInteger aiCounter3 = new AtomicInteger(1);
    DefaultMessagesStats defaultMessagesStats = new DefaultMessagesStats(totalCounter, successfulCounter,
        new StatsCounter(aiCounter3, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));

    // Act
    defaultMessagesStats.incrementFailed();

    // Assert
    assertEquals(2, defaultMessagesStats.getFailed());
  }
}
