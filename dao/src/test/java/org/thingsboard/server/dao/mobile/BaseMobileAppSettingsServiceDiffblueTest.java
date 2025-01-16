package org.thingsboard.server.dao.mobile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.mobile.AndroidConfig;
import org.thingsboard.server.common.data.mobile.BadgePosition;
import org.thingsboard.server.common.data.mobile.IosConfig;
import org.thingsboard.server.common.data.mobile.MobileAppSettings;
import org.thingsboard.server.common.data.mobile.QRCodeConfig;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {BaseMobileAppSettingsService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class BaseMobileAppSettingsServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  private BaseMobileAppSettingsService baseMobileAppSettingsService;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private DataValidator<MobileAppSettings> dataValidator;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private MobileAppSettingsDao mobileAppSettingsDao;

  @MockBean
  private RelationService relationService;

  @MockBean
  private TbTransactionalCache<TenantId, MobileAppSettings> tbTransactionalCache;

  /**
   * Test
   * {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId, MobileAppSettings)}.
   * <p>
   * Method under test:
   * {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId, MobileAppSettings)}
   */
  @Test
  public void testSaveMobileAppSettings() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    when(mobileAppSettingsDao.save(Mockito.<TenantId>any(), Mockito.<MobileAppSettings>any())).thenReturn(null);
    when(dataValidator.validate(Mockito.<MobileAppSettings>any(), Mockito.<Function<MobileAppSettings, TenantId>>any()))
        .thenReturn(new MobileAppSettings());

    // Act
    MobileAppSettings actualSaveMobileAppSettingsResult = baseMobileAppSettingsService
        .saveMobileAppSettings(ModelConstants.SYSTEM_TENANT, new MobileAppSettings());

    // Assert
    verify(tbTransactionalCache).evict(isA(TenantId.class));
    verify(mobileAppSettingsDao).save(isA(TenantId.class), isA(MobileAppSettings.class));
    verify(dataValidator).validate(isA(MobileAppSettings.class), isA(Function.class));
    QRCodeConfig qrCodeConfig = actualSaveMobileAppSettingsResult.getQrCodeConfig();
    assertEquals("Scan to connect or download mobile app", qrCodeConfig.getQrCodeLabel());
    assertEquals("https://apps.apple.com/us/app/thingsboard-live/id1594355695",
        actualSaveMobileAppSettingsResult.getDefaultAppStoreLink());
    assertEquals("https://play.google.com/store/apps/details?id=org.thingsboard.demo.app",
        actualSaveMobileAppSettingsResult.getDefaultGooglePlayLink());
    AndroidConfig androidConfig = actualSaveMobileAppSettingsResult.getAndroidConfig();
    assertNull(androidConfig.getAppPackage());
    assertNull(androidConfig.getSha256CertFingerprints());
    assertNull(androidConfig.getStoreLink());
    IosConfig iosConfig = actualSaveMobileAppSettingsResult.getIosConfig();
    assertNull(iosConfig.getAppId());
    assertNull(iosConfig.getStoreLink());
    assertNull(actualSaveMobileAppSettingsResult.getUuidId());
    assertNull(actualSaveMobileAppSettingsResult.getId());
    assertNull(actualSaveMobileAppSettingsResult.getTenantId());
    assertEquals(0L, actualSaveMobileAppSettingsResult.getCreatedTime());
    assertEquals(BadgePosition.RIGHT, qrCodeConfig.getBadgePosition());
    assertTrue(androidConfig.isEnabled());
    assertTrue(iosConfig.isEnabled());
    assertTrue(actualSaveMobileAppSettingsResult.isUseDefaultApp());
    assertTrue(qrCodeConfig.isBadgeEnabled());
    assertTrue(qrCodeConfig.isQrCodeLabelEnabled());
    assertTrue(qrCodeConfig.isShowOnHomePage());
  }

  /**
   * Test
   * {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId, MobileAppSettings)}.
   * <ul>
   *   <li>Then return {@link MobileAppSettings#MobileAppSettings()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId, MobileAppSettings)}
   */
  @Test
  public void testSaveMobileAppSettings_thenReturnMobileAppSettings() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    when(mobileAppSettingsDao.save(Mockito.<TenantId>any(), Mockito.<MobileAppSettings>any()))
        .thenReturn(mobileAppSettings);
    when(dataValidator.validate(Mockito.<MobileAppSettings>any(), Mockito.<Function<MobileAppSettings, TenantId>>any()))
        .thenReturn(new MobileAppSettings());

    // Act
    MobileAppSettings actualSaveMobileAppSettingsResult = baseMobileAppSettingsService
        .saveMobileAppSettings(ModelConstants.SYSTEM_TENANT, new MobileAppSettings());

    // Assert
    verify(tbTransactionalCache).evict(isA(TenantId.class));
    verify(mobileAppSettingsDao).save(isA(TenantId.class), isA(MobileAppSettings.class));
    verify(dataValidator).validate(isA(MobileAppSettings.class), isA(Function.class));
    assertSame(mobileAppSettings, actualSaveMobileAppSettingsResult);
  }

  /**
   * Test {@link BaseMobileAppSettingsService#getMobileAppSettings(TenantId)}.
   * <p>
   * Method under test:
   * {@link BaseMobileAppSettingsService#getMobileAppSettings(TenantId)}
   */
  @Test
  public void testGetMobileAppSettings() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantId>any(),
        Mockito.<Supplier<MobileAppSettings>>any(), anyBoolean())).thenReturn(null);

    // Act
    MobileAppSettings actualMobileAppSettings = baseMobileAppSettingsService
        .getMobileAppSettings(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    QRCodeConfig qrCodeConfig = actualMobileAppSettings.getQrCodeConfig();
    assertEquals("Scan to connect or download mobile app", qrCodeConfig.getQrCodeLabel());
    assertEquals("https://apps.apple.com/us/app/thingsboard-live/id1594355695",
        actualMobileAppSettings.getDefaultAppStoreLink());
    assertEquals("https://play.google.com/store/apps/details?id=org.thingsboard.demo.app",
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
   * <ul>
   *   <li>Then return {@link MobileAppSettings#MobileAppSettings()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseMobileAppSettingsService#getMobileAppSettings(TenantId)}
   */
  @Test
  public void testGetMobileAppSettings_thenReturnMobileAppSettings() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantId>any(),
        Mockito.<Supplier<MobileAppSettings>>any(), anyBoolean())).thenReturn(mobileAppSettings);

    // Act
    MobileAppSettings actualMobileAppSettings = baseMobileAppSettingsService
        .getMobileAppSettings(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    assertSame(mobileAppSettings, actualMobileAppSettings);
  }

  /**
   * Test {@link BaseMobileAppSettingsService#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link MobileAppSettingsDao#removeByTenantId(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseMobileAppSettingsService#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_whenSystem_tenant_thenCallsRemoveByTenantId() {
    // Arrange
    doNothing().when(mobileAppSettingsDao).removeByTenantId(Mockito.<TenantId>any());

    // Act
    baseMobileAppSettingsService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(mobileAppSettingsDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test
   * {@link BaseMobileAppSettingsService#handleEvictEvent(MobileAppSettingsEvictEvent)}
   * with {@code MobileAppSettingsEvictEvent}.
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseMobileAppSettingsService#handleEvictEvent(MobileAppSettingsEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithMobileAppSettingsEvictEvent_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());

    // Act
    baseMobileAppSettingsService.handleEvictEvent(new MobileAppSettingsEvictEvent(ModelConstants.SYSTEM_TENANT));

    // Assert that nothing has changed
    verify(tbTransactionalCache).evict(isA(TenantId.class));
  }
}
