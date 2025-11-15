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

class LatestTsDeletionHousekeeperTaskDiffblueTest {
  /**
   * Method under test: {@link LatestTsDeletionHousekeeperTask#getDescription()}
   */
  @Test
  void testGetDescription() {
    // Arrange, Act and Assert
    assertEquals("latest telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080 for key 'Key'",
        (new LatestTsDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Key")).getDescription());
    assertEquals("latest telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        (new LatestTsDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, null)).getDescription());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LatestTsDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link LatestTsDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask = new LatestTsDeletionHousekeeperTask();
    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask2 = new LatestTsDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(latestTsDeletionHousekeeperTask, latestTsDeletionHousekeeperTask2);
    int expectedHashCodeResult = latestTsDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, latestTsDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LatestTsDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link LatestTsDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask = new LatestTsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Key");
    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask2 = new LatestTsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Key");

    // Act and Assert
    assertEquals(latestTsDeletionHousekeeperTask, latestTsDeletionHousekeeperTask2);
    int expectedHashCodeResult = latestTsDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, latestTsDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LatestTsDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link LatestTsDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask = new LatestTsDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(latestTsDeletionHousekeeperTask, latestTsDeletionHousekeeperTask);
    int expectedHashCodeResult = latestTsDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, latestTsDeletionHousekeeperTask.hashCode());
  }

  /**
   * Method under test: {@link LatestTsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask = new LatestTsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, "Key");

    // Act and Assert
    assertNotEquals(latestTsDeletionHousekeeperTask, new LatestTsDeletionHousekeeperTask());
  }

  /**
   * Method under test: {@link LatestTsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new LatestTsDeletionHousekeeperTask(), mock(AlarmsDeletionHousekeeperTask.class));
  }

  /**
   * Method under test: {@link LatestTsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask = new LatestTsDeletionHousekeeperTask();
    latestTsDeletionHousekeeperTask.setKey("Key");

    // Act and Assert
    assertNotEquals(latestTsDeletionHousekeeperTask, new LatestTsDeletionHousekeeperTask());
  }

  /**
   * Method under test: {@link LatestTsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask = new LatestTsDeletionHousekeeperTask();

    LatestTsDeletionHousekeeperTask latestTsDeletionHousekeeperTask2 = new LatestTsDeletionHousekeeperTask();
    latestTsDeletionHousekeeperTask2.setKey("Key");

    // Act and Assert
    assertNotEquals(latestTsDeletionHousekeeperTask, latestTsDeletionHousekeeperTask2);
  }

  /**
   * Method under test: {@link LatestTsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LatestTsDeletionHousekeeperTask(), null);
  }

  /**
   * Method under test: {@link LatestTsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LatestTsDeletionHousekeeperTask(), "Different type to LatestTsDeletionHousekeeperTask");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LatestTsDeletionHousekeeperTask#LatestTsDeletionHousekeeperTask()}
   *   <li>{@link LatestTsDeletionHousekeeperTask#setKey(String)}
   *   <li>{@link LatestTsDeletionHousekeeperTask#toString()}
   *   <li>{@link LatestTsDeletionHousekeeperTask#getKey()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    LatestTsDeletionHousekeeperTask actualLatestTsDeletionHousekeeperTask = new LatestTsDeletionHousekeeperTask();
    actualLatestTsDeletionHousekeeperTask.setKey("Key");
    String actualToStringResult = actualLatestTsDeletionHousekeeperTask.toString();

    // Assert that nothing has changed
    assertEquals("Key", actualLatestTsDeletionHousekeeperTask.getKey());
    assertEquals("LatestTsDeletionHousekeeperTask(super=HousekeeperTask(tenantId=null, entityId=null, taskType=null,"
        + " ts=0), key=Key)", actualToStringResult);
    assertEquals(0L, actualLatestTsDeletionHousekeeperTask.getTs());
  }

  /**
   * Method under test:
   * {@link LatestTsDeletionHousekeeperTask#LatestTsDeletionHousekeeperTask(TenantId, EntityId, String)}
   */
  @Test
  void testNewLatestTsDeletionHousekeeperTask() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    LatestTsDeletionHousekeeperTask actualLatestTsDeletionHousekeeperTask = new LatestTsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, entityId, "Key");

    // Assert
    assertEquals("Key", actualLatestTsDeletionHousekeeperTask.getKey());
    assertEquals("latest telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080 for key 'Key'",
        actualLatestTsDeletionHousekeeperTask.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_LATEST_TS, actualLatestTsDeletionHousekeeperTask.getTaskType());
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualLatestTsDeletionHousekeeperTask.getEntityId());
    assertSame(tenantId, actualLatestTsDeletionHousekeeperTask.getTenantId());
  }
}
