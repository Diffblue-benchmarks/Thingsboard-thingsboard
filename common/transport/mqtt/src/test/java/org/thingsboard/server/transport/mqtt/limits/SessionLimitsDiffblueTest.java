package org.thingsboard.server.transport.mqtt.limits;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.transport.mqtt.limits.SessionLimits.SessionRateLimits;

class SessionLimitsDiffblueTest {
  /**
   * Test {@link SessionLimits#equals(Object)}, and {@link SessionLimits#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SessionLimits#equals(Object)}
   *   <li>{@link SessionLimits#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    SessionLimits sessionLimits2 = new SessionLimits();
    sessionLimits2.setMaxInflightMessages(3);
    sessionLimits2.setMaxPayloadSize(3);
    sessionLimits2.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertEquals(sessionLimits, sessionLimits2);
    int expectedHashCodeResult = sessionLimits.hashCode();
    assertEquals(expectedHashCodeResult, sessionLimits2.hashCode());
  }

  /**
   * Test {@link SessionLimits#equals(Object)}, and {@link SessionLimits#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SessionLimits#equals(Object)}
   *   <li>{@link SessionLimits#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits.setRateLimits(null);
    GatewaySessionLimits gatewaySessionLimits = mock(GatewaySessionLimits.class);
    when(gatewaySessionLimits.getRateLimits()).thenReturn(null);
    when(gatewaySessionLimits.getMaxInflightMessages()).thenReturn(3);
    when(gatewaySessionLimits.getMaxPayloadSize()).thenReturn(3);
    when(gatewaySessionLimits.canEqual(Mockito.<Object>any())).thenReturn(true);
    doNothing().when(gatewaySessionLimits).setMaxInflightMessages(anyInt());
    doNothing().when(gatewaySessionLimits).setMaxPayloadSize(anyInt());
    doNothing().when(gatewaySessionLimits).setRateLimits(Mockito.<SessionRateLimits>any());
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    gatewaySessionLimits.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertEquals(sessionLimits, gatewaySessionLimits);
    int notExpectedHashCodeResult = sessionLimits.hashCode();
    assertNotEquals(notExpectedHashCodeResult, gatewaySessionLimits.hashCode());
  }

  /**
   * Test {@link SessionLimits#equals(Object)}, and {@link SessionLimits#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SessionLimits#equals(Object)}
   *   <li>{@link SessionLimits#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertEquals(sessionLimits, sessionLimits);
    int expectedHashCodeResult = sessionLimits.hashCode();
    assertEquals(expectedHashCodeResult, sessionLimits.hashCode());
  }

  /**
   * Test {@link SessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GatewaySessionLimits gatewaySessionLimits = new GatewaySessionLimits();
    gatewaySessionLimits.setGatewayRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    gatewaySessionLimits.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    gatewaySessionLimits.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(gatewaySessionLimits, sessionLimits);
  }

  /**
   * Test {@link SessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(1);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    SessionLimits sessionLimits2 = new SessionLimits();
    sessionLimits2.setMaxInflightMessages(3);
    sessionLimits2.setMaxPayloadSize(3);
    sessionLimits2.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(sessionLimits, sessionLimits2);
  }

  /**
   * Test {@link SessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(1);
    sessionLimits.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    SessionLimits sessionLimits2 = new SessionLimits();
    sessionLimits2.setMaxInflightMessages(3);
    sessionLimits2.setMaxPayloadSize(3);
    sessionLimits2.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(sessionLimits, sessionLimits2);
  }

  /**
   * Test {@link SessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits.setRateLimits(
        new SessionRateLimits(null, "Telemetry Messages", "Telemetry Data Points"));

    SessionLimits sessionLimits2 = new SessionLimits();
    sessionLimits2.setMaxInflightMessages(3);
    sessionLimits2.setMaxPayloadSize(3);
    sessionLimits2.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(sessionLimits, sessionLimits2);
  }

  /**
   * Test {@link SessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits.setRateLimits(null);

    SessionLimits sessionLimits2 = new SessionLimits();
    sessionLimits2.setMaxInflightMessages(3);
    sessionLimits2.setMaxPayloadSize(3);
    sessionLimits2.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(sessionLimits, sessionLimits2);
  }

  /**
   * Test {@link SessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    GatewaySessionLimits gatewaySessionLimits = new GatewaySessionLimits();
    gatewaySessionLimits.setGatewayRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    gatewaySessionLimits.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    gatewaySessionLimits.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(sessionLimits, gatewaySessionLimits);
  }

  /**
   * Test {@link SessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));
    GatewaySessionLimits gatewaySessionLimits = mock(GatewaySessionLimits.class);
    when(gatewaySessionLimits.getRateLimits()).thenReturn(null);
    when(gatewaySessionLimits.getMaxInflightMessages()).thenReturn(3);
    when(gatewaySessionLimits.getMaxPayloadSize()).thenReturn(3);
    when(gatewaySessionLimits.canEqual(Mockito.<Object>any())).thenReturn(true);
    doNothing().when(gatewaySessionLimits).setMaxInflightMessages(anyInt());
    doNothing().when(gatewaySessionLimits).setMaxPayloadSize(anyInt());
    doNothing().when(gatewaySessionLimits).setRateLimits(Mockito.<SessionRateLimits>any());
    gatewaySessionLimits.setMaxInflightMessages(3);
    gatewaySessionLimits.setMaxPayloadSize(3);
    gatewaySessionLimits.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(sessionLimits, gatewaySessionLimits);
  }

  /**
   * Test {@link SessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(sessionLimits, null);
  }

  /**
   * Test {@link SessionLimits#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SessionLimits#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SessionLimits.equals(Object)", "int SessionLimits.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SessionLimits sessionLimits = new SessionLimits();
    sessionLimits.setMaxInflightMessages(3);
    sessionLimits.setMaxPayloadSize(3);
    sessionLimits.setRateLimits(
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points"));

    // Act and Assert
    assertNotEquals(sessionLimits, "Different type to SessionLimits");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SessionLimits}
   *   <li>{@link SessionLimits#setMaxInflightMessages(int)}
   *   <li>{@link SessionLimits#setMaxPayloadSize(int)}
   *   <li>{@link SessionLimits#setRateLimits(SessionRateLimits)}
   *   <li>{@link SessionLimits#toString()}
   *   <li>{@link SessionLimits#getMaxInflightMessages()}
   *   <li>{@link SessionLimits#getMaxPayloadSize()}
   *   <li>{@link SessionLimits#getRateLimits()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void SessionLimits.<init>()",
    "int SessionLimits.getMaxInflightMessages()",
    "int SessionLimits.getMaxPayloadSize()",
    "SessionRateLimits SessionLimits.getRateLimits()",
    "void SessionLimits.setMaxInflightMessages(int)",
    "void SessionLimits.setMaxPayloadSize(int)",
    "void SessionLimits.setRateLimits(SessionRateLimits)",
    "String SessionLimits.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SessionLimits actualSessionLimits = new SessionLimits();
    actualSessionLimits.setMaxInflightMessages(3);
    actualSessionLimits.setMaxPayloadSize(3);
    SessionRateLimits rateLimits =
        new SessionRateLimits("Messages", "Telemetry Messages", "Telemetry Data Points");

    actualSessionLimits.setRateLimits(rateLimits);
    String actualToStringResult = actualSessionLimits.toString();
    int actualMaxInflightMessages = actualSessionLimits.getMaxInflightMessages();
    int actualMaxPayloadSize = actualSessionLimits.getMaxPayloadSize();

    // Assert
    assertEquals(
        "SessionLimits(maxPayloadSize=3, maxInflightMessages=3, rateLimits=SessionRateLimits[messages=Messages,"
            + " telemetryMessages=Telemetry Messages, telemetryDataPoints=Telemetry Data Points])",
        actualToStringResult);
    assertEquals(3, actualMaxInflightMessages);
    assertEquals(3, actualMaxPayloadSize);
    assertSame(rateLimits, actualSessionLimits.getRateLimits());
  }
}
