package org.thingsboard.server.common.data.housekeeper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;

class AlarmsUnassignHousekeeperTaskDiffblueTest {
  /**
   * Test {@link AlarmsUnassignHousekeeperTask#equals(Object)}, and
   * {@link AlarmsUnassignHousekeeperTask#hashCode()}.
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
   * Test {@link AlarmsUnassignHousekeeperTask#equals(Object)}, and
   * {@link AlarmsUnassignHousekeeperTask#hashCode()}.
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
   * Test {@link AlarmsUnassignHousekeeperTask#equals(Object)}, and
   * {@link AlarmsUnassignHousekeeperTask#hashCode()}.
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
   * Test {@link AlarmsUnassignHousekeeperTask#equals(Object)}, and
   * {@link AlarmsUnassignHousekeeperTask#hashCode()}.
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
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmsUnassignHousekeeperTask(), 1);
    assertNotEquals(new AlarmsUnassignHousekeeperTask(), mock(AlarmsDeletionHousekeeperTask.class));
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
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmsUnassignHousekeeperTask actualAlarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    ArrayList<UUID> alarms = new ArrayList<>();
    actualAlarmsUnassignHousekeeperTask.setAlarms(alarms);
    actualAlarmsUnassignHousekeeperTask.setUserTitle("Dr");
    String actualToStringResult = actualAlarmsUnassignHousekeeperTask.toString();
    List<UUID> actualAlarms = actualAlarmsUnassignHousekeeperTask.getAlarms();

    // Assert that nothing has changed
    assertEquals(
        "AlarmsUnassignHousekeeperTask(super=HousekeeperTask(tenantId=null, entityId=null, taskType=null, ts=0),"
            + " userTitle=Dr, alarms=[])",
        actualToStringResult);
    assertEquals("Dr", actualAlarmsUnassignHousekeeperTask.getUserTitle());
    assertEquals(0L, actualAlarmsUnassignHousekeeperTask.getTs());
    assertTrue(actualAlarms.isEmpty());
    assertSame(alarms, actualAlarms);
  }

  /**
   * Test
   * {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask(User)}.
   * <p>
   * Method under test:
   * {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask(User)}
   */
  @Test
  @DisplayName("Test new AlarmsUnassignHousekeeperTask(User)")
  void testNewAlarmsUnassignHousekeeperTask() {
    // Arrange
    User user = mock(User.class);
    when(user.getTitle()).thenReturn("Dr");
    when(user.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    UserId userId = new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(user.getId()).thenReturn(userId);

    // Act
    AlarmsUnassignHousekeeperTask actualAlarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask(user);

    // Assert
    verify(user).getId();
    verify(user).getTenantId();
    verify(user).getTitle();
    TenantId tenantId = actualAlarmsUnassignHousekeeperTask.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Dr", actualAlarmsUnassignHousekeeperTask.getUserTitle());
    assertEquals("alarms unassigning for user 784f394c-42b6-435a-983c-b7beff2784f9",
        actualAlarmsUnassignHousekeeperTask.getDescription());
    assertNull(actualAlarmsUnassignHousekeeperTask.getAlarms());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(HousekeeperTaskType.UNASSIGN_ALARMS, actualAlarmsUnassignHousekeeperTask.getTaskType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(userId, actualAlarmsUnassignHousekeeperTask.getEntityId());
  }

  /**
   * Test
   * {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List)}.
   * <ul>
   *   <li>Then return Alarms is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List)}
   */
  @Test
  @DisplayName("Test new AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List); then return Alarms is ArrayList()")
  void testNewAlarmsUnassignHousekeeperTask_thenReturnAlarmsIsArrayList() {
    // Arrange
    UserId userId = new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<UUID> alarms = new ArrayList<>();
    alarms.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AlarmsUnassignHousekeeperTask actualAlarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask(
        TenantId.SYS_TENANT_ID, userId, "Dr", alarms);

    // Assert
    assertEquals("alarms unassigning for user 784f394c-42b6-435a-983c-b7beff2784f9 ([784f394c-42b6-435a-983c"
        + "-b7beff2784f9])", actualAlarmsUnassignHousekeeperTask.getDescription());
    assertSame(alarms, actualAlarmsUnassignHousekeeperTask.getAlarms());
  }

  /**
   * Test
   * {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List)}.
   * <ul>
   *   <li>Then return Alarms size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List)}
   */
  @Test
  @DisplayName("Test new AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List); then return Alarms size is two")
  void testNewAlarmsUnassignHousekeeperTask_thenReturnAlarmsSizeIsTwo() {
    // Arrange
    UserId userId = new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<UUID> alarms = new ArrayList<>();
    alarms.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarms.add(fromStringResult);

    // Act
    AlarmsUnassignHousekeeperTask actualAlarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask(
        TenantId.SYS_TENANT_ID, userId, "Dr", alarms);

    // Assert
    List<UUID> alarms2 = actualAlarmsUnassignHousekeeperTask.getAlarms();
    assertEquals(2, alarms2.size());
    UUID getResult = alarms2.get(1);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", getResult.toString());
    assertEquals(
        "alarms unassigning for user 784f394c-42b6-435a-983c-b7beff2784f9 ([784f394c-42b6-435a-983c-b7beff2784f9,"
            + " 784f394c-42b6-435a-983c-b7beff2784f9])",
        actualAlarmsUnassignHousekeeperTask.getDescription());
    assertSame(fromStringResult, getResult);
  }

  /**
   * Test
   * {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List)}.
   * <ul>
   *   <li>Then return UserTitle is {@code Dr}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List)}
   */
  @Test
  @DisplayName("Test new AlarmsUnassignHousekeeperTask(TenantId, UserId, String, List); then return UserTitle is 'Dr'")
  void testNewAlarmsUnassignHousekeeperTask_thenReturnUserTitleIsDr() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    UserId userId = new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AlarmsUnassignHousekeeperTask actualAlarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask(tenantId,
        userId, "Dr", new ArrayList<>());

    // Assert
    assertEquals("Dr", actualAlarmsUnassignHousekeeperTask.getUserTitle());
    assertEquals("alarms unassigning for user 784f394c-42b6-435a-983c-b7beff2784f9 ([])",
        actualAlarmsUnassignHousekeeperTask.getDescription());
    assertEquals(HousekeeperTaskType.UNASSIGN_ALARMS, actualAlarmsUnassignHousekeeperTask.getTaskType());
    assertTrue(actualAlarmsUnassignHousekeeperTask.getAlarms().isEmpty());
    assertSame(userId, actualAlarmsUnassignHousekeeperTask.getEntityId());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualAlarmsUnassignHousekeeperTask.getTenantId());
  }

  /**
   * Test {@link AlarmsUnassignHousekeeperTask#getDescription()}.
   * <p>
   * Method under test: {@link AlarmsUnassignHousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
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
