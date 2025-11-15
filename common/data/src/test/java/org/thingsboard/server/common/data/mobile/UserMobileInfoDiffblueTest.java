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
package org.thingsboard.server.common.data.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class UserMobileInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserMobileInfo#equals(Object)}
   *   <li>{@link UserMobileInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserMobileInfo userMobileInfo = new UserMobileInfo();
    userMobileInfo.setSessions(new HashMap<>());

    UserMobileInfo userMobileInfo2 = new UserMobileInfo();
    userMobileInfo2.setSessions(new HashMap<>());

    // Act and Assert
    assertEquals(userMobileInfo, userMobileInfo2);
    int expectedHashCodeResult = userMobileInfo.hashCode();
    assertEquals(expectedHashCodeResult, userMobileInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserMobileInfo#equals(Object)}
   *   <li>{@link UserMobileInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserMobileInfo userMobileInfo = new UserMobileInfo();
    userMobileInfo.setSessions(new HashMap<>());

    // Act and Assert
    assertEquals(userMobileInfo, userMobileInfo);
    int expectedHashCodeResult = userMobileInfo.hashCode();
    assertEquals(expectedHashCodeResult, userMobileInfo.hashCode());
  }

  /**
   * Method under test: {@link UserMobileInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileSessionInfo mobileSessionInfo = new MobileSessionInfo();
    mobileSessionInfo.setFcmTokenTimestamp(1L);

    HashMap<String, MobileSessionInfo> sessions = new HashMap<>();
    sessions.put("foo", mobileSessionInfo);

    UserMobileInfo userMobileInfo = new UserMobileInfo();
    userMobileInfo.setSessions(sessions);

    UserMobileInfo userMobileInfo2 = new UserMobileInfo();
    userMobileInfo2.setSessions(new HashMap<>());

    // Act and Assert
    assertNotEquals(userMobileInfo, userMobileInfo2);
  }

  /**
   * Method under test: {@link UserMobileInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileSessionInfo mobileSessionInfo = new MobileSessionInfo();
    mobileSessionInfo.setFcmTokenTimestamp(1L);

    HashMap<String, MobileSessionInfo> sessions = new HashMap<>();
    sessions.computeIfPresent("foo", mock(BiFunction.class));
    sessions.put("foo", mobileSessionInfo);

    UserMobileInfo userMobileInfo = new UserMobileInfo();
    userMobileInfo.setSessions(sessions);

    UserMobileInfo userMobileInfo2 = new UserMobileInfo();
    userMobileInfo2.setSessions(new HashMap<>());

    // Act and Assert
    assertNotEquals(userMobileInfo, userMobileInfo2);
  }

  /**
   * Method under test: {@link UserMobileInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UserMobileInfo userMobileInfo = new UserMobileInfo();
    userMobileInfo.setSessions(new HashMap<>());

    // Act and Assert
    assertNotEquals(userMobileInfo, null);
  }

  /**
   * Method under test: {@link UserMobileInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UserMobileInfo userMobileInfo = new UserMobileInfo();
    userMobileInfo.setSessions(new HashMap<>());

    // Act and Assert
    assertNotEquals(userMobileInfo, "Different type to UserMobileInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UserMobileInfo}
   *   <li>{@link UserMobileInfo#setSessions(Map)}
   *   <li>{@link UserMobileInfo#toString()}
   *   <li>{@link UserMobileInfo#getSessions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    UserMobileInfo actualUserMobileInfo = new UserMobileInfo();
    HashMap<String, MobileSessionInfo> sessions = new HashMap<>();
    actualUserMobileInfo.setSessions(sessions);
    String actualToStringResult = actualUserMobileInfo.toString();
    Map<String, MobileSessionInfo> actualSessions = actualUserMobileInfo.getSessions();

    // Assert that nothing has changed
    assertEquals("UserMobileInfo(sessions={})", actualToStringResult);
    assertTrue(actualSessions.isEmpty());
    assertSame(sessions, actualSessions);
  }
}
