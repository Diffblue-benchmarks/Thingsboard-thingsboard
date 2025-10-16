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
package org.thingsboard.server.transport.coap;

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
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.Exchange.Origin;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.transport.coap.efento.CoapEfentoTransportResource;

class AbstractCoapTransportResourceDiffblueTest {
  /**
   * Test {@link AbstractCoapTransportResource#handleGET(CoapExchange)}.
   *
   * <p>Method under test: {@link AbstractCoapTransportResource#handleGET(CoapExchange)}
   */
  @Test
  @DisplayName("Test handleGET(CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractCoapTransportResource.handleGET(CoapExchange)"})
  void testHandleGET() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    CoapExchange exchange = mock(CoapExchange.class);
    doNothing().when(exchange).respond(Mockito.<ResponseCode>any());
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    when(exchange.advanced()).thenReturn(exchange2);

    // Act
    coapEfentoTransportResource.handleGET(exchange);

    // Assert
    verify(exchange).advanced();
    verify(exchange).respond(ResponseCode.BAD_REQUEST);
  }

  /**
   * Test {@link AbstractCoapTransportResource#handleGET(CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@link Exchange} {@link Exchange#getRequest()} return newDelete.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoapTransportResource#handleGET(CoapExchange)}
   */
  @Test
  @DisplayName("Test handleGET(CoapExchange); given Exchange getRequest() return newDelete")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractCoapTransportResource.handleGET(CoapExchange)"})
  void testHandleGET_givenExchangeGetRequestReturnNewDelete() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    Exchange exchange = mock(Exchange.class);
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    CoapExchange exchange2 = mock(CoapExchange.class);
    doNothing().when(exchange2).respond(Mockito.<ResponseCode>any());
    when(exchange2.advanced()).thenReturn(exchange);

    // Act
    coapEfentoTransportResource.handleGET(exchange2);

    // Assert
    verify(exchange).getRequest();
    verify(exchange2).advanced();
    verify(exchange2).respond(ResponseCode.BAD_REQUEST);
  }

  /**
   * Test {@link AbstractCoapTransportResource#handleGET(CoapExchange)}.
   *
   * <ul>
   *   <li>Given newDelete.
   *   <li>Then calls {@link Exchange#getCurrentRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoapTransportResource#handleGET(CoapExchange)}
   */
  @Test
  @DisplayName("Test handleGET(CoapExchange); given newDelete; then calls getCurrentRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractCoapTransportResource.handleGET(CoapExchange)"})
  void testHandleGET_givenNewDelete_thenCallsGetCurrentRequest() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    // Act
    coapEfentoTransportResource.handleGET(new CoapExchange(exchange));

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}.
   *
   * <p>Method under test: {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}
   */
  @Test
  @DisplayName("Test handlePOST(CoapExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractCoapTransportResource.handlePOST(CoapExchange)"})
  void testHandlePOST() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    CoapExchange exchange = mock(CoapExchange.class);
    doNothing().when(exchange).respond(Mockito.<ResponseCode>any());
    Exchange exchange2 =
        new Exchange(Request.newDelete(), "Peers Identity", Origin.LOCAL, mock(Executor.class));
    when(exchange.advanced()).thenReturn(exchange2);

    // Act
    coapEfentoTransportResource.handlePOST(exchange);

    // Assert
    verify(exchange).advanced();
    verify(exchange).respond(ResponseCode.BAD_REQUEST);
  }

  /**
   * Test {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@link Exchange} {@link Exchange#getRequest()} return newDelete.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}
   */
  @Test
  @DisplayName("Test handlePOST(CoapExchange); given Exchange getRequest() return newDelete")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractCoapTransportResource.handlePOST(CoapExchange)"})
  void testHandlePOST_givenExchangeGetRequestReturnNewDelete() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    Exchange exchange = mock(Exchange.class);
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    CoapExchange exchange2 = mock(CoapExchange.class);
    doNothing().when(exchange2).respond(Mockito.<ResponseCode>any());
    when(exchange2.advanced()).thenReturn(exchange);

    // Act
    coapEfentoTransportResource.handlePOST(exchange2);

    // Assert
    verify(exchange).getRequest();
    verify(exchange2).advanced();
    verify(exchange2).respond(ResponseCode.BAD_REQUEST);
  }

  /**
   * Test {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}.
   *
   * <ul>
   *   <li>Given newDelete.
   *   <li>Then calls {@link Exchange#getCurrentRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}
   */
  @Test
  @DisplayName("Test handlePOST(CoapExchange); given newDelete; then calls getCurrentRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractCoapTransportResource.handlePOST(CoapExchange)"})
  void testHandlePOST_givenNewDelete_thenCallsGetCurrentRequest() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource =
        new CoapEfentoTransportResource(new CoapTransportContext(), "Name");

    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    // Act
    coapEfentoTransportResource.handlePOST(new CoapExchange(exchange));

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
  }
}
