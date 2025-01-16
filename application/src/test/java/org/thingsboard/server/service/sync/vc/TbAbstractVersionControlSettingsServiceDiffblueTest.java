package org.thingsboard.server.service.sync.vc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.Serializable;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.vc.AutoCommitSettings;
import org.thingsboard.server.common.data.sync.vc.request.create.AutoVersionCreateConfig;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.service.sync.vc.autocommit.AutoCommitSettingsCaffeineCache;
import org.thingsboard.server.service.sync.vc.autocommit.DefaultTbAutoCommitSettingsService;

class TbAbstractVersionControlSettingsServiceDiffblueTest {
  /**
   * Test
   * {@link TbAbstractVersionControlSettingsService#save(TenantId, Serializable)}.
   * <p>
   * Method under test:
   * {@link TbAbstractVersionControlSettingsService#save(TenantId, Serializable)}
   */
  @Test
  @DisplayName("Test save(TenantId, Serializable)")
  void testSave() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    when(adminSettingsService.saveAdminSettings(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(new AdminSettings());
    DefaultTbAutoCommitSettingsService defaultTbAutoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    AutoCommitSettings actualSaveResult = defaultTbAutoCommitSettingsService.save(tenantId, new AutoCommitSettings());

    // Assert
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("autoCommitSettings"));
    verify(adminSettingsService).saveAdminSettings(isA(TenantId.class), isA(AdminSettings.class));
    assertNull(actualSaveResult);
  }

  /**
   * Test
   * {@link TbAbstractVersionControlSettingsService#save(TenantId, Serializable)}.
   * <p>
   * Method under test:
   * {@link TbAbstractVersionControlSettingsService#save(TenantId, Serializable)}
   */
  @Test
  @DisplayName("Test save(TenantId, Serializable)")
  void testSave2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    when(adminSettingsService.saveAdminSettings(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(new AdminSettings());
    DefaultTbAutoCommitSettingsService defaultTbAutoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    AutoCommitSettings actualSaveResult = defaultTbAutoCommitSettingsService.save(tenantId, new AutoCommitSettings());

    // Assert
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("autoCommitSettings"));
    verify(adminSettingsService).saveAdminSettings(isA(TenantId.class), isA(AdminSettings.class));
    assertNull(actualSaveResult);
  }

  /**
   * Test
   * {@link TbAbstractVersionControlSettingsService#save(TenantId, Serializable)}.
   * <ul>
   *   <li>Given {@link AutoVersionCreateConfig} (default constructor) Branch is
   * {@code janedoe/featurebranch}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractVersionControlSettingsService#save(TenantId, Serializable)}
   */
  @Test
  @DisplayName("Test save(TenantId, Serializable); given AutoVersionCreateConfig (default constructor) Branch is 'janedoe/featurebranch'")
  void testSave_givenAutoVersionCreateConfigBranchIsJanedoeFeaturebranch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    doThrow(new RuntimeException("foo")).when(adminSettings).setJsonValue(Mockito.<JsonNode>any());
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    DefaultTbAutoCommitSettingsService defaultTbAutoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    AutoVersionCreateConfig autoVersionCreateConfig = new AutoVersionCreateConfig();
    autoVersionCreateConfig.setBranch("janedoe/featurebranch");
    autoVersionCreateConfig.setSaveAttributes(true);
    autoVersionCreateConfig.setSaveCredentials(true);
    autoVersionCreateConfig.setSaveRelations(true);

    AutoCommitSettings autoCommitSettings = new AutoCommitSettings();
    autoCommitSettings.put(EntityType.TENANT, autoVersionCreateConfig);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultTbAutoCommitSettingsService.save(tenantId, autoCommitSettings));
    verify(adminSettings).setJsonValue(isA(JsonNode.class));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("autoCommitSettings"));
  }

  /**
   * Test
   * {@link TbAbstractVersionControlSettingsService#save(TenantId, Serializable)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractVersionControlSettingsService#save(TenantId, Serializable)}
   */
  @Test
  @DisplayName("Test save(TenantId, Serializable); then throw RuntimeException")
  void testSave_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    doThrow(new RuntimeException("foo")).when(adminSettings).setJsonValue(Mockito.<JsonNode>any());
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    DefaultTbAutoCommitSettingsService defaultTbAutoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbAutoCommitSettingsService.save(tenantId, new AutoCommitSettings()));
    verify(adminSettings).setJsonValue(isA(JsonNode.class));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("autoCommitSettings"));
  }

  /**
   * Test {@link TbAbstractVersionControlSettingsService#delete(TenantId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractVersionControlSettingsService#delete(TenantId)}
   */
  @Test
  @DisplayName("Test delete(TenantId); then return 'false'")
  void testDelete_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.deleteAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(false);
    DefaultTbAutoCommitSettingsService defaultTbAutoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    // Act
    boolean actualDeleteResult = defaultTbAutoCommitSettingsService.delete(new TenantId(UUID.randomUUID()));

    // Assert
    verify(adminSettingsService).deleteAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("autoCommitSettings"));
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link TbAbstractVersionControlSettingsService#delete(TenantId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractVersionControlSettingsService#delete(TenantId)}
   */
  @Test
  @DisplayName("Test delete(TenantId); then return 'true'")
  void testDelete_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.deleteAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(true);
    DefaultTbAutoCommitSettingsService defaultTbAutoCommitSettingsService = new DefaultTbAutoCommitSettingsService(
        adminSettingsService, new AutoCommitSettingsCaffeineCache(new CaffeineCacheManager()));

    // Act
    boolean actualDeleteResult = defaultTbAutoCommitSettingsService.delete(new TenantId(UUID.randomUUID()));

    // Assert
    verify(adminSettingsService).deleteAdminSettingsByTenantIdAndKey(isA(TenantId.class), eq("autoCommitSettings"));
    assertTrue(actualDeleteResult);
  }
}
