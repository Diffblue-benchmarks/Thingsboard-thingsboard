package org.thingsboard.server.queue.notification;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.notification.rule.trigger.NotificationRuleTrigger;
import org.thingsboard.server.queue.discovery.PartitionService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.provider.TbQueueProducerProvider;

@ContextConfiguration(classes = {RemoteNotificationRuleProcessor.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class RemoteNotificationRuleProcessorDiffblueTest {
  @MockBean
  private NotificationDeduplicationService notificationDeduplicationService;

  @MockBean
  private PartitionService partitionService;

  @Autowired
  private RemoteNotificationRuleProcessor remoteNotificationRuleProcessor;

  @MockBean
  private TbQueueProducerProvider tbQueueProducerProvider;

  @MockBean
  private TopicService topicService;

  /**
   * Test
   * {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link NotificationRuleTrigger}
   * {@link NotificationRuleTrigger#deduplicate()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName("Test process(NotificationRuleTrigger); given 'false'; when NotificationRuleTrigger deduplicate() return 'false'")
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
   * Test
   * {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}.
   * <ul>
   *   <li>Given {@link NotificationDeduplicationService}
   * {@link NotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger)}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName("Test process(NotificationRuleTrigger); given NotificationDeduplicationService alreadyProcessed(NotificationRuleTrigger) return 'false'")
  void testProcess_givenNotificationDeduplicationServiceAlreadyProcessedReturnFalse() {
    // Arrange
    when(notificationDeduplicationService.alreadyProcessed(Mockito.<NotificationRuleTrigger>any())).thenReturn(false);
    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.deduplicate()).thenReturn(true);

    // Act
    remoteNotificationRuleProcessor.process(trigger);

    // Assert
    verify(trigger).deduplicate();
    verify(notificationDeduplicationService).alreadyProcessed(isA(NotificationRuleTrigger.class));
  }

  /**
   * Test
   * {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}.
   * <ul>
   *   <li>Given {@link NotificationDeduplicationService}
   * {@link NotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger)}
   * return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RemoteNotificationRuleProcessor#process(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName("Test process(NotificationRuleTrigger); given NotificationDeduplicationService alreadyProcessed(NotificationRuleTrigger) return 'true'")
  void testProcess_givenNotificationDeduplicationServiceAlreadyProcessedReturnTrue() {
    // Arrange
    when(notificationDeduplicationService.alreadyProcessed(Mockito.<NotificationRuleTrigger>any())).thenReturn(true);
    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.deduplicate()).thenReturn(true);

    // Act
    remoteNotificationRuleProcessor.process(trigger);

    // Assert that nothing has changed
    verify(trigger).deduplicate();
    verify(notificationDeduplicationService).alreadyProcessed(isA(NotificationRuleTrigger.class));
  }
}
