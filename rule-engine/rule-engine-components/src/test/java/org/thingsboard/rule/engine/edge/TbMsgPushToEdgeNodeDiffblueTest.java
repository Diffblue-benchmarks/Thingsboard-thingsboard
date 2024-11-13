package org.thingsboard.rule.engine.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;

class TbMsgPushToEdgeNodeDiffblueTest {
  /**
   * Test
   * {@link TbMsgPushToEdgeNode#buildEvent(TenantId, EdgeEventActionType, UUID, EdgeEventType, JsonNode)}
   * with {@code TenantId}, {@code EdgeEventActionType}, {@code UUID},
   * {@code EdgeEventType}, {@code JsonNode}.
   * <p>
   * Method under test:
   * {@link TbMsgPushToEdgeNode#buildEvent(TenantId, EdgeEventActionType, UUID, EdgeEventType, JsonNode)}
   */
  @Test
  @DisplayName("Test buildEvent(TenantId, EdgeEventActionType, UUID, EdgeEventType, JsonNode) with 'TenantId', 'EdgeEventActionType', 'UUID', 'EdgeEventType', 'JsonNode'")
  void testBuildEventWithTenantIdEdgeEventActionTypeUuidEdgeEventTypeJsonNode() {
    // Arrange
    TbMsgPushToEdgeNode tbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    UUID entityId = UUID.randomUUID();
    MissingNode entityBody = MissingNode.getInstance();

    // Act
    EdgeEvent actualBuildEventResult = tbMsgPushToEdgeNode.buildEvent(tenantId, EdgeEventActionType.ADDED, entityId,
        EdgeEventType.DASHBOARD, entityBody);

    // Assert
    assertNull(actualBuildEventResult.getUid());
    assertNull(actualBuildEventResult.getUuidId());
    assertNull(actualBuildEventResult.getId());
    assertNull(actualBuildEventResult.getEdgeId());
    assertEquals(0L, actualBuildEventResult.getCreatedTime());
    assertEquals(0L, actualBuildEventResult.getSeqId());
    assertEquals(EdgeEventActionType.ADDED, actualBuildEventResult.getAction());
    assertEquals(EdgeEventType.DASHBOARD, actualBuildEventResult.getType());
    assertSame(tenantId, actualBuildEventResult.getTenantId());
    assertSame(entityBody, actualBuildEventResult.getBody());
    assertSame(entityId, actualBuildEventResult.getEntityId());
  }

