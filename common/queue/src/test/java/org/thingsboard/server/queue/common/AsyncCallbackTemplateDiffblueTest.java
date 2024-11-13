package org.thingsboard.server.queue.common;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class AsyncCallbackTemplateDiffblueTest {
  /**
   * Test
   * {@link AsyncCallbackTemplate#withCallback(ListenableFuture, Consumer, Consumer, Executor)}.
   * <ul>
   *   <li>Given {@code Value}.</li>
   *   <li>When create {@code Value}.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AsyncCallbackTemplate#withCallback(ListenableFuture, Consumer, Consumer, Executor)}
   */
  @Test
  @DisplayName("Test withCallback(ListenableFuture, Consumer, Consumer, Executor); given 'Value'; when create 'Value'; then calls accept(Object)")
  void testWithCallback_givenValue_whenCreateValue_thenCallsAccept() {
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

  /**
   * Test
   * {@link AsyncCallbackTemplate#withCallback(ListenableFuture, Consumer, Consumer, Executor)}.
   * <ul>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AsyncCallbackTemplate#withCallback(ListenableFuture, Consumer, Consumer, Executor)}
   */
  @Test
  @DisplayName("Test withCallback(ListenableFuture, Consumer, Consumer, Executor); then calls addListener(Runnable, Executor)")
  void testWithCallback_thenCallsAddListener() {
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
}
