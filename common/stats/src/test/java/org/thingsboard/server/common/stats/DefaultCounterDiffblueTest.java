package org.thingsboard.server.common.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefaultCounterDiffblueTest {
  /**
   * Test {@link DefaultCounter#DefaultCounter(AtomicInteger, Counter)}.
   * <p>
   * Method under test:
   * {@link DefaultCounter#DefaultCounter(AtomicInteger, Counter)}
   */
  @Test
  @DisplayName("Test new DefaultCounter(AtomicInteger, Counter)")
  void testNewDefaultCounter() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);

    // Act and Assert
    assertEquals(1, (new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
        "The characteristics of someone or something", Meter.Type.COUNTER)))).get());
  }

  /**
   * Test {@link DefaultCounter#increment()}.
   * <p>
   * Method under test: {@link DefaultCounter#increment()}
   */
  @Test
  @DisplayName("Test increment()")
  void testIncrement() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    DefaultCounter defaultCounter = new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name",
        Tags.empty(), "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)));

    // Act
    defaultCounter.increment();

    // Assert
    assertEquals(2, defaultCounter.get());
  }

  /**
   * Test {@link DefaultCounter#clear()}.
   * <p>
   * Method under test: {@link DefaultCounter#clear()}
   */
  @Test
  @DisplayName("Test clear()")
  void testClear() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    DefaultCounter defaultCounter = new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name",
        Tags.empty(), "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)));

    // Act
    defaultCounter.clear();

    // Assert
    assertEquals(0, defaultCounter.get());
  }

  /**
   * Test {@link DefaultCounter#get()}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCounter#get()}
   */
  @Test
  @DisplayName("Test get(); given AtomicInteger(int) with one; then return one")
  void testGet_givenAtomicIntegerWithOne_thenReturnOne() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);

    // Act and Assert
    assertEquals(1, (new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
        "The characteristics of someone or something", Meter.Type.COUNTER)))).get());
  }

  /**
   * Test {@link DefaultCounter#add(int)}.
   * <p>
   * Method under test: {@link DefaultCounter#add(int)}
   */
  @Test
  @DisplayName("Test add(int)")
  void testAdd() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    DefaultCounter defaultCounter = new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name",
        Tags.empty(), "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)));

    // Act
    defaultCounter.add(2);

    // Assert
    assertEquals(3, defaultCounter.get());
  }
}
