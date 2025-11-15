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
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RpcWriteUpdateRequestDiffblueTest {
  /**
   * Test {@link RpcWriteUpdateRequest#equals(Object)}, and {@link RpcWriteUpdateRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcWriteUpdateRequest#equals(Object)}
   *   <li>{@link RpcWriteUpdateRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcWriteUpdateRequest.equals(Object)", "int RpcWriteUpdateRequest.hashCode()"})
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
   * Test {@link RpcWriteUpdateRequest#equals(Object)}, and {@link RpcWriteUpdateRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcWriteUpdateRequest#equals(Object)}
   *   <li>{@link RpcWriteUpdateRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcWriteUpdateRequest.equals(Object)", "int RpcWriteUpdateRequest.hashCode()"})
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
   * Test {@link RpcWriteUpdateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcWriteUpdateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcWriteUpdateRequest.equals(Object)", "int RpcWriteUpdateRequest.hashCode()"})
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
   * Test {@link RpcWriteUpdateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcWriteUpdateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcWriteUpdateRequest.equals(Object)", "int RpcWriteUpdateRequest.hashCode()"})
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
   * Test {@link RpcWriteUpdateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcWriteUpdateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcWriteUpdateRequest.equals(Object)", "int RpcWriteUpdateRequest.hashCode()"})
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
   * Test {@link RpcWriteUpdateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcWriteUpdateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcWriteUpdateRequest.equals(Object)", "int RpcWriteUpdateRequest.hashCode()"})
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
   * Test {@link RpcWriteUpdateRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcWriteUpdateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcWriteUpdateRequest.equals(Object)", "int RpcWriteUpdateRequest.hashCode()"})
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RpcWriteUpdateRequest.<init>()", "String RpcWriteUpdateRequest.getContentFormat()",
      "Object RpcWriteUpdateRequest.getValue()", "void RpcWriteUpdateRequest.setContentFormat(String)",
      "void RpcWriteUpdateRequest.setValue(Object)", "String RpcWriteUpdateRequest.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    RpcWriteUpdateRequest actualRpcWriteUpdateRequest = new RpcWriteUpdateRequest();
    actualRpcWriteUpdateRequest.setContentFormat("Not all who wander are lost");
    actualRpcWriteUpdateRequest.setValue("Value");
    String actualToStringResult = actualRpcWriteUpdateRequest.toString();
    String actualContentFormat = actualRpcWriteUpdateRequest.getContentFormat();

    // Assert
    assertEquals("Not all who wander are lost", actualContentFormat);
    assertEquals("RpcWriteUpdateRequest(value=Value, contentFormat=Not all who wander are lost)", actualToStringResult);
    assertEquals("Value", actualRpcWriteUpdateRequest.getValue());
    assertNull(actualRpcWriteUpdateRequest.getId());
    assertNull(actualRpcWriteUpdateRequest.getKey());
  }
}
