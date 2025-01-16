package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RpcRequestMetadataDiffblueTest {
  /**
   * Test {@link RpcRequestMetadata#equals(Object)}, and
   * {@link RpcRequestMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcRequestMetadata#equals(Object)}
   *   <li>{@link RpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(null, 1);
    RpcRequestMetadata rpcRequestMetadata2 = new RpcRequestMetadata(null, 1);

    // Act and Assert
    assertEquals(rpcRequestMetadata, rpcRequestMetadata2);
    int expectedHashCodeResult = rpcRequestMetadata.hashCode();
    assertEquals(expectedHashCodeResult, rpcRequestMetadata2.hashCode());
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}, and
   * {@link RpcRequestMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcRequestMetadata#equals(Object)}
   *   <li>{@link RpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(new UUID(1L, 1L), 1);
    RpcRequestMetadata rpcRequestMetadata2 = new RpcRequestMetadata(new UUID(1L, 1L), 1);

    // Act and Assert
    assertEquals(rpcRequestMetadata, rpcRequestMetadata2);
    int expectedHashCodeResult = rpcRequestMetadata.hashCode();
    assertEquals(expectedHashCodeResult, rpcRequestMetadata2.hashCode());
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}, and
   * {@link RpcRequestMetadata#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcRequestMetadata#equals(Object)}
   *   <li>{@link RpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(UUID.randomUUID(), 1);

    // Act and Assert
    assertEquals(rpcRequestMetadata, rpcRequestMetadata);
    int expectedHashCodeResult = rpcRequestMetadata.hashCode();
    assertEquals(expectedHashCodeResult, rpcRequestMetadata.hashCode());
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(UUID.randomUUID(), 1);

    // Act and Assert
    assertNotEquals(rpcRequestMetadata, new RpcRequestMetadata(UUID.randomUUID(), 1));
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(null, 1);

    // Act and Assert
    assertNotEquals(rpcRequestMetadata, new RpcRequestMetadata(UUID.randomUUID(), 1));
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RpcRequestMetadata rpcRequestMetadata = new RpcRequestMetadata(UUID.randomUUID(), 2);

    // Act and Assert
    assertNotEquals(rpcRequestMetadata, new RpcRequestMetadata(UUID.randomUUID(), 1));
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RpcRequestMetadata(UUID.randomUUID(), 1), null);
  }

  /**
   * Test {@link RpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RpcRequestMetadata(UUID.randomUUID(), 1), "Different type to RpcRequestMetadata");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RpcRequestMetadata#RpcRequestMetadata(UUID, int)}
   *   <li>{@link RpcRequestMetadata#toString()}
   *   <li>{@link RpcRequestMetadata#getRequestId()}
   *   <li>{@link RpcRequestMetadata#getSessionId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act
    RpcRequestMetadata actualRpcRequestMetadata = new RpcRequestMetadata(sessionId, 1);
    actualRpcRequestMetadata.toString();
    int actualRequestId = actualRpcRequestMetadata.getRequestId();

    // Assert
    assertEquals(1, actualRequestId);
    assertSame(sessionId, actualRpcRequestMetadata.getSessionId());
  }
}
