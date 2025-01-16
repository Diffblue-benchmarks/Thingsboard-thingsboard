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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.cache.CacheManager;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

class TBRedisCacheConfigurationDiffblueTest {
  /**
   * Test {@link TBRedisCacheConfiguration#cacheManager(RedisConnectionFactory)}.
   * <ul>
   *   <li>Given {@link AsyncTaskExecutor}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TBRedisCacheConfiguration#cacheManager(RedisConnectionFactory)}
   */
  @Test
  @DisplayName("Test cacheManager(RedisConnectionFactory); given AsyncTaskExecutor")
  void testCacheManager_givenAsyncTaskExecutor() {
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
   * Test {@link TBRedisCacheConfiguration#cacheManager(RedisConnectionFactory)}.
   * <ul>
   *   <li>When {@link JedisConnectionFactory#JedisConnectionFactory()}.</li>
   *   <li>Then CacheNames return {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TBRedisCacheConfiguration#cacheManager(RedisConnectionFactory)}
   */
  @Test
  @DisplayName("Test cacheManager(RedisConnectionFactory); when JedisConnectionFactory(); then CacheNames return Set")
  void testCacheManager_whenJedisConnectionFactory_thenCacheNamesReturnSet() {
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
   * Test {@link TBRedisCacheConfiguration#buildPoolConfig()}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#buildPoolConfig()}
   */
  @Test
  @DisplayName("Test buildPoolConfig()")
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
   * Test {@link TBRedisCacheConfiguration#getNodes(String)}.
   * <ul>
   *   <li>When {@code ,}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#getNodes(String)}
   */
  @Test
  @DisplayName("Test getNodes(String); when ','; then return Empty")
  void testGetNodes_whenComma_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new TBRedisClusterConfiguration()).getNodes(",").isEmpty());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getNodes(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#getNodes(String)}
   */
  @Test
  @DisplayName("Test getNodes(String); when empty string; then return Empty")
  void testGetNodes_whenEmptyString_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new TBRedisClusterConfiguration()).getNodes("").isEmpty());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getNodes(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#getNodes(String)}
   */
  @Test
  @DisplayName("Test getNodes(String); when 'null'; then return Empty")
  void testGetNodes_whenNull_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new TBRedisClusterConfiguration()).getNodes(null).isEmpty());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#createSslSocketFactory()}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#createSslSocketFactory()}
   */
  @Test
  @DisplayName("Test createSslSocketFactory()")
  void testCreateSslSocketFactory() {
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
   * Test {@link TBRedisCacheConfiguration#createSslSocketFactory()}.
   * <ul>
   *   <li>Given {@link RedisSslCredentials} (default constructor) CertFile is
   * {@code TLS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#createSslSocketFactory()}
   */
  @Test
  @DisplayName("Test createSslSocketFactory(); given RedisSslCredentials (default constructor) CertFile is 'TLS'")
  void testCreateSslSocketFactory_givenRedisSslCredentialsCertFileIsTls() {
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
   * Test {@link TBRedisCacheConfiguration#createSslSocketFactory()}.
   * <ul>
   *   <li>Given {@link RedisSslCredentials} (default constructor) UserCertFile is
   * empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#createSslSocketFactory()}
   */
  @Test
  @DisplayName("Test createSslSocketFactory(); given RedisSslCredentials (default constructor) UserCertFile is empty string")
  void testCreateSslSocketFactory_givenRedisSslCredentialsUserCertFileIsEmptyString() {
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
   * Test {@link TBRedisCacheConfiguration#createSslSocketFactory()}.
   * <ul>
   *   <li>Given {@link RedisSslCredentials} (default constructor) UserKeyFile is
   * empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#createSslSocketFactory()}
   */
  @Test
  @DisplayName("Test createSslSocketFactory(); given RedisSslCredentials (default constructor) UserKeyFile is empty string")
  void testCreateSslSocketFactory_givenRedisSslCredentialsUserKeyFileIsEmptyString() {
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
   * Test {@link TBRedisCacheConfiguration#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  void testCanEqual_whenOther_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TBRedisClusterConfiguration()).canEqual("Other"));
  }

  /**
   * Test {@link TBRedisCacheConfiguration#canEqual(Object)}.
   * <ul>
   *   <li>When {@link TBRedisClusterConfiguration} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when TBRedisClusterConfiguration (default constructor); then return 'true'")
  void testCanEqual_whenTBRedisClusterConfiguration_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act and Assert
    assertTrue(tbRedisClusterConfiguration.canEqual(new TBRedisClusterConfiguration()));
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}, and
   * {@link TBRedisCacheConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TBRedisCacheConfiguration#equals(Object)}
   *   <li>{@link TBRedisCacheConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link TBRedisCacheConfiguration#equals(Object)}, and
   * {@link TBRedisCacheConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TBRedisCacheConfiguration#equals(Object)}
   *   <li>{@link TBRedisCacheConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act and Assert
    assertEquals(tbRedisClusterConfiguration, tbRedisClusterConfiguration);
    int expectedHashCodeResult = tbRedisClusterConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbRedisClusterConfiguration.hashCode());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TBRedisClusterConfiguration(), 1);
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setEvictTtlInMs(1);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setMaxTotal(3);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setMaxIdle(1);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setMinIdle(1);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestOnBorrow(true);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestOnReturn(true);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestWhileIdle(true);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setMinEvictableMs(1L);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setEvictionRunsMs(1L);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setMaxWaitMills(1L);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setNumberTestsPerEvictionRun(10);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setBlockWhenExhausted(true);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setSslEnabled(true);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TBRedisClusterConfiguration(), null);
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TBRedisClusterConfiguration(), "Different type to TBRedisCacheConfiguration");
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getEvictTtlInMs()}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#getEvictTtlInMs()}
   */
  @Test
  @DisplayName("Test getEvictTtlInMs()")
  void testGetEvictTtlInMs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new TBRedisClusterConfiguration()).getEvictTtlInMs());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getEvictionRunsMs()}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#getEvictionRunsMs()}
   */
  @Test
  @DisplayName("Test getEvictionRunsMs()")
  void testGetEvictionRunsMs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0L, (new TBRedisClusterConfiguration()).getEvictionRunsMs());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getMaxIdle()}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#getMaxIdle()}
   */
  @Test
  @DisplayName("Test getMaxIdle()")
  void testGetMaxIdle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new TBRedisClusterConfiguration()).getMaxIdle());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getMaxTotal()}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#getMaxTotal()}
   */
  @Test
  @DisplayName("Test getMaxTotal()")
  void testGetMaxTotal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new TBRedisClusterConfiguration()).getMaxTotal());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getMaxWaitMills()}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#getMaxWaitMills()}
   */
  @Test
  @DisplayName("Test getMaxWaitMills()")
  void testGetMaxWaitMills() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0L, (new TBRedisClusterConfiguration()).getMaxWaitMills());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getMinEvictableMs()}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#getMinEvictableMs()}
   */
  @Test
  @DisplayName("Test getMinEvictableMs()")
  void testGetMinEvictableMs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0L, (new TBRedisClusterConfiguration()).getMinEvictableMs());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getMinIdle()}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#getMinIdle()}
   */
  @Test
  @DisplayName("Test getMinIdle()")
  void testGetMinIdle() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new TBRedisClusterConfiguration()).getMinIdle());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getNumberTestsPerEvictionRun()}.
   * <p>
   * Method under test:
   * {@link TBRedisCacheConfiguration#getNumberTestsPerEvictionRun()}
   */
  @Test
  @DisplayName("Test getNumberTestsPerEvictionRun()")
  void testGetNumberTestsPerEvictionRun() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(0, (new TBRedisClusterConfiguration()).getNumberTestsPerEvictionRun());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getRedisSslCredentials()}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#getRedisSslCredentials()}
   */
  @Test
  @DisplayName("Test getRedisSslCredentials()")
  void testGetRedisSslCredentials() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new TBRedisClusterConfiguration()).getRedisSslCredentials());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isBlockWhenExhausted()}.
   * <ul>
   *   <li>Given {@link TBRedisClusterConfiguration} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#isBlockWhenExhausted()}
   */
  @Test
  @DisplayName("Test isBlockWhenExhausted(); given TBRedisClusterConfiguration (default constructor); then return 'false'")
  void testIsBlockWhenExhausted_givenTBRedisClusterConfiguration_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TBRedisClusterConfiguration()).isBlockWhenExhausted());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isBlockWhenExhausted()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#isBlockWhenExhausted()}
   */
  @Test
  @DisplayName("Test isBlockWhenExhausted(); then return 'true'")
  void testIsBlockWhenExhausted_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setBlockWhenExhausted(true);

    // Act and Assert
    assertTrue(tbRedisClusterConfiguration.isBlockWhenExhausted());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isSslEnabled()}.
   * <ul>
   *   <li>Given {@link TBRedisClusterConfiguration} (default constructor)
   * SslEnabled is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#isSslEnabled()}
   */
  @Test
  @DisplayName("Test isSslEnabled(); given TBRedisClusterConfiguration (default constructor) SslEnabled is 'true'; then return 'true'")
  void testIsSslEnabled_givenTBRedisClusterConfigurationSslEnabledIsTrue_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setSslEnabled(true);

    // Act and Assert
    assertTrue(tbRedisClusterConfiguration.isSslEnabled());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isSslEnabled()}.
   * <ul>
   *   <li>Given {@link TBRedisClusterConfiguration} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#isSslEnabled()}
   */
  @Test
  @DisplayName("Test isSslEnabled(); given TBRedisClusterConfiguration (default constructor); then return 'false'")
  void testIsSslEnabled_givenTBRedisClusterConfiguration_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TBRedisClusterConfiguration()).isSslEnabled());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isTestOnBorrow()}.
   * <ul>
   *   <li>Given {@link TBRedisClusterConfiguration} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#isTestOnBorrow()}
   */
  @Test
  @DisplayName("Test isTestOnBorrow(); given TBRedisClusterConfiguration (default constructor); then return 'false'")
  void testIsTestOnBorrow_givenTBRedisClusterConfiguration_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TBRedisClusterConfiguration()).isTestOnBorrow());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isTestOnBorrow()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#isTestOnBorrow()}
   */
  @Test
  @DisplayName("Test isTestOnBorrow(); then return 'true'")
  void testIsTestOnBorrow_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestOnBorrow(true);

    // Act and Assert
    assertTrue(tbRedisClusterConfiguration.isTestOnBorrow());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isTestOnReturn()}.
   * <ul>
   *   <li>Given {@link TBRedisClusterConfiguration} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#isTestOnReturn()}
   */
  @Test
  @DisplayName("Test isTestOnReturn(); given TBRedisClusterConfiguration (default constructor); then return 'false'")
  void testIsTestOnReturn_givenTBRedisClusterConfiguration_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TBRedisClusterConfiguration()).isTestOnReturn());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isTestOnReturn()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#isTestOnReturn()}
   */
  @Test
  @DisplayName("Test isTestOnReturn(); then return 'true'")
  void testIsTestOnReturn_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestOnReturn(true);

    // Act and Assert
    assertTrue(tbRedisClusterConfiguration.isTestOnReturn());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isTestWhileIdle()}.
   * <ul>
   *   <li>Given {@link TBRedisClusterConfiguration} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#isTestWhileIdle()}
   */
  @Test
  @DisplayName("Test isTestWhileIdle(); given TBRedisClusterConfiguration (default constructor); then return 'false'")
  void testIsTestWhileIdle_givenTBRedisClusterConfiguration_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new TBRedisClusterConfiguration()).isTestWhileIdle());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isTestWhileIdle()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#isTestWhileIdle()}
   */
  @Test
  @DisplayName("Test isTestWhileIdle(); then return 'true'")
  void testIsTestWhileIdle_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestWhileIdle(true);

    // Act and Assert
    assertTrue(tbRedisClusterConfiguration.isTestWhileIdle());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#setBlockWhenExhausted(boolean)}.
   * <p>
   * Method under test:
   * {@link TBRedisCacheConfiguration#setBlockWhenExhausted(boolean)}
   */
  @Test
  @DisplayName("Test setBlockWhenExhausted(boolean)")
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
   * Test {@link TBRedisCacheConfiguration#setEvictTtlInMs(int)}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#setEvictTtlInMs(int)}
   */
  @Test
  @DisplayName("Test setEvictTtlInMs(int)")
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
   * Test {@link TBRedisCacheConfiguration#setEvictionRunsMs(long)}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#setEvictionRunsMs(long)}
   */
  @Test
  @DisplayName("Test setEvictionRunsMs(long)")
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
   * Test {@link TBRedisCacheConfiguration#setMaxIdle(int)}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#setMaxIdle(int)}
   */
  @Test
  @DisplayName("Test setMaxIdle(int)")
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
   * Test {@link TBRedisCacheConfiguration#setMaxTotal(int)}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#setMaxTotal(int)}
   */
  @Test
  @DisplayName("Test setMaxTotal(int)")
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
   * Test {@link TBRedisCacheConfiguration#setMaxWaitMills(long)}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#setMaxWaitMills(long)}
   */
  @Test
  @DisplayName("Test setMaxWaitMills(long)")
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
   * Test {@link TBRedisCacheConfiguration#setMinEvictableMs(long)}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#setMinEvictableMs(long)}
   */
  @Test
  @DisplayName("Test setMinEvictableMs(long)")
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
   * Test {@link TBRedisCacheConfiguration#setMinIdle(int)}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#setMinIdle(int)}
   */
  @Test
  @DisplayName("Test setMinIdle(int)")
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
   * Test {@link TBRedisCacheConfiguration#setNumberTestsPerEvictionRun(int)}.
   * <p>
   * Method under test:
   * {@link TBRedisCacheConfiguration#setNumberTestsPerEvictionRun(int)}
   */
  @Test
  @DisplayName("Test setNumberTestsPerEvictionRun(int)")
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
   * Test
   * {@link TBRedisCacheConfiguration#setRedisSslCredentials(RedisSslCredentials)}.
   * <p>
   * Method under test:
   * {@link TBRedisCacheConfiguration#setRedisSslCredentials(RedisSslCredentials)}
   */
  @Test
  @DisplayName("Test setRedisSslCredentials(RedisSslCredentials)")
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
   * Test {@link TBRedisCacheConfiguration#setSslEnabled(boolean)}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#setSslEnabled(boolean)}
   */
  @Test
  @DisplayName("Test setSslEnabled(boolean)")
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
   * Test {@link TBRedisCacheConfiguration#setTestOnBorrow(boolean)}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#setTestOnBorrow(boolean)}
   */
  @Test
  @DisplayName("Test setTestOnBorrow(boolean)")
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
   * Test {@link TBRedisCacheConfiguration#setTestOnReturn(boolean)}.
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#setTestOnReturn(boolean)}
   */
  @Test
  @DisplayName("Test setTestOnReturn(boolean)")
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
   * Test {@link TBRedisCacheConfiguration#setTestWhileIdle(boolean)}.
   * <p>
   * Method under test:
   * {@link TBRedisCacheConfiguration#setTestWhileIdle(boolean)}
   */
  @Test
  @DisplayName("Test setTestWhileIdle(boolean)")
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
   * Test {@link TBRedisCacheConfiguration#toString()}.
   * <ul>
   *   <li>Given {@link TBRedisClusterConfiguration} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#toString()}
   */
  @Test
  @DisplayName("Test toString(); given TBRedisClusterConfiguration (default constructor)")
  void testToString_givenTBRedisClusterConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(
        "TBRedisCacheConfiguration(evictTtlInMs=0, maxTotal=0, maxIdle=0, minIdle=0, testOnBorrow=false,"
            + " testOnReturn=false, testWhileIdle=false, minEvictableMs=0, evictionRunsMs=0, maxWaitMills=0,"
            + " numberTestsPerEvictionRun=0, blockWhenExhausted=false, sslEnabled=false, redisSslCredentials=null)",
        (new TBRedisClusterConfiguration()).toString());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#toString()}.
   * <ul>
   *   <li>Given {@link TBRedisClusterConfiguration} (default constructor)
   * TestOnBorrow is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TBRedisCacheConfiguration#toString()}
   */
  @Test
  @DisplayName("Test toString(); given TBRedisClusterConfiguration (default constructor) TestOnBorrow is 'true'")
  void testToString_givenTBRedisClusterConfigurationTestOnBorrowIsTrue() {
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
