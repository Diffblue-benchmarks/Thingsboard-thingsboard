package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.gen.transport.TransportProtos;
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
   * Test
   * {@link InMemoryMonolithQueueFactory#createTransportNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsMsgProducer()")
  void testCreateTransportNotificationsMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToTransportMsg>> actualCreateTransportNotificationsMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createTransportNotificationsMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToTransportMsg>>) actualCreateTransportNotificationsMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateTransportNotificationsMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateTransportNotificationsMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createRuleEngineMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateRuleEngineMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> actualCreateRuleEngineMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createRuleEngineMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>>) actualCreateRuleEngineMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateRuleEngineMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateRuleEngineMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createRuleEngineNotificationsMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineNotificationsMsgProducer()")
  void testCreateRuleEngineNotificationsMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToRuleEngineNotificationMsg>> actualCreateRuleEngineNotificationsMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createRuleEngineNotificationsMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToRuleEngineNotificationMsg>>) actualCreateRuleEngineNotificationsMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateRuleEngineNotificationsMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateRuleEngineNotificationsMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createTbCoreMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateTbCoreMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreMsg>> actualCreateTbCoreMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createTbCoreMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreMsg>>) actualCreateTbCoreMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateTbCoreMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateTbCoreMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createTbCoreNotificationsMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateTbCoreNotificationsMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any())).thenReturn(buildResult);
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreNotificationMsg>> actualCreateTbCoreNotificationsMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createTbCoreNotificationsMsgProducer();

    // Assert
    verify(topicService).getNotificationsTopic(eq(ServiceType.TB_CORE), isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToCoreNotificationMsg>>) actualCreateTbCoreNotificationsMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateTbCoreNotificationsMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToVersionControlMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToVersionControlMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToVersionControlMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateToVersionControlMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToVersionControlServiceMsg>> actualCreateToVersionControlMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())).createToVersionControlMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateToVersionControlMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateToVersionControlMsgConsumerResult.getTopic());
    assertFalse(actualCreateToVersionControlMsgConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToRuleEngineMsgConsumer(Queue)}
   * with {@code configuration}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToRuleEngineMsgConsumer(Queue)}
   */
  @Test
  @DisplayName("Test createToRuleEngineMsgConsumer(Queue) with 'configuration'")
  void testCreateToRuleEngineMsgConsumerWithConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory = new InMemoryMonolithQueueFactory(topicService,
        coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage());

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> actualCreateToRuleEngineMsgConsumerResult = inMemoryMonolithQueueFactory
        .createToRuleEngineMsgConsumer(new Queue());

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateToRuleEngineMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateToRuleEngineMsgConsumerResult.getTopic());
    assertFalse(actualCreateToRuleEngineMsgConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToRuleEngineNotificationsMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToRuleEngineNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToRuleEngineNotificationsMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateToRuleEngineNotificationsMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any())).thenReturn(buildResult);
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToRuleEngineNotificationMsg>> actualCreateToRuleEngineNotificationsMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))
        .createToRuleEngineNotificationsMsgConsumer();

    // Assert
    verify(topicService).getNotificationsTopic(eq(ServiceType.TB_RULE_ENGINE), isNull());
    assertTrue(actualCreateToRuleEngineNotificationsMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertFalse(actualCreateToRuleEngineNotificationsMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createToCoreMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToCoreMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateToCoreMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToCoreMsg>> actualCreateToCoreMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())).createToCoreMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateToCoreMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateToCoreMsgConsumerResult.getTopic());
    assertFalse(actualCreateToCoreMsgConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreNotificationsMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateToCoreNotificationsMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any())).thenReturn(buildResult);
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToCoreNotificationMsg>> actualCreateToCoreNotificationsMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))
        .createToCoreNotificationsMsgConsumer();

    // Assert
    verify(topicService).getNotificationsTopic(eq(ServiceType.TB_CORE), isNull());
    assertTrue(actualCreateToCoreNotificationsMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertFalse(actualCreateToCoreNotificationsMsgConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createTransportApiRequestConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createTransportApiRequestConsumer()}
   */
  @Test
  @DisplayName("Test createTransportApiRequestConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateTransportApiRequestConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.TransportApiRequestMsg>> actualCreateTransportApiRequestConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())).createTransportApiRequestConsumer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateTransportApiRequestConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateTransportApiRequestConsumerResult.getTopic());
    assertFalse(actualCreateTransportApiRequestConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createTransportApiResponseProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createTransportApiResponseProducer()}
   */
  @Test
  @DisplayName("Test createTransportApiResponseProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateTransportApiResponseProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.TransportApiResponseMsg>> actualCreateTransportApiResponseProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createTransportApiResponseProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.TransportApiResponseMsg>>) actualCreateTransportApiResponseProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateTransportApiResponseProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateTransportApiResponseProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createRemoteJsRequestTemplate()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createRemoteJsRequestTemplate()}
   */
  @Test
  @DisplayName("Test createRemoteJsRequestTemplate()")
  void testCreateRemoteJsRequestTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertNull((new InMemoryMonolithQueueFactory(topicService, coreSettings, ruleEngineSettings, vcSettings,
        serviceInfoProvider, transportApiSettings, transportNotificationSettings, edgeSettings,
        new DefaultInMemoryStorage())).createRemoteJsRequestTemplate());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createRemoteJsRequestTemplate()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createRemoteJsRequestTemplate()}
   */
  @Test
  @DisplayName("Test createRemoteJsRequestTemplate()")
  void testCreateRemoteJsRequestTemplate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertNull((new InMemoryMonolithQueueFactory(topicService, coreSettings, ruleEngineSettings, vcSettings,
        serviceInfoProvider, transportApiSettings, transportNotificationSettings, edgeSettings,
        new DefaultInMemoryStorage())).createRemoteJsRequestTemplate());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToUsageStatsServiceMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToUsageStatsServiceMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateToUsageStatsServiceMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToUsageStatsServiceMsg>> actualCreateToUsageStatsServiceMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))
        .createToUsageStatsServiceMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateToUsageStatsServiceMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateToUsageStatsServiceMsgConsumerResult.getTopic());
    assertFalse(actualCreateToUsageStatsServiceMsgConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToOtaPackageStateServiceMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToOtaPackageStateServiceMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateToOtaPackageStateServiceMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToOtaPackageStateServiceMsg>> actualCreateToOtaPackageStateServiceMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))
        .createToOtaPackageStateServiceMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateToOtaPackageStateServiceMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateToOtaPackageStateServiceMsgConsumerResult.getTopic());
    assertFalse(actualCreateToOtaPackageStateServiceMsgConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToOtaPackageStateServiceMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToOtaPackageStateServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgProducer()")
  void testCreateToOtaPackageStateServiceMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToOtaPackageStateServiceMsg>> actualCreateToOtaPackageStateServiceMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createToOtaPackageStateServiceMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToOtaPackageStateServiceMsg>>) actualCreateToOtaPackageStateServiceMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateToOtaPackageStateServiceMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateToOtaPackageStateServiceMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToUsageStatsServiceMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateToUsageStatsServiceMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToUsageStatsServiceMsg>> actualCreateToUsageStatsServiceMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createToUsageStatsServiceMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToUsageStatsServiceMsg>>) actualCreateToUsageStatsServiceMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateToUsageStatsServiceMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateToUsageStatsServiceMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createVersionControlMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test createVersionControlMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateVersionControlMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToVersionControlServiceMsg>> actualCreateVersionControlMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createVersionControlMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToVersionControlServiceMsg>>) actualCreateVersionControlMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateVersionControlMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateVersionControlMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createHousekeeperMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateHousekeeperMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>> actualCreateHousekeeperMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createHousekeeperMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>>) actualCreateHousekeeperMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateHousekeeperMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateHousekeeperMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createHousekeeperMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createHousekeeperMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateHousekeeperMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>> actualCreateHousekeeperMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())).createHousekeeperMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateHousekeeperMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateHousekeeperMsgConsumerResult.getTopic());
    assertFalse(actualCreateHousekeeperMsgConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgProducer()}.
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgProducer()")
  void testCreateHousekeeperReprocessingMsgProducer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>> actualCreateHousekeeperReprocessingMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createHousekeeperReprocessingMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>>) actualCreateHousekeeperReprocessingMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateHousekeeperReprocessingMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateHousekeeperReprocessingMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateHousekeeperReprocessingMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToHousekeeperServiceMsg>> actualCreateHousekeeperReprocessingMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))
        .createHousekeeperReprocessingMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateHousekeeperReprocessingMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateHousekeeperReprocessingMsgConsumerResult.getTopic());
    assertFalse(actualCreateHousekeeperReprocessingMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createEdgeMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createEdgeMsgConsumer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateEdgeMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToEdgeMsg>> actualCreateEdgeMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())).createEdgeMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateEdgeMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateEdgeMsgConsumerResult.getTopic());
    assertFalse(actualCreateEdgeMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createEdgeMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateEdgeMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToEdgeMsg>> actualCreateEdgeMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createEdgeMsgProducer();

    // Assert
    verify(topicService).buildTopicName(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToEdgeMsg>>) actualCreateEdgeMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateEdgeMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateEdgeMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}.
   * <ul>
   *   <li>Then return {@link InMemoryTbQueueConsumer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToEdgeNotificationsMsgConsumer(); then return InMemoryTbQueueConsumer")
  void testCreateToEdgeNotificationsMsgConsumer_thenReturnInMemoryTbQueueConsumer() {
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

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportProtos.ToEdgeNotificationMsg>> actualCreateToEdgeNotificationsMsgConsumerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))
        .createToEdgeNotificationsMsgConsumer();

    // Assert
    verify(topicService).getEdgeNotificationsTopic(isNull());
    assertTrue(actualCreateToEdgeNotificationsMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertFalse(actualCreateToEdgeNotificationsMsgConsumerResult.isStopped());
  }

  /**
   * Test
   * {@link InMemoryMonolithQueueFactory#createEdgeNotificationsMsgProducer()}.
   * <ul>
   *   <li>Then Storage return {@link DefaultInMemoryStorage}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link InMemoryMonolithQueueFactory#createEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeNotificationsMsgProducer(); then Storage return DefaultInMemoryStorage")
  void testCreateEdgeNotificationsMsgProducer_thenStorageReturnDefaultInMemoryStorage() {
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
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportProtos.ToEdgeNotificationMsg>> actualCreateEdgeNotificationsMsgProducerResult = (new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, storage)).createEdgeNotificationsMsgProducer();

    // Assert
    verify(topicService).getEdgeNotificationsTopic(isNull());
    InMemoryStorage storage2 = ((InMemoryTbQueueProducer<TbProtoQueueMsg<TransportProtos.ToEdgeNotificationMsg>>) actualCreateEdgeNotificationsMsgProducerResult)
        .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateEdgeNotificationsMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }
}
