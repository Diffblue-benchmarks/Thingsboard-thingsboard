package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoop;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.util.concurrent.AbstractScheduledEventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RetransmissionHandlerDiffblueTest {
  /**
   * Test {@link RetransmissionHandler#start(EventLoop)}.
   * <ul>
   *   <li>Given {@link PendingOperation} {@link PendingOperation#isCanceled()}
   * return {@code true}.</li>
   *   <li>Then calls {@link PendingOperation#isCanceled()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RetransmissionHandler#start(EventLoop)}
   */
  @Test
  @DisplayName("Test start(EventLoop); given PendingOperation isCanceled() return 'true'; then calls isCanceled()")
  void testStart_givenPendingOperationIsCanceledReturnTrue_thenCallsIsCanceled() {
    // Arrange
    PendingOperation pendingOperation = mock(PendingOperation.class);
    when(pendingOperation.isCanceled()).thenReturn(true);

    RetransmissionHandler<MqttMessage> retransmissionHandler = new RetransmissionHandler<>(pendingOperation);
    retransmissionHandler.setHandle(mock(BiConsumer.class));

    // Act
    retransmissionHandler.start(new DefaultEventLoop());

    // Assert
    verify(pendingOperation).isCanceled();
  }

  /**
   * Test {@link RetransmissionHandler#start(EventLoop)}.
   * <ul>
   *   <li>Given {@link ScheduledFuture}.</li>
   *   <li>Then calls
   * {@link AbstractScheduledEventExecutor#schedule(Runnable, long, TimeUnit)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RetransmissionHandler#start(EventLoop)}
   */
  @Test
  @DisplayName("Test start(EventLoop); given ScheduledFuture; then calls schedule(Runnable, long, TimeUnit)")
  void testStart_givenScheduledFuture_thenCallsSchedule() {
    // Arrange
    PendingOperation pendingOperation = mock(PendingOperation.class);
    when(pendingOperation.isCanceled()).thenReturn(false);

    RetransmissionHandler<MqttMessage> retransmissionHandler = new RetransmissionHandler<>(pendingOperation);
    retransmissionHandler.setHandle(mock(BiConsumer.class));
    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    Mockito.<ScheduledFuture<?>>when(eventLoop.schedule(Mockito.<Runnable>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(mock(ScheduledFuture.class));

    // Act
    retransmissionHandler.start(eventLoop);

    // Assert
    verify(eventLoop).schedule(isA(Runnable.class), eq(10L), eq(TimeUnit.SECONDS));
    verify(pendingOperation).isCanceled();
  }

  /**
   * Test {@link RetransmissionHandler#start(EventLoop)}.
   * <ul>
   *   <li>Then not {@link DefaultEventLoop#DefaultEventLoop()} Terminated.</li>
   * </ul>
   * <p>
   * Method under test: {@link RetransmissionHandler#start(EventLoop)}
   */
  @Test
  @DisplayName("Test start(EventLoop); then not DefaultEventLoop() Terminated")
  void testStart_thenNotDefaultEventLoopTerminated() {
    // Arrange
    PendingOperation pendingOperation = mock(PendingOperation.class);
    when(pendingOperation.isCanceled()).thenReturn(false);

    RetransmissionHandler<MqttMessage> retransmissionHandler = new RetransmissionHandler<>(pendingOperation);
    retransmissionHandler.setHandle(mock(BiConsumer.class));
    DefaultEventLoop eventLoop = new DefaultEventLoop();

    // Act
    retransmissionHandler.start(eventLoop);

    // Assert
    verify(pendingOperation).isCanceled();
    assertFalse(eventLoop.isTerminated());
  }

  /**
   * Test {@link RetransmissionHandler#stop()}.
   * <ul>
   *   <li>Given
   * {@link RetransmissionHandler#RetransmissionHandler(PendingOperation)} with
   * {@link PendingOperation} start
   * {@link DefaultEventLoop#DefaultEventLoop()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RetransmissionHandler#stop()}
   */
  @Test
  @DisplayName("Test stop(); given RetransmissionHandler(PendingOperation) with PendingOperation start DefaultEventLoop()")
  void testStop_givenRetransmissionHandlerWithPendingOperationStartDefaultEventLoop() {
    // Arrange
    PendingOperation pendingOperation = mock(PendingOperation.class);
    when(pendingOperation.isCanceled()).thenReturn(false);

    RetransmissionHandler<MqttMessage> retransmissionHandler = new RetransmissionHandler<>(pendingOperation);
    retransmissionHandler.setHandle(mock(BiConsumer.class));
    retransmissionHandler.start(new DefaultEventLoop());

    // Act
    retransmissionHandler.stop();

    // Assert
    verify(pendingOperation).isCanceled();
  }

  /**
   * Test {@link RetransmissionHandler#stop()}.
   * <ul>
   *   <li>Given {@link ScheduledFuture} {@link Future#cancel(boolean)} return
   * {@code true}.</li>
   *   <li>Then calls
   * {@link AbstractScheduledEventExecutor#schedule(Runnable, long, TimeUnit)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RetransmissionHandler#stop()}
   */
  @Test
  @DisplayName("Test stop(); given ScheduledFuture cancel(boolean) return 'true'; then calls schedule(Runnable, long, TimeUnit)")
  void testStop_givenScheduledFutureCancelReturnTrue_thenCallsSchedule() {
    // Arrange
    PendingOperation pendingOperation = mock(PendingOperation.class);
    when(pendingOperation.isCanceled()).thenReturn(false);
    ScheduledFuture<Object> scheduledFuture = mock(ScheduledFuture.class);
    when(scheduledFuture.cancel(anyBoolean())).thenReturn(true);
    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    Mockito.<ScheduledFuture<?>>when(eventLoop.schedule(Mockito.<Runnable>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(scheduledFuture);

    RetransmissionHandler<MqttMessage> retransmissionHandler = new RetransmissionHandler<>(pendingOperation);
    retransmissionHandler.setHandle(mock(BiConsumer.class));
    retransmissionHandler.start(eventLoop);

    // Act
    retransmissionHandler.stop();

    // Assert
    verify(eventLoop).schedule(isA(Runnable.class), eq(10L), eq(TimeUnit.SECONDS));
    verify(scheduledFuture).cancel(eq(true));
    verify(pendingOperation).isCanceled();
  }
}
