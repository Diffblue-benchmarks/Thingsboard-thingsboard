package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RuleOriginatedNotificationInfoDiffblueTest {
  /**
   * Test {@link RuleOriginatedNotificationInfo#getAffectedCustomerId()}.
   *
   * <p>Method under test: {@link RuleOriginatedNotificationInfo#getAffectedCustomerId()}
   */
  @Test
  @DisplayName("Test getAffectedCustomerId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.CustomerId RuleOriginatedNotificationInfo.getAffectedCustomerId()"
  })
  void testGetAffectedCustomerId() {
    // Arrange, Act and Assert
    assertNull(new ApiUsageLimitNotificationInfo().getAffectedCustomerId());
  }

  /**
   * Test {@link RuleOriginatedNotificationInfo#getAffectedUserId()}.
   *
   * <p>Method under test: {@link RuleOriginatedNotificationInfo#getAffectedUserId()}
   */
  @Test
  @DisplayName("Test getAffectedUserId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.UserId RuleOriginatedNotificationInfo.getAffectedUserId()"
  })
  void testGetAffectedUserId() {
    // Arrange, Act and Assert
    assertNull(new AlarmCommentNotificationInfo().getAffectedUserId());
  }

  /**
   * Test {@link RuleOriginatedNotificationInfo#getAffectedTenantId()}.
   *
   * <p>Method under test: {@link RuleOriginatedNotificationInfo#getAffectedTenantId()}
   */
  @Test
  @DisplayName("Test getAffectedTenantId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.TenantId RuleOriginatedNotificationInfo.getAffectedTenantId()"
  })
  void testGetAffectedTenantId() {
    // Arrange, Act and Assert
    assertNull(new AlarmAssignmentNotificationInfo().getAffectedTenantId());
  }
}
