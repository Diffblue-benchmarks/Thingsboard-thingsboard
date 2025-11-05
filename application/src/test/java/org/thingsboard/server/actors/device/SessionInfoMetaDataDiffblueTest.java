package org.thingsboard.server.actors.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.SessionType;

class SessionInfoMetaDataDiffblueTest {
  /**
   * Test {@link SessionInfoMetaData#equals(Object)}, and {@link SessionInfoMetaData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SessionInfoMetaData#equals(Object)}
   *   <li>{@link SessionInfoMetaData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SessionInfoMetaData.equals(Object)",
    "int SessionInfoMetaData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SessionInfoMetaData sessionInfoMetaData =
        new SessionInfoMetaData(new SessionInfo(SessionType.SYNC, "42"));
    SessionInfoMetaData sessionInfoMetaData2 =
        new SessionInfoMetaData(new SessionInfo(SessionType.SYNC, "42"));

    // Act and Assert
    assertEquals(sessionInfoMetaData, sessionInfoMetaData2);
    assertEquals(sessionInfoMetaData.hashCode(), sessionInfoMetaData2.hashCode());
  }

  /**
   * Test {@link SessionInfoMetaData#equals(Object)}, and {@link SessionInfoMetaData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SessionInfoMetaData#equals(Object)}
   *   <li>{@link SessionInfoMetaData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SessionInfoMetaData.equals(Object)",
    "int SessionInfoMetaData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SessionInfoMetaData sessionInfoMetaData = new SessionInfoMetaData(null);
    SessionInfoMetaData sessionInfoMetaData2 = new SessionInfoMetaData(null);

    // Act and Assert
    assertEquals(sessionInfoMetaData, sessionInfoMetaData2);
    assertEquals(sessionInfoMetaData.hashCode(), sessionInfoMetaData2.hashCode());
  }

  /**
   * Test {@link SessionInfoMetaData#equals(Object)}, and {@link SessionInfoMetaData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SessionInfoMetaData#equals(Object)}
   *   <li>{@link SessionInfoMetaData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SessionInfoMetaData.equals(Object)",
    "int SessionInfoMetaData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SessionInfoMetaData sessionInfoMetaData =
        new SessionInfoMetaData(new SessionInfo(SessionType.SYNC, "42"));

    // Act and Assert
    assertEquals(sessionInfoMetaData, sessionInfoMetaData);
    int expectedHashCodeResult = sessionInfoMetaData.hashCode();
    assertEquals(expectedHashCodeResult, sessionInfoMetaData.hashCode());
  }

  /**
   * Test {@link SessionInfoMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionInfoMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SessionInfoMetaData.equals(Object)",
    "int SessionInfoMetaData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SessionInfoMetaData sessionInfoMetaData = new SessionInfoMetaData(new SessionInfo(null, "42"));

    // Act and Assert
    assertNotEquals(
        sessionInfoMetaData, new SessionInfoMetaData(new SessionInfo(SessionType.SYNC, "42")));
  }

  /**
   * Test {@link SessionInfoMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionInfoMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SessionInfoMetaData.equals(Object)",
    "int SessionInfoMetaData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SessionInfoMetaData sessionInfoMetaData = new SessionInfoMetaData(null);

    // Act and Assert
    assertNotEquals(
        sessionInfoMetaData, new SessionInfoMetaData(new SessionInfo(SessionType.SYNC, "42")));
  }

  /**
   * Test {@link SessionInfoMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionInfoMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SessionInfoMetaData.equals(Object)",
    "int SessionInfoMetaData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SessionInfoMetaData sessionInfoMetaData =
        new SessionInfoMetaData(new SessionInfo(SessionType.SYNC, "42"), 1L);

    // Act and Assert
    assertNotEquals(
        sessionInfoMetaData, new SessionInfoMetaData(new SessionInfo(SessionType.SYNC, "42")));
  }

  /**
   * Test {@link SessionInfoMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionInfoMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SessionInfoMetaData.equals(Object)",
    "int SessionInfoMetaData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SessionInfoMetaData sessionInfoMetaData =
        new SessionInfoMetaData(new SessionInfo(SessionType.SYNC, "42"));
    sessionInfoMetaData.setSubscribedToAttributes(true);

    // Act and Assert
    assertNotEquals(
        sessionInfoMetaData, new SessionInfoMetaData(new SessionInfo(SessionType.SYNC, "42")));
  }

  /**
   * Test {@link SessionInfoMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionInfoMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SessionInfoMetaData.equals(Object)",
    "int SessionInfoMetaData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SessionInfoMetaData sessionInfoMetaData =
        new SessionInfoMetaData(new SessionInfo(SessionType.SYNC, "42"));
    sessionInfoMetaData.setSubscribedToRPC(true);

    // Act and Assert
    assertNotEquals(
        sessionInfoMetaData, new SessionInfoMetaData(new SessionInfo(SessionType.SYNC, "42")));
  }

  /**
   * Test {@link SessionInfoMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionInfoMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SessionInfoMetaData.equals(Object)",
    "int SessionInfoMetaData.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SessionInfoMetaData(new SessionInfo(SessionType.SYNC, "42")), null);
  }

  /**
   * Test {@link SessionInfoMetaData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionInfoMetaData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SessionInfoMetaData.equals(Object)",
    "int SessionInfoMetaData.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new SessionInfoMetaData(new SessionInfo(SessionType.SYNC, "42")),
        "Different type to SessionInfoMetaData");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SessionInfoMetaData#SessionInfoMetaData(SessionInfo, long)}
   *   <li>{@link SessionInfoMetaData#setLastActivityTime(long)}
   *   <li>{@link SessionInfoMetaData#setSubscribedToAttributes(boolean)}
   *   <li>{@link SessionInfoMetaData#setSubscribedToRPC(boolean)}
   *   <li>{@link SessionInfoMetaData#toString()}
   *   <li>{@link SessionInfoMetaData#getLastActivityTime()}
   *   <li>{@link SessionInfoMetaData#getSessionInfo()}
   *   <li>{@link SessionInfoMetaData#isSubscribedToAttributes()}
   *   <li>{@link SessionInfoMetaData#isSubscribedToRPC()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SessionInfoMetaData.<init>(SessionInfo, long)",
    "long SessionInfoMetaData.getLastActivityTime()",
    "SessionInfo SessionInfoMetaData.getSessionInfo()",
    "boolean SessionInfoMetaData.isSubscribedToAttributes()",
    "boolean SessionInfoMetaData.isSubscribedToRPC()",
    "void SessionInfoMetaData.setLastActivityTime(long)",
    "void SessionInfoMetaData.setSubscribedToAttributes(boolean)",
    "void SessionInfoMetaData.setSubscribedToRPC(boolean)",
    "String SessionInfoMetaData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    SessionInfo sessionInfo = new SessionInfo(SessionType.SYNC, "42");

    // Act
    SessionInfoMetaData actualSessionInfoMetaData = new SessionInfoMetaData(sessionInfo, 1L);
    actualSessionInfoMetaData.setLastActivityTime(1L);
    actualSessionInfoMetaData.setSubscribedToAttributes(true);
    actualSessionInfoMetaData.setSubscribedToRPC(true);
    String actualToStringResult = actualSessionInfoMetaData.toString();
    long actualLastActivityTime = actualSessionInfoMetaData.getLastActivityTime();
    SessionInfo actualSessionInfo = actualSessionInfoMetaData.getSessionInfo();
    boolean actualIsSubscribedToAttributesResult =
        actualSessionInfoMetaData.isSubscribedToAttributes();

    // Assert
    assertEquals(
        "SessionInfoMetaData(sessionInfo=SessionInfo(type=SYNC, nodeId=42), lastActivityTime=1, subscribedToAttributes"
            + "=true, subscribedToRPC=true)",
        actualToStringResult);
    assertEquals(1L, actualLastActivityTime);
    assertTrue(actualIsSubscribedToAttributesResult);
    assertTrue(actualSessionInfoMetaData.isSubscribedToRPC());
    assertSame(sessionInfo, actualSessionInfo);
  }

  /**
   * Test {@link SessionInfoMetaData#SessionInfoMetaData(SessionInfo)}.
   *
   * <ul>
   *   <li>Then return not SubscribedToAttributes.
   * </ul>
   *
   * <p>Method under test: {@link SessionInfoMetaData#SessionInfoMetaData(SessionInfo)}
   */
  @Test
  @DisplayName("Test new SessionInfoMetaData(SessionInfo); then return not SubscribedToAttributes")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SessionInfoMetaData.<init>(SessionInfo)"})
  void testNewSessionInfoMetaData_thenReturnNotSubscribedToAttributes() {
    // Arrange
    SessionInfo sessionInfo = new SessionInfo(SessionType.SYNC, "42");

    // Act
    SessionInfoMetaData actualSessionInfoMetaData = new SessionInfoMetaData(sessionInfo);

    // Assert
    assertFalse(actualSessionInfoMetaData.isSubscribedToAttributes());
    assertFalse(actualSessionInfoMetaData.isSubscribedToRPC());
    assertSame(sessionInfo, actualSessionInfoMetaData.getSessionInfo());
  }
}
