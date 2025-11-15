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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Endpoint;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.transport.coap.client.TbCoapClientState;
import org.thingsboard.server.transport.coap.client.TbCoapObservationState;

class AbstractSyncSessionCallbackDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractSyncSessionCallback#isConRequest(TbCoapObservationState)}
   */
  @Test
  void testIsConRequest() {
    // Arrange, Act and Assert
    assertTrue(AbstractSyncSessionCallback.isConRequest(new TbCoapObservationState(
        new CoapExchange(
            new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))),
        "ABC123")));
    assertFalse(AbstractSyncSessionCallback.isConRequest(null));
  }

  /**
   * Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  void testRespond() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);
    CoapExchange exchange2 = new CoapExchange(exchange);
    TbCoapClientState state = new TbCoapClientState(null);
    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback = new GetAttributesSyncSessionCallback(state,
        exchange2, Request.newDelete());
    Response response = new Response(CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    getAttributesSyncSessionCallback.respond(response);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
    OptionSet options = response.getOptions();
    assertEquals("", options.getLocationPathString());
    assertEquals("", options.getLocationQueryString());
    assertEquals("/", options.getLocationString());
    assertEquals(0, options.getContentFormat());
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(60L, options.getMaxAge().longValue());
    assertEquals(CoAP.Type.CON, response.getType());
    assertFalse(options.hasMaxAge());
    assertTrue(options.getETags().isEmpty());
    assertTrue(options.getLocationPath().isEmpty());
    assertTrue(options.getLocationQuery().isEmpty());
    assertTrue(response.isConfirmable());
    assertTrue(options.hasContentFormat());
  }

  /**
   * Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  void testRespond2() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Path");
    TbCoapClientState state = new TbCoapClientState(null);
    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback = new GetAttributesSyncSessionCallback(state,
        exchange2, Request.newDelete());
    Response response = new Response(CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    getAttributesSyncSessionCallback.respond(response);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
    OptionSet options = response.getOptions();
    assertEquals("", options.getLocationQueryString());
    assertEquals("/Path", options.getLocationString());
    List<String> locationPath = options.getLocationPath();
    assertEquals(1, locationPath.size());
    assertEquals("Path", locationPath.get(0));
    assertEquals("Path", options.getLocationPathString());
    assertEquals(0, options.getContentFormat());
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(1, options.getLocationPathCount());
    assertEquals(60L, options.getMaxAge().longValue());
    assertEquals(CoAP.Type.CON, response.getType());
    assertFalse(options.hasMaxAge());
    assertTrue(options.getETags().isEmpty());
    assertTrue(options.getLocationQuery().isEmpty());
    assertTrue(response.isConfirmable());
    assertTrue(options.hasContentFormat());
  }

  /**
   * Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  void testRespond3() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("Query");
    TbCoapClientState state = new TbCoapClientState(null);
    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback = new GetAttributesSyncSessionCallback(state,
        exchange2, Request.newDelete());
    Response response = new Response(CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    getAttributesSyncSessionCallback.respond(response);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
    OptionSet options = response.getOptions();
    assertEquals("", options.getLocationPathString());
    assertEquals("/?Query", options.getLocationString());
    List<String> locationQuery = options.getLocationQuery();
    assertEquals(1, locationQuery.size());
    assertEquals("Query", locationQuery.get(0));
    assertEquals("Query", options.getLocationQueryString());
    assertEquals(0, options.getContentFormat());
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(1, options.getLocationQueryCount());
    assertEquals(60L, options.getMaxAge().longValue());
    assertEquals(CoAP.Type.CON, response.getType());
    assertFalse(options.hasMaxAge());
    assertTrue(options.getETags().isEmpty());
    assertTrue(options.getLocationPath().isEmpty());
    assertTrue(response.isConfirmable());
    assertTrue(options.hasContentFormat());
  }

  /**
   * Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  void testRespond4() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(42L);
    TbCoapClientState state = new TbCoapClientState(null);
    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback = new GetAttributesSyncSessionCallback(state,
        exchange2, Request.newDelete());
    Response response = new Response(CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    getAttributesSyncSessionCallback.respond(response);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
    OptionSet options = response.getOptions();
    assertEquals("", options.getLocationPathString());
    assertEquals("", options.getLocationQueryString());
    assertEquals("/", options.getLocationString());
    assertEquals(0, options.getContentFormat());
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(42L, options.getMaxAge().longValue());
    assertEquals(CoAP.Type.CON, response.getType());
    assertTrue(options.getETags().isEmpty());
    assertTrue(options.getLocationPath().isEmpty());
    assertTrue(options.getLocationQuery().isEmpty());
    assertTrue(response.isConfirmable());
    assertTrue(options.hasContentFormat());
    assertTrue(options.hasMaxAge());
  }

  /**
   * Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  void testRespond5() throws UnsupportedEncodingException {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag("AXAXAXAX".getBytes("UTF-8"));
    TbCoapClientState state = new TbCoapClientState(null);
    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback = new GetAttributesSyncSessionCallback(state,
        exchange2, Request.newDelete());
    Response response = new Response(CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    getAttributesSyncSessionCallback.respond(response);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
    OptionSet options = response.getOptions();
    assertEquals("", options.getLocationPathString());
    assertEquals("", options.getLocationQueryString());
    assertEquals("/", options.getLocationString());
    assertEquals(0, options.getContentFormat());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    List<byte[]> eTags = options.getETags();
    assertEquals(1, eTags.size());
    assertEquals(1, options.getETagCount());
    assertEquals(60L, options.getMaxAge().longValue());
    assertEquals(CoAP.Type.CON, response.getType());
    assertFalse(options.hasMaxAge());
    assertTrue(options.getLocationPath().isEmpty());
    assertTrue(options.getLocationQuery().isEmpty());
    assertTrue(response.isConfirmable());
    assertTrue(options.hasContentFormat());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), eTags.get(0));
  }

  /**
   * Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  void testRespond6() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);
    CoapExchange exchange2 = new CoapExchange(exchange);
    TbCoapClientState state = new TbCoapClientState(null);
    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback = new GetAttributesSyncSessionCallback(state,
        exchange2, Request.newDelete());

    Response response = new Response(CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);
    response.setOptions(new OptionSet());

    // Act
    getAttributesSyncSessionCallback.respond(response);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
    OptionSet options = response.getOptions();
    assertEquals("", options.getLocationPathString());
    assertEquals("", options.getLocationQueryString());
    assertEquals("/", options.getLocationString());
    assertEquals(0, options.getContentFormat());
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(60L, options.getMaxAge().longValue());
    assertEquals(CoAP.Type.CON, response.getType());
    assertFalse(options.hasMaxAge());
    assertTrue(options.getETags().isEmpty());
    assertTrue(options.getLocationPath().isEmpty());
    assertTrue(options.getLocationQuery().isEmpty());
    assertTrue(response.isConfirmable());
    assertTrue(options.hasContentFormat());
  }

  /**
   * Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  void testRespond7() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("");
    TbCoapClientState state = new TbCoapClientState(null);
    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback = new GetAttributesSyncSessionCallback(state,
        exchange2, Request.newDelete());
    Response response = new Response(CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    getAttributesSyncSessionCallback.respond(response);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
    OptionSet options = response.getOptions();
    assertEquals("", options.getLocationPathString());
    assertEquals("", options.getLocationQueryString());
    assertEquals("/", options.getLocationString());
    assertEquals(0, options.getContentFormat());
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(60L, options.getMaxAge().longValue());
    assertEquals(CoAP.Type.CON, response.getType());
    assertFalse(options.hasMaxAge());
    assertTrue(options.getETags().isEmpty());
    assertTrue(options.getLocationPath().isEmpty());
    assertTrue(options.getLocationQuery().isEmpty());
    assertTrue(response.isConfirmable());
    assertTrue(options.hasContentFormat());
  }
}
