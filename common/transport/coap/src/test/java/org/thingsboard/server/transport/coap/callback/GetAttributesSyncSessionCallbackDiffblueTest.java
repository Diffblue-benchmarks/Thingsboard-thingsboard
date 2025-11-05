package org.thingsboard.server.transport.coap.callback;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.Exchange.Origin;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.elements.AddressEndpointContext;
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
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test onGetAttributesResponse(GetAttributeResponseMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    Request request = mock(Request.class);
    when(request.isConfirmable()).thenReturn(true);
    when(request.isMulticast()).thenReturn(true);
    when(request.getSourceContext()).thenReturn(new AddressEndpointContext("", 8080));
    when(request.isObserve()).thenReturn(true);
    when(request.getOptions()).thenReturn(new OptionSet());
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange2 = new CoapExchange(exchange);

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(request, atLeast(1)).getOptions();
    verify(request).getSourceContext();
    verify(request).isConfirmable();
    verify(request).isMulticast();
    verify(request).isObserve();
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }

  /**
   * Test {@link GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}.
   *
   * <p>Method under test: {@link
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test onGetAttributesResponse(GetAttributeResponseMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse2() throws UnsupportedEncodingException {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    Request request = mock(Request.class);
    when(request.isConfirmable()).thenReturn(true);
    when(request.getOptions()).thenReturn(new OptionSet());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(request);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag("AXAXAXAX".getBytes("UTF-8"));

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(request).getOptions();
    verify(request).isConfirmable();
    verify(exchange).getCurrentRequest();
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }

  /**
   * Test {@link GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}.
   *
   * <p>Method under test: {@link
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test onGetAttributesResponse(GetAttributeResponseMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse3() throws AdaptorException {
    // Arrange
    JsonCoapAdaptor jsonCoapAdaptor = mock(JsonCoapAdaptor.class);
    when(jsonCoapAdaptor.convertToPublish(Mockito.<GetAttributeResponseMsg>any()))
        .thenReturn(new Response(ResponseCode._UNKNOWN_SUCCESS_CODE));

    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(jsonCoapAdaptor);

    Request request = mock(Request.class);
    when(request.isConfirmable()).thenReturn(true);
    when(request.getOptions()).thenReturn(new OptionSet());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(request);
    CoapExchange exchange2 = new CoapExchange(exchange);

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(request).getOptions();
    verify(request).isConfirmable();
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
   *   <li>Given {@link CoapExchange} {@link CoapExchange#respond(Response)} does nothing.
   *   <li>Then calls {@link CoapExchange#respond(Response)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg); given CoapExchange respond(Response) does nothing; then calls respond(Response)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_givenCoapExchangeRespondDoesNothing_thenCallsRespond()
      throws AdaptorException {
    // Arrange
    JsonCoapAdaptor jsonCoapAdaptor = mock(JsonCoapAdaptor.class);
    when(jsonCoapAdaptor.convertToPublish(Mockito.<GetAttributeResponseMsg>any()))
        .thenThrow(new AdaptorException());

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
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg); given CoapExchange(Exchange) with Exchange LocationPath is 'Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_givenCoapExchangeWithExchangeLocationPathIsPath() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    Request request = mock(Request.class);
    when(request.isConfirmable()).thenReturn(true);
    when(request.getOptions()).thenReturn(new OptionSet());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(request);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Path");

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(request).getOptions();
    verify(request).isConfirmable();
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
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg); given CoapExchange(Exchange) with Exchange LocationQuery is 'Query'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_givenCoapExchangeWithExchangeLocationQueryIsQuery() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    Request request = mock(Request.class);
    when(request.isConfirmable()).thenReturn(true);
    when(request.getOptions()).thenReturn(new OptionSet());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(request);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("Query");

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(request).getOptions();
    verify(request).isConfirmable();
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
   *   <li>Given {@link CoapExchange#CoapExchange(Exchange)} with {@link Exchange} MaxAge is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg); given CoapExchange(Exchange) with Exchange MaxAge is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_givenCoapExchangeWithExchangeMaxAgeIsOne() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    Request request = mock(Request.class);
    when(request.isConfirmable()).thenReturn(true);
    when(request.getOptions()).thenReturn(new OptionSet());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(request);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(1L);

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(request).getOptions();
    verify(request).isConfirmable();
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
   *   <li>Given {@link Exchange} {@link Exchange#getRequest()} return newDelete.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg); given Exchange getRequest() return newDelete")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_givenExchangeGetRequestReturnNewDelete() {
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
   *   <li>Given {@link OptionSet#OptionSet()} ContentFormat is one.
   *   <li>Then calls {@link Exchange#getRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg); given OptionSet() ContentFormat is one; then calls getRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_givenOptionSetContentFormatIsOne_thenCallsGetRequest() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    OptionSet optionSet = new OptionSet();
    optionSet.setContentFormat(1);

    Request request = mock(Request.class);
    when(request.isConfirmable()).thenReturn(true);
    when(request.getOptions()).thenReturn(optionSet);

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(request);
    CoapExchange exchange2 = new CoapExchange(exchange);

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(request).getOptions();
    verify(request).isConfirmable();
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
   *   <li>Given {@link Request} {@link Request#getSourceContext()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg); given Request getSourceContext() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_givenRequestGetSourceContextReturnNull() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    Request request = mock(Request.class);
    when(request.isConfirmable()).thenReturn(true);
    when(request.isMulticast()).thenReturn(true);
    when(request.getSourceContext()).thenReturn(null);
    when(request.isObserve()).thenReturn(true);
    when(request.getOptions()).thenReturn(new OptionSet());
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange2 = new CoapExchange(exchange);

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(request, atLeast(1)).getOptions();
    verify(request).getSourceContext();
    verify(request).isConfirmable();
    verify(request).isMulticast();
    verify(request).isObserve();
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
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg); given TbCoapClientState getContentFormat() return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_givenTbCoapClientStateGetContentFormatReturnMinusOne() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(-1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    Request request = mock(Request.class);
    when(request.isConfirmable()).thenReturn(true);
    when(request.getOptions()).thenReturn(new OptionSet());

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(request);
    CoapExchange exchange2 = new CoapExchange(exchange);

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act
    getAttributesSyncSessionCallback.onGetAttributesResponse(
        GetAttributeResponseMsg.getDefaultInstance());

    // Assert
    verify(request).getOptions();
    verify(request).isConfirmable();
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
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName("Test onGetAttributesResponse(GetAttributeResponseMsg); then calls getDeviceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_thenCallsGetDeviceId() throws AdaptorException {
    // Arrange
    JsonCoapAdaptor jsonCoapAdaptor = mock(JsonCoapAdaptor.class);
    when(jsonCoapAdaptor.convertToPublish(Mockito.<GetAttributeResponseMsg>any()))
        .thenThrow(new AdaptorException());

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

  /**
   * Test {@link GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GetAttributesSyncSessionCallback#onGetAttributesResponse(GetAttributeResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test onGetAttributesResponse(GetAttributeResponseMsg); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GetAttributesSyncSessionCallback.onGetAttributesResponse(GetAttributeResponseMsg)"
  })
  void testOnGetAttributesResponse_thenThrowIllegalArgumentException() {
    // Arrange
    TbCoapClientState state = mock(TbCoapClientState.class);
    when(state.getContentFormat()).thenReturn(1);
    when(state.getAdaptor()).thenReturn(new JsonCoapAdaptor());

    InetAddress address = mock(InetAddress.class);
    when(address.getHostAddress()).thenReturn("42 Main St");
    when(address.isMulticastAddress()).thenReturn(true);
    AddressEndpointContext addressEndpointContext = new AddressEndpointContext(address, 8080);

    Request request = mock(Request.class);
    when(request.isConfirmable()).thenReturn(true);
    when(request.getSourceContext()).thenReturn(addressEndpointContext);
    when(request.isObserve()).thenReturn(true);
    when(request.getOptions()).thenReturn(new OptionSet());
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange2 = new CoapExchange(exchange);

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            getAttributesSyncSessionCallback.onGetAttributesResponse(
                GetAttributeResponseMsg.getDefaultInstance()));
    verify(address).getHostAddress();
    verify(address).isMulticastAddress();
    verify(request).getOptions();
    verify(request).getSourceContext();
    verify(request).isConfirmable();
    verify(request).isObserve();
    verify(state).getAdaptor();
    verify(state).getContentFormat();
  }
}
