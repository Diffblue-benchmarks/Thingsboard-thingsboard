package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.UpdateMessage;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.AlarmAssignmentTrigger.AlarmAssignmentTriggerBuilder;

class NotificationRuleTriggerDiffblueTest {
  /**
   * Test {@link NotificationRuleTrigger#deduplicate()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleTrigger#deduplicate()}
   */
  @Test
  @DisplayName("Test deduplicate(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRuleTrigger.deduplicate()"})
  void testDeduplicate_thenReturnFalse() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertFalse(tenantIdResult.user(new User()).build().deduplicate());
  }

  /**
   * Test {@link NotificationRuleTrigger#deduplicate()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleTrigger#deduplicate()}
   */
  @Test
  @DisplayName("Test deduplicate(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRuleTrigger.deduplicate()"})
  void testDeduplicate_thenReturnTrue() {
    // Arrange
    UpdateMessage updateInfo =
        new UpdateMessage(
            true,
            "1.0.2",
            "1.0.2",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");

    // Act and Assert
    assertTrue(new NewPlatformVersionTrigger(updateInfo).deduplicate());
  }

  /**
   * Test {@link NotificationRuleTrigger#getDeduplicationKey()}.
   *
   * <p>Method under test: {@link NotificationRuleTrigger#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String NotificationRuleTrigger.getDeduplicationKey()"})
  void testGetDeduplicationKey() {
    // Arrange
    UpdateMessage updateInfo =
        new UpdateMessage(
            true,
            "1.0.2",
            "1.0.2",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");

    // Act and Assert
    assertEquals(
        "NEW_PLATFORM_VERSION:TENANT:13814000-1dd2-11b2-8080-808080808080:1.0.2:1.0.2",
        new NewPlatformVersionTrigger(updateInfo).getDeduplicationKey());
  }

  /**
   * Test {@link NotificationRuleTrigger#getDefaultDeduplicationDuration()}.
   *
   * <p>Method under test: {@link NotificationRuleTrigger#getDefaultDeduplicationDuration()}
   */
  @Test
  @DisplayName("Test getDefaultDeduplicationDuration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NotificationRuleTrigger.getDefaultDeduplicationDuration()"})
  void testGetDefaultDeduplicationDuration() {
    // Arrange
    UpdateMessage updateInfo =
        new UpdateMessage(
            true,
            "1.0.2",
            "1.0.2",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");

    // Act and Assert
    assertEquals(0L, new NewPlatformVersionTrigger(updateInfo).getDefaultDeduplicationDuration());
  }

  /**
   * Test {@link NotificationRuleTrigger#getDefaultDeduplicationDuration()}.
   *
   * <p>Method under test: {@link NotificationRuleTrigger#getDefaultDeduplicationDuration()}
   */
  @Test
  @DisplayName("Test getDefaultDeduplicationDuration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long NotificationRuleTrigger.getDefaultDeduplicationDuration()"})
  void testGetDefaultDeduplicationDuration2() {
    // Arrange
    AlarmAssignmentTriggerBuilder actionTypeResult =
        AlarmAssignmentTrigger.builder().actionType(ActionType.ADDED);

    AlarmAssignmentTriggerBuilder tenantIdResult =
        actionTypeResult.alarmInfo(new AlarmInfo()).tenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(0L, tenantIdResult.user(new User()).build().getDefaultDeduplicationDuration());
  }
}
