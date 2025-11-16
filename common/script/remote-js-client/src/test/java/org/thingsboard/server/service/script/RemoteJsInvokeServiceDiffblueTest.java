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
package org.thingsboard.server.service.script;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.script.api.js.JsScriptInfo;
import org.thingsboard.server.common.stats.TbApiUsageReportClient;
import org.thingsboard.server.common.stats.TbApiUsageStateClient;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;
import org.thingsboard.server.queue.usagestats.DefaultTbApiUsageReportClient;

class RemoteJsInvokeServiceDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RemoteJsInvokeService#getCallbackExecutor()}
   *   <li>{@link RemoteJsInvokeService#getMaxBlackListDurationSec()}
   *   <li>{@link RemoteJsInvokeService#getMaxErrors()}
   *   <li>{@link RemoteJsInvokeService#getMaxEvalRequestsTimeout()}
   *   <li>{@link RemoteJsInvokeService#getMaxInvokeRequestsTimeout()}
   *   <li>{@link RemoteJsInvokeService#getStatsName()}
   *   <li>{@link RemoteJsInvokeService#isStatsEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Executor RemoteJsInvokeService.getCallbackExecutor()",
    "int RemoteJsInvokeService.getMaxBlackListDurationSec()",
    "int RemoteJsInvokeService.getMaxErrors()",
    "long RemoteJsInvokeService.getMaxEvalRequestsTimeout()",
    "long RemoteJsInvokeService.getMaxInvokeRequestsTimeout()",
    "String RemoteJsInvokeService.getStatsName()",
    "boolean RemoteJsInvokeService.isStatsEnabled()"
  })
  void testGettersAndSetters() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient =
        Optional.of(mock(TbApiUsageStateClient.class));
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
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider3,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());

    DefaultTbApiUsageReportClient defaultTbApiUsageReportClient =
        new DefaultTbApiUsageReportClient(
            partitionService,
            serviceInfoProvider2,
            scheduler,
            new TbCoreQueueProducerProvider(tbQueueProvider));
    Optional<TbApiUsageReportClient> apiUsageClient = Optional.of(defaultTbApiUsageReportClient);

    RemoteJsInvokeService remoteJsInvokeService =
        new RemoteJsInvokeService(apiUsageStateClient, apiUsageClient);

    // Act
    Executor actualCallbackExecutor = remoteJsInvokeService.getCallbackExecutor();
    int actualMaxBlackListDurationSec = remoteJsInvokeService.getMaxBlackListDurationSec();
    int actualMaxErrors = remoteJsInvokeService.getMaxErrors();
    long actualMaxEvalRequestsTimeout = remoteJsInvokeService.getMaxEvalRequestsTimeout();
    long actualMaxInvokeRequestsTimeout = remoteJsInvokeService.getMaxInvokeRequestsTimeout();
    String actualStatsName = remoteJsInvokeService.getStatsName();

    // Assert
    assertTrue(actualCallbackExecutor instanceof ThreadPoolExecutor);
    assertEquals("Queue JS Invoke Stats", actualStatsName);
    assertEquals(0, actualMaxBlackListDurationSec);
    assertEquals(0, actualMaxErrors);
    assertEquals(0L, actualMaxEvalRequestsTimeout);
    assertEquals(0L, actualMaxInvokeRequestsTimeout);
    assertFalse(remoteJsInvokeService.isStatsEnabled());
  }

  /**
   * Test {@link RemoteJsInvokeService#doInvokeFunction(UUID, JsScriptInfo, Object[])} with {@code
   * scriptId}, {@code jsInfo}, {@code args}.
   *
   * <ul>
   *   <li>Then return Done.
   * </ul>
   *
   * <p>Method under test: {@link RemoteJsInvokeService#doInvokeFunction(UUID, JsScriptInfo,
   * Object[])}
   */
  @Test
  @DisplayName(
      "Test doInvokeFunction(UUID, JsScriptInfo, Object[]) with 'scriptId', 'jsInfo', 'args'; then return Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture RemoteJsInvokeService.doInvokeFunction(UUID, JsScriptInfo, Object[])"
  })
  void testDoInvokeFunctionWithScriptIdJsInfoArgs_thenReturnDone() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient =
        Optional.of(mock(TbApiUsageStateClient.class));
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
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();

    DefaultTbApiUsageReportClient defaultTbApiUsageReportClient =
        new DefaultTbApiUsageReportClient(
            partitionService,
            serviceInfoProvider2,
            scheduler,
            new TbCoreQueueProducerProvider(null));
    Optional<TbApiUsageReportClient> apiUsageClient = Optional.of(defaultTbApiUsageReportClient);

    RemoteJsInvokeService remoteJsInvokeService =
        new RemoteJsInvokeService(apiUsageStateClient, apiUsageClient);
    UUID scriptId = UUID.randomUUID();

    // Act and Assert
    assertTrue(
        remoteJsInvokeService
            .doInvokeFunction(
                scriptId, new JsScriptInfo("Hash", "Function Name"), new Object[] {"Args"})
            .isDone());
  }

  /**
   * Test {@link RemoteJsInvokeService#constructFunctionName(UUID, String)}.
   *
   * <p>Method under test: {@link RemoteJsInvokeService#constructFunctionName(UUID, String)}
   */
  @Test
  @DisplayName("Test constructFunctionName(UUID, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RemoteJsInvokeService.constructFunctionName(UUID, String)"})
  void testConstructFunctionName() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient =
        Optional.of(mock(TbApiUsageStateClient.class));
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
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();

    DefaultTbApiUsageReportClient defaultTbApiUsageReportClient =
        new DefaultTbApiUsageReportClient(
            partitionService,
            serviceInfoProvider2,
            scheduler,
            new TbCoreQueueProducerProvider(null));
    Optional<TbApiUsageReportClient> apiUsageClient = Optional.of(defaultTbApiUsageReportClient);

    RemoteJsInvokeService remoteJsInvokeService =
        new RemoteJsInvokeService(apiUsageStateClient, apiUsageClient);

    // Act and Assert
    assertEquals(
        "invokeInternal_Script Hash",
        remoteJsInvokeService.constructFunctionName(UUID.randomUUID(), "Script Hash"));
  }

  /**
   * Test {@link RemoteJsInvokeService#getScriptHash(UUID)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RemoteJsInvokeService#getScriptHash(UUID)}
   */
  @Test
  @DisplayName("Test getScriptHash(UUID); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String RemoteJsInvokeService.getScriptHash(UUID)"})
  void testGetScriptHash_thenReturnNull() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient =
        Optional.of(mock(TbApiUsageStateClient.class));
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
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();

    DefaultTbApiUsageReportClient defaultTbApiUsageReportClient =
        new DefaultTbApiUsageReportClient(
            partitionService,
            serviceInfoProvider2,
            scheduler,
            new TbCoreQueueProducerProvider(null));
    Optional<TbApiUsageReportClient> apiUsageClient = Optional.of(defaultTbApiUsageReportClient);

    RemoteJsInvokeService remoteJsInvokeService =
        new RemoteJsInvokeService(apiUsageStateClient, apiUsageClient);

    // Act and Assert
    assertNull(remoteJsInvokeService.getScriptHash(UUID.randomUUID()));
  }
}
