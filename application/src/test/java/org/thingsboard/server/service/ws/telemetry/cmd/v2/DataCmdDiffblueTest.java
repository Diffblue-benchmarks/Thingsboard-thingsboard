package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.AlarmCountQuery;
import org.thingsboard.server.common.data.query.AlarmCountQuery.AlarmCountQueryBuilder;
import org.thingsboard.server.common.data.query.AlarmDataQuery;

class DataCmdDiffblueTest {
  /**
   * Test {@link DataCmd#canEqual(Object)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataCmd#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataCmd.canEqual(Object)"})
  void testCanEqual_thenReturnFalse() {
    // Arrange
    AlarmCountQueryBuilder endTsResult = AlarmCountQuery.builder().assigneeId(null).endTs(1L);
    AlarmCountQueryBuilder startTsResult = endTsResult.severityList(new ArrayList<>()).startTs(1L);
    AlarmCountQueryBuilder timeWindowResult = startTsResult.statusList(new ArrayList<>()).timeWindow(10L);
    AlarmCountQuery query = timeWindowResult.typeList(new ArrayList<>()).build();

    // Act and Assert
    assertFalse((new AlarmCountCmd(1, query)).canEqual("Other"));
  }

  /**
   * Test {@link DataCmd#canEqual(Object)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataCmd#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DataCmd.canEqual(Object)"})
  void testCanEqual_thenReturnTrue() {
    // Arrange
    AlarmCountQueryBuilder endTsResult = AlarmCountQuery.builder().assigneeId(null).endTs(1L);
    AlarmCountQueryBuilder startTsResult = endTsResult.severityList(new ArrayList<>()).startTs(1L);
    AlarmCountQueryBuilder timeWindowResult = startTsResult.statusList(new ArrayList<>()).timeWindow(10L);
    AlarmCountQuery query = timeWindowResult.typeList(new ArrayList<>()).build();
    AlarmCountCmd alarmCountCmd = new AlarmCountCmd(1, query);

    // Act and Assert
    assertTrue(alarmCountCmd.canEqual(new AlarmDataCmd(1, new AlarmDataQuery())));
  }

  /**
   * Test {@link DataCmd#getCmdId()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataCmd#getCmdId()}
   */
  @Test
  @DisplayName("Test getCmdId(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DataCmd.getCmdId()"})
  void testGetCmdId_thenReturnOne() {
    // Arrange
    AlarmCountQueryBuilder endTsResult = AlarmCountQuery.builder().assigneeId(null).endTs(1L);
    AlarmCountQueryBuilder startTsResult = endTsResult.severityList(new ArrayList<>()).startTs(1L);
    AlarmCountQueryBuilder timeWindowResult = startTsResult.statusList(new ArrayList<>()).timeWindow(10L);
    AlarmCountQuery query = timeWindowResult.typeList(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(1, (new AlarmCountCmd(1, query)).getCmdId());
  }

  /**
   * Test {@link DataCmd#toString()}.
   * <ul>
   *   <li>Then return {@code DataCmd(cmdId=1)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataCmd#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'DataCmd(cmdId=1)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String DataCmd.toString()"})
  void testToString_thenReturnDataCmdCmdId1() {
    // Arrange
    AlarmCountQueryBuilder endTsResult = AlarmCountQuery.builder().assigneeId(null).endTs(1L);
    AlarmCountQueryBuilder startTsResult = endTsResult.severityList(new ArrayList<>()).startTs(1L);
    AlarmCountQueryBuilder timeWindowResult = startTsResult.statusList(new ArrayList<>()).timeWindow(10L);
    AlarmCountQuery query = timeWindowResult.typeList(new ArrayList<>()).build();

    // Act and Assert
    assertEquals("DataCmd(cmdId=1)", (new AlarmCountCmd(1, query)).toString());
  }
}
