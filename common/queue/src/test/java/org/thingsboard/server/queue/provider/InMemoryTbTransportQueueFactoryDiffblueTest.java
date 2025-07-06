package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
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
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.InMemoryTbQueueConsumer;
import org.thingsboard.server.queue.memory.InMemoryTbQueueProducer;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;

@ExtendWith(MockitoExtension.class)
class InMemoryTbTransportQueueFactoryDiffblueTest {
  @InjectMocks private InMemoryTbTransportQueueFactory inMemoryTbTransportQueueFactory;

  @Mock private TbQueueCoreSettings tbQueueCoreSettings;

  @Mock private TbQueueTransportApiSettings tbQueueTransportApiSettings;

  @Mock private TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;

  @Mock private TbServiceInfoProvider tbServiceInfoProvider;

  @Mock private TopicService topicService;

  /**
   * Test {@link InMemoryTbTransportQueueFactory#createTransportApiRequestTemplate()}.
   *
   * <p>Method under test: {@link
   * InMemoryTbTransportQueueFactory#createTransportApiRequestTemplate()}
   */
  @Test
  @DisplayName("Test createTransportApiRequestTemplate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueRequestTemplate InMemoryTbTransportQueueFactory.createTransportApiRequestTemplate()"
  })
  void testCreateTransportApiRequestTemplate() {
    // Arrange
    when(tbQueueTransportApiSettings.getMaxPendingRequests()).thenReturn(3);
    when(tbQueueTransportApiSettings.getMaxRequestsTimeout()).thenReturn(3);
    when(tbQueueTransportApiSettings.getRequestsTopic()).thenReturn("Requests Topic");
    when(tbQueueTransportApiSettings.getResponsesTopic()).thenReturn("Responses Topic");
    when(tbQueueTransportApiSettings.getResponsePollInterval()).thenReturn(42L);
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");

    // Act
    TbQueueRequestTemplate<
            TbProtoQueueMsg<TransportApiRequestMsg>, TbProtoQueueMsg<TransportApiResponseMsg>>
        actualCreateTransportApiRequestTemplateResult =
            inMemoryTbTransportQueueFactory.createTransportApiRequestTemplate();

    // Assert
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService, atLeast(1)).buildTopicName(Mockito.<String>any());
    verify(tbQueueTransportApiSettings).getMaxPendingRequests();
    verify(tbQueueTransportApiSettings).getMaxRequestsTimeout();
    verify(tbQueueTransportApiSettings).getRequestsTopic();
    verify(tbQueueTransportApiSettings).getResponsePollInterval();
    verify(tbQueueTransportApiSettings).getResponsesTopic();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueProducer InMemoryTbTransportQueueFactory.createRuleEngineMsgProducer()"
  })
  void testCreateRuleEngineMsgProducer() {
    // Arrange
    when(tbQueueTransportApiSettings.getRequestsTopic()).thenReturn("Requests Topic");
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToRuleEngineMsg>> actualCreateRuleEngineMsgProducerResult =
        inMemoryTbTransportQueueFactory.createRuleEngineMsgProducer();

    // Assert
    verify(topicService).buildTopicName(eq("Requests Topic"));
    verify(tbQueueTransportApiSettings).getRequestsTopic();
    assertTrue(actualCreateRuleEngineMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateRuleEngineMsgProducerResult.getDefaultTopic());
  }

  /**
   * Test {@link InMemoryTbTransportQueueFactory#createTbCoreMsgProducer()}.
   *
   * <p>Method under test: {@link InMemoryTbTransportQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbQueueProducer InMemoryTbTransportQueueFactory.createTbCoreMsgProducer()"})
  void testCreateTbCoreMsgProducer() {
    // Arrange
    when(tbQueueCoreSettings.getTopic()).thenReturn("Topic");
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToCoreMsg>> actualCreateTbCoreMsgProducerResult =
        inMemoryTbTransportQueueFactory.createTbCoreMsgProducer();

    // Assert
    verify(topicService).buildTopicName(eq("Topic"));
    verify(tbQueueCoreSettings).getTopic();
    assertTrue(actualCreateTbCoreMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateTbCoreMsgProducerResult.getDefaultTopic());
  }

  /**
   * Test {@link InMemoryTbTransportQueueFactory#createTbCoreNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * InMemoryTbTransportQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueProducer InMemoryTbTransportQueueFactory.createTbCoreNotificationsMsgProducer()"
  })
  void testCreateTbCoreNotificationsMsgProducer() {
    // Arrange
    when(tbQueueCoreSettings.getTopic()).thenReturn("Topic");
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToCoreNotificationMsg>>
        actualCreateTbCoreNotificationsMsgProducerResult =
            inMemoryTbTransportQueueFactory.createTbCoreNotificationsMsgProducer();

    // Assert
    verify(topicService).buildTopicName(eq("Topic"));
    verify(tbQueueCoreSettings).getTopic();
    assertTrue(actualCreateTbCoreNotificationsMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(
        "Build Topic Name", actualCreateTbCoreNotificationsMsgProducerResult.getDefaultTopic());
  }

  /**
   * Test {@link InMemoryTbTransportQueueFactory#createTransportNotificationsConsumer()}.
   *
   * <p>Method under test: {@link
   * InMemoryTbTransportQueueFactory#createTransportNotificationsConsumer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsConsumer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueConsumer InMemoryTbTransportQueueFactory.createTransportNotificationsConsumer()"
  })
  void testCreateTransportNotificationsConsumer() {
    // Arrange
    when(tbQueueTransportNotificationSettings.getNotificationsTopic())
        .thenReturn("Notifications Topic");
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToTransportMsg>>
        actualCreateTransportNotificationsConsumerResult =
            inMemoryTbTransportQueueFactory.createTransportNotificationsConsumer();

    // Assert
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName(eq("Notifications Topic.42"));
    verify(tbQueueTransportNotificationSettings).getNotificationsTopic();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueProducer InMemoryTbTransportQueueFactory.createToUsageStatsServiceMsgProducer()"
  })
  void testCreateToUsageStatsServiceMsgProducer() {
    // Arrange
    when(tbQueueCoreSettings.getUsageStatsTopic()).thenReturn("Usage Stats Topic");
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToUsageStatsServiceMsg>>
        actualCreateToUsageStatsServiceMsgProducerResult =
            inMemoryTbTransportQueueFactory.createToUsageStatsServiceMsgProducer();

    // Assert
    verify(topicService).buildTopicName(eq("Usage Stats Topic"));
    verify(tbQueueCoreSettings).getUsageStatsTopic();
    assertTrue(actualCreateToUsageStatsServiceMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(
        "Build Topic Name", actualCreateToUsageStatsServiceMsgProducerResult.getDefaultTopic());
  }

  /**
   * Test {@link InMemoryTbTransportQueueFactory#createHousekeeperMsgProducer()}.
   *
   * <p>Method under test: {@link InMemoryTbTransportQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueProducer InMemoryTbTransportQueueFactory.createHousekeeperMsgProducer()"
  })
  void testCreateHousekeeperMsgProducer() {
    // Arrange
    when(tbQueueCoreSettings.getHousekeeperTopic()).thenReturn("Housekeeper Topic");
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToHousekeeperServiceMsg>>
        actualCreateHousekeeperMsgProducerResult =
            inMemoryTbTransportQueueFactory.createHousekeeperMsgProducer();

    // Assert
    verify(topicService).buildTopicName(eq("Housekeeper Topic"));
    verify(tbQueueCoreSettings).getHousekeeperTopic();
    assertTrue(actualCreateHousekeeperMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateHousekeeperMsgProducerResult.getDefaultTopic());
  }
}
