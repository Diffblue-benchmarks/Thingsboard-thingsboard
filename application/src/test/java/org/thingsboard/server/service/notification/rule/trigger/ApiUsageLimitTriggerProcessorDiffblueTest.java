package org.thingsboard.server.service.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

class ApiUsageLimitTriggerProcessorDiffblueTest {
  /**
   * Test {@link ApiUsageLimitTriggerProcessor#getTriggerType()}.
   * <p>
   * Method under test: {@link ApiUsageLimitTriggerProcessor#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationRuleTriggerType ApiUsageLimitTriggerProcessor.getTriggerType()"})
  void testGetTriggerType() {
    // Arrange, Act and Assert
    assertEquals(NotificationRuleTriggerType.API_USAGE_LIMIT,
        (new ApiUsageLimitTriggerProcessor(new TenantServiceImpl())).getTriggerType());
  }
}
