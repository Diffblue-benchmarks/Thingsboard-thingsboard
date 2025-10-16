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
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.elements.AddressEndpointContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.ToServerRpcResponseMsg;
import org.thingsboard.server.transport.coap.adaptors.CoapTransportAdaptor;
import org.thingsboard.server.transport.coap.adaptors.JsonCoapAdaptor;
import org.thingsboard.server.transport.coap.client.TbCoapClientState;

class ToServerRpcSyncSessionCallbackDiffblueTest {
  /**
   * Test {@link ToServerRpcSyncSessionCallback#onToServerRpcResponse(ToServerRpcResponseMsg)}.
   *
   * <p>Method under test: {@link
   * ToServerRpcSyncSessionCallback#onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName("Test onToServerRpcResponse(ToServerRpcResponseMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToServerRpcSyncSessionCallback.onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testOnToServerRpcResponse() throws AdaptorException {
    // Arrange
    CoapTransportAdaptor coapTransportAdaptor = mock(CoapTransportAdaptor.class);
    when(coapTransportAdaptor.convertToPublish(Mockito.<ToServerRpcResponseMsg>any()))
        .thenReturn(new Response(ResponseCode._UNKNOWN_SUCCESS_CODE));

    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(coapTransportAdaptor);

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());
    CoapExchange exchange2 = new CoapExchange(exchange);

    ToServerRpcSyncSessionCallback toServerRpcSyncSessionCallback =
        new ToServerRpcSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    toServerRpcSyncSessionCallback.onToServerRpcResponse(
        ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(coapTransportAdaptor).convertToPublish(isA(ToServerRpcResponseMsg.class));
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }

  /**
   * Test {@link ToServerRpcSyncSessionCallback#onToServerRpcResponse(ToServerRpcResponseMsg)}.
   *
   * <p>Method under test: {@link
   * ToServerRpcSyncSessionCallback#onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName("Test onToServerRpcResponse(ToServerRpcResponseMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToServerRpcSyncSessionCallback.onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testOnToServerRpcResponse2() throws AdaptorException {
    // Arrange
    CoapTransportAdaptor coapTransportAdaptor = mock(CoapTransportAdaptor.class);
    when(coapTransportAdaptor.convertToPublish(Mockito.<ToServerRpcResponseMsg>any()))
        .thenThrow(new AdaptorException("Cause"));

    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getAdaptor()).thenReturn(coapTransportAdaptor);

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    CoapExchange exchange2 = new CoapExchange(exchange);

    ToServerRpcSyncSessionCallback toServerRpcSyncSessionCallback =
        new ToServerRpcSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    toServerRpcSyncSessionCallback.onToServerRpcResponse(
        ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(coapTransportAdaptor).convertToPublish(isA(ToServerRpcResponseMsg.class));
    verify(state).getAdaptor();
  }

  /**
   * Test {@link ToServerRpcSyncSessionCallback#onToServerRpcResponse(ToServerRpcResponseMsg)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When DefaultInstance.
   *   <li>Then calls {@link Exchange#getCurrentRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ToServerRpcSyncSessionCallback#onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onToServerRpcResponse(ToServerRpcResponseMsg); given 'A'; when DefaultInstance; then calls getCurrentRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToServerRpcSyncSessionCallback.onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testOnToServerRpcResponse_givenA_whenDefaultInstance_thenCallsGetCurrentRequest() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    ToServerRpcSyncSessionCallback toServerRpcSyncSessionCallback =
        new ToServerRpcSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    toServerRpcSyncSessionCallback.onToServerRpcResponse(
        ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }

  /**
   * Test {@link ToServerRpcSyncSessionCallback#onToServerRpcResponse(ToServerRpcResponseMsg)}.
   *
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with {@link Exchange}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ToServerRpcSyncSessionCallback#onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onToServerRpcResponse(ToServerRpcResponseMsg); given CoapExchange(Exchange) with Exchange")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToServerRpcSyncSessionCallback.onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testOnToServerRpcResponse_givenCoapExchangeWithExchange() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());
    CoapExchange exchange2 = new CoapExchange(exchange);

    ToServerRpcSyncSessionCallback toServerRpcSyncSessionCallback =
        new ToServerRpcSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    toServerRpcSyncSessionCallback.onToServerRpcResponse(
        ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }

  /**
   * Test {@link ToServerRpcSyncSessionCallback#onToServerRpcResponse(ToServerRpcResponseMsg)}.
   *
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with {@link Exchange} LocationPath is
   *       {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ToServerRpcSyncSessionCallback#onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onToServerRpcResponse(ToServerRpcResponseMsg); given CoapExchange(Exchange) with Exchange LocationPath is 'Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToServerRpcSyncSessionCallback.onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testOnToServerRpcResponse_givenCoapExchangeWithExchangeLocationPathIsPath() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Path");

    ToServerRpcSyncSessionCallback toServerRpcSyncSessionCallback =
        new ToServerRpcSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    toServerRpcSyncSessionCallback.onToServerRpcResponse(
        ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }

  /**
   * Test {@link ToServerRpcSyncSessionCallback#onToServerRpcResponse(ToServerRpcResponseMsg)}.
   *
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with {@link Exchange} LocationQuery is
   *       {@code Query}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ToServerRpcSyncSessionCallback#onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onToServerRpcResponse(ToServerRpcResponseMsg); given CoapExchange(Exchange) with Exchange LocationQuery is 'Query'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToServerRpcSyncSessionCallback.onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testOnToServerRpcResponse_givenCoapExchangeWithExchangeLocationQueryIsQuery() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("Query");

    ToServerRpcSyncSessionCallback toServerRpcSyncSessionCallback =
        new ToServerRpcSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    toServerRpcSyncSessionCallback.onToServerRpcResponse(
        ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }

  /**
   * Test {@link ToServerRpcSyncSessionCallback#onToServerRpcResponse(ToServerRpcResponseMsg)}.
   *
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with {@link Exchange} MaxAge is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ToServerRpcSyncSessionCallback#onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onToServerRpcResponse(ToServerRpcResponseMsg); given CoapExchange(Exchange) with Exchange MaxAge is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToServerRpcSyncSessionCallback.onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testOnToServerRpcResponse_givenCoapExchangeWithExchangeMaxAgeIsOne() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(1L);

    ToServerRpcSyncSessionCallback toServerRpcSyncSessionCallback =
        new ToServerRpcSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    toServerRpcSyncSessionCallback.onToServerRpcResponse(
        ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }

  /**
   * Test {@link ToServerRpcSyncSessionCallback#onToServerRpcResponse(ToServerRpcResponseMsg)}.
   *
   * <ul>
   *   <li>Given newDelete ProxyUri is {@code Proxy Uri}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ToServerRpcSyncSessionCallback#onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onToServerRpcResponse(ToServerRpcResponseMsg); given newDelete ProxyUri is 'Proxy Uri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToServerRpcSyncSessionCallback.onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testOnToServerRpcResponse_givenNewDeleteProxyUriIsProxyUri() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    Request newDeleteResult = Request.newDelete();
    newDeleteResult.setProxyUri("Proxy Uri");

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(newDeleteResult);
    CoapExchange exchange2 = new CoapExchange(exchange);

    ToServerRpcSyncSessionCallback toServerRpcSyncSessionCallback =
        new ToServerRpcSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    toServerRpcSyncSessionCallback.onToServerRpcResponse(
        ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }

  /**
   * Test {@link ToServerRpcSyncSessionCallback#onToServerRpcResponse(ToServerRpcResponseMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbCoapClientState} {@link TbCoapClientState#getContentFormat()} return minus
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ToServerRpcSyncSessionCallback#onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onToServerRpcResponse(ToServerRpcResponseMsg); given TbCoapClientState getContentFormat() return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToServerRpcSyncSessionCallback.onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testOnToServerRpcResponse_givenTbCoapClientStateGetContentFormatReturnMinusOne() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(-1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());
    CoapExchange exchange2 = new CoapExchange(exchange);

    ToServerRpcSyncSessionCallback toServerRpcSyncSessionCallback =
        new ToServerRpcSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    toServerRpcSyncSessionCallback.onToServerRpcResponse(
        ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }

  /**
   * Test {@link ToServerRpcSyncSessionCallback#onToServerRpcResponse(ToServerRpcResponseMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link Response#getDestinationContext()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ToServerRpcSyncSessionCallback#onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onToServerRpcResponse(ToServerRpcResponseMsg); then calls getDestinationContext()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ToServerRpcSyncSessionCallback.onToServerRpcResponse(TransportProtos.ToServerRpcResponseMsg)"
  })
  void testOnToServerRpcResponse_thenCallsGetDestinationContext() throws AdaptorException {
    // Arrange
    Response response = mock(Response.class);
    when(response.setConfirmable(anyBoolean())).thenReturn(new EmptyMessage(Type.CON));
    when(response.getDestinationContext()).thenReturn(new AddressEndpointContext("42", 8080));
    when(response.getOptions()).thenReturn(new OptionSet());

    CoapTransportAdaptor coapTransportAdaptor = mock(CoapTransportAdaptor.class);
    when(coapTransportAdaptor.convertToPublish(Mockito.<ToServerRpcResponseMsg>any()))
        .thenReturn(response);

    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(coapTransportAdaptor);

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getRequest()).thenReturn(Request.newDelete());
    CoapExchange exchange2 = new CoapExchange(exchange);

    ToServerRpcSyncSessionCallback toServerRpcSyncSessionCallback =
        new ToServerRpcSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    toServerRpcSyncSessionCallback.onToServerRpcResponse(
        ToServerRpcResponseMsg.getDefaultInstance());

    // Assert
    verify(response).getDestinationContext();
    verify(response).getOptions();
    verify(response).setConfirmable(true);
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(coapTransportAdaptor).convertToPublish(isA(ToServerRpcResponseMsg.class));
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }
}
