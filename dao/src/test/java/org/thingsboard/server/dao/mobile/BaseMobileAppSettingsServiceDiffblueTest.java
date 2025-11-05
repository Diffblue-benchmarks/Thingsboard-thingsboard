package org.thingsboard.server.dao.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.mobile.AndroidConfig;
import org.thingsboard.server.common.data.mobile.BadgePosition;
import org.thingsboard.server.common.data.mobile.IosConfig;
import org.thingsboard.server.common.data.mobile.MobileAppSettings;
import org.thingsboard.server.common.data.mobile.QRCodeConfig;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.service.validator.MobileAppSettingsDataValidator;
import org.thingsboard.server.dao.sql.mobile.JpaMobileAppSettingsDao;

@ContextConfiguration(classes = {BaseMobileAppSettingsService.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class BaseMobileAppSettingsServiceDiffblueTest {
  @Autowired private BaseMobileAppSettingsService baseMobileAppSettingsService;

  @MockBean private DataValidator<MobileAppSettings> dataValidator;

  @MockBean private MobileAppSettingsDao mobileAppSettingsDao;

  @MockBean private TbTransactionalCache<TenantId, MobileAppSettings> tbTransactionalCache;

  /**
   * Test {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId, MobileAppSettings)}.
   *
   * <p>Method under test: {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @DisplayName("Test saveMobileAppSettings(TenantId, MobileAppSettings)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppSettings BaseMobileAppSettingsService.saveMobileAppSettings(TenantId, MobileAppSettings)"
  })
  void testSaveMobileAppSettings() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    when(mobileAppSettingsDao.save(Mockito.<TenantId>any(), Mockito.<MobileAppSettings>any()))
        .thenReturn(null);
    when(dataValidator.validate(
            Mockito.<MobileAppSettings>any(), Mockito.<Function<MobileAppSettings, TenantId>>any()))
        .thenReturn(new MobileAppSettings());

    // Act
    MobileAppSettings actualSaveMobileAppSettingsResult =
        baseMobileAppSettingsService.saveMobileAppSettings(
            ModelConstants.SYSTEM_TENANT, new MobileAppSettings());

    // Assert
    verify(tbTransactionalCache).evict(isA(TenantId.class));
    verify(mobileAppSettingsDao).save(isA(TenantId.class), isA(MobileAppSettings.class));
    verify(dataValidator).validate(isA(MobileAppSettings.class), isA(Function.class));
    assertEquals(
        "https://apps.apple.com/us/app/thingsboard-live/id1594355695",
        actualSaveMobileAppSettingsResult.getDefaultAppStoreLink());
    assertEquals(
        "https://play.google.com/store/apps/details?id=org.thingsboard.demo.app",
        actualSaveMobileAppSettingsResult.getDefaultGooglePlayLink());
    assertNull(actualSaveMobileAppSettingsResult.getUuidId());
    assertNull(actualSaveMobileAppSettingsResult.getId());
    assertNull(actualSaveMobileAppSettingsResult.getTenantId());
    assertEquals(0L, actualSaveMobileAppSettingsResult.getCreatedTime());
    assertTrue(actualSaveMobileAppSettingsResult.isUseDefaultApp());
  }

  /**
   * Test {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId, MobileAppSettings)}.
   *
   * <p>Method under test: {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @DisplayName("Test saveMobileAppSettings(TenantId, MobileAppSettings)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppSettings BaseMobileAppSettingsService.saveMobileAppSettings(TenantId, MobileAppSettings)"
  })
  void testSaveMobileAppSettings2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());

    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.isUseDefaultApp()).thenThrow(new RuntimeException());
    when(mobileAppSettingsDao.save(Mockito.<TenantId>any(), Mockito.<MobileAppSettings>any()))
        .thenReturn(mobileAppSettings);
    when(dataValidator.validate(
            Mockito.<MobileAppSettings>any(), Mockito.<Function<MobileAppSettings, TenantId>>any()))
        .thenReturn(new MobileAppSettings());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseMobileAppSettingsService.saveMobileAppSettings(
                ModelConstants.SYSTEM_TENANT, new MobileAppSettings()));
    verify(tbTransactionalCache, atLeast(1)).evict(isA(TenantId.class));
    verify(mobileAppSettings).isUseDefaultApp();
    verify(mobileAppSettingsDao).save(isA(TenantId.class), isA(MobileAppSettings.class));
    verify(dataValidator).validate(isA(MobileAppSettings.class), isA(Function.class));
  }

  /**
   * Test {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId, MobileAppSettings)}.
   *
   * <p>Method under test: {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @DisplayName("Test saveMobileAppSettings(TenantId, MobileAppSettings)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppSettings BaseMobileAppSettingsService.saveMobileAppSettings(TenantId, MobileAppSettings)"
  })
  void testSaveMobileAppSettings3() {
    // Arrange
    JpaMobileAppSettingsDao mobileAppSettingsDao = new JpaMobileAppSettingsDao();
    BaseMobileAppSettingsService baseMobileAppSettingsService =
        new BaseMobileAppSettingsService(
            mobileAppSettingsDao, new MobileAppSettingsDataValidator());

    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.getAndroidConfig()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseMobileAppSettingsService.saveMobileAppSettings(
                ModelConstants.SYSTEM_TENANT, mobileAppSettings));
    verify(mobileAppSettings).getAndroidConfig();
  }

  /**
   * Test {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId, MobileAppSettings)}.
   *
   * <p>Method under test: {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @DisplayName("Test saveMobileAppSettings(TenantId, MobileAppSettings)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppSettings BaseMobileAppSettingsService.saveMobileAppSettings(TenantId, MobileAppSettings)"
  })
  void testSaveMobileAppSettings4() {
    // Arrange
    JpaMobileAppSettingsDao mobileAppSettingsDao = new JpaMobileAppSettingsDao();
    BaseMobileAppSettingsService baseMobileAppSettingsService =
        new BaseMobileAppSettingsService(
            mobileAppSettingsDao, new MobileAppSettingsDataValidator());

    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.getId()).thenThrow(new RuntimeException());
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(true);
    when(mobileAppSettings.getAndroidConfig())
        .thenReturn(
            AndroidConfig.builder()
                .appPackage("java.text")
                .enabled(false)
                .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
                .storeLink("Store Link")
                .build());
    when(mobileAppSettings.getIosConfig())
        .thenReturn(IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build());
    when(mobileAppSettings.getQrCodeConfig())
        .thenReturn(
            QRCodeConfig.builder()
                .badgeEnabled(true)
                .badgePosition(BadgePosition.RIGHT)
                .qrCodeLabel("Qr Code Label")
                .qrCodeLabelEnabled(true)
                .showOnHomePage(true)
                .build());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseMobileAppSettingsService.saveMobileAppSettings(
                ModelConstants.SYSTEM_TENANT, mobileAppSettings));
    verify(mobileAppSettings).getId();
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings, atLeast(1)).isUseDefaultApp();
  }

  /**
   * Test {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId, MobileAppSettings)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @DisplayName("Test saveMobileAppSettings(TenantId, MobileAppSettings); given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppSettings BaseMobileAppSettingsService.saveMobileAppSettings(TenantId, MobileAppSettings)"
  })
  void testSaveMobileAppSettings_givenFalse() {
    // Arrange
    JpaMobileAppSettingsDao mobileAppSettingsDao = new JpaMobileAppSettingsDao();
    BaseMobileAppSettingsService baseMobileAppSettingsService =
        new BaseMobileAppSettingsService(
            mobileAppSettingsDao, new MobileAppSettingsDataValidator());

    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.getId()).thenThrow(new RuntimeException());
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(false);
    when(mobileAppSettings.getAndroidConfig())
        .thenReturn(
            AndroidConfig.builder()
                .appPackage("java.text")
                .enabled(true)
                .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
                .storeLink("Store Link")
                .build());
    when(mobileAppSettings.getIosConfig())
        .thenReturn(IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build());
    when(mobileAppSettings.getQrCodeConfig())
        .thenReturn(
            QRCodeConfig.builder()
                .badgeEnabled(true)
                .badgePosition(BadgePosition.RIGHT)
                .qrCodeLabel("Qr Code Label")
                .qrCodeLabelEnabled(true)
                .showOnHomePage(true)
                .build());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseMobileAppSettingsService.saveMobileAppSettings(
                ModelConstants.SYSTEM_TENANT, mobileAppSettings));
    verify(mobileAppSettings).getId();
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings, atLeast(1)).isUseDefaultApp();
  }

  /**
   * Test {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId, MobileAppSettings)}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache}.
   *   <li>Then calls {@link DataValidator#validate(BaseData, Function)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @DisplayName(
      "Test saveMobileAppSettings(TenantId, MobileAppSettings); given TbTransactionalCache; then calls validate(BaseData, Function)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppSettings BaseMobileAppSettingsService.saveMobileAppSettings(TenantId, MobileAppSettings)"
  })
  void testSaveMobileAppSettings_givenTbTransactionalCache_thenCallsValidate() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<MobileAppSettings>any(), Mockito.<Function<MobileAppSettings, TenantId>>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseMobileAppSettingsService.saveMobileAppSettings(
                ModelConstants.SYSTEM_TENANT, new MobileAppSettings()));
    verify(dataValidator).validate(isA(MobileAppSettings.class), isA(Function.class));
  }

  /**
   * Test {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId, MobileAppSettings)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @DisplayName("Test saveMobileAppSettings(TenantId, MobileAppSettings); given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppSettings BaseMobileAppSettingsService.saveMobileAppSettings(TenantId, MobileAppSettings)"
  })
  void testSaveMobileAppSettings_givenTrue() {
    // Arrange
    JpaMobileAppSettingsDao mobileAppSettingsDao = new JpaMobileAppSettingsDao();
    BaseMobileAppSettingsService baseMobileAppSettingsService =
        new BaseMobileAppSettingsService(
            mobileAppSettingsDao, new MobileAppSettingsDataValidator());

    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.getId()).thenThrow(new RuntimeException());
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(true);
    when(mobileAppSettings.getAndroidConfig())
        .thenReturn(
            AndroidConfig.builder()
                .appPackage("java.text")
                .enabled(true)
                .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
                .storeLink("Store Link")
                .build());
    when(mobileAppSettings.getIosConfig())
        .thenReturn(IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build());
    when(mobileAppSettings.getQrCodeConfig())
        .thenReturn(
            QRCodeConfig.builder()
                .badgeEnabled(true)
                .badgePosition(BadgePosition.RIGHT)
                .qrCodeLabel("Qr Code Label")
                .qrCodeLabelEnabled(true)
                .showOnHomePage(true)
                .build());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseMobileAppSettingsService.saveMobileAppSettings(
                ModelConstants.SYSTEM_TENANT, mobileAppSettings));
    verify(mobileAppSettings).getId();
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings, atLeast(1)).isUseDefaultApp();
  }

  /**
   * Test {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId, MobileAppSettings)}.
   *
   * <ul>
   *   <li>Then return {@link MobileAppSettings#MobileAppSettings()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @DisplayName(
      "Test saveMobileAppSettings(TenantId, MobileAppSettings); then return MobileAppSettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppSettings BaseMobileAppSettingsService.saveMobileAppSettings(TenantId, MobileAppSettings)"
  })
  void testSaveMobileAppSettings_thenReturnMobileAppSettings() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    when(mobileAppSettingsDao.save(Mockito.<TenantId>any(), Mockito.<MobileAppSettings>any()))
        .thenReturn(mobileAppSettings);
    when(dataValidator.validate(
            Mockito.<MobileAppSettings>any(), Mockito.<Function<MobileAppSettings, TenantId>>any()))
        .thenReturn(new MobileAppSettings());

    // Act
    MobileAppSettings actualSaveMobileAppSettingsResult =
        baseMobileAppSettingsService.saveMobileAppSettings(
            ModelConstants.SYSTEM_TENANT, new MobileAppSettings());

    // Assert
    verify(tbTransactionalCache).evict(isA(TenantId.class));
    verify(mobileAppSettingsDao).save(isA(TenantId.class), isA(MobileAppSettings.class));
    verify(dataValidator).validate(isA(MobileAppSettings.class), isA(Function.class));
    assertSame(mobileAppSettings, actualSaveMobileAppSettingsResult);
  }

  /**
   * Test {@link BaseMobileAppSettingsService#getMobileAppSettings(TenantId)}.
   *
   * <p>Method under test: {@link BaseMobileAppSettingsService#getMobileAppSettings(TenantId)}
   */
  @Test
  @DisplayName("Test getMobileAppSettings(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppSettings BaseMobileAppSettingsService.getMobileAppSettings(TenantId)"
  })
  void testGetMobileAppSettings() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantId>any(), Mockito.<Supplier<MobileAppSettings>>any(), anyBoolean()))
        .thenReturn(null);

    // Act
    MobileAppSettings actualMobileAppSettings =
        baseMobileAppSettingsService.getMobileAppSettings(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    QRCodeConfig qrCodeConfig = actualMobileAppSettings.getQrCodeConfig();
    assertEquals("Scan to connect or download mobile app", qrCodeConfig.getQrCodeLabel());
    assertEquals(
        "https://apps.apple.com/us/app/thingsboard-live/id1594355695",
        actualMobileAppSettings.getDefaultAppStoreLink());
    assertEquals(
        "https://play.google.com/store/apps/details?id=org.thingsboard.demo.app",
        actualMobileAppSettings.getDefaultGooglePlayLink());
    AndroidConfig androidConfig = actualMobileAppSettings.getAndroidConfig();
    assertNull(androidConfig.getAppPackage());
    assertNull(androidConfig.getSha256CertFingerprints());
    assertNull(androidConfig.getStoreLink());
    IosConfig iosConfig = actualMobileAppSettings.getIosConfig();
    assertNull(iosConfig.getAppId());
    assertNull(iosConfig.getStoreLink());
    assertEquals(BadgePosition.RIGHT, qrCodeConfig.getBadgePosition());
    assertTrue(androidConfig.isEnabled());
    assertTrue(iosConfig.isEnabled());
    assertTrue(actualMobileAppSettings.isUseDefaultApp());
    assertTrue(qrCodeConfig.isBadgeEnabled());
    assertTrue(qrCodeConfig.isQrCodeLabelEnabled());
    assertTrue(qrCodeConfig.isShowOnHomePage());
  }

  /**
   * Test {@link BaseMobileAppSettingsService#getMobileAppSettings(TenantId)}.
   *
   * <ul>
   *   <li>Then return {@link MobileAppSettings#MobileAppSettings()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseMobileAppSettingsService#getMobileAppSettings(TenantId)}
   */
  @Test
  @DisplayName("Test getMobileAppSettings(TenantId); then return MobileAppSettings()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppSettings BaseMobileAppSettingsService.getMobileAppSettings(TenantId)"
  })
  void testGetMobileAppSettings_thenReturnMobileAppSettings() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantId>any(), Mockito.<Supplier<MobileAppSettings>>any(), anyBoolean()))
        .thenReturn(mobileAppSettings);

    // Act
    MobileAppSettings actualMobileAppSettings =
        baseMobileAppSettingsService.getMobileAppSettings(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    assertSame(mobileAppSettings, actualMobileAppSettings);
  }

  /**
   * Test {@link BaseMobileAppSettingsService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseMobileAppSettingsService#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteByTenantId(TenantId); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseMobileAppSettingsService.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_thenCallsGetId() {
    // Arrange
    doNothing().when(mobileAppSettingsDao).removeByTenantId(Mockito.<TenantId>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    baseMobileAppSettingsService.deleteByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(mobileAppSettingsDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link BaseMobileAppSettingsService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link MobileAppSettingsDao#removeByTenantId(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseMobileAppSettingsService#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteByTenantId(TenantId); when SYSTEM_TENANT; then calls removeByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseMobileAppSettingsService.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_whenSystem_tenant_thenCallsRemoveByTenantId() {
    // Arrange
    doNothing().when(mobileAppSettingsDao).removeByTenantId(Mockito.<TenantId>any());

    // Act
    baseMobileAppSettingsService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(mobileAppSettingsDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link BaseMobileAppSettingsService#handleEvictEvent(MobileAppSettingsEvictEvent)} with
   * {@code MobileAppSettingsEvictEvent}.
   *
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseMobileAppSettingsService#handleEvictEvent(MobileAppSettingsEvictEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEvictEvent(MobileAppSettingsEvictEvent) with 'MobileAppSettingsEvictEvent'; then calls evict(Serializable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseMobileAppSettingsService.handleEvictEvent(MobileAppSettingsEvictEvent)"
  })
  void testHandleEvictEventWithMobileAppSettingsEvictEvent_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());

    // Act
    baseMobileAppSettingsService.handleEvictEvent(
        new MobileAppSettingsEvictEvent(ModelConstants.SYSTEM_TENANT));

    // Assert
    verify(tbTransactionalCache).evict(isA(TenantId.class));
  }
}
