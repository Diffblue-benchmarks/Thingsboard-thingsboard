package org.thingsboard.server.common.msg.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.rpc.RpcError;

class FromDeviceRpcResponseDiffblueTest {
  /**
   * Test {@link FromDeviceRpcResponse#getResponse()}.
   *
   * <p>Method under test: {@link FromDeviceRpcResponse#getResponse()}
   */
  @Test
  @DisplayName("Test getResponse()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional FromDeviceRpcResponse.getResponse()"})
  void testGetResponse() {
    // Arrange and Act
    Optional<String> actualResponse =
        new FromDeviceRpcResponse(
                UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
                "Response",
                RpcError.NOT_FOUND)
            .getResponse();

    // Assert
    assertEquals("Response", actualResponse.get());
    assertTrue(actualResponse.isPresent());
  }

  /**
   * Test {@link FromDeviceRpcResponse#getError()}.
   *
   * <p>Method under test: {@link FromDeviceRpcResponse#getError()}
   */
  @Test
  @DisplayName("Test getError()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional FromDeviceRpcResponse.getError()"})
  void testGetError() {
    // Arrange and Act
    Optional<RpcError> actualError =
        new FromDeviceRpcResponse(
                UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
                "Response",
                RpcError.NOT_FOUND)
            .getError();

    // Assert
    assertEquals(RpcError.NOT_FOUND, actualError.get());
    assertTrue(actualError.isPresent());
  }

  /**
   * Test {@link FromDeviceRpcResponse#equals(Object)}, and {@link
   * FromDeviceRpcResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FromDeviceRpcResponse#equals(Object)}
   *   <li>{@link FromDeviceRpcResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean FromDeviceRpcResponse.equals(Object)",
    "int FromDeviceRpcResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FromDeviceRpcResponse fromDeviceRpcResponse =
        new FromDeviceRpcResponse(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "Response",
            RpcError.NOT_FOUND);
    FromDeviceRpcResponse fromDeviceRpcResponse2 =
        new FromDeviceRpcResponse(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "Response",
            RpcError.NOT_FOUND);

    // Act and Assert
    assertEquals(fromDeviceRpcResponse, fromDeviceRpcResponse2);
    int expectedHashCodeResult = fromDeviceRpcResponse.hashCode();
    assertEquals(expectedHashCodeResult, fromDeviceRpcResponse2.hashCode());
  }

  /**
   * Test {@link FromDeviceRpcResponse#equals(Object)}, and {@link
   * FromDeviceRpcResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FromDeviceRpcResponse#equals(Object)}
   *   <li>{@link FromDeviceRpcResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean FromDeviceRpcResponse.equals(Object)",
    "int FromDeviceRpcResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FromDeviceRpcResponse fromDeviceRpcResponse =
        new FromDeviceRpcResponse(null, "Response", RpcError.NOT_FOUND);
    FromDeviceRpcResponse fromDeviceRpcResponse2 =
        new FromDeviceRpcResponse(null, "Response", RpcError.NOT_FOUND);

    // Act and Assert
    assertEquals(fromDeviceRpcResponse, fromDeviceRpcResponse2);
    int expectedHashCodeResult = fromDeviceRpcResponse.hashCode();
    assertEquals(expectedHashCodeResult, fromDeviceRpcResponse2.hashCode());
  }

  /**
   * Test {@link FromDeviceRpcResponse#equals(Object)}, and {@link
   * FromDeviceRpcResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FromDeviceRpcResponse#equals(Object)}
   *   <li>{@link FromDeviceRpcResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean FromDeviceRpcResponse.equals(Object)",
    "int FromDeviceRpcResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FromDeviceRpcResponse fromDeviceRpcResponse =
        new FromDeviceRpcResponse(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "Response",
            RpcError.NOT_FOUND);

    // Act and Assert
    assertEquals(fromDeviceRpcResponse, fromDeviceRpcResponse);
    int expectedHashCodeResult = fromDeviceRpcResponse.hashCode();
    assertEquals(expectedHashCodeResult, fromDeviceRpcResponse.hashCode());
  }

  /**
   * Test {@link FromDeviceRpcResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FromDeviceRpcResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean FromDeviceRpcResponse.equals(Object)",
    "int FromDeviceRpcResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FromDeviceRpcResponse fromDeviceRpcResponse =
        new FromDeviceRpcResponse(UUID.randomUUID(), "Response", RpcError.NOT_FOUND);

    // Act and Assert
    assertNotEquals(
        fromDeviceRpcResponse,
        new FromDeviceRpcResponse(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "Response",
            RpcError.NOT_FOUND));
  }

  /**
   * Test {@link FromDeviceRpcResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FromDeviceRpcResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean FromDeviceRpcResponse.equals(Object)",
    "int FromDeviceRpcResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FromDeviceRpcResponse fromDeviceRpcResponse =
        new FromDeviceRpcResponse(null, "Response", RpcError.NOT_FOUND);

    // Act and Assert
    assertNotEquals(
        fromDeviceRpcResponse,
        new FromDeviceRpcResponse(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "Response",
            RpcError.NOT_FOUND));
  }

  /**
   * Test {@link FromDeviceRpcResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FromDeviceRpcResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean FromDeviceRpcResponse.equals(Object)",
    "int FromDeviceRpcResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    FromDeviceRpcResponse fromDeviceRpcResponse =
        new FromDeviceRpcResponse(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), null, RpcError.NOT_FOUND);

    // Act and Assert
    assertNotEquals(
        fromDeviceRpcResponse,
        new FromDeviceRpcResponse(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "Response",
            RpcError.NOT_FOUND));
  }

  /**
   * Test {@link FromDeviceRpcResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FromDeviceRpcResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean FromDeviceRpcResponse.equals(Object)",
    "int FromDeviceRpcResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    FromDeviceRpcResponse fromDeviceRpcResponse =
        new FromDeviceRpcResponse(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Response", null);

    // Act and Assert
    assertNotEquals(
        fromDeviceRpcResponse,
        new FromDeviceRpcResponse(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "Response",
            RpcError.NOT_FOUND));
  }

  /**
   * Test {@link FromDeviceRpcResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FromDeviceRpcResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean FromDeviceRpcResponse.equals(Object)",
    "int FromDeviceRpcResponse.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new FromDeviceRpcResponse(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "Response",
            RpcError.NOT_FOUND),
        null);
  }

  /**
   * Test {@link FromDeviceRpcResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FromDeviceRpcResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean FromDeviceRpcResponse.equals(Object)",
    "int FromDeviceRpcResponse.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new FromDeviceRpcResponse(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "Response",
            RpcError.NOT_FOUND),
        "Different type to FromDeviceRpcResponse");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FromDeviceRpcResponse#FromDeviceRpcResponse(UUID, String, RpcError)}
   *   <li>{@link FromDeviceRpcResponse#toString()}
   *   <li>{@link FromDeviceRpcResponse#getId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void FromDeviceRpcResponse.<init>(UUID, String, RpcError)",
    "UUID FromDeviceRpcResponse.getId()",
    "String FromDeviceRpcResponse.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    FromDeviceRpcResponse actualFromDeviceRpcResponse =
        new FromDeviceRpcResponse(id, "Response", RpcError.NOT_FOUND);
    String actualToStringResult = actualFromDeviceRpcResponse.toString();
    UUID actualId = actualFromDeviceRpcResponse.getId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualId.toString());
    assertEquals(
        "FromDeviceRpcResponse(id=784f394c-42b6-435a-983c-b7beff2784f9, response=Optional[Response],"
            + " error=Optional[NOT_FOUND])",
        actualToStringResult);
    assertSame(id, actualId);
  }
}
