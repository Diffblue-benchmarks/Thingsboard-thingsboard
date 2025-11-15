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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class RpcWriteCompositeRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RpcWriteCompositeRequest#equals(Object)}
   *   <li>{@link RpcWriteCompositeRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RpcWriteCompositeRequest rpcWriteCompositeRequest = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest.setNodes(new HashMap<>());

    RpcWriteCompositeRequest rpcWriteCompositeRequest2 = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest2.setNodes(new HashMap<>());

    // Act and Assert
    assertEquals(rpcWriteCompositeRequest, rpcWriteCompositeRequest2);
    int expectedHashCodeResult = rpcWriteCompositeRequest.hashCode();
    assertEquals(expectedHashCodeResult, rpcWriteCompositeRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RpcWriteCompositeRequest#equals(Object)}
   *   <li>{@link RpcWriteCompositeRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RpcWriteCompositeRequest rpcWriteCompositeRequest = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest.setNodes(new HashMap<>());

    // Act and Assert
    assertEquals(rpcWriteCompositeRequest, rpcWriteCompositeRequest);
    int expectedHashCodeResult = rpcWriteCompositeRequest.hashCode();
    assertEquals(expectedHashCodeResult, rpcWriteCompositeRequest.hashCode());
  }

  /**
   * Method under test: {@link RpcWriteCompositeRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashMap<String, Object> nodes = new HashMap<>();
    nodes.put("foo", "42");

    RpcWriteCompositeRequest rpcWriteCompositeRequest = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest.setNodes(nodes);

    RpcWriteCompositeRequest rpcWriteCompositeRequest2 = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest2.setNodes(new HashMap<>());

    // Act and Assert
    assertNotEquals(rpcWriteCompositeRequest, rpcWriteCompositeRequest2);
  }

  /**
   * Method under test: {@link RpcWriteCompositeRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<String, Object> nodes = new HashMap<>();
    nodes.computeIfPresent("foo", mock(BiFunction.class));
    nodes.put("foo", "42");

    RpcWriteCompositeRequest rpcWriteCompositeRequest = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest.setNodes(nodes);

    RpcWriteCompositeRequest rpcWriteCompositeRequest2 = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest2.setNodes(new HashMap<>());

    // Act and Assert
    assertNotEquals(rpcWriteCompositeRequest, rpcWriteCompositeRequest2);
  }

  /**
   * Method under test: {@link RpcWriteCompositeRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RpcWriteCompositeRequest rpcWriteCompositeRequest = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest.setNodes(new HashMap<>());

    // Act and Assert
    assertNotEquals(rpcWriteCompositeRequest, null);
  }

  /**
   * Method under test: {@link RpcWriteCompositeRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RpcWriteCompositeRequest rpcWriteCompositeRequest = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest.setNodes(new HashMap<>());

    // Act and Assert
    assertNotEquals(rpcWriteCompositeRequest, "Different type to RpcWriteCompositeRequest");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RpcWriteCompositeRequest}
   *   <li>{@link RpcWriteCompositeRequest#setNodes(Map)}
   *   <li>{@link RpcWriteCompositeRequest#toString()}
   *   <li>{@link RpcWriteCompositeRequest#getNodes()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RpcWriteCompositeRequest actualRpcWriteCompositeRequest = new RpcWriteCompositeRequest();
    HashMap<String, Object> nodes = new HashMap<>();
    actualRpcWriteCompositeRequest.setNodes(nodes);
    String actualToStringResult = actualRpcWriteCompositeRequest.toString();
    Map<String, Object> actualNodes = actualRpcWriteCompositeRequest.getNodes();

    // Assert that nothing has changed
    assertEquals("RpcWriteCompositeRequest(nodes={})", actualToStringResult);
    assertTrue(actualNodes.isEmpty());
    assertSame(nodes, actualNodes);
  }
}
