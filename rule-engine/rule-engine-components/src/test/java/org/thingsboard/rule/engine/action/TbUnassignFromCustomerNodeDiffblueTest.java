package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbUnassignFromCustomerNodeDiffblueTest {
  /**
   * Test {@link TbUnassignFromCustomerNode#createCustomerIfNotExists()}.
   *
   * <p>Method under test: {@link TbUnassignFromCustomerNode#createCustomerIfNotExists()}
   */
  @Test
  @DisplayName("Test createCustomerIfNotExists()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbUnassignFromCustomerNode.createCustomerIfNotExists()"})
  void testCreateCustomerIfNotExists() {
    // Arrange, Act and Assert
    assertFalse(new TbUnassignFromCustomerNode().createCustomerIfNotExists());
  }

  /**
   * Test {@link TbUnassignFromCustomerNode#loadCustomerNodeActionConfig(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbUnassignFromCustomerNode#loadCustomerNodeActionConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadCustomerNodeActionConfig(TbNodeConfiguration); when POJONode(Object) with v is 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbUnassignFromCustomerNodeConfiguration TbUnassignFromCustomerNode.loadCustomerNodeActionConfig(TbNodeConfiguration)"
  })
  void testLoadCustomerNodeActionConfig_whenPOJONodeWithVIsNull_thenReturnNull()
      throws TbNodeException {
    // Arrange
    TbUnassignFromCustomerNode tbUnassignFromCustomerNode = new TbUnassignFromCustomerNode();

    // Act and Assert
    assertNull(
        tbUnassignFromCustomerNode.loadCustomerNodeActionConfig(
            new TbNodeConfiguration(new POJONode(null))));
  }

  /**
   * Test new {@link TbUnassignFromCustomerNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * TbUnassignFromCustomerNode}
   */
  @Test
  @DisplayName("Test new TbUnassignFromCustomerNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbUnassignFromCustomerNode.<init>()"})
  void testNewTbUnassignFromCustomerNode() {
    // Arrange, Act and Assert
    assertNull(new TbUnassignFromCustomerNode().config);
  }
}
