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

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import io.micrometer.core.instrument.noop.NoopTimer;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {FstStatsServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
class FstStatsServiceImplDiffblueTest {
  @Autowired
  private FstStatsServiceImpl fstStatsServiceImpl;

  @MockBean
  private StatsFactory statsFactory;

  /**
   * Method under test: {@link FstStatsServiceImpl#incrementEncode(Class)}
   */
  @Test
  void testIncrementEncode() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    Class<Object> clazz = Object.class;

    // Act
    fstStatsServiceImpl.incrementEncode(clazz);

    // Assert
    verify(statsFactory).createStatsCounter(eq("fst_encode"), eq("Object"), isA(String[].class));
  }

  /**
   * Method under test: {@link FstStatsServiceImpl#incrementEncode(Class)}
   */
  @Test
  void testIncrementEncode2() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(0);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    Class<Object> clazz = Object.class;

    // Act
    fstStatsServiceImpl.incrementEncode(clazz);

    // Assert
    verify(statsFactory).createStatsCounter(eq("fst_encode"), eq("Object"), isA(String[].class));
  }

  /**
   * Method under test: {@link FstStatsServiceImpl#incrementDecode(Class)}
   */
  @Test
  void testIncrementDecode() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    Class<Object> clazz = Object.class;

    // Act
    fstStatsServiceImpl.incrementDecode(clazz);

    // Assert
    verify(statsFactory).createStatsCounter(eq("fst_decode"), eq("Object"), isA(String[].class));
  }

  /**
   * Method under test: {@link FstStatsServiceImpl#incrementDecode(Class)}
   */
  @Test
  void testIncrementDecode2() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(0);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    Class<Object> clazz = Object.class;

    // Act
    fstStatsServiceImpl.incrementDecode(clazz);

    // Assert
    verify(statsFactory).createStatsCounter(eq("fst_decode"), eq("Object"), isA(String[].class));
  }

  /**
   * Method under test: {@link FstStatsServiceImpl#recordEncodeTime(Class, long)}
   */
  @Test
  void testRecordEncodeTime() {
    // Arrange
    when(statsFactory.createTimer(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new NoopTimer(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)));
    Class<Object> clazz = Object.class;

    // Act
    fstStatsServiceImpl.recordEncodeTime(clazz, 1L);

    // Assert
    verify(statsFactory).createTimer(eq("fst_encode_time"), isA(String[].class));
  }

  /**
   * Method under test: {@link FstStatsServiceImpl#recordEncodeTime(Class, long)}
   */
  @Test
  void testRecordEncodeTime2() {
    // Arrange
    when(statsFactory.createTimer(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new NoopTimer(new Meter.Id("fst_encode_time", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)));
    Class<Object> clazz = Object.class;

    // Act
    fstStatsServiceImpl.recordEncodeTime(clazz, 1L);

    // Assert
    verify(statsFactory).createTimer(eq("fst_encode_time"), isA(String[].class));
  }

  /**
   * Method under test: {@link FstStatsServiceImpl#recordDecodeTime(Class, long)}
   */
  @Test
  void testRecordDecodeTime() {
    // Arrange
    when(statsFactory.createTimer(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new NoopTimer(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)));
    Class<Object> clazz = Object.class;

    // Act
    fstStatsServiceImpl.recordDecodeTime(clazz, 1L);

    // Assert
    verify(statsFactory).createTimer(eq("fst_decode_time"), isA(String[].class));
  }

  /**
   * Method under test: {@link FstStatsServiceImpl#recordDecodeTime(Class, long)}
   */
  @Test
  void testRecordDecodeTime2() {
    // Arrange
    when(statsFactory.createTimer(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new NoopTimer(new Meter.Id("fst_decode_time", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)));
    Class<Object> clazz = Object.class;

    // Act
    fstStatsServiceImpl.recordDecodeTime(clazz, 1L);

    // Assert
    verify(statsFactory).createTimer(eq("fst_decode_time"), isA(String[].class));
  }
}
