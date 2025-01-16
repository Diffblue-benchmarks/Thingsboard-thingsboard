package org.thingsboard.server.queue.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.notification.rule.trigger.NotificationRuleTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

@ContextConfiguration(classes = {DefaultNotificationDeduplicationService.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
class DefaultNotificationDeduplicationServiceDiffblueTest {
  @MockBean
  private CacheManager cacheManager;

  @Autowired
  private DefaultNotificationDeduplicationService defaultNotificationDeduplicationService;

  /**
   * Test
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger)}
   * with {@code trigger}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName("Test alreadyProcessed(NotificationRuleTrigger) with 'trigger'")
  void testAlreadyProcessedWithTrigger() {
    // Arrange
    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.getDefaultDeduplicationDuration()).thenReturn(1L);
    when(trigger.getType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(trigger.getDeduplicationKey())
        .thenReturn("Deduplicating trigger {} by key '{}'. Deduplication duration: {} ms, passed: {} ms");

    // Act
    boolean actualAlreadyProcessedResult = defaultNotificationDeduplicationService.alreadyProcessed(trigger);

    // Assert
    verify(trigger).getDeduplicationKey();
    verify(trigger).getDefaultDeduplicationDuration();
    verify(trigger).getType();
    assertFalse(actualAlreadyProcessedResult);
  }

  /**
   * Test
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger, NotificationRule)}
   * with {@code trigger}, {@code rule}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger, NotificationRule)}
   */
  @Test
  @DisplayName("Test alreadyProcessed(NotificationRuleTrigger, NotificationRule) with 'trigger', 'rule'")
  void testAlreadyProcessedWithTriggerRule() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("_"));
    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.getType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(trigger.getDeduplicationKey()).thenReturn("Deduplication Key");
    NotificationRule rule = mock(NotificationRule.class);
    when(rule.getDeduplicationKey()).thenReturn("Deduplication Key");

    // Act
    boolean actualAlreadyProcessedResult = defaultNotificationDeduplicationService.alreadyProcessed(trigger, rule);

    // Assert
    verify(cacheManager, atLeast(1)).getCache(eq("sentNotifications"));
    verify(rule).getDeduplicationKey();
    verify(trigger).getDeduplicationKey();
    verify(trigger).getType();
    assertFalse(actualAlreadyProcessedResult);
  }

  /**
   * Test
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger, NotificationRule)}
   * with {@code trigger}, {@code rule}.
   * <ul>
   *   <li>Given {@code ALARM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger, NotificationRule)}
   */
  @Test
  @DisplayName("Test alreadyProcessed(NotificationRuleTrigger, NotificationRule) with 'trigger', 'rule'; given 'ALARM'")
  void testAlreadyProcessedWithTriggerRule_givenAlarm() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.getDefaultDeduplicationDuration()).thenReturn(1L);
    when(trigger.getType()).thenReturn(NotificationRuleTriggerType.ALARM);
    when(trigger.getDeduplicationKey()).thenReturn("Deduplication Key");
    NotificationRule rule = mock(NotificationRule.class);
    when(rule.getDeduplicationKey()).thenReturn("Deduplication Key");

    // Act
    boolean actualAlreadyProcessedResult = defaultNotificationDeduplicationService.alreadyProcessed(trigger, rule);

    // Assert
    verify(cacheManager, atLeast(1)).getCache(eq("sentNotifications"));
    verify(rule).getDeduplicationKey();
    verify(trigger).getDeduplicationKey();
    verify(trigger).getDefaultDeduplicationDuration();
    verify(trigger).getType();
    assertFalse(actualAlreadyProcessedResult);
  }

  /**
   * Test
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger, NotificationRule)}
   * with {@code trigger}, {@code rule}.
   * <ul>
   *   <li>Given {@code ALARM_COMMENT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger, NotificationRule)}
   */
  @Test
  @DisplayName("Test alreadyProcessed(NotificationRuleTrigger, NotificationRule) with 'trigger', 'rule'; given 'ALARM_COMMENT'")
  void testAlreadyProcessedWithTriggerRule_givenAlarmComment() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.getDefaultDeduplicationDuration()).thenReturn(1L);
    when(trigger.getType()).thenReturn(NotificationRuleTriggerType.ALARM_COMMENT);
    when(trigger.getDeduplicationKey()).thenReturn("Deduplication Key");
    NotificationRule rule = mock(NotificationRule.class);
    when(rule.getDeduplicationKey()).thenReturn("Deduplication Key");

    // Act
    boolean actualAlreadyProcessedResult = defaultNotificationDeduplicationService.alreadyProcessed(trigger, rule);

    // Assert
    verify(cacheManager, atLeast(1)).getCache(eq("sentNotifications"));
    verify(rule).getDeduplicationKey();
    verify(trigger).getDeduplicationKey();
    verify(trigger).getDefaultDeduplicationDuration();
    verify(trigger).getType();
    assertFalse(actualAlreadyProcessedResult);
  }

  /**
   * Test
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger, NotificationRule)}
   * with {@code trigger}, {@code rule}.
   * <ul>
   *   <li>Given {@link CacheManager} {@link CacheManager#getCache(String)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger, NotificationRule)}
   */
  @Test
  @DisplayName("Test alreadyProcessed(NotificationRuleTrigger, NotificationRule) with 'trigger', 'rule'; given CacheManager getCache(String) return 'null'")
  void testAlreadyProcessedWithTriggerRule_givenCacheManagerGetCacheReturnNull() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);
    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.getType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(trigger.getDeduplicationKey()).thenReturn("Deduplication Key");
    NotificationRule rule = mock(NotificationRule.class);
    when(rule.getDeduplicationKey()).thenReturn("Deduplication Key");

    // Act
    boolean actualAlreadyProcessedResult = defaultNotificationDeduplicationService.alreadyProcessed(trigger, rule);

    // Assert
    verify(cacheManager, atLeast(1)).getCache(eq("sentNotifications"));
    verify(rule).getDeduplicationKey();
    verify(trigger).getDeduplicationKey();
    verify(trigger).getType();
    assertFalse(actualAlreadyProcessedResult);
  }

  /**
   * Test
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger, NotificationRule)}
   * with {@code trigger}, {@code rule}.
   * <ul>
   *   <li>Given {@code ENTITY_ACTION}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger, NotificationRule)}
   */
  @Test
  @DisplayName("Test alreadyProcessed(NotificationRuleTrigger, NotificationRule) with 'trigger', 'rule'; given 'ENTITY_ACTION'")
  void testAlreadyProcessedWithTriggerRule_givenEntityAction() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.getType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(trigger.getDeduplicationKey()).thenReturn("Deduplication Key");
    NotificationRule rule = mock(NotificationRule.class);
    when(rule.getDeduplicationKey()).thenReturn("Deduplication Key");

    // Act
    boolean actualAlreadyProcessedResult = defaultNotificationDeduplicationService.alreadyProcessed(trigger, rule);

    // Assert
    verify(cacheManager, atLeast(1)).getCache(eq("sentNotifications"));
    verify(rule).getDeduplicationKey();
    verify(trigger).getDeduplicationKey();
    verify(trigger).getType();
    assertFalse(actualAlreadyProcessedResult);
  }

  /**
   * Test
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger)}
   * with {@code trigger}.
   * <ul>
   *   <li>Given {@code ALARM}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName("Test alreadyProcessed(NotificationRuleTrigger) with 'trigger'; given 'ALARM'")
  void testAlreadyProcessedWithTrigger_givenAlarm() {
    // Arrange
    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.getDefaultDeduplicationDuration()).thenReturn(1L);
    when(trigger.getType()).thenReturn(NotificationRuleTriggerType.ALARM);
    when(trigger.getDeduplicationKey()).thenReturn("Deduplication Key");

    // Act
    boolean actualAlreadyProcessedResult = defaultNotificationDeduplicationService.alreadyProcessed(trigger);

    // Assert
    verify(trigger).getDeduplicationKey();
    verify(trigger).getDefaultDeduplicationDuration();
    verify(trigger).getType();
    assertFalse(actualAlreadyProcessedResult);
  }

  /**
   * Test
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger)}
   * with {@code trigger}.
   * <ul>
   *   <li>Given {@code ENTITY_ACTION}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName("Test alreadyProcessed(NotificationRuleTrigger) with 'trigger'; given 'ENTITY_ACTION'")
  void testAlreadyProcessedWithTrigger_givenEntityAction() {
    // Arrange
    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.getDefaultDeduplicationDuration()).thenReturn(1L);
    when(trigger.getType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(trigger.getDeduplicationKey()).thenReturn("Deduplication Key");

    // Act
    boolean actualAlreadyProcessedResult = defaultNotificationDeduplicationService.alreadyProcessed(trigger);

    // Assert
    verify(trigger).getDeduplicationKey();
    verify(trigger).getDefaultDeduplicationDuration();
    verify(trigger).getType();
    assertFalse(actualAlreadyProcessedResult);
  }

  /**
   * Test
   * {@link DefaultNotificationDeduplicationService#getDeduplicationKey(NotificationRuleTrigger, NotificationRule)}.
   * <ul>
   *   <li>Then return {@code Deduplication Key_Deduplication Key}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationDeduplicationService#getDeduplicationKey(NotificationRuleTrigger, NotificationRule)}
   */
  @Test
  @DisplayName("Test getDeduplicationKey(NotificationRuleTrigger, NotificationRule); then return 'Deduplication Key_Deduplication Key'")
  void testGetDeduplicationKey_thenReturnDeduplicationKeyDeduplicationKey() {
    // Arrange
    NotificationRuleTrigger trigger = mock(NotificationRuleTrigger.class);
    when(trigger.getDeduplicationKey()).thenReturn("Deduplication Key");
    NotificationRule rule = mock(NotificationRule.class);
    when(rule.getDeduplicationKey()).thenReturn("Deduplication Key");

    // Act
    String actualDeduplicationKey = DefaultNotificationDeduplicationService.getDeduplicationKey(trigger, rule);

    // Assert
    verify(rule).getDeduplicationKey();
    verify(trigger).getDeduplicationKey();
    assertEquals("Deduplication Key_Deduplication Key", actualDeduplicationKey);
  }

  /**
   * Test
   * {@link DefaultNotificationDeduplicationService#setDeduplicationDurations(String)}.
   * <ul>
   *   <li>When {@code Deduplication Durations Str}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationDeduplicationService#setDeduplicationDurations(String)}
   */
  @Test
  @DisplayName("Test setDeduplicationDurations(String); when 'Deduplication Durations Str'")
  @Disabled("TODO: Complete this test")
  void testSetDeduplicationDurations_whenDeduplicationDurationsStr() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.StringIndexOutOfBoundsException: begin 0, end -1, length 27
    //       at java.base/java.lang.String.checkBoundsBeginEnd(String.java:4608)
    //       at java.base/java.lang.String.substring(String.java:2711)
    //       at org.thingsboard.server.queue.util.PropertyUtils.getProps(PropertyUtils.java:32)
    //       at org.thingsboard.server.queue.notification.DefaultNotificationDeduplicationService.setDeduplicationDurations(DefaultNotificationDeduplicationService.java:119)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    defaultNotificationDeduplicationService.setDeduplicationDurations("Deduplication Durations Str");
  }

  /**
   * Test
   * {@link DefaultNotificationDeduplicationService#setDeduplicationDurations(String)}.
   * <ul>
   *   <li>When {@code ;}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationDeduplicationService#setDeduplicationDurations(String)}
   */
  @Test
  @DisplayName("Test setDeduplicationDurations(String); when ';'")
  void testSetDeduplicationDurations_whenSemicolon() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    defaultNotificationDeduplicationService.setDeduplicationDurations(";");
  }
}
