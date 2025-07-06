package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.alarm.AlarmSearchStatus;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.id.UserId;

class AlarmCountQueryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AlarmCountQuery.<init>()",
    "UserId AlarmCountQuery.getAssigneeId()",
    "long AlarmCountQuery.getEndTs()",
    "List AlarmCountQuery.getSeverityList()",
    "long AlarmCountQuery.getStartTs()",
    "List AlarmCountQuery.getStatusList()",
    "long AlarmCountQuery.getTimeWindow()",
    "List AlarmCountQuery.getTypeList()",
    "boolean AlarmCountQuery.isSearchPropagatedAlarms()",
    "String AlarmCountQuery.toString()"
  })
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
    assertEquals(
        "AlarmCountQuery(startTs=0, endTs=0, timeWindow=0, typeList=null, statusList=null, severityList=null,"
            + " searchPropagatedAlarms=false, assigneeId=null)",
        actualToStringResult);
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
   * Test {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List, List, boolean,
   * UserId)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return TypeList is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List,
   * List, boolean, UserId)}
   */
  @Test
  @DisplayName(
      "Test new AlarmCountQuery(long, long, long, List, List, List, boolean, UserId); given '42'; when ArrayList() add '42'; then return TypeList is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AlarmCountQuery.<init>(long, long, long, List, List, List, boolean, UserId)"
  })
  void testNewAlarmCountQuery_given42_whenArrayListAdd42_thenReturnTypeListIsArrayList() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();
    typeList.add("42");
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    // Act
    AlarmCountQuery actualAlarmCountQuery =
        new AlarmCountQuery(1L, 1L, 10L, typeList, statusList, new ArrayList<>(), true, null);

    // Assert
    assertNull(actualAlarmCountQuery.getKeyFilters());
    assertNull(actualAlarmCountQuery.getAssigneeId());
    assertNull(actualAlarmCountQuery.getEntityFilter());
    assertEquals(10L, actualAlarmCountQuery.getTimeWindow());
    assertEquals(1L, actualAlarmCountQuery.getEndTs());
    assertEquals(1L, actualAlarmCountQuery.getStartTs());
    assertTrue(actualAlarmCountQuery.getSeverityList().isEmpty());
    assertTrue(actualAlarmCountQuery.getStatusList().isEmpty());
    assertTrue(actualAlarmCountQuery.isSearchPropagatedAlarms());
    assertSame(typeList, actualAlarmCountQuery.getTypeList());
  }

  /**
   * Test {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List, List, boolean,
   * UserId)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>Then return StatusList is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List,
   * List, boolean, UserId)}
   */
  @Test
  @DisplayName(
      "Test new AlarmCountQuery(long, long, long, List, List, List, boolean, UserId); given 'ACTIVE'; then return StatusList is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AlarmCountQuery.<init>(long, long, long, List, List, List, boolean, UserId)"
  })
  void testNewAlarmCountQuery_givenActive_thenReturnStatusListIsArrayList() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.ACTIVE);

    // Act
    AlarmCountQuery actualAlarmCountQuery =
        new AlarmCountQuery(1L, 1L, 10L, typeList, statusList, new ArrayList<>(), true, null);

    // Assert
    assertNull(actualAlarmCountQuery.getKeyFilters());
    assertNull(actualAlarmCountQuery.getAssigneeId());
    assertNull(actualAlarmCountQuery.getEntityFilter());
    assertEquals(10L, actualAlarmCountQuery.getTimeWindow());
    assertEquals(1L, actualAlarmCountQuery.getEndTs());
    assertEquals(1L, actualAlarmCountQuery.getStartTs());
    assertTrue(actualAlarmCountQuery.getSeverityList().isEmpty());
    assertTrue(actualAlarmCountQuery.getTypeList().isEmpty());
    assertTrue(actualAlarmCountQuery.isSearchPropagatedAlarms());
    assertSame(statusList, actualAlarmCountQuery.getStatusList());
  }

  /**
   * Test {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List, List, boolean,
   * UserId)}.
   *
   * <ul>
   *   <li>Given {@code CLEARED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code CLEARED}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List,
   * List, boolean, UserId)}
   */
  @Test
  @DisplayName(
      "Test new AlarmCountQuery(long, long, long, List, List, List, boolean, UserId); given 'CLEARED'; when ArrayList() add 'CLEARED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AlarmCountQuery.<init>(long, long, long, List, List, List, boolean, UserId)"
  })
  void testNewAlarmCountQuery_givenCleared_whenArrayListAddCleared() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.CLEARED);
    statusList.add(AlarmSearchStatus.ACTIVE);

    // Act
    AlarmCountQuery actualAlarmCountQuery =
        new AlarmCountQuery(1L, 1L, 10L, typeList, statusList, new ArrayList<>(), true, null);

    // Assert
    assertNull(actualAlarmCountQuery.getKeyFilters());
    assertNull(actualAlarmCountQuery.getAssigneeId());
    assertNull(actualAlarmCountQuery.getEntityFilter());
    assertEquals(10L, actualAlarmCountQuery.getTimeWindow());
    assertEquals(1L, actualAlarmCountQuery.getEndTs());
    assertEquals(1L, actualAlarmCountQuery.getStartTs());
    assertTrue(actualAlarmCountQuery.getSeverityList().isEmpty());
    assertTrue(actualAlarmCountQuery.getTypeList().isEmpty());
    assertTrue(actualAlarmCountQuery.isSearchPropagatedAlarms());
    assertSame(statusList, actualAlarmCountQuery.getStatusList());
  }

  /**
   * Test {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List, List, boolean,
   * UserId)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link ArrayList#ArrayList()} add empty string.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List,
   * List, boolean, UserId)}
   */
  @Test
  @DisplayName(
      "Test new AlarmCountQuery(long, long, long, List, List, List, boolean, UserId); given empty string; when ArrayList() add empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AlarmCountQuery.<init>(long, long, long, List, List, List, boolean, UserId)"
  })
  void testNewAlarmCountQuery_givenEmptyString_whenArrayListAddEmptyString() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();
    typeList.add("");
    typeList.add("42");
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    // Act
    AlarmCountQuery actualAlarmCountQuery =
        new AlarmCountQuery(1L, 1L, 10L, typeList, statusList, new ArrayList<>(), true, null);

    // Assert
    assertNull(actualAlarmCountQuery.getKeyFilters());
    assertNull(actualAlarmCountQuery.getAssigneeId());
    assertNull(actualAlarmCountQuery.getEntityFilter());
    assertEquals(10L, actualAlarmCountQuery.getTimeWindow());
    assertEquals(1L, actualAlarmCountQuery.getEndTs());
    assertEquals(1L, actualAlarmCountQuery.getStartTs());
    assertTrue(actualAlarmCountQuery.getSeverityList().isEmpty());
    assertTrue(actualAlarmCountQuery.getStatusList().isEmpty());
    assertTrue(actualAlarmCountQuery.isSearchPropagatedAlarms());
    assertSame(typeList, actualAlarmCountQuery.getTypeList());
  }

  /**
   * Test {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List, List, boolean,
   * UserId)}.
   *
   * <ul>
   *   <li>Given {@code MAJOR}.
   *   <li>Then return SeverityList is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List,
   * List, boolean, UserId)}
   */
  @Test
  @DisplayName(
      "Test new AlarmCountQuery(long, long, long, List, List, List, boolean, UserId); given 'MAJOR'; then return SeverityList is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AlarmCountQuery.<init>(long, long, long, List, List, List, boolean, UserId)"
  })
  void testNewAlarmCountQuery_givenMajor_thenReturnSeverityListIsArrayList() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    ArrayList<AlarmSeverity> severityList = new ArrayList<>();
    severityList.add(AlarmSeverity.MAJOR);

    // Act
    AlarmCountQuery actualAlarmCountQuery =
        new AlarmCountQuery(1L, 1L, 10L, typeList, statusList, severityList, true, null);

    // Assert
    assertNull(actualAlarmCountQuery.getKeyFilters());
    assertNull(actualAlarmCountQuery.getAssigneeId());
    assertNull(actualAlarmCountQuery.getEntityFilter());
    assertEquals(10L, actualAlarmCountQuery.getTimeWindow());
    assertEquals(1L, actualAlarmCountQuery.getEndTs());
    assertEquals(1L, actualAlarmCountQuery.getStartTs());
    assertTrue(actualAlarmCountQuery.getStatusList().isEmpty());
    assertTrue(actualAlarmCountQuery.getTypeList().isEmpty());
    assertTrue(actualAlarmCountQuery.isSearchPropagatedAlarms());
    assertSame(severityList, actualAlarmCountQuery.getSeverityList());
  }

  /**
   * Test {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List, List, boolean,
   * UserId)}.
   *
   * <ul>
   *   <li>Given {@code MINOR}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code MINOR}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List,
   * List, boolean, UserId)}
   */
  @Test
  @DisplayName(
      "Test new AlarmCountQuery(long, long, long, List, List, List, boolean, UserId); given 'MINOR'; when ArrayList() add 'MINOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AlarmCountQuery.<init>(long, long, long, List, List, List, boolean, UserId)"
  })
  void testNewAlarmCountQuery_givenMinor_whenArrayListAddMinor() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    ArrayList<AlarmSeverity> severityList = new ArrayList<>();
    severityList.add(AlarmSeverity.MINOR);
    severityList.add(AlarmSeverity.MAJOR);

    // Act
    AlarmCountQuery actualAlarmCountQuery =
        new AlarmCountQuery(1L, 1L, 10L, typeList, statusList, severityList, true, null);

    // Assert
    assertNull(actualAlarmCountQuery.getKeyFilters());
    assertNull(actualAlarmCountQuery.getAssigneeId());
    assertNull(actualAlarmCountQuery.getEntityFilter());
    assertEquals(10L, actualAlarmCountQuery.getTimeWindow());
    assertEquals(1L, actualAlarmCountQuery.getEndTs());
    assertEquals(1L, actualAlarmCountQuery.getStartTs());
    assertTrue(actualAlarmCountQuery.getStatusList().isEmpty());
    assertTrue(actualAlarmCountQuery.getTypeList().isEmpty());
    assertTrue(actualAlarmCountQuery.isSearchPropagatedAlarms());
    assertSame(severityList, actualAlarmCountQuery.getSeverityList());
  }

  /**
   * Test {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List, List, boolean,
   * UserId)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return SeverityList Empty.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCountQuery#AlarmCountQuery(long, long, long, List, List,
   * List, boolean, UserId)}
   */
  @Test
  @DisplayName(
      "Test new AlarmCountQuery(long, long, long, List, List, List, boolean, UserId); when ArrayList(); then return SeverityList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AlarmCountQuery.<init>(long, long, long, List, List, List, boolean, UserId)"
  })
  void testNewAlarmCountQuery_whenArrayList_thenReturnSeverityListEmpty() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    // Act
    AlarmCountQuery actualAlarmCountQuery =
        new AlarmCountQuery(1L, 1L, 10L, typeList, statusList, new ArrayList<>(), true, null);

    // Assert
    assertNull(actualAlarmCountQuery.getKeyFilters());
    assertNull(actualAlarmCountQuery.getAssigneeId());
    assertNull(actualAlarmCountQuery.getEntityFilter());
    assertEquals(10L, actualAlarmCountQuery.getTimeWindow());
    assertEquals(1L, actualAlarmCountQuery.getEndTs());
    assertEquals(1L, actualAlarmCountQuery.getStartTs());
    assertTrue(actualAlarmCountQuery.getSeverityList().isEmpty());
    assertTrue(actualAlarmCountQuery.getStatusList().isEmpty());
    assertTrue(actualAlarmCountQuery.getTypeList().isEmpty());
    assertTrue(actualAlarmCountQuery.isSearchPropagatedAlarms());
  }
}
