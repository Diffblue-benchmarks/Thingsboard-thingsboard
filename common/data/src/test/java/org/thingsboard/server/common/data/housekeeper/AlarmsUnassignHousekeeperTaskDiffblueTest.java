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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;

class AlarmsUnassignHousekeeperTaskDiffblueTest {
  /**
   * Test {@link AlarmsUnassignHousekeeperTask#equals(Object)}, and {@link AlarmsUnassignHousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmsUnassignHousekeeperTask#equals(Object)}
   *   <li>{@link AlarmsUnassignHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsUnassignHousekeeperTask.equals(Object)",
      "int AlarmsUnassignHousekeeperTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask2 = new AlarmsUnassignHousekeeperTask();

    // Act and Assert
    assertEquals(alarmsUnassignHousekeeperTask, alarmsUnassignHousekeeperTask2);
    int expectedHashCodeResult = alarmsUnassignHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, alarmsUnassignHousekeeperTask2.hashCode());
  }

  /**
   * Test {@link AlarmsUnassignHousekeeperTask#equals(Object)}, and {@link AlarmsUnassignHousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmsUnassignHousekeeperTask#equals(Object)}
   *   <li>{@link AlarmsUnassignHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsUnassignHousekeeperTask.equals(Object)",
      "int AlarmsUnassignHousekeeperTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setUserTitle("Dr");

    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask2 = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask2.setUserTitle("Dr");

    // Act and Assert
    assertEquals(alarmsUnassignHousekeeperTask, alarmsUnassignHousekeeperTask2);
    int expectedHashCodeResult = alarmsUnassignHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, alarmsUnassignHousekeeperTask2.hashCode());
  }

  /**
   * Test {@link AlarmsUnassignHousekeeperTask#equals(Object)}, and {@link AlarmsUnassignHousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmsUnassignHousekeeperTask#equals(Object)}
   *   <li>{@link AlarmsUnassignHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsUnassignHousekeeperTask.equals(Object)",
      "int AlarmsUnassignHousekeeperTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setAlarms(new ArrayList<>());

    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask2 = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask2.setAlarms(new ArrayList<>());

    // Act and Assert
    assertEquals(alarmsUnassignHousekeeperTask, alarmsUnassignHousekeeperTask2);
    int expectedHashCodeResult = alarmsUnassignHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, alarmsUnassignHousekeeperTask2.hashCode());
  }

  /**
   * Test {@link AlarmsUnassignHousekeeperTask#equals(Object)}, and {@link AlarmsUnassignHousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmsUnassignHousekeeperTask#equals(Object)}
   *   <li>{@link AlarmsUnassignHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsUnassignHousekeeperTask.equals(Object)",
      "int AlarmsUnassignHousekeeperTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();

    // Act and Assert
    assertEquals(alarmsUnassignHousekeeperTask, alarmsUnassignHousekeeperTask);
    int expectedHashCodeResult = alarmsUnassignHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, alarmsUnassignHousekeeperTask.hashCode());
  }

  /**
   * Test {@link AlarmsUnassignHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmsUnassignHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsUnassignHousekeeperTask.equals(Object)",
      "int AlarmsUnassignHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmsUnassignHousekeeperTask(), 1);
  }

  /**
   * Test {@link AlarmsUnassignHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmsUnassignHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsUnassignHousekeeperTask.equals(Object)",
      "int AlarmsUnassignHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setUserTitle("Dr");

    // Act and Assert
    assertNotEquals(alarmsUnassignHousekeeperTask, new AlarmsUnassignHousekeeperTask());
  }

  /**
   * Test {@link AlarmsUnassignHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmsUnassignHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsUnassignHousekeeperTask.equals(Object)",
      "int AlarmsUnassignHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setAlarms(new ArrayList<>());

    // Act and Assert
    assertNotEquals(alarmsUnassignHousekeeperTask, new AlarmsUnassignHousekeeperTask());
  }

  /**
   * Test {@link AlarmsUnassignHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmsUnassignHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsUnassignHousekeeperTask.equals(Object)",
      "int AlarmsUnassignHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(alarmsUnassignHousekeeperTask, new AlarmsUnassignHousekeeperTask());
  }

  /**
   * Test {@link AlarmsUnassignHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmsUnassignHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsUnassignHousekeeperTask.equals(Object)",
      "int AlarmsUnassignHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();

    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask2 = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask2.setUserTitle("Dr");

    // Act and Assert
    assertNotEquals(alarmsUnassignHousekeeperTask, alarmsUnassignHousekeeperTask2);
  }

  /**
   * Test {@link AlarmsUnassignHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmsUnassignHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsUnassignHousekeeperTask.equals(Object)",
      "int AlarmsUnassignHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();

    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask2 = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask2.setAlarms(new ArrayList<>());

    // Act and Assert
    assertNotEquals(alarmsUnassignHousekeeperTask, alarmsUnassignHousekeeperTask2);
  }

  /**
   * Test {@link AlarmsUnassignHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmsUnassignHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsUnassignHousekeeperTask.equals(Object)",
      "int AlarmsUnassignHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmsUnassignHousekeeperTask(), null);
  }

  /**
   * Test {@link AlarmsUnassignHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmsUnassignHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsUnassignHousekeeperTask.equals(Object)",
      "int AlarmsUnassignHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmsUnassignHousekeeperTask(), "Different type to AlarmsUnassignHousekeeperTask");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask()}
   *   <li>{@link AlarmsUnassignHousekeeperTask#setAlarms(List)}
   *   <li>{@link AlarmsUnassignHousekeeperTask#setUserTitle(String)}
   *   <li>{@link AlarmsUnassignHousekeeperTask#toString()}
   *   <li>{@link AlarmsUnassignHousekeeperTask#getAlarms()}
   *   <li>{@link AlarmsUnassignHousekeeperTask#getUserTitle()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmsUnassignHousekeeperTask.<init>()", "List AlarmsUnassignHousekeeperTask.getAlarms()",
      "String AlarmsUnassignHousekeeperTask.getUserTitle()", "void AlarmsUnassignHousekeeperTask.setAlarms(List)",
      "void AlarmsUnassignHousekeeperTask.setUserTitle(String)", "String AlarmsUnassignHousekeeperTask.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmsUnassignHousekeeperTask actualAlarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    ArrayList<UUID> alarms = new ArrayList<>();
    actualAlarmsUnassignHousekeeperTask.setAlarms(alarms);
    actualAlarmsUnassignHousekeeperTask.setUserTitle("Dr");
    String actualToStringResult = actualAlarmsUnassignHousekeeperTask.toString();
    List<UUID> actualAlarms = actualAlarmsUnassignHousekeeperTask.getAlarms();

    // Assert
    assertEquals(
        "AlarmsUnassignHousekeeperTask(super=HousekeeperTask(tenantId=null, entityId=null, taskType=null, ts=0),"
            + " userTitle=Dr, alarms=[])",
        actualToStringResult);
    assertEquals("Dr", actualAlarmsUnassignHousekeeperTask.getUserTitle());
    assertNull(actualAlarmsUnassignHousekeeperTask.getTaskType());
    assertNull(actualAlarmsUnassignHousekeeperTask.getEntityId());
    assertNull(actualAlarmsUnassignHousekeeperTask.getTenantId());
    assertEquals(0L, actualAlarmsUnassignHousekeeperTask.getTs());
    assertTrue(actualAlarms.isEmpty());
    assertSame(alarms, actualAlarms);
  }

  /**
   * Test {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List)}.
   * <p>
   * Method under test: {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List)}
   */
  @Test
  @DisplayName("Test new AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmsUnassignHousekeeperTask.<init>(TenantId, UserId, String, List)"})
  void testNewAlarmsUnassignHousekeeperTask() {
    // Arrange
    UserId userId = new UserId(EntityId.NULL_UUID);

    // Act
    AlarmsUnassignHousekeeperTask actualAlarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask(
        TenantId.SYS_TENANT_ID, userId, "Dr", new ArrayList<>());

    // Assert
    EntityId entityId = actualAlarmsUnassignHousekeeperTask.getEntityId();
    assertTrue(entityId instanceof UserId);
    UUID id = actualAlarmsUnassignHousekeeperTask.getTenantId().getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("alarms unassigning for user 13814000-1dd2-11b2-8080-808080808080 ([])",
        actualAlarmsUnassignHousekeeperTask.getDescription());
    assertTrue(actualAlarmsUnassignHousekeeperTask.getAlarms().isEmpty());
    assertSame(id, entityId.getId());
  }

  /**
   * Test {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List)}.
   * <ul>
   *   <li>Given {@link EntityId#NULL_UUID}.</li>
   *   <li>Then return Alarms size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List)}
   */
  @Test
  @DisplayName("Test new AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List); given NULL_UUID; then return Alarms size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmsUnassignHousekeeperTask.<init>(TenantId, UserId, String, List)"})
  void testNewAlarmsUnassignHousekeeperTask_givenNull_uuid_thenReturnAlarmsSizeIsOne() {
    // Arrange
    UserId userId = new UserId(EntityId.NULL_UUID);

    ArrayList<UUID> alarms = new ArrayList<>();
    alarms.add(EntityId.NULL_UUID);

    // Act
    AlarmsUnassignHousekeeperTask actualAlarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask(
        TenantId.SYS_TENANT_ID, userId, "Dr", alarms);

    // Assert
    EntityId entityId = actualAlarmsUnassignHousekeeperTask.getEntityId();
    assertTrue(entityId instanceof UserId);
    List<UUID> alarms2 = actualAlarmsUnassignHousekeeperTask.getAlarms();
    assertEquals(1, alarms2.size());
    UUID getResult = alarms2.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.toString());
    assertEquals("alarms unassigning for user 13814000-1dd2-11b2-8080-808080808080 ([13814000-1dd2-11b2-8080"
        + "-808080808080])", actualAlarmsUnassignHousekeeperTask.getDescription());
    assertSame(alarms, alarms2);
    assertSame(getResult, entityId.getId());
    assertSame(getResult, actualAlarmsUnassignHousekeeperTask.getTenantId().getId());
  }

  /**
   * Test {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List)}.
   * <ul>
   *   <li>Then return Description is a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List)}
   */
  @Test
  @DisplayName("Test new AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List); then return Description is a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmsUnassignHousekeeperTask.<init>(TenantId, UserId, String, List)"})
  void testNewAlarmsUnassignHousekeeperTask_thenReturnDescriptionIsAString() {
    // Arrange
    UserId userId = new UserId(EntityId.NULL_UUID);

    ArrayList<UUID> alarms = new ArrayList<>();
    alarms.add(EntityId.NULL_UUID);
    alarms.add(EntityId.NULL_UUID);

    // Act
    AlarmsUnassignHousekeeperTask actualAlarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask(
        TenantId.SYS_TENANT_ID, userId, "Dr", alarms);

    // Assert
    assertTrue(actualAlarmsUnassignHousekeeperTask.getEntityId() instanceof UserId);
    assertEquals(
        "alarms unassigning for user 13814000-1dd2-11b2-8080-808080808080 ([13814000-1dd2-11b2-8080-808080808080,"
            + " 13814000-1dd2-11b2-8080-808080808080])",
        actualAlarmsUnassignHousekeeperTask.getDescription());
    assertSame(alarms, actualAlarmsUnassignHousekeeperTask.getAlarms());
  }

  /**
   * Test {@link AlarmsUnassignHousekeeperTask#getDescription()}.
   * <p>
   * Method under test: {@link AlarmsUnassignHousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AlarmsUnassignHousekeeperTask.getDescription()"})
  void testGetDescription() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    alarmsUnassignHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_ATTRIBUTES);

    // Act and Assert
    assertEquals("attributes deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        alarmsUnassignHousekeeperTask.getDescription());
  }

  /**
   * Test {@link AlarmsUnassignHousekeeperTask#getDescription()}.
   * <p>
   * Method under test: {@link AlarmsUnassignHousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AlarmsUnassignHousekeeperTask.getDescription()"})
  void testGetDescription2() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setAlarms(new ArrayList<>());
    alarmsUnassignHousekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    alarmsUnassignHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_ATTRIBUTES);

    // Act and Assert
    assertEquals("attributes deletion for tenant 13814000-1dd2-11b2-8080-808080808080 ([])",
        alarmsUnassignHousekeeperTask.getDescription());
  }
}
