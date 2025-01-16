package org.thingsboard.rule.engine.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import java.util.function.BiFunction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class SemaphoreWithTbMsgQueueDiffblueTest {
  /**
   * Test
   * {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link TbMsgCallback} {@link TbMsgCallback#isMsgValid()} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)}
   */
  @Test
  @DisplayName("Test addToQueueAndTryProcess(TbMsg, TbContext, BiFunction); given 'false'; when TbMsgCallback isMsgValid() return 'false'")
  void testAddToQueueAndTryProcess_givenFalse_whenTbMsgCallbackIsMsgValidReturnFalse() {
    // Arrange
    SemaphoreWithTbMsgQueue semaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(null);
    TbMsgCallback callback = mock(TbMsgCallback.class);
    when(callback.isMsgValid()).thenReturn(false);
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);
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
    semaphoreWithTbMsgQueue.addToQueueAndTryProcess(msg, mock(TbContext.class), mock(BiFunction.class));

    // Assert
    verify(callback).isMsgValid();
  }

  /**
   * Test
   * {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)}.
   * <ul>
   *   <li>Given {@link ForwardingApiFuture#ForwardingApiFuture(ApiFuture)} with
   * delegate is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)}
   */
  @Test
  @DisplayName("Test addToQueueAndTryProcess(TbMsg, TbContext, BiFunction); given ForwardingApiFuture(ApiFuture) with delegate is 'null'")
  void testAddToQueueAndTryProcess_givenForwardingApiFutureWithDelegateIsNull() {
    // Arrange
    SemaphoreWithTbMsgQueue semaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(null);
    TbMsgCallback callback = mock(TbMsgCallback.class);
    when(callback.isMsgValid()).thenReturn(true);
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);
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
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    BiFunction<TbContext, TbMsg, ListenableFuture<TbMsg>> msgProcessingFunction = mock(BiFunction.class);
    when(msgProcessingFunction.apply(Mockito.<TbContext>any(), Mockito.<TbMsg>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(null)));

    // Act
    semaphoreWithTbMsgQueue.addToQueueAndTryProcess(msg, ctx, msgProcessingFunction);

    // Assert
    verify(msgProcessingFunction).apply(isA(TbContext.class), isA(TbMsg.class));
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(callback).isMsgValid();
  }

  /**
   * Test
   * {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)}
   */
  @Test
  @DisplayName("Test addToQueueAndTryProcess(TbMsg, TbContext, BiFunction); given 'null'")
  void testAddToQueueAndTryProcess_givenNull() {
    // Arrange
    SemaphoreWithTbMsgQueue semaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(null);
    TbMsgCallback callback = mock(TbMsgCallback.class);
    when(callback.isMsgValid()).thenReturn(true);
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);
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
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(null);
    ListenableFutureTask<TbMsg> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    BiFunction<TbContext, TbMsg, ListenableFuture<TbMsg>> msgProcessingFunction = mock(BiFunction.class);
    when(msgProcessingFunction.apply(Mockito.<TbContext>any(), Mockito.<TbMsg>any())).thenReturn(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));

    // Act
    semaphoreWithTbMsgQueue.addToQueueAndTryProcess(msg, ctx, msgProcessingFunction);

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(msgProcessingFunction).apply(isA(TbContext.class), isA(TbMsg.class));
    verify(ctx).getDbCallbackExecutor();
    verify(callback).isMsgValid();
  }

  /**
   * Test
   * {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)}.
   * <ul>
   *   <li>Given {@link TestDbCallbackExecutor} (default constructor).</li>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)}
   */
  @Test
  @DisplayName("Test addToQueueAndTryProcess(TbMsg, TbContext, BiFunction); given TestDbCallbackExecutor (default constructor); then calls addListener(Runnable, Executor)")
  void testAddToQueueAndTryProcess_givenTestDbCallbackExecutor_thenCallsAddListener() {
    // Arrange
    SemaphoreWithTbMsgQueue semaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(null);
    TbMsgCallback callback = mock(TbMsgCallback.class);
    when(callback.isMsgValid()).thenReturn(true);
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(callback);
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
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    ListenableFutureTask<TbMsg> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    BiFunction<TbContext, TbMsg, ListenableFuture<TbMsg>> msgProcessingFunction = mock(BiFunction.class);
    when(msgProcessingFunction.apply(Mockito.<TbContext>any(), Mockito.<TbMsg>any())).thenReturn(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));

    // Act
    semaphoreWithTbMsgQueue.addToQueueAndTryProcess(msg, ctx, msgProcessingFunction);

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(msgProcessingFunction).apply(isA(TbContext.class), isA(TbMsg.class));
    verify(ctx).getDbCallbackExecutor();
    verify(callback).isMsgValid();
  }

  /**
   * Test
   * {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)}
   */
  @Test
  @DisplayName("Test addToQueueAndTryProcess(TbMsg, TbContext, BiFunction); when 'null'; then calls tellFailure(TbMsg, Throwable)")
  void testAddToQueueAndTryProcess_whenNull_thenCallsTellFailure() {
    // Arrange
    SemaphoreWithTbMsgQueue semaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(null);
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    semaphoreWithTbMsgQueue.addToQueueAndTryProcess(null, ctx, mock(BiFunction.class));

    // Assert
    verify(ctx).tellFailure(isNull(), isA(Throwable.class));
  }

  /**
   * Test {@link SemaphoreWithTbMsgQueue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SemaphoreWithTbMsgQueue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SemaphoreWithTbMsgQueue semaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(mock(AlarmId.class));

    // Act and Assert
    assertNotEquals(semaphoreWithTbMsgQueue, new SemaphoreWithTbMsgQueue(null));
  }

  /**
   * Test {@link SemaphoreWithTbMsgQueue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SemaphoreWithTbMsgQueue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new SemaphoreWithTbMsgQueue(mock(AlarmId.class)), "42");
  }

  /**
   * Test {@link SemaphoreWithTbMsgQueue#SemaphoreWithTbMsgQueue(EntityId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return EntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SemaphoreWithTbMsgQueue#SemaphoreWithTbMsgQueue(EntityId)}
   */
  @Test
  @DisplayName("Test new SemaphoreWithTbMsgQueue(EntityId); when 'null'; then return EntityId is 'null'")
  void testNewSemaphoreWithTbMsgQueue_whenNull_thenReturnEntityIdIsNull() {
    // Arrange and Act
    SemaphoreWithTbMsgQueue actualSemaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(null);

    // Assert
    assertNull(actualSemaphoreWithTbMsgQueue.getEntityId());
    Semaphore semaphore = actualSemaphoreWithTbMsgQueue.getSemaphore();
    assertEquals(0, semaphore.getQueueLength());
    assertFalse(semaphore.hasQueuedThreads());
    assertFalse(semaphore.isFair());
    assertTrue(actualSemaphoreWithTbMsgQueue.getQueue().isEmpty());
  }
}
