package org.thingsboard.server.service.subscription;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.cache.limits.RateLimitService;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.common.data.limit.LimitedApi;
import org.thingsboard.server.common.msg.queue.TbCallback;
import org.thingsboard.server.common.msg.tools.TbRateLimitsException;
import org.thingsboard.server.dao.attributes.AttributesService;
import org.thingsboard.server.dao.timeseries.TimeseriesService;
import org.thingsboard.server.queue.discovery.PartitionService;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.service.queue.TbPackCallback;
import org.thingsboard.server.service.queue.TbPackProcessingContext;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.ws.WebSocketService;
import org.thingsboard.server.service.ws.WebSocketSessionRef;
import org.thingsboard.server.service.ws.WebSocketSessionType;
import org.thingsboard.server.service.ws.telemetry.sub.AlarmSubscriptionUpdate;

class DefaultTbLocalSubscriptionServiceDiffblueTest {
  /**
   * Test {@link DefaultTbLocalSubscriptionService#initExecutor()}.
   * <ul>
   *   <li>Given {@link TbServiceInfoProvider}
   * {@link TbServiceInfoProvider#getServiceId()} return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbLocalSubscriptionService#initExecutor()}
   */
  @Test
  @DisplayName("Test initExecutor(); given TbServiceInfoProvider getServiceId() return '42'")
  void testInitExecutor_givenTbServiceInfoProviderGetServiceIdReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbServiceInfoProvider serviceInfoProvider = mock(TbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");

    // Act
    (new DefaultTbLocalSubscriptionService(mock(AttributesService.class), mock(TimeseriesService.class),
        serviceInfoProvider, mock(PartitionService.class), mock(TbClusterService.class),
        mock(SubscriptionManagerService.class), mock(WebSocketService.class), mock(RateLimitService.class)))
        .initExecutor();

    // Assert
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test {@link DefaultTbLocalSubscriptionService#initExecutor()}.
   * <ul>
   *   <li>Then throw {@link TbRateLimitsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbLocalSubscriptionService#initExecutor()}
   */
  @Test
  @DisplayName("Test initExecutor(); then throw TbRateLimitsException")
  void testInitExecutor_thenThrowTbRateLimitsException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbServiceInfoProvider serviceInfoProvider = mock(TbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenThrow(new TbRateLimitsException("An error occurred"));

    // Act and Assert
    assertThrows(TbRateLimitsException.class,
        () -> (new DefaultTbLocalSubscriptionService(mock(AttributesService.class), mock(TimeseriesService.class),
            serviceInfoProvider, mock(PartitionService.class), mock(TbClusterService.class),
            mock(SubscriptionManagerService.class), mock(WebSocketService.class), mock(RateLimitService.class)))
            .initExecutor());
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test {@link DefaultTbLocalSubscriptionService#getSubsLock(TenantId)}.
   * <p>
   * Method under test:
   * {@link DefaultTbLocalSubscriptionService#getSubsLock(TenantId)}
   */
  @Test
  @DisplayName("Test getSubsLock(TenantId)")
  void testGetSubsLock() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbLocalSubscriptionService defaultTbLocalSubscriptionService = new DefaultTbLocalSubscriptionService(
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        mock(PartitionService.class), mock(TbClusterService.class), mock(SubscriptionManagerService.class),
        mock(WebSocketService.class), mock(RateLimitService.class));

    // Act
    Lock actualSubsLock = defaultTbLocalSubscriptionService.getSubsLock(new TenantId(UUID.randomUUID()));

    // Assert
    assertTrue(actualSubsLock instanceof ReentrantLock);
    assertEquals(0, ((ReentrantLock) actualSubsLock).getHoldCount());
    assertEquals(0, ((ReentrantLock) actualSubsLock).getQueueLength());
    assertFalse(((ReentrantLock) actualSubsLock).hasQueuedThreads());
    assertFalse(((ReentrantLock) actualSubsLock).isFair());
    assertFalse(((ReentrantLock) actualSubsLock).isHeldByCurrentThread());
    assertFalse(((ReentrantLock) actualSubsLock).isLocked());
  }

  /**
   * Test
   * {@link DefaultTbLocalSubscriptionService#addSubscription(TbSubscription, WebSocketSessionRef)}.
   * <p>
   * Method under test:
   * {@link DefaultTbLocalSubscriptionService#addSubscription(TbSubscription, WebSocketSessionRef)}
   */
  @Test
  @DisplayName("Test addSubscription(TbSubscription, WebSocketSessionRef)")
  void testAddSubscription() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RateLimitService rateLimitService = mock(RateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenThrow(new TbRateLimitsException("An error occurred"));
    DefaultTbLocalSubscriptionService defaultTbLocalSubscriptionService = new DefaultTbLocalSubscriptionService(
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        mock(PartitionService.class), mock(TbClusterService.class), mock(SubscriptionManagerService.class),
        mock(WebSocketService.class), rateLimitService);

    // Act and Assert
    assertThrows(TbRateLimitsException.class,
        () -> defaultTbLocalSubscriptionService.addSubscription(
            new TbAlarmsSubscription("42", "42", 1, new TenantId(UUID.randomUUID()), null, mock(BiConsumer.class), 1L),
            null));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.WS_SUBSCRIPTIONS), isA(Object.class), (String) isNull());
  }

  /**
   * Test
   * {@link DefaultTbLocalSubscriptionService#addSubscription(TbSubscription, WebSocketSessionRef)}.
   * <p>
   * Method under test:
   * {@link DefaultTbLocalSubscriptionService#addSubscription(TbSubscription, WebSocketSessionRef)}
   */
  @Test
  @DisplayName("Test addSubscription(TbSubscription, WebSocketSessionRef)")
  void testAddSubscription2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RateLimitService rateLimitService = mock(RateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(false);
    DefaultTbLocalSubscriptionService defaultTbLocalSubscriptionService = new DefaultTbLocalSubscriptionService(
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        mock(PartitionService.class), mock(TbClusterService.class), mock(SubscriptionManagerService.class),
        mock(WebSocketService.class), rateLimitService);
    TbSubscription<?> subscription = mock(TbSubscription.class);
    when(subscription.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(subscription.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("Exceeded rate limit for WS subscriptions per tenant")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act and Assert
    assertThrows(TbRateLimitsException.class,
        () -> defaultTbLocalSubscriptionService.addSubscription(subscription, sessionRef));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.WS_SUBSCRIPTIONS), isA(Object.class), (String) isNull());
    verify(subscription).getEntityId();
    verify(subscription).getTenantId();
  }

  /**
   * Test
   * {@link DefaultTbLocalSubscriptionService#addSubscription(TbSubscription, WebSocketSessionRef)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link TbSubscription#getSessionId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbLocalSubscriptionService#addSubscription(TbSubscription, WebSocketSessionRef)}
   */
  @Test
  @DisplayName("Test addSubscription(TbSubscription, WebSocketSessionRef); given one; then calls getSessionId()")
  void testAddSubscription_givenOne_thenCallsGetSessionId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RateLimitService rateLimitService = mock(RateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(true);
    DefaultTbLocalSubscriptionService defaultTbLocalSubscriptionService = new DefaultTbLocalSubscriptionService(
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        mock(PartitionService.class), mock(TbClusterService.class), mock(SubscriptionManagerService.class),
        mock(WebSocketService.class), rateLimitService);
    TbSubscription<?> subscription = mock(TbSubscription.class);
    when(subscription.getSubscriptionId()).thenReturn(1);
    when(subscription.getType()).thenReturn(TbSubscriptionType.TIMESERIES);
    when(subscription.getSessionId()).thenReturn("42");
    when(subscription.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(subscription.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act
    defaultTbLocalSubscriptionService.addSubscription(subscription, sessionRef);

    // Assert
    verify(rateLimitService, atLeast(1)).checkRateLimit(eq(LimitedApi.WS_SUBSCRIPTIONS), Mockito.<Object>any(),
        (String) isNull());
    verify(subscription).getEntityId();
    verify(subscription).getSessionId();
    verify(subscription, atLeast(1)).getSubscriptionId();
    verify(subscription).getTenantId();
    verify(subscription).getType();
  }

  /**
   * Test
   * {@link DefaultTbLocalSubscriptionService#addSubscription(TbSubscription, WebSocketSessionRef)}.
   * <ul>
   *   <li>Given {@link RateLimitService}
   * {@link RateLimitService#checkRateLimit(LimitedApi, Object, String)} return
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbLocalSubscriptionService#addSubscription(TbSubscription, WebSocketSessionRef)}
   */
  @Test
  @DisplayName("Test addSubscription(TbSubscription, WebSocketSessionRef); given RateLimitService checkRateLimit(LimitedApi, Object, String) return 'true'")
  void testAddSubscription_givenRateLimitServiceCheckRateLimitReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RateLimitService rateLimitService = mock(RateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(true);
    DefaultTbLocalSubscriptionService defaultTbLocalSubscriptionService = new DefaultTbLocalSubscriptionService(
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        mock(PartitionService.class), mock(TbClusterService.class), mock(SubscriptionManagerService.class),
        mock(WebSocketService.class), rateLimitService);
    TbAlarmsSubscription subscription = new TbAlarmsSubscription("42", "42", 1, new TenantId(UUID.randomUUID()), null,
        mock(BiConsumer.class), 1L);

    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act
    defaultTbLocalSubscriptionService.addSubscription(subscription, sessionRef);

    // Assert
    verify(rateLimitService, atLeast(1)).checkRateLimit(eq(LimitedApi.WS_SUBSCRIPTIONS), Mockito.<Object>any(),
        (String) isNull());
  }

  /**
   * Test
   * {@link DefaultTbLocalSubscriptionService#addSubscription(TbSubscription, WebSocketSessionRef)}.
   * <ul>
   *   <li>Then throw {@link TbRateLimitsException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbLocalSubscriptionService#addSubscription(TbSubscription, WebSocketSessionRef)}
   */
  @Test
  @DisplayName("Test addSubscription(TbSubscription, WebSocketSessionRef); then throw TbRateLimitsException")
  void testAddSubscription_thenThrowTbRateLimitsException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RateLimitService rateLimitService = mock(RateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(false);
    DefaultTbLocalSubscriptionService defaultTbLocalSubscriptionService = new DefaultTbLocalSubscriptionService(
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        mock(PartitionService.class), mock(TbClusterService.class), mock(SubscriptionManagerService.class),
        mock(WebSocketService.class), rateLimitService);
    TbSubscription<?> subscription = mock(TbSubscription.class);
    when(subscription.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(subscription.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    WebSocketSessionRef.WebSocketSessionRefBuilder builderResult = WebSocketSessionRef.builder();
    WebSocketSessionRef.WebSocketSessionRefBuilder localAddressResult = builderResult
        .localAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef.WebSocketSessionRefBuilder remoteAddressResult = localAddressResult
        .remoteAddress(InetSocketAddress.createUnresolved("foo", 1));
    WebSocketSessionRef sessionRef = remoteAddressResult.securityCtx(new SecurityUser())
        .sessionId("42")
        .sessionType(WebSocketSessionType.GENERAL)
        .build();

    // Act and Assert
    assertThrows(TbRateLimitsException.class,
        () -> defaultTbLocalSubscriptionService.addSubscription(subscription, sessionRef));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.WS_SUBSCRIPTIONS), isA(Object.class), (String) isNull());
    verify(subscription).getEntityId();
    verify(subscription).getTenantId();
  }

  /**
   * Test
   * {@link DefaultTbLocalSubscriptionService#onTimeSeriesUpdate(EntityId, List, TbCallback)}
   * with {@code EntityId}, {@code List}, {@code TbCallback}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbLocalSubscriptionService#onTimeSeriesUpdate(EntityId, List, TbCallback)}
   */
  @Test
  @DisplayName("Test onTimeSeriesUpdate(EntityId, List, TbCallback) with 'EntityId', 'List', 'TbCallback'; then calls getId()")
  void testOnTimeSeriesUpdateWithEntityIdListTbCallback_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbLocalSubscriptionService defaultTbLocalSubscriptionService = new DefaultTbLocalSubscriptionService(
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        mock(PartitionService.class), mock(TbClusterService.class), mock(SubscriptionManagerService.class),
        mock(WebSocketService.class), mock(RateLimitService.class));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    ArrayList<TsKvEntry> data = new ArrayList<>();
    data.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act
    defaultTbLocalSubscriptionService.onTimeSeriesUpdate(entityId, data, new TbPackCallback<>(id,
        new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>())));

    // Assert
    verify(entityId).getId();
  }

  /**
   * Test
   * {@link DefaultTbLocalSubscriptionService#onTimeSeriesUpdate(EntityId, List, TbCallback)}
   * with {@code EntityId}, {@code List}, {@code TbCallback}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbLocalSubscriptionService#onTimeSeriesUpdate(EntityId, List, TbCallback)}
   */
  @Test
  @DisplayName("Test onTimeSeriesUpdate(EntityId, List, TbCallback) with 'EntityId', 'List', 'TbCallback'; then calls getId()")
  void testOnTimeSeriesUpdateWithEntityIdListTbCallback_thenCallsGetId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbLocalSubscriptionService defaultTbLocalSubscriptionService = new DefaultTbLocalSubscriptionService(
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        mock(PartitionService.class), mock(TbClusterService.class), mock(SubscriptionManagerService.class),
        mock(WebSocketService.class), mock(RateLimitService.class));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    ArrayList<TsKvEntry> data = new ArrayList<>();
    data.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
    data.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act
    defaultTbLocalSubscriptionService.onTimeSeriesUpdate(entityId, data, new TbPackCallback<>(id,
        new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>())));

    // Assert
    verify(entityId).getId();
  }

  /**
   * Test
   * {@link DefaultTbLocalSubscriptionService#onAttributesUpdate(EntityId, String, List, TbCallback)}
   * with {@code EntityId}, {@code String}, {@code List}, {@code TbCallback}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbLocalSubscriptionService#onAttributesUpdate(EntityId, String, List, TbCallback)}
   */
  @Test
  @DisplayName("Test onAttributesUpdate(EntityId, String, List, TbCallback) with 'EntityId', 'String', 'List', 'TbCallback'; then calls getId()")
  void testOnAttributesUpdateWithEntityIdStringListTbCallback_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbLocalSubscriptionService defaultTbLocalSubscriptionService = new DefaultTbLocalSubscriptionService(
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        mock(PartitionService.class), mock(TbClusterService.class), mock(SubscriptionManagerService.class),
        mock(WebSocketService.class), mock(RateLimitService.class));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    ArrayList<TsKvEntry> data = new ArrayList<>();
    data.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act
    defaultTbLocalSubscriptionService.onAttributesUpdate(entityId, "Scope", data, new TbPackCallback<>(id,
        new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>())));

