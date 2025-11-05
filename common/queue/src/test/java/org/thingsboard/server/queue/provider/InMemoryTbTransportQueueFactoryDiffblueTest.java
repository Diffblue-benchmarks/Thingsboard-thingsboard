package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ToCoreMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToCoreNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToHousekeeperServiceMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToRuleEngineMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToTransportMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToUsageStatsServiceMsg;
import org.thingsboard.server.gen.transport.TransportProtos.TransportApiRequestMsg;
import org.thingsboard.server.gen.transport.TransportProtos.TransportApiResponseMsg;
import org.thingsboard.server.queue.TbQueueConsumer;
import org.thingsboard.server.queue.TbQueueProducer;
import org.thingsboard.server.queue.TbQueueRequestTemplate;
import org.thingsboard.server.queue.common.DefaultTbQueueRequestTemplate;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.memory.InMemoryStorage;
import org.thingsboard.server.queue.memory.InMemoryTbQueueConsumer;
import org.thingsboard.server.queue.memory.InMemoryTbQueueProducer;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;

class InMemoryTbTransportQueueFactoryDiffblueTest {
  /**
   * Test {@link InMemoryTbTransportQueueFactory#createTransportApiRequestTemplate()}.
   *
   * <p>Method under test: {@link
   * InMemoryTbTransportQueueFactory#createTransportApiRequestTemplate()}
   */
  @Test
  @DisplayName("Test createTransportApiRequestTemplate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueRequestTemplate InMemoryTbTransportQueueFactory.createTransportApiRequestTemplate()"
  })
  void testCreateTransportApiRequestTemplate() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();

    InMemoryTbTransportQueueFactory inMemoryTbTransportQueueFactory =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider,
            coreSettings,
            new DefaultInMemoryStorage(),
            topicService);

    // Act
    TbQueueRequestTemplate<
            TbProtoQueueMsg<TransportApiRequestMsg>, TbProtoQueueMsg<TransportApiResponseMsg>>
        actualCreateTransportApiRequestTemplateResult =
            inMemoryTbTransportQueueFactory.createTransportApiRequestTemplate();

    // Assert
    verify(topicService, atLeast(1)).buildTopicName(Mockito.<String>any());
    assertTrue(
        actualCreateTransportApiRequestTemplateResult instanceof DefaultTbQueueRequestTemplate);
  }

  /**
   * Test {@link InMemoryTbTransportQueueFactory#createRuleEngineMsgProducer()}.
   *
   * <p>Method under test: {@link InMemoryTbTransportQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueProducer InMemoryTbTransportQueueFactory.createRuleEngineMsgProducer()"
  })
  void testCreateRuleEngineMsgProducer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory inMemoryTbTransportQueueFactory =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider,
            coreSettings,
            storage,
            topicService);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToRuleEngineMsg>> actualCreateRuleEngineMsgProducerResult =
        inMemoryTbTransportQueueFactory.createRuleEngineMsgProducer();

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
   * Test {@link InMemoryTbTransportQueueFactory#createTbCoreMsgProducer()}.
   *
   * <p>Method under test: {@link InMemoryTbTransportQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueProducer InMemoryTbTransportQueueFactory.createTbCoreMsgProducer()"})
  void testCreateTbCoreMsgProducer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory inMemoryTbTransportQueueFactory =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider,
            coreSettings,
            storage,
            topicService);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToCoreMsg>> actualCreateTbCoreMsgProducerResult =
        inMemoryTbTransportQueueFactory.createTbCoreMsgProducer();

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
   * Test {@link InMemoryTbTransportQueueFactory#createTbCoreNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * InMemoryTbTransportQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueProducer InMemoryTbTransportQueueFactory.createTbCoreNotificationsMsgProducer()"
  })
  void testCreateTbCoreNotificationsMsgProducer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory inMemoryTbTransportQueueFactory =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider,
            coreSettings,
            storage,
            topicService);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToCoreNotificationMsg>>
        actualCreateTbCoreNotificationsMsgProducerResult =
            inMemoryTbTransportQueueFactory.createTbCoreNotificationsMsgProducer();

    // Assert
    verify(topicService).buildTopicName(null);
    InMemoryStorage storage2 =
        ((InMemoryTbQueueProducer<TbProtoQueueMsg<ToCoreNotificationMsg>>)
                actualCreateTbCoreNotificationsMsgProducerResult)
            .getStorage();
    assertTrue(storage2 instanceof DefaultInMemoryStorage);
    assertTrue(actualCreateTbCoreNotificationsMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(
        "Build Topic Name", actualCreateTbCoreNotificationsMsgProducerResult.getDefaultTopic());
    assertEquals(0, storage2.getLagTotal());
    assertSame(storage, storage2);
  }

  /**
   * Test {@link InMemoryTbTransportQueueFactory#createTransportNotificationsConsumer()}.
   *
   * <p>Method under test: {@link
   * InMemoryTbTransportQueueFactory#createTransportNotificationsConsumer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueConsumer InMemoryTbTransportQueueFactory.createTransportNotificationsConsumer()"
  })
  void testCreateTransportNotificationsConsumer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();

    InMemoryTbTransportQueueFactory inMemoryTbTransportQueueFactory =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider,
            coreSettings,
            new DefaultInMemoryStorage(),
            topicService);

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToTransportMsg>>
        actualCreateTransportNotificationsConsumerResult =
            inMemoryTbTransportQueueFactory.createTransportNotificationsConsumer();

    // Assert
    verify(topicService).buildTopicName("null.null");
    assertTrue(actualCreateTransportNotificationsConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateTransportNotificationsConsumerResult.getTopic());
    assertFalse(actualCreateTransportNotificationsConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryTbTransportQueueFactory#createToUsageStatsServiceMsgProducer()}.
   *
   * <p>Method under test: {@link
   * InMemoryTbTransportQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueProducer InMemoryTbTransportQueueFactory.createToUsageStatsServiceMsgProducer()"
  })
  void testCreateToUsageStatsServiceMsgProducer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory inMemoryTbTransportQueueFactory =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider,
            coreSettings,
            storage,
            topicService);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToUsageStatsServiceMsg>>
        actualCreateToUsageStatsServiceMsgProducerResult =
            inMemoryTbTransportQueueFactory.createToUsageStatsServiceMsgProducer();

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
   * Test {@link InMemoryTbTransportQueueFactory#createHousekeeperMsgProducer()}.
   *
   * <p>Method under test: {@link InMemoryTbTransportQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbQueueProducer InMemoryTbTransportQueueFactory.createHousekeeperMsgProducer()"
  })
  void testCreateHousekeeperMsgProducer() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory inMemoryTbTransportQueueFactory =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider,
            coreSettings,
            storage,
            topicService);

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToHousekeeperServiceMsg>>
        actualCreateHousekeeperMsgProducerResult =
            inMemoryTbTransportQueueFactory.createHousekeeperMsgProducer();

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
}
