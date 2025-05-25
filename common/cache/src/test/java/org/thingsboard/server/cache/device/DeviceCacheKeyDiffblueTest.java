package org.thingsboard.server.cache.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.cache.device.DeviceCacheKey.DeviceCacheKeyBuilder;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceCacheKeyDiffblueTest {
  /**
   * Test {@link DeviceCacheKey#toString()}.
   * <p>
   * Method under test: {@link DeviceCacheKey#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String DeviceCacheKey.toString()"})
  void testToString() {
    // Arrange
    DeviceCacheKeyBuilder builderResult = DeviceCacheKey.builder();
    DeviceCacheKeyBuilder deviceNameResult = builderResult
        .deviceId(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .deviceName("Device Name");
    DeviceCacheKey buildResult = deviceNameResult
        .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9_784f394c-42b6-435a-983c-b7beff2784f9", buildResult.toString());
  }

  /**
   * Test {@link DeviceCacheKey#toString()}.
   * <ul>
   *   <li>Given {@link DeviceCacheKey#DeviceCacheKey(DeviceId)} with deviceId is {@code null}.</li>
   *   <li>Then return {@code null_n_null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCacheKey#toString()}
   */
  @Test
  @DisplayName("Test toString(); given DeviceCacheKey(DeviceId) with deviceId is 'null'; then return 'null_n_null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String DeviceCacheKey.toString()"})
  void testToString_givenDeviceCacheKeyWithDeviceIdIsNull_thenReturnNullNNull() {
    // Arrange, Act and Assert
    assertEquals("null_n_null", (new DeviceCacheKey(null)).toString());
  }

  /**
   * Test {@link DeviceCacheKey#toString()}.
   * <ul>
   *   <li>Then return {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCacheKey#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String DeviceCacheKey.toString()"})
  void testToString_thenReturn784f394c42b6435a983cB7beff2784f9() {
    // Arrange, Act and Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9",
        (new DeviceCacheKey(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))).toString());
  }

  /**
   * Test {@link DeviceCacheKey#isVersioned()}.
   * <ul>
   *   <li>Given {@link DeviceCacheKey#DeviceCacheKey(DeviceId)} with deviceId is {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCacheKey#isVersioned()}
   */
  @Test
  @DisplayName("Test isVersioned(); given DeviceCacheKey(DeviceId) with deviceId is 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceCacheKey.isVersioned()"})
  void testIsVersioned_givenDeviceCacheKeyWithDeviceIdIsNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new DeviceCacheKey(null)).isVersioned());
  }

  /**
   * Test {@link DeviceCacheKey#isVersioned()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCacheKey#isVersioned()}
   */
  @Test
  @DisplayName("Test isVersioned(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceCacheKey.isVersioned()"})
  void testIsVersioned_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new DeviceCacheKey(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))).isVersioned());
  }
}
