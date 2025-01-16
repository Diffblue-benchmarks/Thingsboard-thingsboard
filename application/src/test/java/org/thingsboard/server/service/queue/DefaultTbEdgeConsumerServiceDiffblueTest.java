package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.TbQueueConsumer;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
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
import org.thingsboard.server.service.queue.DefaultTbEdgeConsumerService.EdgeQueueConfig;

class DefaultTbEdgeConsumerServiceDiffblueTest {
  /**
   * Test EdgeQueueConfig {@link EdgeQueueConfig#equals(Object)}, and
   * {@link EdgeQueueConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultTbEdgeConsumerService.EdgeQueueConfig#equals(Object)}
   *   <li>{@link DefaultTbEdgeConsumerService.EdgeQueueConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test EdgeQueueConfig equals(Object), and hashCode(); when other is equal; then return equal")
  void testEdgeQueueConfigEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultTbEdgeConsumerService.EdgeQueueConfig ofResult = DefaultTbEdgeConsumerService.EdgeQueueConfig.of(true, 42);
    DefaultTbEdgeConsumerService.EdgeQueueConfig ofResult2 = DefaultTbEdgeConsumerService.EdgeQueueConfig.of(true, 42);

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Test EdgeQueueConfig {@link EdgeQueueConfig#equals(Object)}, and
   * {@link EdgeQueueConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultTbEdgeConsumerService.EdgeQueueConfig#equals(Object)}
   *   <li>{@link DefaultTbEdgeConsumerService.EdgeQueueConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test EdgeQueueConfig equals(Object), and hashCode(); when other is same; then return equal")
  void testEdgeQueueConfigEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultTbEdgeConsumerService.EdgeQueueConfig ofResult = DefaultTbEdgeConsumerService.EdgeQueueConfig.of(true, 42);

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Test EdgeQueueConfig {@link EdgeQueueConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbEdgeConsumerService.EdgeQueueConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test EdgeQueueConfig equals(Object); when other is different; then return not equal")
  void testEdgeQueueConfigEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultTbEdgeConsumerService.EdgeQueueConfig ofResult = DefaultTbEdgeConsumerService.EdgeQueueConfig.of(false, 42);

    // Act and Assert
    assertNotEquals(ofResult, DefaultTbEdgeConsumerService.EdgeQueueConfig.of(true, 42));
  }

  /**
   * Test EdgeQueueConfig {@link EdgeQueueConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbEdgeConsumerService.EdgeQueueConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test EdgeQueueConfig equals(Object); when other is different; then return not equal")
  void testEdgeQueueConfigEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultTbEdgeConsumerService.EdgeQueueConfig ofResult = DefaultTbEdgeConsumerService.EdgeQueueConfig.of(true, 1);

    // Act and Assert
    assertNotEquals(ofResult, DefaultTbEdgeConsumerService.EdgeQueueConfig.of(true, 42));
  }

  /**
   * Test EdgeQueueConfig {@link EdgeQueueConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbEdgeConsumerService.EdgeQueueConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test EdgeQueueConfig equals(Object); when other is 'null'; then return not equal")
  void testEdgeQueueConfigEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DefaultTbEdgeConsumerService.EdgeQueueConfig.of(true, 42), null);
  }

  /**
   * Test EdgeQueueConfig {@link EdgeQueueConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbEdgeConsumerService.EdgeQueueConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test EdgeQueueConfig equals(Object); when other is wrong type; then return not equal")
  void testEdgeQueueConfigEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DefaultTbEdgeConsumerService.EdgeQueueConfig.of(true, 42), "Different type to EdgeQueueConfig");
  }

  /**
   * Test EdgeQueueConfig getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultTbEdgeConsumerService.EdgeQueueConfig#toString()}
   *   <li>{@link DefaultTbEdgeConsumerService.EdgeQueueConfig#getPollInterval()}
   *   <li>
   * {@link DefaultTbEdgeConsumerService.EdgeQueueConfig#isConsumerPerPartition()}
   * </ul>
   */
  @Test
  @DisplayName("Test EdgeQueueConfig getters and setters")
  void testEdgeQueueConfigGettersAndSetters() {
    // Arrange
    DefaultTbEdgeConsumerService.EdgeQueueConfig ofResult = DefaultTbEdgeConsumerService.EdgeQueueConfig.of(true, 42);

    // Act
    String actualToStringResult = ofResult.toString();
    int actualPollInterval = ofResult.getPollInterval();

    // Assert
    assertEquals("DefaultTbEdgeConsumerService.EdgeQueueConfig(consumerPerPartition=true, pollInterval=42)",
        actualToStringResult);
    assertEquals(42, actualPollInterval);
    assertTrue(ofResult.isConsumerPerPartition());
  }

