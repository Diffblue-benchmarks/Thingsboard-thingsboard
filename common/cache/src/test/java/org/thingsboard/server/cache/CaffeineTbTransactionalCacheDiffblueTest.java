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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cache.customer.CustomerCacheKey;
import org.thingsboard.server.cache.customer.CustomerCaffeineCache;
import org.thingsboard.server.common.data.Customer;

@ContextConfiguration
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class CaffeineTbTransactionalCacheDiffblueTest {
  @MockBean
  private CacheManager cacheManager;

  @Autowired
  private CaffeineTbTransactionalCache<CustomerCacheKey, Customer> caffeineTbTransactionalCache;

  @MockBean
  private CustomerCaffeineCache customerCaffeineCache;

  /**
   * Method under test: {@link CaffeineTbTransactionalCache#commit(UUID, Map)}
   */
  @Test
  void testCommit() {
    // Arrange
    when(customerCaffeineCache.commit(Mockito.<UUID>any(), Mockito.<Map<CustomerCacheKey, Customer>>any()))
        .thenReturn(true);
    UUID trId = UUID.randomUUID();

    // Act
    boolean actualCommitResult = caffeineTbTransactionalCache.commit(trId, new HashMap<>());

    // Assert
    verify(customerCaffeineCache).commit(isA(UUID.class), isA(Map.class));
    assertTrue(actualCommitResult);
  }
}
