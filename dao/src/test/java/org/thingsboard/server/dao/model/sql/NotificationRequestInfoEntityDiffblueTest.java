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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class NotificationRequestInfoEntityDiffblueTest {
  /**
   * Test {@link
   * NotificationRequestInfoEntity#NotificationRequestInfoEntity(NotificationRequestEntity, String,
   * Object)}.
   *
   * <p>Method under test: {@link
   * NotificationRequestInfoEntity#NotificationRequestInfoEntity(NotificationRequestEntity, String,
   * Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NotificationRequestInfoEntity.<init>(NotificationRequestEntity, String, Object)"
  })
  public void testNewNotificationRequestInfoEntity() {
    // Arrange
    NotificationRequestEntity requestEntity = new NotificationRequestEntity();
    requestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    requestEntity.setCreatedTime(1L);
    requestEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    requestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    UUID originatorEntityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    requestEntity.setOriginatorEntityId(originatorEntityId);
    requestEntity.setOriginatorEntityType(EntityType.TENANT);
    UUID ruleId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    requestEntity.setRuleId(ruleId);
    requestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    requestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    requestEntity.setTargets("Targets");
    requestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    UUID templateId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    requestEntity.setTemplateId(templateId);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    requestEntity.setTenantId(tenantId);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    requestEntity.setUuid(id);
    JsonNode jsonNode = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    NotificationRequestInfoEntity actualNotificationRequestInfoEntity =
        new NotificationRequestInfoEntity(requestEntity, "Template Name", jsonNode);

    // Assert
    JsonNode additionalConfig = actualNotificationRequestInfoEntity.getAdditionalConfig();
    assertTrue(additionalConfig instanceof ObjectNode);
    assertEquals("Targets", actualNotificationRequestInfoEntity.getTargets());
    assertEquals("Template Name", actualNotificationRequestInfoEntity.getTemplateName());
    assertEquals(1L, actualNotificationRequestInfoEntity.getCreatedTime());
    assertEquals(EntityType.TENANT, actualNotificationRequestInfoEntity.getOriginatorEntityType());
    assertEquals(
        NotificationRequestStatus.PROCESSING, actualNotificationRequestInfoEntity.getStatus());
    assertSame(id, actualNotificationRequestInfoEntity.getId());
    assertSame(id, actualNotificationRequestInfoEntity.getUuid());
    assertSame(originatorEntityId, actualNotificationRequestInfoEntity.getOriginatorEntityId());
    assertSame(ruleId, actualNotificationRequestInfoEntity.getRuleId());
    assertSame(templateId, actualNotificationRequestInfoEntity.getTemplateId());
    assertSame(tenantId, actualNotificationRequestInfoEntity.getTenantId());
    assertSame(jsonNode, additionalConfig);
    assertSame(jsonNode, actualNotificationRequestInfoEntity.getInfo());
    assertSame(jsonNode, actualNotificationRequestInfoEntity.getStats());
    assertSame(jsonNode, actualNotificationRequestInfoEntity.getTemplate());
    assertSame(jsonNode, actualNotificationRequestInfoEntity.getTemplateConfig());
  }
}
