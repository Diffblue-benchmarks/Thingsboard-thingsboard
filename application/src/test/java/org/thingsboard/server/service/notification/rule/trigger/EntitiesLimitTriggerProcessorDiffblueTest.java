package org.thingsboard.server.service.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.tenant.DefaultTbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantProfileServiceImpl;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

class EntitiesLimitTriggerProcessorDiffblueTest {
  /**
   * Test {@link EntitiesLimitTriggerProcessor#getTriggerType()}.
   * <p>
   * Method under test: {@link EntitiesLimitTriggerProcessor#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationRuleTriggerType EntitiesLimitTriggerProcessor.getTriggerType()"})
  void testGetTriggerType() {
    // Arrange
    BaseEntityCountService entityCountService = new BaseEntityCountService();
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache = new DefaultTbTenantProfileCache(tenantProfileService,
        new TenantServiceImpl());

    // Act and Assert
    assertEquals(NotificationRuleTriggerType.ENTITIES_LIMIT,
        (new EntitiesLimitTriggerProcessor(entityCountService, tenantProfileCache, new TenantServiceImpl()))
            .getTriggerType());
  }
}
