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

class MessagesStatsDiffblueTest {
  /**
   * Method under test: {@link MessagesStats#incrementTotal()}
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
    defaultMessagesStats.incrementTotal();

    // Assert
    assertEquals(2, defaultMessagesStats.getTotal());
  }

  /**
   * Method under test: {@link MessagesStats#incrementSuccessful()}
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
    defaultMessagesStats.incrementSuccessful();

    // Assert
    assertEquals(2, defaultMessagesStats.getSuccessful());
  }

  /**
   * Method under test: {@link MessagesStats#incrementFailed()}
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
    defaultMessagesStats.incrementFailed();

    // Assert
    assertEquals(2, defaultMessagesStats.getFailed());
  }
}
