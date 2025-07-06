package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AlarmCommentInfoDiffblueTest {
  /**
   * Test {@link AlarmCommentInfo#equals(Object)}, and {@link AlarmCommentInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentInfo#equals(Object)}
   *   <li>{@link AlarmCommentInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCommentInfo.equals(Object)", "int AlarmCommentInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    AlarmCommentInfo alarmCommentInfo2 = new AlarmCommentInfo();

    // Act and Assert
    assertEquals(alarmCommentInfo, alarmCommentInfo2);
    int expectedHashCodeResult = alarmCommentInfo.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentInfo2.hashCode());
  }

  /**
   * Test {@link AlarmCommentInfo#equals(Object)}, and {@link AlarmCommentInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentInfo#equals(Object)}
   *   <li>{@link AlarmCommentInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCommentInfo.equals(Object)", "int AlarmCommentInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    alarmCommentInfo.setFirstName("Jane");

    AlarmCommentInfo alarmCommentInfo2 = new AlarmCommentInfo();
    alarmCommentInfo2.setFirstName("Jane");

    // Act and Assert
    assertEquals(alarmCommentInfo, alarmCommentInfo2);
    int expectedHashCodeResult = alarmCommentInfo.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentInfo2.hashCode());
  }

  /**
   * Test {@link AlarmCommentInfo#equals(Object)}, and {@link AlarmCommentInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentInfo#equals(Object)}
   *   <li>{@link AlarmCommentInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCommentInfo.equals(Object)", "int AlarmCommentInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    alarmCommentInfo.setLastName("Doe");

    AlarmCommentInfo alarmCommentInfo2 = new AlarmCommentInfo();
    alarmCommentInfo2.setLastName("Doe");

    // Act and Assert
    assertEquals(alarmCommentInfo, alarmCommentInfo2);
    int expectedHashCodeResult = alarmCommentInfo.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentInfo2.hashCode());
  }

  /**
   * Test {@link AlarmCommentInfo#equals(Object)}, and {@link AlarmCommentInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentInfo#equals(Object)}
   *   <li>{@link AlarmCommentInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCommentInfo.equals(Object)", "int AlarmCommentInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    alarmCommentInfo.setEmail("jane.doe@example.org");

    AlarmCommentInfo alarmCommentInfo2 = new AlarmCommentInfo();
    alarmCommentInfo2.setEmail("jane.doe@example.org");

    // Act and Assert
    assertEquals(alarmCommentInfo, alarmCommentInfo2);
    int expectedHashCodeResult = alarmCommentInfo.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentInfo2.hashCode());
  }

  /**
   * Test {@link AlarmCommentInfo#equals(Object)}, and {@link AlarmCommentInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentInfo#equals(Object)}
   *   <li>{@link AlarmCommentInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCommentInfo.equals(Object)", "int AlarmCommentInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();

    // Act and Assert
    assertEquals(alarmCommentInfo, alarmCommentInfo);
    int expectedHashCodeResult = alarmCommentInfo.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentInfo.hashCode());
  }

  /**
   * Test {@link AlarmCommentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCommentInfo.equals(Object)", "int AlarmCommentInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentInfo(), 1);
  }

  /**
   * Test {@link AlarmCommentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCommentInfo.equals(Object)", "int AlarmCommentInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    alarmCommentInfo.setFirstName("Jane");

    // Act and Assert
    assertNotEquals(alarmCommentInfo, new AlarmCommentInfo());
  }

  /**
   * Test {@link AlarmCommentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCommentInfo.equals(Object)", "int AlarmCommentInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    alarmCommentInfo.setLastName("Doe");

    // Act and Assert
    assertNotEquals(alarmCommentInfo, new AlarmCommentInfo());
  }

  /**
   * Test {@link AlarmCommentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCommentInfo.equals(Object)", "int AlarmCommentInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    alarmCommentInfo.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(alarmCommentInfo, new AlarmCommentInfo());
  }

  /**
   * Test {@link AlarmCommentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCommentInfo.equals(Object)", "int AlarmCommentInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    alarmCommentInfo.setType(AlarmCommentType.SYSTEM);

    // Act and Assert
    assertNotEquals(alarmCommentInfo, new AlarmCommentInfo());
  }

  /**
   * Test {@link AlarmCommentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCommentInfo.equals(Object)", "int AlarmCommentInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();

    AlarmCommentInfo alarmCommentInfo2 = new AlarmCommentInfo();
    alarmCommentInfo2.setFirstName("Jane");

    // Act and Assert
    assertNotEquals(alarmCommentInfo, alarmCommentInfo2);
  }

  /**
   * Test {@link AlarmCommentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCommentInfo.equals(Object)", "int AlarmCommentInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();

    AlarmCommentInfo alarmCommentInfo2 = new AlarmCommentInfo();
    alarmCommentInfo2.setLastName("Doe");

    // Act and Assert
    assertNotEquals(alarmCommentInfo, alarmCommentInfo2);
  }

  /**
   * Test {@link AlarmCommentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCommentInfo.equals(Object)", "int AlarmCommentInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();

    AlarmCommentInfo alarmCommentInfo2 = new AlarmCommentInfo();
    alarmCommentInfo2.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(alarmCommentInfo, alarmCommentInfo2);
  }

  /**
   * Test {@link AlarmCommentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCommentInfo.equals(Object)", "int AlarmCommentInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentInfo(), null);
  }

  /**
   * Test {@link AlarmCommentInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmCommentInfo.equals(Object)", "int AlarmCommentInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentInfo(), "Different type to AlarmCommentInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmCommentInfo#AlarmCommentInfo()}
   *   <li>{@link AlarmCommentInfo#setEmail(String)}
   *   <li>{@link AlarmCommentInfo#setFirstName(String)}
   *   <li>{@link AlarmCommentInfo#setLastName(String)}
   *   <li>{@link AlarmCommentInfo#toString()}
   *   <li>{@link AlarmCommentInfo#getEmail()}
   *   <li>{@link AlarmCommentInfo#getFirstName()}
   *   <li>{@link AlarmCommentInfo#getLastName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AlarmCommentInfo.<init>()",
    "String AlarmCommentInfo.getEmail()",
    "String AlarmCommentInfo.getFirstName()",
    "String AlarmCommentInfo.getLastName()",
    "void AlarmCommentInfo.setEmail(String)",
    "void AlarmCommentInfo.setFirstName(String)",
    "void AlarmCommentInfo.setLastName(String)",
    "String AlarmCommentInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmCommentInfo actualAlarmCommentInfo = new AlarmCommentInfo();
    actualAlarmCommentInfo.setEmail("jane.doe@example.org");
    actualAlarmCommentInfo.setFirstName("Jane");
    actualAlarmCommentInfo.setLastName("Doe");
    String actualToStringResult = actualAlarmCommentInfo.toString();
    String actualEmail = actualAlarmCommentInfo.getEmail();
    String actualFirstName = actualAlarmCommentInfo.getFirstName();

    // Assert
    assertEquals(
        "AlarmCommentInfo(firstName=Jane, lastName=Doe, email=jane.doe@example.org)",
        actualToStringResult);
    assertEquals("Doe", actualAlarmCommentInfo.getLastName());
    assertEquals("Jane", actualFirstName);
    assertEquals("jane.doe@example.org", actualEmail);
    assertNull(actualAlarmCommentInfo.getComment());
    assertNull(actualAlarmCommentInfo.getType());
    assertNull(actualAlarmCommentInfo.getId());
    assertNull(actualAlarmCommentInfo.getAlarmId());
    assertNull(actualAlarmCommentInfo.getUserId());
    assertEquals(0L, actualAlarmCommentInfo.getCreatedTime());
  }

  /**
   * Test {@link AlarmCommentInfo#AlarmCommentInfo(AlarmComment)}.
   *
   * <p>Method under test: {@link AlarmCommentInfo#AlarmCommentInfo(AlarmComment)}
   */
  @Test
  @DisplayName("Test new AlarmCommentInfo(AlarmComment)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmCommentInfo.<init>(AlarmComment)"})
  void testNewAlarmCommentInfo() {
    // Arrange and Act
    AlarmCommentInfo actualAlarmCommentInfo = new AlarmCommentInfo(new AlarmComment());

    // Assert
    assertNull(actualAlarmCommentInfo.getComment());
    assertNull(actualAlarmCommentInfo.getEmail());
    assertNull(actualAlarmCommentInfo.getFirstName());
    assertNull(actualAlarmCommentInfo.getLastName());
    assertNull(actualAlarmCommentInfo.getUuidId());
    assertNull(actualAlarmCommentInfo.getType());
    assertNull(actualAlarmCommentInfo.getId());
    assertNull(actualAlarmCommentInfo.getAlarmId());
    assertNull(actualAlarmCommentInfo.getUserId());
    assertEquals(0L, actualAlarmCommentInfo.getCreatedTime());
  }

  /**
   * Test {@link AlarmCommentInfo#AlarmCommentInfo(AlarmComment, String, String, String)}.
   *
   * <p>Method under test: {@link AlarmCommentInfo#AlarmCommentInfo(AlarmComment, String, String,
   * String)}
   */
  @Test
  @DisplayName("Test new AlarmCommentInfo(AlarmComment, String, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmCommentInfo.<init>(AlarmComment, String, String, String)"})
  void testNewAlarmCommentInfo2() {
    // Arrange and Act
    AlarmCommentInfo actualAlarmCommentInfo =
        new AlarmCommentInfo(new AlarmComment(), "Jane", "Doe", "jane.doe@example.org");

    // Assert
    assertEquals("Doe", actualAlarmCommentInfo.getLastName());
    assertEquals("Jane", actualAlarmCommentInfo.getFirstName());
    assertEquals("jane.doe@example.org", actualAlarmCommentInfo.getEmail());
    assertNull(actualAlarmCommentInfo.getComment());
    assertNull(actualAlarmCommentInfo.getUuidId());
    assertNull(actualAlarmCommentInfo.getType());
    assertNull(actualAlarmCommentInfo.getId());
    assertNull(actualAlarmCommentInfo.getAlarmId());
    assertNull(actualAlarmCommentInfo.getUserId());
    assertEquals(0L, actualAlarmCommentInfo.getCreatedTime());
  }
}
