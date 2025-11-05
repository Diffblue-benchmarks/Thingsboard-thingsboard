package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;

class TbAbstractCustomerActionNodeDiffblueTest {
  /**
   * Test {@link TbAbstractCustomerActionNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractCustomerActionNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenThrowRuntimeException() {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbAssignToCustomerNode.onMsg(ctx, msg));
  }

  /**
   * Test {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then not {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals
   *       {@code true} iterator hasNext.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); then not ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' iterator hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractCustomerActionNode.upgrade(int, JsonNode)"})
  void testUpgrade_thenNotArrayNodeWithNfIsWithExactBigDecimalsTrueIteratorHasNext() {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode oldConfiguration = new ArrayNode(nf);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        tbAssignToCustomerNode.upgrade(0, oldConfiguration);

    // Assert
    assertFalse(oldConfiguration.iterator().hasNext());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is withExactBigDecimals
   *       {@code true} size is zero.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); then ObjectNode(JsonNodeFactory) with nc is withExactBigDecimals 'true' size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractCustomerActionNode.upgrade(int, JsonNode)"})
  void testUpgrade_thenObjectNodeWithNcIsWithExactBigDecimalsTrueSizeIsZero() {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("customerCacheExpiration", DoubleNode.valueOf(10.0d));

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        tbAssignToCustomerNode.upgrade(0, oldConfiguration);

    // Assert
    assertEquals(0, oldConfiguration.size());
    assertFalse(oldConfiguration.iterator().hasNext());
    assertTrue(oldConfiguration.isEmpty());
    assertTrue(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractCustomerActionNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenReturnSecondIsValueOfTen() {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(
        oldConfiguration, new TbAssignToCustomerNode().upgrade(1, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when valueOf ten; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbAbstractCustomerActionNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenValueOfTen_thenReturnSecondIsValueOfTen() {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(
        oldConfiguration, new TbAssignToCustomerNode().upgrade(0, oldConfiguration).getSecond());
  }
}
