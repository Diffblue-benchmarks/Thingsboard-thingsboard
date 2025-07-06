package org.thingsboard.monitoring.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.IntNode;
import java.net.URI;
import java.nio.file.Paths;
import java.util.UUID;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.enums.ReadyState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WsClientDiffblueTest {
  /**
   * Test {@link WsClient#WsClient(URI, long)}.
   *
   * <ul>
   *   <li>Then Connection return {@link WebSocketImpl}.
   * </ul>
   *
   * <p>Method under test: {@link WsClient#WsClient(URI, long)}
   */
  @Test
  @DisplayName("Test new WsClient(URI, long); then Connection return WebSocketImpl")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WsClient.<init>(URI, long)"})
  void testNewWsClient_thenConnectionReturnWebSocketImpl() {
    // Arrange
    URI serverUri = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    WsClient actualWsClient = new WsClient(serverUri, 1L);

    // Assert
    assertTrue(actualWsClient.getConnection() instanceof WebSocketImpl);
    assertTrue(actualWsClient.getDraft() instanceof Draft_6455);
    assertEquals(
        "/C:/Users/sdodd/AppData/Local/Temp/test.txt", actualWsClient.getResourceDescriptor());
    assertNull(actualWsClient.lastMsg);
    assertNull(actualWsClient.getLocalSocketAddress());
    assertNull(actualWsClient.getRemoteSocketAddress());
    assertNull(actualWsClient.getSocket());
    assertNull(actualWsClient.getProtocol());
    assertEquals(60, actualWsClient.getConnectionLostTimeout());
    assertEquals(ReadyState.NOT_YET_CONNECTED, actualWsClient.getReadyState());
    assertFalse(actualWsClient.isDaemon());
    assertFalse(actualWsClient.isReuseAddr());
    assertFalse(actualWsClient.isTcpNoDelay());
    assertFalse(actualWsClient.hasBufferedData());
    assertFalse(actualWsClient.hasSSLSupport());
    assertFalse(actualWsClient.isClosed());
    assertFalse(actualWsClient.isClosing());
    assertFalse(actualWsClient.isFlushAndClose());
    assertFalse(actualWsClient.isOpen());
    assertSame(serverUri, actualWsClient.getURI());
  }

  /**
   * Test {@link WsClient#onMessage(String)} with {@code s}.
   *
   * <p>Method under test: {@link WsClient#onMessage(String)}
   */
  @Test
  @DisplayName("Test onMessage(String) with 's'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WsClient.onMessage(String)"})
  void testOnMessageWithS() {
    // Arrange
    new WsClient(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri(), 1L);

    WsClient wsClient =
        new WsClient(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri(), 1L);

    // Act
    wsClient.onMessage((String) null);

    // Assert that nothing has changed
    assertNull(wsClient.lastMsg);
  }

  /**
   * Test {@link WsClient#onMessage(String)} with {@code s}.
   *
   * <p>Method under test: {@link WsClient#onMessage(String)}
   */
  @Test
  @DisplayName("Test onMessage(String) with 's'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WsClient.onMessage(String)"})
  void testOnMessageWithS2() {
    // Arrange
    WsClient wsClient =
        new WsClient(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri(), 1L);

    // Act
    wsClient.onMessage("42");

    // Assert
    assertTrue(wsClient.lastMsg instanceof IntNode);
  }

  /**
   * Test {@link WsClient#getTelemetryUpdate(UUID, String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WsClient#getTelemetryUpdate(UUID, String)}
   */
  @Test
  @DisplayName("Test getTelemetryUpdate(UUID, String); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object WsClient.getTelemetryUpdate(UUID, String)"})
  void testGetTelemetryUpdate_thenReturnNull() {
    // Arrange
    WsClient wsClient =
        new WsClient(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri(), 1L);

    // Act and Assert
    assertNull(
        wsClient.getTelemetryUpdate(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Key"));
  }
}
