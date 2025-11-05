package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;

class TbGetAttributesNodeDiffblueTest {
  /**
   * Test {@link TbGetAttributesNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then return {@link TbGetAttributesNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbNodeConfiguration); then return TbGetAttributesNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbGetAttributesNodeConfiguration TbGetAttributesNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_thenReturnTbGetAttributesNodeConfiguration()
      throws TbNodeException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();
    TbGetAttributesNodeConfiguration tbGetAttributesNodeConfiguration =
        new TbGetAttributesNodeConfiguration();

    // Act
    TbGetAttributesNodeConfiguration actualLoadNodeConfigurationResult =
        tbGetAttributesNode.loadNodeConfiguration(
            new TbNodeConfiguration(new POJONode(tbGetAttributesNodeConfiguration)));

    // Assert
    assertSame(tbGetAttributesNodeConfiguration, actualLoadNodeConfigurationResult);
  }

  /**
   * Test {@link TbGetAttributesNode#findEntityIdAsync(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbGetAttributesNode#findEntityIdAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test findEntityIdAsync(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbGetAttributesNode.findEntityIdAsync(TbContext, TbMsg)"})
  void testFindEntityIdAsync() throws InterruptedException, ExecutionException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertSame(originator, tbGetAttributesNode.findEntityIdAsync(ctx, msg).get());
  }

  /**
   * Test {@link TbGetAttributesNode#findEntityIdAsync(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then return {@link ListenableFuture#get()} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNode#findEntityIdAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test findEntityIdAsync(TbContext, TbMsg); then return get() is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbGetAttributesNode.findEntityIdAsync(TbContext, TbMsg)"})
  void testFindEntityIdAsync_thenReturnGetIsNull() throws InterruptedException, ExecutionException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    ListenableFuture<EntityId> actualFindEntityIdAsyncResult =
        tbGetAttributesNode.findEntityIdAsync(ctx, msg);

    // Assert
    assertNull(actualFindEntityIdAsyncResult.get());
    assertTrue(actualFindEntityIdAsyncResult.isDone());
  }

  /**
   * Test {@link TbGetAttributesNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then Second return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbGetAttributesNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then Second return DoubleNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbGetAttributesNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenSecondReturnDoubleNode() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        new TbGetAttributesNode().upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof DoubleNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }

  /**
   * Test new {@link TbGetAttributesNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbGetAttributesNode}
   */
  @Test
  @DisplayName("Test new TbGetAttributesNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGetAttributesNode.<init>()"})
  void testNewTbGetAttributesNode() {
    // Arrange and Act
    TbGetAttributesNode actualTbGetAttributesNode = new TbGetAttributesNode();

    // Assert
    assertNull(actualTbGetAttributesNode.config);
    assertNull(actualTbGetAttributesNode.fetchTo);
  }
}
