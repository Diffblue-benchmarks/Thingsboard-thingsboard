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
package org.thingsboard.rule.engine.profile.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PersistedAlarmRuleStateDiffblueTest {
  /**
   * Test {@link PersistedAlarmRuleState#equals(Object)}, and {@link
   * PersistedAlarmRuleState#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PersistedAlarmRuleState#equals(Object)}
   *   <li>{@link PersistedAlarmRuleState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedAlarmRuleState.equals(Object)",
    "int PersistedAlarmRuleState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PersistedAlarmRuleState persistedAlarmRuleState = new PersistedAlarmRuleState(1L, 1L, 3L);
    PersistedAlarmRuleState persistedAlarmRuleState2 = new PersistedAlarmRuleState(1L, 1L, 3L);

    // Act and Assert
    assertEquals(persistedAlarmRuleState, persistedAlarmRuleState2);
    assertEquals(persistedAlarmRuleState.hashCode(), persistedAlarmRuleState2.hashCode());
  }

  /**
   * Test {@link PersistedAlarmRuleState#equals(Object)}, and {@link
   * PersistedAlarmRuleState#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PersistedAlarmRuleState#equals(Object)}
   *   <li>{@link PersistedAlarmRuleState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedAlarmRuleState.equals(Object)",
    "int PersistedAlarmRuleState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PersistedAlarmRuleState persistedAlarmRuleState = new PersistedAlarmRuleState(1L, 1L, 3L);

    // Act and Assert
    assertEquals(persistedAlarmRuleState, persistedAlarmRuleState);
    int expectedHashCodeResult = persistedAlarmRuleState.hashCode();
    assertEquals(expectedHashCodeResult, persistedAlarmRuleState.hashCode());
  }

  /**
   * Test {@link PersistedAlarmRuleState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistedAlarmRuleState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedAlarmRuleState.equals(Object)",
    "int PersistedAlarmRuleState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PersistedAlarmRuleState persistedAlarmRuleState = new PersistedAlarmRuleState(3L, 1L, 3L);

    // Act and Assert
    assertNotEquals(persistedAlarmRuleState, new PersistedAlarmRuleState(1L, 1L, 3L));
  }

  /**
   * Test {@link PersistedAlarmRuleState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistedAlarmRuleState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedAlarmRuleState.equals(Object)",
    "int PersistedAlarmRuleState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PersistedAlarmRuleState persistedAlarmRuleState = new PersistedAlarmRuleState(1L, 3L, 3L);

    // Act and Assert
    assertNotEquals(persistedAlarmRuleState, new PersistedAlarmRuleState(1L, 1L, 3L));
  }

  /**
   * Test {@link PersistedAlarmRuleState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistedAlarmRuleState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedAlarmRuleState.equals(Object)",
    "int PersistedAlarmRuleState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PersistedAlarmRuleState persistedAlarmRuleState = new PersistedAlarmRuleState(1L, 1L, 1L);

    // Act and Assert
    assertNotEquals(persistedAlarmRuleState, new PersistedAlarmRuleState(1L, 1L, 3L));
  }

  /**
   * Test {@link PersistedAlarmRuleState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistedAlarmRuleState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedAlarmRuleState.equals(Object)",
    "int PersistedAlarmRuleState.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PersistedAlarmRuleState(1L, 1L, 3L), null);
  }

  /**
   * Test {@link PersistedAlarmRuleState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistedAlarmRuleState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedAlarmRuleState.equals(Object)",
    "int PersistedAlarmRuleState.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new PersistedAlarmRuleState(1L, 1L, 3L), "Different type to PersistedAlarmRuleState");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PersistedAlarmRuleState#PersistedAlarmRuleState()}
   *   <li>{@link PersistedAlarmRuleState#setDuration(long)}
   *   <li>{@link PersistedAlarmRuleState#setEventCount(long)}
   *   <li>{@link PersistedAlarmRuleState#setLastEventTs(long)}
   *   <li>{@link PersistedAlarmRuleState#toString()}
   *   <li>{@link PersistedAlarmRuleState#getDuration()}
   *   <li>{@link PersistedAlarmRuleState#getEventCount()}
   *   <li>{@link PersistedAlarmRuleState#getLastEventTs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PersistedAlarmRuleState.<init>()",
    "long PersistedAlarmRuleState.getDuration()",
    "long PersistedAlarmRuleState.getEventCount()",
    "long PersistedAlarmRuleState.getLastEventTs()",
    "void PersistedAlarmRuleState.setDuration(long)",
    "void PersistedAlarmRuleState.setEventCount(long)",
    "void PersistedAlarmRuleState.setLastEventTs(long)",
    "String PersistedAlarmRuleState.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    PersistedAlarmRuleState actualPersistedAlarmRuleState = new PersistedAlarmRuleState();
    actualPersistedAlarmRuleState.setDuration(1L);
    actualPersistedAlarmRuleState.setEventCount(3L);
    actualPersistedAlarmRuleState.setLastEventTs(1L);
    String actualToStringResult = actualPersistedAlarmRuleState.toString();
    long actualDuration = actualPersistedAlarmRuleState.getDuration();
    long actualEventCount = actualPersistedAlarmRuleState.getEventCount();

    // Assert
    assertEquals(
        "PersistedAlarmRuleState(lastEventTs=1, duration=1, eventCount=3)", actualToStringResult);
    assertEquals(1L, actualDuration);
    assertEquals(1L, actualPersistedAlarmRuleState.getLastEventTs());
    assertEquals(3L, actualEventCount);
  }

  /**
   * Test {@link PersistedAlarmRuleState#PersistedAlarmRuleState(long, long, long)}.
   *
   * <p>Method under test: {@link PersistedAlarmRuleState#PersistedAlarmRuleState(long, long, long)}
   */
  @Test
  @DisplayName("Test new PersistedAlarmRuleState(long, long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PersistedAlarmRuleState.<init>(long, long, long)"})
  void testNewPersistedAlarmRuleState() {
    // Arrange and Act
    PersistedAlarmRuleState actualPersistedAlarmRuleState = new PersistedAlarmRuleState(1L, 1L, 3L);

    // Assert
    assertEquals(1L, actualPersistedAlarmRuleState.getDuration());
    assertEquals(1L, actualPersistedAlarmRuleState.getLastEventTs());
    assertEquals(3L, actualPersistedAlarmRuleState.getEventCount());
  }
}
