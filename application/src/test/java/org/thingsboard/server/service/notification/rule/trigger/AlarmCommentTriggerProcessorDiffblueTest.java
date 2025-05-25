package org.thingsboard.server.service.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.dao.entity.BaseEntityService;

class AlarmCommentTriggerProcessorDiffblueTest {
  /**
   * Test {@link AlarmCommentTriggerProcessor#getTriggerType()}.
   * <p>
   * Method under test: {@link AlarmCommentTriggerProcessor#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationRuleTriggerType AlarmCommentTriggerProcessor.getTriggerType()"})
  void testGetTriggerType() {
    // Arrange, Act and Assert
    assertEquals(NotificationRuleTriggerType.ALARM_COMMENT,
        (new AlarmCommentTriggerProcessor(new BaseEntityService())).getTriggerType());
  }
}
