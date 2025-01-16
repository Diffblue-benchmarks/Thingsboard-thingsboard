package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

class TbGetCustomerDetailsNodeDiffblueTest {
  /**
   * Test
   * {@link TbGetCustomerDetailsNode#loadNodeConfiguration(TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_ARRAY}.</li>
   *   <li>Then throw {@link NoSuchElementException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetCustomerDetailsNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbNodeConfiguration); given 'START_ARRAY'; then throw NoSuchElementException")
  void testLoadNodeConfiguration_givenStartArray_thenThrowNoSuchElementException() throws TbNodeException {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();
    ArrayNode data = mock(ArrayNode.class);
    when(data.elements()).thenThrow(new NoSuchElementException("foo"));
    when(data.asToken()).thenReturn(JsonToken.START_ARRAY);

    // Act and Assert
    assertThrows(NoSuchElementException.class,
        () -> tbGetCustomerDetailsNode.loadNodeConfiguration(new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).elements();
  }

  /**
   * Test
   * {@link TbGetCustomerDetailsNode#getContactBasedFuture(TbContext, TbMsg)}.
   * <ul>
   *   <li>Then calls {@link TbContext#getAssetService()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetCustomerDetailsNode#getContactBasedFuture(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test getContactBasedFuture(TbContext, TbMsg); then calls getAssetService()")
  void testGetContactBasedFuture_thenCallsGetAssetService() {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getAssetService()).thenThrow(new RuntimeException("foo"));
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

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbGetCustomerDetailsNode.getContactBasedFuture(ctx, msg));
    verify(ctx).getAssetService();
  }

  /**
   * Test
   * {@link TbGetCustomerDetailsNode#getContactBasedFuture(TbContext, TbMsg)}.
   * <ul>
   *   <li>Then calls {@link TbContext#getTenantId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetCustomerDetailsNode#getContactBasedFuture(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test getContactBasedFuture(TbContext, TbMsg); then calls getTenantId()")
  void testGetContactBasedFuture_thenCallsGetTenantId() {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();
    TbContext ctx = mock(TbContext.class);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    when(ctx.getDeviceService()).thenReturn(new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService()));
    when(ctx.getTenantId()).thenThrow(new RuntimeException("foo"));
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder metaDataResult = internalTypeResult.metaData(new TbMsgMetaData());
    TbMsg.TbMsgBuilder queueNameResult = metaDataResult.originator(new DeviceId(UUID.randomUUID()))
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbGetCustomerDetailsNode.getContactBasedFuture(ctx, msg));
    verify(ctx).getDeviceService();
    verify(ctx).getTenantId();
  }

  /**
   * Test
   * {@link TbGetCustomerDetailsNode#getContactBasedFuture(TbContext, TbMsg)}.
   * <ul>
   *   <li>Then return Done.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetCustomerDetailsNode#getContactBasedFuture(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test getContactBasedFuture(TbContext, TbMsg); then return Done")
  void testGetContactBasedFuture_thenReturnDone() {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();
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
    TbMsg.TbMsgBuilder queueNameResult = metaDataResult.originator(new AlarmId(UUID.randomUUID()))
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertTrue(tbGetCustomerDetailsNode.getContactBasedFuture(ctx, msg).isDone());
  }

  /**
   * Test
   * {@link TbGetCustomerDetailsNode#getContactBasedFuture(TbContext, TbMsg)}.
   * <ul>
   *   <li>Then throw {@link NoSuchElementException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbGetCustomerDetailsNode#getContactBasedFuture(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test getContactBasedFuture(TbContext, TbMsg); then throw NoSuchElementException")
  void testGetContactBasedFuture_thenThrowNoSuchElementException() {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceService()).thenThrow(new NoSuchElementException("foo"));
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder metaDataResult = internalTypeResult.metaData(new TbMsgMetaData());
    TbMsg.TbMsgBuilder queueNameResult = metaDataResult.originator(new DeviceId(UUID.randomUUID()))
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> tbGetCustomerDetailsNode.getContactBasedFuture(ctx, msg));
    verify(ctx).getDeviceService();
  }

  /**
   * Test {@link TbGetCustomerDetailsNode#upgrade(int, JsonNode)}.
   * <p>
   * Method under test: {@link TbGetCustomerDetailsNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode)")
  void testUpgrade() throws TbNodeException {
    // Arrange
    TbGetCustomerDetailsNode tbGetCustomerDetailsNode = new TbGetCustomerDetailsNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult = tbGetCustomerDetailsNode.upgrade(1, oldConfiguration);

    // Assert
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, actualUpgradeResult.getSecond());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbGetCustomerDetailsNode}
   *   <li>{@link TbGetCustomerDetailsNode#getPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("customer_", (new TbGetCustomerDetailsNode()).getPrefix());
  }
}
