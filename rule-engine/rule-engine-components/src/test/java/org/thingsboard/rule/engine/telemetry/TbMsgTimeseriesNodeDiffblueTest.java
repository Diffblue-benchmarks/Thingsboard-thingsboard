package org.thingsboard.rule.engine.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.UUID;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileData;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbMsgTimeseriesNodeDiffblueTest {
  /**
   * Test {@link TbMsgTimeseriesNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgTimeseriesNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given IllegalArgumentException(String) with 'foo'; then throw IllegalArgumentException")
  void testInit_givenIllegalArgumentExceptionWithFoo_thenThrowIllegalArgumentException() throws TbNodeException {
    // Arrange
    TbMsgTimeseriesNode tbMsgTimeseriesNode = new TbMsgTimeseriesNode();
    TbContext ctx = mock(TbContext.class);
    doThrow(new IllegalArgumentException("foo")).when(ctx)
        .addTenantProfileListener(Mockito.<Consumer<TenantProfile>>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbMsgTimeseriesNode.init(ctx, new TbNodeConfiguration(null)));
    verify(ctx).addTenantProfileListener(isA(Consumer.class));
  }

  /**
   * Test {@link TbMsgTimeseriesNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@link TenantProfile#TenantProfile()}.</li>
   *   <li>Then calls {@link TbContext#getTenantProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgTimeseriesNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given TenantProfile(); then calls getTenantProfile()")
  void testInit_givenTenantProfile_thenCallsGetTenantProfile() throws TbNodeException {
    // Arrange
    TbMsgTimeseriesNode tbMsgTimeseriesNode = new TbMsgTimeseriesNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantProfile()).thenReturn(new TenantProfile());
    doNothing().when(ctx).addTenantProfileListener(Mockito.<Consumer<TenantProfile>>any());

    // Act
    tbMsgTimeseriesNode.init(ctx, new TbNodeConfiguration(null));

    // Assert
    verify(ctx).addTenantProfileListener(isA(Consumer.class));
    verify(ctx).getTenantProfile();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onTenantProfileUpdate(TenantProfile)}.
   * <ul>
   *   <li>Then calls {@link TenantProfile#getProfileData()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgTimeseriesNode#onTenantProfileUpdate(TenantProfile)}
   */
  @Test
  @DisplayName("Test onTenantProfileUpdate(TenantProfile); then calls getProfileData()")
  void testOnTenantProfileUpdate_thenCallsGetProfileData() {
    // Arrange
    TbMsgTimeseriesNode tbMsgTimeseriesNode = new TbMsgTimeseriesNode();

    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getProfileData()).thenReturn(tenantProfileData);

    // Act
    tbMsgTimeseriesNode.onTenantProfileUpdate(tenantProfile);

    // Assert
    verify(tenantProfile).getProfileData();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given IllegalArgumentException(String) with 'foo'; then throw IllegalArgumentException")
  void testOnMsg_givenIllegalArgumentExceptionWithFoo_thenThrowIllegalArgumentException() {
    // Arrange
    TbMsgTimeseriesNode tbMsgTimeseriesNode = new TbMsgTimeseriesNode();
    TbContext ctx = mock(TbContext.class);
    doThrow(new IllegalArgumentException("foo")).when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
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
    assertThrows(IllegalArgumentException.class, () -> tbMsgTimeseriesNode.onMsg(ctx, msg));
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)}
   * does nothing.</li>
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); when TbContext tellFailure(TbMsg, Throwable) does nothing; then calls tellFailure(TbMsg, Throwable)")
  void testOnMsg_whenTbContextTellFailureDoesNothing_thenCallsTellFailure() {
    // Arrange
    TbMsgTimeseriesNode tbMsgTimeseriesNode = new TbMsgTimeseriesNode();
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
    tbMsgTimeseriesNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbMsgTimeseriesNode#computeTs(TbMsg, boolean)}.
   * <ul>
   *   <li>Given {@link TbMsgBuilder} {@link TbMsgBuilder#metaData(TbMsgMetaData)}
   * return builder.</li>
   *   <li>Then calls {@link TbMsgBuilder#callback(TbMsgCallback)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgTimeseriesNode#computeTs(TbMsg, boolean)}
   */
  @Test
  @DisplayName("Test computeTs(TbMsg, boolean); given TbMsgBuilder metaData(TbMsgMetaData) return builder; then calls callback(TbMsgCallback)")
  void testComputeTs_givenTbMsgBuilderMetaDataReturnBuilder_thenCallsCallback() {
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
    TbMsg.TbMsgBuilder callbackResult = tbMsgBuilder9.callback(mock(TbMsgCallback.class));
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
    TbMsgTimeseriesNode.computeTs(msg, true);

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
  }

  /**
   * Test {@link TbMsgTimeseriesNode#computeTs(TbMsg, boolean)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgTimeseriesNode#computeTs(TbMsg, boolean)}
   */
  @Test
  @DisplayName("Test computeTs(TbMsg, boolean); then return one")
  void testComputeTs_thenReturnOne() {
    // Arrange
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
    assertEquals(1L, TbMsgTimeseriesNode.computeTs(msg, false));
  }
}
