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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Endpoint;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.Exchange.Origin;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CoapNoOpCallbackDiffblueTest {
  /**
   * Test {@link CoapNoOpCallback#onError(Throwable)}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link Exchange#Exchange(Request, Object, Origin, Executor)} ETag is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapNoOpCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) ETag is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapNoOpCallback.onError(Throwable)"})
  void testOnError_givenCoapExchangeWithExchangeIsExchangeETagIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag("AXAXAXAX".getBytes("UTF-8"));
    CoapNoOpCallback coapNoOpCallback = new CoapNoOpCallback(exchange2);

    // Act
    coapNoOpCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapNoOpCallback#onError(Throwable)}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link Exchange#Exchange(Request, Object, Origin, Executor)} LocationPath is {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapNoOpCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) LocationPath is 'Path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapNoOpCallback.onError(Throwable)"})
  void testOnError_givenCoapExchangeWithExchangeIsExchangeLocationPathIsPath() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Path");
    CoapNoOpCallback coapNoOpCallback = new CoapNoOpCallback(exchange2);

    // Act
    coapNoOpCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapNoOpCallback#onError(Throwable)}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link Exchange#Exchange(Request, Object, Origin, Executor)} LocationQuery is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapNoOpCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) LocationQuery is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapNoOpCallback.onError(Throwable)"})
  void testOnError_givenCoapExchangeWithExchangeIsExchangeLocationQueryIsEmptyString() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("");
    CoapNoOpCallback coapNoOpCallback = new CoapNoOpCallback(exchange2);

    // Act
    coapNoOpCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapNoOpCallback#onError(Throwable)}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link Exchange#Exchange(Request, Object, Origin, Executor)} LocationQuery is {@code Query}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapNoOpCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) LocationQuery is 'Query'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapNoOpCallback.onError(Throwable)"})
  void testOnError_givenCoapExchangeWithExchangeIsExchangeLocationQueryIsQuery() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("Query");
    CoapNoOpCallback coapNoOpCallback = new CoapNoOpCallback(exchange2);

    // Act
    coapNoOpCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapNoOpCallback#onError(Throwable)}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link Exchange#Exchange(Request, Object, Origin, Executor)} MaxAge is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapNoOpCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) MaxAge is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapNoOpCallback.onError(Throwable)"})
  void testOnError_givenCoapExchangeWithExchangeIsExchangeMaxAgeIsOne() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(1L);
    CoapNoOpCallback coapNoOpCallback = new CoapNoOpCallback(exchange2);

    // Act
    coapNoOpCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapNoOpCallback#onError(Throwable)}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link Exchange#Exchange(Request, Object, Origin, Executor)}.</li>
   *   <li>Then calls {@link Endpoint#sendResponse(Exchange, Response)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapNoOpCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor); then calls sendResponse(Exchange, Response)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapNoOpCallback.onError(Throwable)"})
  void testOnError_givenCoapExchangeWithExchangeIsExchange_thenCallsSendResponse() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);
    CoapNoOpCallback coapNoOpCallback = new CoapNoOpCallback(new CoapExchange(exchange));

    // Act
    coapNoOpCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }
}
