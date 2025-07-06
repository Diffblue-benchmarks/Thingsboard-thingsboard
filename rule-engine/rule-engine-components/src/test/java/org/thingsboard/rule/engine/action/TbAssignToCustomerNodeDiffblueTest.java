package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbAssignToCustomerNodeDiffblueTest {
  /**
   * Test {@link TbAssignToCustomerNode#loadCustomerNodeActionConfig(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAssignToCustomerNode#loadCustomerNodeActionConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadCustomerNodeActionConfig(TbNodeConfiguration); when POJONode(Object) with v is 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbAssignToCustomerNodeConfiguration TbAssignToCustomerNode.loadCustomerNodeActionConfig(TbNodeConfiguration)"
  })
  void testLoadCustomerNodeActionConfig_whenPOJONodeWithVIsNull_thenReturnNull()
      throws TbNodeException {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();

    // Act and Assert
    assertNull(
        tbAssignToCustomerNode.loadCustomerNodeActionConfig(
            new TbNodeConfiguration(new POJONode(null))));
  }

  /**
   * Test new {@link TbAssignToCustomerNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbAssignToCustomerNode}
   */
  @Test
  @DisplayName("Test new TbAssignToCustomerNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbAssignToCustomerNode.<init>()"})
  void testNewTbAssignToCustomerNode() {
    // Arrange, Act and Assert
    assertNull(new TbAssignToCustomerNode().config);
  }
}
