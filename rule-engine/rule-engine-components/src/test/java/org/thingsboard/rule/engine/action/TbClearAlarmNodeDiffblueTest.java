package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbClearAlarmNodeDiffblueTest {
  /**
   * Test {@link TbClearAlarmNode#loadAlarmNodeConfig(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbClearAlarmNode#loadAlarmNodeConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadAlarmNodeConfig(TbNodeConfiguration); when POJONode(Object) with v is 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbClearAlarmNodeConfiguration TbClearAlarmNode.loadAlarmNodeConfig(TbNodeConfiguration)"
  })
  void testLoadAlarmNodeConfig_whenPOJONodeWithVIsNull_thenReturnNull() throws TbNodeException {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();

    // Act and Assert
    assertNull(tbClearAlarmNode.loadAlarmNodeConfig(new TbNodeConfiguration(new POJONode(null))));
  }

  /**
   * Test new {@link TbClearAlarmNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbClearAlarmNode}
   */
  @Test
  @DisplayName("Test new TbClearAlarmNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbClearAlarmNode.<init>()"})
  void testNewTbClearAlarmNode() {
    // Arrange, Act and Assert
    assertNull(new TbClearAlarmNode().config);
  }
}
