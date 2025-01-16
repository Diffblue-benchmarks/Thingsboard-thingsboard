package org.thingsboard.server.common.data.notification.rule.trigger.config;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NotificationRuleTriggerTypeDiffblueTest {
  /**
   * Test {@link NotificationRuleTriggerType#isTenantLevel()}.
   * <p>
   * Method under test: {@link NotificationRuleTriggerType#isTenantLevel()}
   */
  @Test
  @DisplayName("Test isTenantLevel()")
  void testIsTenantLevel() {
    // Arrange, Act and Assert
    assertTrue(NotificationRuleTriggerType.valueOf("ENTITY_ACTION").isTenantLevel());
  }
}
