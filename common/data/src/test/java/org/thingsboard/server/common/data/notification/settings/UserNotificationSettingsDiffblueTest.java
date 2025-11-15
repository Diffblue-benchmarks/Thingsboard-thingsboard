/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data.notification.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationType;

class UserNotificationSettingsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserNotificationSettings#equals(Object)}
   *   <li>{@link UserNotificationSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserNotificationSettings userNotificationSettings = UserNotificationSettings.DEFAULT;
    UserNotificationSettings userNotificationSettings2 = UserNotificationSettings.DEFAULT;

    // Act and Assert
    assertEquals(userNotificationSettings, userNotificationSettings2);
    int expectedHashCodeResult = userNotificationSettings.hashCode();
    assertEquals(expectedHashCodeResult, userNotificationSettings2.hashCode());
  }

  /**
   * Method under test:
   * {@link UserNotificationSettings#isEnabled(NotificationType, NotificationDeliveryMethod)}
   */
  @Test
  void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue(UserNotificationSettings.DEFAULT.isEnabled(NotificationType.GENERAL, NotificationDeliveryMethod.WEB));
  }

  /**
   * Method under test:
   * {@link UserNotificationSettings#isEnabled(NotificationType, NotificationDeliveryMethod)}
   */
  @Test
  void testIsEnabled2() {
    // Arrange
    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    HashMap<NotificationType, UserNotificationSettings.NotificationPref> prefs = new HashMap<>();
    prefs.put(NotificationType.GENERAL, notificationPref);

    // Act and Assert
    assertTrue(
        (new UserNotificationSettings(prefs)).isEnabled(NotificationType.GENERAL, NotificationDeliveryMethod.WEB));
  }

  /**
   * Method under test:
   * {@link UserNotificationSettings#isEnabled(NotificationType, NotificationDeliveryMethod)}
   */
  @Test
  void testIsEnabled3() {
    // Arrange
    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    HashMap<NotificationType, UserNotificationSettings.NotificationPref> prefs = new HashMap<>();
    prefs.computeIfPresent(NotificationType.GENERAL, mock(BiFunction.class));
    prefs.put(NotificationType.GENERAL, notificationPref);

    // Act and Assert
    assertTrue(
        (new UserNotificationSettings(prefs)).isEnabled(NotificationType.GENERAL, NotificationDeliveryMethod.WEB));
  }

  /**
   * Method under test:
   * {@link UserNotificationSettings#isEnabled(NotificationType, NotificationDeliveryMethod)}
   */
  @Test
  void testIsEnabled4() {
    // Arrange
    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(false);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    HashMap<NotificationType, UserNotificationSettings.NotificationPref> prefs = new HashMap<>();
    prefs.put(NotificationType.GENERAL, notificationPref);

    // Act and Assert
    assertFalse(
        (new UserNotificationSettings(prefs)).isEnabled(NotificationType.GENERAL, NotificationDeliveryMethod.WEB));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserNotificationSettings#equals(Object)}
   *   <li>{@link UserNotificationSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserNotificationSettings userNotificationSettings = new UserNotificationSettings(new HashMap<>());
    UserNotificationSettings userNotificationSettings2 = UserNotificationSettings.DEFAULT;

    // Act and Assert
    assertEquals(userNotificationSettings, userNotificationSettings2);
    int expectedHashCodeResult = userNotificationSettings.hashCode();
    assertEquals(expectedHashCodeResult, userNotificationSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserNotificationSettings#equals(Object)}
   *   <li>{@link UserNotificationSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserNotificationSettings userNotificationSettings = UserNotificationSettings.DEFAULT;

    // Act and Assert
    assertEquals(userNotificationSettings, userNotificationSettings);
    int expectedHashCodeResult = userNotificationSettings.hashCode();
    assertEquals(expectedHashCodeResult, userNotificationSettings.hashCode());
  }

  /**
   * Method under test: {@link UserNotificationSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UserNotificationSettings.DEFAULT, 1);
  }

  /**
   * Method under test: {@link UserNotificationSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    HashMap<NotificationType, UserNotificationSettings.NotificationPref> prefs = new HashMap<>();
    prefs.put(NotificationType.GENERAL, notificationPref);

    // Act and Assert
    assertNotEquals(new UserNotificationSettings(prefs), UserNotificationSettings.DEFAULT);
  }

  /**
   * Method under test: {@link UserNotificationSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    HashMap<NotificationType, UserNotificationSettings.NotificationPref> prefs = new HashMap<>();
    prefs.computeIfPresent(NotificationType.GENERAL, mock(BiFunction.class));
    prefs.put(NotificationType.GENERAL, notificationPref);

    // Act and Assert
    assertNotEquals(new UserNotificationSettings(prefs), UserNotificationSettings.DEFAULT);
  }

  /**
   * Method under test: {@link UserNotificationSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UserNotificationSettings.DEFAULT, null);
  }

  /**
   * Method under test: {@link UserNotificationSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UserNotificationSettings.DEFAULT, "Different type to UserNotificationSettings");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserNotificationSettings#UserNotificationSettings(Map)}
   *   <li>{@link UserNotificationSettings#toString()}
   *   <li>{@link UserNotificationSettings#getPrefs()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    HashMap<NotificationType, UserNotificationSettings.NotificationPref> prefs = new HashMap<>();

    // Act
    UserNotificationSettings actualUserNotificationSettings = new UserNotificationSettings(prefs);
    String actualToStringResult = actualUserNotificationSettings.toString();
    Map<NotificationType, UserNotificationSettings.NotificationPref> actualPrefs = actualUserNotificationSettings
        .getPrefs();

    // Assert
    assertEquals("UserNotificationSettings(prefs={})", actualToStringResult);
    assertTrue(actualPrefs.isEmpty());
    assertSame(prefs, actualPrefs);
  }

  /**
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#createDefault()}
   */
  @Test
  void testNotificationPrefCreateDefault() {
    // Arrange and Act
    UserNotificationSettings.NotificationPref actualCreateDefaultResult = UserNotificationSettings.NotificationPref
        .createDefault();

    // Assert
    Map<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = actualCreateDefaultResult
        .getEnabledDeliveryMethods();
    assertEquals(4, enabledDeliveryMethods.size());
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.EMAIL));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.MOBILE_APP));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.SMS));
    assertTrue(enabledDeliveryMethods.get(NotificationDeliveryMethod.WEB));
    assertTrue(actualCreateDefaultResult.isEnabled());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserNotificationSettings.NotificationPref#equals(Object)}
   *   <li>{@link UserNotificationSettings.NotificationPref#hashCode()}
   * </ul>
   */
  @Test
  void testNotificationPrefEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    UserNotificationSettings.NotificationPref notificationPref2 = new UserNotificationSettings.NotificationPref();
    notificationPref2.setEnabled(true);
    notificationPref2.setEnabledDeliveryMethods(new HashMap<>());

    // Act and Assert
    assertEquals(notificationPref, notificationPref2);
    int expectedHashCodeResult = notificationPref.hashCode();
    assertEquals(expectedHashCodeResult, notificationPref2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserNotificationSettings.NotificationPref#equals(Object)}
   *   <li>{@link UserNotificationSettings.NotificationPref#hashCode()}
   * </ul>
   */
  @Test
  void testNotificationPrefEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    // Act and Assert
    assertEquals(notificationPref, notificationPref);
    int expectedHashCodeResult = notificationPref.hashCode();
    assertEquals(expectedHashCodeResult, notificationPref.hashCode());
  }

  /**
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#equals(Object)}
   */
  @Test
  void testNotificationPrefEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(false);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    UserNotificationSettings.NotificationPref notificationPref2 = new UserNotificationSettings.NotificationPref();
    notificationPref2.setEnabled(true);
    notificationPref2.setEnabledDeliveryMethods(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationPref, notificationPref2);
  }

  /**
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#equals(Object)}
   */
  @Test
  void testNotificationPrefEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = new HashMap<>();
    enabledDeliveryMethods.put(NotificationDeliveryMethod.WEB, true);

    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(enabledDeliveryMethods);

    UserNotificationSettings.NotificationPref notificationPref2 = new UserNotificationSettings.NotificationPref();
    notificationPref2.setEnabled(true);
    notificationPref2.setEnabledDeliveryMethods(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationPref, notificationPref2);
  }

  /**
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#equals(Object)}
   */
  @Test
  void testNotificationPrefEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashMap<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = new HashMap<>();
    enabledDeliveryMethods.computeIfPresent(NotificationDeliveryMethod.WEB, mock(BiFunction.class));
    enabledDeliveryMethods.put(NotificationDeliveryMethod.WEB, true);

    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(enabledDeliveryMethods);

    UserNotificationSettings.NotificationPref notificationPref2 = new UserNotificationSettings.NotificationPref();
    notificationPref2.setEnabled(true);
    notificationPref2.setEnabledDeliveryMethods(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationPref, notificationPref2);
  }

  /**
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#equals(Object)}
   */
  @Test
  void testNotificationPrefEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationPref, null);
  }

  /**
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#equals(Object)}
   */
  @Test
  void testNotificationPrefEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationPref, "Different type to NotificationPref");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link UserNotificationSettings.NotificationPref}
   *   <li>{@link UserNotificationSettings.NotificationPref#setEnabled(boolean)}
   *   <li>
   * {@link UserNotificationSettings.NotificationPref#setEnabledDeliveryMethods(Map)}
   *   <li>{@link UserNotificationSettings.NotificationPref#toString()}
   *   <li>
   * {@link UserNotificationSettings.NotificationPref#getEnabledDeliveryMethods()}
   *   <li>{@link UserNotificationSettings.NotificationPref#isEnabled()}
   * </ul>
   */
  @Test
  void testNotificationPrefGettersAndSetters() {
    // Arrange and Act
    UserNotificationSettings.NotificationPref actualNotificationPref = new UserNotificationSettings.NotificationPref();
    actualNotificationPref.setEnabled(true);
    HashMap<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = new HashMap<>();
    actualNotificationPref.setEnabledDeliveryMethods(enabledDeliveryMethods);
    String actualToStringResult = actualNotificationPref.toString();
    Map<NotificationDeliveryMethod, Boolean> actualEnabledDeliveryMethods = actualNotificationPref
        .getEnabledDeliveryMethods();
    boolean actualIsEnabledResult = actualNotificationPref.isEnabled();

    // Assert that nothing has changed
    assertEquals("UserNotificationSettings.NotificationPref(enabled=true, enabledDeliveryMethods={})",
        actualToStringResult);
    assertTrue(actualEnabledDeliveryMethods.isEmpty());
    assertTrue(actualIsEnabledResult);
    assertSame(enabledDeliveryMethods, actualEnabledDeliveryMethods);
  }

  /**
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#isValid()}
   */
  @Test
  void testNotificationPrefIsValid() {
    // Arrange
    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    // Act and Assert
    assertTrue(notificationPref.isValid());
  }

  /**
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#isValid()}
   */
  @Test
  void testNotificationPrefIsValid2() {
    // Arrange, Act and Assert
    assertTrue(UserNotificationSettings.NotificationPref.createDefault().isValid());
  }

  /**
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#isValid()}
   */
  @Test
  void testNotificationPrefIsValid3() {
    // Arrange
    HashMap<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = new HashMap<>();
    enabledDeliveryMethods.put(NotificationDeliveryMethod.SLACK, true);

    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(enabledDeliveryMethods);

    // Act and Assert
    assertFalse(notificationPref.isValid());
  }

  /**
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#isValid()}
   */
  @Test
  void testNotificationPrefIsValid4() {
    // Arrange
    HashMap<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = new HashMap<>();
    enabledDeliveryMethods.computeIfPresent(NotificationDeliveryMethod.WEB, mock(BiFunction.class));

    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(enabledDeliveryMethods);

    // Act and Assert
    assertTrue(notificationPref.isValid());
  }
}
