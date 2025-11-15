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
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.noop.NoopTimer;
import org.junit.jupiter.api.Test;

class StatsTimerDiffblueTest {
  /**
   * Method under test: {@link StatsTimer#record(long)}
   */
  @Test
  void testRecord() {
    // Arrange
    StatsTimer statsTimer = new StatsTimer("Name", new NoopTimer(new Meter.Id("Name", Tags.empty(), "Base Unit",
        "The characteristics of someone or something", Meter.Type.COUNTER)));

    // Act
    statsTimer.record(10L);

    // Assert
    assertEquals(10.0d, statsTimer.getAvg());
  }

  /**
   * Method under test: {@link StatsTimer#getAvg()}
   */
  @Test
  void testGetAvg() {
    // Arrange, Act and Assert
    assertEquals(0.0d, (new StatsTimer("Name", new NoopTimer(new Meter.Id("Name", Tags.empty(), "Base Unit",
        "The characteristics of someone or something", Meter.Type.COUNTER)))).getAvg());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StatsTimer#StatsTimer(String, Timer)}
   *   <li>{@link StatsTimer#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Name", (new StatsTimer("Name", new NoopTimer(new Meter.Id("Name", Tags.empty(), "Base Unit",
        "The characteristics of someone or something", Meter.Type.COUNTER)))).getName());
  }
}
