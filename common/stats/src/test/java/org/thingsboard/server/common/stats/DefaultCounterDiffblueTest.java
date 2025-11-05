package org.thingsboard.server.common.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Meter.Id;
import io.micrometer.core.instrument.Meter.Type;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DefaultCounterDiffblueTest {
  /**
   * Test {@link DefaultCounter#DefaultCounter(AtomicInteger, Counter)}.
   *
   * <p>Method under test: {@link DefaultCounter#DefaultCounter(AtomicInteger, Counter)}
   */
  @Test
  @DisplayName("Test new DefaultCounter(AtomicInteger, Counter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultCounter.<init>(AtomicInteger, Counter)"})
  void testNewDefaultCounter() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);

    // Act
    DefaultCounter actualDefaultCounter = new DefaultCounter(aiCounter, new CumulativeCounter(id));

    // Assert
    assertEquals(0, actualDefaultCounter.get());
  }

  /**
   * Test {@link DefaultCounter#increment()}.
   *
   * <p>Method under test: {@link DefaultCounter#increment()}
   */
  @Test
  @DisplayName("Test increment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultCounter.increment()"})
  void testIncrement() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    DefaultCounter defaultCounter = new DefaultCounter(aiCounter, new CumulativeCounter(id));

    // Act
    defaultCounter.increment();

    // Assert
    assertEquals(1, defaultCounter.get());
  }

  /**
   * Test {@link DefaultCounter#get()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCounter#get()}
   */
  @Test
  @DisplayName("Test get(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DefaultCounter.get()"})
  void testGet_thenReturnZero() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    DefaultCounter defaultCounter = new DefaultCounter(aiCounter, new CumulativeCounter(id));

    // Act and Assert
    assertEquals(0, defaultCounter.get());
  }

  /**
   * Test {@link DefaultCounter#add(int)}.
   *
   * <p>Method under test: {@link DefaultCounter#add(int)}
   */
  @Test
  @DisplayName("Test add(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultCounter.add(int)"})
  void testAdd() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    DefaultCounter defaultCounter = new DefaultCounter(aiCounter, new CumulativeCounter(id));

    // Act
    defaultCounter.add(2);

    // Assert
    assertEquals(2, defaultCounter.get());
  }
}
