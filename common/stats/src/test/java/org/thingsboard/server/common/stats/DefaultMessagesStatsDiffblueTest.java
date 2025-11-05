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

class DefaultMessagesStatsDiffblueTest {
  /**
   * Test {@link DefaultMessagesStats#DefaultMessagesStats(StatsCounter, StatsCounter,
   * StatsCounter)}.
   *
   * <p>Method under test: {@link DefaultMessagesStats#DefaultMessagesStats(StatsCounter,
   * StatsCounter, StatsCounter)}
   */
  @Test
  @DisplayName("Test new DefaultMessagesStats(StatsCounter, StatsCounter, StatsCounter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultMessagesStats.<init>(StatsCounter, StatsCounter, StatsCounter)"})
  void testNewDefaultMessagesStats() {
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

    // Act
    DefaultMessagesStats actualDefaultMessagesStats =
        new DefaultMessagesStats(totalCounter, successfulCounter, failedCounter);

    // Assert
    assertEquals(0, actualDefaultMessagesStats.getFailed());
    assertEquals(0, actualDefaultMessagesStats.getSuccessful());
    assertEquals(0, actualDefaultMessagesStats.getTotal());
  }

  /**
   * Test {@link DefaultMessagesStats#incrementTotal(int)} with {@code int}.
   *
   * <p>Method under test: {@link DefaultMessagesStats#incrementTotal(int)}
   */
  @Test
  @DisplayName("Test incrementTotal(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultMessagesStats.incrementTotal(int)"})
  void testIncrementTotalWithInt() {
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
    defaultMessagesStats.incrementTotal(10);

    // Assert
    assertEquals(10, defaultMessagesStats.getTotal());
  }

  /**
   * Test {@link DefaultMessagesStats#incrementSuccessful(int)} with {@code int}.
   *
   * <p>Method under test: {@link DefaultMessagesStats#incrementSuccessful(int)}
   */
  @Test
  @DisplayName("Test incrementSuccessful(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultMessagesStats.incrementSuccessful(int)"})
  void testIncrementSuccessfulWithInt() {
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
    defaultMessagesStats.incrementSuccessful(10);

    // Assert
    assertEquals(10, defaultMessagesStats.getSuccessful());
  }

  /**
   * Test {@link DefaultMessagesStats#incrementFailed(int)} with {@code int}.
   *
   * <p>Method under test: {@link DefaultMessagesStats#incrementFailed(int)}
   */
  @Test
  @DisplayName("Test incrementFailed(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultMessagesStats.incrementFailed(int)"})
  void testIncrementFailedWithInt() {
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
    defaultMessagesStats.incrementFailed(10);

    // Assert
    assertEquals(10, defaultMessagesStats.getFailed());
  }

  /**
   * Test {@link DefaultMessagesStats#getTotal()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultMessagesStats#getTotal()}
   */
  @Test
  @DisplayName("Test getTotal(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultMessagesStats.getTotal()"})
  void testGetTotal_thenReturnZero() {
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

    // Act and Assert
    assertEquals(0, defaultMessagesStats.getTotal());
  }

  /**
   * Test {@link DefaultMessagesStats#getSuccessful()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultMessagesStats#getSuccessful()}
   */
  @Test
  @DisplayName("Test getSuccessful(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultMessagesStats.getSuccessful()"})
  void testGetSuccessful_thenReturnZero() {
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

    // Act and Assert
    assertEquals(0, defaultMessagesStats.getSuccessful());
  }

  /**
   * Test {@link DefaultMessagesStats#getFailed()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultMessagesStats#getFailed()}
   */
  @Test
  @DisplayName("Test getFailed(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultMessagesStats.getFailed()"})
  void testGetFailed_thenReturnZero() {
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

    // Act and Assert
    assertEquals(0, defaultMessagesStats.getFailed());
  }
}
