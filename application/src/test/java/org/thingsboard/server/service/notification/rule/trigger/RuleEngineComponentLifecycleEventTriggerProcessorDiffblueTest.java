package org.thingsboard.server.service.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.RuleEngineComponentLifecycleEventTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.common.data.notification.rule.trigger.config.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.PartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;

@ContextConfiguration(classes = {RuleEngineComponentLifecycleEventTriggerProcessor.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class RuleEngineComponentLifecycleEventTriggerProcessorDiffblueTest {
  @MockBean
  private PartitionService partitionService;

  @Autowired
  private RuleEngineComponentLifecycleEventTriggerProcessor ruleEngineComponentLifecycleEventTriggerProcessor;

  /**
   * Test
   * {@link RuleEngineComponentLifecycleEventTriggerProcessor#matchesFilter(RuleEngineComponentLifecycleEventTrigger, RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig)}
   * with {@code RuleEngineComponentLifecycleEventTrigger},
   * {@code RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTriggerProcessor#matchesFilter(RuleEngineComponentLifecycleEventTrigger, RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(RuleEngineComponentLifecycleEventTrigger, RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig) with 'RuleEngineComponentLifecycleEventTrigger', 'RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig'")
  void testMatchesFilterWithRuleEngineComponentLifecycleEventTriggerRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig() {
    // Arrange
    when(partitionService.isMyPartition(Mockito.<ServiceType>any(), Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(true);
    RuleEngineComponentLifecycleEventTrigger trigger = mock(RuleEngineComponentLifecycleEventTrigger.class);
    when(trigger.getComponentId()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(trigger.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig triggerConfig = mock(
        RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.class);
    when(triggerConfig.getRuleChains()).thenReturn(new HashSet<>());

    // Act
    boolean actualMatchesFilterResult = ruleEngineComponentLifecycleEventTriggerProcessor.matchesFilter(trigger,
        triggerConfig);

    // Assert
    verify(trigger, atLeast(1)).getComponentId();
    verify(trigger).getTenantId();
    verify(triggerConfig).getRuleChains();
    verify(partitionService).isMyPartition(eq(ServiceType.TB_RULE_ENGINE), isA(TenantId.class), isA(EntityId.class));
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link RuleEngineComponentLifecycleEventTriggerProcessor#matchesFilter(RuleEngineComponentLifecycleEventTrigger, RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig)}
   * with {@code RuleEngineComponentLifecycleEventTrigger},
   * {@code RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTriggerProcessor#matchesFilter(RuleEngineComponentLifecycleEventTrigger, RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(RuleEngineComponentLifecycleEventTrigger, RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig) with 'RuleEngineComponentLifecycleEventTrigger', 'RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig'")
  void testMatchesFilterWithRuleEngineComponentLifecycleEventTriggerRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig2() {
    // Arrange
    when(partitionService.isMyPartition(Mockito.<ServiceType>any(), Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(false);
    RuleEngineComponentLifecycleEventTrigger trigger = mock(RuleEngineComponentLifecycleEventTrigger.class);
    when(trigger.getComponentId()).thenReturn(null);
    when(trigger.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig triggerConfig = mock(
        RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.class);
    when(triggerConfig.getRuleChains()).thenReturn(new HashSet<>());

    // Act
    boolean actualMatchesFilterResult = ruleEngineComponentLifecycleEventTriggerProcessor.matchesFilter(trigger,
        triggerConfig);

    // Assert
    verify(trigger).getComponentId();
    verify(trigger).getTenantId();
    verify(triggerConfig).getRuleChains();
    verify(partitionService).isMyPartition(eq(ServiceType.TB_RULE_ENGINE), isA(TenantId.class), isNull());
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link RuleEngineComponentLifecycleEventTriggerProcessor#matchesFilter(RuleEngineComponentLifecycleEventTrigger, RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig)}
   * with {@code RuleEngineComponentLifecycleEventTrigger},
   * {@code RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTriggerProcessor#matchesFilter(RuleEngineComponentLifecycleEventTrigger, RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(RuleEngineComponentLifecycleEventTrigger, RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig) with 'RuleEngineComponentLifecycleEventTrigger', 'RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig'")
  void testMatchesFilterWithRuleEngineComponentLifecycleEventTriggerRuleEngineComponentLifecycleEventNotificationRuleTriggerConfig3() {
    // Arrange
    RuleEngineComponentLifecycleEventTrigger trigger = mock(RuleEngineComponentLifecycleEventTrigger.class);
    when(trigger.getRuleChainId()).thenReturn(new RuleChainId(UUID.randomUUID()));

    HashSet<UUID> uuidSet = new HashSet<>();
    uuidSet.add(UUID.randomUUID());
    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig triggerConfig = mock(
        RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig.class);
    when(triggerConfig.getRuleChains()).thenReturn(uuidSet);

    // Act
    boolean actualMatchesFilterResult = ruleEngineComponentLifecycleEventTriggerProcessor.matchesFilter(trigger,
        triggerConfig);

    // Assert
    verify(trigger).getRuleChainId();
    verify(triggerConfig, atLeast(1)).getRuleChains();
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link RuleEngineComponentLifecycleEventTriggerProcessor#getTriggerType()}.
   * <p>
   * Method under test:
   * {@link RuleEngineComponentLifecycleEventTriggerProcessor#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  void testGetTriggerType() {
    // Arrange
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    // Act and Assert
    assertEquals(NotificationRuleTriggerType.RULE_ENGINE_COMPONENT_LIFECYCLE_EVENT,
        (new RuleEngineComponentLifecycleEventTriggerProcessor(new HashPartitionService(serviceInfoProvider,
            tenantRoutingInfoService, applicationEventPublisher, queueRoutingInfoService, new TopicService())))
            .getTriggerType());
  }
}
