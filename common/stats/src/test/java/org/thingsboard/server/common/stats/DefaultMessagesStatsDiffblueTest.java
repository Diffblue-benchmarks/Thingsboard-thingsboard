/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.stats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class DefaultMessagesStatsDiffblueTest {
  /**
   * Method under test: {@link DefaultMessagesStats#incrementTotal(int)}
   */
  @Test
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
    defaultMessagesStats.incrementTotal(10);

    // Assert
    assertEquals(11, defaultMessagesStats.getTotal());
  }

  /**
   * Method under test: {@link DefaultMessagesStats#incrementSuccessful(int)}
   */
  @Test
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
    defaultMessagesStats.incrementSuccessful(10);

    // Assert
    assertEquals(11, defaultMessagesStats.getSuccessful());
  }

  /**
   * Method under test: {@link DefaultMessagesStats#incrementFailed(int)}
   */
  @Test
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
    defaultMessagesStats.incrementFailed(10);

    // Assert
    assertEquals(11, defaultMessagesStats.getFailed());
  }

  /**
   * Method under test: {@link DefaultMessagesStats#getTotal()}
   */
  @Test
  void testGetTotal() {
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
   * Method under test: {@link DefaultMessagesStats#getSuccessful()}
   */
  @Test
  void testGetSuccessful() {
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
   * Method under test: {@link DefaultMessagesStats#getFailed()}
   */
  @Test
  void testGetFailed() {
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
   * Method under test: {@link DefaultMessagesStats#reset()}
   */
  @Test
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

  /**
   * Method under test:
   * {@link DefaultMessagesStats#DefaultMessagesStats(StatsCounter, StatsCounter, StatsCounter)}
   */
  @Test
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
}
