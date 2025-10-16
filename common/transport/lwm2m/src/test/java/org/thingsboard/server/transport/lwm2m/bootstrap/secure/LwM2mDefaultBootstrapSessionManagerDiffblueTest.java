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
package org.thingsboard.server.transport.lwm2m.bootstrap.secure;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.eclipse.leshan.server.bootstrap.BootstrapConfigStore;
import org.eclipse.leshan.server.bootstrap.InMemoryBootstrapConfigStore;
import org.eclipse.leshan.server.model.LwM2mBootstrapModelProvider;
import org.eclipse.leshan.server.security.BootstrapSecurityStore;
import org.eclipse.leshan.server.security.SecurityChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.TransportService;
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
import org.thingsboard.server.transport.lwm2m.bootstrap.store.LwM2MBootstrapConfigStoreTaskProvider;
import org.thingsboard.server.transport.lwm2m.bootstrap.store.LwM2MBootstrapSecurityStore;
import org.thingsboard.server.transport.lwm2m.bootstrap.store.LwM2MBootstrapTaskProvider;
import org.thingsboard.server.transport.lwm2m.config.LwM2MTransportServerConfig;
import org.thingsboard.server.transport.lwm2m.secure.LwM2mCredentialsSecurityInfoValidator;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportContext;
import org.thingsboard.server.transport.lwm2m.server.LwM2mTransportServerHelper;

