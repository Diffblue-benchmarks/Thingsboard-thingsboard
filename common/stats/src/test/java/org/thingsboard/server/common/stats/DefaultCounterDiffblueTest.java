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

class DefaultCounterDiffblueTest {
  /**
   * Method under test: {@link DefaultCounter#increment()}
   */
  @Test
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
   * Method under test: {@link DefaultCounter#clear()}
   */
  @Test
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
   * Method under test: {@link DefaultCounter#get()}
   */
  @Test
  void testGet() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);

    // Act and Assert
    assertEquals(1, (new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
        "The characteristics of someone or something", Meter.Type.COUNTER)))).get());
  }

  /**
   * Method under test: {@link DefaultCounter#add(int)}
   */
  @Test
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

  /**
   * Method under test:
   * {@link DefaultCounter#DefaultCounter(AtomicInteger, Counter)}
   */
  @Test
  void testNewDefaultCounter() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);

    // Act and Assert
    assertEquals(1, (new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
        "The characteristics of someone or something", Meter.Type.COUNTER)))).get());
  }
}
