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
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
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
  void testWithCallbackAndTimeout2() {
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
        future, onSuccess, onFailure, 10L, new DefaultEventLoop(), null);

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
        future, onSuccess, onFailure, 10L, new DefaultEventLoop(), null);

    // Assert
    verify(delegate, atLeast(1)).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    verify(delegate).isDone();
  }

  /**
   * Test {@link AsyncCallbackTemplate#withCallbackAndTimeout(ListenableFuture, Consumer, Consumer,
   * long, ScheduledExecutorService, Executor)}.
   *
   * <ul>
   *   <li>Given {@link Thread#Thread()}.
   *   <li>Then calls {@link ThreadFactory#newThread(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link AsyncCallbackTemplate#withCallbackAndTimeout(ListenableFuture,
   * Consumer, Consumer, long, ScheduledExecutorService, Executor)}
   */
  @Test
  @DisplayName(
      "Test withCallbackAndTimeout(ListenableFuture, Consumer, Consumer, long, ScheduledExecutorService, Executor); given Thread(); then calls newThread(Runnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AsyncCallbackTemplate.withCallbackAndTimeout(ListenableFuture, Consumer, Consumer, long, ScheduledExecutorService, Executor)"
  })
  void testWithCallbackAndTimeout_givenThread_thenCallsNewThread() {
    // Arrange
    ListenableFutureTask<Object> future = mock(ListenableFutureTask.class);
    when(future.isDone()).thenReturn(false);
    doNothing().when(future).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    Consumer<Object> onSuccess = mock(Consumer.class);
    MultipleTbQueueCallbackWrapper multipleTbQueueCallbackWrapper =
        new MultipleTbQueueCallbackWrapper(3, null);
    Consumer<Throwable> onFailure = multipleTbQueueCallbackWrapper::onFailure;

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

    // Act
    AsyncCallbackTemplate.withCallbackAndTimeout(
        future,
        onSuccess,
        onFailure,
        10L,
        new DefaultEventLoop(threadFactory),
        mock(Executor.class));

    // Assert
    verify(future).addListener(isA(Runnable.class), isA(Executor.class));
    verify(future).isDone();
    verify(threadFactory).newThread(isA(Runnable.class));
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
