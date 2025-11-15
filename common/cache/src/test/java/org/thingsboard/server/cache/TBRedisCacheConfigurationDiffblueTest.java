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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.Duration;
import java.util.Collection;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.cache.CacheManager;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

class TBRedisCacheConfigurationDiffblueTest {
  /**
   * Method under test:
   * {@link TBRedisCacheConfiguration#cacheManager(RedisConnectionFactory)}
   */
  @Test
  void testCacheManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    CacheManager actualCacheManagerResult = tbRedisClusterConfiguration.cacheManager(new JedisConnectionFactory());

    // Assert
    Collection<String> cacheNames = actualCacheManagerResult.getCacheNames();
    assertTrue(cacheNames instanceof Set);
    assertTrue(actualCacheManagerResult instanceof RedisCacheManager);
    assertTrue(cacheNames.isEmpty());
    assertTrue(((RedisCacheManager) actualCacheManagerResult).getCacheConfigurations().isEmpty());
    assertTrue(((RedisCacheManager) actualCacheManagerResult).isTransactionAware());
    assertTrue(((RedisCacheManager) actualCacheManagerResult).isAllowRuntimeCacheCreation());
  }

  /**
   * Method under test:
   * {@link TBRedisCacheConfiguration#cacheManager(RedisConnectionFactory)}
   */
  @Test
  void testCacheManager2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    JedisConnectionFactory cf = new JedisConnectionFactory();
    cf.setExecutor(mock(AsyncTaskExecutor.class));

    // Act
    CacheManager actualCacheManagerResult = tbRedisClusterConfiguration.cacheManager(cf);

    // Assert
    Collection<String> cacheNames = actualCacheManagerResult.getCacheNames();
    assertTrue(cacheNames instanceof Set);
    assertTrue(actualCacheManagerResult instanceof RedisCacheManager);
    assertTrue(cacheNames.isEmpty());
    assertTrue(((RedisCacheManager) actualCacheManagerResult).getCacheConfigurations().isEmpty());
    assertTrue(((RedisCacheManager) actualCacheManagerResult).isTransactionAware());
    assertTrue(((RedisCacheManager) actualCacheManagerResult).isAllowRuntimeCacheCreation());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#buildPoolConfig()}
   */
  @Test
  void testBuildPoolConfig() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    JedisPoolConfig actualBuildPoolConfigResult = (new TBRedisClusterConfiguration()).buildPoolConfig();

    // Assert
    assertEquals("org.apache.commons.pool2.impl.DefaultEvictionPolicy",
        actualBuildPoolConfigResult.getEvictionPolicyClassName());
    assertEquals("pool", actualBuildPoolConfigResult.getJmxNamePrefix());
    assertNull(actualBuildPoolConfigResult.getJmxNameBase());
    assertNull(actualBuildPoolConfigResult.getEvictionPolicy());
    assertEquals(0, actualBuildPoolConfigResult.getNumTestsPerEvictionRun());
    assertEquals(0, actualBuildPoolConfigResult.getMaxIdle());
    assertEquals(0, actualBuildPoolConfigResult.getMaxTotal());
    assertEquals(0, actualBuildPoolConfigResult.getMinIdle());
    Duration durationBetweenEvictionRuns = actualBuildPoolConfigResult.getDurationBetweenEvictionRuns();
    assertEquals(0L, durationBetweenEvictionRuns.toNanos());
    assertEquals(0L, actualBuildPoolConfigResult.getMaxWaitMillis());
    assertEquals(0L, actualBuildPoolConfigResult.getSoftMinEvictableIdleTimeMillis());
    assertEquals(0L, actualBuildPoolConfigResult.getTimeBetweenEvictionRunsMillis());
    Duration evictorShutdownTimeout = actualBuildPoolConfigResult.getEvictorShutdownTimeout();
    assertEquals(10000000000L, evictorShutdownTimeout.toNanos());
    assertEquals(10000L, actualBuildPoolConfigResult.getEvictorShutdownTimeoutMillis());
    Duration minEvictableIdleDuration = actualBuildPoolConfigResult.getMinEvictableIdleDuration();
    assertEquals(60000000000L, minEvictableIdleDuration.toNanos());
    assertEquals(60000L, actualBuildPoolConfigResult.getMinEvictableIdleTimeMillis());
    assertFalse(actualBuildPoolConfigResult.getBlockWhenExhausted());
    assertFalse(actualBuildPoolConfigResult.getFairness());
    assertFalse(actualBuildPoolConfigResult.getTestOnBorrow());
    assertFalse(actualBuildPoolConfigResult.getTestOnCreate());
    assertFalse(actualBuildPoolConfigResult.getTestOnReturn());
    assertFalse(actualBuildPoolConfigResult.getTestWhileIdle());
    assertTrue(actualBuildPoolConfigResult.getJmxEnabled());
    assertTrue(actualBuildPoolConfigResult.getLifo());
    assertSame(durationBetweenEvictionRuns, actualBuildPoolConfigResult.getMaxWaitDuration());
    assertSame(durationBetweenEvictionRuns, actualBuildPoolConfigResult.getSoftMinEvictableIdleDuration());
    assertSame(durationBetweenEvictionRuns, actualBuildPoolConfigResult.getSoftMinEvictableIdleTime());
    assertSame(durationBetweenEvictionRuns, actualBuildPoolConfigResult.getTimeBetweenEvictionRuns());
    assertSame(minEvictableIdleDuration, actualBuildPoolConfigResult.getMinEvictableIdleTime());
    Duration duration = actualBuildPoolConfigResult.DEFAULT_EVICTOR_SHUTDOWN_TIMEOUT;
    assertSame(duration, evictorShutdownTimeout);
    assertSame(duration, actualBuildPoolConfigResult.getEvictorShutdownTimeoutDuration());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#getNodes(String)}
   */
  @Test
  void testGetNodes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new TBRedisClusterConfiguration()).getNodes(null).isEmpty());
    assertTrue((new TBRedisClusterConfiguration()).getNodes("").isEmpty());
    assertTrue((new TBRedisClusterConfiguration()).getNodes(",").isEmpty());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#createSslSocketFactory()}
   */
  @Test
  void testCreateSslSocketFactory() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("TLS");
    redisSslCredentials.setUserCertFile("TLS");
    redisSslCredentials.setUserKeyFile("TLS");

    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setRedisSslCredentials(redisSslCredentials);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbRedisClusterConfiguration.createSslSocketFactory());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#createSslSocketFactory()}
   */
  @Test
  void testCreateSslSocketFactory2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Creating TLS factory failed!");
    redisSslCredentials.setUserCertFile("TLS");
    redisSslCredentials.setUserKeyFile("TLS");

    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setRedisSslCredentials(redisSslCredentials);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbRedisClusterConfiguration.createSslSocketFactory());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#createSslSocketFactory()}
   */
  @Test
  void testCreateSslSocketFactory3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("TLS");
    redisSslCredentials.setUserCertFile("");
    redisSslCredentials.setUserKeyFile("TLS");

    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setRedisSslCredentials(redisSslCredentials);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbRedisClusterConfiguration.createSslSocketFactory());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#createSslSocketFactory()}
   */
  @Test
  void testCreateSslSocketFactory4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("TLS");
    redisSslCredentials.setUserCertFile("TLS");
    redisSslCredentials.setUserKeyFile("");

    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setRedisSslCredentials(redisSslCredentials);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbRedisClusterConfiguration.createSslSocketFactory());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TBRedisClusterConfiguration()).canEqual("Other"));
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act and Assert
    assertTrue(tbRedisClusterConfiguration.canEqual(new TBRedisClusterConfiguration()));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TBRedisCacheConfiguration#equals(Object)}
   *   <li>{@link TBRedisCacheConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    TBRedisClusterConfiguration tbRedisClusterConfiguration2 = new TBRedisClusterConfiguration();

    // Act and Assert
    assertEquals(tbRedisClusterConfiguration, tbRedisClusterConfiguration2);
    int expectedHashCodeResult = tbRedisClusterConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbRedisClusterConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TBRedisCacheConfiguration#equals(Object)}
   *   <li>{@link TBRedisCacheConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act and Assert
    assertEquals(tbRedisClusterConfiguration, tbRedisClusterConfiguration);
    int expectedHashCodeResult = tbRedisClusterConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbRedisClusterConfiguration.hashCode());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TBRedisClusterConfiguration(), 1);
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setEvictTtlInMs(1);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setMaxTotal(3);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setMaxIdle(1);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setMinIdle(1);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestOnBorrow(true);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestOnReturn(true);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestWhileIdle(true);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setMinEvictableMs(1L);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setEvictionRunsMs(1L);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setMaxWaitMills(1L);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setNumberTestsPerEvictionRun(10);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setBlockWhenExhausted(true);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setSslEnabled(true);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setRedisSslCredentials(redisSslCredentials);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    TBRedisClusterConfiguration tbRedisClusterConfiguration2 = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration2.setRedisSslCredentials(redisSslCredentials);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, tbRedisClusterConfiguration2);
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TBRedisClusterConfiguration(), null);
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TBRedisClusterConfiguration(), "Different type to TBRedisCacheConfiguration");
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#getEvictTtlInMs()}
   */
  @Test
  void testGetEvictTtlInMs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new TBRedisClusterConfiguration()).getEvictTtlInMs());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#getEvictionRunsMs()}
   */
  @Test
  void testGetEvictionRunsMs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0L, (new TBRedisClusterConfiguration()).getEvictionRunsMs());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#getMaxIdle()}
   */
  @Test
  void testGetMaxIdle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new TBRedisClusterConfiguration()).getMaxIdle());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#getMaxTotal()}
   */
  @Test
  void testGetMaxTotal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new TBRedisClusterConfiguration()).getMaxTotal());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#getMaxWaitMills()}
   */
  @Test
  void testGetMaxWaitMills() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0L, (new TBRedisClusterConfiguration()).getMaxWaitMills());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#getMinEvictableMs()}
   */
  @Test
  void testGetMinEvictableMs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0L, (new TBRedisClusterConfiguration()).getMinEvictableMs());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#getMinIdle()}
   */
  @Test
  void testGetMinIdle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new TBRedisClusterConfiguration()).getMinIdle());
  }

  /**
   * Method under test:
   * {@link TBRedisCacheConfiguration#getNumberTestsPerEvictionRun()}
   */
  @Test
  void testGetNumberTestsPerEvictionRun() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new TBRedisClusterConfiguration()).getNumberTestsPerEvictionRun());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#getRedisSslCredentials()}
   */
  @Test
  void testGetRedisSslCredentials() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TBRedisClusterConfiguration()).getRedisSslCredentials());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#isBlockWhenExhausted()}
   */
  @Test
  void testIsBlockWhenExhausted() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TBRedisClusterConfiguration()).isBlockWhenExhausted());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#isBlockWhenExhausted()}
   */
  @Test
  void testIsBlockWhenExhausted2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setBlockWhenExhausted(true);

    // Act and Assert
    assertTrue(tbRedisClusterConfiguration.isBlockWhenExhausted());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#isSslEnabled()}
   */
  @Test
  void testIsSslEnabled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TBRedisClusterConfiguration()).isSslEnabled());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#isSslEnabled()}
   */
  @Test
  void testIsSslEnabled2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setSslEnabled(true);

    // Act and Assert
    assertTrue(tbRedisClusterConfiguration.isSslEnabled());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#isTestOnBorrow()}
   */
  @Test
  void testIsTestOnBorrow() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TBRedisClusterConfiguration()).isTestOnBorrow());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#isTestOnBorrow()}
   */
  @Test
  void testIsTestOnBorrow2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestOnBorrow(true);

    // Act and Assert
    assertTrue(tbRedisClusterConfiguration.isTestOnBorrow());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#isTestOnReturn()}
   */
  @Test
  void testIsTestOnReturn() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TBRedisClusterConfiguration()).isTestOnReturn());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#isTestOnReturn()}
   */
  @Test
  void testIsTestOnReturn2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestOnReturn(true);

    // Act and Assert
    assertTrue(tbRedisClusterConfiguration.isTestOnReturn());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#isTestWhileIdle()}
   */
  @Test
  void testIsTestWhileIdle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TBRedisClusterConfiguration()).isTestWhileIdle());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#isTestWhileIdle()}
   */
  @Test
  void testIsTestWhileIdle2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestWhileIdle(true);

    // Act and Assert
    assertTrue(tbRedisClusterConfiguration.isTestWhileIdle());
  }

  /**
   * Method under test:
   * {@link TBRedisCacheConfiguration#setBlockWhenExhausted(boolean)}
   */
  @Test
  void testSetBlockWhenExhausted() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setBlockWhenExhausted(true);

    // Assert
    assertTrue(tbRedisClusterConfiguration.isBlockWhenExhausted());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#setEvictTtlInMs(int)}
   */
  @Test
  void testSetEvictTtlInMs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setEvictTtlInMs(1);

    // Assert
    assertEquals(1, tbRedisClusterConfiguration.getEvictTtlInMs());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#setEvictionRunsMs(long)}
   */
  @Test
  void testSetEvictionRunsMs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setEvictionRunsMs(1L);

    // Assert
    assertEquals(1L, tbRedisClusterConfiguration.getEvictionRunsMs());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#setMaxIdle(int)}
   */
  @Test
  void testSetMaxIdle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setMaxIdle(1);

    // Assert
    assertEquals(1, tbRedisClusterConfiguration.getMaxIdle());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#setMaxTotal(int)}
   */
  @Test
  void testSetMaxTotal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setMaxTotal(3);

    // Assert
    assertEquals(3, tbRedisClusterConfiguration.getMaxTotal());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#setMaxWaitMills(long)}
   */
  @Test
  void testSetMaxWaitMills() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setMaxWaitMills(1L);

    // Assert
    assertEquals(1L, tbRedisClusterConfiguration.getMaxWaitMills());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#setMinEvictableMs(long)}
   */
  @Test
  void testSetMinEvictableMs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setMinEvictableMs(1L);

    // Assert
    assertEquals(1L, tbRedisClusterConfiguration.getMinEvictableMs());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#setMinIdle(int)}
   */
  @Test
  void testSetMinIdle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setMinIdle(1);

    // Assert
    assertEquals(1, tbRedisClusterConfiguration.getMinIdle());
  }

  /**
   * Method under test:
   * {@link TBRedisCacheConfiguration#setNumberTestsPerEvictionRun(int)}
   */
  @Test
  void testSetNumberTestsPerEvictionRun() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setNumberTestsPerEvictionRun(10);

    // Assert
    assertEquals(10, tbRedisClusterConfiguration.getNumberTestsPerEvictionRun());
  }

  /**
   * Method under test:
   * {@link TBRedisCacheConfiguration#setRedisSslCredentials(RedisSslCredentials)}
   */
  @Test
  void testSetRedisSslCredentials() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("Cert File");
    redisSslCredentials.setUserCertFile("User Cert File");
    redisSslCredentials.setUserKeyFile("User Key File");

    // Act
    tbRedisClusterConfiguration.setRedisSslCredentials(redisSslCredentials);

    // Assert
    assertSame(redisSslCredentials, tbRedisClusterConfiguration.getRedisSslCredentials());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#setSslEnabled(boolean)}
   */
  @Test
  void testSetSslEnabled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setSslEnabled(true);

    // Assert
    assertTrue(tbRedisClusterConfiguration.isSslEnabled());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#setTestOnBorrow(boolean)}
   */
  @Test
  void testSetTestOnBorrow() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setTestOnBorrow(true);

    // Assert
    assertTrue(tbRedisClusterConfiguration.isTestOnBorrow());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#setTestOnReturn(boolean)}
   */
  @Test
  void testSetTestOnReturn() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setTestOnReturn(true);

    // Assert
    assertTrue(tbRedisClusterConfiguration.isTestOnReturn());
  }

  /**
   * Method under test:
   * {@link TBRedisCacheConfiguration#setTestWhileIdle(boolean)}
   */
  @Test
  void testSetTestWhileIdle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setTestWhileIdle(true);

    // Assert
    assertTrue(tbRedisClusterConfiguration.isTestWhileIdle());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#toString()}
   */
  @Test
  void testToString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(
        "TBRedisCacheConfiguration(evictTtlInMs=0, maxTotal=0, maxIdle=0, minIdle=0, testOnBorrow=false,"
            + " testOnReturn=false, testWhileIdle=false, minEvictableMs=0, evictionRunsMs=0, maxWaitMills=0,"
            + " numberTestsPerEvictionRun=0, blockWhenExhausted=false, sslEnabled=false, redisSslCredentials=null)",
        (new TBRedisClusterConfiguration()).toString());
  }

  /**
   * Method under test: {@link TBRedisCacheConfiguration#toString()}
   */
  @Test
  void testToString2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestOnBorrow(true);

    // Act and Assert
    assertEquals(
        "TBRedisCacheConfiguration(evictTtlInMs=0, maxTotal=0, maxIdle=0, minIdle=0, testOnBorrow=true,"
            + " testOnReturn=false, testWhileIdle=false, minEvictableMs=0, evictionRunsMs=0, maxWaitMills=0,"
            + " numberTestsPerEvictionRun=0, blockWhenExhausted=false, sslEnabled=false, redisSslCredentials=null)",
        tbRedisClusterConfiguration.toString());
  }
}
