package org.thingsboard.server.service.profile;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.device.DeviceProfileService;
import org.thingsboard.server.dao.device.DeviceService;

@ContextConfiguration(classes = {DefaultTbDeviceProfileCache.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
class DefaultTbDeviceProfileCacheDiffblueTest {
  @Autowired
  private DefaultTbDeviceProfileCache defaultTbDeviceProfileCache;

  @MockBean
  private DeviceProfileService deviceProfileService;

  @MockBean
  private DeviceService deviceService;

  /**
   * Test {@link DefaultTbDeviceProfileCache#get(TenantId, DeviceId)} with
   * {@code tenantId}, {@code deviceId}.
   * <p>
   * Method under test:
   * {@link DefaultTbDeviceProfileCache#get(TenantId, DeviceId)}
   */
  @Test
  @DisplayName("Test get(TenantId, DeviceId) with 'tenantId', 'deviceId'")
  void testGetWithTenantIdDeviceId() {
    // Arrange
    when(deviceProfileService.findDeviceProfileById(Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(null);

    Device device = new Device();
    device.setDeviceProfileId(new DeviceProfileId(UUID.randomUUID()));
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(device);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    DeviceProfile actualGetResult = defaultTbDeviceProfileCache.get(tenantId, new DeviceId(UUID.randomUUID()));

    // Assert
    verify(deviceProfileService).findDeviceProfileById(isA(TenantId.class), isA(DeviceProfileId.class));
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbDeviceProfileCache#get(TenantId, DeviceId)} with
   * {@code tenantId}, {@code deviceId}.
   * <p>
   * Method under test:
   * {@link DefaultTbDeviceProfileCache#get(TenantId, DeviceId)}
   */
  @Test
  @DisplayName("Test get(TenantId, DeviceId) with 'tenantId', 'deviceId'")
  void testGetWithTenantIdDeviceId2() {
    // Arrange
    when(deviceProfileService.findDeviceProfileById(Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(null);

    Device device = new Device();
    device.setDeviceProfileId(new DeviceProfileId(null));
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(device);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    DeviceProfile actualGetResult = defaultTbDeviceProfileCache.get(tenantId, new DeviceId(UUID.randomUUID()));

    // Assert
    verify(deviceProfileService).findDeviceProfileById(isA(TenantId.class), isA(DeviceProfileId.class));
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbDeviceProfileCache#get(TenantId, DeviceId)} with
   * {@code tenantId}, {@code deviceId}.
   * <ul>
   *   <li>Given {@link DeviceService}
   * {@link DeviceService#findDeviceById(TenantId, DeviceId)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDeviceProfileCache#get(TenantId, DeviceId)}
   */
  @Test
  @DisplayName("Test get(TenantId, DeviceId) with 'tenantId', 'deviceId'; given DeviceService findDeviceById(TenantId, DeviceId) return 'null'")
  void testGetWithTenantIdDeviceId_givenDeviceServiceFindDeviceByIdReturnNull() {
    // Arrange
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(null);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    DeviceProfile actualGetResult = defaultTbDeviceProfileCache.get(tenantId, new DeviceId(UUID.randomUUID()));

    // Assert
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbDeviceProfileCache#get(TenantId, DeviceId)} with
   * {@code tenantId}, {@code deviceId}.
   * <ul>
   *   <li>Then return {@link DeviceProfile#DeviceProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDeviceProfileCache#get(TenantId, DeviceId)}
   */
  @Test
  @DisplayName("Test get(TenantId, DeviceId) with 'tenantId', 'deviceId'; then return DeviceProfile()")
  void testGetWithTenantIdDeviceId_thenReturnDeviceProfile() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    when(deviceProfileService.findDeviceProfileById(Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(deviceProfile);

    Device device = new Device();
    device.setDeviceProfileId(new DeviceProfileId(UUID.randomUUID()));
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(device);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    DeviceProfile actualGetResult = defaultTbDeviceProfileCache.get(tenantId, new DeviceId(UUID.randomUUID()));

    // Assert
    verify(deviceProfileService).findDeviceProfileById(isA(TenantId.class), isA(DeviceProfileId.class));
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    assertSame(deviceProfile, actualGetResult);
  }

  /**
   * Test {@link DefaultTbDeviceProfileCache#get(TenantId, DeviceId)} with
   * {@code tenantId}, {@code deviceId}.
   * <ul>
   *   <li>When {@link DeviceId#DeviceId(UUID)} with id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDeviceProfileCache#get(TenantId, DeviceId)}
   */
  @Test
  @DisplayName("Test get(TenantId, DeviceId) with 'tenantId', 'deviceId'; when DeviceId(UUID) with id is 'null'")
  void testGetWithTenantIdDeviceId_whenDeviceIdWithIdIsNull() {
    // Arrange
    when(deviceProfileService.findDeviceProfileById(Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(null);

    Device device = new Device();
    device.setDeviceProfileId(new DeviceProfileId(UUID.randomUUID()));
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(device);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    DeviceProfile actualGetResult = defaultTbDeviceProfileCache.get(tenantId, new DeviceId(null));

    // Assert
    verify(deviceProfileService).findDeviceProfileById(isA(TenantId.class), isA(DeviceProfileId.class));
    verify(deviceService).findDeviceById(isA(TenantId.class), isA(DeviceId.class));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbDeviceProfileCache#get(TenantId, DeviceProfileId)} with
   * {@code tenantId}, {@code deviceProfileId}.
   * <ul>
   *   <li>Then return {@link DeviceProfile#DeviceProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDeviceProfileCache#get(TenantId, DeviceProfileId)}
   */
  @Test
  @DisplayName("Test get(TenantId, DeviceProfileId) with 'tenantId', 'deviceProfileId'; then return DeviceProfile()")
  void testGetWithTenantIdDeviceProfileId_thenReturnDeviceProfile() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    when(deviceProfileService.findDeviceProfileById(Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(deviceProfile);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    DeviceProfile actualGetResult = defaultTbDeviceProfileCache.get(tenantId, new DeviceProfileId(UUID.randomUUID()));

    // Assert
    verify(deviceProfileService).findDeviceProfileById(isA(TenantId.class), isA(DeviceProfileId.class));
    assertSame(deviceProfile, actualGetResult);
  }

  /**
   * Test {@link DefaultTbDeviceProfileCache#get(TenantId, DeviceProfileId)} with
   * {@code tenantId}, {@code deviceProfileId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDeviceProfileCache#get(TenantId, DeviceProfileId)}
   */
  @Test
  @DisplayName("Test get(TenantId, DeviceProfileId) with 'tenantId', 'deviceProfileId'; then return 'null'")
  void testGetWithTenantIdDeviceProfileId_thenReturnNull() {
    // Arrange
    when(deviceProfileService.findDeviceProfileById(Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(null);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    DeviceProfile actualGetResult = defaultTbDeviceProfileCache.get(tenantId, new DeviceProfileId(UUID.randomUUID()));

    // Assert
    verify(deviceProfileService).findDeviceProfileById(isA(TenantId.class), isA(DeviceProfileId.class));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbDeviceProfileCache#get(TenantId, DeviceProfileId)} with
   * {@code tenantId}, {@code deviceProfileId}.
   * <ul>
   *   <li>When {@link DeviceProfileId#DeviceProfileId(UUID)} with id is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbDeviceProfileCache#get(TenantId, DeviceProfileId)}
   */
  @Test
  @DisplayName("Test get(TenantId, DeviceProfileId) with 'tenantId', 'deviceProfileId'; when DeviceProfileId(UUID) with id is 'null'")
  void testGetWithTenantIdDeviceProfileId_whenDeviceProfileIdWithIdIsNull() {
    // Arrange
    when(deviceProfileService.findDeviceProfileById(Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(null);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    DeviceProfile actualGetResult = defaultTbDeviceProfileCache.get(tenantId, new DeviceProfileId(null));

    // Assert
    verify(deviceProfileService).findDeviceProfileById(isA(TenantId.class), isA(DeviceProfileId.class));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbDeviceProfileCache#evict(TenantId, DeviceProfileId)}
   * with {@code tenantId}, {@code profileId}.
   * <p>
   * Method under test:
   * {@link DefaultTbDeviceProfileCache#evict(TenantId, DeviceProfileId)}
   */
  @Test
  @DisplayName("Test evict(TenantId, DeviceProfileId) with 'tenantId', 'profileId'")
  void testEvictWithTenantIdProfileId() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setTenantId(new TenantId(UUID.randomUUID()));
    when(deviceProfileService.findDeviceProfileById(Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(deviceProfile);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    defaultTbDeviceProfileCache.evict(tenantId, new DeviceProfileId(UUID.randomUUID()));

    // Assert
    verify(deviceProfileService).findDeviceProfileById(isA(TenantId.class), isA(DeviceProfileId.class));
  }

  /**
   * Test {@link DefaultTbDeviceProfileCache#evict(TenantId, DeviceProfileId)}
   * with {@code tenantId}, {@code profileId}.
   * <p>
   * Method under test:
   * {@link DefaultTbDeviceProfileCache#evict(TenantId, DeviceProfileId)}
   */
  @Test
  @DisplayName("Test evict(TenantId, DeviceProfileId) with 'tenantId', 'profileId'")
  void testEvictWithTenantIdProfileId2() {
    // Arrange
    when(deviceProfileService.findDeviceProfileById(Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(null);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    defaultTbDeviceProfileCache.evict(tenantId, new DeviceProfileId(UUID.randomUUID()));

    // Assert
    verify(deviceProfileService).findDeviceProfileById(isA(TenantId.class), isA(DeviceProfileId.class));
  }

  /**
   * Test {@link DefaultTbDeviceProfileCache#find(DeviceProfileId)}.
   * <ul>
   *   <li>Then return {@link DeviceProfile#DeviceProfile()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbDeviceProfileCache#find(DeviceProfileId)}
   */
  @Test
  @DisplayName("Test find(DeviceProfileId); then return DeviceProfile()")
  void testFind_thenReturnDeviceProfile() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    when(deviceProfileService.findDeviceProfileById(Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(deviceProfile);

    // Act
    DeviceProfile actualFindResult = defaultTbDeviceProfileCache.find(null);

    // Assert
    verify(deviceProfileService).findDeviceProfileById(isA(TenantId.class), isNull());
    assertSame(deviceProfile, actualFindResult);
  }

  /**
   * Test
   * {@link DefaultTbDeviceProfileCache#findOrCreateDeviceProfile(TenantId, String)}.
   * <p>
   * Method under test:
   * {@link DefaultTbDeviceProfileCache#findOrCreateDeviceProfile(TenantId, String)}
   */
  @Test
  @DisplayName("Test findOrCreateDeviceProfile(TenantId, String)")
  void testFindOrCreateDeviceProfile() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    when(deviceProfileService.findOrCreateDeviceProfile(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(deviceProfile);

    // Act
    DeviceProfile actualFindOrCreateDeviceProfileResult = defaultTbDeviceProfileCache
        .findOrCreateDeviceProfile(new TenantId(UUID.randomUUID()), "foo.txt");

    // Assert
    verify(deviceProfileService).findOrCreateDeviceProfile(isA(TenantId.class), eq("foo.txt"));
    assertSame(deviceProfile, actualFindOrCreateDeviceProfileResult);
  }
}
