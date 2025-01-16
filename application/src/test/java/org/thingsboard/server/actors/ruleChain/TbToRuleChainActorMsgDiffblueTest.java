package org.thingsboard.server.actors.ruleChain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbActorStopReason;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.service.queue.TbMsgPackCallback;
import org.thingsboard.server.service.queue.TbMsgPackProcessingContext;
import org.thingsboard.server.service.queue.processing.BatchTbRuleEngineSubmitStrategy;

class TbToRuleChainActorMsgDiffblueTest {
  /**
   * Test {@link TbToRuleChainActorMsg#getRuleChainId()}.
   * <ul>
   *   <li>Given {@link TbMsgBuilder} {@link TbMsgBuilder#metaData(TbMsgMetaData)}
   * return builder.</li>
   *   <li>Then calls {@link TbMsgBuilder#callback(TbMsgCallback)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbToRuleChainActorMsg#getRuleChainId()}
   */
  @Test
  @DisplayName("Test getRuleChainId(); given TbMsgBuilder metaData(TbMsgMetaData) return builder; then calls callback(TbMsgCallback)")
  void testGetRuleChainId_givenTbMsgBuilderMetaDataReturnBuilder_thenCallsCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbMsg.TbMsgBuilder tbMsgBuilder = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder.metaData(Mockito.<TbMsgMetaData>any())).thenReturn(TbMsg.builder());
    TbMsg.TbMsgBuilder tbMsgBuilder2 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder2.internalType(Mockito.<TbMsgType>any())).thenReturn(tbMsgBuilder);
    TbMsg.TbMsgBuilder tbMsgBuilder3 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder3.id(Mockito.<UUID>any())).thenReturn(tbMsgBuilder2);
    TbMsg.TbMsgBuilder tbMsgBuilder4 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder4.dataType(Mockito.<TbMsgDataType>any())).thenReturn(tbMsgBuilder3);
    TbMsg.TbMsgBuilder tbMsgBuilder5 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder5.data(Mockito.<String>any())).thenReturn(tbMsgBuilder4);
    TbMsg.TbMsgBuilder tbMsgBuilder6 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder6.customerId(Mockito.<CustomerId>any())).thenReturn(tbMsgBuilder5);
    TbMsg.TbMsgBuilder tbMsgBuilder7 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder7.ctx(Mockito.<TbMsgProcessingCtx>any())).thenReturn(tbMsgBuilder6);
    TbMsg.TbMsgBuilder tbMsgBuilder8 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder8.correlationId(Mockito.<UUID>any())).thenReturn(tbMsgBuilder7);
    TbMsg.TbMsgBuilder tbMsgBuilder9 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder9.callback(Mockito.<TbMsgCallback>any())).thenReturn(tbMsgBuilder8);
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext ctx = new TbMsgPackProcessingContext("Queue Name", submitStrategy, true);

    UUID id = UUID.randomUUID();
    TbMsg.TbMsgBuilder callbackResult = tbMsgBuilder9
        .callback(new TbMsgPackCallback(id, new TenantId(UUID.randomUUID()), ctx));
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
    (new RuleChainInputMsg(mock(RuleChainId.class), tbMsg)).getRuleChainId();

    // Assert
    verify(tbMsgBuilder9).callback(isA(TbMsgCallback.class));
    verify(tbMsgBuilder8).correlationId(isA(UUID.class));
    verify(tbMsgBuilder7).ctx(isA(TbMsgProcessingCtx.class));
    verify(tbMsgBuilder6).customerId(isA(CustomerId.class));
    verify(tbMsgBuilder5).data(eq("Data"));
    verify(tbMsgBuilder4).dataType(eq(TbMsgDataType.JSON));
    verify(tbMsgBuilder3).id(isA(UUID.class));
    verify(tbMsgBuilder2).internalType(eq(TbMsgType.POST_ATTRIBUTES_REQUEST));
    verify(tbMsgBuilder).metaData(isA(TbMsgMetaData.class));
    verify(submitStrategy).getPendingMap();
  }

  /**
   * Test {@link TbToRuleChainActorMsg#onTbActorStopped(TbActorStopReason)}.
   * <ul>
   *   <li>Given {@link RuleChainId} {@link UUIDBased#getId()} return
   * randomUUID.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbToRuleChainActorMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName("Test onTbActorStopped(TbActorStopReason); given RuleChainId getId() return randomUUID; then calls getId()")
  void testOnTbActorStopped_givenRuleChainIdGetIdReturnRandomUUID_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleChainId target = mock(RuleChainId.class);
    when(target.getId()).thenReturn(UUID.randomUUID());
    TbMsg.TbMsgBuilder tbMsgBuilder = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder.metaData(Mockito.<TbMsgMetaData>any())).thenReturn(TbMsg.builder());
    TbMsg.TbMsgBuilder tbMsgBuilder2 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder2.internalType(Mockito.<TbMsgType>any())).thenReturn(tbMsgBuilder);
    TbMsg.TbMsgBuilder tbMsgBuilder3 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder3.id(Mockito.<UUID>any())).thenReturn(tbMsgBuilder2);
    TbMsg.TbMsgBuilder tbMsgBuilder4 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder4.dataType(Mockito.<TbMsgDataType>any())).thenReturn(tbMsgBuilder3);
    TbMsg.TbMsgBuilder tbMsgBuilder5 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder5.data(Mockito.<String>any())).thenReturn(tbMsgBuilder4);
    TbMsg.TbMsgBuilder tbMsgBuilder6 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder6.customerId(Mockito.<CustomerId>any())).thenReturn(tbMsgBuilder5);
    TbMsg.TbMsgBuilder tbMsgBuilder7 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder7.ctx(Mockito.<TbMsgProcessingCtx>any())).thenReturn(tbMsgBuilder6);
    TbMsg.TbMsgBuilder tbMsgBuilder8 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder8.correlationId(Mockito.<UUID>any())).thenReturn(tbMsgBuilder7);
    TbMsg.TbMsgBuilder tbMsgBuilder9 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder9.callback(Mockito.<TbMsgCallback>any())).thenReturn(tbMsgBuilder8);
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext ctx = new TbMsgPackProcessingContext("Queue Name", submitStrategy, true);

    UUID id = UUID.randomUUID();
    TbMsg.TbMsgBuilder callbackResult = tbMsgBuilder9
        .callback(new TbMsgPackCallback(id, new TenantId(UUID.randomUUID()), ctx));
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
    (new RuleChainInputMsg(target, tbMsg)).onTbActorStopped(TbActorStopReason.INIT_FAILED);

    // Assert
    verify(target).getId();
    verify(tbMsgBuilder9).callback(isA(TbMsgCallback.class));
    verify(tbMsgBuilder8).correlationId(isA(UUID.class));
    verify(tbMsgBuilder7).ctx(isA(TbMsgProcessingCtx.class));
    verify(tbMsgBuilder6).customerId(isA(CustomerId.class));
    verify(tbMsgBuilder5).data(eq("Data"));
    verify(tbMsgBuilder4).dataType(eq(TbMsgDataType.JSON));
    verify(tbMsgBuilder3).id(isA(UUID.class));
    verify(tbMsgBuilder2).internalType(eq(TbMsgType.POST_ATTRIBUTES_REQUEST));
    verify(tbMsgBuilder).metaData(isA(TbMsgMetaData.class));
    verify(submitStrategy).getPendingMap();
  }

  /**
   * Test {@link TbToRuleChainActorMsg#onTbActorStopped(TbActorStopReason)}.
   * <ul>
   *   <li>When {@code STOPPED}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbToRuleChainActorMsg#onTbActorStopped(TbActorStopReason)}
   */
  @Test
  @DisplayName("Test onTbActorStopped(TbActorStopReason); when 'STOPPED'; then calls getId()")
  void testOnTbActorStopped_whenStopped_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RuleChainId target = mock(RuleChainId.class);
    when(target.getId()).thenReturn(UUID.randomUUID());
    TbMsg.TbMsgBuilder tbMsgBuilder = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder.metaData(Mockito.<TbMsgMetaData>any())).thenReturn(TbMsg.builder());
    TbMsg.TbMsgBuilder tbMsgBuilder2 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder2.internalType(Mockito.<TbMsgType>any())).thenReturn(tbMsgBuilder);
    TbMsg.TbMsgBuilder tbMsgBuilder3 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder3.id(Mockito.<UUID>any())).thenReturn(tbMsgBuilder2);
    TbMsg.TbMsgBuilder tbMsgBuilder4 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder4.dataType(Mockito.<TbMsgDataType>any())).thenReturn(tbMsgBuilder3);
    TbMsg.TbMsgBuilder tbMsgBuilder5 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder5.data(Mockito.<String>any())).thenReturn(tbMsgBuilder4);
    TbMsg.TbMsgBuilder tbMsgBuilder6 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder6.customerId(Mockito.<CustomerId>any())).thenReturn(tbMsgBuilder5);
    TbMsg.TbMsgBuilder tbMsgBuilder7 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder7.ctx(Mockito.<TbMsgProcessingCtx>any())).thenReturn(tbMsgBuilder6);
    TbMsg.TbMsgBuilder tbMsgBuilder8 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder8.correlationId(Mockito.<UUID>any())).thenReturn(tbMsgBuilder7);
    TbMsg.TbMsgBuilder tbMsgBuilder9 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder9.callback(Mockito.<TbMsgCallback>any())).thenReturn(tbMsgBuilder8);
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext ctx = new TbMsgPackProcessingContext("Queue Name", submitStrategy, true);

    UUID id = UUID.randomUUID();
    TbMsg.TbMsgBuilder callbackResult = tbMsgBuilder9
        .callback(new TbMsgPackCallback(id, new TenantId(UUID.randomUUID()), ctx));
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
    (new RuleChainInputMsg(target, tbMsg)).onTbActorStopped(TbActorStopReason.STOPPED);

    // Assert
    verify(target).getId();
    verify(tbMsgBuilder9).callback(isA(TbMsgCallback.class));
    verify(tbMsgBuilder8).correlationId(isA(UUID.class));
    verify(tbMsgBuilder7).ctx(isA(TbMsgProcessingCtx.class));
    verify(tbMsgBuilder6).customerId(isA(CustomerId.class));
    verify(tbMsgBuilder5).data(eq("Data"));
    verify(tbMsgBuilder4).dataType(eq(TbMsgDataType.JSON));
    verify(tbMsgBuilder3).id(isA(UUID.class));
    verify(tbMsgBuilder2).internalType(eq(TbMsgType.POST_ATTRIBUTES_REQUEST));
    verify(tbMsgBuilder).metaData(isA(TbMsgMetaData.class));
    verify(submitStrategy).getPendingMap();
  }

  /**
   * Test {@link TbToRuleChainActorMsg#getTarget()}.
   * <ul>
   *   <li>Given {@link TbMsgBuilder} {@link TbMsgBuilder#metaData(TbMsgMetaData)}
   * return builder.</li>
   *   <li>Then calls {@link TbMsgBuilder#callback(TbMsgCallback)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbToRuleChainActorMsg#getTarget()}
   */
  @Test
  @DisplayName("Test getTarget(); given TbMsgBuilder metaData(TbMsgMetaData) return builder; then calls callback(TbMsgCallback)")
  void testGetTarget_givenTbMsgBuilderMetaDataReturnBuilder_thenCallsCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbMsg.TbMsgBuilder tbMsgBuilder = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder.metaData(Mockito.<TbMsgMetaData>any())).thenReturn(TbMsg.builder());
    TbMsg.TbMsgBuilder tbMsgBuilder2 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder2.internalType(Mockito.<TbMsgType>any())).thenReturn(tbMsgBuilder);
    TbMsg.TbMsgBuilder tbMsgBuilder3 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder3.id(Mockito.<UUID>any())).thenReturn(tbMsgBuilder2);
    TbMsg.TbMsgBuilder tbMsgBuilder4 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder4.dataType(Mockito.<TbMsgDataType>any())).thenReturn(tbMsgBuilder3);
    TbMsg.TbMsgBuilder tbMsgBuilder5 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder5.data(Mockito.<String>any())).thenReturn(tbMsgBuilder4);
    TbMsg.TbMsgBuilder tbMsgBuilder6 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder6.customerId(Mockito.<CustomerId>any())).thenReturn(tbMsgBuilder5);
    TbMsg.TbMsgBuilder tbMsgBuilder7 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder7.ctx(Mockito.<TbMsgProcessingCtx>any())).thenReturn(tbMsgBuilder6);
    TbMsg.TbMsgBuilder tbMsgBuilder8 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder8.correlationId(Mockito.<UUID>any())).thenReturn(tbMsgBuilder7);
    TbMsg.TbMsgBuilder tbMsgBuilder9 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder9.callback(Mockito.<TbMsgCallback>any())).thenReturn(tbMsgBuilder8);
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext ctx = new TbMsgPackProcessingContext("Queue Name", submitStrategy, true);

    UUID id = UUID.randomUUID();
    TbMsg.TbMsgBuilder callbackResult = tbMsgBuilder9
        .callback(new TbMsgPackCallback(id, new TenantId(UUID.randomUUID()), ctx));
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
    (new RuleChainInputMsg(mock(RuleChainId.class), tbMsg)).getTarget();

    // Assert
    verify(tbMsgBuilder9).callback(isA(TbMsgCallback.class));
    verify(tbMsgBuilder8).correlationId(isA(UUID.class));
    verify(tbMsgBuilder7).ctx(isA(TbMsgProcessingCtx.class));
    verify(tbMsgBuilder6).customerId(isA(CustomerId.class));
    verify(tbMsgBuilder5).data(eq("Data"));
    verify(tbMsgBuilder4).dataType(eq(TbMsgDataType.JSON));
    verify(tbMsgBuilder3).id(isA(UUID.class));
    verify(tbMsgBuilder2).internalType(eq(TbMsgType.POST_ATTRIBUTES_REQUEST));
    verify(tbMsgBuilder).metaData(isA(TbMsgMetaData.class));
    verify(submitStrategy).getPendingMap();
  }

  /**
   * Test {@link TbToRuleChainActorMsg#toString()}.
   * <ul>
   *   <li>Given {@link TbMsgBuilder} {@link TbMsgBuilder#metaData(TbMsgMetaData)}
   * return builder.</li>
   *   <li>Then return {@code RuleChainInputMsg()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbToRuleChainActorMsg#toString()}
   */
  @Test
  @DisplayName("Test toString(); given TbMsgBuilder metaData(TbMsgMetaData) return builder; then return 'RuleChainInputMsg()'")
  void testToString_givenTbMsgBuilderMetaDataReturnBuilder_thenReturnRuleChainInputMsg() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbMsg.TbMsgBuilder tbMsgBuilder = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder.metaData(Mockito.<TbMsgMetaData>any())).thenReturn(TbMsg.builder());
    TbMsg.TbMsgBuilder tbMsgBuilder2 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder2.internalType(Mockito.<TbMsgType>any())).thenReturn(tbMsgBuilder);
    TbMsg.TbMsgBuilder tbMsgBuilder3 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder3.id(Mockito.<UUID>any())).thenReturn(tbMsgBuilder2);
    TbMsg.TbMsgBuilder tbMsgBuilder4 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder4.dataType(Mockito.<TbMsgDataType>any())).thenReturn(tbMsgBuilder3);
    TbMsg.TbMsgBuilder tbMsgBuilder5 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder5.data(Mockito.<String>any())).thenReturn(tbMsgBuilder4);
    TbMsg.TbMsgBuilder tbMsgBuilder6 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder6.customerId(Mockito.<CustomerId>any())).thenReturn(tbMsgBuilder5);
    TbMsg.TbMsgBuilder tbMsgBuilder7 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder7.ctx(Mockito.<TbMsgProcessingCtx>any())).thenReturn(tbMsgBuilder6);
    TbMsg.TbMsgBuilder tbMsgBuilder8 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder8.correlationId(Mockito.<UUID>any())).thenReturn(tbMsgBuilder7);
    TbMsg.TbMsgBuilder tbMsgBuilder9 = mock(TbMsg.TbMsgBuilder.class);
    when(tbMsgBuilder9.callback(Mockito.<TbMsgCallback>any())).thenReturn(tbMsgBuilder8);
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext ctx = new TbMsgPackProcessingContext("Queue Name", submitStrategy, true);

    UUID id = UUID.randomUUID();
    TbMsg.TbMsgBuilder callbackResult = tbMsgBuilder9
        .callback(new TbMsgPackCallback(id, new TenantId(UUID.randomUUID()), ctx));
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
    String actualToStringResult = (new RuleChainInputMsg(mock(RuleChainId.class), tbMsg)).toString();

    // Assert
    verify(tbMsgBuilder9).callback(isA(TbMsgCallback.class));
    verify(tbMsgBuilder8).correlationId(isA(UUID.class));
    verify(tbMsgBuilder7).ctx(isA(TbMsgProcessingCtx.class));
    verify(tbMsgBuilder6).customerId(isA(CustomerId.class));
    verify(tbMsgBuilder5).data(eq("Data"));
    verify(tbMsgBuilder4).dataType(eq(TbMsgDataType.JSON));
    verify(tbMsgBuilder3).id(isA(UUID.class));
    verify(tbMsgBuilder2).internalType(eq(TbMsgType.POST_ATTRIBUTES_REQUEST));
    verify(tbMsgBuilder).metaData(isA(TbMsgMetaData.class));
    verify(submitStrategy).getPendingMap();
    assertEquals("RuleChainInputMsg()", actualToStringResult);
  }
}
