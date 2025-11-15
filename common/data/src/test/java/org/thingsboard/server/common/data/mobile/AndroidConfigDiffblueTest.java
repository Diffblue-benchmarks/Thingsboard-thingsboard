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
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AndroidConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AndroidConfig.AndroidConfigBuilder#build()}
   *   <li>{@link AndroidConfig.AndroidConfigBuilder#appPackage(String)}
   *   <li>{@link AndroidConfig.AndroidConfigBuilder#enabled(boolean)}
   *   <li>{@link AndroidConfig.AndroidConfigBuilder#sha256CertFingerprints(String)}
   *   <li>{@link AndroidConfig.AndroidConfigBuilder#storeLink(String)}
   * </ul>
   */
  @Test
  void testAndroidConfigBuilderBuild() {
    // Arrange and Act
    AndroidConfig actualBuildResult = AndroidConfig.builder()
        .appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();

    // Assert
    assertEquals("Store Link", actualBuildResult.getStoreLink());
    assertEquals("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09", actualBuildResult.getSha256CertFingerprints());
    assertEquals("java.text", actualBuildResult.getAppPackage());
    assertTrue(actualBuildResult.isEnabled());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AndroidConfig#equals(Object)}
   *   <li>{@link AndroidConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AndroidConfig buildResult = AndroidConfig.builder()
        .appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();
    AndroidConfig buildResult2 = AndroidConfig.builder()
        .appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AndroidConfig#equals(Object)}
   *   <li>{@link AndroidConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AndroidConfig buildResult = AndroidConfig.builder()
        .appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link AndroidConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AndroidConfig.AndroidConfigBuilder androidConfigBuilder = mock(AndroidConfig.AndroidConfigBuilder.class);
    when(androidConfigBuilder.appPackage(Mockito.<String>any())).thenReturn(AndroidConfig.builder());
    AndroidConfig buildResult = androidConfigBuilder.appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();
    AndroidConfig buildResult2 = AndroidConfig.builder()
        .appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link AndroidConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AndroidConfig.AndroidConfigBuilder androidConfigBuilder = mock(AndroidConfig.AndroidConfigBuilder.class);
    when(androidConfigBuilder.enabled(anyBoolean())).thenReturn(AndroidConfig.builder());
    AndroidConfig.AndroidConfigBuilder androidConfigBuilder2 = mock(AndroidConfig.AndroidConfigBuilder.class);
    when(androidConfigBuilder2.appPackage(Mockito.<String>any())).thenReturn(androidConfigBuilder);
    AndroidConfig buildResult = androidConfigBuilder2.appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();
    AndroidConfig buildResult2 = AndroidConfig.builder()
        .appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link AndroidConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AndroidConfig buildResult = AndroidConfig.builder()
        .appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link AndroidConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AndroidConfig buildResult = AndroidConfig.builder()
        .appPackage("java.text")
        .enabled(true)
        .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
        .storeLink("Store Link")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to AndroidConfig");
  }

  /**
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange and Act
    AndroidConfig actualAndroidConfig = new AndroidConfig();
    actualAndroidConfig.setAppPackage("java.text");
    actualAndroidConfig.setEnabled(true);
    actualAndroidConfig.setSha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09");
    actualAndroidConfig.setStoreLink("Store Link");
    String actualToStringResult = actualAndroidConfig.toString();
    String actualAppPackage = actualAndroidConfig.getAppPackage();
    String actualSha256CertFingerprints = actualAndroidConfig.getSha256CertFingerprints();
    String actualStoreLink = actualAndroidConfig.getStoreLink();

    // Assert that nothing has changed
    assertEquals("AndroidConfig(enabled=true, appPackage=java.text, sha256CertFingerprints=b6:03:0e:39:97:9e:d0:e7:24"
        + ":ce:a3:77:3e:01:42:09, storeLink=Store Link)", actualToStringResult);
    assertEquals("Store Link", actualStoreLink);
    assertEquals("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09", actualSha256CertFingerprints);
    assertEquals("java.text", actualAppPackage);
    assertTrue(actualAndroidConfig.isEnabled());
  }

  /**
   * Methods under test:
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
  void testGettersAndSetters2() {
    // Arrange and Act
    AndroidConfig actualAndroidConfig = new AndroidConfig(true, "java.text",
        "b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09", "Store Link");
    actualAndroidConfig.setAppPackage("java.text");
    actualAndroidConfig.setEnabled(true);
    actualAndroidConfig.setSha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09");
    actualAndroidConfig.setStoreLink("Store Link");
    String actualToStringResult = actualAndroidConfig.toString();
    String actualAppPackage = actualAndroidConfig.getAppPackage();
    String actualSha256CertFingerprints = actualAndroidConfig.getSha256CertFingerprints();
    String actualStoreLink = actualAndroidConfig.getStoreLink();

    // Assert that nothing has changed
    assertEquals("AndroidConfig(enabled=true, appPackage=java.text, sha256CertFingerprints=b6:03:0e:39:97:9e:d0:e7:24"
        + ":ce:a3:77:3e:01:42:09, storeLink=Store Link)", actualToStringResult);
    assertEquals("Store Link", actualStoreLink);
    assertEquals("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09", actualSha256CertFingerprints);
    assertEquals("java.text", actualAppPackage);
    assertTrue(actualAndroidConfig.isEnabled());
  }
}
