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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RpcCreateRequestDiffblueTest {
  /**
   * Test {@link RpcCreateRequest#equals(Object)}, and {@link RpcCreateRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RpcCreateRequest#equals(Object)}
   *   <li>{@link RpcCreateRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RpcCreateRequest.equals(Object)", "int RpcCreateRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RpcCreateRequest rpcCreateRequest = new RpcCreateRequest();
    rpcCreateRequest.setContentFormat("Not all who wander are lost");
    rpcCreateRequest.setId("42");
    rpcCreateRequest.setKey("Key");
    rpcCreateRequest.setNodes(new HashMap<>());
    rpcCreateRequest.setValue("Value");

    RpcCreateRequest rpcCreateRequest2 = new RpcCreateRequest();
    rpcCreateRequest2.setContentFormat("Not all who wander are lost");
    rpcCreateRequest2.setId("42");
    rpcCreateRequest2.setKey("Key");
    rpcCreateRequest2.setNodes(new HashMap<>());
    rpcCreateRequest2.setValue("Value");

    // Act and Assert
    assertEquals(rpcCreateRequest, rpcCreateRequest2);
    assertEquals(rpcCreateRequest.hashCode(), rpcCreateRequest2.hashCode());
  }

  /**
   * Test {@link RpcCreateRequest#equals(Object)}, and {@link RpcCreateRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RpcCreateRequest#equals(Object)}
   *   <li>{@link RpcCreateRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RpcCreateRequest.equals(Object)", "int RpcCreateRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RpcCreateRequest rpcCreateRequest = new RpcCreateRequest();
    rpcCreateRequest.setContentFormat("Not all who wander are lost");
    rpcCreateRequest.setId("42");
    rpcCreateRequest.setKey("Key");
    rpcCreateRequest.setNodes(new HashMap<>());
    rpcCreateRequest.setValue(null);

    RpcCreateRequest rpcCreateRequest2 = new RpcCreateRequest();
    rpcCreateRequest2.setContentFormat("Not all who wander are lost");
    rpcCreateRequest2.setId("42");
    rpcCreateRequest2.setKey("Key");
    rpcCreateRequest2.setNodes(new HashMap<>());
    rpcCreateRequest2.setValue(null);

    // Act and Assert
    assertEquals(rpcCreateRequest, rpcCreateRequest2);
    assertEquals(rpcCreateRequest.hashCode(), rpcCreateRequest2.hashCode());
  }

  /**
   * Test {@link RpcCreateRequest#equals(Object)}, and {@link RpcCreateRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RpcCreateRequest#equals(Object)}
   *   <li>{@link RpcCreateRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RpcCreateRequest.equals(Object)", "int RpcCreateRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RpcCreateRequest rpcCreateRequest = new RpcCreateRequest();
    rpcCreateRequest.setContentFormat("Not all who wander are lost");
    rpcCreateRequest.setId("42");
    rpcCreateRequest.setKey("Key");
    rpcCreateRequest.setNodes(new HashMap<>());
    rpcCreateRequest.setValue("Value");

    // Act and Assert
    assertEquals(rpcCreateRequest, rpcCreateRequest);
    int expectedHashCodeResult = rpcCreateRequest.hashCode();
    assertEquals(expectedHashCodeResult, rpcCreateRequest.hashCode());
  }

  /**
   * Test {@link RpcCreateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RpcCreateRequest.equals(Object)", "int RpcCreateRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RpcCreateRequest rpcCreateRequest = new RpcCreateRequest();
    rpcCreateRequest.setContentFormat("Key");
    rpcCreateRequest.setId("42");
    rpcCreateRequest.setKey("Key");
    rpcCreateRequest.setNodes(new HashMap<>());
    rpcCreateRequest.setValue("Value");

    RpcCreateRequest rpcCreateRequest2 = new RpcCreateRequest();
    rpcCreateRequest2.setContentFormat("Not all who wander are lost");
    rpcCreateRequest2.setId("42");
    rpcCreateRequest2.setKey("Key");
    rpcCreateRequest2.setNodes(new HashMap<>());
    rpcCreateRequest2.setValue("Value");

    // Act and Assert
    assertNotEquals(rpcCreateRequest, rpcCreateRequest2);
  }

  /**
   * Test {@link RpcCreateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RpcCreateRequest.equals(Object)", "int RpcCreateRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<String, Object> nodes = new HashMap<>();
    nodes.put("Key", "42");

    RpcCreateRequest rpcCreateRequest = new RpcCreateRequest();
    rpcCreateRequest.setContentFormat("Not all who wander are lost");
    rpcCreateRequest.setId("42");
    rpcCreateRequest.setKey("Key");
    rpcCreateRequest.setNodes(nodes);
    rpcCreateRequest.setValue("Value");

    RpcCreateRequest rpcCreateRequest2 = new RpcCreateRequest();
    rpcCreateRequest2.setContentFormat("Not all who wander are lost");
    rpcCreateRequest2.setId("42");
    rpcCreateRequest2.setKey("Key");
    rpcCreateRequest2.setNodes(new HashMap<>());
    rpcCreateRequest2.setValue("Value");

    // Act and Assert
    assertNotEquals(rpcCreateRequest, rpcCreateRequest2);
  }

  /**
   * Test {@link RpcCreateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RpcCreateRequest.equals(Object)", "int RpcCreateRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RpcCreateRequest rpcCreateRequest = new RpcCreateRequest();
    rpcCreateRequest.setContentFormat("Not all who wander are lost");
    rpcCreateRequest.setId("42");
    rpcCreateRequest.setKey("Key");
    rpcCreateRequest.setNodes(new HashMap<>());
    rpcCreateRequest.setValue("Value");

    RpcCreateRequest rpcCreateRequest2 = new RpcCreateRequest();
    rpcCreateRequest2.setContentFormat("Not all who wander are lost");
    rpcCreateRequest2.setId("42");
    rpcCreateRequest2.setKey("Key");
    rpcCreateRequest2.setNodes(new HashMap<>());
    rpcCreateRequest2.setValue(rpcCreateRequest);

    RpcCreateRequest rpcCreateRequest3 = new RpcCreateRequest();
    rpcCreateRequest3.setContentFormat("Not all who wander are lost");
    rpcCreateRequest3.setId("42");
    rpcCreateRequest3.setKey("Key");
    rpcCreateRequest3.setNodes(new HashMap<>());
    rpcCreateRequest3.setValue("Value");

    // Act and Assert
    assertNotEquals(rpcCreateRequest2, rpcCreateRequest3);
  }

  /**
   * Test {@link RpcCreateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RpcCreateRequest.equals(Object)", "int RpcCreateRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RpcCreateRequest rpcCreateRequest = new RpcCreateRequest();
    rpcCreateRequest.setContentFormat("Not all who wander are lost");
    rpcCreateRequest.setId("42");
    rpcCreateRequest.setKey("Key");
    rpcCreateRequest.setNodes(new HashMap<>());
    rpcCreateRequest.setValue(null);

    RpcCreateRequest rpcCreateRequest2 = new RpcCreateRequest();
    rpcCreateRequest2.setContentFormat("Not all who wander are lost");
    rpcCreateRequest2.setId("42");
    rpcCreateRequest2.setKey("Key");
    rpcCreateRequest2.setNodes(new HashMap<>());
    rpcCreateRequest2.setValue("Value");

    // Act and Assert
    assertNotEquals(rpcCreateRequest, rpcCreateRequest2);
  }

  /**
   * Test {@link RpcCreateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RpcCreateRequest.equals(Object)", "int RpcCreateRequest.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RpcCreateRequest rpcCreateRequest = new RpcCreateRequest();
    rpcCreateRequest.setContentFormat("Not all who wander are lost");
    rpcCreateRequest.setId("42");
    rpcCreateRequest.setKey("Key");
    rpcCreateRequest.setNodes(new HashMap<>());
    rpcCreateRequest.setValue("Value");

    // Act and Assert
    assertNotEquals(rpcCreateRequest, null);
  }

  /**
   * Test {@link RpcCreateRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcCreateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RpcCreateRequest.equals(Object)", "int RpcCreateRequest.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RpcCreateRequest rpcCreateRequest = new RpcCreateRequest();
    rpcCreateRequest.setContentFormat("Not all who wander are lost");
    rpcCreateRequest.setId("42");
    rpcCreateRequest.setKey("Key");
    rpcCreateRequest.setNodes(new HashMap<>());
    rpcCreateRequest.setValue("Value");

    // Act and Assert
    assertNotEquals(rpcCreateRequest, "Different type to RpcCreateRequest");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RpcCreateRequest}
   *   <li>{@link RpcCreateRequest#setContentFormat(String)}
   *   <li>{@link RpcCreateRequest#setNodes(Map)}
   *   <li>{@link RpcCreateRequest#setValue(Object)}
   *   <li>{@link RpcCreateRequest#toString()}
   *   <li>{@link RpcCreateRequest#getContentFormat()}
   *   <li>{@link RpcCreateRequest#getNodes()}
   *   <li>{@link RpcCreateRequest#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcCreateRequest.<init>()",
    "String RpcCreateRequest.getContentFormat()",
    "Map RpcCreateRequest.getNodes()",
    "Object RpcCreateRequest.getValue()",
    "void RpcCreateRequest.setContentFormat(String)",
    "void RpcCreateRequest.setNodes(Map)",
    "void RpcCreateRequest.setValue(Object)",
    "String RpcCreateRequest.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RpcCreateRequest actualRpcCreateRequest = new RpcCreateRequest();
    actualRpcCreateRequest.setContentFormat("Not all who wander are lost");
    HashMap<String, Object> nodes = new HashMap<>();
    actualRpcCreateRequest.setNodes(nodes);
    actualRpcCreateRequest.setValue("Value");
    String actualToStringResult = actualRpcCreateRequest.toString();
    String actualContentFormat = actualRpcCreateRequest.getContentFormat();
    Map<String, Object> actualNodes = actualRpcCreateRequest.getNodes();

    // Assert
    assertEquals("Not all who wander are lost", actualContentFormat);
    assertEquals(
        "RpcCreateRequest(value=Value, contentFormat=Not all who wander are lost, nodes={})",
        actualToStringResult);
    assertEquals("Value", actualRpcCreateRequest.getValue());
    assertNull(actualRpcCreateRequest.getId());
    assertNull(actualRpcCreateRequest.getKey());
    assertTrue(actualNodes.isEmpty());
    assertSame(nodes, actualNodes);
  }
}
