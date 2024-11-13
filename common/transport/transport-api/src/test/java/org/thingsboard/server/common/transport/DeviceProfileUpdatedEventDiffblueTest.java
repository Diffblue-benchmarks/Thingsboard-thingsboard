package org.thingsboard.server.common.transport;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfile;

class DeviceProfileUpdatedEventDiffblueTest {
  /**
   * Test
   * {@link DeviceProfileUpdatedEvent#DeviceProfileUpdatedEvent(DeviceProfile)}.
   * <p>
   * Method under test:
   * {@link DeviceProfileUpdatedEvent#DeviceProfileUpdatedEvent(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfileUpdatedEvent(DeviceProfile)")
  void testNewDeviceProfileUpdatedEvent() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act and Assert
    assertSame(deviceProfile, (new DeviceProfileUpdatedEvent(deviceProfile)).getDeviceProfile());
  }

  /**
   * Test {@link DeviceProfileUpdatedEvent#getDeviceProfile()}.
   * <p>
   * Method under test: {@link DeviceProfileUpdatedEvent#getDeviceProfile()}
   */
  @Test
  @DisplayName("Test getDeviceProfile()")
  void testGetDeviceProfile() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act and Assert
    assertSame(deviceProfile, (new DeviceProfileUpdatedEvent(deviceProfile)).getDeviceProfile());
  }
}
