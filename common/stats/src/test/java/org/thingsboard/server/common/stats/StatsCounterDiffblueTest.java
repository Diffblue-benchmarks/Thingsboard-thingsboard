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
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class StatsCounterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StatsCounter#StatsCounter(AtomicInteger, Counter, String)}
   *   <li>{@link StatsCounter#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);

    // Act and Assert
    assertEquals("Name", (new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(),
        "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name")).getName());
  }
}
