package org.thingsboard.server.common.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class StatsCounterDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StatsCounter#StatsCounter(AtomicInteger, Counter, String)}
   *   <li>{@link StatsCounter#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StatsCounter.<init>(AtomicInteger, Counter, String)", "String StatsCounter.getName()"})
  void testGettersAndSetters() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);

    // Act and Assert
    assertEquals("Name",
        (new StatsCounter(aiCounter,
            new CumulativeCounter(
                new Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something", Type.COUNTER)),
            "Name")).getName());
  }
}
