package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NotificationInfoDiffblueTest {
  /**
   * Test {@link NotificationInfo#getStateEntityId()}.
   *
   * <p>Method under test: {@link NotificationInfo#getStateEntityId()}
   */
  @Test
  @DisplayName("Test getStateEntityId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.EntityId NotificationInfo.getStateEntityId()"
  })
  void testGetStateEntityId() {
    // Arrange, Act and Assert
    assertNull(new ApiUsageLimitNotificationInfo().getStateEntityId());
  }

  /**
   * Test {@link NotificationInfo#getDashboardId()}.
   *
   * <p>Method under test: {@link NotificationInfo#getDashboardId()}
   */
  @Test
  @DisplayName("Test getDashboardId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.DashboardId NotificationInfo.getDashboardId()"
  })
  void testGetDashboardId() {
    // Arrange, Act and Assert
    assertNull(new ApiUsageLimitNotificationInfo().getDashboardId());
  }
}
