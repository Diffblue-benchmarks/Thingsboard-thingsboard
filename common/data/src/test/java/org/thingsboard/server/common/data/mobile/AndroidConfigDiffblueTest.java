package org.thingsboard.server.common.data.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
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
  @Tag("MaintainedByDiffblue")
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
    AndroidConfig actualBuildResult =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();

    // Assert
    assertEquals("Store Link", actualBuildResult.getStoreLink());
    assertEquals(
        "b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09",
        actualBuildResult.getSha256CertFingerprints());
    assertEquals("java.text", actualBuildResult.getAppPackage());
    assertTrue(actualBuildResult.isEnabled());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AndroidConfig buildResult =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();
    AndroidConfig buildResult2 =
        AndroidConfig.builder()
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AndroidConfig buildResult =
        AndroidConfig.builder()
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AndroidConfigBuilder androidConfigBuilder = mock(AndroidConfigBuilder.class);
    when(androidConfigBuilder.appPackage(Mockito.<String>any()))
        .thenReturn(AndroidConfig.builder());
    AndroidConfig buildResult =
        androidConfigBuilder
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();
    AndroidConfig buildResult2 =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AndroidConfigBuilder androidConfigBuilder = mock(AndroidConfigBuilder.class);
    when(androidConfigBuilder.enabled(anyBoolean())).thenReturn(AndroidConfig.builder());
    AndroidConfigBuilder androidConfigBuilder2 = mock(AndroidConfigBuilder.class);
    when(androidConfigBuilder2.appPackage(Mockito.<String>any())).thenReturn(androidConfigBuilder);
    AndroidConfig buildResult =
        androidConfigBuilder2
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();
    AndroidConfig buildResult2 =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AndroidConfig buildResult =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AndroidConfig.equals(Object)", "int AndroidConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AndroidConfig buildResult =
        AndroidConfig.builder()
            .appPackage("java.text")
            .enabled(true)
            .sha256CertFingerprints("b6:03:0e:39:97:9e:d0:e7:24:ce:a3:77:3e:01:42:09")
            .storeLink("Store Link")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to AndroidConfig");
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
