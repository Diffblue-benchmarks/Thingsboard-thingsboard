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
   * <p>Method under test: {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractTransformNodeWithTbMsgSource.upgrade(int, JsonNode)"})
  void testUpgrade() throws TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("fromMetadata", DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCopyKeysNode.upgrade(0, oldConfiguration));
  }

  /**
   * Test {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}.
   *
   * <p>Method under test: {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractTransformNodeWithTbMsgSource.upgrade(int, JsonNode)"})
  void testUpgrade2() throws TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("fromMetadata", DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCopyKeysNode.upgrade(1, oldConfiguration));
  }

  /**
   * Test {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@code copyFrom}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); given 'copyFrom'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractTransformNodeWithTbMsgSource.upgrade(int, JsonNode)"})
  void testUpgrade_givenCopyFrom() throws TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("copyFrom", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbCopyKeysNode.upgrade(1, oldConfiguration).getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof DoubleNode);
    assertTrue(second instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
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
    oldConfiguration.put("fromMetadata", MissingNode.getInstance());

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCopyKeysNode.upgrade(1, oldConfiguration));
  }

  /**
   * Test {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); given TRUE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractTransformNodeWithTbMsgSource.upgrade(int, JsonNode)"})
  void testUpgrade_givenTrueToString() throws TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put(Boolean.TRUE.toString(), DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCopyKeysNode.upgrade(0, oldConfiguration));
  }

  /**
   * Test {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); given TRUE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractTransformNodeWithTbMsgSource.upgrade(int, JsonNode)"})
  void testUpgrade_givenTrueToString2() throws TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put(Boolean.TRUE.toString(), DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCopyKeysNode.upgrade(1, oldConfiguration));
  }

  /**
   * Test {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   *   <li>When minus one.
   *   <li>Then Second iterator next return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given valueOf ten; when minus one; then Second iterator next return DoubleNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractTransformNodeWithTbMsgSource.upgrade(int, JsonNode)"})
  void testUpgrade_givenValueOfTen_whenMinusOne_thenSecondIteratorNextReturnDoubleNode()
      throws TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("fromMetadata", DoubleNode.valueOf(10.0d));

    // Act and Assert
    JsonNode second = tbCopyKeysNode.upgrade(-1, oldConfiguration).getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof DoubleNode);
    assertTrue(second instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(second.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is withExactBigDecimals
   *       {@code true} {@code fromMetadata} is False.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); when ObjectNode(JsonNodeFactory) with nc is withExactBigDecimals 'true' 'fromMetadata' is False")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractTransformNodeWithTbMsgSource.upgrade(int, JsonNode)"})
  void testUpgrade_whenObjectNodeWithNcIsWithExactBigDecimalsTrueFromMetadataIsFalse()
      throws TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
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
   *   <li>When {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is withExactBigDecimals
   *       {@code true} {@code fromMetadata} is True.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractTransformNodeWithTbMsgSource#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); when ObjectNode(JsonNodeFactory) with nc is withExactBigDecimals 'true' 'fromMetadata' is True")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractTransformNodeWithTbMsgSource.upgrade(int, JsonNode)"})
  void testUpgrade_whenObjectNodeWithNcIsWithExactBigDecimalsTrueFromMetadataIsTrue()
      throws TbNodeException {
    // Arrange
    TbCopyKeysNode tbCopyKeysNode = new TbCopyKeysNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
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
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isNumber());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isTextual());
    assertTrue(actualUpgradeResult.getFirst());
  }
}
