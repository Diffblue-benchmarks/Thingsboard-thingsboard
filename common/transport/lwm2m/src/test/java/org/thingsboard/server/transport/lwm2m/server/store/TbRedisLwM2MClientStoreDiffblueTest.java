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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2MClientState;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;

class TbRedisLwM2MClientStoreDiffblueTest {
  /**
   * Test {@link TbRedisLwM2MClientStore#put(LwM2mClient)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link LwM2mClient#getNodeId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRedisLwM2MClientStore#put(LwM2mClient)}
   */
  @Test
  @DisplayName("Test put(LwM2mClient); given RuntimeException(); then calls getNodeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRedisLwM2MClientStore.put(LwM2mClient)"})
  void testPut_givenRuntimeException_thenCallsGetNodeId() {
    // Arrange
    TbRedisLwM2MClientStore tbRedisLwM2MClientStore =
        new TbRedisLwM2MClientStore(new JedisConnectionFactory());

    LwM2mClient client = mock(LwM2mClient.class);
    when(client.getNodeId()).thenThrow(new RuntimeException());
    when(client.getState()).thenReturn(LwM2MClientState.CREATED);

    // Act
    tbRedisLwM2MClientStore.put(client);

    // Assert
    verify(client).getNodeId();
    verify(client).getState();
  }
}
