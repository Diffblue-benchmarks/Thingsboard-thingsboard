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
package org.thingsboard.server.dao.nosql;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Meter.Id;
import io.micrometer.core.instrument.Meter.Type;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import io.micrometer.core.instrument.noop.NoopCounter;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.RateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityService;

public class CassandraBufferedRateReadExecutorDiffblueTest {
  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(id), "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats2() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(42));
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(id), "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats3() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger();
    aiCounter.incrementAndGet();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(id), "Name");

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats4() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats5() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(42));
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats6() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats7() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats8() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            42, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats9() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 42, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats10() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 0, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats11() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, -1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats12() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 0L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats13() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, -1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats14() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 42, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats15() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats16() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, -1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats17() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, false, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats18() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 0, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats19() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, null, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats20() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 42);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats21() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    EntityService entityService = mock(EntityService.class);
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats22() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1,
            1,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            new BaseEntityService(),
            mock(RateLimitService.class));

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats23() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, -1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats24() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 2L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats25() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, -1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats26() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(42));
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 42, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats27() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 42, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats28() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(2);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 42, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats29() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1,
            -1,
            1L,
            1,
            1,
            Long.MIN_VALUE,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats30() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(42));
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, -1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats31() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(42));
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 0L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats32() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 0L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats33() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 0L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats34() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 0L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats35() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 0L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats36() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 0L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats37() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(42));
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, -1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats38() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, -1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats39() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(42));
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, -1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats40() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, -1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats41() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, -1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats42() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(42));
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, false, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats43() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(42));
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 0, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats44() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 0, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet eight.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetEight_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(8);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("[{}] Permits {}");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet eleven.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetEleven_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(11);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("[{}] Permits {}");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet eleven.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetEleven_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(11);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("[{}] Permits {}");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet eleven.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetEleven_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(11);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("[{}] Permits {}");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear6() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear7() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear8() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear9() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear10() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear11() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear12() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear13() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear14() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear15() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear16() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear17() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear18() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear19() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear20() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear21() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear22() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear23() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear24() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear25() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear26() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear27() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear28() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFiftyFour_thenCallsClear29() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFifty_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(50);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFifty_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(50);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFifty_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(50);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFifty_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(50);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFifty_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(50);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFifty_thenCallsClear6() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(50);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFifty_thenCallsClear7() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(50);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFifty_thenCallsClear8() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(50);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFifty_thenCallsClear9() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(50);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet fifty.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFifty_thenCallsClear10() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(50);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFive_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFive_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet forty-nine.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFortyNine_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(49);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet forty-three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFortyThree_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(43);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(114);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFortyTwo_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(42);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(Integer.MIN_VALUE);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("[{}] Permits {}");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("[{}] Permits {}");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("[{}] Permits {}");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear6() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear7() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear8() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear9() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear10() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear11() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear12() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one hundred eight.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOneHundredEight_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(108);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one hundred eight.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOneHundredEight_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(108);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one hundred eight.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOneHundredEight_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(108);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(114);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one hundred eighteen.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOneHundredEighteen_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(118);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("queueSize");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one hundred fourteen.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOneHundredFourteen_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(114);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one hundred fourteen.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOneHundredFourteen_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(114);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one hundred fourteen.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOneHundredFourteen_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(114);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one hundred ninety-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOneHundredNinetyFour_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(194);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 0, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one hundred thirteen.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOneHundredThirteen_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(113);
    atomicInteger.addAndGet(114);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one hundred thirteen.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOneHundredThirteen_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(113);
    atomicInteger.addAndGet(114);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one hundred thirteen.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOneHundredThirteen_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(113);
    atomicInteger.addAndGet(114);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one hundred thirteen.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOneHundredThirteen_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(113);
    atomicInteger.addAndGet(114);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one hundred thirteen.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOneHundredThirteen_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(113);
    atomicInteger.addAndGet(114);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one hundred thirteen.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOneHundredThirteen_thenCallsClear6() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(113);
    atomicInteger.addAndGet(114);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOne_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOne_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOne_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOne_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOne_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetOne_thenCallsClear6() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet seven.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetSeven_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(7);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet six.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetSix_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet six.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetSix_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet six.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetSix_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet six.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetSix_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet six.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetSix_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet six.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetSix_thenCallsClear6() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet six.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetSix_thenCallsClear7() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet six.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetSix_thenCallsClear8() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet six.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetSix_thenCallsClear9() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet six.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetSix_thenCallsClear10() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet six.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetSix_thenCallsClear11() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(3);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear6() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear7() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear8() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear9() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear10() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(3);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear11() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear12() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear13() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear14() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear15() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear16() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear17() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear18() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear19() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear20() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear21() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear22() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear23() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear24() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear25() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear26() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetThree_thenCallsClear27() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetTwo_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetTwo_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetTwo_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetTwo_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetTwo_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetTwo_thenCallsClear6() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetTwo_thenCallsClear7() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetTwo_thenCallsClear8() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetTwo_thenCallsClear9() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetTwo_thenCallsClear10() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetTwo_thenCallsClear11() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetTwo_thenCallsClear12() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetTwo_thenCallsClear13() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetTwo_thenCallsClear14() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetTwo_thenCallsClear15() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerFortyTwo_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerFortyTwo_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerFortyTwo_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerFortyTwo_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerFortyTwo_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerFortyTwo_thenCallsClear6() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerFortyTwo_thenCallsClear7() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerFortyTwo_thenCallsClear8() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerFortyTwo_thenCallsClear9() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerFortyTwo_thenCallsClear10() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerFortyTwo_thenCallsClear11() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerFortyTwo_thenCallsClear12() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerFortyTwo_thenCallsClear13() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerFortyTwo_thenCallsClear14() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerFortyTwo_thenCallsClear15() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerFortyTwo_thenCallsClear16() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerFortyTwo_thenCallsClear17() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} forty-two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerFortyTwo_thenCallsClear18() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerIncrementAndGet_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetFiftyFour_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetFiftyFour_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetFiftyFour_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetFiftyFour_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetFiftyFour_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetFiftyFour_thenCallsClear6() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetFiftyFour_thenCallsClear7() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetFiftyFour_thenCallsClear8() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet fifty-four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetFiftyFour_thenCallsClear9() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet fifty.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetFifty_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(50);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet fifty.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetFifty_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(50);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet fifty.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetFifty_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(50);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet fifty.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetFifty_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(50);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetFive_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetFive_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet forty-three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetFortyThree_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(43);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(114);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetMin_value_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(Integer.MIN_VALUE);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("[{}] Permits {}");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetMin_value_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("[{}] Permits {}");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetMin_value_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("[{}] Permits {}");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetMinusOne_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetMinusOne_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetMinusOne_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetMinusOne_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet one hundred
   *       eight.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetOneHundredEight() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(108);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet one hundred
   *       eight.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetOneHundredEight2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(108);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(114);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet one hundred
   *       fourteen.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetOneHundredFourteen() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(114);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet one hundred
   *       fourteen.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetOneHundredFourteen2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(114);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet one hundred
   *       ninety-four.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetOneHundredNinetyFour() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(194);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 0, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet one hundred
   *       thirteen.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetOneHundredThirteen() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(113);
    atomicInteger.addAndGet(114);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet one hundred
   *       thirteen.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetOneHundredThirteen2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(113);
    atomicInteger.addAndGet(114);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(54);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetOne_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetOne_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetOne_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetOne_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetOne_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet seven.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetSeven_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(7);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet six.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetSix_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet six.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetSix_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet six.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetSix_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(6);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetThree_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(3);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetThree_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetThree_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetThree_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetThree_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(3);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetTwo_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetTwo_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetTwo_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetTwo_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetTwo_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetTwo_thenCallsClear6() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetTwo_thenCallsClear7() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetTwo_thenCallsClear8() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetTwo_thenCallsClear9() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetTwo_thenCallsClear10() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoAddAndGetTwo_thenCallsClear11() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwoIncrementAndGet_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with forty-two.
   *   <li>Then calls {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithFortyTwo_thenCallsCreateGauge() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    AtomicInteger aiCounter = new AtomicInteger(42);
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(id), "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link StatsCounter} {@link StatsCounter#getName()} return {@code 42}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenStatsCounterGetNameReturn42_thenCallsClear() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("42");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link StatsCounter} {@link StatsCounter#getName()} return {@code = [}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenStatsCounterGetNameReturnEqualsSignSpaceLeftSquareBracket() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn(" = [");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link StatsCounter} {@link StatsCounter#getName()} return {@code = [}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenStatsCounterGetNameReturnEqualsSignSpaceLeftSquareBracket2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn(" = [");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link StatsCounter} {@link StatsCounter#getName()} return {@code = [}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenStatsCounterGetNameReturnEqualsSignSpaceLeftSquareBracket3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(42);
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn(" = [");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link StatsCounter} {@link StatsCounter#getName()} return {@code = [}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenStatsCounterGetNameReturnEqualsSignSpaceLeftSquareBracket4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn(" = [");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link StatsCounter} {@link StatsCounter#getName()} return {@code = [}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenStatsCounterGetNameReturnEqualsSignSpaceLeftSquareBracket5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn(" = [");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link StatsCounter} {@link StatsCounter#getName()} return {@code [{}] Permits {}}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenStatsCounterGetNameReturnPermits_thenCallsClear() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("[{}] Permits {}");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link StatsCounter} {@link StatsCounter#getName()} return {@code [{}] Permits {}}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenStatsCounterGetNameReturnPermits_thenCallsClear2() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("[{}] Permits {}");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(42));
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link StatsCounter} {@link StatsCounter#getName()} return {@code [{}] Permits {}}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenStatsCounterGetNameReturnPermits_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("[{}] Permits {}");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link StatsCounter} {@link StatsCounter#getName()} return {@code queueSize}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenStatsCounterGetNameReturnQueueSize_thenCallsClear() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("queueSize");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link StatsCounter} {@link StatsCounter#getName()} return {@code queueSize}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenStatsCounterGetNameReturnQueueSize_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("queueSize");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link StatsCounter} {@link StatsCounter#getName()} return {@code queueSize}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenStatsCounterGetNameReturnQueueSize_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(42);
    atomicInteger.incrementAndGet();

    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("queueSize");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#stop()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.stop()"})
  public void testStop() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(id), "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.stop();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#stop()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.stop()"})
  public void testStop2() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(id), "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, new BaseEntityService(), null);

    // Act
    cassandraBufferedRateReadExecutor.stop();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#create()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateReadExecutor.create()"
  })
  public void testCreate() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(id), "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#create()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateReadExecutor.create()"
  })
  public void testCreate2() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(id), "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1,
            1,
            1L,
            1,
            1,
            1L,
            true,
            Integer.MIN_VALUE,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#create()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateReadExecutor.create()"
  })
  public void testCreate3() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(id), "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, new BaseEntityService(), null);

    // Act
    cassandraBufferedRateReadExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#create()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateReadExecutor.create()"
  })
  public void testCreate4() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    StatsCounter statsCounter = new StatsCounter(new AtomicInteger(), null, "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 0, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#create()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateReadExecutor.create()"
  })
  public void testCreate5() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    StatsCounter statsCounter = new StatsCounter(new AtomicInteger(), null, "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 0, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#create()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateReadExecutor.create()"
  })
  public void testCreate6() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(null);
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(id), "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, new BaseEntityService(), null);

    // Act
    cassandraBufferedRateReadExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#create()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateReadExecutor.create()"
  })
  public void testCreate7() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger();
    CumulativeCounter micrometerCounter = new CumulativeCounter(mock(Id.class));

    StatsCounter statsCounter = new StatsCounter(aiCounter, micrometerCounter, "Name");
    statsCounter.increment();

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(null);
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 0, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#create()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one.
   *   <li>Then calls {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateReadExecutor.create()"
  })
  public void testCreate_givenAtomicIntegerAddAndGetOne_thenCallsCreateGauge() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    StatsCounter statsCounter = new StatsCounter(new AtomicInteger(), null, "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 0, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#create()}.
   *
   * <ul>
   *   <li>Given {@link CumulativeCounter#CumulativeCounter(Id)} with id is {@link
   *       Meter.Id#Id(String, Tags, String, String, Type)}.
   *   <li>Then calls {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateReadExecutor.create()"
  })
  public void testCreate_givenCumulativeCounterWithIdIsId_thenCallsCreateGauge() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(id), "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 0, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#create()}.
   *
   * <ul>
   *   <li>Given {@link CumulativeCounter#CumulativeCounter(Id)} with {@link Meter.Id}.
   *   <li>Then calls {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateReadExecutor.create()"
  })
  public void testCreate_givenCumulativeCounterWithId_thenCallsCreateGauge() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    AtomicInteger aiCounter = new AtomicInteger();
    CumulativeCounter micrometerCounter = new CumulativeCounter(mock(Id.class));

    StatsCounter statsCounter = new StatsCounter(aiCounter, micrometerCounter, "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 0, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#create()}.
   *
   * <ul>
   *   <li>Given {@link DefaultStatsFactory} {@link DefaultStatsFactory#createGauge(String, Number,
   *       String[])} return {@code null}.
   *   <li>Then calls {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateReadExecutor.create()"
  })
  public void testCreate_givenDefaultStatsFactoryCreateGaugeReturnNull_thenCallsCreateGauge() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(null);
    AtomicInteger aiCounter = new AtomicInteger();
    CumulativeCounter micrometerCounter = new CumulativeCounter(mock(Id.class));

    StatsCounter statsCounter = new StatsCounter(aiCounter, micrometerCounter, "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 0, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#create()}.
   *
   * <ul>
   *   <li>Given {@link NoopCounter#NoopCounter(Id)} with id is {@link Meter.Id#Id(String, Tags,
   *       String, String, Type)}.
   *   <li>Then calls {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateReadExecutor.create()"
  })
  public void testCreate_givenNoopCounterWithIdIsId_thenCallsCreateGauge() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter statsCounter = new StatsCounter(aiCounter, new NoopCounter(id), "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 0, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#create()}.
   *
   * <ul>
   *   <li>Given {@link NoopCounter#NoopCounter(Id)} with {@link Meter.Id}.
   *   <li>Then calls {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateReadExecutor.create()"
  })
  public void testCreate_givenNoopCounterWithId_thenCallsCreateGauge() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    AtomicInteger aiCounter = new AtomicInteger();
    NoopCounter micrometerCounter = new NoopCounter(mock(Id.class));

    StatsCounter statsCounter = new StatsCounter(aiCounter, micrometerCounter, "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 0, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }
}
