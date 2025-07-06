package org.thingsboard.server.cache;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.github.benmanes.caffeine.cache.CacheLoader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.thingsboard.server.cache.device.DeviceCacheKey;
import org.thingsboard.server.cache.device.DeviceCaffeineCache;
import org.thingsboard.server.common.data.util.TbPair;

class VersionedCaffeineTbCacheDiffblueTest {
  /**
   * Test {@link VersionedCaffeineTbCache#evict(VersionedCacheKey, Long)} with {@code
   * DeviceCacheKey}, {@code Long}.
   *
   * <ul>
   *   <li>Given {@link TbPair} {@link TbPair#getFirst()} return fifty-nine.
   *   <li>Then calls {@link CacheLoader#load(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link VersionedCaffeineTbCache#evict(VersionedCacheKey, Long)}
   */
  @Test
  @DisplayName(
      "Test evict(VersionedCacheKey, Long) with 'DeviceCacheKey', 'Long'; given TbPair getFirst() return fifty-nine; then calls load(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void VersionedCaffeineTbCache.evict(VersionedCacheKey, Long)"})
  void testEvictWithDeviceCacheKeyLong_givenTbPairGetFirstReturnFiftyNine_thenCallsLoad()
      throws Exception {
    // Arrange
    TbPair<Object, Object> tbPair = mock(TbPair.class);
    when(tbPair.getFirst()).thenReturn(59L);
    CacheLoader<Object, Object> cacheLoader = mock(CacheLoader.class);
    when(cacheLoader.load(Mockito.<Object>any())).thenReturn(tbPair);

    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    cacheManager.setCacheLoader(cacheLoader);
    DeviceCaffeineCache deviceCaffeineCache = new DeviceCaffeineCache(cacheManager);

    // Act
    deviceCaffeineCache.evict(new DeviceCacheKey(null), 1L);

    // Assert
    verify(cacheLoader).load(isA(Object.class));
    verify(tbPair).getFirst();
  }

  /**
   * Test {@link VersionedCaffeineTbCache#evict(VersionedCacheKey, Long)} with {@code
   * DeviceCacheKey}, {@code Long}.
   *
   * <ul>
   *   <li>Given {@link TbPair} {@link TbPair#getFirst()} return zero.
   *   <li>Then calls {@link CacheLoader#load(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link VersionedCaffeineTbCache#evict(VersionedCacheKey, Long)}
   */
  @Test
  @DisplayName(
      "Test evict(VersionedCacheKey, Long) with 'DeviceCacheKey', 'Long'; given TbPair getFirst() return zero; then calls load(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void VersionedCaffeineTbCache.evict(VersionedCacheKey, Long)"})
  void testEvictWithDeviceCacheKeyLong_givenTbPairGetFirstReturnZero_thenCallsLoad()
      throws Exception {
    // Arrange
    TbPair<Object, Object> tbPair = mock(TbPair.class);
    when(tbPair.getFirst()).thenReturn(0L);
    CacheLoader<Object, Object> cacheLoader = mock(CacheLoader.class);
    when(cacheLoader.load(Mockito.<Object>any())).thenReturn(tbPair);

    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    cacheManager.setCacheLoader(cacheLoader);
    DeviceCaffeineCache deviceCaffeineCache = new DeviceCaffeineCache(cacheManager);

    // Act
    deviceCaffeineCache.evict(new DeviceCacheKey(null), 1L);

    // Assert
    verify(cacheLoader).load(isA(Object.class));
    verify(tbPair).getFirst();
  }
}
