package org.thingsboard.server.transport.coap;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
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
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.gen.transport.TransportProtos.SubscriptionInfoProto;
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

  /**
   * Test {@link AbstractCoapTransportResource#reportSubscriptionInfo(SessionInfoProto, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantRoutingInfoService#getRoutingInfo(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoapTransportResource#reportSubscriptionInfo(TransportProtos.SessionInfoProto, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test reportSubscriptionInfo(SessionInfoProto, boolean, boolean); then calls getRoutingInfo(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractCoapTransportResource.reportSubscriptionInfo(TransportProtos.SessionInfoProto, boolean, boolean)"
  })
  void testReportSubscriptionInfo_thenCallsGetRoutingInfo() {
    // Arrange
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(tenantId, null, true);
    when(tenantRoutingInfoService.getRoutingInfo(Mockito.<TenantId>any()))
        .thenReturn(tenantRoutingInfo);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider2,
            coreSettings,
            storage,
            new TopicService());
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings2,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider3,
            transportApiSettings2,
            transportNotificationSettings2,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TbRuleEngineProducerService ruleEngineProducerService =
        new TbRuleEngineProducerService(partitionService2);
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService defaultTransportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService2,
            serviceInfoProvider5,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));

    CoapTransportContext context = mock(CoapTransportContext.class);
    when(context.getTransportService()).thenReturn(defaultTransportService);

    // Act
    new CoapEfentoTransportResource(context, "Name")
        .reportSubscriptionInfo(SessionInfoProto.getDefaultInstance(), true, true);

    // Assert
    verify(context, atLeast(1)).getTransportService();
    verify(tenantRoutingInfoService).getRoutingInfo(isA(TenantId.class));
  }

  /**
   * Test {@link AbstractCoapTransportResource#reportSubscriptionInfo(SessionInfoProto, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultTransportService#process(SessionInfoProto,
   *       SubscriptionInfoProto, TransportServiceCallback)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractCoapTransportResource#reportSubscriptionInfo(TransportProtos.SessionInfoProto, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test reportSubscriptionInfo(SessionInfoProto, boolean, boolean); then calls process(SessionInfoProto, SubscriptionInfoProto, TransportServiceCallback)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractCoapTransportResource.reportSubscriptionInfo(TransportProtos.SessionInfoProto, boolean, boolean)"
  })
  void testReportSubscriptionInfo_thenCallsProcess() {
    // Arrange
    DefaultTransportService defaultTransportService = mock(DefaultTransportService.class);
    doNothing()
        .when(defaultTransportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SubscriptionInfoProto>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    CoapTransportContext context = mock(CoapTransportContext.class);
    when(context.getTransportService()).thenReturn(defaultTransportService);

    // Act
    new CoapEfentoTransportResource(context, "Name")
        .reportSubscriptionInfo(SessionInfoProto.getDefaultInstance(), true, true);

    // Assert
    verify(context, atLeast(1)).getTransportService();
    verify(defaultTransportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SubscriptionInfoProto.class),
            isA(TransportServiceCallback.class));
  }
}
