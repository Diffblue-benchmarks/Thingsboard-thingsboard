package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
  @Autowired
  private MobileAppSettingsDataValidator mobileAppSettingsDataValidator;

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with {@code TenantId}, {@code MobileAppSettings}.
   * <p>
   * Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"})
  public void testValidateDataImplWithTenantIdMobileAppSettings() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setUseDefaultApp(false);
    mobileAppSettings.setAndroidConfig(
        new AndroidConfig(true, "java.text", "b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09", "Store Link"));
    mobileAppSettings.setIosConfig(null);
    mobileAppSettings.setQrCodeConfig(null);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> mobileAppSettingsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, mobileAppSettings));
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with {@code TenantId}, {@code MobileAppSettings}.
   * <p>
   * Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"})
  public void testValidateDataImplWithTenantIdMobileAppSettings2() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setUseDefaultApp(false);
    mobileAppSettings.setAndroidConfig(
        new AndroidConfig(true, null, "b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09", "Store Link"));
    mobileAppSettings.setIosConfig(new IosConfig(true, "42", "Store Link"));
    mobileAppSettings.setQrCodeConfig(new QRCodeConfig(true, true, true, BadgePosition.RIGHT, "Qr Code Label"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> mobileAppSettingsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, mobileAppSettings));
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with {@code TenantId}, {@code MobileAppSettings}.
   * <p>
   * Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"})
  public void testValidateDataImplWithTenantIdMobileAppSettings3() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setUseDefaultApp(false);
    mobileAppSettings.setAndroidConfig(new AndroidConfig(true, "java.text", null, "Store Link"));
    mobileAppSettings.setIosConfig(new IosConfig(true, "42", "Store Link"));
    mobileAppSettings.setQrCodeConfig(new QRCodeConfig(true, true, true, BadgePosition.RIGHT, "Qr Code Label"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> mobileAppSettingsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, mobileAppSettings));
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with {@code TenantId}, {@code MobileAppSettings}.
   * <p>
   * Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"})
  public void testValidateDataImplWithTenantIdMobileAppSettings4() {
    // Arrange
    MobileAppSettingsDataValidator mobileAppSettingsDataValidator = new MobileAppSettingsDataValidator();

    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setUseDefaultApp(false);
    mobileAppSettings.setAndroidConfig(
        new AndroidConfig(true, "java.text", "b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09", "Store Link"));
    mobileAppSettings.setIosConfig(new IosConfig(true, null, "Store Link"));
    mobileAppSettings.setQrCodeConfig(new QRCodeConfig(true, true, true, BadgePosition.RIGHT, "Qr Code Label"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> mobileAppSettingsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, mobileAppSettings));
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with {@code TenantId}, {@code MobileAppSettings}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"})
  public void testValidateDataImplWithTenantIdMobileAppSettings_givenNull() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setUseDefaultApp(false);
    mobileAppSettings.setAndroidConfig(
        new AndroidConfig(true, "java.text", "b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09", "Store Link"));
    mobileAppSettings.setIosConfig(new IosConfig(true, "42", "Store Link"));
    mobileAppSettings.setQrCodeConfig(null);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> mobileAppSettingsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, mobileAppSettings));
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with {@code TenantId}, {@code MobileAppSettings}.
   * <ul>
   *   <li>Then calls {@link MobileAppSettings#getAndroidConfig()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"})
  public void testValidateDataImplWithTenantIdMobileAppSettings_thenCallsGetAndroidConfig() {
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

    // Assert
    verify(mobileAppSettings).getAndroidConfig();
    verify(mobileAppSettings).getIosConfig();
    verify(mobileAppSettings).getQrCodeConfig();
    verify(mobileAppSettings, atLeast(1)).isUseDefaultApp();
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with {@code TenantId}, {@code MobileAppSettings}.
   * <ul>
   *   <li>Then calls {@link AndroidConfig#isEnabled()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"})
  public void testValidateDataImplWithTenantIdMobileAppSettings_thenCallsIsEnabled() {
    // Arrange
    MobileAppSettingsDataValidator mobileAppSettingsDataValidator = new MobileAppSettingsDataValidator();
    AndroidConfig androidConfig = mock(AndroidConfig.class);
    when(androidConfig.isEnabled()).thenThrow(new DataValidationException("An error occurred"));

    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setUseDefaultApp(false);
    mobileAppSettings.setAndroidConfig(androidConfig);
    mobileAppSettings.setIosConfig(new IosConfig(true, "42", "Store Link"));
    mobileAppSettings.setQrCodeConfig(new QRCodeConfig(true, true, true, BadgePosition.RIGHT, "Qr Code Label"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> mobileAppSettingsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, mobileAppSettings));
    verify(androidConfig).isEnabled();
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with {@code TenantId}, {@code MobileAppSettings}.
   * <ul>
   *   <li>Then calls {@link IosConfig#isEnabled()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"})
  public void testValidateDataImplWithTenantIdMobileAppSettings_thenCallsIsEnabled2() {
    // Arrange
    MobileAppSettingsDataValidator mobileAppSettingsDataValidator = new MobileAppSettingsDataValidator();
    IosConfig iosConfig = mock(IosConfig.class);
    when(iosConfig.isEnabled()).thenThrow(new DataValidationException("An error occurred"));

    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setUseDefaultApp(false);
    mobileAppSettings.setAndroidConfig(
        new AndroidConfig(true, "java.text", "b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09", "Store Link"));
    mobileAppSettings.setIosConfig(iosConfig);
    mobileAppSettings.setQrCodeConfig(new QRCodeConfig(true, true, true, BadgePosition.RIGHT, "Qr Code Label"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> mobileAppSettingsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, mobileAppSettings));
    verify(iosConfig).isEnabled();
  }

  /**
   * Test {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)} with {@code TenantId}, {@code MobileAppSettings}.
   * <ul>
   *   <li>When {@link MobileAppSettings#MobileAppSettings()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettingsDataValidator#validateDataImpl(TenantId, MobileAppSettings)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MobileAppSettingsDataValidator.validateDataImpl(TenantId, MobileAppSettings)"})
  public void testValidateDataImplWithTenantIdMobileAppSettings_whenMobileAppSettings() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> mobileAppSettingsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new MobileAppSettings()));
  }
}
