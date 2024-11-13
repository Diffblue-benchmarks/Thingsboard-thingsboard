package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbGetAttributesNodeDiffblueTest {
  /**
   * Test {@link TbGetAttributesNode#loadNodeConfiguration(TbNodeConfiguration)}.
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data
   * is {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetAttributesNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbNodeConfiguration); when TbNodeConfiguration(JsonNode) with data is 'null'; then return 'null'")
  void testLoadNodeConfiguration_whenTbNodeConfigurationWithDataIsNull_thenReturnNull() throws TbNodeException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();

    // Act and Assert
    assertNull(tbGetAttributesNode.loadNodeConfiguration(new TbNodeConfiguration(null)));
  }

  /**
   * Test {@link TbGetAttributesNode#findEntityIdAsync(TbContext, TbMsg)}.
   * <ul>
   *   <li>Then return {@link Future#get()} is {@link AlarmId#AlarmId(UUID)} with id
   * is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetAttributesNode#findEntityIdAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test findEntityIdAsync(TbContext, TbMsg); then return get() is AlarmId(UUID) with id is randomUUID")
  void testFindEntityIdAsync_thenReturnGetIsAlarmIdWithIdIsRandomUUID()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();
    TbContext ctx = mock(TbContext.class);
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder metaDataResult = internalTypeResult.metaData(new TbMsgMetaData());
    AlarmId originator = new AlarmId(UUID.randomUUID());
    TbMsg.TbMsgBuilder queueNameResult = metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertSame(originator, tbGetAttributesNode.findEntityIdAsync(ctx, msg).get());
  }

  /**
   * Test {@link TbGetAttributesNode#findEntityIdAsync(TbContext, TbMsg)}.
   * <ul>
   *   <li>Then return {@link Future#get()} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetAttributesNode#findEntityIdAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test findEntityIdAsync(TbContext, TbMsg); then return get() is 'null'")
  void testFindEntityIdAsync_thenReturnGetIsNull() throws InterruptedException, ExecutionException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();
    TbContext ctx = mock(TbContext.class);
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder queueNameResult = internalTypeResult.metaData(new TbMsgMetaData())
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertNull(tbGetAttributesNode.findEntityIdAsync(ctx, msg).get());
  }

  /**
   * Test {@link TbGetAttributesNode#upgrade(int, JsonNode)}.
   * <p>
   * Method under test: {@link TbGetAttributesNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  void testUpgrade() throws TbNodeException {
    // Arrange
    TbGetAttributesNode tbGetAttributesNode = new TbGetAttributesNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbGetAttributesNode.upgrade(1, oldConfiguration);

    // Assert
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test new {@link TbGetAttributesNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TbGetAttributesNode}
   */
  @Test
  @DisplayName("Test new TbGetAttributesNode (default constructor)")
  void testNewTbGetAttributesNode() {
    // Arrange and Act
    TbGetAttributesNode actualTbGetAttributesNode = new TbGetAttributesNode();

    // Assert
    assertNull(actualTbGetAttributesNode.config);
    assertNull(actualTbGetAttributesNode.fetchTo);
  }
}
