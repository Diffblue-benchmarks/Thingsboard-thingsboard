package org.thingsboard.server.actors.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;

class SessionInfoDiffblueTest {
  /**
   * Test {@link SessionInfo#equals(Object)}, and {@link SessionInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SessionInfo#equals(Object)}
   *   <li>{@link SessionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SessionInfo sessionInfo = new SessionInfo(TransportProtos.SessionType.SYNC, "42");
    SessionInfo sessionInfo2 = new SessionInfo(TransportProtos.SessionType.SYNC, "42");

    // Act and Assert
    assertEquals(sessionInfo, sessionInfo2);
    int expectedHashCodeResult = sessionInfo.hashCode();
    assertEquals(expectedHashCodeResult, sessionInfo2.hashCode());
  }

  /**
   * Test {@link SessionInfo#equals(Object)}, and {@link SessionInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SessionInfo#equals(Object)}
   *   <li>{@link SessionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SessionInfo sessionInfo = new SessionInfo(null, "42");
    SessionInfo sessionInfo2 = new SessionInfo(null, "42");

    // Act and Assert
    assertEquals(sessionInfo, sessionInfo2);
    int expectedHashCodeResult = sessionInfo.hashCode();
    assertEquals(expectedHashCodeResult, sessionInfo2.hashCode());
  }

  /**
   * Test {@link SessionInfo#equals(Object)}, and {@link SessionInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SessionInfo#equals(Object)}
   *   <li>{@link SessionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SessionInfo sessionInfo = new SessionInfo(TransportProtos.SessionType.SYNC, null);
    SessionInfo sessionInfo2 = new SessionInfo(TransportProtos.SessionType.SYNC, null);

    // Act and Assert
    assertEquals(sessionInfo, sessionInfo2);
    int expectedHashCodeResult = sessionInfo.hashCode();
    assertEquals(expectedHashCodeResult, sessionInfo2.hashCode());
  }

  /**
   * Test {@link SessionInfo#equals(Object)}, and {@link SessionInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SessionInfo#equals(Object)}
   *   <li>{@link SessionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SessionInfo sessionInfo = new SessionInfo(TransportProtos.SessionType.SYNC, "42");

    // Act and Assert
    assertEquals(sessionInfo, sessionInfo);
    int expectedHashCodeResult = sessionInfo.hashCode();
    assertEquals(expectedHashCodeResult, sessionInfo.hashCode());
  }

  /**
   * Test {@link SessionInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SessionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SessionInfo sessionInfo = new SessionInfo(null, "42");

    // Act and Assert
    assertNotEquals(sessionInfo, new SessionInfo(TransportProtos.SessionType.SYNC, "42"));
  }

  /**
   * Test {@link SessionInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SessionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SessionInfo sessionInfo = new SessionInfo(TransportProtos.SessionType.ASYNC, "42");

    // Act and Assert
    assertNotEquals(sessionInfo, new SessionInfo(TransportProtos.SessionType.SYNC, "42"));
  }

  /**
   * Test {@link SessionInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SessionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SessionInfo sessionInfo = new SessionInfo(TransportProtos.SessionType.SYNC, "Node Id");

    // Act and Assert
    assertNotEquals(sessionInfo, new SessionInfo(TransportProtos.SessionType.SYNC, "42"));
  }

  /**
   * Test {@link SessionInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SessionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SessionInfo sessionInfo = new SessionInfo(TransportProtos.SessionType.SYNC, null);

    // Act and Assert
    assertNotEquals(sessionInfo, new SessionInfo(TransportProtos.SessionType.SYNC, "42"));
  }

  /**
   * Test {@link SessionInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SessionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SessionInfo(TransportProtos.SessionType.SYNC, "42"), null);
  }

  /**
   * Test {@link SessionInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SessionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SessionInfo(TransportProtos.SessionType.SYNC, "42"), "Different type to SessionInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SessionInfo#SessionInfo(TransportProtos.SessionType, String)}
   *   <li>{@link SessionInfo#toString()}
   *   <li>{@link SessionInfo#getNodeId()}
   *   <li>{@link SessionInfo#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    SessionInfo actualSessionInfo = new SessionInfo(TransportProtos.SessionType.SYNC, "42");
    String actualToStringResult = actualSessionInfo.toString();
    String actualNodeId = actualSessionInfo.getNodeId();

    // Assert
    assertEquals("42", actualNodeId);
    assertEquals("SessionInfo(type=SYNC, nodeId=42)", actualToStringResult);
    assertEquals(TransportProtos.SessionType.SYNC, actualSessionInfo.getType());
  }
}
