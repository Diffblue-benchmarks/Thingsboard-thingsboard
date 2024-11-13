package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;

class KafkaMonolithQueueFactoryDiffblueTest {
  /**
   * Test {@link KafkaMonolithQueueFactory#createToRuleEngineMsgConsumer(Queue)}
   * with {@code configuration}.
   * <p>
   * Method under test:
   * {@link KafkaMonolithQueueFactory#createToRuleEngineMsgConsumer(Queue)}
   */
  @Test
  @DisplayName("Test createToRuleEngineMsgConsumer(Queue) with 'configuration'")
  void testCreateToRuleEngineMsgConsumerWithConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
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
    TopicService topicService = mock(TopicService.class);
    TbKafkaSettings kafkaSettings = new TbKafkaSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueRemoteJsInvokeSettings jsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbKafkaSettings kafkaSettings2 = new TbKafkaSettings();
    KafkaMonolithQueueFactory kafkaMonolithQueueFactory = new KafkaMonolithQueueFactory(topicService, kafkaSettings,
        serviceInfoProvider, coreSettings, ruleEngineSettings, transportApiSettings, transportNotificationSettings,
        jsInvokeSettings, vcSettings, edgeSettings,
        new TbKafkaConsumerStatsService(kafkaSettings2, new TbKafkaConsumerStatisticConfig()), kafkaTopicConfigs);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> kafkaMonolithQueueFactory.createToRuleEngineMsgConsumer(new Queue()));
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
   * Test {@link KafkaMonolithQueueFactory#createRemoteJsRequestTemplate()}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link KafkaMonolithQueueFactory#createRemoteJsRequestTemplate()}
   */
  @Test
  @DisplayName("Test createRemoteJsRequestTemplate(); then throw UnsupportedOperationException")
  void testCreateRemoteJsRequestTemplate_thenThrowUnsupportedOperationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException("rule-engine-node-"));

    TbQueueRemoteJsInvokeSettings jsInvokeSettings = new TbQueueRemoteJsInvokeSettings();
    jsInvokeSettings.setPrefix("Prefix");
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
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbKafkaSettings kafkaSettings2 = new TbKafkaSettings();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new KafkaMonolithQueueFactory(topicService, kafkaSettings, serviceInfoProvider, coreSettings,
            ruleEngineSettings, transportApiSettings, transportNotificationSettings, jsInvokeSettings, vcSettings,
            edgeSettings, new TbKafkaConsumerStatsService(kafkaSettings2, new TbKafkaConsumerStatisticConfig()),
            kafkaTopicConfigs)).createRemoteJsRequestTemplate());
    verify(topicService).buildTopicName(eq("rule-engine-node-"));
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
}
