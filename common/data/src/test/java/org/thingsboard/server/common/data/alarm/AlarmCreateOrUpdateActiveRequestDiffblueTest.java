package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;

class AlarmCreateOrUpdateActiveRequestDiffblueTest {
  /**
   * Test
   * {@link AlarmCreateOrUpdateActiveRequest#fromAlarm(Alarm, UserId, AlarmId)}
   * with {@code a}, {@code userId}, {@code edgeAlarmId}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then Originator return {@link TenantId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmCreateOrUpdateActiveRequest#fromAlarm(Alarm, UserId, AlarmId)}
   */
  @Test
  @DisplayName("Test fromAlarm(Alarm, UserId, AlarmId) with 'a', 'userId', 'edgeAlarmId'; given 'true'; then Originator return TenantId")
  void testFromAlarmWithAUserIdEdgeAlarmId_givenTrue_thenOriginatorReturnTenantId() {
    // Arrange
    Alarm a = mock(Alarm.class);
    when(a.isPropagate()).thenReturn(true);
    when(a.isPropagateToOwner()).thenReturn(true);
    when(a.isPropagateToTenant()).thenReturn(true);
    MissingNode instance = MissingNode.getInstance();
    when(a.getDetails()).thenReturn(instance);
    when(a.getType()).thenReturn("Type");
    when(a.getPropagateRelationTypes()).thenReturn(new ArrayList<>());
    when(a.getEndTs()).thenReturn(1L);
    when(a.getStartTs()).thenReturn(1L);
    when(a.getSeverity()).thenReturn(AlarmSeverity.CRITICAL);
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(a.getCustomerId()).thenReturn(customerId);
    when(a.getOriginator()).thenReturn(TenantId.SYS_TENANT_ID);
    when(a.getTenantId()).thenReturn(TenantId.SYS_TENANT_ID);

    // Act
    AlarmCreateOrUpdateActiveRequest actualFromAlarmResult = AlarmCreateOrUpdateActiveRequest.fromAlarm(a, null, null);

    // Assert
    verify(a).getCustomerId();
    verify(a).getDetails();
    verify(a).getEndTs();
    verify(a).getOriginator();
    verify(a).getPropagateRelationTypes();
    verify(a).getSeverity();
    verify(a).getStartTs();
    verify(a).getTenantId();
    verify(a).getType();
    verify(a).isPropagate();
    verify(a).isPropagateToOwner();
    verify(a).isPropagateToTenant();
    EntityId originator = actualFromAlarmResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originator.getId().toString());
    assertEquals("Type", actualFromAlarmResult.getType());
    assertNull(actualFromAlarmResult.getEdgeAlarmId());
    assertNull(actualFromAlarmResult.getUserId());
    assertEquals(1L, actualFromAlarmResult.getEndTs());
    assertEquals(1L, actualFromAlarmResult.getStartTs());
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertEquals(AlarmSeverity.CRITICAL, actualFromAlarmResult.getSeverity());
    AlarmPropagationInfo propagation = actualFromAlarmResult.getPropagation();
    assertTrue(propagation.getPropagateRelationTypes().isEmpty());
    assertTrue(propagation.isPropagate());
    assertTrue(propagation.isPropagateToOwner());
    assertTrue(propagation.isPropagateToTenant());
    assertTrue(originator.isNullUid());
    assertTrue(((TenantId) originator).isSysTenantId());
    assertSame(customerId, actualFromAlarmResult.getCustomerId());
    assertSame(instance, actualFromAlarmResult.getDetails());
    assertSame(originator, actualFromAlarmResult.getTenantId());
  }

  /**
   * Test {@link AlarmCreateOrUpdateActiveRequest#fromAlarm(Alarm, UserId)} with
   * {@code a}, {@code userId}.
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.</li>
   *   <li>Then return Details is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmCreateOrUpdateActiveRequest#fromAlarm(Alarm, UserId)}
   */
  @Test
  @DisplayName("Test fromAlarm(Alarm, UserId) with 'a', 'userId'; when Alarm(); then return Details is 'null'")
  void testFromAlarmWithAUserId_whenAlarm_thenReturnDetailsIsNull() {
    // Arrange and Act
    AlarmCreateOrUpdateActiveRequest actualFromAlarmResult = AlarmCreateOrUpdateActiveRequest.fromAlarm(new Alarm(),
        null);

    // Assert
    assertNull(actualFromAlarmResult.getDetails());
    assertNull(actualFromAlarmResult.getType());
    AlarmPropagationInfo propagation = actualFromAlarmResult.getPropagation();
    assertNull(propagation.getPropagateRelationTypes());
    assertNull(actualFromAlarmResult.getSeverity());
    assertNull(actualFromAlarmResult.getEdgeAlarmId());
    assertNull(actualFromAlarmResult.getCustomerId());
    assertNull(actualFromAlarmResult.getOriginator());
    assertNull(actualFromAlarmResult.getTenantId());
    assertNull(actualFromAlarmResult.getUserId());
    assertEquals(0L, actualFromAlarmResult.getEndTs());
    assertEquals(0L, actualFromAlarmResult.getStartTs());
    assertFalse(propagation.isPropagate());
    assertFalse(propagation.isPropagateToOwner());
    assertFalse(propagation.isPropagateToTenant());
  }

  /**
   * Test {@link AlarmCreateOrUpdateActiveRequest#fromAlarm(Alarm)} with
   * {@code a}.
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.</li>
   *   <li>Then return Details is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmCreateOrUpdateActiveRequest#fromAlarm(Alarm)}
   */
  @Test
  @DisplayName("Test fromAlarm(Alarm) with 'a'; when Alarm(); then return Details is 'null'")
  void testFromAlarmWithA_whenAlarm_thenReturnDetailsIsNull() {
    // Arrange and Act
    AlarmCreateOrUpdateActiveRequest actualFromAlarmResult = AlarmCreateOrUpdateActiveRequest.fromAlarm(new Alarm());

    // Assert
    assertNull(actualFromAlarmResult.getDetails());
    assertNull(actualFromAlarmResult.getType());
    AlarmPropagationInfo propagation = actualFromAlarmResult.getPropagation();
    assertNull(propagation.getPropagateRelationTypes());
    assertNull(actualFromAlarmResult.getSeverity());
    assertNull(actualFromAlarmResult.getEdgeAlarmId());
    assertNull(actualFromAlarmResult.getCustomerId());
    assertNull(actualFromAlarmResult.getOriginator());
    assertNull(actualFromAlarmResult.getTenantId());
    assertNull(actualFromAlarmResult.getUserId());
    assertEquals(0L, actualFromAlarmResult.getEndTs());
    assertEquals(0L, actualFromAlarmResult.getStartTs());
    assertFalse(propagation.isPropagate());
    assertFalse(propagation.isPropagateToOwner());
    assertFalse(propagation.isPropagateToTenant());
  }
}
