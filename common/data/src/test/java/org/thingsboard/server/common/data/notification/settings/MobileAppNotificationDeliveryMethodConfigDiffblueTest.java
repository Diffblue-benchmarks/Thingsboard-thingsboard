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
package org.thingsboard.server.common.data.notification.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class MobileAppNotificationDeliveryMethodConfigDiffblueTest {
  /**
   * Test {@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}, and {@link MobileAppNotificationDeliveryMethodConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}
   *   <li>{@link MobileAppNotificationDeliveryMethodConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppNotificationDeliveryMethodConfig.equals(Object)",
      "int MobileAppNotificationDeliveryMethodConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileAppNotificationDeliveryMethodConfig mobileAppNotificationDeliveryMethodConfig = new MobileAppNotificationDeliveryMethodConfig();
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentials("3");
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentialsFileName("Dr Jane Doe");

    MobileAppNotificationDeliveryMethodConfig mobileAppNotificationDeliveryMethodConfig2 = new MobileAppNotificationDeliveryMethodConfig();
    mobileAppNotificationDeliveryMethodConfig2.setFirebaseServiceAccountCredentials("3");
    mobileAppNotificationDeliveryMethodConfig2.setFirebaseServiceAccountCredentialsFileName("Dr Jane Doe");

    // Act and Assert
    assertEquals(mobileAppNotificationDeliveryMethodConfig, mobileAppNotificationDeliveryMethodConfig2);
    int expectedHashCodeResult = mobileAppNotificationDeliveryMethodConfig.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppNotificationDeliveryMethodConfig2.hashCode());
  }

  /**
   * Test {@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}, and {@link MobileAppNotificationDeliveryMethodConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}
   *   <li>{@link MobileAppNotificationDeliveryMethodConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppNotificationDeliveryMethodConfig.equals(Object)",
      "int MobileAppNotificationDeliveryMethodConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MobileAppNotificationDeliveryMethodConfig mobileAppNotificationDeliveryMethodConfig = new MobileAppNotificationDeliveryMethodConfig();
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentials(null);
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentialsFileName("Dr Jane Doe");

    MobileAppNotificationDeliveryMethodConfig mobileAppNotificationDeliveryMethodConfig2 = new MobileAppNotificationDeliveryMethodConfig();
    mobileAppNotificationDeliveryMethodConfig2.setFirebaseServiceAccountCredentials(null);
    mobileAppNotificationDeliveryMethodConfig2.setFirebaseServiceAccountCredentialsFileName("Dr Jane Doe");

    // Act and Assert
    assertEquals(mobileAppNotificationDeliveryMethodConfig, mobileAppNotificationDeliveryMethodConfig2);
    int expectedHashCodeResult = mobileAppNotificationDeliveryMethodConfig.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppNotificationDeliveryMethodConfig2.hashCode());
  }

  /**
   * Test {@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}, and {@link MobileAppNotificationDeliveryMethodConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}
   *   <li>{@link MobileAppNotificationDeliveryMethodConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppNotificationDeliveryMethodConfig.equals(Object)",
      "int MobileAppNotificationDeliveryMethodConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    MobileAppNotificationDeliveryMethodConfig mobileAppNotificationDeliveryMethodConfig = new MobileAppNotificationDeliveryMethodConfig();
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentials("3");
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentialsFileName(null);

    MobileAppNotificationDeliveryMethodConfig mobileAppNotificationDeliveryMethodConfig2 = new MobileAppNotificationDeliveryMethodConfig();
    mobileAppNotificationDeliveryMethodConfig2.setFirebaseServiceAccountCredentials("3");
    mobileAppNotificationDeliveryMethodConfig2.setFirebaseServiceAccountCredentialsFileName(null);

    // Act and Assert
    assertEquals(mobileAppNotificationDeliveryMethodConfig, mobileAppNotificationDeliveryMethodConfig2);
    int expectedHashCodeResult = mobileAppNotificationDeliveryMethodConfig.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppNotificationDeliveryMethodConfig2.hashCode());
  }

  /**
   * Test {@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}, and {@link MobileAppNotificationDeliveryMethodConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}
   *   <li>{@link MobileAppNotificationDeliveryMethodConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppNotificationDeliveryMethodConfig.equals(Object)",
      "int MobileAppNotificationDeliveryMethodConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppNotificationDeliveryMethodConfig mobileAppNotificationDeliveryMethodConfig = new MobileAppNotificationDeliveryMethodConfig();
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentials("3");
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentialsFileName("Dr Jane Doe");

    // Act and Assert
    assertEquals(mobileAppNotificationDeliveryMethodConfig, mobileAppNotificationDeliveryMethodConfig);
    int expectedHashCodeResult = mobileAppNotificationDeliveryMethodConfig.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppNotificationDeliveryMethodConfig.hashCode());
  }

  /**
   * Test {@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppNotificationDeliveryMethodConfig.equals(Object)",
      "int MobileAppNotificationDeliveryMethodConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileAppNotificationDeliveryMethodConfig mobileAppNotificationDeliveryMethodConfig = new MobileAppNotificationDeliveryMethodConfig();
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentials("Dr Jane Doe");
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentialsFileName("Dr Jane Doe");

    MobileAppNotificationDeliveryMethodConfig mobileAppNotificationDeliveryMethodConfig2 = new MobileAppNotificationDeliveryMethodConfig();
    mobileAppNotificationDeliveryMethodConfig2.setFirebaseServiceAccountCredentials("3");
    mobileAppNotificationDeliveryMethodConfig2.setFirebaseServiceAccountCredentialsFileName("Dr Jane Doe");

    // Act and Assert
    assertNotEquals(mobileAppNotificationDeliveryMethodConfig, mobileAppNotificationDeliveryMethodConfig2);
  }

  /**
   * Test {@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppNotificationDeliveryMethodConfig.equals(Object)",
      "int MobileAppNotificationDeliveryMethodConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppNotificationDeliveryMethodConfig mobileAppNotificationDeliveryMethodConfig = new MobileAppNotificationDeliveryMethodConfig();
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentials(null);
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentialsFileName("Dr Jane Doe");

    MobileAppNotificationDeliveryMethodConfig mobileAppNotificationDeliveryMethodConfig2 = new MobileAppNotificationDeliveryMethodConfig();
    mobileAppNotificationDeliveryMethodConfig2.setFirebaseServiceAccountCredentials("3");
    mobileAppNotificationDeliveryMethodConfig2.setFirebaseServiceAccountCredentialsFileName("Dr Jane Doe");

    // Act and Assert
    assertNotEquals(mobileAppNotificationDeliveryMethodConfig, mobileAppNotificationDeliveryMethodConfig2);
  }

  /**
   * Test {@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppNotificationDeliveryMethodConfig.equals(Object)",
      "int MobileAppNotificationDeliveryMethodConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppNotificationDeliveryMethodConfig mobileAppNotificationDeliveryMethodConfig = new MobileAppNotificationDeliveryMethodConfig();
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentials("3");
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentialsFileName("Mr John Smith");

    MobileAppNotificationDeliveryMethodConfig mobileAppNotificationDeliveryMethodConfig2 = new MobileAppNotificationDeliveryMethodConfig();
    mobileAppNotificationDeliveryMethodConfig2.setFirebaseServiceAccountCredentials("3");
    mobileAppNotificationDeliveryMethodConfig2.setFirebaseServiceAccountCredentialsFileName("Dr Jane Doe");

    // Act and Assert
    assertNotEquals(mobileAppNotificationDeliveryMethodConfig, mobileAppNotificationDeliveryMethodConfig2);
  }

  /**
   * Test {@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppNotificationDeliveryMethodConfig.equals(Object)",
      "int MobileAppNotificationDeliveryMethodConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppNotificationDeliveryMethodConfig mobileAppNotificationDeliveryMethodConfig = new MobileAppNotificationDeliveryMethodConfig();
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentials("3");
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentialsFileName(null);

    MobileAppNotificationDeliveryMethodConfig mobileAppNotificationDeliveryMethodConfig2 = new MobileAppNotificationDeliveryMethodConfig();
    mobileAppNotificationDeliveryMethodConfig2.setFirebaseServiceAccountCredentials("3");
    mobileAppNotificationDeliveryMethodConfig2.setFirebaseServiceAccountCredentialsFileName("Dr Jane Doe");

    // Act and Assert
    assertNotEquals(mobileAppNotificationDeliveryMethodConfig, mobileAppNotificationDeliveryMethodConfig2);
  }

  /**
   * Test {@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppNotificationDeliveryMethodConfig.equals(Object)",
      "int MobileAppNotificationDeliveryMethodConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    MobileAppNotificationDeliveryMethodConfig mobileAppNotificationDeliveryMethodConfig = new MobileAppNotificationDeliveryMethodConfig();
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentials("3");
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentialsFileName("Dr Jane Doe");

    // Act and Assert
    assertNotEquals(mobileAppNotificationDeliveryMethodConfig, null);
  }

  /**
   * Test {@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppNotificationDeliveryMethodConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MobileAppNotificationDeliveryMethodConfig.equals(Object)",
      "int MobileAppNotificationDeliveryMethodConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    MobileAppNotificationDeliveryMethodConfig mobileAppNotificationDeliveryMethodConfig = new MobileAppNotificationDeliveryMethodConfig();
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentials("3");
    mobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentialsFileName("Dr Jane Doe");

    // Act and Assert
    assertNotEquals(mobileAppNotificationDeliveryMethodConfig,
        "Different type to MobileAppNotificationDeliveryMethodConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MobileAppNotificationDeliveryMethodConfig}
   *   <li>{@link MobileAppNotificationDeliveryMethodConfig#setFirebaseServiceAccountCredentials(String)}
   *   <li>{@link MobileAppNotificationDeliveryMethodConfig#setFirebaseServiceAccountCredentialsFileName(String)}
   *   <li>{@link MobileAppNotificationDeliveryMethodConfig#toString()}
   *   <li>{@link MobileAppNotificationDeliveryMethodConfig#getFirebaseServiceAccountCredentials()}
   *   <li>{@link MobileAppNotificationDeliveryMethodConfig#getFirebaseServiceAccountCredentialsFileName()}
   *   <li>{@link MobileAppNotificationDeliveryMethodConfig#getMethod()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MobileAppNotificationDeliveryMethodConfig.<init>()",
      "String MobileAppNotificationDeliveryMethodConfig.getFirebaseServiceAccountCredentials()",
      "String MobileAppNotificationDeliveryMethodConfig.getFirebaseServiceAccountCredentialsFileName()",
      "NotificationDeliveryMethod MobileAppNotificationDeliveryMethodConfig.getMethod()",
      "void MobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentials(String)",
      "void MobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentialsFileName(String)",
      "String MobileAppNotificationDeliveryMethodConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    MobileAppNotificationDeliveryMethodConfig actualMobileAppNotificationDeliveryMethodConfig = new MobileAppNotificationDeliveryMethodConfig();
    actualMobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentials("3");
    actualMobileAppNotificationDeliveryMethodConfig.setFirebaseServiceAccountCredentialsFileName("Dr Jane Doe");
    String actualToStringResult = actualMobileAppNotificationDeliveryMethodConfig.toString();
    String actualFirebaseServiceAccountCredentials = actualMobileAppNotificationDeliveryMethodConfig
        .getFirebaseServiceAccountCredentials();
    String actualFirebaseServiceAccountCredentialsFileName = actualMobileAppNotificationDeliveryMethodConfig
        .getFirebaseServiceAccountCredentialsFileName();

    // Assert
    assertEquals("3", actualFirebaseServiceAccountCredentials);
    assertEquals("Dr Jane Doe", actualFirebaseServiceAccountCredentialsFileName);
    assertEquals("MobileAppNotificationDeliveryMethodConfig(firebaseServiceAccountCredentialsFileName=Dr Jane Doe,"
        + " firebaseServiceAccountCredentials=3)", actualToStringResult);
    assertEquals(NotificationDeliveryMethod.MOBILE_APP, actualMobileAppNotificationDeliveryMethodConfig.getMethod());
  }
}
