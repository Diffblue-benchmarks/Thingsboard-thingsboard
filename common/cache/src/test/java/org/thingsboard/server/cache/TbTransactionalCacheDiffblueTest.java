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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.thingsboard.server.cache.customer.CustomerCacheKey;
import org.thingsboard.server.cache.customer.CustomerCaffeineCache;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.id.TenantId;

class TbTransactionalCacheDiffblueTest {
  /**
   * Test
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, boolean, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheNullValue}, {@code putToCache}.
   * <ul>
   *   <li>Then return {@link Customer#Customer()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, boolean, boolean)}
   */
  @Test
  @DisplayName("Test getOrFetchFromDB(Serializable, Supplier, boolean, boolean) with 'key', 'dbCall', 'cacheNullValue', 'putToCache'; then return Customer()")
  void testGetOrFetchFromDBWithKeyDbCallCacheNullValuePutToCache_thenReturnCustomer() {
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
   * Test
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, boolean, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheNullValue}, {@code putToCache}.
   * <ul>
   *   <li>Then return {@link Customer#Customer()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, boolean, boolean)}
   */
  @Test
  @DisplayName("Test getOrFetchFromDB(Serializable, Supplier, boolean, boolean) with 'key', 'dbCall', 'cacheNullValue', 'putToCache'; then return Customer()")
  void testGetOrFetchFromDBWithKeyDbCallCacheNullValuePutToCache_thenReturnCustomer2() {
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
   * Test
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, boolean, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheNullValue}, {@code putToCache}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, boolean, boolean)}
   */
  @Test
  @DisplayName("Test getOrFetchFromDB(Serializable, Supplier, boolean, boolean) with 'key', 'dbCall', 'cacheNullValue', 'putToCache'; then return 'null'")
  void testGetOrFetchFromDBWithKeyDbCallCacheNullValuePutToCache_thenReturnNull() {
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
   * Test
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheValueToResult},
   * {@code dbValueToCacheValue}, {@code cacheNullValue}, {@code putToCache}.
   * <p>
   * Method under test:
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)}
   */
  @Test
  @DisplayName("Test getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue', 'putToCache'")
  void testGetOrFetchFromDBWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValuePutToCache() {
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
   * Test
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheValueToResult},
   * {@code dbValueToCacheValue}, {@code cacheNullValue}, {@code putToCache}.
   * <p>
   * Method under test:
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)}
   */
  @Test
  @DisplayName("Test getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue', 'putToCache'")
  void testGetOrFetchFromDBWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValuePutToCache2() {
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
   * Test
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheValueToResult},
   * {@code dbValueToCacheValue}, {@code cacheNullValue}, {@code putToCache}.
   * <p>
   * Method under test:
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)}
   */
  @Test
  @DisplayName("Test getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue', 'putToCache'")
  void testGetOrFetchFromDBWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValuePutToCache3() {
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
   * Test
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheValueToResult},
   * {@code dbValueToCacheValue}, {@code cacheNullValue}, {@code putToCache}.
   * <p>
   * Method under test:
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)}
   */
  @Test
  @DisplayName("Test getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue', 'putToCache'")
  void testGetOrFetchFromDBWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValuePutToCache4()
      throws Exception {
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
   * Test
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheValueToResult},
   * {@code dbValueToCacheValue}, {@code cacheNullValue}, {@code putToCache}.
   * <p>
   * Method under test:
   * {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)}
   */
  @Test
  @DisplayName("Test getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue', 'putToCache'")
  void testGetOrFetchFromDBWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValuePutToCache5()
      throws Exception {
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
   * Test
   * {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheNullValue}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, boolean)}
   */
  @Test
  @DisplayName("Test getAndPutInTransaction(Serializable, Supplier, boolean) with 'key', 'dbCall', 'cacheNullValue'; given 'null'; then return 'null'")
  void testGetAndPutInTransactionWithKeyDbCallCacheNullValue_givenNull_thenReturnNull() {
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

  /**
   * Test
   * {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheNullValue}.
   * <ul>
   *   <li>Then return {@link Customer#Customer()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, boolean)}
   */
  @Test
  @DisplayName("Test getAndPutInTransaction(Serializable, Supplier, boolean) with 'key', 'dbCall', 'cacheNullValue'; then return Customer()")
  void testGetAndPutInTransactionWithKeyDbCallCacheNullValue_thenReturnCustomer() {
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
   * Test
   * {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheValueToResult},
   * {@code dbValueToCacheValue}, {@code cacheNullValue}.
   * <p>
   * Method under test:
   * {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)}
   */
  @Test
  @DisplayName("Test getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue'")
  void testGetAndPutInTransactionWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValue() {
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
   * Test
   * {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheValueToResult},
   * {@code dbValueToCacheValue}, {@code cacheNullValue}.
   * <p>
   * Method under test:
   * {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)}
   */
  @Test
  @DisplayName("Test getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue'")
  void testGetAndPutInTransactionWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValue2() {
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
   * Test
   * {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheValueToResult},
   * {@code dbValueToCacheValue}, {@code cacheNullValue}.
   * <p>
   * Method under test:
   * {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)}
   */
  @Test
  @DisplayName("Test getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue'")
  void testGetAndPutInTransactionWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValue3() throws Exception {
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
}
