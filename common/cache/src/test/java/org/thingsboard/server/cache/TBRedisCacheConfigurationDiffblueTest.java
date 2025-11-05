package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.Duration;
import java.util.Collection;
import java.util.Set;
import org.apache.commons.pool2.impl.BaseObjectPoolConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import redis.clients.jedis.JedisPoolConfig;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class TBRedisCacheConfigurationDiffblueTest {
  @Mock private RedisSslCredentials redisSslCredentials;

  /**
   * Test {@link TBRedisCacheConfiguration#cacheManager(RedisConnectionFactory)}.
   *
   * <ul>
   *   <li>When {@link JedisConnectionFactory#JedisConnectionFactory()}.
   *   <li>Then CacheNames return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#cacheManager(RedisConnectionFactory)}
   */
  @Test
  @DisplayName(
      "Test cacheManager(RedisConnectionFactory); when JedisConnectionFactory(); then CacheNames return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CacheManager TBRedisCacheConfiguration.cacheManager(RedisConnectionFactory)"})
  void testCacheManager_whenJedisConnectionFactory_thenCacheNamesReturnSet() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    CacheManager actualCacheManagerResult =
        tbRedisClusterConfiguration.cacheManager(new JedisConnectionFactory());

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
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#buildPoolConfig()}
   */
  @Test
  @DisplayName("Test buildPoolConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JedisPoolConfig TBRedisCacheConfiguration.buildPoolConfig()"})
  void testBuildPoolConfig() {
    // Arrange and Act
    JedisPoolConfig actualBuildPoolConfigResult =
        new TBRedisClusterConfiguration().buildPoolConfig();

    // Assert
    assertEquals(
        "org.apache.commons.pool2.impl.DefaultEvictionPolicy",
        actualBuildPoolConfigResult.getEvictionPolicyClassName());
    assertEquals("pool", actualBuildPoolConfigResult.getJmxNamePrefix());
    assertNull(actualBuildPoolConfigResult.getJmxNameBase());
    assertNull(actualBuildPoolConfigResult.getEvictionPolicy());
    assertEquals(0, actualBuildPoolConfigResult.getNumTestsPerEvictionRun());
    assertEquals(0, actualBuildPoolConfigResult.getMaxIdle());
    assertEquals(0, actualBuildPoolConfigResult.getMaxTotal());
    assertEquals(0, actualBuildPoolConfigResult.getMinIdle());
    assertEquals(0L, actualBuildPoolConfigResult.getMaxWaitMillis());
    assertEquals(0L, actualBuildPoolConfigResult.getSoftMinEvictableIdleTimeMillis());
    assertEquals(0L, actualBuildPoolConfigResult.getTimeBetweenEvictionRunsMillis());
    assertEquals(10000L, actualBuildPoolConfigResult.getEvictorShutdownTimeoutMillis());
    assertEquals(60000L, actualBuildPoolConfigResult.getMinEvictableIdleTimeMillis());
    assertFalse(actualBuildPoolConfigResult.getBlockWhenExhausted());
    assertFalse(actualBuildPoolConfigResult.getFairness());
    assertFalse(actualBuildPoolConfigResult.getTestOnBorrow());
    assertFalse(actualBuildPoolConfigResult.getTestOnCreate());
    assertFalse(actualBuildPoolConfigResult.getTestOnReturn());
    assertFalse(actualBuildPoolConfigResult.getTestWhileIdle());
    assertTrue(actualBuildPoolConfigResult.getJmxEnabled());
    assertTrue(actualBuildPoolConfigResult.getLifo());
    Duration duration = BaseObjectPoolConfig.DEFAULT_EVICTOR_SHUTDOWN_TIMEOUT;
    assertSame(duration, actualBuildPoolConfigResult.getEvictorShutdownTimeout());
    assertSame(duration, actualBuildPoolConfigResult.getEvictorShutdownTimeoutDuration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getNodes(String)}.
   *
   * <ul>
   *   <li>When {@code ,}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#getNodes(String)}
   */
  @Test
  @DisplayName("Test getNodes(String); when ','; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List TBRedisCacheConfiguration.getNodes(String)"})
  void testGetNodes_whenComma_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new TBRedisClusterConfiguration().getNodes(",").isEmpty());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getNodes(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#getNodes(String)}
   */
  @Test
  @DisplayName("Test getNodes(String); when empty string; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List TBRedisCacheConfiguration.getNodes(String)"})
  void testGetNodes_whenEmptyString_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new TBRedisClusterConfiguration().getNodes("").isEmpty());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getNodes(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#getNodes(String)}
   */
  @Test
  @DisplayName("Test getNodes(String); when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List TBRedisCacheConfiguration.getNodes(String)"})
  void testGetNodes_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new TBRedisClusterConfiguration().getNodes(null).isEmpty());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getNodes(String)}.
   *
   * <ul>
   *   <li>When space.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#getNodes(String)}
   */
  @Test
  @DisplayName("Test getNodes(String); when space; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List TBRedisCacheConfiguration.getNodes(String)"})
  void testGetNodes_whenSpace_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new TBRedisClusterConfiguration().getNodes(" ").isEmpty());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#createSslSocketFactory()}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#createSslSocketFactory()}
   */
  @Test
  @DisplayName("Test createSslSocketFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "javax.net.ssl.SSLSocketFactory TBRedisCacheConfiguration.createSslSocketFactory()"
  })
  void testCreateSslSocketFactory() {
    // Arrange
    when(redisSslCredentials.getUserKeyFile()).thenThrow(new RuntimeException());
    when(redisSslCredentials.getUserCertFile()).thenReturn("User Cert File");
    doNothing().when(redisSslCredentials).setUserCertFile(Mockito.<String>any());
    doNothing().when(redisSslCredentials).setUserKeyFile(Mockito.<String>any());
    redisSslCredentials.setUserCertFile(" ");
    redisSslCredentials.setUserKeyFile(" ");

    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setRedisSslCredentials(redisSslCredentials);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbRedisClusterConfiguration.createSslSocketFactory());
    verify(redisSslCredentials).getUserCertFile();
    verify(redisSslCredentials).getUserKeyFile();
    verify(redisSslCredentials).setUserCertFile(" ");
    verify(redisSslCredentials).setUserKeyFile(" ");
  }

  /**
   * Test {@link TBRedisCacheConfiguration#createSslSocketFactory()}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#createSslSocketFactory()}
   */
  @Test
  @DisplayName("Test createSslSocketFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "javax.net.ssl.SSLSocketFactory TBRedisCacheConfiguration.createSslSocketFactory()"
  })
  void testCreateSslSocketFactory2() {
    // Arrange
    when(redisSslCredentials.getCertFile()).thenThrow(new RuntimeException());
    when(redisSslCredentials.getUserKeyFile()).thenReturn("User Key File");
    when(redisSslCredentials.getUserCertFile()).thenReturn("User Cert File");
    doNothing().when(redisSslCredentials).setUserCertFile(Mockito.<String>any());
    doNothing().when(redisSslCredentials).setUserKeyFile(Mockito.<String>any());
    redisSslCredentials.setUserCertFile(" ");
    redisSslCredentials.setUserKeyFile(" ");

    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setRedisSslCredentials(redisSslCredentials);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbRedisClusterConfiguration.createSslSocketFactory());
    verify(redisSslCredentials).getCertFile();
    verify(redisSslCredentials).getUserCertFile();
    verify(redisSslCredentials).getUserKeyFile();
    verify(redisSslCredentials).setUserCertFile(" ");
    verify(redisSslCredentials).setUserKeyFile(" ");
  }

  /**
   * Test {@link TBRedisCacheConfiguration#createSslSocketFactory()}.
   *
   * <ul>
   *   <li>Given {@link RedisSslCredentials} {@link RedisSslCredentials#getCertFile()} return {@code
   *       Cert File}.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#createSslSocketFactory()}
   */
  @Test
  @DisplayName(
      "Test createSslSocketFactory(); given RedisSslCredentials getCertFile() return 'Cert File'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "javax.net.ssl.SSLSocketFactory TBRedisCacheConfiguration.createSslSocketFactory()"
  })
  void testCreateSslSocketFactory_givenRedisSslCredentialsGetCertFileReturnCertFile() {
    // Arrange
    when(redisSslCredentials.getCertFile()).thenReturn("Cert File");
    when(redisSslCredentials.getUserKeyFile()).thenReturn("User Key File");
    when(redisSslCredentials.getUserCertFile()).thenReturn("User Cert File");
    doNothing().when(redisSslCredentials).setUserCertFile(Mockito.<String>any());
    doNothing().when(redisSslCredentials).setUserKeyFile(Mockito.<String>any());
    redisSslCredentials.setUserCertFile(" ");
    redisSslCredentials.setUserKeyFile(" ");

    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setRedisSslCredentials(redisSslCredentials);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbRedisClusterConfiguration.createSslSocketFactory());
    verify(redisSslCredentials).getCertFile();
    verify(redisSslCredentials).getUserCertFile();
    verify(redisSslCredentials).getUserKeyFile();
    verify(redisSslCredentials).setUserCertFile(" ");
    verify(redisSslCredentials).setUserKeyFile(" ");
  }

  /**
   * Test {@link TBRedisCacheConfiguration#createSslSocketFactory()}.
   *
   * <ul>
   *   <li>Given {@link RedisSslCredentials} {@link RedisSslCredentials#getUserKeyFile()} return
   *       space.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#createSslSocketFactory()}
   */
  @Test
  @DisplayName(
      "Test createSslSocketFactory(); given RedisSslCredentials getUserKeyFile() return space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "javax.net.ssl.SSLSocketFactory TBRedisCacheConfiguration.createSslSocketFactory()"
  })
  void testCreateSslSocketFactory_givenRedisSslCredentialsGetUserKeyFileReturnSpace() {
    // Arrange
    when(redisSslCredentials.getCertFile()).thenReturn("Cert File");
    when(redisSslCredentials.getUserKeyFile()).thenReturn(" ");
    when(redisSslCredentials.getUserCertFile()).thenReturn("User Cert File");
    doNothing().when(redisSslCredentials).setUserCertFile(Mockito.<String>any());
    doNothing().when(redisSslCredentials).setUserKeyFile(Mockito.<String>any());
    redisSslCredentials.setUserCertFile(" ");
    redisSslCredentials.setUserKeyFile(" ");

    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setRedisSslCredentials(redisSslCredentials);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbRedisClusterConfiguration.createSslSocketFactory());
    verify(redisSslCredentials).getCertFile();
    verify(redisSslCredentials).getUserCertFile();
    verify(redisSslCredentials).getUserKeyFile();
    verify(redisSslCredentials).setUserCertFile(" ");
    verify(redisSslCredentials).setUserKeyFile(" ");
  }

  /**
   * Test {@link TBRedisCacheConfiguration#createSslSocketFactory()}.
   *
   * <ul>
   *   <li>Given {@link RedisSslCredentials} (default constructor) UserKeyFile is {@code TLS}.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#createSslSocketFactory()}
   */
  @Test
  @DisplayName(
      "Test createSslSocketFactory(); given RedisSslCredentials (default constructor) UserKeyFile is 'TLS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "javax.net.ssl.SSLSocketFactory TBRedisCacheConfiguration.createSslSocketFactory()"
  })
  void testCreateSslSocketFactory_givenRedisSslCredentialsUserKeyFileIsTls() {
    // Arrange
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();
    redisSslCredentials.setCertFile("42");
    redisSslCredentials.setUserKeyFile("TLS");
    redisSslCredentials.setUserCertFile("User Cert File");

    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setRedisSslCredentials(redisSslCredentials);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbRedisClusterConfiguration.createSslSocketFactory());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TBRedisCacheConfiguration.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TBRedisClusterConfiguration().canEqual("Other"));
  }

  /**
   * Test {@link TBRedisCacheConfiguration#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link TBRedisClusterConfiguration} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName(
      "Test canEqual(Object); when TBRedisClusterConfiguration (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TBRedisCacheConfiguration.canEqual(Object)"})
  void testCanEqual_whenTBRedisClusterConfiguration_thenReturnTrue() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act and Assert
    assertTrue(tbRedisClusterConfiguration.canEqual(new TBRedisClusterConfiguration()));
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}, and {@link
   * TBRedisCacheConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TBRedisCacheConfiguration#equals(Object)}
   *   <li>{@link TBRedisCacheConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    TBRedisClusterConfiguration tbRedisClusterConfiguration2 = new TBRedisClusterConfiguration();

    // Act and Assert
    assertEquals(tbRedisClusterConfiguration, tbRedisClusterConfiguration2);
    assertEquals(tbRedisClusterConfiguration.hashCode(), tbRedisClusterConfiguration2.hashCode());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}, and {@link
   * TBRedisCacheConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TBRedisCacheConfiguration#equals(Object)}
   *   <li>{@link TBRedisCacheConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TBRedisClusterConfiguration(), 1);
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setEvictTtlInMs(1);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setMaxTotal(3);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setMaxIdle(1);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setMinIdle(1);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestOnBorrow(true);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestOnReturn(true);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestWhileIdle(true);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setMinEvictableMs(1L);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setEvictionRunsMs(1L);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setMaxWaitMills(1L);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setNumberTestsPerEvictionRun(10);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setBlockWhenExhausted(true);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setSslEnabled(true);

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setRedisSslCredentials(new RedisSslCredentials());

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, new TBRedisClusterConfiguration());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    TBRedisClusterConfiguration tbRedisClusterConfiguration2 = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration2.setRedisSslCredentials(new RedisSslCredentials());

    // Act and Assert
    assertNotEquals(tbRedisClusterConfiguration, tbRedisClusterConfiguration2);
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TBRedisClusterConfiguration(), null);
  }

  /**
   * Test {@link TBRedisCacheConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TBRedisCacheConfiguration.equals(Object)",
    "int TBRedisCacheConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TBRedisClusterConfiguration(), "Different type to TBRedisCacheConfiguration");
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getEvictTtlInMs()}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#getEvictTtlInMs()}
   */
  @Test
  @DisplayName("Test getEvictTtlInMs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TBRedisCacheConfiguration.getEvictTtlInMs()"})
  void testGetEvictTtlInMs() {
    // Arrange, Act and Assert
    assertEquals(0, new TBRedisClusterConfiguration().getEvictTtlInMs());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getEvictionRunsMs()}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#getEvictionRunsMs()}
   */
  @Test
  @DisplayName("Test getEvictionRunsMs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TBRedisCacheConfiguration.getEvictionRunsMs()"})
  void testGetEvictionRunsMs() {
    // Arrange, Act and Assert
    assertEquals(0L, new TBRedisClusterConfiguration().getEvictionRunsMs());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getMaxIdle()}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#getMaxIdle()}
   */
  @Test
  @DisplayName("Test getMaxIdle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TBRedisCacheConfiguration.getMaxIdle()"})
  void testGetMaxIdle() {
    // Arrange, Act and Assert
    assertEquals(0, new TBRedisClusterConfiguration().getMaxIdle());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getMaxTotal()}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#getMaxTotal()}
   */
  @Test
  @DisplayName("Test getMaxTotal()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TBRedisCacheConfiguration.getMaxTotal()"})
  void testGetMaxTotal() {
    // Arrange, Act and Assert
    assertEquals(0, new TBRedisClusterConfiguration().getMaxTotal());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getMaxWaitMills()}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#getMaxWaitMills()}
   */
  @Test
  @DisplayName("Test getMaxWaitMills()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TBRedisCacheConfiguration.getMaxWaitMills()"})
  void testGetMaxWaitMills() {
    // Arrange, Act and Assert
    assertEquals(0L, new TBRedisClusterConfiguration().getMaxWaitMills());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getMinEvictableMs()}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#getMinEvictableMs()}
   */
  @Test
  @DisplayName("Test getMinEvictableMs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TBRedisCacheConfiguration.getMinEvictableMs()"})
  void testGetMinEvictableMs() {
    // Arrange, Act and Assert
    assertEquals(0L, new TBRedisClusterConfiguration().getMinEvictableMs());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getMinIdle()}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#getMinIdle()}
   */
  @Test
  @DisplayName("Test getMinIdle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TBRedisCacheConfiguration.getMinIdle()"})
  void testGetMinIdle() {
    // Arrange, Act and Assert
    assertEquals(0, new TBRedisClusterConfiguration().getMinIdle());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getNumberTestsPerEvictionRun()}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#getNumberTestsPerEvictionRun()}
   */
  @Test
  @DisplayName("Test getNumberTestsPerEvictionRun()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TBRedisCacheConfiguration.getNumberTestsPerEvictionRun()"})
  void testGetNumberTestsPerEvictionRun() {
    // Arrange, Act and Assert
    assertEquals(0, new TBRedisClusterConfiguration().getNumberTestsPerEvictionRun());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#getRedisSslCredentials()}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#getRedisSslCredentials()}
   */
  @Test
  @DisplayName("Test getRedisSslCredentials()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RedisSslCredentials TBRedisCacheConfiguration.getRedisSslCredentials()"})
  void testGetRedisSslCredentials() {
    // Arrange, Act and Assert
    assertNull(new TBRedisClusterConfiguration().getRedisSslCredentials());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isBlockWhenExhausted()}.
   *
   * <ul>
   *   <li>Given {@link TBRedisClusterConfiguration} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#isBlockWhenExhausted()}
   */
  @Test
  @DisplayName(
      "Test isBlockWhenExhausted(); given TBRedisClusterConfiguration (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TBRedisCacheConfiguration.isBlockWhenExhausted()"})
  void testIsBlockWhenExhausted_givenTBRedisClusterConfiguration_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TBRedisClusterConfiguration().isBlockWhenExhausted());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isBlockWhenExhausted()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#isBlockWhenExhausted()}
   */
  @Test
  @DisplayName("Test isBlockWhenExhausted(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TBRedisCacheConfiguration.isBlockWhenExhausted()"})
  void testIsBlockWhenExhausted_thenReturnTrue() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setBlockWhenExhausted(true);

    // Act and Assert
    assertTrue(tbRedisClusterConfiguration.isBlockWhenExhausted());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isSslEnabled()}.
   *
   * <ul>
   *   <li>Given {@link TBRedisClusterConfiguration} (default constructor) SslEnabled is {@code
   *       true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#isSslEnabled()}
   */
  @Test
  @DisplayName(
      "Test isSslEnabled(); given TBRedisClusterConfiguration (default constructor) SslEnabled is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TBRedisCacheConfiguration.isSslEnabled()"})
  void testIsSslEnabled_givenTBRedisClusterConfigurationSslEnabledIsTrue_thenReturnTrue() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setSslEnabled(true);

    // Act and Assert
    assertTrue(tbRedisClusterConfiguration.isSslEnabled());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isSslEnabled()}.
   *
   * <ul>
   *   <li>Given {@link TBRedisClusterConfiguration} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#isSslEnabled()}
   */
  @Test
  @DisplayName(
      "Test isSslEnabled(); given TBRedisClusterConfiguration (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TBRedisCacheConfiguration.isSslEnabled()"})
  void testIsSslEnabled_givenTBRedisClusterConfiguration_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TBRedisClusterConfiguration().isSslEnabled());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isTestOnBorrow()}.
   *
   * <ul>
   *   <li>Given {@link TBRedisClusterConfiguration} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#isTestOnBorrow()}
   */
  @Test
  @DisplayName(
      "Test isTestOnBorrow(); given TBRedisClusterConfiguration (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TBRedisCacheConfiguration.isTestOnBorrow()"})
  void testIsTestOnBorrow_givenTBRedisClusterConfiguration_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TBRedisClusterConfiguration().isTestOnBorrow());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isTestOnBorrow()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#isTestOnBorrow()}
   */
  @Test
  @DisplayName("Test isTestOnBorrow(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TBRedisCacheConfiguration.isTestOnBorrow()"})
  void testIsTestOnBorrow_thenReturnTrue() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestOnBorrow(true);

    // Act and Assert
    assertTrue(tbRedisClusterConfiguration.isTestOnBorrow());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isTestOnReturn()}.
   *
   * <ul>
   *   <li>Given {@link TBRedisClusterConfiguration} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#isTestOnReturn()}
   */
  @Test
  @DisplayName(
      "Test isTestOnReturn(); given TBRedisClusterConfiguration (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TBRedisCacheConfiguration.isTestOnReturn()"})
  void testIsTestOnReturn_givenTBRedisClusterConfiguration_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TBRedisClusterConfiguration().isTestOnReturn());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isTestOnReturn()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#isTestOnReturn()}
   */
  @Test
  @DisplayName("Test isTestOnReturn(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TBRedisCacheConfiguration.isTestOnReturn()"})
  void testIsTestOnReturn_thenReturnTrue() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestOnReturn(true);

    // Act and Assert
    assertTrue(tbRedisClusterConfiguration.isTestOnReturn());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isTestWhileIdle()}.
   *
   * <ul>
   *   <li>Given {@link TBRedisClusterConfiguration} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#isTestWhileIdle()}
   */
  @Test
  @DisplayName(
      "Test isTestWhileIdle(); given TBRedisClusterConfiguration (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TBRedisCacheConfiguration.isTestWhileIdle()"})
  void testIsTestWhileIdle_givenTBRedisClusterConfiguration_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TBRedisClusterConfiguration().isTestWhileIdle());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#isTestWhileIdle()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#isTestWhileIdle()}
   */
  @Test
  @DisplayName("Test isTestWhileIdle(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TBRedisCacheConfiguration.isTestWhileIdle()"})
  void testIsTestWhileIdle_thenReturnTrue() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    tbRedisClusterConfiguration.setTestWhileIdle(true);

    // Act and Assert
    assertTrue(tbRedisClusterConfiguration.isTestWhileIdle());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#setBlockWhenExhausted(boolean)}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#setBlockWhenExhausted(boolean)}
   */
  @Test
  @DisplayName("Test setBlockWhenExhausted(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TBRedisCacheConfiguration.setBlockWhenExhausted(boolean)"})
  void testSetBlockWhenExhausted() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setBlockWhenExhausted(true);

    // Assert
    assertTrue(tbRedisClusterConfiguration.isBlockWhenExhausted());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#setEvictTtlInMs(int)}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#setEvictTtlInMs(int)}
   */
  @Test
  @DisplayName("Test setEvictTtlInMs(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TBRedisCacheConfiguration.setEvictTtlInMs(int)"})
  void testSetEvictTtlInMs() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setEvictTtlInMs(1);

    // Assert
    assertEquals(1, tbRedisClusterConfiguration.getEvictTtlInMs());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#setEvictionRunsMs(long)}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#setEvictionRunsMs(long)}
   */
  @Test
  @DisplayName("Test setEvictionRunsMs(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TBRedisCacheConfiguration.setEvictionRunsMs(long)"})
  void testSetEvictionRunsMs() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setEvictionRunsMs(1L);

    // Assert
    assertEquals(1L, tbRedisClusterConfiguration.getEvictionRunsMs());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#setMaxIdle(int)}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#setMaxIdle(int)}
   */
  @Test
  @DisplayName("Test setMaxIdle(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TBRedisCacheConfiguration.setMaxIdle(int)"})
  void testSetMaxIdle() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setMaxIdle(1);

    // Assert
    assertEquals(1, tbRedisClusterConfiguration.getMaxIdle());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#setMaxTotal(int)}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#setMaxTotal(int)}
   */
  @Test
  @DisplayName("Test setMaxTotal(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TBRedisCacheConfiguration.setMaxTotal(int)"})
  void testSetMaxTotal() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setMaxTotal(3);

    // Assert
    assertEquals(3, tbRedisClusterConfiguration.getMaxTotal());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#setMaxWaitMills(long)}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#setMaxWaitMills(long)}
   */
  @Test
  @DisplayName("Test setMaxWaitMills(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TBRedisCacheConfiguration.setMaxWaitMills(long)"})
  void testSetMaxWaitMills() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setMaxWaitMills(1L);

    // Assert
    assertEquals(1L, tbRedisClusterConfiguration.getMaxWaitMills());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#setMinEvictableMs(long)}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#setMinEvictableMs(long)}
   */
  @Test
  @DisplayName("Test setMinEvictableMs(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TBRedisCacheConfiguration.setMinEvictableMs(long)"})
  void testSetMinEvictableMs() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setMinEvictableMs(1L);

    // Assert
    assertEquals(1L, tbRedisClusterConfiguration.getMinEvictableMs());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#setMinIdle(int)}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#setMinIdle(int)}
   */
  @Test
  @DisplayName("Test setMinIdle(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TBRedisCacheConfiguration.setMinIdle(int)"})
  void testSetMinIdle() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setMinIdle(1);

    // Assert
    assertEquals(1, tbRedisClusterConfiguration.getMinIdle());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#setNumberTestsPerEvictionRun(int)}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#setNumberTestsPerEvictionRun(int)}
   */
  @Test
  @DisplayName("Test setNumberTestsPerEvictionRun(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TBRedisCacheConfiguration.setNumberTestsPerEvictionRun(int)"})
  void testSetNumberTestsPerEvictionRun() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setNumberTestsPerEvictionRun(10);

    // Assert
    assertEquals(10, tbRedisClusterConfiguration.getNumberTestsPerEvictionRun());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#setRedisSslCredentials(RedisSslCredentials)}.
   *
   * <p>Method under test: {@link
   * TBRedisCacheConfiguration#setRedisSslCredentials(RedisSslCredentials)}
   */
  @Test
  @DisplayName("Test setRedisSslCredentials(RedisSslCredentials)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TBRedisCacheConfiguration.setRedisSslCredentials(RedisSslCredentials)"})
  void testSetRedisSslCredentials() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();
    RedisSslCredentials redisSslCredentials = new RedisSslCredentials();

    // Act
    tbRedisClusterConfiguration.setRedisSslCredentials(redisSslCredentials);

    // Assert
    assertSame(redisSslCredentials, tbRedisClusterConfiguration.getRedisSslCredentials());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#setSslEnabled(boolean)}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#setSslEnabled(boolean)}
   */
  @Test
  @DisplayName("Test setSslEnabled(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TBRedisCacheConfiguration.setSslEnabled(boolean)"})
  void testSetSslEnabled() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setSslEnabled(true);

    // Assert
    assertTrue(tbRedisClusterConfiguration.isSslEnabled());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#setTestOnBorrow(boolean)}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#setTestOnBorrow(boolean)}
   */
  @Test
  @DisplayName("Test setTestOnBorrow(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TBRedisCacheConfiguration.setTestOnBorrow(boolean)"})
  void testSetTestOnBorrow() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setTestOnBorrow(true);

    // Assert
    assertTrue(tbRedisClusterConfiguration.isTestOnBorrow());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#setTestOnReturn(boolean)}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#setTestOnReturn(boolean)}
   */
  @Test
  @DisplayName("Test setTestOnReturn(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TBRedisCacheConfiguration.setTestOnReturn(boolean)"})
  void testSetTestOnReturn() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setTestOnReturn(true);

    // Assert
    assertTrue(tbRedisClusterConfiguration.isTestOnReturn());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#setTestWhileIdle(boolean)}.
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#setTestWhileIdle(boolean)}
   */
  @Test
  @DisplayName("Test setTestWhileIdle(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TBRedisCacheConfiguration.setTestWhileIdle(boolean)"})
  void testSetTestWhileIdle() {
    // Arrange
    TBRedisClusterConfiguration tbRedisClusterConfiguration = new TBRedisClusterConfiguration();

    // Act
    tbRedisClusterConfiguration.setTestWhileIdle(true);

    // Assert
    assertTrue(tbRedisClusterConfiguration.isTestWhileIdle());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#toString()}.
   *
   * <ul>
   *   <li>Given {@link TBRedisClusterConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#toString()}
   */
  @Test
  @DisplayName("Test toString(); given TBRedisClusterConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TBRedisCacheConfiguration.toString()"})
  void testToString_givenTBRedisClusterConfiguration() {
    // Arrange, Act and Assert
    assertEquals(
        "TBRedisCacheConfiguration(evictTtlInMs=0, maxTotal=0, maxIdle=0, minIdle=0, testOnBorrow=false,"
            + " testOnReturn=false, testWhileIdle=false, minEvictableMs=0, evictionRunsMs=0, maxWaitMills=0,"
            + " numberTestsPerEvictionRun=0, blockWhenExhausted=false, sslEnabled=false, redisSslCredentials=null)",
        new TBRedisClusterConfiguration().toString());
  }

  /**
   * Test {@link TBRedisCacheConfiguration#toString()}.
   *
   * <ul>
   *   <li>Given {@link TBRedisClusterConfiguration} (default constructor) TestOnBorrow is {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link TBRedisCacheConfiguration#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given TBRedisClusterConfiguration (default constructor) TestOnBorrow is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TBRedisCacheConfiguration.toString()"})
  void testToString_givenTBRedisClusterConfigurationTestOnBorrowIsTrue() {
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
