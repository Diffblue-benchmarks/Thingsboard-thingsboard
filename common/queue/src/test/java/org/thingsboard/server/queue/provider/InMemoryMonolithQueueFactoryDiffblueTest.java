package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
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
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ToCoreMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToEdgeMsg;
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
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.InMemoryTbQueueConsumer;
import org.thingsboard.server.queue.memory.InMemoryTbQueueProducer;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;

@ExtendWith(MockitoExtension.class)
class InMemoryMonolithQueueFactoryDiffblueTest {
  @InjectMocks private InMemoryMonolithQueueFactory inMemoryMonolithQueueFactory;

  @Mock private TbQueueCoreSettings tbQueueCoreSettings;

  @Mock private TbQueueEdgeSettings tbQueueEdgeSettings;

  @Mock private TbQueueRuleEngineSettings tbQueueRuleEngineSettings;

  @Mock private TbQueueTransportApiSettings tbQueueTransportApiSettings;

  @Mock private TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;

  @Mock private TbQueueVersionControlSettings tbQueueVersionControlSettings;

  @Mock private TopicService topicService;

  /**
   * Test {@link InMemoryMonolithQueueFactory#createTransportNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * InMemoryMonolithQueueFactory#createTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueProducer InMemoryMonolithQueueFactory.createTransportNotificationsMsgProducer()"
  })
  void testCreateTransportNotificationsMsgProducer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueTransportNotificationSettings.getNotificationsTopic())
        .thenReturn("Notifications Topic");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToTransportMsg>>
        actualCreateTransportNotificationsMsgProducerResult =
            inMemoryMonolithQueueFactory.createTransportNotificationsMsgProducer();

    // Assert
    verify(topicService).buildTopicName(eq("Notifications Topic"));
    verify(tbQueueTransportNotificationSettings).getNotificationsTopic();
    assertTrue(
        actualCreateTransportNotificationsMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(
        "Build Topic Name", actualCreateTransportNotificationsMsgProducerResult.getDefaultTopic());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createRuleEngineMsgProducer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbQueueProducer InMemoryMonolithQueueFactory.createRuleEngineMsgProducer()"})
  void testCreateRuleEngineMsgProducer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueRuleEngineSettings.getTopic()).thenReturn("Topic");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToRuleEngineMsg>> actualCreateRuleEngineMsgProducerResult =
        inMemoryMonolithQueueFactory.createRuleEngineMsgProducer();

    // Assert
    verify(topicService).buildTopicName(eq("Topic"));
    verify(tbQueueRuleEngineSettings).getTopic();
    assertTrue(actualCreateRuleEngineMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateRuleEngineMsgProducerResult.getDefaultTopic());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createRuleEngineNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * InMemoryMonolithQueueFactory#createRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineNotificationsMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueProducer InMemoryMonolithQueueFactory.createRuleEngineNotificationsMsgProducer()"
  })
  void testCreateRuleEngineNotificationsMsgProducer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueRuleEngineSettings.getTopic()).thenReturn("Topic");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToRuleEngineNotificationMsg>>
        actualCreateRuleEngineNotificationsMsgProducerResult =
            inMemoryMonolithQueueFactory.createRuleEngineNotificationsMsgProducer();

    // Assert
    verify(topicService).buildTopicName(eq("Topic"));
    verify(tbQueueRuleEngineSettings).getTopic();
    assertTrue(
        actualCreateRuleEngineNotificationsMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(
        "Build Topic Name", actualCreateRuleEngineNotificationsMsgProducerResult.getDefaultTopic());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createTbCoreMsgProducer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbQueueProducer InMemoryMonolithQueueFactory.createTbCoreMsgProducer()"})
  void testCreateTbCoreMsgProducer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueCoreSettings.getTopic()).thenReturn("Topic");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToCoreMsg>> actualCreateTbCoreMsgProducerResult =
        inMemoryMonolithQueueFactory.createTbCoreMsgProducer();

    // Assert
    verify(topicService).buildTopicName(eq("Topic"));
    verify(tbQueueCoreSettings).getTopic();
    assertTrue(actualCreateTbCoreMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateTbCoreMsgProducerResult.getDefaultTopic());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createToVersionControlMsgConsumer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createToVersionControlMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToVersionControlMsgConsumer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueConsumer InMemoryMonolithQueueFactory.createToVersionControlMsgConsumer()"
  })
  void testCreateToVersionControlMsgConsumer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueVersionControlSettings.getTopic()).thenReturn("Topic");

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToVersionControlServiceMsg>>
        actualCreateToVersionControlMsgConsumerResult =
            inMemoryMonolithQueueFactory.createToVersionControlMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(eq("Topic"));
    verify(tbQueueVersionControlSettings).getTopic();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueConsumer InMemoryMonolithQueueFactory.createToRuleEngineMsgConsumer(Queue)"
  })
  void testCreateToRuleEngineMsgConsumerWithConfiguration() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToRuleEngineMsg>> actualCreateToRuleEngineMsgConsumerResult =
        inMemoryMonolithQueueFactory.createToRuleEngineMsgConsumer(new Queue());

    // Assert
    verify(topicService).buildTopicName(isNull());
    assertTrue(actualCreateToRuleEngineMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateToRuleEngineMsgConsumerResult.getTopic());
    assertFalse(actualCreateToRuleEngineMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createToCoreMsgConsumer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createToCoreMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreMsgConsumer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbQueueConsumer InMemoryMonolithQueueFactory.createToCoreMsgConsumer()"})
  void testCreateToCoreMsgConsumer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueCoreSettings.getTopic()).thenReturn("Topic");

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToCoreMsg>> actualCreateToCoreMsgConsumerResult =
        inMemoryMonolithQueueFactory.createToCoreMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(eq("Topic"));
    verify(tbQueueCoreSettings).getTopic();
    assertTrue(actualCreateToCoreMsgConsumerResult instanceof InMemoryTbQueueConsumer);
    assertEquals("Build Topic Name", actualCreateToCoreMsgConsumerResult.getTopic());
    assertFalse(actualCreateToCoreMsgConsumerResult.isStopped());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createTransportApiRequestConsumer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createTransportApiRequestConsumer()}
   */
  @Test
  @DisplayName("Test createTransportApiRequestConsumer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueConsumer InMemoryMonolithQueueFactory.createTransportApiRequestConsumer()"
  })
  void testCreateTransportApiRequestConsumer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueTransportApiSettings.getRequestsTopic()).thenReturn("Requests Topic");

    // Act
    TbQueueConsumer<TbProtoQueueMsg<TransportApiRequestMsg>>
        actualCreateTransportApiRequestConsumerResult =
            inMemoryMonolithQueueFactory.createTransportApiRequestConsumer();

    // Assert
    verify(topicService).buildTopicName(eq("Requests Topic"));
    verify(tbQueueTransportApiSettings).getRequestsTopic();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueProducer InMemoryMonolithQueueFactory.createTransportApiResponseProducer()"
  })
  void testCreateTransportApiResponseProducer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueTransportApiSettings.getResponsesTopic()).thenReturn("Responses Topic");

    // Act
    TbQueueProducer<TbProtoQueueMsg<TransportApiResponseMsg>>
        actualCreateTransportApiResponseProducerResult =
            inMemoryMonolithQueueFactory.createTransportApiResponseProducer();

    // Assert
    verify(topicService).buildTopicName(eq("Responses Topic"));
    verify(tbQueueTransportApiSettings).getResponsesTopic();
    assertTrue(actualCreateTransportApiResponseProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(
        "Build Topic Name", actualCreateTransportApiResponseProducerResult.getDefaultTopic());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createRemoteJsRequestTemplate()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createRemoteJsRequestTemplate()}
   */
  @Test
  @DisplayName("Test createRemoteJsRequestTemplate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueRequestTemplate InMemoryMonolithQueueFactory.createRemoteJsRequestTemplate()"
  })
  void testCreateRemoteJsRequestTemplate() {
    // Arrange, Act and Assert
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueConsumer InMemoryMonolithQueueFactory.createToUsageStatsServiceMsgConsumer()"
  })
  void testCreateToUsageStatsServiceMsgConsumer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueCoreSettings.getUsageStatsTopic()).thenReturn("Usage Stats Topic");

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToUsageStatsServiceMsg>>
        actualCreateToUsageStatsServiceMsgConsumerResult =
            inMemoryMonolithQueueFactory.createToUsageStatsServiceMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(eq("Usage Stats Topic"));
    verify(tbQueueCoreSettings).getUsageStatsTopic();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueConsumer InMemoryMonolithQueueFactory.createToOtaPackageStateServiceMsgConsumer()"
  })
  void testCreateToOtaPackageStateServiceMsgConsumer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueCoreSettings.getOtaPackageTopic()).thenReturn("java.text");

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToOtaPackageStateServiceMsg>>
        actualCreateToOtaPackageStateServiceMsgConsumerResult =
            inMemoryMonolithQueueFactory.createToOtaPackageStateServiceMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(eq("java.text"));
    verify(tbQueueCoreSettings).getOtaPackageTopic();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueProducer InMemoryMonolithQueueFactory.createToOtaPackageStateServiceMsgProducer()"
  })
  void testCreateToOtaPackageStateServiceMsgProducer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueCoreSettings.getOtaPackageTopic()).thenReturn("java.text");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToOtaPackageStateServiceMsg>>
        actualCreateToOtaPackageStateServiceMsgProducerResult =
            inMemoryMonolithQueueFactory.createToOtaPackageStateServiceMsgProducer();

    // Assert
    verify(topicService).buildTopicName(eq("java.text"));
    verify(tbQueueCoreSettings).getOtaPackageTopic();
    assertTrue(
        actualCreateToOtaPackageStateServiceMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(
        "Build Topic Name",
        actualCreateToOtaPackageStateServiceMsgProducerResult.getDefaultTopic());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createToUsageStatsServiceMsgProducer()}.
   *
   * <p>Method under test: {@link
   * InMemoryMonolithQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueProducer InMemoryMonolithQueueFactory.createToUsageStatsServiceMsgProducer()"
  })
  void testCreateToUsageStatsServiceMsgProducer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueCoreSettings.getUsageStatsTopic()).thenReturn("Usage Stats Topic");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToUsageStatsServiceMsg>>
        actualCreateToUsageStatsServiceMsgProducerResult =
            inMemoryMonolithQueueFactory.createToUsageStatsServiceMsgProducer();

    // Assert
    verify(topicService).buildTopicName(eq("Usage Stats Topic"));
    verify(tbQueueCoreSettings).getUsageStatsTopic();
    assertTrue(actualCreateToUsageStatsServiceMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(
        "Build Topic Name", actualCreateToUsageStatsServiceMsgProducerResult.getDefaultTopic());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createVersionControlMsgProducer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test createVersionControlMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueProducer InMemoryMonolithQueueFactory.createVersionControlMsgProducer()"
  })
  void testCreateVersionControlMsgProducer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueVersionControlSettings.getTopic()).thenReturn("Topic");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToVersionControlServiceMsg>>
        actualCreateVersionControlMsgProducerResult =
            inMemoryMonolithQueueFactory.createVersionControlMsgProducer();

    // Assert
    verify(topicService).buildTopicName(eq("Topic"));
    verify(tbQueueVersionControlSettings).getTopic();
    assertTrue(actualCreateVersionControlMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateVersionControlMsgProducerResult.getDefaultTopic());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createHousekeeperMsgProducer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbQueueProducer InMemoryMonolithQueueFactory.createHousekeeperMsgProducer()"})
  void testCreateHousekeeperMsgProducer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueCoreSettings.getHousekeeperTopic()).thenReturn("Housekeeper Topic");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToHousekeeperServiceMsg>>
        actualCreateHousekeeperMsgProducerResult =
            inMemoryMonolithQueueFactory.createHousekeeperMsgProducer();

    // Assert
    verify(topicService).buildTopicName(eq("Housekeeper Topic"));
    verify(tbQueueCoreSettings).getHousekeeperTopic();
    assertTrue(actualCreateHousekeeperMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateHousekeeperMsgProducerResult.getDefaultTopic());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createHousekeeperMsgConsumer()}.
   *
   * <p>Method under test: {@link InMemoryMonolithQueueFactory#createHousekeeperMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgConsumer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbQueueConsumer InMemoryMonolithQueueFactory.createHousekeeperMsgConsumer()"})
  void testCreateHousekeeperMsgConsumer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueCoreSettings.getHousekeeperTopic()).thenReturn("Housekeeper Topic");

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToHousekeeperServiceMsg>>
        actualCreateHousekeeperMsgConsumerResult =
            inMemoryMonolithQueueFactory.createHousekeeperMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(eq("Housekeeper Topic"));
    verify(tbQueueCoreSettings).getHousekeeperTopic();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueProducer InMemoryMonolithQueueFactory.createHousekeeperReprocessingMsgProducer()"
  })
  void testCreateHousekeeperReprocessingMsgProducer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueCoreSettings.getHousekeeperReprocessingTopic())
        .thenReturn("Housekeeper Reprocessing Topic");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToHousekeeperServiceMsg>>
        actualCreateHousekeeperReprocessingMsgProducerResult =
            inMemoryMonolithQueueFactory.createHousekeeperReprocessingMsgProducer();

    // Assert
    verify(topicService).buildTopicName(eq("Housekeeper Reprocessing Topic"));
    verify(tbQueueCoreSettings).getHousekeeperReprocessingTopic();
    assertTrue(
        actualCreateHousekeeperReprocessingMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals(
        "Build Topic Name", actualCreateHousekeeperReprocessingMsgProducerResult.getDefaultTopic());
  }

  /**
   * Test {@link InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgConsumer()}.
   *
   * <p>Method under test: {@link
   * InMemoryMonolithQueueFactory#createHousekeeperReprocessingMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgConsumer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbQueueConsumer InMemoryMonolithQueueFactory.createHousekeeperReprocessingMsgConsumer()"
  })
  void testCreateHousekeeperReprocessingMsgConsumer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueCoreSettings.getHousekeeperReprocessingTopic())
        .thenReturn("Housekeeper Reprocessing Topic");

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToHousekeeperServiceMsg>>
        actualCreateHousekeeperReprocessingMsgConsumerResult =
            inMemoryMonolithQueueFactory.createHousekeeperReprocessingMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(eq("Housekeeper Reprocessing Topic"));
    verify(tbQueueCoreSettings).getHousekeeperReprocessingTopic();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbQueueConsumer InMemoryMonolithQueueFactory.createEdgeMsgConsumer()"})
  void testCreateEdgeMsgConsumer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueEdgeSettings.getTopic()).thenReturn("Topic");

    // Act
    TbQueueConsumer<TbProtoQueueMsg<ToEdgeMsg>> actualCreateEdgeMsgConsumerResult =
        inMemoryMonolithQueueFactory.createEdgeMsgConsumer();

    // Assert
    verify(topicService).buildTopicName(eq("Topic"));
    verify(tbQueueEdgeSettings).getTopic();
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbQueueProducer InMemoryMonolithQueueFactory.createEdgeMsgProducer()"})
  void testCreateEdgeMsgProducer() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbQueueEdgeSettings.getTopic()).thenReturn("Topic");

    // Act
    TbQueueProducer<TbProtoQueueMsg<ToEdgeMsg>> actualCreateEdgeMsgProducerResult =
        inMemoryMonolithQueueFactory.createEdgeMsgProducer();

    // Assert
    verify(topicService).buildTopicName(eq("Topic"));
    verify(tbQueueEdgeSettings).getTopic();
    assertTrue(actualCreateEdgeMsgProducerResult instanceof InMemoryTbQueueProducer);
    assertEquals("Build Topic Name", actualCreateEdgeMsgProducerResult.getDefaultTopic());
  }
}
