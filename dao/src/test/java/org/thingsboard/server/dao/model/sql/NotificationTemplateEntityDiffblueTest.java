package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class NotificationTemplateEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplateEntity#NotificationTemplateEntity()}
   *   <li>{@link NotificationTemplateEntity#setConfiguration(JsonNode)}
   *   <li>{@link NotificationTemplateEntity#setExternalId(UUID)}
   *   <li>{@link NotificationTemplateEntity#setName(String)}
   *   <li>{@link NotificationTemplateEntity#setNotificationType(NotificationType)}
   *   <li>{@link NotificationTemplateEntity#setTenantId(UUID)}
   *   <li>{@link NotificationTemplateEntity#toString()}
   *   <li>{@link NotificationTemplateEntity#getConfiguration()}
   *   <li>{@link NotificationTemplateEntity#getExternalId()}
   *   <li>{@link NotificationTemplateEntity#getName()}
   *   <li>{@link NotificationTemplateEntity#getNotificationType()}
   *   <li>{@link NotificationTemplateEntity#getTenantId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationTemplateEntity.<init>()",
      "JsonNode NotificationTemplateEntity.getConfiguration()", "UUID NotificationTemplateEntity.getExternalId()",
      "String NotificationTemplateEntity.getName()",
      "NotificationType NotificationTemplateEntity.getNotificationType()",
      "UUID NotificationTemplateEntity.getTenantId()", "void NotificationTemplateEntity.setConfiguration(JsonNode)",
      "void NotificationTemplateEntity.setExternalId(UUID)", "void NotificationTemplateEntity.setName(String)",
      "void NotificationTemplateEntity.setNotificationType(NotificationType)",
      "void NotificationTemplateEntity.setTenantId(UUID)", "String NotificationTemplateEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    NotificationTemplateEntity actualNotificationTemplateEntity = new NotificationTemplateEntity();
    JsonNode configuration = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualNotificationTemplateEntity.setConfiguration(configuration);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualNotificationTemplateEntity.setExternalId(externalId);
    actualNotificationTemplateEntity.setName("Name");
    actualNotificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualNotificationTemplateEntity.setTenantId(tenantId);
    String actualToStringResult = actualNotificationTemplateEntity.toString();
    JsonNode actualConfiguration = actualNotificationTemplateEntity.getConfiguration();
    UUID actualExternalId = actualNotificationTemplateEntity.getExternalId();
    String actualName = actualNotificationTemplateEntity.getName();
    NotificationType actualNotificationType = actualNotificationTemplateEntity.getNotificationType();
    UUID actualTenantId = actualNotificationTemplateEntity.getTenantId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualExternalId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Name", actualName);
    assertEquals(
        "NotificationTemplateEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, name=Name, notificationType"
            + "=GENERAL, configuration={\"isPublic\":true}, externalId=784f394c-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertNull(actualNotificationTemplateEntity.getId());
    assertNull(actualNotificationTemplateEntity.getUuid());
    assertEquals(0L, actualNotificationTemplateEntity.getCreatedTime());
    assertEquals(NotificationType.GENERAL, actualNotificationType);
    assertSame(externalId, actualExternalId);
    assertSame(tenantId, actualTenantId);
    assertSame(configuration, actualConfiguration);
  }
}
