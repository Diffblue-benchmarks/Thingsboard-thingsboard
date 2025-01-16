package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class NotificationInfoDiffblueTest {
  /**
   * Test {@link NotificationInfo#getStateEntityId()}.
   * <ul>
   *   <li>Given
   * {@link ApiUsageLimitNotificationInfo#ApiUsageLimitNotificationInfo()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationInfo#getStateEntityId()}
   */
  @Test
  @DisplayName("Test getStateEntityId(); given ApiUsageLimitNotificationInfo(); then return 'null'")
  void testGetStateEntityId_givenApiUsageLimitNotificationInfo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ApiUsageLimitNotificationInfo()).getStateEntityId());
  }

  /**
   * Test {@link NotificationInfo#getStateEntityId()}.
   * <ul>
   *   <li>Then calls {@link NotificationInfo#getStateEntityId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationInfo#getStateEntityId()}
   */
  @Test
  @DisplayName("Test getStateEntityId(); then calls getStateEntityId()")
  void testGetStateEntityId_thenCallsGetStateEntityId() {
    // Arrange
    NotificationInfo notificationInfo = mock(NotificationInfo.class);
    when(notificationInfo.getStateEntityId()).thenReturn(TenantId.SYS_TENANT_ID);

    // Act
    notificationInfo.getStateEntityId();

    // Assert
    verify(notificationInfo).getStateEntityId();
  }

  /**
   * Test {@link NotificationInfo#getDashboardId()}.
   * <ul>
   *   <li>Given
   * {@link ApiUsageLimitNotificationInfo#ApiUsageLimitNotificationInfo()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationInfo#getDashboardId()}
   */
  @Test
  @DisplayName("Test getDashboardId(); given ApiUsageLimitNotificationInfo(); then return 'null'")
  void testGetDashboardId_givenApiUsageLimitNotificationInfo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ApiUsageLimitNotificationInfo()).getDashboardId());
  }

  /**
   * Test {@link NotificationInfo#getDashboardId()}.
   * <ul>
   *   <li>Then calls {@link NotificationInfo#getDashboardId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationInfo#getDashboardId()}
   */
  @Test
  @DisplayName("Test getDashboardId(); then calls getDashboardId()")
  void testGetDashboardId_thenCallsGetDashboardId() {
    // Arrange
    NotificationInfo notificationInfo = mock(NotificationInfo.class);
    when(notificationInfo.getDashboardId()).thenReturn(null);

    // Act
    notificationInfo.getDashboardId();

    // Assert
    verify(notificationInfo).getDashboardId();
  }
}
