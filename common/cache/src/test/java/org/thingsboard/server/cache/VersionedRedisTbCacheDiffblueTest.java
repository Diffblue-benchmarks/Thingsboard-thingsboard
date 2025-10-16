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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.util.UUID;
import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.thingsboard.server.cache.device.DeviceCacheKey;
import org.thingsboard.server.cache.device.DeviceRedisCache;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.id.DeviceId;

class VersionedRedisTbCacheDiffblueTest {
  /**
   * Test {@link VersionedRedisTbCache#put(VersionedCacheKey, Serializable)} with {@code
   * DeviceCacheKey}, {@code Device}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidDataAccessApiUsageException}.
   * </ul>
   *
   * <p>Method under test: {@link VersionedRedisTbCache#put(VersionedCacheKey, Serializable)}
   */
  @Test
  @DisplayName(
      "Test put(VersionedCacheKey, Serializable) with 'DeviceCacheKey', 'Device'; then throw InvalidDataAccessApiUsageException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VersionedRedisTbCache.put(VersionedCacheKey, Serializable)"})
  void testPutWithDeviceCacheKeyDevice_thenThrowInvalidDataAccessApiUsageException() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    DeviceRedisCache deviceRedisCache =
        new DeviceRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    DeviceCacheKey deviceCacheKey = new DeviceCacheKey(new DeviceId(UUID.randomUUID()));

    Device device = mock(Device.class);
    when(device.getVersion()).thenThrow(new InvalidDataAccessApiUsageException("Msg"));

    // Act and Assert
    assertThrows(
        InvalidDataAccessApiUsageException.class,
        () -> deviceRedisCache.put(deviceCacheKey, device));
    verify(device).getVersion();
  }

  /**
   * Test {@link VersionedRedisTbCache#putIfAbsent(VersionedCacheKey, Serializable)} with {@code
   * DeviceCacheKey}, {@code Device}.
   *
   * <ul>
   *   <li>Then throw {@link NotImplementedException}.
   * </ul>
   *
   * <p>Method under test: {@link VersionedRedisTbCache#putIfAbsent(VersionedCacheKey,
   * Serializable)}
   */
  @Test
  @DisplayName(
      "Test putIfAbsent(VersionedCacheKey, Serializable) with 'DeviceCacheKey', 'Device'; then throw NotImplementedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VersionedRedisTbCache.putIfAbsent(VersionedCacheKey, Serializable)"})
  void testPutIfAbsentWithDeviceCacheKeyDevice_thenThrowNotImplementedException() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    DeviceRedisCache deviceRedisCache =
        new DeviceRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    DeviceCacheKey deviceCacheKey = new DeviceCacheKey(null);

    // Act and Assert
    assertThrows(
        NotImplementedException.class,
        () -> deviceRedisCache.putIfAbsent(deviceCacheKey, new Device()));
  }

  /**
   * Test {@link VersionedRedisTbCache#evictOrPut(VersionedCacheKey, Serializable)} with {@code
   * DeviceCacheKey}, {@code Device}.
   *
   * <ul>
   *   <li>Then throw {@link NotImplementedException}.
   * </ul>
   *
   * <p>Method under test: {@link VersionedRedisTbCache#evictOrPut(VersionedCacheKey, Serializable)}
   */
  @Test
  @DisplayName(
      "Test evictOrPut(VersionedCacheKey, Serializable) with 'DeviceCacheKey', 'Device'; then throw NotImplementedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VersionedRedisTbCache.evictOrPut(VersionedCacheKey, Serializable)"})
  void testEvictOrPutWithDeviceCacheKeyDevice_thenThrowNotImplementedException() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    DeviceRedisCache deviceRedisCache =
        new DeviceRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    DeviceCacheKey deviceCacheKey = new DeviceCacheKey(null);

    // Act and Assert
    assertThrows(
        NotImplementedException.class,
        () -> deviceRedisCache.evictOrPut(deviceCacheKey, new Device()));
  }
}
