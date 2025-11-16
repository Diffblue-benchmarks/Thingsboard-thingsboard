/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.rule.engine.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class SemaphoreWithTbMsgQueueDiffblueTest {
  /**
   * Test {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgCallback#EMPTY}.
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext,
   * BiFunction)}
   */
  @Test
  @DisplayName(
      "Test addToQueueAndTryProcess(TbMsg, TbContext, BiFunction); given EMPTY; then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SemaphoreWithTbMsgQueue.addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)"
  })
  void testAddToQueueAndTryProcess_givenEmpty_thenCallsAddListener() {
    // Arrange
    SemaphoreWithTbMsgQueue semaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(null);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getCallback()).thenReturn(TbMsgCallback.EMPTY);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());

    ListenableFutureTask<TbMsg> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ListenableFutureToApiFuture<TbMsg> delegate2 = new ListenableFutureToApiFuture<>(delegate);
    ForwardingApiFuture<TbMsg> apiFuture = new ForwardingApiFuture<>(delegate2);

    BiFunction<TbContext, TbMsg, ListenableFuture<TbMsg>> msgProcessingFunction =
        mock(BiFunction.class);
    when(msgProcessingFunction.apply(Mockito.<TbContext>any(), Mockito.<TbMsg>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    // Act
    semaphoreWithTbMsgQueue.addToQueueAndTryProcess(msg, ctx, msgProcessingFunction);

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(msgProcessingFunction).apply(isA(TbContext.class), isA(TbMsg.class));
    verify(ctx).getDbCallbackExecutor();
    verify(msg).getCallback();
  }

  /**
   * Test {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgCallback#EMPTY}.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext,
   * BiFunction)}
   */
  @Test
  @DisplayName(
      "Test addToQueueAndTryProcess(TbMsg, TbContext, BiFunction); given EMPTY; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SemaphoreWithTbMsgQueue.addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)"
  })
  void testAddToQueueAndTryProcess_givenEmpty_thenCallsTellFailure() {
    // Arrange
    SemaphoreWithTbMsgQueue semaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(null);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getCallback()).thenReturn(TbMsgCallback.EMPTY);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    BiFunction<TbContext, TbMsg, ListenableFuture<TbMsg>> msgProcessingFunction =
        mock(BiFunction.class);
    when(msgProcessingFunction.apply(Mockito.<TbContext>any(), Mockito.<TbMsg>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(null)));

    // Act
    semaphoreWithTbMsgQueue.addToQueueAndTryProcess(msg, ctx, msgProcessingFunction);

    // Assert
    verify(msgProcessingFunction).apply(isA(TbContext.class), isA(TbMsg.class));
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getCallback();
  }

  /**
   * Test {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgCallback} {@link TbMsgCallback#isMsgValid()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext,
   * BiFunction)}
   */
  @Test
  @DisplayName(
      "Test addToQueueAndTryProcess(TbMsg, TbContext, BiFunction); given TbMsgCallback isMsgValid() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SemaphoreWithTbMsgQueue.addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)"
  })
  void testAddToQueueAndTryProcess_givenTbMsgCallbackIsMsgValidReturnFalse() {
    // Arrange
    SemaphoreWithTbMsgQueue semaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(null);

    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    when(tbMsgCallback.isMsgValid()).thenReturn(false);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getCallback()).thenReturn(tbMsgCallback);

    // Act
    semaphoreWithTbMsgQueue.addToQueueAndTryProcess(
        msg, mock(TbContext.class), mock(BiFunction.class));

    // Assert
    verify(msg).getCallback();
    verify(tbMsgCallback).isMsgValid();
  }

  /**
   * Test {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext,
   * BiFunction)}
   */
  @Test
  @DisplayName(
      "Test addToQueueAndTryProcess(TbMsg, TbContext, BiFunction); then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SemaphoreWithTbMsgQueue.addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)"
  })
  void testAddToQueueAndTryProcess_thenCallsAddListener() {
    // Arrange
    SemaphoreWithTbMsgQueue semaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(null);

    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    when(tbMsgCallback.isMsgValid()).thenReturn(true);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getCallback()).thenReturn(tbMsgCallback);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(null);

    ListenableFutureTask<TbMsg> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ListenableFutureToApiFuture<TbMsg> delegate2 = new ListenableFutureToApiFuture<>(delegate);
    ForwardingApiFuture<TbMsg> apiFuture = new ForwardingApiFuture<>(delegate2);

    BiFunction<TbContext, TbMsg, ListenableFuture<TbMsg>> msgProcessingFunction =
        mock(BiFunction.class);
    when(msgProcessingFunction.apply(Mockito.<TbContext>any(), Mockito.<TbMsg>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    // Act
    semaphoreWithTbMsgQueue.addToQueueAndTryProcess(msg, ctx, msgProcessingFunction);

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(msgProcessingFunction).apply(isA(TbContext.class), isA(TbMsg.class));
    verify(ctx).getDbCallbackExecutor();
    verify(msg).getCallback();
    verify(tbMsgCallback).isMsgValid();
  }

  /**
   * Test {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link SemaphoreWithTbMsgQueue#addToQueueAndTryProcess(TbMsg, TbContext,
   * BiFunction)}
   */
  @Test
  @DisplayName(
      "Test addToQueueAndTryProcess(TbMsg, TbContext, BiFunction); then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SemaphoreWithTbMsgQueue.addToQueueAndTryProcess(TbMsg, TbContext, BiFunction)"
  })
  void testAddToQueueAndTryProcess_thenCallsTellFailure() {
    // Arrange
    SemaphoreWithTbMsgQueue semaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(null);

    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    when(tbMsgCallback.isMsgValid()).thenReturn(true);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getCallback()).thenReturn(tbMsgCallback);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(null);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    BiFunction<TbContext, TbMsg, ListenableFuture<TbMsg>> msgProcessingFunction =
        mock(BiFunction.class);
    when(msgProcessingFunction.apply(Mockito.<TbContext>any(), Mockito.<TbMsg>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(null)));

    // Act
    semaphoreWithTbMsgQueue.addToQueueAndTryProcess(msg, ctx, msgProcessingFunction);

    // Assert
    verify(msgProcessingFunction).apply(isA(TbContext.class), isA(TbMsg.class));
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getCallback();
    verify(tbMsgCallback).isMsgValid();
  }

  /**
   * Test {@link SemaphoreWithTbMsgQueue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SemaphoreWithTbMsgQueue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SemaphoreWithTbMsgQueue.equals(Object)",
    "int SemaphoreWithTbMsgQueue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SemaphoreWithTbMsgQueue semaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(null);

    // Act and Assert
    assertNotEquals(semaphoreWithTbMsgQueue, new SemaphoreWithTbMsgQueue(null));
  }

  /**
   * Test {@link SemaphoreWithTbMsgQueue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SemaphoreWithTbMsgQueue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SemaphoreWithTbMsgQueue.equals(Object)",
    "int SemaphoreWithTbMsgQueue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SemaphoreWithTbMsgQueue semaphoreWithTbMsgQueue =
        new SemaphoreWithTbMsgQueue(new AlarmId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(semaphoreWithTbMsgQueue, new SemaphoreWithTbMsgQueue(null));
  }

  /**
   * Test {@link SemaphoreWithTbMsgQueue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SemaphoreWithTbMsgQueue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SemaphoreWithTbMsgQueue.equals(Object)",
    "int SemaphoreWithTbMsgQueue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new SemaphoreWithTbMsgQueue(null), 1);
  }

  /**
   * Test {@link SemaphoreWithTbMsgQueue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SemaphoreWithTbMsgQueue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SemaphoreWithTbMsgQueue.equals(Object)",
    "int SemaphoreWithTbMsgQueue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SemaphoreWithTbMsgQueue semaphoreWithTbMsgQueue = new SemaphoreWithTbMsgQueue(null);

    // Act and Assert
    assertNotEquals(
        semaphoreWithTbMsgQueue, new SemaphoreWithTbMsgQueue(new AlarmId(UUID.randomUUID())));
  }

  /**
   * Test {@link SemaphoreWithTbMsgQueue#SemaphoreWithTbMsgQueue(EntityId)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return EntityId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SemaphoreWithTbMsgQueue#SemaphoreWithTbMsgQueue(EntityId)}
   */
  @Test
  @DisplayName(
      "Test new SemaphoreWithTbMsgQueue(EntityId); when 'null'; then return EntityId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SemaphoreWithTbMsgQueue.<init>(EntityId)"})
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
