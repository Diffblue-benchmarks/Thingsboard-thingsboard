package org.thingsboard.server.service.entitiy.device.profile;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.device.DeviceProfileService;

class DefaultTbDeviceProfileServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultTbDeviceProfileService#setDefaultDeviceProfile(DeviceProfile, DeviceProfile, User)}.
   * <ul>
   *   <li>Then return {@link DeviceProfile#DeviceProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDeviceProfileService#setDefaultDeviceProfile(DeviceProfile, DeviceProfile, User)}
   */
  @Test
  @DisplayName("Test setDefaultDeviceProfile(DeviceProfile, DeviceProfile, User); then return DeviceProfile()")
  void testSetDefaultDeviceProfile_thenReturnDeviceProfile() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    when(deviceProfileService.setDefaultDeviceProfile(Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(false);
    DefaultTbDeviceProfileService defaultTbDeviceProfileService = new DefaultTbDeviceProfileService(
        deviceProfileService);
    DeviceProfile deviceProfile = new DeviceProfile();
    DeviceProfile previousDefaultDeviceProfile = new DeviceProfile();

    // Act
    DeviceProfile actualSetDefaultDeviceProfileResult = defaultTbDeviceProfileService
        .setDefaultDeviceProfile(deviceProfile, previousDefaultDeviceProfile, new User());

    // Assert
    verify(deviceProfileService).setDefaultDeviceProfile(isNull(), isNull());
    assertSame(deviceProfile, actualSetDefaultDeviceProfileResult);
  }
}
