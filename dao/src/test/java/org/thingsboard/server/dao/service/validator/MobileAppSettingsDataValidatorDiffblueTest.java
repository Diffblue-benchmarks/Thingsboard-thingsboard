package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.mobile.AndroidConfig;
import org.thingsboard.server.common.data.mobile.AndroidConfig.AndroidConfigBuilder;
import org.thingsboard.server.common.data.mobile.BadgePosition;
import org.thingsboard.server.common.data.mobile.IosConfig;
import org.thingsboard.server.common.data.mobile.MobileAppSettings;
import org.thingsboard.server.common.data.mobile.QRCodeConfig;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {MobileAppSettingsDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class MobileAppSettingsDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @Autowired
  private MobileAppSettingsDataValidator mobileAppSettingsDataValidator;

  /**
   * Test
   * {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   * with {@code TenantId}, {@code MobileAppSettings}.
   * <p>
   * Method under test:
   * {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   */
  @Test
  public void testValidateDataImplWithTenantIdMobileAppSettings() {
    // Arrange
    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(true);
    AndroidConfig buildResult = AndroidConfig.builder()
        .appPackage("java.text")
        .enabled(false)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();
    when(mobileAppSettings.getAndroidConfig()).thenReturn(buildResult);
    IosConfig buildResult2 = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();
    when(mobileAppSettings.getIosConfig()).thenReturn(buildResult2);
    QRCodeConfig buildResult3 = QRCodeConfig.builder()
        .badgeEnabled(true)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();
    when(mobileAppSettings.getQrCodeConfig()).thenReturn(buildResult3);

    // Act
    mobileAppSettingsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, mobileAppSettings);

    // Assert that nothing has changed
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings, atLeast(1)).isUseDefaultApp();
  }

  /**
   * Test
   * {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   * with {@code TenantId}, {@code MobileAppSettings}.
   * <p>
   * Method under test:
   * {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   */
  @Test
  public void testValidateDataImplWithTenantIdMobileAppSettings2() {
    // Arrange
    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(true);
    AndroidConfig buildResult = AndroidConfig.builder()
        .appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();
    when(mobileAppSettings.getAndroidConfig()).thenReturn(buildResult);
    IosConfig buildResult2 = IosConfig.builder().appId("42").enabled(false).storeLink("Store Link").build();
    when(mobileAppSettings.getIosConfig()).thenReturn(buildResult2);
    QRCodeConfig buildResult3 = QRCodeConfig.builder()
        .badgeEnabled(true)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();
    when(mobileAppSettings.getQrCodeConfig()).thenReturn(buildResult3);

    // Act
    mobileAppSettingsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, mobileAppSettings);

    // Assert that nothing has changed
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings, atLeast(1)).isUseDefaultApp();
  }

  /**
   * Test
   * {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   * with {@code TenantId}, {@code MobileAppSettings}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   */
  @Test
  public void testValidateDataImplWithTenantIdMobileAppSettings_givenFalse() {
    // Arrange
    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(false);
    AndroidConfig buildResult = AndroidConfig.builder()
        .appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();
    when(mobileAppSettings.getAndroidConfig()).thenReturn(buildResult);
    IosConfig buildResult2 = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();
    when(mobileAppSettings.getIosConfig()).thenReturn(buildResult2);
    QRCodeConfig buildResult3 = QRCodeConfig.builder()
        .badgeEnabled(true)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();
    when(mobileAppSettings.getQrCodeConfig()).thenReturn(buildResult3);

    // Act
    mobileAppSettingsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, mobileAppSettings);

    // Assert that nothing has changed
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings, atLeast(1)).isUseDefaultApp();
  }

  /**
   * Test
   * {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   * with {@code TenantId}, {@code MobileAppSettings}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   */
  @Test
  public void testValidateDataImplWithTenantIdMobileAppSettings_givenTrue() {
    // Arrange
    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(true);
    AndroidConfig buildResult = AndroidConfig.builder()
        .appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();
    when(mobileAppSettings.getAndroidConfig()).thenReturn(buildResult);
    IosConfig buildResult2 = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();
    when(mobileAppSettings.getIosConfig()).thenReturn(buildResult2);
    QRCodeConfig buildResult3 = QRCodeConfig.builder()
        .badgeEnabled(true)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();
    when(mobileAppSettings.getQrCodeConfig()).thenReturn(buildResult3);

    // Act
    mobileAppSettingsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, mobileAppSettings);

    // Assert that nothing has changed
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings, atLeast(1)).isUseDefaultApp();
  }

  /**
   * Test
   * {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   * with {@code TenantId}, {@code MobileAppSettings}.
   * <ul>
   *   <li>Then calls {@link AndroidConfigBuilder#appPackage(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   */
  @Test
  public void testValidateDataImplWithTenantIdMobileAppSettings_thenCallsAppPackage() {
    // Arrange
    AndroidConfig.AndroidConfigBuilder androidConfigBuilder = mock(AndroidConfig.AndroidConfigBuilder.class);
    when(androidConfigBuilder.appPackage(Mockito.<String>any())).thenReturn(AndroidConfig.builder());
    AndroidConfig buildResult = androidConfigBuilder.appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();
    MobileAppSettings mobileAppSettings = mock(MobileAppSettings.class);
    when(mobileAppSettings.isUseDefaultApp()).thenReturn(false);
    when(mobileAppSettings.getAndroidConfig()).thenReturn(buildResult);
    IosConfig buildResult2 = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();
    when(mobileAppSettings.getIosConfig()).thenReturn(buildResult2);
    QRCodeConfig buildResult3 = QRCodeConfig.builder()
        .badgeEnabled(true)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();
    when(mobileAppSettings.getQrCodeConfig()).thenReturn(buildResult3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> mobileAppSettingsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, mobileAppSettings));
    verify(androidConfigBuilder).appPackage(eq("java.text"));
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings, atLeast(1)).isUseDefaultApp();
  }

  /**
   * Test
   * {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   * with {@code TenantId}, {@code MobileAppSettings}.
   * <ul>
   *   <li>When {@link MobileAppSettings#MobileAppSettings()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   */
  @Test
  public void testValidateDataImplWithTenantIdMobileAppSettings_whenMobileAppSettings() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> mobileAppSettingsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new MobileAppSettings()));
  }
}
