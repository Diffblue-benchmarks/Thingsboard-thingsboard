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
package org.thingsboard.server.queue.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class TbQueueTransportNotificationSettingsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueTransportNotificationSettings#equals(Object)}
   *   <li>{@link TbQueueTransportNotificationSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings2 = new TbQueueTransportNotificationSettings();

    // Act and Assert
    assertEquals(tbQueueTransportNotificationSettings, tbQueueTransportNotificationSettings2);
    int expectedHashCodeResult = tbQueueTransportNotificationSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueTransportNotificationSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueTransportNotificationSettings#equals(Object)}
   *   <li>{@link TbQueueTransportNotificationSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings = new TbQueueTransportNotificationSettings();
    tbQueueTransportNotificationSettings.setNotificationsTopic("Notifications Topic");

    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    tbQueueTransportNotificationSettings2.setNotificationsTopic("Notifications Topic");

    // Act and Assert
    assertEquals(tbQueueTransportNotificationSettings, tbQueueTransportNotificationSettings2);
    int expectedHashCodeResult = tbQueueTransportNotificationSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueTransportNotificationSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueTransportNotificationSettings#equals(Object)}
   *   <li>{@link TbQueueTransportNotificationSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings = new TbQueueTransportNotificationSettings();

    // Act and Assert
    assertEquals(tbQueueTransportNotificationSettings, tbQueueTransportNotificationSettings);
    int expectedHashCodeResult = tbQueueTransportNotificationSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueTransportNotificationSettings.hashCode());
  }

  /**
   * Method under test:
   * {@link TbQueueTransportNotificationSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueTransportNotificationSettings(), 1);
  }

  /**
   * Method under test:
   * {@link TbQueueTransportNotificationSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings = new TbQueueTransportNotificationSettings();
    tbQueueTransportNotificationSettings.setNotificationsTopic("Notifications Topic");

    // Act and Assert
    assertNotEquals(tbQueueTransportNotificationSettings, new TbQueueTransportNotificationSettings());
  }

  /**
   * Method under test:
   * {@link TbQueueTransportNotificationSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings = new TbQueueTransportNotificationSettings();
    tbQueueTransportNotificationSettings.setTransportPollInterval(42L);

    // Act and Assert
    assertNotEquals(tbQueueTransportNotificationSettings, new TbQueueTransportNotificationSettings());
  }

  /**
   * Method under test:
   * {@link TbQueueTransportNotificationSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings = new TbQueueTransportNotificationSettings();

    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    tbQueueTransportNotificationSettings2.setNotificationsTopic("Notifications Topic");

    // Act and Assert
    assertNotEquals(tbQueueTransportNotificationSettings, tbQueueTransportNotificationSettings2);
  }

  /**
   * Method under test:
   * {@link TbQueueTransportNotificationSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueTransportNotificationSettings(), null);
  }

  /**
   * Method under test:
   * {@link TbQueueTransportNotificationSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueTransportNotificationSettings(),
        "Different type to TbQueueTransportNotificationSettings");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbQueueTransportNotificationSettings#setNotificationsTopic(String)}
   *   <li>
   * {@link TbQueueTransportNotificationSettings#setTransportPollInterval(long)}
   *   <li>{@link TbQueueTransportNotificationSettings#toString()}
   *   <li>{@link TbQueueTransportNotificationSettings#getNotificationsTopic()}
   *   <li>{@link TbQueueTransportNotificationSettings#getTransportPollInterval()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbQueueTransportNotificationSettings tbQueueTransportNotificationSettings = new TbQueueTransportNotificationSettings();

    // Act
    tbQueueTransportNotificationSettings.setNotificationsTopic("Notifications Topic");
    tbQueueTransportNotificationSettings.setTransportPollInterval(42L);
    String actualToStringResult = tbQueueTransportNotificationSettings.toString();
    String actualNotificationsTopic = tbQueueTransportNotificationSettings.getNotificationsTopic();

    // Assert that nothing has changed
    assertEquals("Notifications Topic", actualNotificationsTopic);
    assertEquals(
        "TbQueueTransportNotificationSettings(notificationsTopic=Notifications Topic, transportPollInterval" + "=42)",
        actualToStringResult);
    assertEquals(42L, tbQueueTransportNotificationSettings.getTransportPollInterval());
  }
}
