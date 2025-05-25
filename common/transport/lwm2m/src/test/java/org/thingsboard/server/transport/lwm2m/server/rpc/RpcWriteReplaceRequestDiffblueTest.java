package org.thingsboard.server.transport.lwm2m.server.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RpcWriteReplaceRequestDiffblueTest {
  /**
   * Test {@link RpcWriteReplaceRequest#equals(Object)}, and {@link RpcWriteReplaceRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcWriteReplaceRequest#equals(Object)}
   *   <li>{@link RpcWriteReplaceRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcWriteReplaceRequest.equals(Object)", "int RpcWriteReplaceRequest.hashCode()"})
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
   * Test {@link RpcWriteReplaceRequest#equals(Object)}, and {@link RpcWriteReplaceRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcWriteReplaceRequest#equals(Object)}
   *   <li>{@link RpcWriteReplaceRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcWriteReplaceRequest.equals(Object)", "int RpcWriteReplaceRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
    rpcWriteReplaceRequest2.setValue(null);

    // Act and Assert
    assertEquals(rpcWriteReplaceRequest, rpcWriteReplaceRequest2);
    int expectedHashCodeResult = rpcWriteReplaceRequest.hashCode();
    assertEquals(expectedHashCodeResult, rpcWriteReplaceRequest2.hashCode());
  }

  /**
   * Test {@link RpcWriteReplaceRequest#equals(Object)}, and {@link RpcWriteReplaceRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcWriteReplaceRequest#equals(Object)}
   *   <li>{@link RpcWriteReplaceRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcWriteReplaceRequest.equals(Object)", "int RpcWriteReplaceRequest.hashCode()"})
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
   * Test {@link RpcWriteReplaceRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcWriteReplaceRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcWriteReplaceRequest.equals(Object)", "int RpcWriteReplaceRequest.hashCode()"})
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
   * Test {@link RpcWriteReplaceRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcWriteReplaceRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcWriteReplaceRequest.equals(Object)", "int RpcWriteReplaceRequest.hashCode()"})
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
   * Test {@link RpcWriteReplaceRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcWriteReplaceRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcWriteReplaceRequest.equals(Object)", "int RpcWriteReplaceRequest.hashCode()"})
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
   * Test {@link RpcWriteReplaceRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcWriteReplaceRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcWriteReplaceRequest.equals(Object)", "int RpcWriteReplaceRequest.hashCode()"})
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
   * Test {@link RpcWriteReplaceRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcWriteReplaceRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RpcWriteReplaceRequest.equals(Object)", "int RpcWriteReplaceRequest.hashCode()"})
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link RpcWriteReplaceRequest}
   *   <li>{@link RpcWriteReplaceRequest#setValue(Object)}
   *   <li>{@link RpcWriteReplaceRequest#toString()}
   *   <li>{@link RpcWriteReplaceRequest#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RpcWriteReplaceRequest.<init>()", "Object RpcWriteReplaceRequest.getValue()",
      "void RpcWriteReplaceRequest.setValue(Object)", "String RpcWriteReplaceRequest.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    RpcWriteReplaceRequest actualRpcWriteReplaceRequest = new RpcWriteReplaceRequest();
    actualRpcWriteReplaceRequest.setValue("Value");
    String actualToStringResult = actualRpcWriteReplaceRequest.toString();

    // Assert
    assertEquals("RpcWriteReplaceRequest(value=Value)", actualToStringResult);
    assertEquals("Value", actualRpcWriteReplaceRequest.getValue());
    assertNull(actualRpcWriteReplaceRequest.getContentFormat());
    assertNull(actualRpcWriteReplaceRequest.getId());
    assertNull(actualRpcWriteReplaceRequest.getKey());
  }
}
