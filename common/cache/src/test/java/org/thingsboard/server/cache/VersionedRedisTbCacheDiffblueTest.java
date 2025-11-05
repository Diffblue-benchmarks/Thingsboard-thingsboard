package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link VersionedRedisTbCache#put(VersionedCacheKey, Serializable)}
   */
  @Test
  @DisplayName(
      "Test put(VersionedCacheKey, Serializable) with 'DeviceCacheKey', 'Device'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VersionedRedisTbCache.put(VersionedCacheKey, Serializable)"})
  void testPutWithDeviceCacheKeyDevice_thenDoesNotThrow() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    DeviceRedisCache deviceRedisCache =
        new DeviceRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceCacheKey deviceCacheKey = new DeviceCacheKey(deviceId);

    // Act and Assert
    assertDoesNotThrow(() -> deviceRedisCache.put(deviceCacheKey, new Device()));
  }

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
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceCacheKey deviceCacheKey = new DeviceCacheKey(deviceId);

    Device device = mock(Device.class);
    when(device.getVersion()).thenThrow(new InvalidDataAccessApiUsageException("Msg"));

    // Act and Assert
    assertThrows(
        InvalidDataAccessApiUsageException.class,
        () -> deviceRedisCache.put(deviceCacheKey, device));
    verify(device).getVersion();
  }

  /**
   * Test {@link VersionedRedisTbCache#put(VersionedCacheKey, Serializable)} with {@code
   * DeviceCacheKey}, {@code Device}.
   *
   * <ul>
   *   <li>When {@link DeviceCacheKey#DeviceCacheKey(DeviceId)} with deviceId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VersionedRedisTbCache#put(VersionedCacheKey, Serializable)}
   */
  @Test
  @DisplayName(
      "Test put(VersionedCacheKey, Serializable) with 'DeviceCacheKey', 'Device'; when DeviceCacheKey(DeviceId) with deviceId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VersionedRedisTbCache.put(VersionedCacheKey, Serializable)"})
  void testPutWithDeviceCacheKeyDevice_whenDeviceCacheKeyWithDeviceIdIsNull() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    DeviceRedisCache deviceRedisCache =
        new DeviceRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    DeviceCacheKey deviceCacheKey = new DeviceCacheKey(null);

    // Act and Assert
    assertDoesNotThrow(() -> deviceRedisCache.put(deviceCacheKey, new Device()));
  }

  /**
   * Test {@link VersionedRedisTbCache#put(VersionedCacheKey, Serializable)} with {@code
   * DeviceCacheKey}, {@code Device}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link VersionedRedisTbCache#put(VersionedCacheKey, Serializable)}
   */
  @Test
  @DisplayName(
      "Test put(VersionedCacheKey, Serializable) with 'DeviceCacheKey', 'Device'; when 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void VersionedRedisTbCache.put(VersionedCacheKey, Serializable)"})
  void testPutWithDeviceCacheKeyDevice_whenNull_thenDoesNotThrow() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    DeviceRedisCache deviceRedisCache =
        new DeviceRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertDoesNotThrow(() -> deviceRedisCache.put(new DeviceCacheKey(deviceId), null));
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
