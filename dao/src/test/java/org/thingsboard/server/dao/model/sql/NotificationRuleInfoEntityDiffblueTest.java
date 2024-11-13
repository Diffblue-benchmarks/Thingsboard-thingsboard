package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class NotificationRuleInfoEntityDiffblueTest {
  /**
   * Test
   * {@link NotificationRuleInfoEntity#NotificationRuleInfoEntity(NotificationRuleEntity, String, Object)}.
   * <p>
   * Method under test:
   * {@link NotificationRuleInfoEntity#NotificationRuleInfoEntity(NotificationRuleEntity, String, Object)}
   */
  @Test
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
    NotificationRuleInfoEntity actualNotificationRuleInfoEntity = new NotificationRuleInfoEntity(ruleEntity,
        "Template Name", jsonNode);

    // Assert
    UUID externalId = actualNotificationRuleInfoEntity.getExternalId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", externalId.toString());
    assertEquals("Name", actualNotificationRuleInfoEntity.getName());
    assertEquals("Template Name", actualNotificationRuleInfoEntity.getTemplateName());
    assertEquals(1L, actualNotificationRuleInfoEntity.getCreatedTime());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualNotificationRuleInfoEntity.getTriggerType());
    assertTrue(actualNotificationRuleInfoEntity.isEnabled());
    assertSame(externalId, actualNotificationRuleInfoEntity.getId());
    assertSame(externalId, actualNotificationRuleInfoEntity.getUuid());
    assertSame(externalId, actualNotificationRuleInfoEntity.getTemplateId());
    assertSame(externalId, actualNotificationRuleInfoEntity.getTenantId());
    assertSame(jsonNode, actualNotificationRuleInfoEntity.getAdditionalConfig());
    assertSame(jsonNode, actualNotificationRuleInfoEntity.getRecipientsConfig());
    assertSame(jsonNode, actualNotificationRuleInfoEntity.getTriggerConfig());
    assertSame(jsonNode, actualNotificationRuleInfoEntity.getTemplateConfig());
  }
}
