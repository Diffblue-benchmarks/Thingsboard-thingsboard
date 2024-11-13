package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbClearAlarmNodeDiffblueTest {
  /**
   * Test {@link TbClearAlarmNode#loadAlarmNodeConfig(TbNodeConfiguration)}.
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data
   * is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbClearAlarmNode#loadAlarmNodeConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadAlarmNodeConfig(TbNodeConfiguration); when TbNodeConfiguration(JsonNode) with data is 'null'; then return 'null'")
  void testLoadAlarmNodeConfig_whenTbNodeConfigurationWithDataIsNull_thenReturnNull() throws TbNodeException {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();

    // Act and Assert
    assertNull(tbClearAlarmNode.loadAlarmNodeConfig(new TbNodeConfiguration(null)));
  }

  /**
   * Test new {@link TbClearAlarmNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TbClearAlarmNode}
   */
  @Test
  @DisplayName("Test new TbClearAlarmNode (default constructor)")
  void testNewTbClearAlarmNode() {
    // Arrange, Act and Assert
    assertNull((new TbClearAlarmNode()).config);
  }
}
