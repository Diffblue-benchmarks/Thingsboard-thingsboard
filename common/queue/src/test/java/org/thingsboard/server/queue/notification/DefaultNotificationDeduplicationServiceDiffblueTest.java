/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.queue.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.notification.rule.trigger.NotificationRuleTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

@ContextConfiguration(classes = {DefaultNotificationDeduplicationService.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
class DefaultNotificationDeduplicationServiceDiffblueTest {
  @Autowired
  private DefaultNotificationDeduplicationService defaultNotificationDeduplicationService;

  @MockBean
  private CacheManager cacheManager;

  /**
   * Test {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger)} with {@code trigger}.
   * <p>
   * Method under test: {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName("Test alreadyProcessed(NotificationRuleTrigger) with 'trigger'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultNotificationDeduplicationService.alreadyProcessed(NotificationRuleTrigger)"})
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
   * Test {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger, NotificationRule)} with {@code trigger}, {@code rule}.
   * <p>
   * Method under test: {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger, NotificationRule)}
   */
  @Test
  @DisplayName("Test alreadyProcessed(NotificationRuleTrigger, NotificationRule) with 'trigger', 'rule'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean DefaultNotificationDeduplicationService.alreadyProcessed(NotificationRuleTrigger, NotificationRule)"})
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
   * Test {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger, NotificationRule)} with {@code trigger}, {@code rule}.
   * <ul>
   *   <li>Given {@code ALARM_COMMENT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger, NotificationRule)}
   */
  @Test
  @DisplayName("Test alreadyProcessed(NotificationRuleTrigger, NotificationRule) with 'trigger', 'rule'; given 'ALARM_COMMENT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "boolean DefaultNotificationDeduplicationService.alreadyProcessed(NotificationRuleTrigger, NotificationRule)"})
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
   * Test {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger)} with {@code trigger}.
   * <ul>
   *   <li>Given {@code ENTITY_ACTION}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger)}
   */
  @Test
  @DisplayName("Test alreadyProcessed(NotificationRuleTrigger) with 'trigger'; given 'ENTITY_ACTION'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultNotificationDeduplicationService.alreadyProcessed(NotificationRuleTrigger)"})
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
   * Test {@link DefaultNotificationDeduplicationService#getDeduplicationKey(NotificationRuleTrigger, NotificationRule)}.
   * <ul>
   *   <li>Then return {@code Deduplication Key_Deduplication Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationDeduplicationService#getDeduplicationKey(NotificationRuleTrigger, NotificationRule)}
   */
  @Test
  @DisplayName("Test getDeduplicationKey(NotificationRuleTrigger, NotificationRule); then return 'Deduplication Key_Deduplication Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String DefaultNotificationDeduplicationService.getDeduplicationKey(NotificationRuleTrigger, NotificationRule)"})
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
}
