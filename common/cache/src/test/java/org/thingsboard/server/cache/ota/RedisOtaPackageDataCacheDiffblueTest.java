package org.thingsboard.server.cache.ota;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.redis.connection.DefaultStringRedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisClusterConnection;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import redis.clients.jedis.JedisCluster;

@ExtendWith(MockitoExtension.class)
class RedisOtaPackageDataCacheDiffblueTest {
  @Mock private RedisConnectionFactory redisConnectionFactory;

  @InjectMocks private RedisOtaPackageDataCache redisOtaPackageDataCache;

  /**
   * Test {@link RedisOtaPackageDataCache#get(String, int, int)} with {@code key}, {@code
   * chunkSize}, {@code chunk}.
   *
   * <ul>
   *   <li>Then calls {@link JedisCluster#get(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link RedisOtaPackageDataCache#get(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test get(String, int, int) with 'key', 'chunkSize', 'chunk'; then calls get(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RedisOtaPackageDataCache.get(String, int, int)"})
  void testGetWithKeyChunkSizeChunk_thenCallsGet() throws UnsupportedEncodingException {
    // Arrange
    JedisCluster cluster = mock(JedisCluster.class);
    when(cluster.get(Mockito.<byte[]>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    JedisClusterConnection connection = new JedisClusterConnection(cluster);
    DefaultStringRedisConnection connection2 = new DefaultStringRedisConnection(connection);
    Class<String> type = String.class;
    DefaultStringRedisConnection defaultStringRedisConnection =
        new DefaultStringRedisConnection(connection2, new GenericToStringSerializer<>(type));
    when(redisConnectionFactory.getConnection()).thenReturn(defaultStringRedisConnection);

    // Act
    byte[] actualGetResult = redisOtaPackageDataCache.get("Key", 0, 1);

    // Assert
    verify(redisConnectionFactory).getConnection();
    verify(cluster).get(isA(byte[].class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualGetResult);
  }

  /**
   * Test {@link RedisOtaPackageDataCache#get(String, int, int)} with {@code key}, {@code
   * chunkSize}, {@code chunk}.
   *
   * <ul>
   *   <li>Then calls {@link JedisCluster#getrange(byte[], long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link RedisOtaPackageDataCache#get(String, int, int)}
   */
  @Test
  @DisplayName(
      "Test get(String, int, int) with 'key', 'chunkSize', 'chunk'; then calls getrange(byte[], long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RedisOtaPackageDataCache.get(String, int, int)"})
  void testGetWithKeyChunkSizeChunk_thenCallsGetrange() throws UnsupportedEncodingException {
    // Arrange
    JedisCluster cluster = mock(JedisCluster.class);
    when(cluster.getrange(Mockito.<byte[]>any(), anyLong(), anyLong()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    JedisClusterConnection connection = new JedisClusterConnection(cluster);
    DefaultStringRedisConnection connection2 = new DefaultStringRedisConnection(connection);
    Class<String> type = String.class;
    DefaultStringRedisConnection defaultStringRedisConnection =
        new DefaultStringRedisConnection(connection2, new GenericToStringSerializer<>(type));
    when(redisConnectionFactory.getConnection()).thenReturn(defaultStringRedisConnection);

    // Act
    byte[] actualGetResult = redisOtaPackageDataCache.get("Key", 3, 1);

    // Assert
    verify(redisConnectionFactory).getConnection();
    verify(cluster).getrange(isA(byte[].class), eq(3L), eq(5L));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualGetResult);
  }

  /**
   * Test {@link RedisOtaPackageDataCache#get(String)} with {@code key}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link RedisOtaPackageDataCache#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'key'; then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] RedisOtaPackageDataCache.get(String)"})
  void testGetWithKey_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange
    JedisCluster cluster = mock(JedisCluster.class);
    when(cluster.get(Mockito.<byte[]>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    JedisClusterConnection connection = new JedisClusterConnection(cluster);
    DefaultStringRedisConnection connection2 = new DefaultStringRedisConnection(connection);
    Class<String> type = String.class;
    DefaultStringRedisConnection defaultStringRedisConnection =
        new DefaultStringRedisConnection(connection2, new GenericToStringSerializer<>(type));
    when(redisConnectionFactory.getConnection()).thenReturn(defaultStringRedisConnection);

    // Act
    byte[] actualGetResult = redisOtaPackageDataCache.get("Key");

    // Assert
    verify(redisConnectionFactory).getConnection();
    verify(cluster).get(isA(byte[].class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualGetResult);
  }

  /**
   * Test {@link RedisOtaPackageDataCache#put(String, byte[])}.
   *
   * <ul>
   *   <li>Given {@link JedisCluster} {@link JedisCluster#set(byte[], byte[])} return {@code Set}.
   *   <li>Then calls {@link RedisConnectionFactory#getConnection()}.
   * </ul>
   *
   * <p>Method under test: {@link RedisOtaPackageDataCache#put(String, byte[])}
   */
  @Test
  @DisplayName(
      "Test put(String, byte[]); given JedisCluster set(byte[], byte[]) return 'Set'; then calls getConnection()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RedisOtaPackageDataCache.put(String, byte[])"})
  void testPut_givenJedisClusterSetReturnSet_thenCallsGetConnection()
      throws UnsupportedEncodingException {
    // Arrange
    JedisCluster cluster = mock(JedisCluster.class);
    when(cluster.set(Mockito.<byte[]>any(), Mockito.<byte[]>any())).thenReturn("Set");
    JedisClusterConnection connection = new JedisClusterConnection(cluster);
    DefaultStringRedisConnection connection2 = new DefaultStringRedisConnection(connection);
    Class<String> type = String.class;
    DefaultStringRedisConnection defaultStringRedisConnection =
        new DefaultStringRedisConnection(connection2, new GenericToStringSerializer<>(type));
    when(redisConnectionFactory.getConnection()).thenReturn(defaultStringRedisConnection);

    // Act
    redisOtaPackageDataCache.put("Key", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(redisConnectionFactory).getConnection();
    verify(cluster).set(isA(byte[].class), isA(byte[].class));
  }

  /**
   * Test {@link RedisOtaPackageDataCache#evict(String)}.
   *
   * <ul>
   *   <li>Given {@link JedisCluster} {@link JedisCluster#del(byte[][])} return one.
   *   <li>Then calls {@link RedisConnectionFactory#getConnection()}.
   * </ul>
   *
   * <p>Method under test: {@link RedisOtaPackageDataCache#evict(String)}
   */
  @Test
  @DisplayName(
      "Test evict(String); given JedisCluster del(byte[][]) return one; then calls getConnection()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RedisOtaPackageDataCache.evict(String)"})
  void testEvict_givenJedisClusterDelReturnOne_thenCallsGetConnection() {
    // Arrange
    JedisCluster cluster = mock(JedisCluster.class);
    when(cluster.del(isA(byte[][].class))).thenReturn(1L);
    JedisClusterConnection connection = new JedisClusterConnection(cluster);
    DefaultStringRedisConnection connection2 = new DefaultStringRedisConnection(connection);
    Class<String> type = String.class;
    DefaultStringRedisConnection defaultStringRedisConnection =
        new DefaultStringRedisConnection(connection2, new GenericToStringSerializer<>(type));
    when(redisConnectionFactory.getConnection()).thenReturn(defaultStringRedisConnection);

    // Act
    redisOtaPackageDataCache.evict("Key");

    // Assert
    verify(redisConnectionFactory).getConnection();
    verify(cluster).del(isA(byte[][].class));
  }
}
