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

class AlarmsDeletionHousekeeperTaskDiffblueTest {
  /**
   * Test {@link AlarmsDeletionHousekeeperTask#equals(Object)}, and {@link AlarmsDeletionHousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmsDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link AlarmsDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsDeletionHousekeeperTask.equals(Object)",
      "int AlarmsDeletionHousekeeperTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask();
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask2 = new AlarmsDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(alarmsDeletionHousekeeperTask, alarmsDeletionHousekeeperTask2);
    int expectedHashCodeResult = alarmsDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, alarmsDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Test {@link AlarmsDeletionHousekeeperTask#equals(Object)}, and {@link AlarmsDeletionHousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmsDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link AlarmsDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsDeletionHousekeeperTask.equals(Object)",
      "int AlarmsDeletionHousekeeperTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, new ArrayList<>());
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask2 = new AlarmsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, new ArrayList<>());

    // Act and Assert
    assertEquals(alarmsDeletionHousekeeperTask, alarmsDeletionHousekeeperTask2);
    int expectedHashCodeResult = alarmsDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, alarmsDeletionHousekeeperTask2.hashCode());
  }

  /**
   * Test {@link AlarmsDeletionHousekeeperTask#equals(Object)}, and {@link AlarmsDeletionHousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmsDeletionHousekeeperTask#equals(Object)}
   *   <li>{@link AlarmsDeletionHousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsDeletionHousekeeperTask.equals(Object)",
      "int AlarmsDeletionHousekeeperTask.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask();

    // Act and Assert
    assertEquals(alarmsDeletionHousekeeperTask, alarmsDeletionHousekeeperTask);
    int expectedHashCodeResult = alarmsDeletionHousekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, alarmsDeletionHousekeeperTask.hashCode());
  }

  /**
   * Test {@link AlarmsDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsDeletionHousekeeperTask.equals(Object)",
      "int AlarmsDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(alarmsDeletionHousekeeperTask, new AlarmsDeletionHousekeeperTask());
  }

  /**
   * Test {@link AlarmsDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsDeletionHousekeeperTask.equals(Object)",
      "int AlarmsDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask();
    alarmsDeletionHousekeeperTask.setAlarms(new ArrayList<>());

    // Act and Assert
    assertNotEquals(alarmsDeletionHousekeeperTask, new AlarmsDeletionHousekeeperTask());
  }

  /**
   * Test {@link AlarmsDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsDeletionHousekeeperTask.equals(Object)",
      "int AlarmsDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(alarmsDeletionHousekeeperTask,
        new AlarmsDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, new ArrayList<>()));
  }

  /**
   * Test {@link AlarmsDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsDeletionHousekeeperTask.equals(Object)",
      "int AlarmsDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmsDeletionHousekeeperTask(), null);
  }

  /**
   * Test {@link AlarmsDeletionHousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmsDeletionHousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AlarmsDeletionHousekeeperTask.equals(Object)",
      "int AlarmsDeletionHousekeeperTask.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmsDeletionHousekeeperTask(), "Different type to AlarmsDeletionHousekeeperTask");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmsDeletionHousekeeperTask#AlarmsDeletionHousekeeperTask()}
   *   <li>{@link AlarmsDeletionHousekeeperTask#setAlarms(List)}
   *   <li>{@link AlarmsDeletionHousekeeperTask#toString()}
   *   <li>{@link AlarmsDeletionHousekeeperTask#getAlarms()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmsDeletionHousekeeperTask.<init>()", "List AlarmsDeletionHousekeeperTask.getAlarms()",
      "void AlarmsDeletionHousekeeperTask.setAlarms(List)", "String AlarmsDeletionHousekeeperTask.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmsDeletionHousekeeperTask actualAlarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask();
    ArrayList<UUID> alarms = new ArrayList<>();
    actualAlarmsDeletionHousekeeperTask.setAlarms(alarms);
    String actualToStringResult = actualAlarmsDeletionHousekeeperTask.toString();
    List<UUID> actualAlarms = actualAlarmsDeletionHousekeeperTask.getAlarms();

    // Assert
    assertEquals(
        "AlarmsDeletionHousekeeperTask(super=HousekeeperTask(tenantId=null, entityId=null, taskType=null, ts=0),"
            + " alarms=[])",
        actualToStringResult);
    assertNull(actualAlarmsDeletionHousekeeperTask.getTaskType());
    assertNull(actualAlarmsDeletionHousekeeperTask.getEntityId());
    assertNull(actualAlarmsDeletionHousekeeperTask.getTenantId());
    assertEquals(0L, actualAlarmsDeletionHousekeeperTask.getTs());
    assertTrue(actualAlarms.isEmpty());
    assertSame(alarms, actualAlarms);
  }

  /**
   * Test {@link AlarmsDeletionHousekeeperTask#AlarmsDeletionHousekeeperTask(TenantId, EntityId)}.
   * <p>
   * Method under test: {@link AlarmsDeletionHousekeeperTask#AlarmsDeletionHousekeeperTask(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test new AlarmsDeletionHousekeeperTask(TenantId, EntityId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmsDeletionHousekeeperTask.<init>(TenantId, EntityId)"})
  void testNewAlarmsDeletionHousekeeperTask() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    AlarmsDeletionHousekeeperTask actualAlarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, entityId);

    // Assert
    assertEquals("alarms deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        actualAlarmsDeletionHousekeeperTask.getDescription());
    assertNull(actualAlarmsDeletionHousekeeperTask.getAlarms());
    assertEquals(HousekeeperTaskType.DELETE_ALARMS, actualAlarmsDeletionHousekeeperTask.getTaskType());
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualAlarmsDeletionHousekeeperTask.getEntityId());
    assertSame(tenantId, actualAlarmsDeletionHousekeeperTask.getTenantId());
  }

  /**
   * Test {@link AlarmsDeletionHousekeeperTask#AlarmsDeletionHousekeeperTask(TenantId, EntityId, List)}.
   * <p>
   * Method under test: {@link AlarmsDeletionHousekeeperTask#AlarmsDeletionHousekeeperTask(TenantId, EntityId, List)}
   */
  @Test
  @DisplayName("Test new AlarmsDeletionHousekeeperTask(TenantId, EntityId, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmsDeletionHousekeeperTask.<init>(TenantId, EntityId, List)"})
  void testNewAlarmsDeletionHousekeeperTask2() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    AlarmsDeletionHousekeeperTask actualAlarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, entityId, new ArrayList<>());

    // Assert
    assertEquals("alarms deletion for tenant 13814000-1dd2-11b2-8080-808080808080 ([])",
        actualAlarmsDeletionHousekeeperTask.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_ALARMS, actualAlarmsDeletionHousekeeperTask.getTaskType());
    assertTrue(actualAlarmsDeletionHousekeeperTask.getAlarms().isEmpty());
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualAlarmsDeletionHousekeeperTask.getEntityId());
    assertSame(tenantId, actualAlarmsDeletionHousekeeperTask.getTenantId());
  }

  /**
   * Test {@link AlarmsDeletionHousekeeperTask#AlarmsDeletionHousekeeperTask(TenantId, EntityId, List)}.
   * <ul>
   *   <li>Then return Alarms is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmsDeletionHousekeeperTask#AlarmsDeletionHousekeeperTask(TenantId, EntityId, List)}
   */
  @Test
  @DisplayName("Test new AlarmsDeletionHousekeeperTask(TenantId, EntityId, List); then return Alarms is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmsDeletionHousekeeperTask.<init>(TenantId, EntityId, List)"})
  void testNewAlarmsDeletionHousekeeperTask_thenReturnAlarmsIsArrayList() {
    // Arrange
    ArrayList<UUID> alarms = new ArrayList<>();
    alarms.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AlarmsDeletionHousekeeperTask actualAlarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, alarms);

    // Assert
    assertEquals(
        "alarms deletion for tenant 13814000-1dd2-11b2-8080-808080808080 ([784f394c-42b6-435a-983c" + "-b7beff2784f9])",
        actualAlarmsDeletionHousekeeperTask.getDescription());
    assertSame(alarms, actualAlarmsDeletionHousekeeperTask.getAlarms());
  }

  /**
   * Test {@link AlarmsDeletionHousekeeperTask#AlarmsDeletionHousekeeperTask(TenantId, EntityId, List)}.
   * <ul>
   *   <li>Then return Alarms size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmsDeletionHousekeeperTask#AlarmsDeletionHousekeeperTask(TenantId, EntityId, List)}
   */
  @Test
  @DisplayName("Test new AlarmsDeletionHousekeeperTask(TenantId, EntityId, List); then return Alarms size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmsDeletionHousekeeperTask.<init>(TenantId, EntityId, List)"})
  void testNewAlarmsDeletionHousekeeperTask_thenReturnAlarmsSizeIsTwo() {
    // Arrange
    ArrayList<UUID> alarms = new ArrayList<>();
    alarms.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarms.add(fromStringResult);

    // Act
    AlarmsDeletionHousekeeperTask actualAlarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask(
        TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, alarms);

    // Assert
    List<UUID> alarms2 = actualAlarmsDeletionHousekeeperTask.getAlarms();
    assertEquals(2, alarms2.size());
    UUID getResult = alarms2.get(1);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", getResult.toString());
    assertEquals(
        "alarms deletion for tenant 13814000-1dd2-11b2-8080-808080808080 ([784f394c-42b6-435a-983c-b7beff2784f9,"
            + " 784f394c-42b6-435a-983c-b7beff2784f9])",
        actualAlarmsDeletionHousekeeperTask.getDescription());
    assertSame(fromStringResult, getResult);
  }

  /**
   * Test {@link AlarmsDeletionHousekeeperTask#getDescription()}.
   * <p>
   * Method under test: {@link AlarmsDeletionHousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AlarmsDeletionHousekeeperTask.getDescription()"})
  void testGetDescription() {
    // Arrange, Act and Assert
    assertEquals("alarms deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        (new AlarmsDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID)).getDescription());
  }

  /**
   * Test {@link AlarmsDeletionHousekeeperTask#getDescription()}.
   * <p>
   * Method under test: {@link AlarmsDeletionHousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AlarmsDeletionHousekeeperTask.getDescription()"})
  void testGetDescription2() {
    // Arrange, Act and Assert
    assertEquals("alarms deletion for tenant 13814000-1dd2-11b2-8080-808080808080 ([])",
        (new AlarmsDeletionHousekeeperTask(TenantId.SYS_TENANT_ID, TenantId.SYS_TENANT_ID, new ArrayList<>()))
            .getDescription());
  }
}
