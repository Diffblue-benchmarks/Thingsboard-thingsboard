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
package org.thingsboard.server.cache.ota;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] CaffeineOtaPackageCache.get(String)"})
  void testGetWithKey_thenReturnNull() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

    // Act
    byte[] actualGetResult = caffeineOtaPackageCache.get("Key");

    // Assert
    verify(cacheManager).getCache("otaPackagesData");
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CaffeineOtaPackageCache.put(String, byte[])"})
  void testPut_thenCallsGetCache() throws UnsupportedEncodingException {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

    // Act
    caffeineOtaPackageCache.put("Key", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(cacheManager).getCache("otaPackagesData");
  }
}
