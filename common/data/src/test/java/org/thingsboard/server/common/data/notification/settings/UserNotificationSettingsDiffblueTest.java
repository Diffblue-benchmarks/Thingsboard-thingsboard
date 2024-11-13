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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.settings.UserNotificationSettings.NotificationPref;

class UserNotificationSettingsDiffblueTest {
  /**
   * Test {@link UserNotificationSettings#equals(Object)}, and
   * {@link UserNotificationSettings#hashCode()}.
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
   * Test {@link UserNotificationSettings#equals(Object)}, and
   * {@link UserNotificationSettings#hashCode()}.
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
   * Test {@link UserNotificationSettings#equals(Object)}, and
   * {@link UserNotificationSettings#hashCode()}.
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
   * Test
   * {@link UserNotificationSettings#isEnabled(NotificationType, NotificationDeliveryMethod)}.
   * <ul>
   *   <li>Given {@link UserNotificationSettings#DEFAULT}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserNotificationSettings#isEnabled(NotificationType, NotificationDeliveryMethod)}
   */
  @Test
  @DisplayName("Test isEnabled(NotificationType, NotificationDeliveryMethod); given DEFAULT; then return 'true'")
  void testIsEnabled_givenDefault_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(UserNotificationSettings.DEFAULT.isEnabled(NotificationType.GENERAL, NotificationDeliveryMethod.WEB));
  }

  /**
   * Test
   * {@link UserNotificationSettings#isEnabled(NotificationType, NotificationDeliveryMethod)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code GENERAL} and
   * {@link BiFunction}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserNotificationSettings#isEnabled(NotificationType, NotificationDeliveryMethod)}
   */
  @Test
  @DisplayName("Test isEnabled(NotificationType, NotificationDeliveryMethod); given HashMap() computeIfPresent 'GENERAL' and BiFunction; then return 'true'")
  void testIsEnabled_givenHashMapComputeIfPresentGeneralAndBiFunction_thenReturnTrue() {
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
   * Test
   * {@link UserNotificationSettings#isEnabled(NotificationType, NotificationDeliveryMethod)}.
   * <ul>
   *   <li>Given {@link NotificationPref} (default constructor) Enabled is
   * {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserNotificationSettings#isEnabled(NotificationType, NotificationDeliveryMethod)}
   */
  @Test
  @DisplayName("Test isEnabled(NotificationType, NotificationDeliveryMethod); given NotificationPref (default constructor) Enabled is 'false'; then return 'false'")
  void testIsEnabled_givenNotificationPrefEnabledIsFalse_thenReturnFalse() {
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
   * Test
   * {@link UserNotificationSettings#isEnabled(NotificationType, NotificationDeliveryMethod)}.
   * <ul>
   *   <li>Given {@link NotificationPref} (default constructor) Enabled is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserNotificationSettings#isEnabled(NotificationType, NotificationDeliveryMethod)}
   */
  @Test
  @DisplayName("Test isEnabled(NotificationType, NotificationDeliveryMethod); given NotificationPref (default constructor) Enabled is 'true'; then return 'true'")
  void testIsEnabled_givenNotificationPrefEnabledIsTrue_thenReturnTrue() {
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
   * Test NotificationPref {@link NotificationPref#createDefault()}.
   * <p>
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#createDefault()}
   */
  @Test
  @DisplayName("Test NotificationPref createDefault()")
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
   * Test NotificationPref {@link NotificationPref#equals(Object)}, and
   * {@link NotificationPref#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserNotificationSettings.NotificationPref#equals(Object)}
   *   <li>{@link UserNotificationSettings.NotificationPref#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test NotificationPref equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test NotificationPref {@link NotificationPref#equals(Object)}, and
   * {@link NotificationPref#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserNotificationSettings.NotificationPref#equals(Object)}
   *   <li>{@link UserNotificationSettings.NotificationPref#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test NotificationPref equals(Object), and hashCode(); when other is same; then return equal")
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
   * Test NotificationPref {@link NotificationPref#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#equals(Object)}
   */
  @Test
  @DisplayName("Test NotificationPref equals(Object); when other is different; then return not equal")
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
   * Test NotificationPref {@link NotificationPref#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#equals(Object)}
   */
  @Test
  @DisplayName("Test NotificationPref equals(Object); when other is different; then return not equal")
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
   * Test NotificationPref {@link NotificationPref#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#equals(Object)}
   */
  @Test
  @DisplayName("Test NotificationPref equals(Object); when other is different; then return not equal")
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
   * Test NotificationPref {@link NotificationPref#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#equals(Object)}
   */
  @Test
  @DisplayName("Test NotificationPref equals(Object); when other is 'null'; then return not equal")
  void testNotificationPrefEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
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
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#equals(Object)}
   */
  @Test
  @DisplayName("Test NotificationPref equals(Object); when other is wrong type; then return not equal")
  void testNotificationPrefEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
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
  @DisplayName("Test NotificationPref getters and setters")
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
   * Test NotificationPref {@link NotificationPref#isValid()}.
   * <ul>
   *   <li>Given createDefault.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#isValid()}
   */
  @Test
  @DisplayName("Test NotificationPref isValid(); given createDefault; then return 'true'")
  void testNotificationPrefIsValid_givenCreateDefault_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(UserNotificationSettings.NotificationPref.createDefault().isValid());
  }

  /**
   * Test NotificationPref {@link NotificationPref#isValid()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code WEB} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#isValid()}
   */
  @Test
  @DisplayName("Test NotificationPref isValid(); given HashMap() computeIfPresent 'WEB' and BiFunction")
  void testNotificationPrefIsValid_givenHashMapComputeIfPresentWebAndBiFunction() {
    // Arrange
    HashMap<NotificationDeliveryMethod, Boolean> enabledDeliveryMethods = new HashMap<>();
    enabledDeliveryMethods.computeIfPresent(NotificationDeliveryMethod.WEB, mock(BiFunction.class));

    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(enabledDeliveryMethods);

    // Act and Assert
    assertTrue(notificationPref.isValid());
  }

  /**
   * Test NotificationPref {@link NotificationPref#isValid()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code SLACK} is {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#isValid()}
   */
  @Test
  @DisplayName("Test NotificationPref isValid(); given HashMap() 'SLACK' is 'true'; then return 'false'")
  void testNotificationPrefIsValid_givenHashMapSlackIsTrue_thenReturnFalse() {
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
   * Test NotificationPref {@link NotificationPref#isValid()}.
   * <ul>
   *   <li>Given {@link NotificationPref} (default constructor) Enabled is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserNotificationSettings.NotificationPref#isValid()}
   */
  @Test
  @DisplayName("Test NotificationPref isValid(); given NotificationPref (default constructor) Enabled is 'true'; then return 'true'")
  void testNotificationPrefIsValid_givenNotificationPrefEnabledIsTrue_thenReturnTrue() {
    // Arrange
    UserNotificationSettings.NotificationPref notificationPref = new UserNotificationSettings.NotificationPref();
    notificationPref.setEnabled(true);
    notificationPref.setEnabledDeliveryMethods(new HashMap<>());

    // Act and Assert
    assertTrue(notificationPref.isValid());
  }
}
