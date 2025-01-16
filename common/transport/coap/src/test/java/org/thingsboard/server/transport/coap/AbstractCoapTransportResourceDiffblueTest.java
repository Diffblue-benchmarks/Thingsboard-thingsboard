package org.thingsboard.server.transport.coap;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Endpoint;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.common.TbRuleEngineProducerService;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfo;
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
import org.thingsboard.server.transport.coap.efento.CoapEfentoTransportResource;

class AbstractCoapTransportResourceDiffblueTest {
  /**
   * Test {@link AbstractCoapTransportResource#handleGET(CoapExchange)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCoapTransportResource#handleGET(CoapExchange)}
   */
  @Test
  @DisplayName("Test handleGET(CoapExchange); given 'A'")
  void testHandleGET_givenA() {
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
    coapEfentoTransportResource.handleGET(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handleGET(CoapExchange)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} MaxAge is
   * two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCoapTransportResource#handleGET(CoapExchange)}
   */
  @Test
  @DisplayName("Test handleGET(CoapExchange); given two; when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) MaxAge is two")
  void testHandleGET_givenTwo_whenCoapExchangeWithExchangeIsExchangeMaxAgeIsTwo() {
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
    coapEfentoTransportResource.handleGET(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handleGET(CoapExchange)}.
   * <ul>
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} LocationPath is
   * {@code Invalid path: [{}]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCoapTransportResource#handleGET(CoapExchange)}
   */
  @Test
  @DisplayName("Test handleGET(CoapExchange); when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) LocationPath is 'Invalid path: [{}]'")
  void testHandleGET_whenCoapExchangeWithExchangeIsExchangeLocationPathIsInvalidPath() {
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
    coapEfentoTransportResource.handleGET(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handleGET(CoapExchange)}.
   * <ul>
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} LocationQuery is
   * {@code Invalid path: [{}]}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCoapTransportResource#handleGET(CoapExchange)}
   */
  @Test
  @DisplayName("Test handleGET(CoapExchange); when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) LocationQuery is 'Invalid path: [{}]'")
  void testHandleGET_whenCoapExchangeWithExchangeIsExchangeLocationQueryIsInvalidPath() {
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
    coapEfentoTransportResource.handleGET(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handleGET(CoapExchange)}.
   * <ul>
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)}.</li>
   *   <li>Then calls {@link Endpoint#sendResponse(Exchange, Response)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCoapTransportResource#handleGET(CoapExchange)}
   */
  @Test
  @DisplayName("Test handleGET(CoapExchange); when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor); then calls sendResponse(Exchange, Response)")
  void testHandleGET_whenCoapExchangeWithExchangeIsExchange_thenCallsSendResponse() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    // Act
    coapEfentoTransportResource.handleGET(new CoapExchange(exchange));

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}.
   * <p>
   * Method under test:
   * {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}
   */
  @Test
  @DisplayName("Test handlePOST(CoapExchange)")
  void testHandlePOST() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationPath("Unexpected uri path size, uri path: [{}]");

    // Act
    coapEfentoTransportResource.handlePOST(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}.
   * <p>
   * Method under test:
   * {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}
   */
  @Test
  @DisplayName("Test handlePOST(CoapExchange)")
  void testHandlePOST2() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    CoapExchange exchange2 = new CoapExchange(exchange);
    exchange2.setLocationQuery("Unexpected uri path size, uri path: [{}]");

    // Act
    coapEfentoTransportResource.handlePOST(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}
   */
  @Test
  @DisplayName("Test handlePOST(CoapExchange); given 'A'")
  void testHandlePOST_givenA() {
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
    coapEfentoTransportResource.handlePOST(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)} MaxAge is
   * two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}
   */
  @Test
  @DisplayName("Test handlePOST(CoapExchange); given two; when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor) MaxAge is two")
  void testHandlePOST_givenTwo_whenCoapExchangeWithExchangeIsExchangeMaxAgeIsTwo() {
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
    coapEfentoTransportResource.handlePOST(exchange2);

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}.
   * <ul>
   *   <li>When {@link CoapExchange#CoapExchange(Exchange)} with exchange is
   * {@link Exchange#Exchange(Request, Object, Origin, Executor)}.</li>
   *   <li>Then calls {@link Endpoint#sendResponse(Exchange, Response)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCoapTransportResource#handlePOST(CoapExchange)}
   */
  @Test
  @DisplayName("Test handlePOST(CoapExchange); when CoapExchange(Exchange) with exchange is Exchange(Request, Object, Origin, Executor); then calls sendResponse(Exchange, Response)")
  void testHandlePOST_whenCoapExchangeWithExchangeIsExchange_thenCallsSendResponse() {
    // Arrange
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(
        new CoapTransportContext(), "Name");
    Endpoint endpoint = mock(Endpoint.class);
    doNothing().when(endpoint).sendResponse(Mockito.<Exchange>any(), Mockito.<Response>any());

    Exchange exchange = new Exchange(Request.newDelete(), "Peers Identity", Exchange.Origin.LOCAL,
        mock(Executor.class));
    exchange.setEndpoint(endpoint);

    // Act
    coapEfentoTransportResource.handlePOST(new CoapExchange(exchange));

    // Assert
    verify(endpoint).sendResponse(isA(Exchange.class), isA(Response.class));
  }

  /**
   * Test
   * {@link AbstractCoapTransportResource#reportSubscriptionInfo(SessionInfoProto, boolean, boolean)}.
   * <ul>
   *   <li>Then calls
   * {@link TenantRoutingInfoService#getRoutingInfo(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCoapTransportResource#reportSubscriptionInfo(TransportProtos.SessionInfoProto, boolean, boolean)}
   */
  @Test
  @DisplayName("Test reportSubscriptionInfo(SessionInfoProto, boolean, boolean); then calls getRoutingInfo(TenantId)")
  void testReportSubscriptionInfo_thenCallsGetRoutingInfo() {
    // Arrange
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any()))
        .thenReturn(new TenantRoutingInfo(new TenantId(UUID.randomUUID()), null, true));
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
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
    CoapTransportContext context = mock(CoapTransportContext.class);
    when(context.getTransportService()).thenReturn(new DefaultTransportService(partitionService, queueProvider,
        producerProvider, ruleEngineProducerService, topicService2, serviceInfoProvider5, statsFactory,
        deviceProfileCache, tenantProfileCache, rateLimitService, scheduler, eventPublisher, transportResourceCache,
        notificationRuleProcessor, new DefaultEntityLimitsCache(1, 3)));
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(context, "Name");

    // Act
    coapEfentoTransportResource.reportSubscriptionInfo(TransportProtos.SessionInfoProto.getDefaultInstance(), true,
        true);

    // Assert
    verify(context, atLeast(1)).getTransportService();
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
  }

  /**
   * Test
   * {@link AbstractCoapTransportResource#reportSubscriptionInfo(SessionInfoProto, boolean, boolean)}.
   * <ul>
   *   <li>Then calls
   * {@link DefaultTransportService#process(SessionInfoProto, SubscriptionInfoProto, TransportServiceCallback)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCoapTransportResource#reportSubscriptionInfo(TransportProtos.SessionInfoProto, boolean, boolean)}
   */
  @Test
  @DisplayName("Test reportSubscriptionInfo(SessionInfoProto, boolean, boolean); then calls process(SessionInfoProto, SubscriptionInfoProto, TransportServiceCallback)")
  void testReportSubscriptionInfo_thenCallsProcess() {
    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing().when(defaultTransportService)
        .process(Mockito.<TransportProtos.SessionInfoProto>any(), Mockito.<TransportProtos.SubscriptionInfoProto>any(),
            Mockito.<TransportServiceCallback<Void>>any());
    CoapTransportContext context = mock(CoapTransportContext.class);
    when(context.getTransportService()).thenReturn(defaultTransportService);
    CoapEfentoTransportResource coapEfentoTransportResource = new CoapEfentoTransportResource(context, "Name");

    // Act
    coapEfentoTransportResource.reportSubscriptionInfo(TransportProtos.SessionInfoProto.getDefaultInstance(), true,
        true);

    // Assert
    verify(context, atLeast(1)).getTransportService();
    verify(defaultTransportService).process(isA(TransportProtos.SessionInfoProto.class),
        isA(TransportProtos.SubscriptionInfoProto.class), isA(TransportServiceCallback.class));
  }
}
