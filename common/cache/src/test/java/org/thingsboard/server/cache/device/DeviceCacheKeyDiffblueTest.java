package org.thingsboard.server.cache.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;

class DeviceCacheKeyDiffblueTest {
  /**
   * Test {@link DeviceCacheKey#toString()}.
   * <ul>
   *   <li>Given {@link DeviceCacheKey#DeviceCacheKey(DeviceId)} with deviceId is
   * {@code null}.</li>
   *   <li>Then return {@code null_n_null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCacheKey#toString()}
   */
  @Test
  @DisplayName("Test toString(); given DeviceCacheKey(DeviceId) with deviceId is 'null'; then return 'null_n_null'")
  void testToString_givenDeviceCacheKeyWithDeviceIdIsNull_thenReturnNullNNull() {
    // Arrange, Act and Assert
    assertEquals("null_n_null", (new DeviceCacheKey(null)).toString());
  }

  /**
   * Test {@link DeviceCacheKey#isVersioned()}.
   * <ul>
   *   <li>Given {@link DeviceCacheKey#DeviceCacheKey(DeviceId)} with deviceId is
   * {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCacheKey#isVersioned()}
   */
  @Test
  @DisplayName("Test isVersioned(); given DeviceCacheKey(DeviceId) with deviceId is 'null'; then return 'false'")
  void testIsVersioned_givenDeviceCacheKeyWithDeviceIdIsNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new DeviceCacheKey(null)).isVersioned());
  }

  /**
   * Test {@link DeviceCacheKey#isVersioned()}.
   * <ul>
   *   <li>Given {@link DeviceId#DeviceId(UUID)} with id is randomUUID.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCacheKey#isVersioned()}
   */
  @Test
  @DisplayName("Test isVersioned(); given DeviceId(UUID) with id is randomUUID; then return 'true'")
  void testIsVersioned_givenDeviceIdWithIdIsRandomUUID_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new DeviceCacheKey(new DeviceId(UUID.randomUUID()))).isVersioned());
  }
}
