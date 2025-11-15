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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class AsyncCallbackTemplateDiffblueTest {
  /**
   * Method under test:
   * {@link AsyncCallbackTemplate#withCallbackAndTimeout(ListenableFuture, Consumer, Consumer, long, ScheduledExecutorService, Executor)}
   */
  @Test
  void testWithCallbackAndTimeout() {
    // Arrange
    ListenableFutureTask<Object> delegate = mock(ListenableFutureTask.class);
    when(delegate.isDone()).thenReturn(true);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ApiFutureToListenableFuture<Object> future = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    Consumer<Object> onSuccess = mock(Consumer.class);
    Consumer<Throwable> onFailure = new MultipleTbQueueCallbackWrapper(3,
        new TbQueueTbMsgCallbackWrapper(mock(TbMsgCallback.class)))::onFailure;

    // Act
    AsyncCallbackTemplate.withCallbackAndTimeout(future, onSuccess, onFailure, 10L, new DefaultEventLoop(),
        mock(Executor.class));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(delegate).isDone();
  }

  /**
   * Method under test:
   * {@link AsyncCallbackTemplate#withCallbackAndTimeout(ListenableFuture, Consumer, Consumer, long, ScheduledExecutorService, Executor)}
   */
  @Test
  void testWithCallbackAndTimeout2() {
    // Arrange
    ListenableFutureTask<Object> delegate = mock(ListenableFutureTask.class);
    when(delegate.isDone()).thenReturn(false);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ApiFutureToListenableFuture<Object> future = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    Consumer<Object> onSuccess = mock(Consumer.class);
    Consumer<Throwable> onFailure = new MultipleTbQueueCallbackWrapper(3,
        new TbQueueTbMsgCallbackWrapper(mock(TbMsgCallback.class)))::onFailure;
    DefaultEventLoop timeoutExecutor = new DefaultEventLoop();

    // Act
    AsyncCallbackTemplate.withCallbackAndTimeout(future, onSuccess, onFailure, 10L, timeoutExecutor,
        mock(Executor.class));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(delegate).isDone();
    assertFalse(timeoutExecutor.isTerminated());
  }

  /**
   * Method under test:
   * {@link AsyncCallbackTemplate#withCallbackAndTimeout(ListenableFuture, Consumer, Consumer, long, ScheduledExecutorService, Executor)}
   */
  @Test
  void testWithCallbackAndTimeout3() {
    // Arrange
    ListenableFutureTask<Object> future = mock(ListenableFutureTask.class);
    when(future.isDone()).thenReturn(true);
    doNothing().when(future).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    Consumer<Object> onSuccess = mock(Consumer.class);
    Consumer<Throwable> onFailure = new MultipleTbQueueCallbackWrapper(3,
        new TbQueueTbMsgCallbackWrapper(mock(TbMsgCallback.class)))::onFailure;

    // Act
    AsyncCallbackTemplate.withCallbackAndTimeout(future, onSuccess, onFailure, 10L, new DefaultEventLoop(), null);

    // Assert
    verify(future).addListener(isA(Runnable.class), isA(Executor.class));
    verify(future).isDone();
  }

  /**
   * Method under test:
   * {@link AsyncCallbackTemplate#withCallback(ListenableFuture, Consumer, Consumer, Executor)}
   */
  @Test
  void testWithCallback() {
    // Arrange
    ListenableFutureTask<Object> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ApiFutureToListenableFuture<Object> future = new ApiFutureToListenableFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate)));
    Consumer<Object> onSuccess = mock(Consumer.class);

    // Act
    AsyncCallbackTemplate.withCallback(future, onSuccess,
        new MultipleTbQueueCallbackWrapper(3, new TbQueueTbMsgCallbackWrapper(mock(TbMsgCallback.class)))::onFailure,
        mock(Executor.class));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
  }

  /**
   * Method under test:
   * {@link AsyncCallbackTemplate#withCallback(ListenableFuture, Consumer, Consumer, Executor)}
   */
  @Test
  void testWithCallback2() {
    // Arrange
    SettableApiFuture<Object> apiFuture = SettableApiFuture.create();
    apiFuture.set("Value");
    ApiFutureToListenableFuture<Object> future = new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(new ApiFutureToListenableFuture<>(apiFuture)))));
    Consumer<Object> onSuccess = mock(Consumer.class);
    doNothing().when(onSuccess).accept(Mockito.<Object>any());

    // Act
    AsyncCallbackTemplate.withCallback(future, onSuccess,
        new MultipleTbQueueCallbackWrapper(3, new TbQueueTbMsgCallbackWrapper(mock(TbMsgCallback.class)))::onFailure,
        null);

    // Assert
    verify(onSuccess).accept(isA(Object.class));
  }
}
