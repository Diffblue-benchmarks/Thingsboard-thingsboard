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
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.stats.DefaultCounter;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.common.stats.StatsFactory;
import org.thingsboard.server.dao.model.ModelConstants;

public class BufferedRateExecutorStatsDiffblueTest {
  /**
   * Test
   * {@link BufferedRateExecutorStats#BufferedRateExecutorStats(StatsFactory)}.
   * <ul>
   *   <li>Then return StatsCounters size is seven.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BufferedRateExecutorStats#BufferedRateExecutorStats(StatsFactory)}
   */
  @Test
  public void testNewBufferedRateExecutorStats_thenReturnStatsCountersSizeIsSeven() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(),
        "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);

    // Act
    BufferedRateExecutorStats actualBufferedRateExecutorStats = new BufferedRateExecutorStats(statsFactory);

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    List<StatsCounter> statsCounters = actualBufferedRateExecutorStats.getStatsCounters();
    assertEquals(7, statsCounters.size());
    assertTrue(actualBufferedRateExecutorStats.getRateLimitedTenants().isEmpty());
    assertSame(statsCounter, statsCounters.get(0));
    assertSame(statsCounter, statsCounters.get(1));
    assertSame(statsCounter, statsCounters.get(2));
    assertSame(statsCounter, statsCounters.get(4));
    assertSame(statsCounter, statsCounters.get(5));
    assertSame(statsCounter, statsCounters.get(6));
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
   * <p>
   * Method under test:
   * {@link BufferedRateExecutorStats#incrementRateLimitedTenant(TenantId)}
   */
  @Test
  public void testIncrementRateLimitedTenant() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    AtomicInteger aiCounter2 = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter2, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    BufferedRateExecutorStats bufferedRateExecutorStats = new BufferedRateExecutorStats(statsFactory);

    // Act
    bufferedRateExecutorStats.incrementRateLimitedTenant(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(statsFactory).createDefaultCounter(eq("rateExecutor.tenant"), isA(String[].class));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(1, bufferedRateExecutorStats.getRateLimitedTenants().size());
  }

  /**
   * Test {@link BufferedRateExecutorStats#incrementRateLimitedTenant(TenantId)}.
   * <p>
   * Method under test:
   * {@link BufferedRateExecutorStats#incrementRateLimitedTenant(TenantId)}
   */
  @Test
  public void testIncrementRateLimitedTenant2() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    AtomicInteger aiCounter2 = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter2, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));

    BufferedRateExecutorStats bufferedRateExecutorStats = new BufferedRateExecutorStats(statsFactory);
    bufferedRateExecutorStats.incrementRateLimitedTenant(ModelConstants.SYSTEM_TENANT);

    // Act
    bufferedRateExecutorStats.incrementRateLimitedTenant(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(statsFactory).createDefaultCounter(eq("rateExecutor.tenant"), isA(String[].class));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(1, bufferedRateExecutorStats.getRateLimitedTenants().size());
  }
}
