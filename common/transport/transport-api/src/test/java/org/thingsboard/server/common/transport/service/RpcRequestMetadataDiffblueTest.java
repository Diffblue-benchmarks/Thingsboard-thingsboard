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
package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class RpcRequestMetadataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RpcRequestMetadata#equals(Object)}
   *   <li>{@link RpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(null, 1);
    RpcRequestMetadata rpcRequestMetadata2 = new RpcRequestMetadata(null, 1);

    // Act and Assert
    assertEquals(rpcRequestMetadata, rpcRequestMetadata2);
    int expectedHashCodeResult = rpcRequestMetadata.hashCode();
    assertEquals(expectedHashCodeResult, rpcRequestMetadata2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RpcRequestMetadata#equals(Object)}
   *   <li>{@link RpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(new UUID(1L, 1L), 1);
    RpcRequestMetadata rpcRequestMetadata2 = new RpcRequestMetadata(new UUID(1L, 1L), 1);

    // Act and Assert
    assertEquals(rpcRequestMetadata, rpcRequestMetadata2);
    int expectedHashCodeResult = rpcRequestMetadata.hashCode();
    assertEquals(expectedHashCodeResult, rpcRequestMetadata2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RpcRequestMetadata#equals(Object)}
   *   <li>{@link RpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(UUID.randomUUID(), 1);

    // Act and Assert
    assertEquals(rpcRequestMetadata, rpcRequestMetadata);
    int expectedHashCodeResult = rpcRequestMetadata.hashCode();
    assertEquals(expectedHashCodeResult, rpcRequestMetadata.hashCode());
  }

  /**
   * Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(UUID.randomUUID(), 1);

    // Act and Assert
    assertNotEquals(rpcRequestMetadata, new RpcRequestMetadata(UUID.randomUUID(), 1));
  }

  /**
   * Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(null, 1);

    // Act and Assert
    assertNotEquals(rpcRequestMetadata, new RpcRequestMetadata(UUID.randomUUID(), 1));
  }

  /**
   * Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(UUID.randomUUID(), 2);

    // Act and Assert
    assertNotEquals(rpcRequestMetadata, new RpcRequestMetadata(UUID.randomUUID(), 1));
  }

  /**
   * Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RpcRequestMetadata(UUID.randomUUID(), 1), null);
  }

  /**
   * Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RpcRequestMetadata(UUID.randomUUID(), 1), "Different type to RpcRequestMetadata");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RpcRequestMetadata#RpcRequestMetadata(UUID, int)}
   *   <li>{@link RpcRequestMetadata#toString()}
   *   <li>{@link RpcRequestMetadata#getRequestId()}
   *   <li>{@link RpcRequestMetadata#getSessionId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act
    RpcRequestMetadata actualRpcRequestMetadata = new RpcRequestMetadata(sessionId, 1);
    actualRpcRequestMetadata.toString();
    int actualRequestId = actualRpcRequestMetadata.getRequestId();

    // Assert
    assertEquals(1, actualRequestId);
    assertSame(sessionId, actualRpcRequestMetadata.getSessionId());
  }
}
