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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.github.benmanes.caffeine.cache.CacheLoader;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.observe.ObserveRelation;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.core.server.resources.ResourceAttributes;
import org.eclipse.californium.elements.AddressEndpointContext;
import org.junit.jupiter.api.Test;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.thingsboard.server.cache.ota.CaffeineOtaPackageCache;
import org.thingsboard.server.cache.ota.OtaPackageDataCache;

class LwM2mTransportCoapResourceDiffblueTest {
  /**
   * Method under test:
   * {@link LwM2mTransportCoapResource#checkObserveRelation(Exchange, Response)}
   */
  @Test
  void testCheckObserveRelation() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource = new LwM2mTransportCoapResource(
        new CaffeineOtaPackageCache(new CaffeineCacheManager()), "Name");
    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));

    Response response = new Response(CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    lwM2mTransportCoapResource.checkObserveRelation(exchange, response);

    // Assert that nothing has changed
    assertEquals(0, lwM2mTransportCoapResource.getObserverCount());
    assertFalse(response.getOptions().hasObserve());
    assertFalse(response.isNotification());
  }

  /**
   * Method under test:
   * {@link LwM2mTransportCoapResource#checkObserveRelation(Exchange, Response)}
   */
  @Test
  void testCheckObserveRelation2() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource = new LwM2mTransportCoapResource(
        new CaffeineOtaPackageCache(new CaffeineCacheManager()), "Name");
    Request request = mock(Request.class);
    when(request.isObserve()).thenReturn(true);
    when(request.getTokenString()).thenReturn("ABC123");
    when(request.getSourceContext()).thenReturn(new AddressEndpointContext("42", 8080));
    Exchange exchange = new Exchange(request, "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class));

    Response response = new Response(CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    lwM2mTransportCoapResource.checkObserveRelation(exchange, response);

    // Assert that nothing has changed
    verify(request, atLeast(1)).getSourceContext();
    verify(request).getTokenString();
    verify(request).isObserve();
    assertEquals(0, lwM2mTransportCoapResource.getObserverCount());
    assertFalse(response.getOptions().hasObserve());
    assertFalse(response.isNotification());
  }

  /**
   * Method under test:
   * {@link LwM2mTransportCoapResource#checkObserveRelation(Exchange, Response)}
   */
  @Test
  void testCheckObserveRelation3() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource = new LwM2mTransportCoapResource(
        new CaffeineOtaPackageCache(new CaffeineCacheManager()), "Name");
    ObserveRelation observeRelation = mock(ObserveRelation.class);
    when(observeRelation.isCanceled()).thenReturn(true);
    Exchange exchange = mock(Exchange.class);
    when(exchange.getRelation()).thenReturn(observeRelation);
    when(exchange.getRequest()).thenReturn(Request.newDelete());
    Response response = new Response(CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    lwM2mTransportCoapResource.checkObserveRelation(exchange, response);

    // Assert that nothing has changed
    verify(exchange).getRelation();
    verify(exchange).getRequest();
    verify(observeRelation).isCanceled();
    assertEquals(0, lwM2mTransportCoapResource.getObserverCount());
    assertFalse(response.getOptions().hasObserve());
    assertFalse(response.isNotification());
  }

  /**
   * Method under test:
   * {@link LwM2mTransportCoapResource#checkObserveRelation(Exchange, Response)}
   */
  @Test
  void testCheckObserveRelation4() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource = new LwM2mTransportCoapResource(
        new CaffeineOtaPackageCache(new CaffeineCacheManager()), "Name");
    ObserveRelation observeRelation = mock(ObserveRelation.class);
    when(observeRelation.isCanceled()).thenReturn(false);
    when(observeRelation.isEstablished()).thenReturn(true);
    Exchange exchange = mock(Exchange.class);
    when(exchange.getRelation()).thenReturn(observeRelation);
    when(exchange.getRequest()).thenReturn(Request.newDelete());
    Response response = new Response(CoAP.ResponseCode._UNKNOWN_SUCCESS_CODE);

    // Act
    lwM2mTransportCoapResource.checkObserveRelation(exchange, response);

    // Assert
    verify(exchange).getRelation();
    verify(exchange).getRequest();
    verify(observeRelation).isCanceled();
    verify(observeRelation).isEstablished();
    OptionSet options = response.getOptions();
    assertEquals(0, options.getObserve().intValue());
    assertEquals(0, lwM2mTransportCoapResource.getObserverCount());
    assertTrue(options.hasObserve());
    assertTrue(response.isNotification());
  }

  /**
   * Method under test:
   * {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}
   */
  @Test
  void testProcessHandleGet() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource = new LwM2mTransportCoapResource(
        new CaffeineOtaPackageCache(new CaffeineCacheManager()), "Name");
    Request request = mock(Request.class);
    when(request.isObserve()).thenReturn(true);
    when(request.getOptions()).thenReturn(new OptionSet());

    CoapExchange exchange = new CoapExchange(
        new Exchange(request, "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class)));
    exchange.setLocationPath("/");
    exchange.setLocationQuery(null);
    exchange.setMaxAge(60L);
    exchange.setETag(null);

    // Act
    lwM2mTransportCoapResource.processHandleGet(exchange);

    // Assert
    verify(request).getOptions();
    verify(request).isObserve();
  }

  /**
   * Method under test:
   * {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}
   */
  @Test
  void testProcessHandleGet2() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource = new LwM2mTransportCoapResource(
        new CaffeineOtaPackageCache(new CaffeineCacheManager()), "Name");

    OptionSet optionSet = new OptionSet();
    optionSet.addUriPath("processHandleGet [{}]");
    Request request = mock(Request.class);
    when(request.isObserve()).thenReturn(true);
    when(request.getOptions()).thenReturn(optionSet);

    CoapExchange exchange = new CoapExchange(
        new Exchange(request, "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class)));
    exchange.setLocationPath("/");
    exchange.setLocationQuery(null);
    exchange.setMaxAge(60L);
    exchange.setETag(null);

    // Act
    lwM2mTransportCoapResource.processHandleGet(exchange);

    // Assert that nothing has changed
    verify(request).getOptions();
    verify(request).isObserve();
  }

  /**
   * Method under test:
   * {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}
   */
  @Test
  void testProcessHandleGet3() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource = new LwM2mTransportCoapResource(
        new CaffeineOtaPackageCache(new CaffeineCacheManager()), "Name");
    Exchange exchange = mock(Exchange.class);
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("/");
    exchange2.setLocationQuery(null);
    exchange2.setMaxAge(60L);
    exchange2.setETag(null);

    // Act
    lwM2mTransportCoapResource.processHandleGet(exchange2);

    // Assert
    verify(exchange).getRequest();
  }

  /**
   * Method under test: {@link LwM2mTransportCoapResource#getChild(String)}
   */
  @Test
  void testGetChild() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource = new LwM2mTransportCoapResource(
        new CaffeineOtaPackageCache(new CaffeineCacheManager()), "Name");

    // Act and Assert
    assertSame(lwM2mTransportCoapResource, lwM2mTransportCoapResource.getChild("Name"));
  }

  /**
   * Method under test:
   * {@link LwM2mTransportCoapResource#LwM2mTransportCoapResource(OtaPackageDataCache, String)}
   */
  @Test
  void testNewLwM2mTransportCoapResource() {
    // Arrange and Act
    LwM2mTransportCoapResource actualLwM2mTransportCoapResource = new LwM2mTransportCoapResource(
        new CaffeineOtaPackageCache(new CaffeineCacheManager()), "Name");

    // Assert
    assertEquals("", actualLwM2mTransportCoapResource.getPath());
    assertEquals("Name", actualLwM2mTransportCoapResource.getName());
    assertEquals("Name", actualLwM2mTransportCoapResource.getURI());
    ResourceAttributes attributes = actualLwM2mTransportCoapResource.getAttributes();
    assertNull(attributes.getMaximumSizeEstimate());
    assertNull(attributes.getTitle());
    assertNull(actualLwM2mTransportCoapResource.getExecutor());
    assertNull(actualLwM2mTransportCoapResource.getObserveType());
    assertNull(actualLwM2mTransportCoapResource.getParent());
    assertEquals(0, actualLwM2mTransportCoapResource.getNotificationSequenceNumber());
    assertEquals(0, actualLwM2mTransportCoapResource.getObserverCount());
    Set<String> attributeKeySet = attributes.getAttributeKeySet();
    assertEquals(1, attributeKeySet.size());
    assertEquals(1, attributes.getCount());
    assertFalse(attributes.hasOscoreOnly());
    assertTrue(actualLwM2mTransportCoapResource.getChildren().isEmpty());
    List<String> contentTypes = attributes.getContentTypes();
    assertTrue(contentTypes.isEmpty());
    assertTrue(attributeKeySet.contains("obs"));
    assertTrue(actualLwM2mTransportCoapResource.isCachable());
    assertTrue(actualLwM2mTransportCoapResource.isObservable());
    assertTrue(actualLwM2mTransportCoapResource.isVisible());
    assertTrue(attributes.hasObservable());
    assertSame(contentTypes, attributes.getInterfaceDescriptions());
    assertSame(contentTypes, attributes.getResourceTypes());
  }

  /**
   * Method under test:
   * {@link LwM2mTransportCoapResource#LwM2mTransportCoapResource(OtaPackageDataCache, String)}
   */
  @Test
  void testNewLwM2mTransportCoapResource2() {
    // Arrange
    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    cacheManager.setCacheLoader(mock(CacheLoader.class));

    // Act
    LwM2mTransportCoapResource actualLwM2mTransportCoapResource = new LwM2mTransportCoapResource(
        new CaffeineOtaPackageCache(cacheManager), "Name");

    // Assert
    assertEquals("", actualLwM2mTransportCoapResource.getPath());
    assertEquals("Name", actualLwM2mTransportCoapResource.getName());
    assertEquals("Name", actualLwM2mTransportCoapResource.getURI());
    ResourceAttributes attributes = actualLwM2mTransportCoapResource.getAttributes();
    assertNull(attributes.getMaximumSizeEstimate());
    assertNull(attributes.getTitle());
    assertNull(actualLwM2mTransportCoapResource.getExecutor());
    assertNull(actualLwM2mTransportCoapResource.getObserveType());
    assertNull(actualLwM2mTransportCoapResource.getParent());
    assertEquals(0, actualLwM2mTransportCoapResource.getNotificationSequenceNumber());
    assertEquals(0, actualLwM2mTransportCoapResource.getObserverCount());
    Set<String> attributeKeySet = attributes.getAttributeKeySet();
    assertEquals(1, attributeKeySet.size());
    assertEquals(1, attributes.getCount());
    assertFalse(attributes.hasOscoreOnly());
    assertTrue(actualLwM2mTransportCoapResource.getChildren().isEmpty());
    List<String> contentTypes = attributes.getContentTypes();
    assertTrue(contentTypes.isEmpty());
    assertTrue(attributeKeySet.contains("obs"));
    assertTrue(actualLwM2mTransportCoapResource.isCachable());
    assertTrue(actualLwM2mTransportCoapResource.isObservable());
    assertTrue(actualLwM2mTransportCoapResource.isVisible());
    assertTrue(attributes.hasObservable());
    assertSame(contentTypes, attributes.getInterfaceDescriptions());
    assertSame(contentTypes, attributes.getResourceTypes());
  }
}
