package org.thingsboard.server.service.ws.notification.cmd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.ws.notification.cmd.UnreadNotificationsCountUpdate.UnreadNotificationsCountUpdateBuilder;
import org.thingsboard.server.service.ws.telemetry.cmd.v2.CmdUpdateType;

class UnreadNotificationsCountUpdateDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link UnreadNotificationsCountUpdate#UnreadNotificationsCountUpdate(int, int, String, int, int)}
   *   <li>{@link UnreadNotificationsCountUpdate#toString()}
   *   <li>{@link UnreadNotificationsCountUpdate#getCmdUpdateType()}
   *   <li>{@link UnreadNotificationsCountUpdate#getSequenceNumber()}
   *   <li>{@link UnreadNotificationsCountUpdate#getTotalUnreadCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    UnreadNotificationsCountUpdate actualUnreadNotificationsCountUpdate = new UnreadNotificationsCountUpdate(1, -1,
        "An error occurred", 3, 10);
    String actualToStringResult = actualUnreadNotificationsCountUpdate.toString();
    CmdUpdateType actualCmdUpdateType = actualUnreadNotificationsCountUpdate.getCmdUpdateType();
    int actualSequenceNumber = actualUnreadNotificationsCountUpdate.getSequenceNumber();
    int actualTotalUnreadCount = actualUnreadNotificationsCountUpdate.getTotalUnreadCount();

    // Assert
    assertEquals("An error occurred", actualUnreadNotificationsCountUpdate.getErrorMsg());
    assertEquals("UnreadNotificationsCountUpdate(totalUnreadCount=3, sequenceNumber=10)", actualToStringResult);
    assertEquals(-1, actualUnreadNotificationsCountUpdate.getErrorCode());
    assertEquals(1, actualUnreadNotificationsCountUpdate.getCmdId());
    assertEquals(10, actualSequenceNumber);
    assertEquals(3, actualTotalUnreadCount);
    assertEquals(CmdUpdateType.NOTIFICATIONS_COUNT, actualCmdUpdateType);
  }

  /**
   * Test UnreadNotificationsCountUpdateBuilder
   * {@link UnreadNotificationsCountUpdateBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link UnreadNotificationsCountUpdate.UnreadNotificationsCountUpdateBuilder#build()}
   *   <li>
   * {@link UnreadNotificationsCountUpdate.UnreadNotificationsCountUpdateBuilder#cmdId(int)}
   *   <li>
   * {@link UnreadNotificationsCountUpdate.UnreadNotificationsCountUpdateBuilder#errorCode(int)}
   *   <li>
   * {@link UnreadNotificationsCountUpdate.UnreadNotificationsCountUpdateBuilder#errorMsg(String)}
   *   <li>
   * {@link UnreadNotificationsCountUpdate.UnreadNotificationsCountUpdateBuilder#sequenceNumber(int)}
   *   <li>
   * {@link UnreadNotificationsCountUpdate.UnreadNotificationsCountUpdateBuilder#totalUnreadCount(int)}
   * </ul>
   */
  @Test
  @DisplayName("Test UnreadNotificationsCountUpdateBuilder build()")
  void testUnreadNotificationsCountUpdateBuilderBuild() {
    // Arrange and Act
    UnreadNotificationsCountUpdate actualBuildResult = UnreadNotificationsCountUpdate.builder()
        .cmdId(1)
        .errorCode(-1)
        .errorMsg("An error occurred")
        .sequenceNumber(10)
        .totalUnreadCount(3)
        .build();

    // Assert
    assertEquals("An error occurred", actualBuildResult.getErrorMsg());
    assertEquals(-1, actualBuildResult.getErrorCode());
    assertEquals(1, actualBuildResult.getCmdId());
    assertEquals(10, actualBuildResult.getSequenceNumber());
    assertEquals(3, actualBuildResult.getTotalUnreadCount());
    assertEquals(CmdUpdateType.NOTIFICATIONS_COUNT, actualBuildResult.getCmdUpdateType());
  }
}
