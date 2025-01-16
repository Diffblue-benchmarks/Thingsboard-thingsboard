package org.thingsboard.server.service.queue.processing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.common.util.ThingsBoardForkJoinWorkerThreadFactory;
import org.thingsboard.common.util.ThingsBoardThreadFactory;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.TbQueueConsumer;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.discovery.event.PartitionChangeEvent;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.memory.InMemoryTbQueueConsumer;
import org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;
import org.thingsboard.server.service.edge.EdgeContextComponent;
import org.thingsboard.server.service.queue.DefaultTbEdgeConsumerService;

class AbstractConsumerServiceDiffblueTest {
  /**
   * Test {@link AbstractConsumerService#init(String)}.
   * <p>
   * Method under test: {@link AbstractConsumerService#init(String)}
   */
  @Test
  @DisplayName("Test init(String)")
  void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    when(topicService.getEdgeNotificationsTopic(Mockito.<String>any())).thenReturn(buildResult);
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    InMemoryMonolithQueueFactory tbCoreQueueFactory = new InMemoryMonolithQueueFactory(topicService, coreSettings,
        ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings, transportNotificationSettings,
        edgeSettings, new DefaultInMemoryStorage());

    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    ActorSystemContext actorContext = new ActorSystemContext();
    DefaultTbEdgeConsumerService defaultTbEdgeConsumerService = new DefaultTbEdgeConsumerService(tbCoreQueueFactory,
        actorContext, statsFactory, new EdgeContextComponent());

    // Act
    defaultTbEdgeConsumerService.init("Prefix");

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("edge"), Mockito.<String>any(), isA(String[].class));
    verify(topicService).getEdgeNotificationsTopic(isNull());
    ExecutorService executorService = defaultTbEdgeConsumerService.mgmtExecutor;
    assertTrue(executorService instanceof ForkJoinPool);
    ExecutorService executorService2 = defaultTbEdgeConsumerService.consumersExecutor;
    assertTrue(executorService2 instanceof ThreadPoolExecutor);
    assertTrue(((ForkJoinPool) executorService).getFactory() instanceof ThingsBoardForkJoinWorkerThreadFactory);
    assertTrue(((ThreadPoolExecutor) executorService2).getThreadFactory() instanceof ThingsBoardThreadFactory);
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToEdgeNotificationMsg>> consumer = defaultTbEdgeConsumerService.nfConsumer
        .getConsumer();
    assertTrue(consumer instanceof InMemoryTbQueueConsumer);
    assertNull(((ForkJoinPool) executorService).getUncaughtExceptionHandler());
    assertEquals(0, ((ForkJoinPool) executorService).getActiveThreadCount());
    assertEquals(0, ((ForkJoinPool) executorService).getPoolSize());
    assertEquals(0, ((ForkJoinPool) executorService).getQueuedSubmissionCount());
    assertEquals(0, ((ForkJoinPool) executorService).getRunningThreadCount());
    assertEquals(0, ((ThreadPoolExecutor) executorService2).getActiveCount());
    assertEquals(0, ((ThreadPoolExecutor) executorService2).getCorePoolSize());
    assertEquals(0, ((ThreadPoolExecutor) executorService2).getLargestPoolSize());
    assertEquals(0, ((ThreadPoolExecutor) executorService2).getPoolSize());
    assertEquals(0L, ((ForkJoinPool) executorService).getQueuedTaskCount());
    assertEquals(0L, ((ForkJoinPool) executorService).getStealCount());
    assertEquals(0L, ((ThreadPoolExecutor) executorService2).getCompletedTaskCount());
    assertEquals(0L, ((ThreadPoolExecutor) executorService2).getTaskCount());
    assertEquals(20, ((ForkJoinPool) executorService).getParallelism());
    assertFalse(((ForkJoinPool) executorService).hasQueuedSubmissions());
    assertFalse(((ForkJoinPool) executorService).isTerminating());
    assertFalse(consumer.isStopped());
    assertTrue(((ThreadPoolExecutor) executorService2).getQueue().isEmpty());
    assertTrue(((ForkJoinPool) executorService).getAsyncMode());
    assertTrue(((ForkJoinPool) executorService).isQuiescent());
    assertEquals(Integer.MAX_VALUE, ((ThreadPoolExecutor) executorService2).getMaximumPoolSize());
  }

  /**
   * Test
   * {@link AbstractConsumerService#filterTbApplicationEvent(PartitionChangeEvent)}
   * with {@code PartitionChangeEvent}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractConsumerService#filterTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName("Test filterTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'; then return 'false'")
  void testFilterTbApplicationEventWithPartitionChangeEvent_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    TopicService topicService = mock(TopicService.class);
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    InMemoryMonolithQueueFactory tbCoreQueueFactory = new InMemoryMonolithQueueFactory(topicService, coreSettings,
        ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings, transportNotificationSettings,
        edgeSettings, new DefaultInMemoryStorage());

    ActorSystemContext actorContext = new ActorSystemContext();
    DefaultTbEdgeConsumerService defaultTbEdgeConsumerService = new DefaultTbEdgeConsumerService(tbCoreQueueFactory,
        actorContext, statsFactory, new EdgeContextComponent());

    // Act
    boolean actualFilterTbApplicationEventResult = defaultTbEdgeConsumerService
        .filterTbApplicationEvent(new PartitionChangeEvent("Source", ServiceType.TB_RULE_ENGINE, new HashMap<>()));

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("edge"), Mockito.<String>any(), isA(String[].class));
    assertFalse(actualFilterTbApplicationEventResult);
  }

  /**
   * Test
   * {@link AbstractConsumerService#filterTbApplicationEvent(PartitionChangeEvent)}
   * with {@code PartitionChangeEvent}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractConsumerService#filterTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName("Test filterTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'; then return 'true'")
  void testFilterTbApplicationEventWithPartitionChangeEvent_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    TopicService topicService = mock(TopicService.class);
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    InMemoryMonolithQueueFactory tbCoreQueueFactory = new InMemoryMonolithQueueFactory(topicService, coreSettings,
        ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings, transportNotificationSettings,
        edgeSettings, new DefaultInMemoryStorage());

    ActorSystemContext actorContext = new ActorSystemContext();
    DefaultTbEdgeConsumerService defaultTbEdgeConsumerService = new DefaultTbEdgeConsumerService(tbCoreQueueFactory,
        actorContext, statsFactory, new EdgeContextComponent());

    // Act
    boolean actualFilterTbApplicationEventResult = defaultTbEdgeConsumerService
        .filterTbApplicationEvent(new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>()));

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("edge"), Mockito.<String>any(), isA(String[].class));
    assertTrue(actualFilterTbApplicationEventResult);
  }
}
