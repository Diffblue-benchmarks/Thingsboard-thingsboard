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
   * Method under test:
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger)}
   */
  @Test
  void testAlreadyProcessed() {
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
   * Method under test:
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger)}
   */
  @Test
  void testAlreadyProcessed2() {
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
   * Method under test:
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger, NotificationRule)}
   */
  @Test
  void testAlreadyProcessed3() {
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
   * Method under test:
   * {@link DefaultNotificationDeduplicationService#alreadyProcessed(NotificationRuleTrigger, NotificationRule)}
   */
  @Test
  void testAlreadyProcessed4() {
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
   * Method under test:
   * {@link DefaultNotificationDeduplicationService#getDeduplicationKey(NotificationRuleTrigger, NotificationRule)}
   */
  @Test
  void testGetDeduplicationKey() {
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
