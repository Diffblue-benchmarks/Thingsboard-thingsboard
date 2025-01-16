package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.BaseData;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.device.DeviceProfileService;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;

class DeviceProfileImportServiceDiffblueTest {
  /**
   * Test {@link DeviceProfileImportService#deepCopy(DeviceProfile)} with
   * {@code DeviceProfile}.
   * <p>
   * Method under test: {@link DeviceProfileImportService#deepCopy(DeviceProfile)}
   */
  @Test
  @DisplayName("Test deepCopy(DeviceProfile) with 'DeviceProfile'")
  void testDeepCopyWithDeviceProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileImportService deviceProfileImportService = new DeviceProfileImportService(
        mock(DeviceProfileService.class));
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act and Assert
    assertEquals(deviceProfile, deviceProfileImportService.deepCopy(deviceProfile));
  }

  /**
   * Test {@link DeviceProfileImportService#deepCopy(DeviceProfile)} with
   * {@code DeviceProfile}.
   * <ul>
   *   <li>Then return {@link DeviceProfile#DeviceProfile()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileImportService#deepCopy(DeviceProfile)}
   */
  @Test
  @DisplayName("Test deepCopy(DeviceProfile) with 'DeviceProfile'; then return DeviceProfile()")
  void testDeepCopyWithDeviceProfile_thenReturnDeviceProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileImportService deviceProfileImportService = new DeviceProfileImportService(
        new DeviceProfileServiceImpl());
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act and Assert
    assertEquals(deviceProfile, deviceProfileImportService.deepCopy(deviceProfile));
  }

  /**
   * Test {@link DeviceProfileImportService#cleanupForComparison(DeviceProfile)}
   * with {@code DeviceProfile}.
   * <ul>
   *   <li>Then calls {@link BaseData#setCreatedTime(long)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProfileImportService#cleanupForComparison(DeviceProfile)}
   */
  @Test
  @DisplayName("Test cleanupForComparison(DeviceProfile) with 'DeviceProfile'; then calls setCreatedTime(long)")
  void testCleanupForComparisonWithDeviceProfile_thenCallsSetCreatedTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileImportService deviceProfileImportService = new DeviceProfileImportService(
        new DeviceProfileServiceImpl());
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doNothing().when(deviceProfile).setCreatedTime(anyLong());
    doNothing().when(deviceProfile).setFirmwareId(Mockito.<OtaPackageId>any());
    doNothing().when(deviceProfile).setSoftwareId(Mockito.<OtaPackageId>any());
    doNothing().when(deviceProfile).setTenantId(Mockito.<TenantId>any());
    doNothing().when(deviceProfile).setVersion(Mockito.<Long>any());

    // Act
    deviceProfileImportService.cleanupForComparison(deviceProfile);

    // Assert that nothing has changed
    verify(deviceProfile).setCreatedTime(eq(0L));
    verify(deviceProfile).setFirmwareId(isNull());
    verify(deviceProfile).setSoftwareId(isNull());
    verify(deviceProfile).setTenantId(isNull());
    verify(deviceProfile).setVersion(isNull());
  }

  /**
   * Test {@link DeviceProfileImportService#getEntityType()}.
   * <p>
   * Method under test: {@link DeviceProfileImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.DEVICE_PROFILE,
        (new DeviceProfileImportService(new DeviceProfileServiceImpl())).getEntityType());
  }
}
