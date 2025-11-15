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
package org.thingsboard.server.common.msg.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.rpc.RpcError;

class FromDeviceRpcResponseDiffblueTest {
  /**
   * Method under test: {@link FromDeviceRpcResponse#getResponse()}
   */
  @Test
  void testGetResponse() {
    // Arrange and Act
    Optional<String> actualResponse = (new FromDeviceRpcResponse(UUID.randomUUID(), "Response", RpcError.NOT_FOUND))
        .getResponse();

    // Assert
    assertEquals("Response", actualResponse.get());
    assertTrue(actualResponse.isPresent());
  }

  /**
   * Method under test: {@link FromDeviceRpcResponse#getError()}
   */
  @Test
  void testGetError() {
    // Arrange and Act
    Optional<RpcError> actualError = (new FromDeviceRpcResponse(UUID.randomUUID(), "Response", RpcError.NOT_FOUND))
        .getError();

    // Assert
    assertEquals(RpcError.NOT_FOUND, actualError.get());
    assertTrue(actualError.isPresent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FromDeviceRpcResponse#equals(Object)}
   *   <li>{@link FromDeviceRpcResponse#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FromDeviceRpcResponse fromDeviceRpcResponse = new FromDeviceRpcResponse(null, "Response", RpcError.NOT_FOUND);
    FromDeviceRpcResponse fromDeviceRpcResponse2 = new FromDeviceRpcResponse(null, "Response", RpcError.NOT_FOUND);

    // Act and Assert
    assertEquals(fromDeviceRpcResponse, fromDeviceRpcResponse2);
    int expectedHashCodeResult = fromDeviceRpcResponse.hashCode();
    assertEquals(expectedHashCodeResult, fromDeviceRpcResponse2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FromDeviceRpcResponse#equals(Object)}
   *   <li>{@link FromDeviceRpcResponse#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FromDeviceRpcResponse fromDeviceRpcResponse = new FromDeviceRpcResponse(new UUID(1L, 1L), "Response",
        RpcError.NOT_FOUND);
    FromDeviceRpcResponse fromDeviceRpcResponse2 = new FromDeviceRpcResponse(new UUID(1L, 1L), "Response",
        RpcError.NOT_FOUND);

    // Act and Assert
    assertEquals(fromDeviceRpcResponse, fromDeviceRpcResponse2);
    int expectedHashCodeResult = fromDeviceRpcResponse.hashCode();
    assertEquals(expectedHashCodeResult, fromDeviceRpcResponse2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FromDeviceRpcResponse#equals(Object)}
   *   <li>{@link FromDeviceRpcResponse#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FromDeviceRpcResponse fromDeviceRpcResponse = new FromDeviceRpcResponse(UUID.randomUUID(), "Response",
        RpcError.NOT_FOUND);

    // Act and Assert
    assertEquals(fromDeviceRpcResponse, fromDeviceRpcResponse);
    int expectedHashCodeResult = fromDeviceRpcResponse.hashCode();
    assertEquals(expectedHashCodeResult, fromDeviceRpcResponse.hashCode());
  }

  /**
   * Method under test: {@link FromDeviceRpcResponse#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FromDeviceRpcResponse fromDeviceRpcResponse = new FromDeviceRpcResponse(UUID.randomUUID(), "Response",
        RpcError.NOT_FOUND);

    // Act and Assert
    assertNotEquals(fromDeviceRpcResponse,
        new FromDeviceRpcResponse(UUID.randomUUID(), "Response", RpcError.NOT_FOUND));
  }

  /**
   * Method under test: {@link FromDeviceRpcResponse#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FromDeviceRpcResponse fromDeviceRpcResponse = new FromDeviceRpcResponse(null, "Response", RpcError.NOT_FOUND);

    // Act and Assert
    assertNotEquals(fromDeviceRpcResponse,
        new FromDeviceRpcResponse(UUID.randomUUID(), "Response", RpcError.NOT_FOUND));
  }

  /**
   * Method under test: {@link FromDeviceRpcResponse#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    FromDeviceRpcResponse fromDeviceRpcResponse = new FromDeviceRpcResponse(null, null, RpcError.NOT_FOUND);

    // Act and Assert
    assertNotEquals(fromDeviceRpcResponse, new FromDeviceRpcResponse(null, "Response", RpcError.NOT_FOUND));
  }

  /**
   * Method under test: {@link FromDeviceRpcResponse#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    FromDeviceRpcResponse fromDeviceRpcResponse = new FromDeviceRpcResponse(null, "Response", null);

    // Act and Assert
    assertNotEquals(fromDeviceRpcResponse, new FromDeviceRpcResponse(null, "Response", RpcError.NOT_FOUND));
  }

  /**
   * Method under test: {@link FromDeviceRpcResponse#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FromDeviceRpcResponse(UUID.randomUUID(), "Response", RpcError.NOT_FOUND), null);
  }

  /**
   * Method under test: {@link FromDeviceRpcResponse#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FromDeviceRpcResponse(UUID.randomUUID(), "Response", RpcError.NOT_FOUND),
        "Different type to FromDeviceRpcResponse");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link FromDeviceRpcResponse#FromDeviceRpcResponse(UUID, String, RpcError)}
   *   <li>{@link FromDeviceRpcResponse#toString()}
   *   <li>{@link FromDeviceRpcResponse#getId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    UUID id = UUID.randomUUID();

    // Act
    FromDeviceRpcResponse actualFromDeviceRpcResponse = new FromDeviceRpcResponse(id, "Response", RpcError.NOT_FOUND);
    actualFromDeviceRpcResponse.toString();

    // Assert
    assertSame(id, actualFromDeviceRpcResponse.getId());
  }
}
