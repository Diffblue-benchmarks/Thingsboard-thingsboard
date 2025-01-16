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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CoapEfentoCallbackDiffblueTest {
  /**
   * Test
   * {@link CoapEfentoCallback#CoapEfentoCallback(CoapExchange, ResponseCode, ResponseCode)}.
   * <p>
   * Method under test:
   * {@link CoapEfentoCallback#CoapEfentoCallback(CoapExchange, CoAP.ResponseCode, CoAP.ResponseCode)}
   */
  @Test
  @DisplayName("Test new CoapEfentoCallback(CoapExchange, ResponseCode, ResponseCode)")
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

  /**
   * Test {@link CoapEfentoCallback#onSuccess(Void)} with {@code Void}.
   * <p>
   * Method under test: {@link CoapEfentoCallback#onSuccess(Void)}
   */
  @Test
  @DisplayName("Test onSuccess(Void) with 'Void'")
  void testOnSuccessWithVoid() {
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
   * Test {@link CoapEfentoCallback#onSuccess(Void)} with {@code Void}.
   * <p>
   * Method under test: {@link CoapEfentoCallback#onSuccess(Void)}
   */
  @Test
  @DisplayName("Test onSuccess(Void) with 'Void'")
  void testOnSuccessWithVoid2() {
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
   * Test {@link CoapEfentoCallback#onSuccess(Void)} with {@code Void}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then calls {@link Endpoint#sendResponse(Exchange, Response)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoCallback#onSuccess(Void)}
   */
  @Test
  @DisplayName("Test onSuccess(Void) with 'Void'; given 'A'; then calls sendResponse(Exchange, Response)")
  void testOnSuccessWithVoid_givenA_thenCallsSendResponse() {
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
   * Test {@link CoapEfentoCallback#onSuccess(Void)} with {@code Void}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoCallback#onSuccess(Void)}
   */
  @Test
  @DisplayName("Test onSuccess(Void) with 'Void'; given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor)")
  void testOnSuccessWithVoid_givenCoapExchangeWithExchangeIsExchange() {
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
   * Test {@link CoapEfentoCallback#onSuccess(Void)} with {@code Void}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} LocationPath is
   * {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoCallback#onSuccess(Void)}
   */
  @Test
  @DisplayName("Test onSuccess(Void) with 'Void'; given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) LocationPath is 'Path'")
  void testOnSuccessWithVoid_givenCoapExchangeWithExchangeIsExchangeLocationPathIsPath() {
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
   * Test {@link CoapEfentoCallback#onSuccess(Void)} with {@code Void}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} MaxAge is
   * six.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoCallback#onSuccess(Void)}
   */
  @Test
  @DisplayName("Test onSuccess(Void) with 'Void'; given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) MaxAge is six")
  void testOnSuccessWithVoid_givenCoapExchangeWithExchangeIsExchangeMaxAgeIsSix() {
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
   * Test {@link CoapEfentoCallback#onError(Throwable)}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} ETag is
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoCallback#onError(Throwable)}
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
    CoapEfentoCallback coapEfentoCallback = new CoapEfentoCallback(exchange2, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE,
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    coapEfentoCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoCallback#onError(Throwable)}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} LocationPath is
   * {@code Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoCallback#onError(Throwable)}
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
    CoapEfentoCallback coapEfentoCallback = new CoapEfentoCallback(exchange2, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE,
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    coapEfentoCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoCallback#onError(Throwable)}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} LocationQuery is
   * empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoCallback#onError(Throwable)}
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
    CoapEfentoCallback coapEfentoCallback = new CoapEfentoCallback(exchange2, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE,
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    coapEfentoCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoCallback#onError(Throwable)}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} LocationQuery is
   * {@code Query}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoCallback#onError(Throwable)}
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
    CoapEfentoCallback coapEfentoCallback = new CoapEfentoCallback(exchange2, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE,
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    coapEfentoCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoCallback#onError(Throwable)}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} MaxAge is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoCallback#onError(Throwable)}
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
    CoapEfentoCallback coapEfentoCallback = new CoapEfentoCallback(exchange2, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE,
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    coapEfentoCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoCallback#onError(Throwable)}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)}.</li>
   *   <li>Then calls {@link Endpoint#sendResponse(Exchange, Response)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoCallback#onError(Throwable)}
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
    CoapEfentoCallback coapEfentoCallback = new CoapEfentoCallback(new CoapExchange(exchange),
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    coapEfentoCallback.onError(new Throwable());

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoCallback#isConRequest()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoapEfentoCallback#isConRequest()}
   */
  @Test
  @DisplayName("Test isConRequest(); then return 'true'")
  void testIsConRequest_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new CoapEfentoCallback(
        new CoapExchange(
            new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))),
        CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE, CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE)).isConRequest());
  }
}
