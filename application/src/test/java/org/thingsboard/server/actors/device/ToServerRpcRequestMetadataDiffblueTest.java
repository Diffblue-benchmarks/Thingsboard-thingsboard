package org.thingsboard.server.actors.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;

class ToServerRpcRequestMetadataDiffblueTest {
  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}, and
   * {@link ToServerRpcRequestMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ToServerRpcRequestMetadata#equals(Object)}
   *   <li>{@link ToServerRpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata = new ToServerRpcRequestMetadata(null,
        TransportProtos.SessionType.SYNC, "42");
    ToServerRpcRequestMetadata toServerRpcRequestMetadata2 = new ToServerRpcRequestMetadata(null,
        TransportProtos.SessionType.SYNC, "42");

    // Act and Assert
    assertEquals(toServerRpcRequestMetadata, toServerRpcRequestMetadata2);
    int expectedHashCodeResult = toServerRpcRequestMetadata.hashCode();
    assertEquals(expectedHashCodeResult, toServerRpcRequestMetadata2.hashCode());
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}, and
   * {@link ToServerRpcRequestMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ToServerRpcRequestMetadata#equals(Object)}
   *   <li>{@link ToServerRpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata = new ToServerRpcRequestMetadata(null, null, "42");
    ToServerRpcRequestMetadata toServerRpcRequestMetadata2 = new ToServerRpcRequestMetadata(null, null, "42");

    // Act and Assert
    assertEquals(toServerRpcRequestMetadata, toServerRpcRequestMetadata2);
    int expectedHashCodeResult = toServerRpcRequestMetadata.hashCode();
    assertEquals(expectedHashCodeResult, toServerRpcRequestMetadata2.hashCode());
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}, and
   * {@link ToServerRpcRequestMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ToServerRpcRequestMetadata#equals(Object)}
   *   <li>{@link ToServerRpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata = new ToServerRpcRequestMetadata(null,
        TransportProtos.SessionType.SYNC, null);
    ToServerRpcRequestMetadata toServerRpcRequestMetadata2 = new ToServerRpcRequestMetadata(null,
        TransportProtos.SessionType.SYNC, null);

    // Act and Assert
    assertEquals(toServerRpcRequestMetadata, toServerRpcRequestMetadata2);
    int expectedHashCodeResult = toServerRpcRequestMetadata.hashCode();
    assertEquals(expectedHashCodeResult, toServerRpcRequestMetadata2.hashCode());
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}, and
   * {@link ToServerRpcRequestMetadata#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ToServerRpcRequestMetadata#equals(Object)}
   *   <li>{@link ToServerRpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata = new ToServerRpcRequestMetadata(new UUID(1L, 1L),
        TransportProtos.SessionType.SYNC, "42");
    ToServerRpcRequestMetadata toServerRpcRequestMetadata2 = new ToServerRpcRequestMetadata(new UUID(1L, 1L),
        TransportProtos.SessionType.SYNC, "42");

    // Act and Assert
    assertEquals(toServerRpcRequestMetadata, toServerRpcRequestMetadata2);
    int expectedHashCodeResult = toServerRpcRequestMetadata.hashCode();
    assertEquals(expectedHashCodeResult, toServerRpcRequestMetadata2.hashCode());
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}, and
   * {@link ToServerRpcRequestMetadata#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ToServerRpcRequestMetadata#equals(Object)}
   *   <li>{@link ToServerRpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata = new ToServerRpcRequestMetadata(UUID.randomUUID(),
        TransportProtos.SessionType.SYNC, "42");

    // Act and Assert
    assertEquals(toServerRpcRequestMetadata, toServerRpcRequestMetadata);
    int expectedHashCodeResult = toServerRpcRequestMetadata.hashCode();
    assertEquals(expectedHashCodeResult, toServerRpcRequestMetadata.hashCode());
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToServerRpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata = new ToServerRpcRequestMetadata(UUID.randomUUID(),
        TransportProtos.SessionType.SYNC, "42");

    // Act and Assert
    assertNotEquals(toServerRpcRequestMetadata,
        new ToServerRpcRequestMetadata(UUID.randomUUID(), TransportProtos.SessionType.SYNC, "42"));
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToServerRpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata = new ToServerRpcRequestMetadata(null,
        TransportProtos.SessionType.SYNC, "42");

    // Act and Assert
    assertNotEquals(toServerRpcRequestMetadata,
        new ToServerRpcRequestMetadata(UUID.randomUUID(), TransportProtos.SessionType.SYNC, "42"));
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToServerRpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata = new ToServerRpcRequestMetadata(null, null, "42");

    // Act and Assert
    assertNotEquals(toServerRpcRequestMetadata,
        new ToServerRpcRequestMetadata(null, TransportProtos.SessionType.SYNC, "42"));
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToServerRpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata = new ToServerRpcRequestMetadata(null,
        TransportProtos.SessionType.ASYNC, "42");

    // Act and Assert
    assertNotEquals(toServerRpcRequestMetadata,
        new ToServerRpcRequestMetadata(null, TransportProtos.SessionType.SYNC, "42"));
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToServerRpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata = new ToServerRpcRequestMetadata(null,
        TransportProtos.SessionType.SYNC, "Node Id");

    // Act and Assert
    assertNotEquals(toServerRpcRequestMetadata,
        new ToServerRpcRequestMetadata(null, TransportProtos.SessionType.SYNC, "42"));
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToServerRpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata = new ToServerRpcRequestMetadata(null,
        TransportProtos.SessionType.SYNC, null);

    // Act and Assert
    assertNotEquals(toServerRpcRequestMetadata,
        new ToServerRpcRequestMetadata(null, TransportProtos.SessionType.SYNC, "42"));
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToServerRpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ToServerRpcRequestMetadata(UUID.randomUUID(), TransportProtos.SessionType.SYNC, "42"), null);
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ToServerRpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ToServerRpcRequestMetadata(UUID.randomUUID(), TransportProtos.SessionType.SYNC, "42"),
        "Different type to ToServerRpcRequestMetadata");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ToServerRpcRequestMetadata#ToServerRpcRequestMetadata(UUID, TransportProtos.SessionType, String)}
   *   <li>{@link ToServerRpcRequestMetadata#toString()}
   *   <li>{@link ToServerRpcRequestMetadata#getNodeId()}
   *   <li>{@link ToServerRpcRequestMetadata#getSessionId()}
   *   <li>{@link ToServerRpcRequestMetadata#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    UUID sessionId = UUID.randomUUID();

    // Act
    ToServerRpcRequestMetadata actualToServerRpcRequestMetadata = new ToServerRpcRequestMetadata(sessionId,
        TransportProtos.SessionType.SYNC, "42");
    actualToServerRpcRequestMetadata.toString();
    String actualNodeId = actualToServerRpcRequestMetadata.getNodeId();
    UUID actualSessionId = actualToServerRpcRequestMetadata.getSessionId();

    // Assert
    assertEquals("42", actualNodeId);
    assertEquals(TransportProtos.SessionType.SYNC, actualToServerRpcRequestMetadata.getType());
    assertSame(sessionId, actualSessionId);
  }
}
