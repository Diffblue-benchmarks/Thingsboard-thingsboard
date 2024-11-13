package org.thingsboard.server.transport.lwm2m.server.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RpcWriteUpdateRequestDiffblueTest {
  /**
   * Test {@link RpcWriteUpdateRequest#equals(Object)}, and
   * {@link RpcWriteUpdateRequest#hashCode()}.
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
   * Test {@link RpcWriteUpdateRequest#equals(Object)}, and
   * {@link RpcWriteUpdateRequest#hashCode()}.
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
   * Test {@link RpcWriteUpdateRequest#equals(Object)}, and
   * {@link RpcWriteUpdateRequest#hashCode()}.
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
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcWriteUpdateRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
