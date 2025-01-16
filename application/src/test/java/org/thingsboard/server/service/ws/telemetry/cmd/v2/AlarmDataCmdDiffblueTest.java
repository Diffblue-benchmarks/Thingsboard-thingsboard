package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.AlarmDataQuery;
import org.thingsboard.server.service.ws.WsCmdType;

class AlarmDataCmdDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataCmd#AlarmDataCmd(int, AlarmDataQuery)}
   *   <li>{@link AlarmDataCmd#getQuery()}
   *   <li>{@link AlarmDataCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    AlarmDataQuery query = new AlarmDataQuery();

    // Act
    AlarmDataCmd actualAlarmDataCmd = new AlarmDataCmd(1, query);
    AlarmDataQuery actualQuery = actualAlarmDataCmd.getQuery();
    WsCmdType actualType = actualAlarmDataCmd.getType();

    // Assert
    assertEquals(1, actualAlarmDataCmd.getCmdId());
    assertEquals(WsCmdType.ALARM_DATA, actualType);
    assertSame(query, actualQuery);
  }
}
