package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class NotificationRuleInfoEntityDiffblueTest {
  /**
   * Test {@link NotificationRuleInfoEntity#NotificationRuleInfoEntity(NotificationRuleEntity,
   * String, Object)}.
   *
   * <p>Method under test: {@link
   * NotificationRuleInfoEntity#NotificationRuleInfoEntity(NotificationRuleEntity, String, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NotificationRuleInfoEntity.<init>(NotificationRuleEntity, String, Object)"
  })
  public void testNewNotificationRuleInfoEntity() {
    // Arrange
    NotificationRuleEntity ruleEntity = new NotificationRuleEntity();
    ruleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleEntity.setCreatedTime(1L);
    ruleEntity.setEnabled(true);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleEntity.setExternalId(externalId);
    ruleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ruleEntity.setName("Name");
    ruleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    UUID templateId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleEntity.setTemplateId(templateId);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleEntity.setTenantId(tenantId);
    ruleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ruleEntity.setUuid(id);
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
    assertSame(id, actualNotificationRuleInfoEntity.getId());
    assertSame(id, actualNotificationRuleInfoEntity.getUuid());
    assertSame(externalId, actualNotificationRuleInfoEntity.getExternalId());
    assertSame(templateId, actualNotificationRuleInfoEntity.getTemplateId());
    assertSame(tenantId, actualNotificationRuleInfoEntity.getTenantId());
    assertSame(jsonNode, additionalConfig);
    assertSame(jsonNode, actualNotificationRuleInfoEntity.getRecipientsConfig());
    assertSame(jsonNode, actualNotificationRuleInfoEntity.getTriggerConfig());
    assertSame(jsonNode, actualNotificationRuleInfoEntity.getTemplateConfig());
  }
}
