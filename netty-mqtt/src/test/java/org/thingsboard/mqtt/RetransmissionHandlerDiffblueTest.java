package org.thingsboard.mqtt;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoop;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RetransmissionHandlerDiffblueTest {
  /**
   * Test {@link RetransmissionHandler#start(EventLoop)}.
   *
   * <ul>
   *   <li>Given {@link PendingOperation} {@link PendingOperation#isCanceled()} return {@code true}.
   *   <li>Then calls {@link PendingOperation#isCanceled()}.
   * </ul>
   *
   * <p>Method under test: {@link RetransmissionHandler#start(EventLoop)}
   */
  @Test
  @DisplayName(
      "Test start(EventLoop); given PendingOperation isCanceled() return 'true'; then calls isCanceled()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RetransmissionHandler.start(EventLoop)"})
  void testStart_givenPendingOperationIsCanceledReturnTrue_thenCallsIsCanceled() {
    // Arrange
    PendingOperation pendingOperation = mock(PendingOperation.class);
    when(pendingOperation.isCanceled()).thenReturn(true);

    RetransmissionHandler<MqttMessage> retransmissionHandler =
        new RetransmissionHandler<>(pendingOperation);
    retransmissionHandler.setHandle(mock(BiConsumer.class));

    // Act
    retransmissionHandler.start(new DefaultEventLoop(mock(ThreadFactory.class)));

    // Assert
    verify(pendingOperation).isCanceled();
  }

  /**
   * Test {@link RetransmissionHandler#start(EventLoop)}.
   *
   * <ul>
   *   <li>Given {@link ScheduledFuture}.
   *   <li>Then calls {@link EventLoop#schedule(Runnable, long, TimeUnit)}.
   * </ul>
   *
   * <p>Method under test: {@link RetransmissionHandler#start(EventLoop)}
   */
  @Test
  @DisplayName(
      "Test start(EventLoop); given ScheduledFuture; then calls schedule(Runnable, long, TimeUnit)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RetransmissionHandler.start(EventLoop)"})
  void testStart_givenScheduledFuture_thenCallsSchedule() {
    // Arrange
    PendingOperation pendingOperation = mock(PendingOperation.class);
    when(pendingOperation.isCanceled()).thenReturn(false);

    RetransmissionHandler<MqttMessage> retransmissionHandler =
        new RetransmissionHandler<>(pendingOperation);
    retransmissionHandler.setHandle(mock(BiConsumer.class));

    EventLoop eventLoop = mock(EventLoop.class);
    Mockito.<ScheduledFuture<?>>when(
            eventLoop.schedule(Mockito.<Runnable>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(mock(ScheduledFuture.class));

    // Act
    retransmissionHandler.start(eventLoop);

    // Assert
    verify(eventLoop).schedule(isA(Runnable.class), eq(10L), eq(TimeUnit.SECONDS));
    verify(pendingOperation).isCanceled();
  }

  /**
   * Test {@link RetransmissionHandler#start(EventLoop)}.
   *
   * <ul>
   *   <li>Given {@link Thread#Thread()}.
   *   <li>When {@link ThreadFactory} {@link ThreadFactory#newThread(Runnable)} return {@link
   *       Thread#Thread()}.
   *   <li>Then calls {@link ThreadFactory#newThread(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link RetransmissionHandler#start(EventLoop)}
   */
  @Test
  @DisplayName(
      "Test start(EventLoop); given Thread(); when ThreadFactory newThread(Runnable) return Thread(); then calls newThread(Runnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RetransmissionHandler.start(EventLoop)"})
  void testStart_givenThread_whenThreadFactoryNewThreadReturnThread_thenCallsNewThread() {
    // Arrange
    PendingOperation pendingOperation = mock(PendingOperation.class);
    when(pendingOperation.isCanceled()).thenReturn(false);

    RetransmissionHandler<MqttMessage> retransmissionHandler =
        new RetransmissionHandler<>(pendingOperation);
    retransmissionHandler.setHandle(mock(BiConsumer.class));

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());

    // Act
    retransmissionHandler.start(new DefaultEventLoop(threadFactory));

    // Assert
    verify(threadFactory).newThread(isA(Runnable.class));
    verify(pendingOperation).isCanceled();
  }

  /**
   * Test {@link RetransmissionHandler#stop()}.
   *
   * <ul>
   *   <li>Given {@link RetransmissionHandler#RetransmissionHandler(PendingOperation)} with {@link
   *       PendingOperation} start {@link DefaultEventLoop#DefaultEventLoop()}.
   * </ul>
   *
   * <p>Method under test: {@link RetransmissionHandler#stop()}
   */
  @Test
  @DisplayName(
      "Test stop(); given RetransmissionHandler(PendingOperation) with PendingOperation start DefaultEventLoop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RetransmissionHandler.stop()"})
  void testStop_givenRetransmissionHandlerWithPendingOperationStartDefaultEventLoop() {
    // Arrange
    PendingOperation pendingOperation = mock(PendingOperation.class);
    when(pendingOperation.isCanceled()).thenReturn(false);

    RetransmissionHandler<MqttMessage> retransmissionHandler =
        new RetransmissionHandler<>(pendingOperation);
    retransmissionHandler.setHandle(mock(BiConsumer.class));
    retransmissionHandler.start(new DefaultEventLoop());

    // Act
    retransmissionHandler.stop();

    // Assert
    verify(pendingOperation).isCanceled();
  }

  /**
   * Test {@link RetransmissionHandler#stop()}.
   *
   * <ul>
   *   <li>Given {@link ScheduledFuture} {@link ScheduledFuture#cancel(boolean)} return {@code
   *       true}.
   *   <li>Then calls {@link DefaultEventLoop#schedule(Runnable, long, TimeUnit)}.
   * </ul>
   *
   * <p>Method under test: {@link RetransmissionHandler#stop()}
   */
  @Test
  @DisplayName(
      "Test stop(); given ScheduledFuture cancel(boolean) return 'true'; then calls schedule(Runnable, long, TimeUnit)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RetransmissionHandler.stop()"})
  void testStop_givenScheduledFutureCancelReturnTrue_thenCallsSchedule() {
    // Arrange
    PendingOperation pendingOperation = mock(PendingOperation.class);
    when(pendingOperation.isCanceled()).thenReturn(false);

    ScheduledFuture<Object> scheduledFuture = mock(ScheduledFuture.class);
    when(scheduledFuture.cancel(anyBoolean())).thenReturn(true);

    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    Mockito.<ScheduledFuture<?>>when(
            eventLoop.schedule(Mockito.<Runnable>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(scheduledFuture);

    RetransmissionHandler<MqttMessage> retransmissionHandler =
        new RetransmissionHandler<>(pendingOperation);
    retransmissionHandler.setHandle(mock(BiConsumer.class));
    retransmissionHandler.start(eventLoop);

    // Act
    retransmissionHandler.stop();

    // Assert
    verify(eventLoop).schedule(isA(Runnable.class), eq(10L), eq(TimeUnit.SECONDS));
    verify(scheduledFuture).cancel(true);
    verify(pendingOperation).isCanceled();
  }
}
