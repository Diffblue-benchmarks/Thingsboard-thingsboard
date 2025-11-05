package org.thingsboard.server.transport.coap.callback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.Exchange.Origin;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.transport.coap.client.TbCoapClientState;
import org.thingsboard.server.transport.coap.client.TbCoapObservationState;

class AbstractSyncSessionCallbackDiffblueTest {
  /**
   * Test {@link AbstractSyncSessionCallback#isConRequest(TbCoapObservationState)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSyncSessionCallback#isConRequest(TbCoapObservationState)}
   */
  @Test
  @DisplayName("Test isConRequest(TbCoapObservationState); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractSyncSessionCallback.isConRequest(TbCoapObservationState)"})
  void testIsConRequest_thenReturnTrue() {
    // Arrange
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertTrue(
        AbstractSyncSessionCallback.isConRequest(
            new TbCoapObservationState(new CoapExchange(exchange), "ABC123")));
  }

  /**
   * Test {@link AbstractSyncSessionCallback#isConRequest(TbCoapObservationState)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSyncSessionCallback#isConRequest(TbCoapObservationState)}
   */
  @Test
  @DisplayName("Test isConRequest(TbCoapObservationState); when 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractSyncSessionCallback.isConRequest(TbCoapObservationState)"})
  void testIsConRequest_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(AbstractSyncSessionCallback.isConRequest(null));
  }

  /**
   * Test {@link AbstractSyncSessionCallback#respond(Response)}.
   *
   * <p>Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  @DisplayName("Test respond(Response)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractSyncSessionCallback.respond(Response)"})
  void testRespond() {
    // Arrange
    CoapExchange exchange = mock(CoapExchange.class);
    doNothing().when(exchange).respond(Mockito.<Response>any());
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    when(exchange.advanced()).thenReturn(exchange2);
    when(exchange.getRequestOptions()).thenReturn(new OptionSet());
    TbCoapClientState state = new TbCoapClientState(null);

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange, Request.newDelete());
    Response response = new Response(ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    getAttributesSyncSessionCallback.respond(response);

    // Assert
    verify(exchange).advanced();
    verify(exchange).getRequestOptions();
    verify(exchange).respond(isA(Response.class));
    OptionSet options = response.getOptions();
    assertEquals(0, options.getContentFormat());
    assertEquals(Type.CON, response.getType());
    assertTrue(response.isConfirmable());
    assertTrue(options.hasContentFormat());
  }

  /**
   * Test {@link AbstractSyncSessionCallback#respond(Response)}.
   *
   * <ul>
   *   <li>Given {@link Exchange} {@link Exchange#sendResponse(Response)} does nothing.
   *   <li>Then calls {@link Exchange#getCurrentRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  @DisplayName(
      "Test respond(Response); given Exchange sendResponse(Response) does nothing; then calls getCurrentRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractSyncSessionCallback.respond(Response)"})
  void testRespond_givenExchangeSendResponseDoesNothing_thenCallsGetCurrentRequest() {
    // Arrange
    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());
    CoapExchange exchange2 = new CoapExchange(exchange);
    TbCoapClientState state = new TbCoapClientState(null);

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());
    Response response = new Response(ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    getAttributesSyncSessionCallback.respond(response);

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange, atLeast(1)).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
    OptionSet options = response.getOptions();
    assertEquals(0, options.getContentFormat());
    assertEquals(Type.CON, response.getType());
    assertTrue(response.isConfirmable());
    assertTrue(options.hasContentFormat());
  }

  /**
   * Test {@link AbstractSyncSessionCallback#respond(Response)}.
   *
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()} ContentFormat is forty-two.
   *   <li>Then calls {@link Response#getOptions()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  @DisplayName(
      "Test respond(Response); given OptionSet() ContentFormat is forty-two; then calls getOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractSyncSessionCallback.respond(Response)"})
  void testRespond_givenOptionSetContentFormatIsFortyTwo_thenCallsGetOptions() {
    // Arrange
    OptionSet optionSet = new OptionSet();
    optionSet.setContentFormat(42);

    Exchange exchange = mock(Exchange.class);
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    CoapExchange exchange2 = mock(CoapExchange.class);
    doNothing().when(exchange2).respond(Mockito.<Response>any());
    when(exchange2.advanced()).thenReturn(exchange);
    when(exchange2.getRequestOptions()).thenReturn(optionSet);
    TbCoapClientState state = new TbCoapClientState(null);

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    Response response = mock(Response.class);
    when(response.setConfirmable(anyBoolean())).thenReturn(new EmptyMessage(Type.CON));
    when(response.getOptions()).thenReturn(new OptionSet());

    // Act
    getAttributesSyncSessionCallback.respond(response);

    // Assert
    verify(response).getOptions();
    verify(response).setConfirmable(true);
    verify(exchange).getRequest();
    verify(exchange2).advanced();
    verify(exchange2).getRequestOptions();
    verify(exchange2).respond(isA(Response.class));
  }

  /**
   * Test {@link AbstractSyncSessionCallback#respond(Response)}.
   *
   * <ul>
   *   <li>Given {@link OptionSet} {@link OptionSet#getContentFormat()} return one.
   *   <li>Then calls {@link OptionSet#getContentFormat()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  @DisplayName(
      "Test respond(Response); given OptionSet getContentFormat() return one; then calls getContentFormat()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractSyncSessionCallback.respond(Response)"})
  void testRespond_givenOptionSetGetContentFormatReturnOne_thenCallsGetContentFormat() {
    // Arrange
    OptionSet optionSet = mock(OptionSet.class);
    when(optionSet.getContentFormat()).thenReturn(1);

    Exchange exchange = mock(Exchange.class);
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    CoapExchange exchange2 = mock(CoapExchange.class);
    doNothing().when(exchange2).respond(Mockito.<Response>any());
    when(exchange2.advanced()).thenReturn(exchange);
    when(exchange2.getRequestOptions()).thenReturn(optionSet);
    TbCoapClientState state = new TbCoapClientState(null);

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    Response response = mock(Response.class);
    when(response.setConfirmable(anyBoolean())).thenReturn(new EmptyMessage(Type.CON));
    when(response.getOptions()).thenReturn(new OptionSet());

    // Act
    getAttributesSyncSessionCallback.respond(response);

    // Assert
    verify(response).getOptions();
    verify(response).setConfirmable(true);
    verify(optionSet).getContentFormat();
    verify(exchange).getRequest();
    verify(exchange2).advanced();
    verify(exchange2).getRequestOptions();
    verify(exchange2).respond(isA(Response.class));
  }

  /**
   * Test {@link AbstractSyncSessionCallback#respond(Response)}.
   *
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()}.
   *   <li>Then calls {@link Response#getOptions()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  @DisplayName("Test respond(Response); given OptionSet(); then calls getOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractSyncSessionCallback.respond(Response)"})
  void testRespond_givenOptionSet_thenCallsGetOptions() {
    // Arrange
    Exchange exchange = mock(Exchange.class);
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    CoapExchange exchange2 = mock(CoapExchange.class);
    doNothing().when(exchange2).respond(Mockito.<Response>any());
    when(exchange2.advanced()).thenReturn(exchange);
    when(exchange2.getRequestOptions()).thenReturn(new OptionSet());
    TbCoapClientState state = new TbCoapClientState(null);

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    Response response = mock(Response.class);
    when(response.setConfirmable(anyBoolean())).thenReturn(new EmptyMessage(Type.CON));
    when(response.getOptions()).thenReturn(new OptionSet());

    // Act
    getAttributesSyncSessionCallback.respond(response);

    // Assert
    verify(response).getOptions();
    verify(response).setConfirmable(true);
    verify(exchange).getRequest();
    verify(exchange2).advanced();
    verify(exchange2).getRequestOptions();
    verify(exchange2).respond(isA(Response.class));
  }

  /**
   * Test {@link AbstractSyncSessionCallback#respond(Response)}.
   *
   * <ul>
   *   <li>Given {@link TbCoapClientState#TbCoapClientState(DeviceId)} with deviceId is {@code null}
   *       ContentFormat is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  @DisplayName(
      "Test respond(Response); given TbCoapClientState(DeviceId) with deviceId is 'null' ContentFormat is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractSyncSessionCallback.respond(Response)"})
  void testRespond_givenTbCoapClientStateWithDeviceIdIsNullContentFormatIsFortyTwo() {
    // Arrange
    TbCoapClientState state = new TbCoapClientState(null);
    state.setContentFormat(42);

    Exchange exchange = mock(Exchange.class);
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    CoapExchange exchange2 = mock(CoapExchange.class);
    doNothing().when(exchange2).respond(Mockito.<Response>any());
    when(exchange2.advanced()).thenReturn(exchange);
    when(exchange2.getRequestOptions()).thenReturn(new OptionSet());

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    Response response = mock(Response.class);
    when(response.setConfirmable(anyBoolean())).thenReturn(new EmptyMessage(Type.CON));
    when(response.getOptions()).thenReturn(new OptionSet());

    // Act
    getAttributesSyncSessionCallback.respond(response);

    // Assert
    verify(response).getOptions();
    verify(response).setConfirmable(true);
    verify(exchange).getRequest();
    verify(exchange2).advanced();
    verify(exchange2).getRequestOptions();
    verify(exchange2).respond(isA(Response.class));
  }

  /**
   * Test {@link AbstractSyncSessionCallback#respond(Response)}.
   *
   * <ul>
   *   <li>Then calls {@link OptionSet#setContentFormat(int)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSyncSessionCallback#respond(Response)}
   */
  @Test
  @DisplayName("Test respond(Response); then calls setContentFormat(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractSyncSessionCallback.respond(Response)"})
  void testRespond_thenCallsSetContentFormat() {
    // Arrange
    OptionSet optionSet = mock(OptionSet.class);
    when(optionSet.getContentFormat()).thenReturn(1);

    Exchange exchange = mock(Exchange.class);
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    CoapExchange exchange2 = mock(CoapExchange.class);
    doNothing().when(exchange2).respond(Mockito.<Response>any());
    when(exchange2.advanced()).thenReturn(exchange);
    when(exchange2.getRequestOptions()).thenReturn(optionSet);
    TbCoapClientState state = new TbCoapClientState(null);

    GetAttributesSyncSessionCallback getAttributesSyncSessionCallback =
        new GetAttributesSyncSessionCallback(state, exchange2, Request.newDelete());

    OptionSet optionSet2 = mock(OptionSet.class);
    when(optionSet2.setContentFormat(anyInt())).thenReturn(new OptionSet());

    Response response = mock(Response.class);
    when(response.setConfirmable(anyBoolean())).thenReturn(new EmptyMessage(Type.CON));
    when(response.getOptions()).thenReturn(optionSet2);

    // Act
    getAttributesSyncSessionCallback.respond(response);

    // Assert
    verify(response).getOptions();
    verify(response).setConfirmable(true);
    verify(optionSet).getContentFormat();
    verify(optionSet2).setContentFormat(1);
    verify(exchange).getRequest();
    verify(exchange2).advanced();
    verify(exchange2).getRequestOptions();
    verify(exchange2).respond(isA(Response.class));
  }
}
