package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.cache.device.DeviceCacheKey;
import org.thingsboard.server.common.data.id.DeviceId;

class VersionedCacheKeyDiffblueTest {
  /**
   * Test {@link VersionedCacheKey#isVersioned()}.
   *
   * <ul>
   *   <li>Given {@link DeviceCacheKey#DeviceCacheKey(DeviceId)} with deviceId is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link VersionedCacheKey#isVersioned()}
   */
  @Test
  @DisplayName(
      "Test isVersioned(); given DeviceCacheKey(DeviceId) with deviceId is 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionedCacheKey.isVersioned()"})
  void testIsVersioned_givenDeviceCacheKeyWithDeviceIdIsNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new DeviceCacheKey(null).isVersioned());
  }

  /**
   * Test {@link VersionedCacheKey#isVersioned()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link VersionedCacheKey#isVersioned()}
   */
  @Test
  @DisplayName("Test isVersioned(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean VersionedCacheKey.isVersioned()"})
  void testIsVersioned_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new DeviceCacheKey(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .isVersioned());
  }
}
