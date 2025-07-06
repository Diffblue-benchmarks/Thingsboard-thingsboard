package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.thingsboard.server.cache.customer.CustomerCacheKey;
import org.thingsboard.server.cache.customer.CustomerCaffeineCache;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.id.TenantId;

class TbTransactionalCacheDiffblueTest {
  /**
   * Test {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, boolean, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheNullValue}, {@code putToCache}.
   *
   * <p>Method under test: {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getOrFetchFromDB(Serializable, Supplier, boolean, boolean) with 'key', 'dbCall', 'cacheNullValue', 'putToCache'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Serializable TbTransactionalCache.getOrFetchFromDB(Serializable, Supplier, boolean, boolean)"
  })
  void testGetOrFetchFromDBWithKeyDbCallCacheNullValuePutToCache() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Customer customer = new Customer();
    customerCaffeineCache.put(customerCacheKey, customer);

    // Act and Assert
    assertSame(
        customer,
        customerCaffeineCache.getOrFetchFromDB(
            new CustomerCacheKey(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"),
            mock(Supplier.class),
            true,
            true));
  }

  /**
   * Test {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, boolean, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheNullValue}, {@code putToCache}.
   *
   * <p>Method under test: {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getOrFetchFromDB(Serializable, Supplier, boolean, boolean) with 'key', 'dbCall', 'cacheNullValue', 'putToCache'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Serializable TbTransactionalCache.getOrFetchFromDB(Serializable, Supplier, boolean, boolean)"
  })
  void testGetOrFetchFromDBWithKeyDbCallCacheNullValuePutToCache2() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    customerCaffeineCache.put(
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"),
        null);

    // Act and Assert
    assertNull(
        customerCaffeineCache.getOrFetchFromDB(
            new CustomerCacheKey(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"),
            mock(Supplier.class),
            true,
            true));
  }

  /**
   * Test {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, boolean, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheNullValue}, {@code putToCache}.
   *
   * <p>Method under test: {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getOrFetchFromDB(Serializable, Supplier, boolean, boolean) with 'key', 'dbCall', 'cacheNullValue', 'putToCache'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Serializable TbTransactionalCache.getOrFetchFromDB(Serializable, Supplier, boolean, boolean)"
  })
  void testGetOrFetchFromDBWithKeyDbCallCacheNullValuePutToCache3() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Customer customer = new Customer();
    customerCaffeineCache.put(customerCacheKey, customer);

    // Act and Assert
    assertSame(
        customer,
        customerCaffeineCache.getOrFetchFromDB(
            new CustomerCacheKey(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"),
            mock(Supplier.class),
            true,
            false));
  }

  /**
   * Test {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, boolean, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheNullValue}, {@code putToCache}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer()}.
   * </ul>
   *
   * <p>Method under test: {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getOrFetchFromDB(Serializable, Supplier, boolean, boolean) with 'key', 'dbCall', 'cacheNullValue', 'putToCache'; given Customer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Serializable TbTransactionalCache.getOrFetchFromDB(Serializable, Supplier, boolean, boolean)"
  })
  void testGetOrFetchFromDBWithKeyDbCallCacheNullValuePutToCache_givenCustomer() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Supplier<Customer> dbCall = mock(Supplier.class);
    Customer customer = new Customer();
    when(dbCall.get()).thenReturn(customer);

    // Act
    Customer actualOrFetchFromDB =
        customerCaffeineCache.getOrFetchFromDB(customerCacheKey, dbCall, true, true);

    // Assert
    verify(dbCall).get();
    assertSame(customer, actualOrFetchFromDB);
  }

  /**
   * Test {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, boolean, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheNullValue}, {@code putToCache}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getOrFetchFromDB(Serializable, Supplier, boolean, boolean) with 'key', 'dbCall', 'cacheNullValue', 'putToCache'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Serializable TbTransactionalCache.getOrFetchFromDB(Serializable, Supplier, boolean, boolean)"
  })
  void testGetOrFetchFromDBWithKeyDbCallCacheNullValuePutToCache_thenReturnNull() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Supplier<Customer> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn(null);

    // Act
    Customer actualOrFetchFromDB =
        customerCaffeineCache.getOrFetchFromDB(customerCacheKey, dbCall, true, true);

    // Assert
    verify(dbCall).get();
    assertNull(actualOrFetchFromDB);
  }

  /**
   * Test {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, boolean, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheNullValue}, {@code putToCache}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getOrFetchFromDB(Serializable, Supplier, boolean, boolean) with 'key', 'dbCall', 'cacheNullValue', 'putToCache'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Serializable TbTransactionalCache.getOrFetchFromDB(Serializable, Supplier, boolean, boolean)"
  })
  void testGetOrFetchFromDBWithKeyDbCallCacheNullValuePutToCache_thenReturnNull2() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Supplier<Customer> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn(null);

    // Act
    Customer actualOrFetchFromDB =
        customerCaffeineCache.getOrFetchFromDB(customerCacheKey, dbCall, false, true);

    // Assert
    verify(dbCall).get();
    assertNull(actualOrFetchFromDB);
  }

  /**
   * Test {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, boolean, boolean)}
   * with {@code key}, {@code dbCall}, {@code cacheNullValue}, {@code putToCache}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier,
   * boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getOrFetchFromDB(Serializable, Supplier, boolean, boolean) with 'key', 'dbCall', 'cacheNullValue', 'putToCache'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Serializable TbTransactionalCache.getOrFetchFromDB(Serializable, Supplier, boolean, boolean)"
  })
  void testGetOrFetchFromDBWithKeyDbCallCacheNullValuePutToCache_thenReturnNull3() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Supplier<Customer> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn(null);

    // Act
    Customer actualOrFetchFromDB =
        customerCaffeineCache.getOrFetchFromDB(customerCacheKey, dbCall, true, false);

    // Assert
    verify(dbCall).get();
    assertNull(actualOrFetchFromDB);
  }

  /**
   * Test {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function,
   * boolean, boolean)} with {@code key}, {@code dbCall}, {@code cacheValueToResult}, {@code
   * dbValueToCacheValue}, {@code cacheNullValue}, {@code putToCache}.
   *
   * <p>Method under test: {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier,
   * Function, Function, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue', 'putToCache'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Object TbTransactionalCache.getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)"
  })
  void
      testGetOrFetchFromDBWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValuePutToCache() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Supplier<Object> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn(null);
    Function<Customer, Object> cacheValueToResult = mock(Function.class);
    Function<Object, Customer> dbValueToCacheValue = mock(Function.class);
    when(dbValueToCacheValue.apply(Mockito.<Object>any())).thenReturn(new Customer());

    // Act
    Object actualOrFetchFromDB =
        customerCaffeineCache.getOrFetchFromDB(
            customerCacheKey, dbCall, cacheValueToResult, dbValueToCacheValue, true, true);

    // Assert
    verify(dbValueToCacheValue).apply(isNull());
    verify(dbCall).get();
    assertNull(actualOrFetchFromDB);
  }

  /**
   * Test {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function,
   * boolean, boolean)} with {@code key}, {@code dbCall}, {@code cacheValueToResult}, {@code
   * dbValueToCacheValue}, {@code cacheNullValue}, {@code putToCache}.
   *
   * <p>Method under test: {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier,
   * Function, Function, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue', 'putToCache'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Object TbTransactionalCache.getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)"
  })
  void
      testGetOrFetchFromDBWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValuePutToCache2() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Supplier<Object> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn("Get");
    Function<Customer, Object> cacheValueToResult = mock(Function.class);
    Function<Object, Customer> dbValueToCacheValue = mock(Function.class);
    when(dbValueToCacheValue.apply(Mockito.<Object>any())).thenReturn(new Customer());

    // Act
    Object actualOrFetchFromDB =
        customerCaffeineCache.getOrFetchFromDB(
            customerCacheKey, dbCall, cacheValueToResult, dbValueToCacheValue, true, true);

    // Assert
    verify(dbValueToCacheValue).apply(isA(Object.class));
    verify(dbCall).get();
    assertEquals("Get", actualOrFetchFromDB);
  }

  /**
   * Test {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function,
   * boolean, boolean)} with {@code key}, {@code dbCall}, {@code cacheValueToResult}, {@code
   * dbValueToCacheValue}, {@code cacheNullValue}, {@code putToCache}.
   *
   * <p>Method under test: {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier,
   * Function, Function, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue', 'putToCache'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Object TbTransactionalCache.getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)"
  })
  void
      testGetOrFetchFromDBWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValuePutToCache3() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    customerCaffeineCache.put(customerCacheKey, new Customer());
    CustomerCacheKey customerCacheKey2 =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Supplier<Object> dbCall = mock(Supplier.class);
    Function<Customer, Object> cacheValueToResult = mock(Function.class);
    when(cacheValueToResult.apply(Mockito.<Customer>any())).thenReturn("Apply");

    // Act
    Object actualOrFetchFromDB =
        customerCaffeineCache.getOrFetchFromDB(
            customerCacheKey2, dbCall, cacheValueToResult, mock(Function.class), true, true);

    // Assert
    verify(cacheValueToResult).apply(isA(Customer.class));
    assertEquals("Apply", actualOrFetchFromDB);
  }

  /**
   * Test {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function,
   * boolean, boolean)} with {@code key}, {@code dbCall}, {@code cacheValueToResult}, {@code
   * dbValueToCacheValue}, {@code cacheNullValue}, {@code putToCache}.
   *
   * <p>Method under test: {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier,
   * Function, Function, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue', 'putToCache'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Object TbTransactionalCache.getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)"
  })
  void
      testGetOrFetchFromDBWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValuePutToCache4() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    customerCaffeineCache.put(
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"),
        null);

    // Act and Assert
    assertNull(
        customerCaffeineCache.<Object>getOrFetchFromDB(
            new CustomerCacheKey(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"),
            mock(Supplier.class),
            mock(Function.class),
            mock(Function.class),
            true,
            true));
  }

  /**
   * Test {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function,
   * boolean, boolean)} with {@code key}, {@code dbCall}, {@code cacheValueToResult}, {@code
   * dbValueToCacheValue}, {@code cacheNullValue}, {@code putToCache}.
   *
   * <p>Method under test: {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier,
   * Function, Function, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue', 'putToCache'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Object TbTransactionalCache.getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)"
  })
  void
      testGetOrFetchFromDBWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValuePutToCache5() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    customerCaffeineCache.put(customerCacheKey, new Customer());
    CustomerCacheKey customerCacheKey2 =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Supplier<Object> dbCall = mock(Supplier.class);
    Function<Customer, Object> cacheValueToResult = mock(Function.class);
    when(cacheValueToResult.apply(Mockito.<Customer>any())).thenReturn("Apply");

    // Act
    Object actualOrFetchFromDB =
        customerCaffeineCache.getOrFetchFromDB(
            customerCacheKey2, dbCall, cacheValueToResult, mock(Function.class), true, false);

    // Assert
    verify(cacheValueToResult).apply(isA(Customer.class));
    assertEquals("Apply", actualOrFetchFromDB);
  }

  /**
   * Test {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function,
   * boolean, boolean)} with {@code key}, {@code dbCall}, {@code cacheValueToResult}, {@code
   * dbValueToCacheValue}, {@code cacheNullValue}, {@code putToCache}.
   *
   * <p>Method under test: {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier,
   * Function, Function, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue', 'putToCache'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Object TbTransactionalCache.getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)"
  })
  void
      testGetOrFetchFromDBWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValuePutToCache6() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    customerCaffeineCache.put(
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"),
        null);

    // Act and Assert
    assertNull(
        customerCaffeineCache.<Object>getOrFetchFromDB(
            new CustomerCacheKey(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"),
            mock(Supplier.class),
            mock(Function.class),
            mock(Function.class),
            true,
            false));
  }

  /**
   * Test {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier, Function, Function,
   * boolean, boolean)} with {@code key}, {@code dbCall}, {@code cacheValueToResult}, {@code
   * dbValueToCacheValue}, {@code cacheNullValue}, {@code putToCache}.
   *
   * <p>Method under test: {@link TbTransactionalCache#getOrFetchFromDB(Serializable, Supplier,
   * Function, Function, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue', 'putToCache'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Object TbTransactionalCache.getOrFetchFromDB(Serializable, Supplier, Function, Function, boolean, boolean)"
  })
  void
      testGetOrFetchFromDBWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValuePutToCache7() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    customerCaffeineCache.put(customerCacheKey, new Customer());
    CustomerCacheKey customerCacheKey2 =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Supplier<Object> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn(null);

    // Act
    Object actualOrFetchFromDB =
        customerCaffeineCache.<Object>getOrFetchFromDB(
            customerCacheKey2, dbCall, mock(Function.class), mock(Function.class), true, false);

    // Assert
    verify(dbCall).get();
    assertNull(actualOrFetchFromDB);
  }

  /**
   * Test {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, boolean)} with
   * {@code key}, {@code dbCall}, {@code cacheNullValue}.
   *
   * <p>Method under test: {@link TbTransactionalCache#getAndPutInTransaction(Serializable,
   * Supplier, boolean)}
   */
  @Test
  @DisplayName(
      "Test getAndPutInTransaction(Serializable, Supplier, boolean) with 'key', 'dbCall', 'cacheNullValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Serializable TbTransactionalCache.getAndPutInTransaction(Serializable, Supplier, boolean)"
  })
  void testGetAndPutInTransactionWithKeyDbCallCacheNullValue() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Customer customer = new Customer();
    customerCaffeineCache.put(customerCacheKey, customer);

    // Act and Assert
    assertSame(
        customer,
        customerCaffeineCache.getAndPutInTransaction(
            new CustomerCacheKey(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"),
            mock(Supplier.class),
            true));
  }

  /**
   * Test {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, boolean)} with
   * {@code key}, {@code dbCall}, {@code cacheNullValue}.
   *
   * <p>Method under test: {@link TbTransactionalCache#getAndPutInTransaction(Serializable,
   * Supplier, boolean)}
   */
  @Test
  @DisplayName(
      "Test getAndPutInTransaction(Serializable, Supplier, boolean) with 'key', 'dbCall', 'cacheNullValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Serializable TbTransactionalCache.getAndPutInTransaction(Serializable, Supplier, boolean)"
  })
  void testGetAndPutInTransactionWithKeyDbCallCacheNullValue2() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    customerCaffeineCache.put(
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"),
        null);

    // Act and Assert
    assertNull(
        customerCaffeineCache.getAndPutInTransaction(
            new CustomerCacheKey(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"),
            mock(Supplier.class),
            true));
  }

  /**
   * Test {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, boolean)} with
   * {@code key}, {@code dbCall}, {@code cacheNullValue}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer()}.
   * </ul>
   *
   * <p>Method under test: {@link TbTransactionalCache#getAndPutInTransaction(Serializable,
   * Supplier, boolean)}
   */
  @Test
  @DisplayName(
      "Test getAndPutInTransaction(Serializable, Supplier, boolean) with 'key', 'dbCall', 'cacheNullValue'; given Customer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Serializable TbTransactionalCache.getAndPutInTransaction(Serializable, Supplier, boolean)"
  })
  void testGetAndPutInTransactionWithKeyDbCallCacheNullValue_givenCustomer() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Supplier<Customer> dbCall = mock(Supplier.class);
    Customer customer = new Customer();
    when(dbCall.get()).thenReturn(customer);

    // Act
    Customer actualAndPutInTransaction =
        customerCaffeineCache.getAndPutInTransaction(customerCacheKey, dbCall, true);

    // Assert
    verify(dbCall).get();
    assertSame(customer, actualAndPutInTransaction);
  }

  /**
   * Test {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, boolean)} with
   * {@code key}, {@code dbCall}, {@code cacheNullValue}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbTransactionalCache#getAndPutInTransaction(Serializable,
   * Supplier, boolean)}
   */
  @Test
  @DisplayName(
      "Test getAndPutInTransaction(Serializable, Supplier, boolean) with 'key', 'dbCall', 'cacheNullValue'; given 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Serializable TbTransactionalCache.getAndPutInTransaction(Serializable, Supplier, boolean)"
  })
  void testGetAndPutInTransactionWithKeyDbCallCacheNullValue_givenNull_thenReturnNull() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Supplier<Customer> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn(null);

    // Act
    Customer actualAndPutInTransaction =
        customerCaffeineCache.getAndPutInTransaction(customerCacheKey, dbCall, true);

    // Assert
    verify(dbCall).get();
    assertNull(actualAndPutInTransaction);
  }

  /**
   * Test {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, boolean)} with
   * {@code key}, {@code dbCall}, {@code cacheNullValue}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbTransactionalCache#getAndPutInTransaction(Serializable,
   * Supplier, boolean)}
   */
  @Test
  @DisplayName(
      "Test getAndPutInTransaction(Serializable, Supplier, boolean) with 'key', 'dbCall', 'cacheNullValue'; when 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Serializable TbTransactionalCache.getAndPutInTransaction(Serializable, Supplier, boolean)"
  })
  void testGetAndPutInTransactionWithKeyDbCallCacheNullValue_whenFalse_thenReturnNull() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Supplier<Customer> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn(null);

    // Act
    Customer actualAndPutInTransaction =
        customerCaffeineCache.getAndPutInTransaction(customerCacheKey, dbCall, false);

    // Assert
    verify(dbCall).get();
    assertNull(actualAndPutInTransaction);
  }

  /**
   * Test {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function,
   * Function, boolean)} with {@code key}, {@code dbCall}, {@code cacheValueToResult}, {@code
   * dbValueToCacheValue}, {@code cacheNullValue}.
   *
   * <p>Method under test: {@link TbTransactionalCache#getAndPutInTransaction(Serializable,
   * Supplier, Function, Function, boolean)}
   */
  @Test
  @DisplayName(
      "Test getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Object TbTransactionalCache.getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)"
  })
  void
      testGetAndPutInTransactionWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValue() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Supplier<Object> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn(null);
    Function<Customer, Object> cacheValueToResult = mock(Function.class);
    Function<Object, Customer> dbValueToCacheValue = mock(Function.class);
    when(dbValueToCacheValue.apply(Mockito.<Object>any())).thenReturn(new Customer());

    // Act
    Object actualAndPutInTransaction =
        customerCaffeineCache.getAndPutInTransaction(
            customerCacheKey, dbCall, cacheValueToResult, dbValueToCacheValue, true);

    // Assert
    verify(dbValueToCacheValue).apply(isNull());
    verify(dbCall).get();
    assertNull(actualAndPutInTransaction);
  }

  /**
   * Test {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function,
   * Function, boolean)} with {@code key}, {@code dbCall}, {@code cacheValueToResult}, {@code
   * dbValueToCacheValue}, {@code cacheNullValue}.
   *
   * <p>Method under test: {@link TbTransactionalCache#getAndPutInTransaction(Serializable,
   * Supplier, Function, Function, boolean)}
   */
  @Test
  @DisplayName(
      "Test getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Object TbTransactionalCache.getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)"
  })
  void
      testGetAndPutInTransactionWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValue2() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Supplier<Object> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn("Get");
    Function<Customer, Object> cacheValueToResult = mock(Function.class);
    Function<Object, Customer> dbValueToCacheValue = mock(Function.class);
    when(dbValueToCacheValue.apply(Mockito.<Object>any())).thenReturn(new Customer());

    // Act
    Object actualAndPutInTransaction =
        customerCaffeineCache.getAndPutInTransaction(
            customerCacheKey, dbCall, cacheValueToResult, dbValueToCacheValue, true);

    // Assert
    verify(dbValueToCacheValue).apply(isA(Object.class));
    verify(dbCall).get();
    assertEquals("Get", actualAndPutInTransaction);
  }

  /**
   * Test {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function,
   * Function, boolean)} with {@code key}, {@code dbCall}, {@code cacheValueToResult}, {@code
   * dbValueToCacheValue}, {@code cacheNullValue}.
   *
   * <p>Method under test: {@link TbTransactionalCache#getAndPutInTransaction(Serializable,
   * Supplier, Function, Function, boolean)}
   */
  @Test
  @DisplayName(
      "Test getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Object TbTransactionalCache.getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)"
  })
  void
      testGetAndPutInTransactionWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValue3() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    CustomerCacheKey customerCacheKey =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    customerCaffeineCache.put(customerCacheKey, new Customer());
    CustomerCacheKey customerCacheKey2 =
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Supplier<Object> dbCall = mock(Supplier.class);
    Function<Customer, Object> cacheValueToResult = mock(Function.class);
    when(cacheValueToResult.apply(Mockito.<Customer>any())).thenReturn("Apply");

    // Act
    Object actualAndPutInTransaction =
        customerCaffeineCache.getAndPutInTransaction(
            customerCacheKey2, dbCall, cacheValueToResult, mock(Function.class), true);

    // Assert
    verify(cacheValueToResult).apply(isA(Customer.class));
    assertEquals("Apply", actualAndPutInTransaction);
  }

  /**
   * Test {@link TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function,
   * Function, boolean)} with {@code key}, {@code dbCall}, {@code cacheValueToResult}, {@code
   * dbValueToCacheValue}, {@code cacheNullValue}.
   *
   * <p>Method under test: {@link TbTransactionalCache#getAndPutInTransaction(Serializable,
   * Supplier, Function, Function, boolean)}
   */
  @Test
  @DisplayName(
      "Test getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Object TbTransactionalCache.getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)"
  })
  void
      testGetAndPutInTransactionWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValue4() {
    // Arrange
    CustomerCaffeineCache customerCaffeineCache =
        new CustomerCaffeineCache(new CaffeineCacheManager());
    customerCaffeineCache.put(
        new CustomerCacheKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"),
        null);

    // Act and Assert
    assertNull(
        customerCaffeineCache.<Object>getAndPutInTransaction(
            new CustomerCacheKey(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"),
            mock(Supplier.class),
            mock(Function.class),
            mock(Function.class),
            true));
  }
}
