package org.thingsboard.server.cache.ota;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CaffeineOtaPackageCache.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class CaffeineOtaPackageCacheDiffblueTest {
  @MockBean private CacheManager cacheManager;

  @Autowired private CaffeineOtaPackageCache caffeineOtaPackageCache;

  /**
   * Test {@link CaffeineOtaPackageCache#get(String, int, int)} with {@code key}, {@code chunkSize},
   * {@code chunk}.
   *
   * <p>Method under test: {@link CaffeineOtaPackageCache#get(String, int, int)}
   */
  @Test
  @DisplayName("Test get(String, int, int) with 'key', 'chunkSize', 'chunk'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CaffeineOtaPackageCache.get(String, int, int)"})
  void testGetWithKeyChunkSizeChunk() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

    // Act
    byte[] actualGetResult = caffeineOtaPackageCache.get("Key", 3, 1);

    // Assert
    verify(cacheManager).getCache(eq("otaPackagesData"));
    assertArrayEquals(new byte[] {}, actualGetResult);
  }

  /**
   * Test {@link CaffeineOtaPackageCache#get(String, int, int)} with {@code key}, {@code chunkSize},
   * {@code chunk}.
   *
   * <ul>
   *   <li>Given {@link Cache} {@link Cache#get(Object, Class)} return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link CaffeineOtaPackageCache#get(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test get(String, int, int) with 'key', 'chunkSize', 'chunk'; given Cache get(Object, Class) return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CaffeineOtaPackageCache.get(String, int, int)"})
  void testGetWithKeyChunkSizeChunk_givenCacheGetReturnEmptyArrayOfByte() {
    // Arrange
    Cache cache = mock(Cache.class);
    when(cache.get(Mockito.<Object>any(), Mockito.<Class<byte[]>>any())).thenReturn(new byte[] {});
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(cache);

    // Act
    byte[] actualGetResult = caffeineOtaPackageCache.get("Key", 3, 1);

    // Assert
    verify(cache).get(isA(Object.class), isA(Class.class));
    verify(cacheManager).getCache(eq("otaPackagesData"));
    assertArrayEquals(new byte[] {}, actualGetResult);
  }

  /**
   * Test {@link CaffeineOtaPackageCache#get(String, int, int)} with {@code key}, {@code chunkSize},
   * {@code chunk}.
   *
   * <ul>
   *   <li>Then return {@code XAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link CaffeineOtaPackageCache#get(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test get(String, int, int) with 'key', 'chunkSize', 'chunk'; then return 'XAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CaffeineOtaPackageCache.get(String, int, int)"})
  void testGetWithKeyChunkSizeChunk_thenReturnXaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    Cache cache = mock(Cache.class);
    when(cache.get(Mockito.<Object>any(), Mockito.<Class<byte[]>>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(cache);

    // Act
    byte[] actualGetResult = caffeineOtaPackageCache.get("Key", 3, 1);

    // Assert
    verify(cache).get(isA(Object.class), isA(Class.class));
    verify(cacheManager).getCache(eq("otaPackagesData"));
    assertArrayEquals("XAX".getBytes("UTF-8"), actualGetResult);
  }

  /**
   * Test {@link CaffeineOtaPackageCache#get(String, int, int)} with {@code key}, {@code chunkSize},
   * {@code chunk}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link CaffeineOtaPackageCache#get(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test get(String, int, int) with 'key', 'chunkSize', 'chunk'; when eight; then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CaffeineOtaPackageCache.get(String, int, int)"})
  void testGetWithKeyChunkSizeChunk_whenEight_thenReturnEmptyArrayOfByte()
      throws UnsupportedEncodingException {
    // Arrange
    Cache cache = mock(Cache.class);
    when(cache.get(Mockito.<Object>any(), Mockito.<Class<byte[]>>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(cache);

    // Act
    byte[] actualGetResult = caffeineOtaPackageCache.get("Key", 8, 1);

    // Assert
    verify(cache).get(isA(Object.class), isA(Class.class));
    verify(cacheManager).getCache(eq("otaPackagesData"));
    assertArrayEquals(new byte[] {}, actualGetResult);
  }

  /**
   * Test {@link CaffeineOtaPackageCache#get(String, int, int)} with {@code key}, {@code chunkSize},
   * {@code chunk}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link CaffeineOtaPackageCache#get(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test get(String, int, int) with 'key', 'chunkSize', 'chunk'; when MIN_VALUE; then return empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CaffeineOtaPackageCache.get(String, int, int)"})
  void testGetWithKeyChunkSizeChunk_whenMin_value_thenReturnEmptyArrayOfByte()
      throws UnsupportedEncodingException {
    // Arrange
    Cache cache = mock(Cache.class);
    when(cache.get(Mockito.<Object>any(), Mockito.<Class<byte[]>>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(cache);

    // Act
    byte[] actualGetResult = caffeineOtaPackageCache.get("Key", 3, Integer.MIN_VALUE);

    // Assert
    verify(cache).get(isA(Object.class), isA(Class.class));
    verify(cacheManager).getCache(eq("otaPackagesData"));
    assertArrayEquals(new byte[] {}, actualGetResult);
  }

  /**
   * Test {@link CaffeineOtaPackageCache#get(String, int, int)} with {@code key}, {@code chunkSize},
   * {@code chunk}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link CaffeineOtaPackageCache#get(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test get(String, int, int) with 'key', 'chunkSize', 'chunk'; when zero; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CaffeineOtaPackageCache.get(String, int, int)"})
  void testGetWithKeyChunkSizeChunk_whenZero_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    Cache cache = mock(Cache.class);
    when(cache.get(Mockito.<Object>any(), Mockito.<Class<byte[]>>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(cache);

    // Act
    byte[] actualGetResult = caffeineOtaPackageCache.get("Key", 0, 1);

    // Assert
    verify(cache).get(isA(Object.class), isA(Class.class));
    verify(cacheManager).getCache(eq("otaPackagesData"));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualGetResult);
  }

  /**
   * Test {@link CaffeineOtaPackageCache#get(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CaffeineOtaPackageCache#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'key'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CaffeineOtaPackageCache.get(String)"})
  void testGetWithKey_thenReturnNull() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

    // Act
    byte[] actualGetResult = caffeineOtaPackageCache.get("Key");

    // Assert
    verify(cacheManager).getCache(eq("otaPackagesData"));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link CaffeineOtaPackageCache#put(String, byte[])}.
   *
   * <ul>
   *   <li>Then calls {@link CacheManager#getCache(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CaffeineOtaPackageCache#put(String, byte[])}
   */
  @Test
  @DisplayName("Test put(String, byte[]); then calls getCache(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CaffeineOtaPackageCache.put(String, byte[])"})
  void testPut_thenCallsGetCache() throws UnsupportedEncodingException {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

    // Act
    caffeineOtaPackageCache.put("Key", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(cacheManager).getCache(eq("otaPackagesData"));
  }

  /**
   * Test {@link CaffeineOtaPackageCache#evict(String)}.
   *
   * <ul>
   *   <li>Then calls {@link CacheManager#getCache(String)}.
   * </ul>
   *
   * <p>Method under test: {@link CaffeineOtaPackageCache#evict(String)}
   */
  @Test
  @DisplayName("Test evict(String); then calls getCache(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CaffeineOtaPackageCache.evict(String)"})
  void testEvict_thenCallsGetCache() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

    // Act
    caffeineOtaPackageCache.evict("Key");

    // Assert
    verify(cacheManager).getCache(eq("otaPackagesData"));
  }
}
