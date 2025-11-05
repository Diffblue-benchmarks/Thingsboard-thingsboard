package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Properties;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo.TopicPartitionInfoBuilder;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.kafka.TbKafkaConsumerStatisticConfig;
import org.thingsboard.server.queue.kafka.TbKafkaConsumerStatsService;
import org.thingsboard.server.queue.kafka.TbKafkaSettings;
import org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRemoteJsInvokeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class KafkaMonolithQueueFactoryDiffblueTest {
  @InjectMocks private KafkaMonolithQueueFactory kafkaMonolithQueueFactory;

  @Mock private TbKafkaConsumerStatsService tbKafkaConsumerStatsService;

  @Mock private TbKafkaSettings tbKafkaSettings;

  @Mock private TbKafkaTopicConfigs tbKafkaTopicConfigs;

  @Mock private TbQueueCoreSettings tbQueueCoreSettings;

  @Mock private TbQueueEdgeSettings tbQueueEdgeSettings;

  @Mock private TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;

  @Mock private TbQueueRuleEngineSettings tbQueueRuleEngineSettings;

  @Mock private TbQueueTransportApiSettings tbQueueTransportApiSettings;

  @Mock private TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;

  @Mock private TbQueueVersionControlSettings tbQueueVersionControlSettings;

  @Mock private TbServiceInfoProvider tbServiceInfoProvider;

  @Mock private TopicService topicService;

  /**
   * Test {@link KafkaMonolithQueueFactory#createTransportNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createTransportNotificationsMsgProducer()"
  })
  void testCreateTransportNotificationsMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createTransportNotificationsMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createTransportNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createTransportNotificationsMsgProducer()"
  })
  void testCreateTransportNotificationsMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueTransportNotificationSettings.getNotificationsTopic())
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createTransportNotificationsMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueTransportNotificationSettings).getNotificationsTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createTransportNotificationsMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createTransportNotificationsMsgProducer()"
  })
  void testCreateTransportNotificationsMsgProducer_thenCallsBuildTopicName() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toProducerProps()).thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueTransportNotificationSettings.getNotificationsTopic())
        .thenReturn("Notifications Topic");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createTransportNotificationsMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("Notifications Topic");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueTransportNotificationSettings).getNotificationsTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createRuleEngineMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createRuleEngineMsgProducer()"
  })
  void testCreateRuleEngineMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createRuleEngineMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createRuleEngineMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createRuleEngineMsgProducer()"
  })
  void testCreateRuleEngineMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueRuleEngineSettings.getTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createRuleEngineMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueRuleEngineSettings).getTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createRuleEngineMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createRuleEngineMsgProducer()"
  })
  void testCreateRuleEngineMsgProducer_thenCallsBuildTopicName() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toProducerProps()).thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueRuleEngineSettings.getTopic()).thenReturn("Topic");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createRuleEngineMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("Topic");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueRuleEngineSettings).getTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createRuleEngineNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createRuleEngineNotificationsMsgProducer()"
  })
  void testCreateRuleEngineNotificationsMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createRuleEngineNotificationsMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createRuleEngineNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createRuleEngineNotificationsMsgProducer()"
  })
  void testCreateRuleEngineNotificationsMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueRuleEngineSettings.getTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createRuleEngineNotificationsMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueRuleEngineSettings).getTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createRuleEngineNotificationsMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineNotificationsMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createRuleEngineNotificationsMsgProducer()"
  })
  void testCreateRuleEngineNotificationsMsgProducer_thenCallsBuildTopicName() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toProducerProps()).thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueRuleEngineSettings.getTopic()).thenReturn("Topic");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createRuleEngineNotificationsMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("Topic");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueRuleEngineSettings).getTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createTbCoreMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createTbCoreMsgProducer()"
  })
  void testCreateTbCoreMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createTbCoreMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createTbCoreMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createTbCoreMsgProducer()"
  })
  void testCreateTbCoreMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createTbCoreMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueCoreSettings).getTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createTbCoreMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createTbCoreMsgProducer()"
  })
  void testCreateTbCoreMsgProducer_thenCallsBuildTopicName() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toProducerProps()).thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getTopic()).thenReturn("Topic");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createTbCoreMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("Topic");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueCoreSettings).getTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createTbCoreNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createTbCoreNotificationsMsgProducer()"
  })
  void testCreateTbCoreNotificationsMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createTbCoreNotificationsMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createTbCoreNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createTbCoreNotificationsMsgProducer()"
  })
  void testCreateTbCoreNotificationsMsgProducer2() {
    // Arrange
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createTbCoreNotificationsMsgProducer());
    verify(tbServiceInfoProvider, atLeast(1)).getServiceId();
    verify(topicService).getNotificationsTopic(ServiceType.TB_CORE, "42");
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createTbCoreNotificationsMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbKafkaSettings#toProducerProps()}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer(); then calls toProducerProps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createTbCoreNotificationsMsgProducer()"
  })
  void testCreateTbCoreNotificationsMsgProducer_thenCallsToProducerProps() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(tbKafkaSettings.toProducerProps()).thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createTbCoreNotificationsMsgProducer());
    verify(tbServiceInfoProvider, atLeast(1)).getServiceId();
    verify(topicService).getNotificationsTopic(ServiceType.TB_CORE, "42");
    verify(tbKafkaSettings).toProducerProps();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToVersionControlMsgConsumer()}.
   *
   * <ul>
   *   <li>Given {@link TbKafkaSettings}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToVersionControlMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToVersionControlMsgConsumer(); given TbKafkaSettings")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToVersionControlMsgConsumer()"
  })
  void testCreateToVersionControlMsgConsumer_givenTbKafkaSettings() {
    // Arrange
    when(tbQueueVersionControlSettings.getTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToVersionControlMsgConsumer());
    verify(tbQueueVersionControlSettings).getTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToVersionControlMsgConsumer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbServiceInfoProvider#getServiceId()}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToVersionControlMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToVersionControlMsgConsumer(); then calls getServiceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToVersionControlMsgConsumer()"
  })
  void testCreateToVersionControlMsgConsumer_thenCallsGetServiceId() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toConsumerProps(Mockito.<String>any())).thenReturn(new Properties());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueVersionControlSettings.getTopic()).thenReturn("Topic");
    doThrow(new UnsupportedOperationException())
        .when(tbKafkaConsumerStatsService)
        .registerClientGroup(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToVersionControlMsgConsumer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService, atLeast(1)).buildTopicName(Mockito.<String>any());
    verify(tbKafkaConsumerStatsService).registerClientGroup("Build Topic Name");
    verify(tbKafkaSettings).toConsumerProps("Build Topic Name");
    verify(tbQueueVersionControlSettings).getTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToRuleEngineMsgConsumer(Queue)} with {@code
   * configuration}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToRuleEngineMsgConsumer(Queue)}
   */
  @Test
  @DisplayName("Test createToRuleEngineMsgConsumer(Queue) with 'configuration'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToRuleEngineMsgConsumer(Queue)"
  })
  void testCreateToRuleEngineMsgConsumerWithConfiguration() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToRuleEngineMsgConsumer(new Queue()));
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToRuleEngineMsgConsumer(Queue, Integer)} with
   * {@code configuration}, {@code partitionId}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToRuleEngineMsgConsumer(Queue,
   * Integer)}
   */
  @Test
  @DisplayName(
      "Test createToRuleEngineMsgConsumer(Queue, Integer) with 'configuration', 'partitionId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToRuleEngineMsgConsumer(Queue, Integer)"
  })
  void testCreateToRuleEngineMsgConsumerWithConfigurationPartitionId() {
    // Arrange
    when(topicService.buildConsumerGroupId(
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<String>any(),
            Mockito.<Integer>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToRuleEngineMsgConsumer(new Queue(), 1));
    verify(topicService).buildConsumerGroupId(eq("re-"), isNull(), isNull(), eq(1));
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToRuleEngineMsgConsumer(Queue, Integer)} with
   * {@code configuration}, {@code partitionId}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToRuleEngineMsgConsumer(Queue,
   * Integer)}
   */
  @Test
  @DisplayName(
      "Test createToRuleEngineMsgConsumer(Queue, Integer) with 'configuration', 'partitionId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToRuleEngineMsgConsumer(Queue, Integer)"
  })
  void testCreateToRuleEngineMsgConsumerWithConfigurationPartitionId2() {
    // Arrange
    when(topicService.buildConsumerGroupId(
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<String>any(),
            Mockito.<Integer>any()))
        .thenReturn("42");
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toConsumerProps(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(tbKafkaSettings.getAdminClient()).thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToRuleEngineMsgConsumer(new Queue(), 1));
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService, atLeast(1))
        .buildConsumerGroupId(eq("re-"), isNull(), isNull(), Mockito.<Integer>any());
    verify(topicService).buildTopicName(null);
    verify(tbKafkaSettings).getAdminClient();
    verify(tbKafkaSettings).toConsumerProps("Build Topic Name");
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToRuleEngineMsgConsumer(Queue, Integer)} with
   * {@code configuration}, {@code partitionId}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToRuleEngineMsgConsumer(Queue,
   * Integer)}
   */
  @Test
  @DisplayName(
      "Test createToRuleEngineMsgConsumer(Queue, Integer) with 'configuration', 'partitionId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToRuleEngineMsgConsumer(Queue, Integer)"
  })
  void testCreateToRuleEngineMsgConsumerWithConfigurationPartitionId3() {
    // Arrange
    when(topicService.buildConsumerGroupId(
            Mockito.<String>any(),
            Mockito.<TenantId>any(),
            Mockito.<String>any(),
            Mockito.<Integer>any()))
        .thenReturn("42");
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toConsumerProps(Mockito.<String>any())).thenReturn(new Properties());
    when(tbKafkaSettings.getAdminClient()).thenReturn(null);
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    doThrow(new UnsupportedOperationException())
        .when(tbKafkaConsumerStatsService)
        .registerClientGroup(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToRuleEngineMsgConsumer(new Queue(), 1));
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService, atLeast(1))
        .buildConsumerGroupId(eq("re-"), isNull(), isNull(), Mockito.<Integer>any());
    verify(topicService).buildTopicName(null);
    verify(tbKafkaConsumerStatsService).registerClientGroup("42");
    verify(tbKafkaSettings).getAdminClient();
    verify(tbKafkaSettings).toConsumerProps("Build Topic Name");
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToRuleEngineNotificationsMsgConsumer()}.
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createToRuleEngineNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToRuleEngineNotificationsMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToRuleEngineNotificationsMsgConsumer()"
  })
  void testCreateToRuleEngineNotificationsMsgConsumer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToRuleEngineNotificationsMsgConsumer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToRuleEngineNotificationsMsgConsumer()}.
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createToRuleEngineNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToRuleEngineNotificationsMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToRuleEngineNotificationsMsgConsumer()"
  })
  void testCreateToRuleEngineNotificationsMsgConsumer2() {
    // Arrange
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToRuleEngineNotificationsMsgConsumer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).getNotificationsTopic(ServiceType.TB_RULE_ENGINE, "42");
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToRuleEngineNotificationsMsgConsumer()}.
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createToRuleEngineNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToRuleEngineNotificationsMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToRuleEngineNotificationsMsgConsumer()"
  })
  void testCreateToRuleEngineNotificationsMsgConsumer3() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(tbKafkaSettings.toConsumerProps(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToRuleEngineNotificationsMsgConsumer());
    verify(tbServiceInfoProvider, atLeast(1)).getServiceId();
    verify(topicService).buildTopicName("monolith-rule-engine-notifications-consumer-42");
    verify(topicService).getNotificationsTopic(ServiceType.TB_RULE_ENGINE, "42");
    verify(tbKafkaSettings)
        .toConsumerProps("Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1");
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToRuleEngineNotificationsMsgConsumer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbKafkaTopicConfigs#getCoreConfigs()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createToRuleEngineNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToRuleEngineNotificationsMsgConsumer(); then calls getCoreConfigs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToRuleEngineNotificationsMsgConsumer()"
  })
  void testCreateToRuleEngineNotificationsMsgConsumer_thenCallsGetCoreConfigs() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());

    TbKafkaTopicConfigs kafkaTopicConfigs = mock(TbKafkaTopicConfigs.class);
    when(kafkaTopicConfigs.getCoreConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getEdgeConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getFwUpdatesConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getHousekeeperConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getHousekeeperReprocessingConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getJsExecutorRequestConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getJsExecutorResponseConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getNotificationsConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getRuleEngineConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getTransportApiRequestConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getTransportApiResponseConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getVcConfigs()).thenReturn(new HashMap<>());
    TbKafkaSettings kafkaSettings = new TbKafkaSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueRemoteJsInvokeSettings jsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbKafkaSettings kafkaSettings2 = new TbKafkaSettings();
    TbKafkaConsumerStatsService consumerStatsService =
        new TbKafkaConsumerStatsService(kafkaSettings2, new TbKafkaConsumerStatisticConfig());

    KafkaMonolithQueueFactory kafkaMonolithQueueFactory =
        new KafkaMonolithQueueFactory(
            topicService,
            kafkaSettings,
            serviceInfoProvider,
            coreSettings,
            ruleEngineSettings,
            transportApiSettings,
            transportNotificationSettings,
            jsInvokeSettings,
            vcSettings,
            edgeSettings,
            consumerStatsService,
            kafkaTopicConfigs);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToRuleEngineNotificationsMsgConsumer());
    verify(topicService).buildTopicName("monolith-rule-engine-notifications-consumer-null");
    verify(topicService).getNotificationsTopic(ServiceType.TB_RULE_ENGINE, null);
    verify(kafkaTopicConfigs).getCoreConfigs();
    verify(kafkaTopicConfigs).getEdgeConfigs();
    verify(kafkaTopicConfigs).getFwUpdatesConfigs();
    verify(kafkaTopicConfigs).getHousekeeperConfigs();
    verify(kafkaTopicConfigs).getHousekeeperReprocessingConfigs();
    verify(kafkaTopicConfigs).getJsExecutorRequestConfigs();
    verify(kafkaTopicConfigs).getJsExecutorResponseConfigs();
    verify(kafkaTopicConfigs).getNotificationsConfigs();
    verify(kafkaTopicConfigs).getRuleEngineConfigs();
    verify(kafkaTopicConfigs).getTransportApiRequestConfigs();
    verify(kafkaTopicConfigs).getTransportApiResponseConfigs();
    verify(kafkaTopicConfigs).getVcConfigs();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToRuleEngineNotificationsMsgConsumer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbKafkaConsumerStatsService#registerClientGroup(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createToRuleEngineNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName(
      "Test createToRuleEngineNotificationsMsgConsumer(); then calls registerClientGroup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToRuleEngineNotificationsMsgConsumer()"
  })
  void testCreateToRuleEngineNotificationsMsgConsumer_thenCallsRegisterClientGroup() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(tbKafkaSettings.toConsumerProps(Mockito.<String>any())).thenReturn(new Properties());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    doThrow(new UnsupportedOperationException())
        .when(tbKafkaConsumerStatsService)
        .registerClientGroup(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToRuleEngineNotificationsMsgConsumer());
    verify(tbServiceInfoProvider, atLeast(1)).getServiceId();
    verify(topicService).buildTopicName("monolith-rule-engine-notifications-consumer-42");
    verify(topicService).getNotificationsTopic(ServiceType.TB_RULE_ENGINE, "42");
    verify(tbKafkaConsumerStatsService).registerClientGroup("Build Topic Name");
    verify(tbKafkaSettings)
        .toConsumerProps("Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1");
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToCoreMsgConsumer()}.
   *
   * <ul>
   *   <li>Given {@link TbKafkaSettings}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToCoreMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreMsgConsumer(); given TbKafkaSettings")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToCoreMsgConsumer()"
  })
  void testCreateToCoreMsgConsumer_givenTbKafkaSettings() {
    // Arrange
    when(tbQueueCoreSettings.getTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToCoreMsgConsumer());
    verify(tbQueueCoreSettings).getTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToCoreMsgConsumer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbServiceInfoProvider#getServiceId()}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToCoreMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreMsgConsumer(); then calls getServiceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToCoreMsgConsumer()"
  })
  void testCreateToCoreMsgConsumer_thenCallsGetServiceId() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toConsumerProps(Mockito.<String>any())).thenReturn(new Properties());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getTopic()).thenReturn("Topic");
    doThrow(new UnsupportedOperationException())
        .when(tbKafkaConsumerStatsService)
        .registerClientGroup(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToCoreMsgConsumer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService, atLeast(1)).buildTopicName(Mockito.<String>any());
    verify(tbKafkaConsumerStatsService).registerClientGroup("Build Topic Name");
    verify(tbKafkaSettings).toConsumerProps("Build Topic Name");
    verify(tbQueueCoreSettings).getTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreNotificationsMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToCoreNotificationsMsgConsumer()"
  })
  void testCreateToCoreNotificationsMsgConsumer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToCoreNotificationsMsgConsumer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreNotificationsMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToCoreNotificationsMsgConsumer()"
  })
  void testCreateToCoreNotificationsMsgConsumer2() {
    // Arrange
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToCoreNotificationsMsgConsumer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).getNotificationsTopic(ServiceType.TB_CORE, "42");
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreNotificationsMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToCoreNotificationsMsgConsumer()"
  })
  void testCreateToCoreNotificationsMsgConsumer3() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(tbKafkaSettings.toConsumerProps(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToCoreNotificationsMsgConsumer());
    verify(tbServiceInfoProvider, atLeast(1)).getServiceId();
    verify(topicService).buildTopicName("monolith-core-notifications-consumer-42");
    verify(topicService).getNotificationsTopic(ServiceType.TB_CORE, "42");
    verify(tbKafkaSettings)
        .toConsumerProps("Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1");
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbKafkaTopicConfigs#getCoreConfigs()}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToCoreNotificationsMsgConsumer(); then calls getCoreConfigs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToCoreNotificationsMsgConsumer()"
  })
  void testCreateToCoreNotificationsMsgConsumer_thenCallsGetCoreConfigs() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());

    TbKafkaTopicConfigs kafkaTopicConfigs = mock(TbKafkaTopicConfigs.class);
    when(kafkaTopicConfigs.getCoreConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getEdgeConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getFwUpdatesConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getHousekeeperConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getHousekeeperReprocessingConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getJsExecutorRequestConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getJsExecutorResponseConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getNotificationsConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getRuleEngineConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getTransportApiRequestConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getTransportApiResponseConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getVcConfigs()).thenReturn(new HashMap<>());
    TbKafkaSettings kafkaSettings = new TbKafkaSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueRemoteJsInvokeSettings jsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbKafkaSettings kafkaSettings2 = new TbKafkaSettings();
    TbKafkaConsumerStatsService consumerStatsService =
        new TbKafkaConsumerStatsService(kafkaSettings2, new TbKafkaConsumerStatisticConfig());

    KafkaMonolithQueueFactory kafkaMonolithQueueFactory =
        new KafkaMonolithQueueFactory(
            topicService,
            kafkaSettings,
            serviceInfoProvider,
            coreSettings,
            ruleEngineSettings,
            transportApiSettings,
            transportNotificationSettings,
            jsInvokeSettings,
            vcSettings,
            edgeSettings,
            consumerStatsService,
            kafkaTopicConfigs);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToCoreNotificationsMsgConsumer());
    verify(topicService).buildTopicName("monolith-core-notifications-consumer-null");
    verify(topicService).getNotificationsTopic(ServiceType.TB_CORE, null);
    verify(kafkaTopicConfigs).getCoreConfigs();
    verify(kafkaTopicConfigs).getEdgeConfigs();
    verify(kafkaTopicConfigs).getFwUpdatesConfigs();
    verify(kafkaTopicConfigs).getHousekeeperConfigs();
    verify(kafkaTopicConfigs).getHousekeeperReprocessingConfigs();
    verify(kafkaTopicConfigs).getJsExecutorRequestConfigs();
    verify(kafkaTopicConfigs).getJsExecutorResponseConfigs();
    verify(kafkaTopicConfigs).getNotificationsConfigs();
    verify(kafkaTopicConfigs).getRuleEngineConfigs();
    verify(kafkaTopicConfigs).getTransportApiRequestConfigs();
    verify(kafkaTopicConfigs).getTransportApiResponseConfigs();
    verify(kafkaTopicConfigs).getVcConfigs();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbKafkaConsumerStatsService#registerClientGroup(String)}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName(
      "Test createToCoreNotificationsMsgConsumer(); then calls registerClientGroup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToCoreNotificationsMsgConsumer()"
  })
  void testCreateToCoreNotificationsMsgConsumer_thenCallsRegisterClientGroup() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(tbKafkaSettings.toConsumerProps(Mockito.<String>any())).thenReturn(new Properties());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    doThrow(new UnsupportedOperationException())
        .when(tbKafkaConsumerStatsService)
        .registerClientGroup(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToCoreNotificationsMsgConsumer());
    verify(tbServiceInfoProvider, atLeast(1)).getServiceId();
    verify(topicService).buildTopicName("monolith-core-notifications-consumer-42");
    verify(topicService).getNotificationsTopic(ServiceType.TB_CORE, "42");
    verify(tbKafkaConsumerStatsService).registerClientGroup("Build Topic Name");
    verify(tbKafkaSettings)
        .toConsumerProps("Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1");
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createTransportApiRequestConsumer()}.
   *
   * <ul>
   *   <li>Given {@link TbKafkaSettings}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createTransportApiRequestConsumer()}
   */
  @Test
  @DisplayName("Test createTransportApiRequestConsumer(); given TbKafkaSettings")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createTransportApiRequestConsumer()"
  })
  void testCreateTransportApiRequestConsumer_givenTbKafkaSettings() {
    // Arrange
    when(tbQueueTransportApiSettings.getRequestsTopic())
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createTransportApiRequestConsumer());
    verify(tbQueueTransportApiSettings).getRequestsTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createTransportApiRequestConsumer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbServiceInfoProvider#getServiceId()}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createTransportApiRequestConsumer()}
   */
  @Test
  @DisplayName("Test createTransportApiRequestConsumer(); then calls getServiceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createTransportApiRequestConsumer()"
  })
  void testCreateTransportApiRequestConsumer_thenCallsGetServiceId() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toConsumerProps(Mockito.<String>any())).thenReturn(new Properties());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueTransportApiSettings.getRequestsTopic()).thenReturn("Requests Topic");
    doThrow(new UnsupportedOperationException())
        .when(tbKafkaConsumerStatsService)
        .registerClientGroup(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createTransportApiRequestConsumer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService, atLeast(1)).buildTopicName(Mockito.<String>any());
    verify(tbKafkaConsumerStatsService).registerClientGroup("Build Topic Name");
    verify(tbKafkaSettings).toConsumerProps("Build Topic Name");
    verify(tbQueueTransportApiSettings).getRequestsTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createTransportApiResponseProducer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createTransportApiResponseProducer()}
   */
  @Test
  @DisplayName("Test createTransportApiResponseProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createTransportApiResponseProducer()"
  })
  void testCreateTransportApiResponseProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createTransportApiResponseProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createTransportApiResponseProducer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createTransportApiResponseProducer()}
   */
  @Test
  @DisplayName("Test createTransportApiResponseProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createTransportApiResponseProducer()"
  })
  void testCreateTransportApiResponseProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueTransportApiSettings.getResponsesTopic())
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createTransportApiResponseProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueTransportApiSettings).getResponsesTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createTransportApiResponseProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createTransportApiResponseProducer()}
   */
  @Test
  @DisplayName("Test createTransportApiResponseProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createTransportApiResponseProducer()"
  })
  void testCreateTransportApiResponseProducer_thenCallsBuildTopicName() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toProducerProps()).thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueTransportApiSettings.getResponsesTopic()).thenReturn("Responses Topic");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createTransportApiResponseProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("Responses Topic");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueTransportApiSettings).getResponsesTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createRemoteJsRequestTemplate()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createRemoteJsRequestTemplate()}
   */
  @Test
  @DisplayName("Test createRemoteJsRequestTemplate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueRequestTemplate KafkaMonolithQueueFactory.createRemoteJsRequestTemplate()"
  })
  void testCreateRemoteJsRequestTemplate() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createRemoteJsRequestTemplate());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createRemoteJsRequestTemplate()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createRemoteJsRequestTemplate()}
   */
  @Test
  @DisplayName("Test createRemoteJsRequestTemplate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueRequestTemplate KafkaMonolithQueueFactory.createRemoteJsRequestTemplate()"
  })
  void testCreateRemoteJsRequestTemplate2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueRemoteJsInvokeSettings.getRequestTopic())
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createRemoteJsRequestTemplate());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueRemoteJsInvokeSettings).getRequestTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createRemoteJsRequestTemplate()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createRemoteJsRequestTemplate()}
   */
  @Test
  @DisplayName("Test createRemoteJsRequestTemplate(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueRequestTemplate KafkaMonolithQueueFactory.createRemoteJsRequestTemplate()"
  })
  void testCreateRemoteJsRequestTemplate_thenCallsBuildTopicName() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toProducerProps()).thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueRemoteJsInvokeSettings.getRequestTopic()).thenReturn("Request Topic");
    when(tbQueueRemoteJsInvokeSettings.getResponseTopic()).thenReturn("Response Topic");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createRemoteJsRequestTemplate());
    verify(tbServiceInfoProvider, atLeast(1)).getServiceId();
    verify(topicService).buildTopicName("rule-engine-node-");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueRemoteJsInvokeSettings).getRequestTopic();
    verify(tbQueueRemoteJsInvokeSettings).getResponseTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToUsageStatsServiceMsgConsumer()}.
   *
   * <ul>
   *   <li>Given {@link TbKafkaSettings}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToUsageStatsServiceMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgConsumer(); given TbKafkaSettings")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToUsageStatsServiceMsgConsumer()"
  })
  void testCreateToUsageStatsServiceMsgConsumer_givenTbKafkaSettings() {
    // Arrange
    when(tbQueueCoreSettings.getUsageStatsTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToUsageStatsServiceMsgConsumer());
    verify(tbQueueCoreSettings).getUsageStatsTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToUsageStatsServiceMsgConsumer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbServiceInfoProvider#getServiceId()}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToUsageStatsServiceMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgConsumer(); then calls getServiceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToUsageStatsServiceMsgConsumer()"
  })
  void testCreateToUsageStatsServiceMsgConsumer_thenCallsGetServiceId() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toConsumerProps(Mockito.<String>any())).thenReturn(new Properties());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getUsageStatsTopic()).thenReturn("Usage Stats Topic");
    doThrow(new UnsupportedOperationException())
        .when(tbKafkaConsumerStatsService)
        .registerClientGroup(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToUsageStatsServiceMsgConsumer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService, atLeast(1)).buildTopicName(Mockito.<String>any());
    verify(tbKafkaConsumerStatsService).registerClientGroup("Build Topic Name");
    verify(tbKafkaSettings).toConsumerProps("Build Topic Name");
    verify(tbQueueCoreSettings).getUsageStatsTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToOtaPackageStateServiceMsgConsumer()}.
   *
   * <ul>
   *   <li>Given {@link TbKafkaSettings}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createToOtaPackageStateServiceMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgConsumer(); given TbKafkaSettings")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToOtaPackageStateServiceMsgConsumer()"
  })
  void testCreateToOtaPackageStateServiceMsgConsumer_givenTbKafkaSettings() {
    // Arrange
    when(tbQueueCoreSettings.getOtaPackageTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToOtaPackageStateServiceMsgConsumer());
    verify(tbQueueCoreSettings).getOtaPackageTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToOtaPackageStateServiceMsgConsumer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbServiceInfoProvider#getServiceId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createToOtaPackageStateServiceMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgConsumer(); then calls getServiceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToOtaPackageStateServiceMsgConsumer()"
  })
  void testCreateToOtaPackageStateServiceMsgConsumer_thenCallsGetServiceId() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toConsumerProps(Mockito.<String>any())).thenReturn(new Properties());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getOtaPackageTopic()).thenReturn("java.text");
    doThrow(new UnsupportedOperationException())
        .when(tbKafkaConsumerStatsService)
        .registerClientGroup(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToOtaPackageStateServiceMsgConsumer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService, atLeast(1)).buildTopicName(Mockito.<String>any());
    verify(tbKafkaConsumerStatsService).registerClientGroup("Build Topic Name");
    verify(tbKafkaSettings).toConsumerProps("Build Topic Name");
    verify(tbQueueCoreSettings).getOtaPackageTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToOtaPackageStateServiceMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createToOtaPackageStateServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createToOtaPackageStateServiceMsgProducer()"
  })
  void testCreateToOtaPackageStateServiceMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToOtaPackageStateServiceMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToOtaPackageStateServiceMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createToOtaPackageStateServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createToOtaPackageStateServiceMsgProducer()"
  })
  void testCreateToOtaPackageStateServiceMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getOtaPackageTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToOtaPackageStateServiceMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueCoreSettings).getOtaPackageTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToOtaPackageStateServiceMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createToOtaPackageStateServiceMsgProducer()}
   */
  @Test
  @DisplayName(
      "Test createToOtaPackageStateServiceMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createToOtaPackageStateServiceMsgProducer()"
  })
  void testCreateToOtaPackageStateServiceMsgProducer_thenCallsBuildTopicName() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toProducerProps()).thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getOtaPackageTopic()).thenReturn("java.text");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToOtaPackageStateServiceMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("java.text");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueCoreSettings).getOtaPackageTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToUsageStatsServiceMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createToUsageStatsServiceMsgProducer()"
  })
  void testCreateToUsageStatsServiceMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToUsageStatsServiceMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToUsageStatsServiceMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createToUsageStatsServiceMsgProducer()"
  })
  void testCreateToUsageStatsServiceMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getUsageStatsTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToUsageStatsServiceMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueCoreSettings).getUsageStatsTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToUsageStatsServiceMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createToUsageStatsServiceMsgProducer()"
  })
  void testCreateToUsageStatsServiceMsgProducer_thenCallsBuildTopicName() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toProducerProps()).thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getUsageStatsTopic()).thenReturn("Usage Stats Topic");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToUsageStatsServiceMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("Usage Stats Topic");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueCoreSettings).getUsageStatsTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createVersionControlMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test createVersionControlMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createVersionControlMsgProducer()"
  })
  void testCreateVersionControlMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createVersionControlMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createVersionControlMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test createVersionControlMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createVersionControlMsgProducer()"
  })
  void testCreateVersionControlMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueVersionControlSettings.getTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createVersionControlMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueVersionControlSettings).getTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createVersionControlMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test createVersionControlMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createVersionControlMsgProducer()"
  })
  void testCreateVersionControlMsgProducer_thenCallsBuildTopicName() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toProducerProps()).thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueVersionControlSettings.getTopic()).thenReturn("Topic");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createVersionControlMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("Topic");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueVersionControlSettings).getTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createHousekeeperMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createHousekeeperMsgProducer()"
  })
  void testCreateHousekeeperMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createHousekeeperMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createHousekeeperMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createHousekeeperMsgProducer()"
  })
  void testCreateHousekeeperMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getHousekeeperTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createHousekeeperMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueCoreSettings).getHousekeeperTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createHousekeeperMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createHousekeeperMsgProducer()"
  })
  void testCreateHousekeeperMsgProducer_thenCallsBuildTopicName() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toProducerProps()).thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getHousekeeperTopic()).thenReturn("Housekeeper Topic");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createHousekeeperMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("Housekeeper Topic");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueCoreSettings).getHousekeeperTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createHousekeeperMsgConsumer()}.
   *
   * <ul>
   *   <li>Given {@link TbKafkaSettings}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createHousekeeperMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgConsumer(); given TbKafkaSettings")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createHousekeeperMsgConsumer()"
  })
  void testCreateHousekeeperMsgConsumer_givenTbKafkaSettings() {
    // Arrange
    when(tbQueueCoreSettings.getHousekeeperTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createHousekeeperMsgConsumer());
    verify(tbQueueCoreSettings).getHousekeeperTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createHousekeeperMsgConsumer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbServiceInfoProvider#getServiceId()}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createHousekeeperMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgConsumer(); then calls getServiceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createHousekeeperMsgConsumer()"
  })
  void testCreateHousekeeperMsgConsumer_thenCallsGetServiceId() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toConsumerProps(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getHousekeeperTopic()).thenReturn("Housekeeper Topic");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createHousekeeperMsgConsumer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService, atLeast(1)).buildTopicName(Mockito.<String>any());
    verify(tbKafkaSettings).toConsumerProps("Build Topic Name");
    verify(tbQueueCoreSettings).getHousekeeperTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createHousekeeperReprocessingMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createHousekeeperReprocessingMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createHousekeeperReprocessingMsgProducer()"
  })
  void testCreateHousekeeperReprocessingMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createHousekeeperReprocessingMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createHousekeeperReprocessingMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createHousekeeperReprocessingMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createHousekeeperReprocessingMsgProducer()"
  })
  void testCreateHousekeeperReprocessingMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getHousekeeperReprocessingTopic())
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createHousekeeperReprocessingMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueCoreSettings).getHousekeeperReprocessingTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createHousekeeperReprocessingMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createHousekeeperReprocessingMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createHousekeeperReprocessingMsgProducer()"
  })
  void testCreateHousekeeperReprocessingMsgProducer_thenCallsBuildTopicName() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toProducerProps()).thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getHousekeeperReprocessingTopic())
        .thenReturn("Housekeeper Reprocessing Topic");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createHousekeeperReprocessingMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("Housekeeper Reprocessing Topic");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueCoreSettings).getHousekeeperReprocessingTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createHousekeeperReprocessingMsgConsumer()}.
   *
   * <ul>
   *   <li>Given {@link TbKafkaSettings}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createHousekeeperReprocessingMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgConsumer(); given TbKafkaSettings")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createHousekeeperReprocessingMsgConsumer()"
  })
  void testCreateHousekeeperReprocessingMsgConsumer_givenTbKafkaSettings() {
    // Arrange
    when(tbQueueCoreSettings.getHousekeeperReprocessingTopic())
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createHousekeeperReprocessingMsgConsumer());
    verify(tbQueueCoreSettings).getHousekeeperReprocessingTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createHousekeeperReprocessingMsgConsumer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbServiceInfoProvider#getServiceId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KafkaMonolithQueueFactory#createHousekeeperReprocessingMsgConsumer()}
   */
  @Test
  @DisplayName("Test createHousekeeperReprocessingMsgConsumer(); then calls getServiceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createHousekeeperReprocessingMsgConsumer()"
  })
  void testCreateHousekeeperReprocessingMsgConsumer_thenCallsGetServiceId() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toConsumerProps(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getHousekeeperReprocessingTopic())
        .thenReturn("Housekeeper Reprocessing Topic");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createHousekeeperReprocessingMsgConsumer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService, atLeast(1)).buildTopicName(Mockito.<String>any());
    verify(tbKafkaSettings).toConsumerProps("Build Topic Name");
    verify(tbQueueCoreSettings).getHousekeeperReprocessingTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createEdgeMsgConsumer()}.
   *
   * <ul>
   *   <li>Given {@link TbKafkaSettings}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createEdgeMsgConsumer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgConsumer(); given TbKafkaSettings")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createEdgeMsgConsumer()"
  })
  void testCreateEdgeMsgConsumer_givenTbKafkaSettings() {
    // Arrange
    when(tbQueueEdgeSettings.getTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createEdgeMsgConsumer());
    verify(tbQueueEdgeSettings).getTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createEdgeMsgConsumer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbServiceInfoProvider#getServiceId()}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createEdgeMsgConsumer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgConsumer(); then calls getServiceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createEdgeMsgConsumer()"
  })
  void testCreateEdgeMsgConsumer_thenCallsGetServiceId() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toConsumerProps(Mockito.<String>any())).thenReturn(new Properties());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueEdgeSettings.getTopic()).thenReturn("Topic");
    doThrow(new UnsupportedOperationException())
        .when(tbKafkaConsumerStatsService)
        .registerClientGroup(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createEdgeMsgConsumer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService, atLeast(1)).buildTopicName(Mockito.<String>any());
    verify(tbKafkaConsumerStatsService).registerClientGroup("Build Topic Name");
    verify(tbKafkaSettings).toConsumerProps("Build Topic Name");
    verify(tbQueueEdgeSettings).getTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createEdgeMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createEdgeMsgProducer()"
  })
  void testCreateEdgeMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createEdgeMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createEdgeMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createEdgeMsgProducer()"
  })
  void testCreateEdgeMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueEdgeSettings.getTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createEdgeMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueEdgeSettings).getTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createEdgeMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createEdgeMsgProducer()"
  })
  void testCreateEdgeMsgProducer_thenCallsBuildTopicName() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toProducerProps()).thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueEdgeSettings.getTopic()).thenReturn("Topic");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createEdgeMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("Topic");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueEdgeSettings).getTopic();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToEdgeNotificationsMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToEdgeNotificationsMsgConsumer()"
  })
  void testCreateToEdgeNotificationsMsgConsumer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToEdgeNotificationsMsgConsumer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToEdgeNotificationsMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToEdgeNotificationsMsgConsumer()"
  })
  void testCreateToEdgeNotificationsMsgConsumer2() {
    // Arrange
    when(topicService.getEdgeNotificationsTopic(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToEdgeNotificationsMsgConsumer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).getEdgeNotificationsTopic("42");
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToEdgeNotificationsMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToEdgeNotificationsMsgConsumer()"
  })
  void testCreateToEdgeNotificationsMsgConsumer3() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getEdgeNotificationsTopic(Mockito.<String>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(tbKafkaSettings.toConsumerProps(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToEdgeNotificationsMsgConsumer());
    verify(tbServiceInfoProvider, atLeast(1)).getServiceId();
    verify(topicService).buildTopicName("monolith-edge-notifications-consumer-42");
    verify(topicService).getEdgeNotificationsTopic("42");
    verify(tbKafkaSettings)
        .toConsumerProps("Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1");
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbKafkaTopicConfigs#getCoreConfigs()}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToEdgeNotificationsMsgConsumer(); then calls getCoreConfigs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToEdgeNotificationsMsgConsumer()"
  })
  void testCreateToEdgeNotificationsMsgConsumer_thenCallsGetCoreConfigs() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getEdgeNotificationsTopic(Mockito.<String>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());

    TbKafkaTopicConfigs kafkaTopicConfigs = mock(TbKafkaTopicConfigs.class);
    when(kafkaTopicConfigs.getCoreConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getEdgeConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getFwUpdatesConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getHousekeeperConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getHousekeeperReprocessingConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getJsExecutorRequestConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getJsExecutorResponseConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getNotificationsConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getRuleEngineConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getTransportApiRequestConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getTransportApiResponseConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getVcConfigs()).thenReturn(new HashMap<>());
    TbKafkaSettings kafkaSettings = new TbKafkaSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueRemoteJsInvokeSettings jsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbKafkaSettings kafkaSettings2 = new TbKafkaSettings();
    TbKafkaConsumerStatsService consumerStatsService =
        new TbKafkaConsumerStatsService(kafkaSettings2, new TbKafkaConsumerStatisticConfig());

    KafkaMonolithQueueFactory kafkaMonolithQueueFactory =
        new KafkaMonolithQueueFactory(
            topicService,
            kafkaSettings,
            serviceInfoProvider,
            coreSettings,
            ruleEngineSettings,
            transportApiSettings,
            transportNotificationSettings,
            jsInvokeSettings,
            vcSettings,
            edgeSettings,
            consumerStatsService,
            kafkaTopicConfigs);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToEdgeNotificationsMsgConsumer());
    verify(topicService).buildTopicName("monolith-edge-notifications-consumer-null");
    verify(topicService).getEdgeNotificationsTopic(null);
    verify(kafkaTopicConfigs).getCoreConfigs();
    verify(kafkaTopicConfigs).getEdgeConfigs();
    verify(kafkaTopicConfigs).getFwUpdatesConfigs();
    verify(kafkaTopicConfigs).getHousekeeperConfigs();
    verify(kafkaTopicConfigs).getHousekeeperReprocessingConfigs();
    verify(kafkaTopicConfigs).getJsExecutorRequestConfigs();
    verify(kafkaTopicConfigs).getJsExecutorResponseConfigs();
    verify(kafkaTopicConfigs).getNotificationsConfigs();
    verify(kafkaTopicConfigs).getRuleEngineConfigs();
    verify(kafkaTopicConfigs).getTransportApiRequestConfigs();
    verify(kafkaTopicConfigs).getTransportApiResponseConfigs();
    verify(kafkaTopicConfigs).getVcConfigs();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbKafkaConsumerStatsService#registerClientGroup(String)}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName(
      "Test createToEdgeNotificationsMsgConsumer(); then calls registerClientGroup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToEdgeNotificationsMsgConsumer()"
  })
  void testCreateToEdgeNotificationsMsgConsumer_thenCallsRegisterClientGroup() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getEdgeNotificationsTopic(Mockito.<String>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(tbKafkaSettings.toConsumerProps(Mockito.<String>any())).thenReturn(new Properties());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    doThrow(new UnsupportedOperationException())
        .when(tbKafkaConsumerStatsService)
        .registerClientGroup(Mockito.<String>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToEdgeNotificationsMsgConsumer());
    verify(tbServiceInfoProvider, atLeast(1)).getServiceId();
    verify(topicService).buildTopicName("monolith-edge-notifications-consumer-42");
    verify(topicService).getEdgeNotificationsTopic("42");
    verify(tbKafkaConsumerStatsService).registerClientGroup("Build Topic Name");
    verify(tbKafkaSettings)
        .toConsumerProps("Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1");
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createEdgeNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createEdgeNotificationsMsgProducer()"
  })
  void testCreateEdgeNotificationsMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createEdgeNotificationsMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createEdgeNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createEdgeNotificationsMsgProducer()"
  })
  void testCreateEdgeNotificationsMsgProducer2() {
    // Arrange
    when(topicService.getEdgeNotificationsTopic(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createEdgeNotificationsMsgProducer());
    verify(tbServiceInfoProvider, atLeast(1)).getServiceId();
    verify(topicService).getEdgeNotificationsTopic("42");
  }

  /**
   * Test {@link KafkaMonolithQueueFactory#createEdgeNotificationsMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbKafkaSettings#toProducerProps()}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeNotificationsMsgProducer(); then calls toProducerProps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaMonolithQueueFactory.createEdgeNotificationsMsgProducer()"
  })
  void testCreateEdgeNotificationsMsgProducer_thenCallsToProducerProps() {
    // Arrange
    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getEdgeNotificationsTopic(Mockito.<String>any()))
        .thenReturn(
            partitionResult
                .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                .topic("Topic")
                .build());
    when(tbKafkaSettings.toProducerProps()).thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createEdgeNotificationsMsgProducer());
    verify(tbServiceInfoProvider, atLeast(1)).getServiceId();
    verify(topicService).getEdgeNotificationsTopic("42");
    verify(tbKafkaSettings).toProducerProps();
  }
}
