/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
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
    TopicService topicService = new TopicService();
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
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenReturn(
            partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build());

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
   * Test {@link KafkaMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToCoreNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName(
      "Test createToCoreNotificationsMsgConsumer(); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToCoreNotificationsMsgConsumer()"
  })
  void testCreateToCoreNotificationsMsgConsumer_thenThrowUnsupportedOperationException() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenReturn(
            partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build());

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
   * Test {@link KafkaMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link KafkaMonolithQueueFactory#createToEdgeNotificationsMsgConsumer()}
   */
  @Test
  @DisplayName(
      "Test createToEdgeNotificationsMsgConsumer(); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer KafkaMonolithQueueFactory.createToEdgeNotificationsMsgConsumer()"
  })
  void testCreateToEdgeNotificationsMsgConsumer_thenThrowUnsupportedOperationException() {
    // Arrange
    TopicService topicService = mock(TopicService.class);
    when(topicService.buildTopicName(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getEdgeNotificationsTopic(Mockito.<String>any()))
        .thenReturn(
            partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build());

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
}
