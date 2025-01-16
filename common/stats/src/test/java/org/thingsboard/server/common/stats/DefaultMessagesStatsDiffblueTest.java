package org.thingsboard.server.common.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefaultMessagesStatsDiffblueTest {
  /**
   * Test
   * {@link DefaultMessagesStats#DefaultMessagesStats(StatsCounter, StatsCounter, StatsCounter)}.
   * <p>
   * Method under test:
   * {@link DefaultMessagesStats#DefaultMessagesStats(StatsCounter, StatsCounter, StatsCounter)}
   */
  @Test
  @DisplayName("Test new DefaultMessagesStats(StatsCounter, StatsCounter, StatsCounter)")
  void testNewDefaultMessagesStats() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(),
        "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    AtomicInteger aiCounter2 = new AtomicInteger(1);
    StatsCounter successfulCounter = new StatsCounter(aiCounter2, new CumulativeCounter(new Meter.Id("Name",
        Tags.empty(), "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    AtomicInteger aiCounter3 = new AtomicInteger(1);

    // Act
    DefaultMessagesStats actualDefaultMessagesStats = new DefaultMessagesStats(totalCounter, successfulCounter,
        new StatsCounter(aiCounter3, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));

    // Assert
    assertEquals(1, actualDefaultMessagesStats.getFailed());
    assertEquals(1, actualDefaultMessagesStats.getSuccessful());
    assertEquals(1, actualDefaultMessagesStats.getTotal());
  }

  /**
   * Test {@link DefaultMessagesStats#incrementTotal(int)} with {@code int}.
   * <p>
   * Method under test: {@link DefaultMessagesStats#incrementTotal(int)}
   */
  @Test
  @DisplayName("Test incrementTotal(int) with 'int'")
  void testIncrementTotalWithInt() {
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
    defaultMessagesStats.incrementTotal(10);

    // Assert
    assertEquals(11, defaultMessagesStats.getTotal());
  }

  /**
   * Test {@link DefaultMessagesStats#incrementSuccessful(int)} with {@code int}.
   * <p>
   * Method under test: {@link DefaultMessagesStats#incrementSuccessful(int)}
   */
  @Test
  @DisplayName("Test incrementSuccessful(int) with 'int'")
  void testIncrementSuccessfulWithInt() {
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
    defaultMessagesStats.incrementSuccessful(10);

    // Assert
    assertEquals(11, defaultMessagesStats.getSuccessful());
  }

  /**
   * Test {@link DefaultMessagesStats#incrementFailed(int)} with {@code int}.
   * <p>
   * Method under test: {@link DefaultMessagesStats#incrementFailed(int)}
   */
  @Test
  @DisplayName("Test incrementFailed(int) with 'int'")
  void testIncrementFailedWithInt() {
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
    defaultMessagesStats.incrementFailed(10);

    // Assert
    assertEquals(11, defaultMessagesStats.getFailed());
  }

  /**
   * Test {@link DefaultMessagesStats#getTotal()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMessagesStats#getTotal()}
   */
  @Test
  @DisplayName("Test getTotal(); then return one")
  void testGetTotal_thenReturnOne() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(),
        "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    AtomicInteger aiCounter2 = new AtomicInteger(1);
    StatsCounter successfulCounter = new StatsCounter(aiCounter2, new CumulativeCounter(new Meter.Id("Name",
        Tags.empty(), "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    AtomicInteger aiCounter3 = new AtomicInteger(1);

    // Act and Assert
    assertEquals(1,
        (new DefaultMessagesStats(totalCounter, successfulCounter,
            new StatsCounter(aiCounter3, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
                "The characteristics of someone or something", Meter.Type.COUNTER)), "Name")))
            .getTotal());
  }

  /**
   * Test {@link DefaultMessagesStats#getSuccessful()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMessagesStats#getSuccessful()}
   */
  @Test
  @DisplayName("Test getSuccessful(); then return one")
  void testGetSuccessful_thenReturnOne() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(),
        "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    AtomicInteger aiCounter2 = new AtomicInteger(1);
    StatsCounter successfulCounter = new StatsCounter(aiCounter2, new CumulativeCounter(new Meter.Id("Name",
        Tags.empty(), "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    AtomicInteger aiCounter3 = new AtomicInteger(1);

    // Act and Assert
    assertEquals(1,
        (new DefaultMessagesStats(totalCounter, successfulCounter,
            new StatsCounter(aiCounter3, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
                "The characteristics of someone or something", Meter.Type.COUNTER)), "Name")))
            .getSuccessful());
  }

  /**
   * Test {@link DefaultMessagesStats#getFailed()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMessagesStats#getFailed()}
   */
  @Test
  @DisplayName("Test getFailed(); then return one")
  void testGetFailed_thenReturnOne() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter totalCounter = new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(),
        "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    AtomicInteger aiCounter2 = new AtomicInteger(1);
    StatsCounter successfulCounter = new StatsCounter(aiCounter2, new CumulativeCounter(new Meter.Id("Name",
        Tags.empty(), "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    AtomicInteger aiCounter3 = new AtomicInteger(1);

    // Act and Assert
    assertEquals(1,
        (new DefaultMessagesStats(totalCounter, successfulCounter,
            new StatsCounter(aiCounter3, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
                "The characteristics of someone or something", Meter.Type.COUNTER)), "Name")))
            .getFailed());
  }

  /**
   * Test {@link DefaultMessagesStats#reset()}.
   * <p>
   * Method under test: {@link DefaultMessagesStats#reset()}
   */
  @Test
  @DisplayName("Test reset()")
  void testReset() {
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
    defaultMessagesStats.reset();

    // Assert
    assertEquals(0, defaultMessagesStats.getFailed());
    assertEquals(0, defaultMessagesStats.getSuccessful());
    assertEquals(0, defaultMessagesStats.getTotal());
  }
}
