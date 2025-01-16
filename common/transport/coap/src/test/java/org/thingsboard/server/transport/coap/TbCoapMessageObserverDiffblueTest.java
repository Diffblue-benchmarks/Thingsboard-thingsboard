package org.thingsboard.server.transport.coap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.function.Consumer;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TbCoapMessageObserverDiffblueTest {
  /**
   * Test {@link TbCoapMessageObserver#onAcknowledgement()}.
   * <p>
   * Method under test: {@link TbCoapMessageObserver#onAcknowledgement()}
   */
  @Test
  @DisplayName("Test onAcknowledgement()")
  void testOnAcknowledgement() {
    // Arrange
    Consumer<Integer> onAcknowledge = mock(Consumer.class);
    doNothing().when(onAcknowledge).accept(Mockito.<Integer>any());

    // Act
    (new TbCoapMessageObserver(1, onAcknowledge, mock(Consumer.class))).onAcknowledgement();

    // Assert that nothing has changed
    verify(onAcknowledge).accept(eq(1));
  }

  /**
   * Test {@link TbCoapMessageObserver#onTimeout()}.
   * <p>
   * Method under test: {@link TbCoapMessageObserver#onTimeout()}
   */
  @Test
  @DisplayName("Test onTimeout()")
  void testOnTimeout() {
    // Arrange
    Consumer<Integer> onTimeout = mock(Consumer.class);
    doNothing().when(onTimeout).accept(Mockito.<Integer>any());

    // Act
    (new TbCoapMessageObserver(1, mock(Consumer.class), onTimeout)).onTimeout();

    // Assert that nothing has changed
    verify(onTimeout).accept(eq(1));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbCoapMessageObserver#TbCoapMessageObserver(int, Consumer, Consumer)}
   *   <li>{@link TbCoapMessageObserver#onCancel()}
   *   <li>{@link TbCoapMessageObserver#onConnecting()}
   *   <li>{@link TbCoapMessageObserver#onDtlsRetransmission(int)}
   *   <li>{@link TbCoapMessageObserver#onReadyToSend()}
   *   <li>{@link TbCoapMessageObserver#onReject()}
   *   <li>{@link TbCoapMessageObserver#onResponse(Response)}
   *   <li>{@link TbCoapMessageObserver#onResponseHandlingError(Throwable)}
   *   <li>{@link TbCoapMessageObserver#onRetransmission()}
   *   <li>{@link TbCoapMessageObserver#onSendError(Throwable)}
   *   <li>{@link TbCoapMessageObserver#onSent(boolean)}
   *   <li>{@link TbCoapMessageObserver#onTransferComplete()}
   *   <li>{@link TbCoapMessageObserver#isInternal()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbCoapMessageObserver actualTbCoapMessageObserver = new TbCoapMessageObserver(1, mock(Consumer.class),
        mock(Consumer.class));
    actualTbCoapMessageObserver.onCancel();
    actualTbCoapMessageObserver.onConnecting();
    actualTbCoapMessageObserver.onDtlsRetransmission(1);
    actualTbCoapMessageObserver.onReadyToSend();
    actualTbCoapMessageObserver.onReject();
    actualTbCoapMessageObserver.onResponse(new Response(CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE));
    actualTbCoapMessageObserver.onResponseHandlingError(new Throwable());
    actualTbCoapMessageObserver.onRetransmission();
    actualTbCoapMessageObserver.onSendError(new Throwable());
    actualTbCoapMessageObserver.onSent(true);
    actualTbCoapMessageObserver.onTransferComplete();

    // Assert that nothing has changed
    assertFalse(actualTbCoapMessageObserver.isInternal());
  }
}
