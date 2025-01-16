package org.thingsboard.server.dao.util;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
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
   * <p>
   * Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  public void testGetQueueSize() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(1));
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    BaseEntityService entityService = new BaseEntityService();

    // Act
    int actualQueueSize = (new CassandraBufferedRateReadExecutor(1, 1, 1L, 1, 1, 1L, true, 1, statsFactory,
        entityService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3)))
        .getQueueSize();

    // Assert
    verify(statsFactory).createGauge(eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }

  /**
   * Test {@link AbstractBufferedRateExecutor#getQueueSize()}.
   * <p>
   * Method under test: {@link AbstractBufferedRateExecutor#getQueueSize()}
   */
  @Test
  public void testGetQueueSize2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(1));
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    BaseEntityService entityService = new BaseEntityService();

    // Act
    int actualQueueSize = (new CassandraBufferedRateReadExecutor(1, 1, 1L, 1, 1, 1L, true, -1, statsFactory,
        entityService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3)))
        .getQueueSize();

    // Assert
    verify(statsFactory).createGauge(eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0, actualQueueSize);
  }
}
