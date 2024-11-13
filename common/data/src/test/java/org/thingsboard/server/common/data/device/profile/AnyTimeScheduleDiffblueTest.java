package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.DynamicValue;

class AnyTimeScheduleDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AnyTimeSchedule}
   *   <li>{@link AnyTimeSchedule#getDynamicValue()}
   *   <li>{@link AnyTimeSchedule#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    AnyTimeSchedule actualAnyTimeSchedule = new AnyTimeSchedule();
    DynamicValue<String> actualDynamicValue = actualAnyTimeSchedule.getDynamicValue();

    // Assert
    assertNull(actualDynamicValue);
    assertEquals(AlarmScheduleType.ANY_TIME, actualAnyTimeSchedule.getType());
  }
}
