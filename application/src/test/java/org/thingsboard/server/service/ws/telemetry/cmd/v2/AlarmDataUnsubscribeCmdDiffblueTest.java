package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.ws.WsCmdType;

class AlarmDataUnsubscribeCmdDiffblueTest {
  /**
   * Test {@link AlarmDataUnsubscribeCmd#equals(Object)}, and {@link AlarmDataUnsubscribeCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataUnsubscribeCmd#equals(Object)}
   *   <li>{@link AlarmDataUnsubscribeCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmDataUnsubscribeCmd.equals(Object)", "int AlarmDataUnsubscribeCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmDataUnsubscribeCmd alarmDataUnsubscribeCmd = new AlarmDataUnsubscribeCmd(1);
    AlarmDataUnsubscribeCmd alarmDataUnsubscribeCmd2 = new AlarmDataUnsubscribeCmd(1);

    // Act and Assert
    assertEquals(alarmDataUnsubscribeCmd, alarmDataUnsubscribeCmd2);
    int expectedHashCodeResult = alarmDataUnsubscribeCmd.hashCode();
    assertEquals(expectedHashCodeResult, alarmDataUnsubscribeCmd2.hashCode());
  }

  /**
   * Test {@link AlarmDataUnsubscribeCmd#equals(Object)}, and {@link AlarmDataUnsubscribeCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataUnsubscribeCmd#equals(Object)}
   *   <li>{@link AlarmDataUnsubscribeCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmDataUnsubscribeCmd.equals(Object)", "int AlarmDataUnsubscribeCmd.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmDataUnsubscribeCmd alarmDataUnsubscribeCmd = new AlarmDataUnsubscribeCmd(1);

    // Act and Assert
    assertEquals(alarmDataUnsubscribeCmd, alarmDataUnsubscribeCmd);
    int expectedHashCodeResult = alarmDataUnsubscribeCmd.hashCode();
    assertEquals(expectedHashCodeResult, alarmDataUnsubscribeCmd.hashCode());
  }

  /**
   * Test {@link AlarmDataUnsubscribeCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataUnsubscribeCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmDataUnsubscribeCmd.equals(Object)", "int AlarmDataUnsubscribeCmd.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmDataUnsubscribeCmd alarmDataUnsubscribeCmd = new AlarmDataUnsubscribeCmd(2);

    // Act and Assert
    assertNotEquals(alarmDataUnsubscribeCmd, new AlarmDataUnsubscribeCmd(1));
  }

  /**
   * Test {@link AlarmDataUnsubscribeCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataUnsubscribeCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmDataUnsubscribeCmd.equals(Object)", "int AlarmDataUnsubscribeCmd.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmDataUnsubscribeCmd(1), null);
  }

  /**
   * Test {@link AlarmDataUnsubscribeCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataUnsubscribeCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmDataUnsubscribeCmd.equals(Object)", "int AlarmDataUnsubscribeCmd.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmDataUnsubscribeCmd(1), "Different type to AlarmDataUnsubscribeCmd");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataUnsubscribeCmd#AlarmDataUnsubscribeCmd(int)}
   *   <li>{@link AlarmDataUnsubscribeCmd#toString()}
   *   <li>{@link AlarmDataUnsubscribeCmd#getCmdId()}
   *   <li>{@link AlarmDataUnsubscribeCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmDataUnsubscribeCmd.<init>(int)", "int AlarmDataUnsubscribeCmd.getCmdId()",
      "WsCmdType AlarmDataUnsubscribeCmd.getType()", "String AlarmDataUnsubscribeCmd.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmDataUnsubscribeCmd actualAlarmDataUnsubscribeCmd = new AlarmDataUnsubscribeCmd(1);
    String actualToStringResult = actualAlarmDataUnsubscribeCmd.toString();
    int actualCmdId = actualAlarmDataUnsubscribeCmd.getCmdId();

    // Assert
    assertEquals("AlarmDataUnsubscribeCmd(cmdId=1)", actualToStringResult);
    assertEquals(1, actualCmdId);
    assertEquals(WsCmdType.ALARM_DATA_UNSUBSCRIBE, actualAlarmDataUnsubscribeCmd.getType());
  }
}
