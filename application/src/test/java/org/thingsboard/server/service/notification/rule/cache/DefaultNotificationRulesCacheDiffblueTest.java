package org.thingsboard.server.service.notification.rule.cache;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.common.msg.plugin.ComponentLifecycleMsg;
import org.thingsboard.server.dao.notification.NotificationRuleService;

@ContextConfiguration(classes = {DefaultNotificationRulesCache.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class DefaultNotificationRulesCacheDiffblueTest {
  @Autowired
  private DefaultNotificationRulesCache defaultNotificationRulesCache;

  @MockBean
  private NotificationRuleService notificationRuleService;

  /**
   * Test
   * {@link DefaultNotificationRulesCache#onComponentLifecycleEvent(ComponentLifecycleMsg)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationRulesCache#onComponentLifecycleEvent(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test onComponentLifecycleEvent(ComponentLifecycleMsg)")
  void testOnComponentLifecycleEvent() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultNotificationRulesCache.onComponentLifecycleEvent(
        new ComponentLifecycleMsg(new TenantId(UUID.randomUUID()), entityId, ComponentLifecycleEvent.CREATED));

    // Assert that nothing has changed
    verify(entityId).getEntityType();
  }

  /**
   * Test
   * {@link DefaultNotificationRulesCache#onComponentLifecycleEvent(ComponentLifecycleMsg)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationRulesCache#onComponentLifecycleEvent(ComponentLifecycleMsg)}
   */
  @Test
  @DisplayName("Test onComponentLifecycleEvent(ComponentLifecycleMsg)")
  void testOnComponentLifecycleEvent2() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    defaultNotificationRulesCache.onComponentLifecycleEvent(
        new ComponentLifecycleMsg(new TenantId(UUID.randomUUID()), entityId, ComponentLifecycleEvent.DELETED));

    // Assert
    verify(entityId).getEntityType();
  }

  /**
   * Test
   * {@link DefaultNotificationRulesCache#getEnabled(TenantId, NotificationRuleTriggerType)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link NotificationRule#NotificationRule()}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRulesCache#getEnabled(TenantId, NotificationRuleTriggerType)}
   */
  @Test
  @DisplayName("Test getEnabled(TenantId, NotificationRuleTriggerType); given ArrayList() add NotificationRule(); then return ArrayList()")
  void testGetEnabled_givenArrayListAddNotificationRule_thenReturnArrayList() {
    // Arrange
    ArrayList<NotificationRule> notificationRuleList = new ArrayList<>();
    notificationRuleList.add(new NotificationRule());
    when(notificationRuleService.findEnabledNotificationRulesByTenantIdAndTriggerType(Mockito.<TenantId>any(),
        Mockito.<NotificationRuleTriggerType>any())).thenReturn(notificationRuleList);

    // Act
    List<NotificationRule> actualEnabled = defaultNotificationRulesCache.getEnabled(new TenantId(UUID.randomUUID()),
        NotificationRuleTriggerType.ENTITY_ACTION);

    // Assert
    verify(notificationRuleService).findEnabledNotificationRulesByTenantIdAndTriggerType(isA(TenantId.class),
        eq(NotificationRuleTriggerType.ENTITY_ACTION));
    assertSame(notificationRuleList, actualEnabled);
  }

  /**
   * Test
   * {@link DefaultNotificationRulesCache#getEnabled(TenantId, NotificationRuleTriggerType)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationRulesCache#getEnabled(TenantId, NotificationRuleTriggerType)}
   */
  @Test
  @DisplayName("Test getEnabled(TenantId, NotificationRuleTriggerType); then return Empty")
  void testGetEnabled_thenReturnEmpty() {
    // Arrange
    when(notificationRuleService.findEnabledNotificationRulesByTenantIdAndTriggerType(Mockito.<TenantId>any(),
        Mockito.<NotificationRuleTriggerType>any())).thenReturn(new ArrayList<>());

    // Act
    List<NotificationRule> actualEnabled = defaultNotificationRulesCache.getEnabled(new TenantId(UUID.randomUUID()),
        NotificationRuleTriggerType.ENTITY_ACTION);

    // Assert
    verify(notificationRuleService).findEnabledNotificationRulesByTenantIdAndTriggerType(isA(TenantId.class),
        eq(NotificationRuleTriggerType.ENTITY_ACTION));
    assertTrue(actualEnabled.isEmpty());
  }
}
