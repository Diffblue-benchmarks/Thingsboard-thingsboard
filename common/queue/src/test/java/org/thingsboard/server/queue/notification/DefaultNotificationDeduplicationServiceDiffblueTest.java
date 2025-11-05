package org.thingsboard.server.queue.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.notification.rule.trigger.NotificationRuleTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

@ContextConfiguration(classes = {DefaultNotificationDeduplicationService.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
class DefaultNotificationDeduplicationServiceDiffblueTest {
  @Autowired
  private DefaultNotificationDeduplicationService defaultNotificationDeduplicationService;

  /**
   * Test {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger,
   * NotificationRule)} with {@code trigger}, {@code rule}.
   *
   * <p>Method under test: {@link
   * DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger,
   * NotificationRule)}
   */
  @Test
  @DisplayName(
      "Test alreadyProcessed(NotificationRuleTrigger, NotificationRule) with 'trigger', 'rule'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotificationDeduplicationService.alreadyProcessed(NotificationRuleTrigger, NotificationRule)"
  })
  void testAlreadyProcessedWithTriggerRule() {
    // Arrange
    DefaultNotificationDeduplicationService defaultNotificationDeduplicationService =
        new DefaultNotificationDeduplicationService();
    defaultNotificationDeduplicationService.setDeduplicationDurations("");

    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.getDefaultDeduplicationDuration()).thenReturn(1L);
    when(trigger.getType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(trigger.getDeduplicationKey()).thenReturn("Deduplication Key");

    NotificationRule rule = mock(NotificationRule.class);
    when(rule.getDeduplicationKey()).thenReturn("Deduplication Key");

    // Act
    boolean actualAlreadyProcessedResult =
        defaultNotificationDeduplicationService.alreadyProcessed(trigger, rule);

    // Assert
    verify(rule).getDeduplicationKey();
    verify(trigger).getDeduplicationKey();
    verify(trigger).getDefaultDeduplicationDuration();
    verify(trigger).getType();
    assertFalse(actualAlreadyProcessedResult);
  }

  /**
   * Test {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger)}
   * with {@code trigger}.
   *
   * <ul>
   *   <li>Given {@code ENTITY_ACTION}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName(
      "Test alreadyProcessed(NotificationRuleTrigger) with 'trigger'; given 'ENTITY_ACTION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultNotificationDeduplicationService.alreadyProcessed(NotificationRuleTrigger)"
  })
  void testAlreadyProcessedWithTrigger_givenEntityAction() {
    // Arrange
    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.getDefaultDeduplicationDuration()).thenReturn(1L);
    when(trigger.getType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(trigger.getDeduplicationKey()).thenReturn("Deduplication Key");

    // Act
    boolean actualAlreadyProcessedResult =
        defaultNotificationDeduplicationService.alreadyProcessed(trigger);

    // Assert
    verify(trigger).getDeduplicationKey();
    verify(trigger).getDefaultDeduplicationDuration();
    verify(trigger).getType();
    assertFalse(actualAlreadyProcessedResult);
  }

  /**
   * Test {@link
   * DefaultNotificationDeduplicationService#getDeduplicationKey(NotificationRuleTrigger,
   * NotificationRule)}.
   *
   * <ul>
   *   <li>Then return {@code Deduplication Key_Deduplication Key}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultNotificationDeduplicationService#getDeduplicationKey(NotificationRuleTrigger,
   * NotificationRule)}
   */
  @Test
  @DisplayName(
      "Test getDeduplicationKey(NotificationRuleTrigger, NotificationRule); then return 'Deduplication Key_Deduplication Key'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DefaultNotificationDeduplicationService.getDeduplicationKey(NotificationRuleTrigger, NotificationRule)"
  })
  void testGetDeduplicationKey_thenReturnDeduplicationKeyDeduplicationKey() {
    // Arrange
    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.getDeduplicationKey()).thenReturn("Deduplication Key");

    NotificationRule rule = mock(NotificationRule.class);
    when(rule.getDeduplicationKey()).thenReturn("Deduplication Key");

    // Act
    String actualDeduplicationKey =
        DefaultNotificationDeduplicationService.getDeduplicationKey(trigger, rule);

    // Assert
    verify(rule).getDeduplicationKey();
    verify(trigger).getDeduplicationKey();
    assertEquals("Deduplication Key_Deduplication Key", actualDeduplicationKey);
  }
}
