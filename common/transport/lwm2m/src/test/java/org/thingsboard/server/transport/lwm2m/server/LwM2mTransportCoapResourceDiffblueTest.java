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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.network.Exchange.Origin;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.core.server.resources.Resource;
import org.eclipse.californium.elements.AddressEndpointContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.cache.ota.OtaPackageDataCache;

class LwM2mTransportCoapResourceDiffblueTest {
  /**
   * Test {@link LwM2mTransportCoapResource#LwM2mTransportCoapResource(OtaPackageDataCache,
   * String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Path is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * LwM2mTransportCoapResource#LwM2mTransportCoapResource(OtaPackageDataCache, String)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mTransportCoapResource(OtaPackageDataCache, String); when 'null'; then return Path is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mTransportCoapResource.<init>(OtaPackageDataCache, String)"})
  void testNewLwM2mTransportCoapResource_whenNull_thenReturnPathIsEmptyString() {
    // Arrange and Act
    LwM2mTransportCoapResource actualLwM2mTransportCoapResource =
        new LwM2mTransportCoapResource(null, "Name");

    // Assert
    assertEquals("", actualLwM2mTransportCoapResource.getPath());
    assertEquals("Name", actualLwM2mTransportCoapResource.getName());
    assertEquals("Name", actualLwM2mTransportCoapResource.getURI());
    assertNull(actualLwM2mTransportCoapResource.getExecutor());
    assertNull(actualLwM2mTransportCoapResource.getObserveType());
    assertNull(actualLwM2mTransportCoapResource.getParent());
    assertEquals(0, actualLwM2mTransportCoapResource.getNotificationSequenceNumber());
    assertEquals(0, actualLwM2mTransportCoapResource.getObserverCount());
    assertTrue(actualLwM2mTransportCoapResource.getChildren().isEmpty());
    assertTrue(actualLwM2mTransportCoapResource.isCachable());
    assertTrue(actualLwM2mTransportCoapResource.isObservable());
    assertTrue(actualLwM2mTransportCoapResource.isVisible());
  }

  /**
   * Test {@link LwM2mTransportCoapResource#checkObserveRelation(Exchange, Response)}.
   *
   * <ul>
   *   <li>Then calls {@link Request#getSourceContext()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportCoapResource#checkObserveRelation(Exchange,
   * Response)}
   */
  @Test
  @DisplayName("Test checkObserveRelation(Exchange, Response); then calls getSourceContext()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mTransportCoapResource.checkObserveRelation(Exchange, Response)"})
  void testCheckObserveRelation_thenCallsGetSourceContext() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource =
        new LwM2mTransportCoapResource(null, "Name");

    Request request = mock(Request.class);
    when(request.isObserve()).thenReturn(true);
    when(request.getTokenString()).thenReturn("ABC123");
    when(request.getSourceContext()).thenReturn(new AddressEndpointContext("42", 8080));
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    lwM2mTransportCoapResource.checkObserveRelation(
        exchange, new Response(ResponseCode._UNKNOWN_SUCCESS_CODE));

    // Assert
    verify(request, atLeast(1)).getSourceContext();
    verify(request).getTokenString();
    verify(request).isObserve();
  }

  /**
   * Test {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then calls {@link OptionSet#getUriPath()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandleGet(CoapExchange); given ArrayList() add '42'; then calls getUriPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mTransportCoapResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet_givenArrayListAdd42_thenCallsGetUriPath() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource =
        new LwM2mTransportCoapResource(null, "Name");

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("42");
    stringList.add("processHandleGet [{}]");

    OptionSet optionSet = mock(OptionSet.class);
    when(optionSet.getUriPath()).thenReturn(stringList);

    CoapExchange exchange = mock(CoapExchange.class);
    when(exchange.getRequestOptions()).thenReturn(optionSet);

    // Act
    lwM2mTransportCoapResource.processHandleGet(exchange);

    // Assert
    verify(optionSet).getUriPath();
    verify(exchange).getRequestOptions();
  }

  /**
   * Test {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}.
   *
   * <ul>
   *   <li>Given newDelete.
   *   <li>Then calls {@link Exchange#getRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandleGet(CoapExchange); given newDelete; then calls getRequest()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mTransportCoapResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet_givenNewDelete_thenCallsGetRequest() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource =
        new LwM2mTransportCoapResource(null, "Name");

    Exchange exchange = mock(Exchange.class);
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    // Act
    lwM2mTransportCoapResource.processHandleGet(new CoapExchange(exchange));

    // Assert
    verify(exchange).getRequest();
  }

  /**
   * Test {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()} addUriPath {@code processHandleGet [{}]}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandleGet(CoapExchange); given OptionSet() addUriPath 'processHandleGet [{}]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mTransportCoapResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet_givenOptionSetAddUriPathProcessHandleGet() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource =
        new LwM2mTransportCoapResource(null, "Name");

    OptionSet optionSet = new OptionSet();
    optionSet.addUriPath("processHandleGet [{}]");

    Request request = mock(Request.class);
    when(request.isObserve()).thenReturn(true);
    when(request.getOptions()).thenReturn(optionSet);
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    lwM2mTransportCoapResource.processHandleGet(new CoapExchange(exchange));

    // Assert
    verify(request).getOptions();
    verify(request).isObserve();
  }

  /**
   * Test {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@link OptionSet} {@link OptionSet#getUriPath()} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then calls {@link OptionSet#getUriPath()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandleGet(CoapExchange); given OptionSet getUriPath() return ArrayList(); then calls getUriPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mTransportCoapResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet_givenOptionSetGetUriPathReturnArrayList_thenCallsGetUriPath() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource =
        new LwM2mTransportCoapResource(null, "Name");

    OptionSet optionSet = mock(OptionSet.class);
    when(optionSet.getUriPath()).thenReturn(new ArrayList<>());

    CoapExchange exchange = mock(CoapExchange.class);
    when(exchange.getRequestOptions()).thenReturn(optionSet);

    // Act
    lwM2mTransportCoapResource.processHandleGet(exchange);

    // Assert
    verify(optionSet).getUriPath();
    verify(exchange).getRequestOptions();
  }

  /**
   * Test {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}.
   *
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()}.
   *   <li>Then calls {@link Request#getOptions()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandleGet(CoapExchange); given OptionSet(); then calls getOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mTransportCoapResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet_givenOptionSet_thenCallsGetOptions() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource =
        new LwM2mTransportCoapResource(null, "Name");

    Request request = mock(Request.class);
    when(request.isObserve()).thenReturn(true);
    when(request.getOptions()).thenReturn(new OptionSet());
    Exchange exchange = new Exchange(request, "Peers Identity", Origin.LOCAL, mock(Executor.class));

    // Act
    lwM2mTransportCoapResource.processHandleGet(new CoapExchange(exchange));

    // Assert
    verify(request).getOptions();
    verify(request).isObserve();
  }

  /**
   * Test {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}.
   *
   * <ul>
   *   <li>When {@link CoapExchange} {@link CoapExchange#getRequestOptions()} return {@link
   *       OptionSet#OptionSet()}.
   * </ul>
   *
   * <p>Method under test: {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName(
      "Test processHandleGet(CoapExchange); when CoapExchange getRequestOptions() return OptionSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2mTransportCoapResource.processHandleGet(CoapExchange)"})
  void testProcessHandleGet_whenCoapExchangeGetRequestOptionsReturnOptionSet() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource =
        new LwM2mTransportCoapResource(null, "Name");

    CoapExchange exchange = mock(CoapExchange.class);
    when(exchange.getRequestOptions()).thenReturn(new OptionSet());

    // Act
    lwM2mTransportCoapResource.processHandleGet(exchange);

    // Assert
    verify(exchange).getRequestOptions();
  }

  /**
   * Test {@link LwM2mTransportCoapResource#getChild(String)}.
   *
   * <p>Method under test: {@link LwM2mTransportCoapResource#getChild(String)}
   */
  @Test
  @DisplayName("Test getChild(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Resource LwM2mTransportCoapResource.getChild(String)"})
  void testGetChild() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource =
        new LwM2mTransportCoapResource(null, "Name");

    // Act
    Resource actualChild = lwM2mTransportCoapResource.getChild("Name");

    // Assert
    assertSame(lwM2mTransportCoapResource, actualChild);
  }
}
