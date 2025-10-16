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
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class NotificationRuleInfoEntityDiffblueTest {
  /**
   * Test {@link NotificationRuleInfoEntity#NotificationRuleInfoEntity(NotificationRuleEntity,
   * String, Object)}.
   *
   * <p>Method under test: {@link
   * NotificationRuleInfoEntity#NotificationRuleInfoEntity(NotificationRuleEntity, String, Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NotificationRuleInfoEntity.<init>(NotificationRuleEntity, String, Object)"
  })
  public void testNewNotificationRuleInfoEntity() {
    // Arrange
    NotificationRuleEntity ruleEntity = new NotificationRuleEntity();
    ruleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleEntity.setCreatedTime(1L);
    ruleEntity.setEnabled(true);
    ruleEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleEntity.setId(ModelConstants.NULL_UUID);
    ruleEntity.setName("Name");
    ruleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleEntity.setTemplateId(ModelConstants.NULL_UUID);
    ruleEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    ruleEntity.setUuid(ModelConstants.NULL_UUID);
    JsonNode jsonNode = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    NotificationRuleInfoEntity actualNotificationRuleInfoEntity =
        new NotificationRuleInfoEntity(ruleEntity, "Template Name", jsonNode);

    // Assert
    JsonNode additionalConfig = actualNotificationRuleInfoEntity.getAdditionalConfig();
    assertTrue(additionalConfig instanceof ObjectNode);
    assertEquals("Name", actualNotificationRuleInfoEntity.getName());
    assertEquals("Template Name", actualNotificationRuleInfoEntity.getTemplateName());
    assertEquals(1L, actualNotificationRuleInfoEntity.getCreatedTime());
    assertEquals(
        NotificationRuleTriggerType.ENTITY_ACTION,
        actualNotificationRuleInfoEntity.getTriggerType());
    assertTrue(actualNotificationRuleInfoEntity.isEnabled());
    assertSame(jsonNode, additionalConfig);
    assertSame(jsonNode, actualNotificationRuleInfoEntity.getRecipientsConfig());
    assertSame(jsonNode, actualNotificationRuleInfoEntity.getTriggerConfig());
    assertSame(jsonNode, actualNotificationRuleInfoEntity.getTemplateConfig());
  }
}
