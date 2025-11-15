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
package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.thingsboard.server.cache.device.DeviceCaffeineCache;
import org.thingsboard.server.common.data.Device;

class VersionedTbCacheDiffblueTest {
  /**
   * Method under test: {@link VersionedTbCache#getVersion(Serializable)}
   */
  @Test
  void testGetVersion() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceCaffeineCache deviceCaffeineCache = new DeviceCaffeineCache(new CaffeineCacheManager());

    // Act and Assert
    assertNull(deviceCaffeineCache.getVersion(new Device()));
  }

  /**
   * Method under test: {@link VersionedTbCache#getVersion(Serializable)}
   */
  @Test
  void testGetVersion2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0L, (new DeviceCaffeineCache(new CaffeineCacheManager())).getVersion(null).longValue());
  }

  /**
   * Method under test: {@link VersionedTbCache#getVersion(Serializable)}
   */
  @Test
  void testGetVersion3() {
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
   * Method under test: {@link VersionedTbCache#getVersion(Serializable)}
   */
  @Test
  void testGetVersion4() {
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
}
