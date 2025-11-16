/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.monitoring.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.IntNode;
import java.io.File;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WsClient.<init>(URI, long)"})
  void testNewWsClient_thenConnectionReturnWebSocketImpl() {
    // Arrange
    URI serverUri = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    WsClient actualWsClient = new WsClient(serverUri, 1L);

    // Assert
    assertTrue(actualWsClient.getConnection() instanceof WebSocketImpl);
    assertTrue(actualWsClient.getDraft() instanceof Draft_6455);
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
    assertEquals(
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")
            .toString()
            .concat(File.separator),
        actualWsClient.getResourceDescriptor());
    assertSame(serverUri, actualWsClient.getURI());
  }

  /**
   * Test {@link WsClient#WsClient(URI, long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link WsClient#WsClient(URI, long)}
   */
  @Test
  @DisplayName("Test new WsClient(URI, long); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WsClient.<init>(URI, long)"})
  void testNewWsClient_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new WsClient(null, 1L));
  }

  /**
   * Test {@link WsClient#onMessage(String)} with {@code s}.
   *
   * <p>Method under test: {@link WsClient#onMessage(String)}
   */
  @Test
  @DisplayName("Test onMessage(String) with 's'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * <p>Method under test: {@link WsClient#getTelemetryUpdate(UUID, String)}
   */
  @Test
  @DisplayName("Test getTelemetryUpdate(UUID, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Object WsClient.getTelemetryUpdate(UUID, String)"})
  void testGetTelemetryUpdate() {
    // Arrange
    WsClient wsClient =
        new WsClient(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri(), 1L);

    // Act and Assert
    assertNull(wsClient.getTelemetryUpdate(UUID.randomUUID(), "Key"));
  }
}
