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

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.thingsboard.server.transport.coap.efento.CoapEfentoTransportResource;

class AbstractCoapTransportResourceDiffblueTest {
  /**
   * Test {@link AbstractCoapTransportResource#handleGET(CoapExchange)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoapTransportResource#handleGET(CoapExchange)}
   */
  @Test
  @DisplayName("Test handleGET(CoapExchange); given 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractCoapTransportResource.handleGET(CoapExchange)"})
  void testHandleGET_givenA() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    coapEfentoTransportResource.handleGET(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handleGET(CoapExchange)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link Exchange#Exchange(Request, Object, Origin, Executor)} MaxAge is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoapTransportResource#handleGET(CoapExchange)}
   */
  @Test
  @DisplayName("Test handleGET(CoapExchange); given two; when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) MaxAge is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractCoapTransportResource.handleGET(CoapExchange)"})
  void testHandleGET_givenTwo_whenCoapExchangeWithExchangeIsExchangeMaxAgeIsTwo() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(2L);

    // Act
    coapEfentoTransportResource.handleGET(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handleGET(CoapExchange)}.
   * <ul>
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link Exchange#Exchange(Request, Object, Origin, Executor)} LocationPath is {@code Invalid path: [{}]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoapTransportResource#handleGET(CoapExchange)}
   */
  @Test
  @DisplayName("Test handleGET(CoapExchange); when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) LocationPath is 'Invalid path: [{}]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractCoapTransportResource.handleGET(CoapExchange)"})
  void testHandleGET_whenCoapExchangeWithExchangeIsExchangeLocationPathIsInvalidPath() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Invalid path: [{}]");

    // Act
    coapEfentoTransportResource.handleGET(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handleGET(CoapExchange)}.
   * <ul>
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link Exchange#Exchange(Request, Object, Origin, Executor)} LocationQuery is {@code Invalid path: [{}]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoapTransportResource#handleGET(CoapExchange)}
   */
  @Test
  @DisplayName("Test handleGET(CoapExchange); when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) LocationQuery is 'Invalid path: [{}]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractCoapTransportResource.handleGET(CoapExchange)"})
  void testHandleGET_whenCoapExchangeWithExchangeIsExchangeLocationQueryIsInvalidPath() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("Invalid path: [{}]");

    // Act
    coapEfentoTransportResource.handleGET(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handleGET(CoapExchange)}.
   * <ul>
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link Exchange#Exchange(Request, Object, Origin, Executor)}.</li>
   *   <li>Then calls {@link Endpoint#sendResponse(Exchange, Response)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoapTransportResource#handleGET(CoapExchange)}
   */
  @Test
  @DisplayName("Test handleGET(CoapExchange); when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor); then calls sendResponse(Exchange, Response)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractCoapTransportResource.handleGET(CoapExchange)"})
  void testHandleGET_whenCoapExchangeWithExchangeIsExchange_thenCallsSendResponse() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    // Act
    coapEfentoTransportResource.handleGET(new CoapExchange(exchange));

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}.
   * <p>
   * Method under test: {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}
   */
  @Test
  @DisplayName("Test handlePOST(CoapExchange)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractCoapTransportResource.handlePOST(CoapExchange)"})
  void testHandlePOST() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Unexpected uri path size, uri path: [{}]");

    // Act
    coapEfentoTransportResource.handlePOST(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}.
   * <p>
   * Method under test: {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}
   */
  @Test
  @DisplayName("Test handlePOST(CoapExchange)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractCoapTransportResource.handlePOST(CoapExchange)"})
  void testHandlePOST2() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("Unexpected uri path size, uri path: [{}]");

    // Act
    coapEfentoTransportResource.handlePOST(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}
   */
  @Test
  @DisplayName("Test handlePOST(CoapExchange); given 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractCoapTransportResource.handlePOST(CoapExchange)"})
  void testHandlePOST_givenA() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    coapEfentoTransportResource.handlePOST(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link Exchange#Exchange(Request, Object, Origin, Executor)} MaxAge is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}
   */
  @Test
  @DisplayName("Test handlePOST(CoapExchange); given two; when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) MaxAge is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractCoapTransportResource.handlePOST(CoapExchange)"})
  void testHandlePOST_givenTwo_whenCoapExchangeWithExchangeIsExchangeMaxAgeIsTwo() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(2L);

    // Act
    coapEfentoTransportResource.handlePOST(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}.
   * <ul>
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link Exchange#Exchange(Request, Object, Origin, Executor)}.</li>
   *   <li>Then calls {@link Endpoint#sendResponse(Exchange, Response)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}
   */
  @Test
  @DisplayName("Test handlePOST(CoapExchange); when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor); then calls sendResponse(Exchange, Response)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractCoapTransportResource.handlePOST(CoapExchange)"})
  void testHandlePOST_whenCoapExchangeWithExchangeIsExchange_thenCallsSendResponse() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    // Act
    coapEfentoTransportResource.handlePOST(new CoapExchange(exchange));

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }
}
