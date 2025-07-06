package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RpcRequestMetadataDiffblueTest {
  /**
   * Test {@link RpcRequestMetadata#equals(Object)}, and {@link RpcRequestMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RpcRequestMetadata#equals(Object)}
   *   <li>{@link RpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RpcRequestMetadata.equals(Object)",
    "int RpcRequestMetadata.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata =
        new RpcRequestMetadata(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1);
    RpcRequestMetadata rpcRequestMetadata2 =
        new RpcRequestMetadata(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1);

    // Act and Assert
    assertEquals(rpcRequestMetadata, rpcRequestMetadata2);
    int expectedHashCodeResult = rpcRequestMetadata.hashCode();
    assertEquals(expectedHashCodeResult, rpcRequestMetadata2.hashCode());
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}, and {@link RpcRequestMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RpcRequestMetadata#equals(Object)}
   *   <li>{@link RpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RpcRequestMetadata.equals(Object)",
    "int RpcRequestMetadata.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(null, 1);
    RpcRequestMetadata rpcRequestMetadata2 = new RpcRequestMetadata(null, 1);

    // Act and Assert
    assertEquals(rpcRequestMetadata, rpcRequestMetadata2);
    int expectedHashCodeResult = rpcRequestMetadata.hashCode();
    assertEquals(expectedHashCodeResult, rpcRequestMetadata2.hashCode());
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}, and {@link RpcRequestMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RpcRequestMetadata#equals(Object)}
   *   <li>{@link RpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RpcRequestMetadata.equals(Object)",
    "int RpcRequestMetadata.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata =
        new RpcRequestMetadata(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1);

    // Act and Assert
    assertEquals(rpcRequestMetadata, rpcRequestMetadata);
    int expectedHashCodeResult = rpcRequestMetadata.hashCode();
    assertEquals(expectedHashCodeResult, rpcRequestMetadata.hashCode());
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RpcRequestMetadata.equals(Object)",
    "int RpcRequestMetadata.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(UUID.randomUUID(), 1);

    // Act and Assert
    assertNotEquals(
        rpcRequestMetadata,
        new RpcRequestMetadata(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1));
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RpcRequestMetadata.equals(Object)",
    "int RpcRequestMetadata.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(null, 1);

    // Act and Assert
    assertNotEquals(
        rpcRequestMetadata,
        new RpcRequestMetadata(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1));
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RpcRequestMetadata.equals(Object)",
    "int RpcRequestMetadata.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata =
        new RpcRequestMetadata(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 2);

    // Act and Assert
    assertNotEquals(
        rpcRequestMetadata,
        new RpcRequestMetadata(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1));
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RpcRequestMetadata.equals(Object)",
    "int RpcRequestMetadata.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new RpcRequestMetadata(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1), null);
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RpcRequestMetadata.equals(Object)",
    "int RpcRequestMetadata.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new RpcRequestMetadata(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1),
        "Different type to RpcRequestMetadata");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RpcRequestMetadata#RpcRequestMetadata(UUID, int)}
   *   <li>{@link RpcRequestMetadata#toString()}
   *   <li>{@link RpcRequestMetadata#getRequestId()}
   *   <li>{@link RpcRequestMetadata#getSessionId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void RpcRequestMetadata.<init>(UUID, int)",
    "int RpcRequestMetadata.getRequestId()",
    "UUID RpcRequestMetadata.getSessionId()",
    "String RpcRequestMetadata.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    RpcRequestMetadata actualRpcRequestMetadata = new RpcRequestMetadata(sessionId, 1);
    String actualToStringResult = actualRpcRequestMetadata.toString();
    int actualRequestId = actualRpcRequestMetadata.getRequestId();
    UUID actualSessionId = actualRpcRequestMetadata.getSessionId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualSessionId.toString());
    assertEquals(
        "RpcRequestMetadata(sessionId=784f394c-42b6-435a-983c-b7beff2784f9, requestId=1)",
        actualToStringResult);
    assertEquals(1, actualRequestId);
    assertSame(sessionId, actualSessionId);
  }
}
