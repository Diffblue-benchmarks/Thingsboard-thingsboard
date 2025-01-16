package org.thingsboard.server.common.data.notification.targets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class NotificationTargetTypeDiffblueTest {
  /**
   * Test
   * {@link NotificationTargetType#forDeliveryMethod(NotificationDeliveryMethod)}.
   * <ul>
   *   <li>When {@code SLACK}.</li>
   *   <li>Then return {@code SLACK}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTargetType#forDeliveryMethod(NotificationDeliveryMethod)}
   */
  @Test
  @DisplayName("Test forDeliveryMethod(NotificationDeliveryMethod); when 'SLACK'; then return 'SLACK'")
  void testForDeliveryMethod_whenSlack_thenReturnSlack() {
    // Arrange, Act and Assert
    assertEquals(NotificationTargetType.SLACK,
        NotificationTargetType.forDeliveryMethod(NotificationDeliveryMethod.SLACK));
  }

  /**
   * Test
   * {@link NotificationTargetType#forDeliveryMethod(NotificationDeliveryMethod)}.
   * <ul>
   *   <li>When {@code WEB}.</li>
   *   <li>Then return {@code PLATFORM_USERS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTargetType#forDeliveryMethod(NotificationDeliveryMethod)}
   */
  @Test
  @DisplayName("Test forDeliveryMethod(NotificationDeliveryMethod); when 'WEB'; then return 'PLATFORM_USERS'")
  void testForDeliveryMethod_whenWeb_thenReturnPlatformUsers() {
    // Arrange, Act and Assert
    assertEquals(NotificationTargetType.PLATFORM_USERS,
        NotificationTargetType.forDeliveryMethod(NotificationDeliveryMethod.WEB));
  }

  /**
   * Test {@link NotificationTargetType#getSupportedDeliveryMethods()}.
   * <p>
   * Method under test:
   * {@link NotificationTargetType#getSupportedDeliveryMethods()}
   */
  @Test
  @DisplayName("Test getSupportedDeliveryMethods()")
  void testGetSupportedDeliveryMethods() {
    // Arrange and Act
    Set<NotificationDeliveryMethod> actualSupportedDeliveryMethods = NotificationTargetType.valueOf("PLATFORM_USERS")
        .getSupportedDeliveryMethods();

    // Assert
    assertEquals(4, actualSupportedDeliveryMethods.size());
    assertTrue(actualSupportedDeliveryMethods.contains(NotificationDeliveryMethod.EMAIL));
    assertTrue(actualSupportedDeliveryMethods.contains(NotificationDeliveryMethod.MOBILE_APP));
    assertTrue(actualSupportedDeliveryMethods.contains(NotificationDeliveryMethod.SMS));
    assertTrue(actualSupportedDeliveryMethods.contains(NotificationDeliveryMethod.WEB));
  }
}
