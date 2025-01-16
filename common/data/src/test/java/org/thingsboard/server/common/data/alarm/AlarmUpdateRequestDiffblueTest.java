package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;

class AlarmUpdateRequestDiffblueTest {
  /**
   * Test {@link AlarmUpdateRequest#fromAlarm(Alarm, UserId)} with {@code a},
   * {@code userId}.
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.</li>
   *   <li>Then return Details is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmUpdateRequest#fromAlarm(Alarm, UserId)}
   */
  @Test
  @DisplayName("Test fromAlarm(Alarm, UserId) with 'a', 'userId'; when Alarm(); then return Details is 'null'")
  void testFromAlarmWithAUserId_whenAlarm_thenReturnDetailsIsNull() {
    // Arrange and Act
    AlarmUpdateRequest actualFromAlarmResult = AlarmUpdateRequest.fromAlarm(new Alarm(), null);

    // Assert
    assertNull(actualFromAlarmResult.getDetails());
    AlarmPropagationInfo propagation = actualFromAlarmResult.getPropagation();
    assertNull(propagation.getPropagateRelationTypes());
    assertNull(actualFromAlarmResult.getSeverity());
    assertNull(actualFromAlarmResult.getAlarmId());
    assertNull(actualFromAlarmResult.getTenantId());
    assertNull(actualFromAlarmResult.getUserId());
    assertEquals(0L, actualFromAlarmResult.getEndTs());
    assertEquals(0L, actualFromAlarmResult.getStartTs());
    assertFalse(propagation.isPropagate());
    assertFalse(propagation.isPropagateToOwner());
    assertFalse(propagation.isPropagateToTenant());
  }

  /**
   * Test {@link AlarmUpdateRequest#fromAlarm(Alarm)} with {@code a}.
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.</li>
   *   <li>Then return Details is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmUpdateRequest#fromAlarm(Alarm)}
   */
  @Test
  @DisplayName("Test fromAlarm(Alarm) with 'a'; when Alarm(); then return Details is 'null'")
  void testFromAlarmWithA_whenAlarm_thenReturnDetailsIsNull() {
    // Arrange and Act
    AlarmUpdateRequest actualFromAlarmResult = AlarmUpdateRequest.fromAlarm(new Alarm());

    // Assert
    assertNull(actualFromAlarmResult.getDetails());
    AlarmPropagationInfo propagation = actualFromAlarmResult.getPropagation();
    assertNull(propagation.getPropagateRelationTypes());
    assertNull(actualFromAlarmResult.getSeverity());
    assertNull(actualFromAlarmResult.getAlarmId());
    assertNull(actualFromAlarmResult.getTenantId());
    assertNull(actualFromAlarmResult.getUserId());
    assertEquals(0L, actualFromAlarmResult.getEndTs());
    assertEquals(0L, actualFromAlarmResult.getStartTs());
    assertFalse(propagation.isPropagate());
    assertFalse(propagation.isPropagateToOwner());
    assertFalse(propagation.isPropagateToTenant());
  }

  /**
   * Test
   * {@link AlarmUpdateRequest#AlarmUpdateRequest(TenantId, AlarmId, AlarmSeverity, long, long, JsonNode, AlarmPropagationInfo, UserId)}.
   * <ul>
   *   <li>When {@link AlarmId}.</li>
   *   <li>Then return UserId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmUpdateRequest#AlarmUpdateRequest(TenantId, AlarmId, AlarmSeverity, long, long, JsonNode, AlarmPropagationInfo, UserId)}
   */
  @Test
  @DisplayName("Test new AlarmUpdateRequest(TenantId, AlarmId, AlarmSeverity, long, long, JsonNode, AlarmPropagationInfo, UserId); when AlarmId; then return UserId is 'null'")
  void testNewAlarmUpdateRequest_whenAlarmId_thenReturnUserIdIsNull() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    AlarmId alarmId = mock(AlarmId.class);
    MissingNode details = MissingNode.getInstance();
    AlarmPropagationInfo propagation = new AlarmPropagationInfo(true, true, true, new ArrayList<>());

    // Act
    AlarmUpdateRequest actualAlarmUpdateRequest = new AlarmUpdateRequest(tenantId, alarmId, AlarmSeverity.CRITICAL, 1L,
        1L, details, propagation, null);

    // Assert
    assertNull(actualAlarmUpdateRequest.getUserId());
    assertEquals(1L, actualAlarmUpdateRequest.getEndTs());
    assertEquals(1L, actualAlarmUpdateRequest.getStartTs());
    assertEquals(AlarmSeverity.CRITICAL, actualAlarmUpdateRequest.getSeverity());
    assertSame(propagation, actualAlarmUpdateRequest.getPropagation());
    assertSame(details, actualAlarmUpdateRequest.getDetails());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualAlarmUpdateRequest.getTenantId());
    assertSame(alarmId, actualAlarmUpdateRequest.getAlarmId());
  }
}
