package org.thingsboard.server.transport.coap.callback;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
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

class CoapDeviceAuthCallbackDiffblueTest {
  /**
   * Test {@link CoapDeviceAuthCallback#onError(Throwable)}.
   *
   * <p>Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onError(Throwable)"})
  void testOnError() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Failed to process request");
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

    // Act
    coapDeviceAuthCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapDeviceAuthCallback#onError(Throwable)}.
   *
   * <p>Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  @DisplayName("Test onError(Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onError(Throwable)"})
  void testOnError2() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("Failed to process request");
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

    // Act
    coapDeviceAuthCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapDeviceAuthCallback#onError(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link
   *       Exchange#Exchange(Request, Object, Origin, Executor)} ETag is {@code AXAXAXAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) ETag is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onError(Throwable)"})
  void testOnError_givenCoapExchangeWithExchangeIsExchangeETagIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag("AXAXAXAX".getBytes("UTF-8"));
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

    // Act
    coapDeviceAuthCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapDeviceAuthCallback#onError(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link
   *       Exchange#Exchange(Request, Object, Origin, Executor)} LocationQuery is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) LocationQuery is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onError(Throwable)"})
  void testOnError_givenCoapExchangeWithExchangeIsExchangeLocationQueryIsEmptyString() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("");
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

    // Act
    coapDeviceAuthCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapDeviceAuthCallback#onError(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link
   *       Exchange#Exchange(Request, Object, Origin, Executor)} MaxAge is one.
   * </ul>
   *
   * <p>Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) MaxAge is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onError(Throwable)"})
  void testOnError_givenCoapExchangeWithExchangeIsExchangeMaxAgeIsOne() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(1L);
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(exchange2, mock(BiConsumer.class));

    // Act
    coapDeviceAuthCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapDeviceAuthCallback#onError(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is {@link
   *       Exchange#Exchange(Request, Object, Origin, Executor)}.
   *   <li>Then calls {@link Endpoint#sendResponse(Exchange, Response)}.
   * </ul>
   *
   * <p>Method under test: {@link CoapDeviceAuthCallback#onError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onError(Throwable); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor); then calls sendResponse(Exchange, Response)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapDeviceAuthCallback.onError(Throwable)"})
  void testOnError_givenCoapExchangeWithExchangeIsExchange_thenCallsSendResponse() {
    // Arrange
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    exchange.setEndpoint(endpoint);
    CoapDeviceAuthCallback coapDeviceAuthCallback =
        new CoapDeviceAuthCallback(new CoapExchange(exchange), mock(BiConsumer.class));

    // Act
    coapDeviceAuthCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }
}
