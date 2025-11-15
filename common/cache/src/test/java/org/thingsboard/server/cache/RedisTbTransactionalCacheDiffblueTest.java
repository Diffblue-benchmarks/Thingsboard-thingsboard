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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.Serializable;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.thingsboard.server.cache.customer.CustomerCacheKey;
import org.thingsboard.server.cache.customer.CustomerRedisCache;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.id.TenantId;

class RedisTbTransactionalCacheDiffblueTest {
  /**
   * Method under test:
   * {@link RedisTbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)}
   */
  @Test
  void testGetAndPutInTransaction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    CustomerRedisCache customerRedisCache = new CustomerRedisCache(configuration, cacheSpecsMap,
        new JedisConnectionFactory());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    Supplier<Object> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn("Get");

    // Act
    Object actualAndPutInTransaction = customerRedisCache.<Object>getAndPutInTransaction(customerCacheKey, dbCall,
        mock(Function.class), mock(Function.class), true);

    // Assert
    verify(dbCall).get();
    assertEquals("Get", actualAndPutInTransaction);
  }

  /**
   * Method under test:
   * {@link RedisTbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)}
   */
  @Test
  void testGetAndPutInTransaction2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    CustomerRedisCache customerRedisCache = new CustomerRedisCache(configuration, cacheSpecsMap,
        new JedisConnectionFactory());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    Supplier<Object> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> customerRedisCache.<Object>getAndPutInTransaction(customerCacheKey,
        dbCall, mock(Function.class), mock(Function.class), true));
    verify(dbCall).get();
  }

  /**
   * Method under test: {@link RedisTbTransactionalCache#getRawKey(Serializable)}
   */
  @Test
  void testGetRawKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    CustomerRedisCache customerRedisCache = new CustomerRedisCache(configuration, cacheSpecsMap,
        new JedisConnectionFactory());

    // Act
    byte[] actualRawKey = customerRedisCache.getRawKey(new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr"));

    // Assert
    assertEquals(48, actualRawKey.length);
    assertEquals('-', actualRawKey[17]);
    assertEquals('-', actualRawKey[22]);
    assertEquals('-', actualRawKey[27]);
    assertEquals('-', actualRawKey[Integer.SIZE]);
    assertEquals('4', actualRawKey[23]);
    assertEquals('D', actualRawKey[46]);
    assertEquals('_', actualRawKey[45]);
    assertEquals('c', actualRawKey[0]);
    assertEquals('e', actualRawKey[6]);
    assertEquals('m', actualRawKey[5]);
    assertEquals('o', actualRawKey[4]);
    assertEquals('r', actualRawKey[47]);
    assertEquals('r', actualRawKey[7]);
    assertEquals('s', actualRawKey[2]);
    assertEquals('s', actualRawKey[8]);
    assertEquals('t', actualRawKey[3]);
    assertEquals('u', actualRawKey[1]);
  }

  /**
   * Method under test: {@link RedisTbTransactionalCache#getCacheName()}
   */
  @Test
  void testGetCacheName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    // Act and Assert
    assertEquals("customers",
        (new CustomerRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory())).getCacheName());
  }

  /**
   * Method under test: {@link RedisTbTransactionalCache#getConnectionFactory()}
   */
  @Test
  void testGetConnectionFactory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    JedisConnectionFactory connectionFactory = new JedisConnectionFactory();

    // Act and Assert
    assertSame(connectionFactory,
        (new CustomerRedisCache(configuration, cacheSpecsMap, connectionFactory)).getConnectionFactory());
  }
}
