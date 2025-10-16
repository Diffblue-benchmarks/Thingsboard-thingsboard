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
package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.util.TbPair;

class TbAbstractTransformNodeWithTbMsgSourceDiffblueTest {
  /**
   * Test {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@code fromMetadata}.
   *   <li>When one.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given 'fromMetadata'; when one; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractTransformNodeWithTbMsgSource.upgrade(int, JsonNode)"})
  void testUpgrade_givenFromMetadata_whenOne_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("fromMetadata", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("fromMetadata", DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCopyKeysNode.upgrade(1, oldConfiguration));
  }

  /**
   * Test {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@code fromMetadata}.
   *   <li>When zero.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given 'fromMetadata'; when zero; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractTransformNodeWithTbMsgSource.upgrade(int, JsonNode)"})
  void testUpgrade_givenFromMetadata_whenZero_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("fromMetadata", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("fromMetadata", DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCopyKeysNode.upgrade(0, oldConfiguration));
  }

  /**
   * Test {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given Instance.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); given Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractTransformNodeWithTbMsgSource.upgrade(int, JsonNode)"})
  void testUpgrade_givenInstance() throws TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("fromMetadata", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("fromMetadata", MissingNode.getInstance());

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCopyKeysNode.upgrade(0, oldConfiguration));
  }

  /**
   * Test {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given Instance.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); given Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractTransformNodeWithTbMsgSource.upgrade(int, JsonNode)"})
  void testUpgrade_givenInstance2() throws TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("fromMetadata", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("fromMetadata", MissingNode.getInstance());

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCopyKeysNode.upgrade(1, oldConfiguration));
  }

  /**
   * Test {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then return Second iterator next toPrettyString is {@code "DATA"}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); then return Second iterator next toPrettyString is '\"DATA\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractTransformNodeWithTbMsgSource.upgrade(int, JsonNode)"})
  void testUpgrade_thenReturnSecondIteratorNextToPrettyStringIsData() throws TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("fromMetadata", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("fromMetadata", BooleanNode.getFalse());

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbCopyKeysNode.upgrade(0, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertEquals("\"DATA\"", nextResult.toPrettyString());
    assertEquals("{\n  \"copyFrom\" : \"DATA\"\n}", second.toPrettyString());
    assertEquals("{\n  \"copyFrom\" : \"DATA\"\n}", oldConfiguration.toPrettyString());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isTextual());
    assertTrue(actualUpgradeResult.getFirst());
  }

  /**
   * Test {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then return Second iterator next toPrettyString is {@code "METADATA"}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); then return Second iterator next toPrettyString is '\"METADATA\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractTransformNodeWithTbMsgSource.upgrade(int, JsonNode)"})
  void testUpgrade_thenReturnSecondIteratorNextToPrettyStringIsMetadata() throws TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("fromMetadata", DoubleNode.valueOf(10.0d));
    oldConfiguration.put("fromMetadata", BooleanNode.getTrue());

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbCopyKeysNode.upgrade(0, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertEquals("\"METADATA\"", nextResult.toPrettyString());
    assertEquals("{\n  \"copyFrom\" : \"METADATA\"\n}", second.toPrettyString());
    assertEquals("{\n  \"copyFrom\" : \"METADATA\"\n}", oldConfiguration.toPrettyString());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isTextual());
    assertTrue(actualUpgradeResult.getFirst());
  }

  /**
   * Test {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then Second iterator next return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); when minus one; then Second iterator next return DoubleNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractTransformNodeWithTbMsgSource.upgrade(int, JsonNode)"})
  void testUpgrade_whenMinusOne_thenSecondIteratorNextReturnDoubleNode() throws TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    DoubleNode value = DoubleNode.valueOf(10.0d);
    oldConfiguration.put("fromMetadata", value);
    oldConfiguration.put("fromMetadata", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbCopyKeysNode.upgrade(-1, oldConfiguration).getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof DoubleNode);
    assertTrue(second instanceof ObjectNode);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertEquals("{\n  \"fromMetadata\" : 10.0\n}", second.toPrettyString());
    assertFalse(iteratorResult.hasNext());
    assertEquals(value, nextResult);
  }
}
