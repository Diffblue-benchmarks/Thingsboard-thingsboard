package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.thingsboard.server.cache.device.DeviceCaffeineCache;
import org.thingsboard.server.common.data.Device;

class VersionedTbCacheDiffblueTest {
  /**
   * Test {@link VersionedTbCache#getVersion(Serializable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link Device} {@link Device#getVersion()} return one.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionedTbCache#getVersion(Serializable)}
   */
  @Test
  @DisplayName("Test getVersion(Serializable); given one; when Device getVersion() return one; then return longValue is one")
  void testGetVersion_givenOne_whenDeviceGetVersionReturnOne_thenReturnLongValueIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CacheManager cacheManager = mock(CacheManager.class);
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
    DeviceCaffeineCache deviceCaffeineCache = new DeviceCaffeineCache(cacheManager);
    Device device = mock(Device.class);
    when(device.getVersion()).thenReturn(1L);

    // Act
    Long actualVersion = deviceCaffeineCache.getVersion(device);

    // Assert
    verify(cacheManager).getCache(eq("devices"));
    verify(device, atLeast(1)).getVersion();
    assertEquals(1L, actualVersion.longValue());
  }

  /**
   * Test {@link VersionedTbCache#getVersion(Serializable)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionedTbCache#getVersion(Serializable)}
   */
  @Test
  @DisplayName("Test getVersion(Serializable); then return 'null'")
  void testGetVersion_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceCaffeineCache deviceCaffeineCache = new DeviceCaffeineCache(new CaffeineCacheManager());

    // Act and Assert
    assertNull(deviceCaffeineCache.getVersion(new Device()));
  }

  /**
   * Test {@link VersionedTbCache#getVersion(Serializable)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionedTbCache#getVersion(Serializable)}
   */
  @Test
  @DisplayName("Test getVersion(Serializable); then return 'null'")
  void testGetVersion_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CacheManager cacheManager = mock(CacheManager.class);
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
    DeviceCaffeineCache deviceCaffeineCache = new DeviceCaffeineCache(cacheManager);

    // Act
    Long actualVersion = deviceCaffeineCache.getVersion(new Device());

    // Assert
    verify(cacheManager).getCache(eq("devices"));
    assertNull(actualVersion);
  }

  /**
   * Test {@link VersionedTbCache#getVersion(Serializable)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return longValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionedTbCache#getVersion(Serializable)}
   */
  @Test
  @DisplayName("Test getVersion(Serializable); when 'null'; then return longValue is zero")
  void testGetVersion_whenNull_thenReturnLongValueIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0L, (new DeviceCaffeineCache(new CaffeineCacheManager())).getVersion(null).longValue());
  }
}
