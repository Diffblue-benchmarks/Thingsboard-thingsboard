/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.mobile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
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
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.service.validator.MobileAppSettingsDataValidator;
import org.thingsboard.server.dao.sql.mobile.JpaMobileAppSettingsDao;

@ContextConfiguration(classes = {BaseMobileAppSettingsService.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseMobileAppSettingsServiceDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppSettings BaseMobileAppSettingsService.saveMobileAppSettings(TenantId, MobileAppSettings)"
  })
  public void testSaveMobileAppSettings() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppSettings BaseMobileAppSettingsService.saveMobileAppSettings(TenantId, MobileAppSettings)"
  })
  public void testSaveMobileAppSettings2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppSettings BaseMobileAppSettingsService.saveMobileAppSettings(TenantId, MobileAppSettings)"
  })
  public void testSaveMobileAppSettings3() {
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
   * <ul>
   *   <li>Given {@link TbTransactionalCache}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppSettings BaseMobileAppSettingsService.saveMobileAppSettings(TenantId, MobileAppSettings)"
  })
  public void testSaveMobileAppSettings_givenTbTransactionalCache_thenThrowRuntimeException() {
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
   *   <li>Then calls {@link MobileAppSettings#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseMobileAppSettingsService#saveMobileAppSettings(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppSettings BaseMobileAppSettingsService.saveMobileAppSettings(TenantId, MobileAppSettings)"
  })
  public void testSaveMobileAppSettings_givenTrue_thenCallsGetId() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppSettings BaseMobileAppSettingsService.saveMobileAppSettings(TenantId, MobileAppSettings)"
  })
  public void testSaveMobileAppSettings_thenReturnMobileAppSettings() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppSettings BaseMobileAppSettingsService.getMobileAppSettings(TenantId)"
  })
  public void testGetMobileAppSettings() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileAppSettings BaseMobileAppSettingsService.getMobileAppSettings(TenantId)"
  })
  public void testGetMobileAppSettings_thenReturnMobileAppSettings() {
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
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseMobileAppSettingsService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseMobileAppSettingsService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(mobileAppSettingsDao).removeByTenantId(Mockito.<TenantId>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseMobileAppSettingsService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_whenSystem_tenant_thenCallsRemoveByTenantId() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseMobileAppSettingsService.handleEvictEvent(MobileAppSettingsEvictEvent)"
  })
  public void testHandleEvictEventWithMobileAppSettingsEvictEvent_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());

    // Act
    baseMobileAppSettingsService.handleEvictEvent(
        new MobileAppSettingsEvictEvent(ModelConstants.SYSTEM_TENANT));

    // Assert
    verify(tbTransactionalCache).evict(isA(TenantId.class));
  }
}
