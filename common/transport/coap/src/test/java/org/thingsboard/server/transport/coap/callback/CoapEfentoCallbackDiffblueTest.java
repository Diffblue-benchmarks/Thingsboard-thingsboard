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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.UnsupportedEncodingException;
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

class CoapEfentoCallbackDiffblueTest {
  /**
   * Method under test: {@link CoapEfentoCallback#onSuccess(Void)}
   */
  @Test
  void testOnSuccess() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    // Act
    (new CoapEfentoCallback(new CoapExchange(exchange), CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE,
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE)).onSuccess(null);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Method under test: {@link CoapEfentoCallback#onSuccess(Void)}
   */
  @Test
  void testOnSuccess2() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Path");

    // Act
    (new CoapEfentoCallback(exchange2, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE,
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE)).onSuccess(null);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Method under test: {@link CoapEfentoCallback#onSuccess(Void)}
   */
  @Test
  void testOnSuccess3() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("Query");

    // Act
    (new CoapEfentoCallback(exchange2, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE,
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE)).onSuccess(null);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Method under test: {@link CoapEfentoCallback#onSuccess(Void)}
   */
  @Test
  void testOnSuccess4() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(6L);

    // Act
    (new CoapEfentoCallback(exchange2, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE,
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE)).onSuccess(null);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Method under test: {@link CoapEfentoCallback#onSuccess(Void)}
   */
  @Test
  void testOnSuccess5() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag(new byte[]{'A', 6, 'A', 6, 'A', 6, 'A', 6});

    // Act
    (new CoapEfentoCallback(exchange2, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE,
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE)).onSuccess(null);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Method under test: {@link CoapEfentoCallback#onSuccess(Void)}
   */
  @Test
  void testOnSuccess6() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("");

    // Act
    (new CoapEfentoCallback(exchange2, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE,
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE)).onSuccess(null);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Method under test: {@link CoapEfentoCallback#onError(Throwable)}
   */
  @Test
  void testOnError() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);
    CoapEfentoCallback coapEfentoCallback = new CoapEfentoCallback(new CoapExchange(exchange),
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    coapEfentoCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Method under test: {@link CoapEfentoCallback#onError(Throwable)}
   */
  @Test
  void testOnError2() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Path");
    CoapEfentoCallback coapEfentoCallback = new CoapEfentoCallback(exchange2, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE,
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    coapEfentoCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Method under test: {@link CoapEfentoCallback#onError(Throwable)}
   */
  @Test
  void testOnError3() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("Query");
    CoapEfentoCallback coapEfentoCallback = new CoapEfentoCallback(exchange2, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE,
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    coapEfentoCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Method under test: {@link CoapEfentoCallback#onError(Throwable)}
   */
  @Test
  void testOnError4() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(1L);
    CoapEfentoCallback coapEfentoCallback = new CoapEfentoCallback(exchange2, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE,
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    coapEfentoCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Method under test: {@link CoapEfentoCallback#onError(Throwable)}
   */
  @Test
  void testOnError5() throws UnsupportedEncodingException {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag("AXAXAXAX".getBytes("UTF-8"));
    CoapEfentoCallback coapEfentoCallback = new CoapEfentoCallback(exchange2, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE,
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    coapEfentoCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Method under test: {@link CoapEfentoCallback#onError(Throwable)}
   */
  @Test
  void testOnError6() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("");
    CoapEfentoCallback coapEfentoCallback = new CoapEfentoCallback(exchange2, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE,
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    coapEfentoCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Method under test: {@link CoapEfentoCallback#isConRequest()}
   */
  @Test
  void testIsConRequest() {
    // Arrange, Act and Assert
    assertTrue((new CoapEfentoCallback(
        new CoapExchange(
            new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))),
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE)).isConRequest());
  }

  /**
   * Method under test:
   * {@link CoapEfentoCallback#CoapEfentoCallback(CoapExchange, CoAP.ResponseCode, CoAP.ResponseCode)}
   */
  @Test
  void testNewCoapEfentoCallback() {
    // Arrange, Act and Assert
    CoapExchange coapExchange = (new CoapEfentoCallback(
        new CoapExchange(
            new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))),
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE)).exchange;
    OptionSet requestOptions = coapExchange.getRequestOptions();
    assertEquals("", requestOptions.getLocationPathString());
    assertEquals("", requestOptions.getLocationQueryString());
    assertEquals("", requestOptions.getUriPathString());
    assertEquals("", requestOptions.getUriQueryString());
    assertEquals("", coapExchange.getRequestText());
    assertEquals("/", requestOptions.getLocationString());
    assertEquals("/", requestOptions.getUriString());
    assertNull(requestOptions.getOscore());
    assertNull(requestOptions.getObserve());
    assertNull(requestOptions.getSize1());
    assertNull(requestOptions.getSize2());
    assertNull(requestOptions.getUriPort());
    assertNull(requestOptions.getProxyScheme());
    assertNull(requestOptions.getProxyUri());
    assertNull(requestOptions.getUriHost());
    assertNull(requestOptions.getBlock1());
    assertNull(requestOptions.getBlock2());
    assertNull(requestOptions.getNoResponse());
    assertEquals(-1, requestOptions.getAccept());
    assertEquals(-1, requestOptions.getContentFormat());
    assertEquals(0, requestOptions.getETagCount());
    assertEquals(0, requestOptions.getIfMatchCount());
    assertEquals(0, requestOptions.getLocationPathCount());
    assertEquals(0, requestOptions.getLocationQueryCount());
    assertEquals(0, requestOptions.getURIPathCount());
    assertEquals(0, requestOptions.getURIQueryCount());
    assertEquals(0, requestOptions.getUriQueryParameter().size());
    assertEquals(0, coapExchange.getRequestPayloadSize());
    assertEquals(0, coapExchange.getRequestPayload().length);
    assertEquals(60L, requestOptions.getMaxAge().longValue());
    assertEquals(CoAP.Code.DELETE, coapExchange.getRequestCode());
    assertFalse(requestOptions.hasAccept());
    assertFalse(requestOptions.hasBlock1());
    assertFalse(requestOptions.hasBlock2());
    assertFalse(requestOptions.hasContentFormat());
    assertFalse(requestOptions.hasIfNoneMatch());
    assertFalse(requestOptions.hasMaxAge());
    assertFalse(requestOptions.hasNoResponse());
    assertFalse(requestOptions.hasObserve());
    assertFalse(requestOptions.hasOscore());
    assertFalse(requestOptions.hasProxyScheme());
    assertFalse(requestOptions.hasProxyUri());
    assertFalse(requestOptions.hasSize1());
    assertFalse(requestOptions.hasSize2());
    assertFalse(requestOptions.hasUriHost());
    assertFalse(requestOptions.hasUriPort());
    assertFalse(coapExchange.isMulticastRequest());
    assertTrue(requestOptions.getETags().isEmpty());
    assertTrue(requestOptions.getIfMatch().isEmpty());
    assertTrue(requestOptions.getLocationPath().isEmpty());
    assertTrue(requestOptions.getLocationQuery().isEmpty());
    assertTrue(requestOptions.getOthers().isEmpty());
    assertTrue(requestOptions.getUriPath().isEmpty());
    assertTrue(requestOptions.getUriQuery().isEmpty());
  }
}
