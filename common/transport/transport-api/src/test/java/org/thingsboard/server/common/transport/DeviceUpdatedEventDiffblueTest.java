package org.thingsboard.server.common.transport;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Device;

class DeviceUpdatedEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceUpdatedEvent#DeviceUpdatedEvent(Device)}
   *   <li>{@link DeviceUpdatedEvent#getDevice()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DeviceUpdatedEvent.<init>(Device)",
    "Device DeviceUpdatedEvent.getDevice()"
  })
  void testGettersAndSetters() {
    // Arrange
    Device device = new Device();

    // Act and Assert
    assertSame(device, new DeviceUpdatedEvent(device).getDevice());
  }
}
