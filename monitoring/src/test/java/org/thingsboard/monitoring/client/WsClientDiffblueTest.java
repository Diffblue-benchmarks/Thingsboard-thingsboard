package org.thingsboard.monitoring.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.client.DnsResolver;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.extensions.DefaultExtension;
import org.java_websocket.extensions.IExtension;
import org.java_websocket.protocols.IProtocol;
import org.java_websocket.protocols.Protocol;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WsClientDiffblueTest {
  /**
   * Test {@link WsClient#WsClient(URI, long)}.
   * <p>
   * Method under test: {@link WsClient#WsClient(URI, long)}
   */
  @Test
  @DisplayName("Test new WsClient(URI, long)")
  void testNewWsClient() {
    // Arrange
    URI serverUri = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri();

    // Act
    WsClient actualWsClient = new WsClient(serverUri, 1L);

    // Assert
    WebSocket connection = actualWsClient.getConnection();
    assertTrue(connection instanceof WebSocketImpl);
    Draft draft = connection.getDraft();
    assertTrue(draft instanceof Draft_6455);
    Draft draft2 = actualWsClient.getDraft();
    assertTrue(draft2 instanceof Draft_6455);
    IExtension extension = ((Draft_6455) draft2).getExtension();
    assertTrue(extension instanceof DefaultExtension);
    List<IProtocol> knownProtocols = ((Draft_6455) draft2).getKnownProtocols();
    assertEquals(1, knownProtocols.size());
    IProtocol getResult = knownProtocols.get(0);
    assertTrue(getResult instanceof Protocol);
    assertEquals("", extension.getProvidedExtensionAsClient());
    assertEquals("", extension.getProvidedExtensionAsServer());
    assertEquals("", getResult.getProvidedProtocol());
    assertEquals("/C:/Users/sdodd/AppData/Local/Temp/test.txt", actualWsClient.getResourceDescriptor());
    assertNull(actualWsClient.lastMsg);
    assertNull(connection.getAttachment());
    assertNull(connection.getResourceDescriptor());
    assertNull(connection.getLocalSocketAddress());
    assertNull(connection.getRemoteSocketAddress());
    assertNull(actualWsClient.getLocalSocketAddress());
    assertNull(actualWsClient.getRemoteSocketAddress());
    assertNull(actualWsClient.getSocket());
    assertNull(((WebSocketImpl) connection).getChannel());
    assertNull(((WebSocketImpl) connection).getSelectionKey());
    assertNull(draft2.getRole());
    assertNull(connection.getProtocol());
    assertNull(actualWsClient.getProtocol());
    assertNull(((Draft_6455) draft2).getProtocol());
    assertNull(((WebSocketImpl) connection).getWorkerThread());
    List<IExtension> knownExtensions = ((Draft_6455) draft2).getKnownExtensions();
    assertEquals(1, knownExtensions.size());
    assertEquals(60, actualWsClient.getConnectionLostTimeout());
    assertEquals(CloseHandshakeType.TWOWAY, draft2.getCloseHandshakeType());
    assertEquals(ReadyState.NOT_YET_CONNECTED, connection.getReadyState());
    assertEquals(ReadyState.NOT_YET_CONNECTED, actualWsClient.getReadyState());
    assertFalse(actualWsClient.isDaemon());
    assertFalse(actualWsClient.isReuseAddr());
    assertFalse(actualWsClient.isTcpNoDelay());
    assertFalse(connection.hasBufferedData());
    assertFalse(connection.hasSSLSupport());
    assertFalse(connection.isClosed());
    assertFalse(connection.isClosing());
    assertFalse(connection.isFlushAndClose());
    assertFalse(connection.isOpen());
    assertFalse(actualWsClient.hasBufferedData());
    assertFalse(actualWsClient.hasSSLSupport());
    assertFalse(actualWsClient.isClosed());
    assertFalse(actualWsClient.isClosing());
    assertFalse(actualWsClient.isFlushAndClose());
    assertFalse(actualWsClient.isOpen());
    assertTrue(((WebSocketImpl) connection).inQueue.isEmpty());
    assertTrue(((WebSocketImpl) connection).outQueue.isEmpty());
    assertEquals(Integer.MAX_VALUE, ((Draft_6455) draft2).getMaxFrameSize());
    assertEquals(draft2, draft);
    assertSame(actualWsClient, ((WebSocketImpl) connection).getWebSocketListener());
    assertSame(serverUri, actualWsClient.getURI());
    assertSame(extension, knownExtensions.get(0));
  }

  /**
   * Test {@link WsClient#onMessage(String)} with {@code s}.
   * <p>
   * Method under test: {@link WsClient#onMessage(String)}
   */
  @Test
  @DisplayName("Test onMessage(String) with 's'")
  void testOnMessageWithS() {
    // Arrange
    WsClient wsClient = new WsClient(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri(), 1L);

    // Act
    wsClient.onMessage((String) null);

    // Assert that nothing has changed
    assertNull(wsClient.lastMsg);
  }

  /**
   * Test {@link WsClient#onMessage(String)} with {@code s}.
   * <p>
   * Method under test: {@link WsClient#onMessage(String)}
   */
  @Test
  @DisplayName("Test onMessage(String) with 's'")
  void testOnMessageWithS2() throws IOException {
    // Arrange
    WsClient wsClient = new WsClient(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri(), 1L);

    // Act
    wsClient.onMessage("42");

    // Assert
    JsonNode jsonNode = wsClient.lastMsg;
    assertTrue(jsonNode instanceof IntNode);
    JsonParser traverseResult = jsonNode.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", jsonNode.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, jsonNode.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, jsonNode.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(jsonNode.isArray());
    assertFalse(jsonNode.isBigDecimal());
    assertFalse(jsonNode.isBigInteger());
    assertFalse(jsonNode.isBinary());
    assertFalse(jsonNode.isBoolean());
    assertFalse(jsonNode.isContainerNode());
    assertFalse(jsonNode.isDouble());
    assertFalse(jsonNode.isFloat());
    assertFalse(jsonNode.isFloatingPointNumber());
    assertFalse(jsonNode.isLong());
    assertFalse(jsonNode.isMissingNode());
    assertFalse(jsonNode.isNull());
    assertFalse(jsonNode.isObject());
    assertFalse(jsonNode.isPojo());
    assertFalse(jsonNode.isShort());
    assertFalse(jsonNode.isTextual());
    assertFalse(((IntNode) jsonNode).isNaN());
    assertFalse(jsonNode.iterator().hasNext());
    assertTrue(jsonNode.isEmpty());
    assertTrue(jsonNode.isInt());
    assertTrue(jsonNode.isIntegralNumber());
    assertTrue(jsonNode.isNumber());
    assertTrue(jsonNode.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link WsClient#onMessage(String)} with {@code s}.
   * <p>
   * Method under test: {@link WsClient#onMessage(String)}
   */
  @Test
  @DisplayName("Test onMessage(String) with 's'")
  void testOnMessageWithS3() throws IOException {
    // Arrange
    WsClient wsClient = new WsClient(Paths.get(System.getProperty("java.io.tmpdir"), "foo").toUri(), 1L);

    // Act
    wsClient.onMessage("42");

    // Assert
    JsonNode jsonNode = wsClient.lastMsg;
    assertTrue(jsonNode instanceof IntNode);
    JsonParser traverseResult = jsonNode.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", jsonNode.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, jsonNode.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, jsonNode.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(jsonNode.isArray());
    assertFalse(jsonNode.isBigDecimal());
    assertFalse(jsonNode.isBigInteger());
    assertFalse(jsonNode.isBinary());
    assertFalse(jsonNode.isBoolean());
    assertFalse(jsonNode.isContainerNode());
    assertFalse(jsonNode.isDouble());
    assertFalse(jsonNode.isFloat());
    assertFalse(jsonNode.isFloatingPointNumber());
    assertFalse(jsonNode.isLong());
    assertFalse(jsonNode.isMissingNode());
    assertFalse(jsonNode.isNull());
    assertFalse(jsonNode.isObject());
    assertFalse(jsonNode.isPojo());
    assertFalse(jsonNode.isShort());
    assertFalse(jsonNode.isTextual());
    assertFalse(((IntNode) jsonNode).isNaN());
    assertFalse(jsonNode.iterator().hasNext());
    assertTrue(jsonNode.isEmpty());
    assertTrue(jsonNode.isInt());
    assertTrue(jsonNode.isIntegralNumber());
    assertTrue(jsonNode.isNumber());
    assertTrue(jsonNode.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link WsClient#getTelemetryUpdate(UUID, String)}.
   * <p>
   * Method under test: {@link WsClient#getTelemetryUpdate(UUID, String)}
   */
  @Test
  @DisplayName("Test getTelemetryUpdate(UUID, String)")
  void testGetTelemetryUpdate() {
    // Arrange
    WsClient wsClient = new WsClient(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri(), 1L);

    // Act and Assert
    assertNull(wsClient.getTelemetryUpdate(UUID.randomUUID(), "Key"));
  }

  /**
   * Test {@link WsClient#getTelemetryUpdate(UUID, String)}.
   * <p>
   * Method under test: {@link WsClient#getTelemetryUpdate(UUID, String)}
   */
  @Test
  @DisplayName("Test getTelemetryUpdate(UUID, String)")
  void testGetTelemetryUpdate2() {
    // Arrange
    WsClient wsClient = new WsClient(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toUri(), 1L);
    wsClient.setDnsResolver(mock(DnsResolver.class));

    // Act and Assert
    assertNull(wsClient.getTelemetryUpdate(UUID.randomUUID(), "Key"));
  }
}
