/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.alarm.AlarmSearchStatus;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.id.UserId;

class AlarmCountQueryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCountQuery#AlarmCountQuery()}
   *   <li>{@link AlarmCountQuery#toString()}
   *   <li>{@link AlarmCountQuery#getAssigneeId()}
   *   <li>{@link AlarmCountQuery#getEndTs()}
   *   <li>{@link AlarmCountQuery#getSeverityList()}
   *   <li>{@link AlarmCountQuery#getStartTs()}
   *   <li>{@link AlarmCountQuery#getStatusList()}
   *   <li>{@link AlarmCountQuery#getTimeWindow()}
   *   <li>{@link AlarmCountQuery#getTypeList()}
   *   <li>{@link AlarmCountQuery#isSearchPropagatedAlarms()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmCountQuery actualAlarmCountQuery = new AlarmCountQuery();
    String actualToStringResult = actualAlarmCountQuery.toString();
    UserId actualAssigneeId = actualAlarmCountQuery.getAssigneeId();
    long actualEndTs = actualAlarmCountQuery.getEndTs();
    List<AlarmSeverity> actualSeverityList = actualAlarmCountQuery.getSeverityList();
    long actualStartTs = actualAlarmCountQuery.getStartTs();
    List<AlarmSearchStatus> actualStatusList = actualAlarmCountQuery.getStatusList();
    long actualTimeWindow = actualAlarmCountQuery.getTimeWindow();
    List<String> actualTypeList = actualAlarmCountQuery.getTypeList();
    boolean actualIsSearchPropagatedAlarmsResult = actualAlarmCountQuery.isSearchPropagatedAlarms();

    // Assert
    assertEquals("AlarmCountQuery(startTs=0, endTs=0, timeWindow=0, typeList=null, statusList=null, severityList=null,"
        + " searchPropagatedAlarms=false, assigneeId=null)", actualToStringResult);
    assertNull(actualTypeList);
    assertNull(actualStatusList);
    assertNull(actualSeverityList);
    assertNull(actualAlarmCountQuery.getKeyFilters());
    assertNull(actualAssigneeId);
    assertNull(actualAlarmCountQuery.getEntityFilter());
    assertEquals(0L, actualEndTs);
    assertEquals(0L, actualStartTs);
    assertEquals(0L, actualTimeWindow);
    assertFalse(actualIsSearchPropagatedAlarmsResult);
  }

  /**
   * Method under test:
   * {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  void testNewAlarmCountQuery() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    ArrayList<AlarmSeverity> severityList = new ArrayList<>();

    // Act
    AlarmCountQuery actualAlarmCountQuery = new AlarmCountQuery(1L, 1L, 10L, typeList, statusList, severityList, true,
        null);

    // Assert
    assertNull(actualAlarmCountQuery.getKeyFilters());
    assertNull(actualAlarmCountQuery.getAssigneeId());
    assertNull(actualAlarmCountQuery.getEntityFilter());
    assertEquals(10L, actualAlarmCountQuery.getTimeWindow());
    assertEquals(1L, actualAlarmCountQuery.getEndTs());
    assertEquals(1L, actualAlarmCountQuery.getStartTs());
    List<AlarmSeverity> severityList2 = actualAlarmCountQuery.getSeverityList();
    assertTrue(severityList2.isEmpty());
    List<AlarmSearchStatus> statusList2 = actualAlarmCountQuery.getStatusList();
    assertTrue(statusList2.isEmpty());
    List<String> typeList2 = actualAlarmCountQuery.getTypeList();
    assertTrue(typeList2.isEmpty());
    assertTrue(actualAlarmCountQuery.isSearchPropagatedAlarms());
    assertSame(severityList, severityList2);
    assertSame(statusList, statusList2);
    assertSame(typeList, typeList2);
  }

  /**
   * Method under test:
   * {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  void testNewAlarmCountQuery2() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();
    typeList.add("42");
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    ArrayList<AlarmSeverity> severityList = new ArrayList<>();

    // Act
    AlarmCountQuery actualAlarmCountQuery = new AlarmCountQuery(1L, 1L, 10L, typeList, statusList, severityList, true,
        null);

    // Assert
    List<String> typeList2 = actualAlarmCountQuery.getTypeList();
    assertEquals(1, typeList2.size());
    assertEquals("42", typeList2.get(0));
    assertNull(actualAlarmCountQuery.getKeyFilters());
    assertNull(actualAlarmCountQuery.getAssigneeId());
    assertNull(actualAlarmCountQuery.getEntityFilter());
    assertEquals(10L, actualAlarmCountQuery.getTimeWindow());
    assertEquals(1L, actualAlarmCountQuery.getEndTs());
    assertEquals(1L, actualAlarmCountQuery.getStartTs());
    List<AlarmSeverity> severityList2 = actualAlarmCountQuery.getSeverityList();
    assertTrue(severityList2.isEmpty());
    List<AlarmSearchStatus> statusList2 = actualAlarmCountQuery.getStatusList();
    assertTrue(statusList2.isEmpty());
    assertTrue(actualAlarmCountQuery.isSearchPropagatedAlarms());
    assertSame(severityList, severityList2);
    assertSame(statusList, statusList2);
    assertSame(typeList, typeList2);
  }

  /**
   * Method under test:
   * {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  void testNewAlarmCountQuery3() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();
    typeList.add("");
    typeList.add("42");
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    ArrayList<AlarmSeverity> severityList = new ArrayList<>();

    // Act
    AlarmCountQuery actualAlarmCountQuery = new AlarmCountQuery(1L, 1L, 10L, typeList, statusList, severityList, true,
        null);

    // Assert
    assertNull(actualAlarmCountQuery.getKeyFilters());
    assertNull(actualAlarmCountQuery.getAssigneeId());
    assertNull(actualAlarmCountQuery.getEntityFilter());
    assertEquals(10L, actualAlarmCountQuery.getTimeWindow());
    assertEquals(1L, actualAlarmCountQuery.getEndTs());
    assertEquals(1L, actualAlarmCountQuery.getStartTs());
    List<AlarmSeverity> severityList2 = actualAlarmCountQuery.getSeverityList();
    assertTrue(severityList2.isEmpty());
    List<AlarmSearchStatus> statusList2 = actualAlarmCountQuery.getStatusList();
    assertTrue(statusList2.isEmpty());
    assertTrue(actualAlarmCountQuery.isSearchPropagatedAlarms());
    assertSame(severityList, severityList2);
    assertSame(statusList, statusList2);
    assertSame(typeList, actualAlarmCountQuery.getTypeList());
  }

  /**
   * Method under test:
   * {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  void testNewAlarmCountQuery4() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.ACTIVE);
    ArrayList<AlarmSeverity> severityList = new ArrayList<>();

    // Act
    AlarmCountQuery actualAlarmCountQuery = new AlarmCountQuery(1L, 1L, 10L, typeList, statusList, severityList, true,
        null);

    // Assert
    assertNull(actualAlarmCountQuery.getKeyFilters());
    assertNull(actualAlarmCountQuery.getAssigneeId());
    assertNull(actualAlarmCountQuery.getEntityFilter());
    List<AlarmSearchStatus> statusList2 = actualAlarmCountQuery.getStatusList();
    assertEquals(1, statusList2.size());
    assertEquals(10L, actualAlarmCountQuery.getTimeWindow());
    assertEquals(1L, actualAlarmCountQuery.getEndTs());
    assertEquals(1L, actualAlarmCountQuery.getStartTs());
    assertEquals(AlarmSearchStatus.ACTIVE, statusList2.get(0));
    List<AlarmSeverity> severityList2 = actualAlarmCountQuery.getSeverityList();
    assertTrue(severityList2.isEmpty());
    List<String> typeList2 = actualAlarmCountQuery.getTypeList();
    assertTrue(typeList2.isEmpty());
    assertTrue(actualAlarmCountQuery.isSearchPropagatedAlarms());
    assertSame(severityList, severityList2);
    assertSame(statusList, statusList2);
    assertSame(typeList, typeList2);
  }

  /**
   * Method under test:
   * {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  void testNewAlarmCountQuery5() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.CLEARED);
    statusList.add(AlarmSearchStatus.ACTIVE);
    ArrayList<AlarmSeverity> severityList = new ArrayList<>();

    // Act
    AlarmCountQuery actualAlarmCountQuery = new AlarmCountQuery(1L, 1L, 10L, typeList, statusList, severityList, true,
        null);

    // Assert
    assertNull(actualAlarmCountQuery.getKeyFilters());
    assertNull(actualAlarmCountQuery.getAssigneeId());
    assertNull(actualAlarmCountQuery.getEntityFilter());
    assertEquals(10L, actualAlarmCountQuery.getTimeWindow());
    assertEquals(1L, actualAlarmCountQuery.getEndTs());
    assertEquals(1L, actualAlarmCountQuery.getStartTs());
    List<AlarmSeverity> severityList2 = actualAlarmCountQuery.getSeverityList();
    assertTrue(severityList2.isEmpty());
    List<String> typeList2 = actualAlarmCountQuery.getTypeList();
    assertTrue(typeList2.isEmpty());
    assertTrue(actualAlarmCountQuery.isSearchPropagatedAlarms());
    assertSame(severityList, severityList2);
    assertSame(statusList, actualAlarmCountQuery.getStatusList());
    assertSame(typeList, typeList2);
  }

  /**
   * Method under test:
   * {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  void testNewAlarmCountQuery6() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    ArrayList<AlarmSeverity> severityList = new ArrayList<>();
    severityList.add(AlarmSeverity.MAJOR);

    // Act
    AlarmCountQuery actualAlarmCountQuery = new AlarmCountQuery(1L, 1L, 10L, typeList, statusList, severityList, true,
        null);

    // Assert
    assertNull(actualAlarmCountQuery.getKeyFilters());
    assertNull(actualAlarmCountQuery.getAssigneeId());
    assertNull(actualAlarmCountQuery.getEntityFilter());
    List<AlarmSeverity> severityList2 = actualAlarmCountQuery.getSeverityList();
    assertEquals(1, severityList2.size());
    assertEquals(10L, actualAlarmCountQuery.getTimeWindow());
    assertEquals(1L, actualAlarmCountQuery.getEndTs());
    assertEquals(1L, actualAlarmCountQuery.getStartTs());
    assertEquals(AlarmSeverity.MAJOR, severityList2.get(0));
    List<AlarmSearchStatus> statusList2 = actualAlarmCountQuery.getStatusList();
    assertTrue(statusList2.isEmpty());
    List<String> typeList2 = actualAlarmCountQuery.getTypeList();
    assertTrue(typeList2.isEmpty());
    assertTrue(actualAlarmCountQuery.isSearchPropagatedAlarms());
    assertSame(severityList, severityList2);
    assertSame(statusList, statusList2);
    assertSame(typeList, typeList2);
  }

  /**
   * Method under test:
   * {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  void testNewAlarmCountQuery7() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    ArrayList<AlarmSeverity> severityList = new ArrayList<>();
    severityList.add(AlarmSeverity.MINOR);
    severityList.add(AlarmSeverity.MAJOR);

    // Act
    AlarmCountQuery actualAlarmCountQuery = new AlarmCountQuery(1L, 1L, 10L, typeList, statusList, severityList, true,
        null);

    // Assert
    assertNull(actualAlarmCountQuery.getKeyFilters());
    assertNull(actualAlarmCountQuery.getAssigneeId());
    assertNull(actualAlarmCountQuery.getEntityFilter());
    assertEquals(10L, actualAlarmCountQuery.getTimeWindow());
    assertEquals(1L, actualAlarmCountQuery.getEndTs());
    assertEquals(1L, actualAlarmCountQuery.getStartTs());
    List<AlarmSearchStatus> statusList2 = actualAlarmCountQuery.getStatusList();
    assertTrue(statusList2.isEmpty());
    List<String> typeList2 = actualAlarmCountQuery.getTypeList();
    assertTrue(typeList2.isEmpty());
    assertTrue(actualAlarmCountQuery.isSearchPropagatedAlarms());
    assertSame(severityList, actualAlarmCountQuery.getSeverityList());
    assertSame(statusList, statusList2);
    assertSame(typeList, typeList2);
  }
}
