package org.thingsboard.server.dao.nosql;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Meter.Id;
import io.micrometer.core.instrument.MockClock;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import io.micrometer.core.instrument.step.StepCounter;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultCounter;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.dao.entity.BaseEntityService;

public class CassandraBufferedRateReadExecutorDiffblueTest {
  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   * <p>
   * Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  public void testPrintStats() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.get()).thenReturn(1);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(1));
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();

    // Act
    (new CassandraBufferedRateReadExecutor(1, 0, 1L, 1, 1, 1L, true, 1, statsFactory, entityService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3)))
        .printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory).createGauge(eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   * <p>
   * Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  public void testPrintStats2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.get()).thenReturn(1);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(1));
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();

    // Act
    (new CassandraBufferedRateReadExecutor(1, 0, 1L, 1, 1, -1L, true, 1, statsFactory, entityService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3)))
        .printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory).createGauge(eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   * <p>
   * Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  public void testPrintStats3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.get()).thenReturn(1);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(1));
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();

    // Act
    (new CassandraBufferedRateReadExecutor(1, 0, 0L, 1, 1, -1L, true, 1, statsFactory, entityService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3)))
        .printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory).createGauge(eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.</li>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createGauge(String, Number, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  public void testPrintStats_givenAtomicIntegerWithOne_thenCallsCreateGauge() {
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
    (new CassandraBufferedRateReadExecutor(1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3)))
        .printStats();

    // Assert
    verify(statsFactory).createGauge(eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   * <ul>
   *   <li>Given {@link DefaultStatsFactory}
   * {@link DefaultStatsFactory#createGauge(String, Number, String[])} return
   * {@link AtomicInteger#AtomicInteger(int)} with zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  public void testPrintStats_givenDefaultStatsFactoryCreateGaugeReturnAtomicIntegerWithZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(0));
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    BaseEntityService entityService = new BaseEntityService();

    // Act
    (new CassandraBufferedRateReadExecutor(1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3)))
        .printStats();

    // Assert
    verify(statsFactory).createGauge(eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   * <ul>
   *   <li>Given {@link DefaultStatsFactory}
   * {@link DefaultStatsFactory#createGauge(String, Number, String[])} return
   * {@link AtomicInteger#AtomicInteger(int)} with zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  public void testPrintStats_givenDefaultStatsFactoryCreateGaugeReturnAtomicIntegerWithZero2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.get()).thenReturn(1);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(0));
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();

    // Act
    (new CassandraBufferedRateReadExecutor(1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3)))
        .printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory).createGauge(eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   * <ul>
   *   <li>Given {@link StatsCounter} {@link DefaultCounter#get()} return one.</li>
   *   <li>Then calls {@link DefaultCounter#clear()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  public void testPrintStats_givenStatsCounterGetReturnOne_thenCallsClear() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.get()).thenReturn(1);
    when(statsCounter.getName()).thenReturn("Name");
    doNothing().when(statsCounter).clear();
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(1));
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();

    // Act
    (new CassandraBufferedRateReadExecutor(1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3)))
        .printStats();

    // Assert
    verify(statsCounter, atLeast(1)).clear();
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory).createGauge(eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
    verify(statsCounter, atLeast(1)).getName();
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#printStats()}.
   * <ul>
   *   <li>Given {@link StatsCounter} {@link DefaultCounter#get()} return zero.</li>
   *   <li>Then calls {@link DefaultCounter#get()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraBufferedRateReadExecutor#printStats()}
   */
  @Test
  public void testPrintStats_givenStatsCounterGetReturnZero_thenCallsGet() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatsCounter statsCounter = mock(StatsCounter.class);
    when(statsCounter.get()).thenReturn(0);
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(0));
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();

    // Act
    (new CassandraBufferedRateReadExecutor(1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3)))
        .printStats();

    // Assert that nothing has changed
    verify(statsCounter, atLeast(1)).get();
    verify(statsFactory).createGauge(eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#stop()}.
   * <p>
   * Method under test: {@link CassandraBufferedRateReadExecutor#stop()}
   */
  @Test
  public void testStop() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Meter.Id id = new Meter.Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something",
        Meter.Type.COUNTER);

    StepCounter micrometerCounter = new StepCounter(id, new MockClock(), 1L);
    micrometerCounter.increment();
    StatsCounter statsCounter = new StatsCounter(new AtomicInteger(1), micrometerCounter, "Name");

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(1));
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);

    // Act
    (new CassandraBufferedRateReadExecutor(1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, null,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3)))
        .stop();

    // Assert that nothing has changed
    verify(statsFactory).createGauge(eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#stop()}.
   * <ul>
   *   <li>Given {@link CumulativeCounter#CumulativeCounter(Id)} with id is
   * {@link Id#Id(String, Tags, String, String, Type)}.</li>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createGauge(String, Number, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraBufferedRateReadExecutor#stop()}
   */
  @Test
  public void testStop_givenCumulativeCounterWithIdIsId_thenCallsCreateGauge() {
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
    (new CassandraBufferedRateReadExecutor(1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3)))
        .stop();

    // Assert that nothing has changed
    verify(statsFactory).createGauge(eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#stop()}.
   * <ul>
   *   <li>Given {@link CumulativeCounter#CumulativeCounter(Id)} with id is
   * {@code null}.</li>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createGauge(String, Number, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraBufferedRateReadExecutor#stop()}
   */
  @Test
  public void testStop_givenCumulativeCounterWithIdIsNull_thenCallsCreateGauge() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(1));
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(null), "Name"));
    BaseEntityService entityService = new BaseEntityService();

    // Act
    (new CassandraBufferedRateReadExecutor(1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3)))
        .stop();

    // Assert that nothing has changed
    verify(statsFactory).createGauge(eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#stop()}.
   * <ul>
   *   <li>Given {@link CumulativeCounter#CumulativeCounter(Id)} with id is
   * {@code null}.</li>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createGauge(String, Number, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraBufferedRateReadExecutor#stop()}
   */
  @Test
  public void testStop_givenCumulativeCounterWithIdIsNull_thenCallsCreateGauge2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(1));
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(null), "Name"));

    // Act
    (new CassandraBufferedRateReadExecutor(1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, null,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3)))
        .stop();

    // Assert that nothing has changed
    verify(statsFactory).createGauge(eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#create()}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one one.</li>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createGauge(String, Number, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraBufferedRateReadExecutor#create()}
   */
  @Test
  public void testCreate_givenAtomicIntegerWithOneOne_thenCallsCreateGauge() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AtomicInteger aiCounter = new AtomicInteger(1);
    aiCounter.set(1);
    aiCounter.addAndGet(2);
    StatsCounter statsCounter = new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(),
        "Base Unit", "The characteristics of someone or something", Meter.Type.COUNTER)), "Name");

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    when(statsFactory.createGauge(Mockito.<String>any(), Mockito.<AtomicInteger>any(), isA(String[].class)))
        .thenReturn(new AtomicInteger(1));
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(statsCounter);
    BaseEntityService entityService = new BaseEntityService();

    // Act
    (new CassandraBufferedRateReadExecutor(1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3)))
        .create();

    // Assert
    verify(statsFactory).createGauge(eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test {@link CassandraBufferedRateReadExecutor#create()}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.</li>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createGauge(String, Number, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraBufferedRateReadExecutor#create()}
   */
  @Test
  public void testCreate_givenAtomicIntegerWithOne_thenCallsCreateGauge() {
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
    (new CassandraBufferedRateReadExecutor(1, 1, 1L, 1, 1, 1L, true, 1, statsFactory, entityService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3)))
        .create();

    // Assert
    verify(statsFactory).createGauge(eq("rateExecutor.currBufferRead"), isA(AtomicInteger.class), isA(String[].class));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("rateExecutor"), Mockito.<String>any(), isA(String[].class));
  }
}
