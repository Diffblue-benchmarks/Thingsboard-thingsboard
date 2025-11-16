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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.coapserver.CoapServerContext;
import org.thingsboard.server.coapserver.CoapServerService;
import org.thingsboard.server.coapserver.DefaultCoapServerService;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
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
import org.thingsboard.server.transport.coap.client.DefaultCoapClientContext;

class CoapTransportResourceDiffblueTest {
  /**
   * Test {@link CoapTransportResource#CoapTransportResource(CoapTransportContext,
   * CoapServerService, String)}.
   *
   * <ul>
   *   <li>Then {@link AbstractCoapTransportResource#transportService} return {@link
   *       DefaultTransportService}.
   * </ul>
   *
   * <p>Method under test: {@link CoapTransportResource#CoapTransportResource(CoapTransportContext,
   * CoapServerService, String)}
   */
  @Test
  @DisplayName(
      "Test new CoapTransportResource(CoapTransportContext, CoapServerService, String); then transportService return DefaultTransportService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CoapTransportResource.<init>(CoapTransportContext, CoapServerService, String)"
  })
  void testNewCoapTransportResource_thenTransportServiceReturnDefaultTransportService() {
    // Arrange
    DefaultSchedulerComponent defaultSchedulerComponent = mock(DefaultSchedulerComponent.class);
    Mockito.<ScheduledFuture<?>>when(
            defaultSchedulerComponent.scheduleAtFixedRate(
                Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);

    CoapTransportContext ctx = mock(CoapTransportContext.class);
    when(ctx.getPiggybackTimeout()).thenReturn(1L);
    when(ctx.getTimeout()).thenReturn(10L);
    when(ctx.getSessionReportTimeout()).thenReturn(1L);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
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
    when(ctx.getTransportService()).thenReturn(defaultTransportService);
    when(ctx.getScheduler()).thenReturn(defaultSchedulerComponent);
    CoapServerContext config = new CoapServerContext();
    CoapTransportContext transportContext = new CoapTransportContext();
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService3 =
        new HashPartitionService(
            serviceInfoProvider6,
            tenantRoutingInfoService3,
            applicationEventPublisher3,
            queueRoutingInfoService3,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings3 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings3 =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider7 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings3 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage2 = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider2 =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings3,
            transportNotificationSettings3,
            serviceInfoProvider7,
            coreSettings3,
            storage2,
            new TopicService());
    TopicService topicService3 = new TopicService();
    TbQueueCoreSettings coreSettings4 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings2 = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings2 = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider8 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings4 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings4 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings2 = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider2 =
        new InMemoryMonolithQueueFactory(
            topicService3,
            coreSettings4,
            ruleEngineSettings2,
            vcSettings2,
            serviceInfoProvider8,
            transportApiSettings4,
            transportNotificationSettings4,
            edgeSettings2,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider2 =
        new TbCoreQueueProducerProvider(tbQueueProvider2);
    DefaultTbServiceInfoProvider serviceInfoProvider9 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService4 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher4 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService4 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService4 =
        new HashPartitionService(
            serviceInfoProvider9,
            tenantRoutingInfoService4,
            applicationEventPublisher4,
            queueRoutingInfoService4,
            new TopicService());
    TbRuleEngineProducerService ruleEngineProducerService2 =
        new TbRuleEngineProducerService(partitionService4);
    TopicService topicService4 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider10 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory2 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache2 =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache2 =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService2 =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler2 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache2 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor2 = mock(NotificationRuleProcessor.class);

    DefaultTransportService transportService =
        new DefaultTransportService(
            partitionService3,
            queueProvider2,
            producerProvider2,
            ruleEngineProducerService2,
            topicService4,
            serviceInfoProvider10,
            statsFactory2,
            deviceProfileCache2,
            tenantProfileCache2,
            rateLimitService2,
            scheduler2,
            eventPublisher2,
            transportResourceCache2,
            notificationRuleProcessor2,
            new DefaultEntityLimitsCache(1, 3));
    DefaultTransportDeviceProfileCache profileCache = new DefaultTransportDeviceProfileCache();
    DefaultTbServiceInfoProvider serviceInfoProvider11 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService5 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher5 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService5 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService5 =
        new HashPartitionService(
            serviceInfoProvider11,
            tenantRoutingInfoService5,
            applicationEventPublisher5,
            queueRoutingInfoService5,
            new TopicService());

    DefaultCoapClientContext defaultCoapClientContext =
        new DefaultCoapClientContext(
            config, transportContext, transportService, profileCache, partitionService5);
    when(ctx.getClientContext()).thenReturn(defaultCoapClientContext);

    // Act
    CoapTransportResource actualCoapTransportResource =
        new CoapTransportResource(ctx, new DefaultCoapServerService(), "Name");

    // Assert
    verify(ctx).getScheduler();
    verify(ctx).getTransportService();
    verify(defaultSchedulerComponent)
        .scheduleAtFixedRate(isA(Runnable.class), eq(0L), eq(1L), eq(TimeUnit.MILLISECONDS));
    verify(ctx).getClientContext();
    verify(ctx).getPiggybackTimeout();
    verify(ctx).getSessionReportTimeout();
    verify(ctx).getTimeout();
    assertTrue(actualCoapTransportResource.transportService instanceof DefaultTransportService);
    assertEquals("", actualCoapTransportResource.getPath());
    assertEquals("Name", actualCoapTransportResource.getName());
    assertEquals("Name", actualCoapTransportResource.getURI());
    assertNull(actualCoapTransportResource.getExecutor());
    assertNull(actualCoapTransportResource.getObserveType());
    assertNull(actualCoapTransportResource.getParent());
    assertEquals(0, actualCoapTransportResource.getNotificationSequenceNumber());
    assertEquals(0, actualCoapTransportResource.getObserverCount());
    assertTrue(actualCoapTransportResource.getChildren().isEmpty());
    assertTrue(actualCoapTransportResource.isCachable());
    assertTrue(actualCoapTransportResource.isObservable());
    assertTrue(actualCoapTransportResource.isVisible());
  }

  /**
   * Test {@link CoapTransportResource#CoapTransportResource(CoapTransportContext,
   * CoapServerService, String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CoapTransportResource#CoapTransportResource(CoapTransportContext,
   * CoapServerService, String)}
   */
  @Test
  @DisplayName(
      "Test new CoapTransportResource(CoapTransportContext, CoapServerService, String); when '/'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CoapTransportResource.<init>(CoapTransportContext, CoapServerService, String)"
  })
  void testNewCoapTransportResource_whenSlash_thenThrowIllegalArgumentException() {
    // Arrange
    CoapTransportContext ctx = new CoapTransportContext();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new CoapTransportResource(ctx, new DefaultCoapServerService(), "/"));
  }

  /**
   * Test {@link CoapTransportResource#getRequestId(Request)}.
   *
   * <ul>
   *   <li>Given {@code Failed to decode feature type: {}}.
   * </ul>
   *
   * <p>Method under test: {@link CoapTransportResource#getRequestId(Request)}
   */
  @Test
  @DisplayName("Test getRequestId(Request); given 'Failed to decode feature type: {}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional CoapTransportResource.getRequestId(Request)"})
  void testGetRequestId_givenFailedToDecodeFeatureType() {
    // Arrange
    Request request = Request.newDelete();
    request.setProxyUri("Failed to decode feature type: {}");

    // Act
    Optional<Integer> actualRequestId = CoapTransportResource.getRequestId(request);

    // Assert
    assertFalse(actualRequestId.isPresent());
  }

  /**
   * Test {@link CoapTransportResource#getRequestId(Request)}.
   *
   * <ul>
   *   <li>Given {@link OptionSet#OptionSet()} addUriPath {@code Segment}.
   *   <li>When newDelete Options is {@link OptionSet#OptionSet()}.
   * </ul>
   *
   * <p>Method under test: {@link CoapTransportResource#getRequestId(Request)}
   */
  @Test
  @DisplayName(
      "Test getRequestId(Request); given OptionSet() addUriPath 'Segment'; when newDelete Options is OptionSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional CoapTransportResource.getRequestId(Request)"})
  void testGetRequestId_givenOptionSetAddUriPathSegment_whenNewDeleteOptionsIsOptionSet() {
    // Arrange
    OptionSet options = new OptionSet();
    options.addUriPath("Segment");

    Request request = Request.newDelete();
    request.setOptions(options);

    // Act
    Optional<Integer> actualRequestId = CoapTransportResource.getRequestId(request);

    // Assert
    assertFalse(actualRequestId.isPresent());
  }

  /**
   * Test {@link CoapTransportResource#getRequestId(Request)}.
   *
   * <ul>
   *   <li>When newDelete.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link CoapTransportResource#getRequestId(Request)}
   */
  @Test
  @DisplayName("Test getRequestId(Request); when newDelete; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional CoapTransportResource.getRequestId(Request)"})
  void testGetRequestId_whenNewDelete_thenReturnNotPresent() {
    // Arrange and Act
    Optional<Integer> actualRequestId = CoapTransportResource.getRequestId(Request.newDelete());

    // Assert
    assertFalse(actualRequestId.isPresent());
  }
}
