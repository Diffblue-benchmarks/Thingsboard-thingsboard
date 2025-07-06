package org.thingsboard.server.queue.notification;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.notification.rule.trigger.NotificationRuleTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
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
  @Tag("MaintainedByDiffblue")
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
   *   <li>Then calls {@link NotificationRuleTrigger#getDeduplicationKey()}.
   * </ul>
   *
   * <p>Method under test: {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName("Test process(NotificationRuleTrigger); then calls getDeduplicationKey()")
  @Tag("MaintainedByDiffblue")
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
    TbCoreQueueProducerProvider producerProvider =
        new TbCoreQueueProducerProvider(
            new InMemoryMonolithQueueFactory(
                topicService,
                coreSettings,
                ruleEngineSettings,
                vcSettings,
                serviceInfoProvider,
                transportApiSettings,
                transportNotificationSettings,
                edgeSettings,
                new DefaultInMemoryStorage()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    RemoteNotificationRuleProcessor remoteNotificationRuleProcessor =
        new RemoteNotificationRuleProcessor(
            deduplicationService,
            producerProvider,
            topicService2,
            new HashPartitionService(
                serviceInfoProvider2,
                tenantRoutingInfoService,
                applicationEventPublisher,
                queueRoutingInfoService,
                new TopicService()));
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
