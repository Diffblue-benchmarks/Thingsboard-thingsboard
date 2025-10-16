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
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.dao.entity.BaseEntityService;

public class CassandraBufferedRateWriteExecutorDiffblueTest {
  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats2() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(1));
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats3() {
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 1, Long.MAX_VALUE, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats5() {
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            Long.MAX_VALUE,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats6() {
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats7() {
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 1);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            Long.MAX_VALUE,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            Long.MIN_VALUE,
            1,
            1,
            Long.MAX_VALUE,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            2,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            0L,
            true,
            2,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats11() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);

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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            2,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 2, 3);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 2, 1L, 1, 1, -1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, -1, 1L, 1, 1, -1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 0, 1L, 1, 1, -1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -2147483648L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            2L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
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
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
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
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats20() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(1));
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats21() {
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats22() {
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats23() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats24() {
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats25() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats26() {
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats27() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats28() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats29() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats30() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.incrementAndGet();
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats31() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats32() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats33() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats34() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats35() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats36() {
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
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
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats37() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(1));
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 0, 1L, 1, 1, -1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats38() {
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 1, -2147483648L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@code -2147483641}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGet2147483641_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(-2147483641);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@code -2147483644}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGet2147483644_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(-2147483644);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@code -2147483644}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGet2147483644_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(-2147483644);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFive_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFive_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFive_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFive_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFive_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFive_thenCallsClear6() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFive_thenCallsClear7() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFive_thenCallsClear8() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFive_thenCallsClear9() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFive_thenCallsClear10() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFive_thenCallsClear11() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFive_thenCallsClear12() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFive_thenCallsClear13() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFive_thenCallsClear14() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFive_thenCallsClear15() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFive_thenCallsClear16() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFour_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(4);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetFour_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(4);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear6() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear7() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear8() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear9() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear10() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear11() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear12() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear13() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear14() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear15() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear16() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear17() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear18() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear19() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear20() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear21() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear22() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear23() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear24() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear25() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear26() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear27() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear28() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear29() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear30() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear31() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear32() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear33() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear34() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear35() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear36() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear37() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMin_value_thenCallsClear38() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(-1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(-1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(-1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(-1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(-1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear6() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
    atomicInteger.addAndGet(-1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear7() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(-1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear8() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear9() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(-1);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear10() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(-1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerAddAndGetMinusOne_thenCallsClear11() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(-1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerIncrementAndGet_thenCallsClear() {
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerIncrementAndGet_thenCallsClear2() {
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerIncrementAndGet_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerIncrementAndGet_thenCallsClear4() {
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerIncrementAndGet_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerIncrementAndGet_thenCallsClear6() {
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerIncrementAndGet_thenCallsClear7() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerIncrementAndGet_thenCallsClear8() {
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerIncrementAndGet_thenCallsClear9() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerIncrementAndGet_thenCallsClear10() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.addAndGet(2);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMin_value_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMin_value_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMin_value_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMin_value_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMin_value_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMin_value_thenCallsClear6() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMin_value_thenCallsClear7() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMin_value_thenCallsClear8() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMin_value_thenCallsClear9() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMin_value_thenCallsClear10() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMin_value_thenCallsClear11() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMin_value_thenCallsClear12() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMin_value_thenCallsClear13() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMin_value_thenCallsClear14() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMin_value_thenCallsClear15() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMin_value_thenCallsClear16() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMin_value_thenCallsClear17() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} {@link Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMin_value_thenCallsClear18() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMinusOne_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(-1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMinusOne_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(-1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMinusOne_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(-1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMinusOne_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(-1);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerMinusOne_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(-1);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(-1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} six.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerSix_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(6);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetFive_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetFive_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetFive_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetFive_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet five.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetFive_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(5);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet four.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetFour_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(4);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear6() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear7() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear8() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear9() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear10() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear11() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear12() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear13() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear14() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear15() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear16() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear17() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear18() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear19() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear20() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear21() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMin_value_thenCallsClear22() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(2);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMinusOne_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(Integer.MIN_VALUE);
    atomicInteger.addAndGet(-1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet minus one.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetMinusOne_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(1);
    atomicInteger.addAndGet(-1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one addAndGet two.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneAddAndGetTwo_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneIncrementAndGet_thenCallsClear() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneIncrementAndGet_thenCallsClear2() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneIncrementAndGet_thenCallsClear3() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneIncrementAndGet_thenCallsClear4() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneIncrementAndGet_thenCallsClear5() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneIncrementAndGet_thenCallsClear6() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneIncrementAndGet_thenCallsClear7() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.incrementAndGet();
    atomicInteger.incrementAndGet();
    atomicInteger.addAndGet(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneIncrementAndGet_thenCallsClear8() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one incrementAndGet.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOneIncrementAndGet_thenCallsClear9() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger(1);
    atomicInteger.incrementAndGet();
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.
   *   <li>Then calls {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenAtomicIntegerWithOne_thenCallsCreateGauge() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    AtomicInteger aiCounter = new AtomicInteger(1);
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link DefaultStatsFactory} {@link DefaultStatsFactory#createGauge(String, Number,
   *       String[])} return {@link AtomicInteger#AtomicInteger()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
  public void testPrintStats_givenDefaultStatsFactoryCreateGaugeReturnAtomicInteger() {
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 0);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#printStats()}.
   *
   * <ul>
   *   <li>Given {@link StatsCounter} {@link StatsCounter#getName()} return {@code 42}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.printStats()"})
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            Long.MAX_VALUE,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#stop()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.stop()"})
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.stop();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#stop()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.stop()"})
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
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.stop();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#stop()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.stop()"})
  public void testStop3() {
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 1, Long.MAX_VALUE, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.stop();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#stop()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.stop()"})
  public void testStop4() {
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 0, 3);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.stop();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#stop()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.stop()"})
  public void testStop5() {
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            0L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.stop();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#stop()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.stop()"})
  public void testStop6() {
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -2147483648L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.stop();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#stop()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.stop()"})
  public void testStop7() {
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, -1, 1L, 1, 1, -2147483648L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.stop();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#stop()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.stop()"})
  public void testStop8() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    StatsCounter statsCounter =
        new StatsCounter(new AtomicInteger(), mock(CumulativeCounter.class), "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            0L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.stop();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#stop()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} incrementAndGet.
   *   <li>Then calls {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.stop()"})
  public void testStop_givenAtomicIntegerIncrementAndGet_thenCallsCreateGauge() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.incrementAndGet();

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, -1, 1L, 1, 1, -2147483648L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.stop();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#stop()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.
   *   <li>Then calls {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.stop()"})
  public void testStop_givenAtomicIntegerWithOne_thenCallsCreateGauge() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(1));
    AtomicInteger aiCounter = new AtomicInteger(1);
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            0L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.stop();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#stop()}.
   *
   * <ul>
   *   <li>Given {@link CumulativeCounter#CumulativeCounter(Id)} with id is {@link
   *       Meter.Id#Id(String, Tags, String, String, Type)} increment.
   *   <li>Then calls {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.stop()"})
  public void testStop_givenCumulativeCounterWithIdIsIdIncrement_thenCallsCreateGauge() {
    // Arrange
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);

    CumulativeCounter micrometerCounter = new CumulativeCounter(id);
    micrometerCounter.increment();
    StatsCounter statsCounter = new StatsCounter(new AtomicInteger(), micrometerCounter, "Name");

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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -2147483648L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.stop();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#stop()}.
   *
   * <ul>
   *   <li>Given {@link DefaultStatsFactory} {@link DefaultStatsFactory#createGauge(String, Number,
   *       String[])} return {@link AtomicInteger#AtomicInteger(int)} with one.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateWriteExecutor.stop()"})
  public void testStop_givenDefaultStatsFactoryCreateGaugeReturnAtomicIntegerWithOne() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(1));
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            0L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.stop();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#create()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateWriteExecutor.create()"
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#create()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateWriteExecutor.create()"
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#create()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateWriteExecutor.create()"
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
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#create()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateWriteExecutor.create()"
  })
  public void testCreate4() {
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 1, 1L, true, 0, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#create()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateWriteExecutor.create()"
  })
  public void testCreate5() {
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
    BaseEntityService entityService = mock(BaseEntityService.class);
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#create()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateWriteExecutor.create()"
  })
  public void testCreate6() {
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            0L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#create()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateWriteExecutor.create()"
  })
  public void testCreate7() {
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            -1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#create()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateWriteExecutor.create()"
  })
  public void testCreate8() {
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 0, 1L, 1, 1, 1L, true, 0, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#create()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateWriteExecutor.create()"
  })
  public void testCreate9() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(id), "42");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#create()}.
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateWriteExecutor.create()"
  })
  public void testCreate10() {
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 0, 3);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#create()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} addAndGet two.
   *   <li>Then calls {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateWriteExecutor.create()"
  })
  public void testCreate_givenAtomicIntegerAddAndGetTwo_thenCallsCreateGauge() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger();
    aiCounter.addAndGet(2);
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#create()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} one.
   *   <li>Then calls {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateWriteExecutor.create()"
  })
  public void testCreate_givenAtomicIntegerOne_thenCallsCreateGauge() {
    // Arrange
    AtomicInteger atomicInteger = new AtomicInteger();
    atomicInteger.set(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(atomicInteger);
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#create()}.
   *
   * <ul>
   *   <li>Given {@link DefaultStatsFactory} {@link DefaultStatsFactory#createGauge(String, Number,
   *       String[])} return {@code null}.
   *   <li>Then calls {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateWriteExecutor.create()"
  })
  public void testCreate_givenDefaultStatsFactoryCreateGaugeReturnNull_thenCallsCreateGauge() {
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
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateWriteExecutor#create()}.
   *
   * <ul>
   *   <li>Given {@link DefaultStatsFactory} {@link DefaultStatsFactory#createStatsCounter(String,
   *       String, String[])} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateWriteExecutor#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.SettableFuture CassandraBufferedRateWriteExecutor.create()"
  })
  public void testCreate_givenDefaultStatsFactoryCreateStatsCounterReturnNull() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(null);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1,
            Integer.MIN_VALUE,
            1L,
            1,
            1,
            1L,
            true,
            1,
            statsFactory,
            entityService,
            rateLimitService);

    // Act
    cassandraBufferedRateWriteExecutor.create();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferWrite"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }
}
