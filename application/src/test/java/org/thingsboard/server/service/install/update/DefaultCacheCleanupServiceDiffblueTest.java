package org.thingsboard.server.service.install.update;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.github.benmanes.caffeine.cache.Cache;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.dao.EmptyResultDataAccessException;

@ExtendWith(MockitoExtension.class)
class DefaultCacheCleanupServiceDiffblueTest {
  @Mock private CacheManager cacheManager;

  @InjectMocks private DefaultCacheCleanupService defaultCacheCleanupService;

  /**
   * Test {@link DefaultCacheCleanupService#clearCache(String)}.
   *
   * <ul>
   *   <li>Given {@link CacheManager} {@link CacheManager#getCache(String)} return {@link
   *       ConcurrentMapCache#ConcurrentMapCache(String)} with {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCacheCleanupService#clearCache(String)}
   */
  @Test
  @DisplayName(
      "Test clearCache(String); given CacheManager getCache(String) return ConcurrentMapCache(String) with 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultCacheCleanupService.clearCache(String)"})
  void testClearCache_givenCacheManagerGetCacheReturnConcurrentMapCacheWithName() throws Exception {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

    // Act
    defaultCacheCleanupService.clearCache("3.6.1");

    // Assert
    verify(cacheManager, atLeast(1)).getCache(Mockito.<String>any());
  }

  /**
   * Test {@link DefaultCacheCleanupService#clearCache(String)}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCacheCleanupService#clearCache(String)}
   */
  @Test
  @DisplayName("Test clearCache(String); then throw EmptyResultDataAccessException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultCacheCleanupService.clearCache(String)"})
  void testClearCache_thenThrowEmptyResultDataAccessException() throws Exception {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class, () -> defaultCacheCleanupService.clearCache("3.6.1"));
    verify(cacheManager).getCache(eq("securitySettings"));
  }

  /**
   * Test {@link DefaultCacheCleanupService#clearAllCaches()}.
   *
   * <p>Method under test: {@link DefaultCacheCleanupService#clearAllCaches()}
   */
  @Test
  @DisplayName("Test clearAllCaches()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultCacheCleanupService.clearAllCaches()"})
  void testClearAllCaches() {
    // Arrange
    when(cacheManager.getCacheNames()).thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class, () -> defaultCacheCleanupService.clearAllCaches());
    verify(cacheManager).getCacheNames();
  }

  /**
   * Test {@link DefaultCacheCleanupService#clearAllCaches()}.
   *
   * <p>Method under test: {@link DefaultCacheCleanupService#clearAllCaches()}
   */
  @Test
  @DisplayName("Test clearAllCaches()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultCacheCleanupService.clearAllCaches()"})
  void testClearAllCaches2() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    when(cacheManager.getCache(Mockito.<String>any()))
        .thenThrow(new EmptyResultDataAccessException(3));
    when(cacheManager.getCacheNames()).thenReturn(stringList);

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class, () -> defaultCacheCleanupService.clearAllCaches());
    verify(cacheManager).getCache(eq("foo"));
    verify(cacheManager).getCacheNames();
  }

  /**
   * Test {@link DefaultCacheCleanupService#clearAllCaches()}.
   *
   * <ul>
   *   <li>Given {@link Cache} {@link Cache#invalidateAll()} does nothing.
   *   <li>Then calls {@link Cache#invalidateAll()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCacheCleanupService#clearAllCaches()}
   */
  @Test
  @DisplayName(
      "Test clearAllCaches(); given Cache invalidateAll() does nothing; then calls invalidateAll()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultCacheCleanupService.clearAllCaches()"})
  void testClearAllCaches_givenCacheInvalidateAllDoesNothing_thenCallsInvalidateAll() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    stringList.add("foo");
    Cache<Object, Object> cache = mock(Cache.class);
    doNothing().when(cache).invalidateAll();
    when(cacheManager.getCache(Mockito.<String>any()))
        .thenReturn(new CaffeineCache("Clearing cache [{}]", cache, true));
    when(cacheManager.getCacheNames()).thenReturn(stringList);

    // Act
    defaultCacheCleanupService.clearAllCaches();

    // Assert
    verify(cache, atLeast(1)).invalidateAll();
    verify(cacheManager, atLeast(1)).getCache(eq("foo"));
    verify(cacheManager).getCacheNames();
  }

  /**
   * Test {@link DefaultCacheCleanupService#clearAllCaches()}.
   *
   * <ul>
   *   <li>Given {@link CacheManager} {@link CacheManager#getCache(String)} return {@link
   *       ConcurrentMapCache#ConcurrentMapCache(String)} with {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCacheCleanupService#clearAllCaches()}
   */
  @Test
  @DisplayName(
      "Test clearAllCaches(); given CacheManager getCache(String) return ConcurrentMapCache(String) with 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultCacheCleanupService.clearAllCaches()"})
  void testClearAllCaches_givenCacheManagerGetCacheReturnConcurrentMapCacheWithName() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("foo");
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
    when(cacheManager.getCacheNames()).thenReturn(stringList);

    // Act
    defaultCacheCleanupService.clearAllCaches();

    // Assert
    verify(cacheManager).getCache(eq("foo"));
    verify(cacheManager).getCacheNames();
  }

  /**
   * Test {@link DefaultCacheCleanupService#clearAllCaches()}.
   *
   * <ul>
   *   <li>Then calls {@link CacheManager#getCacheNames()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCacheCleanupService#clearAllCaches()}
   */
  @Test
  @DisplayName("Test clearAllCaches(); then calls getCacheNames()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultCacheCleanupService.clearAllCaches()"})
  void testClearAllCaches_thenCallsGetCacheNames() {
    // Arrange
    when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

    // Act
    defaultCacheCleanupService.clearAllCaches();

    // Assert
    verify(cacheManager).getCacheNames();
  }

  /**
   * Test {@link DefaultCacheCleanupService#clearCacheByName(String)}.
   *
   * <ul>
   *   <li>Given {@link CacheManager} {@link CacheManager#getCache(String)} return {@link
   *       ConcurrentMapCache#ConcurrentMapCache(String)} with {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCacheCleanupService#clearCacheByName(String)}
   */
  @Test
  @DisplayName(
      "Test clearCacheByName(String); given CacheManager getCache(String) return ConcurrentMapCache(String) with 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultCacheCleanupService.clearCacheByName(String)"})
  void testClearCacheByName_givenCacheManagerGetCacheReturnConcurrentMapCacheWithName() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

    // Act
    defaultCacheCleanupService.clearCacheByName("Cache Name");

    // Assert
    verify(cacheManager).getCache(eq("Cache Name"));
  }

  /**
   * Test {@link DefaultCacheCleanupService#clearCacheByName(String)}.
   *
   * <ul>
   *   <li>Then throw {@link EmptyResultDataAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultCacheCleanupService#clearCacheByName(String)}
   */
  @Test
  @DisplayName("Test clearCacheByName(String); then throw EmptyResultDataAccessException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultCacheCleanupService.clearCacheByName(String)"})
  void testClearCacheByName_thenThrowEmptyResultDataAccessException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any()))
        .thenThrow(new EmptyResultDataAccessException(3));

    // Act and Assert
    assertThrows(
        EmptyResultDataAccessException.class,
        () -> defaultCacheCleanupService.clearCacheByName("Cache Name"));
    verify(cacheManager).getCache(eq("Cache Name"));
  }
}
