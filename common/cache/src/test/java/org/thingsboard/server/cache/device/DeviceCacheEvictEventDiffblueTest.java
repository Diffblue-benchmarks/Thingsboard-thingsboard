package org.thingsboard.server.cache.device;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceCacheEvictEventDiffblueTest {
  /**
   * Test {@link DeviceCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceCacheEvictEvent deviceCacheEvictEvent = new DeviceCacheEvictEvent(new TenantId(UUID.randomUUID()),
        mock(DeviceId.class), "New Name", "Old Name");

    // Act and Assert
    assertNotEquals(deviceCacheEvictEvent,
        new DeviceCacheEvictEvent(new TenantId(UUID.randomUUID()), null, "New Name", "Old Name"));
  }

  /**
   * Test {@link DeviceCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DeviceCacheEvictEvent(new TenantId(UUID.randomUUID()), mock(DeviceId.class), "New Name", "Old Name"), "42");
  }

  /**
   * Test {@link DeviceCacheEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceCacheEvictEvent deviceCacheEvictEvent = new DeviceCacheEvictEvent(null, mock(DeviceId.class), "New Name",
        "Old Name");

    // Act and Assert
    assertNotEquals(deviceCacheEvictEvent,
        new DeviceCacheEvictEvent(new TenantId(UUID.randomUUID()), null, "New Name", "Old Name"));
  }
}
