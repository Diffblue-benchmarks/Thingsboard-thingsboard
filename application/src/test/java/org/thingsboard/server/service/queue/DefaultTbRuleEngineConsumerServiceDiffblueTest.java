package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.msg.plugin.ComponentLifecycleMsg;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.dao.queue.QueueService;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.queue.discovery.PartitionService;
import org.thingsboard.server.queue.discovery.QueueKey;
import org.thingsboard.server.queue.discovery.event.PartitionChangeEvent;
import org.thingsboard.server.service.apiusage.TbApiUsageStateService;
import org.thingsboard.server.service.profile.TbAssetProfileCache;
import org.thingsboard.server.service.profile.TbDeviceProfileCache;
import org.thingsboard.server.service.queue.ruleengine.TbRuleEngineConsumerContext;
import org.thingsboard.server.service.rpc.TbRuleEngineDeviceRpcService;
import org.thingsboard.server.service.security.auth.jwt.settings.JwtSettingsService;

class DefaultTbRuleEngineConsumerServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultTbRuleEngineConsumerService#onTbApplicationEvent(PartitionChangeEvent)}
   * with {@code PartitionChangeEvent}.
   * <p>
   * Method under test:
   * {@link DefaultTbRuleEngineConsumerService#onTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName("Test onTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'")
  void testOnTbApplicationEventWithPartitionChangeEvent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    QueueService queueService = mock(QueueService.class);
    when(queueService.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);
    PartitionService partitionService = mock(PartitionService.class);
    when(partitionService.isManagedByCurrentService(Mockito.<TenantId>any())).thenReturn(true);
    DefaultTbRuleEngineConsumerService defaultTbRuleEngineConsumerService = new DefaultTbRuleEngineConsumerService(
        mock(TbRuleEngineConsumerContext.class), mock(ActorSystemContext.class),
        mock(TbRuleEngineDeviceRpcService.class), queueService, mock(TbDeviceProfileCache.class),
        mock(TbAssetProfileCache.class), mock(TbTenantProfileCache.class), mock(TbApiUsageStateService.class),
        partitionService, mock(ApplicationEventPublisher.class), mock(JwtSettingsService.class));

    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);
    partitionsMap.put(queueKey, new HashSet<>());

    // Act
    defaultTbRuleEngineConsumerService
        .onTbApplicationEvent(new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap));

    // Assert
    verify(queueService).findQueueByTenantIdAndName(isA(TenantId.class), eq("Main"));
    verify(partitionService).isManagedByCurrentService(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DefaultTbRuleEngineConsumerService#onTbApplicationEvent(PartitionChangeEvent)}
   * with {@code PartitionChangeEvent}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleEngineConsumerService#onTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName("Test onTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'; then throw RuntimeException")
  void testOnTbApplicationEventWithPartitionChangeEvent_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbRuleEngineConsumerContext ctx = mock(TbRuleEngineConsumerContext.class);
    when(ctx.getQueueFactory()).thenThrow(new RuntimeException("foo"));
    QueueService queueService = mock(QueueService.class);
    when(queueService.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new Queue());
    PartitionService partitionService = mock(PartitionService.class);
    when(partitionService.isManagedByCurrentService(Mockito.<TenantId>any())).thenReturn(true);
    DefaultTbRuleEngineConsumerService defaultTbRuleEngineConsumerService = new DefaultTbRuleEngineConsumerService(ctx,
        mock(ActorSystemContext.class), mock(TbRuleEngineDeviceRpcService.class), queueService,
        mock(TbDeviceProfileCache.class), mock(TbAssetProfileCache.class), mock(TbTenantProfileCache.class),
        mock(TbApiUsageStateService.class), partitionService, mock(ApplicationEventPublisher.class),
        mock(JwtSettingsService.class));

    HashMap<QueueKey, Set<TopicPartitionInfo>> partitionsMap = new HashMap<>();
    QueueKey queueKey = new QueueKey(ServiceType.TB_CORE);
    partitionsMap.put(queueKey, new HashSet<>());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultTbRuleEngineConsumerService
        .onTbApplicationEvent(new PartitionChangeEvent("Source", ServiceType.TB_CORE, partitionsMap)));
    verify(queueService).findQueueByTenantIdAndName(isA(TenantId.class), eq("Main"));
    verify(partitionService).isManagedByCurrentService(isA(TenantId.class));
    verify(ctx).getQueueFactory();
  }

  /**
   * Test
   * {@link DefaultTbRuleEngineConsumerService#getNotificationPollDuration()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleEngineConsumerService#getNotificationPollDuration()}
   */
  @Test
  @DisplayName("Test getNotificationPollDuration(); then return one")
  void testGetNotificationPollDuration_thenReturnOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbRuleEngineConsumerContext ctx = mock(TbRuleEngineConsumerContext.class);
    when(ctx.getPollDuration()).thenReturn(1L);

    // Act
    long actualNotificationPollDuration = (new DefaultTbRuleEngineConsumerService(ctx, mock(ActorSystemContext.class),
        mock(TbRuleEngineDeviceRpcService.class), mock(QueueService.class), mock(TbDeviceProfileCache.class),
        mock(TbAssetProfileCache.class), mock(TbTenantProfileCache.class), mock(TbApiUsageStateService.class),
        mock(PartitionService.class), mock(ApplicationEventPublisher.class), mock(JwtSettingsService.class)))
        .getNotificationPollDuration();

    // Assert
    verify(ctx).getPollDuration();
    assertEquals(1L, actualNotificationPollDuration);
  }

  /**
   * Test
   * {@link DefaultTbRuleEngineConsumerService#getNotificationPollDuration()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleEngineConsumerService#getNotificationPollDuration()}
   */
  @Test
  @DisplayName("Test getNotificationPollDuration(); then throw RuntimeException")
  void testGetNotificationPollDuration_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbRuleEngineConsumerContext ctx = mock(TbRuleEngineConsumerContext.class);
    when(ctx.getPollDuration()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new DefaultTbRuleEngineConsumerService(ctx, mock(ActorSystemContext.class),
            mock(TbRuleEngineDeviceRpcService.class), mock(QueueService.class), mock(TbDeviceProfileCache.class),
            mock(TbAssetProfileCache.class), mock(TbTenantProfileCache.class), mock(TbApiUsageStateService.class),
            mock(PartitionService.class), mock(ApplicationEventPublisher.class), mock(JwtSettingsService.class)))
            .getNotificationPollDuration());
    verify(ctx).getPollDuration();
  }

  /**
   * Test
   * {@link DefaultTbRuleEngineConsumerService#getNotificationPackProcessingTimeout()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleEngineConsumerService#getNotificationPackProcessingTimeout()}
   */
  @Test
  @DisplayName("Test getNotificationPackProcessingTimeout(); then return one")
  void testGetNotificationPackProcessingTimeout_thenReturnOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbRuleEngineConsumerContext ctx = mock(TbRuleEngineConsumerContext.class);
    when(ctx.getPackProcessingTimeout()).thenReturn(1L);

    // Act
    long actualNotificationPackProcessingTimeout = (new DefaultTbRuleEngineConsumerService(ctx,
        mock(ActorSystemContext.class), mock(TbRuleEngineDeviceRpcService.class), mock(QueueService.class),
        mock(TbDeviceProfileCache.class), mock(TbAssetProfileCache.class), mock(TbTenantProfileCache.class),
        mock(TbApiUsageStateService.class), mock(PartitionService.class), mock(ApplicationEventPublisher.class),
        mock(JwtSettingsService.class))).getNotificationPackProcessingTimeout();

    // Assert
    verify(ctx).getPackProcessingTimeout();
    assertEquals(1L, actualNotificationPackProcessingTimeout);
  }

  /**
   * Test
   * {@link DefaultTbRuleEngineConsumerService#getNotificationPackProcessingTimeout()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleEngineConsumerService#getNotificationPackProcessingTimeout()}
   */
  @Test
  @DisplayName("Test getNotificationPackProcessingTimeout(); then throw RuntimeException")
  void testGetNotificationPackProcessingTimeout_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbRuleEngineConsumerContext ctx = mock(TbRuleEngineConsumerContext.class);
    when(ctx.getPackProcessingTimeout()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new DefaultTbRuleEngineConsumerService(ctx, mock(ActorSystemContext.class),
            mock(TbRuleEngineDeviceRpcService.class), mock(QueueService.class), mock(TbDeviceProfileCache.class),
            mock(TbAssetProfileCache.class), mock(TbTenantProfileCache.class), mock(TbApiUsageStateService.class),
            mock(PartitionService.class), mock(ApplicationEventPublisher.class), mock(JwtSettingsService.class)))
            .getNotificationPackProcessingTimeout());
    verify(ctx).getPackProcessingTimeout();
  }

  /**
   * Test {@link DefaultTbRuleEngineConsumerService#getMgmtThreadPoolSize()}.
   * <ul>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleEngineConsumerService#getMgmtThreadPoolSize()}
   */
  @Test
  @DisplayName("Test getMgmtThreadPoolSize(); then return three")
  void testGetMgmtThreadPoolSize_thenReturnThree() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbRuleEngineConsumerContext ctx = mock(TbRuleEngineConsumerContext.class);
    when(ctx.getMgmtThreadPoolSize()).thenReturn(3);

    // Act
    int actualMgmtThreadPoolSize = (new DefaultTbRuleEngineConsumerService(ctx, mock(ActorSystemContext.class),
        mock(TbRuleEngineDeviceRpcService.class), mock(QueueService.class), mock(TbDeviceProfileCache.class),
        mock(TbAssetProfileCache.class), mock(TbTenantProfileCache.class), mock(TbApiUsageStateService.class),
        mock(PartitionService.class), mock(ApplicationEventPublisher.class), mock(JwtSettingsService.class)))
        .getMgmtThreadPoolSize();

    // Assert
    verify(ctx).getMgmtThreadPoolSize();
    assertEquals(3, actualMgmtThreadPoolSize);
  }

  /**
   * Test {@link DefaultTbRuleEngineConsumerService#getMgmtThreadPoolSize()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleEngineConsumerService#getMgmtThreadPoolSize()}
   */
  @Test
  @DisplayName("Test getMgmtThreadPoolSize(); then throw RuntimeException")
  void testGetMgmtThreadPoolSize_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbRuleEngineConsumerContext ctx = mock(TbRuleEngineConsumerContext.class);
    when(ctx.getMgmtThreadPoolSize()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new DefaultTbRuleEngineConsumerService(ctx, mock(ActorSystemContext.class),
            mock(TbRuleEngineDeviceRpcService.class), mock(QueueService.class), mock(TbDeviceProfileCache.class),
            mock(TbAssetProfileCache.class), mock(TbTenantProfileCache.class), mock(TbApiUsageStateService.class),
            mock(PartitionService.class), mock(ApplicationEventPublisher.class), mock(JwtSettingsService.class)))
            .getMgmtThreadPoolSize());
    verify(ctx).getMgmtThreadPoolSize();
  }

  /**
   * Test
   * {@link DefaultTbRuleEngineConsumerService#handleComponentLifecycleEvent(ComponentLifecycleMsg)}.
   * <p>
   * Method under test:
   * {@link DefaultTbRuleEngineConsumerService#handleComponentLifecycleEvent(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test handleComponentLifecycleEvent(ComponentLifecycleMsg)")
  void testHandleComponentLifecycleEvent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbRuleEngineConsumerService defaultTbRuleEngineConsumerService = new DefaultTbRuleEngineConsumerService(
        mock(TbRuleEngineConsumerContext.class), mock(ActorSystemContext.class),
        mock(TbRuleEngineDeviceRpcService.class), mock(QueueService.class), mock(TbDeviceProfileCache.class),
        mock(TbAssetProfileCache.class), mock(TbTenantProfileCache.class), mock(TbApiUsageStateService.class),
        mock(PartitionService.class), mock(ApplicationEventPublisher.class), mock(JwtSettingsService.class));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTbRuleEngineConsumerService.handleComponentLifecycleEvent(
        new ComponentLifecycleMsg(new TenantId(UUID.randomUUID()), entityId, ComponentLifecycleEvent.CREATED));

    // Assert that nothing has changed
    verify(entityId).getEntityType();
  }

  /**
   * Test
   * {@link DefaultTbRuleEngineConsumerService#handleComponentLifecycleEvent(ComponentLifecycleMsg)}.
   * <p>
   * Method under test:
   * {@link DefaultTbRuleEngineConsumerService#handleComponentLifecycleEvent(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test handleComponentLifecycleEvent(ComponentLifecycleMsg)")
  void testHandleComponentLifecycleEvent2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTbRuleEngineConsumerService defaultTbRuleEngineConsumerService = new DefaultTbRuleEngineConsumerService(
        mock(TbRuleEngineConsumerContext.class), mock(ActorSystemContext.class),
        mock(TbRuleEngineDeviceRpcService.class), mock(QueueService.class), mock(TbDeviceProfileCache.class),
        mock(TbAssetProfileCache.class), mock(TbTenantProfileCache.class), mock(TbApiUsageStateService.class),
        mock(PartitionService.class), mock(ApplicationEventPublisher.class), mock(JwtSettingsService.class));
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultTbRuleEngineConsumerService.handleComponentLifecycleEvent(
        new ComponentLifecycleMsg(new TenantId(UUID.randomUUID()), entityId, ComponentLifecycleEvent.DELETED));

    // Assert that nothing has changed
    verify(entityId).getEntityType();
  }

  /**
   * Test {@link DefaultTbRuleEngineConsumerService#printStats()}.
   * <ul>
   *   <li>Given {@link TbRuleEngineConsumerContext}
   * {@link TbRuleEngineConsumerContext#isStatsEnabled()} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbRuleEngineConsumerService#printStats()}
   */
  @Test
  @DisplayName("Test printStats(); given TbRuleEngineConsumerContext isStatsEnabled() return 'false'")
  void testPrintStats_givenTbRuleEngineConsumerContextIsStatsEnabledReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbRuleEngineConsumerContext ctx = mock(TbRuleEngineConsumerContext.class);
    when(ctx.isStatsEnabled()).thenReturn(false);

    // Act
    (new DefaultTbRuleEngineConsumerService(ctx, mock(ActorSystemContext.class),
        mock(TbRuleEngineDeviceRpcService.class), mock(QueueService.class), mock(TbDeviceProfileCache.class),
        mock(TbAssetProfileCache.class), mock(TbTenantProfileCache.class), mock(TbApiUsageStateService.class),
        mock(PartitionService.class), mock(ApplicationEventPublisher.class), mock(JwtSettingsService.class)))
        .printStats();

    // Assert that nothing has changed
    verify(ctx).isStatsEnabled();
  }

  /**
   * Test {@link DefaultTbRuleEngineConsumerService#printStats()}.
   * <ul>
   *   <li>Given {@link TbRuleEngineConsumerContext}
   * {@link TbRuleEngineConsumerContext#isStatsEnabled()} return
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbRuleEngineConsumerService#printStats()}
   */
  @Test
  @DisplayName("Test printStats(); given TbRuleEngineConsumerContext isStatsEnabled() return 'true'")
  void testPrintStats_givenTbRuleEngineConsumerContextIsStatsEnabledReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbRuleEngineConsumerContext ctx = mock(TbRuleEngineConsumerContext.class);
    when(ctx.isStatsEnabled()).thenReturn(true);

    // Act
    (new DefaultTbRuleEngineConsumerService(ctx, mock(ActorSystemContext.class),
        mock(TbRuleEngineDeviceRpcService.class), mock(QueueService.class), mock(TbDeviceProfileCache.class),
        mock(TbAssetProfileCache.class), mock(TbTenantProfileCache.class), mock(TbApiUsageStateService.class),
        mock(PartitionService.class), mock(ApplicationEventPublisher.class), mock(JwtSettingsService.class)))
        .printStats();

    // Assert that nothing has changed
    verify(ctx).isStatsEnabled();
  }

  /**
   * Test {@link DefaultTbRuleEngineConsumerService#printStats()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbRuleEngineConsumerService#printStats()}
   */
  @Test
  @DisplayName("Test printStats(); then throw RuntimeException")
  void testPrintStats_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbRuleEngineConsumerContext ctx = mock(TbRuleEngineConsumerContext.class);
    when(ctx.isStatsEnabled()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new DefaultTbRuleEngineConsumerService(ctx, mock(ActorSystemContext.class),
            mock(TbRuleEngineDeviceRpcService.class), mock(QueueService.class), mock(TbDeviceProfileCache.class),
            mock(TbAssetProfileCache.class), mock(TbTenantProfileCache.class), mock(TbApiUsageStateService.class),
            mock(PartitionService.class), mock(ApplicationEventPublisher.class), mock(JwtSettingsService.class)))
            .printStats());
    verify(ctx).isStatsEnabled();
  }
}
