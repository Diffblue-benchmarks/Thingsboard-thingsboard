package org.thingsboard.server.controller.plugin;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.socket.CloseStatus;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.ws.WebSocketSessionRef;
import org.thingsboard.server.service.ws.WebSocketSessionRef.WebSocketSessionRefBuilder;
import org.thingsboard.server.service.ws.WebSocketSessionType;

class TbWebSocketHandlerDiffblueTest {
  /**
   * Test {@link TbWebSocketHandler#send(WebSocketSessionRef, int, String)}.
   * <ul>
   *   <li>Then calls
   * {@link WebSocketSessionRefBuilder#localAddress(InetSocketAddress)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbWebSocketHandler#send(WebSocketSessionRef, int, String)}
   */
  @Test
  @DisplayName("Test send(WebSocketSessionRef, int, String); then calls localAddress(InetSocketAddress)")
  void testSend_thenCallsLocalAddress() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbWebSocketHandler tbWebSocketHandler = new TbWebSocketHandler();
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

    // Act
    tbWebSocketHandler.send(sessionRef, 1, "Msg");

    // Assert that nothing has changed
    verify(webSocketSessionRefBuilder).localAddress(isA(InetSocketAddress.class));
  }

  /**
   * Test {@link TbWebSocketHandler#sendPing(WebSocketSessionRef, long)}.
   * <ul>
   *   <li>Then calls
   * {@link WebSocketSessionRefBuilder#localAddress(InetSocketAddress)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbWebSocketHandler#sendPing(WebSocketSessionRef, long)}
   */
  @Test
  @DisplayName("Test sendPing(WebSocketSessionRef, long); then calls localAddress(InetSocketAddress)")
  void testSendPing_thenCallsLocalAddress() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbWebSocketHandler tbWebSocketHandler = new TbWebSocketHandler();
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

    // Act
    tbWebSocketHandler.sendPing(sessionRef, 1L);

    // Assert that nothing has changed
    verify(webSocketSessionRefBuilder).localAddress(isA(InetSocketAddress.class));
  }

  /**
   * Test {@link TbWebSocketHandler#close(WebSocketSessionRef, CloseStatus)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link WebSocketSessionRef}
   * {@link WebSocketSessionRef#getSessionId()} return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbWebSocketHandler#close(WebSocketSessionRef, CloseStatus)}
   */
  @Test
  @DisplayName("Test close(WebSocketSessionRef, CloseStatus); given '42'; when WebSocketSessionRef getSessionId() return '42'")
  void testClose_given42_whenWebSocketSessionRefGetSessionIdReturn42() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbWebSocketHandler tbWebSocketHandler = new TbWebSocketHandler();
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSessionId()).thenReturn("42");

    // Act
    tbWebSocketHandler.close(sessionRef, null);

    // Assert
    verify(sessionRef).getSessionId();
  }

  /**
   * Test {@link TbWebSocketHandler#close(WebSocketSessionRef, CloseStatus)}.
   * <ul>
   *   <li>Then throw {@link InvalidParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbWebSocketHandler#close(WebSocketSessionRef, CloseStatus)}
   */
  @Test
  @DisplayName("Test close(WebSocketSessionRef, CloseStatus); then throw InvalidParameterException")
  void testClose_thenThrowInvalidParameterException() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbWebSocketHandler tbWebSocketHandler = new TbWebSocketHandler();
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSessionId()).thenThrow(new InvalidParameterException("{} Processing close request"));

    // Act and Assert
    assertThrows(InvalidParameterException.class, () -> tbWebSocketHandler.close(sessionRef, null));
    verify(sessionRef).getSessionId();
  }
}
