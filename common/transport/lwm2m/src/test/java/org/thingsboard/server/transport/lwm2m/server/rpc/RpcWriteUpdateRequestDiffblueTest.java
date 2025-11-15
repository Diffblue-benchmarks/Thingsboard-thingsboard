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

class RpcWriteUpdateRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RpcWriteUpdateRequest#equals(Object)}
   *   <li>{@link RpcWriteUpdateRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RpcWriteUpdateRequest rpcWriteUpdateRequest = new RpcWriteUpdateRequest();
    rpcWriteUpdateRequest.setContentFormat("Not all who wander are lost");
    rpcWriteUpdateRequest.setId("42");
    rpcWriteUpdateRequest.setKey("Key");
    rpcWriteUpdateRequest.setValue("Value");

    RpcWriteUpdateRequest rpcWriteUpdateRequest2 = new RpcWriteUpdateRequest();
    rpcWriteUpdateRequest2.setContentFormat("Not all who wander are lost");
    rpcWriteUpdateRequest2.setId("42");
    rpcWriteUpdateRequest2.setKey("Key");
    rpcWriteUpdateRequest2.setValue("Value");

    // Act and Assert
    assertEquals(rpcWriteUpdateRequest, rpcWriteUpdateRequest2);
    int expectedHashCodeResult = rpcWriteUpdateRequest.hashCode();
    assertEquals(expectedHashCodeResult, rpcWriteUpdateRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RpcWriteUpdateRequest#equals(Object)}
   *   <li>{@link RpcWriteUpdateRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RpcWriteUpdateRequest rpcWriteUpdateRequest = new RpcWriteUpdateRequest();
    rpcWriteUpdateRequest.setContentFormat("Not all who wander are lost");
    rpcWriteUpdateRequest.setId("42");
    rpcWriteUpdateRequest.setKey("Key");
    rpcWriteUpdateRequest.setValue(null);

    RpcWriteUpdateRequest rpcWriteUpdateRequest2 = new RpcWriteUpdateRequest();
    rpcWriteUpdateRequest2.setContentFormat("Not all who wander are lost");
    rpcWriteUpdateRequest2.setId("42");
    rpcWriteUpdateRequest2.setKey("Key");
    rpcWriteUpdateRequest2.setValue(null);

    // Act and Assert
    assertEquals(rpcWriteUpdateRequest, rpcWriteUpdateRequest2);
    int expectedHashCodeResult = rpcWriteUpdateRequest.hashCode();
    assertEquals(expectedHashCodeResult, rpcWriteUpdateRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RpcWriteUpdateRequest#equals(Object)}
   *   <li>{@link RpcWriteUpdateRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RpcWriteUpdateRequest rpcWriteUpdateRequest = new RpcWriteUpdateRequest();
    rpcWriteUpdateRequest.setContentFormat("Not all who wander are lost");
    rpcWriteUpdateRequest.setId("42");
    rpcWriteUpdateRequest.setKey("Key");
    rpcWriteUpdateRequest.setValue("Value");

    // Act and Assert
    assertEquals(rpcWriteUpdateRequest, rpcWriteUpdateRequest);
    int expectedHashCodeResult = rpcWriteUpdateRequest.hashCode();
    assertEquals(expectedHashCodeResult, rpcWriteUpdateRequest.hashCode());
  }

  /**
   * Method under test: {@link RpcWriteUpdateRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RpcWriteUpdateRequest rpcWriteUpdateRequest = new RpcWriteUpdateRequest();
    rpcWriteUpdateRequest.setContentFormat("Key");
    rpcWriteUpdateRequest.setId("42");
    rpcWriteUpdateRequest.setKey("Key");
    rpcWriteUpdateRequest.setValue("Value");

    RpcWriteUpdateRequest rpcWriteUpdateRequest2 = new RpcWriteUpdateRequest();
    rpcWriteUpdateRequest2.setContentFormat("Not all who wander are lost");
    rpcWriteUpdateRequest2.setId("42");
    rpcWriteUpdateRequest2.setKey("Key");
    rpcWriteUpdateRequest2.setValue("Value");

    // Act and Assert
    assertNotEquals(rpcWriteUpdateRequest, rpcWriteUpdateRequest2);
  }

  /**
   * Method under test: {@link RpcWriteUpdateRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RpcWriteUpdateRequest rpcWriteUpdateRequest = new RpcWriteUpdateRequest();
    rpcWriteUpdateRequest.setContentFormat("Not all who wander are lost");
    rpcWriteUpdateRequest.setId("42");
    rpcWriteUpdateRequest.setKey("Key");
    rpcWriteUpdateRequest.setValue("Value");

    RpcWriteUpdateRequest rpcWriteUpdateRequest2 = new RpcWriteUpdateRequest();
    rpcWriteUpdateRequest2.setContentFormat("Not all who wander are lost");
    rpcWriteUpdateRequest2.setId("42");
    rpcWriteUpdateRequest2.setKey("Key");
    rpcWriteUpdateRequest2.setValue(rpcWriteUpdateRequest);

    RpcWriteUpdateRequest rpcWriteUpdateRequest3 = new RpcWriteUpdateRequest();
    rpcWriteUpdateRequest3.setContentFormat("Not all who wander are lost");
    rpcWriteUpdateRequest3.setId("42");
    rpcWriteUpdateRequest3.setKey("Key");
    rpcWriteUpdateRequest3.setValue("Value");

    // Act and Assert
    assertNotEquals(rpcWriteUpdateRequest2, rpcWriteUpdateRequest3);
  }

  /**
   * Method under test: {@link RpcWriteUpdateRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RpcWriteUpdateRequest rpcWriteUpdateRequest = new RpcWriteUpdateRequest();
    rpcWriteUpdateRequest.setContentFormat("Not all who wander are lost");
    rpcWriteUpdateRequest.setId("42");
    rpcWriteUpdateRequest.setKey("Key");
    rpcWriteUpdateRequest.setValue(null);

    RpcWriteUpdateRequest rpcWriteUpdateRequest2 = new RpcWriteUpdateRequest();
    rpcWriteUpdateRequest2.setContentFormat("Not all who wander are lost");
    rpcWriteUpdateRequest2.setId("42");
    rpcWriteUpdateRequest2.setKey("Key");
    rpcWriteUpdateRequest2.setValue("Value");

    // Act and Assert
    assertNotEquals(rpcWriteUpdateRequest, rpcWriteUpdateRequest2);
  }

  /**
   * Method under test: {@link RpcWriteUpdateRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RpcWriteUpdateRequest rpcWriteUpdateRequest = new RpcWriteUpdateRequest();
    rpcWriteUpdateRequest.setContentFormat("Not all who wander are lost");
    rpcWriteUpdateRequest.setId("42");
    rpcWriteUpdateRequest.setKey("Key");
    rpcWriteUpdateRequest.setValue(mock(LwM2MRpcRequestHeader.class));

    RpcWriteUpdateRequest rpcWriteUpdateRequest2 = new RpcWriteUpdateRequest();
    rpcWriteUpdateRequest2.setContentFormat("Not all who wander are lost");
    rpcWriteUpdateRequest2.setId("42");
    rpcWriteUpdateRequest2.setKey("Key");
    rpcWriteUpdateRequest2.setValue("Value");

    // Act and Assert
    assertNotEquals(rpcWriteUpdateRequest, rpcWriteUpdateRequest2);
  }

  /**
   * Method under test: {@link RpcWriteUpdateRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RpcWriteUpdateRequest rpcWriteUpdateRequest = new RpcWriteUpdateRequest();
    rpcWriteUpdateRequest.setContentFormat("Not all who wander are lost");
    rpcWriteUpdateRequest.setId("42");
    rpcWriteUpdateRequest.setKey("Key");
    rpcWriteUpdateRequest.setValue("Value");

    // Act and Assert
    assertNotEquals(rpcWriteUpdateRequest, null);
  }

  /**
   * Method under test: {@link RpcWriteUpdateRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RpcWriteUpdateRequest rpcWriteUpdateRequest = new RpcWriteUpdateRequest();
    rpcWriteUpdateRequest.setContentFormat("Not all who wander are lost");
    rpcWriteUpdateRequest.setId("42");
    rpcWriteUpdateRequest.setKey("Key");
    rpcWriteUpdateRequest.setValue("Value");

    // Act and Assert
    assertNotEquals(rpcWriteUpdateRequest, "Different type to RpcWriteUpdateRequest");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RpcWriteUpdateRequest}
   *   <li>{@link RpcWriteUpdateRequest#setContentFormat(String)}
   *   <li>{@link RpcWriteUpdateRequest#setValue(Object)}
   *   <li>{@link RpcWriteUpdateRequest#toString()}
   *   <li>{@link RpcWriteUpdateRequest#getContentFormat()}
   *   <li>{@link RpcWriteUpdateRequest#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RpcWriteUpdateRequest actualRpcWriteUpdateRequest = new RpcWriteUpdateRequest();
    actualRpcWriteUpdateRequest.setContentFormat("Not all who wander are lost");
    actualRpcWriteUpdateRequest.setValue("Value");
    String actualToStringResult = actualRpcWriteUpdateRequest.toString();
    String actualContentFormat = actualRpcWriteUpdateRequest.getContentFormat();

    // Assert that nothing has changed
    assertEquals("Not all who wander are lost", actualContentFormat);
    assertEquals("RpcWriteUpdateRequest(value=Value, contentFormat=Not all who wander are lost)", actualToStringResult);
    assertEquals("Value", actualRpcWriteUpdateRequest.getValue());
  }
}
