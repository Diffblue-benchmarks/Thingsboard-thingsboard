package org.thingsboard.server.service.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

class RateLimitsTriggerProcessorDiffblueTest {
  /**
   * Test {@link RateLimitsTriggerProcessor#getTriggerType()}.
   * <p>
   * Method under test: {@link RateLimitsTriggerProcessor#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationRuleTriggerType RateLimitsTriggerProcessor.getTriggerType()"})
  void testGetTriggerType() {
    // Arrange
    TenantServiceImpl tenantService = new TenantServiceImpl();

    // Act and Assert
    assertEquals(NotificationRuleTriggerType.RATE_LIMITS,
        (new RateLimitsTriggerProcessor(tenantService, new BaseEntityService())).getTriggerType());
  }
}
