package org.thingsboard.server.service.notification.rule;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.NotificationRuleTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.service.executors.NotificationExecutorService;

@ExtendWith(MockitoExtension.class)
class DefaultNotificationRuleProcessorDiffblueTest {
  @InjectMocks
  private DefaultNotificationRuleProcessor defaultNotificationRuleProcessor;

  @Mock
  private NotificationExecutorService notificationExecutorService;

  /**
   * Test {@link DefaultNotificationRuleProcessor#process(NotificationRuleTrigger)}.
   * <ul>
   *   <li>Given {@code NEW_PLATFORM_VERSION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationRuleProcessor#process(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName("Test process(NotificationRuleTrigger); given 'NEW_PLATFORM_VERSION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultNotificationRuleProcessor.process(NotificationRuleTrigger)"})
  void testProcess_givenNewPlatformVersion() {
    // Arrange
    SettableFuture<?> delegate = SettableFuture.create();
    Mockito.<ListenableFuture<?>>when(notificationExecutorService.submit(Mockito.<Runnable>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.getType()).thenReturn(NotificationRuleTriggerType.NEW_PLATFORM_VERSION);

    // Act
    defaultNotificationRuleProcessor.process(trigger);

    // Assert
    verify(notificationExecutorService).submit(isA(Runnable.class));
    verify(trigger).getType();
  }

  /**
   * Test {@link DefaultNotificationRuleProcessor#process(NotificationRuleTrigger)}.
   * <ul>
   *   <li>Then calls {@link NotificationRuleTrigger#getTenantId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationRuleProcessor#process(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName("Test process(NotificationRuleTrigger); then calls getTenantId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultNotificationRuleProcessor.process(NotificationRuleTrigger)"})
  void testProcess_thenCallsGetTenantId() {
    // Arrange
    SettableFuture<?> delegate = SettableFuture.create();
    Mockito.<ListenableFuture<?>>when(notificationExecutorService.submit(Mockito.<Runnable>any()))
        .thenReturn(
            new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.getTenantId()).thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(trigger.getType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act
    defaultNotificationRuleProcessor.process(trigger);

    // Assert
    verify(notificationExecutorService).submit(isA(Runnable.class));
    verify(trigger).getTenantId();
    verify(trigger).getType();
  }
}
