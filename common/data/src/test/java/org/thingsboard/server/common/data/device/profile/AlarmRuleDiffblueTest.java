package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AlarmRuleDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AlarmRule}
   *   <li>{@link AlarmRule#setAlarmDetails(String)}
   *   <li>{@link AlarmRule#setCondition(AlarmCondition)}
   *   <li>{@link AlarmRule#setSchedule(AlarmSchedule)}
   *   <li>{@link AlarmRule#toString()}
   *   <li>{@link AlarmRule#getAlarmDetails()}
   *   <li>{@link AlarmRule#getCondition()}
   *   <li>{@link AlarmRule#getDashboardId()}
   *   <li>{@link AlarmRule#getSchedule()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmRule actualAlarmRule = new AlarmRule();
    actualAlarmRule.setAlarmDetails("Alarm Details");
    AlarmCondition condition = new AlarmCondition();
    condition.setCondition(new ArrayList<>());
    condition.setSpec(mock(AlarmConditionSpec.class));
    actualAlarmRule.setCondition(condition);
    AnyTimeSchedule schedule = new AnyTimeSchedule();
    actualAlarmRule.setSchedule(schedule);
    actualAlarmRule.toString();
    String actualAlarmDetails = actualAlarmRule.getAlarmDetails();
    AlarmCondition actualCondition = actualAlarmRule.getCondition();
    actualAlarmRule.getDashboardId();

    // Assert that nothing has changed
    assertEquals("Alarm Details", actualAlarmDetails);
    assertSame(condition, actualCondition);
    assertSame(schedule, actualAlarmRule.getSchedule());
  }
}
