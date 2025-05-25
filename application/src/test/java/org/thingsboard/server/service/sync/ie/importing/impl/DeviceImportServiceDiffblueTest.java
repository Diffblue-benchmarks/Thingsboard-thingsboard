package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.BaseData;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.DeviceExportData;
import org.thingsboard.server.common.data.sync.ie.EntityImportResult;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.service.sync.ie.importing.impl.BaseEntityImportService.IdProvider;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

@ExtendWith(MockitoExtension.class)
class DeviceImportServiceDiffblueTest {
  @InjectMocks
  private DeviceImportService deviceImportService;

  /**
   * Test {@link DeviceImportService#setOwner(TenantId, Device, IdProvider)}.
   * <p>
   * Method under test: {@link DeviceImportService#setOwner(TenantId, Device, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, Device, IdProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceImportService.setOwner(TenantId, Device, IdProvider)"})
  void testSetOwner() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Device device = new Device();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    deviceImportService.setOwner(tenantId, device,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    assertSame(tenantId, device.getTenantId());
  }

  /**
   * Test {@link DeviceImportService#setOwner(TenantId, Device, IdProvider)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Device} {@link Device#getCustomerId()} return {@code null}.</li>
   *   <li>Then calls {@link Device#getCustomerId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceImportService#setOwner(TenantId, Device, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, Device, IdProvider); given 'null'; when Device getCustomerId() return 'null'; then calls getCustomerId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceImportService.setOwner(TenantId, Device, IdProvider)"})
  void testSetOwner_givenNull_whenDeviceGetCustomerIdReturnNull_thenCallsGetCustomerId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Device device = mock(Device.class);
    when(device.getCustomerId()).thenReturn(null);
    doNothing().when(device).setCustomerId(Mockito.<CustomerId>any());
    doNothing().when(device).setTenantId(Mockito.<TenantId>any());
    device.setCustomerId(new CustomerId(UUID.randomUUID()));
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    deviceImportService.setOwner(tenantId, device,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    verify(device).getCustomerId();
    verify(device, atLeast(1)).setCustomerId(Mockito.<CustomerId>any());
    verify(device).setTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DeviceImportService#setOwner(TenantId, Device, IdProvider)}.
   * <ul>
   *   <li>Then calls {@link EntitiesImportCtx#getInternalId(EntityId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceImportService#setOwner(TenantId, Device, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, Device, IdProvider); then calls getInternalId(EntityId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceImportService.setOwner(TenantId, Device, IdProvider)"})
  void testSetOwner_thenCallsGetInternalId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Device device = mock(Device.class);
    when(device.getCustomerId()).thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing().when(device).setCustomerId(Mockito.<CustomerId>any());
    doNothing().when(device).setTenantId(Mockito.<TenantId>any());
    device.setCustomerId(new CustomerId(UUID.randomUUID()));
    EntitiesImportCtx ctx = mock(EntitiesImportCtx.class);
    when(ctx.getInternalId(Mockito.<EntityId>any()))
        .thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());

    // Act
    deviceImportService.setOwner(tenantId, device,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    verify(device).getCustomerId();
    verify(device, atLeast(1)).setCustomerId(Mockito.<CustomerId>any());
    verify(device).setTenantId(isA(TenantId.class));
    verify(ctx).getInternalId(isA(EntityId.class));
  }

  /**
   * Test {@link DeviceImportService#prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link DeviceProfileId} {@link EntityId#isNullUid()} return {@code false}.</li>
   *   <li>Then calls {@link DeviceProfileId#getEntityType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceImportService#prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider); given DeviceProfileId isNullUid() return 'false'; then calls getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Device DeviceImportService.prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider)"})
  void testPrepare_givenDeviceProfileIdIsNullUidReturnFalse_thenCallsGetEntityType() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.isNullUid()).thenReturn(false);
    when(deviceProfileId.getEntityType()).thenReturn(EntityType.TENANT);
    Device device = mock(Device.class);
    when(device.getDeviceProfileId()).thenReturn(deviceProfileId);
    doNothing().when(device).setDeviceProfileId(Mockito.<DeviceProfileId>any());
    doNothing().when(device).setFirmwareId(Mockito.<OtaPackageId>any());
    doNothing().when(device).setSoftwareId(Mockito.<OtaPackageId>any());
    Device old = new Device();
    DeviceExportData exportData = new DeviceExportData();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    Device actualPrepareResult = deviceImportService.prepare(ctx, device, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(device).getDeviceProfileId();
    verify(device).setDeviceProfileId(isNull());
    verify(device).setFirmwareId(isNull());
    verify(device).setSoftwareId(isNull());
    verify(deviceProfileId).getEntityType();
    verify(deviceProfileId).isNullUid();
    assertSame(device, actualPrepareResult);
  }

  /**
   * Test {@link DeviceImportService#prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link DeviceProfileId} {@link EntityId#isNullUid()} return {@code true}.</li>
   *   <li>Then calls {@link EntityId#isNullUid()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceImportService#prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider); given DeviceProfileId isNullUid() return 'true'; then calls isNullUid()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Device DeviceImportService.prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider)"})
  void testPrepare_givenDeviceProfileIdIsNullUidReturnTrue_thenCallsIsNullUid() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.isNullUid()).thenReturn(true);
    Device device = mock(Device.class);
    when(device.getDeviceProfileId()).thenReturn(deviceProfileId);
    doNothing().when(device).setDeviceProfileId(Mockito.<DeviceProfileId>any());
    doNothing().when(device).setFirmwareId(Mockito.<OtaPackageId>any());
    doNothing().when(device).setSoftwareId(Mockito.<OtaPackageId>any());
    Device old = new Device();
    DeviceExportData exportData = new DeviceExportData();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    Device actualPrepareResult = deviceImportService.prepare(ctx, device, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(device).getDeviceProfileId();
    verify(device).setDeviceProfileId(isNull());
    verify(device).setFirmwareId(isNull());
    verify(device).setSoftwareId(isNull());
    verify(deviceProfileId).isNullUid();
    assertSame(device, actualPrepareResult);
  }

  /**
   * Test {@link DeviceImportService#prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@link DeviceProfileId} {@link EntityId#isNullUid()} return {@code true}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link EntityId#isNullUid()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceImportService#prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider); given DeviceProfileId isNullUid() return 'true'; when 'null'; then calls isNullUid()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Device DeviceImportService.prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider)"})
  void testPrepare_givenDeviceProfileIdIsNullUidReturnTrue_whenNull_thenCallsIsNullUid() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    DeviceProfileId deviceProfileId = mock(DeviceProfileId.class);
    when(deviceProfileId.isNullUid()).thenReturn(true);
    Device device = mock(Device.class);
    when(device.getDeviceProfileId()).thenReturn(deviceProfileId);
    doNothing().when(device).setDeviceProfileId(Mockito.<DeviceProfileId>any());
    doNothing().when(device).setFirmwareId(Mockito.<OtaPackageId>any());
    doNothing().when(device).setSoftwareId(Mockito.<OtaPackageId>any());
    DeviceExportData exportData = new DeviceExportData();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    Device actualPrepareResult = deviceImportService.prepare(ctx, device, null, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(device).getDeviceProfileId();
    verify(device).setDeviceProfileId(isNull());
    verify(device).setFirmwareId(isNull());
    verify(device).setSoftwareId(isNull());
    verify(deviceProfileId).isNullUid();
    assertSame(device, actualPrepareResult);
  }

  /**
   * Test {@link DeviceImportService#prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Device} {@link Device#getDeviceProfileId()} return {@code null}.</li>
   *   <li>Then return {@link Device}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceImportService#prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider); given 'null'; when Device getDeviceProfileId() return 'null'; then return Device")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Device DeviceImportService.prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider)"})
  void testPrepare_givenNull_whenDeviceGetDeviceProfileIdReturnNull_thenReturnDevice() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    Device device = mock(Device.class);
    when(device.getDeviceProfileId()).thenReturn(null);
    doNothing().when(device).setDeviceProfileId(Mockito.<DeviceProfileId>any());
    doNothing().when(device).setFirmwareId(Mockito.<OtaPackageId>any());
    doNothing().when(device).setSoftwareId(Mockito.<OtaPackageId>any());
    Device old = new Device();
    DeviceExportData exportData = new DeviceExportData();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    Device actualPrepareResult = deviceImportService.prepare(ctx, device, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(device).getDeviceProfileId();
    verify(device).setDeviceProfileId(isNull());
    verify(device).setFirmwareId(isNull());
    verify(device).setSoftwareId(isNull());
    assertSame(device, actualPrepareResult);
  }

  /**
   * Test {@link DeviceImportService#prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider)}.
   * <ul>
   *   <li>When {@link Device#Device()}.</li>
   *   <li>Then return {@link Device#Device()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceImportService#prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider); when Device(); then return Device()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Device DeviceImportService.prepare(EntitiesImportCtx, Device, Device, DeviceExportData, IdProvider)"})
  void testPrepare_whenDevice_thenReturnDevice() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    Device device = new Device();
    Device old = new Device();
    DeviceExportData exportData = new DeviceExportData();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act and Assert
    assertSame(device, deviceImportService.prepare(ctx, device, old, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult())));
  }

  /**
   * Test {@link DeviceImportService#deepCopy(Device)} with {@code Device}.
   * <ul>
   *   <li>When {@link Device#Device(Device)} with device is {@link Device#Device()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceImportService#deepCopy(Device)}
   */
  @Test
  @DisplayName("Test deepCopy(Device) with 'Device'; when Device(Device) with device is Device()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Device DeviceImportService.deepCopy(Device)"})
  void testDeepCopyWithDevice_whenDeviceWithDeviceIsDevice() {
    // Arrange and Act
    Device actualDeepCopyResult = deviceImportService.deepCopy(new Device(new Device()));

    // Assert
    assertTrue(actualDeepCopyResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualDeepCopyResult.getDeviceDataBytes());
    assertNull(actualDeepCopyResult.getVersion());
    assertNull(actualDeepCopyResult.getLabel());
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getType());
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getDeviceData());
    assertNull(actualDeepCopyResult.getCustomerId());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getId());
    assertNull(actualDeepCopyResult.getDeviceProfileId());
    assertNull(actualDeepCopyResult.getFirmwareId());
    assertNull(actualDeepCopyResult.getSoftwareId());
    assertNull(actualDeepCopyResult.getTenantId());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
  }

  /**
   * Test {@link DeviceImportService#deepCopy(Device)} with {@code Device}.
   * <ul>
   *   <li>When {@link Device#Device()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceImportService#deepCopy(Device)}
   */
  @Test
  @DisplayName("Test deepCopy(Device) with 'Device'; when Device(); then AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Device DeviceImportService.deepCopy(Device)"})
  void testDeepCopyWithDevice_whenDevice_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Device actualDeepCopyResult = deviceImportService.deepCopy(new Device());

    // Assert
    assertTrue(actualDeepCopyResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualDeepCopyResult.getDeviceDataBytes());
    assertNull(actualDeepCopyResult.getVersion());
    assertNull(actualDeepCopyResult.getLabel());
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getType());
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getDeviceData());
    assertNull(actualDeepCopyResult.getCustomerId());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getId());
    assertNull(actualDeepCopyResult.getDeviceProfileId());
    assertNull(actualDeepCopyResult.getFirmwareId());
    assertNull(actualDeepCopyResult.getSoftwareId());
    assertNull(actualDeepCopyResult.getTenantId());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
  }

  /**
   * Test {@link DeviceImportService#cleanupForComparison(Device)} with {@code Device}.
   * <ul>
   *   <li>Then calls {@link BaseData#setCreatedTime(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceImportService#cleanupForComparison(Device)}
   */
  @Test
  @DisplayName("Test cleanupForComparison(Device) with 'Device'; then calls setCreatedTime(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceImportService.cleanupForComparison(Device)"})
  void testCleanupForComparisonWithDevice_thenCallsSetCreatedTime() {
    // Arrange
    Device e = mock(Device.class);
    when(e.getCustomerId()).thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing().when(e).setCreatedTime(anyLong());
    doNothing().when(e).setTenantId(Mockito.<TenantId>any());
    doNothing().when(e).setVersion(Mockito.<Long>any());

    // Act
    deviceImportService.cleanupForComparison(e);

    // Assert
    verify(e).setCreatedTime(eq(0L));
    verify(e, atLeast(1)).getCustomerId();
    verify(e).setTenantId(isNull());
    verify(e).setVersion(isNull());
  }

  /**
   * Test {@link DeviceImportService#updateRelatedEntitiesIfUnmodified(EntitiesImportCtx, Device, DeviceExportData, IdProvider)}.
   * <ul>
   *   <li>When {@link DeviceExportData} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceImportService#updateRelatedEntitiesIfUnmodified(EntitiesImportCtx, Device, DeviceExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test updateRelatedEntitiesIfUnmodified(EntitiesImportCtx, Device, DeviceExportData, IdProvider); when DeviceExportData (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean DeviceImportService.updateRelatedEntitiesIfUnmodified(EntitiesImportCtx, Device, DeviceExportData, IdProvider)"})
  void testUpdateRelatedEntitiesIfUnmodified_whenDeviceExportData_thenReturnFalse() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    Device prepared = new Device();
    DeviceExportData exportData = new DeviceExportData();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act and Assert
    assertFalse(deviceImportService.updateRelatedEntitiesIfUnmodified(ctx, prepared, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult())));
  }

  /**
   * Test {@link DeviceImportService#getEntityType()}.
   * <p>
   * Method under test: {@link DeviceImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType DeviceImportService.getEntityType()"})
  void testGetEntityType() {
    // Arrange
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();

    // Act and Assert
    assertEquals(EntityType.DEVICE,
        (new DeviceImportService(deviceService,
            new DeviceCredentialsServiceImpl(deviceCredentialsDao2, new DeviceCredentialsDataValidator())))
            .getEntityType());
  }
}
