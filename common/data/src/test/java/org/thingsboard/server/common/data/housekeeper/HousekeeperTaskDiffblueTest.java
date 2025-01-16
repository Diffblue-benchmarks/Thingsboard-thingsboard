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
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
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
   * Test {@link HousekeeperTask#equals(Object)}, and
   * {@link HousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HousekeeperTask#equals(Object)}
   *   <li>{@link HousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    HousekeeperTask housekeeperTask2 = new HousekeeperTask();

    // Act and Assert
    assertEquals(housekeeperTask, housekeeperTask2);
    int expectedHashCodeResult = housekeeperTask.hashCode();
    assertEquals(expectedHashCodeResult, housekeeperTask2.hashCode());
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}, and
   * {@link HousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HousekeeperTask#equals(Object)}
   *   <li>{@link HousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    housekeeperTask.setTaskType(HousekeeperTaskType.DELETE_ATTRIBUTES);
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(0L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
    int notExpectedHashCodeResult = housekeeperTask.hashCode();
    assertNotEquals(notExpectedHashCodeResult, alarmsDeletionHousekeeperTask.hashCode());
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}, and
   * {@link HousekeeperTask#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HousekeeperTask#equals(Object)}
   *   <li>{@link HousekeeperTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask();

    // Act and Assert
    assertNotEquals(alarmsDeletionHousekeeperTask, new HousekeeperTask());
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();

    // Act and Assert
    assertNotEquals(housekeeperTask, new AlarmsDeletionHousekeeperTask());
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(1L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(0L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(0L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    housekeeperTask.setTenantId(TenantId.SYS_TENANT_ID);
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(0L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(0L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    housekeeperTask.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(0L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    housekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(0L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    housekeeperTask.setEntityId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(0L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    HousekeeperTask housekeeperTask = new HousekeeperTask();
    housekeeperTask.setTaskType(HousekeeperTaskType.DELETE_TELEMETRY);
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = mock(AlarmsDeletionHousekeeperTask.class);
    when(alarmsDeletionHousekeeperTask.getTs()).thenReturn(0L);
    when(alarmsDeletionHousekeeperTask.getTaskType()).thenReturn(HousekeeperTaskType.DELETE_ATTRIBUTES);
    when(alarmsDeletionHousekeeperTask.getEntityId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.getTenantId()).thenReturn(null);
    when(alarmsDeletionHousekeeperTask.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(housekeeperTask, alarmsDeletionHousekeeperTask);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HousekeeperTask(), null);
  }

  /**
   * Test {@link HousekeeperTask#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HousekeeperTask(), "Different type to HousekeeperTask");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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

    // Assert that nothing has changed
    assertEquals(
        "HousekeeperTask(tenantId=13814000-1dd2-11b2-8080-808080808080, entityId=13814000-1dd2-11b2-8080-808080808080,"
            + " taskType=DELETE_ATTRIBUTES, ts=1)",
        actualToStringResult);
    assertEquals(1L, actualHousekeeperTask.getTs());
    assertEquals(HousekeeperTaskType.DELETE_ATTRIBUTES, actualTaskType);
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualEntityId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test
   * {@link HousekeeperTask#HousekeeperTask(TenantId, EntityId, HousekeeperTaskType)}.
   * <p>
   * Method under test:
   * {@link HousekeeperTask#HousekeeperTask(TenantId, EntityId, HousekeeperTaskType)}
   */
  @Test
  @DisplayName("Test new HousekeeperTask(TenantId, EntityId, HousekeeperTaskType)")
  void testNewHousekeeperTask() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    HousekeeperTask actualHousekeeperTask = new HousekeeperTask(TenantId.SYS_TENANT_ID, entityId,
        HousekeeperTaskType.DELETE_ATTRIBUTES);

    // Assert
    assertEquals("attributes deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        actualHousekeeperTask.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_ATTRIBUTES, actualHousekeeperTask.getTaskType());
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualHousekeeperTask.getEntityId());
    assertSame(tenantId, actualHousekeeperTask.getTenantId());
  }

  /**
   * Test {@link HousekeeperTask#deleteAttributes(TenantId, EntityId)}.
   * <p>
   * Method under test:
   * {@link HousekeeperTask#deleteAttributes(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test deleteAttributes(TenantId, EntityId)")
  void testDeleteAttributes() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    HousekeeperTask actualDeleteAttributesResult = HousekeeperTask.deleteAttributes(TenantId.SYS_TENANT_ID, entityId);

    // Assert
    assertEquals("attributes deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        actualDeleteAttributesResult.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_ATTRIBUTES, actualDeleteAttributesResult.getTaskType());
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualDeleteAttributesResult.getEntityId());
    assertSame(tenantId, actualDeleteAttributesResult.getTenantId());
  }

  /**
   * Test {@link HousekeeperTask#deleteTelemetry(TenantId, EntityId)}.
   * <p>
   * Method under test:
   * {@link HousekeeperTask#deleteTelemetry(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test deleteTelemetry(TenantId, EntityId)")
  void testDeleteTelemetry() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    HousekeeperTask actualDeleteTelemetryResult = HousekeeperTask.deleteTelemetry(TenantId.SYS_TENANT_ID, entityId);

    // Assert
    assertEquals("telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        actualDeleteTelemetryResult.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_TELEMETRY, actualDeleteTelemetryResult.getTaskType());
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualDeleteTelemetryResult.getEntityId());
    assertSame(tenantId, actualDeleteTelemetryResult.getTenantId());
  }

  /**
   * Test {@link HousekeeperTask#deleteEvents(TenantId, EntityId)}.
   * <p>
   * Method under test: {@link HousekeeperTask#deleteEvents(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test deleteEvents(TenantId, EntityId)")
  void testDeleteEvents() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    HousekeeperTask actualDeleteEventsResult = HousekeeperTask.deleteEvents(TenantId.SYS_TENANT_ID, entityId);

    // Assert
    assertEquals("events deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        actualDeleteEventsResult.getDescription());
    assertEquals(HousekeeperTaskType.DELETE_EVENTS, actualDeleteEventsResult.getTaskType());
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualDeleteEventsResult.getEntityId());
    assertSame(tenantId, actualDeleteEventsResult.getTenantId());
  }

  /**
   * Test {@link HousekeeperTask#unassignAlarms(User)}.
   * <ul>
   *   <li>Then return {@link AlarmsUnassignHousekeeperTask}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperTask#unassignAlarms(User)}
   */
  @Test
  @DisplayName("Test unassignAlarms(User); then return AlarmsUnassignHousekeeperTask")
  void testUnassignAlarms_thenReturnAlarmsUnassignHousekeeperTask() {
    // Arrange
    User user = mock(User.class);
    when(user.getTitle()).thenReturn("Dr");
    when(user.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);
    UserId userId = new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(user.getId()).thenReturn(userId);

    // Act
    HousekeeperTask actualUnassignAlarmsResult = HousekeeperTask.unassignAlarms(user);

    // Assert
    verify(user).getId();
    verify(user).getTenantId();
    verify(user).getTitle();
    assertTrue(actualUnassignAlarmsResult instanceof AlarmsUnassignHousekeeperTask);
    TenantId tenantId = actualUnassignAlarmsResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Dr", ((AlarmsUnassignHousekeeperTask) actualUnassignAlarmsResult).getUserTitle());
    assertEquals("alarms unassigning for user 784f394c-42b6-435a-983c-b7beff2784f9",
        actualUnassignAlarmsResult.getDescription());
    assertNull(((AlarmsUnassignHousekeeperTask) actualUnassignAlarmsResult).getAlarms());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(HousekeeperTaskType.UNASSIGN_ALARMS, actualUnassignAlarmsResult.getTaskType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(userId, actualUnassignAlarmsResult.getEntityId());
  }

  /**
   * Test {@link HousekeeperTask#deleteAlarms(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.</li>
   *   <li>Then return {@link AlarmsDeletionHousekeeperTask}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperTask#deleteAlarms(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test deleteAlarms(TenantId, EntityId); when SYS_TENANT_ID; then return AlarmsDeletionHousekeeperTask")
  void testDeleteAlarms_whenSys_tenant_id_thenReturnAlarmsDeletionHousekeeperTask() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    HousekeeperTask actualDeleteAlarmsResult = HousekeeperTask.deleteAlarms(TenantId.SYS_TENANT_ID, entityId);

    // Assert
    assertTrue(actualDeleteAlarmsResult instanceof AlarmsDeletionHousekeeperTask);
    assertEquals("alarms deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        actualDeleteAlarmsResult.getDescription());
    assertNull(((AlarmsDeletionHousekeeperTask) actualDeleteAlarmsResult).getAlarms());
    assertEquals(HousekeeperTaskType.DELETE_ALARMS, actualDeleteAlarmsResult.getTaskType());
    TenantId tenantId = entityId.SYS_TENANT_ID;
    assertSame(tenantId, actualDeleteAlarmsResult.getEntityId());
    assertSame(tenantId, actualDeleteAlarmsResult.getTenantId());
  }

  /**
   * Test {@link HousekeeperTask#deleteTenantEntities(TenantId, EntityType)}.
   * <ul>
   *   <li>Then return {@link TenantEntitiesDeletionHousekeeperTask}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HousekeeperTask#deleteTenantEntities(TenantId, EntityType)}
   */
  @Test
  @DisplayName("Test deleteTenantEntities(TenantId, EntityType); then return TenantEntitiesDeletionHousekeeperTask")
  void testDeleteTenantEntities_thenReturnTenantEntitiesDeletionHousekeeperTask() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    // Act
    HousekeeperTask actualDeleteTenantEntitiesResult = HousekeeperTask.deleteTenantEntities(tenantId,
        EntityType.TENANT);

    // Assert
    assertTrue(actualDeleteTenantEntitiesResult instanceof TenantEntitiesDeletionHousekeeperTask);
    assertEquals("tenants deletion", actualDeleteTenantEntitiesResult.getDescription());
    assertEquals(EntityType.TENANT,
        ((TenantEntitiesDeletionHousekeeperTask) actualDeleteTenantEntitiesResult).getEntityType());
    assertEquals(HousekeeperTaskType.DELETE_TENANT_ENTITIES, actualDeleteTenantEntitiesResult.getTaskType());
    TenantId tenantId2 = tenantId.SYS_TENANT_ID;
    assertSame(tenantId2, actualDeleteTenantEntitiesResult.getEntityId());
    assertSame(tenantId2, actualDeleteTenantEntitiesResult.getTenantId());
  }

  /**
   * Test {@link HousekeeperTask#getDescription()}.
   * <p>
   * Method under test: {@link HousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  void testGetDescription() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask();
    alarmsDeletionHousekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    alarmsDeletionHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_TELEMETRY);

    // Act and Assert
    assertEquals("telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        alarmsDeletionHousekeeperTask.getDescription());
  }

  /**
   * Test {@link HousekeeperTask#getDescription()}.
   * <p>
   * Method under test: {@link HousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription()")
  void testGetDescription2() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    alarmsUnassignHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_TELEMETRY);

    // Act and Assert
    assertEquals("telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080",
        alarmsUnassignHousekeeperTask.getDescription());
  }

  /**
   * Test {@link HousekeeperTask#getDescription()}.
   * <ul>
   *   <li>Given
   * {@link AlarmsDeletionHousekeeperTask#AlarmsDeletionHousekeeperTask()} Alarms
   * is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); given AlarmsDeletionHousekeeperTask() Alarms is ArrayList()")
  void testGetDescription_givenAlarmsDeletionHousekeeperTaskAlarmsIsArrayList() {
    // Arrange
    AlarmsDeletionHousekeeperTask alarmsDeletionHousekeeperTask = new AlarmsDeletionHousekeeperTask();
    alarmsDeletionHousekeeperTask.setAlarms(new ArrayList<>());
    alarmsDeletionHousekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    alarmsDeletionHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_TELEMETRY);

    // Act and Assert
    assertEquals("telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080 ([])",
        alarmsDeletionHousekeeperTask.getDescription());
  }

  /**
   * Test {@link HousekeeperTask#getDescription()}.
   * <ul>
   *   <li>Given
   * {@link AlarmsUnassignHousekeeperTask#AlarmsUnassignHousekeeperTask()} Alarms
   * is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); given AlarmsUnassignHousekeeperTask() Alarms is ArrayList()")
  void testGetDescription_givenAlarmsUnassignHousekeeperTaskAlarmsIsArrayList() {
    // Arrange
    AlarmsUnassignHousekeeperTask alarmsUnassignHousekeeperTask = new AlarmsUnassignHousekeeperTask();
    alarmsUnassignHousekeeperTask.setAlarms(new ArrayList<>());
    alarmsUnassignHousekeeperTask.setEntityId(TenantId.SYS_TENANT_ID);
    alarmsUnassignHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_TELEMETRY);

    // Act and Assert
    assertEquals("telemetry deletion for tenant 13814000-1dd2-11b2-8080-808080808080 ([])",
        alarmsUnassignHousekeeperTask.getDescription());
  }

  /**
   * Test {@link HousekeeperTask#getDescription()}.
   * <ul>
   *   <li>Then return {@code tenants deletion}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HousekeeperTask#getDescription()}
   */
  @Test
  @DisplayName("Test getDescription(); then return 'tenants deletion'")
  void testGetDescription_thenReturnTenantsDeletion() {
    // Arrange
    TenantEntitiesDeletionHousekeeperTask tenantEntitiesDeletionHousekeeperTask = new TenantEntitiesDeletionHousekeeperTask();
    tenantEntitiesDeletionHousekeeperTask.setEntityType(EntityType.TENANT);
    tenantEntitiesDeletionHousekeeperTask.setTaskType(HousekeeperTaskType.DELETE_TELEMETRY);

    // Act and Assert
    assertEquals("tenants deletion", tenantEntitiesDeletionHousekeeperTask.getDescription());
  }
}