class LwM2mDefaultBootstrapSessionManagerDiffblueTest {
  /**
   * Test {@link
   * LwM2mDefaultBootstrapSessionManager#LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore,
   * BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider,
   * LwM2mBootstrapModelProvider)}.
   *
   * <p>Method under test: {@link
   * LwM2mDefaultBootstrapSessionManager#LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore,
   * BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider,
   * LwM2mBootstrapModelProvider)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore, BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider, LwM2mBootstrapModelProvider)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mDefaultBootstrapSessionManager.<init>(BootstrapSecurityStore, BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider, LwM2mBootstrapModelProvider)"
  })
  void testNewLwM2mDefaultBootstrapSessionManager() {
    // Arrange
    InMemoryBootstrapConfigStore bootstrapConfigStore = new InMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());
    LwM2mTransportContext context2 = new LwM2mTransportContext();

    LwM2MBootstrapSecurityStore bsSecurityStore =
        new LwM2MBootstrapSecurityStore(
            bootstrapConfigStore,
            lwM2MCredentialsSecurityInfoValidator,
            context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext()));
    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
    SecurityChecker securityChecker = new SecurityChecker();
    LwM2MBootstrapConfigStoreTaskProvider tasksProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));

    // Act
    LwM2mDefaultBootstrapSessionManager actualLwM2mDefaultBootstrapSessionManager =
        new LwM2mDefaultBootstrapSessionManager(
            bsSecurityStore,
            configStore,
            securityChecker,
            tasksProvider,
            mock(LwM2mBootstrapModelProvider.class));

    // Assert
    assertFalse(actualLwM2mDefaultBootstrapSessionManager.hasConfigFor(null));
  }

  /**
   * Test {@link
   * LwM2mDefaultBootstrapSessionManager#LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore,
   * BootstrapConfigStore, TransportService)}.
   *
   * <p>Method under test: {@link
   * LwM2mDefaultBootstrapSessionManager#LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore,
   * BootstrapConfigStore, TransportService)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore, BootstrapConfigStore, TransportService)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mDefaultBootstrapSessionManager.<init>(BootstrapSecurityStore, BootstrapConfigStore, TransportService)"
  })
  void testNewLwM2mDefaultBootstrapSessionManager2() {
    // Arrange
    InMemoryBootstrapConfigStore bootstrapConfigStore = new InMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());
    LwM2mTransportContext context2 = new LwM2mTransportContext();

    LwM2MBootstrapSecurityStore bsSecurityStore =
        new LwM2MBootstrapSecurityStore(
            bootstrapConfigStore,
            lwM2MCredentialsSecurityInfoValidator,
            context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext()));
    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
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
    DefaultTransportResourceCache transportResourceCache =
        new DefaultTransportResourceCache(mock(TransportService.class));
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService transportService =
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

    // Act
    LwM2mDefaultBootstrapSessionManager actualLwM2mDefaultBootstrapSessionManager =
        new LwM2mDefaultBootstrapSessionManager(bsSecurityStore, configStore, transportService);

    // Assert
    assertFalse(actualLwM2mDefaultBootstrapSessionManager.hasConfigFor(null));
  }

  /**
   * Test {@link
   * LwM2mDefaultBootstrapSessionManager#LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore,
   * BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider,
   * LwM2mBootstrapModelProvider)}.
   *
   * <p>Method under test: {@link
   * LwM2mDefaultBootstrapSessionManager#LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore,
   * BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider,
   * LwM2mBootstrapModelProvider)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore, BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider, LwM2mBootstrapModelProvider)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mDefaultBootstrapSessionManager.<init>(BootstrapSecurityStore, BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider, LwM2mBootstrapModelProvider)"
  })
  void testNewLwM2mDefaultBootstrapSessionManager3() {
    // Arrange
    InMemoryBootstrapConfigStore bootstrapConfigStore = new InMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());
    LwM2mTransportContext context2 = new LwM2mTransportContext();

    LwM2MBootstrapSecurityStore bsSecurityStore =
        new LwM2MBootstrapSecurityStore(
            bootstrapConfigStore,
            lwM2MCredentialsSecurityInfoValidator,
            context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext()));
    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
    SecurityChecker securityChecker = new SecurityChecker();
    LwM2MBootstrapConfigStoreTaskProvider tasksProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));

    // Act
    LwM2mDefaultBootstrapSessionManager actualLwM2mDefaultBootstrapSessionManager =
        new LwM2mDefaultBootstrapSessionManager(
            bsSecurityStore,
            configStore,
            securityChecker,
            tasksProvider,
            mock(LwM2mBootstrapModelProvider.class));

    // Assert
    assertFalse(actualLwM2mDefaultBootstrapSessionManager.hasConfigFor(null));
  }

  /**
   * Test {@link
   * LwM2mDefaultBootstrapSessionManager#LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore,
   * BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider,
   * LwM2mBootstrapModelProvider)}.
   *
   * <p>Method under test: {@link
   * LwM2mDefaultBootstrapSessionManager#LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore,
   * BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider,
   * LwM2mBootstrapModelProvider)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore, BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider, LwM2mBootstrapModelProvider)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mDefaultBootstrapSessionManager.<init>(BootstrapSecurityStore, BootstrapConfigStore, SecurityChecker, LwM2MBootstrapTaskProvider, LwM2mBootstrapModelProvider)"
  })
  void testNewLwM2mDefaultBootstrapSessionManager4() {
    // Arrange
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());
    LwM2mTransportContext context2 = new LwM2mTransportContext();

    LwM2MBootstrapSecurityStore bsSecurityStore =
        new LwM2MBootstrapSecurityStore(
            null,
            lwM2MCredentialsSecurityInfoValidator,
            context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext()));
    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
    SecurityChecker securityChecker = new SecurityChecker();
    LwM2MBootstrapConfigStoreTaskProvider tasksProvider =
        new LwM2MBootstrapConfigStoreTaskProvider(mock(BootstrapConfigStore.class));

    // Act
    LwM2mDefaultBootstrapSessionManager actualLwM2mDefaultBootstrapSessionManager =
        new LwM2mDefaultBootstrapSessionManager(
            bsSecurityStore,
            configStore,
            securityChecker,
            tasksProvider,
            mock(LwM2mBootstrapModelProvider.class));

    // Assert
    assertFalse(actualLwM2mDefaultBootstrapSessionManager.hasConfigFor(null));
  }

  /**
   * Test {@link
   * LwM2mDefaultBootstrapSessionManager#LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore,
   * BootstrapConfigStore, TransportService)}.
   *
   * <p>Method under test: {@link
   * LwM2mDefaultBootstrapSessionManager#LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore,
   * BootstrapConfigStore, TransportService)}
   */
  @Test
  @DisplayName(
      "Test new LwM2mDefaultBootstrapSessionManager(BootstrapSecurityStore, BootstrapConfigStore, TransportService)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2mDefaultBootstrapSessionManager.<init>(BootstrapSecurityStore, BootstrapConfigStore, TransportService)"
  })
  void testNewLwM2mDefaultBootstrapSessionManager5() {
    // Arrange
    InMemoryBootstrapConfigStore bootstrapConfigStore = new InMemoryBootstrapConfigStore();
    LwM2mTransportContext context = new LwM2mTransportContext();
    LwM2mCredentialsSecurityInfoValidator lwM2MCredentialsSecurityInfoValidator =
        new LwM2mCredentialsSecurityInfoValidator(context, new LwM2MTransportServerConfig());
    LwM2mTransportContext context2 = new LwM2mTransportContext();

    LwM2MBootstrapSecurityStore bsSecurityStore =
        new LwM2MBootstrapSecurityStore(
            bootstrapConfigStore,
            lwM2MCredentialsSecurityInfoValidator,
            context2,
            new LwM2mTransportServerHelper(new LwM2mTransportContext()));
    BootstrapConfigStore configStore = mock(BootstrapConfigStore.class);
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

    DefaultTransportService transportService =
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

    // Act
    LwM2mDefaultBootstrapSessionManager actualLwM2mDefaultBootstrapSessionManager =
        new LwM2mDefaultBootstrapSessionManager(bsSecurityStore, configStore, transportService);

    // Assert
    assertFalse(actualLwM2mDefaultBootstrapSessionManager.hasConfigFor(null));
  }
}
