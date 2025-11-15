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

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Collection;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TbCaffeineCacheConfiguration.class, CacheSpecsMap.class})
@ExtendWith(SpringExtension.class)
class TbCaffeineCacheConfigurationDiffblueTest {
  @Autowired
  private CacheSpecsMap cacheSpecsMap;

  @Autowired
  private TbCaffeineCacheConfiguration tbCaffeineCacheConfiguration;

  /**
   * Method under test: {@link TbCaffeineCacheConfiguration#cacheManager()}
   */
  @Test
  void testCacheManager() {
    // Arrange and Act
    CacheManager actualCacheManagerResult = tbCaffeineCacheConfiguration.cacheManager();

    // Assert
    Collection<String> cacheNames = actualCacheManagerResult.getCacheNames();
    assertTrue(cacheNames instanceof Set);
    assertTrue(actualCacheManagerResult instanceof SimpleCacheManager);
    assertTrue(cacheNames.isEmpty());
  }
}
