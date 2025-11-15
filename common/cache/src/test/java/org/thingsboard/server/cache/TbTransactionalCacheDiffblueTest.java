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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.github.benmanes.caffeine.cache.CacheLoader;
import java.io.Serializable;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.thingsboard.server.cache.customer.CustomerCacheKey;
import org.thingsboard.server.cache.customer.CustomerCaffeineCache;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.id.TenantId;

class TbTransactionalCacheDiffblueTest {
  /**
   * Method under test:
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)}
   */
  @Test
  void testGetOrFetchFromDB() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCaffeineCache customerCaffeineCache = new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    Supplier<Object> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn("Get");
    Function<Customer, Object> cacheValueToResult = mock(Function.class);
    Function<Object, Customer> dbValueToCacheValue = mock(Function.class);
    when(dbValueToCacheValue.apply(Mockito.<Object>any())).thenReturn(new Customer());

    // Act
    Object actualOrFetchFromDB = customerCaffeineCache.getOrFetchFromDB(customerCacheKey, dbCall, cacheValueToResult,
        dbValueToCacheValue, true, true);

    // Assert
    verify(dbValueToCacheValue).apply(isA(Object.class));
    verify(dbCall).get();
    assertEquals("Get", actualOrFetchFromDB);
  }

  /**
   * Method under test:
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)}
   */
  @Test
  void testGetOrFetchFromDB2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCaffeineCache customerCaffeineCache = new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    Supplier<Object> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn(null);
    Function<Customer, Object> cacheValueToResult = mock(Function.class);
    Function<Object, Customer> dbValueToCacheValue = mock(Function.class);
    when(dbValueToCacheValue.apply(Mockito.<Object>any())).thenReturn(new Customer());

    // Act
    Object actualOrFetchFromDB = customerCaffeineCache.getOrFetchFromDB(customerCacheKey, dbCall, cacheValueToResult,
        dbValueToCacheValue, true, true);

    // Assert
    verify(dbValueToCacheValue).apply(isNull());
    verify(dbCall).get();
    assertNull(actualOrFetchFromDB);
  }

  /**
   * Method under test:
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)}
   */
  @Test
  void testGetOrFetchFromDB3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCaffeineCache customerCaffeineCache = new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    Supplier<Object> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn("Get");

    // Act
    Object actualOrFetchFromDB = customerCaffeineCache.<Object>getOrFetchFromDB(customerCacheKey, dbCall,
        mock(Function.class), mock(Function.class), true, false);

    // Assert
    verify(dbCall).get();
    assertEquals("Get", actualOrFetchFromDB);
  }

  /**
   * Method under test:
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)}
   */
  @Test
  void testGetOrFetchFromDB4() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CacheLoader<Object, Object> cacheLoader = mock(CacheLoader.class);
    when(cacheLoader.load(Mockito.<Object>any())).thenReturn("Load");

    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    cacheManager.setCacheLoader(cacheLoader);
    CustomerCaffeineCache customerCaffeineCache = new CustomerCaffeineCache(cacheManager);

    // Act
    Object actualOrFetchFromDB = customerCaffeineCache.<Object>getOrFetchFromDB(
        new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr"), mock(Supplier.class), mock(Function.class),
        mock(Function.class), true, true);

    // Assert
    verify(cacheLoader).load(isA(Object.class));
    assertNull(actualOrFetchFromDB);
  }

  /**
   * Method under test:
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)}
   */
  @Test
  void testGetOrFetchFromDB5() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CacheLoader<Object, Object> cacheLoader = mock(CacheLoader.class);
    when(cacheLoader.load(Mockito.<Object>any())).thenReturn("Load");

    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    cacheManager.setCacheLoader(cacheLoader);
    CustomerCaffeineCache customerCaffeineCache = new CustomerCaffeineCache(cacheManager);

    // Act
    Object actualOrFetchFromDB = customerCaffeineCache.<Object>getOrFetchFromDB(
        new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr"), mock(Supplier.class), mock(Function.class),
        mock(Function.class), true, false);

    // Assert
    verify(cacheLoader).load(isA(Object.class));
    assertNull(actualOrFetchFromDB);
  }

  /**
   * Method under test:
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, boolean, boolean)}
   */
  @Test
  void testGetOrFetchFromDB6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCaffeineCache customerCaffeineCache = new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    Supplier<Customer> dbCall = mock(Supplier.class);
    Customer customer = new Customer();
    when(dbCall.get()).thenReturn(customer);

    // Act
    Customer actualOrFetchFromDB = customerCaffeineCache.getOrFetchFromDB(customerCacheKey, dbCall, true, true);

    // Assert
    verify(dbCall).get();
    assertSame(customer, actualOrFetchFromDB);
  }

  /**
   * Method under test:
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, boolean, boolean)}
   */
  @Test
  void testGetOrFetchFromDB7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCaffeineCache customerCaffeineCache = new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    Supplier<Customer> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn(null);

    // Act
    Customer actualOrFetchFromDB = customerCaffeineCache.getOrFetchFromDB(customerCacheKey, dbCall, true, true);

    // Assert
    verify(dbCall).get();
    assertNull(actualOrFetchFromDB);
  }

  /**
   * Method under test:
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, boolean, boolean)}
   */
  @Test
  void testGetOrFetchFromDB8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCaffeineCache customerCaffeineCache = new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    Supplier<Customer> dbCall = mock(Supplier.class);
    Customer customer = new Customer();
    when(dbCall.get()).thenReturn(customer);

    // Act
    Customer actualOrFetchFromDB = customerCaffeineCache.getOrFetchFromDB(customerCacheKey, dbCall, true, false);

    // Assert
    verify(dbCall).get();
    assertSame(customer, actualOrFetchFromDB);
  }

  /**
   * Method under test:
   * {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)}
   */
  @Test
  void testGetAndPutInTransaction() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCaffeineCache customerCaffeineCache = new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    Supplier<Object> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn("Get");
    Function<Customer, Object> cacheValueToResult = mock(Function.class);
    Function<Object, Customer> dbValueToCacheValue = mock(Function.class);
    when(dbValueToCacheValue.apply(Mockito.<Object>any())).thenReturn(new Customer());

    // Act
    Object actualAndPutInTransaction = customerCaffeineCache.getAndPutInTransaction(customerCacheKey, dbCall,
        cacheValueToResult, dbValueToCacheValue, true);

    // Assert
    verify(dbValueToCacheValue).apply(isA(Object.class));
    verify(dbCall).get();
    assertEquals("Get", actualAndPutInTransaction);
  }

  /**
   * Method under test:
   * {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)}
   */
  @Test
  void testGetAndPutInTransaction2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCaffeineCache customerCaffeineCache = new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    Supplier<Object> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn(null);
    Function<Customer, Object> cacheValueToResult = mock(Function.class);
    Function<Object, Customer> dbValueToCacheValue = mock(Function.class);
    when(dbValueToCacheValue.apply(Mockito.<Object>any())).thenReturn(new Customer());

    // Act
    Object actualAndPutInTransaction = customerCaffeineCache.getAndPutInTransaction(customerCacheKey, dbCall,
        cacheValueToResult, dbValueToCacheValue, true);

    // Assert
    verify(dbValueToCacheValue).apply(isNull());
    verify(dbCall).get();
    assertNull(actualAndPutInTransaction);
  }

  /**
   * Method under test:
   * {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)}
   */
  @Test
  void testGetAndPutInTransaction3() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CacheLoader<Object, Object> cacheLoader = mock(CacheLoader.class);
    when(cacheLoader.load(Mockito.<Object>any())).thenReturn("Load");

    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    cacheManager.setCacheLoader(cacheLoader);
    CustomerCaffeineCache customerCaffeineCache = new CustomerCaffeineCache(cacheManager);

    // Act
    Object actualAndPutInTransaction = customerCaffeineCache.<Object>getAndPutInTransaction(
        new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr"), mock(Supplier.class), mock(Function.class),
        mock(Function.class), true);

    // Assert
    verify(cacheLoader).load(isA(Object.class));
    assertNull(actualAndPutInTransaction);
  }

  /**
   * Method under test:
   * {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, boolean)}
   */
  @Test
  void testGetAndPutInTransaction4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCaffeineCache customerCaffeineCache = new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    Supplier<Customer> dbCall = mock(Supplier.class);
    Customer customer = new Customer();
    when(dbCall.get()).thenReturn(customer);

    // Act
    Customer actualAndPutInTransaction = customerCaffeineCache.getAndPutInTransaction(customerCacheKey, dbCall, true);

    // Assert
    verify(dbCall).get();
    assertSame(customer, actualAndPutInTransaction);
  }

  /**
   * Method under test:
   * {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, boolean)}
   */
  @Test
  void testGetAndPutInTransaction5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerCaffeineCache customerCaffeineCache = new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    Supplier<Customer> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn(null);

    // Act
    Customer actualAndPutInTransaction = customerCaffeineCache.getAndPutInTransaction(customerCacheKey, dbCall, true);

    // Assert
    verify(dbCall).get();
    assertNull(actualAndPutInTransaction);
  }
}
