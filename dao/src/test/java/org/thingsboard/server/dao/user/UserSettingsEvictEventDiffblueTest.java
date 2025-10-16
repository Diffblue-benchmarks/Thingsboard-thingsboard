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
package org.thingsboard.server.dao.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.settings.UserSettingsCompositeKey;
import org.thingsboard.server.dao.model.ModelConstants;

public class UserSettingsEvictEventDiffblueTest {
  /**
   * Test {@link UserSettingsEvictEvent#equals(Object)}, and {@link
   * UserSettingsEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSettingsEvictEvent#equals(Object)}
   *   <li>{@link UserSettingsEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEvictEvent.equals(Object)",
    "int UserSettingsEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserSettingsEvictEvent userSettingsEvictEvent =
        new UserSettingsEvictEvent(new UserSettingsCompositeKey());
    UserSettingsEvictEvent userSettingsEvictEvent2 =
        new UserSettingsEvictEvent(new UserSettingsCompositeKey());

    // Act and Assert
    assertEquals(userSettingsEvictEvent, userSettingsEvictEvent2);
    assertEquals(userSettingsEvictEvent.hashCode(), userSettingsEvictEvent2.hashCode());
  }

  /**
   * Test {@link UserSettingsEvictEvent#equals(Object)}, and {@link
   * UserSettingsEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSettingsEvictEvent#equals(Object)}
   *   <li>{@link UserSettingsEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEvictEvent.equals(Object)",
    "int UserSettingsEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserSettingsEvictEvent userSettingsEvictEvent = new UserSettingsEvictEvent(null);
    UserSettingsEvictEvent userSettingsEvictEvent2 = new UserSettingsEvictEvent(null);

    // Act and Assert
    assertEquals(userSettingsEvictEvent, userSettingsEvictEvent2);
    assertEquals(userSettingsEvictEvent.hashCode(), userSettingsEvictEvent2.hashCode());
  }

  /**
   * Test {@link UserSettingsEvictEvent#equals(Object)}, and {@link
   * UserSettingsEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSettingsEvictEvent#equals(Object)}
   *   <li>{@link UserSettingsEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEvictEvent.equals(Object)",
    "int UserSettingsEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserSettingsEvictEvent userSettingsEvictEvent =
        new UserSettingsEvictEvent(new UserSettingsCompositeKey());

    // Act and Assert
    assertEquals(userSettingsEvictEvent, userSettingsEvictEvent);
    int expectedHashCodeResult = userSettingsEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsEvictEvent.hashCode());
  }

  /**
   * Test {@link UserSettingsEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEvictEvent.equals(Object)",
    "int UserSettingsEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserSettingsEvictEvent userSettingsEvictEvent = new UserSettingsEvictEvent(null);

    // Act and Assert
    assertNotEquals(
        userSettingsEvictEvent, new UserSettingsEvictEvent(new UserSettingsCompositeKey()));
  }

  /**
   * Test {@link UserSettingsEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEvictEvent.equals(Object)",
    "int UserSettingsEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserSettingsEvictEvent userSettingsEvictEvent =
        new UserSettingsEvictEvent(new UserSettingsCompositeKey(ModelConstants.NULL_UUID, "Type"));

    // Act and Assert
    assertNotEquals(
        userSettingsEvictEvent, new UserSettingsEvictEvent(new UserSettingsCompositeKey()));
  }

  /**
   * Test {@link UserSettingsEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEvictEvent.equals(Object)",
    "int UserSettingsEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserSettingsEvictEvent(new UserSettingsCompositeKey()), null);
  }

  /**
   * Test {@link UserSettingsEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsEvictEvent#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEvictEvent.equals(Object)",
    "int UserSettingsEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new UserSettingsEvictEvent(new UserSettingsCompositeKey()),
        "Different type to UserSettingsEvictEvent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSettingsEvictEvent#UserSettingsEvictEvent(UserSettingsCompositeKey)}
   *   <li>{@link UserSettingsEvictEvent#getKey()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserSettingsEvictEvent.<init>(UserSettingsCompositeKey)",
    "UserSettingsCompositeKey UserSettingsEvictEvent.getKey()",
    "java.lang.String UserSettingsEvictEvent.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    UserSettingsCompositeKey key = new UserSettingsCompositeKey();

    // Act and Assert
    assertSame(key, new UserSettingsEvictEvent(key).getKey());
  }
}
