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
package org.thingsboard.server.transport.coap.callback;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Endpoint;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.transport.coap.adaptors.JsonCoapAdaptor;
import org.thingsboard.server.transport.coap.client.TbCoapClientState;

class GetAttributesSyncSessionCallbackDiffblueTest {
  /**
   * Method under test:
   * {@link GetAttributesSyncSessionCallback#onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testOnGetAttributesResponse() {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    state.setAdaptor(new JsonCoapAdaptor());
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);
    CoapExchange exchange2 = new CoapExchange(exchange);
    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback = new GetAttributesSyncSessionCallback(state,
        exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback
        .onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Method under test:
   * {@link GetAttributesSyncSessionCallback#onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testOnGetAttributesResponse2() {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    state.setAdaptor(new JsonCoapAdaptor());
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Path");
    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback = new GetAttributesSyncSessionCallback(state,
        exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback
        .onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Method under test:
   * {@link GetAttributesSyncSessionCallback#onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testOnGetAttributesResponse3() {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    state.setAdaptor(new JsonCoapAdaptor());
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("Query");
    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback = new GetAttributesSyncSessionCallback(state,
        exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback
        .onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Method under test:
   * {@link GetAttributesSyncSessionCallback#onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testOnGetAttributesResponse4() {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    state.setAdaptor(new JsonCoapAdaptor());
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(3L);
    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback = new GetAttributesSyncSessionCallback(state,
        exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback
        .onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Method under test:
   * {@link GetAttributesSyncSessionCallback#onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  void testOnGetAttributesResponse5() throws UnsupportedEncodingException {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    state.setAdaptor(new JsonCoapAdaptor());
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag("AXAXAXAX".getBytes("UTF-8"));
    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback = new GetAttributesSyncSessionCallback(state,
        exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback
        .onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }
}
