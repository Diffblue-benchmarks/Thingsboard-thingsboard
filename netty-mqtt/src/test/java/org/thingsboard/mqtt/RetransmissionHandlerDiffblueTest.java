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
package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoop;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttQoS;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RetransmissionHandlerDiffblueTest {
  /**
   * Test {@link RetransmissionHandler#start(EventLoop)}.
   * <ul>
   *   <li>Given {@link PendingOperation} {@link PendingOperation#isCanceled()} return {@code true}.</li>
   *   <li>Then calls {@link PendingOperation#isCanceled()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RetransmissionHandler#start(EventLoop)}
   */
  @Test
  @DisplayName("Test start(EventLoop); given PendingOperation isCanceled() return 'true'; then calls isCanceled()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RetransmissionHandler.start(EventLoop)"})
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
   *   <li>Then not {@link DefaultEventLoop#DefaultEventLoop()} Terminated.</li>
   * </ul>
   * <p>
   * Method under test: {@link RetransmissionHandler#start(EventLoop)}
   */
  @Test
  @DisplayName("Test start(EventLoop); then not DefaultEventLoop() Terminated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RetransmissionHandler.start(EventLoop)"})
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
   * <p>
   * Method under test: {@link RetransmissionHandler#stop()}
   */
  @Test
  @DisplayName("Test stop()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RetransmissionHandler.stop()"})
  void testStop() {
    // Arrange
    PendingOperation pendingOperation = mock(PendingOperation.class);
    when(pendingOperation.isCanceled()).thenReturn(false);

    RetransmissionHandler<MqttMessage> retransmissionHandler = new RetransmissionHandler<>(pendingOperation);
    retransmissionHandler.setOriginalMessage(
        new MqttMessage(new MqttFixedHeader(MqttMessageType.CONNACK, true, MqttQoS.AT_MOST_ONCE, true, 3)));
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
   *   <li>Given {@link PendingOperation} {@link PendingOperation#isCanceled()} return {@code false}.</li>
   *   <li>Then calls {@link PendingOperation#isCanceled()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RetransmissionHandler#stop()}
   */
  @Test
  @DisplayName("Test stop(); given PendingOperation isCanceled() return 'false'; then calls isCanceled()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RetransmissionHandler.stop()"})
  void testStop_givenPendingOperationIsCanceledReturnFalse_thenCallsIsCanceled() {
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
}
