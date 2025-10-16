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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class NotificationSettingsDiffblueTest {
  /**
   * Test {@link NotificationSettings#equals(Object)}, and {@link NotificationSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationSettings#equals(Object)}
   *   <li>{@link NotificationSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationSettings.equals(Object)",
    "int NotificationSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setDeliveryMethodsConfigs(new HashMap<>());

    NotificationSettings notificationSettings2 = new NotificationSettings();
    notificationSettings2.setDeliveryMethodsConfigs(new HashMap<>());

    // Act and Assert
    assertEquals(notificationSettings, notificationSettings2);
    assertEquals(notificationSettings.hashCode(), notificationSettings2.hashCode());
  }

  /**
   * Test {@link NotificationSettings#equals(Object)}, and {@link NotificationSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationSettings#equals(Object)}
   *   <li>{@link NotificationSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationSettings.equals(Object)",
    "int NotificationSettings.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationSettings.equals(Object)",
    "int NotificationSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashMap<NotificationDeliveryMethod, NotificationDeliveryMethodConfig> deliveryMethodsConfigs =
        new HashMap<>();
    deliveryMethodsConfigs.put(
        NotificationDeliveryMethod.WEB, mock(NotificationDeliveryMethodConfig.class));

    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setDeliveryMethodsConfigs(deliveryMethodsConfigs);

    NotificationSettings notificationSettings2 = new NotificationSettings();
    notificationSettings2.setDeliveryMethodsConfigs(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationSettings, notificationSettings2);
  }

  /**
   * Test {@link NotificationSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationSettings.equals(Object)",
    "int NotificationSettings.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationSettings, null);
  }

  /**
   * Test {@link NotificationSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NotificationSettings.equals(Object)",
    "int NotificationSettings.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setDeliveryMethodsConfigs(new HashMap<>());

    // Act and Assert
    assertNotEquals(notificationSettings, "Different type to NotificationSettings");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link NotificationSettings}
   *   <li>{@link NotificationSettings#setDeliveryMethodsConfigs(Map)}
   *   <li>{@link NotificationSettings#toString()}
   *   <li>{@link NotificationSettings#getDeliveryMethodsConfigs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationSettings.<init>()",
    "Map NotificationSettings.getDeliveryMethodsConfigs()",
    "void NotificationSettings.setDeliveryMethodsConfigs(Map)",
    "String NotificationSettings.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationSettings actualNotificationSettings = new NotificationSettings();
    HashMap<NotificationDeliveryMethod, NotificationDeliveryMethodConfig> deliveryMethodsConfigs =
        new HashMap<>();
    actualNotificationSettings.setDeliveryMethodsConfigs(deliveryMethodsConfigs);
    String actualToStringResult = actualNotificationSettings.toString();
    Map<NotificationDeliveryMethod, NotificationDeliveryMethodConfig> actualDeliveryMethodsConfigs =
        actualNotificationSettings.getDeliveryMethodsConfigs();

    // Assert
    assertEquals("NotificationSettings(deliveryMethodsConfigs={})", actualToStringResult);
    assertTrue(actualDeliveryMethodsConfigs.isEmpty());
    assertSame(deliveryMethodsConfigs, actualDeliveryMethodsConfigs);
  }
}
