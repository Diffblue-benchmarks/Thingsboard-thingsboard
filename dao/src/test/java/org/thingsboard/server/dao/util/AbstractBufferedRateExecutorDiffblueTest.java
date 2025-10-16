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
package org.thingsboard.server.dao.util;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
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
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.nosql.CassandraBufferedRateReadExecutor;

public class AbstractBufferedRateExecutorDiffblueTest {
  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize() {
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
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize2() {
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
            1, -1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize3() {
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
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize4() {
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
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize5() {
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
            Type.DISTRIBUTION_SUMMARY);
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
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize6() {
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
            1, -1, -1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize7() {
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
            1, -1, 1L, 1, 1, -1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize8() {
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
            -1,
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
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize9() {
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
            1, -1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize10() {
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
            Type.LONG_TASK_TIMER);
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
            1, -1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize11() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(null);
    StatsCounter statsCounter =
        new StatsCounter(new AtomicInteger(), mock(NoopCounter.class), "Name");
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
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize12() {
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
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize13() {
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
            1, 1, 1L, 1, 1, 2L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize14() {
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
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 1);

    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize15() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger());
    StatsCounter statsCounter = new StatsCounter(new AtomicInteger(), null, "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    CassandraBufferedRateReadExecutor cassandraBufferedRateReadExecutor =
        new CassandraBufferedRateReadExecutor(
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, new BaseEntityService(), null);

    // Act
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize16() {
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
            Type.DISTRIBUTION_SUMMARY);
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
            2, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize17() {
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
            Type.DISTRIBUTION_SUMMARY);
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
            1, 1, -2147483648L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize18() {
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
            Type.DISTRIBUTION_SUMMARY);
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
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger()} incrementAndGet.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize_givenAtomicIntegerIncrementAndGet_thenReturnZero() {
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
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <ul>
   *   <li>Given {@link CumulativeCounter#CumulativeCounter(Id)} with id is {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize_givenCumulativeCounterWithIdIsNull_thenReturnZero() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(null);
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
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <ul>
   *   <li>Given {@link DefaultStatsFactory} {@link DefaultStatsFactory#createGauge(String, Number,
   *       String[])} return {@link AtomicInteger#AtomicInteger(int)} with one.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize_givenDefaultStatsFactoryCreateGaugeReturnAtomicIntegerWithOne() {
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
            1, -1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   *
   * <ul>
   *   <li>Given {@link DefaultStatsFactory} {@link DefaultStatsFactory#createGauge(String, Number,
   *       String[])} return {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractBufferedRateExecutor.getQueueSize()"})
  public void testGetQueueSize_givenDefaultStatsFactoryCreateGaugeReturnNull_thenReturnZero() {
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
            1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

    // Act
    int actualQueueSize = cassandraBufferedRateReadExecutor.getQueueSize();

    // Assert
    verify(statsFactory)
        .createGauge(
            eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }
}
