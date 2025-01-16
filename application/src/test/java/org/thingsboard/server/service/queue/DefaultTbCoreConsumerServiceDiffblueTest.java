package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.msg.queue.TbCallback;
import org.thingsboard.server.common.stats.StatsCounter;
import org.thingsboard.server.common.stats.StatsFactory;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.discovery.PartitionService;
import org.thingsboard.server.queue.provider.TbCoreQueueFactory;
import org.thingsboard.server.service.apiusage.TbApiUsageStateService;
import org.thingsboard.server.service.notification.NotificationSchedulerService;
import org.thingsboard.server.service.ota.OtaPackageStateService;
import org.thingsboard.server.service.profile.TbAssetProfileCache;
import org.thingsboard.server.service.profile.TbDeviceProfileCache;
import org.thingsboard.server.service.queue.DefaultTbCoreConsumerService.CoreQueueConfig;
import org.thingsboard.server.service.resource.TbImageService;
import org.thingsboard.server.service.rpc.TbCoreDeviceRpcService;
import org.thingsboard.server.service.ruleengine.RuleEngineCallService;
import org.thingsboard.server.service.security.auth.jwt.settings.JwtSettingsService;
import org.thingsboard.server.service.state.DeviceStateService;
import org.thingsboard.server.service.subscription.SubscriptionManagerService;
import org.thingsboard.server.service.subscription.TbLocalSubscriptionService;
import org.thingsboard.server.service.sync.vc.GitVersionControlQueueService;

class DefaultTbCoreConsumerServiceDiffblueTest {
  /**
   * Test CoreQueueConfig {@link CoreQueueConfig#equals(Object)}, and
   * {@link CoreQueueConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultTbCoreConsumerService.CoreQueueConfig#equals(Object)}
   *   <li>{@link DefaultTbCoreConsumerService.CoreQueueConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test CoreQueueConfig equals(Object), and hashCode(); when other is equal; then return equal")
  void testCoreQueueConfigEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DefaultTbCoreConsumerService.CoreQueueConfig ofResult = DefaultTbCoreConsumerService.CoreQueueConfig.of(true, 42);
    DefaultTbCoreConsumerService.CoreQueueConfig ofResult2 = DefaultTbCoreConsumerService.CoreQueueConfig.of(true, 42);

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Test CoreQueueConfig {@link CoreQueueConfig#equals(Object)}, and
   * {@link CoreQueueConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultTbCoreConsumerService.CoreQueueConfig#equals(Object)}
   *   <li>{@link DefaultTbCoreConsumerService.CoreQueueConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test CoreQueueConfig equals(Object), and hashCode(); when other is same; then return equal")
  void testCoreQueueConfigEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DefaultTbCoreConsumerService.CoreQueueConfig ofResult = DefaultTbCoreConsumerService.CoreQueueConfig.of(true, 42);

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Test CoreQueueConfig {@link CoreQueueConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbCoreConsumerService.CoreQueueConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test CoreQueueConfig equals(Object); when other is different; then return not equal")
  void testCoreQueueConfigEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DefaultTbCoreConsumerService.CoreQueueConfig ofResult = DefaultTbCoreConsumerService.CoreQueueConfig.of(false, 42);

    // Act and Assert
    assertNotEquals(ofResult, DefaultTbCoreConsumerService.CoreQueueConfig.of(true, 42));
  }

  /**
   * Test CoreQueueConfig {@link CoreQueueConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbCoreConsumerService.CoreQueueConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test CoreQueueConfig equals(Object); when other is different; then return not equal")
  void testCoreQueueConfigEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DefaultTbCoreConsumerService.CoreQueueConfig ofResult = DefaultTbCoreConsumerService.CoreQueueConfig.of(true, 1);

    // Act and Assert
    assertNotEquals(ofResult, DefaultTbCoreConsumerService.CoreQueueConfig.of(true, 42));
  }

  /**
   * Test CoreQueueConfig {@link CoreQueueConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbCoreConsumerService.CoreQueueConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test CoreQueueConfig equals(Object); when other is 'null'; then return not equal")
  void testCoreQueueConfigEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DefaultTbCoreConsumerService.CoreQueueConfig.of(true, 42), null);
  }

  /**
   * Test CoreQueueConfig {@link CoreQueueConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbCoreConsumerService.CoreQueueConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test CoreQueueConfig equals(Object); when other is wrong type; then return not equal")
  void testCoreQueueConfigEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DefaultTbCoreConsumerService.CoreQueueConfig.of(true, 42), "Different type to CoreQueueConfig");
  }

  /**
   * Test CoreQueueConfig getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultTbCoreConsumerService.CoreQueueConfig#toString()}
   *   <li>{@link DefaultTbCoreConsumerService.CoreQueueConfig#getPollInterval()}
   *   <li>
   * {@link DefaultTbCoreConsumerService.CoreQueueConfig#isConsumerPerPartition()}
   * </ul>
   */
  @Test
  @DisplayName("Test CoreQueueConfig getters and setters")
  void testCoreQueueConfigGettersAndSetters() {
    // Arrange
    DefaultTbCoreConsumerService.CoreQueueConfig ofResult = DefaultTbCoreConsumerService.CoreQueueConfig.of(true, 42);

    // Act
    String actualToStringResult = ofResult.toString();
    int actualPollInterval = ofResult.getPollInterval();

    // Assert
    assertEquals("DefaultTbCoreConsumerService.CoreQueueConfig(consumerPerPartition=true, pollInterval=42)",
        actualToStringResult);
    assertEquals(42, actualPollInterval);
    assertTrue(ofResult.isConsumerPerPartition());
  }

