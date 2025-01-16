package org.thingsboard.server.service.ws.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.net.InetSocketAddress;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.ws.WebSocketSessionRef;
import org.thingsboard.server.service.ws.WebSocketSessionType;

class TelemetryWebSocketTextMsgDiffblueTest {
  /**
   * Test {@link TelemetryWebSocketTextMsg#equals(Object)}, and
   * {@link TelemetryWebSocketTextMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryWebSocketTextMsg#equals(Object)}
   *   <li>{@link TelemetryWebSocketTextMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    TelemetryWebSocketTextMsg telemetryWebSocketTextMsg = new TelemetryWebSocketTextMsg(sessionRef, "Payload");
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult2 = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult2 = builderResult2
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult2 = localAddressResult2
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef2 = remoteAddressResult2.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    TelemetryWebSocketTextMsg telemetryWebSocketTextMsg2 = new TelemetryWebSocketTextMsg(sessionRef2, "Payload");

    // Act and Assert
    assertEquals(telemetryWebSocketTextMsg, telemetryWebSocketTextMsg2);
    int expectedHashCodeResult = telemetryWebSocketTextMsg.hashCode();
    assertEquals(expectedHashCodeResult, telemetryWebSocketTextMsg2.hashCode());
  }

  /**
   * Test {@link TelemetryWebSocketTextMsg#equals(Object)}, and
   * {@link TelemetryWebSocketTextMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryWebSocketTextMsg#equals(Object)}
   *   <li>{@link TelemetryWebSocketTextMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WebSocketSessionRef.WebSocketSessionRefBuilder webSocketSessionRefBuilder = mock(
        WebSocketSessionRef.WebSocketSessionRefBuilder.class);
    when(webSocketSessionRefBuilder.localAddress(Mockito.<InetSocketAddress>any()))
        .thenReturn(WebSocketSessionRef.builder());
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = webSocketSessionRefBuilder
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    TelemetryWebSocketTextMsg telemetryWebSocketTextMsg = new TelemetryWebSocketTextMsg(sessionRef, "Payload");
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult2 = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult2 = localAddressResult2
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef2 = remoteAddressResult2.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    TelemetryWebSocketTextMsg telemetryWebSocketTextMsg2 = new TelemetryWebSocketTextMsg(sessionRef2, "Payload");

    // Act and Assert
    assertEquals(telemetryWebSocketTextMsg, telemetryWebSocketTextMsg2);
    int expectedHashCodeResult = telemetryWebSocketTextMsg.hashCode();
    assertEquals(expectedHashCodeResult, telemetryWebSocketTextMsg2.hashCode());
  }

  /**
   * Test {@link TelemetryWebSocketTextMsg#equals(Object)}, and
   * {@link TelemetryWebSocketTextMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryWebSocketTextMsg#equals(Object)}
   *   <li>{@link TelemetryWebSocketTextMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    WebSocketSessionRef.WebSocketSessionRefBuilder webSocketSessionRefBuilder = mock(
        WebSocketSessionRef.WebSocketSessionRefBuilder.class);
    when(webSocketSessionRefBuilder.localAddress(Mockito.<InetSocketAddress>any()))
        .thenReturn(WebSocketSessionRef.builder());
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = webSocketSessionRefBuilder
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    TelemetryWebSocketTextMsg telemetryWebSocketTextMsg = new TelemetryWebSocketTextMsg(sessionRef, null);
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult2 = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult2 = localAddressResult2
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef2 = remoteAddressResult2.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    TelemetryWebSocketTextMsg telemetryWebSocketTextMsg2 = new TelemetryWebSocketTextMsg(sessionRef2, null);

    // Act and Assert
    assertEquals(telemetryWebSocketTextMsg, telemetryWebSocketTextMsg2);
    int expectedHashCodeResult = telemetryWebSocketTextMsg.hashCode();
    assertEquals(expectedHashCodeResult, telemetryWebSocketTextMsg2.hashCode());
  }

  /**
   * Test {@link TelemetryWebSocketTextMsg#equals(Object)}, and
   * {@link TelemetryWebSocketTextMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryWebSocketTextMsg#equals(Object)}
   *   <li>{@link TelemetryWebSocketTextMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    TelemetryWebSocketTextMsg telemetryWebSocketTextMsg = new TelemetryWebSocketTextMsg(sessionRef, "Payload");

    // Act and Assert
    assertEquals(telemetryWebSocketTextMsg, telemetryWebSocketTextMsg);
    int expectedHashCodeResult = telemetryWebSocketTextMsg.hashCode();
    assertEquals(expectedHashCodeResult, telemetryWebSocketTextMsg.hashCode());
  }

  /**
   * Test {@link TelemetryWebSocketTextMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryWebSocketTextMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WebSocketSessionRef.WebSocketSessionRefBuilder webSocketSessionRefBuilder = mock(
        WebSocketSessionRef.WebSocketSessionRefBuilder.class);
    when(webSocketSessionRefBuilder.localAddress(Mockito.<InetSocketAddress>any()))
        .thenReturn(WebSocketSessionRef.builder());
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = webSocketSessionRefBuilder
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("Payload")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    TelemetryWebSocketTextMsg telemetryWebSocketTextMsg = new TelemetryWebSocketTextMsg(sessionRef, "Payload");
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult2 = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult2 = localAddressResult2
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef2 = remoteAddressResult2.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(telemetryWebSocketTextMsg, new TelemetryWebSocketTextMsg(sessionRef2, "Payload"));
  }

  /**
   * Test {@link TelemetryWebSocketTextMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryWebSocketTextMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WebSocketSessionRef.WebSocketSessionRefBuilder webSocketSessionRefBuilder = mock(
        WebSocketSessionRef.WebSocketSessionRefBuilder.class);
    when(webSocketSessionRefBuilder.localAddress(Mockito.<InetSocketAddress>any()))
        .thenReturn(WebSocketSessionRef.builder());
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = webSocketSessionRefBuilder
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    TelemetryWebSocketTextMsg telemetryWebSocketTextMsg = new TelemetryWebSocketTextMsg(sessionRef, null);
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult2 = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult2 = localAddressResult2
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef2 = remoteAddressResult2.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(telemetryWebSocketTextMsg, new TelemetryWebSocketTextMsg(sessionRef2, "Payload"));
  }

  /**
   * Test {@link TelemetryWebSocketTextMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryWebSocketTextMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WebSocketSessionRef.WebSocketSessionRefBuilder webSocketSessionRefBuilder = mock(
        WebSocketSessionRef.WebSocketSessionRefBuilder.class);
    when(webSocketSessionRefBuilder.localAddress(Mockito.<InetSocketAddress>any()))
        .thenReturn(WebSocketSessionRef.builder());
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = webSocketSessionRefBuilder
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();
    TelemetryWebSocketTextMsg telemetryWebSocketTextMsg = new TelemetryWebSocketTextMsg(sessionRef,
        "org.thingsboard.server.service.ws.telemetry.TelemetryWebSocketTextMsg");
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult2 = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult2 = localAddressResult2
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef2 = remoteAddressResult2.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(telemetryWebSocketTextMsg, new TelemetryWebSocketTextMsg(sessionRef2, "Payload"));
  }

  /**
   * Test {@link TelemetryWebSocketTextMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryWebSocketTextMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(new TelemetryWebSocketTextMsg(sessionRef, "Payload"), null);
  }

  /**
   * Test {@link TelemetryWebSocketTextMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryWebSocketTextMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act and Assert
    assertNotEquals(new TelemetryWebSocketTextMsg(sessionRef, "Payload"),
        "Different type to TelemetryWebSocketTextMsg");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TelemetryWebSocketTextMsg#TelemetryWebSocketTextMsg(WebSocketSessionRef, String)}
   *   <li>{@link TelemetryWebSocketTextMsg#toString()}
   *   <li>{@link TelemetryWebSocketTextMsg#getPayload()}
   *   <li>{@link TelemetryWebSocketTextMsg#getSessionRef()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act
    TelemetryWebSocketTextMsg actualTelemetryWebSocketTextMsg = new TelemetryWebSocketTextMsg(sessionRef, "Payload");
    String actualToStringResult = actualTelemetryWebSocketTextMsg.toString();
    String actualPayload = actualTelemetryWebSocketTextMsg.getPayload();

    // Assert
    assertEquals("Payload", actualPayload);
    assertEquals("TelemetryWebSocketTextMsg(sessionRef=[null][null][42], payload=Payload)", actualToStringResult);
    assertSame(sessionRef, actualTelemetryWebSocketTextMsg.getSessionRef());
  }
}
