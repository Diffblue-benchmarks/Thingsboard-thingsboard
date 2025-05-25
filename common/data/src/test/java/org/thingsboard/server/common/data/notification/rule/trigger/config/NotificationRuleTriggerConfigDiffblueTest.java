package org.thingsboard.server.common.data.notification.rule.trigger.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NotificationRuleTriggerConfigDiffblueTest {
  /**
   * Test {@link NotificationRuleTriggerConfig#getDeduplicationKey()}.
   * <p>
   * Method under test: {@link NotificationRuleTriggerConfig#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String NotificationRuleTriggerConfig.getDeduplicationKey()"})
  void testGetDeduplicationKey() {
    // Arrange, Act and Assert
    assertEquals("#", (new AlarmAssignmentNotificationRuleTriggerConfig()).getDeduplicationKey());
  }
}
