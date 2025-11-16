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
package org.thingsboard.server.common.data.housekeeper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;

class HousekeeperTaskDiffblueTest {
  /**
   * Test {@link HousekeeperTask#equals(Object)}, and {@link HousekeeperTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HousekeeperTask#equals(Object)}
   *   <li>{@link HousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HousekeeperTask.equals(Object)", "int HousekeeperTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    HousekeeperTask housekeeperTask2 = new HousekeeperTask();

    // Act and Assert
    assertEquals(housekeeperTask, housekeeperTask2);
    assertEquals(housekeeperTask.hashCode(), housekeeperTask2.hashCode());
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}, and {@link HousekeeperTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HousekeeperTask#equals(Object)}
   *   <li>{@link HousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HousekeeperTask.equals(Object)", "int HousekeeperTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();

    // Act and Assert
    assertEquals(housekeeperTask, housekeeperTask);
    int expectedHashCodeResult = housekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, housekeeperTask.hashCode());
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HousekeeperTask.equals(Object)", "int HousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask =
        new AlarmsDeletionHousekeeperTask();

    // Act and Assert
    assertNotEquals(alarmsDeletionHousekeeperTask, new HousekeeperTask());
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HousekeeperTask.equals(Object)", "int HousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();

    // Act and Assert
    assertNotEquals(housekeeperTask, new AlarmsDeletionHousekeeperTask());
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HousekeeperTask.equals(Object)", "int HousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();

    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask =
        mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(1L);
    when(alarmsDeletionHousekeeperTask.getTaskType())
        .thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HousekeeperTask.equals(Object)", "int HousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    housekeeperTask.setTs(1L);

    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask =
        mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(1L);
    when(alarmsDeletionHousekeeperTask.getTaskType())
        .thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HousekeeperTask.equals(Object)", "int HousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    housekeeperTask.setTs(1L);

    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask =
        mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(1L);
    when(alarmsDeletionHousekeeperTask.getTaskType())
        .thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HousekeeperTask.equals(Object)", "int HousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask =
        new AlarmsDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID);
    alarmsDeletionHousekeeperTask.setTs(1L);

    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask2 =
        mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask2.getTs()).thenReturn(1L);
    when(alarmsDeletionHousekeeperTask2.getTaskType())
        .thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask2.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask2.getTenantId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(alarmsDeletionHousekeeperTask, alarmsDeletionHousekeeperTask2);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HousekeeperTask.equals(Object)", "int HousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    housekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    housekeeperTask.setTs(1L);

    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask =
        mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(1L);
    when(alarmsDeletionHousekeeperTask.getTaskType())
        .thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HousekeeperTask.equals(Object)", "int HousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    housekeeperTask.setEntityId(new AlarmId(EntityId.NULL_UUID));
    housekeeperTask.setTs(1L);

    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask =
        mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(1L);
    when(alarmsDeletionHousekeeperTask.getTaskType())
        .thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HousekeeperTask.equals(Object)", "int HousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    housekeeperTask.setTenantId(TenantId.SYS_TENANT_ID);
    housekeeperTask.setTs(1L);

    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask =
        mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(1L);
    when(alarmsDeletionHousekeeperTask.getTaskType())
        .thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HousekeeperTask.equals(Object)", "int HousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask =
        new AlarmsDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID);
    alarmsDeletionHousekeeperTask.setTs(1L);

    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask2 =
        mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask2.getTs()).thenReturn(1L);
    when(alarmsDeletionHousekeeperTask2.getTaskType())
        .thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask2.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(alarmsDeletionHousekeeperTask, alarmsDeletionHousekeeperTask2);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HousekeeperTask.equals(Object)", "int HousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask =
        new AlarmsDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID);
    alarmsDeletionHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_ATTRIBUTES);
    alarmsDeletionHousekeeperTask.setTs(1L);

    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask2 =
        mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask2.getAlarms()).thenReturn(new ArrayList<>());
    when(alarmsDeletionHousekeeperTask2.getTs()).thenReturn(1L);
    when(alarmsDeletionHousekeeperTask2.getTaskType())
        .thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask2.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask2.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(alarmsDeletionHousekeeperTask, alarmsDeletionHousekeeperTask2);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HousekeeperTask.equals(Object)", "int HousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HousekeeperTask(), null);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HousekeeperTask.equals(Object)", "int HousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HousekeeperTask(), "Different type to HousekeeperTask");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link HousekeeperTask#HousekeeperTask()}
   *   <li>{@link HousekeeperTask#setEntityId(EntityId)}
   *   <li>{@link HousekeeperTask#setTaskType(HousekeeperTaskType)}
   *   <li>{@link HousekeeperTask#setTenantId(TenantId)}
   *   <li>{@link HousekeeperTask#setTs(long)}
   *   <li>{@link HousekeeperTask#toString()}
   *   <li>{@link HousekeeperTask#getEntityId()}
   *   <li>{@link HousekeeperTask#getTaskType()}
   *   <li>{@link HousekeeperTask#getTenantId()}
   *   <li>{@link HousekeeperTask#getTs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HousekeeperTask.<init>()",
    "EntityId HousekeeperTask.getEntityId()",
    "HousekeeperTaskType HousekeeperTask.getTaskType()",
    "TenantId HousekeeperTask.getTenantId()",
    "long HousekeeperTask.getTs()",
    "void HousekeeperTask.setEntityId(EntityId)",
    "void HousekeeperTask.setTaskType(HousekeeperTaskType)",
    "void HousekeeperTask.setTenantId(TenantId)",
    "void HousekeeperTask.setTs(long)",
    "String HousekeeperTask.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    HousekeeperTask actualHousekeeperTask = new HousekeeperTask();
    actualHousekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    actualHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_ATTRIBUTES);
    actualHousekeeperTask.setTenantId(TenantId.SYS_TENANT_ID);
    actualHousekeeperTask.setTs(1L);
    String actualToStringResult = actualHousekeeperTask.toString();
    EntityId actualEntityId = actualHousekeeperTask.getEntityId();
    HousekeeperTaskType actualTaskType = actualHousekeeperTask.getTaskType();
    TenantId actualTenantId = actualHousekeeperTask.getTenantId();

    // Assert
    assertEquals(
        "HousekeeperTask(tenantId=13814000-1dd2-11b2-8080-808080808080, entityId=13814000-1dd2-11b2-8080-808080808080,"
            + " taskType=DELETE_ATTRIBUTES, ts=1)",
        actualToStringResult);
    assertEquals(1L, actualHousekeeperTask.getTs());
    assertEquals(HousekeeperTaskType.DELETE_ATTRIBUTES, actualTaskType);
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualEntityId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link HousekeeperTask#HousekeeperTask(TenantId, EntityId, HousekeeperTaskType)}.
   *
   * <p>Method under test: {@link HousekeeperTask#HousekeeperTask(TenantId, EntityId,
   * HousekeeperTaskType)}
   */
  @Test
  @DisplayName("Test new HousekeeperTask(TenantId, EntityId, HousekeeperTaskType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HousekeeperTask.<init>(TenantId, EntityId, HousekeeperTaskType)"})
  void testNewHousekeeperTask() {
    // Arrange and Act
    HousekeeperTask actualHousekeeperTask =
        new HousekeeperTask(
            TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, HousekeeperTaskType.DELETE_ATTRIBUTES);

    // Assert
    assertEquals(
        "attributes deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        actualHousekeeperTask.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_ATTRIBUTES, actualHousekeeperTask.getTaskType());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualHousekeeperTask.getEntityId());
    assertSame(tenantId, actualHousekeeperTask.getTenantId());
  }

  /**
   * Test {@link HousekeeperTask#deleteAttributes(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link HousekeeperTask#deleteAttributes(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test deleteAttributes(TenantId, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HousekeeperTask HousekeeperTask.deleteAttributes(TenantId, EntityId)"})
  void testDeleteAttributes() {
    // Arrange and Act
    HousekeeperTask actualDeleteAttributesResult =
        HousekeeperTask.deleteAttributes(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID);

    // Assert
    assertEquals(
        "attributes deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        actualDeleteAttributesResult.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_ATTRIBUTES, actualDeleteAttributesResult.getTaskType());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualDeleteAttributesResult.getEntityId());
    assertSame(tenantId, actualDeleteAttributesResult.getTenantId());
  }

  /**
   * Test {@link HousekeeperTask#deleteTelemetry(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link HousekeeperTask#deleteTelemetry(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test deleteTelemetry(TenantId, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HousekeeperTask HousekeeperTask.deleteTelemetry(TenantId, EntityId)"})
  void testDeleteTelemetry() {
    // Arrange and Act
    HousekeeperTask actualDeleteTelemetryResult =
        HousekeeperTask.deleteTelemetry(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID);

    // Assert
    assertEquals(
        "telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        actualDeleteTelemetryResult.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_TELEMETRY, actualDeleteTelemetryResult.getTaskType());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualDeleteTelemetryResult.getEntityId());
    assertSame(tenantId, actualDeleteTelemetryResult.getTenantId());
  }

  /**
   * Test {@link HousekeeperTask#deleteEvents(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link HousekeeperTask#deleteEvents(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test deleteEvents(TenantId, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HousekeeperTask HousekeeperTask.deleteEvents(TenantId, EntityId)"})
  void testDeleteEvents() {
    // Arrange and Act
    HousekeeperTask actualDeleteEventsResult =
        HousekeeperTask.deleteEvents(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID);

    // Assert
    assertEquals(
        "events deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        actualDeleteEventsResult.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_EVENTS, actualDeleteEventsResult.getTaskType());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualDeleteEventsResult.getEntityId());
    assertSame(tenantId, actualDeleteEventsResult.getTenantId());
  }

  /**
   * Test {@link HousekeeperTask#unassignAlarms(User)}.
   *
   * <ul>
   *   <li>Given {@code not empty}.
   *   <li>Then return {@link AlarmsUnassignHousekeeperTask}.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#unassignAlarms(User)}
   */
  @Test
  @DisplayName(
      "Test unassignAlarms(User); given 'not empty'; then return AlarmsUnassignHousekeeperTask")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HousekeeperTask HousekeeperTask.unassignAlarms(User)"})
  void testUnassignAlarms_givenNotEmpty_thenReturnAlarmsUnassignHousekeeperTask() {
    // Arrange
    UserId id = new UserId(EntityId.NULL_UUID);

    User user = new User(id);
    user.setFirstName("not empty");
    user.setLastName("not empty");
    user.setTenantId(TenantId.SYS_TENANT_ID);

    // Act
    HousekeeperTask actualUnassignAlarmsResult = HousekeeperTask.unassignAlarms(user);

    // Assert
    assertTrue(actualUnassignAlarmsResult instanceof AlarmsUnassignHousekeeperTask);
    assertEquals(
        "alarms unassigning for user 13814000-1dd2-11b2-8080-808080808080",
        actualUnassignAlarmsResult.getDescription());
    assertEquals(
        "not empty not empty",
        ((AlarmsUnassignHousekeeperTask) actualUnassignAlarmsResult).getUserTitle());
    assertNull(((AlarmsUnassignHousekeeperTask) actualUnassignAlarmsResult).getAlarms());
    TenantId tenantId = actualUnassignAlarmsResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(HousekeeperTaskType.UNASSIGN_ALARMS, actualUnassignAlarmsResult.getTaskType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(id, actualUnassignAlarmsResult.getEntityId());
  }

  /**
   * Test {@link HousekeeperTask#deleteAlarms(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.
   *   <li>Then return {@link AlarmsDeletionHousekeeperTask}.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#deleteAlarms(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test deleteAlarms(TenantId, EntityId); when SYS_TENANT_ID; then return AlarmsDeletionHousekeeperTask")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HousekeeperTask HousekeeperTask.deleteAlarms(TenantId, EntityId)"})
  void testDeleteAlarms_whenSys_tenant_id_thenReturnAlarmsDeletionHousekeeperTask() {
    // Arrange and Act
    HousekeeperTask actualDeleteAlarmsResult =
        HousekeeperTask.deleteAlarms(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID);

    // Assert
    assertTrue(actualDeleteAlarmsResult instanceof AlarmsDeletionHousekeeperTask);
    assertEquals(
        "alarms deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        actualDeleteAlarmsResult.getDescription());
    assertNull(((AlarmsDeletionHousekeeperTask) actualDeleteAlarmsResult).getAlarms());
    assertEquals(HousekeeperTaskType.DELETE_ALARMS, actualDeleteAlarmsResult.getTaskType());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualDeleteAlarmsResult.getEntityId());
    assertSame(tenantId, actualDeleteAlarmsResult.getTenantId());
  }

  /**
   * Test {@link HousekeeperTask#deleteTenantEntities(TenantId, EntityType)}.
   *
   * <ul>
   *   <li>Then return {@link TenantEntitiesDeletionHousekeeperTask}.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#deleteTenantEntities(TenantId, EntityType)}
   */
  @Test
  @DisplayName(
      "Test deleteTenantEntities(TenantId, EntityType); then return TenantEntitiesDeletionHousekeeperTask")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"HousekeeperTask HousekeeperTask.deleteTenantEntities(TenantId, EntityType)"})
  void testDeleteTenantEntities_thenReturnTenantEntitiesDeletionHousekeeperTask() {
    // Arrange and Act
    HousekeeperTask actualDeleteTenantEntitiesResult =
        HousekeeperTask.deleteTenantEntities(TenantId.SYS_TENANT_ID, EntityType.TENANT);

    // Assert
    assertTrue(actualDeleteTenantEntitiesResult instanceof TenantEntitiesDeletionHousekeeperTask);
    assertEquals("tenants deletion", actualDeleteTenantEntitiesResult.getDescription());
    assertEquals(
        EntityType.TENANT,
        ((TenantEntitiesDeletionHousekeeperTask) actualDeleteTenantEntitiesResult).getEntityType());
    assertEquals(
        HousekeeperTaskType.DELETE_TENANT_ENTITIES, actualDeleteTenantEntitiesResult.getTaskType());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualDeleteTenantEntitiesResult.getEntityId());
    assertSame(tenantId, actualDeleteTenantEntitiesResult.getTenantId());
  }

  /**
   * Test {@link HousekeeperTask#getDescription()}.
   *
   * <p>Method under test: {@link HousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HousekeeperTask.getDescription()"})
  void testGetDescription() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask =
        new AlarmsDeletionHousekeeperTask();
    alarmsDeletionHousekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    alarmsDeletionHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_TELEMETRY);

    // Act and Assert
    assertEquals(
        "telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        alarmsDeletionHousekeeperTask.getDescription());
  }

  /**
   * Test {@link HousekeeperTask#getDescription()}.
   *
   * <p>Method under test: {@link HousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HousekeeperTask.getDescription()"})
  void testGetDescription2() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask =
        new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    alarmsUnassignHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_TELEMETRY);

    // Act and Assert
    assertEquals(
        "telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        alarmsUnassignHousekeeperTask.getDescription());
  }

  /**
   * Test {@link HousekeeperTask#getDescription()}.
   *
   * <p>Method under test: {@link HousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HousekeeperTask.getDescription()"})
  void testGetDescription3() {
    // Arrange
    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask =
        new LatestTsDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Key");
    latestTsDeletionHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_TELEMETRY);

    // Act and Assert
    assertEquals(
        "telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080 for key 'Key'",
        latestTsDeletionHousekeeperTask.getDescription());
  }

  /**
   * Test {@link HousekeeperTask#getDescription()}.
   *
   * <ul>
   *   <li>Given {@link AlarmsDeletionHousekeeperTask#AlarmsDeletionHousekeeperTask()} Alarms is
   *       {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); given AlarmsDeletionHousekeeperTask() Alarms is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HousekeeperTask.getDescription()"})
  void testGetDescription_givenAlarmsDeletionHousekeeperTaskAlarmsIsArrayList() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask =
        new AlarmsDeletionHousekeeperTask();
    alarmsDeletionHousekeeperTask.setAlarms(new ArrayList<>());
    alarmsDeletionHousekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    alarmsDeletionHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_TELEMETRY);

    // Act and Assert
    assertEquals(
        "telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080 ([])",
        alarmsDeletionHousekeeperTask.getDescription());
  }

  /**
   * Test {@link HousekeeperTask#getDescription()}.
   *
   * <ul>
   *   <li>Given {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask()} Alarms is
   *       {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); given AlarmsUnassignHousekeeperTask() Alarms is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HousekeeperTask.getDescription()"})
  void testGetDescription_givenAlarmsUnassignHousekeeperTaskAlarmsIsArrayList() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask =
        new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setAlarms(new ArrayList<>());
    alarmsUnassignHousekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    alarmsUnassignHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_TELEMETRY);

    // Act and Assert
    assertEquals(
        "telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080 ([])",
        alarmsUnassignHousekeeperTask.getDescription());
  }

  /**
   * Test {@link HousekeeperTask#getDescription()}.
   *
   * <ul>
   *   <li>Then return {@code tenants deletion}.
   * </ul>
   *
   * <p>Method under test: {@link HousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); then return 'tenants deletion'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String HousekeeperTask.getDescription()"})
  void testGetDescription_thenReturnTenantsDeletion() {
    // Arrange
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask =
        new TenantEntitiesDeletionHousekeeperTask();
    tenantEntitiesDeletionHousekeeperTask.setEntityType(EntityType.TENANT);
    tenantEntitiesDeletionHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_TELEMETRY);

    // Act and Assert
    assertEquals("tenants deletion", tenantEntitiesDeletionHousekeeperTask.getDescription());
  }
}
