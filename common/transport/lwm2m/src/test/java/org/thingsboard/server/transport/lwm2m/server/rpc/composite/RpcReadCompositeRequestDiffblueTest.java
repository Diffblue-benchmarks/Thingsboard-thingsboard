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
package org.thingsboard.server.transport.lwm2m.server.rpc.composite;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class RpcReadCompositeRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RpcReadCompositeRequest#equals(Object)}
   *   <li>{@link RpcReadCompositeRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RpcReadCompositeRequest rpcReadCompositeRequest = new RpcReadCompositeRequest();
    rpcReadCompositeRequest.setIds(new String[]{"Ids"});
    rpcReadCompositeRequest.setKeys(new String[]{"Keys"});

    RpcReadCompositeRequest rpcReadCompositeRequest2 = new RpcReadCompositeRequest();
    rpcReadCompositeRequest2.setIds(new String[]{"Ids"});
    rpcReadCompositeRequest2.setKeys(new String[]{"Keys"});

    // Act and Assert
    assertEquals(rpcReadCompositeRequest, rpcReadCompositeRequest2);
    int expectedHashCodeResult = rpcReadCompositeRequest.hashCode();
    assertEquals(expectedHashCodeResult, rpcReadCompositeRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RpcReadCompositeRequest#equals(Object)}
   *   <li>{@link RpcReadCompositeRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RpcReadCompositeRequest rpcReadCompositeRequest = new RpcReadCompositeRequest();
    rpcReadCompositeRequest.setIds(new String[]{"Ids"});
    rpcReadCompositeRequest.setKeys(new String[]{"Keys"});

    // Act and Assert
    assertEquals(rpcReadCompositeRequest, rpcReadCompositeRequest);
    int expectedHashCodeResult = rpcReadCompositeRequest.hashCode();
    assertEquals(expectedHashCodeResult, rpcReadCompositeRequest.hashCode());
  }

  /**
   * Method under test: {@link RpcReadCompositeRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RpcReadCompositeRequest rpcReadCompositeRequest = new RpcReadCompositeRequest();
    rpcReadCompositeRequest
        .setIds(new String[]{"org.thingsboard.server.transport.lwm2m.server.rpc.composite.RpcReadCompositeRequest"});
    rpcReadCompositeRequest.setKeys(new String[]{"Keys"});

    RpcReadCompositeRequest rpcReadCompositeRequest2 = new RpcReadCompositeRequest();
    rpcReadCompositeRequest2.setIds(new String[]{"Ids"});
    rpcReadCompositeRequest2.setKeys(new String[]{"Keys"});

    // Act and Assert
    assertNotEquals(rpcReadCompositeRequest, rpcReadCompositeRequest2);
  }

  /**
   * Method under test: {@link RpcReadCompositeRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RpcReadCompositeRequest rpcReadCompositeRequest = new RpcReadCompositeRequest();
    rpcReadCompositeRequest.setIds(new String[]{"Ids"});
    rpcReadCompositeRequest
        .setKeys(new String[]{"org.thingsboard.server.transport.lwm2m.server.rpc.composite.RpcReadCompositeRequest"});

    RpcReadCompositeRequest rpcReadCompositeRequest2 = new RpcReadCompositeRequest();
    rpcReadCompositeRequest2.setIds(new String[]{"Ids"});
    rpcReadCompositeRequest2.setKeys(new String[]{"Keys"});

    // Act and Assert
    assertNotEquals(rpcReadCompositeRequest, rpcReadCompositeRequest2);
  }

  /**
   * Method under test: {@link RpcReadCompositeRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RpcReadCompositeRequest rpcReadCompositeRequest = new RpcReadCompositeRequest();
    rpcReadCompositeRequest.setIds(new String[]{"Ids"});
    rpcReadCompositeRequest.setKeys(new String[]{"Keys"});

    // Act and Assert
    assertNotEquals(rpcReadCompositeRequest, null);
  }

  /**
   * Method under test: {@link RpcReadCompositeRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RpcReadCompositeRequest rpcReadCompositeRequest = new RpcReadCompositeRequest();
    rpcReadCompositeRequest.setIds(new String[]{"Ids"});
    rpcReadCompositeRequest.setKeys(new String[]{"Keys"});

    // Act and Assert
    assertNotEquals(rpcReadCompositeRequest, "Different type to RpcReadCompositeRequest");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RpcReadCompositeRequest}
   *   <li>{@link RpcReadCompositeRequest#setIds(String[])}
   *   <li>{@link RpcReadCompositeRequest#setKeys(String[])}
   *   <li>{@link RpcReadCompositeRequest#toString()}
   *   <li>{@link RpcReadCompositeRequest#getIds()}
   *   <li>{@link RpcReadCompositeRequest#getKeys()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RpcReadCompositeRequest actualRpcReadCompositeRequest = new RpcReadCompositeRequest();
    String[] ids = new String[]{"Ids"};
    actualRpcReadCompositeRequest.setIds(ids);
    String[] keys = new String[]{"Keys"};
    actualRpcReadCompositeRequest.setKeys(keys);
    String actualToStringResult = actualRpcReadCompositeRequest.toString();
    String[] actualIds = actualRpcReadCompositeRequest.getIds();
    String[] actualKeys = actualRpcReadCompositeRequest.getKeys();

    // Assert that nothing has changed
    assertEquals("RpcReadCompositeRequest(keys=[Keys], ids=[Ids])", actualToStringResult);
    assertSame(ids, actualIds);
    assertSame(keys, actualKeys);
    assertArrayEquals(new String[]{"Ids"}, actualIds);
    assertArrayEquals(new String[]{"Keys"}, actualKeys);
  }
}
