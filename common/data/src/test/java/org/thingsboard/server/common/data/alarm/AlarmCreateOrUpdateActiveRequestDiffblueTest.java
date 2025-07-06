package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.UserId;

class AlarmCreateOrUpdateActiveRequestDiffblueTest {
  /**
   * Test {@link AlarmCreateOrUpdateActiveRequest#fromAlarm(Alarm, UserId)} with {@code a}, {@code
   * userId}.
   *
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.
   *   <li>Then return Details is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCreateOrUpdateActiveRequest#fromAlarm(Alarm, UserId)}
   */
  @Test
  @DisplayName(
      "Test fromAlarm(Alarm, UserId) with 'a', 'userId'; when Alarm(); then return Details is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AlarmCreateOrUpdateActiveRequest AlarmCreateOrUpdateActiveRequest.fromAlarm(Alarm, UserId)"
  })
  void testFromAlarmWithAUserId_whenAlarm_thenReturnDetailsIsNull() {
    // Arrange and Act
    AlarmCreateOrUpdateActiveRequest actualFromAlarmResult =
        AlarmCreateOrUpdateActiveRequest.fromAlarm(new Alarm(), null);

    // Assert
    assertNull(actualFromAlarmResult.getDetails());
    assertNull(actualFromAlarmResult.getType());
    assertNull(actualFromAlarmResult.getSeverity());
    assertNull(actualFromAlarmResult.getEdgeAlarmId());
    assertNull(actualFromAlarmResult.getCustomerId());
    assertNull(actualFromAlarmResult.getOriginator());
    assertNull(actualFromAlarmResult.getTenantId());
    assertNull(actualFromAlarmResult.getUserId());
    assertEquals(0L, actualFromAlarmResult.getEndTs());
    assertEquals(0L, actualFromAlarmResult.getStartTs());
  }

  /**
   * Test {@link AlarmCreateOrUpdateActiveRequest#fromAlarm(Alarm)} with {@code a}.
   *
   * <ul>
   *   <li>When {@link Alarm#Alarm()}.
   *   <li>Then return Details is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmCreateOrUpdateActiveRequest#fromAlarm(Alarm)}
   */
  @Test
  @DisplayName("Test fromAlarm(Alarm) with 'a'; when Alarm(); then return Details is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AlarmCreateOrUpdateActiveRequest AlarmCreateOrUpdateActiveRequest.fromAlarm(Alarm)"
  })
  void testFromAlarmWithA_whenAlarm_thenReturnDetailsIsNull() {
    // Arrange and Act
    AlarmCreateOrUpdateActiveRequest actualFromAlarmResult =
        AlarmCreateOrUpdateActiveRequest.fromAlarm(new Alarm());

    // Assert
    assertNull(actualFromAlarmResult.getDetails());
    assertNull(actualFromAlarmResult.getType());
    assertNull(actualFromAlarmResult.getSeverity());
    assertNull(actualFromAlarmResult.getEdgeAlarmId());
    assertNull(actualFromAlarmResult.getCustomerId());
    assertNull(actualFromAlarmResult.getOriginator());
    assertNull(actualFromAlarmResult.getTenantId());
    assertNull(actualFromAlarmResult.getUserId());
    assertEquals(0L, actualFromAlarmResult.getEndTs());
    assertEquals(0L, actualFromAlarmResult.getStartTs());
  }
}
