package org.thingsboard.server.common.data.notification.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class NotificationSettingsDiffblueTest {
  /**
   * Test {@link NotificationSettings#equals(Object)}, and
   * {@link NotificationSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationSettings#equals(Object)}
   *   <li>{@link NotificationSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setDeliveryMethodsConfigs(new HashMap<>());

    NotificationSettings notificationSettings2 = new NotificationSettings();
    notificationSettings2.setDeliveryMethodsConfigs(new HashMap<>());

    // Act and Assert
    assertEquals(notificationSettings, notificationSettings2);
    int expectedHashCodeResult = notificationSettings.hashCode();
    assertEquals(expectedHashCodeResult, notificationSettings2.hashCode());
  }

  /**
   * Test {@link NotificationSettings#equals(Object)}, and
   * {@link NotificationSettings#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationSettings#equals(Object)}
   *   <li>{@link NotificationSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act and Assert
    assertEquals(notificationSettings, notificationSettings);
    int expectedHashCodeResult = notificationSettings.hashCode();
    assertEquals(expectedHashCodeResult, notificationSettings.hashCode());
  }

  /**
   * Test {@link NotificationSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashMap<NotificationDeliveryMethod, NotificationDeliveryMethodConfig> deliveryMethodsConfigs = new HashMap<>();
    deliveryMethodsConfigs.put(NotificationDeliveryMethod.WEB, mock(NotificationDeliveryMethodConfig.class));

    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setDeliveryMethodsConfigs(deliveryMethodsConfigs);

    NotificationSettings notificationSettings2 = new NotificationSettings();
    notificationSettings2.setDeliveryMethodsConfigs(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationSettings, notificationSettings2);
  }

  /**
   * Test {@link NotificationSettings#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationSettings, null);
  }

  /**
   * Test {@link NotificationSettings#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationSettings, "Different type to NotificationSettings");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NotificationSettings}
   *   <li>{@link NotificationSettings#setDeliveryMethodsConfigs(Map)}
   *   <li>{@link NotificationSettings#toString()}
   *   <li>{@link NotificationSettings#getDeliveryMethodsConfigs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationSettings actualNotificationSettings = new NotificationSettings();
    HashMap<NotificationDeliveryMethod, NotificationDeliveryMethodConfig> deliveryMethodsConfigs = new HashMap<>();
    actualNotificationSettings.setDeliveryMethodsConfigs(deliveryMethodsConfigs);
    String actualToStringResult = actualNotificationSettings.toString();
    Map<NotificationDeliveryMethod, NotificationDeliveryMethodConfig> actualDeliveryMethodsConfigs = actualNotificationSettings
        .getDeliveryMethodsConfigs();

    // Assert that nothing has changed
    assertEquals("NotificationSettings(deliveryMethodsConfigs={})", actualToStringResult);
    assertTrue(actualDeliveryMethodsConfigs.isEmpty());
    assertSame(deliveryMethodsConfigs, actualDeliveryMethodsConfigs);
  }
}
