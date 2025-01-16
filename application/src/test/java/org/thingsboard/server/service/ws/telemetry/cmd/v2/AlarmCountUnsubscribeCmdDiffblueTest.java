package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.ws.WsCmdType;

class AlarmCountUnsubscribeCmdDiffblueTest {
  /**
   * Test {@link AlarmCountUnsubscribeCmd#equals(Object)}, and
   * {@link AlarmCountUnsubscribeCmd#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCountUnsubscribeCmd#equals(Object)}
   *   <li>{@link AlarmCountUnsubscribeCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmCountUnsubscribeCmd alarmCountUnsubscribeCmd = new AlarmCountUnsubscribeCmd(1);
    AlarmCountUnsubscribeCmd alarmCountUnsubscribeCmd2 = new AlarmCountUnsubscribeCmd(1);

    // Act and Assert
    assertEquals(alarmCountUnsubscribeCmd, alarmCountUnsubscribeCmd2);
    int expectedHashCodeResult = alarmCountUnsubscribeCmd.hashCode();
    assertEquals(expectedHashCodeResult, alarmCountUnsubscribeCmd2.hashCode());
  }

  /**
   * Test {@link AlarmCountUnsubscribeCmd#equals(Object)}, and
   * {@link AlarmCountUnsubscribeCmd#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCountUnsubscribeCmd#equals(Object)}
   *   <li>{@link AlarmCountUnsubscribeCmd#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmCountUnsubscribeCmd alarmCountUnsubscribeCmd = new AlarmCountUnsubscribeCmd(1);

    // Act and Assert
    assertEquals(alarmCountUnsubscribeCmd, alarmCountUnsubscribeCmd);
    int expectedHashCodeResult = alarmCountUnsubscribeCmd.hashCode();
    assertEquals(expectedHashCodeResult, alarmCountUnsubscribeCmd.hashCode());
  }

  /**
   * Test {@link AlarmCountUnsubscribeCmd#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCountUnsubscribeCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmCountUnsubscribeCmd alarmCountUnsubscribeCmd = new AlarmCountUnsubscribeCmd(2);

    // Act and Assert
    assertNotEquals(alarmCountUnsubscribeCmd, new AlarmCountUnsubscribeCmd(1));
  }

  /**
   * Test {@link AlarmCountUnsubscribeCmd#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCountUnsubscribeCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCountUnsubscribeCmd(1), null);
  }

  /**
   * Test {@link AlarmCountUnsubscribeCmd#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCountUnsubscribeCmd#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCountUnsubscribeCmd(1), "Different type to AlarmCountUnsubscribeCmd");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCountUnsubscribeCmd#AlarmCountUnsubscribeCmd(int)}
   *   <li>{@link AlarmCountUnsubscribeCmd#toString()}
   *   <li>{@link AlarmCountUnsubscribeCmd#getCmdId()}
   *   <li>{@link AlarmCountUnsubscribeCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmCountUnsubscribeCmd actualAlarmCountUnsubscribeCmd = new AlarmCountUnsubscribeCmd(1);
    String actualToStringResult = actualAlarmCountUnsubscribeCmd.toString();
    int actualCmdId = actualAlarmCountUnsubscribeCmd.getCmdId();

    // Assert
    assertEquals("AlarmCountUnsubscribeCmd(cmdId=1)", actualToStringResult);
    assertEquals(1, actualCmdId);
    assertEquals(WsCmdType.ALARM_COUNT_UNSUBSCRIBE, actualAlarmCountUnsubscribeCmd.getType());
  }
}
