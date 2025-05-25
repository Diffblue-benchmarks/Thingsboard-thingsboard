package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AlarmCountUpdateDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return toString is {@code AlarmCountUpdate(count=0)}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCountUpdate#AlarmCountUpdate(int, int, String)}
   *   <li>{@link AlarmCountUpdate#toString()}
   *   <li>{@link AlarmCountUpdate#getCmdUpdateType()}
   *   <li>{@link AlarmCountUpdate#getCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return toString is 'AlarmCountUpdate(count=0)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmCountUpdate.<init>(int, int, int, String)",
      "void AlarmCountUpdate.<init>(int, int, String)", "CmdUpdateType AlarmCountUpdate.getCmdUpdateType()",
      "int AlarmCountUpdate.getCount()", "String AlarmCountUpdate.toString()"})
  void testGettersAndSetters_thenReturnToStringIsAlarmCountUpdateCount0() {
    // Arrange and Act
    AlarmCountUpdate actualAlarmCountUpdate = new AlarmCountUpdate(1, -1, "An error occurred");
    String actualToStringResult = actualAlarmCountUpdate.toString();
    CmdUpdateType actualCmdUpdateType = actualAlarmCountUpdate.getCmdUpdateType();
    int actualCount = actualAlarmCountUpdate.getCount();

    // Assert
    assertEquals("AlarmCountUpdate(count=0)", actualToStringResult);
    assertEquals("An error occurred", actualAlarmCountUpdate.getErrorMsg());
    assertEquals(-1, actualAlarmCountUpdate.getErrorCode());
    assertEquals(0, actualCount);
    assertEquals(1, actualAlarmCountUpdate.getCmdId());
    assertEquals(CmdUpdateType.ALARM_COUNT_DATA, actualCmdUpdateType);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return toString is {@code AlarmCountUpdate(count=3)}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCountUpdate#AlarmCountUpdate(int, int, int, String)}
   *   <li>{@link AlarmCountUpdate#toString()}
   *   <li>{@link AlarmCountUpdate#getCmdUpdateType()}
   *   <li>{@link AlarmCountUpdate#getCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when three; then return toString is 'AlarmCountUpdate(count=3)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmCountUpdate.<init>(int, int, int, String)",
      "void AlarmCountUpdate.<init>(int, int, String)", "CmdUpdateType AlarmCountUpdate.getCmdUpdateType()",
      "int AlarmCountUpdate.getCount()", "String AlarmCountUpdate.toString()"})
  void testGettersAndSetters_whenThree_thenReturnToStringIsAlarmCountUpdateCount3() {
    // Arrange and Act
    AlarmCountUpdate actualAlarmCountUpdate = new AlarmCountUpdate(1, 3, -1, "An error occurred");
    String actualToStringResult = actualAlarmCountUpdate.toString();
    CmdUpdateType actualCmdUpdateType = actualAlarmCountUpdate.getCmdUpdateType();
    int actualCount = actualAlarmCountUpdate.getCount();

    // Assert
    assertEquals("AlarmCountUpdate(count=3)", actualToStringResult);
    assertEquals("An error occurred", actualAlarmCountUpdate.getErrorMsg());
    assertEquals(-1, actualAlarmCountUpdate.getErrorCode());
    assertEquals(1, actualAlarmCountUpdate.getCmdId());
    assertEquals(3, actualCount);
    assertEquals(CmdUpdateType.ALARM_COUNT_DATA, actualCmdUpdateType);
  }

  /**
   * Test {@link AlarmCountUpdate#AlarmCountUpdate(int, int)}.
   * <ul>
   *   <li>Then return ErrorMsg is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCountUpdate#AlarmCountUpdate(int, int)}
   */
  @Test
  @DisplayName("Test new AlarmCountUpdate(int, int); then return ErrorMsg is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmCountUpdate.<init>(int, int)"})
  void testNewAlarmCountUpdate_thenReturnErrorMsgIsNull() {
    // Arrange and Act
    AlarmCountUpdate actualAlarmCountUpdate = new AlarmCountUpdate(1, 3);

    // Assert
    assertNull(actualAlarmCountUpdate.getErrorMsg());
    assertEquals(0, actualAlarmCountUpdate.getErrorCode());
    assertEquals(1, actualAlarmCountUpdate.getCmdId());
    assertEquals(3, actualAlarmCountUpdate.getCount());
    assertEquals(CmdUpdateType.ALARM_COUNT_DATA, actualAlarmCountUpdate.getCmdUpdateType());
  }
}
