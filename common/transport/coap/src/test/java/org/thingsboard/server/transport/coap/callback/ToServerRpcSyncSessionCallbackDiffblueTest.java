package org.thingsboard.server.transport.coap.callback;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Endpoint;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.transport.coap.adaptors.JsonCoapAdaptor;
import org.thingsboard.server.transport.coap.client.TbCoapClientState;

class ToServerRpcSyncSessionCallbackDiffblueTest {
  /**
   * Test
   * {@link ToServerRpcSyncSessionCallback#onToServerRpcResponse(ToServerRpcResponseMsg)}.
   * <ul>
   *   <li>Then calls {@link Endpoint#sendResponse(Exchange, Response)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ToServerRpcSyncSessionCallback#onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName("Test onToServerRpcResponse(ToServerRpcResponseMsg); then calls sendResponse(Exchange, Response)")
  void testOnToServerRpcResponse_thenCallsSendResponse() {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    state.setAdaptor(new JsonCoapAdaptor());
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);
    CoapExchange exchange2 = new CoapExchange(exchange);
    ToServerRpcSyncSessionCallback toServerRpcSyncSessionCallback = new ToServerRpcSyncSessionCallback(state, exchange2,
        Request.newDelete());

    // Act
    toServerRpcSyncSessionCallback.onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }
}
