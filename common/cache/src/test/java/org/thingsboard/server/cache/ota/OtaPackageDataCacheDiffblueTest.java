package org.thingsboard.server.cache.ota;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
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
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class OtaPackageDataCacheDiffblueTest {
  @MockBean
  private CacheManager cacheManager;

  @Autowired
  private OtaPackageDataCache otaPackageDataCache;

  /**
   * Test {@link OtaPackageDataCache#has(String)}.
   * <ul>
   *   <li>Given {@link Cache} {@link Cache#get(Object, Class)} return
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageDataCache#has(String)}
   */
  @Test
  @DisplayName("Test has(String); given Cache get(Object, Class) return 'AXAXAXAX' Bytes is 'UTF-8'; then return 'true'")
  void testHas_givenCacheGetReturnAxaxaxaxBytesIsUtf8_thenReturnTrue() throws UnsupportedEncodingException {
    // Arrange
    Cache cache = mock(Cache.class);
    when(cache.get(Mockito.<Object>any(), Mockito.<Class<byte[]>>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(cache);

    // Act
    boolean actualHasResult = otaPackageDataCache.has("42");

    // Assert
    verify(cache).get(isA(Object.class), isA(Class.class));
    verify(cacheManager).getCache(eq("otaPackagesData"));
    assertTrue(actualHasResult);
  }

  /**
   * Test {@link OtaPackageDataCache#has(String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageDataCache#has(String)}
   */
  @Test
  @DisplayName("Test has(String); then return 'false'")
  void testHas_thenReturnFalse() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

    // Act
    boolean actualHasResult = otaPackageDataCache.has("42");

    // Assert
    verify(cacheManager).getCache(eq("otaPackagesData"));
    assertFalse(actualHasResult);
  }
}
