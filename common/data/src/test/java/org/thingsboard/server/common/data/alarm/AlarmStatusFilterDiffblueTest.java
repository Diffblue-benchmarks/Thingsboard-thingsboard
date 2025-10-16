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
package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.TimePageLink;

class AlarmStatusFilterDiffblueTest {
  /**
   * Test {@link AlarmStatusFilter#from(AlarmSearchStatus)} with {@code alarmSearchStatus}.
   *
   * <ul>
   *   <li>When {@code ACK}.
   *   <li>Then return AckFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmSearchStatus)}
   */
  @Test
  @DisplayName(
      "Test from(AlarmSearchStatus) with 'alarmSearchStatus'; when 'ACK'; then return AckFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmSearchStatus)"})
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
   * Test {@link AlarmStatusFilter#from(AlarmSearchStatus)} with {@code alarmSearchStatus}.
   *
   * <ul>
   *   <li>When {@code ACTIVE}.
   *   <li>Then return not ClearFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmSearchStatus)}
   */
  @Test
  @DisplayName(
      "Test from(AlarmSearchStatus) with 'alarmSearchStatus'; when 'ACTIVE'; then return not ClearFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmSearchStatus)"})
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
   * Test {@link AlarmStatusFilter#from(AlarmSearchStatus)} with {@code alarmSearchStatus}.
   *
   * <ul>
   *   <li>When {@code ANY}.
   *   <li>Then return not hasAnyFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmSearchStatus)}
   */
  @Test
  @DisplayName(
      "Test from(AlarmSearchStatus) with 'alarmSearchStatus'; when 'ANY'; then return not hasAnyFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmSearchStatus)"})
  void testFromWithAlarmSearchStatus_whenAny_thenReturnNotHasAnyFilter() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(AlarmSearchStatus.ANY);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmSearchStatus)} with {@code alarmSearchStatus}.
   *
   * <ul>
   *   <li>When {@code CLEARED}.
   *   <li>Then return ClearFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmSearchStatus)}
   */
  @Test
  @DisplayName(
      "Test from(AlarmSearchStatus) with 'alarmSearchStatus'; when 'CLEARED'; then return ClearFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmSearchStatus)"})
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
   * Test {@link AlarmStatusFilter#from(AlarmSearchStatus)} with {@code alarmSearchStatus}.
   *
   * <ul>
   *   <li>When {@code UNACK}.
   *   <li>Then return not AckFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmSearchStatus)}
   */
  @Test
  @DisplayName(
      "Test from(AlarmSearchStatus) with 'alarmSearchStatus'; when 'UNACK'; then return not AckFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmSearchStatus)"})
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
   *
   * <ul>
   *   <li>When {@code ACTIVE_ACK}.
   *   <li>Then return not ClearFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmStatus)}
   */
  @Test
  @DisplayName(
      "Test from(AlarmStatus) with 'alarmStatus'; when 'ACTIVE_ACK'; then return not ClearFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmStatus)"})
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
   *
   * <ul>
   *   <li>When {@code ACTIVE_UNACK}.
   *   <li>Then return not AckFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmStatus)}
   */
  @Test
  @DisplayName(
      "Test from(AlarmStatus) with 'alarmStatus'; when 'ACTIVE_UNACK'; then return not AckFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmStatus)"})
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
   *
   * <ul>
   *   <li>When {@code CLEARED_ACK}.
   *   <li>Then return AckFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmStatus)}
   */
  @Test
  @DisplayName(
      "Test from(AlarmStatus) with 'alarmStatus'; when 'CLEARED_ACK'; then return AckFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmStatus)"})
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
   *
   * <ul>
   *   <li>When {@code CLEARED_UNACK}.
   *   <li>Then return not AckFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmStatus)}
   */
  @Test
  @DisplayName(
      "Test from(AlarmStatus) with 'alarmStatus'; when 'CLEARED_UNACK'; then return not AckFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmStatus)"})
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
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmQuery)"})
  void testFromWithQuery() {
    // Arrange
    AlarmQuery query =
        new AlarmQuery(
            TenantId.SYS_TENANT_ID,
            new TimePageLink(3),
            AlarmSearchStatus.ANY,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(query);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmQuery)"})
  void testFromWithQuery2() {
    // Arrange
    AlarmQuery query =
        new AlarmQuery(
            TenantId.SYS_TENANT_ID,
            new TimePageLink(3),
            null,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(query);

    // Assert
    assertFalse(actualFromResult.getAckFilter());
    assertFalse(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmQuery)"})
  void testFromWithQuery3() {
    // Arrange
    AlarmQuery query =
        new AlarmQuery(
            TenantId.SYS_TENANT_ID,
            new TimePageLink(3),
            AlarmSearchStatus.ACTIVE,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(query);

    // Assert
    assertFalse(actualFromResult.getClearFilter());
    assertFalse(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmQuery)"})
  void testFromWithQuery4() {
    // Arrange
    AlarmQuery query =
        new AlarmQuery(
            TenantId.SYS_TENANT_ID,
            new TimePageLink(3),
            AlarmSearchStatus.CLEARED,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(query);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAnyFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmQuery)"})
  void testFromWithQuery5() {
    // Arrange
    AlarmQuery query =
        new AlarmQuery(
            TenantId.SYS_TENANT_ID,
            new TimePageLink(3),
            AlarmSearchStatus.ACK,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(query);

    // Assert
    assertFalse(actualFromResult.hasClearFilter());
    assertTrue(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmQuery)"})
  void testFromWithQuery6() {
    // Arrange
    AlarmQuery query =
        new AlarmQuery(
            TenantId.SYS_TENANT_ID,
            new TimePageLink(3),
            AlarmSearchStatus.UNACK,
            AlarmStatus.ACTIVE_UNACK,
            null,
            true);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(query);

    // Assert
    assertFalse(actualFromResult.getAckFilter());
    assertFalse(actualFromResult.hasClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasAnyFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmQuery)"})
  void testFromWithQuery7() {
    // Arrange
    AlarmQuery query =
        new AlarmQuery(TenantId.SYS_TENANT_ID, new TimePageLink(3), null, null, null, true);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(query);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmQuery)"})
  void testFromWithQuery8() {
    // Arrange
    AlarmQuery query =
        new AlarmQuery(
            TenantId.SYS_TENANT_ID, new TimePageLink(3), null, AlarmStatus.ACTIVE_ACK, null, true);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(query);

    // Assert
    assertFalse(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmQuery)"})
  void testFromWithQuery9() {
    // Arrange
    AlarmQuery query =
        new AlarmQuery(
            TenantId.SYS_TENANT_ID,
            new TimePageLink(3),
            null,
            AlarmStatus.CLEARED_UNACK,
            null,
            true);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(query);

    // Assert
    assertFalse(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(AlarmQuery)} with {@code query}.
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(AlarmQuery)}
   */
  @Test
  @DisplayName("Test from(AlarmQuery) with 'query'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(AlarmQuery)"})
  void testFromWithQuery10() {
    // Arrange
    AlarmQuery query =
        new AlarmQuery(
            TenantId.SYS_TENANT_ID, new TimePageLink(3), null, AlarmStatus.CLEARED_ACK, null, true);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(query);

    // Assert
    assertTrue(actualFromResult.getAckFilter());
    assertTrue(actualFromResult.getClearFilter());
    assertTrue(actualFromResult.hasAckFilter());
    assertTrue(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(Collection)} with {@code statuses}.
   *
   * <ul>
   *   <li>Given {@code ACK}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ACK}.
   *   <li>Then return AckFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName(
      "Test from(Collection) with 'statuses'; given 'ACK'; when ArrayList() add 'ACK'; then return AckFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(Collection)"})
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
   *
   * <ul>
   *   <li>Given {@code ACK}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ACK}.
   *   <li>Then return not hasAnyFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName(
      "Test from(Collection) with 'statuses'; given 'ACK'; when ArrayList() add 'ACK'; then return not hasAnyFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(Collection)"})
  void testFromWithStatuses_givenAck_whenArrayListAddAck_thenReturnNotHasAnyFilter() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(AlarmSearchStatus.ACK);
    statuses.add(AlarmSearchStatus.UNACK);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(Collection)} with {@code statuses}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ACTIVE}.
   *   <li>Then return not ClearFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName(
      "Test from(Collection) with 'statuses'; given 'ACTIVE'; when ArrayList() add 'ACTIVE'; then return not ClearFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(Collection)"})
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
   *
   * <ul>
   *   <li>Given {@code ANY}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ANY}.
   *   <li>Then return not hasAnyFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName(
      "Test from(Collection) with 'statuses'; given 'ANY'; when ArrayList() add 'ANY'; then return not hasAnyFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(Collection)"})
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
   *
   * <ul>
   *   <li>Given {@code ANY}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ANY}.
   *   <li>Then return not hasAnyFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName(
      "Test from(Collection) with 'statuses'; given 'ANY'; when ArrayList() add 'ANY'; then return not hasAnyFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(Collection)"})
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
   *
   * <ul>
   *   <li>Given {@code CLEARED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code CLEARED}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName(
      "Test from(Collection) with 'statuses'; given 'CLEARED'; when ArrayList() add 'CLEARED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(Collection)"})
  void testFromWithStatuses_givenCleared_whenArrayListAddCleared() {
    // Arrange
    ArrayList<AlarmSearchStatus> statuses = new ArrayList<>();
    statuses.add(AlarmSearchStatus.CLEARED);
    statuses.add(AlarmSearchStatus.ACTIVE);

    // Act
    AlarmStatusFilter actualFromResult = AlarmStatusFilter.from(statuses);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#from(Collection)} with {@code statuses}.
   *
   * <ul>
   *   <li>Given {@code CLEARED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code CLEARED}.
   *   <li>Then return ClearFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName(
      "Test from(Collection) with 'statuses'; given 'CLEARED'; when ArrayList() add 'CLEARED'; then return ClearFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(Collection)"})
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
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return not hasAnyFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName(
      "Test from(Collection) with 'statuses'; given 'null'; when ArrayList() add 'null'; then return not hasAnyFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(Collection)"})
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
   *
   * <ul>
   *   <li>Given {@code UNACK}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code UNACK}.
   *   <li>Then return not AckFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName(
      "Test from(Collection) with 'statuses'; given 'UNACK'; when ArrayList() add 'UNACK'; then return not AckFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(Collection)"})
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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return not hasAnyFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName(
      "Test from(Collection) with 'statuses'; when ArrayList(); then return not hasAnyFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(Collection)"})
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
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not hasAnyFilter.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#from(Collection)}
   */
  @Test
  @DisplayName("Test from(Collection) with 'statuses'; when 'null'; then return not hasAnyFilter")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.from(Collection)"})
  void testFromWithStatuses_whenNull_thenReturnNotHasAnyFilter() {
    // Arrange and Act
    AlarmStatusFilter actualFromResult =
        AlarmStatusFilter.from((Collection<AlarmSearchStatus>) null);

    // Assert
    assertFalse(actualFromResult.hasAckFilter());
    assertFalse(actualFromResult.hasAnyFilter());
    assertFalse(actualFromResult.hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#matches(Alarm)}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link Alarm#Alarm()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#matches(Alarm)}
   */
  @Test
  @DisplayName("Test matches(Alarm); given empty; when Alarm(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmStatusFilter.matches(Alarm)"})
  void testMatches_givenEmpty_whenAlarm_thenReturnTrue() {
    // Arrange
    AlarmStatusFilter emptyResult = AlarmStatusFilter.empty();

    // Act and Assert
    assertTrue(emptyResult.matches(new Alarm()));
  }

  /**
   * Test {@link AlarmStatusFilter#matches(Alarm)}.
   *
   * <ul>
   *   <li>Given from {@code ACTIVE_UNACK}.
   *   <li>When {@link Alarm#Alarm()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#matches(Alarm)}
   */
  @Test
  @DisplayName("Test matches(Alarm); given from 'ACTIVE_UNACK'; when Alarm(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmStatusFilter.matches(Alarm)"})
  void testMatches_givenFromActiveUnack_whenAlarm_thenReturnTrue() {
    // Arrange
    AlarmStatusFilter fromResult = AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK);

    // Act and Assert
    assertTrue(fromResult.matches(new Alarm()));
  }

  /**
   * Test {@link AlarmStatusFilter#matches(Alarm)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Alarm#Alarm()} Acknowledged is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#matches(Alarm)}
   */
  @Test
  @DisplayName(
      "Test matches(Alarm); given 'true'; when Alarm() Acknowledged is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmStatusFilter.matches(Alarm)"})
  void testMatches_givenTrue_whenAlarmAcknowledgedIsTrue_thenReturnFalse() {
    // Arrange
    AlarmStatusFilter fromResult = AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK);

    Alarm alarm = new Alarm();
    alarm.setAcknowledged(true);

    // Act and Assert
    assertFalse(fromResult.matches(alarm));
  }

  /**
   * Test {@link AlarmStatusFilter#matches(Alarm)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link Alarm#Alarm()} Cleared is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#matches(Alarm)}
   */
  @Test
  @DisplayName(
      "Test matches(Alarm); given 'true'; when Alarm() Cleared is 'true'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmStatusFilter.matches(Alarm)"})
  void testMatches_givenTrue_whenAlarmClearedIsTrue_thenReturnFalse() {
    // Arrange
    AlarmStatusFilter fromResult = AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK);

    Alarm alarm = new Alarm();
    alarm.setCleared(true);

    // Act and Assert
    assertFalse(fromResult.matches(alarm));
  }

  /**
   * Test {@link AlarmStatusFilter#empty()}.
   *
   * <p>Method under test: {@link AlarmStatusFilter#empty()}
   */
  @Test
  @DisplayName("Test empty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmStatusFilter AlarmStatusFilter.empty()"})
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
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#hasAnyFilter()}
   */
  @Test
  @DisplayName("Test hasAnyFilter(); given empty; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmStatusFilter.hasAnyFilter()"})
  void testHasAnyFilter_givenEmpty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AlarmStatusFilter.empty().hasAnyFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#hasAnyFilter()}.
   *
   * <ul>
   *   <li>Given from {@code ACK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#hasAnyFilter()}
   */
  @Test
  @DisplayName("Test hasAnyFilter(); given from 'ACK'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmStatusFilter.hasAnyFilter()"})
  void testHasAnyFilter_givenFromAck_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AlarmStatusFilter.from(AlarmSearchStatus.ACK).hasAnyFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#hasAnyFilter()}.
   *
   * <ul>
   *   <li>Given from {@code ACTIVE_UNACK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#hasAnyFilter()}
   */
  @Test
  @DisplayName("Test hasAnyFilter(); given from 'ACTIVE_UNACK'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmStatusFilter.hasAnyFilter()"})
  void testHasAnyFilter_givenFromActiveUnack_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK).hasAnyFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#hasClearFilter()}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#hasClearFilter()}
   */
  @Test
  @DisplayName("Test hasClearFilter(); given empty; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmStatusFilter.hasClearFilter()"})
  void testHasClearFilter_givenEmpty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AlarmStatusFilter.empty().hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#hasClearFilter()}.
   *
   * <ul>
   *   <li>Given from {@code ACTIVE_UNACK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#hasClearFilter()}
   */
  @Test
  @DisplayName("Test hasClearFilter(); given from 'ACTIVE_UNACK'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmStatusFilter.hasClearFilter()"})
  void testHasClearFilter_givenFromActiveUnack_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK).hasClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#hasAckFilter()}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#hasAckFilter()}
   */
  @Test
  @DisplayName("Test hasAckFilter(); given empty; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmStatusFilter.hasAckFilter()"})
  void testHasAckFilter_givenEmpty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AlarmStatusFilter.empty().hasAckFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#hasAckFilter()}.
   *
   * <ul>
   *   <li>Given from {@code ACTIVE_UNACK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#hasAckFilter()}
   */
  @Test
  @DisplayName("Test hasAckFilter(); given from 'ACTIVE_UNACK'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmStatusFilter.hasAckFilter()"})
  void testHasAckFilter_givenFromActiveUnack_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK).hasAckFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#getClearFilter()}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#getClearFilter()}
   */
  @Test
  @DisplayName("Test getClearFilter(); given empty; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmStatusFilter.getClearFilter()"})
  void testGetClearFilter_givenEmpty_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> AlarmStatusFilter.empty().getClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#getClearFilter()}.
   *
   * <ul>
   *   <li>Given from {@code ACTIVE_UNACK}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#getClearFilter()}
   */
  @Test
  @DisplayName("Test getClearFilter(); given from 'ACTIVE_UNACK'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmStatusFilter.getClearFilter()"})
  void testGetClearFilter_givenFromActiveUnack_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK).getClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#getClearFilter()}.
   *
   * <ul>
   *   <li>Given from {@code CLEARED_UNACK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#getClearFilter()}
   */
  @Test
  @DisplayName("Test getClearFilter(); given from 'CLEARED_UNACK'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmStatusFilter.getClearFilter()"})
  void testGetClearFilter_givenFromClearedUnack_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AlarmStatusFilter.from(AlarmStatus.CLEARED_UNACK).getClearFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#getAckFilter()}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#getAckFilter()}
   */
  @Test
  @DisplayName("Test getAckFilter(); given empty; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmStatusFilter.getAckFilter()"})
  void testGetAckFilter_givenEmpty_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> AlarmStatusFilter.empty().getAckFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#getAckFilter()}.
   *
   * <ul>
   *   <li>Given from {@code ACTIVE_ACK}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#getAckFilter()}
   */
  @Test
  @DisplayName("Test getAckFilter(); given from 'ACTIVE_ACK'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmStatusFilter.getAckFilter()"})
  void testGetAckFilter_givenFromActiveAck_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AlarmStatusFilter.from(AlarmStatus.ACTIVE_ACK).getAckFilter());
  }

  /**
   * Test {@link AlarmStatusFilter#getAckFilter()}.
   *
   * <ul>
   *   <li>Given from {@code ACTIVE_UNACK}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmStatusFilter#getAckFilter()}
   */
  @Test
  @DisplayName("Test getAckFilter(); given from 'ACTIVE_UNACK'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmStatusFilter.getAckFilter()"})
  void testGetAckFilter_givenFromActiveUnack_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AlarmStatusFilter.from(AlarmStatus.ACTIVE_UNACK).getAckFilter());
  }
}
