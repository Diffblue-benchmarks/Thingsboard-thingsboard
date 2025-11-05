package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AlarmConditionFilterKeyDiffblueTest {
  /**
   * Test {@link AlarmConditionFilterKey#equals(Object)}, and {@link
   * AlarmConditionFilterKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmConditionFilterKey#equals(Object)}
   *   <li>{@link AlarmConditionFilterKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilterKey.equals(Object)",
    "int AlarmConditionFilterKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmConditionFilterKey alarmConditionFilterKey =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");
    AlarmConditionFilterKey alarmConditionFilterKey2 =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertEquals(alarmConditionFilterKey, alarmConditionFilterKey2);
    assertEquals(alarmConditionFilterKey.hashCode(), alarmConditionFilterKey2.hashCode());
  }

  /**
   * Test {@link AlarmConditionFilterKey#equals(Object)}, and {@link
   * AlarmConditionFilterKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmConditionFilterKey#equals(Object)}
   *   <li>{@link AlarmConditionFilterKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilterKey.equals(Object)",
    "int AlarmConditionFilterKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmConditionFilterKey alarmConditionFilterKey = new AlarmConditionFilterKey(null, "Key");
    AlarmConditionFilterKey alarmConditionFilterKey2 = new AlarmConditionFilterKey(null, "Key");

    // Act and Assert
    assertEquals(alarmConditionFilterKey, alarmConditionFilterKey2);
    assertEquals(alarmConditionFilterKey.hashCode(), alarmConditionFilterKey2.hashCode());
  }

  /**
   * Test {@link AlarmConditionFilterKey#equals(Object)}, and {@link
   * AlarmConditionFilterKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmConditionFilterKey#equals(Object)}
   *   <li>{@link AlarmConditionFilterKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilterKey.equals(Object)",
    "int AlarmConditionFilterKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AlarmConditionFilterKey alarmConditionFilterKey =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, null);
    AlarmConditionFilterKey alarmConditionFilterKey2 =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, null);

    // Act and Assert
    assertEquals(alarmConditionFilterKey, alarmConditionFilterKey2);
    assertEquals(alarmConditionFilterKey.hashCode(), alarmConditionFilterKey2.hashCode());
  }

  /**
   * Test {@link AlarmConditionFilterKey#equals(Object)}, and {@link
   * AlarmConditionFilterKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmConditionFilterKey#equals(Object)}
   *   <li>{@link AlarmConditionFilterKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilterKey.equals(Object)",
    "int AlarmConditionFilterKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmConditionFilterKey alarmConditionFilterKey =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");

    // Act and Assert
    assertEquals(alarmConditionFilterKey, alarmConditionFilterKey);
    int expectedHashCodeResult = alarmConditionFilterKey.hashCode();
    assertEquals(expectedHashCodeResult, alarmConditionFilterKey.hashCode());
  }

  /**
   * Test {@link AlarmConditionFilterKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilterKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilterKey.equals(Object)",
    "int AlarmConditionFilterKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmConditionFilterKey alarmConditionFilterKey = new AlarmConditionFilterKey(null, "Key");

    // Act and Assert
    assertNotEquals(
        alarmConditionFilterKey,
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
  }

  /**
   * Test {@link AlarmConditionFilterKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilterKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilterKey.equals(Object)",
    "int AlarmConditionFilterKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmConditionFilterKey alarmConditionFilterKey =
        new AlarmConditionFilterKey(AlarmConditionKeyType.TIME_SERIES, "Key");

    // Act and Assert
    assertNotEquals(
        alarmConditionFilterKey,
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
  }

  /**
   * Test {@link AlarmConditionFilterKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilterKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilterKey.equals(Object)",
    "int AlarmConditionFilterKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmConditionFilterKey alarmConditionFilterKey =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, null);

    // Act and Assert
    assertNotEquals(
        alarmConditionFilterKey,
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
  }

  /**
   * Test {@link AlarmConditionFilterKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilterKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilterKey.equals(Object)",
    "int AlarmConditionFilterKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmConditionFilterKey alarmConditionFilterKey =
        new AlarmConditionFilterKey(
            AlarmConditionKeyType.ATTRIBUTE,
            "org.thingsboard.server.common.data.device.profile.AlarmConditionFilterKey");

    // Act and Assert
    assertNotEquals(
        alarmConditionFilterKey,
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"));
  }

  /**
   * Test {@link AlarmConditionFilterKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilterKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilterKey.equals(Object)",
    "int AlarmConditionFilterKey.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"), null);
  }

  /**
   * Test {@link AlarmConditionFilterKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmConditionFilterKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AlarmConditionFilterKey.equals(Object)",
    "int AlarmConditionFilterKey.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key"),
        "Different type to AlarmConditionFilterKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmConditionFilterKey#AlarmConditionFilterKey(AlarmConditionKeyType, String)}
   *   <li>{@link AlarmConditionFilterKey#toString()}
   *   <li>{@link AlarmConditionFilterKey#getKey()}
   *   <li>{@link AlarmConditionFilterKey#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmConditionFilterKey.<init>(AlarmConditionKeyType, String)",
    "String AlarmConditionFilterKey.getKey()",
    "AlarmConditionKeyType AlarmConditionFilterKey.getType()",
    "String AlarmConditionFilterKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmConditionFilterKey actualAlarmConditionFilterKey =
        new AlarmConditionFilterKey(AlarmConditionKeyType.ATTRIBUTE, "Key");
    String actualToStringResult = actualAlarmConditionFilterKey.toString();
    String actualKey = actualAlarmConditionFilterKey.getKey();

    // Assert
    assertEquals("AlarmConditionFilterKey(type=ATTRIBUTE, key=Key)", actualToStringResult);
    assertEquals("Key", actualKey);
    assertEquals(AlarmConditionKeyType.ATTRIBUTE, actualAlarmConditionFilterKey.getType());
  }
}
