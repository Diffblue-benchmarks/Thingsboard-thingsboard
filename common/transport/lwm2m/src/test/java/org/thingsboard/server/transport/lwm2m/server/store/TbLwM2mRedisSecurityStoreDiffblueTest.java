package org.thingsboard.server.transport.lwm2m.server.store;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import java.io.UnsupportedEncodingException;
import org.eclipse.leshan.core.peer.OscoreIdentity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

class TbLwM2mRedisSecurityStoreDiffblueTest {
  /**
   * Test
   * {@link TbLwM2mRedisSecurityStore#TbLwM2mRedisSecurityStore(RedisConnectionFactory)}.
   * <ul>
   *   <li>Given {@link AsyncTaskExecutor}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbLwM2mRedisSecurityStore#TbLwM2mRedisSecurityStore(RedisConnectionFactory)}
   */
  @Test
  @DisplayName("Test new TbLwM2mRedisSecurityStore(RedisConnectionFactory); given AsyncTaskExecutor")
  void testNewTbLwM2mRedisSecurityStore_givenAsyncTaskExecutor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
    connectionFactory.setExecutor(mock(AsyncTaskExecutor.class));

    // Act and Assert
    assertNull((new TbLwM2mRedisSecurityStore(connectionFactory)).getByOscoreIdentity(null));
  }

  /**
   * Test
   * {@link TbLwM2mRedisSecurityStore#TbLwM2mRedisSecurityStore(RedisConnectionFactory)}.
   * <ul>
   *   <li>When {@link JedisConnectionFactory#JedisConnectionFactory()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbLwM2mRedisSecurityStore#TbLwM2mRedisSecurityStore(RedisConnectionFactory)}
   */
  @Test
  @DisplayName("Test new TbLwM2mRedisSecurityStore(RedisConnectionFactory); when JedisConnectionFactory()")
  void testNewTbLwM2mRedisSecurityStore_whenJedisConnectionFactory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TbLwM2mRedisSecurityStore(new JedisConnectionFactory())).getByOscoreIdentity(null));
  }

  /**
   * Test {@link TbLwM2mRedisSecurityStore#getByOscoreIdentity(OscoreIdentity)}.
   * <p>
   * Method under test:
   * {@link TbLwM2mRedisSecurityStore#getByOscoreIdentity(OscoreIdentity)}
   */
  @Test
  @DisplayName("Test getByOscoreIdentity(OscoreIdentity)")
  void testGetByOscoreIdentity() throws UnsupportedEncodingException {
    // Arrange
    TbLwM2mRedisSecurityStore tbLwM2mRedisSecurityStore = new TbLwM2mRedisSecurityStore(new JedisConnectionFactory());

    // Act and Assert
    assertNull(tbLwM2mRedisSecurityStore.getByOscoreIdentity(new OscoreIdentity("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link TbLwM2mRedisSecurityStore#getByOscoreIdentity(OscoreIdentity)}.
   * <ul>
   *   <li>Given {@link JedisConnectionFactory#JedisConnectionFactory()} Executor is
   * {@link AsyncTaskExecutor}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbLwM2mRedisSecurityStore#getByOscoreIdentity(OscoreIdentity)}
   */
  @Test
  @DisplayName("Test getByOscoreIdentity(OscoreIdentity); given JedisConnectionFactory() Executor is AsyncTaskExecutor")
  void testGetByOscoreIdentity_givenJedisConnectionFactoryExecutorIsAsyncTaskExecutor()
      throws UnsupportedEncodingException {
    // Arrange
    JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
    connectionFactory.setExecutor(mock(AsyncTaskExecutor.class));
    TbLwM2mRedisSecurityStore tbLwM2mRedisSecurityStore = new TbLwM2mRedisSecurityStore(connectionFactory);

    // Act and Assert
    assertNull(tbLwM2mRedisSecurityStore.getByOscoreIdentity(new OscoreIdentity("AXAXAXAX".getBytes("UTF-8"))));
  }
}
