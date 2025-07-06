package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbAbstractCustomerActionNodeDiffblueTest {
  /**
   * Test {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then return Second is {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   *       withExactBigDecimals {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); then return Second is ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractCustomerActionNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_thenReturnSecondIsArrayNodeWithNfIsWithExactBigDecimalsTrue() {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    ArrayNode oldConfiguration = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act and Assert
    assertSame(oldConfiguration, tbAssignToCustomerNode.upgrade(0, oldConfiguration).getSecond());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractCustomerActionNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_whenOne_thenReturnSecondIsValueOfTen() {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(oldConfiguration, tbAssignToCustomerNode.upgrade(1, oldConfiguration).getSecond());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbAbstractCustomerActionNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_whenValueOfTen_thenReturnSecondIsValueOfTen() {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(oldConfiguration, tbAssignToCustomerNode.upgrade(0, oldConfiguration).getSecond());
  }
}
