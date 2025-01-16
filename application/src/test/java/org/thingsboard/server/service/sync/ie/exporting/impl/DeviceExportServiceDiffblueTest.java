package org.thingsboard.server.service.sync.ie.exporting.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.sync.ie.DeviceExportData;
import org.thingsboard.server.common.data.sync.ie.EntityExportSettings;
import org.thingsboard.server.dao.device.DeviceCredentialsService;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.service.sync.vc.data.EntitiesExportCtx;

class DeviceExportServiceDiffblueTest {
  /**
   * Test
   * {@link DeviceExportService#setRelatedEntities(EntitiesExportCtx, Device, DeviceExportData)}
   * with {@code EntitiesExportCtx}, {@code Device}, {@code DeviceExportData}.
   * <p>
   * Method under test:
   * {@link DeviceExportService#setRelatedEntities(EntitiesExportCtx, Device, DeviceExportData)}
   */
  @Test
  @DisplayName("Test setRelatedEntities(EntitiesExportCtx, Device, DeviceExportData) with 'EntitiesExportCtx', 'Device', 'DeviceExportData'")
  void testSetRelatedEntitiesWithEntitiesExportCtxDeviceDeviceExportData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    when(deviceCredentialsService.findDeviceCredentialsByDeviceId(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(deviceCredentials);
    DeviceExportService deviceExportService = new DeviceExportService(deviceCredentialsService);
    EntitiesExportCtx<?> ctx = mock(EntitiesExportCtx.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    EntityExportSettings buildResult = EntityExportSettings.builder()
        .exportAttributes(true)
        .exportCredentials(true)
        .exportRelations(true)
        .build();
    when(ctx.getSettings()).thenReturn(buildResult);
    Device device = new Device();
    DeviceExportData exportData = new DeviceExportData();

    // Act
    deviceExportService.setRelatedEntities(ctx, device, exportData);

    // Assert
    verify(deviceCredentialsService).findDeviceCredentialsByDeviceId(isA(TenantId.class), isNull());
    verify(ctx).getSettings();
    verify(ctx).getTenantId();
    assertNull(device.getCustomerId());
    assertTrue(exportData.hasCredentials());
    assertSame(deviceCredentials, exportData.getCredentials());
  }

  /**
   * Test
   * {@link DeviceExportService#setRelatedEntities(EntitiesExportCtx, Device, DeviceExportData)}
   * with {@code EntitiesExportCtx}, {@code Device}, {@code DeviceExportData}.
   * <p>
   * Method under test:
   * {@link DeviceExportService#setRelatedEntities(EntitiesExportCtx, Device, DeviceExportData)}
   */
  @Test
  @DisplayName("Test setRelatedEntities(EntitiesExportCtx, Device, DeviceExportData) with 'EntitiesExportCtx', 'Device', 'DeviceExportData'")
  void testSetRelatedEntitiesWithEntitiesExportCtxDeviceDeviceExportData2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceExportService deviceExportService = new DeviceExportService(mock(DeviceCredentialsService.class));
    EntitiesExportCtx<?> ctx = mock(EntitiesExportCtx.class);
    EntityExportSettings buildResult = EntityExportSettings.builder()
        .exportAttributes(true)
        .exportCredentials(false)
        .exportRelations(true)
        .build();
    when(ctx.getSettings()).thenReturn(buildResult);
    Device device = new Device();
    DeviceExportData exportData = new DeviceExportData();

    // Act
    deviceExportService.setRelatedEntities(ctx, device, exportData);

    // Assert
    verify(ctx).getSettings();
    assertNull(device.getCustomerId());
    assertNull(exportData.getCredentials());
    assertFalse(exportData.hasCredentials());
  }

  /**
   * Test
   * {@link DeviceExportService#setRelatedEntities(EntitiesExportCtx, Device, DeviceExportData)}
   * with {@code EntitiesExportCtx}, {@code Device}, {@code DeviceExportData}.
   * <p>
   * Method under test:
   * {@link DeviceExportService#setRelatedEntities(EntitiesExportCtx, Device, DeviceExportData)}
   */
  @Test
  @DisplayName("Test setRelatedEntities(EntitiesExportCtx, Device, DeviceExportData) with 'EntitiesExportCtx', 'Device', 'DeviceExportData'")
  void testSetRelatedEntitiesWithEntitiesExportCtxDeviceDeviceExportData3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    DeviceCredentials deviceCredentials = new DeviceCredentials();
    when(deviceCredentialsService.findDeviceCredentialsByDeviceId(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(deviceCredentials);
    DeviceExportService deviceExportService = new DeviceExportService(deviceCredentialsService);
    EntitiesExportCtx<?> ctx = mock(EntitiesExportCtx.class);
    UUID id = UUID.randomUUID();
    CustomerId customerId = new CustomerId(id);
    when(ctx.getExternalId(Mockito.<CustomerId>any())).thenReturn(customerId);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    EntityExportSettings buildResult = EntityExportSettings.builder()
        .exportAttributes(true)
        .exportCredentials(true)
        .exportRelations(true)
        .build();
    when(ctx.getSettings()).thenReturn(buildResult);

    Device device = new Device();
    device.setCustomerId(new CustomerId(null));
    DeviceExportData exportData = new DeviceExportData();

    // Act
    deviceExportService.setRelatedEntities(ctx, device, exportData);

    // Assert
    verify(deviceCredentialsService).findDeviceCredentialsByDeviceId(isA(TenantId.class), isNull());
    verify(ctx).getExternalId(isA(CustomerId.class));
    verify(ctx).getSettings();
    verify(ctx).getTenantId();
    assertTrue(exportData.hasCredentials());
    CustomerId customerId2 = device.getCustomerId();
    assertSame(customerId, customerId2);
    assertSame(deviceCredentials, exportData.getCredentials());
    assertSame(id, customerId2.getId());
  }

  /**
   * Test {@link DeviceExportService#newExportData()}.
   * <p>
   * Method under test: {@link DeviceExportService#newExportData()}
   */
  @Test
  @DisplayName("Test newExportData()")
  void testNewExportData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();

    // Act
    DeviceExportData actualNewExportDataResult = (new DeviceExportService(
        new DeviceCredentialsServiceImpl(deviceCredentialsDao, new DeviceCredentialsDataValidator()))).newExportData();

    // Assert
    assertNull(actualNewExportDataResult.getRelations());
    assertNull(actualNewExportDataResult.getAttributes());
    assertNull(actualNewExportDataResult.getEntity());
    assertNull(actualNewExportDataResult.getEntityType());
    assertNull(actualNewExportDataResult.getCredentials());
    assertFalse(actualNewExportDataResult.hasCredentials());
    assertFalse(actualNewExportDataResult.hasAttributes());
    assertFalse(actualNewExportDataResult.hasRelations());
  }

  /**
   * Test {@link DeviceExportService#newExportData()}.
   * <p>
   * Method under test: {@link DeviceExportService#newExportData()}
   */
  @Test
  @DisplayName("Test newExportData()")
  void testNewExportData2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceCredentialsDao deviceCredentialsDao = mock(JpaDeviceCredentialsDao.class);

    // Act
    DeviceExportData actualNewExportDataResult = (new DeviceExportService(
        new DeviceCredentialsServiceImpl(deviceCredentialsDao, new DeviceCredentialsDataValidator()))).newExportData();

    // Assert
    assertNull(actualNewExportDataResult.getRelations());
    assertNull(actualNewExportDataResult.getAttributes());
    assertNull(actualNewExportDataResult.getEntity());
    assertNull(actualNewExportDataResult.getEntityType());
    assertNull(actualNewExportDataResult.getCredentials());
    assertFalse(actualNewExportDataResult.hasCredentials());
    assertFalse(actualNewExportDataResult.hasAttributes());
    assertFalse(actualNewExportDataResult.hasRelations());
  }

  /**
   * Test {@link DeviceExportService#getSupportedEntityTypes()}.
   * <p>
   * Method under test: {@link DeviceExportService#getSupportedEntityTypes()}
   */
  @Test
  @DisplayName("Test getSupportedEntityTypes()")
  void testGetSupportedEntityTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();

    // Act
    Set<EntityType> actualSupportedEntityTypes = (new DeviceExportService(
        new DeviceCredentialsServiceImpl(deviceCredentialsDao, new DeviceCredentialsDataValidator())))
        .getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.DEVICE));
  }

  /**
   * Test {@link DeviceExportService#getSupportedEntityTypes()}.
   * <p>
   * Method under test: {@link DeviceExportService#getSupportedEntityTypes()}
   */
  @Test
  @DisplayName("Test getSupportedEntityTypes()")
  void testGetSupportedEntityTypes2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDeviceCredentialsDao deviceCredentialsDao = mock(JpaDeviceCredentialsDao.class);

    // Act
    Set<EntityType> actualSupportedEntityTypes = (new DeviceExportService(
        new DeviceCredentialsServiceImpl(deviceCredentialsDao, new DeviceCredentialsDataValidator())))
        .getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.DEVICE));
  }
}
