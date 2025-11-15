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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.settings.UserNotificationSettings.NotificationPref;

class UserNotificationSettingsDiffblueTest {
  /**
   * Test {@link UserNotificationSettings#equals(Object)}, and {@link UserNotificationSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserNotificationSettings#equals(Object)}
   *   <li>{@link UserNotificationSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserNotificationSettings.equals(Object)", "int UserNotificationSettings.hashCode()"})
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
   * Test {@link UserNotificationSettings#equals(Object)}, and {@link UserNotificationSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserNotificationSettings#equals(Object)}
   *   <li>{@link UserNotificationSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserNotificationSettings.equals(Object)", "int UserNotificationSettings.hashCode()"})
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
   * Test {@link UserNotificationSettings#equals(Object)}, and {@link UserNotificationSettings#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserNotificationSettings#equals(Object)}
   *   <li>{@link UserNotificationSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserNotificationSettings.equals(Object)", "int UserNotificationSettings.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserNotificationSettings userNotificationSettings = UserNotificationSettings.DEFAULT;

    // Act and Assert
    assertEquals(userNotificationSettings, userNotificationSettings);
    int expectedHashCodeResult = userNotificationSettings.hashCode();
    assertEquals(expectedHashCodeResult, userNotificationSettings.hashCode());
  }

  /**
   * Test {@link UserNotificationSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserNotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserNotificationSettings.equals(Object)", "int UserNotificationSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UserNotificationSettings.DEFAULT, 1);
  }

  /**
   * Test {@link UserNotificationSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserNotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserNotificationSettings.equals(Object)", "int UserNotificationSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationPref notificationPref = new NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    HashMap<NotificationType, NotificationPref> prefs = new HashMap<>();
    prefs.put(NotificationType.GENERAL, notificationPref);

    // Act and Assert
    assertNotEquals(new UserNotificationSettings(prefs), UserNotificationSettings.DEFAULT);
  }

  /**
   * Test {@link UserNotificationSettings#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserNotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserNotificationSettings.equals(Object)", "int UserNotificationSettings.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UserNotificationSettings.DEFAULT, null);
  }

  /**
   * Test {@link UserNotificationSettings#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserNotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserNotificationSettings.equals(Object)", "int UserNotificationSettings.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(UserNotificationSettings.DEFAULT, "Different type to UserNotificationSettings");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserNotificationSettings#UserNotificationSettings(Map)}
   *   <li>{@link UserNotificationSettings#toString()}
   *   <li>{@link UserNotificationSettings#getPrefs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserNotificationSettings.<init>(Map)", "Map UserNotificationSettings.getPrefs()",
      "String UserNotificationSettings.toString()"})
  void testGettersAndSetters() {
    // Arrange
    HashMap<NotificationType, NotificationPref> prefs = new HashMap<>();

    // Act
    UserNotificationSettings actualUserNotificationSettings = new UserNotificationSettings(prefs);
    String actualToStringResult = actualUserNotificationSettings.toString();
    Map<NotificationType, NotificationPref> actualPrefs = actualUserNotificationSettings.getPrefs();

    // Assert
    assertEquals("UserNotificationSettings(prefs={})", actualToStringResult);
    assertTrue(actualPrefs.isEmpty());
    assertSame(prefs, actualPrefs);
  }

  /**
   * Test {@link UserNotificationSettings#isEnabled(NotificationType, NotificationDeliveryMethod)}.
   * <ul>
   *   <li>Given {@link UserNotificationSettings#DEFAULT}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserNotificationSettings#isEnabled(NotificationType, NotificationDeliveryMethod)}
   */
  @Test
  @DisplayName("Test isEnabled(NotificationType, NotificationDeliveryMethod); given DEFAULT; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserNotificationSettings.isEnabled(NotificationType, NotificationDeliveryMethod)"})
  void testIsEnabled_givenDefault_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(UserNotificationSettings.DEFAULT.isEnabled(NotificationType.GENERAL, NotificationDeliveryMethod.WEB));
  }

  /**
   * Test {@link UserNotificationSettings#isEnabled(NotificationType, NotificationDeliveryMethod)}.
   * <ul>
   *   <li>Given {@link NotificationPref} (default constructor) Enabled is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserNotificationSettings#isEnabled(NotificationType, NotificationDeliveryMethod)}
   */
  @Test
  @DisplayName("Test isEnabled(NotificationType, NotificationDeliveryMethod); given NotificationPref (default constructor) Enabled is 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserNotificationSettings.isEnabled(NotificationType, NotificationDeliveryMethod)"})
  void testIsEnabled_givenNotificationPrefEnabledIsFalse_thenReturnFalse() {
    // Arrange
    NotificationPref notificationPref = new NotificationPref();
    notificationPref.setEnabled(false);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    HashMap<NotificationType, NotificationPref> prefs = new HashMap<>();
    prefs.put(NotificationType.GENERAL, notificationPref);

    // Act and Assert
    assertFalse(
        (new UserNotificationSettings(prefs)).isEnabled(NotificationType.GENERAL, NotificationDeliveryMethod.WEB));
  }

  /**
   * Test {@link UserNotificationSettings#isEnabled(NotificationType, NotificationDeliveryMethod)}.
   * <ul>
   *   <li>Given {@link NotificationPref} (default constructor) Enabled is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserNotificationSettings#isEnabled(NotificationType, NotificationDeliveryMethod)}
   */
  @Test
  @DisplayName("Test isEnabled(NotificationType, NotificationDeliveryMethod); given NotificationPref (default constructor) Enabled is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserNotificationSettings.isEnabled(NotificationType, NotificationDeliveryMethod)"})
  void testIsEnabled_givenNotificationPrefEnabledIsTrue_thenReturnTrue() {
    // Arrange
    NotificationPref notificationPref = new NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    HashMap<NotificationType, NotificationPref> prefs = new HashMap<>();
    prefs.put(NotificationType.GENERAL, notificationPref);

    // Act and Assert
    assertTrue(
        (new UserNotificationSettings(prefs)).isEnabled(NotificationType.GENERAL, NotificationDeliveryMethod.WEB));
  }

  /**
   * Test NotificationPref {@link NotificationPref#createDefault()}.
   * <p>
   * Method under test: {@link NotificationPref#createDefault()}
   */
  @Test
  @DisplayName("Test NotificationPref createDefault()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationPref NotificationPref.createDefault()"})
  void testNotificationPrefCreateDefault() {
    // Arrange and Act
    NotificationPref actualCreateDefaultResult = NotificationPref.createDefault();

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
   * Test NotificationPref {@link NotificationPref#equals(Object)}, and {@link NotificationPref#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationPref#equals(Object)}
   *   <li>{@link NotificationPref#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test NotificationPref equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationPref.equals(Object)", "int NotificationPref.hashCode()"})
  void testNotificationPrefEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationPref notificationPref = new NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    NotificationPref notificationPref2 = new NotificationPref();
    notificationPref2.setEnabled(true);
    notificationPref2.setEnabledDeliveryMethods(new HashMap<>());

    // Act and Assert
    assertEquals(notificationPref, notificationPref2);
    int expectedHashCodeResult = notificationPref.hashCode();
    assertEquals(expectedHashCodeResult, notificationPref2.hashCode());
  }

  /**
   * Test NotificationPref {@link NotificationPref#equals(Object)}, and {@link NotificationPref#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationPref#equals(Object)}
   *   <li>{@link NotificationPref#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test NotificationPref equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationPref.equals(Object)", "int NotificationPref.hashCode()"})
  void testNotificationPrefEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationPref notificationPref = new NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    // Act and Assert
    assertEquals(notificationPref, notificationPref);
    int expectedHashCodeResult = notificationPref.hashCode();
    assertEquals(expectedHashCodeResult, notificationPref.hashCode());
  }

  /**
   * Test NotificationPref {@link NotificationPref#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationPref#equals(Object)}
   */
  @Test
  @DisplayName("Test NotificationPref equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationPref.equals(Object)", "int NotificationPref.hashCode()"})
  void testNotificationPrefEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationPref notificationPref = new NotificationPref();
    notificationPref.setEnabled(false);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    NotificationPref notificationPref2 = new NotificationPref();
    notificationPref2.setEnabled(true);
    notificationPref2.setEnabledDeliveryMethods(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationPref, notificationPref2);
  }

  /**
   * Test NotificationPref {@link NotificationPref#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationPref#equals(Object)}
   */
  @Test
  @DisplayName("Test NotificationPref equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationPref.equals(Object)", "int NotificationPref.hashCode()"})
  void testNotificationPrefEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = new HashMap<>();
    enabledDeliveryMethods.put(NotificationDeliveryMethod.WEB, true);

    NotificationPref notificationPref = new NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(enabledDeliveryMethods);

    NotificationPref notificationPref2 = new NotificationPref();
    notificationPref2.setEnabled(true);
    notificationPref2.setEnabledDeliveryMethods(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationPref, notificationPref2);
  }

  /**
   * Test NotificationPref {@link NotificationPref#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationPref#equals(Object)}
   */
  @Test
  @DisplayName("Test NotificationPref equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationPref.equals(Object)", "int NotificationPref.hashCode()"})
  void testNotificationPrefEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationPref notificationPref = new NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationPref, null);
  }

  /**
   * Test NotificationPref {@link NotificationPref#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationPref#equals(Object)}
   */
  @Test
  @DisplayName("Test NotificationPref equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationPref.equals(Object)", "int NotificationPref.hashCode()"})
  void testNotificationPrefEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationPref notificationPref = new NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationPref, "Different type to NotificationPref");
  }

  /**
   * Test NotificationPref getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NotificationPref}
   *   <li>{@link NotificationPref#setEnabled(boolean)}
   *   <li>{@link NotificationPref#setEnabledDeliveryMethods(Map)}
   *   <li>{@link NotificationPref#toString()}
   *   <li>{@link NotificationPref#getEnabledDeliveryMethods()}
   *   <li>{@link NotificationPref#isEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test NotificationPref getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationPref.<init>()", "Map NotificationPref.getEnabledDeliveryMethods()",
      "boolean NotificationPref.isEnabled()", "void NotificationPref.setEnabled(boolean)",
      "void NotificationPref.setEnabledDeliveryMethods(Map)", "String NotificationPref.toString()"})
  void testNotificationPrefGettersAndSetters() {
    // Arrange and Act
    NotificationPref actualNotificationPref = new NotificationPref();
    actualNotificationPref.setEnabled(true);
    HashMap<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = new HashMap<>();
    actualNotificationPref.setEnabledDeliveryMethods(enabledDeliveryMethods);
    String actualToStringResult = actualNotificationPref.toString();
    Map<NotificationDeliveryMethod, Boolean> actualEnabledDeliveryMethods = actualNotificationPref
        .getEnabledDeliveryMethods();
    boolean actualIsEnabledResult = actualNotificationPref.isEnabled();

    // Assert
    assertEquals("UserNotificationSettings.NotificationPref(enabled=true, enabledDeliveryMethods={})",
        actualToStringResult);
    assertTrue(actualEnabledDeliveryMethods.isEmpty());
    assertTrue(actualIsEnabledResult);
    assertSame(enabledDeliveryMethods, actualEnabledDeliveryMethods);
  }

  /**
   * Test NotificationPref {@link NotificationPref#isValid()}.
   * <ul>
   *   <li>Given createDefault.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationPref#isValid()}
   */
  @Test
  @DisplayName("Test NotificationPref isValid(); given createDefault; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationPref.isValid()"})
  void testNotificationPrefIsValid_givenCreateDefault_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(NotificationPref.createDefault().isValid());
  }

  /**
   * Test NotificationPref {@link NotificationPref#isValid()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code SLACK} is {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationPref#isValid()}
   */
  @Test
  @DisplayName("Test NotificationPref isValid(); given HashMap() 'SLACK' is 'true'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationPref.isValid()"})
  void testNotificationPrefIsValid_givenHashMapSlackIsTrue_thenReturnFalse() {
    // Arrange
    HashMap<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = new HashMap<>();
    enabledDeliveryMethods.put(NotificationDeliveryMethod.SLACK, true);

    NotificationPref notificationPref = new NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(enabledDeliveryMethods);

    // Act and Assert
    assertFalse(notificationPref.isValid());
  }

  /**
   * Test NotificationPref {@link NotificationPref#isValid()}.
   * <ul>
   *   <li>Given {@link NotificationPref} (default constructor) Enabled is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationPref#isValid()}
   */
  @Test
  @DisplayName("Test NotificationPref isValid(); given NotificationPref (default constructor) Enabled is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationPref.isValid()"})
  void testNotificationPrefIsValid_givenNotificationPrefEnabledIsTrue_thenReturnTrue() {
    // Arrange
    NotificationPref notificationPref = new NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    // Act and Assert
    assertTrue(notificationPref.isValid());
  }
}
