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
import org.thingsboard.server.common.data.alarm.AlarmSeverity;

class PersistedAlarmStateDiffblueTest {
  /**
   * Test {@link PersistedAlarmState#equals(Object)}, and {@link PersistedAlarmState#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PersistedAlarmState#equals(Object)}
   *   <li>{@link PersistedAlarmState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedAlarmState.equals(Object)",
    "int PersistedAlarmState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PersistedAlarmState persistedAlarmState = new PersistedAlarmState();
    persistedAlarmState.setClearRuleState(new PersistedAlarmRuleState(1L, 1L, 3L));
    persistedAlarmState.setCreateRuleStates(new HashMap<>());

    PersistedAlarmState persistedAlarmState2 = new PersistedAlarmState();
    persistedAlarmState2.setClearRuleState(new PersistedAlarmRuleState(1L, 1L, 3L));
    persistedAlarmState2.setCreateRuleStates(new HashMap<>());

    // Act and Assert
    assertEquals(persistedAlarmState, persistedAlarmState2);
    assertEquals(persistedAlarmState.hashCode(), persistedAlarmState2.hashCode());
  }

  /**
   * Test {@link PersistedAlarmState#equals(Object)}, and {@link PersistedAlarmState#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PersistedAlarmState#equals(Object)}
   *   <li>{@link PersistedAlarmState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedAlarmState.equals(Object)",
    "int PersistedAlarmState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PersistedAlarmState persistedAlarmState = new PersistedAlarmState();
    persistedAlarmState.setClearRuleState(null);
    persistedAlarmState.setCreateRuleStates(new HashMap<>());

    PersistedAlarmState persistedAlarmState2 = new PersistedAlarmState();
    persistedAlarmState2.setClearRuleState(null);
    persistedAlarmState2.setCreateRuleStates(new HashMap<>());

    // Act and Assert
    assertEquals(persistedAlarmState, persistedAlarmState2);
    assertEquals(persistedAlarmState.hashCode(), persistedAlarmState2.hashCode());
  }

  /**
   * Test {@link PersistedAlarmState#equals(Object)}, and {@link PersistedAlarmState#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PersistedAlarmState#equals(Object)}
   *   <li>{@link PersistedAlarmState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedAlarmState.equals(Object)",
    "int PersistedAlarmState.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PersistedAlarmState persistedAlarmState = new PersistedAlarmState();
    persistedAlarmState.setClearRuleState(new PersistedAlarmRuleState(1L, 1L, 3L));
    persistedAlarmState.setCreateRuleStates(new HashMap<>());

    // Act and Assert
    assertEquals(persistedAlarmState, persistedAlarmState);
    int expectedHashCodeResult = persistedAlarmState.hashCode();
    assertEquals(expectedHashCodeResult, persistedAlarmState.hashCode());
  }

  /**
   * Test {@link PersistedAlarmState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistedAlarmState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedAlarmState.equals(Object)",
    "int PersistedAlarmState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PersistedAlarmState persistedAlarmState = new PersistedAlarmState();
    persistedAlarmState.setClearRuleState(new PersistedAlarmRuleState(3L, 1L, 3L));
    persistedAlarmState.setCreateRuleStates(new HashMap<>());

    PersistedAlarmState persistedAlarmState2 = new PersistedAlarmState();
    persistedAlarmState2.setClearRuleState(new PersistedAlarmRuleState(1L, 1L, 3L));
    persistedAlarmState2.setCreateRuleStates(new HashMap<>());

    // Act and Assert
    assertNotEquals(persistedAlarmState, persistedAlarmState2);
  }

  /**
   * Test {@link PersistedAlarmState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistedAlarmState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedAlarmState.equals(Object)",
    "int PersistedAlarmState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PersistedAlarmState persistedAlarmState = new PersistedAlarmState();
    persistedAlarmState.setClearRuleState(null);
    persistedAlarmState.setCreateRuleStates(new HashMap<>());

    PersistedAlarmState persistedAlarmState2 = new PersistedAlarmState();
    persistedAlarmState2.setClearRuleState(new PersistedAlarmRuleState(1L, 1L, 3L));
    persistedAlarmState2.setCreateRuleStates(new HashMap<>());

    // Act and Assert
    assertNotEquals(persistedAlarmState, persistedAlarmState2);
  }

  /**
   * Test {@link PersistedAlarmState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistedAlarmState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedAlarmState.equals(Object)",
    "int PersistedAlarmState.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashMap<AlarmSeverity, PersistedAlarmRuleState> createRuleStates = new HashMap<>();
    createRuleStates.put(AlarmSeverity.CRITICAL, new PersistedAlarmRuleState(1L, 1L, 3L));

    PersistedAlarmState persistedAlarmState = new PersistedAlarmState();
    persistedAlarmState.setClearRuleState(new PersistedAlarmRuleState(1L, 1L, 3L));
    persistedAlarmState.setCreateRuleStates(createRuleStates);

    PersistedAlarmState persistedAlarmState2 = new PersistedAlarmState();
    persistedAlarmState2.setClearRuleState(new PersistedAlarmRuleState(1L, 1L, 3L));
    persistedAlarmState2.setCreateRuleStates(new HashMap<>());

    // Act and Assert
    assertNotEquals(persistedAlarmState, persistedAlarmState2);
  }

  /**
   * Test {@link PersistedAlarmState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistedAlarmState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedAlarmState.equals(Object)",
    "int PersistedAlarmState.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PersistedAlarmState persistedAlarmState = new PersistedAlarmState();
    persistedAlarmState.setClearRuleState(new PersistedAlarmRuleState(1L, 1L, 3L));
    persistedAlarmState.setCreateRuleStates(new HashMap<>());

    // Act and Assert
    assertNotEquals(persistedAlarmState, null);
  }

  /**
   * Test {@link PersistedAlarmState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PersistedAlarmState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PersistedAlarmState.equals(Object)",
    "int PersistedAlarmState.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PersistedAlarmState persistedAlarmState = new PersistedAlarmState();
    persistedAlarmState.setClearRuleState(new PersistedAlarmRuleState(1L, 1L, 3L));
    persistedAlarmState.setCreateRuleStates(new HashMap<>());

    // Act and Assert
    assertNotEquals(persistedAlarmState, "Different type to PersistedAlarmState");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link PersistedAlarmState}
   *   <li>{@link PersistedAlarmState#setClearRuleState(PersistedAlarmRuleState)}
   *   <li>{@link PersistedAlarmState#setCreateRuleStates(Map)}
   *   <li>{@link PersistedAlarmState#toString()}
   *   <li>{@link PersistedAlarmState#getClearRuleState()}
   *   <li>{@link PersistedAlarmState#getCreateRuleStates()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PersistedAlarmState.<init>()",
    "PersistedAlarmRuleState PersistedAlarmState.getClearRuleState()",
    "Map PersistedAlarmState.getCreateRuleStates()",
    "void PersistedAlarmState.setClearRuleState(PersistedAlarmRuleState)",
    "void PersistedAlarmState.setCreateRuleStates(Map)",
    "String PersistedAlarmState.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    PersistedAlarmState actualPersistedAlarmState = new PersistedAlarmState();
    PersistedAlarmRuleState clearRuleState = new PersistedAlarmRuleState(1L, 1L, 3L);
    actualPersistedAlarmState.setClearRuleState(clearRuleState);
    HashMap<AlarmSeverity, PersistedAlarmRuleState> createRuleStates = new HashMap<>();
    actualPersistedAlarmState.setCreateRuleStates(createRuleStates);
    String actualToStringResult = actualPersistedAlarmState.toString();
    PersistedAlarmRuleState actualClearRuleState = actualPersistedAlarmState.getClearRuleState();
    Map<AlarmSeverity, PersistedAlarmRuleState> actualCreateRuleStates =
        actualPersistedAlarmState.getCreateRuleStates();

    // Assert
    assertEquals(
        "PersistedAlarmState(createRuleStates={}, clearRuleState=PersistedAlarmRuleState(lastEventTs=1, duration=1,"
            + " eventCount=3))",
        actualToStringResult);
    assertTrue(actualCreateRuleStates.isEmpty());
    assertSame(createRuleStates, actualCreateRuleStates);
    assertSame(clearRuleState, actualClearRuleState);
  }
}
