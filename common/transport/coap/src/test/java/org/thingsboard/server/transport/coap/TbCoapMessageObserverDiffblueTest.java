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
package org.thingsboard.server.transport.coap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Consumer;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TbCoapMessageObserverDiffblueTest {
  /**
   * Test {@link TbCoapMessageObserver#onAcknowledgement()}.
   *
   * <p>Method under test: {@link TbCoapMessageObserver#onAcknowledgement()}
   */
  @Test
  @DisplayName("Test onAcknowledgement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCoapMessageObserver.onAcknowledgement()"})
  void testOnAcknowledgement() {
    // Arrange
    Consumer<Integer> onAcknowledge = mock(Consumer.class);
    doNothing().when(onAcknowledge).accept(Mockito.<Integer>any());
    TbCoapMessageObserver tbCoapMessageObserver =
        new TbCoapMessageObserver(1, onAcknowledge, mock(Consumer.class));

    // Act
    tbCoapMessageObserver.onAcknowledgement();

    // Assert
    verify(onAcknowledge).accept(1);
  }

  /**
   * Test {@link TbCoapMessageObserver#onTimeout()}.
   *
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link TbCoapMessageObserver#onTimeout()}
   */
  @Test
  @DisplayName(
      "Test onTimeout(); given Consumer accept(Object) does nothing; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCoapMessageObserver.onTimeout()"})
  void testOnTimeout_givenConsumerAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    Consumer<Integer> onTimeout = mock(Consumer.class);
    doNothing().when(onTimeout).accept(Mockito.<Integer>any());
    TbCoapMessageObserver tbCoapMessageObserver =
        new TbCoapMessageObserver(1, mock(Consumer.class), onTimeout);

    // Act
    tbCoapMessageObserver.onTimeout();

    // Assert
    verify(onTimeout).accept(1);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbCoapMessageObserver#TbCoapMessageObserver(int, Consumer, Consumer)}
   *   <li>{@link TbCoapMessageObserver#onCancel()}
   *   <li>{@link TbCoapMessageObserver#onConnecting()}
   *   <li>{@link TbCoapMessageObserver#onDtlsRetransmission(int)}
   *   <li>{@link TbCoapMessageObserver#onReadyToSend()}
   *   <li>{@link TbCoapMessageObserver#onReject()}
   *   <li>{@link TbCoapMessageObserver#onResponse(Response)}
   *   <li>{@link TbCoapMessageObserver#onRetransmission()}
   *   <li>{@link TbCoapMessageObserver#onSent(boolean)}
   *   <li>{@link TbCoapMessageObserver#onTransferComplete()}
   *   <li>{@link TbCoapMessageObserver#isInternal()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbCoapMessageObserver.<init>(int, Consumer, Consumer)",
    "boolean TbCoapMessageObserver.isInternal()",
    "void TbCoapMessageObserver.onCancel()",
    "void TbCoapMessageObserver.onConnecting()",
    "void TbCoapMessageObserver.onContextEstablished(org.eclipse.californium.elements.EndpointContext)",
    "void TbCoapMessageObserver.onDtlsRetransmission(int)",
    "void TbCoapMessageObserver.onReadyToSend()",
    "void TbCoapMessageObserver.onReject()",
    "void TbCoapMessageObserver.onResponse(Response)",
    "void TbCoapMessageObserver.onResponseHandlingError(java.lang.Throwable)",
    "void TbCoapMessageObserver.onRetransmission()",
    "void TbCoapMessageObserver.onSendError(java.lang.Throwable)",
    "void TbCoapMessageObserver.onSent(boolean)",
    "void TbCoapMessageObserver.onTransferComplete()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbCoapMessageObserver actualTbCoapMessageObserver =
        new TbCoapMessageObserver(1, mock(Consumer.class), mock(Consumer.class));
    actualTbCoapMessageObserver.onCancel();
    actualTbCoapMessageObserver.onConnecting();
    actualTbCoapMessageObserver.onDtlsRetransmission(1);
    actualTbCoapMessageObserver.onReadyToSend();
    actualTbCoapMessageObserver.onReject();
    actualTbCoapMessageObserver.onResponse(new Response(ResponseCode._UNKNOWN_SUCCESS_CODE));
    actualTbCoapMessageObserver.onRetransmission();
    actualTbCoapMessageObserver.onSent(true);
    actualTbCoapMessageObserver.onTransferComplete();

    // Assert
    assertFalse(actualTbCoapMessageObserver.isInternal());
  }
}
