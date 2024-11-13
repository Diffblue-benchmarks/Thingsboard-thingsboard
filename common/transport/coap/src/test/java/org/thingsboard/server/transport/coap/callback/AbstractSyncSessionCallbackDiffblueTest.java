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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.transport.coap.client.TbCoapClientState;
import org.thingsboard.server.transport.coap.client.TbCoapObservationState;

class AbstractSyncSessionCallbackDiffblueTest {
  /**
   * Test
   * {@link AbstractSyncSessionCallback#isConRequest(TbCoapObservationState)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSyncSessionCallback#isConRequest(TbCoapObservationState)}
   */
  @Test
  @DisplayName("Test isConRequest(TbCoapObservationState); then return 'true'")
  void testIsConRequest_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(AbstractSyncSessionCallback.isConRequest(new TbCoapObservationState(
        new CoapExchange(
            new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class))),
        "ABC123")));
  }

  /**
   * Test
   * {@link AbstractSyncSessionCallback#isConRequest(TbCoapObservationState)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractSyncSessionCallback#isConRequest(TbCoapObservationState)}
   */
  @Test
  @DisplayName("Test isConRequest(TbCoapObservationState); when 'null'; then return 'false'")
  void testIsConRequest_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AbstractSyncSessionCallback.isConRequest(null));
  }

  /**
   * Test {@link AbstractSyncSessionCallback#respond(Response)}.
   * <p>
   * Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  @DisplayName("Test respond(Response)")
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
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(60L, options.getMaxAge().longValue());
    assertFalse(options.hasMaxAge());
    assertTrue(options.getETags().isEmpty());
    assertTrue(options.getLocationPath().isEmpty());
    assertTrue(options.getLocationQuery().isEmpty());
  }

  /**
   * Test {@link AbstractSyncSessionCallback#respond(Response)}.
   * <p>
   * Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  @DisplayName("Test respond(Response)")
  void testRespond2() {
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
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(42L, options.getMaxAge().longValue());
    assertTrue(options.getETags().isEmpty());
    assertTrue(options.getLocationPath().isEmpty());
    assertTrue(options.getLocationQuery().isEmpty());
    assertTrue(options.hasMaxAge());
  }

  /**
   * Test {@link AbstractSyncSessionCallback#respond(Response)}.
   * <ul>
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} LocationQuery is
   * empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  @DisplayName("Test respond(Response); given CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) LocationQuery is empty string")
  void testRespond_givenCoapExchangeWithExchangeIsExchangeLocationQueryIsEmptyString() {
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
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(60L, options.getMaxAge().longValue());
    assertFalse(options.hasMaxAge());
    assertTrue(options.getETags().isEmpty());
    assertTrue(options.getLocationPath().isEmpty());
    assertTrue(options.getLocationQuery().isEmpty());
  }

  /**
   * Test {@link AbstractSyncSessionCallback#respond(Response)}.
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  @DisplayName("Test respond(Response); given OptionSet()")
  void testRespond_givenOptionSet() {
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
    assertEquals(0, options.getETagCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(60L, options.getMaxAge().longValue());
    assertFalse(options.hasMaxAge());
    assertTrue(options.getETags().isEmpty());
    assertTrue(options.getLocationPath().isEmpty());
    assertTrue(options.getLocationQuery().isEmpty());
  }

  /**
   * Test {@link AbstractSyncSessionCallback#respond(Response)}.
   * <ul>
   *   <li>Then {@link Response#Response(ResponseCode)} with code is
   * {@code _UNKNOWN_SUCCESS_CODE} Options ETags size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  @DisplayName("Test respond(Response); then Response(ResponseCode) with code is '_UNKNOWN_SUCCESS_CODE' Options ETags size is one")
  void testRespond_thenResponseWithCodeIsUnknownSuccessCodeOptionsETagsSizeIsOne() throws UnsupportedEncodingException {
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
    List<byte[]> eTags = options.getETags();
    assertEquals(1, eTags.size());
    assertEquals(1, options.getETagCount());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), eTags.get(0));
  }

  /**
   * Test {@link AbstractSyncSessionCallback#respond(Response)}.
   * <ul>
   *   <li>Then {@link Response#Response(ResponseCode)} with code is
   * {@code _UNKNOWN_SUCCESS_CODE} Options LocationString is {@code /Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  @DisplayName("Test respond(Response); then Response(ResponseCode) with code is '_UNKNOWN_SUCCESS_CODE' Options LocationString is '/Path'")
  void testRespond_thenResponseWithCodeIsUnknownSuccessCodeOptionsLocationStringIsPath() {
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
    assertEquals("/Path", options.getLocationString());
    List<String> locationPath = options.getLocationPath();
    assertEquals(1, locationPath.size());
    assertEquals("Path", locationPath.get(0));
    assertEquals("Path", options.getLocationPathString());
    assertEquals(1, options.getLocationPathCount());
  }

  /**
   * Test {@link AbstractSyncSessionCallback#respond(Response)}.
   * <ul>
   *   <li>Then {@link Response#Response(ResponseCode)} with code is
   * {@code _UNKNOWN_SUCCESS_CODE} Options LocationString is {@code /?Query}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  @DisplayName("Test respond(Response); then Response(ResponseCode) with code is '_UNKNOWN_SUCCESS_CODE' Options LocationString is '/?Query'")
  void testRespond_thenResponseWithCodeIsUnknownSuccessCodeOptionsLocationStringIsQuery() {
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
    assertEquals("/?Query", options.getLocationString());
    List<String> locationQuery = options.getLocationQuery();
    assertEquals(1, locationQuery.size());
    assertEquals("Query", locationQuery.get(0));
    assertEquals("Query", options.getLocationQueryString());
    assertEquals(1, options.getLocationQueryCount());
  }
}
