package org.thingsboard.server.common.transport;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;

class DeviceDeletedEventDiffblueTest {
  /**
   * Test {@link DeviceDeletedEvent#DeviceDeletedEvent(DeviceId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return DeviceId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceDeletedEvent#DeviceDeletedEvent(DeviceId)}
   */
  @Test
  @DisplayName("Test new DeviceDeletedEvent(DeviceId); when 'null'; then return DeviceId is 'null'")
  void testNewDeviceDeletedEvent_whenNull_thenReturnDeviceIdIsNull() {
    // Arrange, Act and Assert
    assertNull((new DeviceDeletedEvent(null)).getDeviceId());
  }
}
