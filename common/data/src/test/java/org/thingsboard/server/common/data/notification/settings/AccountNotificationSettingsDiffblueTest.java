package org.thingsboard.server.common.data.notification.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class AccountNotificationSettingsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link AccountNotificationSettings}
   *   <li>{@link AccountNotificationSettings#setAllowedNotifications(Set)}
   *   <li>{@link AccountNotificationSettings#toString()}
   *   <li>{@link AccountNotificationSettings#getAllowedNotifications()}
   *   <li>{@link AccountNotificationSettings#getUserId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    AccountNotificationSettings actualAccountNotificationSettings = new AccountNotificationSettings();
    HashSet<NotificationDeliveryMethod> allowedNotifications = new HashSet<>();
    actualAccountNotificationSettings.setAllowedNotifications(allowedNotifications);
    String actualToStringResult = actualAccountNotificationSettings.toString();
    Set<NotificationDeliveryMethod> actualAllowedNotifications = actualAccountNotificationSettings
        .getAllowedNotifications();
    actualAccountNotificationSettings.getUserId();

    // Assert that nothing has changed
    assertEquals("AccountNotificationSettings(userId=null, allowedNotifications=[])", actualToStringResult);
    assertTrue(actualAllowedNotifications.isEmpty());
    assertSame(allowedNotifications, actualAllowedNotifications);
  }
}
