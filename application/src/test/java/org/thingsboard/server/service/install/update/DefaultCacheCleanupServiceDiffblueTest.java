package org.thingsboard.server.service.install.update;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.github.benmanes.caffeine.cache.AsyncCache;
import com.github.benmanes.caffeine.cache.Cache;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.redis.core.RedisTemplate;

class DefaultCacheCleanupServiceDiffblueTest {
  /**
   * Test {@link DefaultCacheCleanupService#clearCache(String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code Clearing cache [{}]}.</li>
   *   <li>When {@code 3.7.0}.</li>
   *   <li>Then calls
   * {@link com.github.benmanes.caffeine.cache.Cache#invalidateAll()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCacheCleanupService#clearCache(String)}
   */
  @Test
  @DisplayName("Test clearCache(String); given ArrayList() add 'Clearing cache [{}]'; when '3.7.0'; then calls invalidateAll()")
  void testClearCache_givenArrayListAddClearingCache_when370_thenCallsInvalidateAll() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    new EmptyResultDataAccessException(3);
    com.github.benmanes.caffeine.cache.Cache<Object, Object> cache = mock(
        com.github.benmanes.caffeine.cache.Cache.class);
    doNothing().when(cache).invalidateAll();
    CaffeineCache caffeineCache = new CaffeineCache("Name", cache);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Clearing cache [{}]");
    stringList.add("3.7.0");
    CaffeineCacheManager cacheManager = mock(CaffeineCacheManager.class);
    when(cacheManager.getCacheNames()).thenReturn(stringList);
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(caffeineCache);
    Optional<RedisTemplate<String, Object>> redisTemplate = Optional.empty();

    // Act
    (new DefaultCacheCleanupService(cacheManager, redisTemplate)).clearCache("3.7.0");