  /**
   * Test EdgeQueueConfig {@link EdgeQueueConfig#of(boolean, int)}.
   * <p>
   * Method under test:
   * {@link DefaultTbEdgeConsumerService.EdgeQueueConfig#of(boolean, int)}
   */
  @Test
  @DisplayName("Test EdgeQueueConfig of(boolean, int)")
  void testEdgeQueueConfigOf() {
    // Arrange and Act
    DefaultTbEdgeConsumerService.EdgeQueueConfig actualOfResult = DefaultTbEdgeConsumerService.EdgeQueueConfig.of(true,
        42);

    // Assert
    assertEquals(42, actualOfResult.getPollInterval());
    assertTrue(actualOfResult.isConsumerPerPartition());
  }

  /**
   * Test {@link DefaultTbEdgeConsumerService#init()}.
   * <ul>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbEdgeConsumerService#init()}
   */
  @Test
  @DisplayName("Test init(); then calls createStatsCounter(String, String, String[])")
  void testInit_thenCallsCreateStatsCounter() {
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

    // Act
    (new DefaultTbEdgeConsumerService(tbCoreQueueFactory, actorContext, statsFactory, new EdgeContextComponent()))
        .init();

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("edge"), Mockito.<String>any(), isA(String[].class));
    verify(topicService).getEdgeNotificationsTopic(isNull());
  }

  /**
   * Test {@link DefaultTbEdgeConsumerService#getNotificationPollDuration()}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbEdgeConsumerService#getNotificationPollDuration()}
   */
  @Test
  @DisplayName("Test getNotificationPollDuration(); given AtomicInteger(int) with one; then return zero")
  void testGetNotificationPollDuration_givenAtomicIntegerWithOne_thenReturnZero() {
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

    // Act
    long actualNotificationPollDuration = (new DefaultTbEdgeConsumerService(tbCoreQueueFactory, actorContext,
        statsFactory, new EdgeContextComponent())).getNotificationPollDuration();

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("edge"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0L, actualNotificationPollDuration);
  }

  /**
   * Test
   * {@link DefaultTbEdgeConsumerService#getNotificationPackProcessingTimeout()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbEdgeConsumerService#getNotificationPackProcessingTimeout()}
   */
  @Test
  @DisplayName("Test getNotificationPackProcessingTimeout(); then return zero")
  void testGetNotificationPackProcessingTimeout_thenReturnZero() {
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

    // Act
    long actualNotificationPackProcessingTimeout = (new DefaultTbEdgeConsumerService(tbCoreQueueFactory, actorContext,
        statsFactory, new EdgeContextComponent())).getNotificationPackProcessingTimeout();

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("edge"), Mockito.<String>any(), isA(String[].class));
    assertEquals(0L, actualNotificationPackProcessingTimeout);
  }

  /**
   * Test {@link DefaultTbEdgeConsumerService#getMgmtThreadPoolSize()}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.</li>
   *   <li>Then return twenty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbEdgeConsumerService#getMgmtThreadPoolSize()}
   */
  @Test
  @DisplayName("Test getMgmtThreadPoolSize(); given AtomicInteger(int) with one; then return twenty")
  void testGetMgmtThreadPoolSize_givenAtomicIntegerWithOne_thenReturnTwenty() {
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

    // Act
    int actualMgmtThreadPoolSize = (new DefaultTbEdgeConsumerService(tbCoreQueueFactory, actorContext, statsFactory,
        new EdgeContextComponent())).getMgmtThreadPoolSize();

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("edge"), Mockito.<String>any(), isA(String[].class));
    assertEquals(20, actualMgmtThreadPoolSize);
  }

  /**
   * Test {@link DefaultTbEdgeConsumerService#createNotificationsConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbEdgeConsumerService#createNotificationsConsumer()}
   */
  @Test
  @DisplayName("Test createNotificationsConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateNotificationsConsumer_thenReturnInMemoryTbQueueConsumer() {
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

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToEdgeNotificationMsg>> actualCreateNotificationsConsumerResult = (new DefaultTbEdgeConsumerService(
        tbCoreQueueFactory, actorContext, statsFactory, new EdgeContextComponent())).createNotificationsConsumer();

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("edge"), Mockito.<String>any(), isA(String[].class));
    verify(topicService).getEdgeNotificationsTopic(isNull());
    assertTrue(actualCreateNotificationsConsumerResult instanceof InMemoryTbQueueConsumer);
    assertFalse(actualCreateNotificationsConsumerResult.isStopped());
  }

  /**
   * Test {@link DefaultTbEdgeConsumerService#printStats()}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.</li>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createStatsCounter(String, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbEdgeConsumerService#printStats()}
   */
  @Test
  @DisplayName("Test printStats(); given AtomicInteger(int) with one; then calls createStatsCounter(String, String, String[])")
  void testPrintStats_givenAtomicIntegerWithOne_thenCallsCreateStatsCounter() {
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

    // Act
    (new DefaultTbEdgeConsumerService(tbCoreQueueFactory, actorContext, statsFactory, new EdgeContextComponent()))
        .printStats();

    // Assert that nothing has changed
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("edge"), Mockito.<String>any(), isA(String[].class));
  }
}