    // Assert
    verify(entityId).getId();
  }

  /**
   * Test
   * {@link DefaultTbLocalSubscriptionService#onAttributesUpdate(EntityId, String, List, TbCallback)}
   * with {@code EntityId}, {@code String}, {@code List}, {@code TbCallback}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbLocalSubscriptionService#onAttributesUpdate(EntityId, String, List, TbCallback)}
   */
  @Test
  @DisplayName("Test onAttributesUpdate(EntityId, String, List, TbCallback) with 'EntityId', 'String', 'List', 'TbCallback'; then calls getId()")
  void testOnAttributesUpdateWithEntityIdStringListTbCallback_thenCallsGetId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbLocalSubscriptionService defaultTbLocalSubscriptionService = new DefaultTbLocalSubscriptionService(
        mock(AttributesService.class), mock(TimeseriesService.class), mock(TbServiceInfoProvider.class),
        mock(PartitionService.class), mock(TbClusterService.class), mock(SubscriptionManagerService.class),
        mock(WebSocketService.class), mock(RateLimitService.class));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.randomUUID());

    ArrayList<TsKvEntry> data = new ArrayList<>();
    data.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
    data.add(new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act
    defaultTbLocalSubscriptionService.onAttributesUpdate(entityId, "Scope", data, new TbPackCallback<>(id,
        new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>())));

    // Assert
    verify(entityId).getId();
  }
}
