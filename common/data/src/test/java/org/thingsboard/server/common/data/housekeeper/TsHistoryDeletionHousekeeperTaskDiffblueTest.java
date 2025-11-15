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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class TsHistoryDeletionHousekeeperTaskDiffblueTest {
  /**
   * Method under test: {@link TsHistoryDeletionHousekeeperTask#getDescription()}
   */
  @Test
  void testGetDescription() {
    // Arrange, Act and Assert
    assertEquals("timeseries history deletion for tenant 13814000-1dd2-11b2-8080-808080808080 for key 'Key'",
        (new TsHistoryDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Key")).getDescription());
    assertEquals("timeseries history deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        (new TsHistoryDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, null)).getDescription());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TsHistoryDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link TsHistoryDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsHistoryDeletionHousekeeperTask tsHistoryDeletionHousekeeperTask = new TsHistoryDeletionHousekeeperTask();
    TsHistoryDeletionHousekeeperTask tsHistoryDeletionHousekeeperTask2 = new TsHistoryDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(tsHistoryDeletionHousekeeperTask, tsHistoryDeletionHousekeeperTask2);
    int expectedHashCodeResult = tsHistoryDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, tsHistoryDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TsHistoryDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link TsHistoryDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TsHistoryDeletionHousekeeperTask tsHistoryDeletionHousekeeperTask = new TsHistoryDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Key");
    TsHistoryDeletionHousekeeperTask tsHistoryDeletionHousekeeperTask2 = new TsHistoryDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Key");

    // Act and Assert
    assertEquals(tsHistoryDeletionHousekeeperTask, tsHistoryDeletionHousekeeperTask2);
    int expectedHashCodeResult = tsHistoryDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, tsHistoryDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TsHistoryDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link TsHistoryDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsHistoryDeletionHousekeeperTask tsHistoryDeletionHousekeeperTask = new TsHistoryDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(tsHistoryDeletionHousekeeperTask, tsHistoryDeletionHousekeeperTask);
    int expectedHashCodeResult = tsHistoryDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, tsHistoryDeletionHousekeeperTask.hashCode());
  }

  /**
   * Method under test: {@link TsHistoryDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsHistoryDeletionHousekeeperTask tsHistoryDeletionHousekeeperTask = new TsHistoryDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Key");

    // Act and Assert
    assertNotEquals(tsHistoryDeletionHousekeeperTask, new TsHistoryDeletionHousekeeperTask());
  }

  /**
   * Method under test: {@link TsHistoryDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TsHistoryDeletionHousekeeperTask(), mock(AlarmsDeletionHousekeeperTask.class));
  }

  /**
   * Method under test: {@link TsHistoryDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TsHistoryDeletionHousekeeperTask tsHistoryDeletionHousekeeperTask = new TsHistoryDeletionHousekeeperTask();
    tsHistoryDeletionHousekeeperTask.setKey("Key");

    // Act and Assert
    assertNotEquals(tsHistoryDeletionHousekeeperTask, new TsHistoryDeletionHousekeeperTask());
  }

  /**
   * Method under test: {@link TsHistoryDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TsHistoryDeletionHousekeeperTask tsHistoryDeletionHousekeeperTask = new TsHistoryDeletionHousekeeperTask();

    TsHistoryDeletionHousekeeperTask tsHistoryDeletionHousekeeperTask2 = new TsHistoryDeletionHousekeeperTask();
    tsHistoryDeletionHousekeeperTask2.setKey("Key");

    // Act and Assert
    assertNotEquals(tsHistoryDeletionHousekeeperTask, tsHistoryDeletionHousekeeperTask2);
  }

  /**
   * Method under test: {@link TsHistoryDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsHistoryDeletionHousekeeperTask(), null);
  }

  /**
   * Method under test: {@link TsHistoryDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsHistoryDeletionHousekeeperTask(), "Different type to TsHistoryDeletionHousekeeperTask");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TsHistoryDeletionHousekeeperTask#TsHistoryDeletionHousekeeperTask()}
   *   <li>{@link TsHistoryDeletionHousekeeperTask#setKey(String)}
   *   <li>{@link TsHistoryDeletionHousekeeperTask#toString()}
   *   <li>{@link TsHistoryDeletionHousekeeperTask#getKey()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TsHistoryDeletionHousekeeperTask actualTsHistoryDeletionHousekeeperTask = new TsHistoryDeletionHousekeeperTask();
    actualTsHistoryDeletionHousekeeperTask.setKey("Key");
    String actualToStringResult = actualTsHistoryDeletionHousekeeperTask.toString();

    // Assert that nothing has changed
    assertEquals("Key", actualTsHistoryDeletionHousekeeperTask.getKey());
    assertEquals("TsHistoryDeletionHousekeeperTask(super=HousekeeperTask(tenantId=null, entityId=null, taskType=null,"
        + " ts=0), key=Key)", actualToStringResult);
    assertEquals(0L, actualTsHistoryDeletionHousekeeperTask.getTs());
  }

  /**
   * Method under test:
   * {@link TsHistoryDeletionHousekeeperTask#TsHistoryDeletionHousekeeperTask(TenantId, EntityId, String)}
   */
  @Test
  void testNewTsHistoryDeletionHousekeeperTask() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    TsHistoryDeletionHousekeeperTask actualTsHistoryDeletionHousekeeperTask = new TsHistoryDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, entityId, "Key");

    // Assert
    assertEquals("Key", actualTsHistoryDeletionHousekeeperTask.getKey());
    assertEquals("timeseries history deletion for tenant 13814000-1dd2-11b2-8080-808080808080 for key 'Key'",
        actualTsHistoryDeletionHousekeeperTask.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_TS_HISTORY, actualTsHistoryDeletionHousekeeperTask.getTaskType());
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualTsHistoryDeletionHousekeeperTask.getEntityId());
    assertSame(tenantId, actualTsHistoryDeletionHousekeeperTask.getTenantId());
  }
}