  /**
   * Test
   * {@link TbMsgPushToEdgeNode#buildEvent(TenantId, EdgeEventActionType, UUID, EdgeEventType, JsonNode)}
   * with {@code TenantId}, {@code EdgeEventActionType}, {@code UUID},
   * {@code EdgeEventType}, {@code JsonNode}.
   * <p>
   * Method under test:
   * {@link TbMsgPushToEdgeNode#buildEvent(TenantId, EdgeEventActionType, UUID, EdgeEventType, JsonNode)}
   */
  @Test
  @DisplayName("Test buildEvent(TenantId, EdgeEventActionType, UUID, EdgeEventType, JsonNode) with 'TenantId', 'EdgeEventActionType', 'UUID', 'EdgeEventType', 'JsonNode'")
  void testBuildEventWithTenantIdEdgeEventActionTypeUuidEdgeEventTypeJsonNode2() throws TbNodeException {
    // Arrange
    TbMsgPushToEdgeNode tbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();
    TbContext ctx = mock(TbContext.class);
    tbMsgPushToEdgeNode.init(ctx, new TbNodeConfiguration(null));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    UUID entityId = UUID.randomUUID();
    MissingNode entityBody = MissingNode.getInstance();

    // Act
    EdgeEvent actualBuildEventResult = tbMsgPushToEdgeNode.buildEvent(tenantId, EdgeEventActionType.ADDED, entityId,
        EdgeEventType.DASHBOARD, entityBody);

    // Assert
    assertNull(actualBuildEventResult.getUid());
    assertNull(actualBuildEventResult.getUuidId());
    assertNull(actualBuildEventResult.getId());
    assertNull(actualBuildEventResult.getEdgeId());
    assertEquals(0L, actualBuildEventResult.getCreatedTime());
    assertEquals(0L, actualBuildEventResult.getSeqId());
    assertEquals(EdgeEventActionType.ADDED, actualBuildEventResult.getAction());
    assertEquals(EdgeEventType.DASHBOARD, actualBuildEventResult.getType());
    assertSame(tenantId, actualBuildEventResult.getTenantId());
    assertSame(entityBody, actualBuildEventResult.getBody());
    assertSame(entityId, actualBuildEventResult.getEntityId());
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#getEventTypeByEntityType(EntityType)}.
   * <p>
   * Method under test:
   * {@link TbMsgPushToEdgeNode#getEventTypeByEntityType(EntityType)}
   */
  @Test
  @DisplayName("Test getEventTypeByEntityType(EntityType)")
  void testGetEventTypeByEntityType() throws TbNodeException {
    // Arrange
    TbMsgPushToEdgeNode tbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();
    TbContext ctx = mock(TbContext.class);
    tbMsgPushToEdgeNode.init(ctx, new TbNodeConfiguration(null));

    // Act and Assert
    assertEquals(EdgeEventType.TENANT, tbMsgPushToEdgeNode.getEventTypeByEntityType(EntityType.TENANT));
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#getEventTypeByEntityType(EntityType)}.
   * <ul>
   *   <li>Given {@link TbMsgPushToEdgeNode} (default constructor).</li>
   *   <li>Then return {@code TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgPushToEdgeNode#getEventTypeByEntityType(EntityType)}
   */
  @Test
  @DisplayName("Test getEventTypeByEntityType(EntityType); given TbMsgPushToEdgeNode (default constructor); then return 'TENANT'")
  void testGetEventTypeByEntityType_givenTbMsgPushToEdgeNode_thenReturnTenant() {
    // Arrange, Act and Assert
    assertEquals(EdgeEventType.TENANT, (new TbMsgPushToEdgeNode()).getEventTypeByEntityType(EntityType.TENANT));
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#getEventTypeByEntityType(EntityType)}.
   * <ul>
   *   <li>When {@code CUSTOMER}.</li>
   *   <li>Then return {@code CUSTOMER}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgPushToEdgeNode#getEventTypeByEntityType(EntityType)}
   */
  @Test
  @DisplayName("Test getEventTypeByEntityType(EntityType); when 'CUSTOMER'; then return 'CUSTOMER'")
  void testGetEventTypeByEntityType_whenCustomer_thenReturnCustomer() {
    // Arrange, Act and Assert
    assertEquals(EdgeEventType.CUSTOMER, (new TbMsgPushToEdgeNode()).getEventTypeByEntityType(EntityType.CUSTOMER));
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#getAlarmEventType()}.
   * <p>
   * Method under test: {@link TbMsgPushToEdgeNode#getAlarmEventType()}
   */
  @Test
  @DisplayName("Test getAlarmEventType()")
  void testGetAlarmEventType() throws TbNodeException {
    // Arrange
    TbMsgPushToEdgeNode tbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();
    TbContext ctx = mock(TbContext.class);
    tbMsgPushToEdgeNode.init(ctx, new TbNodeConfiguration(null));

    // Act and Assert
    assertEquals(EdgeEventType.ALARM, tbMsgPushToEdgeNode.getAlarmEventType());
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#getAlarmEventType()}.
   * <ul>
   *   <li>Given {@link TbMsgPushToEdgeNode} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPushToEdgeNode#getAlarmEventType()}
   */
  @Test
  @DisplayName("Test getAlarmEventType(); given TbMsgPushToEdgeNode (default constructor)")
  void testGetAlarmEventType_givenTbMsgPushToEdgeNode() {
    // Arrange, Act and Assert
    assertEquals(EdgeEventType.ALARM, (new TbMsgPushToEdgeNode()).getAlarmEventType());
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}.
   * <p>
   * Method under test: {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test processMsg(TbContext, TbMsg)")
  void testProcessMsg() {
    // Arrange
    TbMsgPushToEdgeNode tbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
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
    tbMsgPushToEdgeNode.processMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link TbContext} {@link TbContext#getEdgeService()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test processMsg(TbContext, TbMsg); given 'null'; when TbContext getEdgeService() return 'null'")
  void testProcessMsg_givenNull_whenTbContextGetEdgeServiceReturnNull() {
    // Arrange
    TbMsgPushToEdgeNode tbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getEdgeService()).thenReturn(null);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder metaDataResult = internalTypeResult.metaData(new TbMsgMetaData());
    TbMsg.TbMsgBuilder queueNameResult = metaDataResult.originator(new AlarmId(UUID.randomUUID()))
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbMsgPushToEdgeNode.processMsg(ctx, msg);

    // Assert
    verify(ctx).getEdgeService();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@link TenantId#TenantId(UUID)} with id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test processMsg(TbContext, TbMsg); given TenantId(UUID) with id is 'null'")
  void testProcessMsg_givenTenantIdWithIdIsNull() {
    // Arrange
    TbMsgPushToEdgeNode tbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(null));
    when(ctx.getEdgeService()).thenReturn(new EdgeServiceImpl());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder metaDataResult = internalTypeResult.metaData(new TbMsgMetaData());
    TbMsg.TbMsgBuilder queueNameResult = metaDataResult.originator(new AssetId(UUID.randomUUID()))
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbMsgPushToEdgeNode.processMsg(ctx, msg);

    // Assert
    verify(ctx).getEdgeService();
    verify(ctx).getTenantId();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   *   <li>Then calls {@link TbContext#ack(TbMsg)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test processMsg(TbContext, TbMsg); given TenantId(UUID) with id is randomUUID; then calls ack(TbMsg)")
  void testProcessMsg_givenTenantIdWithIdIsRandomUUID_thenCallsAck() {
    // Arrange
    TbMsgPushToEdgeNode tbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(ctx).ack(Mockito.<TbMsg>any());
    when(ctx.getEdgeService()).thenReturn(new EdgeServiceImpl());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder metaDataResult = internalTypeResult.metaData(new TbMsgMetaData());
    TbMsg.TbMsgBuilder queueNameResult = metaDataResult.originator(new AlarmId(UUID.randomUUID()))
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbMsgPushToEdgeNode.processMsg(ctx, msg);

    // Assert
    verify(ctx).ack(isA(TbMsg.class));
    verify(ctx).getEdgeService();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test processMsg(TbContext, TbMsg); when 'null'; then calls tellFailure(TbMsg, Throwable)")
  void testProcessMsg_whenNull_thenCallsTellFailure() {
    // Arrange
    TbMsgPushToEdgeNode tbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbMsgPushToEdgeNode.processMsg(ctx, null);

    // Assert
    verify(ctx).tellFailure(isNull(), isA(Throwable.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbMsgPushToEdgeNode}
   *   <li>{@link TbMsgPushToEdgeNode#getConfigClazz()}
   *   <li>{@link TbMsgPushToEdgeNode#getIgnoredMessageSource()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgPushToEdgeNode actualTbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();
    Class<TbMsgPushToEdgeNodeConfiguration> actualConfigClazz = actualTbMsgPushToEdgeNode.getConfigClazz();

    // Assert
    assertEquals("edge", actualTbMsgPushToEdgeNode.getIgnoredMessageSource());
    Class<TbMsgPushToEdgeNodeConfiguration> expectedConfigClazz = TbMsgPushToEdgeNodeConfiguration.class;
    assertEquals(expectedConfigClazz, actualConfigClazz);
  }
}
