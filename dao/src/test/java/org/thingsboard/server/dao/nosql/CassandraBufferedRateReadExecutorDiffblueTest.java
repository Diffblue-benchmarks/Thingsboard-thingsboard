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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            2, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
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
  public void testPrintStats4() {
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 2, 1L, 1, 1, 1L, true, 2, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
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
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.
   *   <li>Then calls {@link DefaultStatsFactory#createGauge(String, Number, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
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
   *   <li>Given {@link DefaultStatsFactory} {@link DefaultStatsFactory#createGauge(String, Number,
   *       String[])} return {@link AtomicInteger#AtomicInteger()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
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
   *   <li>Given {@link DefaultStatsFactory} {@link DefaultStatsFactory#createGauge(String, Number,
   *       String[])} return {@link AtomicInteger#AtomicInteger(int)} with two.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenDefaultStatsFactoryCreateGaugeReturnAtomicIntegerWithTwo() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(1);

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(2));
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 2, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
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
   *   <li>Given {@link StatsCounter} {@link StatsCounter#getName()} return {@code ]}.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenStatsCounterGetNameReturnRightSquareBracket_thenCallsClear() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("] ");
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 2, 1L, 1, 1, 1L, true, 2, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory)
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
   *   <li>Given {@link StatsCounter} {@link StatsCounter#get()} return three.
   *   <li>Then calls {@link StatsCounter#clear()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CassandraBufferedRateReadExecutor.printStats()"})
  public void testPrintStats_givenStatsCounterGetReturnThree_thenCallsClear() {
    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    when(statsCounter.get()).thenReturn(3);

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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            2, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    cassandraBufferedRateReadExecutor.printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
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
            "42",
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
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(id), "");
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, Long.MIN_VALUE, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

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
            1, 0, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

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
    BaseEntityService entityService = new BaseEntityService();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, Long.MAX_VALUE, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

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
            1, 1, 1L, 1, 1, Long.MAX_VALUE, true, 1, statsFactory, entityService, rateLimitService);

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

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 2, Long.MAX_VALUE, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

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
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);

    CumulativeCounter micrometerCounter = new CumulativeCounter(id);
    micrometerCounter.increment(-0.5d);
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

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, Long.MAX_VALUE, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

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
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);

    CumulativeCounter micrometerCounter = new CumulativeCounter(id);
    micrometerCounter.increment(-0.5d);
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

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1,
            -1,
            Long.MAX_VALUE,
            1,
            1,
            1L,
            true,
            1,
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
  public void testCreate8() {
    // Arrange
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);

    CumulativeCounter micrometerCounter = new CumulativeCounter(id);
    micrometerCounter.increment(-0.5d);
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

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1,
            -1,
            Long.MAX_VALUE,
            1,
            1,
            0L,
            true,
            1,
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
  public void testCreate9() {
    // Arrange
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);

    CumulativeCounter micrometerCounter = new CumulativeCounter(id);
    micrometerCounter.increment(-0.5d);
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

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1,
            -1,
            Long.MAX_VALUE,
            1,
            1,
            Long.MAX_VALUE,
            true,
            1,
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
  public void testCreate10() {
    // Arrange
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);

    CumulativeCounter micrometerCounter = new CumulativeCounter(id);
    micrometerCounter.increment(-0.5d);
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

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, Long.MAX_VALUE, 1, 1, 0L, true, 1, statsFactory, entityService, rateLimitService);

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
  public void testCreate11() {
    // Arrange
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);

    CumulativeCounter micrometerCounter = new CumulativeCounter(id);
    micrometerCounter.increment(-0.5d);
    StatsCounter statsCounter = new StatsCounter(new AtomicInteger(), micrometerCounter, "Name");

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
            1,
            -1,
            Long.MAX_VALUE,
            1,
            1,
            0L,
            true,
            1,
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
  public void testCreate12() {
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
            1, 1, 2L, 1, 1, Long.MAX_VALUE, true, 1, statsFactory, entityService, rateLimitService);

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
  public void testCreate13() {
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
            1, 1, 1L, 1, 2, Long.MAX_VALUE, true, 1, statsFactory, entityService, rateLimitService);

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
  public void testCreate14() {
    // Arrange
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);

    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(id), "Name");
    statsCounter.add(2);

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
            1, 1, 1L, 1, 1, Long.MAX_VALUE, true, 1, statsFactory, entityService, rateLimitService);

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
  public void testCreate15() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    AtomicInteger aiCounter = new AtomicInteger();
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");
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
  public void testCreate16() {
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

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1,
            -1,
            Long.MAX_VALUE,
            1,
            1,
            1L,
            true,
            1,
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
  public void testCreate17() {
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

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, -1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

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
   *   <li>Given {@link AtomicInteger#AtomicInteger()} incrementAndGet.
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
  public void testCreate_givenAtomicIntegerIncrementAndGet_thenCallsCreateGauge() {
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

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, Long.MAX_VALUE, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

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
   *   <li>Given {@link CumulativeCounter#CumulativeCounter(Id)} with id is {@code null}.
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
  public void testCreate_givenCumulativeCounterWithIdIsNull_thenCallsCreateGauge() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    AtomicInteger aiCounter = new AtomicInteger();
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(null), "Name");
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
   * <ul>
   *   <li>Given {@link DefaultStatsFactory} {@link DefaultStatsFactory#createGauge(String, Number,
   *       String[])} return {@link AtomicInteger#AtomicInteger(int)} with one.
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
  public void testCreate_givenDefaultStatsFactoryCreateGaugeReturnAtomicIntegerWithOne() {
    // Arrange
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);

    CumulativeCounter micrometerCounter = new CumulativeCounter(id);
    micrometerCounter.increment(-0.5d);
    StatsCounter statsCounter = new StatsCounter(new AtomicInteger(), micrometerCounter, "Name");

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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1,
            -1,
            Long.MAX_VALUE,
            1,
            1,
            0L,
            true,
            1,
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
            1, 1, Long.MAX_VALUE, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

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
