package org.thingsboard.server.common.transport;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfile;

class DeviceProfileUpdatedEventDiffblueTest {
  /**
   * Test {@link DeviceProfileUpdatedEvent#DeviceProfileUpdatedEvent(DeviceProfile)}.
   *
   * <p>Method under test: {@link
   * DeviceProfileUpdatedEvent#DeviceProfileUpdatedEvent(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfileUpdatedEvent(DeviceProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileUpdatedEvent.<init>(DeviceProfile)"})
  void testNewDeviceProfileUpdatedEvent() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act and Assert
    assertSame(deviceProfile, new DeviceProfileUpdatedEvent(deviceProfile).getDeviceProfile());
  }

  /**
   * Test {@link DeviceProfileUpdatedEvent#getDeviceProfile()}.
   *
   * <p>Method under test: {@link DeviceProfileUpdatedEvent#getDeviceProfile()}
   */
  @Test
  @DisplayName("Test getDeviceProfile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileUpdatedEvent.getDeviceProfile()"})
  void testGetDeviceProfile() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act and Assert
    assertSame(deviceProfile, new DeviceProfileUpdatedEvent(deviceProfile).getDeviceProfile());
  }
}
