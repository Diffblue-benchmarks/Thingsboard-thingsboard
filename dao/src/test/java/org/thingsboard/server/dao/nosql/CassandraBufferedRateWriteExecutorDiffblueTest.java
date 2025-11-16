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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, -1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, -2147483648L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, 1L, 1, 42, 1L, true, 1, statsFactory, entityService, rateLimitService);

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
        .thenReturn(new AtomicInteger(42));
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(id), "Write");
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
  public void testCreate6() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(42));
    AtomicInteger aiCounter = new AtomicInteger();
    Id id = new Id("Name", Tags.empty(), "Base Unit", "Failed to queue task:", Type.COUNTER);
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
            1, 1, -1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

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
        .thenReturn(new AtomicInteger(42));
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, -1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

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
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, -1L, 1, 1, 1L, true, 1, statsFactory, null, rateLimitService);

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
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, -1L, 1, 1, Long.MAX_VALUE, true, 1, statsFactory, null, rateLimitService);

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
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, -1L, 1, 1, Long.MIN_VALUE, true, 1, statsFactory, null, rateLimitService);

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
  public void testCreate11() {
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
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 42, -1L, 1, 1, Long.MAX_VALUE, true, 1, statsFactory, null, rateLimitService);

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
  public void testCreate12() {
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            42, 1, -2147483648L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

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
  public void testCreate13() {
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            42, 43, -2147483648L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

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
  public void testCreate14() {
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            42, 1, -2147483648L, 1, 1, 42L, true, 1, statsFactory, entityService, rateLimitService);

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
  public void testCreate15() {
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            42,
            1,
            -2147483648L,
            1,
            1,
            Long.MIN_VALUE,
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
  public void testCreate16() {
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, -2147483648L, 42, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

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
  public void testCreate17() {
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

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, -1, -2147483648L, 42, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

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
   *       String[])} return {@link AtomicInteger#AtomicInteger()}.
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
  public void testCreate_givenDefaultStatsFactoryCreateGaugeReturnAtomicInteger() {
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
   * <ul>
   *   <li>Given {@link DefaultStatsFactory} {@link DefaultStatsFactory#createGauge(String, Number,
   *       String[])} return {@link AtomicInteger#AtomicInteger(int)} with minus one.
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
  public void testCreate_givenDefaultStatsFactoryCreateGaugeReturnAtomicIntegerWithMinusOne() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(
            Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(-1));
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
            1, 1, -1L, 1, 1, 1L, true, 1, statsFactory, entityService, rateLimitService);

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
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    CassandraBufferedRateWriteExecutor cassandraBufferedRateWriteExecutor =
        new CassandraBufferedRateWriteExecutor(
            1, 1, -1L, 1, 1, Long.MAX_VALUE, true, 1, statsFactory, null, rateLimitService);

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
