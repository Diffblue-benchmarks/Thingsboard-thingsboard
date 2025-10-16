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
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.DefaultPromise;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
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
    when(ctx.getSharedEventLoop()).thenReturn(new DefaultEventLoop());
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
  void testInitWithCtxConfiguration2() throws TbNodeException {
    // Arrange
    TbRestApiCallNode tbRestApiCallNode = new TbRestApiCallNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSharedEventLoop()).thenReturn(null);
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
    EventLoopGroup eventLoopGroup = tbRestApiCallNode.httpClient.getEventLoopGroup();
    assertTrue(eventLoopGroup.next() instanceof NioEventLoop);
    assertTrue(eventLoopGroup instanceof NioEventLoopGroup);
    assertTrue(eventLoopGroup.terminationFuture() instanceof DefaultPromise);
    assertFalse(eventLoopGroup.isShuttingDown());
    assertFalse(eventLoopGroup.isShutdown());
    assertFalse(eventLoopGroup.isTerminated());
    assertTrue(eventLoopGroup.iterator().hasNext());
  }

  /**
   * Test {@link TbRestApiCallNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then Second traverse return {@link TreeTraversingParser}.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); when one; then Second traverse return TreeTraversingParser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbRestApiCallNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_whenOne_thenSecondTraverseReturnTreeTraversingParser() throws TbNodeException {
    // Arrange
    TbRestApiCallNode tbRestApiCallNode = new TbRestApiCallNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("trimDoubleQuotes", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("parseToPlainText", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("maxInMemoryBufferSizeInKb", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("trimDoubleQuotes", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbRestApiCallNode.upgrade(1, oldConfiguration).getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof DoubleNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof DoubleNode);
    assertTrue(iteratorResult.next() instanceof DoubleNode);
    assertTrue(second instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link TbRestApiCallNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When two hundred fifty-six.
   *   <li>Then Second traverse return {@link TreeTraversingParser}.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); when two hundred fifty-six; then Second traverse return TreeTraversingParser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbRestApiCallNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_whenTwoHundredFiftySix_thenSecondTraverseReturnTreeTraversingParser()
      throws TbNodeException {
    // Arrange
    TbRestApiCallNode tbRestApiCallNode = new TbRestApiCallNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("trimDoubleQuotes", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("parseToPlainText", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("maxInMemoryBufferSizeInKb", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("trimDoubleQuotes", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbRestApiCallNode.upgrade(256, oldConfiguration).getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof DoubleNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof DoubleNode);
    assertTrue(iteratorResult.next() instanceof DoubleNode);
    assertTrue(second instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link TbRestApiCallNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then Second traverse return {@link TreeTraversingParser}.
   * </ul>
   *
   * <p>Method under test: {@link TbRestApiCallNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); when two; then Second traverse return TreeTraversingParser")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbRestApiCallNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_whenTwo_thenSecondTraverseReturnTreeTraversingParser() throws TbNodeException {
    // Arrange
    TbRestApiCallNode tbRestApiCallNode = new TbRestApiCallNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("trimDoubleQuotes", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("parseToPlainText", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("maxInMemoryBufferSizeInKb", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("trimDoubleQuotes", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbRestApiCallNode.upgrade(2, oldConfiguration).getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof DoubleNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof DoubleNode);
    assertTrue(iteratorResult.next() instanceof DoubleNode);
    assertTrue(second instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
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
