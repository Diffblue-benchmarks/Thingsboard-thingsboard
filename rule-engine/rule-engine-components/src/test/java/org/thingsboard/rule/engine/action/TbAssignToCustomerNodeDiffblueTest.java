package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbAssignToCustomerNodeDiffblueTest {
  /**
   * Test
   * {@link TbAssignToCustomerNode#loadCustomerNodeActionConfig(TbNodeConfiguration)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAssignToCustomerNode#loadCustomerNodeActionConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadCustomerNodeActionConfig(TbNodeConfiguration); then return 'null'")
  void testLoadCustomerNodeActionConfig_thenReturnNull() throws TbNodeException {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();

    // Act and Assert
    assertNull(tbAssignToCustomerNode.loadCustomerNodeActionConfig(new TbNodeConfiguration(null)));
  }

  /**
   * Test new {@link TbAssignToCustomerNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TbAssignToCustomerNode}
   */
  @Test
  @DisplayName("Test new TbAssignToCustomerNode (default constructor)")
  void testNewTbAssignToCustomerNode() {
    // Arrange, Act and Assert
    assertNull((new TbAssignToCustomerNode()).config);
  }
}
