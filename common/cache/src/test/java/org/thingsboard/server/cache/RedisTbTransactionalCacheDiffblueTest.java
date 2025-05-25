package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import redis.clients.jedis.Jedis;

class RedisTbTransactionalCacheDiffblueTest {
  /**
   * Test {@link RedisTbTransactionalCache#getCacheName()}.
   * <p>
   * Method under test: {@link RedisTbTransactionalCache#getCacheName()}
   */
  @Test
  @DisplayName("Test getCacheName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RedisTbTransactionalCache.getCacheName()"})
  void testGetCacheName() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    // Act and Assert
    assertEquals("customers",
        (new CustomerRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory())).getCacheName());
  }

  /**
   * Test {@link RedisTbTransactionalCache#getConnectionFactory()}.
   * <p>
   * Method under test: {@link RedisTbTransactionalCache#getConnectionFactory()}
   */
  @Test
  @DisplayName("Test getConnectionFactory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JedisConnectionFactory RedisTbTransactionalCache.getConnectionFactory()"})
  void testGetConnectionFactory() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    JedisConnectionFactory connectionFactory = new JedisConnectionFactory();

    // Act and Assert
    assertSame(connectionFactory,
        (new CustomerRedisCache(configuration, cacheSpecsMap, connectionFactory)).getConnectionFactory());
  }

  /**
   * Test {@link RedisTbTransactionalCache#get(Serializable)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RedisTbTransactionalCache#get(Serializable)}
   */
  @Test
  @DisplayName("Test get(Serializable); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.cache.TbCacheValueWrapper RedisTbTransactionalCache.get(Serializable)"})
  void testGet_thenReturnNull() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    CustomerRedisCache customerRedisCache = new CustomerRedisCache(configuration, cacheSpecsMap,
        new JedisConnectionFactory());

    // Act and Assert
    assertNull(customerRedisCache
        .get(new CustomerCacheKey(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr")));
  }

  /**
   * Test {@link RedisTbTransactionalCache#doGet(Serializable, RedisConnection)}.
   * <ul>
   *   <li>Given {@code Select}.</li>
   *   <li>When {@link Jedis} {@link Jedis#select(int)} return {@code Select}.</li>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RedisTbTransactionalCache#doGet(Serializable, RedisConnection)}
   */
  @Test
  @DisplayName("Test doGet(Serializable, RedisConnection); given 'Select'; when Jedis select(int) return 'Select'; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] RedisTbTransactionalCache.doGet(Serializable, RedisConnection)"})
  void testDoGet_givenSelect_whenJedisSelectReturnSelect_thenReturnAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    CustomerRedisCache customerRedisCache = new CustomerRedisCache(configuration, cacheSpecsMap,
        new JedisConnectionFactory());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Jedis jedis = mock(Jedis.class);
    when(jedis.select(anyInt())).thenReturn("Select");
    when(jedis.get(Mockito.<byte[]>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(jedis.getDB()).thenReturn(1);
    DefaultStringRedisConnection connection = new DefaultStringRedisConnection(new JedisConnection(jedis));
    Class<String> type = String.class;

    // Act
    byte[] actualDoGetResult = customerRedisCache.doGet(customerCacheKey,
        new DefaultStringRedisConnection(connection, new GenericToStringSerializer<>(type)));

    // Assert
    verify(jedis).get(isA(byte[].class));
    verify(jedis).getDB();
    verify(jedis).select(eq(0));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualDoGetResult);
  }

  /**
   * Test {@link RedisTbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)} with {@code key}, {@code dbCall}, {@code cacheValueToResult}, {@code dbValueToCacheValue}, {@code cacheNullValue}.
   * <p>
   * Method under test: {@link RedisTbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)}
   */
  @Test
  @DisplayName("Test getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Object RedisTbTransactionalCache.getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)"})
  void testGetAndPutInTransactionWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValue() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    CustomerRedisCache customerRedisCache = new CustomerRedisCache(configuration, cacheSpecsMap,
        new JedisConnectionFactory());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

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
   * Test {@link RedisTbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)} with {@code key}, {@code dbCall}, {@code cacheValueToResult}, {@code dbValueToCacheValue}, {@code cacheNullValue}.
   * <p>
   * Method under test: {@link RedisTbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)}
   */
  @Test
  @DisplayName("Test getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean) with 'key', 'dbCall', 'cacheValueToResult', 'dbValueToCacheValue', 'cacheNullValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "Object RedisTbTransactionalCache.getAndPutInTransaction(Serializable, Supplier, Function, Function, boolean)"})
  void testGetAndPutInTransactionWithKeyDbCallCacheValueToResultDbValueToCacheValueCacheNullValue2() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    CustomerRedisCache customerRedisCache = new CustomerRedisCache(configuration, cacheSpecsMap,
        new JedisConnectionFactory());
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr");

    Supplier<Object> dbCall = mock(Supplier.class);
    when(dbCall.get()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> customerRedisCache.<Object>getAndPutInTransaction(customerCacheKey,
        dbCall, mock(Function.class), mock(Function.class), true));
    verify(dbCall).get();
  }

  /**
   * Test {@link RedisTbTransactionalCache#getRawKey(Serializable)}.
   * <ul>
   *   <li>Then return {@code customers784f394c-42b6-435a-983c-b7beff2784f9_Dr} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RedisTbTransactionalCache#getRawKey(Serializable)}
   */
  @Test
  @DisplayName("Test getRawKey(Serializable); then return 'customers784f394c-42b6-435a-983c-b7beff2784f9_Dr' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] RedisTbTransactionalCache.getRawKey(Serializable)"})
  void testGetRawKey_thenReturnCustomers784f394c42b6435a983cB7beff2784f9DrBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    CustomerRedisCache customerRedisCache = new CustomerRedisCache(configuration, cacheSpecsMap,
        new JedisConnectionFactory());

    // Act
    byte[] actualRawKey = customerRedisCache
        .getRawKey(new CustomerCacheKey(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Dr"));

    // Assert
    assertArrayEquals("customers784f394c-42b6-435a-983c-b7beff2784f9_Dr".getBytes("UTF-8"), actualRawKey);
  }

  /**
   * Test {@link RedisTbTransactionalCache#getRawValue(Serializable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RedisTbTransactionalCache#getRawValue(Serializable)}
   */
  @Test
  @DisplayName("Test getRawValue(Serializable); given one; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] RedisTbTransactionalCache.getRawValue(Serializable)"})
  void testGetRawValue_givenOne_thenThrowRuntimeException() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    CustomerRedisCache customerRedisCache = new CustomerRedisCache(configuration, cacheSpecsMap,
        new JedisConnectionFactory());
    Customer customer = mock(Customer.class);
    when(customer.getVersion()).thenReturn(1L);
    when(customer.getAddress()).thenReturn("42 Main St");
    when(customer.getAddress2()).thenReturn("42 Main St");
    when(customer.getCity()).thenReturn("Oxford");
    when(customer.getCountry()).thenReturn("GB");
    when(customer.getEmail()).thenReturn("jane.doe@example.org");
    when(customer.getPhone()).thenReturn("6625550144");
    when(customer.getState()).thenReturn("MD");
    when(customer.getTitle()).thenReturn("Dr");
    when(customer.getZip()).thenReturn("21654");
    when(customer.getCreatedTime()).thenReturn(1L);
    when(customer.getExternalId()).thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(customer.getId()).thenReturn(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(customer.getTenantId()).thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> customerRedisCache.getRawValue(customer));
    verify(customer).getAddress();
    verify(customer).getAddress2();
    verify(customer).getCity();
    verify(customer).getCountry();
    verify(customer).getCreatedTime();
    verify(customer).getEmail();
    verify(customer).getExternalId();
    verify(customer).getId();
    verify(customer).getPhone();
    verify(customer).getState();
    verify(customer).getTenantId();
    verify(customer).getTitle();
    verify(customer).getVersion();
    verify(customer).getZip();
  }

  /**
   * Test {@link RedisTbTransactionalCache#getRawValue(Serializable)}.
   * <ul>
   *   <li>Then return array of {@code byte} with minus eighty-four and minus nineteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link RedisTbTransactionalCache#getRawValue(Serializable)}
   */
  @Test
  @DisplayName("Test getRawValue(Serializable); then return array of byte with minus eighty-four and minus nineteen")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] RedisTbTransactionalCache.getRawValue(Serializable)"})
  void testGetRawValue_thenReturnArrayOfByteWithMinusEightyFourAndMinusNineteen() {
    // Arrange
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    // Act and Assert
    assertArrayEquals(
        new byte[]{-84, -19, 0, 5, 's', 'r', 0, '+', 'o', 'r', 'g', '.', 's', 'p', 'r', 'i', 'n', 'g', 'f', 'r', 'a',
            'm', 'e', 'w', 'o', 'r', 'k', '.', 'c', 'a', 'c', 'h', 'e', '.', 's', 'u', 'p', 'p', 'o', 'r', 't', '.',
            'N', 'u', 'l', 'l', 'V', 'a', 'l', 'u', 'e', 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 'x', 'p'},
        (new CustomerRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory())).getRawValue(null));
  }
}
