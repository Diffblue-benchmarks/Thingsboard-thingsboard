package org.thingsboard.server.common.data.notification.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class AccountNotificationSettingsDiffblueTest {
  /**
   * Test {@link AccountNotificationSettings#equals(Object)}, and {@link AccountNotificationSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountNotificationSettings#equals(Object)}
   *   <li>{@link AccountNotificationSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AccountNotificationSettings.equals(Object)",
      "int AccountNotificationSettings.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AccountNotificationSettings accountNotificationSettings = new AccountNotificationSettings();
    accountNotificationSettings.setAllowedNotifications(new HashSet<>());
    accountNotificationSettings.setUserId(null);

    AccountNotificationSettings accountNotificationSettings2 = new AccountNotificationSettings();
    accountNotificationSettings2.setAllowedNotifications(new HashSet<>());
    accountNotificationSettings2.setUserId(null);

    // Act and Assert
    assertEquals(accountNotificationSettings, accountNotificationSettings2);
    int expectedHashCodeResult = accountNotificationSettings.hashCode();
    assertEquals(expectedHashCodeResult, accountNotificationSettings2.hashCode());
  }

  /**
   * Test {@link AccountNotificationSettings#equals(Object)}, and {@link AccountNotificationSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AccountNotificationSettings#equals(Object)}
   *   <li>{@link AccountNotificationSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AccountNotificationSettings.equals(Object)",
      "int AccountNotificationSettings.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AccountNotificationSettings accountNotificationSettings = new AccountNotificationSettings();
    accountNotificationSettings.setAllowedNotifications(new HashSet<>());
    accountNotificationSettings.setUserId(new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    AccountNotificationSettings accountNotificationSettings2 = new AccountNotificationSettings();
    accountNotificationSettings2.setAllowedNotifications(new HashSet<>());
    accountNotificationSettings2.setUserId(new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertEquals(accountNotificationSettings, accountNotificationSettings2);
    int expectedHashCodeResult = accountNotificationSettings.hashCode();
    assertEquals(expectedHashCodeResult, accountNotificationSettings2.hashCode());
  }

  /**
   * Test {@link AccountNotificationSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountNotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AccountNotificationSettings.equals(Object)",
      "int AccountNotificationSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<NotificationDeliveryMethod> allowedNotifications = new HashSet<>();
    allowedNotifications.add(NotificationDeliveryMethod.WEB);

    AccountNotificationSettings accountNotificationSettings = new AccountNotificationSettings();
    accountNotificationSettings.setAllowedNotifications(allowedNotifications);
    accountNotificationSettings.setUserId(null);

    AccountNotificationSettings accountNotificationSettings2 = new AccountNotificationSettings();
    accountNotificationSettings2.setAllowedNotifications(new HashSet<>());
    accountNotificationSettings2.setUserId(null);

    // Act and Assert
    assertNotEquals(accountNotificationSettings, accountNotificationSettings2);
  }

  /**
   * Test {@link AccountNotificationSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountNotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AccountNotificationSettings.equals(Object)",
      "int AccountNotificationSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AccountNotificationSettings accountNotificationSettings = new AccountNotificationSettings();
    accountNotificationSettings.setAllowedNotifications(new HashSet<>());
    accountNotificationSettings.setUserId(new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    AccountNotificationSettings accountNotificationSettings2 = new AccountNotificationSettings();
    accountNotificationSettings2.setAllowedNotifications(new HashSet<>());
    accountNotificationSettings2.setUserId(null);

    // Act and Assert
    assertNotEquals(accountNotificationSettings, accountNotificationSettings2);
  }

  /**
   * Test {@link AccountNotificationSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccountNotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AccountNotificationSettings.equals(Object)",
      "int AccountNotificationSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<NotificationDeliveryMethod> allowedNotifications = new HashSet<>();
    allowedNotifications.add(NotificationDeliveryMethod.WEB);

    AccountNotificationSettings accountNotificationSettings = new AccountNotificationSettings();
    accountNotificationSettings.setAllowedNotifications(allowedNotifications);
    accountNotificationSettings.setUserId(null);

    AccountNotificationSettings accountNotificationSettings2 = new AccountNotificationSettings();
    accountNotificationSettings2.setAllowedNotifications(new HashSet<>());
    accountNotificationSettings2.setUserId(new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(accountNotificationSettings, accountNotificationSettings2);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AccountNotificationSettings}
   *   <li>{@link AccountNotificationSettings#setAllowedNotifications(Set)}
   *   <li>{@link AccountNotificationSettings#toString()}
   *   <li>{@link AccountNotificationSettings#getAllowedNotifications()}
   *   <li>{@link AccountNotificationSettings#getUserId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccountNotificationSettings.<init>()",
      "Set AccountNotificationSettings.getAllowedNotifications()", "UserId AccountNotificationSettings.getUserId()",
      "void AccountNotificationSettings.setAllowedNotifications(Set)",
      "void AccountNotificationSettings.setUserId(UserId)", "String AccountNotificationSettings.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    AccountNotificationSettings actualAccountNotificationSettings = new AccountNotificationSettings();
    HashSet<NotificationDeliveryMethod> allowedNotifications = new HashSet<>();
    actualAccountNotificationSettings.setAllowedNotifications(allowedNotifications);
    String actualToStringResult = actualAccountNotificationSettings.toString();
    Set<NotificationDeliveryMethod> actualAllowedNotifications = actualAccountNotificationSettings
        .getAllowedNotifications();

    // Assert
    assertEquals("AccountNotificationSettings(userId=null, allowedNotifications=[])", actualToStringResult);
    assertNull(actualAccountNotificationSettings.getUserId());
    assertTrue(actualAllowedNotifications.isEmpty());
    assertSame(allowedNotifications, actualAllowedNotifications);
  }
}
