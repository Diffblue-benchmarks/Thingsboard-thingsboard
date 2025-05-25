package org.thingsboard.rule.engine.flow;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbCheckpointNodeDiffblueTest {
  /**
   * Test {@link TbCheckpointNode#init(TbContext, TbNodeConfiguration)}.
   * <p>
   * Method under test: {@link TbCheckpointNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbCheckpointNode.init(TbContext, TbNodeConfiguration)"})
  void testInit() throws TbNodeException {
    // Arrange
    TbCheckpointNode tbCheckpointNode = new TbCheckpointNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getQueueName()).thenReturn("Queue Name");

    // Act
    tbCheckpointNode.init(ctx, new TbNodeConfiguration(MissingNode.getInstance()));

    // Assert
    verify(ctx).getQueueName();
  }

  /**
   * Test {@link TbCheckpointNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>Then return Second is {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCheckpointNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); then return Second is ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.util.TbPair TbCheckpointNode.upgrade(int, JsonNode)"})
  void testUpgrade_thenReturnSecondIsArrayNodeWithNfIsWithExactBigDecimalsTrue() throws TbNodeException {
    // Arrange
    TbCheckpointNode tbCheckpointNode = new TbCheckpointNode();
    ArrayNode oldConfiguration = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act and Assert
    assertSame(oldConfiguration, tbCheckpointNode.upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbCheckpointNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then return Second is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCheckpointNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when Instance; then return Second is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.util.TbPair TbCheckpointNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenInstance_thenReturnSecondIsInstance() throws TbNodeException {
    // Arrange
    TbCheckpointNode tbCheckpointNode = new TbCheckpointNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act and Assert
    assertSame(oldConfiguration, tbCheckpointNode.upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbCheckpointNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Second is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbCheckpointNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return Second is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.thingsboard.server.common.data.util.TbPair TbCheckpointNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenReturnSecondIsInstance() throws TbNodeException {
    // Arrange
    TbCheckpointNode tbCheckpointNode = new TbCheckpointNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act and Assert
    assertSame(oldConfiguration, tbCheckpointNode.upgrade(1, oldConfiguration).getSecond());
  }
}
