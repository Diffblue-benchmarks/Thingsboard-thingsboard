package org.thingsboard.server.cache;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.redis.connection.DefaultStringRedisConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import redis.clients.jedis.Jedis;

class RedisTbCacheTransactionDiffblueTest {
  /**
   * Test {@link RedisTbCacheTransaction#put(Serializable, Serializable)} with
   * {@code Serializable}, {@code Serializable}.
   * <ul>
   *   <li>Then calls
   * {@link RedisTbTransactionalCache#put(Serializable, Serializable, RedisConnection)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RedisTbCacheTransaction#put(Serializable, Serializable)}
   */
  @Test
  @DisplayName("Test put(Serializable, Serializable) with 'Serializable', 'Serializable'; then calls put(Serializable, Serializable, RedisConnection)")
  void testPutWithSerializableSerializable_thenCallsPut() {
    // Arrange
    RedisTbTransactionalCache<Serializable, Serializable> cache = mock(RedisTbTransactionalCache.class);
    doNothing().when(cache)
        .put(Mockito.<Serializable>any(), Mockito.<Serializable>any(), Mockito.<RedisConnection>any());
    DefaultStringRedisConnection connection = new DefaultStringRedisConnection(new JedisConnection(new Jedis()));
    Class<String> type = String.class;
    RedisTbCacheTransaction<Serializable, Serializable> redisTbCacheTransaction = new RedisTbCacheTransaction<>(cache,
        new DefaultStringRedisConnection(connection, new GenericToStringSerializer<>(type)));
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/mm/dd");

    // Act
    redisTbCacheTransaction.put(simpleDateFormat, new SimpleDateFormat("yyyy/mm/dd"));

    // Assert that nothing has changed
    verify(cache).put(isA(Serializable.class), isA(Serializable.class), isA(RedisConnection.class));
  }
}
