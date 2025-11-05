package org.thingsboard.server.transport.lwm2m.server.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.profile.lwm2m.ObjectAttributes;

class RpcWriteAttributesRequestDiffblueTest {
  /**
   * Test {@link RpcWriteAttributesRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcWriteAttributesRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RpcWriteAttributesRequest.equals(Object)",
    "int RpcWriteAttributesRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ObjectAttributes attributes = new ObjectAttributes();
    attributes.setDim(3L);
    attributes.setEpmax(1L);
    attributes.setEpmin(1L);
    attributes.setGt(10.0d);
    attributes.setLt(10.0d);
    attributes.setLwm2m("Lwm2m");
    attributes.setPmax(1L);
    attributes.setPmin(1L);
    attributes.setSsid(1L);
    attributes.setSt(10.0d);
    attributes.setUri("Uri");
    attributes.setVer("Ver");

    RpcWriteAttributesRequest rpcWriteAttributesRequest = new RpcWriteAttributesRequest();
    rpcWriteAttributesRequest.setAttributes(attributes);
    rpcWriteAttributesRequest.setContentFormat("Not all who wander are lost");
    rpcWriteAttributesRequest.setId("42");
    rpcWriteAttributesRequest.setKey("Key");

    ObjectAttributes attributes2 = new ObjectAttributes();
    attributes2.setDim(1L);
    attributes2.setEpmax(1L);
    attributes2.setEpmin(1L);
    attributes2.setGt(10.0d);
    attributes2.setLt(10.0d);
    attributes2.setLwm2m("Lwm2m");
    attributes2.setPmax(1L);
    attributes2.setPmin(1L);
    attributes2.setSsid(1L);
    attributes2.setSt(10.0d);
    attributes2.setUri("Uri");
    attributes2.setVer("Ver");

    RpcWriteAttributesRequest rpcWriteAttributesRequest2 = new RpcWriteAttributesRequest();
    rpcWriteAttributesRequest2.setAttributes(attributes2);
    rpcWriteAttributesRequest2.setContentFormat("Not all who wander are lost");
    rpcWriteAttributesRequest2.setId("42");
    rpcWriteAttributesRequest2.setKey("Key");

    // Act and Assert
    assertNotEquals(rpcWriteAttributesRequest, rpcWriteAttributesRequest2);
  }

  /**
   * Test {@link RpcWriteAttributesRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcWriteAttributesRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RpcWriteAttributesRequest.equals(Object)",
    "int RpcWriteAttributesRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ObjectAttributes attributes = new ObjectAttributes();
    attributes.setDim(1L);
    attributes.setEpmax(1L);
    attributes.setEpmin(1L);
    attributes.setGt(10.0d);
    attributes.setLt(10.0d);
    attributes.setLwm2m("Lwm2m");
    attributes.setPmax(1L);
    attributes.setPmin(1L);
    attributes.setSsid(1L);
    attributes.setSt(10.0d);
    attributes.setUri("Uri");
    attributes.setVer("Ver");

    RpcWriteAttributesRequest rpcWriteAttributesRequest = new RpcWriteAttributesRequest();
    rpcWriteAttributesRequest.setAttributes(attributes);
    rpcWriteAttributesRequest.setContentFormat("Key");
    rpcWriteAttributesRequest.setId("42");
    rpcWriteAttributesRequest.setKey("Key");

    ObjectAttributes attributes2 = new ObjectAttributes();
    attributes2.setDim(1L);
    attributes2.setEpmax(1L);
    attributes2.setEpmin(1L);
    attributes2.setGt(10.0d);
    attributes2.setLt(10.0d);
    attributes2.setLwm2m("Lwm2m");
    attributes2.setPmax(1L);
    attributes2.setPmin(1L);
    attributes2.setSsid(1L);
    attributes2.setSt(10.0d);
    attributes2.setUri("Uri");
    attributes2.setVer("Ver");

    RpcWriteAttributesRequest rpcWriteAttributesRequest2 = new RpcWriteAttributesRequest();
    rpcWriteAttributesRequest2.setAttributes(attributes2);
    rpcWriteAttributesRequest2.setContentFormat("Not all who wander are lost");
    rpcWriteAttributesRequest2.setId("42");
    rpcWriteAttributesRequest2.setKey("Key");

    // Act and Assert
    assertNotEquals(rpcWriteAttributesRequest, rpcWriteAttributesRequest2);
  }

  /**
   * Test {@link RpcWriteAttributesRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcWriteAttributesRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RpcWriteAttributesRequest.equals(Object)",
    "int RpcWriteAttributesRequest.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ObjectAttributes attributes = new ObjectAttributes();
    attributes.setDim(1L);
    attributes.setEpmax(1L);
    attributes.setEpmin(1L);
    attributes.setGt(10.0d);
    attributes.setLt(10.0d);
    attributes.setLwm2m("Lwm2m");
    attributes.setPmax(1L);
    attributes.setPmin(1L);
    attributes.setSsid(1L);
    attributes.setSt(10.0d);
    attributes.setUri("Uri");
    attributes.setVer("Ver");

    RpcWriteAttributesRequest rpcWriteAttributesRequest = new RpcWriteAttributesRequest();
    rpcWriteAttributesRequest.setAttributes(attributes);
    rpcWriteAttributesRequest.setContentFormat("Not all who wander are lost");
    rpcWriteAttributesRequest.setId("42");
    rpcWriteAttributesRequest.setKey("Key");

    // Act and Assert
    assertNotEquals(rpcWriteAttributesRequest, null);
  }

  /**
   * Test {@link RpcWriteAttributesRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcWriteAttributesRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RpcWriteAttributesRequest.equals(Object)",
    "int RpcWriteAttributesRequest.hashCode()"
  })
  void testEquals_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ObjectAttributes attributes = new ObjectAttributes();
    attributes.setDim(1L);
    attributes.setEpmax(1L);
    attributes.setEpmin(1L);
    attributes.setGt(10.0d);
    attributes.setLt(10.0d);
    attributes.setLwm2m("Lwm2m");
    attributes.setPmax(1L);
    attributes.setPmin(1L);
    attributes.setSsid(1L);
    attributes.setSt(10.0d);
    attributes.setUri("Uri");
    attributes.setVer("Ver");

    RpcWriteAttributesRequest rpcWriteAttributesRequest = new RpcWriteAttributesRequest();
    rpcWriteAttributesRequest.setAttributes(attributes);
    rpcWriteAttributesRequest.setContentFormat("Not all who wander are lost");
    rpcWriteAttributesRequest.setId("42");
    rpcWriteAttributesRequest.setKey("Key");

    // Act and Assert
    assertEquals(rpcWriteAttributesRequest, rpcWriteAttributesRequest);
  }

  /**
   * Test {@link RpcWriteAttributesRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcWriteAttributesRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RpcWriteAttributesRequest.equals(Object)",
    "int RpcWriteAttributesRequest.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ObjectAttributes attributes = new ObjectAttributes();
    attributes.setDim(1L);
    attributes.setEpmax(1L);
    attributes.setEpmin(1L);
    attributes.setGt(10.0d);
    attributes.setLt(10.0d);
    attributes.setLwm2m("Lwm2m");
    attributes.setPmax(1L);
    attributes.setPmin(1L);
    attributes.setSsid(1L);
    attributes.setSt(10.0d);
    attributes.setUri("Uri");
    attributes.setVer("Ver");

    RpcWriteAttributesRequest rpcWriteAttributesRequest = new RpcWriteAttributesRequest();
    rpcWriteAttributesRequest.setAttributes(attributes);
    rpcWriteAttributesRequest.setContentFormat("Not all who wander are lost");
    rpcWriteAttributesRequest.setId("42");
    rpcWriteAttributesRequest.setKey("Key");

    // Act and Assert
    assertNotEquals(rpcWriteAttributesRequest, "Different type to RpcWriteAttributesRequest");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RpcWriteAttributesRequest}
   *   <li>{@link RpcWriteAttributesRequest#setAttributes(ObjectAttributes)}
   *   <li>{@link RpcWriteAttributesRequest#getAttributes()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RpcWriteAttributesRequest.<init>()",
    "ObjectAttributes RpcWriteAttributesRequest.getAttributes()",
    "void RpcWriteAttributesRequest.setAttributes(ObjectAttributes)",
    "java.lang.String RpcWriteAttributesRequest.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RpcWriteAttributesRequest actualRpcWriteAttributesRequest = new RpcWriteAttributesRequest();
    ObjectAttributes attributes = new ObjectAttributes();
    attributes.setDim(1L);
    attributes.setEpmax(1L);
    attributes.setEpmin(1L);
    attributes.setGt(10.0d);
    attributes.setLt(10.0d);
    attributes.setLwm2m("Lwm2m");
    attributes.setPmax(1L);
    attributes.setPmin(1L);
    attributes.setSsid(1L);
    attributes.setSt(10.0d);
    attributes.setUri("Uri");
    attributes.setVer("Ver");
    actualRpcWriteAttributesRequest.setAttributes(attributes);
    ObjectAttributes actualAttributes = actualRpcWriteAttributesRequest.getAttributes();

    // Assert
    assertNull(actualRpcWriteAttributesRequest.getContentFormat());
    assertNull(actualRpcWriteAttributesRequest.getId());
    assertNull(actualRpcWriteAttributesRequest.getKey());
    assertSame(attributes, actualAttributes);
  }
}
