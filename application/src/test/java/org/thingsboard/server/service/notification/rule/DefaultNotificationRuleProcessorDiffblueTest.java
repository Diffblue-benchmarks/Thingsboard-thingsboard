package org.thingsboard.server.service.notification.rule;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.common.util.ListeningExecutor;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.NotificationRuleTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.dao.notification.DefaultNotificationRequestService;
import org.thingsboard.server.dao.sql.notification.JpaNotificationDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.NotificationRepository;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.notification.DefaultNotificationDeduplicationService;
import org.thingsboard.server.service.executors.NotificationExecutorService;
import org.thingsboard.server.service.notification.rule.cache.NotificationRulesCache;

class DefaultNotificationRuleProcessorDiffblueTest {
  /**
   * Test
   * {@link DefaultNotificationRuleProcessor#process(NotificationRuleTrigger)}.
   * <ul>
   *   <li>Given
   * {@link ListenableFutureToApiFuture#ListenableFutureToApiFuture(ListenableFuture)}
   * with delegate is create.</li>
   *   <li>Then calls {@link ListeningExecutor#submit(Runnable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRuleProcessor#process(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName("Test process(NotificationRuleTrigger); given ListenableFutureToApiFuture(ListenableFuture) with delegate is create; then calls submit(Runnable)")
  void testProcess_givenListenableFutureToApiFutureWithDelegateIsCreate_thenCallsSubmit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationExecutorService notificationExecutor = mock(NotificationExecutorService.class);
    SettableFuture<?> delegate = SettableFuture.create();
    Mockito.<ListenableFuture<?>>when(notificationExecutor.submit(Mockito.<Runnable>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    NotificationRulesCache notificationRulesCache = mock(NotificationRulesCache.class);
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    DefaultNotificationDeduplicationService deduplicationService = new DefaultNotificationDeduplicationService();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultNotificationRuleProcessor defaultNotificationRuleProcessor = new DefaultNotificationRuleProcessor(
        notificationRulesCache, notificationRequestService, deduplicationService, partitionService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3),
        notificationExecutor);
    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(trigger.getType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act
    defaultNotificationRuleProcessor.process(trigger);

    // Assert that nothing has changed
    verify(notificationExecutor).submit(isA(Runnable.class));
    verify(trigger).getTenantId();
    verify(trigger).getType();
  }
}
