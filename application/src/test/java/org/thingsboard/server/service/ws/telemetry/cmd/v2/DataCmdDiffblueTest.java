package org.thingsboard.server.service.ws.telemetry.cmd.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.query.AlarmCountQuery;
import org.thingsboard.server.common.data.query.AlarmCountQuery.AlarmCountQueryBuilder;
import org.thingsboard.server.common.data.query.AlarmDataQuery;

class DataCmdDiffblueTest {
  /**
   * Test {@link DataCmd#canEqual(Object)}.
   * <ul>
   *   <li>Given {@link AlarmCountQueryBuilder}
   * {@link AlarmCountQueryBuilder#assigneeId(UserId)} return builder.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataCmd#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); given AlarmCountQueryBuilder assigneeId(UserId) return builder; then return 'false'")
  void testCanEqual_givenAlarmCountQueryBuilderAssigneeIdReturnBuilder_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmCountQuery.AlarmCountQueryBuilder alarmCountQueryBuilder = mock(AlarmCountQuery.AlarmCountQueryBuilder.class);
    when(alarmCountQueryBuilder.assigneeId(Mockito.<UserId>any())).thenReturn(AlarmCountQuery.builder());
    AlarmCountQuery.AlarmCountQueryBuilder endTsResult = alarmCountQueryBuilder.assigneeId(null).endTs(1L);
    AlarmCountQuery.AlarmCountQueryBuilder startTsResult = endTsResult.severityList(new ArrayList<>()).startTs(1L);
    AlarmCountQuery.AlarmCountQueryBuilder timeWindowResult = startTsResult.statusList(new ArrayList<>())
        .timeWindow(10L);
    AlarmCountQuery query = timeWindowResult.typeList(new ArrayList<>()).build();

    // Act
    boolean actualCanEqualResult = (new AlarmCountCmd(1, query)).canEqual("Other");

    // Assert
    verify(alarmCountQueryBuilder).assigneeId(isNull());
    assertFalse(actualCanEqualResult);
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
  void testCanEqual_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmCountQuery.AlarmCountQueryBuilder alarmCountQueryBuilder = mock(AlarmCountQuery.AlarmCountQueryBuilder.class);
    when(alarmCountQueryBuilder.assigneeId(Mockito.<UserId>any())).thenReturn(AlarmCountQuery.builder());
    AlarmCountQuery.AlarmCountQueryBuilder endTsResult = alarmCountQueryBuilder.assigneeId(null).endTs(1L);
    AlarmCountQuery.AlarmCountQueryBuilder startTsResult = endTsResult.severityList(new ArrayList<>()).startTs(1L);
    AlarmCountQuery.AlarmCountQueryBuilder timeWindowResult = startTsResult.statusList(new ArrayList<>())
        .timeWindow(10L);
    AlarmCountQuery query = timeWindowResult.typeList(new ArrayList<>()).build();
    AlarmCountCmd alarmCountCmd = new AlarmCountCmd(1, query);

    // Act
    boolean actualCanEqualResult = alarmCountCmd.canEqual(new AlarmDataCmd(1, new AlarmDataQuery()));

    // Assert
    verify(alarmCountQueryBuilder).assigneeId(isNull());
    assertTrue(actualCanEqualResult);
  }

  /**
   * Test {@link DataCmd#getCmdId()}.
   * <ul>
   *   <li>Given {@link AlarmCountQueryBuilder}
   * {@link AlarmCountQueryBuilder#assigneeId(UserId)} return builder.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DataCmd#getCmdId()}
   */
  @Test
  @DisplayName("Test getCmdId(); given AlarmCountQueryBuilder assigneeId(UserId) return builder; then return one")
  void testGetCmdId_givenAlarmCountQueryBuilderAssigneeIdReturnBuilder_thenReturnOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmCountQuery.AlarmCountQueryBuilder alarmCountQueryBuilder = mock(AlarmCountQuery.AlarmCountQueryBuilder.class);
    when(alarmCountQueryBuilder.assigneeId(Mockito.<UserId>any())).thenReturn(AlarmCountQuery.builder());
    AlarmCountQuery.AlarmCountQueryBuilder endTsResult = alarmCountQueryBuilder.assigneeId(null).endTs(1L);
    AlarmCountQuery.AlarmCountQueryBuilder startTsResult = endTsResult.severityList(new ArrayList<>()).startTs(1L);
    AlarmCountQuery.AlarmCountQueryBuilder timeWindowResult = startTsResult.statusList(new ArrayList<>())
        .timeWindow(10L);
    AlarmCountQuery query = timeWindowResult.typeList(new ArrayList<>()).build();

    // Act
    int actualCmdId = (new AlarmCountCmd(1, query)).getCmdId();

    // Assert
    verify(alarmCountQueryBuilder).assigneeId(isNull());
    assertEquals(1, actualCmdId);
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
  void testToString_thenReturnDataCmdCmdId1() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmCountQuery.AlarmCountQueryBuilder alarmCountQueryBuilder = mock(AlarmCountQuery.AlarmCountQueryBuilder.class);
    when(alarmCountQueryBuilder.assigneeId(Mockito.<UserId>any())).thenReturn(AlarmCountQuery.builder());
    AlarmCountQuery.AlarmCountQueryBuilder endTsResult = alarmCountQueryBuilder.assigneeId(null).endTs(1L);
    AlarmCountQuery.AlarmCountQueryBuilder startTsResult = endTsResult.severityList(new ArrayList<>()).startTs(1L);
    AlarmCountQuery.AlarmCountQueryBuilder timeWindowResult = startTsResult.statusList(new ArrayList<>())
        .timeWindow(10L);
    AlarmCountQuery query = timeWindowResult.typeList(new ArrayList<>()).build();

    // Act
    String actualToStringResult = (new AlarmCountCmd(1, query)).toString();

    // Assert
    verify(alarmCountQueryBuilder).assigneeId(isNull());
    assertEquals("DataCmd(cmdId=1)", actualToStringResult);
  }
}
