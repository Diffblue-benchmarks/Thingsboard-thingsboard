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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CoapNoOpCallbackDiffblueTest {
  /**
   * Test {@link CoapNoOpCallback#onError(Throwable)}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} ETag is
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapNoOpCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) ETag is 'AXAXAXAX' Bytes is 'UTF-8'")
  void testOnError_givenCoapExchangeWithExchangeIsExchangeETagIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
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
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} LocationPath is
   * {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapNoOpCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) LocationPath is 'Path'")
  void testOnError_givenCoapExchangeWithExchangeIsExchangeLocationPathIsPath() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
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
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} LocationQuery is
   * empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapNoOpCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) LocationQuery is empty string")
  void testOnError_givenCoapExchangeWithExchangeIsExchangeLocationQueryIsEmptyString() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
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
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} LocationQuery is
   * {@code Query}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapNoOpCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) LocationQuery is 'Query'")
  void testOnError_givenCoapExchangeWithExchangeIsExchangeLocationQueryIsQuery() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
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
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} MaxAge is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapNoOpCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) MaxAge is one")
  void testOnError_givenCoapExchangeWithExchangeIsExchangeMaxAgeIsOne() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
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
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)}.</li>
   *   <li>Then calls {@link Endpoint#sendResponse(Exchange, Response)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapNoOpCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor); then calls sendResponse(Exchange, Response)")
  void testOnError_givenCoapExchangeWithExchangeIsExchange_thenCallsSendResponse() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);
    CoapNoOpCallback coapNoOpCallback = new CoapNoOpCallback(new CoapExchange(exchange));

    // Act
    coapNoOpCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }
}
