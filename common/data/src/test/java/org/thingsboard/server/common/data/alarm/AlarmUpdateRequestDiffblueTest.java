package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.UserId;

class AlarmUpdateRequestDiffblueTest {
  /**
   * Test {@link AlarmUpdateRequest#fromAlarm(Alarm, UserId)} with {@code a}, {@code userId}.
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.</li>
   *   <li>Then return Details is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmUpdateRequest#fromAlarm(Alarm, UserId)}
   */
  @Test
  @DisplayName("Test fromAlarm(Alarm, UserId) with 'a', 'userId'; when Alarm(); then return Details is 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.</li>
   *   <li>Then return Details is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmUpdateRequest#fromAlarm(Alarm)}
   */
  @Test
  @DisplayName("Test fromAlarm(Alarm) with 'a'; when Alarm(); then return Details is 'null'")
  @Tag("MaintainedByDiffblue")
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
}
