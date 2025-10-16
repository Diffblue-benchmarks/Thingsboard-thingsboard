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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.adaptor.AdaptorException;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.GetAttributeResponseMsg;
import org.thingsboard.server.transport.coap.adaptors.JsonCoapAdaptor;
import org.thingsboard.server.transport.coap.client.TbCoapClientState;

class GetAttributesSyncSessionCallbackDiffblueTest {
  /**
   * Test {@link GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}.
   *
   * <p>Method under test: {@link
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test onGetAttributesResponse(GetAttributeResponseMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse() throws AdaptorException {
    // Arrange
    JsonCoapAdaptor jsonCoapAdaptor = mock(JsonCoapAdaptor.class);
    when(jsonCoapAdaptor.convertToPublish(Mockito.<GetAttributeResponseMsg>any()))
        .thenReturn(new Response(ResponseCode._UNKNOWN_SUCCESS_CODE));

    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(jsonCoapAdaptor);

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());
    CoapExchange exchange2 = new CoapExchange(exchange);

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(jsonCoapAdaptor).convertToPublish(isA(GetAttributeResponseMsg.class));
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }

  /**
   * Test {@link GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When DefaultInstance.
   *   <li>Then calls {@link Exchange#getRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg); given 'A'; when DefaultInstance; then calls getRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_givenA_whenDefaultInstance_thenCallsGetRequest() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }

  /**
   * Test {@link GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}.
   *
   * <ul>
   *   <li>Given {@link CoapExchange} {@link CoapExchange#respond(Response)} does nothing.
   *   <li>Then calls {@link CoapExchange#respond(Response)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg); given CoapExchange respond(Response) does nothing; then calls respond(Response)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_givenCoapExchangeRespondDoesNothing_thenCallsRespond()
      throws AdaptorException {
    // Arrange
    JsonCoapAdaptor jsonCoapAdaptor = mock(JsonCoapAdaptor.class);
    when(jsonCoapAdaptor.convertToPublish(Mockito.<GetAttributeResponseMsg>any()))
        .thenThrow(new AdaptorException("Cause"));

    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getDeviceId()).thenReturn(null);
    when(state.getAdaptor()).thenReturn(jsonCoapAdaptor);

    CoapExchange exchange = mock(CoapExchange.class);
    doNothing().when(exchange).respond(Mockito.<Response>any());

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).respond(isA(Response.class));
    verify(jsonCoapAdaptor).convertToPublish(isA(GetAttributeResponseMsg.class));
    verify(state).getAdaptor();
    verify(state).getDeviceId();
  }

  /**
   * Test {@link GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}.
   *
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with {@link Exchange} LocationPath is
   *       {@code Path}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg); given CoapExchange(Exchange) with Exchange LocationPath is 'Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_givenCoapExchangeWithExchangeLocationPathIsPath() {
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

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }

  /**
   * Test {@link GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}.
   *
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with {@link Exchange} LocationQuery is
   *       {@code Query}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg); given CoapExchange(Exchange) with Exchange LocationQuery is 'Query'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_givenCoapExchangeWithExchangeLocationQueryIsQuery() {
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

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }

  /**
   * Test {@link GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}.
   *
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with {@link Exchange} MaxAge is three.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg); given CoapExchange(Exchange) with Exchange MaxAge is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_givenCoapExchangeWithExchangeMaxAgeIsThree() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(3L);

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }

  /**
   * Test {@link GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}.
   *
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with {@link Exchange}.
   *   <li>Then calls {@link Exchange#getRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg); given CoapExchange(Exchange) with Exchange; then calls getRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_givenCoapExchangeWithExchange_thenCallsGetRequest() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());
    CoapExchange exchange2 = new CoapExchange(exchange);

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }

  /**
   * Test {@link GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}.
   *
   * <ul>
   *   <li>Given newDelete ProxyUri is {@code Proxy Uri}.
   *   <li>Then calls {@link Exchange#getRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg); given newDelete ProxyUri is 'Proxy Uri'; then calls getRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_givenNewDeleteProxyUriIsProxyUri_thenCallsGetRequest() {
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

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }

  /**
   * Test {@link GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbCoapClientState} {@link TbCoapClientState#getContentFormat()} return minus
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg); given TbCoapClientState getContentFormat() return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_givenTbCoapClientStateGetContentFormatReturnMinusOne() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(-1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());
    CoapExchange exchange2 = new CoapExchange(exchange);

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }

  /**
   * Test {@link GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link TbCoapClientState#getDeviceId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test onGetAttributesResponse(GetAttributeResponseMsg); then calls getDeviceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(TransportProtos.GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_thenCallsGetDeviceId() throws AdaptorException {
    // Arrange
    JsonCoapAdaptor jsonCoapAdaptor = mock(JsonCoapAdaptor.class);
    when(jsonCoapAdaptor.convertToPublish(Mockito.<GetAttributeResponseMsg>any()))
        .thenThrow(new AdaptorException("Cause"));

    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getDeviceId()).thenReturn(null);
    when(state.getAdaptor()).thenReturn(jsonCoapAdaptor);

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    CoapExchange exchange2 = new CoapExchange(exchange);

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(jsonCoapAdaptor).convertToPublish(isA(GetAttributeResponseMsg.class));
    verify(state).getAdaptor();
    verify(state).getDeviceId();
  }
}
