package org.thingsboard.server.service.ws;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.InetSocketAddress;
import java.util.UUID;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.dao.attributes.AttributesService;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.dao.timeseries.TimeseriesService;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.service.security.AccessValidator;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.subscription.SubscriptionErrorCode;
import org.thingsboard.server.service.subscription.TbEntityDataSubscriptionService;
import org.thingsboard.server.service.subscription.TbLocalSubscriptionService;
import org.thingsboard.server.service.ws.DefaultWebSocketService.WsCmdHandler;
import org.thingsboard.server.service.ws.notification.NotificationCommandsHandler;
import org.thingsboard.server.service.ws.telemetry.sub.TelemetrySubscriptionUpdate;

@ContextConfiguration(classes = {DefaultWebSocketService.WsCmdHandler.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class DefaultWebSocketServiceDiffblueTest {
  @MockBean
  private BiConsumer<WebSocketSessionRef, WsCmd> biConsumer;

  @Autowired
  private DefaultWebSocketService.WsCmdHandler<WsCmd> wsCmdHandler;

  @MockBean
  private AccessValidator accessValidator;

  @MockBean
  private AttributesService attributesService;

  @MockBean
  private NotificationCommandsHandler notificationCommandsHandler;

  @MockBean
  private TbEntityDataSubscriptionService tbEntityDataSubscriptionService;

  @MockBean
  private TbLocalSubscriptionService tbLocalSubscriptionService;

  @MockBean
  private TbServiceInfoProvider tbServiceInfoProvider;

  @MockBean
  private TbTenantProfileCache tbTenantProfileCache;

  @MockBean
  private TimeseriesService timeseriesService;

  @MockBean
  private WebSocketMsgEndpoint webSocketMsgEndpoint;

  /**
   * Test {@link DefaultWebSocketService#init()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultWebSocketService#init()}
   */
  @Test
  @DisplayName("Test init(); then throw RuntimeException")
  void testInit_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbServiceInfoProvider serviceInfoProvider = mock(TbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenThrow(new RuntimeException("telemetry-web-socket-ping"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new DefaultWebSocketService(mock(TbLocalSubscriptionService.class),
            mock(TbEntityDataSubscriptionService.class), mock(NotificationCommandsHandler.class),
            mock(WebSocketMsgEndpoint.class), mock(AccessValidator.class), mock(AttributesService.class),
            mock(TimeseriesService.class), serviceInfoProvider, mock(TbTenantProfileCache.class))).init());
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test
   * {@link DefaultWebSocketService#handleSessionEvent(WebSocketSessionRef, SessionEvent)}.
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}
   * {@link TbTenantProfileCache#get(TenantId)} return {@code null}.</li>
   *   <li>Then calls {@link TbTenantProfileCache#get(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultWebSocketService#handleSessionEvent(WebSocketSessionRef, SessionEvent)}
   */
  @Test
  @DisplayName("Test handleSessionEvent(WebSocketSessionRef, SessionEvent); given TbTenantProfileCache get(TenantId) return 'null'; then calls get(TenantId)")
  void testHandleSessionEvent_givenTbTenantProfileCacheGetReturnNull_thenCallsGet() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLocalSubscriptionService oldSubService = mock(TbLocalSubscriptionService.class);
    doNothing().when(oldSubService).cancelAllSessionSubscriptions(Mockito.<TenantId>any(), Mockito.<String>any());
    TbEntityDataSubscriptionService entityDataSubService = mock(TbEntityDataSubscriptionService.class);
    doNothing().when(entityDataSubService).cancelAllSessionSubscriptions(Mockito.<String>any());
    TbTenantProfileCache tenantProfileCache = mock(TbTenantProfileCache.class);
    when(tenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(null);
    DefaultWebSocketService defaultWebSocketService = new DefaultWebSocketService(oldSubService, entityDataSubService,
        mock(NotificationCommandsHandler.class), mock(WebSocketMsgEndpoint.class), mock(AccessValidator.class),
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        tenantProfileCache);
    SecurityUser securityCtx = new SecurityUser();
    InetSocketAddress localAddress = InetSocketAddress.createUnresolved("foo", 1);
    WebSocketSessionRef sessionRef = new WebSocketSessionRef("42", securityCtx, localAddress,
        InetSocketAddress.createUnresolved("foo", 1), WebSocketSessionType.GENERAL);

    // Act
    defaultWebSocketService.handleSessionEvent(sessionRef, SessionEvent.onClosed());

    // Assert
    verify(tenantProfileCache).get((TenantId) isNull());
    verify(entityDataSubService).cancelAllSessionSubscriptions(eq("42"));
    verify(oldSubService).cancelAllSessionSubscriptions(isNull(), eq("42"));
  }

  /**
   * Test
   * {@link DefaultWebSocketService#handleSessionEvent(WebSocketSessionRef, SessionEvent)}.
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}
   * {@link TbTenantProfileCache#get(TenantId)} return
   * {@link TenantProfile#TenantProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultWebSocketService#handleSessionEvent(WebSocketSessionRef, SessionEvent)}
   */
  @Test
  @DisplayName("Test handleSessionEvent(WebSocketSessionRef, SessionEvent); given TbTenantProfileCache get(TenantId) return TenantProfile()")
  void testHandleSessionEvent_givenTbTenantProfileCacheGetReturnTenantProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLocalSubscriptionService oldSubService = mock(TbLocalSubscriptionService.class);
    doNothing().when(oldSubService).cancelAllSessionSubscriptions(Mockito.<TenantId>any(), Mockito.<String>any());
    TbEntityDataSubscriptionService entityDataSubService = mock(TbEntityDataSubscriptionService.class);
    doNothing().when(entityDataSubService).cancelAllSessionSubscriptions(Mockito.<String>any());
    TbTenantProfileCache tenantProfileCache = mock(TbTenantProfileCache.class);
    when(tenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    DefaultWebSocketService defaultWebSocketService = new DefaultWebSocketService(oldSubService, entityDataSubService,
        mock(NotificationCommandsHandler.class), mock(WebSocketMsgEndpoint.class), mock(AccessValidator.class),
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        tenantProfileCache);
    SecurityUser securityCtx = new SecurityUser();
    InetSocketAddress localAddress = InetSocketAddress.createUnresolved("foo", 1);
    WebSocketSessionRef sessionRef = new WebSocketSessionRef("42", securityCtx, localAddress,
        InetSocketAddress.createUnresolved("foo", 1), WebSocketSessionType.GENERAL);

    // Act
    defaultWebSocketService.handleSessionEvent(sessionRef, SessionEvent.onClosed());

    // Assert
    verify(tenantProfileCache).get((TenantId) isNull());
    verify(entityDataSubService).cancelAllSessionSubscriptions(eq("42"));
    verify(oldSubService).cancelAllSessionSubscriptions(isNull(), eq("42"));
  }

  /**
   * Test
   * {@link DefaultWebSocketService#handleSessionEvent(WebSocketSessionRef, SessionEvent)}.
   * <ul>
   *   <li>Then calls {@link TenantProfile#getDefaultProfileConfiguration()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultWebSocketService#handleSessionEvent(WebSocketSessionRef, SessionEvent)}
   */
  @Test
  @DisplayName("Test handleSessionEvent(WebSocketSessionRef, SessionEvent); then calls getDefaultProfileConfiguration()")
  void testHandleSessionEvent_thenCallsGetDefaultProfileConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLocalSubscriptionService oldSubService = mock(TbLocalSubscriptionService.class);
    doNothing().when(oldSubService).cancelAllSessionSubscriptions(Mockito.<TenantId>any(), Mockito.<String>any());
    TbEntityDataSubscriptionService entityDataSubService = mock(TbEntityDataSubscriptionService.class);
    doNothing().when(entityDataSubService).cancelAllSessionSubscriptions(Mockito.<String>any());
    TenantProfile tenantProfile = mock(TenantProfile.class);
    DefaultTenantProfileConfiguration buildResult = DefaultTenantProfileConfiguration.builder()
        .alarmsTtlDays(1)
        .cassandraQueryTenantRateLimitsConfiguration("Cassandra Query Tenant Rate Limits Configuration")
        .customerServerRestLimitsConfiguration("Customer Server Rest Limits Configuration")
        .defaultStorageTtlDays(1)
        .edgeEventRateLimits("Edge Event Rate Limits")
        .edgeEventRateLimitsPerEdge("Edge Event Rate Limits Per Edge")
        .edgeUplinkMessagesRateLimits("Edge Uplink Messages Rate Limits")
        .edgeUplinkMessagesRateLimitsPerEdge("Edge Uplink Messages Rate Limits Per Edge")
        .maxAssets(1L)
        .maxCreatedAlarms(1L)
        .maxCustomers(1L)
        .maxDPStorageDays(1L)
        .maxDashboards(1L)
        .maxDevices(1L)
        .maxEmails(1L)
        .maxJSExecutions(1L)
        .maxOtaPackagesInBytes(1L)
        .maxREExecutions(1L)
        .maxResourceSize(3L)
        .maxResourcesInBytes(1L)
        .maxRuleChains(1L)
        .maxRuleNodeExecutionsPerMessage(3)
        .maxSms(1L)
        .maxTbelExecutions(1L)
        .maxTransportDataPoints(1L)
        .maxTransportMessages(1L)
        .maxUsers(1L)
        .maxWsSessionsPerCustomer(3)
        .maxWsSessionsPerPublicUser(3)
        .maxWsSessionsPerRegularUser(3)
        .maxWsSessionsPerTenant(3)
        .maxWsSubscriptionsPerCustomer(1L)
        .maxWsSubscriptionsPerPublicUser(1L)
        .maxWsSubscriptionsPerRegularUser(1L)
        .maxWsSubscriptionsPerTenant(1L)
        .queueStatsTtlDays(1)
        .rpcTtlDays(1)
        .ruleEngineExceptionsTtlDays(1)
        .smsEnabled(true)
        .tenantEntityExportRateLimit("Tenant Entity Export Rate Limit")
        .tenantEntityImportRateLimit("Tenant Entity Import Rate Limit")
        .tenantNotificationRequestsPerRuleRateLimit("Tenant Notification Requests Per Rule Rate Limit")
        .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
        .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
        .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
        .transportDeviceTelemetryDataPointsRateLimit("Transport Device Telemetry Data Points Rate Limit")
        .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
        .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
        .transportGatewayDeviceTelemetryDataPointsRateLimit("Transport Gateway Device Telemetry Data Points Rate Limit")
        .transportGatewayDeviceTelemetryMsgRateLimit("Transport Gateway Device Telemetry Msg Rate Limit")
        .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
        .transportGatewayTelemetryDataPointsRateLimit("Transport Gateway Telemetry Data Points Rate Limit")
        .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
        .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
        .transportTenantTelemetryDataPointsRateLimit("Transport Tenant Telemetry Data Points Rate Limit")
        .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
        .warnThreshold(10.0d)
        .wsMsgQueueLimitPerSession(1)
        .wsUpdatesPerSessionRateLimit("2020-03-01")
        .build();
    when(tenantProfile.getDefaultProfileConfiguration()).thenReturn(buildResult);
    TbTenantProfileCache tenantProfileCache = mock(TbTenantProfileCache.class);
    when(tenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);
    DefaultWebSocketService defaultWebSocketService = new DefaultWebSocketService(oldSubService, entityDataSubService,
        mock(NotificationCommandsHandler.class), mock(WebSocketMsgEndpoint.class), mock(AccessValidator.class),
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        tenantProfileCache);

    SecurityUser securityCtx = new SecurityUser();
    securityCtx.setTenantId(new TenantId(UUID.randomUUID()));
    InetSocketAddress localAddress = InetSocketAddress.createUnresolved("foo", 1);
    WebSocketSessionRef sessionRef = new WebSocketSessionRef("42", securityCtx, localAddress,
        InetSocketAddress.createUnresolved("foo", 1), WebSocketSessionType.GENERAL);

    // Act
    defaultWebSocketService.handleSessionEvent(sessionRef, SessionEvent.onClosed());

    // Assert
    verify(tenantProfile).getDefaultProfileConfiguration();
    verify(tenantProfileCache).get(isA(TenantId.class));
    verify(entityDataSubService).cancelAllSessionSubscriptions(eq("42"));
    verify(oldSubService).cancelAllSessionSubscriptions(isA(TenantId.class), eq("42"));
  }

  /**
   * Test
   * {@link DefaultWebSocketService#handleSessionEvent(WebSocketSessionRef, SessionEvent)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultWebSocketService#handleSessionEvent(WebSocketSessionRef, SessionEvent)}
   */
  @Test
  @DisplayName("Test handleSessionEvent(WebSocketSessionRef, SessionEvent); then throw RuntimeException")
  void testHandleSessionEvent_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLocalSubscriptionService oldSubService = mock(TbLocalSubscriptionService.class);
    doNothing().when(oldSubService).cancelAllSessionSubscriptions(Mockito.<TenantId>any(), Mockito.<String>any());
    TbEntityDataSubscriptionService entityDataSubService = mock(TbEntityDataSubscriptionService.class);
    doNothing().when(entityDataSubService).cancelAllSessionSubscriptions(Mockito.<String>any());
    TbTenantProfileCache tenantProfileCache = mock(TbTenantProfileCache.class);
    when(tenantProfileCache.get(Mockito.<TenantId>any())).thenThrow(new RuntimeException("[{}] Processing: {}"));
    DefaultWebSocketService defaultWebSocketService = new DefaultWebSocketService(oldSubService, entityDataSubService,
        mock(NotificationCommandsHandler.class), mock(WebSocketMsgEndpoint.class), mock(AccessValidator.class),
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        tenantProfileCache);
    SecurityUser securityCtx = new SecurityUser();
    InetSocketAddress localAddress = InetSocketAddress.createUnresolved("foo", 1);
    WebSocketSessionRef sessionRef = new WebSocketSessionRef("42", securityCtx, localAddress,
        InetSocketAddress.createUnresolved("foo", 1), WebSocketSessionType.GENERAL);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultWebSocketService.handleSessionEvent(sessionRef, SessionEvent.onClosed()));
    verify(tenantProfileCache).get((TenantId) isNull());
    verify(entityDataSubService).cancelAllSessionSubscriptions(eq("42"));
    verify(oldSubService).cancelAllSessionSubscriptions(isNull(), eq("42"));
  }

  /**
   * Test
   * {@link DefaultWebSocketService#handleCommands(WebSocketSessionRef, WsCommandsWrapper)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultWebSocketService#handleCommands(WebSocketSessionRef, WsCommandsWrapper)}
   */
  @Test
  @DisplayName("Test handleCommands(WebSocketSessionRef, WsCommandsWrapper); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  void testHandleCommands_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultWebSocketService defaultWebSocketService = new DefaultWebSocketService(
        mock(TbLocalSubscriptionService.class), mock(TbEntityDataSubscriptionService.class),
        mock(NotificationCommandsHandler.class), mock(WebSocketMsgEndpoint.class), mock(AccessValidator.class),
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        mock(TbTenantProfileCache.class));
    SecurityUser securityCtx = new SecurityUser();
    InetSocketAddress localAddress = InetSocketAddress.createUnresolved("foo", 1);
    WebSocketSessionRef sessionRef = new WebSocketSessionRef("42", securityCtx, localAddress,
        InetSocketAddress.createUnresolved("foo", 1), WebSocketSessionType.GENERAL);

    WsCommandsWrapper commandsWrapper = mock(WsCommandsWrapper.class);
    when(commandsWrapper.getCmds()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultWebSocketService.handleCommands(sessionRef, commandsWrapper));
    verify(commandsWrapper).getCmds();
  }

  /**
   * Test
   * {@link DefaultWebSocketService#sendUpdate(String, int, TelemetrySubscriptionUpdate)}
   * with {@code String}, {@code int}, {@code TelemetrySubscriptionUpdate}.
   * <p>
   * Method under test:
   * {@link DefaultWebSocketService#sendUpdate(String, int, TelemetrySubscriptionUpdate)}
   */
  @Test
  @DisplayName("Test sendUpdate(String, int, TelemetrySubscriptionUpdate) with 'String', 'int', 'TelemetrySubscriptionUpdate'")
  void testSendUpdateWithStringIntTelemetrySubscriptionUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultWebSocketService defaultWebSocketService = new DefaultWebSocketService(
        mock(TbLocalSubscriptionService.class), mock(TbEntityDataSubscriptionService.class),
        mock(NotificationCommandsHandler.class), mock(WebSocketMsgEndpoint.class), mock(AccessValidator.class),
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        mock(TbTenantProfileCache.class));
    TelemetrySubscriptionUpdate update = mock(TelemetrySubscriptionUpdate.class);
    when(update.copyWithNewSubscriptionId(anyInt()))
        .thenReturn(new TelemetrySubscriptionUpdate(1, SubscriptionErrorCode.NO_ERROR));

    // Act
    defaultWebSocketService.sendUpdate("42", 1, update);

    // Assert that nothing has changed
    verify(update).copyWithNewSubscriptionId(eq(1));
  }

  /**
   * Test {@link DefaultWebSocketService#cleanupIfStale(TenantId, String)}.
   * <ul>
   *   <li>Given {@link WebSocketMsgEndpoint}
   * {@link WebSocketMsgEndpoint#isOpen(String)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultWebSocketService#cleanupIfStale(TenantId, String)}
   */
  @Test
  @DisplayName("Test cleanupIfStale(TenantId, String); given WebSocketMsgEndpoint isOpen(String) return 'true'")
  void testCleanupIfStale_givenWebSocketMsgEndpointIsOpenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketMsgEndpoint msgEndpoint = mock(WebSocketMsgEndpoint.class);
    when(msgEndpoint.isOpen(Mockito.<String>any())).thenReturn(true);
    DefaultWebSocketService defaultWebSocketService = new DefaultWebSocketService(
        mock(TbLocalSubscriptionService.class), mock(TbEntityDataSubscriptionService.class),
        mock(NotificationCommandsHandler.class), msgEndpoint, mock(AccessValidator.class),
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        mock(TbTenantProfileCache.class));

    // Act
    defaultWebSocketService.cleanupIfStale(new TenantId(UUID.randomUUID()), "42");

    // Assert
    verify(msgEndpoint).isOpen(eq("42"));
  }

  /**
   * Test {@link DefaultWebSocketService#cleanupIfStale(TenantId, String)}.
   * <ul>
   *   <li>Then calls
   * {@link TbEntityDataSubscriptionService#cancelAllSessionSubscriptions(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultWebSocketService#cleanupIfStale(TenantId, String)}
   */
  @Test
  @DisplayName("Test cleanupIfStale(TenantId, String); then calls cancelAllSessionSubscriptions(String)")
  void testCleanupIfStale_thenCallsCancelAllSessionSubscriptions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbLocalSubscriptionService oldSubService = mock(TbLocalSubscriptionService.class);
    doNothing().when(oldSubService).cancelAllSessionSubscriptions(Mockito.<TenantId>any(), Mockito.<String>any());
    TbEntityDataSubscriptionService entityDataSubService = mock(TbEntityDataSubscriptionService.class);
    doNothing().when(entityDataSubService).cancelAllSessionSubscriptions(Mockito.<String>any());
    WebSocketMsgEndpoint msgEndpoint = mock(WebSocketMsgEndpoint.class);
    when(msgEndpoint.isOpen(Mockito.<String>any())).thenReturn(false);
    DefaultWebSocketService defaultWebSocketService = new DefaultWebSocketService(oldSubService, entityDataSubService,
        mock(NotificationCommandsHandler.class), msgEndpoint, mock(AccessValidator.class),
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        mock(TbTenantProfileCache.class));

    // Act
    defaultWebSocketService.cleanupIfStale(new TenantId(UUID.randomUUID()), "42");

    // Assert
    verify(entityDataSubService).cancelAllSessionSubscriptions(eq("42"));
    verify(oldSubService).cancelAllSessionSubscriptions(isA(TenantId.class), eq("42"));
    verify(msgEndpoint).isOpen(eq("42"));
  }

  /**
   * Test {@link DefaultWebSocketService#cleanupIfStale(TenantId, String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultWebSocketService#cleanupIfStale(TenantId, String)}
   */
  @Test
  @DisplayName("Test cleanupIfStale(TenantId, String); then throw RuntimeException")
  void testCleanupIfStale_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    WebSocketMsgEndpoint msgEndpoint = mock(WebSocketMsgEndpoint.class);
    when(msgEndpoint.isOpen(Mockito.<String>any())).thenThrow(new RuntimeException("[{}] Cleaning up stale session "));
    DefaultWebSocketService defaultWebSocketService = new DefaultWebSocketService(
        mock(TbLocalSubscriptionService.class), mock(TbEntityDataSubscriptionService.class),
        mock(NotificationCommandsHandler.class), msgEndpoint, mock(AccessValidator.class),
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        mock(TbTenantProfileCache.class));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultWebSocketService.cleanupIfStale(new TenantId(UUID.randomUUID()), "42"));
    verify(msgEndpoint).isOpen(eq("42"));
  }

  /**
   * Test {@link DefaultWebSocketService#getAggregation(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code NONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultWebSocketService#getAggregation(String)}
   */
  @Test
  @DisplayName("Test getAggregation(String); when empty string; then return 'NONE'")
  void testGetAggregation_whenEmptyString_thenReturnNone() {
    // Arrange, Act and Assert
    assertEquals(Aggregation.NONE, DefaultWebSocketService.getAggregation(""));
  }

  /**
   * Test {@link DefaultWebSocketService#newCmdHandler(BiConsumer)}.
   * <p>
   * Method under test: {@link DefaultWebSocketService#newCmdHandler(BiConsumer)}
   */
  @Test
  @DisplayName("Test newCmdHandler(BiConsumer)")
  void testNewCmdHandler() {
    // Arrange
    BiConsumer<WebSocketSessionRef, WsCmd> handler = mock(BiConsumer.class);

    // Act
    DefaultWebSocketService.WsCmdHandler<WsCmd> actualNewCmdHandlerResult = DefaultWebSocketService
        .newCmdHandler(handler);

    // Assert
    assertSame(handler, actualNewCmdHandlerResult.getHandler());
  }

  /**
   * Test WsCmdHandler getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultWebSocketService.WsCmdHandler#WsCmdHandler(BiConsumer)}
   *   <li>{@link DefaultWebSocketService.WsCmdHandler#getHandler()}
   * </ul>
   */
  @Test
  @DisplayName("Test WsCmdHandler getters and setters")
  void testWsCmdHandlerGettersAndSetters() {
    // Arrange
    BiConsumer<WebSocketSessionRef, WsCmd> handler = mock(BiConsumer.class);

    // Act
    DefaultWebSocketService.WsCmdHandler<WsCmd> actualWsCmdHandler = new DefaultWebSocketService.WsCmdHandler<>(
        handler);

    // Assert
    assertSame(handler, actualWsCmdHandler.getHandler());
  }

  /**
   * Test WsCmdHandler {@link WsCmdHandler#handle(WebSocketSessionRef, WsCmd)}.
   * <p>
   * Method under test:
   * {@link DefaultWebSocketService.WsCmdHandler#handle(WebSocketSessionRef, WsCmd)}
   */
  @Test
  @DisplayName("Test WsCmdHandler handle(WebSocketSessionRef, WsCmd)")
  void testWsCmdHandlerHandle() {
    // Arrange
    doNothing().when(biConsumer).accept(Mockito.<WebSocketSessionRef>any(), Mockito.<WsCmd>any());
    SecurityUser securityCtx = new SecurityUser();
    InetSocketAddress localAddress = InetSocketAddress.createUnresolved("foo", 1);
    WebSocketSessionRef sessionRef = new WebSocketSessionRef("42", securityCtx, localAddress,
        InetSocketAddress.createUnresolved("foo", 1), WebSocketSessionType.GENERAL);

    // Act
    wsCmdHandler.handle(sessionRef, new AuthCmd(1, "ABC123"));

    // Assert that nothing has changed
    verify(biConsumer).accept(isA(WebSocketSessionRef.class), isA(WsCmd.class));
  }
}
