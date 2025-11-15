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
package org.thingsboard.server.common.data.notification.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

class NotificationRuleDiffblueTest {
  /**
   * Method under test: {@link NotificationRule#isValid()}
   */
  @Test
  void testIsValid() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);

    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTriggerConfig(triggerConfig);

    // Act
    boolean actualIsValidResult = notificationRule.isValid();

    // Assert
    verify(triggerConfig).getTriggerType();
    assertFalse(actualIsValidResult);
  }

  /**
   * Method under test: {@link NotificationRule#isValid()}
   */
  @Test
  void testIsValid2() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);

    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setRecipientsConfig(new DefaultNotificationRuleRecipientsConfig());
    notificationRule.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRule.setTriggerConfig(triggerConfig);

    // Act
    boolean actualIsValidResult = notificationRule.isValid();

    // Assert
    verify(triggerConfig).getTriggerType();
    assertFalse(actualIsValidResult);
  }

  /**
   * Method under test: {@link NotificationRule#isValid()}
   */
  @Test
  void testIsValid3() {
    // Arrange
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);

    DefaultNotificationRuleRecipientsConfig recipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    recipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setRecipientsConfig(recipientsConfig);
    notificationRule.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRule.setTriggerConfig(triggerConfig);

    // Act
    boolean actualIsValidResult = notificationRule.isValid();

    // Assert
    verify(triggerConfig).getTriggerType();
    assertTrue(actualIsValidResult);
  }

  /**
   * Method under test: {@link NotificationRule#getDeduplicationKey()}
   */
  @Test
  void testGetDeduplicationKey() {
    // Arrange
    EscalatedNotificationRuleRecipientsConfig recipientsConfig = new EscalatedNotificationRuleRecipientsConfig();
    recipientsConfig.setEscalationTable(new HashMap<>());
    recipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(triggerConfig.getDeduplicationKey()).thenReturn("Deduplication Key");

    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTriggerConfig(triggerConfig);
    notificationRule.setRecipientsConfig(recipientsConfig);

    // Act
    String actualDeduplicationKey = notificationRule.getDeduplicationKey();

    // Assert
    verify(triggerConfig).getDeduplicationKey();
    assertEquals(":Deduplication Key", actualDeduplicationKey);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRule#equals(Object)}
   *   <li>{@link NotificationRule#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    NotificationRule notificationRule2 = new NotificationRule();

    // Act and Assert
    assertEquals(notificationRule, notificationRule2);
    int expectedHashCodeResult = notificationRule.hashCode();
    assertEquals(expectedHashCodeResult, notificationRule2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRule#equals(Object)}
   *   <li>{@link NotificationRule#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    // Act and Assert
    assertEquals(notificationRule, notificationRule);
    int expectedHashCodeResult = notificationRule.hashCode();
    assertEquals(expectedHashCodeResult, notificationRule.hashCode());
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRuleInfo notificationRuleInfo = new NotificationRuleInfo();

    // Act and Assert
    assertNotEquals(notificationRuleInfo, new NotificationRule());
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRuleInfo());
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTriggerConfig(mock(NotificationRuleTriggerConfig.class));

    // Act and Assert
    assertNotEquals(notificationRule, 1);
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    NotificationRuleInfo notificationRuleInfo = mock(NotificationRuleInfo.class);
    when(notificationRuleInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(notificationRule, notificationRuleInfo);
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRule());
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setName("Name");

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRule());
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setEnabled(true);

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRule());
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTemplateId(new NotificationTemplateId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRule());
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRule());
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTriggerConfig(mock(NotificationRuleTriggerConfig.class));

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRule());
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setRecipientsConfig(new DefaultNotificationRuleRecipientsConfig());

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRule());
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    NotificationRuleConfig additionalConfig = new NotificationRuleConfig();
    additionalConfig.setDescription("The characteristics of someone or something");

    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setAdditionalConfig(additionalConfig);

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRule());
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setExternalId(new NotificationRuleId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(notificationRule, new NotificationRule());
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(notificationRule, notificationRule2);
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setName("Name");

    // Act and Assert
    assertNotEquals(notificationRule, notificationRule2);
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setTemplateId(new NotificationTemplateId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(notificationRule, notificationRule2);
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    // Act and Assert
    assertNotEquals(notificationRule, notificationRule2);
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setTriggerConfig(mock(NotificationRuleTriggerConfig.class));

    // Act and Assert
    assertNotEquals(notificationRule, notificationRule2);
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setRecipientsConfig(new DefaultNotificationRuleRecipientsConfig());

    // Act and Assert
    assertNotEquals(notificationRule, notificationRule2);
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    NotificationRuleConfig additionalConfig = new NotificationRuleConfig();
    additionalConfig.setDescription("The characteristics of someone or something");

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setAdditionalConfig(additionalConfig);

    // Act and Assert
    assertNotEquals(notificationRule, notificationRule2);
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    NotificationRule notificationRule2 = new NotificationRule();
    notificationRule2.setExternalId(new NotificationRuleId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(notificationRule, notificationRule2);
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRule(), null);
  }

  /**
   * Method under test: {@link NotificationRule#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationRule(), "Different type to NotificationRule");
  }

  /**
   * Method under test: {@link NotificationRule#getExternalId()}
   */
  @Test
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new NotificationRule()).getExternalId());
  }

  /**
   * Method under test: {@link NotificationRule#getExternalId()}
   */
  @Test
  void testGetExternalId2() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTriggerConfig(mock(NotificationRuleTriggerConfig.class));

    // Act and Assert
    assertNull(notificationRule.getExternalId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRule#NotificationRule()}
   *   <li>{@link NotificationRule#setAdditionalConfig(NotificationRuleConfig)}
   *   <li>{@link NotificationRule#setEnabled(boolean)}
   *   <li>{@link NotificationRule#setExternalId(NotificationRuleId)}
   *   <li>{@link NotificationRule#setName(String)}
   *   <li>
   * {@link NotificationRule#setRecipientsConfig(NotificationRuleRecipientsConfig)}
   *   <li>{@link NotificationRule#setTemplateId(NotificationTemplateId)}
   *   <li>{@link NotificationRule#setTenantId(TenantId)}
   *   <li>{@link NotificationRule#setTriggerConfig(NotificationRuleTriggerConfig)}
   *   <li>{@link NotificationRule#setTriggerType(NotificationRuleTriggerType)}
   *   <li>{@link NotificationRule#toString()}
   *   <li>{@link NotificationRule#getAdditionalConfig()}
   *   <li>{@link NotificationRule#getName()}
   *   <li>{@link NotificationRule#getRecipientsConfig()}
   *   <li>{@link NotificationRule#getTemplateId()}
   *   <li>{@link NotificationRule#getTenantId()}
   *   <li>{@link NotificationRule#getTriggerConfig()}
   *   <li>{@link NotificationRule#getTriggerType()}
   *   <li>{@link NotificationRule#isEnabled()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationRule actualNotificationRule = new NotificationRule();
    NotificationRuleConfig additionalConfig = new NotificationRuleConfig();
    additionalConfig.setDescription("The characteristics of someone or something");
    actualNotificationRule.setAdditionalConfig(additionalConfig);
    actualNotificationRule.setEnabled(true);
    NotificationRuleId externalId = new NotificationRuleId(EntityId.NULL_UUID);
    actualNotificationRule.setExternalId(externalId);
    actualNotificationRule.setName("Name");
    DefaultNotificationRuleRecipientsConfig recipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    actualNotificationRule.setRecipientsConfig(recipientsConfig);
    NotificationTemplateId templateId = new NotificationTemplateId(EntityId.NULL_UUID);
    actualNotificationRule.setTemplateId(templateId);
    actualNotificationRule.setTenantId(TenantId.SYS_TENANT_ID);
    NotificationRuleTriggerConfig triggerConfig = mock(NotificationRuleTriggerConfig.class);
    actualNotificationRule.setTriggerConfig(triggerConfig);
    actualNotificationRule.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    actualNotificationRule.toString();
    NotificationRuleConfig actualAdditionalConfig = actualNotificationRule.getAdditionalConfig();
    String actualName = actualNotificationRule.getName();
    NotificationRuleRecipientsConfig actualRecipientsConfig = actualNotificationRule.getRecipientsConfig();
    NotificationTemplateId actualTemplateId = actualNotificationRule.getTemplateId();
    TenantId actualTenantId = actualNotificationRule.getTenantId();
    NotificationRuleTriggerConfig actualTriggerConfig = actualNotificationRule.getTriggerConfig();
    NotificationRuleTriggerType actualTriggerType = actualNotificationRule.getTriggerType();
    boolean actualIsEnabledResult = actualNotificationRule.isEnabled();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("The characteristics of someone or something", actualAdditionalConfig.getDescription());
    assertEquals(0L, actualNotificationRule.getCreatedTime());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualTriggerType);
    assertTrue(actualIsEnabledResult);
    assertSame(externalId, actualNotificationRule.getExternalId());
    assertSame(templateId, actualTemplateId);
    assertSame(recipientsConfig, actualRecipientsConfig);
    assertSame(additionalConfig, actualAdditionalConfig);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
    assertSame(triggerConfig, actualTriggerConfig);
  }

  /**
   * Method under test:
   * {@link NotificationRule#NotificationRule(NotificationRule)}
   */
  @Test
  void testNewNotificationRule() {
    // Arrange
    NotificationRule other = new NotificationRule();

    // Act and Assert
    assertEquals(other, new NotificationRule(other));
  }

  /**
   * Method under test:
   * {@link NotificationRule#NotificationRule(NotificationRule)}
   */
  @Test
  void testNewNotificationRule2() {
    // Arrange
    NotificationRule other = new NotificationRule();
    other.setTriggerConfig(mock(NotificationRuleTriggerConfig.class));

    // Act and Assert
    assertEquals(other, new NotificationRule(other));
  }
}
