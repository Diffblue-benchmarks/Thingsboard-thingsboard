package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class NotificationRequestInfoEntityDiffblueTest {
  /**
   * Test
   * {@link NotificationRequestInfoEntity#NotificationRequestInfoEntity(NotificationRequestEntity, String, Object)}.
   * <p>
   * Method under test:
   * {@link NotificationRequestInfoEntity#NotificationRequestInfoEntity(NotificationRequestEntity, String, Object)}
   */
  @Test
  public void testNewNotificationRequestInfoEntity() {
    // Arrange
    NotificationRequestEntity requestEntity = new NotificationRequestEntity();
    requestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    requestEntity.setCreatedTime(1L);
    requestEntity.setId(ModelConstants.NULL_UUID);
    requestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    requestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    requestEntity.setOriginatorEntityType(EntityType.TENANT);
    requestEntity.setRuleId(ModelConstants.NULL_UUID);
    requestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    requestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    requestEntity.setTargets("Targets");
    requestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    requestEntity.setTemplateId(ModelConstants.NULL_UUID);
    requestEntity.setTenantId(ModelConstants.NULL_UUID);
    requestEntity.setUuid(ModelConstants.NULL_UUID);
    JsonNode jsonNode = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    NotificationRequestInfoEntity actualNotificationRequestInfoEntity = new NotificationRequestInfoEntity(requestEntity,
        "Template Name", jsonNode);

    // Assert
    UUID id = actualNotificationRequestInfoEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("Targets", actualNotificationRequestInfoEntity.getTargets());
    assertEquals("Template Name", actualNotificationRequestInfoEntity.getTemplateName());
    assertEquals(1L, actualNotificationRequestInfoEntity.getCreatedTime());
    assertEquals(EntityType.TENANT, actualNotificationRequestInfoEntity.getOriginatorEntityType());
    assertEquals(NotificationRequestStatus.PROCESSING, actualNotificationRequestInfoEntity.getStatus());
    assertSame(id, actualNotificationRequestInfoEntity.getUuid());
    assertSame(id, actualNotificationRequestInfoEntity.getOriginatorEntityId());
    assertSame(id, actualNotificationRequestInfoEntity.getRuleId());
    assertSame(id, actualNotificationRequestInfoEntity.getTemplateId());
    assertSame(id, actualNotificationRequestInfoEntity.getTenantId());
    assertSame(jsonNode, actualNotificationRequestInfoEntity.getAdditionalConfig());
    assertSame(jsonNode, actualNotificationRequestInfoEntity.getInfo());
    assertSame(jsonNode, actualNotificationRequestInfoEntity.getStats());
    assertSame(jsonNode, actualNotificationRequestInfoEntity.getTemplate());
    assertSame(jsonNode, actualNotificationRequestInfoEntity.getTemplateConfig());
  }
}
