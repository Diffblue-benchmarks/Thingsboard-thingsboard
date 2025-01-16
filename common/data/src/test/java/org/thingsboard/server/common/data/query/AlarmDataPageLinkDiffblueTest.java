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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.alarm.AlarmSearchStatus;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.id.UserId;

class AlarmDataPageLinkDiffblueTest {
  /**
   * Test {@link AlarmDataPageLink#equals(Object)}, and
   * {@link AlarmDataPageLink#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataPageLink#equals(Object)}
   *   <li>{@link AlarmDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link AlarmDataPageLink#equals(Object)}, and
   * {@link AlarmDataPageLink#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataPageLink#equals(Object)}
   *   <li>{@link AlarmDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link AlarmDataPageLink#equals(Object)}, and
   * {@link AlarmDataPageLink#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataPageLink#equals(Object)}
   *   <li>{@link AlarmDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link AlarmDataPageLink#equals(Object)}, and
   * {@link AlarmDataPageLink#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataPageLink#equals(Object)}
   *   <li>{@link AlarmDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link AlarmDataPageLink#equals(Object)}, and
   * {@link AlarmDataPageLink#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmDataPageLink#equals(Object)}
   *   <li>{@link AlarmDataPageLink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();

    // Act and Assert
    assertEquals(alarmDataPageLink, alarmDataPageLink);
    int expectedHashCodeResult = alarmDataPageLink.hashCode();
    assertEquals(expectedHashCodeResult, alarmDataPageLink.hashCode());
  }

  /**
   * Test {@link AlarmDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmDataPageLink(), 1);
    assertNotEquals(new AlarmDataPageLink(), mock(EntityDataPageLink.class));
  }

  /**
   * Test {@link AlarmDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setStartTs(1L);

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Test {@link AlarmDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setEndTs(1L);

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Test {@link AlarmDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setTimeWindow(10L);

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Test {@link AlarmDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setTypeList(new ArrayList<>());

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Test {@link AlarmDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setStatusList(new ArrayList<>());

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Test {@link AlarmDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setSeverityList(new ArrayList<>());

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Test {@link AlarmDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setSearchPropagatedAlarms(true);

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Test {@link AlarmDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();
    alarmDataPageLink.setPageSize(3);

    // Act and Assert
    assertNotEquals(alarmDataPageLink, new AlarmDataPageLink());
  }

  /**
   * Test {@link AlarmDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();

    AlarmDataPageLink alarmDataPageLink2 = new AlarmDataPageLink();
    alarmDataPageLink2.setTypeList(new ArrayList<>());

    // Act and Assert
    assertNotEquals(alarmDataPageLink, alarmDataPageLink2);
  }

  /**
   * Test {@link AlarmDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();

    AlarmDataPageLink alarmDataPageLink2 = new AlarmDataPageLink();
    alarmDataPageLink2.setStatusList(new ArrayList<>());

    // Act and Assert
    assertNotEquals(alarmDataPageLink, alarmDataPageLink2);
  }

  /**
   * Test {@link AlarmDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AlarmDataPageLink alarmDataPageLink = new AlarmDataPageLink();

    AlarmDataPageLink alarmDataPageLink2 = new AlarmDataPageLink();
    alarmDataPageLink2.setSeverityList(new ArrayList<>());

    // Act and Assert
    assertNotEquals(alarmDataPageLink, alarmDataPageLink2);
  }

  /**
   * Test {@link AlarmDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmDataPageLink(), null);
  }

  /**
   * Test {@link AlarmDataPageLink#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataPageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmDataPageLink(), "Different type to AlarmDataPageLink");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
   * Test
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return TypeList is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}
   */
  @Test
  @DisplayName("Test new AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId); given '42'; then return TypeList is ArrayList()")
  void testNewAlarmDataPageLink_given42_thenReturnTypeListIsArrayList() {
    // Arrange
    EntityDataSortOrder sortOrder = new EntityDataSortOrder();

    ArrayList<String> typeList = new ArrayList<>();
    typeList.add("42");
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(3, 1, "Text Search", sortOrder, true, true, 1L,
        1L, 10L, typeList, statusList, new ArrayList<>(), null);

    // Assert
    assertEquals("Text Search", actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    assertEquals(1, actualAlarmDataPageLink.getPage());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertEquals(3, actualAlarmDataPageLink.getPageSize());
    assertTrue(actualAlarmDataPageLink.getSeverityList().isEmpty());
    assertTrue(actualAlarmDataPageLink.getStatusList().isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertTrue(actualAlarmDataPageLink.isDynamic());
    assertSame(typeList, actualAlarmDataPageLink.getTypeList());
    assertSame(sortOrder, actualAlarmDataPageLink.getSortOrder());
  }

  /**
   * Test
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return TypeList is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  @DisplayName("Test new AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId); given '42'; then return TypeList is ArrayList()")
  void testNewAlarmDataPageLink_given42_thenReturnTypeListIsArrayList2() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();
    typeList.add("42");
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(1L, 1L, 10L, typeList, statusList,
        new ArrayList<>(), true, null);

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
    assertTrue(actualAlarmDataPageLink.getSeverityList().isEmpty());
    assertTrue(actualAlarmDataPageLink.getStatusList().isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertSame(typeList, actualAlarmDataPageLink.getTypeList());
  }

  /**
   * Test
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}.
   * <ul>
   *   <li>Given {@code ACTIVE}.</li>
   *   <li>Then return StatusList is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}
   */
  @Test
  @DisplayName("Test new AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId); given 'ACTIVE'; then return StatusList is ArrayList()")
  void testNewAlarmDataPageLink_givenActive_thenReturnStatusListIsArrayList() {
    // Arrange
    EntityDataSortOrder sortOrder = new EntityDataSortOrder();
    ArrayList<String> typeList = new ArrayList<>();

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.ACTIVE);

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(3, 1, "Text Search", sortOrder, true, true, 1L,
        1L, 10L, typeList, statusList, new ArrayList<>(), null);

    // Assert
    assertEquals("Text Search", actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    assertEquals(1, actualAlarmDataPageLink.getPage());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertEquals(3, actualAlarmDataPageLink.getPageSize());
    assertTrue(actualAlarmDataPageLink.getSeverityList().isEmpty());
    assertTrue(actualAlarmDataPageLink.getTypeList().isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertTrue(actualAlarmDataPageLink.isDynamic());
    assertSame(statusList, actualAlarmDataPageLink.getStatusList());
    assertSame(sortOrder, actualAlarmDataPageLink.getSortOrder());
  }

  /**
   * Test
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}.
   * <ul>
   *   <li>Given {@code ACTIVE}.</li>
   *   <li>Then return StatusList is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  @DisplayName("Test new AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId); given 'ACTIVE'; then return StatusList is ArrayList()")
  void testNewAlarmDataPageLink_givenActive_thenReturnStatusListIsArrayList2() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.ACTIVE);

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(1L, 1L, 10L, typeList, statusList,
        new ArrayList<>(), true, null);

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
    assertTrue(actualAlarmDataPageLink.getSeverityList().isEmpty());
    assertTrue(actualAlarmDataPageLink.getTypeList().isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertSame(statusList, actualAlarmDataPageLink.getStatusList());
  }

  /**
   * Test
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}.
   * <ul>
   *   <li>Given {@code CLEARED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code CLEARED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}
   */
  @Test
  @DisplayName("Test new AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId); given 'CLEARED'; when ArrayList() add 'CLEARED'")
  void testNewAlarmDataPageLink_givenCleared_whenArrayListAddCleared() {
    // Arrange
    EntityDataSortOrder sortOrder = new EntityDataSortOrder();
    ArrayList<String> typeList = new ArrayList<>();

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.CLEARED);
    statusList.add(AlarmSearchStatus.ACTIVE);

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(3, 1, "Text Search", sortOrder, true, true, 1L,
        1L, 10L, typeList, statusList, new ArrayList<>(), null);

    // Assert
    assertEquals("Text Search", actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    assertEquals(1, actualAlarmDataPageLink.getPage());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertEquals(3, actualAlarmDataPageLink.getPageSize());
    assertTrue(actualAlarmDataPageLink.getSeverityList().isEmpty());
    assertTrue(actualAlarmDataPageLink.getTypeList().isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertTrue(actualAlarmDataPageLink.isDynamic());
    assertSame(statusList, actualAlarmDataPageLink.getStatusList());
    assertSame(sortOrder, actualAlarmDataPageLink.getSortOrder());
  }

  /**
   * Test
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}.
   * <ul>
   *   <li>Given {@code CLEARED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code CLEARED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  @DisplayName("Test new AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId); given 'CLEARED'; when ArrayList() add 'CLEARED'")
  void testNewAlarmDataPageLink_givenCleared_whenArrayListAddCleared2() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();

    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();
    statusList.add(AlarmSearchStatus.CLEARED);
    statusList.add(AlarmSearchStatus.ACTIVE);

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(1L, 1L, 10L, typeList, statusList,
        new ArrayList<>(), true, null);

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
    assertTrue(actualAlarmDataPageLink.getSeverityList().isEmpty());
    assertTrue(actualAlarmDataPageLink.getTypeList().isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertSame(statusList, actualAlarmDataPageLink.getStatusList());
  }

  /**
   * Test
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link ArrayList#ArrayList()} add empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}
   */
  @Test
  @DisplayName("Test new AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId); given empty string; when ArrayList() add empty string")
  void testNewAlarmDataPageLink_givenEmptyString_whenArrayListAddEmptyString() {
    // Arrange
    EntityDataSortOrder sortOrder = new EntityDataSortOrder();

    ArrayList<String> typeList = new ArrayList<>();
    typeList.add("");
    typeList.add("42");
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(3, 1, "Text Search", sortOrder, true, true, 1L,
        1L, 10L, typeList, statusList, new ArrayList<>(), null);

    // Assert
    assertEquals("Text Search", actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    assertEquals(1, actualAlarmDataPageLink.getPage());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertEquals(3, actualAlarmDataPageLink.getPageSize());
    assertTrue(actualAlarmDataPageLink.getSeverityList().isEmpty());
    assertTrue(actualAlarmDataPageLink.getStatusList().isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertTrue(actualAlarmDataPageLink.isDynamic());
    assertSame(typeList, actualAlarmDataPageLink.getTypeList());
    assertSame(sortOrder, actualAlarmDataPageLink.getSortOrder());
  }

  /**
   * Test
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link ArrayList#ArrayList()} add empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  @DisplayName("Test new AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId); given empty string; when ArrayList() add empty string")
  void testNewAlarmDataPageLink_givenEmptyString_whenArrayListAddEmptyString2() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();
    typeList.add("");
    typeList.add("42");
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(1L, 1L, 10L, typeList, statusList,
        new ArrayList<>(), true, null);

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
    assertTrue(actualAlarmDataPageLink.getSeverityList().isEmpty());
    assertTrue(actualAlarmDataPageLink.getStatusList().isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertSame(typeList, actualAlarmDataPageLink.getTypeList());
  }

  /**
   * Test
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}.
   * <ul>
   *   <li>Given {@code MAJOR}.</li>
   *   <li>Then return SeverityList is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}
   */
  @Test
  @DisplayName("Test new AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId); given 'MAJOR'; then return SeverityList is ArrayList()")
  void testNewAlarmDataPageLink_givenMajor_thenReturnSeverityListIsArrayList() {
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
    assertEquals(1, actualAlarmDataPageLink.getPage());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertEquals(3, actualAlarmDataPageLink.getPageSize());
    assertTrue(actualAlarmDataPageLink.getStatusList().isEmpty());
    assertTrue(actualAlarmDataPageLink.getTypeList().isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertTrue(actualAlarmDataPageLink.isDynamic());
    assertSame(severityList, actualAlarmDataPageLink.getSeverityList());
    assertSame(sortOrder, actualAlarmDataPageLink.getSortOrder());
  }

  /**
   * Test
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}.
   * <ul>
   *   <li>Given {@code MAJOR}.</li>
   *   <li>Then return SeverityList is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  @DisplayName("Test new AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId); given 'MAJOR'; then return SeverityList is ArrayList()")
  void testNewAlarmDataPageLink_givenMajor_thenReturnSeverityListIsArrayList2() {
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
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertFalse(actualAlarmDataPageLink.isDynamic());
    assertTrue(actualAlarmDataPageLink.getStatusList().isEmpty());
    assertTrue(actualAlarmDataPageLink.getTypeList().isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertSame(severityList, actualAlarmDataPageLink.getSeverityList());
  }

  /**
   * Test
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}.
   * <ul>
   *   <li>Given {@code MINOR}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code MINOR}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}
   */
  @Test
  @DisplayName("Test new AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId); given 'MINOR'; when ArrayList() add 'MINOR'")
  void testNewAlarmDataPageLink_givenMinor_whenArrayListAddMinor() {
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
    assertTrue(actualAlarmDataPageLink.getStatusList().isEmpty());
    assertTrue(actualAlarmDataPageLink.getTypeList().isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertTrue(actualAlarmDataPageLink.isDynamic());
    assertSame(severityList, actualAlarmDataPageLink.getSeverityList());
    assertSame(sortOrder, actualAlarmDataPageLink.getSortOrder());
  }

  /**
   * Test
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}.
   * <ul>
   *   <li>Given {@code MINOR}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code MINOR}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  @DisplayName("Test new AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId); given 'MINOR'; when ArrayList() add 'MINOR'")
  void testNewAlarmDataPageLink_givenMinor_whenArrayListAddMinor2() {
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
    assertTrue(actualAlarmDataPageLink.getStatusList().isEmpty());
    assertTrue(actualAlarmDataPageLink.getTypeList().isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertSame(severityList, actualAlarmDataPageLink.getSeverityList());
  }

  /**
   * Test
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return SeverityList Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId)}
   */
  @Test
  @DisplayName("Test new AlarmDataPageLink(long, long, long, List, List, List, boolean, UserId); when ArrayList(); then return SeverityList Empty")
  void testNewAlarmDataPageLink_whenArrayList_thenReturnSeverityListEmpty() {
    // Arrange
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(1L, 1L, 10L, typeList, statusList,
        new ArrayList<>(), true, null);

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
    assertTrue(actualAlarmDataPageLink.getSeverityList().isEmpty());
    assertTrue(actualAlarmDataPageLink.getStatusList().isEmpty());
    assertTrue(actualAlarmDataPageLink.getTypeList().isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
  }

  /**
   * Test
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}.
   * <ul>
   *   <li>When {@link EntityDataSortOrder#EntityDataSortOrder()}.</li>
   *   <li>Then return SeverityList Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmDataPageLink#AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId)}
   */
  @Test
  @DisplayName("Test new AlarmDataPageLink(int, int, String, EntityDataSortOrder, boolean, boolean, long, long, long, List, List, List, UserId); when EntityDataSortOrder(); then return SeverityList Empty")
  void testNewAlarmDataPageLink_whenEntityDataSortOrder_thenReturnSeverityListEmpty() {
    // Arrange
    EntityDataSortOrder sortOrder = new EntityDataSortOrder();
    ArrayList<String> typeList = new ArrayList<>();
    ArrayList<AlarmSearchStatus> statusList = new ArrayList<>();

    // Act
    AlarmDataPageLink actualAlarmDataPageLink = new AlarmDataPageLink(3, 1, "Text Search", sortOrder, true, true, 1L,
        1L, 10L, typeList, statusList, new ArrayList<>(), null);

    // Assert
    assertEquals("Text Search", actualAlarmDataPageLink.getTextSearch());
    assertNull(actualAlarmDataPageLink.getAssigneeId());
    assertEquals(1, actualAlarmDataPageLink.getPage());
    assertEquals(10L, actualAlarmDataPageLink.getTimeWindow());
    assertEquals(1L, actualAlarmDataPageLink.getEndTs());
    assertEquals(1L, actualAlarmDataPageLink.getStartTs());
    assertEquals(3, actualAlarmDataPageLink.getPageSize());
    assertTrue(actualAlarmDataPageLink.getSeverityList().isEmpty());
    assertTrue(actualAlarmDataPageLink.getStatusList().isEmpty());
    assertTrue(actualAlarmDataPageLink.getTypeList().isEmpty());
    assertTrue(actualAlarmDataPageLink.isSearchPropagatedAlarms());
    assertTrue(actualAlarmDataPageLink.isDynamic());
    assertSame(sortOrder, actualAlarmDataPageLink.getSortOrder());
  }

  /**
   * Test {@link AlarmDataPageLink#nextPageLink()}.
   * <ul>
   *   <li>Given {@link AlarmDataPageLink#AlarmDataPageLink()} Dynamic is
   * {@code true}.</li>
   *   <li>Then return Dynamic.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataPageLink#nextPageLink()}
   */
  @Test
  @DisplayName("Test nextPageLink(); given AlarmDataPageLink() Dynamic is 'true'; then return Dynamic")
  void testNextPageLink_givenAlarmDataPageLinkDynamicIsTrue_thenReturnDynamic() {
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
   * Test {@link AlarmDataPageLink#nextPageLink()}.
   * <ul>
   *   <li>Given {@link AlarmDataPageLink#AlarmDataPageLink()}.</li>
   *   <li>Then return not Dynamic.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmDataPageLink#nextPageLink()}
   */
  @Test
  @DisplayName("Test nextPageLink(); given AlarmDataPageLink(); then return not Dynamic")
  void testNextPageLink_givenAlarmDataPageLink_thenReturnNotDynamic() {
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
}
