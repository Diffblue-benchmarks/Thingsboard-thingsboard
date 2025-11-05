package org.thingsboard.server.actors.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.SessionType;

class ToServerRpcRequestMetadataDiffblueTest {
  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}, and {@link
   * ToServerRpcRequestMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToServerRpcRequestMetadata#equals(Object)}
   *   <li>{@link ToServerRpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToServerRpcRequestMetadata.equals(Object)",
    "int ToServerRpcRequestMetadata.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata =
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), SessionType.SYNC, "42");
    ToServerRpcRequestMetadata toServerRpcRequestMetadata2 =
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), SessionType.SYNC, "42");

    // Act and Assert
    assertEquals(toServerRpcRequestMetadata, toServerRpcRequestMetadata2);
    assertEquals(toServerRpcRequestMetadata.hashCode(), toServerRpcRequestMetadata2.hashCode());
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}, and {@link
   * ToServerRpcRequestMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToServerRpcRequestMetadata#equals(Object)}
   *   <li>{@link ToServerRpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToServerRpcRequestMetadata.equals(Object)",
    "int ToServerRpcRequestMetadata.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata =
        new ToServerRpcRequestMetadata(null, SessionType.SYNC, "42");
    ToServerRpcRequestMetadata toServerRpcRequestMetadata2 =
        new ToServerRpcRequestMetadata(null, SessionType.SYNC, "42");

    // Act and Assert
    assertEquals(toServerRpcRequestMetadata, toServerRpcRequestMetadata2);
    assertEquals(toServerRpcRequestMetadata.hashCode(), toServerRpcRequestMetadata2.hashCode());
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}, and {@link
   * ToServerRpcRequestMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToServerRpcRequestMetadata#equals(Object)}
   *   <li>{@link ToServerRpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToServerRpcRequestMetadata.equals(Object)",
    "int ToServerRpcRequestMetadata.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata =
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), null, "42");
    ToServerRpcRequestMetadata toServerRpcRequestMetadata2 =
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), null, "42");

    // Act and Assert
    assertEquals(toServerRpcRequestMetadata, toServerRpcRequestMetadata2);
    assertEquals(toServerRpcRequestMetadata.hashCode(), toServerRpcRequestMetadata2.hashCode());
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}, and {@link
   * ToServerRpcRequestMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToServerRpcRequestMetadata#equals(Object)}
   *   <li>{@link ToServerRpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToServerRpcRequestMetadata.equals(Object)",
    "int ToServerRpcRequestMetadata.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata =
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), SessionType.SYNC, null);
    ToServerRpcRequestMetadata toServerRpcRequestMetadata2 =
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), SessionType.SYNC, null);

    // Act and Assert
    assertEquals(toServerRpcRequestMetadata, toServerRpcRequestMetadata2);
    assertEquals(toServerRpcRequestMetadata.hashCode(), toServerRpcRequestMetadata2.hashCode());
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}, and {@link
   * ToServerRpcRequestMetadata#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToServerRpcRequestMetadata#equals(Object)}
   *   <li>{@link ToServerRpcRequestMetadata#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToServerRpcRequestMetadata.equals(Object)",
    "int ToServerRpcRequestMetadata.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata =
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), SessionType.SYNC, "42");

    // Act and Assert
    assertEquals(toServerRpcRequestMetadata, toServerRpcRequestMetadata);
    int expectedHashCodeResult = toServerRpcRequestMetadata.hashCode();
    assertEquals(expectedHashCodeResult, toServerRpcRequestMetadata.hashCode());
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ToServerRpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToServerRpcRequestMetadata.equals(Object)",
    "int ToServerRpcRequestMetadata.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata =
        new ToServerRpcRequestMetadata(UUID.randomUUID(), SessionType.SYNC, "42");

    // Act and Assert
    assertNotEquals(
        toServerRpcRequestMetadata,
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), SessionType.SYNC, "42"));
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ToServerRpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToServerRpcRequestMetadata.equals(Object)",
    "int ToServerRpcRequestMetadata.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata =
        new ToServerRpcRequestMetadata(null, SessionType.SYNC, "42");

    // Act and Assert
    assertNotEquals(
        toServerRpcRequestMetadata,
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), SessionType.SYNC, "42"));
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ToServerRpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToServerRpcRequestMetadata.equals(Object)",
    "int ToServerRpcRequestMetadata.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata =
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), null, "42");

    // Act and Assert
    assertNotEquals(
        toServerRpcRequestMetadata,
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), SessionType.SYNC, "42"));
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ToServerRpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToServerRpcRequestMetadata.equals(Object)",
    "int ToServerRpcRequestMetadata.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata =
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), SessionType.ASYNC, "42");

    // Act and Assert
    assertNotEquals(
        toServerRpcRequestMetadata,
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), SessionType.SYNC, "42"));
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ToServerRpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToServerRpcRequestMetadata.equals(Object)",
    "int ToServerRpcRequestMetadata.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata =
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), SessionType.SYNC, "Node Id");

    // Act and Assert
    assertNotEquals(
        toServerRpcRequestMetadata,
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), SessionType.SYNC, "42"));
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ToServerRpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToServerRpcRequestMetadata.equals(Object)",
    "int ToServerRpcRequestMetadata.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ToServerRpcRequestMetadata toServerRpcRequestMetadata =
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), SessionType.SYNC, null);

    // Act and Assert
    assertNotEquals(
        toServerRpcRequestMetadata,
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), SessionType.SYNC, "42"));
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ToServerRpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToServerRpcRequestMetadata.equals(Object)",
    "int ToServerRpcRequestMetadata.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), SessionType.SYNC, "42"),
        null);
  }

  /**
   * Test {@link ToServerRpcRequestMetadata#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ToServerRpcRequestMetadata#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ToServerRpcRequestMetadata.equals(Object)",
    "int ToServerRpcRequestMetadata.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ToServerRpcRequestMetadata(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), SessionType.SYNC, "42"),
        "Different type to ToServerRpcRequestMetadata");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ToServerRpcRequestMetadata#ToServerRpcRequestMetadata(UUID, SessionType, String)}
   *   <li>{@link ToServerRpcRequestMetadata#toString()}
   *   <li>{@link ToServerRpcRequestMetadata#getNodeId()}
   *   <li>{@link ToServerRpcRequestMetadata#getSessionId()}
   *   <li>{@link ToServerRpcRequestMetadata#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToServerRpcRequestMetadata.<init>(UUID, SessionType, String)",
    "String ToServerRpcRequestMetadata.getNodeId()",
    "UUID ToServerRpcRequestMetadata.getSessionId()",
    "SessionType ToServerRpcRequestMetadata.getType()",
    "String ToServerRpcRequestMetadata.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    UUID sessionId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    ToServerRpcRequestMetadata actualToServerRpcRequestMetadata =
        new ToServerRpcRequestMetadata(sessionId, SessionType.SYNC, "42");
    String actualToStringResult = actualToServerRpcRequestMetadata.toString();
    String actualNodeId = actualToServerRpcRequestMetadata.getNodeId();
    UUID actualSessionId = actualToServerRpcRequestMetadata.getSessionId();

    // Assert
    assertEquals("42", actualNodeId);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualSessionId.toString());
    assertEquals(
        "ToServerRpcRequestMetadata(sessionId=784f394c-42b6-435a-983c-b7beff2784f9, type=SYNC, nodeId=42)",
        actualToStringResult);
    assertEquals(SessionType.SYNC, actualToServerRpcRequestMetadata.getType());
    assertSame(sessionId, actualSessionId);
  }
}
