package org.thingsboard.server.actors.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.SessionType;

class SessionInfoDiffblueTest {
  /**
   * Test {@link SessionInfo#equals(Object)}, and {@link SessionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SessionInfo#equals(Object)}
   *   <li>{@link SessionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionInfo.equals(Object)", "int SessionInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SessionInfo sessionInfo = new SessionInfo(SessionType.SYNC, "42");
    SessionInfo sessionInfo2 = new SessionInfo(SessionType.SYNC, "42");

    // Act and Assert
    assertEquals(sessionInfo, sessionInfo2);
    assertEquals(sessionInfo.hashCode(), sessionInfo2.hashCode());
  }

  /**
   * Test {@link SessionInfo#equals(Object)}, and {@link SessionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SessionInfo#equals(Object)}
   *   <li>{@link SessionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionInfo.equals(Object)", "int SessionInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SessionInfo sessionInfo = new SessionInfo(null, "42");
    SessionInfo sessionInfo2 = new SessionInfo(null, "42");

    // Act and Assert
    assertEquals(sessionInfo, sessionInfo2);
    assertEquals(sessionInfo.hashCode(), sessionInfo2.hashCode());
  }

  /**
   * Test {@link SessionInfo#equals(Object)}, and {@link SessionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SessionInfo#equals(Object)}
   *   <li>{@link SessionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionInfo.equals(Object)", "int SessionInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SessionInfo sessionInfo = new SessionInfo(SessionType.SYNC, null);
    SessionInfo sessionInfo2 = new SessionInfo(SessionType.SYNC, null);

    // Act and Assert
    assertEquals(sessionInfo, sessionInfo2);
    assertEquals(sessionInfo.hashCode(), sessionInfo2.hashCode());
  }

  /**
   * Test {@link SessionInfo#equals(Object)}, and {@link SessionInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SessionInfo#equals(Object)}
   *   <li>{@link SessionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionInfo.equals(Object)", "int SessionInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SessionInfo sessionInfo = new SessionInfo(SessionType.SYNC, "42");

    // Act and Assert
    assertEquals(sessionInfo, sessionInfo);
    int expectedHashCodeResult = sessionInfo.hashCode();
    assertEquals(expectedHashCodeResult, sessionInfo.hashCode());
  }

  /**
   * Test {@link SessionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionInfo.equals(Object)", "int SessionInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SessionInfo sessionInfo = new SessionInfo(null, "42");

    // Act and Assert
    assertNotEquals(sessionInfo, new SessionInfo(SessionType.SYNC, "42"));
  }

  /**
   * Test {@link SessionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionInfo.equals(Object)", "int SessionInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SessionInfo sessionInfo = new SessionInfo(SessionType.ASYNC, "42");

    // Act and Assert
    assertNotEquals(sessionInfo, new SessionInfo(SessionType.SYNC, "42"));
  }

  /**
   * Test {@link SessionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionInfo.equals(Object)", "int SessionInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SessionInfo sessionInfo = new SessionInfo(SessionType.SYNC, "Node Id");

    // Act and Assert
    assertNotEquals(sessionInfo, new SessionInfo(SessionType.SYNC, "42"));
  }

  /**
   * Test {@link SessionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionInfo.equals(Object)", "int SessionInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SessionInfo sessionInfo = new SessionInfo(SessionType.SYNC, null);

    // Act and Assert
    assertNotEquals(sessionInfo, new SessionInfo(SessionType.SYNC, "42"));
  }

  /**
   * Test {@link SessionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionInfo.equals(Object)", "int SessionInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SessionInfo(SessionType.SYNC, "42"), null);
  }

  /**
   * Test {@link SessionInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionInfo.equals(Object)", "int SessionInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SessionInfo(SessionType.SYNC, "42"), "Different type to SessionInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SessionInfo#SessionInfo(SessionType, String)}
   *   <li>{@link SessionInfo#toString()}
   *   <li>{@link SessionInfo#getNodeId()}
   *   <li>{@link SessionInfo#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SessionInfo.<init>(SessionType, String)",
    "String SessionInfo.getNodeId()",
    "SessionType SessionInfo.getType()",
    "String SessionInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SessionInfo actualSessionInfo = new SessionInfo(SessionType.SYNC, "42");
    String actualToStringResult = actualSessionInfo.toString();
    String actualNodeId = actualSessionInfo.getNodeId();

    // Assert
    assertEquals("42", actualNodeId);
    assertEquals("SessionInfo(type=SYNC, nodeId=42)", actualToStringResult);
    assertEquals(SessionType.SYNC, actualSessionInfo.getType());
  }
}
