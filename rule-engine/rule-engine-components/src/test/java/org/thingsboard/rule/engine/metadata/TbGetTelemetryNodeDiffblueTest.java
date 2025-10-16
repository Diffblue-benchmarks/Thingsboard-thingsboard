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
package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;

class TbGetTelemetryNodeDiffblueTest {
  /**
   * Test {@link TbGetTelemetryNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code START_OBJECT}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code START_OBJECT}.
   *   <li>Then calls {@link ArrayNode#fields()}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; when ArrayNode asToken() return 'START_OBJECT'; then calls fields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGetTelemetryNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartObject_whenArrayNodeAsTokenReturnStartObject_thenCallsFields()
      throws TbNodeException {
    // Arrange
    TbGetTelemetryNode tbGetTelemetryNode = new TbGetTelemetryNode();
    TbContext ctx = mock(TbContext.class);

    ArrayNode data = mock(ArrayNode.class);
    when(data.fields()).thenThrow(new RuntimeException());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbGetTelemetryNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbGetTelemetryNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode} {@link ArrayNode#elements()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link ArrayNode#elements()}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when ArrayNode elements() throw RuntimeException(); then calls elements()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGetTelemetryNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenArrayNodeElementsThrowRuntimeException_thenCallsElements()
      throws TbNodeException {
    // Arrange
    TbGetTelemetryNode tbGetTelemetryNode = new TbGetTelemetryNode();
    TbContext ctx = mock(TbContext.class);

    ArrayNode data = mock(ArrayNode.class);
    when(data.elements()).thenThrow(new RuntimeException());
    when(data.asToken()).thenReturn(JsonToken.START_ARRAY);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbGetTelemetryNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).elements();
  }

  /**
   * Test {@link TbGetTelemetryNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>Then Second iterator next return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given Instance; then Second iterator next return DoubleNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbGetTelemetryNode.upgrade(int, JsonNode)"})
  void testUpgrade_givenInstance_thenSecondIteratorNextReturnDoubleNode() throws TbNodeException {
    // Arrange
    TbGetTelemetryNode tbGetTelemetryNode = new TbGetTelemetryNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    DoubleNode value = DoubleNode.valueOf(10.0d);
    oldConfiguration.put("orderBy", value);
    DoubleNode value2 = DoubleNode.valueOf(10.0d);
    oldConfiguration.put("aggregation", value2);
    oldConfiguration.put("fetchMode", NullNode.getInstance());

    // Act and Assert
    JsonNode second = tbGetTelemetryNode.upgrade(0, oldConfiguration).getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    JsonNode actualNextResult = iteratorResult.next();
    JsonNode nextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult instanceof DoubleNode);
    assertSame(value, nextResult);
    assertSame(value2, actualNextResult);
    assertTrue(nextResult2 instanceof NullNode);
    assertSame(NullNode.instance, nextResult2);
    assertEquals(
        "{\n  \"orderBy\" : 10.0,\n  \"aggregation\" : 10.0,\n  \"fetchMode\" : null\n}",
        second.toPrettyString());
  }

  /**
   * Test {@link TbGetTelemetryNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>Then Second iterator next return {@link TextNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given Instance; then Second iterator next return TextNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbGetTelemetryNode.upgrade(int, JsonNode)"})
  void testUpgrade_givenInstance_thenSecondIteratorNextReturnTextNode() throws TbNodeException {
    // Arrange
    TbGetTelemetryNode tbGetTelemetryNode = new TbGetTelemetryNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("orderBy", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("aggregation", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("fetchMode", MissingNode.getInstance());

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbGetTelemetryNode.upgrade(0, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertEquals(
        "{\n  \"orderBy\" : \"DESC\",\n  \"aggregation\" : \"NONE\",\n  \"fetchMode\" : \"LAST\"\n}",
        second.toPrettyString());
    assertEquals(
        "{\n  \"orderBy\" : \"DESC\",\n  \"aggregation\" : \"NONE\",\n  \"fetchMode\" : \"LAST\"\n}",
        oldConfiguration.toPrettyString());
    assertFalse(iteratorResult.hasNext());
    assertTrue(actualUpgradeResult.getFirst());
  }

  /**
   * Test {@link TbGetTelemetryNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then return Second is {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   *       withExactBigDecimals {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); then return Second is ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbGetTelemetryNode.upgrade(int, JsonNode)"})
  void testUpgrade_thenReturnSecondIsArrayNodeWithNfIsWithExactBigDecimalsTrue()
      throws TbNodeException {
    // Arrange
    TbGetTelemetryNode tbGetTelemetryNode = new TbGetTelemetryNode();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode oldConfiguration = new ArrayNode(nf);

    // Act and Assert
    assertSame(oldConfiguration, tbGetTelemetryNode.upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbGetTelemetryNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is withExactBigDecimals
   *       {@code true} {@code fetchMode} is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); when ObjectNode(JsonNodeFactory) with nc is withExactBigDecimals 'true' 'fetchMode' is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbGetTelemetryNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenObjectNodeWithNcIsWithExactBigDecimalsTrueFetchModeIsValueOfTen()
      throws TbNodeException {
    // Arrange
    TbGetTelemetryNode tbGetTelemetryNode = new TbGetTelemetryNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("orderBy", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("aggregation", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("fetchMode", DoubleNode.valueOf(10.0d));

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbGetTelemetryNode.upgrade(0, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertEquals(
        "{\n  \"orderBy\" : \"DESC\",\n  \"aggregation\" : \"NONE\",\n  \"fetchMode\" : \"LAST\"\n}",
        second.toPrettyString());
    assertEquals(
        "{\n  \"orderBy\" : \"DESC\",\n  \"aggregation\" : \"NONE\",\n  \"fetchMode\" : \"LAST\"\n}",
        oldConfiguration.toPrettyString());
    assertFalse(iteratorResult.hasNext());
    assertTrue(actualUpgradeResult.getFirst());
  }

  /**
   * Test {@link TbGetTelemetryNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbGetTelemetryNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenReturnSecondIsValueOfTen() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(oldConfiguration, new TbGetTelemetryNode().upgrade(1, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbGetTelemetryNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbGetTelemetryNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when valueOf ten; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbGetTelemetryNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenValueOfTen_thenReturnSecondIsValueOfTen() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(oldConfiguration, new TbGetTelemetryNode().upgrade(0, oldConfiguration).getSecond());
  }
}
