package org.thingsboard.rule.engine.external;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.aws.lambda.TbAwsLambdaNode;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbAbstractExternalNodeDiffblueTest {
  /**
   * Test {@link TbAbstractExternalNode#init(TbContext)} with {@code ctx}.
   * <p>
   * Method under test: {@link TbAbstractExternalNode#init(TbContext)}
   */
  @Test
  @DisplayName("Test init(TbContext) with 'ctx'")
  void testInitWithCtx() {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act
    tbAwsLambdaNode.init(ctx);

    // Assert
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAbstractExternalNode#tellSuccess(TbContext, TbMsg)}.
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#tellSuccess(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test tellSuccess(TbContext, TbMsg)")
  void testTellSuccess() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);
    TbContext ctx2 = mock(TbContext.class);
    doNothing().when(ctx2).enqueueForTellNext(Mockito.<TbMsg>any(), Mockito.<String>any());
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
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbAwsLambdaNode.tellSuccess(ctx2, tbMsg);

    // Assert
    verify(ctx2).enqueueForTellNext(isA(TbMsg.class), eq("Success"));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAbstractExternalNode#tellSuccess(TbContext, TbMsg)}.
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#tellSuccess(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test tellSuccess(TbContext, TbMsg)")
  void testTellSuccess2() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);
    TbContext ctx2 = mock(TbContext.class);
    doNothing().when(ctx2).enqueueForTellNext(Mockito.<TbMsg>any(), Mockito.<String>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder dataTypeResult = correlationIdResult.ctx(new TbMsgProcessingCtx())
        .customerId(null)
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder queueNameResult = internalTypeResult.metaData(new TbMsgMetaData())
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbAwsLambdaNode.tellSuccess(ctx2, tbMsg);

    // Assert
    verify(ctx2).enqueueForTellNext(isA(TbMsg.class), eq("Success"));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAbstractExternalNode#tellSuccess(TbContext, TbMsg)}.
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#tellSuccess(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test tellSuccess(TbContext, TbMsg)")
  void testTellSuccess3() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);
    TbContext ctx2 = mock(TbContext.class);
    doNothing().when(ctx2).enqueueForTellNext(Mockito.<TbMsg>any(), Mockito.<String>any());
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
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(0L).type("Type").build();

    // Act
    tbAwsLambdaNode.tellSuccess(ctx2, tbMsg);

    // Assert
    verify(ctx2).enqueueForTellNext(isA(TbMsg.class), eq("Success"));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAbstractExternalNode#tellSuccess(TbContext, TbMsg)}.
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#tellSuccess(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test tellSuccess(TbContext, TbMsg)")
  void testTellSuccess4() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);
    TbContext ctx2 = mock(TbContext.class);
    doNothing().when(ctx2).enqueueForTellNext(Mockito.<TbMsg>any(), Mockito.<String>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder dataTypeResult = correlationIdResult.ctx(new TbMsgProcessingCtx())
        .customerId(null)
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder metaDataResult = internalTypeResult.metaData(new TbMsgMetaData());
    TbMsg.TbMsgBuilder queueNameResult = metaDataResult.originator(new AlarmId(UUID.randomUUID()))
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbAwsLambdaNode.tellSuccess(ctx2, tbMsg);

    // Assert
    verify(ctx2).enqueueForTellNext(isA(TbMsg.class), eq("Success"));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAbstractExternalNode#tellSuccess(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#tellSuccess(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test tellSuccess(TbContext, TbMsg); given RuleChainId(UUID) with id is randomUUID")
  void testTellSuccess_givenRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);
    TbContext ctx2 = mock(TbContext.class);
    doNothing().when(ctx2).enqueueForTellNext(Mockito.<TbMsg>any(), Mockito.<String>any());

    TbMsgProcessingCtx ctx3 = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx3.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx3);
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
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbAwsLambdaNode.tellSuccess(ctx2, tbMsg);

    // Assert
    verify(ctx2).enqueueForTellNext(isA(TbMsg.class), eq("Success"));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAbstractExternalNode#tellSuccess(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@link TbAwsLambdaNode} (default constructor).</li>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#tellSuccess(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test tellSuccess(TbContext, TbMsg); given TbAwsLambdaNode (default constructor); when 'null'; then calls tellSuccess(TbMsg)")
  void testTellSuccess_givenTbAwsLambdaNode_whenNull_thenCallsTellSuccess() {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    // Act
    tbAwsLambdaNode.tellSuccess(ctx, null);

    // Assert
    verify(ctx).tellSuccess(isNull());
  }

  /**
   * Test {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}.
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test tellFailure(TbContext, TbMsg, Throwable)")
  void testTellFailure() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);
    TbContext ctx2 = mock(TbContext.class);
    doNothing().when(ctx2).enqueueForTellNext(Mockito.<TbMsg>any(), Mockito.<String>any());
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
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbAwsLambdaNode.tellFailure(ctx2, tbMsg, null);

    // Assert
    verify(ctx2).enqueueForTellNext(isA(TbMsg.class), eq("Failure"));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}.
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test tellFailure(TbContext, TbMsg, Throwable)")
  void testTellFailure2() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);
    TbContext ctx2 = mock(TbContext.class);
    doNothing().when(ctx2).enqueueForTellNext(Mockito.<TbMsg>any(), Mockito.<String>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder dataTypeResult = correlationIdResult.ctx(new TbMsgProcessingCtx())
        .customerId(null)
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder queueNameResult = internalTypeResult.metaData(new TbMsgMetaData())
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbAwsLambdaNode.tellFailure(ctx2, tbMsg, null);

    // Assert
    verify(ctx2).enqueueForTellNext(isA(TbMsg.class), eq("Failure"));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}.
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test tellFailure(TbContext, TbMsg, Throwable)")
  void testTellFailure3() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);
    TbContext ctx2 = mock(TbContext.class);
    doNothing().when(ctx2).enqueueForTellNext(Mockito.<TbMsg>any(), Mockito.<String>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID()).internalType(null);
    TbMsg.TbMsgBuilder queueNameResult = internalTypeResult.metaData(new TbMsgMetaData())
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbAwsLambdaNode.tellFailure(ctx2, tbMsg, null);

    // Assert
    verify(ctx2).enqueueForTellNext(isA(TbMsg.class), eq("Failure"));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}.
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test tellFailure(TbContext, TbMsg, Throwable)")
  void testTellFailure4() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);
    TbContext ctx2 = mock(TbContext.class);
    doNothing().when(ctx2).enqueueForTellNext(Mockito.<TbMsg>any(), Mockito.<String>any());
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
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(0L).type("Type").build();

    // Act
    tbAwsLambdaNode.tellFailure(ctx2, tbMsg, null);

    // Assert
    verify(ctx2).enqueueForTellNext(isA(TbMsg.class), eq("Failure"));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}.
   * <ul>
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test tellFailure(TbContext, TbMsg, Throwable); given RuleChainId(UUID) with id is randomUUID")
  void testTellFailure_givenRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);
    TbContext ctx2 = mock(TbContext.class);
    doNothing().when(ctx2).enqueueForTellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsgProcessingCtx ctx3 = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx3.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx3);
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
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbAwsLambdaNode.tellFailure(ctx2, tbMsg, new Throwable());

    // Assert
    verify(ctx2).enqueueForTellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}.
   * <ul>
   *   <li>Given {@link TbAwsLambdaNode} (default constructor).</li>
   *   <li>Then calls {@link TbContext#tellNext(TbMsg, String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test tellFailure(TbContext, TbMsg, Throwable); given TbAwsLambdaNode (default constructor); then calls tellNext(TbMsg, String)")
  void testTellFailure_givenTbAwsLambdaNode_thenCallsTellNext() {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());

    // Act
    tbAwsLambdaNode.tellFailure(ctx, null, null);

    // Assert
    verify(ctx).tellNext((TbMsg) isNull(), eq("Failure"));
  }

  /**
   * Test {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}.
   * <ul>
   *   <li>Given {@link TbAwsLambdaNode} (default constructor).</li>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test tellFailure(TbContext, TbMsg, Throwable); given TbAwsLambdaNode (default constructor); when Throwable(); then calls tellFailure(TbMsg, Throwable)")
  void testTellFailure_givenTbAwsLambdaNode_whenThrowable_thenCallsTellFailure() {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbAwsLambdaNode.tellFailure(ctx, null, new Throwable());

    // Assert
    verify(ctx).tellFailure(isNull(), isA(Throwable.class));
  }

  /**
   * Test {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}.
   * <ul>
   *   <li>Then calls
   * {@link TbContext#enqueueForTellFailure(TbMsg, Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#tellFailure(TbContext, TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test tellFailure(TbContext, TbMsg, Throwable); then calls enqueueForTellFailure(TbMsg, Throwable)")
  void testTellFailure_thenCallsEnqueueForTellFailure() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);
    TbContext ctx2 = mock(TbContext.class);
    doNothing().when(ctx2).enqueueForTellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
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
    TbMsg tbMsg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbAwsLambdaNode.tellFailure(ctx2, tbMsg, new Throwable());

    // Assert
    verify(ctx2).enqueueForTellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAbstractExternalNode#ackIfNeeded(TbContext, TbMsg)}.
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#ackIfNeeded(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test ackIfNeeded(TbContext, TbMsg)")
  void testAckIfNeeded() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);
    TbContext ctx2 = mock(TbContext.class);
    doNothing().when(ctx2).ack(Mockito.<TbMsg>any());
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

    // Act
    tbAwsLambdaNode.ackIfNeeded(ctx2, msg);

    // Assert
    verify(ctx2).ack(isA(TbMsg.class));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAbstractExternalNode#ackIfNeeded(TbContext, TbMsg)}.
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#ackIfNeeded(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test ackIfNeeded(TbContext, TbMsg)")
  void testAckIfNeeded2() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);
    TbContext ctx2 = mock(TbContext.class);
    doNothing().when(ctx2).ack(Mockito.<TbMsg>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder dataTypeResult = correlationIdResult.ctx(new TbMsgProcessingCtx())
        .customerId(null)
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

    // Act
    tbAwsLambdaNode.ackIfNeeded(ctx2, msg);

    // Assert
    verify(ctx2).ack(isA(TbMsg.class));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAbstractExternalNode#ackIfNeeded(TbContext, TbMsg)}.
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#ackIfNeeded(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test ackIfNeeded(TbContext, TbMsg)")
  void testAckIfNeeded3() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);
    TbContext ctx2 = mock(TbContext.class);
    doNothing().when(ctx2).ack(Mockito.<TbMsg>any());
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
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(0L).type("Type").build();

    // Act
    tbAwsLambdaNode.ackIfNeeded(ctx2, msg);

    // Assert
    verify(ctx2).ack(isA(TbMsg.class));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAbstractExternalNode#ackIfNeeded(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#ackIfNeeded(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test ackIfNeeded(TbContext, TbMsg); given RuleChainId(UUID) with id is randomUUID")
  void testAckIfNeeded_givenRuleChainIdWithIdIsRandomUUID() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);
    TbContext ctx2 = mock(TbContext.class);
    doNothing().when(ctx2).ack(Mockito.<TbMsg>any());

    TbMsgProcessingCtx ctx3 = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    ctx3.push(ruleChainId, new RuleNodeId(UUID.randomUUID()));
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder ctxResult = callbackResult.correlationId(UUID.randomUUID()).ctx(ctx3);
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

    // Act
    tbAwsLambdaNode.ackIfNeeded(ctx2, msg);

    // Assert
    verify(ctx2).ack(isA(TbMsg.class));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAbstractExternalNode#ackIfNeeded(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@link TbAwsLambdaNode} (default constructor).</li>
   *   <li>When {@link TbContext}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#ackIfNeeded(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test ackIfNeeded(TbContext, TbMsg); given TbAwsLambdaNode (default constructor); when TbContext; then return 'null'")
  void testAckIfNeeded_givenTbAwsLambdaNode_whenTbContext_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new TbAwsLambdaNode()).ackIfNeeded(mock(TbContext.class), null));
  }

  /**
   * Test {@link TbAbstractExternalNode#ackIfNeeded(TbContext, TbMsg)}.
   * <ul>
   *   <li>Then return Originator is {@link AlarmId#AlarmId(UUID)} with id is
   * randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractExternalNode#ackIfNeeded(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test ackIfNeeded(TbContext, TbMsg); then return Originator is AlarmId(UUID) with id is randomUUID")
  void testAckIfNeeded_thenReturnOriginatorIsAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);
    TbContext ctx2 = mock(TbContext.class);
    doNothing().when(ctx2).ack(Mockito.<TbMsg>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder dataTypeResult = correlationIdResult.ctx(new TbMsgProcessingCtx())
        .customerId(null)
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder metaDataResult = internalTypeResult.metaData(new TbMsgMetaData());
    AlarmId originator = new AlarmId(UUID.randomUUID());
    TbMsg.TbMsgBuilder queueNameResult = metaDataResult.originator(originator).partition(1).queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    TbMsg actualAckIfNeededResult = tbAwsLambdaNode.ackIfNeeded(ctx2, msg);

    // Assert
    verify(ctx2).ack(isA(TbMsg.class));
    verify(ctx).isExternalNodeForceAck();
    assertSame(originator, actualAckIfNeededResult.getOriginator());
  }
}
