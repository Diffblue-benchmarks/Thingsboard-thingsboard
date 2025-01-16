package org.thingsboard.server.service.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.notification.rule.trigger.AlarmAssignmentTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.NotificationRuleTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.AlarmAssignmentNotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerConfig;

@ContextConfiguration(classes = {AlarmAssignmentTriggerProcessor.class})
@ExtendWith(SpringExtension.class)
class NotificationRuleTriggerProcessorDiffblueTest {
  @Autowired
  private NotificationRuleTriggerProcessor<AlarmAssignmentTrigger, AlarmAssignmentNotificationRuleTriggerConfig> notificationRuleTriggerProcessor;

  /**
   * Test
   * {@link NotificationRuleTriggerProcessor#matchesClearRule(NotificationRuleTrigger, NotificationRuleTriggerConfig)}.
   * <ul>
   *   <li>When {@link AlarmAssignmentTrigger}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRuleTriggerProcessor#matchesClearRule(NotificationRuleTrigger, NotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesClearRule(NotificationRuleTrigger, NotificationRuleTriggerConfig); when AlarmAssignmentTrigger")
  void testMatchesClearRule_whenAlarmAssignmentTrigger() {
    // Arrange
    AlarmAssignmentTrigger alarmAssignmentTrigger = mock(AlarmAssignmentTrigger.class);

    // Act and Assert
    assertFalse(notificationRuleTriggerProcessor.matchesClearRule(alarmAssignmentTrigger,
        new AlarmAssignmentNotificationRuleTriggerConfig()));
  }

  /**
   * Test
   * {@link NotificationRuleTriggerProcessor#matchesClearRule(NotificationRuleTrigger, NotificationRuleTriggerConfig)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRuleTriggerProcessor#matchesClearRule(NotificationRuleTrigger, NotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesClearRule(NotificationRuleTrigger, NotificationRuleTriggerConfig); when 'null'")
  void testMatchesClearRule_whenNull() {
    // Arrange, Act and Assert
    assertFalse(
        notificationRuleTriggerProcessor.matchesClearRule(null, new AlarmAssignmentNotificationRuleTriggerConfig()));
  }
}
