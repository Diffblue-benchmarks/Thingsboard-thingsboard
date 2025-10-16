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
package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.mobile.AndroidConfig;
import org.thingsboard.server.common.data.mobile.BadgePosition;
import org.thingsboard.server.common.data.mobile.IosConfig;
import org.thingsboard.server.common.data.mobile.MobileAppSettings;
import org.thingsboard.server.common.data.mobile.QRCodeConfig;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {MobileAppSettingsDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MobileAppSettingsDataValidatorDiffblueTest {
  @Autowired private MobileAppSettingsDataValidator mobileAppSettingsDataValidator;

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with
   * {@code TenantId}, {@code MobileAppSettings}.
   *
   * <p>Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"
  })
  public void testValidateDataImplWithTenantIdMobileAppSettings() {
    // Arrange
    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(false);
    AndroidConfig androidConfig = new AndroidConfig(false, null, null, "Store Link");
    when(mobileAppSettings.getAndroidConfig()).thenReturn(androidConfig);
    when(mobileAppSettings.getIosConfig()).thenReturn(null);
    when(mobileAppSettings.getQrCodeConfig()).thenReturn(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            mobileAppSettingsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, mobileAppSettings));
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings).isUseDefaultApp();
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with
   * {@code TenantId}, {@code MobileAppSettings}.
   *
   * <p>Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"
  })
  public void testValidateDataImplWithTenantIdMobileAppSettings2() {
    // Arrange
    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(false);
    AndroidConfig androidConfig = new AndroidConfig(false, "java.text", null, "Store Link");
    when(mobileAppSettings.getAndroidConfig()).thenReturn(androidConfig);
    IosConfig iosConfig = new IosConfig(false, null, "Store Link");
    when(mobileAppSettings.getIosConfig()).thenReturn(iosConfig);
    when(mobileAppSettings.getQrCodeConfig()).thenReturn(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            mobileAppSettingsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, mobileAppSettings));
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings).isUseDefaultApp();
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with
   * {@code TenantId}, {@code MobileAppSettings}.
   *
   * <p>Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"
  })
  public void testValidateDataImplWithTenantIdMobileAppSettings3() {
    // Arrange
    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(false);
    AndroidConfig androidConfig = new AndroidConfig(false, "java.text", null, "Store Link");
    when(mobileAppSettings.getAndroidConfig()).thenReturn(androidConfig);
    IosConfig iosConfig = new IosConfig(false, null, "Store Link");
    when(mobileAppSettings.getIosConfig()).thenReturn(iosConfig);
    when(mobileAppSettings.getQrCodeConfig())
        .thenReturn(
            QRCodeConfig.builder()
                .badgeEnabled(true)
                .badgePosition(BadgePosition.RIGHT)
                .qrCodeLabel("Qr Code Label")
                .qrCodeLabelEnabled(true)
                .showOnHomePage(true)
                .build());

    // Act
    mobileAppSettingsDataValidator.validateDataImpl(
        ModelConstants.SYSTEM_TENANT, mobileAppSettings);

    // Assert
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings).isUseDefaultApp();
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with
   * {@code TenantId}, {@code MobileAppSettings}.
   *
   * <p>Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"
  })
  public void testValidateDataImplWithTenantIdMobileAppSettings4() {
    // Arrange
    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
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

    // Act
    mobileAppSettingsDataValidator.validateDataImpl(
        ModelConstants.SYSTEM_TENANT, mobileAppSettings);

    // Assert
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings, atLeast(1)).isUseDefaultApp();
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with
   * {@code TenantId}, {@code MobileAppSettings}.
   *
   * <p>Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"
  })
  public void testValidateDataImplWithTenantIdMobileAppSettings5() {
    // Arrange
    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(false);
    AndroidConfig androidConfig = new AndroidConfig(true, "java.text", null, "Store Link");
    when(mobileAppSettings.getAndroidConfig()).thenReturn(androidConfig);
    IosConfig iosConfig = new IosConfig(false, null, "Store Link");
    when(mobileAppSettings.getIosConfig()).thenReturn(iosConfig);
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
        DataValidationException.class,
        () ->
            mobileAppSettingsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, mobileAppSettings));
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings, atLeast(1)).isUseDefaultApp();
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with
   * {@code TenantId}, {@code MobileAppSettings}.
   *
   * <p>Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"
  })
  public void testValidateDataImplWithTenantIdMobileAppSettings6() {
    // Arrange
    AndroidConfig androidConfig = mock(AndroidConfig.class);
    when(androidConfig.isEnabled()).thenThrow(new DataValidationException("An error occurred"));

    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(false);
    when(mobileAppSettings.getAndroidConfig()).thenReturn(androidConfig);
    IosConfig iosConfig = new IosConfig(false, null, "Store Link");
    when(mobileAppSettings.getIosConfig()).thenReturn(iosConfig);
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
        DataValidationException.class,
        () ->
            mobileAppSettingsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, mobileAppSettings));
    verify(androidConfig).isEnabled();
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings).isUseDefaultApp();
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with
   * {@code TenantId}, {@code MobileAppSettings}.
   *
   * <p>Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"
  })
  public void testValidateDataImplWithTenantIdMobileAppSettings7() {
    // Arrange
    AndroidConfig androidConfig = mock(AndroidConfig.class);
    when(androidConfig.getAppPackage()).thenReturn(null);
    when(androidConfig.isEnabled()).thenReturn(true);

    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(false);
    when(mobileAppSettings.getAndroidConfig()).thenReturn(androidConfig);
    IosConfig iosConfig = new IosConfig(false, null, "Store Link");
    when(mobileAppSettings.getIosConfig()).thenReturn(iosConfig);
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
        DataValidationException.class,
        () ->
            mobileAppSettingsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, mobileAppSettings));
    verify(androidConfig).getAppPackage();
    verify(androidConfig).isEnabled();
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings, atLeast(1)).isUseDefaultApp();
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with
   * {@code TenantId}, {@code MobileAppSettings}.
   *
   * <p>Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"
  })
  public void testValidateDataImplWithTenantIdMobileAppSettings8() {
    // Arrange
    AndroidConfig androidConfig = mock(AndroidConfig.class);
    when(androidConfig.getAppPackage()).thenThrow(new DataValidationException("An error occurred"));
    when(androidConfig.isEnabled()).thenReturn(true);

    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(false);
    when(mobileAppSettings.getAndroidConfig()).thenReturn(androidConfig);
    IosConfig iosConfig = new IosConfig(false, null, "Store Link");
    when(mobileAppSettings.getIosConfig()).thenReturn(iosConfig);
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
        DataValidationException.class,
        () ->
            mobileAppSettingsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, mobileAppSettings));
    verify(androidConfig).getAppPackage();
    verify(androidConfig).isEnabled();
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings, atLeast(1)).isUseDefaultApp();
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with
   * {@code TenantId}, {@code MobileAppSettings}.
   *
   * <p>Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"
  })
  public void testValidateDataImplWithTenantIdMobileAppSettings9() {
    // Arrange
    AndroidConfig androidConfig = mock(AndroidConfig.class);
    when(androidConfig.getSha256CertFingerprints())
        .thenThrow(new DataValidationException("An error occurred"));
    when(androidConfig.getAppPackage()).thenReturn("java.text");
    when(androidConfig.isEnabled()).thenReturn(true);

    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(false);
    when(mobileAppSettings.getAndroidConfig()).thenReturn(androidConfig);
    IosConfig iosConfig = new IosConfig(false, null, "Store Link");
    when(mobileAppSettings.getIosConfig()).thenReturn(iosConfig);
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
        DataValidationException.class,
        () ->
            mobileAppSettingsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, mobileAppSettings));
    verify(androidConfig).getAppPackage();
    verify(androidConfig).getSha256CertFingerprints();
    verify(androidConfig).isEnabled();
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings, atLeast(1)).isUseDefaultApp();
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with
   * {@code TenantId}, {@code MobileAppSettings}.
   *
   * <p>Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"
  })
  public void testValidateDataImplWithTenantIdMobileAppSettings10() {
    // Arrange
    MobileAppSettingsDataValidator mobileAppSettingsDataValidator =
        new MobileAppSettingsDataValidator();

    AndroidConfig androidConfig = mock(AndroidConfig.class);
    when(androidConfig.isEnabled()).thenReturn(false);

    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(false);
    when(mobileAppSettings.getAndroidConfig()).thenReturn(androidConfig);
    IosConfig iosConfig = new IosConfig(true, null, "Store Link");
    when(mobileAppSettings.getIosConfig()).thenReturn(iosConfig);
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
        DataValidationException.class,
        () ->
            mobileAppSettingsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, mobileAppSettings));
    verify(androidConfig).isEnabled();
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings, atLeast(1)).isUseDefaultApp();
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with
   * {@code TenantId}, {@code MobileAppSettings}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"
  })
  public void testValidateDataImplWithTenantIdMobileAppSettings_givenTrue() {
    // Arrange
    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
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

    // Act
    mobileAppSettingsDataValidator.validateDataImpl(
        ModelConstants.SYSTEM_TENANT, mobileAppSettings);

    // Assert
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings, atLeast(1)).isUseDefaultApp();
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with
   * {@code TenantId}, {@code MobileAppSettings}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"
  })
  public void testValidateDataImplWithTenantIdMobileAppSettings_givenTrue2() {
    // Arrange
    MobileAppSettingsDataValidator mobileAppSettingsDataValidator =
        new MobileAppSettingsDataValidator();

    AndroidConfig androidConfig = mock(AndroidConfig.class);
    when(androidConfig.isEnabled()).thenReturn(true);

    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(true);
    when(mobileAppSettings.getAndroidConfig()).thenReturn(androidConfig);
    when(mobileAppSettings.getIosConfig()).thenReturn(null);
    when(mobileAppSettings.getQrCodeConfig())
        .thenReturn(
            QRCodeConfig.builder()
                .badgeEnabled(true)
                .badgePosition(BadgePosition.RIGHT)
                .qrCodeLabel("Qr Code Label")
                .qrCodeLabelEnabled(true)
                .showOnHomePage(true)
                .build());

    // Act
    mobileAppSettingsDataValidator.validateDataImpl(
        ModelConstants.SYSTEM_TENANT, mobileAppSettings);

    // Assert
    verify(androidConfig).isEnabled();
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings, atLeast(1)).isUseDefaultApp();
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with
   * {@code TenantId}, {@code MobileAppSettings}.
   *
   * <ul>
   *   <li>Then calls {@link IosConfig#isEnabled()}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"
  })
  public void testValidateDataImplWithTenantIdMobileAppSettings_thenCallsIsEnabled() {
    // Arrange
    MobileAppSettingsDataValidator mobileAppSettingsDataValidator =
        new MobileAppSettingsDataValidator();

    AndroidConfig androidConfig = mock(AndroidConfig.class);
    when(androidConfig.isEnabled()).thenReturn(false);

    IosConfig iosConfig = mock(IosConfig.class);
    when(iosConfig.isEnabled()).thenThrow(new DataValidationException("An error occurred"));

    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(false);
    when(mobileAppSettings.getAndroidConfig()).thenReturn(androidConfig);
    when(mobileAppSettings.getIosConfig()).thenReturn(iosConfig);
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
        DataValidationException.class,
        () ->
            mobileAppSettingsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, mobileAppSettings));
    verify(androidConfig).isEnabled();
    verify(iosConfig).isEnabled();
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings).isUseDefaultApp();
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with
   * {@code TenantId}, {@code MobileAppSettings}.
   *
   * <ul>
   *   <li>When {@link MobileAppSettings#MobileAppSettings()}.
   * </ul>
   *
   * <p>Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId,
   * MobileAppSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"
  })
  public void testValidateDataImplWithTenantIdMobileAppSettings_whenMobileAppSettings() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            mobileAppSettingsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, new MobileAppSettings()));
  }
}
