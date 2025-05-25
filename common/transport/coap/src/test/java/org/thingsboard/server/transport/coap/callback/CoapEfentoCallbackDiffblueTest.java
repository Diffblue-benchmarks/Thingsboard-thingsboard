package org.thingsboard.server.transport.coap.callback;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAP.Code;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.Exchange.Origin;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CoapEfentoCallbackDiffblueTest {
  /**
   * Test {@link CoapEfentoCallback#CoapEfentoCallback(CoapExchange, ResponseCode, ResponseCode)}.
   * <p>
   * Method under test: {@link CoapEfentoCallback#CoapEfentoCallback(CoapExchange, ResponseCode, ResponseCode)}
   */
  @Test
  @DisplayName("Test new CoapEfentoCallback(CoapExchange, ResponseCode, ResponseCode)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CoapEfentoCallback.<init>(CoapExchange, ResponseCode, ResponseCode)"})
  void testNewCoapEfentoCallback() {
    // Arrange, Act and Assert
    CoapExchange coapExchange = (new CoapEfentoCallback(
        new CoapExchange(new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class))),
        ResponseCode._UNKNOWN_SUCCESS_CODE, ResponseCode._UNKNOWN_SUCCESS_CODE)).exchange;
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
    assertArrayEquals(new byte[]{}, coapExchange.getRequestPayload());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CoapEfentoCallback.isConRequest()"})
  void testIsConRequest_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new CoapEfentoCallback(
        new CoapExchange(new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class))),
        ResponseCode._UNKNOWN_SUCCESS_CODE, ResponseCode._UNKNOWN_SUCCESS_CODE)).isConRequest());
  }
}
