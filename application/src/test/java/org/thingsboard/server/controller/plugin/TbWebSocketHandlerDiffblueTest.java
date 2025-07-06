package org.thingsboard.server.controller.plugin;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.security.InvalidParameterException;
import org.apache.kafka.common.network.NetworkReceive;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.adapter.standard.StandardWebSocketSession;
import org.springframework.web.socket.handler.ConcurrentWebSocketSessionDecorator;
import org.springframework.web.socket.handler.WebSocketSessionDecorator;
import org.thingsboard.server.service.ws.WebSocketSessionRef;

@ExtendWith(MockitoExtension.class)
class TbWebSocketHandlerDiffblueTest {
  @InjectMocks private TbWebSocketHandler tbWebSocketHandler;

  /**
   * Test {@link TbWebSocketHandler#handleTextMessage(WebSocketSession, TextMessage)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link TbWebSocketHandler#handleTextMessage(WebSocketSession,
   * TextMessage)}
   */
  @Test
  @DisplayName(
      "Test handleTextMessage(WebSocketSession, TextMessage); then throw InvalidParameterException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbWebSocketHandler.handleTextMessage(WebSocketSession, TextMessage)"})
  void testHandleTextMessage_thenThrowInvalidParameterException() {
    // Arrange
    StandardWebSocketSession delegate = mock(StandardWebSocketSession.class);
    when(delegate.getId()).thenThrow(new InvalidParameterException("foo"));
    WebSocketSessionDecorator session =
        new WebSocketSessionDecorator(new ConcurrentWebSocketSessionDecorator(delegate, 3, 3));

    // Act and Assert
    assertThrows(
        InvalidParameterException.class,
        () ->
            tbWebSocketHandler.handleTextMessage(
                session, new TextMessage(NetworkReceive.UNKNOWN_SOURCE)));
    verify(delegate).getId();
  }

  /**
   * Test {@link TbWebSocketHandler#handlePongMessage(WebSocketSession, PongMessage)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link TbWebSocketHandler#handlePongMessage(WebSocketSession,
   * PongMessage)}
   */
  @Test
  @DisplayName(
      "Test handlePongMessage(WebSocketSession, PongMessage); then throw InvalidParameterException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbWebSocketHandler.handlePongMessage(WebSocketSession, PongMessage)"})
  void testHandlePongMessage_thenThrowInvalidParameterException() throws Exception {
    // Arrange
    StandardWebSocketSession delegate = mock(StandardWebSocketSession.class);
    when(delegate.getId()).thenThrow(new InvalidParameterException("foo"));
    WebSocketSessionDecorator session =
        new WebSocketSessionDecorator(new ConcurrentWebSocketSessionDecorator(delegate, 3, 3));

    // Act and Assert
    assertThrows(
        InvalidParameterException.class,
        () -> tbWebSocketHandler.handlePongMessage(session, new PongMessage()));
    verify(delegate).getId();
  }

  /**
   * Test {@link TbWebSocketHandler#handleTransportError(WebSocketSession, Throwable)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link TbWebSocketHandler#handleTransportError(WebSocketSession,
   * Throwable)}
   */
  @Test
  @DisplayName(
      "Test handleTransportError(WebSocketSession, Throwable); then throw InvalidParameterException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbWebSocketHandler.handleTransportError(WebSocketSession, Throwable)"})
  void testHandleTransportError_thenThrowInvalidParameterException() throws Exception {
    // Arrange
    StandardWebSocketSession delegate = mock(StandardWebSocketSession.class);
    when(delegate.getId()).thenThrow(new InvalidParameterException("foo"));
    WebSocketSessionDecorator session =
        new WebSocketSessionDecorator(new ConcurrentWebSocketSessionDecorator(delegate, 3, 3));

    // Act and Assert
    assertThrows(
        InvalidParameterException.class,
        () -> tbWebSocketHandler.handleTransportError(session, new Throwable()));
    verify(delegate).getId();
  }

  /**
   * Test {@link TbWebSocketHandler#send(WebSocketSessionRef, int, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then calls {@link WebSocketSessionRef#getSessionId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbWebSocketHandler#send(WebSocketSessionRef, int, String)}
   */
  @Test
  @DisplayName("Test send(WebSocketSessionRef, int, String); given '42'; then calls getSessionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbWebSocketHandler.send(WebSocketSessionRef, int, String)"})
  void testSend_given42_thenCallsGetSessionId() throws IOException {
    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSessionId()).thenReturn("42");

    // Act
    tbWebSocketHandler.send(sessionRef, 1, "Msg");

    // Assert
    verify(sessionRef).getSessionId();
  }

  /**
   * Test {@link TbWebSocketHandler#sendPing(WebSocketSessionRef, long)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then calls {@link WebSocketSessionRef#getSessionId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbWebSocketHandler#sendPing(WebSocketSessionRef, long)}
   */
  @Test
  @DisplayName("Test sendPing(WebSocketSessionRef, long); given '42'; then calls getSessionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbWebSocketHandler.sendPing(WebSocketSessionRef, long)"})
  void testSendPing_given42_thenCallsGetSessionId() throws IOException {
    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSessionId()).thenReturn("42");

    // Act
    tbWebSocketHandler.sendPing(sessionRef, 1L);

    // Assert
    verify(sessionRef).getSessionId();
  }

  /**
   * Test {@link TbWebSocketHandler#close(WebSocketSessionRef, CloseStatus)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then calls {@link WebSocketSessionRef#getSessionId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbWebSocketHandler#close(WebSocketSessionRef, CloseStatus)}
   */
  @Test
  @DisplayName(
      "Test close(WebSocketSessionRef, CloseStatus); given '42'; then calls getSessionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbWebSocketHandler.close(WebSocketSessionRef, CloseStatus)"})
  void testClose_given42_thenCallsGetSessionId() throws IOException {
    // Arrange
    WebSocketSessionRef sessionRef = mock(WebSocketSessionRef.class);
    when(sessionRef.getSessionId()).thenReturn("42");

    // Act
    tbWebSocketHandler.close(sessionRef, null);

    // Assert
    verify(sessionRef).getSessionId();
  }

  /**
   * Test {@link TbWebSocketHandler#isOpen(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbWebSocketHandler#isOpen(String)}
   */
  @Test
  @DisplayName("Test isOpen(String); when '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbWebSocketHandler.isOpen(String)"})
  void testIsOpen_when42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(tbWebSocketHandler.isOpen("42"));
  }
}