    // Assert that nothing has changed
    verify(cache, atLeast(1)).invalidateAll();
    verify(cacheManager, atLeast(1)).getCache(Mockito.<String>any());
    verify(cacheManager).getCacheNames();
  }

  /**
   * Test {@link DefaultCacheCleanupService#clearCache(String)}.
   * <ul>
   *   <li>Then calls
   * {@link com.github.benmanes.caffeine.cache.Cache#invalidateAll()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCacheCleanupService#clearCache(String)}
   */
  @Test
  @DisplayName("Test clearCache(String); then calls invalidateAll()")
  void testClearCache_thenCallsInvalidateAll() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    new EmptyResultDataAccessException(3);
    com.github.benmanes.caffeine.cache.Cache<Object, Object> cache = mock(
        com.github.benmanes.caffeine.cache.Cache.class);
    doNothing().when(cache).invalidateAll();
    CaffeineCache caffeineCache = new CaffeineCache("Name", cache);

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("3.7.0");
    CaffeineCacheManager cacheManager = mock(CaffeineCacheManager.class);
    when(cacheManager.getCacheNames()).thenReturn(stringList);
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(caffeineCache);
    Optional<RedisTemplate<String, Object>> redisTemplate = Optional.empty();

    // Act
    (new DefaultCacheCleanupService(cacheManager, redisTemplate)).clearCache("3.7.0");

    // Assert that nothing has changed
    verify(cache).invalidateAll();
    verify(cacheManager).getCache(eq("3.7.0"));
    verify(cacheManager).getCacheNames();
  }

  /**
   * Test {@link DefaultCacheCleanupService#clearCache(String)}.
   * <ul>
   *   <li>Then calls {@link AsyncCache#synchronous()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCacheCleanupService#clearCache(String)}
   */
  @Test
  @DisplayName("Test clearCache(String); then calls synchronous()")
  void testClearCache_thenCallsSynchronous() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AsyncCache<Object, Object> cache = mock(AsyncCache.class);
    when(cache.synchronous()).thenReturn(mock(Cache.class));
    new CaffeineCache("Name", cache, true);

    CaffeineCacheManager cacheManager = mock(CaffeineCacheManager.class);
    when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
    Optional<RedisTemplate<String, Object>> redisTemplate = Optional.empty();

    // Act
    (new DefaultCacheCleanupService(cacheManager, redisTemplate)).clearCache("3.7.0");

    // Assert that nothing has changed
    verify(cache).synchronous();
    verify(cacheManager).getCacheNames();
  }

  /**
   * Test {@link DefaultCacheCleanupService#clearCache(String)}.
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCacheCleanupService#clearCache(String)}
   */
  @Test
  @DisplayName("Test clearCache(String); then throw EmptyResultDataAccessException")
  void testClearCache_thenThrowEmptyResultDataAccessException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AsyncCache<Object, Object> cache = mock(AsyncCache.class);
    when(cache.synchronous()).thenReturn(mock(Cache.class));
    new CaffeineCache("Name", cache, true);

    CaffeineCacheManager cacheManager = mock(CaffeineCacheManager.class);
    when(cacheManager.getCacheNames()).thenThrow(new EmptyResultDataAccessException(3));
    Optional<RedisTemplate<String, Object>> redisTemplate = Optional.empty();

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class,
        () -> (new DefaultCacheCleanupService(cacheManager, redisTemplate)).clearCache("3.7.0"));
    verify(cache).synchronous();
    verify(cacheManager).getCacheNames();
  }

  /**
   * Test {@link DefaultCacheCleanupService#clearCache(String)}.
   * <ul>
   *   <li>When {@code 3.6.3}.</li>
   *   <li>Then calls {@link AsyncCache#synchronous()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCacheCleanupService#clearCache(String)}
   */
  @Test
  @DisplayName("Test clearCache(String); when '3.6.3'; then calls synchronous()")
  void testClearCache_when363_thenCallsSynchronous() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AsyncCache<Object, Object> cache = mock(AsyncCache.class);
    when(cache.synchronous()).thenReturn(mock(Cache.class));
    new CaffeineCache("Name", cache, true);

    CaffeineCacheManager cacheManager = mock(CaffeineCacheManager.class);
    when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
    Optional<RedisTemplate<String, Object>> redisTemplate = Optional.empty();

    // Act
    (new DefaultCacheCleanupService(cacheManager, redisTemplate)).clearCache("3.6.3");

    // Assert that nothing has changed
    verify(cache).synchronous();
    verify(cacheManager).getCacheNames();
  }

  /**
   * Test {@link DefaultCacheCleanupService#clearCache(String)}.
   * <ul>
   *   <li>When {@code 3.6.4}.</li>
   *   <li>Then calls {@link AsyncCache#synchronous()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCacheCleanupService#clearCache(String)}
   */
  @Test
  @DisplayName("Test clearCache(String); when '3.6.4'; then calls synchronous()")
  void testClearCache_when364_thenCallsSynchronous() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AsyncCache<Object, Object> cache = mock(AsyncCache.class);
    when(cache.synchronous()).thenReturn(mock(Cache.class));
    new CaffeineCache("Name", cache, true);

    CaffeineCacheManager cacheManager = mock(CaffeineCacheManager.class);
    when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
    Optional<RedisTemplate<String, Object>> redisTemplate = Optional.empty();

    // Act
    (new DefaultCacheCleanupService(cacheManager, redisTemplate)).clearCache("3.6.4");

    // Assert that nothing has changed
    verify(cache).synchronous();
    verify(cacheManager).getCacheNames();
  }

  /**
   * Test {@link DefaultCacheCleanupService#clearAllCaches()}.
   * <ul>
   *   <li>Then calls {@link CaffeineCacheManager#getCacheNames()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCacheCleanupService#clearAllCaches()}
   */
  @Test
  @DisplayName("Test clearAllCaches(); then calls getCacheNames()")
  void testClearAllCaches_thenCallsGetCacheNames() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CaffeineCacheManager cacheManager = mock(CaffeineCacheManager.class);
    when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
    Optional<RedisTemplate<String, Object>> redisTemplate = Optional.of(new RedisTemplate<>());

    // Act
    (new DefaultCacheCleanupService(cacheManager, redisTemplate)).clearAllCaches();

    // Assert that nothing has changed
    verify(cacheManager).getCacheNames();
  }

  /**
   * Test {@link DefaultCacheCleanupService#clearCacheByName(String)}.
   * <ul>
   *   <li>Then calls {@link CaffeineCacheManager#getCache(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCacheCleanupService#clearCacheByName(String)}
   */
  @Test
  @DisplayName("Test clearCacheByName(String); then calls getCache(String)")
  void testClearCacheByName_thenCallsGetCache() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CaffeineCacheManager cacheManager = mock(CaffeineCacheManager.class);
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
    Optional<RedisTemplate<String, Object>> redisTemplate = Optional.of(new RedisTemplate<>());

    // Act
    (new DefaultCacheCleanupService(cacheManager, redisTemplate)).clearCacheByName("Cache Name");

    // Assert
    verify(cacheManager).getCache(eq("Cache Name"));
  }

  /**
   * Test {@link DefaultCacheCleanupService#clearAll()}.
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCacheCleanupService#clearAll()}
   */
  @Test
  @DisplayName("Test clearAll(); then throw EmptyResultDataAccessException")
  void testClearAll_thenThrowEmptyResultDataAccessException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CacheManager cacheManager = mock(CacheManager.class);
    when(cacheManager.getCacheNames()).thenThrow(new EmptyResultDataAccessException(3));
    Optional<RedisTemplate<String, Object>> redisTemplate = Optional.empty();

    // Act and Assert
    assertThrows(EmptyResultDataAccessException.class,
        () -> (new DefaultCacheCleanupService(cacheManager, redisTemplate)).clearAll());
    verify(cacheManager).getCacheNames();
  }
}
