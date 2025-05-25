package org.thingsboard.server.transport.lwm2m.server.store;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.eclipse.leshan.core.peer.OscoreIdentity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

class TbLwM2mRedisSecurityStoreDiffblueTest {
  /**
   * Test {@link TbLwM2mRedisSecurityStore#TbLwM2mRedisSecurityStore(RedisConnectionFactory)}.
   * <ul>
   *   <li>Then return ByOscoreIdentity is {@code null} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLwM2mRedisSecurityStore#TbLwM2mRedisSecurityStore(RedisConnectionFactory)}
   */
  @Test
  @DisplayName("Test new TbLwM2mRedisSecurityStore(RedisConnectionFactory); then return ByOscoreIdentity is 'null' is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbLwM2mRedisSecurityStore.<init>(RedisConnectionFactory)"})
  void testNewTbLwM2mRedisSecurityStore_thenReturnByOscoreIdentityIsNullIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertNull((new TbLwM2mRedisSecurityStore(new JedisConnectionFactory())).getByOscoreIdentity(null));
  }

  /**
   * Test {@link TbLwM2mRedisSecurityStore#getByOscoreIdentity(OscoreIdentity)}.
   * <p>
   * Method under test: {@link TbLwM2mRedisSecurityStore#getByOscoreIdentity(OscoreIdentity)}
   */
  @Test
  @DisplayName("Test getByOscoreIdentity(OscoreIdentity)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.eclipse.leshan.server.security.SecurityInfo TbLwM2mRedisSecurityStore.getByOscoreIdentity(OscoreIdentity)"})
  void testGetByOscoreIdentity() throws UnsupportedEncodingException {
    // Arrange
    TbLwM2mRedisSecurityStore tbLwM2mRedisSecurityStore = new TbLwM2mRedisSecurityStore(new JedisConnectionFactory());

    // Act and Assert
    assertNull(tbLwM2mRedisSecurityStore.getByOscoreIdentity(new OscoreIdentity("AXAXAXAX".getBytes("UTF-8"))));
  }
}
