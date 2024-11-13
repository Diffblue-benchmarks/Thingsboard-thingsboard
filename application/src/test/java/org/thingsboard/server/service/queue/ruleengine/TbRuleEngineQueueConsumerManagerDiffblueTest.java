package org.thingsboard.server.service.queue.ruleengine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.common.stats.StatsFactory;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.QueueKey;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;

class TbRuleEngineQueueConsumerManagerDiffblueTest {
  /**
   * Test
   * {@link TbRuleEngineQueueConsumerManager#TbRuleEngineQueueConsumerManager(TbRuleEngineConsumerContext, QueueKey, ExecutorService, ScheduledExecutorService, ExecutorService)}.
   * <p>
   * Method under test:
   * {@link TbRuleEngineQueueConsumerManager#TbRuleEngineQueueConsumerManager(TbRuleEngineConsumerContext, QueueKey, ExecutorService, ScheduledExecutorService, ExecutorService)}
   */
  @Test
  @DisplayName("Test new TbRuleEngineQueueConsumerManager(TbRuleEngineConsumerContext, QueueKey, ExecutorService, ScheduledExecutorService, ExecutorService)")
  void testNewTbRuleEngineQueueConsumerManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatsFactory statsFactory = mock(StatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    TbRuleEngineConsumerContext ctx = mock(TbRuleEngineConsumerContext.class);
    when(ctx.getStatsFactory()).thenReturn(statsFactory);
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    when(ctx.getQueueFactory()).thenReturn(new InMemoryMonolithQueueFactory(topicService, coreSettings,
        ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings, transportNotificationSettings,
        edgeSettings, new DefaultInMemoryStorage()));
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);
    DefaultEventLoop consumerExecutor = new DefaultEventLoop();
    DefaultEventLoop scheduler = new DefaultEventLoop();

    // Act
    TbRuleEngineQueueConsumerManager actualTbRuleEngineQueueConsumerManager = new TbRuleEngineQueueConsumerManager(ctx,
        queueKey, consumerExecutor, scheduler, new DefaultEventLoop());

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("ruleEngine.Main"), Mockito.<String>any(),
        isA(String[].class));
    verify(ctx).getQueueFactory();
    verify(ctx).getStatsFactory();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", queueKey.getTenantId().getId().toString());
    assertNull(actualTbRuleEngineQueueConsumerManager.getPartitions());
    assertNull(actualTbRuleEngineQueueConsumerManager.getConfig());
  }

  /**
   * Test
   * {@link TbRuleEngineQueueConsumerManager#TbRuleEngineQueueConsumerManager(TbRuleEngineConsumerContext, QueueKey, ExecutorService, ScheduledExecutorService, ExecutorService)}.
   * <p>
   * Method under test:
   * {@link TbRuleEngineQueueConsumerManager#TbRuleEngineQueueConsumerManager(TbRuleEngineConsumerContext, QueueKey, ExecutorService, ScheduledExecutorService, ExecutorService)}
   */
  @Test
  @DisplayName("Test new TbRuleEngineQueueConsumerManager(TbRuleEngineConsumerContext, QueueKey, ExecutorService, ScheduledExecutorService, ExecutorService)")
  void testNewTbRuleEngineQueueConsumerManager2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatsFactory statsFactory = mock(StatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    TbRuleEngineConsumerContext ctx = mock(TbRuleEngineConsumerContext.class);
    when(ctx.getStatsFactory()).thenReturn(statsFactory);
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    when(ctx.getQueueFactory()).thenReturn(new InMemoryMonolithQueueFactory(topicService, coreSettings,
        ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings, transportNotificationSettings,
        edgeSettings, new DefaultInMemoryStorage()));
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE, new Queue());

    DefaultEventLoop consumerExecutor = new DefaultEventLoop();
    DefaultEventLoop scheduler = new DefaultEventLoop();

    // Act
    TbRuleEngineQueueConsumerManager actualTbRuleEngineQueueConsumerManager = new TbRuleEngineQueueConsumerManager(ctx,
        queueKey, consumerExecutor, scheduler, new DefaultEventLoop());

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("ruleEngine.null"), Mockito.<String>any(),
        isA(String[].class));
    verify(ctx).getQueueFactory();
    verify(ctx).getStatsFactory();
    assertNull(actualTbRuleEngineQueueConsumerManager.getPartitions());
    assertNull(actualTbRuleEngineQueueConsumerManager.getConfig());
  }

  /**
   * Test
   * {@link TbRuleEngineQueueConsumerManager#TbRuleEngineQueueConsumerManager(TbRuleEngineConsumerContext, QueueKey, ExecutorService, ScheduledExecutorService, ExecutorService)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineQueueConsumerManager#TbRuleEngineQueueConsumerManager(TbRuleEngineConsumerContext, QueueKey, ExecutorService, ScheduledExecutorService, ExecutorService)}
   */
  @Test
  @DisplayName("Test new TbRuleEngineQueueConsumerManager(TbRuleEngineConsumerContext, QueueKey, ExecutorService, ScheduledExecutorService, ExecutorService); when TenantId(UUID) with id is randomUUID")
  void testNewTbRuleEngineQueueConsumerManager_whenTenantIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatsFactory statsFactory = mock(StatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    TbRuleEngineConsumerContext ctx = mock(TbRuleEngineConsumerContext.class);
    when(ctx.getStatsFactory()).thenReturn(statsFactory);
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    when(ctx.getQueueFactory()).thenReturn(new InMemoryMonolithQueueFactory(topicService, coreSettings,
        ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings, transportNotificationSettings,
        edgeSettings, new DefaultInMemoryStorage()));
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE, new TenantId(UUID.randomUUID()));

    DefaultEventLoop consumerExecutor = new DefaultEventLoop();
    DefaultEventLoop scheduler = new DefaultEventLoop();

    // Act
    TbRuleEngineQueueConsumerManager actualTbRuleEngineQueueConsumerManager = new TbRuleEngineQueueConsumerManager(ctx,
        queueKey, consumerExecutor, scheduler, new DefaultEventLoop());

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("ruleEngine.Main"), Mockito.<String>any(),
        isA(String[].class));
    verify(ctx).getQueueFactory();
    verify(ctx).getStatsFactory();
    assertNull(actualTbRuleEngineQueueConsumerManager.getPartitions());
    assertNull(actualTbRuleEngineQueueConsumerManager.getConfig());
  }
}
