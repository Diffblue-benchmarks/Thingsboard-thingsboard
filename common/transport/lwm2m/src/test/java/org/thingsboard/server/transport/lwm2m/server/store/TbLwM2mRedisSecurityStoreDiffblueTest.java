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
package org.thingsboard.server.transport.lwm2m.server.store;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import org.eclipse.leshan.core.peer.OscoreIdentity;
import org.junit.jupiter.api.Test;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

class TbLwM2mRedisSecurityStoreDiffblueTest {
  /**
   * Method under test:
   * {@link TbLwM2mRedisSecurityStore#getByOscoreIdentity(OscoreIdentity)}
   */
  @Test
  void testGetByOscoreIdentity() throws UnsupportedEncodingException {
    // Arrange
    TbLwM2mRedisSecurityStore tbLwM2mRedisSecurityStore = new TbLwM2mRedisSecurityStore(new JedisConnectionFactory());

    // Act and Assert
    assertNull(tbLwM2mRedisSecurityStore.getByOscoreIdentity(new OscoreIdentity("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test:
   * {@link TbLwM2mRedisSecurityStore#getByOscoreIdentity(OscoreIdentity)}
   */
  @Test
  void testGetByOscoreIdentity2() throws UnsupportedEncodingException {
    // Arrange
    JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
    connectionFactory.setExecutor(mock(AsyncTaskExecutor.class));
    TbLwM2mRedisSecurityStore tbLwM2mRedisSecurityStore = new TbLwM2mRedisSecurityStore(connectionFactory);

    // Act and Assert
    assertNull(tbLwM2mRedisSecurityStore.getByOscoreIdentity(new OscoreIdentity("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Method under test:
   * {@link TbLwM2mRedisSecurityStore#TbLwM2mRedisSecurityStore(RedisConnectionFactory)}
   */
  @Test
  void testNewTbLwM2mRedisSecurityStore() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TbLwM2mRedisSecurityStore(new JedisConnectionFactory())).getByOscoreIdentity(null));
  }

  /**
   * Method under test:
   * {@link TbLwM2mRedisSecurityStore#TbLwM2mRedisSecurityStore(RedisConnectionFactory)}
   */
  @Test
  void testNewTbLwM2mRedisSecurityStore2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
    connectionFactory.setExecutor(mock(AsyncTaskExecutor.class));

    // Act and Assert
    assertNull((new TbLwM2mRedisSecurityStore(connectionFactory)).getByOscoreIdentity(null));
  }
}
