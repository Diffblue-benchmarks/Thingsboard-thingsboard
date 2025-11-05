package org.thingsboard.rule.engine.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import io.netty.channel.DefaultEventLoop;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ThreadFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.rule.engine.credentials.AnonymousCredentials;

class TbRestApiCallNodeDiffblueTest {
  /**
   * Test {@link TbRestApiCallNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <p>Method under test: {@link TbRestApiCallNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRestApiCallNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration() throws TbNodeException {
    // Arrange
    TbRestApiCallNode tbRestApiCallNode = new TbRestApiCallNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSharedEventLoop()).thenReturn(new DefaultEventLoop(mock(ThreadFactory.class)));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbRestApiCallNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    verify(ctx).getSharedEventLoop();
    verify(ctx).isExternalNodeForceAck();
    TbHttpClient tbHttpClient = tbRestApiCallNode.httpClient;
    TbRestApiCallNodeConfiguration config = tbHttpClient.getConfig();
    assertTrue(config.getCredentials() instanceof AnonymousCredentials);
    assertNull(tbHttpClient.getEventLoopGroup());
    assertNull(config.getProxyHost());
    assertNull(config.getProxyPassword());
    assertNull(config.getProxyScheme());
    assertNull(config.getProxyUser());
    assertNull(config.getRequestMethod());
    assertNull(config.getRestEndpointUrlPattern());
    assertNull(config.getHeaders());
    assertNull(tbHttpClient.getSemaphore());
    assertEquals(0, config.getMaxInMemoryBufferSizeInKb());
    assertEquals(0, config.getMaxParallelRequestsCount());
    assertEquals(0, config.getProxyPort());
    assertEquals(0, config.getReadTimeoutMs());
    assertFalse(config.isEnableProxy());
    assertFalse(config.isIgnoreRequestBody());
    assertFalse(config.isParseToPlainText());
    assertFalse(config.isUseSimpleClientHttpFactory());
    assertFalse(config.isUseSystemProxyProperties());
  }

  /**
   * Test {@link TbRestApiCallNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then return Second iterator next.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); then return Second iterator next")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbRestApiCallNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_thenReturnSecondIteratorNext() throws TbNodeException {
    // Arrange
    TbRestApiCallNode tbRestApiCallNode = new TbRestApiCallNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("trimDoubleQuotes", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("parseToPlainText", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("maxInMemoryBufferSizeInKb", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbRestApiCallNode.upgrade(0, oldConfiguration).getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    JsonNode nextResult3 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult2 instanceof DoubleNode);
    assertEquals(nextResult, nextResult2);
    assertTrue(nextResult3 instanceof DoubleNode);
    assertEquals(nextResult, nextResult3);
  }

  /**
   * Test {@link TbRestApiCallNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then Second iterator next traverse return {@link TreeTraversingParser}.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); when one; then Second iterator next traverse return TreeTraversingParser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbRestApiCallNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_whenOne_thenSecondIteratorNextTraverseReturnTreeTraversingParser()
      throws TbNodeException {
    // Arrange
    TbRestApiCallNode tbRestApiCallNode = new TbRestApiCallNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("trimDoubleQuotes", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("parseToPlainText", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("maxInMemoryBufferSizeInKb", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbRestApiCallNode.upgrade(1, oldConfiguration).getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof DoubleNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof DoubleNode);
    JsonNode nextResult3 = iteratorResult.next();
    assertTrue(nextResult3 instanceof DoubleNode);
    assertTrue(second instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    assertEquals(nextResult, nextResult2);
    assertEquals(nextResult, nextResult3);
  }

  /**
   * Test {@link TbRestApiCallNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When two hundred fifty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when two hundred fifty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbRestApiCallNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_whenTwoHundredFiftySix() throws TbNodeException {
    // Arrange
    TbRestApiCallNode tbRestApiCallNode = new TbRestApiCallNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("trimDoubleQuotes", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("parseToPlainText", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("maxInMemoryBufferSizeInKb", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbRestApiCallNode.upgrade(256, oldConfiguration).getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof DoubleNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof DoubleNode);
    JsonNode nextResult3 = iteratorResult.next();
    assertTrue(nextResult3 instanceof DoubleNode);
    assertTrue(second instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    assertEquals(nextResult, nextResult2);
    assertEquals(nextResult, nextResult3);
  }

  /**
   * Test {@link TbRestApiCallNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then Second iterator next traverse return {@link TreeTraversingParser}.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); when two; then Second iterator next traverse return TreeTraversingParser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbRestApiCallNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_whenTwo_thenSecondIteratorNextTraverseReturnTreeTraversingParser()
      throws TbNodeException {
    // Arrange
    TbRestApiCallNode tbRestApiCallNode = new TbRestApiCallNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("trimDoubleQuotes", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("parseToPlainText", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("maxInMemoryBufferSizeInKb", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbRestApiCallNode.upgrade(2, oldConfiguration).getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof DoubleNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof DoubleNode);
    JsonNode nextResult3 = iteratorResult.next();
    assertTrue(nextResult3 instanceof DoubleNode);
    assertTrue(second instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    assertEquals(nextResult, nextResult2);
    assertEquals(nextResult, nextResult3);
  }

  /**
   * Test new {@link TbRestApiCallNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbRestApiCallNode}
   */
  @Test
  @DisplayName("Test new TbRestApiCallNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRestApiCallNode.<init>()"})
  void testNewTbRestApiCallNode() {
    // Arrange, Act and Assert
    assertNull(new TbRestApiCallNode().httpClient);
  }
}
