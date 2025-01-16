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
import org.eclipse.californium.core.coap.Message;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.observe.ObserveRelation;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.core.server.resources.ResourceAttributes;
import org.eclipse.californium.elements.AddressEndpointContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.thingsboard.server.cache.ota.CaffeineOtaPackageCache;
import org.thingsboard.server.cache.ota.OtaPackageDataCache;

class LwM2mTransportCoapResourceDiffblueTest {
  /**
   * Test
   * {@link LwM2mTransportCoapResource#LwM2mTransportCoapResource(OtaPackageDataCache, String)}.
   * <p>
   * Method under test:
   * {@link LwM2mTransportCoapResource#LwM2mTransportCoapResource(OtaPackageDataCache, String)}
   */
  @Test
  @DisplayName("Test new LwM2mTransportCoapResource(OtaPackageDataCache, String)")
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
   * Test
   * {@link LwM2mTransportCoapResource#LwM2mTransportCoapResource(OtaPackageDataCache, String)}.
   * <ul>
   *   <li>Given {@link CacheLoader}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mTransportCoapResource#LwM2mTransportCoapResource(OtaPackageDataCache, String)}
   */
  @Test
  @DisplayName("Test new LwM2mTransportCoapResource(OtaPackageDataCache, String); given CacheLoader")
  void testNewLwM2mTransportCoapResource_givenCacheLoader() {
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

  /**
   * Test
   * {@link LwM2mTransportCoapResource#checkObserveRelation(Exchange, Response)}.
   * <p>
   * Method under test:
   * {@link LwM2mTransportCoapResource#checkObserveRelation(Exchange, Response)}
   */
  @Test
  @DisplayName("Test checkObserveRelation(Exchange, Response)")
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
    assertFalse(response.getOptions().hasObserve());
    assertFalse(response.isNotification());
  }

  /**
   * Test
   * {@link LwM2mTransportCoapResource#checkObserveRelation(Exchange, Response)}.
   * <ul>
   *   <li>Given {@link ObserveRelation} {@link ObserveRelation#isCanceled()} return
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mTransportCoapResource#checkObserveRelation(Exchange, Response)}
   */
  @Test
  @DisplayName("Test checkObserveRelation(Exchange, Response); given ObserveRelation isCanceled() return 'true'")
  void testCheckObserveRelation_givenObserveRelationIsCanceledReturnTrue() {
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
   * Test
   * {@link LwM2mTransportCoapResource#checkObserveRelation(Exchange, Response)}.
   * <ul>
   *   <li>Then calls {@link Message#getTokenString()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mTransportCoapResource#checkObserveRelation(Exchange, Response)}
   */
  @Test
  @DisplayName("Test checkObserveRelation(Exchange, Response); then calls getTokenString()")
  void testCheckObserveRelation_thenCallsGetTokenString() {
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
    assertFalse(response.getOptions().hasObserve());
    assertFalse(response.isNotification());
  }

  /**
   * Test
   * {@link LwM2mTransportCoapResource#checkObserveRelation(Exchange, Response)}.
   * <ul>
   *   <li>Then calls {@link ObserveRelation#isEstablished()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mTransportCoapResource#checkObserveRelation(Exchange, Response)}
   */
  @Test
  @DisplayName("Test checkObserveRelation(Exchange, Response); then calls isEstablished()")
  void testCheckObserveRelation_thenCallsIsEstablished() {
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
   * Test {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}.
   * <ul>
   *   <li>Given newDelete.</li>
   *   <li>Then calls {@link Exchange#getRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandleGet(CoapExchange); given newDelete; then calls getRequest()")
  void testProcessHandleGet_givenNewDelete_thenCallsGetRequest() {
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
   * Test {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}.
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()} addUriPath {@code processHandleGet
   * [{}]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandleGet(CoapExchange); given OptionSet() addUriPath 'processHandleGet [{}]'")
  void testProcessHandleGet_givenOptionSetAddUriPathProcessHandleGet() {
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
   * Test {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}.
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()}.</li>
   *   <li>Then calls {@link Message#getOptions()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mTransportCoapResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandleGet(CoapExchange); given OptionSet(); then calls getOptions()")
  void testProcessHandleGet_givenOptionSet_thenCallsGetOptions() {
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
   * Test {@link LwM2mTransportCoapResource#getChild(String)}.
   * <p>
   * Method under test: {@link LwM2mTransportCoapResource#getChild(String)}
   */
  @Test
  @DisplayName("Test getChild(String)")
  void testGetChild() {
    // Arrange
    LwM2mTransportCoapResource lwM2mTransportCoapResource = new LwM2mTransportCoapResource(
        new CaffeineOtaPackageCache(new CaffeineCacheManager()), "Name");

    // Act and Assert
    assertSame(lwM2mTransportCoapResource, lwM2mTransportCoapResource.getChild("Name"));
  }
}
