package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.alarm.AlarmStatus;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class AlarmDataDiffblueTest {
  /**
   * Test {@link AlarmData#AlarmData(Alarm, EntityId)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return Status is {@code ACTIVE_ACK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmData#AlarmData(Alarm, EntityId)}
   */
  @Test
  @DisplayName("Test new AlarmData(Alarm, EntityId); given 'true'; then return Status is 'ACTIVE_ACK'")
  void testNewAlarmData_givenTrue_thenReturnStatusIsActiveAck() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setAcknowledged(true);
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    AlarmData actualAlarmData = new AlarmData(alarm, entityId);

    // Assert
    assertNull(actualAlarmData.getDetails());
    assertNull(actualAlarmData.getName());
    assertNull(actualAlarmData.getType());
    assertNull(actualAlarmData.getOriginatorLabel());
    assertNull(actualAlarmData.getOriginatorName());
    assertNull(actualAlarmData.getPropagateRelationTypes());
    assertNull(actualAlarmData.getUuidId());
    assertNull(actualAlarmData.getAssignee());
    assertNull(actualAlarmData.getSeverity());
    assertNull(actualAlarmData.getId());
    assertNull(actualAlarmData.getCustomerId());
    assertNull(actualAlarmData.getDashboardId());
    assertNull(actualAlarmData.getOriginator());
    assertNull(actualAlarmData.getTenantId());
    assertNull(actualAlarmData.getAssigneeId());
    assertEquals(0L, actualAlarmData.getAckTs());
    assertEquals(0L, actualAlarmData.getAssignTs());
    assertEquals(0L, actualAlarmData.getClearTs());
    assertEquals(0L, actualAlarmData.getCreatedTime());
    assertEquals(0L, actualAlarmData.getEndTs());
    assertEquals(0L, actualAlarmData.getStartTs());
    assertEquals(AlarmStatus.ACTIVE_ACK, actualAlarmData.getStatus());
    assertFalse(actualAlarmData.isCleared());
    assertFalse(actualAlarmData.isPropagate());
    assertFalse(actualAlarmData.isPropagateToOwner());
    assertFalse(actualAlarmData.isPropagateToTenant());
    assertTrue(actualAlarmData.getLatest().isEmpty());
    assertTrue(actualAlarmData.isAcknowledged());
    TenantId expectedEntityId = entityId.SYS_TENANT_ID;
    assertSame(expectedEntityId, actualAlarmData.getEntityId());
  }

  /**
   * Test {@link AlarmData#AlarmData(AlarmInfo, AlarmData)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return Status is {@code ACTIVE_ACK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmData#AlarmData(AlarmInfo, AlarmData)}
   */
  @Test
  @DisplayName("Test new AlarmData(AlarmInfo, AlarmData); given 'true'; then return Status is 'ACTIVE_ACK'")
  void testNewAlarmData_givenTrue_thenReturnStatusIsActiveAck2() {
    // Arrange
    AlarmInfo main = new AlarmInfo();
    main.setAcknowledged(true);
    Alarm.AlarmBuilder clearedResult = Alarm.builder()
        .ackTs(1L)
        .acknowledged(true)
        .assignTs(1L)
        .assigneeId(null)
        .clearTs(1L)
        .cleared(true);
    Alarm.AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
    Alarm.AlarmBuilder propagateResult = customerIdResult.details(MissingNode.getInstance())
        .endTs(1L)
        .originator(TenantId.SYS_TENANT_ID)
        .propagate(true);
    Alarm alarm = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .severity(AlarmSeverity.CRITICAL)
        .startTs(1L)
        .tenantId(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();

    // Act
    AlarmData actualAlarmData = new AlarmData(main, new AlarmData(alarm, TenantId.SYS_TENANT_ID));

    // Assert
    EntityId entityId = actualAlarmData.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertNull(actualAlarmData.getDetails());
    assertNull(actualAlarmData.getName());
    assertNull(actualAlarmData.getType());
    assertNull(actualAlarmData.getOriginatorLabel());
    assertNull(actualAlarmData.getOriginatorName());
    assertNull(actualAlarmData.getPropagateRelationTypes());
    assertNull(actualAlarmData.getUuidId());
    assertNull(actualAlarmData.getAssignee());
    assertNull(actualAlarmData.getSeverity());
    assertNull(actualAlarmData.getId());
    assertNull(actualAlarmData.getCustomerId());
    assertNull(actualAlarmData.getDashboardId());
    assertNull(actualAlarmData.getOriginator());
    assertNull(actualAlarmData.getTenantId());
    assertNull(actualAlarmData.getAssigneeId());
    assertEquals(0L, actualAlarmData.getAckTs());
    assertEquals(0L, actualAlarmData.getAssignTs());
    assertEquals(0L, actualAlarmData.getClearTs());
    assertEquals(0L, actualAlarmData.getCreatedTime());
    assertEquals(0L, actualAlarmData.getEndTs());
    assertEquals(0L, actualAlarmData.getStartTs());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertEquals(AlarmStatus.ACTIVE_ACK, actualAlarmData.getStatus());
    assertFalse(actualAlarmData.isCleared());
    assertFalse(actualAlarmData.isPropagate());
    assertFalse(actualAlarmData.isPropagateToOwner());
    assertFalse(actualAlarmData.isPropagateToTenant());
    assertTrue(actualAlarmData.getLatest().isEmpty());
    assertTrue(actualAlarmData.isAcknowledged());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Test {@link AlarmData#AlarmData(AlarmInfo, AlarmData)}.
   * <ul>
   *   <li>Then return Status is {@code ACTIVE_UNACK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmData#AlarmData(AlarmInfo, AlarmData)}
   */
  @Test
  @DisplayName("Test new AlarmData(AlarmInfo, AlarmData); then return Status is 'ACTIVE_UNACK'")
  void testNewAlarmData_thenReturnStatusIsActiveUnack() {
    // Arrange
    AlarmInfo main = new AlarmInfo();
    Alarm.AlarmBuilder clearedResult = Alarm.builder()
        .ackTs(1L)
        .acknowledged(true)
        .assignTs(1L)
        .assigneeId(null)
        .clearTs(1L)
        .cleared(true);
    Alarm.AlarmBuilder customerIdResult = clearedResult.customerId(new CustomerId(EntityId.NULL_UUID));
    Alarm.AlarmBuilder propagateResult = customerIdResult.details(MissingNode.getInstance())
        .endTs(1L)
        .originator(TenantId.SYS_TENANT_ID)
        .propagate(true);
    Alarm alarm = propagateResult.propagateRelationTypes(new ArrayList<>())
        .propagateToOwner(true)
        .propagateToTenant(true)
        .severity(AlarmSeverity.CRITICAL)
        .startTs(1L)
        .tenantId(TenantId.SYS_TENANT_ID)
        .type("Type")
        .build();

    // Act
    AlarmData actualAlarmData = new AlarmData(main, new AlarmData(alarm, TenantId.SYS_TENANT_ID));

    // Assert
    EntityId entityId = actualAlarmData.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertNull(actualAlarmData.getDetails());
    assertNull(actualAlarmData.getName());
    assertNull(actualAlarmData.getType());
    assertNull(actualAlarmData.getOriginatorLabel());
    assertNull(actualAlarmData.getOriginatorName());
    assertNull(actualAlarmData.getPropagateRelationTypes());
    assertNull(actualAlarmData.getUuidId());
    assertNull(actualAlarmData.getAssignee());
    assertNull(actualAlarmData.getSeverity());
    assertNull(actualAlarmData.getId());
    assertNull(actualAlarmData.getCustomerId());
    assertNull(actualAlarmData.getDashboardId());
    assertNull(actualAlarmData.getOriginator());
    assertNull(actualAlarmData.getTenantId());
    assertNull(actualAlarmData.getAssigneeId());
    assertEquals(0L, actualAlarmData.getAckTs());
    assertEquals(0L, actualAlarmData.getAssignTs());
    assertEquals(0L, actualAlarmData.getClearTs());
    assertEquals(0L, actualAlarmData.getCreatedTime());
    assertEquals(0L, actualAlarmData.getEndTs());
    assertEquals(0L, actualAlarmData.getStartTs());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertEquals(AlarmStatus.ACTIVE_UNACK, actualAlarmData.getStatus());
    assertFalse(actualAlarmData.isAcknowledged());
    assertFalse(actualAlarmData.isCleared());
    assertFalse(actualAlarmData.isPropagate());
    assertFalse(actualAlarmData.isPropagateToOwner());
    assertFalse(actualAlarmData.isPropagateToTenant());
    assertTrue(actualAlarmData.getLatest().isEmpty());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Test {@link AlarmData#AlarmData(Alarm, EntityId)}.
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.</li>
   *   <li>Then return Status is {@code ACTIVE_UNACK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmData#AlarmData(Alarm, EntityId)}
   */
  @Test
  @DisplayName("Test new AlarmData(Alarm, EntityId); when Alarm(); then return Status is 'ACTIVE_UNACK'")
  void testNewAlarmData_whenAlarm_thenReturnStatusIsActiveUnack() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;

    // Act
    AlarmData actualAlarmData = new AlarmData(new Alarm(), entityId);

    // Assert
    assertNull(actualAlarmData.getDetails());
    assertNull(actualAlarmData.getName());
    assertNull(actualAlarmData.getType());
    assertNull(actualAlarmData.getOriginatorLabel());
    assertNull(actualAlarmData.getOriginatorName());
    assertNull(actualAlarmData.getPropagateRelationTypes());
    assertNull(actualAlarmData.getUuidId());
    assertNull(actualAlarmData.getAssignee());
    assertNull(actualAlarmData.getSeverity());
    assertNull(actualAlarmData.getId());
    assertNull(actualAlarmData.getCustomerId());
    assertNull(actualAlarmData.getDashboardId());
    assertNull(actualAlarmData.getOriginator());
    assertNull(actualAlarmData.getTenantId());
    assertNull(actualAlarmData.getAssigneeId());
    assertEquals(0L, actualAlarmData.getAckTs());
    assertEquals(0L, actualAlarmData.getAssignTs());
    assertEquals(0L, actualAlarmData.getClearTs());
    assertEquals(0L, actualAlarmData.getCreatedTime());
    assertEquals(0L, actualAlarmData.getEndTs());
    assertEquals(0L, actualAlarmData.getStartTs());
    assertEquals(AlarmStatus.ACTIVE_UNACK, actualAlarmData.getStatus());
    assertFalse(actualAlarmData.isAcknowledged());
    assertFalse(actualAlarmData.isCleared());
    assertFalse(actualAlarmData.isPropagate());
    assertFalse(actualAlarmData.isPropagateToOwner());
    assertFalse(actualAlarmData.isPropagateToTenant());
    assertTrue(actualAlarmData.getLatest().isEmpty());
    TenantId expectedEntityId = entityId.SYS_TENANT_ID;
    assertSame(expectedEntityId, actualAlarmData.getEntityId());
  }
}
