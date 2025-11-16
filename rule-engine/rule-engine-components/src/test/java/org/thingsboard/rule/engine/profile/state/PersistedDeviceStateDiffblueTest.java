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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PersistedDeviceStateDiffblueTest {
  /**
   * Test {@link PersistedDeviceState#equals(Object)}, and {@link PersistedDeviceState#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PersistedDeviceState#equals(Object)}
   *   <li>{@link PersistedDeviceState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedDeviceState.equals(Object)",
    "int PersistedDeviceState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PersistedDeviceState persistedDeviceState = new PersistedDeviceState();
    persistedDeviceState.setAlarmStates(new HashMap<>());

    PersistedDeviceState persistedDeviceState2 = new PersistedDeviceState();
    persistedDeviceState2.setAlarmStates(new HashMap<>());

    // Act and Assert
    assertEquals(persistedDeviceState, persistedDeviceState2);
    assertEquals(persistedDeviceState.hashCode(), persistedDeviceState2.hashCode());
  }

  /**
   * Test {@link PersistedDeviceState#equals(Object)}, and {@link PersistedDeviceState#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PersistedDeviceState#equals(Object)}
   *   <li>{@link PersistedDeviceState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedDeviceState.equals(Object)",
    "int PersistedDeviceState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PersistedDeviceState persistedDeviceState = new PersistedDeviceState();
    persistedDeviceState.setAlarmStates(new HashMap<>());

    // Act and Assert
    assertEquals(persistedDeviceState, persistedDeviceState);
    int expectedHashCodeResult = persistedDeviceState.hashCode();
    assertEquals(expectedHashCodeResult, persistedDeviceState.hashCode());
  }

  /**
   * Test {@link PersistedDeviceState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistedDeviceState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedDeviceState.equals(Object)",
    "int PersistedDeviceState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PersistedAlarmState persistedAlarmState = new PersistedAlarmState();
    persistedAlarmState.setClearRuleState(new PersistedAlarmRuleState(1L, 1L, 3L));
    persistedAlarmState.setCreateRuleStates(new HashMap<>());

    HashMap<String, PersistedAlarmState> alarmStates = new HashMap<>();
    alarmStates.put("Key", persistedAlarmState);

    PersistedDeviceState persistedDeviceState = new PersistedDeviceState();
    persistedDeviceState.setAlarmStates(alarmStates);

    PersistedDeviceState persistedDeviceState2 = new PersistedDeviceState();
    persistedDeviceState2.setAlarmStates(new HashMap<>());

    // Act and Assert
    assertNotEquals(persistedDeviceState, persistedDeviceState2);
  }

  /**
   * Test {@link PersistedDeviceState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistedDeviceState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedDeviceState.equals(Object)",
    "int PersistedDeviceState.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PersistedDeviceState persistedDeviceState = new PersistedDeviceState();
    persistedDeviceState.setAlarmStates(new HashMap<>());

    // Act and Assert
    assertNotEquals(persistedDeviceState, null);
  }

  /**
   * Test {@link PersistedDeviceState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistedDeviceState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedDeviceState.equals(Object)",
    "int PersistedDeviceState.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PersistedDeviceState persistedDeviceState = new PersistedDeviceState();
    persistedDeviceState.setAlarmStates(new HashMap<>());

    // Act and Assert
    assertNotEquals(persistedDeviceState, "Different type to PersistedDeviceState");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PersistedDeviceState}
   *   <li>{@link PersistedDeviceState#setAlarmStates(Map)}
   *   <li>{@link PersistedDeviceState#toString()}
   *   <li>{@link PersistedDeviceState#getAlarmStates()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PersistedDeviceState.<init>()",
    "Map PersistedDeviceState.getAlarmStates()",
    "void PersistedDeviceState.setAlarmStates(Map)",
    "String PersistedDeviceState.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    PersistedDeviceState actualPersistedDeviceState = new PersistedDeviceState();
    HashMap<String, PersistedAlarmState> alarmStates = new HashMap<>();
    actualPersistedDeviceState.setAlarmStates(alarmStates);
    String actualToStringResult = actualPersistedDeviceState.toString();
    Map<String, PersistedAlarmState> actualAlarmStates =
        actualPersistedDeviceState.getAlarmStates();

    // Assert
    assertEquals("PersistedDeviceState(alarmStates={})", actualToStringResult);
    assertTrue(actualAlarmStates.isEmpty());
    assertSame(alarmStates, actualAlarmStates);
  }
}
