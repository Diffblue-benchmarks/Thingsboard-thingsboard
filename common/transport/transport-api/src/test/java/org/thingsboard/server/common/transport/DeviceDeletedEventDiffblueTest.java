package org.thingsboard.server.common.transport;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceDeletedEvent.<init>(DeviceId)"})
  void testNewDeviceDeletedEvent_whenNull_thenReturnDeviceIdIsNull() {
    // Arrange, Act and Assert
    assertNull((new DeviceDeletedEvent(null)).getDeviceId());
  }
}
