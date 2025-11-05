package org.thingsboard.rule.engine.geo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbGpsGeofencingActionNodeDiffblueTest {
  /**
   * Test {@link TbGpsGeofencingActionNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGpsGeofencingActionNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbGpsGeofencingActionNode.onMsg(
                ctx,
                ruleChainIdResult
                    .ruleNodeId(
                        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                    .ts(1L)
                    .type("Type")
                    .build()));
  }

  /**
   * Test {@link TbGpsGeofencingActionNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGpsGeofencingActionNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg2() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("42")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbGpsGeofencingActionNode.onMsg(
                ctx,
                ruleChainIdResult
                    .ruleNodeId(
                        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                    .ts(1L)
                    .type("Type")
                    .build()));
  }

  /**
   * Test {@link TbGpsGeofencingActionNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGpsGeofencingActionNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg3() throws TbNodeException {
    // Arrange
    TbGpsGeofencingActionNode tbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbGpsGeofencingActionNode.onMsg(
                ctx,
                ruleChainIdResult
                    .ruleNodeId(
                        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                    .ts(1L)
                    .type("Type")
                    .build()));
  }

  /**
   * Test {@link TbGpsGeofencingActionNode#getConfigClazz()}.
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNode#getConfigClazz()}
   */
  @Test
  @DisplayName("Test getConfigClazz()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class TbGpsGeofencingActionNode.getConfigClazz()"})
  void testGetConfigClazz() {
    // Arrange and Act
    Class<TbGpsGeofencingActionNodeConfiguration> actualConfigClazz =
        new TbGpsGeofencingActionNode().getConfigClazz();

    // Assert
    Class<TbGpsGeofencingActionNodeConfiguration> expectedConfigClazz =
        TbGpsGeofencingActionNodeConfiguration.class;
    assertEquals(expectedConfigClazz, actualConfigClazz);
  }

  /**
   * Test {@link TbGpsGeofencingActionNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbGpsGeofencingActionNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbGpsGeofencingActionNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_whenOne_thenReturnSecondIsValueOfTen() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(
        oldConfiguration, new TbGpsGeofencingActionNode().upgrade(1, oldConfiguration).getSecond());
  }

  /**
   * Test new {@link TbGpsGeofencingActionNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbGpsGeofencingActionNode}
   */
  @Test
  @DisplayName("Test new TbGpsGeofencingActionNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbGpsGeofencingActionNode.<init>()"})
  void testNewTbGpsGeofencingActionNode() {
    // Arrange and Act
    TbGpsGeofencingActionNode actualTbGpsGeofencingActionNode = new TbGpsGeofencingActionNode();

    // Assert
    assertNull(actualTbGpsGeofencingActionNode.jtsCtx);
    assertNull(actualTbGpsGeofencingActionNode.config);
    Class<TbGpsGeofencingActionNodeConfiguration> expectedConfigClazz =
        TbGpsGeofencingActionNodeConfiguration.class;
    assertEquals(expectedConfigClazz, actualTbGpsGeofencingActionNode.getConfigClazz());
  }
}
