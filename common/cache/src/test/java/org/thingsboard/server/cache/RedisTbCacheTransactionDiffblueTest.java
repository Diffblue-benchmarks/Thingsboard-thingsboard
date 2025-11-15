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

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.redis.connection.DefaultStringRedisConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import redis.clients.jedis.Jedis;

class RedisTbCacheTransactionDiffblueTest {
  /**
   * Method under test:
   * {@link RedisTbCacheTransaction#put(Serializable, Serializable)}
   */
  @Test
  void testPut() {
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
