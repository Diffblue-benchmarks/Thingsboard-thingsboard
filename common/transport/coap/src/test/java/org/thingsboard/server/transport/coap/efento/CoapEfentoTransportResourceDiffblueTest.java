package org.thingsboard.server.transport.coap.efento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Endpoint;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.core.server.resources.ResourceAttributes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportContext;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
import org.thingsboard.server.gen.transport.coap.MeasurementsProtos;
import org.thingsboard.server.queue.common.TbRuleEngineProducerService;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory;
import org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;
import org.thingsboard.server.transport.coap.CoapTransportContext;
import org.thingsboard.server.transport.coap.efento.CoapEfentoTransportResource.EfentoTelemetry;

class CoapEfentoTransportResourceDiffblueTest {
  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}, and
   * {@link EfentoTelemetry#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CoapEfentoTransportResource.EfentoTelemetry#equals(Object)}
   *   <li>{@link CoapEfentoTransportResource.EfentoTelemetry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test EfentoTelemetry equals(Object), and hashCode(); when other is equal; then return equal")
  void testEfentoTelemetryEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(1L,
        new JsonArray(3));
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry2 = new CoapEfentoTransportResource.EfentoTelemetry(1L,
        new JsonArray(3));

    // Act and Assert
    assertEquals(efentoTelemetry, efentoTelemetry2);
    int expectedHashCodeResult = efentoTelemetry.hashCode();
    assertEquals(expectedHashCodeResult, efentoTelemetry2.hashCode());
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}, and
   * {@link EfentoTelemetry#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CoapEfentoTransportResource.EfentoTelemetry#equals(Object)}
   *   <li>{@link CoapEfentoTransportResource.EfentoTelemetry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test EfentoTelemetry equals(Object), and hashCode(); when other is equal; then return equal")
  void testEfentoTelemetryEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(1L,
        null);
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry2 = new CoapEfentoTransportResource.EfentoTelemetry(1L,
        null);

    // Act and Assert
    assertEquals(efentoTelemetry, efentoTelemetry2);
    int expectedHashCodeResult = efentoTelemetry.hashCode();
    assertEquals(expectedHashCodeResult, efentoTelemetry2.hashCode());
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}, and
   * {@link EfentoTelemetry#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CoapEfentoTransportResource.EfentoTelemetry#equals(Object)}
   *   <li>{@link CoapEfentoTransportResource.EfentoTelemetry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test EfentoTelemetry equals(Object), and hashCode(); when other is same; then return equal")
  void testEfentoTelemetryEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(1L,
        new JsonArray(3));

    // Act and Assert
    assertEquals(efentoTelemetry, efentoTelemetry);
    int expectedHashCodeResult = efentoTelemetry.hashCode();
    assertEquals(expectedHashCodeResult, efentoTelemetry.hashCode());
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapEfentoTransportResource.EfentoTelemetry#equals(Object)}
   */
  @Test
  @DisplayName("Test EfentoTelemetry equals(Object); when other is different; then return not equal")
  void testEfentoTelemetryEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(3L,
        new JsonArray(3));

    // Act and Assert
    assertNotEquals(efentoTelemetry, new CoapEfentoTransportResource.EfentoTelemetry(1L, new JsonArray(3)));
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapEfentoTransportResource.EfentoTelemetry#equals(Object)}
   */
  @Test
  @DisplayName("Test EfentoTelemetry equals(Object); when other is different; then return not equal")
  void testEfentoTelemetryEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(1L,
        null);

    // Act and Assert
    assertNotEquals(efentoTelemetry, new CoapEfentoTransportResource.EfentoTelemetry(1L, new JsonArray(3)));
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapEfentoTransportResource.EfentoTelemetry#equals(Object)}
   */
  @Test
  @DisplayName("Test EfentoTelemetry equals(Object); when other is different; then return not equal")
  void testEfentoTelemetryEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(1L,
        new JsonNull());

    // Act and Assert
    assertNotEquals(efentoTelemetry, new CoapEfentoTransportResource.EfentoTelemetry(1L, new JsonArray(3)));
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapEfentoTransportResource.EfentoTelemetry#equals(Object)}
   */
  @Test
  @DisplayName("Test EfentoTelemetry equals(Object); when other is different; then return not equal")
  void testEfentoTelemetryEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(1L,
        mock(JsonElement.class));

    // Act and Assert
    assertNotEquals(efentoTelemetry, new CoapEfentoTransportResource.EfentoTelemetry(1L, new JsonArray(3)));
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapEfentoTransportResource.EfentoTelemetry#equals(Object)}
   */
  @Test
  @DisplayName("Test EfentoTelemetry equals(Object); when other is 'null'; then return not equal")
  void testEfentoTelemetryEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CoapEfentoTransportResource.EfentoTelemetry(1L, new JsonArray(3)), null);
  }

  /**
   * Test EfentoTelemetry {@link EfentoTelemetry#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapEfentoTransportResource.EfentoTelemetry#equals(Object)}
   */
  @Test
  @DisplayName("Test EfentoTelemetry equals(Object); when other is wrong type; then return not equal")
  void testEfentoTelemetryEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CoapEfentoTransportResource.EfentoTelemetry(1L, new JsonArray(3)),
        "Different type to EfentoTelemetry");
  }

  /**
   * Test EfentoTelemetry getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CoapEfentoTransportResource.EfentoTelemetry#setTs(long)}
   *   <li>
   * {@link CoapEfentoTransportResource.EfentoTelemetry#setValues(JsonElement)}
   *   <li>{@link CoapEfentoTransportResource.EfentoTelemetry#toString()}
   *   <li>{@link CoapEfentoTransportResource.EfentoTelemetry#getTs()}
   *   <li>{@link CoapEfentoTransportResource.EfentoTelemetry#getValues()}
   * </ul>
   */
  @Test
  @DisplayName("Test EfentoTelemetry getters and setters")
  void testEfentoTelemetryGettersAndSetters() {
    // Arrange
    CoapEfentoTransportResource.EfentoTelemetry efentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(1L,
        new JsonArray(3));

    // Act
    efentoTelemetry.setTs(1L);
    JsonArray values = new JsonArray(3);
    efentoTelemetry.setValues(values);
    String actualToStringResult = efentoTelemetry.toString();
    long actualTs = efentoTelemetry.getTs();

    // Assert that nothing has changed
    assertEquals("CoapEfentoTransportResource.EfentoTelemetry(ts=1, values=[])", actualToStringResult);
    assertEquals(1L, actualTs);
    assertSame(values, efentoTelemetry.getValues());
  }

  /**
   * Test EfentoTelemetry
   * {@link EfentoTelemetry#EfentoTelemetry(long, JsonElement)}.
   * <p>
   * Method under test:
   * {@link CoapEfentoTransportResource.EfentoTelemetry#EfentoTelemetry(long, JsonElement)}
   */
  @Test
  @DisplayName("Test EfentoTelemetry new EfentoTelemetry(long, JsonElement)")
  void testEfentoTelemetryNewEfentoTelemetry() {
    // Arrange
    JsonArray values = new JsonArray(3);

    // Act
    CoapEfentoTransportResource.EfentoTelemetry actualEfentoTelemetry = new CoapEfentoTransportResource.EfentoTelemetry(
        1L, values);

    // Assert
    assertEquals(1L, actualEfentoTelemetry.getTs());
    assertSame(values, actualEfentoTelemetry.getValues());
  }

  /**
   * Test {@link CoapEfentoTransportResource#getChild(String)}.
   * <p>
   * Method under test: {@link CoapEfentoTransportResource#getChild(String)}
   */
  @Test
  @DisplayName("Test getChild(String)")
  void testGetChild() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");

    // Act and Assert
    assertSame(coapEfentoTransportResource, coapEfentoTransportResource.getChild("Name"));
  }

  /**
   * Test
   * {@link CoapEfentoTransportResource#getEfentoMeasurements(ProtoMeasurements, UUID)}.
   * <p>
   * Method under test:
   * {@link CoapEfentoTransportResource#getEfentoMeasurements(MeasurementsProtos.ProtoMeasurements, UUID)}
   */
  @Test
  @DisplayName("Test getEfentoMeasurements(ProtoMeasurements, UUID)")
  void testGetEfentoMeasurements() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    MeasurementsProtos.ProtoMeasurements protoMeasurements = MeasurementsProtos.ProtoMeasurements.getDefaultInstance();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> coapEfentoTransportResource.getEfentoMeasurements(protoMeasurements, UUID.randomUUID()));
  }

  /**
   * Test
   * {@link CoapEfentoTransportResource#CoapEfentoTransportResource(CoapTransportContext, String)}.
   * <ul>
   *   <li>Then calls {@link TransportContext#getTransportService()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapEfentoTransportResource#CoapEfentoTransportResource(CoapTransportContext, String)}
   */
  @Test
  @DisplayName("Test new CoapEfentoTransportResource(CoapTransportContext, String); then calls getTransportService()")
  void testNewCoapEfentoTransportResource_thenCallsGetTransportService() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CoapTransportContext context = mock(CoapTransportContext.class);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider = new InMemoryTbTransportQueueFactory(transportApiSettings,
        transportNotificationSettings, serviceInfoProvider2, coreSettings, storage, new TopicService());

    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings2, ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings2,
        transportNotificationSettings2, edgeSettings, new DefaultInMemoryStorage()));
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(
        new HashPartitionService(serviceInfoProvider4, tenantRoutingInfoService2, applicationEventPublisher2,
            queueRoutingInfoService2, new TopicService()));
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache = new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache = new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));

    // Act
    CoapEfentoTransportResource actualCoapEfentoTransportResource = new CoapEfentoTransportResource(context, "Name");

    // Assert
    verify(context).getTransportService();
    assertEquals("", actualCoapEfentoTransportResource.getPath());
    assertEquals("Name", actualCoapEfentoTransportResource.getName());
    assertEquals("Name", actualCoapEfentoTransportResource.getURI());
    ResourceAttributes attributes = actualCoapEfentoTransportResource.getAttributes();
    assertNull(attributes.getMaximumSizeEstimate());
    assertNull(attributes.getTitle());
    assertNull(actualCoapEfentoTransportResource.getExecutor());
    assertNull(actualCoapEfentoTransportResource.getParent());
    assertEquals(0, actualCoapEfentoTransportResource.getNotificationSequenceNumber());
    assertEquals(0, actualCoapEfentoTransportResource.getObserverCount());
    Set<String> attributeKeySet = attributes.getAttributeKeySet();
    assertEquals(1, attributeKeySet.size());
    assertEquals(1, attributes.getCount());
    assertEquals(CoAP.Type.CON, actualCoapEfentoTransportResource.getObserveType());
    assertFalse(attributes.hasOscoreOnly());
    assertTrue(actualCoapEfentoTransportResource.getChildren().isEmpty());
    List<String> contentTypes = attributes.getContentTypes();
    assertTrue(contentTypes.isEmpty());
    assertTrue(attributeKeySet.contains("obs"));
    assertTrue(actualCoapEfentoTransportResource.isCachable());
    assertTrue(actualCoapEfentoTransportResource.isObservable());
    assertTrue(actualCoapEfentoTransportResource.isVisible());
    assertTrue(attributes.hasObservable());
    assertSame(contentTypes, attributes.getInterfaceDescriptions());
    assertSame(contentTypes, attributes.getResourceTypes());
  }

  /**
   * Test
   * {@link CoapEfentoTransportResource#CoapEfentoTransportResource(CoapTransportContext, String)}.
   * <ul>
   *   <li>Then return Path is empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapEfentoTransportResource#CoapEfentoTransportResource(CoapTransportContext, String)}
   */
  @Test
  @DisplayName("Test new CoapEfentoTransportResource(CoapTransportContext, String); then return Path is empty string")
  void testNewCoapEfentoTransportResource_thenReturnPathIsEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    CoapEfentoTransportResource actualCoapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");

    // Assert
    assertEquals("", actualCoapEfentoTransportResource.getPath());
    assertEquals("Name", actualCoapEfentoTransportResource.getName());
    assertEquals("Name", actualCoapEfentoTransportResource.getURI());
    ResourceAttributes attributes = actualCoapEfentoTransportResource.getAttributes();
    assertNull(attributes.getMaximumSizeEstimate());
    assertNull(attributes.getTitle());
    assertNull(actualCoapEfentoTransportResource.getExecutor());
    assertNull(actualCoapEfentoTransportResource.getParent());
    assertEquals(0, actualCoapEfentoTransportResource.getNotificationSequenceNumber());
    assertEquals(0, actualCoapEfentoTransportResource.getObserverCount());
    Set<String> attributeKeySet = attributes.getAttributeKeySet();
    assertEquals(1, attributeKeySet.size());
    assertEquals(1, attributes.getCount());
    assertEquals(CoAP.Type.CON, actualCoapEfentoTransportResource.getObserveType());
    assertFalse(attributes.hasOscoreOnly());
    assertTrue(actualCoapEfentoTransportResource.getChildren().isEmpty());
    List<String> contentTypes = attributes.getContentTypes();
    assertTrue(contentTypes.isEmpty());
    assertTrue(attributeKeySet.contains("obs"));
    assertTrue(actualCoapEfentoTransportResource.isCachable());
    assertTrue(actualCoapEfentoTransportResource.isObservable());
    assertTrue(actualCoapEfentoTransportResource.isVisible());
    assertTrue(attributes.hasObservable());
    assertSame(contentTypes, attributes.getInterfaceDescriptions());
    assertSame(contentTypes, attributes.getResourceTypes());
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   * <p>
   * Method under test:
   * {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandleGet(CoapExchange)")
  void testProcessHandleGet() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Invalid path: [{}]");

    // Act
    coapEfentoTransportResource.processHandleGet(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   * <p>
   * Method under test:
   * {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandleGet(CoapExchange)")
  void testProcessHandleGet2() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("Invalid path: [{}]");

    // Act
    coapEfentoTransportResource.processHandleGet(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandleGet(CoapExchange); given 'A'")
  void testProcessHandleGet_givenA() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setETag(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});

    // Act
    coapEfentoTransportResource.processHandleGet(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandleGet(CoapExchange); given empty string")
  void testProcessHandleGet_givenEmptyString() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("");

    // Act
    coapEfentoTransportResource.processHandleGet(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} MaxAge is
   * two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandleGet(CoapExchange); given two; when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) MaxAge is two")
  void testProcessHandleGet_givenTwo_whenCoapExchangeWithExchangeIsExchangeMaxAgeIsTwo() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setMaxAge(2L);

    // Act
    coapEfentoTransportResource.processHandleGet(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}.
   * <ul>
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapEfentoTransportResource#processHandleGet(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandleGet(CoapExchange); when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor)")
  void testProcessHandleGet_whenCoapExchangeWithExchangeIsExchange() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    // Act
    coapEfentoTransportResource.processHandleGet(new CoapExchange(exchange));

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}.
   * <ul>
   *   <li>Then calls {@link CoapExchange#advanced()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandlePost(CoapExchange); then calls advanced()")
  void testProcessHandlePost_thenCallsAdvanced() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    new RuntimeException("foo");
    new RuntimeException("foo");
    new IllegalStateException("foo");
    CoapExchange exchange = mock(CoapExchange.class);
    doNothing().when(exchange).respond(Mockito.<CoAP.ResponseCode>any());
    when(exchange.advanced())
        .thenReturn(new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL, mock(Executor.class)));

    // Act
    coapEfentoTransportResource.processHandlePost(exchange);

    // Assert
    verify(exchange).advanced();
    verify(exchange).respond(eq(CoAP.ResponseCode.BAD_REQUEST));
  }

  /**
   * Test {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}.
   * <ul>
   *   <li>Then calls {@link Exchange#getCurrentRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapEfentoTransportResource#processHandlePost(CoapExchange)}
   */
  @Test
  @DisplayName("Test processHandlePost(CoapExchange); then calls getCurrentRequest()")
  void testProcessHandlePost_thenCallsGetCurrentRequest() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    new RuntimeException("foo");
    new RuntimeException("foo");
    Exchange exchange = mock(Exchange.class);
    doNothing().when(exchange).sendResponse(Mockito.<Response>any());
    when(exchange.getCurrentRequest()).thenReturn(Request.newDelete());
    when(exchange.getRequest()).thenReturn(Request.newDelete());

    // Act
    coapEfentoTransportResource.processHandlePost(new CoapExchange(exchange));

    // Assert
    verify(exchange).getCurrentRequest();
    verify(exchange).getRequest();
    verify(exchange).sendResponse(isA(Response.class));
  }
}
