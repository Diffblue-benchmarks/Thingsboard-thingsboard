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
package org.thingsboard.server.transport.lwm2m.server;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.junit.jupiter.api.Test;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.thingsboard.server.cache.ota.CaffeineOtaPackageCache;

class AbstractLwM2mTransportResourceDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractLwM2mTransportResource#handleGET(CoapExchange)}
   */
  @Test
  void testHandleGET() {
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
   * Method under test:
   * {@link AbstractLwM2mTransportResource#handleGET(CoapExchange)}
   */
  @Test
  void testHandleGET2() {
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
