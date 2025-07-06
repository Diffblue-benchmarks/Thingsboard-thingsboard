package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
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

class KafkaTbRuleEngineQueueFactoryDiffblueTest {
  /**
   * Test {@link KafkaTbRuleEngineQueueFactory#createToRuleEngineMsgConsumer(Queue)} with {@code
   * configuration}.
   *
   * <p>Method under test: {@link
   * KafkaTbRuleEngineQueueFactory#createToRuleEngineMsgConsumer(Queue)}
   */
  @Test
  @DisplayName("Test createToRuleEngineMsgConsumer(Queue) with 'configuration'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaTbRuleEngineQueueFactory.createToRuleEngineMsgConsumer(Queue)"
  })
  void testCreateToRuleEngineMsgConsumerWithConfiguration() {
    // Arrange
    TbKafkaTopicConfigs kafkaTopicConfigs = mock(TbKafkaTopicConfigs.class);
    when(kafkaTopicConfigs.getCoreConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getEdgeConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getFwUpdatesConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getHousekeeperConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getJsExecutorRequestConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getJsExecutorResponseConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getNotificationsConfigs()).thenReturn(new HashMap<>());
    when(kafkaTopicConfigs.getRuleEngineConfigs()).thenReturn(new HashMap<>());
    TopicService topicService = new TopicService();
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
        () -> kafkaTbRuleEngineQueueFactory.createToRuleEngineMsgConsumer(new Queue()));
    verify(kafkaTopicConfigs).getCoreConfigs();
    verify(kafkaTopicConfigs).getEdgeConfigs();
    verify(kafkaTopicConfigs).getFwUpdatesConfigs();
    verify(kafkaTopicConfigs).getHousekeeperConfigs();
    verify(kafkaTopicConfigs).getJsExecutorRequestConfigs();
    verify(kafkaTopicConfigs).getJsExecutorResponseConfigs();
    verify(kafkaTopicConfigs).getNotificationsConfigs();
    verify(kafkaTopicConfigs).getRuleEngineConfigs();
  }
}
