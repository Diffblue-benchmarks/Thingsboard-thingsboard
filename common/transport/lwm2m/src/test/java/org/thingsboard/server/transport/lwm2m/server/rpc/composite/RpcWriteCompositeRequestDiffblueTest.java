package org.thingsboard.server.transport.lwm2m.server.rpc.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RpcWriteCompositeRequestDiffblueTest {
  /**
   * Test {@link RpcWriteCompositeRequest#equals(Object)}, and
   * {@link RpcWriteCompositeRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcWriteCompositeRequest#equals(Object)}
   *   <li>{@link RpcWriteCompositeRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link RpcWriteCompositeRequest#equals(Object)}, and
   * {@link RpcWriteCompositeRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcWriteCompositeRequest#equals(Object)}
   *   <li>{@link RpcWriteCompositeRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * Test {@link RpcWriteCompositeRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcWriteCompositeRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link RpcWriteCompositeRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcWriteCompositeRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link RpcWriteCompositeRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcWriteCompositeRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RpcWriteCompositeRequest rpcWriteCompositeRequest = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest.setNodes(new HashMap<>());

    // Act and Assert
    assertNotEquals(rpcWriteCompositeRequest, null);
  }

  /**
   * Test {@link RpcWriteCompositeRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcWriteCompositeRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RpcWriteCompositeRequest rpcWriteCompositeRequest = new RpcWriteCompositeRequest();
    rpcWriteCompositeRequest.setNodes(new HashMap<>());

    // Act and Assert
    assertNotEquals(rpcWriteCompositeRequest, "Different type to RpcWriteCompositeRequest");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RpcWriteCompositeRequest}
   *   <li>{@link RpcWriteCompositeRequest#setNodes(Map)}
   *   <li>{@link RpcWriteCompositeRequest#toString()}
   *   <li>{@link RpcWriteCompositeRequest#getNodes()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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
