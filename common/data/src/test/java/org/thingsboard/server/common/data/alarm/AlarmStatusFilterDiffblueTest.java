package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.TimePageLink;

class AlarmStatusFilterDiffblueTest {
  /**
   * Test {@link AlarmStatusFilter#from(AlarmSearchStatus)} with
   * {@code alarmSearchStatus}.
   * <ul>
   *   <li>When {@code ACK}.</li>
   *   <li>Then return AckFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmSearchStatus)}
   */
  @Test
  @DisplayName("Test from(AlarmSearchStatus) with 'alarmSearchStatus'; when 'ACK'; then return AckFilter")
  void testFromWithAlarmSearchStatus_whenAck_thenReturnAckFilter() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmSearchStatus.ACK);

    // Assert
    assertFalse(actualFromResult.hasClearFilter());
    assertTrue(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmSearchStatus)} with
   * {@code alarmSearchStatus}.
   * <ul>
   *   <li>When {@code ACTIVE}.</li>
   *   <li>Then return not ClearFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmSearchStatus)}
   */
  @Test
  @DisplayName("Test from(AlarmSearchStatus) with 'alarmSearchStatus'; when 'ACTIVE'; then return not ClearFilter")
  void testFromWithAlarmSearchStatus_whenActive_thenReturnNotClearFilter() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmSearchStatus.ACTIVE);

    // Assert
    assertFalse(actualFromResult.getClearFilter());
    assertFalse(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmSearchStatus)} with
   * {@code alarmSearchStatus}.
   * <ul>
   *   <li>When {@code ANY}.</li>
   *   <li>Then return not hasAnyFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmSearchStatus)}
   */
  @Test
  @DisplayName("Test from(AlarmSearchStatus) with 'alarmSearchStatus'; when 'ANY'; then return not hasAnyFilter")
  void testFromWithAlarmSearchStatus_whenAny_thenReturnNotHasAnyFilter() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmSearchStatus.ANY);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmSearchStatus)} with
   * {@code alarmSearchStatus}.
   * <ul>
   *   <li>When {@code CLEARED}.</li>
   *   <li>Then return ClearFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmSearchStatus)}
   */
  @Test
  @DisplayName("Test from(AlarmSearchStatus) with 'alarmSearchStatus'; when 'CLEARED'; then return ClearFilter")
  void testFromWithAlarmSearchStatus_whenCleared_thenReturnClearFilter() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmSearchStatus.CLEARED);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmSearchStatus)} with
   * {@code alarmSearchStatus}.
   * <ul>
   *   <li>When {@code UNACK}.</li>
   *   <li>Then return not AckFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmSearchStatus)}
   */
  @Test
  @DisplayName("Test from(AlarmSearchStatus) with 'alarmSearchStatus'; when 'UNACK'; then return not AckFilter")
  void testFromWithAlarmSearchStatus_whenUnack_thenReturnNotAckFilter() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmSearchStatus.UNACK);

    // Assert
    assertFalse(actualFromResult.getAckFilter());
    assertFalse(actualFromResult.hasClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmStatus)} with {@code alarmStatus}.
   * <ul>
   *   <li>When {@code ACTIVE_ACK}.</li>
   *   <li>Then return not ClearFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmStatus)}
   */
  @Test
  @DisplayName("Test from(AlarmStatus) with 'alarmStatus'; when 'ACTIVE_ACK'; then return not ClearFilter")
  void testFromWithAlarmStatus_whenActiveAck_thenReturnNotClearFilter() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmStatus.ACTIVE_ACK);

    // Assert
    assertFalse(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmStatus)} with {@code alarmStatus}.
   * <ul>
   *   <li>When {@code ACTIVE_UNACK}.</li>
   *   <li>Then return not AckFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmStatus)}
   */
  @Test
  @DisplayName("Test from(AlarmStatus) with 'alarmStatus'; when 'ACTIVE_UNACK'; then return not AckFilter")
  void testFromWithAlarmStatus_whenActiveUnack_thenReturnNotAckFilter() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK);

    // Assert
    assertFalse(actualFromResult.getAckFilter());
    assertFalse(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmStatus)} with {@code alarmStatus}.
   * <ul>
   *   <li>When {@code CLEARED_ACK}.</li>
   *   <li>Then return AckFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmStatus)}
   */
  @Test
  @DisplayName("Test from(AlarmStatus) with 'alarmStatus'; when 'CLEARED_ACK'; then return AckFilter")
  void testFromWithAlarmStatus_whenClearedAck_thenReturnAckFilter() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmStatus.CLEARED_ACK);

    // Assert
    assertTrue(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmStatus)} with {@code alarmStatus}.
   * <ul>
   *   <li>When {@code CLEARED_UNACK}.</li>
   *   <li>Then return not AckFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmStatus)}
   */
  @Test
  @DisplayName("Test from(AlarmStatus) with 'alarmStatus'; when 'CLEARED_UNACK'; then return not AckFilter")
  void testFromWithAlarmStatus_whenClearedUnack_thenReturnNotAckFilter() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmStatus.CLEARED_UNACK);

    // Assert
    assertFalse(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  void testFromWithQuery() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(new AlarmQuery(TenantId.SYS_TENANT_ID,
        new TimePageLink(3), AlarmSearchStatus.ANY, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  void testFromWithQuery2() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter
        .from(new AlarmQuery(TenantId.SYS_TENANT_ID, new TimePageLink(3), null, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    assertFalse(actualFromResult.getAckFilter());
    assertFalse(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  void testFromWithQuery3() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(new AlarmQuery(TenantId.SYS_TENANT_ID,
        new TimePageLink(3), AlarmSearchStatus.ACTIVE, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    assertFalse(actualFromResult.getClearFilter());
    assertFalse(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  void testFromWithQuery4() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(new AlarmQuery(TenantId.SYS_TENANT_ID,
        new TimePageLink(3), AlarmSearchStatus.CLEARED, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  void testFromWithQuery5() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(new AlarmQuery(TenantId.SYS_TENANT_ID,
        new TimePageLink(3), AlarmSearchStatus.ACK, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    assertFalse(actualFromResult.hasClearFilter());
    assertTrue(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  void testFromWithQuery6() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(new AlarmQuery(TenantId.SYS_TENANT_ID,
        new TimePageLink(3), AlarmSearchStatus.UNACK, AlarmStatus.ACTIVE_UNACK, null, true));

    // Assert
    assertFalse(actualFromResult.getAckFilter());
    assertFalse(actualFromResult.hasClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  void testFromWithQuery7() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter
        .from(new AlarmQuery(TenantId.SYS_TENANT_ID, new TimePageLink(3), null, null, null, true));

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  void testFromWithQuery8() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter
        .from(new AlarmQuery(TenantId.SYS_TENANT_ID, new TimePageLink(3), null, AlarmStatus.ACTIVE_ACK, null, true));

    // Assert
    assertFalse(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  void testFromWithQuery9() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter
        .from(new AlarmQuery(TenantId.SYS_TENANT_ID, new TimePageLink(3), null, AlarmStatus.CLEARED_UNACK, null, true));

    // Assert
    assertFalse(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  void testFromWithQuery10() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter
        .from(new AlarmQuery(TenantId.SYS_TENANT_ID, new TimePageLink(3), null, AlarmStatus.CLEARED_ACK, null, true));

    // Assert
    assertTrue(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(Collection)} with {@code statuses}.
   * <ul>
   *   <li>Given {@code ACK}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code ACK}.</li>
   *   <li>Then return AckFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName("Test from(Collection) with 'statuses'; given 'ACK'; when ArrayList() add 'ACK'; then return AckFilter")
  void testFromWithStatuses_givenAck_whenArrayListAddAck_thenReturnAckFilter() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(AlarmSearchStatus.ACK);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.hasClearFilter());
    assertTrue(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(Collection)} with {@code statuses}.
   * <ul>
   *   <li>Given {@code ACTIVE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code ACTIVE}.</li>
   *   <li>Then return not ClearFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName("Test from(Collection) with 'statuses'; given 'ACTIVE'; when ArrayList() add 'ACTIVE'; then return not ClearFilter")
  void testFromWithStatuses_givenActive_whenArrayListAddActive_thenReturnNotClearFilter() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(AlarmSearchStatus.ACTIVE);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.getClearFilter());
    assertFalse(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(Collection)} with {@code statuses}.
   * <ul>
   *   <li>Given {@code ANY}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code ANY}.</li>
   *   <li>Then return not hasAnyFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName("Test from(Collection) with 'statuses'; given 'ANY'; when ArrayList() add 'ANY'; then return not hasAnyFilter")
  void testFromWithStatuses_givenAny_whenArrayListAddAny_thenReturnNotHasAnyFilter() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(AlarmSearchStatus.ANY);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(Collection)} with {@code statuses}.
   * <ul>
   *   <li>Given {@code ANY}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code ANY}.</li>
   *   <li>Then return not hasAnyFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName("Test from(Collection) with 'statuses'; given 'ANY'; when ArrayList() add 'ANY'; then return not hasAnyFilter")
  void testFromWithStatuses_givenAny_whenArrayListAddAny_thenReturnNotHasAnyFilter2() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(AlarmSearchStatus.ACTIVE);
    statuses.add(AlarmSearchStatus.ANY);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(Collection)} with {@code statuses}.
   * <ul>
   *   <li>Given {@code CLEARED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code CLEARED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName("Test from(Collection) with 'statuses'; given 'CLEARED'; when ArrayList() add 'CLEARED'")
  void testFromWithStatuses_givenCleared_whenArrayListAddCleared() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(AlarmSearchStatus.ACTIVE);
    statuses.add(AlarmSearchStatus.CLEARED);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(Collection)} with {@code statuses}.
   * <ul>
   *   <li>Given {@code CLEARED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code CLEARED}.</li>
   *   <li>Then return ClearFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName("Test from(Collection) with 'statuses'; given 'CLEARED'; when ArrayList() add 'CLEARED'; then return ClearFilter")
  void testFromWithStatuses_givenCleared_whenArrayListAddCleared_thenReturnClearFilter() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(AlarmSearchStatus.CLEARED);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(Collection)} with {@code statuses}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return not hasAnyFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName("Test from(Collection) with 'statuses'; given 'null'; when ArrayList() add 'null'; then return not hasAnyFilter")
  void testFromWithStatuses_givenNull_whenArrayListAddNull_thenReturnNotHasAnyFilter() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(null);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(Collection)} with {@code statuses}.
   * <ul>
   *   <li>Given {@code UNACK}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code UNACK}.</li>
   *   <li>Then return not AckFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName("Test from(Collection) with 'statuses'; given 'UNACK'; when ArrayList() add 'UNACK'; then return not AckFilter")
  void testFromWithStatuses_givenUnack_whenArrayListAddUnack_thenReturnNotAckFilter() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(AlarmSearchStatus.UNACK);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.getAckFilter());
    assertFalse(actualFromResult.hasClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(Collection)} with {@code statuses}.
   * <ul>
   *   <li>Given {@code UNACK}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code UNACK}.</li>
   *   <li>Then return not hasAnyFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName("Test from(Collection) with 'statuses'; given 'UNACK'; when ArrayList() add 'UNACK'; then return not hasAnyFilter")
  void testFromWithStatuses_givenUnack_whenArrayListAddUnack_thenReturnNotHasAnyFilter() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(AlarmSearchStatus.UNACK);
    statuses.add(AlarmSearchStatus.ACK);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(Collection)} with {@code statuses}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return not hasAnyFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName("Test from(Collection) with 'statuses'; when ArrayList(); then return not hasAnyFilter")
  void testFromWithStatuses_whenArrayList_thenReturnNotHasAnyFilter() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(new ArrayList<>());

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(Collection)} with {@code statuses}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return not hasAnyFilter.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName("Test from(Collection) with 'statuses'; when 'null'; then return not hasAnyFilter")
  void testFromWithStatuses_whenNull_thenReturnNotHasAnyFilter() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from((Collection<AlarmSearchStatus>) null);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#matches(Alarm)}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link Alarm#Alarm()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#matches(Alarm)}
   */
  @Test
  @DisplayName("Test matches(Alarm); given empty; when Alarm(); then return 'true'")
  void testMatches_givenEmpty_whenAlarm_thenReturnTrue() {
    // Arrange
    AlarmStatusFilter emptyResult = AlarmStatusFilter.empty();

    // Act and Assert
    assertTrue(emptyResult.matches(new Alarm()));
  }

  /**
   * Test {@link AlarmStatusFilter#matches(Alarm)}.
   * <ul>
   *   <li>Given from {@code ACTIVE_ACK}.</li>
   *   <li>When {@link Alarm#Alarm()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#matches(Alarm)}
   */
  @Test
  @DisplayName("Test matches(Alarm); given from 'ACTIVE_ACK'; when Alarm(); then return 'false'")
  void testMatches_givenFromActiveAck_whenAlarm_thenReturnFalse() {
    // Arrange
    AlarmStatusFilter fromResult = AlarmStatusFilter.from(AlarmStatus.ACTIVE_ACK);

    // Act and Assert
    assertFalse(fromResult.matches(new Alarm()));
  }

  /**
   * Test {@link AlarmStatusFilter#matches(Alarm)}.
   * <ul>
   *   <li>Given from {@code ACTIVE_UNACK}.</li>
   *   <li>When {@link Alarm#Alarm()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#matches(Alarm)}
   */
  @Test
  @DisplayName("Test matches(Alarm); given from 'ACTIVE_UNACK'; when Alarm(); then return 'true'")
  void testMatches_givenFromActiveUnack_whenAlarm_thenReturnTrue() {
    // Arrange
    AlarmStatusFilter fromResult = AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK);

    // Act and Assert
    assertTrue(fromResult.matches(new Alarm()));
  }

  /**
   * Test {@link AlarmStatusFilter#matches(Alarm)}.
   * <ul>
   *   <li>Given from {@code CLEARED_UNACK}.</li>
   *   <li>When {@link Alarm#Alarm()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#matches(Alarm)}
   */
  @Test
  @DisplayName("Test matches(Alarm); given from 'CLEARED_UNACK'; when Alarm(); then return 'false'")
  void testMatches_givenFromClearedUnack_whenAlarm_thenReturnFalse() {
    // Arrange
    AlarmStatusFilter fromResult = AlarmStatusFilter.from(AlarmStatus.CLEARED_UNACK);

    // Act and Assert
    assertFalse(fromResult.matches(new Alarm()));
  }

  /**
   * Test {@link AlarmStatusFilter#empty()}.
   * <p>
   * Method under test: {@link AlarmStatusFilter#empty()}
   */
  @Test
  @DisplayName("Test empty()")
  void testEmpty() {
    // Arrange and Act
    AlarmStatusFilter actualEmptyResult = AlarmStatusFilter.empty();

    // Assert
    assertFalse(actualEmptyResult.hasAckFilter());
    assertFalse(actualEmptyResult.hasAnyFilter());
    assertFalse(actualEmptyResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#hasAnyFilter()}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#hasAnyFilter()}
   */
  @Test
  @DisplayName("Test hasAnyFilter(); given empty; then return 'false'")
  void testHasAnyFilter_givenEmpty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AlarmStatusFilter.empty().hasAnyFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#hasAnyFilter()}.
   * <ul>
   *   <li>Given from {@code ACK}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#hasAnyFilter()}
   */
  @Test
  @DisplayName("Test hasAnyFilter(); given from 'ACK'; then return 'true'")
  void testHasAnyFilter_givenFromAck_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AlarmStatusFilter.from(AlarmSearchStatus.ACK).hasAnyFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#hasAnyFilter()}.
   * <ul>
   *   <li>Given from {@code ACTIVE_UNACK}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#hasAnyFilter()}
   */
  @Test
  @DisplayName("Test hasAnyFilter(); given from 'ACTIVE_UNACK'; then return 'true'")
  void testHasAnyFilter_givenFromActiveUnack_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK).hasAnyFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#hasClearFilter()}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#hasClearFilter()}
   */
  @Test
  @DisplayName("Test hasClearFilter(); given empty; then return 'false'")
  void testHasClearFilter_givenEmpty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AlarmStatusFilter.empty().hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#hasClearFilter()}.
   * <ul>
   *   <li>Given from {@code ACTIVE_UNACK}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#hasClearFilter()}
   */
  @Test
  @DisplayName("Test hasClearFilter(); given from 'ACTIVE_UNACK'; then return 'true'")
  void testHasClearFilter_givenFromActiveUnack_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK).hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#hasAckFilter()}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#hasAckFilter()}
   */
  @Test
  @DisplayName("Test hasAckFilter(); given empty; then return 'false'")
  void testHasAckFilter_givenEmpty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AlarmStatusFilter.empty().hasAckFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#hasAckFilter()}.
   * <ul>
   *   <li>Given from {@code ACTIVE_UNACK}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#hasAckFilter()}
   */
  @Test
  @DisplayName("Test hasAckFilter(); given from 'ACTIVE_UNACK'; then return 'true'")
  void testHasAckFilter_givenFromActiveUnack_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK).hasAckFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#getClearFilter()}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#getClearFilter()}
   */
  @Test
  @DisplayName("Test getClearFilter(); given empty; then throw RuntimeException")
  void testGetClearFilter_givenEmpty_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> AlarmStatusFilter.empty().getClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#getClearFilter()}.
   * <ul>
   *   <li>Given from {@code ACTIVE_UNACK}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#getClearFilter()}
   */
  @Test
  @DisplayName("Test getClearFilter(); given from 'ACTIVE_UNACK'; then return 'false'")
  void testGetClearFilter_givenFromActiveUnack_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK).getClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#getClearFilter()}.
   * <ul>
   *   <li>Given from {@code CLEARED_UNACK}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#getClearFilter()}
   */
  @Test
  @DisplayName("Test getClearFilter(); given from 'CLEARED_UNACK'; then return 'true'")
  void testGetClearFilter_givenFromClearedUnack_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AlarmStatusFilter.from(AlarmStatus.CLEARED_UNACK).getClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#getAckFilter()}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#getAckFilter()}
   */
  @Test
  @DisplayName("Test getAckFilter(); given empty; then throw RuntimeException")
  void testGetAckFilter_givenEmpty_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> AlarmStatusFilter.empty().getAckFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#getAckFilter()}.
   * <ul>
   *   <li>Given from {@code ACTIVE_ACK}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#getAckFilter()}
   */
  @Test
  @DisplayName("Test getAckFilter(); given from 'ACTIVE_ACK'; then return 'true'")
  void testGetAckFilter_givenFromActiveAck_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AlarmStatusFilter.from(AlarmStatus.ACTIVE_ACK).getAckFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#getAckFilter()}.
   * <ul>
   *   <li>Given from {@code ACTIVE_UNACK}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmStatusFilter#getAckFilter()}
   */
  @Test
  @DisplayName("Test getAckFilter(); given from 'ACTIVE_UNACK'; then return 'false'")
  void testGetAckFilter_givenFromActiveUnack_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK).getAckFilter());
  }
}
