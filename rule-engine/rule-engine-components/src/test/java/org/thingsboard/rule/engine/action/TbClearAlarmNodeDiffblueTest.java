package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *   <li>Then return {@link TbClearAlarmNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbClearAlarmNode#loadAlarmNodeConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadAlarmNodeConfig(TbNodeConfiguration); then return TbClearAlarmNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbClearAlarmNodeConfiguration TbClearAlarmNode.loadAlarmNodeConfig(TbNodeConfiguration)"
  })
  void testLoadAlarmNodeConfig_thenReturnTbClearAlarmNodeConfiguration() throws TbNodeException {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration =
        new TbClearAlarmNodeConfiguration();

    // Act
    TbClearAlarmNodeConfiguration actualLoadAlarmNodeConfigResult =
        tbClearAlarmNode.loadAlarmNodeConfig(
            new TbNodeConfiguration(new POJONode(tbClearAlarmNodeConfiguration)));

    // Assert
    assertSame(tbClearAlarmNodeConfiguration, actualLoadAlarmNodeConfigResult);
  }

  /**
   * Test new {@link TbClearAlarmNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbClearAlarmNode}
   */
  @Test
  @DisplayName("Test new TbClearAlarmNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbClearAlarmNode.<init>()"})
  void testNewTbClearAlarmNode() {
    // Arrange, Act and Assert
    assertNull(new TbClearAlarmNode().config);
  }
}
