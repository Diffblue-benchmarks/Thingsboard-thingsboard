package org.thingsboard.server.common.data.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class MobileAppSettingsDiffblueTest {
  /**
   * Test {@link MobileAppSettings#equals(Object)}, and {@link MobileAppSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppSettings#equals(Object)}
   *   <li>{@link MobileAppSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    MobileAppSettings mobileAppSettings2 = new MobileAppSettings();

    // Act and Assert
    assertEquals(mobileAppSettings, mobileAppSettings2);
    int expectedHashCodeResult = mobileAppSettings.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppSettings2.hashCode());
  }

  /**
   * Test {@link MobileAppSettings#equals(Object)}, and {@link MobileAppSettings#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppSettings#equals(Object)}
   *   <li>{@link MobileAppSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();

    // Act and Assert
    assertEquals(mobileAppSettings, mobileAppSettings);
    int expectedHashCodeResult = mobileAppSettings.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppSettings.hashCode());
  }

  /**
   * Test {@link MobileAppSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppSettings(), 1);
  }

  /**
   * Test {@link MobileAppSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(mobileAppSettings, new MobileAppSettings());
  }

  /**
   * Test {@link MobileAppSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setUseDefaultApp(true);

    // Act and Assert
    assertNotEquals(mobileAppSettings, new MobileAppSettings());
  }

  /**
   * Test {@link MobileAppSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    AndroidConfig androidConfig = AndroidConfig.builder()
        .appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();
    mobileAppSettings.setAndroidConfig(androidConfig);

    // Act and Assert
    assertNotEquals(mobileAppSettings, new MobileAppSettings());
  }

  /**
   * Test {@link MobileAppSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    IosConfig iosConfig = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();
    mobileAppSettings.setIosConfig(iosConfig);

    // Act and Assert
    assertNotEquals(mobileAppSettings, new MobileAppSettings());
  }

  /**
   * Test {@link MobileAppSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    QRCodeConfig qrCodeConfig = QRCodeConfig.builder()
        .badgeEnabled(true)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();
    mobileAppSettings.setQrCodeConfig(qrCodeConfig);

    // Act and Assert
    assertNotEquals(mobileAppSettings, new MobileAppSettings());
  }

  /**
   * Test {@link MobileAppSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setDefaultGooglePlayLink("Default Google Play Link");

    // Act and Assert
    assertNotEquals(mobileAppSettings, new MobileAppSettings());
  }

  /**
   * Test {@link MobileAppSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setDefaultAppStoreLink("Default App Store Link");

    // Act and Assert
    assertNotEquals(mobileAppSettings, new MobileAppSettings());
  }

  /**
   * Test {@link MobileAppSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(mobileAppSettings, new MobileAppSettings());
  }

  /**
   * Test {@link MobileAppSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();

    MobileAppSettings mobileAppSettings2 = new MobileAppSettings();
    mobileAppSettings2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(mobileAppSettings, mobileAppSettings2);
  }

  /**
   * Test {@link MobileAppSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();

    MobileAppSettings mobileAppSettings2 = new MobileAppSettings();
    AndroidConfig androidConfig = AndroidConfig.builder()
        .appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();
    mobileAppSettings2.setAndroidConfig(androidConfig);

    // Act and Assert
    assertNotEquals(mobileAppSettings, mobileAppSettings2);
  }

  /**
   * Test {@link MobileAppSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();

    MobileAppSettings mobileAppSettings2 = new MobileAppSettings();
    IosConfig iosConfig = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();
    mobileAppSettings2.setIosConfig(iosConfig);

    // Act and Assert
    assertNotEquals(mobileAppSettings, mobileAppSettings2);
  }

  /**
   * Test {@link MobileAppSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();

    MobileAppSettings mobileAppSettings2 = new MobileAppSettings();
    QRCodeConfig qrCodeConfig = QRCodeConfig.builder()
        .badgeEnabled(true)
        .badgePosition(BadgePosition.RIGHT)
        .qrCodeLabel("Qr Code Label")
        .qrCodeLabelEnabled(true)
        .showOnHomePage(true)
        .build();
    mobileAppSettings2.setQrCodeConfig(qrCodeConfig);

    // Act and Assert
    assertNotEquals(mobileAppSettings, mobileAppSettings2);
  }

  /**
   * Test {@link MobileAppSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();

    MobileAppSettings mobileAppSettings2 = new MobileAppSettings();
    mobileAppSettings2.setDefaultGooglePlayLink("Default Google Play Link");

    // Act and Assert
    assertNotEquals(mobileAppSettings, mobileAppSettings2);
  }

  /**
   * Test {@link MobileAppSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();

    MobileAppSettings mobileAppSettings2 = new MobileAppSettings();
    mobileAppSettings2.setDefaultAppStoreLink("Default App Store Link");

    // Act and Assert
    assertNotEquals(mobileAppSettings, mobileAppSettings2);
  }

  /**
   * Test {@link MobileAppSettings#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppSettings(), null);
  }

  /**
   * Test {@link MobileAppSettings#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppSettings.equals(Object)", "int MobileAppSettings.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppSettings(), "Different type to MobileAppSettings");
  }
}