  /**
   * Test CoreQueueConfig {@link CoreQueueConfig#of(boolean, int)}.
   * <p>
   * Method under test:
   * {@link DefaultTbCoreConsumerService.CoreQueueConfig#of(boolean, int)}
   */
  @Test
  @DisplayName("Test CoreQueueConfig of(boolean, int)")
  void testCoreQueueConfigOf() {
    // Arrange and Act
    DefaultTbCoreConsumerService.CoreQueueConfig actualOfResult = DefaultTbCoreConsumerService.CoreQueueConfig.of(true,
        42);

    // Assert
    assertEquals(42, actualOfResult.getPollInterval());
    assertTrue(actualOfResult.isConsumerPerPartition());
  }

  /**
   * Test {@link DefaultTbCoreConsumerService#getMgmtThreadPoolSize()}.
   * <p>
   * Method under test:
   * {@link DefaultTbCoreConsumerService#getMgmtThreadPoolSize()}
   */
  @Test
  @DisplayName("Test getMgmtThreadPoolSize()")
  void testGetMgmtThreadPoolSize() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatsFactory statsFactory = mock(StatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));

    // Act
    int actualMgmtThreadPoolSize = (new DefaultTbCoreConsumerService(mock(TbCoreQueueFactory.class),
        mock(ActorSystemContext.class), mock(DeviceStateService.class), mock(TbLocalSubscriptionService.class),
        mock(SubscriptionManagerService.class), mock(TbCoreDeviceRpcService.class), statsFactory,
        mock(TbDeviceProfileCache.class), mock(TbAssetProfileCache.class), mock(TbApiUsageStateService.class),
        mock(TbTenantProfileCache.class), mock(TbApiUsageStateService.class), mock(OtaPackageStateService.class),
        mock(GitVersionControlQueueService.class), mock(PartitionService.class), mock(ApplicationEventPublisher.class),
        mock(JwtSettingsService.class), mock(NotificationSchedulerService.class), mock(NotificationRuleProcessor.class),
        mock(TbImageService.class), mock(RuleEngineCallService.class))).getMgmtThreadPoolSize();

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("core"), Mockito.<String>any(), isA(String[].class));
    assertEquals(20, actualMgmtThreadPoolSize);
  }

  /**
   * Test {@link DefaultTbCoreConsumerService#printStats()}.
   * <p>
   * Method under test: {@link DefaultTbCoreConsumerService#printStats()}
   */
  @Test
  @DisplayName("Test printStats()")
  void testPrintStats() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatsFactory statsFactory = mock(StatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));

    // Act
    (new DefaultTbCoreConsumerService(mock(TbCoreQueueFactory.class), mock(ActorSystemContext.class),
        mock(DeviceStateService.class), mock(TbLocalSubscriptionService.class), mock(SubscriptionManagerService.class),
        mock(TbCoreDeviceRpcService.class), statsFactory, mock(TbDeviceProfileCache.class),
        mock(TbAssetProfileCache.class), mock(TbApiUsageStateService.class), mock(TbTenantProfileCache.class),
        mock(TbApiUsageStateService.class), mock(OtaPackageStateService.class),
        mock(GitVersionControlQueueService.class), mock(PartitionService.class), mock(ApplicationEventPublisher.class),
        mock(JwtSettingsService.class), mock(NotificationSchedulerService.class), mock(NotificationRuleProcessor.class),
        mock(TbImageService.class), mock(RuleEngineCallService.class))).printStats();

    // Assert that nothing has changed
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("core"), Mockito.<String>any(), isA(String[].class));
  }

  /**
   * Test
   * {@link DefaultTbCoreConsumerService#forwardToStateService(DeviceStateServiceMsgProto, TbCallback)}
   * with {@code deviceStateServiceMsg}, {@code callback}.
   * <p>
   * Method under test:
   * {@link DefaultTbCoreConsumerService#forwardToStateService(TransportProtos.DeviceStateServiceMsgProto, TbCallback)}
   */
  @Test
  @DisplayName("Test forwardToStateService(DeviceStateServiceMsgProto, TbCallback) with 'deviceStateServiceMsg', 'callback'")
  void testForwardToStateServiceWithDeviceStateServiceMsgCallback() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceStateService stateService = mock(DeviceStateService.class);
    doNothing().when(stateService)
        .onQueueMsg(Mockito.<TransportProtos.DeviceStateServiceMsgProto>any(), Mockito.<TbCallback>any());
    StatsFactory statsFactory = mock(StatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    DefaultTbCoreConsumerService defaultTbCoreConsumerService = new DefaultTbCoreConsumerService(
        mock(TbCoreQueueFactory.class), mock(ActorSystemContext.class), stateService,
        mock(TbLocalSubscriptionService.class), mock(SubscriptionManagerService.class),
        mock(TbCoreDeviceRpcService.class), statsFactory, mock(TbDeviceProfileCache.class),
        mock(TbAssetProfileCache.class), mock(TbApiUsageStateService.class), mock(TbTenantProfileCache.class),
        mock(TbApiUsageStateService.class), mock(OtaPackageStateService.class),
        mock(GitVersionControlQueueService.class), mock(PartitionService.class), mock(ApplicationEventPublisher.class),
        mock(JwtSettingsService.class), mock(NotificationSchedulerService.class), mock(NotificationRuleProcessor.class),
        mock(TbImageService.class), mock(RuleEngineCallService.class));
    TransportProtos.DeviceStateServiceMsgProto deviceStateServiceMsg = TransportProtos.DeviceStateServiceMsgProto
        .getDefaultInstance();
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act
    defaultTbCoreConsumerService.forwardToStateService(deviceStateServiceMsg, new TbPackCallback<>(id,
        new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>())));

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("core"), Mockito.<String>any(), isA(String[].class));
    verify(stateService).onQueueMsg(isA(TransportProtos.DeviceStateServiceMsgProto.class), isA(TbCallback.class));
  }

  /**
   * Test
   * {@link DefaultTbCoreConsumerService#forwardToRuleEngineCallService(RestApiCallResponseMsgProto, TbCallback)}.
   * <p>
   * Method under test:
   * {@link DefaultTbCoreConsumerService#forwardToRuleEngineCallService(TransportProtos.RestApiCallResponseMsgProto, TbCallback)}
   */
  @Test
  @DisplayName("Test forwardToRuleEngineCallService(RestApiCallResponseMsgProto, TbCallback)")
  void testForwardToRuleEngineCallService() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatsFactory statsFactory = mock(StatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    RuleEngineCallService ruleEngineCallService = mock(RuleEngineCallService.class);
    doNothing().when(ruleEngineCallService)
        .onQueueMsg(Mockito.<TransportProtos.RestApiCallResponseMsgProto>any(), Mockito.<TbCallback>any());
    DefaultTbCoreConsumerService defaultTbCoreConsumerService = new DefaultTbCoreConsumerService(
        mock(TbCoreQueueFactory.class), mock(ActorSystemContext.class), mock(DeviceStateService.class),
        mock(TbLocalSubscriptionService.class), mock(SubscriptionManagerService.class),
        mock(TbCoreDeviceRpcService.class), statsFactory, mock(TbDeviceProfileCache.class),
        mock(TbAssetProfileCache.class), mock(TbApiUsageStateService.class), mock(TbTenantProfileCache.class),
        mock(TbApiUsageStateService.class), mock(OtaPackageStateService.class),
        mock(GitVersionControlQueueService.class), mock(PartitionService.class), mock(ApplicationEventPublisher.class),
        mock(JwtSettingsService.class), mock(NotificationSchedulerService.class), mock(NotificationRuleProcessor.class),
        mock(TbImageService.class), ruleEngineCallService);
    TransportProtos.RestApiCallResponseMsgProto restApiCallResponseMsg = TransportProtos.RestApiCallResponseMsgProto
        .getDefaultInstance();
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act
    defaultTbCoreConsumerService.forwardToRuleEngineCallService(restApiCallResponseMsg, new TbPackCallback<>(id,
        new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>())));

    // Assert
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("core"), Mockito.<String>any(), isA(String[].class));
    verify(ruleEngineCallService).onQueueMsg(isA(TransportProtos.RestApiCallResponseMsgProto.class),
        isA(TbCallback.class));
  }

  /**
   * Test
   * {@link DefaultTbCoreConsumerService#forwardToRuleEngineCallService(RestApiCallResponseMsgProto, TbCallback)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbCoreConsumerService#forwardToRuleEngineCallService(TransportProtos.RestApiCallResponseMsgProto, TbCallback)}
   */
  @Test
  @DisplayName("Test forwardToRuleEngineCallService(RestApiCallResponseMsgProto, TbCallback); then throw RuntimeException")
  void testForwardToRuleEngineCallService_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    StatsFactory statsFactory = mock(StatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createStatsCounter(Mockito.<String>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new StatsCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER)), "Name"));
    RuleEngineCallService ruleEngineCallService = mock(RuleEngineCallService.class);
    doThrow(new RuntimeException("foo")).when(ruleEngineCallService)
        .onQueueMsg(Mockito.<TransportProtos.RestApiCallResponseMsgProto>any(), Mockito.<TbCallback>any());
    DefaultTbCoreConsumerService defaultTbCoreConsumerService = new DefaultTbCoreConsumerService(
        mock(TbCoreQueueFactory.class), mock(ActorSystemContext.class), mock(DeviceStateService.class),
        mock(TbLocalSubscriptionService.class), mock(SubscriptionManagerService.class),
        mock(TbCoreDeviceRpcService.class), statsFactory, mock(TbDeviceProfileCache.class),
        mock(TbAssetProfileCache.class), mock(TbApiUsageStateService.class), mock(TbTenantProfileCache.class),
        mock(TbApiUsageStateService.class), mock(OtaPackageStateService.class),
        mock(GitVersionControlQueueService.class), mock(PartitionService.class), mock(ApplicationEventPublisher.class),
        mock(JwtSettingsService.class), mock(NotificationSchedulerService.class), mock(NotificationRuleProcessor.class),
        mock(TbImageService.class), ruleEngineCallService);
    TransportProtos.RestApiCallResponseMsgProto restApiCallResponseMsg = TransportProtos.RestApiCallResponseMsgProto
        .getDefaultInstance();
    UUID id = UUID.randomUUID();
    CountDownLatch processingTimeoutLatch = new CountDownLatch(1);
    ConcurrentHashMap<UUID, Object> ackMap = new ConcurrentHashMap<>();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultTbCoreConsumerService.forwardToRuleEngineCallService(restApiCallResponseMsg, new TbPackCallback<>(
            id, new TbPackProcessingContext<>(processingTimeoutLatch, ackMap, new ConcurrentHashMap<>()))));
    verify(statsFactory, atLeast(1)).createStatsCounter(eq("core"), Mockito.<String>any(), isA(String[].class));
    verify(ruleEngineCallService).onQueueMsg(isA(TransportProtos.RestApiCallResponseMsgProto.class),
        isA(TbCallback.class));
  }
}
