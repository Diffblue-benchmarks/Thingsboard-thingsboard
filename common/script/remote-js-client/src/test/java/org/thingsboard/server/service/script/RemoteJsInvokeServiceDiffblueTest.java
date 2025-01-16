package org.thingsboard.server.service.script;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import org.junit.jupiter.api.DisplayName;
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
   * <p>
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    Optional<TbApiUsageReportClient> apiUsageClient = Optional
        .of(new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));
    RemoteJsInvokeService remoteJsInvokeService = new RemoteJsInvokeService(apiUsageStateClient, apiUsageClient);

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
   * Test {@link RemoteJsInvokeService#doEval(UUID, JsScriptInfo, String)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RemoteJsInvokeService#doEval(UUID, JsScriptInfo, String)}
   */
  @Test
  @DisplayName("Test doEval(UUID, JsScriptInfo, String); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  void testDoEval_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    Optional<TbApiUsageReportClient> apiUsageClient = Optional.of(new DefaultTbApiUsageReportClient(partitionService,
        serviceInfoProvider2, scheduler, new TbCoreQueueProducerProvider(null)));
    RemoteJsInvokeService remoteJsInvokeService = new RemoteJsInvokeService(apiUsageStateClient, apiUsageClient);
    UUID scriptId = UUID.randomUUID();
    JsScriptInfo jsInfo = mock(JsScriptInfo.class);
    when(jsInfo.getFunctionName()).thenThrow(new RuntimeException("foo"));
    when(jsInfo.getHash()).thenReturn("Hash");

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> remoteJsInvokeService.doEval(scriptId, jsInfo, "Not all who wander are lost"));
    verify(jsInfo).getFunctionName();
    verify(jsInfo).getHash();
  }

  /**
   * Test
   * {@link RemoteJsInvokeService#doInvokeFunction(UUID, JsScriptInfo, Object[])}
   * with {@code scriptId}, {@code jsInfo}, {@code args}.
   * <ul>
   *   <li>Then return Done.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RemoteJsInvokeService#doInvokeFunction(UUID, JsScriptInfo, Object[])}
   */
  @Test
  @DisplayName("Test doInvokeFunction(UUID, JsScriptInfo, Object[]) with 'scriptId', 'jsInfo', 'args'; then return Done")
  void testDoInvokeFunctionWithScriptIdJsInfoArgs_thenReturnDone() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    Optional<TbApiUsageReportClient> apiUsageClient = Optional.of(new DefaultTbApiUsageReportClient(partitionService,
        serviceInfoProvider2, scheduler, new TbCoreQueueProducerProvider(null)));
    RemoteJsInvokeService remoteJsInvokeService = new RemoteJsInvokeService(apiUsageStateClient, apiUsageClient);
    UUID scriptId = UUID.randomUUID();

    // Act and Assert
    assertTrue(remoteJsInvokeService
        .doInvokeFunction(scriptId, new JsScriptInfo("Hash", "Function Name"), new Object[]{"Args"})
        .isDone());
  }

  /**
   * Test {@link RemoteJsInvokeService#doRelease(UUID, JsScriptInfo)} with
   * {@code scriptId}, {@code jsInfo}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RemoteJsInvokeService#doRelease(UUID, JsScriptInfo)}
   */
  @Test
  @DisplayName("Test doRelease(UUID, JsScriptInfo) with 'scriptId', 'jsInfo'; then throw RuntimeException")
  void testDoReleaseWithScriptIdJsInfo_thenThrowRuntimeException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    Optional<TbApiUsageReportClient> apiUsageClient = Optional.of(new DefaultTbApiUsageReportClient(partitionService,
        serviceInfoProvider2, scheduler, new TbCoreQueueProducerProvider(null)));
    RemoteJsInvokeService remoteJsInvokeService = new RemoteJsInvokeService(apiUsageStateClient, apiUsageClient);
    UUID scriptId = UUID.randomUUID();
    JsScriptInfo jsInfo = mock(JsScriptInfo.class);
    when(jsInfo.getFunctionName()).thenThrow(new RuntimeException("foo"));
    when(jsInfo.getHash()).thenReturn("Hash");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> remoteJsInvokeService.doRelease(scriptId, jsInfo));
    verify(jsInfo).getFunctionName();
    verify(jsInfo).getHash();
  }

  /**
   * Test {@link RemoteJsInvokeService#constructFunctionName(UUID, String)}.
   * <p>
   * Method under test:
   * {@link RemoteJsInvokeService#constructFunctionName(UUID, String)}
   */
  @Test
  @DisplayName("Test constructFunctionName(UUID, String)")
  void testConstructFunctionName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    Optional<TbApiUsageReportClient> apiUsageClient = Optional.of(new DefaultTbApiUsageReportClient(partitionService,
        serviceInfoProvider2, scheduler, new TbCoreQueueProducerProvider(null)));
    RemoteJsInvokeService remoteJsInvokeService = new RemoteJsInvokeService(apiUsageStateClient, apiUsageClient);

    // Act and Assert
    assertEquals("invokeInternal_Script Hash",
        remoteJsInvokeService.constructFunctionName(UUID.randomUUID(), "Script Hash"));
  }

  /**
   * Test {@link RemoteJsInvokeService#getScriptHash(UUID)}.
   * <ul>
   *   <li>When randomUUID.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoteJsInvokeService#getScriptHash(UUID)}
   */
  @Test
  @DisplayName("Test getScriptHash(UUID); when randomUUID; then return 'null'")
  void testGetScriptHash_whenRandomUUID_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient = Optional.of(mock(TbApiUsageStateClient.class));
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    Optional<TbApiUsageReportClient> apiUsageClient = Optional.of(new DefaultTbApiUsageReportClient(partitionService,
        serviceInfoProvider2, scheduler, new TbCoreQueueProducerProvider(null)));
    RemoteJsInvokeService remoteJsInvokeService = new RemoteJsInvokeService(apiUsageStateClient, apiUsageClient);

    // Act and Assert
    assertNull(remoteJsInvokeService.getScriptHash(UUID.randomUUID()));
  }
}
