package org.thingsboard.server.common.transport.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.id.DeviceProfileId;

class DefaultTransportDeviceProfileCacheDiffblueTest {
  /**
   * Test {@link DefaultTransportDeviceProfileCache#put(DeviceProfile)} with
   * {@code profile}.
   * <ul>
   *   <li>Given {@link DeviceProfileId#DeviceProfileId(UUID)} with id is
   * randomUUID.</li>
   *   <li>Then calls {@link DeviceProfile#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTransportDeviceProfileCache#put(DeviceProfile)}
   */
  @Test
  @DisplayName("Test put(DeviceProfile) with 'profile'; given DeviceProfileId(UUID) with id is randomUUID; then calls getId()")
  void testPutWithProfile_givenDeviceProfileIdWithIdIsRandomUUID_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTransportDeviceProfileCache defaultTransportDeviceProfileCache = new DefaultTransportDeviceProfileCache();
    DeviceProfile profile = mock(DeviceProfile.class);
    when(profile.getId()).thenReturn(new DeviceProfileId(UUID.randomUUID()));

    // Act
    defaultTransportDeviceProfileCache.put(profile);

    // Assert
    verify(profile).getId();
  }
}
