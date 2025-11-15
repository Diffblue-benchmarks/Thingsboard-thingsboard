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
package org.thingsboard.server.common.data.security.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class UserSessionInvalidationEventDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserSessionInvalidationEvent#equals(Object)}
   *   <li>{@link UserSessionInvalidationEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserSessionInvalidationEvent userSessionInvalidationEvent = new UserSessionInvalidationEvent("42");

    // Act and Assert
    assertEquals(userSessionInvalidationEvent, userSessionInvalidationEvent);
    int expectedHashCodeResult = userSessionInvalidationEvent.hashCode();
    assertEquals(expectedHashCodeResult, userSessionInvalidationEvent.hashCode());
  }

  /**
   * Method under test: {@link UserSessionInvalidationEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserSessionInvalidationEvent userSessionInvalidationEvent = new UserSessionInvalidationEvent("42");

    // Act and Assert
    assertNotEquals(userSessionInvalidationEvent, new UserSessionInvalidationEvent("42"));
  }

  /**
   * Method under test: {@link UserSessionInvalidationEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserSessionInvalidationEvent("42"), null);
  }

  /**
   * Method under test: {@link UserSessionInvalidationEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserSessionInvalidationEvent("42"), "Different type to UserSessionInvalidationEvent");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserSessionInvalidationEvent#getId()}
   *   <li>{@link UserSessionInvalidationEvent#getTs()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    UserSessionInvalidationEvent userSessionInvalidationEvent = new UserSessionInvalidationEvent("42");

    // Act
    String actualId = userSessionInvalidationEvent.getId();
    userSessionInvalidationEvent.getTs();

    // Assert
    assertEquals("42", actualId);
  }

  /**
   * Method under test:
   * {@link UserSessionInvalidationEvent#UserSessionInvalidationEvent(String)}
   */
  @Test
  void testNewUserSessionInvalidationEvent() {
    // Arrange, Act and Assert
    assertEquals("42", (new UserSessionInvalidationEvent("42")).getId());
  }
}
