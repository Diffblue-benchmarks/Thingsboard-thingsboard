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
package org.thingsboard.server.queue.common;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
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
import com.microsoft.rest.ServiceFuture;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class AsyncCallbackTemplateDiffblueTest {
  /**
   * Test {@link AsyncCallbackTemplate#withCallbackAndTimeout(ListenableFuture, Consumer, Consumer,
   * long, ScheduledExecutorService, Executor)}.
   *
   * <p>Method under test: {@link AsyncCallbackTemplate#withCallbackAndTimeout(ListenableFuture,
   * Consumer, Consumer, long, ScheduledExecutorService, Executor)}
   */
  @Test
  @DisplayName(
      "Test withCallbackAndTimeout(ListenableFuture, Consumer, Consumer, long, ScheduledExecutorService, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AsyncCallbackTemplate.withCallbackAndTimeout(ListenableFuture, Consumer, Consumer, long, ScheduledExecutorService, Executor)"
  })
  void testWithCallbackAndTimeout() {
    // Arrange
    ListenableFutureTask<Object> delegate = mock(ListenableFutureTask.class);
    when(delegate.isDone()).thenReturn(true);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ListenableFutureToApiFuture<Object> delegate2 = new ListenableFutureToApiFuture<>(delegate);
    ForwardingApiFuture<Object> apiFuture = new ForwardingApiFuture<>(delegate2);
    ApiFutureToListenableFuture<Object> future = new ApiFutureToListenableFuture<>(apiFuture);
    Consumer<Object> onSuccess = mock(Consumer.class);
    TbQueueTbMsgCallbackWrapper callback =
        new TbQueueTbMsgCallbackWrapper(mock(TbMsgCallback.class));
    MultipleTbQueueCallbackWrapper multipleTbQueueCallbackWrapper =
        new MultipleTbQueueCallbackWrapper(3, callback);
    Consumer<Throwable> onFailure = multipleTbQueueCallbackWrapper::onFailure;

    // Act
    AsyncCallbackTemplate.withCallbackAndTimeout(
        future, onSuccess, onFailure, 10L, new DefaultEventLoop(), mock(Executor.class));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(delegate).isDone();
  }

  /**
   * Test {@link AsyncCallbackTemplate#withCallbackAndTimeout(ListenableFuture, Consumer, Consumer,
   * long, ScheduledExecutorService, Executor)}.
   *
   * <ul>
   *   <li>Given {@link Runnable}.
   * </ul>
   *
   * <p>Method under test: {@link AsyncCallbackTemplate#withCallbackAndTimeout(ListenableFuture,
   * Consumer, Consumer, long, ScheduledExecutorService, Executor)}
   */
  @Test
  @DisplayName(
      "Test withCallbackAndTimeout(ListenableFuture, Consumer, Consumer, long, ScheduledExecutorService, Executor); given Runnable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AsyncCallbackTemplate.withCallbackAndTimeout(ListenableFuture, Consumer, Consumer, long, ScheduledExecutorService, Executor)"
  })
  void testWithCallbackAndTimeout_givenRunnable() {
    // Arrange
    ListenableFutureTask<Object> delegate = mock(ListenableFutureTask.class);
    when(delegate.isDone()).thenReturn(true);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());

    ListenableFutureToApiFuture<Object> delegate2 = new ListenableFutureToApiFuture<>(delegate);
    delegate2.addListener(mock(Runnable.class), mock(Executor.class));
    ForwardingApiFuture<Object> apiFuture = new ForwardingApiFuture<>(delegate2);
    ApiFutureToListenableFuture<Object> future = new ApiFutureToListenableFuture<>(apiFuture);
    Consumer<Object> onSuccess = mock(Consumer.class);
    TbQueueTbMsgCallbackWrapper callback =
        new TbQueueTbMsgCallbackWrapper(mock(TbMsgCallback.class));
    MultipleTbQueueCallbackWrapper multipleTbQueueCallbackWrapper =
        new MultipleTbQueueCallbackWrapper(3, callback);
    Consumer<Throwable> onFailure = multipleTbQueueCallbackWrapper::onFailure;

    // Act
    AsyncCallbackTemplate.withCallbackAndTimeout(
        future, onSuccess, onFailure, 10L, new DefaultEventLoop(), mock(Executor.class));

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    verify(delegate).isDone();
  }

  /**
   * Test {@link AsyncCallbackTemplate#withCallbackAndTimeout(ListenableFuture, Consumer, Consumer,
   * long, ScheduledExecutorService, Executor)}.
   *
   * <ul>
   *   <li>Then calls {@link ServiceFuture#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link AsyncCallbackTemplate#withCallbackAndTimeout(ListenableFuture,
   * Consumer, Consumer, long, ScheduledExecutorService, Executor)}
   */
  @Test
  @DisplayName(
      "Test withCallbackAndTimeout(ListenableFuture, Consumer, Consumer, long, ScheduledExecutorService, Executor); then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AsyncCallbackTemplate.withCallbackAndTimeout(ListenableFuture, Consumer, Consumer, long, ScheduledExecutorService, Executor)"
  })
  void testWithCallbackAndTimeout_thenCallsAddListener() {
    // Arrange
    ServiceFuture<Object> delegate = mock(ServiceFuture.class);
    when(delegate.isDone()).thenReturn(true);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ListenableFutureToApiFuture<Object> future = new ListenableFutureToApiFuture<>(delegate);
    Consumer<Object> onSuccess = mock(Consumer.class);
    TbQueueTbMsgCallbackWrapper callback =
        new TbQueueTbMsgCallbackWrapper(mock(TbMsgCallback.class));
    MultipleTbQueueCallbackWrapper multipleTbQueueCallbackWrapper =
        new MultipleTbQueueCallbackWrapper(3, callback);
    Consumer<Throwable> onFailure = multipleTbQueueCallbackWrapper::onFailure;

    // Act
    AsyncCallbackTemplate.withCallbackAndTimeout(
        future, onSuccess, onFailure, 10L, new DefaultEventLoop(), null);

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(delegate).isDone();
  }

  /**
   * Test {@link AsyncCallbackTemplate#withCallback(ListenableFuture, Consumer, Consumer,
   * Executor)}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link AsyncCallbackTemplate#withCallback(ListenableFuture, Consumer,
   * Consumer, Executor)}
   */
  @Test
  @DisplayName(
      "Test withCallback(ListenableFuture, Consumer, Consumer, Executor); then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AsyncCallbackTemplate.withCallback(ListenableFuture, Consumer, Consumer, Executor)"
  })
  void testWithCallback_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<Object> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ListenableFutureToApiFuture<Object> delegate2 = new ListenableFutureToApiFuture<>(delegate);
    ForwardingApiFuture<Object> apiFuture = new ForwardingApiFuture<>(delegate2);
    ApiFutureToListenableFuture<Object> future = new ApiFutureToListenableFuture<>(apiFuture);
    Consumer<Object> onSuccess = mock(Consumer.class);
    TbQueueTbMsgCallbackWrapper callback =
        new TbQueueTbMsgCallbackWrapper(mock(TbMsgCallback.class));
    MultipleTbQueueCallbackWrapper multipleTbQueueCallbackWrapper =
        new MultipleTbQueueCallbackWrapper(3, callback);

    // Act
    AsyncCallbackTemplate.withCallback(
        future, onSuccess, multipleTbQueueCallbackWrapper::onFailure, mock(Executor.class));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
  }
}
