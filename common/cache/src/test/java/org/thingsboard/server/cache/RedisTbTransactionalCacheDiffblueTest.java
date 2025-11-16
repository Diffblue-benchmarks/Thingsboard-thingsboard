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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.redis.connection.DefaultStringRedisConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.thingsboard.server.cache.customer.CustomerCacheKey;
import org.thingsboard.server.cache.customer.CustomerRedisCache;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.id.TenantId;
import redis.clients.jedis.Jedis;

class RedisTbTransactionalCacheDiffblueTest {
  /**
   * Test {@link RedisTbTransactionalCache#getCacheName()}.
   *
   * <p>Method under test: {@link RedisTbTransactionalCache#getCacheName()}
   */
  @Test
  @DisplayName("Test getCacheName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RedisTbTransactionalCache.getCacheName()"})
  void testGetCacheName() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    CustomerRedisCache customerRedisCache =
        new CustomerRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());

    // Act and Assert
    assertEquals("customers", customerRedisCache.getCacheName());
  }

  /**
   * Test {@link RedisTbTransactionalCache#getConnectionFactory()}.
   *
   * <p>Method under test: {@link RedisTbTransactionalCache#getConnectionFactory()}
   */
  @Test
  @DisplayName("Test getConnectionFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JedisConnectionFactory RedisTbTransactionalCache.getConnectionFactory()"})
  void testGetConnectionFactory() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    JedisConnectionFactory connectionFactory = new JedisConnectionFactory();

    CustomerRedisCache customerRedisCache =
        new CustomerRedisCache(configuration, cacheSpecsMap, connectionFactory);

    // Act and Assert
    assertSame(connectionFactory, customerRedisCache.getConnectionFactory());
  }

  /**
   * Test {@link RedisTbTransactionalCache#get(Serializable)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RedisTbTransactionalCache#get(Serializable)}
   */
  @Test
  @DisplayName("Test get(Serializable); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbCacheValueWrapper RedisTbTransactionalCache.get(Serializable)"})
  void testGet_thenReturnNull() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    CustomerRedisCache customerRedisCache =
        new CustomerRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());

    // Act
    TbCacheValueWrapper<Customer> actualGetResult =
        customerRedisCache.get(new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr"));

    // Assert
    assertNull(actualGetResult);
  }

  /**
   * Test {@link RedisTbTransactionalCache#doGet(Serializable, RedisConnection)}.
   *
   * <ul>
   *   <li>Given {@code Select}.
   *   <li>When {@link Jedis} {@link Jedis#select(int)} return {@code Select}.
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RedisTbTransactionalCache#doGet(Serializable, RedisConnection)}
   */
  @Test
  @DisplayName(
      "Test doGet(Serializable, RedisConnection); given 'Select'; when Jedis select(int) return 'Select'; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RedisTbTransactionalCache.doGet(Serializable, RedisConnection)"})
  void testDoGet_givenSelect_whenJedisSelectReturnSelect_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    CustomerRedisCache customerRedisCache =
        new CustomerRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    Jedis jedis = mock(Jedis.class);
    when(jedis.select(anyInt())).thenReturn("Select");
    when(jedis.get(Mockito.<byte[]>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(jedis.getDB()).thenReturn(1);
    JedisConnection connection = new JedisConnection(jedis);
    DefaultStringRedisConnection connection2 = new DefaultStringRedisConnection(connection);
    Class<String> type = String.class;
    DefaultStringRedisConnection connection3 =
        new DefaultStringRedisConnection(connection2, new GenericToStringSerializer<>(type));

    // Act
    byte[] actualDoGetResult = customerRedisCache.doGet(customerCacheKey, connection3);

    // Assert
    verify(jedis).get(isA(byte[].class));
    verify(jedis).getDB();
    verify(jedis).select(0);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualDoGetResult);
  }

  /**
   * Test {@link RedisTbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function,
   * Function, boolean)} with {@code key}, {@code dbCall}, {@code cacheValueToResult}, {@code
   * dbValueToCacheValue}, {@code cacheNullValue}.
   *
   * <p>Method under test: {@link RedisTbTransactionalCache#getAndPutInTransaction(Serializable,
   * Supplier, Function, Function, boolean)}
   */
  @Test
  @DisplayName(
      "Test getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object RedisTbTransactionalCache.getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)"
  })
  void
      testGetAndPutInTransactionWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValue() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    CustomerRedisCache customerRedisCache =
        new CustomerRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    Supplier<Object> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenReturn("Get");

    // Act
    Object actualAndPutInTransaction =
        customerRedisCache.getAndPutInTransaction(
            customerCacheKey, dbCall, mock(Function.class), mock(Function.class), true);

    // Assert
    verify(dbCall).get();
    assertEquals("Get", actualAndPutInTransaction);
  }

  /**
   * Test {@link RedisTbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function,
   * Function, boolean)} with {@code key}, {@code dbCall}, {@code cacheValueToResult}, {@code
   * dbValueToCacheValue}, {@code cacheNullValue}.
   *
   * <p>Method under test: {@link RedisTbTransactionalCache#getAndPutInTransaction(Serializable,
   * Supplier, Function, Function, boolean)}
   */
  @Test
  @DisplayName(
      "Test getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object RedisTbTransactionalCache.getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)"
  })
  void
      testGetAndPutInTransactionWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValue2() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    CustomerRedisCache customerRedisCache =
        new CustomerRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    Supplier<Object> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            customerRedisCache.getAndPutInTransaction(
                customerCacheKey, dbCall, mock(Function.class), mock(Function.class), true));
    verify(dbCall).get();
  }

  /**
   * Test {@link RedisTbTransactionalCache#getRawValue(Serializable)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link RedisTbTransactionalCache#getRawValue(Serializable)}
   */
  @Test
  @DisplayName(
      "Test getRawValue(Serializable); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RedisTbTransactionalCache.getRawValue(Serializable)"})
  void testGetRawValue_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    CustomerRedisCache customerRedisCache =
        new CustomerRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());

    Customer customer = mock(Customer.class);
    when(customer.getId()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> customerRedisCache.getRawValue(customer));
    verify(customer).getId();
  }

  /**
   * Test {@link RedisTbTransactionalCache#getRawValue(Serializable)}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with minus eighty-four and minus nineteen.
   * </ul>
   *
   * <p>Method under test: {@link RedisTbTransactionalCache#getRawValue(Serializable)}
   */
  @Test
  @DisplayName(
      "Test getRawValue(Serializable); then return array of byte with minus eighty-four and minus nineteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RedisTbTransactionalCache.getRawValue(Serializable)"})
  void testGetRawValue_thenReturnArrayOfByteWithMinusEightyFourAndMinusNineteen() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    CustomerRedisCache customerRedisCache =
        new CustomerRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());

    // Act and Assert
    assertArrayEquals(
        new byte[] {
          -84, -19, 0, 5, 's', 'r', 0, '+', 'o', 'r', 'g', '.', 's', 'p', 'r', 'i', 'n', 'g', 'f',
          'r', 'a', 'm', 'e', 'w', 'o', 'r', 'k', '.', 'c', 'a', 'c', 'h', 'e', '.', 's', 'u', 'p',
          'p', 'o', 'r', 't', '.', 'N', 'u', 'l', 'l', 'V', 'a', 'l', 'u', 'e', 0, 0, 0, 0, 0, 0, 0,
          1, 2, 0, 0, 'x', 'p'
        },
        customerRedisCache.getRawValue(null));
  }
}
