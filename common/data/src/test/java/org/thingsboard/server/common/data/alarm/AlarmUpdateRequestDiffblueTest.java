package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;

class AlarmUpdateRequestDiffblueTest {
  /**
   * Test {@link AlarmUpdateRequest#fromAlarm(Alarm, UserId)} with {@code a}, {@code userId}.
   *
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.
   *   <li>Then return Details is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmUpdateRequest#fromAlarm(Alarm, UserId)}
   */
  @Test
  @DisplayName(
      "Test fromAlarm(Alarm, UserId) with 'a', 'userId'; when Alarm(); then return Details is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmUpdateRequest AlarmUpdateRequest.fromAlarm(Alarm, UserId)"})
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
   *
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.
   *   <li>Then return Details is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmUpdateRequest#fromAlarm(Alarm)}
   */
  @Test
  @DisplayName("Test fromAlarm(Alarm) with 'a'; when Alarm(); then return Details is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AlarmUpdateRequest AlarmUpdateRequest.fromAlarm(Alarm)"})
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
   * Test {@link AlarmUpdateRequest#AlarmUpdateRequest(TenantId, AlarmId, AlarmSeverity, long, long,
   * JsonNode, AlarmPropagationInfo, UserId)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then Details return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmUpdateRequest#AlarmUpdateRequest(TenantId, AlarmId,
   * AlarmSeverity, long, long, JsonNode, AlarmPropagationInfo, UserId)}
   */
  @Test
  @DisplayName(
      "Test new AlarmUpdateRequest(TenantId, AlarmId, AlarmSeverity, long, long, JsonNode, AlarmPropagationInfo, UserId); when 'null'; then Details return DoubleNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AlarmUpdateRequest.<init>(TenantId, AlarmId, AlarmSeverity, long, long, JsonNode, AlarmPropagationInfo, UserId)"
  })
  void testNewAlarmUpdateRequest_whenNull_thenDetailsReturnDoubleNode() {
    // Arrange
    DoubleNode details = DoubleNode.valueOf(10.0d);
    AlarmPropagationInfo propagation =
        new AlarmPropagationInfo(true, true, true, new ArrayList<>());

    // Act
    AlarmUpdateRequest actualAlarmUpdateRequest =
        new AlarmUpdateRequest(
            TenantId.SYS_TENANT_ID,
            null,
            AlarmSeverity.CRITICAL,
            1L,
            1L,
            details,
            propagation,
            null);

    // Assert
    JsonNode details2 = actualAlarmUpdateRequest.getDetails();
    assertTrue(details2 instanceof DoubleNode);
    assertNull(actualAlarmUpdateRequest.getAlarmId());
    assertNull(actualAlarmUpdateRequest.getUserId());
    assertEquals(1L, actualAlarmUpdateRequest.getEndTs());
    assertEquals(1L, actualAlarmUpdateRequest.getStartTs());
    assertEquals(AlarmSeverity.CRITICAL, actualAlarmUpdateRequest.getSeverity());
    assertSame(propagation, actualAlarmUpdateRequest.getPropagation());
    assertSame(details, details2);
    assertSame(TenantId.SYS_TENANT_ID, actualAlarmUpdateRequest.getTenantId());
  }
}
