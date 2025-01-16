package org.thingsboard.server.common.data.notification.rule.trigger.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NotificationRuleTriggerConfigDiffblueTest {
  /**
   * Test {@link NotificationRuleTriggerConfig#getDeduplicationKey()}.
   * <ul>
   *   <li>Then calls
   * {@link NotificationRuleTriggerConfig#getDeduplicationKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRuleTriggerConfig#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey(); then calls getDeduplicationKey()")
  void testGetDeduplicationKey_thenCallsGetDeduplicationKey() {
    // Arrange
    NotificationRuleTriggerConfig notificationRuleTriggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(notificationRuleTriggerConfig.getDeduplicationKey()).thenReturn("Deduplication Key");

    // Act
    notificationRuleTriggerConfig.getDeduplicationKey();

    // Assert
    verify(notificationRuleTriggerConfig).getDeduplicationKey();
  }

  /**
   * Test {@link NotificationRuleTriggerConfig#getDeduplicationKey()}.
   * <ul>
   *   <li>Then return {@code #}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRuleTriggerConfig#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey(); then return '#'")
  void testGetDeduplicationKey_thenReturnNumberSign() {
    // Arrange, Act and Assert
    assertEquals("#", (new AlarmAssignmentNotificationRuleTriggerConfig()).getDeduplicationKey());
  }
}
