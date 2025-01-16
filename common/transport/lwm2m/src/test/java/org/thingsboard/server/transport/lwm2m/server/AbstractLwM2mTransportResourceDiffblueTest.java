package org.thingsboard.server.transport.lwm2m.server;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.thingsboard.server.cache.ota.CaffeineOtaPackageCache;

class AbstractLwM2mTransportResourceDiffblueTest {
  /**
   * Test {@link AbstractLwM2mTransportResource#handleGET(CoapExchange)}.
   * <ul>
   *   <li>Given newDelete.</li>
   *   <li>Then calls {@link Exchange#getRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLwM2mTransportResource#handleGET(CoapExchange)}
   */
  @Test
  @DisplayName("Test handleGET(CoapExchange); given newDelete; then calls getRequest()")
  void testHandleGET_givenNewDelete_thenCallsGetRequest() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource = new LwM2mTransportCoapResource(
        new CaffeineOtaPackageCache(new CaffeineCacheManager()), "Name");
    Exchange exchange = mock(Exchange.class);
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    // Act
    lwM2mTransportCoapResource.handleGET(new CoapExchange(exchange));

    // Assert
    verify(exchange).getRequest();
  }

  /**
   * Test {@link AbstractLwM2mTransportResource#handleGET(CoapExchange)}.
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()}.</li>
   *   <li>Then calls {@link CoapExchange#getRequestOptions()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractLwM2mTransportResource#handleGET(CoapExchange)}
   */
  @Test
  @DisplayName("Test handleGET(CoapExchange); given OptionSet(); then calls getRequestOptions()")
  void testHandleGET_givenOptionSet_thenCallsGetRequestOptions() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource = new LwM2mTransportCoapResource(
        new CaffeineOtaPackageCache(new CaffeineCacheManager()), "Name");
    CoapExchange exchange = mock(CoapExchange.class);
    when(exchange.getRequestOptions()).thenReturn(new OptionSet());

    // Act
    lwM2mTransportCoapResource.handleGET(exchange);

    // Assert
    verify(exchange).getRequestOptions();
  }
}
