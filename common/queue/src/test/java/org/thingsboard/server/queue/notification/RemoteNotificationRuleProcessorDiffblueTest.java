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
package org.thingsboard.server.queue.notification;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.AlarmAssignmentTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.NotificationRuleTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo.TopicPartitionInfoBuilder;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.PartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.provider.TbQueueProducerProvider;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;

@ContextConfiguration(classes = {RemoteNotificationRuleProcessor.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class RemoteNotificationRuleProcessorDiffblueTest {
  @MockBean private NotificationDeduplicationService notificationDeduplicationService;

  @MockBean private PartitionService partitionService;

  @Autowired private RemoteNotificationRuleProcessor remoteNotificationRuleProcessor;

  @MockBean private TbQueueProducerProvider tbQueueProducerProvider;

  @MockBean private TopicService topicService;

  /**
   * Test {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}.
   *
   * <p>Method under test: {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName("Test process(NotificationRuleTrigger)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteNotificationRuleProcessor.process(NotificationRuleTrigger)"})
  void testProcess() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Submitting notification rule trigger: {}");

    HashPartitionService partitionService = mock(HashPartitionService.class);
    when(partitionService.getAllServiceIds(Mockito.<ServiceType>any())).thenReturn(stringSet);
    DefaultNotificationDeduplicationService deduplicationService =
        new DefaultNotificationDeduplicationService();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
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
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);

    RemoteNotificationRuleProcessor remoteNotificationRuleProcessor =
        new RemoteNotificationRuleProcessor(
            deduplicationService, producerProvider, new TopicService(), partitionService);

    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder alarmInfoResult = actionTypeResult.alarmInfo(new AlarmInfo());

    AlarmAssignmentTriggerBuilder tenantIdResult =
        alarmInfoResult.tenantId(new TenantId(UUID.randomUUID()));

    // Act
    remoteNotificationRuleProcessor.process(tenantIdResult.user(new User()).build());

    // Assert
    verify(partitionService).getAllServiceIds(ServiceType.TB_CORE);
  }

  /**
   * Test {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}.
   *
   * <p>Method under test: {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName("Test process(NotificationRuleTrigger)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteNotificationRuleProcessor.process(NotificationRuleTrigger)"})
  void testProcess2() {
    // Arrange
    TopicService topicService = mock(TopicService.class);

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenReturn(
            partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Submitting notification rule trigger: {}");

    HashPartitionService partitionService = mock(HashPartitionService.class);
    when(partitionService.getAllServiceIds(Mockito.<ServiceType>any())).thenReturn(stringSet);
    DefaultNotificationDeduplicationService deduplicationService =
        new DefaultNotificationDeduplicationService();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService2,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    RemoteNotificationRuleProcessor remoteNotificationRuleProcessor =
        new RemoteNotificationRuleProcessor(
            deduplicationService,
            new TbCoreQueueProducerProvider(tbQueueProvider),
            topicService,
            partitionService);

    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder alarmInfoResult = actionTypeResult.alarmInfo(new AlarmInfo());

    AlarmAssignmentTriggerBuilder tenantIdResult =
        alarmInfoResult.tenantId(new TenantId(UUID.randomUUID()));

    // Act
    remoteNotificationRuleProcessor.process(tenantIdResult.user(new User()).build());

    // Assert
    verify(partitionService).getAllServiceIds(ServiceType.TB_CORE);
    verify(topicService)
        .getNotificationsTopic(ServiceType.TB_CORE, "Submitting notification rule trigger: {}");
  }

  /**
   * Test {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}.
   *
   * <p>Method under test: {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName("Test process(NotificationRuleTrigger)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteNotificationRuleProcessor.process(NotificationRuleTrigger)"})
  void testProcess3() {
    // Arrange
    TopicService topicService = mock(TopicService.class);

    TopicPartitionInfoBuilder partitionResult =
        TopicPartitionInfo.builder().myPartition(true).partition(1);
    when(topicService.getNotificationsTopic(Mockito.<ServiceType>any(), Mockito.<String>any()))
        .thenReturn(
            partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("Submitting notification rule trigger: {}");

    HashPartitionService partitionService = mock(HashPartitionService.class);
    when(partitionService.getAllServiceIds(Mockito.<ServiceType>any())).thenReturn(stringSet);

    RemoteNotificationRuleProcessor remoteNotificationRuleProcessor =
        new RemoteNotificationRuleProcessor(
            new DefaultNotificationDeduplicationService(), null, topicService, partitionService);

    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder alarmInfoResult = actionTypeResult.alarmInfo(new AlarmInfo());

    AlarmAssignmentTriggerBuilder tenantIdResult =
        alarmInfoResult.tenantId(new TenantId(UUID.randomUUID()));

    // Act
    remoteNotificationRuleProcessor.process(tenantIdResult.user(new User()).build());

    // Assert
    verify(partitionService).getAllServiceIds(ServiceType.TB_CORE);
    verify(topicService)
        .getNotificationsTopic(ServiceType.TB_CORE, "Submitting notification rule trigger: {}");
  }

  /**
   * Test {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link NotificationRuleTrigger} {@link NotificationRuleTrigger#deduplicate()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName(
      "Test process(NotificationRuleTrigger); given 'false'; when NotificationRuleTrigger deduplicate() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteNotificationRuleProcessor.process(NotificationRuleTrigger)"})
  void testProcess_givenFalse_whenNotificationRuleTriggerDeduplicateReturnFalse() {
    // Arrange
    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.deduplicate()).thenReturn(false);

    // Act
    remoteNotificationRuleProcessor.process(trigger);

    // Assert
    verify(trigger).deduplicate();
  }

  /**
   * Test {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}.
   *
   * <ul>
   *   <li>Then calls {@link PartitionService#getAllServiceIds(ServiceType)}.
   * </ul>
   *
   * <p>Method under test: {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName("Test process(NotificationRuleTrigger); then calls getAllServiceIds(ServiceType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteNotificationRuleProcessor.process(NotificationRuleTrigger)"})
  void testProcess_thenCallsGetAllServiceIds() {
    // Arrange
    when(partitionService.getAllServiceIds(Mockito.<ServiceType>any())).thenReturn(new HashSet<>());

    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder alarmInfoResult = actionTypeResult.alarmInfo(new AlarmInfo());

    AlarmAssignmentTriggerBuilder tenantIdResult =
        alarmInfoResult.tenantId(new TenantId(UUID.randomUUID()));

    // Act
    remoteNotificationRuleProcessor.process(tenantIdResult.user(new User()).build());

    // Assert
    verify(partitionService).getAllServiceIds(ServiceType.TB_CORE);
  }

  /**
   * Test {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}.
   *
   * <ul>
   *   <li>Then calls {@link NotificationRuleTrigger#getDeduplicationKey()}.
   * </ul>
   *
   * <p>Method under test: {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName("Test process(NotificationRuleTrigger); then calls getDeduplicationKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RemoteNotificationRuleProcessor.process(NotificationRuleTrigger)"})
  void testProcess_thenCallsGetDeduplicationKey() {
    // Arrange
    DefaultNotificationDeduplicationService deduplicationService =
        new DefaultNotificationDeduplicationService();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
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
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider2,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());

    RemoteNotificationRuleProcessor remoteNotificationRuleProcessor =
        new RemoteNotificationRuleProcessor(
            deduplicationService, producerProvider, topicService2, partitionService);

    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.getType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(trigger.getDeduplicationKey()).thenReturn("Deduplication Key");
    when(trigger.deduplicate()).thenReturn(true);

    // Act
    remoteNotificationRuleProcessor.process(trigger);

    // Assert
    verify(trigger).deduplicate();
    verify(trigger).getDeduplicationKey();
    verify(trigger).getType();
  }
}
