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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.alarm.AlarmSearchStatus;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.id.UserId;

class AlarmDataPageLinkDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataPageLink#equals(Object)}
   *   <li>{@link AlarmDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    AlarmDataPageLink alarmDataPageLink2 = new AlarmDataPageLink();

    // Act and Assert
    assertEquals(alarmDataPageLink, alarmDataPageLink2);
    int expectedHashCodeResult = alarmDataPageLink.hashCode();
    assertEquals(expectedHashCodeResult, alarmDataPageLink2.hashCode());
  }

  /**
   * Method under test: {@link AlarmDataPageLink#nextPageLink()}
   */
  @Test
  void testNextPageLink() {
    // Arrange and Act
    AlarmDataPageLink actualNextPageLinkResult = (new AlarmDataPageLink()).nextPageLink();

    // Assert
    assertNull(actualNextPageLinkResult.getTextSearch());
    assertNull(actualNextPageLinkResult.getTypeList());
    assertNull(actualNextPageLinkResult.getStatusList());
    assertNull(actualNextPageLinkResult.getSeverityList());
    assertNull(actualNextPageLinkResult.getAssigneeId());
    assertNull(actualNextPageLinkResult.getSortOrder());
    assertEquals(0, actualNextPageLinkResult.getPageSize());
    assertEquals(0L, actualNextPageLinkResult.getEndTs());
    assertEquals(0L, actualNextPageLinkResult.getStartTs());
    assertEquals(0L, actualNextPageLinkResult.getTimeWindow());
    assertEquals(1, actualNextPageLinkResult.getPage());
    assertFalse(actualNextPageLinkResult.isSearchPropagatedAlarms());
    assertFalse(actualNextPageLinkResult.isDynamic());
  }

  /**
   * Method under test: {@link AlarmDataPageLink#nextPageLink()}
   */
  @Test
  void testNextPageLink2() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setDynamic(true);

    // Act
    AlarmDataPageLink actualNextPageLinkResult = alarmDataPageLink.nextPageLink();

    // Assert
    assertNull(actualNextPageLinkResult.getTextSearch());
    assertNull(actualNextPageLinkResult.getTypeList());
    assertNull(actualNextPageLinkResult.getStatusList());
    assertNull(actualNextPageLinkResult.getSeverityList());
    assertNull(actualNextPageLinkResult.getAssigneeId());
    assertNull(actualNextPageLinkResult.getSortOrder());
    assertEquals(0, actualNextPageLinkResult.getPageSize());
    assertEquals(0L, actualNextPageLinkResult.getEndTs());
    assertEquals(0L, actualNextPageLinkResult.getStartTs());
    assertEquals(0L, actualNextPageLinkResult.getTimeWindow());
    assertEquals(1, actualNextPageLinkResult.getPage());
    assertFalse(actualNextPageLinkResult.isSearchPropagatedAlarms());
    assertTrue(actualNextPageLinkResult.isDynamic());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataPageLink#equals(Object)}
   *   <li>{@link AlarmDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setTypeList(new ArrayList<>());

    AlarmDataPageLink alarmDataPageLink2 = new AlarmDataPageLink();
    alarmDataPageLink2.setTypeList(new ArrayList<>());

    // Act and Assert
    assertEquals(alarmDataPageLink, alarmDataPageLink2);
    int expectedHashCodeResult = alarmDataPageLink.hashCode();
    assertEquals(expectedHashCodeResult, alarmDataPageLink2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataPageLink#equals(Object)}
   *   <li>{@link AlarmDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setStatusList(new ArrayList<>());

    AlarmDataPageLink alarmDataPageLink2 = new AlarmDataPageLink();
    alarmDataPageLink2.setStatusList(new ArrayList<>());

    // Act and Assert
    assertEquals(alarmDataPageLink, alarmDataPageLink2);
    int expectedHashCodeResult = alarmDataPageLink.hashCode();
    assertEquals(expectedHashCodeResult, alarmDataPageLink2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataPageLink#equals(Object)}
   *   <li>{@link AlarmDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setSeverityList(new ArrayList<>());

    AlarmDataPageLink alarmDataPageLink2 = new AlarmDataPageLink();
    alarmDataPageLink2.setSeverityList(new ArrayList<>());

    // Act and Assert
    assertEquals(alarmDataPageLink, alarmDataPageLink2);
    int expectedHashCodeResult = alarmDataPageLink.hashCode();
    assertEquals(expectedHashCodeResult, alarmDataPageLink2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataPageLink#equals(Object)}
   *   <li>{@link AlarmDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();

    // Act and Assert
    assertEquals(alarmDataPageLink, alarmDataPageLink);
    int expectedHashCodeResult = alarmDataPageLink.hashCode();
    assertEquals(expectedHashCodeResult, alarmDataPageLink.hashCode());
  }

  /**
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmDataPageLink(), 1);
    assertNotEquals(new AlarmDataPageLink(), mock(EntityDataPageLink.class));
  }

  /**
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setStartTs(1L);

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setEndTs(1L);

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setTimeWindow(10L);

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setTypeList(new ArrayList<>());

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setStatusList(new ArrayList<>());

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setSeverityList(new ArrayList<>());

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setSearchPropagatedAlarms(true);

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setPageSize(3);

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();

    AlarmDataPageLink alarmDataPageLink2 = new AlarmDataPageLink();
    alarmDataPageLink2.setTypeList(new ArrayList<>());

    // Act and Assert
    assertNotEquals(alarmDataPageLink, alarmDataPageLink2);
  }

  /**
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();

    AlarmDataPageLink alarmDataPageLink2 = new AlarmDataPageLink();
    alarmDataPageLink2.setStatusList(new ArrayList<>());

    // Act and Assert
    assertNotEquals(alarmDataPageLink, alarmDataPageLink2);
  }

  /**
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();

    AlarmDataPageLink alarmDataPageLink2 = new AlarmDataPageLink();
    alarmDataPageLink2.setSeverityList(new ArrayList<>());

    // Act and Assert
    assertNotEquals(alarmDataPageLink, alarmDataPageLink2);
  }

  /**
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmDataPageLink(), null);
  }

  /**
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmDataPageLink(), "Different type to AlarmDataPageLink");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataPageLink#AlarmDataPageLink()}
   *   <li>{@link AlarmDataPageLink#setEndTs(long)}
   *   <li>{@link AlarmDataPageLink#setSearchPropagatedAlarms(boolean)}
   *   <li>{@link AlarmDataPageLink#setSeverityList(List)}
   *   <li>{@link AlarmDataPageLink#setStartTs(long)}
   *   <li>{@link AlarmDataPageLink#setStatusList(List)}
   *   <li>{@link AlarmDataPageLink#setTimeWindow(long)}
   *   <li>{@link AlarmDataPageLink#setTypeList(List)}
   *   <li>{@link AlarmDataPageLink#toString()}
   *   <li>{@link AlarmDataPageLink#getAssigneeId()}
   *   <li>{@link AlarmDataPageLink#getEndTs()}
   *   <li>{@link AlarmDataPageLink#getSeverityList()}
   *   <li>{@link AlarmDataPageLink#getStartTs()}
   *   <li>{@link AlarmDataPageLink#getStatusList()}
   *   <li>{@link AlarmDataPageLink#getTimeWindow()}
   *   <li>{@link AlarmDataPageLink#getTypeList()}
   *   <li>{@link AlarmDataPageLink#isSearchPropagatedAlarms()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink();
    actualAlarmDataPageLink.setEndTs(1L);
    actualAlarmDataPageLink.setSearchPropagatedAlarms(true);
    ArrayList<AlarmSeverity> severityList = new ArrayList<>();
    actualAlarmDataPageLink.setSeverityList(severityList);
    actualAlarmDataPageLink.setStartTs(1L);
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    actualAlarmDataPageLink.setStatusList(statusList);
    actualAlarmDataPageLink.setTimeWindow(10L);
    ArrayList<String> typeList = new ArrayList<>();
    actualAlarmDataPageLink.setTypeList(typeList);
    String actualToStringResult = actualAlarmDataPageLink.toString();
    actualAlarmDataPageLink.getAssigneeId();
    long actualEndTs = actualAlarmDataPageLink.getEndTs();
    List<AlarmSeverity> actualSeverityList = actualAlarmDataPageLink.getSeverityList();
    long actualStartTs = actualAlarmDataPageLink.getStartTs();
    List<AlarmSearchStatus> actualStatusList = actualAlarmDataPageLink.getStatusList();
    long actualTimeWindow = actualAlarmDataPageLink.getTimeWindow();
    List<String> actualTypeList = actualAlarmDataPageLink.getTypeList();
    boolean actualIsSearchPropagatedAlarmsResult = actualAlarmDataPageLink.isSearchPropagatedAlarms();

    // Assert that nothing has changed
    assertEquals("AlarmDataPageLink(super=EntityDataPageLink(pageSize=0, page=0, textSearch=null, sortOrder=null,"
        + " dynamic=false), startTs=1, endTs=1, timeWindow=10, typeList=[], statusList=[], severityList=[],"
        + " searchPropagatedAlarms=true, assigneeId=null)", actualToStringResult);
    assertEquals(0, actualAlarmDataPageLink.getPage());
    assertEquals(0, actualAlarmDataPageLink.getPageSize());
    assertEquals(10L, actualTimeWindow);
    assertEquals(1L, actualEndTs);
    assertEquals(1L, actualStartTs);
    assertFalse(actualAlarmDataPageLink.isDynamic());
    assertTrue(actualSeverityList.isEmpty());
    assertTrue(actualStatusList.isEmpty());
    assertTrue(actualTypeList.isEmpty());
    assertTrue(actualIsSearchPropagatedAlarmsResult);
    assertSame(severityList, actualSeverityList);
    assertSame(statusList, actualStatusList);
    assertSame(typeList, actualTypeList);
  }

  /**
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}
   */
  @Test
  void testNewAlarmDataPageLink() {
    // Arrange
    EntityDataSortOrder sortOrder = new EntityDataSortOrder();
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    ArrayList<AlarmSeverity> severityList = new ArrayList<>();

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(3, 1, "Text Search", sortOrder, true, true, 1L,
        1L, 10L, typeList, statusList, severityList, null);

    // Assert
    assertEquals("Text Search", actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    assertEquals(1, actualAlarmDataPageLink.getPage());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertEquals(3, actualAlarmDataPageLink.getPageSize());
    List<AlarmSeverity> severityList2 = actualAlarmDataPageLink.getSeverityList();
    assertTrue(severityList2.isEmpty());
    List<AlarmSearchStatus> statusList2 = actualAlarmDataPageLink.getStatusList();
    assertTrue(statusList2.isEmpty());
    List<String> typeList2 = actualAlarmDataPageLink.getTypeList();
    assertTrue(typeList2.isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertTrue(actualAlarmDataPageLink.isDynamic());
    assertSame(severityList, severityList2);
    assertSame(statusList, statusList2);
    assertSame(typeList, typeList2);
    assertSame(sortOrder, actualAlarmDataPageLink.getSortOrder());
  }

  /**
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}
   */
  @Test
  void testNewAlarmDataPageLink2() {
    // Arrange
    EntityDataSortOrder sortOrder = new EntityDataSortOrder();

    ArrayList<String> typeList = new ArrayList<>();
    typeList.add("42");
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    ArrayList<AlarmSeverity> severityList = new ArrayList<>();

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(3, 1, "Text Search", sortOrder, true, true, 1L,
        1L, 10L, typeList, statusList, severityList, null);

    // Assert
    List<String> typeList2 = actualAlarmDataPageLink.getTypeList();
    assertEquals(1, typeList2.size());
    assertEquals("42", typeList2.get(0));
    assertEquals("Text Search", actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    assertEquals(1, actualAlarmDataPageLink.getPage());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertEquals(3, actualAlarmDataPageLink.getPageSize());
    List<AlarmSeverity> severityList2 = actualAlarmDataPageLink.getSeverityList();
    assertTrue(severityList2.isEmpty());
    List<AlarmSearchStatus> statusList2 = actualAlarmDataPageLink.getStatusList();
    assertTrue(statusList2.isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertTrue(actualAlarmDataPageLink.isDynamic());
    assertSame(severityList, severityList2);
    assertSame(statusList, statusList2);
    assertSame(typeList, typeList2);
    assertSame(sortOrder, actualAlarmDataPageLink.getSortOrder());
  }

  /**
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}
   */
  @Test
  void testNewAlarmDataPageLink3() {
    // Arrange
    EntityDataSortOrder sortOrder = new EntityDataSortOrder();

    ArrayList<String> typeList = new ArrayList<>();
    typeList.add("");
    typeList.add("42");
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    ArrayList<AlarmSeverity> severityList = new ArrayList<>();

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(3, 1, "Text Search", sortOrder, true, true, 1L,
        1L, 10L, typeList, statusList, severityList, null);

    // Assert
    assertEquals("Text Search", actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    assertEquals(1, actualAlarmDataPageLink.getPage());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertEquals(3, actualAlarmDataPageLink.getPageSize());
    List<AlarmSeverity> severityList2 = actualAlarmDataPageLink.getSeverityList();
    assertTrue(severityList2.isEmpty());
    List<AlarmSearchStatus> statusList2 = actualAlarmDataPageLink.getStatusList();
    assertTrue(statusList2.isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertTrue(actualAlarmDataPageLink.isDynamic());
    assertSame(severityList, severityList2);
    assertSame(statusList, statusList2);
    assertSame(typeList, actualAlarmDataPageLink.getTypeList());
    assertSame(sortOrder, actualAlarmDataPageLink.getSortOrder());
  }

  /**
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}
   */
  @Test
  void testNewAlarmDataPageLink4() {
    // Arrange
    EntityDataSortOrder sortOrder = new EntityDataSortOrder();
    ArrayList<String> typeList = new ArrayList<>();

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.ACTIVE);
    ArrayList<AlarmSeverity> severityList = new ArrayList<>();

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(3, 1, "Text Search", sortOrder, true, true, 1L,
        1L, 10L, typeList, statusList, severityList, null);

    // Assert
    assertEquals("Text Search", actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    List<AlarmSearchStatus> statusList2 = actualAlarmDataPageLink.getStatusList();
    assertEquals(1, statusList2.size());
    assertEquals(1, actualAlarmDataPageLink.getPage());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertEquals(3, actualAlarmDataPageLink.getPageSize());
    assertEquals(AlarmSearchStatus.ACTIVE, statusList2.get(0));
    List<AlarmSeverity> severityList2 = actualAlarmDataPageLink.getSeverityList();
    assertTrue(severityList2.isEmpty());
    List<String> typeList2 = actualAlarmDataPageLink.getTypeList();
    assertTrue(typeList2.isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertTrue(actualAlarmDataPageLink.isDynamic());
    assertSame(severityList, severityList2);
    assertSame(statusList, statusList2);
    assertSame(typeList, typeList2);
    assertSame(sortOrder, actualAlarmDataPageLink.getSortOrder());
  }

  /**
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}
   */
  @Test
  void testNewAlarmDataPageLink5() {
    // Arrange
    EntityDataSortOrder sortOrder = new EntityDataSortOrder();
    ArrayList<String> typeList = new ArrayList<>();

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.CLEARED);
    statusList.add(AlarmSearchStatus.ACTIVE);
    ArrayList<AlarmSeverity> severityList = new ArrayList<>();

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(3, 1, "Text Search", sortOrder, true, true, 1L,
        1L, 10L, typeList, statusList, severityList, null);

    // Assert
    assertEquals("Text Search", actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    assertEquals(1, actualAlarmDataPageLink.getPage());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertEquals(3, actualAlarmDataPageLink.getPageSize());
    List<AlarmSeverity> severityList2 = actualAlarmDataPageLink.getSeverityList();
    assertTrue(severityList2.isEmpty());
    List<String> typeList2 = actualAlarmDataPageLink.getTypeList();
    assertTrue(typeList2.isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertTrue(actualAlarmDataPageLink.isDynamic());
    assertSame(severityList, severityList2);
    assertSame(statusList, actualAlarmDataPageLink.getStatusList());
    assertSame(typeList, typeList2);
    assertSame(sortOrder, actualAlarmDataPageLink.getSortOrder());
  }

  /**
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}
   */
  @Test
  void testNewAlarmDataPageLink6() {
    // Arrange
    EntityDataSortOrder sortOrder = new EntityDataSortOrder();
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    ArrayList<AlarmSeverity> severityList = new ArrayList<>();
    severityList.add(AlarmSeverity.MAJOR);

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(3, 1, "Text Search", sortOrder, true, true, 1L,
        1L, 10L, typeList, statusList, severityList, null);

    // Assert
    assertEquals("Text Search", actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    List<AlarmSeverity> severityList2 = actualAlarmDataPageLink.getSeverityList();
    assertEquals(1, severityList2.size());
    assertEquals(1, actualAlarmDataPageLink.getPage());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertEquals(3, actualAlarmDataPageLink.getPageSize());
    assertEquals(AlarmSeverity.MAJOR, severityList2.get(0));
    List<AlarmSearchStatus> statusList2 = actualAlarmDataPageLink.getStatusList();
    assertTrue(statusList2.isEmpty());
    List<String> typeList2 = actualAlarmDataPageLink.getTypeList();
    assertTrue(typeList2.isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertTrue(actualAlarmDataPageLink.isDynamic());
    assertSame(severityList, severityList2);
    assertSame(statusList, statusList2);
    assertSame(typeList, typeList2);
    assertSame(sortOrder, actualAlarmDataPageLink.getSortOrder());
  }

  /**
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}
   */
  @Test
  void testNewAlarmDataPageLink7() {
    // Arrange
    EntityDataSortOrder sortOrder = new EntityDataSortOrder();
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    ArrayList<AlarmSeverity> severityList = new ArrayList<>();
    severityList.add(AlarmSeverity.MINOR);
    severityList.add(AlarmSeverity.MAJOR);

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(3, 1, "Text Search", sortOrder, true, true, 1L,
        1L, 10L, typeList, statusList, severityList, null);

    // Assert
    assertEquals("Text Search", actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    assertEquals(1, actualAlarmDataPageLink.getPage());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertEquals(3, actualAlarmDataPageLink.getPageSize());
    List<AlarmSearchStatus> statusList2 = actualAlarmDataPageLink.getStatusList();
    assertTrue(statusList2.isEmpty());
    List<String> typeList2 = actualAlarmDataPageLink.getTypeList();
    assertTrue(typeList2.isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertTrue(actualAlarmDataPageLink.isDynamic());
    assertSame(severityList, actualAlarmDataPageLink.getSeverityList());
    assertSame(statusList, statusList2);
    assertSame(typeList, typeList2);
    assertSame(sortOrder, actualAlarmDataPageLink.getSortOrder());
  }

  /**
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  void testNewAlarmDataPageLink8() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    ArrayList<AlarmSeverity> severityList = new ArrayList<>();

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(1L, 1L, 10L, typeList, statusList, severityList,
        true, null);

    // Assert
    assertNull(actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    assertNull(actualAlarmDataPageLink.getSortOrder());
    assertEquals(0, actualAlarmDataPageLink.getPage());
    assertEquals(0, actualAlarmDataPageLink.getPageSize());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertFalse(actualAlarmDataPageLink.isDynamic());
    List<AlarmSeverity> severityList2 = actualAlarmDataPageLink.getSeverityList();
    assertTrue(severityList2.isEmpty());
    List<AlarmSearchStatus> statusList2 = actualAlarmDataPageLink.getStatusList();
    assertTrue(statusList2.isEmpty());
    List<String> typeList2 = actualAlarmDataPageLink.getTypeList();
    assertTrue(typeList2.isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertSame(severityList, severityList2);
    assertSame(statusList, statusList2);
    assertSame(typeList, typeList2);
  }

  /**
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  void testNewAlarmDataPageLink9() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();
    typeList.add("42");
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    ArrayList<AlarmSeverity> severityList = new ArrayList<>();

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(1L, 1L, 10L, typeList, statusList, severityList,
        true, null);

    // Assert
    List<String> typeList2 = actualAlarmDataPageLink.getTypeList();
    assertEquals(1, typeList2.size());
    assertEquals("42", typeList2.get(0));
    assertNull(actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    assertNull(actualAlarmDataPageLink.getSortOrder());
    assertEquals(0, actualAlarmDataPageLink.getPage());
    assertEquals(0, actualAlarmDataPageLink.getPageSize());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertFalse(actualAlarmDataPageLink.isDynamic());
    List<AlarmSeverity> severityList2 = actualAlarmDataPageLink.getSeverityList();
    assertTrue(severityList2.isEmpty());
    List<AlarmSearchStatus> statusList2 = actualAlarmDataPageLink.getStatusList();
    assertTrue(statusList2.isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertSame(severityList, severityList2);
    assertSame(statusList, statusList2);
    assertSame(typeList, typeList2);
  }

  /**
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  void testNewAlarmDataPageLink10() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();
    typeList.add("");
    typeList.add("42");
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    ArrayList<AlarmSeverity> severityList = new ArrayList<>();

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(1L, 1L, 10L, typeList, statusList, severityList,
        true, null);

    // Assert
    assertNull(actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    assertNull(actualAlarmDataPageLink.getSortOrder());
    assertEquals(0, actualAlarmDataPageLink.getPage());
    assertEquals(0, actualAlarmDataPageLink.getPageSize());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertFalse(actualAlarmDataPageLink.isDynamic());
    List<AlarmSeverity> severityList2 = actualAlarmDataPageLink.getSeverityList();
    assertTrue(severityList2.isEmpty());
    List<AlarmSearchStatus> statusList2 = actualAlarmDataPageLink.getStatusList();
    assertTrue(statusList2.isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertSame(severityList, severityList2);
    assertSame(statusList, statusList2);
    assertSame(typeList, actualAlarmDataPageLink.getTypeList());
  }

  /**
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  void testNewAlarmDataPageLink11() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.ACTIVE);
    ArrayList<AlarmSeverity> severityList = new ArrayList<>();

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(1L, 1L, 10L, typeList, statusList, severityList,
        true, null);

    // Assert
    assertNull(actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    assertNull(actualAlarmDataPageLink.getSortOrder());
    assertEquals(0, actualAlarmDataPageLink.getPage());
    assertEquals(0, actualAlarmDataPageLink.getPageSize());
    List<AlarmSearchStatus> statusList2 = actualAlarmDataPageLink.getStatusList();
    assertEquals(1, statusList2.size());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertEquals(AlarmSearchStatus.ACTIVE, statusList2.get(0));
    assertFalse(actualAlarmDataPageLink.isDynamic());
    List<AlarmSeverity> severityList2 = actualAlarmDataPageLink.getSeverityList();
    assertTrue(severityList2.isEmpty());
    List<String> typeList2 = actualAlarmDataPageLink.getTypeList();
    assertTrue(typeList2.isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertSame(severityList, severityList2);
    assertSame(statusList, statusList2);
    assertSame(typeList, typeList2);
  }

  /**
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  void testNewAlarmDataPageLink12() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.CLEARED);
    statusList.add(AlarmSearchStatus.ACTIVE);
    ArrayList<AlarmSeverity> severityList = new ArrayList<>();

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(1L, 1L, 10L, typeList, statusList, severityList,
        true, null);

    // Assert
    assertNull(actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    assertNull(actualAlarmDataPageLink.getSortOrder());
    assertEquals(0, actualAlarmDataPageLink.getPage());
    assertEquals(0, actualAlarmDataPageLink.getPageSize());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertFalse(actualAlarmDataPageLink.isDynamic());
    List<AlarmSeverity> severityList2 = actualAlarmDataPageLink.getSeverityList();
    assertTrue(severityList2.isEmpty());
    List<String> typeList2 = actualAlarmDataPageLink.getTypeList();
    assertTrue(typeList2.isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertSame(severityList, severityList2);
    assertSame(statusList, actualAlarmDataPageLink.getStatusList());
    assertSame(typeList, typeList2);
  }

  /**
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  void testNewAlarmDataPageLink13() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    ArrayList<AlarmSeverity> severityList = new ArrayList<>();
    severityList.add(AlarmSeverity.MAJOR);

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(1L, 1L, 10L, typeList, statusList, severityList,
        true, null);

    // Assert
    assertNull(actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    assertNull(actualAlarmDataPageLink.getSortOrder());
    assertEquals(0, actualAlarmDataPageLink.getPage());
    assertEquals(0, actualAlarmDataPageLink.getPageSize());
    List<AlarmSeverity> severityList2 = actualAlarmDataPageLink.getSeverityList();
    assertEquals(1, severityList2.size());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertEquals(AlarmSeverity.MAJOR, severityList2.get(0));
    assertFalse(actualAlarmDataPageLink.isDynamic());
    List<AlarmSearchStatus> statusList2 = actualAlarmDataPageLink.getStatusList();
    assertTrue(statusList2.isEmpty());
    List<String> typeList2 = actualAlarmDataPageLink.getTypeList();
    assertTrue(typeList2.isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertSame(severityList, severityList2);
    assertSame(statusList, statusList2);
    assertSame(typeList, typeList2);
  }

  /**
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  void testNewAlarmDataPageLink14() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    ArrayList<AlarmSeverity> severityList = new ArrayList<>();
    severityList.add(AlarmSeverity.MINOR);
    severityList.add(AlarmSeverity.MAJOR);

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(1L, 1L, 10L, typeList, statusList, severityList,
        true, null);

    // Assert
    assertNull(actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    assertNull(actualAlarmDataPageLink.getSortOrder());
    assertEquals(0, actualAlarmDataPageLink.getPage());
    assertEquals(0, actualAlarmDataPageLink.getPageSize());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertFalse(actualAlarmDataPageLink.isDynamic());
    List<AlarmSearchStatus> statusList2 = actualAlarmDataPageLink.getStatusList();
    assertTrue(statusList2.isEmpty());
    List<String> typeList2 = actualAlarmDataPageLink.getTypeList();
    assertTrue(typeList2.isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertSame(severityList, actualAlarmDataPageLink.getSeverityList());
    assertSame(statusList, statusList2);
    assertSame(typeList, typeList2);
  }
}
