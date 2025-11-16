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
import static org.mockito.Mockito.mock;
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

class CoapResponseCallbackDiffblueTest {
  /**
   * Test {@link CoapResponseCallback#CoapResponseCallback(CoapExchange, Response, Response)}.
   *
   * <p>Method under test: {@link CoapResponseCallback#CoapResponseCallback(CoapExchange, Response,
   * Response)}
   */
  @Test
  @DisplayName("Test new CoapResponseCallback(CoapExchange, Response, Response)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoapResponseCallback.<init>(CoapExchange, Response, Response)"})
  void testNewCoapResponseCallback() {
    // Arrange
    Exchange exchange =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    CoapExchange exchange2 = new CoapExchange(exchange);
    Response onSuccessResponse = new Response(ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    CoapResponseCallback actualCoapResponseCallback =
        new CoapResponseCallback(
            exchange2, onSuccessResponse, new Response(ResponseCode._UNKNOWN_SUCCESS_CODE));

    // Assert
    Response response = actualCoapResponseCallback.onFailureResponse;
    assertEquals("", response.getPayloadString());
    Response response2 = actualCoapResponseCallback.onSuccessResponse;
    assertEquals("", response2.getPayloadString());
    OptionSet options = response.getOptions();
    assertEquals("", options.getLocationPathString());
    OptionSet options2 = response2.getOptions();
    assertEquals("", options2.getLocationPathString());
    CoapExchange coapExchange = actualCoapResponseCallback.exchange;
    OptionSet requestOptions = coapExchange.getRequestOptions();
    assertEquals("", requestOptions.getLocationPathString());
    assertEquals("", options.getLocationQueryString());
    assertEquals("", options2.getLocationQueryString());
    assertEquals("", requestOptions.getLocationQueryString());
    assertEquals("", options.getUriPathString());
    assertEquals("", options2.getUriPathString());
    assertEquals("", requestOptions.getUriPathString());
    assertEquals("", options.getUriQueryString());
    assertEquals("", options2.getUriQueryString());
    assertEquals("", requestOptions.getUriQueryString());
    assertEquals("", coapExchange.getRequestText());
    assertEquals("/", options.getLocationString());
    assertEquals("/", options2.getLocationString());
    assertEquals("/", requestOptions.getLocationString());
    assertEquals("/", options.getUriString());
    assertEquals("/", options2.getUriString());
    assertEquals("/", requestOptions.getUriString());
    assertEquals("null", response.getTokenString());
    assertEquals("null", response2.getTokenString());
    assertNull(response.getBytes());
    assertNull(response2.getBytes());
    assertNull(response.getTokenBytes());
    assertNull(response2.getTokenBytes());
    assertNull(options.getOscore());
    assertNull(options2.getOscore());
    assertNull(requestOptions.getOscore());
    assertNull(options.getObserve());
    assertNull(options2.getObserve());
    assertNull(requestOptions.getObserve());
    assertNull(options.getSize1());
    assertNull(options2.getSize1());
    assertNull(requestOptions.getSize1());
    assertNull(options.getSize2());
    assertNull(options2.getSize2());
    assertNull(requestOptions.getSize2());
    assertNull(options.getUriPort());
    assertNull(options2.getUriPort());
    assertNull(requestOptions.getUriPort());
    assertNull(response.getApplicationRttNanos());
    assertNull(response2.getApplicationRttNanos());
    assertNull(response.getTransmissionRttNanos());
    assertNull(response2.getTransmissionRttNanos());
    assertNull(options.getProxyScheme());
    assertNull(options2.getProxyScheme());
    assertNull(requestOptions.getProxyScheme());
    assertNull(options.getProxyUri());
    assertNull(options2.getProxyUri());
    assertNull(requestOptions.getProxyUri());
    assertNull(options.getUriHost());
    assertNull(options2.getUriHost());
    assertNull(requestOptions.getUriHost());
    assertNull(response.getSendError());
    assertNull(response2.getSendError());
    assertNull(response.getLocalAddress());
    assertNull(response2.getLocalAddress());
    assertNull(options.getBlock1());
    assertNull(options2.getBlock1());
    assertNull(requestOptions.getBlock1());
    assertNull(options.getBlock2());
    assertNull(options2.getBlock2());
    assertNull(requestOptions.getBlock2());
    assertNull(response.getType());
    assertNull(response2.getType());
    assertNull(response.getOffloadMode());
    assertNull(response2.getOffloadMode());
    assertNull(options.getNoResponse());
    assertNull(options2.getNoResponse());
    assertNull(requestOptions.getNoResponse());
    assertNull(response.getToken());
    assertNull(response2.getToken());
    assertNull(response.getReliabilityLayerParameters());
    assertNull(response2.getReliabilityLayerParameters());
    assertNull(response.getDestinationContext());
    assertNull(response2.getDestinationContext());
    assertNull(response.getEffectiveDestinationContext());
    assertNull(response2.getEffectiveDestinationContext());
    assertNull(response.getSourceContext());
    assertNull(response2.getSourceContext());
    assertEquals(-1, response.getMID());
    assertEquals(-1, response2.getMID());
    assertEquals(-1, options.getAccept());
    assertEquals(-1, options2.getAccept());
    assertEquals(-1, requestOptions.getAccept());
    assertEquals(-1, options.getContentFormat());
    assertEquals(-1, options2.getContentFormat());
    assertEquals(-1, requestOptions.getContentFormat());
    assertEquals(0, response.getMaxResourceBodySize());
    assertEquals(0, response2.getMaxResourceBodySize());
    assertEquals(0, response.getMessageSize());
    assertEquals(0, response2.getMessageSize());
    assertEquals(0, response.getPayloadSize());
    assertEquals(0, response2.getPayloadSize());
    assertEquals(0, options.getETagCount());
    assertEquals(0, options2.getETagCount());
    assertEquals(0, requestOptions.getETagCount());
    assertEquals(0, options.getIfMatchCount());
    assertEquals(0, options2.getIfMatchCount());
    assertEquals(0, requestOptions.getIfMatchCount());
    assertEquals(0, options.getLocationPathCount());
    assertEquals(0, options2.getLocationPathCount());
    assertEquals(0, requestOptions.getLocationPathCount());
    assertEquals(0, options.getLocationQueryCount());
    assertEquals(0, options2.getLocationQueryCount());
    assertEquals(0, requestOptions.getLocationQueryCount());
    assertEquals(0, options.getURIPathCount());
    assertEquals(0, options2.getURIPathCount());
    assertEquals(0, requestOptions.getURIPathCount());
    assertEquals(0, options.getURIQueryCount());
    assertEquals(0, options2.getURIQueryCount());
    assertEquals(0, requestOptions.getURIQueryCount());
    assertEquals(0, requestOptions.getUriQueryParameter().size());
    assertEquals(0, coapExchange.getRequestPayloadSize());
    assertEquals(0L, response.getNanoTimestamp());
    assertEquals(0L, response2.getNanoTimestamp());
    assertEquals(60L, options.getMaxAge().longValue());
    assertEquals(60L, options2.getMaxAge().longValue());
    assertEquals(60L, requestOptions.getMaxAge().longValue());
    assertEquals(Code.DELETE, coapExchange.getRequestCode());
    assertEquals(ResponseCode._UNKNOWN_SUCCESS_CODE, response.getCode());
    assertEquals(ResponseCode._UNKNOWN_SUCCESS_CODE, response2.getCode());
    assertFalse(response.hasMID());
    assertFalse(response2.hasMID());
    assertFalse(response.isAcknowledged());
    assertFalse(response2.isAcknowledged());
    assertFalse(response.isCanceled());
    assertFalse(response2.isCanceled());
    assertFalse(response.isConfirmable());
    assertFalse(response2.isConfirmable());
    assertFalse(response.isDuplicate());
    assertFalse(response2.isDuplicate());
    assertFalse(response.isRejected());
    assertFalse(response2.isRejected());
    assertFalse(response.isSent());
    assertFalse(response2.isSent());
    assertFalse(response.isTimedOut());
    assertFalse(response2.isTimedOut());
    assertFalse(response.isUnintendedPayload());
    assertFalse(response2.isUnintendedPayload());
    assertFalse(options.hasAccept());
    assertFalse(options2.hasAccept());
    assertFalse(requestOptions.hasAccept());
    assertFalse(options.hasBlock1());
    assertFalse(options2.hasBlock1());
    assertFalse(requestOptions.hasBlock1());
    assertFalse(options.hasBlock2());
    assertFalse(options2.hasBlock2());
    assertFalse(requestOptions.hasBlock2());
    assertFalse(options.hasContentFormat());
    assertFalse(options2.hasContentFormat());
    assertFalse(requestOptions.hasContentFormat());
    assertFalse(options.hasIfNoneMatch());
    assertFalse(options2.hasIfNoneMatch());
    assertFalse(requestOptions.hasIfNoneMatch());
    assertFalse(options.hasMaxAge());
    assertFalse(options2.hasMaxAge());
    assertFalse(requestOptions.hasMaxAge());
    assertFalse(options.hasNoResponse());
    assertFalse(options2.hasNoResponse());
    assertFalse(requestOptions.hasNoResponse());
    assertFalse(options.hasObserve());
    assertFalse(options2.hasObserve());
    assertFalse(requestOptions.hasObserve());
    assertFalse(options.hasOscore());
    assertFalse(options2.hasOscore());
    assertFalse(requestOptions.hasOscore());
    assertFalse(options.hasProxyScheme());
    assertFalse(options2.hasProxyScheme());
    assertFalse(requestOptions.hasProxyScheme());
    assertFalse(options.hasProxyUri());
    assertFalse(options2.hasProxyUri());
    assertFalse(requestOptions.hasProxyUri());
    assertFalse(options.hasSize1());
    assertFalse(options2.hasSize1());
    assertFalse(requestOptions.hasSize1());
    assertFalse(options.hasSize2());
    assertFalse(options2.hasSize2());
    assertFalse(requestOptions.hasSize2());
    assertFalse(options.hasUriHost());
    assertFalse(options2.hasUriHost());
    assertFalse(requestOptions.hasUriHost());
    assertFalse(options.hasUriPort());
    assertFalse(options2.hasUriPort());
    assertFalse(requestOptions.hasUriPort());
    assertFalse(response.hasBlockOption());
    assertFalse(response2.hasBlockOption());
    assertFalse(response.isClientError());
    assertFalse(response2.isClientError());
    assertFalse(response.isError());
    assertFalse(response2.isError());
    assertFalse(response.isInternal());
    assertFalse(response2.isInternal());
    assertFalse(response.isNotification());
    assertFalse(response2.isNotification());
    assertFalse(response.isServerError());
    assertFalse(response2.isServerError());
    assertFalse(coapExchange.isMulticastRequest());
    assertTrue(response.getMessageObservers().isEmpty());
    assertTrue(options.getETags().isEmpty());
    assertTrue(options2.getETags().isEmpty());
    assertTrue(requestOptions.getETags().isEmpty());
    assertTrue(options.getIfMatch().isEmpty());
    assertTrue(options2.getIfMatch().isEmpty());
    assertTrue(requestOptions.getIfMatch().isEmpty());
    assertTrue(options.getLocationPath().isEmpty());
    assertTrue(options2.getLocationPath().isEmpty());
    assertTrue(requestOptions.getLocationPath().isEmpty());
    assertTrue(options.getLocationQuery().isEmpty());
    assertTrue(options2.getLocationQuery().isEmpty());
    assertTrue(requestOptions.getLocationQuery().isEmpty());
    assertTrue(options.getUriPath().isEmpty());
    assertTrue(options2.getUriPath().isEmpty());
    assertTrue(requestOptions.getUriPath().isEmpty());
    assertTrue(options.getUriQuery().isEmpty());
    assertTrue(options2.getUriQuery().isEmpty());
    assertTrue(requestOptions.getUriQuery().isEmpty());
    assertTrue(response.hasEmptyToken());
    assertTrue(response2.hasEmptyToken());
    assertTrue(response.isIntendedPayload());
    assertTrue(response2.isIntendedPayload());
    assertTrue(response.isSuccess());
    assertTrue(response2.isSuccess());
    assertEquals(Double.SIZE, response.getRawCode());
    assertEquals(Double.SIZE, response2.getRawCode());
    assertArrayEquals(new byte[] {}, coapExchange.getRequestPayload());
  }
}
