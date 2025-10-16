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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
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
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.stats.DefaultCounter;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.common.stats.StatsFactory;
import org.thingsboard.server.dao.model.ModelConstants;

public class BufferedRateExecutorStatsDiffblueTest {
  /**
   * Test {@link BufferedRateExecutorStats#BufferedRateExecutorStats(StatsFactory)}.
   *
   * <ul>
   *   <li>Then return StatsCounters size is seven.
   * </ul>
   *
   * <p>Method under test: {@link BufferedRateExecutorStats#BufferedRateExecutorStats(StatsFactory)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BufferedRateExecutorStats.<init>(StatsFactory)"})
  public void testNewBufferedRateExecutorStats_thenReturnStatsCountersSizeIsSeven() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
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

    // Act
    BufferedRateExecutorStats actualBufferedRateExecutorStats =
        new BufferedRateExecutorStats(statsFactory);

    // Assert
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(7, actualBufferedRateExecutorStats.getStatsCounters().size());
    assertTrue(actualBufferedRateExecutorStats.getRateLimitedTenants().isEmpty());
    assertSame(statsCounter, actualBufferedRateExecutorStats.getTotalAdded());
    assertSame(statsCounter, actualBufferedRateExecutorStats.getTotalExpired());
    assertSame(statsCounter, actualBufferedRateExecutorStats.getTotalFailed());
    assertSame(statsCounter, actualBufferedRateExecutorStats.getTotalLaunched());
    assertSame(statsCounter, actualBufferedRateExecutorStats.getTotalRateLimited());
    assertSame(statsCounter, actualBufferedRateExecutorStats.getTotalRejected());
    assertSame(statsCounter, actualBufferedRateExecutorStats.getTotalReleased());
    assertSame(statsFactory, actualBufferedRateExecutorStats.getStatsFactory());
  }

  /**
   * Test {@link BufferedRateExecutorStats#incrementRateLimitedTenant(TenantId)}.
   *
   * <p>Method under test: {@link BufferedRateExecutorStats#incrementRateLimitedTenant(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BufferedRateExecutorStats.incrementRateLimitedTenant(TenantId)"})
  public void testIncrementRateLimitedTenant() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    DefaultCounter defaultCounter = new DefaultCounter(aiCounter, new CumulativeCounter(id));
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(defaultCounter);
    AtomicInteger aiCounter2 = new AtomicInteger();
    Id id2 =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter statsCounter = new StatsCounter(aiCounter2, new CumulativeCounter(id2), "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BufferedRateExecutorStats bufferedRateExecutorStats =
        new BufferedRateExecutorStats(statsFactory);

    // Act
    bufferedRateExecutorStats.incrementRateLimitedTenant(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(statsFactory).createDefaultCounter(eq("rateExecutor.tenant"), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(1, bufferedRateExecutorStats.getRateLimitedTenants().size());
  }

  /**
   * Test {@link BufferedRateExecutorStats#incrementRateLimitedTenant(TenantId)}.
   *
   * <p>Method under test: {@link BufferedRateExecutorStats#incrementRateLimitedTenant(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BufferedRateExecutorStats.incrementRateLimitedTenant(TenantId)"})
  public void testIncrementRateLimitedTenant2() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    DefaultCounter defaultCounter = new DefaultCounter(aiCounter, new CumulativeCounter(id));
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(defaultCounter);
    AtomicInteger aiCounter2 = new AtomicInteger();
    Id id2 =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    StatsCounter statsCounter = new StatsCounter(aiCounter2, new CumulativeCounter(id2), "Name");
    when(statsFactory.createStatsCounter(
            Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);

    BufferedRateExecutorStats bufferedRateExecutorStats =
        new BufferedRateExecutorStats(statsFactory);
    bufferedRateExecutorStats.incrementRateLimitedTenant(ModelConstants.SYSTEM_TENANT);

    // Act
    bufferedRateExecutorStats.incrementRateLimitedTenant(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(statsFactory).createDefaultCounter(eq("rateExecutor.tenant"), isA(String[].class));
    verify(statsFactory, atLeast(1))
        .createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(1, bufferedRateExecutorStats.getRateLimitedTenants().size());
  }
}
