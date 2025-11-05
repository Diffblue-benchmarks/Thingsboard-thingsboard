package org.thingsboard.server.transport.coap.callback;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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

class CoapNoOpCallbackDiffblueTest {
  /**
   * Test {@link CoapNoOpCallback#onError(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link CoapExchange} {@link CoapExchange#respond(ResponseCode)} does nothing.
   *   <li>Then calls {@link CoapExchange#respond(ResponseCode)}.
   * </ul>
   *
   * <p>Method under test: {@link CoapNoOpCallback#onError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onError(Throwable); given CoapExchange respond(ResponseCode) does nothing; then calls respond(ResponseCode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapNoOpCallback.onError(Throwable)"})
  void testOnError_givenCoapExchangeRespondDoesNothing_thenCallsRespond() {
    // Arrange
    CoapExchange exchange = mock(CoapExchange.class);
    doNothing().when(exchange).respond(Mockito.<ResponseCode>any());
    CoapNoOpCallback coapNoOpCallback = new CoapNoOpCallback(exchange);

    // Act
    coapNoOpCallback.onError(new Throwable());

    // Assert
    verify(exchange).respond(ResponseCode.INTERNAL_SERVER_ERROR);
  }

  /**
   * Test {@link CoapNoOpCallback#onError(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link Exchange} {@link Exchange#sendResponse(Response)} does nothing.
   *   <li>Then calls {@link Exchange#getCurrentRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapNoOpCallback#onError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onError(Throwable); given Exchange sendResponse(Response) does nothing; then calls getCurrentRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapNoOpCallback.onError(Throwable)"})
  void testOnError_givenExchangeSendResponseDoesNothing_thenCallsGetCurrentRequest() {
    // Arrange
    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    CoapExchange exchange2 = new CoapExchange(exchange);
    CoapNoOpCallback coapNoOpCallback = new CoapNoOpCallback(exchange2);

    // Act
    coapNoOpCallback.onError(new Throwable());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange).sendResponse(isA(Response.class));
  }

  /**
   * Test {@link CoapNoOpCallback#onError(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link Request} {@link Request#getOptions()} return {@link OptionSet#OptionSet()}.
   *   <li>Then calls {@link Request#getOptions()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapNoOpCallback#onError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onError(Throwable); given Request getOptions() return OptionSet(); then calls getOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapNoOpCallback.onError(Throwable)"})
  void testOnError_givenRequestGetOptionsReturnOptionSet_thenCallsGetOptions() {
    // Arrange
    Request request = mock(Request.class);
    when(request.isMulticast()).thenReturn(true);
    when(request.isObserve()).thenReturn(true);
    when(request.getOptions()).thenReturn(new OptionSet());
    when(request.getSourceContext()).thenReturn(new AddressEndpointContext("42", 8080));
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapNoOpCallback coapNoOpCallback = new CoapNoOpCallback(new CoapExchange(exchange));

    // Act
    coapNoOpCallback.onError(new Throwable());

    // Assert
    verify(request).getOptions();
    verify(request).getSourceContext();
    verify(request).isMulticast();
    verify(request).isObserve();
  }
}
