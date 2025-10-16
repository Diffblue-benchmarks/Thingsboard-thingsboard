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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.mobile.AndroidConfig.AndroidConfigBuilder;

@ContextConfiguration(classes = {AndroidConfigBuilder.class})
@ExtendWith(SpringExtension.class)
class AndroidConfigDiffblueTest {
  @Autowired private AndroidConfigBuilder androidConfigBuilder;

  /**
   * Test AndroidConfigBuilder {@link AndroidConfigBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AndroidConfigBuilder#build()}
   *   <li>{@link AndroidConfigBuilder#appPackage(String)}
   *   <li>{@link AndroidConfigBuilder#enabled(boolean)}
   *   <li>{@link AndroidConfigBuilder#sha256CertFingerprints(String)}
   *   <li>{@link AndroidConfigBuilder#storeLink(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test AndroidConfigBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AndroidConfigBuilder.<init>()",
    "AndroidConfigBuilder AndroidConfigBuilder.appPackage(String)",
    "AndroidConfig AndroidConfigBuilder.build()",
    "AndroidConfigBuilder AndroidConfigBuilder.enabled(boolean)",
    "AndroidConfigBuilder AndroidConfigBuilder.sha256CertFingerprints(String)",
    "AndroidConfigBuilder AndroidConfigBuilder.storeLink(String)",
    "String AndroidConfigBuilder.toString()"
  })
  void testAndroidConfigBuilderBuild() {
    // Arrange and Act
    AndroidConfig actualAndroidConfig =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();

    // Assert
    assertEquals("Store Link", actualAndroidConfig.getStoreLink());
    assertEquals(
        "b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09",
        actualAndroidConfig.getSha256CertFingerprints());
    assertEquals("java.text", actualAndroidConfig.getAppPackage());
    assertTrue(actualAndroidConfig.isEnabled());
  }

  /**
   * Test {@link AndroidConfig#equals(Object)}, and {@link AndroidConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AndroidConfig#equals(Object)}
   *   <li>{@link AndroidConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AndroidConfig androidConfig =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();
    AndroidConfig androidConfig2 =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();

    // Act and Assert
    assertEquals(androidConfig, androidConfig2);
    assertEquals(androidConfig.hashCode(), androidConfig2.hashCode());
  }

  /**
   * Test {@link AndroidConfig#equals(Object)}, and {@link AndroidConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AndroidConfig#equals(Object)}
   *   <li>{@link AndroidConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AndroidConfig androidConfig =
        AndroidConfig.builder()
            .appPackage(null)
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();
    AndroidConfig androidConfig2 =
        AndroidConfig.builder()
            .appPackage(null)
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();

    // Act and Assert
    assertEquals(androidConfig, androidConfig2);
    assertEquals(androidConfig.hashCode(), androidConfig2.hashCode());
  }

  /**
   * Test {@link AndroidConfig#equals(Object)}, and {@link AndroidConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AndroidConfig#equals(Object)}
   *   <li>{@link AndroidConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AndroidConfig androidConfig =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints(null)
            .storeLink("Store Link")
            .build();
    AndroidConfig androidConfig2 =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints(null)
            .storeLink("Store Link")
            .build();

    // Act and Assert
    assertEquals(androidConfig, androidConfig2);
    assertEquals(androidConfig.hashCode(), androidConfig2.hashCode());
  }

  /**
   * Test {@link AndroidConfig#equals(Object)}, and {@link AndroidConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AndroidConfig#equals(Object)}
   *   <li>{@link AndroidConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AndroidConfig androidConfig =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink(null)
            .build();
    AndroidConfig androidConfig2 =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink(null)
            .build();

    // Act and Assert
    assertEquals(androidConfig, androidConfig2);
    assertEquals(androidConfig.hashCode(), androidConfig2.hashCode());
  }

  /**
   * Test {@link AndroidConfig#equals(Object)}, and {@link AndroidConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AndroidConfig#equals(Object)}
   *   <li>{@link AndroidConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AndroidConfig androidConfig =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();

    // Act and Assert
    assertEquals(androidConfig, androidConfig);
    int expectedHashCodeResult = androidConfig.hashCode();
    assertEquals(expectedHashCodeResult, androidConfig.hashCode());
  }

  /**
   * Test {@link AndroidConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AndroidConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AndroidConfig androidConfig =
        AndroidConfig.builder()
            .appPackage("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();

    // Act and Assert
    assertNotEquals(
        androidConfig,
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build());
  }

  /**
   * Test {@link AndroidConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AndroidConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AndroidConfig androidConfig =
        AndroidConfig.builder()
            .appPackage(null)
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();

    // Act and Assert
    assertNotEquals(
        androidConfig,
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build());
  }

  /**
   * Test {@link AndroidConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AndroidConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AndroidConfig androidConfig =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(false)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();

    // Act and Assert
    assertNotEquals(
        androidConfig,
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build());
  }

  /**
   * Test {@link AndroidConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AndroidConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AndroidConfig androidConfig =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("java.text")
            .storeLink("Store Link")
            .build();

    // Act and Assert
    assertNotEquals(
        androidConfig,
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build());
  }

  /**
   * Test {@link AndroidConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AndroidConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AndroidConfig androidConfig =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints(null)
            .storeLink("Store Link")
            .build();

    // Act and Assert
    assertNotEquals(
        androidConfig,
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build());
  }

  /**
   * Test {@link AndroidConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AndroidConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AndroidConfig androidConfig =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("java.text")
            .build();

    // Act and Assert
    assertNotEquals(
        androidConfig,
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build());
  }

  /**
   * Test {@link AndroidConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AndroidConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AndroidConfig androidConfig =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink(null)
            .build();

    // Act and Assert
    assertNotEquals(
        androidConfig,
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build());
  }

  /**
   * Test {@link AndroidConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AndroidConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build(),
        null);
  }

  /**
   * Test {@link AndroidConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AndroidConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build(),
        "Different type to AndroidConfig");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AndroidConfig#AndroidConfig()}
   *   <li>{@link AndroidConfig#setAppPackage(String)}
   *   <li>{@link AndroidConfig#setEnabled(boolean)}
   *   <li>{@link AndroidConfig#setSha256CertFingerprints(String)}
   *   <li>{@link AndroidConfig#setStoreLink(String)}
   *   <li>{@link AndroidConfig#toString()}
   *   <li>{@link AndroidConfig#getAppPackage()}
   *   <li>{@link AndroidConfig#getSha256CertFingerprints()}
   *   <li>{@link AndroidConfig#getStoreLink()}
   *   <li>{@link AndroidConfig#isEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AndroidConfig.<init>()",
    "void AndroidConfig.<init>(boolean, String, String, String)",
    "String AndroidConfig.getAppPackage()",
    "String AndroidConfig.getSha256CertFingerprints()",
    "String AndroidConfig.getStoreLink()",
    "boolean AndroidConfig.isEnabled()",
    "void AndroidConfig.setAppPackage(String)",
    "void AndroidConfig.setEnabled(boolean)",
    "void AndroidConfig.setSha256CertFingerprints(String)",
    "void AndroidConfig.setStoreLink(String)",
    "String AndroidConfig.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AndroidConfig actualAndroidConfig = new AndroidConfig();
    actualAndroidConfig.setAppPackage("java.text");
    actualAndroidConfig.setEnabled(true);
    actualAndroidConfig.setSha256CertFingerprints(
        "b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09");
    actualAndroidConfig.setStoreLink("Store Link");
    String actualToStringResult = actualAndroidConfig.toString();
    String actualAppPackage = actualAndroidConfig.getAppPackage();
    String actualSha256CertFingerprints = actualAndroidConfig.getSha256CertFingerprints();
    String actualStoreLink = actualAndroidConfig.getStoreLink();

    // Assert
    assertEquals(
        "AndroidConfig(enabled=true, appPackage=java.text, sha256CertFingerprints=b6:03:0e:39:97:9e:d0:e7:24"
            + ":ce:a3:77:3e:01:42:09, storeLink=Store Link)",
        actualToStringResult);
    assertEquals("Store Link", actualStoreLink);
    assertEquals("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09", actualSha256CertFingerprints);
    assertEquals("java.text", actualAppPackage);
    assertTrue(actualAndroidConfig.isEnabled());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AndroidConfig#AndroidConfig(boolean, String, String, String)}
   *   <li>{@link AndroidConfig#setAppPackage(String)}
   *   <li>{@link AndroidConfig#setEnabled(boolean)}
   *   <li>{@link AndroidConfig#setSha256CertFingerprints(String)}
   *   <li>{@link AndroidConfig#setStoreLink(String)}
   *   <li>{@link AndroidConfig#toString()}
   *   <li>{@link AndroidConfig#getAppPackage()}
   *   <li>{@link AndroidConfig#getSha256CertFingerprints()}
   *   <li>{@link AndroidConfig#getStoreLink()}
   *   <li>{@link AndroidConfig#isEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AndroidConfig.<init>()",
    "void AndroidConfig.<init>(boolean, String, String, String)",
    "String AndroidConfig.getAppPackage()",
    "String AndroidConfig.getSha256CertFingerprints()",
    "String AndroidConfig.getStoreLink()",
    "boolean AndroidConfig.isEnabled()",
    "void AndroidConfig.setAppPackage(String)",
    "void AndroidConfig.setEnabled(boolean)",
    "void AndroidConfig.setSha256CertFingerprints(String)",
    "void AndroidConfig.setStoreLink(String)",
    "String AndroidConfig.toString()"
  })
  void testGettersAndSetters_whenTrue() {
    // Arrange and Act
    AndroidConfig actualAndroidConfig =
        new AndroidConfig(
            true, "java.text", "b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09", "Store Link");
    actualAndroidConfig.setAppPackage("java.text");
    actualAndroidConfig.setEnabled(true);
    actualAndroidConfig.setSha256CertFingerprints(
        "b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09");
    actualAndroidConfig.setStoreLink("Store Link");
    String actualToStringResult = actualAndroidConfig.toString();
    String actualAppPackage = actualAndroidConfig.getAppPackage();
    String actualSha256CertFingerprints = actualAndroidConfig.getSha256CertFingerprints();
    String actualStoreLink = actualAndroidConfig.getStoreLink();

    // Assert
    assertEquals(
        "AndroidConfig(enabled=true, appPackage=java.text, sha256CertFingerprints=b6:03:0e:39:97:9e:d0:e7:24"
            + ":ce:a3:77:3e:01:42:09, storeLink=Store Link)",
        actualToStringResult);
    assertEquals("Store Link", actualStoreLink);
    assertEquals("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09", actualSha256CertFingerprints);
    assertEquals("java.text", actualAppPackage);
    assertTrue(actualAndroidConfig.isEnabled());
  }
}
