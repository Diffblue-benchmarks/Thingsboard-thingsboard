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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.eclipse.leshan.core.peer.OscoreIdentity;
import org.eclipse.leshan.server.security.SecurityInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

class TbLwM2mRedisSecurityStoreDiffblueTest {
  /**
   * Test {@link TbLwM2mRedisSecurityStore#TbLwM2mRedisSecurityStore(RedisConnectionFactory)}.
   *
   * <ul>
   *   <li>Then return ByOscoreIdentity is {@code null} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbLwM2mRedisSecurityStore#TbLwM2mRedisSecurityStore(RedisConnectionFactory)}
   */
  @Test
  @DisplayName(
      "Test new TbLwM2mRedisSecurityStore(RedisConnectionFactory); then return ByOscoreIdentity is 'null' is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLwM2mRedisSecurityStore.<init>(RedisConnectionFactory)"})
  void testNewTbLwM2mRedisSecurityStore_thenReturnByOscoreIdentityIsNullIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertNull(
        new TbLwM2mRedisSecurityStore(new JedisConnectionFactory()).getByOscoreIdentity(null));
  }

  /**
   * Test {@link TbLwM2mRedisSecurityStore#getByOscoreIdentity(OscoreIdentity)}.
   *
   * <p>Method under test: {@link TbLwM2mRedisSecurityStore#getByOscoreIdentity(OscoreIdentity)}
   */
  @Test
  @DisplayName("Test getByOscoreIdentity(OscoreIdentity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SecurityInfo TbLwM2mRedisSecurityStore.getByOscoreIdentity(OscoreIdentity)"})
  void testGetByOscoreIdentity() throws UnsupportedEncodingException {
    // Arrange
    TbLwM2mRedisSecurityStore tbLwM2mRedisSecurityStore =
        new TbLwM2mRedisSecurityStore(new JedisConnectionFactory());

    // Act
    SecurityInfo actualByOscoreIdentity =
        tbLwM2mRedisSecurityStore.getByOscoreIdentity(
            new OscoreIdentity("AXAXAXAX".getBytes("UTF-8")));

    // Assert
    assertNull(actualByOscoreIdentity);
  }
}
