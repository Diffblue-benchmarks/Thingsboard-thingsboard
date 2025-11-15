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
package org.thingsboard.server.common.data.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class MobileAppSettingsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppSettings#equals(Object)}
   *   <li>{@link MobileAppSettings#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppSettings#equals(Object)}
   *   <li>{@link MobileAppSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();

    // Act and Assert
    assertEquals(mobileAppSettings, mobileAppSettings);
    int expectedHashCodeResult = mobileAppSettings.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppSettings.hashCode());
  }

  /**
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppSettings(), 1);
    assertNotEquals(new MobileAppSettings(), mock(MobileApp.class));
  }

  /**
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(mobileAppSettings, new MobileAppSettings());
  }

  /**
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setUseDefaultApp(true);

    // Act and Assert
    assertNotEquals(mobileAppSettings, new MobileAppSettings());
  }

  /**
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
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
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    IosConfig iosConfig = IosConfig.builder().appId("42").enabled(true).storeLink("Store Link").build();
    mobileAppSettings.setIosConfig(iosConfig);

    // Act and Assert
    assertNotEquals(mobileAppSettings, new MobileAppSettings());
  }

  /**
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
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
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setDefaultGooglePlayLink("Default Google Play Link");

    // Act and Assert
    assertNotEquals(mobileAppSettings, new MobileAppSettings());
  }

  /**
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setDefaultAppStoreLink("Default App Store Link");

    // Act and Assert
    assertNotEquals(mobileAppSettings, new MobileAppSettings());
  }

  /**
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();
    mobileAppSettings.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(mobileAppSettings, new MobileAppSettings());
  }

  /**
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();

    MobileAppSettings mobileAppSettings2 = new MobileAppSettings();
    mobileAppSettings2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(mobileAppSettings, mobileAppSettings2);
  }

  /**
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
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
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
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
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
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
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();

    MobileAppSettings mobileAppSettings2 = new MobileAppSettings();
    mobileAppSettings2.setDefaultGooglePlayLink("Default Google Play Link");

    // Act and Assert
    assertNotEquals(mobileAppSettings, mobileAppSettings2);
  }

  /**
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    MobileAppSettings mobileAppSettings = new MobileAppSettings();

    MobileAppSettings mobileAppSettings2 = new MobileAppSettings();
    mobileAppSettings2.setDefaultAppStoreLink("Default App Store Link");

    // Act and Assert
    assertNotEquals(mobileAppSettings, mobileAppSettings2);
  }

  /**
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppSettings(), null);
  }

  /**
   * Method under test: {@link MobileAppSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppSettings(), "Different type to MobileAppSettings");
  }
}
