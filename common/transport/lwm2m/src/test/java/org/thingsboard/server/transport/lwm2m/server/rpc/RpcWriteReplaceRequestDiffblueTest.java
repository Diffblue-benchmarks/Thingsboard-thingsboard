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
package org.thingsboard.server.transport.lwm2m.server.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class RpcWriteReplaceRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RpcWriteReplaceRequest#equals(Object)}
   *   <li>{@link RpcWriteReplaceRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RpcWriteReplaceRequest rpcWriteReplaceRequest = new RpcWriteReplaceRequest();
    rpcWriteReplaceRequest.setContentFormat("Not all who wander are lost");
    rpcWriteReplaceRequest.setId("42");
    rpcWriteReplaceRequest.setKey("Key");
    rpcWriteReplaceRequest.setValue("Value");

    RpcWriteReplaceRequest rpcWriteReplaceRequest2 = new RpcWriteReplaceRequest();
    rpcWriteReplaceRequest2.setContentFormat("Not all who wander are lost");
    rpcWriteReplaceRequest2.setId("42");
    rpcWriteReplaceRequest2.setKey("Key");
    rpcWriteReplaceRequest2.setValue("Value");

    // Act and Assert
    assertEquals(rpcWriteReplaceRequest, rpcWriteReplaceRequest2);
    int expectedHashCodeResult = rpcWriteReplaceRequest.hashCode();
    assertEquals(expectedHashCodeResult, rpcWriteReplaceRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RpcWriteReplaceRequest#equals(Object)}
   *   <li>{@link RpcWriteReplaceRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RpcWriteReplaceRequest rpcWriteReplaceRequest = new RpcWriteReplaceRequest();
    rpcWriteReplaceRequest.setContentFormat("Not all who wander are lost");
    rpcWriteReplaceRequest.setId("42");
    rpcWriteReplaceRequest.setKey("Key");
    rpcWriteReplaceRequest.setValue("Value");

    // Act and Assert
    assertEquals(rpcWriteReplaceRequest, rpcWriteReplaceRequest);
    int expectedHashCodeResult = rpcWriteReplaceRequest.hashCode();
    assertEquals(expectedHashCodeResult, rpcWriteReplaceRequest.hashCode());
  }

  /**
   * Method under test: {@link RpcWriteReplaceRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RpcWriteReplaceRequest rpcWriteReplaceRequest = new RpcWriteReplaceRequest();
    rpcWriteReplaceRequest.setContentFormat("Key");
    rpcWriteReplaceRequest.setId("42");
    rpcWriteReplaceRequest.setKey("Key");
    rpcWriteReplaceRequest.setValue("Value");

    RpcWriteReplaceRequest rpcWriteReplaceRequest2 = new RpcWriteReplaceRequest();
    rpcWriteReplaceRequest2.setContentFormat("Not all who wander are lost");
    rpcWriteReplaceRequest2.setId("42");
    rpcWriteReplaceRequest2.setKey("Key");
    rpcWriteReplaceRequest2.setValue("Value");

    // Act and Assert
    assertNotEquals(rpcWriteReplaceRequest, rpcWriteReplaceRequest2);
  }

  /**
   * Method under test: {@link RpcWriteReplaceRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RpcWriteReplaceRequest rpcWriteReplaceRequest = new RpcWriteReplaceRequest();
    rpcWriteReplaceRequest.setContentFormat("Not all who wander are lost");
    rpcWriteReplaceRequest.setId("42");
    rpcWriteReplaceRequest.setKey("Key");
    rpcWriteReplaceRequest.setValue("Value");

    RpcWriteReplaceRequest rpcWriteReplaceRequest2 = new RpcWriteReplaceRequest();
    rpcWriteReplaceRequest2.setContentFormat("Not all who wander are lost");
    rpcWriteReplaceRequest2.setId("42");
    rpcWriteReplaceRequest2.setKey("Key");
    rpcWriteReplaceRequest2.setValue(rpcWriteReplaceRequest);

    RpcWriteReplaceRequest rpcWriteReplaceRequest3 = new RpcWriteReplaceRequest();
    rpcWriteReplaceRequest3.setContentFormat("Not all who wander are lost");
    rpcWriteReplaceRequest3.setId("42");
    rpcWriteReplaceRequest3.setKey("Key");
    rpcWriteReplaceRequest3.setValue("Value");

    // Act and Assert
    assertNotEquals(rpcWriteReplaceRequest2, rpcWriteReplaceRequest3);
  }

  /**
   * Method under test: {@link RpcWriteReplaceRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RpcWriteReplaceRequest rpcWriteReplaceRequest = new RpcWriteReplaceRequest();
    rpcWriteReplaceRequest.setContentFormat("Not all who wander are lost");
    rpcWriteReplaceRequest.setId("42");
    rpcWriteReplaceRequest.setKey("Key");
    rpcWriteReplaceRequest.setValue(null);

    RpcWriteReplaceRequest rpcWriteReplaceRequest2 = new RpcWriteReplaceRequest();
    rpcWriteReplaceRequest2.setContentFormat("Not all who wander are lost");
    rpcWriteReplaceRequest2.setId("42");
    rpcWriteReplaceRequest2.setKey("Key");
    rpcWriteReplaceRequest2.setValue("Value");

    // Act and Assert
    assertNotEquals(rpcWriteReplaceRequest, rpcWriteReplaceRequest2);
  }

  /**
   * Method under test: {@link RpcWriteReplaceRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RpcWriteReplaceRequest rpcWriteReplaceRequest = new RpcWriteReplaceRequest();
    rpcWriteReplaceRequest.setContentFormat("Not all who wander are lost");
    rpcWriteReplaceRequest.setId("42");
    rpcWriteReplaceRequest.setKey("Key");
    rpcWriteReplaceRequest.setValue(mock(LwM2MRpcRequestHeader.class));

    RpcWriteReplaceRequest rpcWriteReplaceRequest2 = new RpcWriteReplaceRequest();
    rpcWriteReplaceRequest2.setContentFormat("Not all who wander are lost");
    rpcWriteReplaceRequest2.setId("42");
    rpcWriteReplaceRequest2.setKey("Key");
    rpcWriteReplaceRequest2.setValue("Value");

    // Act and Assert
    assertNotEquals(rpcWriteReplaceRequest, rpcWriteReplaceRequest2);
  }

  /**
   * Method under test: {@link RpcWriteReplaceRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RpcWriteReplaceRequest rpcWriteReplaceRequest = new RpcWriteReplaceRequest();
    rpcWriteReplaceRequest.setContentFormat("Not all who wander are lost");
    rpcWriteReplaceRequest.setId("42");
    rpcWriteReplaceRequest.setKey("Key");
    rpcWriteReplaceRequest.setValue("Value");

    // Act and Assert
    assertNotEquals(rpcWriteReplaceRequest, null);
  }

  /**
   * Method under test: {@link RpcWriteReplaceRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RpcWriteReplaceRequest rpcWriteReplaceRequest = new RpcWriteReplaceRequest();
    rpcWriteReplaceRequest.setContentFormat("Not all who wander are lost");
    rpcWriteReplaceRequest.setId("42");
    rpcWriteReplaceRequest.setKey("Key");
    rpcWriteReplaceRequest.setValue("Value");

    // Act and Assert
    assertNotEquals(rpcWriteReplaceRequest, "Different type to RpcWriteReplaceRequest");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RpcWriteReplaceRequest}
   *   <li>{@link RpcWriteReplaceRequest#setValue(Object)}
   *   <li>{@link RpcWriteReplaceRequest#toString()}
   *   <li>{@link RpcWriteReplaceRequest#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RpcWriteReplaceRequest actualRpcWriteReplaceRequest = new RpcWriteReplaceRequest();
    actualRpcWriteReplaceRequest.setValue("Value");
    String actualToStringResult = actualRpcWriteReplaceRequest.toString();

    // Assert that nothing has changed
    assertEquals("RpcWriteReplaceRequest(value=Value)", actualToStringResult);
    assertEquals("Value", actualRpcWriteReplaceRequest.getValue());
  }
}
