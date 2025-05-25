package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbAbstractCustomerActionNodeDiffblueTest {
  /**
   * Test {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>Then return Second is {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); then return Second is ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.util.TbPair TbAbstractCustomerActionNode.upgrade(int, JsonNode)"})
  void testUpgrade_thenReturnSecondIsArrayNodeWithNfIsWithExactBigDecimalsTrue() {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    ArrayNode oldConfiguration = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act and Assert
    assertSame(oldConfiguration, tbAssignToCustomerNode.upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then return Second is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when Instance; then return Second is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.util.TbPair TbAbstractCustomerActionNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenInstance_thenReturnSecondIsInstance() {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act and Assert
    assertSame(oldConfiguration, tbAssignToCustomerNode.upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Second is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAbstractCustomerActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return Second is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.common.data.util.TbPair TbAbstractCustomerActionNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenReturnSecondIsInstance() {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act and Assert
    assertSame(oldConfiguration, tbAssignToCustomerNode.upgrade(1, oldConfiguration).getSecond());
  }
}
