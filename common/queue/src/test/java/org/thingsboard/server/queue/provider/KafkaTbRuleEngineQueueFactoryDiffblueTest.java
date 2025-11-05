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
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class KafkaTbRuleEngineQueueFactoryDiffblueTest {
  @InjectMocks private KafkaTbRuleEngineQueueFactory kafkaTbRuleEngineQueueFactory;

  @Mock private TbKafkaConsumerStatsService tbKafkaConsumerStatsService;

  @Mock private TbKafkaSettings tbKafkaSettings;

  @Mock private TbKafkaTopicConfigs tbKafkaTopicConfigs;

  @Mock private TbQueueCoreSettings tbQueueCoreSettings;

  @Mock private TbQueueEdgeSettings tbQueueEdgeSettings;

  @Mock private TbQueueRemoteJsInvokeSettings tbQueueRemoteJsInvokeSettings;

  @Mock private TbQueueRuleEngineSettings tbQueueRuleEngineSettings;

  @Mock private TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings;

  @Mock private TbServiceInfoProvider tbServiceInfoProvider;

  @Mock private TopicService topicService;

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createTransportNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createTransportNotificationsMsgProducer()"
  })
  void testCreateTransportNotificationsMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createTransportNotificationsMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createTransportNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createTransportNotificationsMsgProducer()"
  })
  void testCreateTransportNotificationsMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueTransportNotificationSettings.getNotificationsTopic())
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createTransportNotificationsMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueTransportNotificationSettings).getNotificationsTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createTransportNotificationsMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createTransportNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTransportNotificationsMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createTransportNotificationsMsgProducer()"
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
        () -> kafkaTbRuleEngineQueueFactory.createTransportNotificationsMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("Notifications Topic");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueTransportNotificationSettings).getNotificationsTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createRuleEngineMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaTbRuleEngineQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createRuleEngineMsgProducer()"
  })
  void testCreateRuleEngineMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createRuleEngineMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createRuleEngineMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaTbRuleEngineQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createRuleEngineMsgProducer()"
  })
  void testCreateRuleEngineMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueRuleEngineSettings.getTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createRuleEngineMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueRuleEngineSettings).getTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createRuleEngineMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaTbRuleEngineQueueFactory#createRuleEngineMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createRuleEngineMsgProducer()"
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
        () -> kafkaTbRuleEngineQueueFactory.createRuleEngineMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("Topic");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueRuleEngineSettings).getTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createRuleEngineNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createRuleEngineNotificationsMsgProducer()"
  })
  void testCreateRuleEngineNotificationsMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createRuleEngineNotificationsMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createRuleEngineNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createRuleEngineNotificationsMsgProducer()"
  })
  void testCreateRuleEngineNotificationsMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueRuleEngineSettings.getTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createRuleEngineNotificationsMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueRuleEngineSettings).getTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createRuleEngineNotificationsMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createRuleEngineNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createRuleEngineNotificationsMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createRuleEngineNotificationsMsgProducer()"
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
        () -> kafkaTbRuleEngineQueueFactory.createRuleEngineNotificationsMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("Topic");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueRuleEngineSettings).getTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createTbCoreMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaTbRuleEngineQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createTbCoreMsgProducer()"
  })
  void testCreateTbCoreMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createTbCoreMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createTbCoreMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaTbRuleEngineQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createTbCoreMsgProducer()"
  })
  void testCreateTbCoreMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createTbCoreMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueCoreSettings).getTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createTbCoreMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaTbRuleEngineQueueFactory#createTbCoreMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createTbCoreMsgProducer()"
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
        () -> kafkaTbRuleEngineQueueFactory.createTbCoreMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("Topic");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueCoreSettings).getTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createToOtaPackageStateServiceMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createToOtaPackageStateServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createToOtaPackageStateServiceMsgProducer()"
  })
  void testCreateToOtaPackageStateServiceMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createToOtaPackageStateServiceMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createToOtaPackageStateServiceMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createToOtaPackageStateServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToOtaPackageStateServiceMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createToOtaPackageStateServiceMsgProducer()"
  })
  void testCreateToOtaPackageStateServiceMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getOtaPackageTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createToOtaPackageStateServiceMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueCoreSettings).getOtaPackageTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createToOtaPackageStateServiceMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createToOtaPackageStateServiceMsgProducer()}
   */
  @Test
  @DisplayName(
      "Test createToOtaPackageStateServiceMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createToOtaPackageStateServiceMsgProducer()"
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
        () -> kafkaTbRuleEngineQueueFactory.createToOtaPackageStateServiceMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("java.text");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueCoreSettings).getOtaPackageTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createTbCoreNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createTbCoreNotificationsMsgProducer()"
  })
  void testCreateTbCoreNotificationsMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createTbCoreNotificationsMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createTbCoreNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createTbCoreNotificationsMsgProducer()"
  })
  void testCreateTbCoreNotificationsMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createTbCoreNotificationsMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueCoreSettings).getTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createTbCoreNotificationsMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createTbCoreNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createTbCoreNotificationsMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createTbCoreNotificationsMsgProducer()"
  })
  void testCreateTbCoreNotificationsMsgProducer_thenCallsBuildTopicName() {
    // Arrange
    when(topicService.buildTopicName(Mockito.<String>any())).thenReturn("Build Topic Name");
    when(tbKafkaSettings.toProducerProps()).thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getTopic()).thenReturn("Topic");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createTbCoreNotificationsMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("Topic");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueCoreSettings).getTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createEdgeMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaTbRuleEngineQueueFactory#createEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createEdgeMsgProducer()"
  })
  void testCreateEdgeMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createEdgeMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createEdgeMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaTbRuleEngineQueueFactory#createEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createEdgeMsgProducer()"
  })
  void testCreateEdgeMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueEdgeSettings.getTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createEdgeMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueEdgeSettings).getTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createEdgeMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaTbRuleEngineQueueFactory#createEdgeMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createEdgeMsgProducer()"
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
        () -> kafkaTbRuleEngineQueueFactory.createEdgeMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("Topic");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueEdgeSettings).getTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createEdgeNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createEdgeNotificationsMsgProducer()"
  })
  void testCreateEdgeNotificationsMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createEdgeNotificationsMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createEdgeNotificationsMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeNotificationsMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createEdgeNotificationsMsgProducer()"
  })
  void testCreateEdgeNotificationsMsgProducer2() {
    // Arrange
    when(topicService.getEdgeNotificationsTopic(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createEdgeNotificationsMsgProducer());
    verify(tbServiceInfoProvider, atLeast(1)).getServiceId();
    verify(topicService).getEdgeNotificationsTopic("42");
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createEdgeNotificationsMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbKafkaSettings#toProducerProps()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createEdgeNotificationsMsgProducer()}
   */
  @Test
  @DisplayName("Test createEdgeNotificationsMsgProducer(); then calls toProducerProps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createEdgeNotificationsMsgProducer()"
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
        () -> kafkaTbRuleEngineQueueFactory.createEdgeNotificationsMsgProducer());
    verify(tbServiceInfoProvider, atLeast(1)).getServiceId();
    verify(topicService).getEdgeNotificationsTopic("42");
    verify(tbKafkaSettings).toProducerProps();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineMsgConsumer(Queue)} with {@code
   * configuration}.
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createToRuleEngineMsgConsumer(Queue)}
   */
  @Test
  @DisplayName("Test createToRuleEngineMsgConsumer(Queue) with 'configuration'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaTbRuleEngineQueueFactory.createToRuleEngineMsgConsumer(Queue)"
  })
  void testCreateToRuleEngineMsgConsumerWithConfiguration() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createToRuleEngineMsgConsumer(new Queue()));
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineMsgConsumer(Queue, Integer)} with
   * {@code configuration}, {@code partitionId}.
   *
   * <p>Method under test: {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineMsgConsumer(Queue,
   * Integer)}
   */
  @Test
  @DisplayName(
      "Test createToRuleEngineMsgConsumer(Queue, Integer) with 'configuration', 'partitionId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaTbRuleEngineQueueFactory.createToRuleEngineMsgConsumer(Queue, Integer)"
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
        () -> kafkaTbRuleEngineQueueFactory.createToRuleEngineMsgConsumer(new Queue(), 1));
    verify(topicService).buildConsumerGroupId(eq("re-"), isNull(), isNull(), eq(1));
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineMsgConsumer(Queue, Integer)} with
   * {@code configuration}, {@code partitionId}.
   *
   * <p>Method under test: {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineMsgConsumer(Queue,
   * Integer)}
   */
  @Test
  @DisplayName(
      "Test createToRuleEngineMsgConsumer(Queue, Integer) with 'configuration', 'partitionId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaTbRuleEngineQueueFactory.createToRuleEngineMsgConsumer(Queue, Integer)"
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
        () -> kafkaTbRuleEngineQueueFactory.createToRuleEngineMsgConsumer(new Queue(), 1));
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService, atLeast(1))
        .buildConsumerGroupId(eq("re-"), isNull(), isNull(), Mockito.<Integer>any());
    verify(topicService).buildTopicName(null);
    verify(tbKafkaSettings).getAdminClient();
    verify(tbKafkaSettings).toConsumerProps("Build Topic Name");
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineMsgConsumer(Queue, Integer)} with
   * {@code configuration}, {@code partitionId}.
   *
   * <p>Method under test: {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineMsgConsumer(Queue,
   * Integer)}
   */
  @Test
  @DisplayName(
      "Test createToRuleEngineMsgConsumer(Queue, Integer) with 'configuration', 'partitionId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaTbRuleEngineQueueFactory.createToRuleEngineMsgConsumer(Queue, Integer)"
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
        () -> kafkaTbRuleEngineQueueFactory.createToRuleEngineMsgConsumer(new Queue(), 1));
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService, atLeast(1))
        .buildConsumerGroupId(eq("re-"), isNull(), isNull(), Mockito.<Integer>any());
    verify(topicService).buildTopicName(null);
    verify(tbKafkaConsumerStatsService).registerClientGroup("42");
    verify(tbKafkaSettings).getAdminClient();
    verify(tbKafkaSettings).toConsumerProps("Build Topic Name");
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineNotificationsMsgConsumer()}.
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createToRuleEngineNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToRuleEngineNotificationsMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaTbRuleEngineQueueFactory.createToRuleEngineNotificationsMsgConsumer()"
  })
  void testCreateToRuleEngineNotificationsMsgConsumer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createToRuleEngineNotificationsMsgConsumer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineNotificationsMsgConsumer()}.
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createToRuleEngineNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToRuleEngineNotificationsMsgConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaTbRuleEngineQueueFactory.createToRuleEngineNotificationsMsgConsumer()"
  })
  void testCreateToRuleEngineNotificationsMsgConsumer2() {
    // Arrange
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createToRuleEngineNotificationsMsgConsumer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).getNotificationsTopic(ServiceType.TB_RULE_ENGINE, "42");
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineNotificationsMsgConsumer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbKafkaTopicConfigs#getCoreConfigs()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createToRuleEngineNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName("Test createToRuleEngineNotificationsMsgConsumer(); then calls getCoreConfigs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaTbRuleEngineQueueFactory.createToRuleEngineNotificationsMsgConsumer()"
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
    when(kafkaTopicConfigs.getJsExecutorRequestConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getJsExecutorResponseConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getNotificationsConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getRuleEngineConfigs()).thenReturn(new HashMap<>());
    TbKafkaSettings kafkaSettings = new TbKafkaSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueRemoteJsInvokeSettings jsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    TbKafkaSettings kafkaSettings2 = new TbKafkaSettings();
    TbKafkaConsumerStatsService consumerStatsService =
        new TbKafkaConsumerStatsService(kafkaSettings2, new TbKafkaConsumerStatisticConfig());
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();

    KafkaTbRuleEngineQueueFactory kafkaTbRuleEngineQueueFactory =
        new KafkaTbRuleEngineQueueFactory(
            topicService,
            kafkaSettings,
            serviceInfoProvider,
            coreSettings,
            ruleEngineSettings,
            jsInvokeSettings,
            consumerStatsService,
            transportNotificationSettings,
            new TbQueueEdgeSettings(),
            kafkaTopicConfigs);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createToRuleEngineNotificationsMsgConsumer());
    verify(topicService).buildTopicName("tb-rule-engine-notifications-node-");
    verify(topicService).getNotificationsTopic(ServiceType.TB_RULE_ENGINE, null);
    verify(kafkaTopicConfigs).getCoreConfigs();
    verify(kafkaTopicConfigs).getEdgeConfigs();
    verify(kafkaTopicConfigs).getFwUpdatesConfigs();
    verify(kafkaTopicConfigs).getHousekeeperConfigs();
    verify(kafkaTopicConfigs).getJsExecutorRequestConfigs();
    verify(kafkaTopicConfigs).getJsExecutorResponseConfigs();
    verify(kafkaTopicConfigs).getNotificationsConfigs();
    verify(kafkaTopicConfigs).getRuleEngineConfigs();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineNotificationsMsgConsumer()}.
   *
   * <ul>
   *   <li>Then calls {@link TbKafkaSettings#toConsumerProps(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createToRuleEngineNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName(
      "Test createToRuleEngineNotificationsMsgConsumer(); then calls toConsumerProps(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaTbRuleEngineQueueFactory.createToRuleEngineNotificationsMsgConsumer()"
  })
  void testCreateToRuleEngineNotificationsMsgConsumer_thenCallsToConsumerProps() {
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
        () -> kafkaTbRuleEngineQueueFactory.createToRuleEngineNotificationsMsgConsumer());
    verify(tbServiceInfoProvider, atLeast(1)).getServiceId();
    verify(topicService).buildTopicName("tb-rule-engine-notifications-node-");
    verify(topicService).getNotificationsTopic(ServiceType.TB_RULE_ENGINE, "42");
    verify(tbKafkaSettings)
        .toConsumerProps("Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1");
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createRemoteJsRequestTemplate()}.
   *
   * <p>Method under test: {@link KafkaTbRuleEngineQueueFactory#createRemoteJsRequestTemplate()}
   */
  @Test
  @DisplayName("Test createRemoteJsRequestTemplate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueRequestTemplate KafkaTbRuleEngineQueueFactory.createRemoteJsRequestTemplate()"
  })
  void testCreateRemoteJsRequestTemplate() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createRemoteJsRequestTemplate());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createRemoteJsRequestTemplate()}.
   *
   * <p>Method under test: {@link KafkaTbRuleEngineQueueFactory#createRemoteJsRequestTemplate()}
   */
  @Test
  @DisplayName("Test createRemoteJsRequestTemplate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueRequestTemplate KafkaTbRuleEngineQueueFactory.createRemoteJsRequestTemplate()"
  })
  void testCreateRemoteJsRequestTemplate2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueRemoteJsInvokeSettings.getRequestTopic())
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createRemoteJsRequestTemplate());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueRemoteJsInvokeSettings).getRequestTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createRemoteJsRequestTemplate()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaTbRuleEngineQueueFactory#createRemoteJsRequestTemplate()}
   */
  @Test
  @DisplayName("Test createRemoteJsRequestTemplate(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueRequestTemplate KafkaTbRuleEngineQueueFactory.createRemoteJsRequestTemplate()"
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
        () -> kafkaTbRuleEngineQueueFactory.createRemoteJsRequestTemplate());
    verify(tbServiceInfoProvider, atLeast(1)).getServiceId();
    verify(topicService).buildTopicName("rule-engine-node-");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueRemoteJsInvokeSettings).getRequestTopic();
    verify(tbQueueRemoteJsInvokeSettings).getResponseTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createToUsageStatsServiceMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createToUsageStatsServiceMsgProducer()"
  })
  void testCreateToUsageStatsServiceMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createToUsageStatsServiceMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createToUsageStatsServiceMsgProducer()}.
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createToUsageStatsServiceMsgProducer()"
  })
  void testCreateToUsageStatsServiceMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getUsageStatsTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createToUsageStatsServiceMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueCoreSettings).getUsageStatsTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createToUsageStatsServiceMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createToUsageStatsServiceMsgProducer()}
   */
  @Test
  @DisplayName("Test createToUsageStatsServiceMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createToUsageStatsServiceMsgProducer()"
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
        () -> kafkaTbRuleEngineQueueFactory.createToUsageStatsServiceMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("Usage Stats Topic");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueCoreSettings).getUsageStatsTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createHousekeeperMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaTbRuleEngineQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createHousekeeperMsgProducer()"
  })
  void testCreateHousekeeperMsgProducer() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createHousekeeperMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createHousekeeperMsgProducer()}.
   *
   * <p>Method under test: {@link KafkaTbRuleEngineQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createHousekeeperMsgProducer()"
  })
  void testCreateHousekeeperMsgProducer2() {
    // Arrange
    when(tbServiceInfoProvider.getServiceId()).thenReturn("42");
    when(tbQueueCoreSettings.getHousekeeperTopic()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> kafkaTbRuleEngineQueueFactory.createHousekeeperMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(tbQueueCoreSettings).getHousekeeperTopic();
  }

  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createHousekeeperMsgProducer()}.
   *
   * <ul>
   *   <li>Then calls {@link TopicService#buildTopicName(String)}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaTbRuleEngineQueueFactory#createHousekeeperMsgProducer()}
   */
  @Test
  @DisplayName("Test createHousekeeperMsgProducer(); then calls buildTopicName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueProducer KafkaTbRuleEngineQueueFactory.createHousekeeperMsgProducer()"
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
        () -> kafkaTbRuleEngineQueueFactory.createHousekeeperMsgProducer());
    verify(tbServiceInfoProvider).getServiceId();
    verify(topicService).buildTopicName("Housekeeper Topic");
    verify(tbKafkaSettings).toProducerProps();
    verify(tbQueueCoreSettings).getHousekeeperTopic();
  }
}
