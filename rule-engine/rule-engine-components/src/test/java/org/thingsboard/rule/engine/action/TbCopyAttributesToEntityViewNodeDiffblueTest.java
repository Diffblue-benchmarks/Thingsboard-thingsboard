package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.EmptyNodeConfiguration;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
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

class TbCopyAttributesToEntityViewNodeDiffblueTest {
  /**
   * Test {@link TbCopyAttributesToEntityViewNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is {@link
   *       POJONode#POJONode(Object)} Data {@link POJONode}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyAttributesToEntityViewNode#init(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); then TbNodeConfiguration(JsonNode) with data is POJONode(Object) Data POJONode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyAttributesToEntityViewNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenTbNodeConfigurationWithDataIsPOJONodeDataPOJONode() throws TbNodeException {
    // Arrange
    TbCopyAttributesToEntityViewNode tbCopyAttributesToEntityViewNode =
        new TbCopyAttributesToEntityViewNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    EmptyNodeConfiguration emptyNodeConfiguration = new EmptyNodeConfiguration();
    TbNodeConfiguration configuration =
        new TbNodeConfiguration(new POJONode(emptyNodeConfiguration));

    // Act
    tbCopyAttributesToEntityViewNode.init(ctx, configuration);

    // Assert
    JsonNode data = configuration.getData();
    assertTrue(data instanceof POJONode);
    Object pojo = ((POJONode) data).getPojo();
    assertTrue(pojo instanceof EmptyNodeConfiguration);
    assertEquals(0, tbCopyAttributesToEntityViewNode.config.getVersion());
    assertSame(emptyNodeConfiguration, pojo);
  }

  /**
   * Test {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyAttributesToEntityViewNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    TbCopyAttributesToEntityViewNode tbCopyAttributesToEntityViewNode =
        new TbCopyAttributesToEntityViewNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getEntityViewService()).thenThrow(new IllegalArgumentException());

    TbMsgMetaData metaData = new TbMsgMetaData();
    metaData.putValue("Key", "Message metadata is empty");

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder queueNameResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST)
            .metaData(metaData)
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tbCopyAttributesToEntityViewNode.onMsg(
                ctx,
                ruleChainIdResult
                    .ruleNodeId(
                        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
                    .ts(1L)
                    .type("Type")
                    .build()));
    verify(ctx).getEntityViewService();
  }

  /**
   * Test {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyAttributesToEntityViewNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsTellFailure() {
    // Arrange
    TbCopyAttributesToEntityViewNode tbCopyAttributesToEntityViewNode =
        new TbCopyAttributesToEntityViewNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbCopyAttributesToEntityViewNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbCopyAttributesToEntityViewNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyAttributesToEntityViewNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsTellFailure2() {
    // Arrange
    TbCopyAttributesToEntityViewNode tbCopyAttributesToEntityViewNode =
        new TbCopyAttributesToEntityViewNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

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

    // Act
    tbCopyAttributesToEntityViewNode.onMsg(
        ctx,
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build());

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test new {@link TbCopyAttributesToEntityViewNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * TbCopyAttributesToEntityViewNode}
   */
  @Test
  @DisplayName("Test new TbCopyAttributesToEntityViewNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCopyAttributesToEntityViewNode.<init>()"})
  void testNewTbCopyAttributesToEntityViewNode() {
    // Arrange, Act and Assert
    assertNull(new TbCopyAttributesToEntityViewNode().config);
  }
}
