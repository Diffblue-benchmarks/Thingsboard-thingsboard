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
package org.thingsboard.server.common.data.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.UserId;

class UserSettingsCompositeKeyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserSettingsCompositeKey#equals(Object)}
   *   <li>{@link UserSettingsCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey();
    UserSettingsCompositeKey userSettingsCompositeKey2 = new UserSettingsCompositeKey();

    // Act and Assert
    assertEquals(userSettingsCompositeKey, userSettingsCompositeKey2);
    int expectedHashCodeResult = userSettingsCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsCompositeKey2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserSettingsCompositeKey#equals(Object)}
   *   <li>{@link UserSettingsCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey(EntityId.NULL_UUID, "Type");
    UserSettingsCompositeKey userSettingsCompositeKey2 = new UserSettingsCompositeKey(EntityId.NULL_UUID, "Type");

    // Act and Assert
    assertEquals(userSettingsCompositeKey, userSettingsCompositeKey2);
    int expectedHashCodeResult = userSettingsCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsCompositeKey2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserSettingsCompositeKey#equals(Object)}
   *   <li>{@link UserSettingsCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey();

    // Act and Assert
    assertEquals(userSettingsCompositeKey, userSettingsCompositeKey);
    int expectedHashCodeResult = userSettingsCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsCompositeKey.hashCode());
  }

  /**
   * Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey(EntityId.NULL_UUID, "Type");

    // Act and Assert
    assertNotEquals(userSettingsCompositeKey, new UserSettingsCompositeKey());
  }

  /**
   * Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey();

    // Act and Assert
    assertNotEquals(userSettingsCompositeKey, new UserSettingsCompositeKey(EntityId.NULL_UUID, "Type"));
  }

  /**
   * Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey();
    userSettingsCompositeKey.setType("Type");

    // Act and Assert
    assertNotEquals(userSettingsCompositeKey, new UserSettingsCompositeKey());
  }

  /**
   * Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey();

    UserSettingsCompositeKey userSettingsCompositeKey2 = new UserSettingsCompositeKey();
    userSettingsCompositeKey2.setType("Type");

    // Act and Assert
    assertNotEquals(userSettingsCompositeKey, userSettingsCompositeKey2);
  }

  /**
   * Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getType()).thenReturn(UserSettingsType.GENERAL);
    when(userSettings.getUserId()).thenReturn(new UserId(EntityId.NULL_UUID));
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey(userSettings);

    // Act and Assert
    assertNotEquals(userSettingsCompositeKey, new UserSettingsCompositeKey());
  }

  /**
   * Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserSettingsCompositeKey(), null);
  }

  /**
   * Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserSettingsCompositeKey(), "Different type to UserSettingsCompositeKey");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserSettingsCompositeKey#UserSettingsCompositeKey()}
   *   <li>{@link UserSettingsCompositeKey#setType(String)}
   *   <li>{@link UserSettingsCompositeKey#setUserId(UUID)}
   *   <li>{@link UserSettingsCompositeKey#toString()}
   *   <li>{@link UserSettingsCompositeKey#getType()}
   *   <li>{@link UserSettingsCompositeKey#getUserId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    UserSettingsCompositeKey actualUserSettingsCompositeKey = new UserSettingsCompositeKey();
    actualUserSettingsCompositeKey.setType("Type");
    UUID userId = EntityId.NULL_UUID;
    actualUserSettingsCompositeKey.setUserId(userId);
    String actualToStringResult = actualUserSettingsCompositeKey.toString();
    String actualType = actualUserSettingsCompositeKey.getType();
    UUID actualUserId = actualUserSettingsCompositeKey.getUserId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualUserId.toString());
    assertEquals("13814000-1dd2-11b2-8080-808080808080_Type", actualToStringResult);
    assertEquals("Type", actualType);
    assertSame(userId, actualUserId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserSettingsCompositeKey#UserSettingsCompositeKey(UUID, String)}
   *   <li>{@link UserSettingsCompositeKey#setType(String)}
   *   <li>{@link UserSettingsCompositeKey#setUserId(UUID)}
   *   <li>{@link UserSettingsCompositeKey#toString()}
   *   <li>{@link UserSettingsCompositeKey#getType()}
   *   <li>{@link UserSettingsCompositeKey#getUserId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    UserSettingsCompositeKey actualUserSettingsCompositeKey = new UserSettingsCompositeKey(EntityId.NULL_UUID, "Type");
    actualUserSettingsCompositeKey.setType("Type");
    UUID userId = EntityId.NULL_UUID;
    actualUserSettingsCompositeKey.setUserId(userId);
    String actualToStringResult = actualUserSettingsCompositeKey.toString();
    String actualType = actualUserSettingsCompositeKey.getType();
    UUID actualUserId = actualUserSettingsCompositeKey.getUserId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualUserId.toString());
    assertEquals("13814000-1dd2-11b2-8080-808080808080_Type", actualToStringResult);
    assertEquals("Type", actualType);
    assertSame(userId, actualUserId);
  }

  /**
   * Method under test:
   * {@link UserSettingsCompositeKey#UserSettingsCompositeKey(UserSettings)}
   */
  @Test
  void testNewUserSettingsCompositeKey() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(new UserId(EntityId.NULL_UUID));

    // Act
    UserSettingsCompositeKey actualUserSettingsCompositeKey = new UserSettingsCompositeKey(userSettings);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualUserSettingsCompositeKey.getUserId().toString());
    assertEquals("GENERAL", actualUserSettingsCompositeKey.getType());
  }
}
