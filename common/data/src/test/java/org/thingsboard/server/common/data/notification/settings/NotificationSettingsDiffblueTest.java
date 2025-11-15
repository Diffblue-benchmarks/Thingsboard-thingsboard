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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class NotificationSettingsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationSettings#equals(Object)}
   *   <li>{@link NotificationSettings#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationSettings#equals(Object)}
   *   <li>{@link NotificationSettings#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link NotificationSettings#equals(Object)}
   */
  @Test
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
   * Method under test: {@link NotificationSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationSettings, null);
  }

  /**
   * Method under test: {@link NotificationSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationSettings, "Different type to NotificationSettings");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NotificationSettings}
   *   <li>{@link NotificationSettings#setDeliveryMethodsConfigs(Map)}
   *   <li>{@link NotificationSettings#toString()}
   *   <li>{@link NotificationSettings#getDeliveryMethodsConfigs()}
   * </ul>
   */
  @Test
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
