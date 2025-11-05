package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo.TopicPartitionInfoBuilder;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ToCoreMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToCoreNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToEdgeMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToEdgeNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToHousekeeperServiceMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToOtaPackageStateServiceMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToRuleEngineMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToRuleEngineNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToTransportMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToUsageStatsServiceMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToVersionControlServiceMsg;
import org.thingsboard.server.gen.transport.TransportProtos.TransportApiRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.TransportApiResponseMsg;
import org.thingsboard.server.queue.TbQueueConsumer;
import org.thingsboard.server.queue.TbQueueProducer;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.memory.InMemoryStorage;
import org.thingsboard.server.queue.memory.InMemoryTbQueueConsumer;
import org.thingsboard.server.queue.memory.InMemoryTbQueueProducer;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;

class InMemoryMonolithQueueFactoryDiffblueTest {
  /**
   * Test {@link InMemoryMonolithQueueFactory#createTransportNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * InMemoryMonolithQueueFactory#createTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueProducer InMemoryMonolithQueueFactory.createTransportNotificationsMsgProducer()"
  })
  void testCreateTransportNotificationsMsgProducer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            storage);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToTransportMsg>>
        actualCreateTransportNotificationsMsgProducerResult =
            inMemoryMonolithQueueFactory.createTransportNotificationsMsgProducer();

    // Assert
    verify(topicService).buildTopicName(null);
    InMemoryStorage storage2 =
        ((InMemoryTbQueueProducer<TbProtoQueueMsg<ToTransportMsg>>)
                actualCreateTransportNotificationsMsgProducerResult)
            .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(
        actualCreateTransportNotificationsMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(
        "Build Topic Name", actualCreateTransportNotificationsMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createRuleEngineMsgProducer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueProducer InMemoryMonolithQueueFactory.createRuleEngineMsgProducer()"})
  void testCreateRuleEngineMsgProducer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            storage);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToRuleEngineMsg>> actualCreateRuleEngineMsgProducerResult =
        inMemoryMonolithQueueFactory.createRuleEngineMsgProducer();

    // Assert
    verify(topicService).buildTopicName(null);
    InMemoryStorage storage2 =
        ((InMemoryTbQueueProducer<TbProtoQueueMsg<ToRuleEngineMsg>>)
                actualCreateRuleEngineMsgProducerResult)
            .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateRuleEngineMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateRuleEngineMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createRuleEngineNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * InMemoryMonolithQueueFactory#createRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueProducer InMemoryMonolithQueueFactory.createRuleEngineNotificationsMsgProducer()"
  })
  void testCreateRuleEngineNotificationsMsgProducer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            storage);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToRuleEngineNotificationMsg>>
        actualCreateRuleEngineNotificationsMsgProducerResult =
            inMemoryMonolithQueueFactory.createRuleEngineNotificationsMsgProducer();

    // Assert
    verify(topicService).buildTopicName(null);
    InMemoryStorage storage2 =
        ((InMemoryTbQueueProducer<TbProtoQueueMsg<ToRuleEngineNotificationMsg>>)
                actualCreateRuleEngineNotificationsMsgProducerResult)
            .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(
        actualCreateRuleEngineNotificationsMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(
        "Build Topic Name", actualCreateRuleEngineNotificationsMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createTbCoreMsgProducer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueProducer InMemoryMonolithQueueFactory.createTbCoreMsgProducer()"})
  void testCreateTbCoreMsgProducer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            storage);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToCoreMsg>> actualCreateTbCoreMsgProducerResult =
        inMemoryMonolithQueueFactory.createTbCoreMsgProducer();

    // Assert
    verify(topicService).buildTopicName(null);
    InMemoryStorage storage2 =
        ((InMemoryTbQueueProducer<TbProtoQueueMsg<ToCoreMsg>>) actualCreateTbCoreMsgProducerResult)
            .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateTbCoreMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateTbCoreMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createTbCoreNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * InMemoryMonolithQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueProducer InMemoryMonolithQueueFactory.createTbCoreNotificationsMsgProducer()"
  })
  void testCreateTbCoreNotificationsMsgProducer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            storage);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToCoreNotificationMsg>>
        actualCreateTbCoreNotificationsMsgProducerResult =
            inMemoryMonolithQueueFactory.createTbCoreNotificationsMsgProducer();

    // Assert
    verify(topicService).getNotificationsTopic(ServiceType.TB_CORE, null);
    InMemoryStorage storage2 =
        ((InMemoryTbQueueProducer<TbProtoQueueMsg<ToCoreNotificationMsg>>)
                actualCreateTbCoreNotificationsMsgProducerResult)
            .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateTbCoreNotificationsMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(
        "Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1",
        actualCreateTbCoreNotificationsMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createToVersionControlMsgConsumer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createToVersionControlMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToVersionControlMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueConsumer InMemoryMonolithQueueFactory.createToVersionControlMsgConsumer()"
  })
  void testCreateToVersionControlMsgConsumer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToVersionControlServiceMsg>>
        actualCreateToVersionControlMsgConsumerResult =
            inMemoryMonolithQueueFactory.createToVersionControlMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(null);
    assertTrue(actualCreateToVersionControlMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateToVersionControlMsgConsumerResult.getTopic());
    assertFalse(actualCreateToVersionControlMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createToRuleEngineMsgConsumer(Queue)} with {@code
   * configuration}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createToRuleEngineMsgConsumer(Queue)}
   */
  @Test
  @DisplayName("Test createToRuleEngineMsgConsumer(Queue) with 'configuration'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueConsumer InMemoryMonolithQueueFactory.createToRuleEngineMsgConsumer(Queue)"
  })
  void testCreateToRuleEngineMsgConsumerWithConfiguration() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToRuleEngineMsg>> actualCreateToRuleEngineMsgConsumerResult =
        inMemoryMonolithQueueFactory.createToRuleEngineMsgConsumer(new Queue());

    // Assert
    verify(topicService).buildTopicName(null);
    assertTrue(actualCreateToRuleEngineMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateToRuleEngineMsgConsumerResult.getTopic());
    assertFalse(actualCreateToRuleEngineMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createToRuleEngineNotificationsMsgConsumer()}.
   *
   * <p>Method under test: {@link
   * InMemoryMonolithQueueFactory#createToRuleEngineNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToRuleEngineNotificationsMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueConsumer InMemoryMonolithQueueFactory.createToRuleEngineNotificationsMsgConsumer()"
  })
  void testCreateToRuleEngineNotificationsMsgConsumer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToRuleEngineNotificationMsg>>
        actualCreateToRuleEngineNotificationsMsgConsumerResult =
            inMemoryMonolithQueueFactory.createToRuleEngineNotificationsMsgConsumer();

    // Assert
    verify(topicService).getNotificationsTopic(ServiceType.TB_RULE_ENGINE, null);
    assertTrue(
        actualCreateToRuleEngineNotificationsMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals(
        "Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1",
        actualCreateToRuleEngineNotificationsMsgConsumerResult.getTopic());
    assertFalse(actualCreateToRuleEngineNotificationsMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createToCoreMsgConsumer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createToCoreMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueConsumer InMemoryMonolithQueueFactory.createToCoreMsgConsumer()"})
  void testCreateToCoreMsgConsumer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToCoreMsg>> actualCreateToCoreMsgConsumerResult =
        inMemoryMonolithQueueFactory.createToCoreMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(null);
    assertTrue(actualCreateToCoreMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateToCoreMsgConsumerResult.getTopic());
    assertFalse(actualCreateToCoreMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}.
   *
   * <p>Method under test: {@link
   * InMemoryMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreNotificationsMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueConsumer InMemoryMonolithQueueFactory.createToCoreNotificationsMsgConsumer()"
  })
  void testCreateToCoreNotificationsMsgConsumer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToCoreNotificationMsg>>
        actualCreateToCoreNotificationsMsgConsumerResult =
            inMemoryMonolithQueueFactory.createToCoreNotificationsMsgConsumer();

    // Assert
    verify(topicService).getNotificationsTopic(ServiceType.TB_CORE, null);
    assertTrue(actualCreateToCoreNotificationsMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals(
        "Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1",
        actualCreateToCoreNotificationsMsgConsumerResult.getTopic());
    assertFalse(actualCreateToCoreNotificationsMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createTransportApiRequestConsumer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createTransportApiRequestConsumer()}
   */
  @Test
  @DisplayName("Test createTransportApiRequestConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueConsumer InMemoryMonolithQueueFactory.createTransportApiRequestConsumer()"
  })
  void testCreateTransportApiRequestConsumer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportApiRequestMsg>>
        actualCreateTransportApiRequestConsumerResult =
            inMemoryMonolithQueueFactory.createTransportApiRequestConsumer();

    // Assert
    verify(topicService).buildTopicName(null);
    assertTrue(actualCreateTransportApiRequestConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateTransportApiRequestConsumerResult.getTopic());
    assertFalse(actualCreateTransportApiRequestConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createTransportApiResponseProducer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createTransportApiResponseProducer()}
   */
  @Test
  @DisplayName("Test createTransportApiResponseProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueProducer InMemoryMonolithQueueFactory.createTransportApiResponseProducer()"
  })
  void testCreateTransportApiResponseProducer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            storage);

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportApiResponseMsg>>
        actualCreateTransportApiResponseProducerResult =
            inMemoryMonolithQueueFactory.createTransportApiResponseProducer();

    // Assert
    verify(topicService).buildTopicName(null);
    InMemoryStorage storage2 =
        ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportApiResponseMsg>>)
                actualCreateTransportApiResponseProducerResult)
            .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateTransportApiResponseProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(
        "Build Topic Name", actualCreateTransportApiResponseProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createRemoteJsRequestTemplate()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createRemoteJsRequestTemplate()}
   */
  @Test
  @DisplayName("Test createRemoteJsRequestTemplate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueRequestTemplate InMemoryMonolithQueueFactory.createRemoteJsRequestTemplate()"
  })
  void testCreateRemoteJsRequestTemplate() {
    // Arrange
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    // Act and Assert
    assertNull(inMemoryMonolithQueueFactory.createRemoteJsRequestTemplate());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createToUsageStatsServiceMsgConsumer()}.
   *
   * <p>Method under test: {@link
   * InMemoryMonolithQueueFactory#createToUsageStatsServiceMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueConsumer InMemoryMonolithQueueFactory.createToUsageStatsServiceMsgConsumer()"
  })
  void testCreateToUsageStatsServiceMsgConsumer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToUsageStatsServiceMsg>>
        actualCreateToUsageStatsServiceMsgConsumerResult =
            inMemoryMonolithQueueFactory.createToUsageStatsServiceMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(null);
    assertTrue(actualCreateToUsageStatsServiceMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateToUsageStatsServiceMsgConsumerResult.getTopic());
    assertFalse(actualCreateToUsageStatsServiceMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createToOtaPackageStateServiceMsgConsumer()}.
   *
   * <p>Method under test: {@link
   * InMemoryMonolithQueueFactory#createToOtaPackageStateServiceMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueConsumer InMemoryMonolithQueueFactory.createToOtaPackageStateServiceMsgConsumer()"
  })
  void testCreateToOtaPackageStateServiceMsgConsumer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToOtaPackageStateServiceMsg>>
        actualCreateToOtaPackageStateServiceMsgConsumerResult =
            inMemoryMonolithQueueFactory.createToOtaPackageStateServiceMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(null);
    assertTrue(
        actualCreateToOtaPackageStateServiceMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals(
        "Build Topic Name", actualCreateToOtaPackageStateServiceMsgConsumerResult.getTopic());
    assertFalse(actualCreateToOtaPackageStateServiceMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createToOtaPackageStateServiceMsgProducer()}.
   *
   * <p>Method under test: {@link
   * InMemoryMonolithQueueFactory#createToOtaPackageStateServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueProducer InMemoryMonolithQueueFactory.createToOtaPackageStateServiceMsgProducer()"
  })
  void testCreateToOtaPackageStateServiceMsgProducer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            storage);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToOtaPackageStateServiceMsg>>
        actualCreateToOtaPackageStateServiceMsgProducerResult =
            inMemoryMonolithQueueFactory.createToOtaPackageStateServiceMsgProducer();

    // Assert
    verify(topicService).buildTopicName(null);
    InMemoryStorage storage2 =
        ((InMemoryTbQueueProducer<TbProtoQueueMsg<ToOtaPackageStateServiceMsg>>)
                actualCreateToOtaPackageStateServiceMsgProducerResult)
            .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(
        actualCreateToOtaPackageStateServiceMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(
        "Build Topic Name",
        actualCreateToOtaPackageStateServiceMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createToUsageStatsServiceMsgProducer()}.
   *
   * <p>Method under test: {@link
   * InMemoryMonolithQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueProducer InMemoryMonolithQueueFactory.createToUsageStatsServiceMsgProducer()"
  })
  void testCreateToUsageStatsServiceMsgProducer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            storage);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToUsageStatsServiceMsg>>
        actualCreateToUsageStatsServiceMsgProducerResult =
            inMemoryMonolithQueueFactory.createToUsageStatsServiceMsgProducer();

    // Assert
    verify(topicService).buildTopicName(null);
    InMemoryStorage storage2 =
        ((InMemoryTbQueueProducer<TbProtoQueueMsg<ToUsageStatsServiceMsg>>)
                actualCreateToUsageStatsServiceMsgProducerResult)
            .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateToUsageStatsServiceMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(
        "Build Topic Name", actualCreateToUsageStatsServiceMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createVersionControlMsgProducer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test createVersionControlMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueProducer InMemoryMonolithQueueFactory.createVersionControlMsgProducer()"
  })
  void testCreateVersionControlMsgProducer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            storage);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToVersionControlServiceMsg>>
        actualCreateVersionControlMsgProducerResult =
            inMemoryMonolithQueueFactory.createVersionControlMsgProducer();

    // Assert
    verify(topicService).buildTopicName(null);
    InMemoryStorage storage2 =
        ((InMemoryTbQueueProducer<TbProtoQueueMsg<ToVersionControlServiceMsg>>)
                actualCreateVersionControlMsgProducerResult)
            .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateVersionControlMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateVersionControlMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createHousekeeperMsgProducer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueProducer InMemoryMonolithQueueFactory.createHousekeeperMsgProducer()"})
  void testCreateHousekeeperMsgProducer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            storage);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToHousekeeperServiceMsg>>
        actualCreateHousekeeperMsgProducerResult =
            inMemoryMonolithQueueFactory.createHousekeeperMsgProducer();

    // Assert
    verify(topicService).buildTopicName(null);
    InMemoryStorage storage2 =
        ((InMemoryTbQueueProducer<TbProtoQueueMsg<ToHousekeeperServiceMsg>>)
                actualCreateHousekeeperMsgProducerResult)
            .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateHousekeeperMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateHousekeeperMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createHousekeeperMsgConsumer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createHousekeeperMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueConsumer InMemoryMonolithQueueFactory.createHousekeeperMsgConsumer()"})
  void testCreateHousekeeperMsgConsumer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToHousekeeperServiceMsg>>
        actualCreateHousekeeperMsgConsumerResult =
            inMemoryMonolithQueueFactory.createHousekeeperMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(null);
    assertTrue(actualCreateHousekeeperMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateHousekeeperMsgConsumerResult.getTopic());
    assertFalse(actualCreateHousekeeperMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgProducer()}.
   *
   * <p>Method under test: {@link
   * InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueProducer InMemoryMonolithQueueFactory.createHousekeeperReprocessingMsgProducer()"
  })
  void testCreateHousekeeperReprocessingMsgProducer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            storage);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToHousekeeperServiceMsg>>
        actualCreateHousekeeperReprocessingMsgProducerResult =
            inMemoryMonolithQueueFactory.createHousekeeperReprocessingMsgProducer();

    // Assert
    verify(topicService).buildTopicName(null);
    InMemoryStorage storage2 =
        ((InMemoryTbQueueProducer<TbProtoQueueMsg<ToHousekeeperServiceMsg>>)
                actualCreateHousekeeperReprocessingMsgProducerResult)
            .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(
        actualCreateHousekeeperReprocessingMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(
        "Build Topic Name", actualCreateHousekeeperReprocessingMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgConsumer()}.
   *
   * <p>Method under test: {@link
   * InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueConsumer InMemoryMonolithQueueFactory.createHousekeeperReprocessingMsgConsumer()"
  })
  void testCreateHousekeeperReprocessingMsgConsumer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToHousekeeperServiceMsg>>
        actualCreateHousekeeperReprocessingMsgConsumerResult =
            inMemoryMonolithQueueFactory.createHousekeeperReprocessingMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(null);
    assertTrue(
        actualCreateHousekeeperReprocessingMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals(
        "Build Topic Name", actualCreateHousekeeperReprocessingMsgConsumerResult.getTopic());
    assertFalse(actualCreateHousekeeperReprocessingMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createEdgeMsgConsumer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createEdgeMsgConsumer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueConsumer InMemoryMonolithQueueFactory.createEdgeMsgConsumer()"})
  void testCreateEdgeMsgConsumer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToEdgeMsg>> actualCreateEdgeMsgConsumerResult =
        inMemoryMonolithQueueFactory.createEdgeMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(null);
    assertTrue(actualCreateEdgeMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateEdgeMsgConsumerResult.getTopic());
    assertFalse(actualCreateEdgeMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createEdgeMsgProducer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueProducer InMemoryMonolithQueueFactory.createEdgeMsgProducer()"})
  void testCreateEdgeMsgProducer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            storage);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToEdgeMsg>> actualCreateEdgeMsgProducerResult =
        inMemoryMonolithQueueFactory.createEdgeMsgProducer();

    // Assert
    verify(topicService).buildTopicName(null);
    InMemoryStorage storage2 =
        ((InMemoryTbQueueProducer<TbProtoQueueMsg<ToEdgeMsg>>) actualCreateEdgeMsgProducerResult)
            .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateEdgeMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateEdgeMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}.
   *
   * <p>Method under test: {@link
   * InMemoryMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToEdgeNotificationsMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueConsumer InMemoryMonolithQueueFactory.createToEdgeNotificationsMsgConsumer()"
  })
  void testCreateToEdgeNotificationsMsgConsumer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getEdgeNotificationsTopic(Mockito.<String>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToEdgeNotificationMsg>>
        actualCreateToEdgeNotificationsMsgConsumerResult =
            inMemoryMonolithQueueFactory.createToEdgeNotificationsMsgConsumer();

    // Assert
    verify(topicService).getEdgeNotificationsTopic(null);
    assertTrue(actualCreateToEdgeNotificationsMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals(
        "Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1",
        actualCreateToEdgeNotificationsMsgConsumerResult.getTopic());
    assertFalse(actualCreateToEdgeNotificationsMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createEdgeNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueProducer InMemoryMonolithQueueFactory.createEdgeNotificationsMsgProducer()"
  })
  void testCreateEdgeNotificationsMsgProducer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getEdgeNotificationsTopic(Mockito.<String>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            storage);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToEdgeNotificationMsg>>
        actualCreateEdgeNotificationsMsgProducerResult =
            inMemoryMonolithQueueFactory.createEdgeNotificationsMsgProducer();

    // Assert
    verify(topicService).getEdgeNotificationsTopic(null);
    InMemoryStorage storage2 =
        ((InMemoryTbQueueProducer<TbProtoQueueMsg<ToEdgeNotificationMsg>>)
                actualCreateEdgeNotificationsMsgProducerResult)
            .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateEdgeNotificationsMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(
        "Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1",
        actualCreateEdgeNotificationsMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }
}
