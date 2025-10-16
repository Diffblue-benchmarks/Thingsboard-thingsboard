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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserSessionInvalidationEventDiffblueTest {
  /**
   * Test {@link UserSessionInvalidationEvent#UserSessionInvalidationEvent(String)}.
   *
   * <p>Method under test: {@link UserSessionInvalidationEvent#UserSessionInvalidationEvent(String)}
   */
  @Test
  @DisplayName("Test new UserSessionInvalidationEvent(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserSessionInvalidationEvent.<init>(String)"})
  void testNewUserSessionInvalidationEvent() {
    // Arrange, Act and Assert
    assertEquals("42", new UserSessionInvalidationEvent("42").getId());
  }

  /**
   * Test {@link UserSessionInvalidationEvent#equals(Object)}, and {@link
   * UserSessionInvalidationEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSessionInvalidationEvent#equals(Object)}
   *   <li>{@link UserSessionInvalidationEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSessionInvalidationEvent.equals(Object)",
    "int UserSessionInvalidationEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserSessionInvalidationEvent userSessionInvalidationEvent =
        new UserSessionInvalidationEvent("42");

    // Act and Assert
    assertEquals(userSessionInvalidationEvent, userSessionInvalidationEvent);
    int expectedHashCodeResult = userSessionInvalidationEvent.hashCode();
    assertEquals(expectedHashCodeResult, userSessionInvalidationEvent.hashCode());
  }

  /**
   * Test {@link UserSessionInvalidationEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSessionInvalidationEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSessionInvalidationEvent.equals(Object)",
    "int UserSessionInvalidationEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserSessionInvalidationEvent userSessionInvalidationEvent =
        new UserSessionInvalidationEvent("42");

    // Act and Assert
    assertNotEquals(userSessionInvalidationEvent, new UserSessionInvalidationEvent("42"));
  }

  /**
   * Test {@link UserSessionInvalidationEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSessionInvalidationEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSessionInvalidationEvent.equals(Object)",
    "int UserSessionInvalidationEvent.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserSessionInvalidationEvent("42"), null);
  }

  /**
   * Test {@link UserSessionInvalidationEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSessionInvalidationEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSessionInvalidationEvent.equals(Object)",
    "int UserSessionInvalidationEvent.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new UserSessionInvalidationEvent("42"), "Different type to UserSessionInvalidationEvent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSessionInvalidationEvent#getId()}
   *   <li>{@link UserSessionInvalidationEvent#getTs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String UserSessionInvalidationEvent.getId()",
    "long UserSessionInvalidationEvent.getTs()"
  })
  void testGettersAndSetters() {
    // Arrange
    UserSessionInvalidationEvent userSessionInvalidationEvent =
        new UserSessionInvalidationEvent("42");

    // Act
    String actualId = userSessionInvalidationEvent.getId();
    userSessionInvalidationEvent.getTs();

    // Assert
    assertEquals("42", actualId);
  }
}
