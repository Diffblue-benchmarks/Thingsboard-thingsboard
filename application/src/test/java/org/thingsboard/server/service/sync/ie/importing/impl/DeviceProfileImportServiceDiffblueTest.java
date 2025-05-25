package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.BaseData;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.ie.EntityImportResult;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.service.sync.ie.importing.impl.BaseEntityImportService.IdProvider;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

@ExtendWith(MockitoExtension.class)
class DeviceProfileImportServiceDiffblueTest {
  @InjectMocks
  private DeviceProfileImportService deviceProfileImportService;

  /**
   * Test {@link DeviceProfileImportService#setOwner(TenantId, DeviceProfile, IdProvider)}.
   * <p>
   * Method under test: {@link DeviceProfileImportService#setOwner(TenantId, DeviceProfile, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, DeviceProfile, IdProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfileImportService.setOwner(TenantId, DeviceProfile, IdProvider)"})
  void testSetOwner() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceProfile deviceProfile = new DeviceProfile();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    deviceProfileImportService.setOwner(tenantId, deviceProfile,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    assertSame(tenantId, deviceProfile.getTenantId());
  }

  /**
   * Test {@link DeviceProfileImportService#setOwner(TenantId, DeviceProfile, IdProvider)}.
   * <ul>
   *   <li>When {@link DeviceProfile} {@link DeviceProfile#setTenantId(TenantId)} does nothing.</li>
   *   <li>Then calls {@link DeviceProfile#setTenantId(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileImportService#setOwner(TenantId, DeviceProfile, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, DeviceProfile, IdProvider); when DeviceProfile setTenantId(TenantId) does nothing; then calls setTenantId(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfileImportService.setOwner(TenantId, DeviceProfile, IdProvider)"})
  void testSetOwner_whenDeviceProfileSetTenantIdDoesNothing_thenCallsSetTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doNothing().when(deviceProfile).setTenantId(Mockito.<TenantId>any());
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    deviceProfileImportService.setOwner(tenantId, deviceProfile,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    verify(deviceProfile).setTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DeviceProfileImportService#prepare(EntitiesImportCtx, DeviceProfile, DeviceProfile, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Then {@link DeviceProfile#DeviceProfile()} DefaultRuleChainId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileImportService#prepare(EntitiesImportCtx, DeviceProfile, DeviceProfile, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, DeviceProfile, DeviceProfile, EntityExportData, IdProvider); then DeviceProfile() DefaultRuleChainId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DeviceProfile DeviceProfileImportService.prepare(EntitiesImportCtx, DeviceProfile, DeviceProfile, EntityExportData, IdProvider)"})
  void testPrepare_thenDeviceProfileDefaultRuleChainIdIsNull() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    DeviceProfile deviceProfile = new DeviceProfile();
    DeviceProfile old = new DeviceProfile();
    EntityExportData<DeviceProfile> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    DeviceProfile actualPrepareResult = deviceProfileImportService.prepare(ctx, deviceProfile, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    assertNull(deviceProfile.getDefaultRuleChainId());
    assertSame(deviceProfile, actualPrepareResult);
  }

  /**
   * Test {@link DeviceProfileImportService#prepare(EntitiesImportCtx, DeviceProfile, DeviceProfile, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>When {@link DeviceProfile#DeviceProfile()} DefaultRuleChainId is {@link RuleChainId}.</li>
   *   <li>Then calls {@link EntityId#isNullUid()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileImportService#prepare(EntitiesImportCtx, DeviceProfile, DeviceProfile, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, DeviceProfile, DeviceProfile, EntityExportData, IdProvider); when DeviceProfile() DefaultRuleChainId is RuleChainId; then calls isNullUid()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "DeviceProfile DeviceProfileImportService.prepare(EntitiesImportCtx, DeviceProfile, DeviceProfile, EntityExportData, IdProvider)"})
  void testPrepare_whenDeviceProfileDefaultRuleChainIdIsRuleChainId_thenCallsIsNullUid() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    RuleChainId defaultRuleChainId = mock(RuleChainId.class);
    when(defaultRuleChainId.isNullUid()).thenReturn(true);

    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefaultRuleChainId(defaultRuleChainId);
    DeviceProfile old = new DeviceProfile();
    EntityExportData<DeviceProfile> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    DeviceProfile actualPrepareResult = deviceProfileImportService.prepare(ctx, deviceProfile, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(defaultRuleChainId).isNullUid();
    assertNull(deviceProfile.getDefaultRuleChainId());
    assertSame(deviceProfile, actualPrepareResult);
  }

  /**
   * Test {@link DeviceProfileImportService#deepCopy(DeviceProfile)} with {@code DeviceProfile}.
   * <ul>
   *   <li>When {@link DeviceProfile#DeviceProfile()}.</li>
   *   <li>Then return {@link DeviceProfile#DeviceProfile()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileImportService#deepCopy(DeviceProfile)}
   */
  @Test
  @DisplayName("Test deepCopy(DeviceProfile) with 'DeviceProfile'; when DeviceProfile(); then return DeviceProfile()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeviceProfile DeviceProfileImportService.deepCopy(DeviceProfile)"})
  void testDeepCopyWithDeviceProfile_whenDeviceProfile_thenReturnDeviceProfile() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();

    // Act and Assert
    assertEquals(deviceProfile, deviceProfileImportService.deepCopy(deviceProfile));
  }

  /**
   * Test {@link DeviceProfileImportService#cleanupForComparison(DeviceProfile)} with {@code DeviceProfile}.
   * <ul>
   *   <li>Then calls {@link BaseData#setCreatedTime(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileImportService#cleanupForComparison(DeviceProfile)}
   */
  @Test
  @DisplayName("Test cleanupForComparison(DeviceProfile) with 'DeviceProfile'; then calls setCreatedTime(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfileImportService.cleanupForComparison(DeviceProfile)"})
  void testCleanupForComparisonWithDeviceProfile_thenCallsSetCreatedTime() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    doNothing().when(deviceProfile).setCreatedTime(anyLong());
    doNothing().when(deviceProfile).setFirmwareId(Mockito.<OtaPackageId>any());
    doNothing().when(deviceProfile).setSoftwareId(Mockito.<OtaPackageId>any());
    doNothing().when(deviceProfile).setTenantId(Mockito.<TenantId>any());
    doNothing().when(deviceProfile).setVersion(Mockito.<Long>any());

    // Act
    deviceProfileImportService.cleanupForComparison(deviceProfile);

    // Assert
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType DeviceProfileImportService.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.DEVICE_PROFILE,
        (new DeviceProfileImportService(new DeviceProfileServiceImpl())).getEntityType());
  }
}
