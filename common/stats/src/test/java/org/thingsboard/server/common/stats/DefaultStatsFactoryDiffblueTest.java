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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.distribution.pause.NoPauseDetector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DefaultStatsFactory.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class DefaultStatsFactoryDiffblueTest {
  @Autowired
  private DefaultStatsFactory defaultStatsFactory;

  @MockBean
  private MeterRegistry meterRegistry;

  /**
   * Method under test:
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}
   */
  @Test
  void testCreateStatsCounter() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultStatsFactory.createStatsCounter("Key", "Stats Name", "Other Tags"));
  }

  /**
   * Method under test:
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}
   */
  @Test
  void testCreateStatsCounter2() {
    // Arrange and Act
    StatsCounter actualCreateStatsCounterResult = defaultStatsFactory.createStatsCounter("Key", "Stats Name");

    // Assert
    assertEquals("Stats Name", actualCreateStatsCounterResult.getName());
    assertEquals(0, actualCreateStatsCounterResult.get());
  }

  /**
   * Method under test:
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}
   */
  @Test
  void testCreateStatsCounter3() {
    // Arrange and Act
    StatsCounter actualCreateStatsCounterResult = defaultStatsFactory.createStatsCounter("Key", "Stats Name",
        "statsName", "Invalid tags array size");

    // Assert
    assertEquals("Stats Name", actualCreateStatsCounterResult.getName());
    assertEquals(0, actualCreateStatsCounterResult.get());
  }

  /**
   * Method under test:
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}
   */
  @Test
  void testCreateStatsCounter4() {
    // Arrange and Act
    StatsCounter actualCreateStatsCounterResult = defaultStatsFactory.createStatsCounter("statsName", "Stats Name",
        "statsName", "Invalid tags array size");

    // Assert
    assertEquals("Stats Name", actualCreateStatsCounterResult.getName());
    assertEquals(0, actualCreateStatsCounterResult.get());
  }

  /**
   * Method under test:
   * {@link DefaultStatsFactory#createDefaultCounter(String, String[])}
   */
  @Test
  void testCreateDefaultCounter() {
    // Arrange, Act and Assert
    assertEquals(0, defaultStatsFactory.createDefaultCounter("Key", "Tags").get());
  }

  /**
   * Method under test:
   * {@link DefaultStatsFactory#createGauge(String, Number, String[])}
   */
  @Test
  void testCreateGauge() {
    // Arrange
    when(meterRegistry.gauge(Mockito.<String>any(), Mockito.<Iterable<Tag>>any(), Mockito.<Integer>any()))
        .thenReturn(1);
    Integer valueOfResult = Integer.valueOf(1);

    // Act
    Number actualCreateGaugeResult = defaultStatsFactory.createGauge("Key", valueOfResult);

    // Assert
    verify(meterRegistry).gauge(eq("Key"), isA(Iterable.class), eq(1));
    assertSame(valueOfResult, actualCreateGaugeResult);
  }

  /**
   * Method under test:
   * {@link DefaultStatsFactory#createGauge(String, Number, String[])}
   */
  @Test
  void testCreateGauge2() {
    // Arrange
    when(meterRegistry.gauge(Mockito.<String>any(), Mockito.<Iterable<Tag>>any(), Mockito.<Integer>any()))
        .thenReturn(1);
    Integer valueOfResult = Integer.valueOf(1);

    // Act
    Number actualCreateGaugeResult = defaultStatsFactory.createGauge("Key", valueOfResult, "Tags", ",");

    // Assert
    verify(meterRegistry).gauge(eq("Key"), isA(Iterable.class), eq(1));
    assertSame(valueOfResult, actualCreateGaugeResult);
  }

  /**
   * Method under test:
   * {@link DefaultStatsFactory#createGauge(String, Number, String[])}
   */
  @Test
  void testCreateGauge3() {
    // Arrange
    when(meterRegistry.gauge(Mockito.<String>any(), Mockito.<Iterable<Tag>>any(), Mockito.<Integer>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultStatsFactory.createGauge("Key", Integer.valueOf(1)));
    verify(meterRegistry).gauge(eq("Key"), isA(Iterable.class), eq(1));
  }

  /**
   * Method under test: {@link DefaultStatsFactory#createMessagesStats(String)}
   */
  @Test
  void testCreateMessagesStats() {
    // Arrange and Act
    MessagesStats actualCreateMessagesStatsResult = defaultStatsFactory.createMessagesStats("Key");

    // Assert
    assertTrue(actualCreateMessagesStatsResult instanceof DefaultMessagesStats);
    assertEquals(0, actualCreateMessagesStatsResult.getFailed());
    assertEquals(0, actualCreateMessagesStatsResult.getSuccessful());
    assertEquals(0, actualCreateMessagesStatsResult.getTotal());
  }

  /**
   * Method under test: {@link DefaultStatsFactory#createTimer(String, String[])}
   */
  @Test
  void testCreateTimer() {
    // Arrange
    when(meterRegistry.config()).thenReturn(meterRegistry.new Config());

    // Act
    Timer actualCreateTimerResult = defaultStatsFactory.createTimer("Key");

    // Assert
    verify(meterRegistry).config();
    assertNull(actualCreateTimerResult);
  }

  /**
   * Method under test: {@link DefaultStatsFactory#createTimer(String, String[])}
   */
  @Test
  void testCreateTimer2() {
    // Arrange
    MeterRegistry.Config config = mock(MeterRegistry.Config.class);
    when(config.pauseDetector()).thenReturn(new NoPauseDetector());
    when(meterRegistry.config()).thenReturn(config);

    // Act
    Timer actualCreateTimerResult = defaultStatsFactory.createTimer("Key");

    // Assert
    verify(meterRegistry).config();
    verify(config).pauseDetector();
    assertNull(actualCreateTimerResult);
  }

  /**
   * Method under test: {@link DefaultStatsFactory#createTimer(String, String[])}
   */
  @Test
  void testCreateTimer3() {
    // Arrange
    MeterRegistry.Config config = mock(MeterRegistry.Config.class);
    when(config.pauseDetector()).thenReturn(new NoPauseDetector());
    when(meterRegistry.config()).thenReturn(config);

    // Act
    Timer actualCreateTimerResult = defaultStatsFactory.createTimer("Key", null);

    // Assert
    verify(meterRegistry).config();
    verify(config).pauseDetector();
    assertNull(actualCreateTimerResult);
  }

  /**
   * Method under test: {@link DefaultStatsFactory#createTimer(String, String[])}
   */
  @Test
  void testCreateTimer4() {
    // Arrange
    MeterRegistry.Config config = mock(MeterRegistry.Config.class);
    when(config.pauseDetector()).thenReturn(new NoPauseDetector());
    when(meterRegistry.config()).thenReturn(config);

    // Act
    Timer actualCreateTimerResult = defaultStatsFactory.createTimer("Key", "Tags", ",");

    // Assert
    verify(meterRegistry).config();
    verify(config).pauseDetector();
    assertNull(actualCreateTimerResult);
  }

  /**
   * Method under test:
   * {@link DefaultStatsFactory#createTimer(StatsType, String, String[])}
   */
  @Test
  void testCreateTimer5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultStatsFactory.createTimer(StatsType.RULE_ENGINE, "Name", "Tags"));
  }

  /**
   * Method under test:
   * {@link DefaultStatsFactory#createTimer(StatsType, String, String[])}
   */
  @Test
  void testCreateTimer6() {
    // Arrange
    when(meterRegistry.config()).thenReturn(meterRegistry.new Config());

    // Act
    StatsTimer actualCreateTimerResult = defaultStatsFactory.createTimer(StatsType.RULE_ENGINE, "Name");

    // Assert
    verify(meterRegistry).config();
    assertEquals("Name", actualCreateTimerResult.getName());
    assertEquals(0.0d, actualCreateTimerResult.getAvg());
  }

  /**
   * Method under test:
   * {@link DefaultStatsFactory#createTimer(StatsType, String, String[])}
   */
  @Test
  void testCreateTimer7() {
    // Arrange
    MeterRegistry.Config config = mock(MeterRegistry.Config.class);
    when(config.pauseDetector()).thenReturn(new NoPauseDetector());
    when(meterRegistry.config()).thenReturn(config);

    // Act
    StatsTimer actualCreateTimerResult = defaultStatsFactory.createTimer(StatsType.RULE_ENGINE, "Name");

    // Assert
    verify(meterRegistry).config();
    verify(config).pauseDetector();
    assertEquals("Name", actualCreateTimerResult.getName());
    assertEquals(0.0d, actualCreateTimerResult.getAvg());
  }

  /**
   * Method under test:
   * {@link DefaultStatsFactory#createTimer(StatsType, String, String[])}
   */
  @Test
  void testCreateTimer8() {
    // Arrange
    MeterRegistry.Config config = mock(MeterRegistry.Config.class);
    when(config.pauseDetector()).thenReturn(new NoPauseDetector());
    when(meterRegistry.config()).thenReturn(config);

    // Act
    StatsTimer actualCreateTimerResult = defaultStatsFactory.createTimer(StatsType.RULE_ENGINE, "Name", "statsName",
        "Invalid tags array size");

    // Assert
    verify(meterRegistry).config();
    verify(config).pauseDetector();
    assertEquals("Name", actualCreateTimerResult.getName());
    assertEquals(0.0d, actualCreateTimerResult.getAvg());
  }

  /**
   * Method under test:
   * {@link DefaultStatsFactory#createTimer(StatsType, String, String[])}
   */
  @Test
  void testCreateTimer9() {
    // Arrange
    MeterRegistry.Config config = mock(MeterRegistry.Config.class);
    when(config.pauseDetector()).thenReturn(new NoPauseDetector());
    when(meterRegistry.config()).thenReturn(config);

    // Act
    StatsTimer actualCreateTimerResult = defaultStatsFactory.createTimer(StatsType.RULE_ENGINE, "Name", "Tags",
        "Invalid tags array size");

    // Assert
    verify(meterRegistry).config();
    verify(config).pauseDetector();
    assertEquals("Name", actualCreateTimerResult.getName());
    assertEquals(0.0d, actualCreateTimerResult.getAvg());
  }
}
