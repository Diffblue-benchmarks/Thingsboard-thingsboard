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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAP.Code;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
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

class CoapResponseCodeCallbackDiffblueTest {
  /**
   * Test {@link CoapResponseCodeCallback#CoapResponseCodeCallback(CoapExchange, ResponseCode,
   * ResponseCode)}.
   *
   * <p>Method under test: {@link CoapResponseCodeCallback#CoapResponseCodeCallback(CoapExchange,
   * ResponseCode, ResponseCode)}
   */
  @Test
  @DisplayName("Test new CoapResponseCodeCallback(CoapExchange, ResponseCode, ResponseCode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CoapResponseCodeCallback.<init>(CoapExchange, ResponseCode, ResponseCode)"
  })
  void testNewCoapResponseCodeCallback() {
    // Arrange
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    CoapExchange coapExchange =
        new CoapResponseCodeCallback(
                new CoapExchange(exchange),
                ResponseCode._UNKNOWN_SUCCESS_CODE,
                ResponseCode._UNKNOWN_SUCCESS_CODE)
            .exchange;
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
    assertEquals(60L, requestOptions.getMaxAge().longValue());
    assertEquals(Code.DELETE, coapExchange.getRequestCode());
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
    assertArrayEquals(new byte[] {}, coapExchange.getRequestPayload());
  }

  /**
   * Test {@link CoapResponseCodeCallback#onSuccess(Void)} with {@code Void}.
   *
   * <ul>
   *   <li>Then calls {@link CoapExchange#advanced()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapResponseCodeCallback#onSuccess(Void)}
   */
  @Test
  @DisplayName("Test onSuccess(Void) with 'Void'; then calls advanced()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapResponseCodeCallback.onSuccess(Void)"})
  void testOnSuccessWithVoid_thenCallsAdvanced() {
    // Arrange
    CoapExchange exchange = mock(CoapExchange.class);
    doNothing().when(exchange).respond(Mockito.<Response>any());
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    when(exchange.advanced()).thenReturn(exchange2);

    // Act
    new CoapResponseCodeCallback(
            exchange, ResponseCode._UNKNOWN_SUCCESS_CODE, ResponseCode._UNKNOWN_SUCCESS_CODE)
        .onSuccess(null);

    // Assert
    verify(exchange).advanced();
    verify(exchange).respond(isA(Response.class));
  }

  /**
   * Test {@link CoapResponseCodeCallback#onSuccess(Void)} with {@code Void}.
   *
   * <ul>
   *   <li>Then calls {@link Exchange#getCurrentRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapResponseCodeCallback#onSuccess(Void)}
   */
  @Test
  @DisplayName("Test onSuccess(Void) with 'Void'; then calls getCurrentRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapResponseCodeCallback.onSuccess(Void)"})
  void testOnSuccessWithVoid_thenCallsGetCurrentRequest() {
    // Arrange
    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());
    CoapExchange exchange2 = new CoapExchange(exchange);

    // Act
    new CoapResponseCodeCallback(
            exchange2, ResponseCode._UNKNOWN_SUCCESS_CODE, ResponseCode._UNKNOWN_SUCCESS_CODE)
        .onSuccess(null);

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
  }

  /**
   * Test {@link CoapResponseCodeCallback#onError(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link CoapExchange} {@link CoapExchange#respond(ResponseCode)} does nothing.
   *   <li>Then calls {@link CoapExchange#respond(ResponseCode)}.
   * </ul>
   *
   * <p>Method under test: {@link CoapResponseCodeCallback#onError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onError(Throwable); given CoapExchange respond(ResponseCode) does nothing; then calls respond(ResponseCode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapResponseCodeCallback.onError(Throwable)"})
  void testOnError_givenCoapExchangeRespondDoesNothing_thenCallsRespond() {
    // Arrange
    CoapExchange exchange = mock(CoapExchange.class);
    doNothing().when(exchange).respond(Mockito.<ResponseCode>any());
    CoapResponseCodeCallback coapResponseCodeCallback =
        new CoapResponseCodeCallback(
            exchange, ResponseCode._UNKNOWN_SUCCESS_CODE, ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    coapResponseCodeCallback.onError(new Throwable());

    // Assert
    verify(exchange).respond(ResponseCode._UNKNOWN_SUCCESS_CODE);
  }

  /**
   * Test {@link CoapResponseCodeCallback#onError(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link Exchange} {@link Exchange#sendResponse(Response)} does nothing.
   *   <li>Then calls {@link Exchange#getCurrentRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapResponseCodeCallback#onError(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onError(Throwable); given Exchange sendResponse(Response) does nothing; then calls getCurrentRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapResponseCodeCallback.onError(Throwable)"})
  void testOnError_givenExchangeSendResponseDoesNothing_thenCallsGetCurrentRequest() {
    // Arrange
    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    CoapExchange exchange2 = new CoapExchange(exchange);
    CoapResponseCodeCallback coapResponseCodeCallback =
        new CoapResponseCodeCallback(
            exchange2, ResponseCode._UNKNOWN_SUCCESS_CODE, ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    coapResponseCodeCallback.onError(new Throwable());

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange).sendResponse(isA(Response.class));
  }

  /**
   * Test {@link CoapResponseCodeCallback#isConRequest()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CoapResponseCodeCallback#isConRequest()}
   */
  @Test
  @DisplayName("Test isConRequest(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CoapResponseCodeCallback.isConRequest()"})
  void testIsConRequest_thenReturnTrue() {
    // Arrange
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act and Assert
    assertTrue(
        new CoapResponseCodeCallback(
                new CoapExchange(exchange),
                ResponseCode._UNKNOWN_SUCCESS_CODE,
                ResponseCode._UNKNOWN_SUCCESS_CODE)
            .isConRequest());
  }
}
