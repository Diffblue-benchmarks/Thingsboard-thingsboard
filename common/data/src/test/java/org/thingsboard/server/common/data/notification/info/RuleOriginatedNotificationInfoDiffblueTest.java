package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class RuleOriginatedNotificationInfoDiffblueTest {
  /**
   * Test {@link RuleOriginatedNotificationInfo#getAffectedCustomerId()}.
   * <ul>
   *   <li>Given
   * {@link ApiUsageLimitNotificationInfo#ApiUsageLimitNotificationInfo()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleOriginatedNotificationInfo#getAffectedCustomerId()}
   */
  @Test
  @DisplayName("Test getAffectedCustomerId(); given ApiUsageLimitNotificationInfo(); then return 'null'")
  void testGetAffectedCustomerId_givenApiUsageLimitNotificationInfo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ApiUsageLimitNotificationInfo()).getAffectedCustomerId());
  }

  /**
   * Test {@link RuleOriginatedNotificationInfo#getAffectedCustomerId()}.
   * <ul>
   *   <li>Then calls
   * {@link RuleOriginatedNotificationInfo#getAffectedCustomerId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleOriginatedNotificationInfo#getAffectedCustomerId()}
   */
  @Test
  @DisplayName("Test getAffectedCustomerId(); then calls getAffectedCustomerId()")
  void testGetAffectedCustomerId_thenCallsGetAffectedCustomerId() {
    // Arrange
    RuleOriginatedNotificationInfo ruleOriginatedNotificationInfo = mock(RuleOriginatedNotificationInfo.class);
    when(ruleOriginatedNotificationInfo.getAffectedCustomerId()).thenReturn(new CustomerId(EntityId.NULL_UUID));

    // Act
    ruleOriginatedNotificationInfo.getAffectedCustomerId();

    // Assert
    verify(ruleOriginatedNotificationInfo).getAffectedCustomerId();
  }

  /**
   * Test {@link RuleOriginatedNotificationInfo#getAffectedUserId()}.
   * <ul>
   *   <li>Given
   * {@link AlarmCommentNotificationInfo#AlarmCommentNotificationInfo()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleOriginatedNotificationInfo#getAffectedUserId()}
   */
  @Test
  @DisplayName("Test getAffectedUserId(); given AlarmCommentNotificationInfo(); then return 'null'")
  void testGetAffectedUserId_givenAlarmCommentNotificationInfo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AlarmCommentNotificationInfo()).getAffectedUserId());
  }

  /**
   * Test {@link RuleOriginatedNotificationInfo#getAffectedUserId()}.
   * <ul>
   *   <li>Then calls
   * {@link RuleOriginatedNotificationInfo#getAffectedUserId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleOriginatedNotificationInfo#getAffectedUserId()}
   */
  @Test
  @DisplayName("Test getAffectedUserId(); then calls getAffectedUserId()")
  void testGetAffectedUserId_thenCallsGetAffectedUserId() {
    // Arrange
    RuleOriginatedNotificationInfo ruleOriginatedNotificationInfo = mock(RuleOriginatedNotificationInfo.class);
    when(ruleOriginatedNotificationInfo.getAffectedUserId()).thenReturn(null);

    // Act
    ruleOriginatedNotificationInfo.getAffectedUserId();

    // Assert
    verify(ruleOriginatedNotificationInfo).getAffectedUserId();
  }

  /**
   * Test {@link RuleOriginatedNotificationInfo#getAffectedTenantId()}.
   * <ul>
   *   <li>Given
   * {@link AlarmAssignmentNotificationInfo#AlarmAssignmentNotificationInfo()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleOriginatedNotificationInfo#getAffectedTenantId()}
   */
  @Test
  @DisplayName("Test getAffectedTenantId(); given AlarmAssignmentNotificationInfo(); then return 'null'")
  void testGetAffectedTenantId_givenAlarmAssignmentNotificationInfo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AlarmAssignmentNotificationInfo()).getAffectedTenantId());
  }

  /**
   * Test {@link RuleOriginatedNotificationInfo#getAffectedTenantId()}.
   * <ul>
   *   <li>Then calls
   * {@link RuleOriginatedNotificationInfo#getAffectedTenantId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RuleOriginatedNotificationInfo#getAffectedTenantId()}
   */
  @Test
  @DisplayName("Test getAffectedTenantId(); then calls getAffectedTenantId()")
  void testGetAffectedTenantId_thenCallsGetAffectedTenantId() {
    // Arrange
    RuleOriginatedNotificationInfo ruleOriginatedNotificationInfo = mock(RuleOriginatedNotificationInfo.class);
    when(ruleOriginatedNotificationInfo.getAffectedTenantId()).thenReturn(TenantId.SYS_TENANT_ID);

    // Act
    ruleOriginatedNotificationInfo.getAffectedTenantId();

    // Assert
    verify(ruleOriginatedNotificationInfo).getAffectedTenantId();
  }
}
