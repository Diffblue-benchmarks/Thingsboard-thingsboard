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
package org.thingsboard.server.common.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class NotificationRequestConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestConfig#equals(Object)}
   *   <li>{@link NotificationRequestConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationRequestConfig notificationRequestConfig = new NotificationRequestConfig();
    notificationRequestConfig.setSendingDelayInSec(3);

    NotificationRequestConfig notificationRequestConfig2 = new NotificationRequestConfig();
    notificationRequestConfig2.setSendingDelayInSec(3);

    // Act and Assert
    assertEquals(notificationRequestConfig, notificationRequestConfig2);
    int expectedHashCodeResult = notificationRequestConfig.hashCode();
    assertEquals(expectedHashCodeResult, notificationRequestConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestConfig#equals(Object)}
   *   <li>{@link NotificationRequestConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRequestConfig notificationRequestConfig = new NotificationRequestConfig();
    notificationRequestConfig.setSendingDelayInSec(3);

    // Act and Assert
    assertEquals(notificationRequestConfig, notificationRequestConfig);
    int expectedHashCodeResult = notificationRequestConfig.hashCode();
    assertEquals(expectedHashCodeResult, notificationRequestConfig.hashCode());
  }

  /**
   * Method under test: {@link NotificationRequestConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRequestConfig notificationRequestConfig = new NotificationRequestConfig();
    notificationRequestConfig.setSendingDelayInSec(1);

    NotificationRequestConfig notificationRequestConfig2 = new NotificationRequestConfig();
    notificationRequestConfig2.setSendingDelayInSec(3);

    // Act and Assert
    assertNotEquals(notificationRequestConfig, notificationRequestConfig2);
  }

  /**
   * Method under test: {@link NotificationRequestConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationRequestConfig notificationRequestConfig = new NotificationRequestConfig();
    notificationRequestConfig.setSendingDelayInSec(3);

    // Act and Assert
    assertNotEquals(notificationRequestConfig, null);
  }

  /**
   * Method under test: {@link NotificationRequestConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationRequestConfig notificationRequestConfig = new NotificationRequestConfig();
    notificationRequestConfig.setSendingDelayInSec(3);

    // Act and Assert
    assertNotEquals(notificationRequestConfig, "Different type to NotificationRequestConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NotificationRequestConfig}
   *   <li>{@link NotificationRequestConfig#setSendingDelayInSec(int)}
   *   <li>{@link NotificationRequestConfig#toString()}
   *   <li>{@link NotificationRequestConfig#getSendingDelayInSec()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationRequestConfig actualNotificationRequestConfig = new NotificationRequestConfig();
    actualNotificationRequestConfig.setSendingDelayInSec(3);
    String actualToStringResult = actualNotificationRequestConfig.toString();

    // Assert that nothing has changed
    assertEquals("NotificationRequestConfig(sendingDelayInSec=3)", actualToStringResult);
    assertEquals(3, actualNotificationRequestConfig.getSendingDelayInSec());
  }
}
