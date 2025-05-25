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
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class NotificationTargetEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTargetEntity#NotificationTargetEntity()}
   *   <li>{@link NotificationTargetEntity#setConfiguration(JsonNode)}
   *   <li>{@link NotificationTargetEntity#setExternalId(UUID)}
   *   <li>{@link NotificationTargetEntity#setName(String)}
   *   <li>{@link NotificationTargetEntity#setTenantId(UUID)}
   *   <li>{@link NotificationTargetEntity#toString()}
   *   <li>{@link NotificationTargetEntity#getConfiguration()}
   *   <li>{@link NotificationTargetEntity#getExternalId()}
   *   <li>{@link NotificationTargetEntity#getName()}
   *   <li>{@link NotificationTargetEntity#getTenantId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationTargetEntity.<init>()", "JsonNode NotificationTargetEntity.getConfiguration()",
      "UUID NotificationTargetEntity.getExternalId()", "String NotificationTargetEntity.getName()",
      "UUID NotificationTargetEntity.getTenantId()", "void NotificationTargetEntity.setConfiguration(JsonNode)",
      "void NotificationTargetEntity.setExternalId(UUID)", "void NotificationTargetEntity.setName(String)",
      "void NotificationTargetEntity.setTenantId(UUID)", "String NotificationTargetEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    NotificationTargetEntity actualNotificationTargetEntity = new NotificationTargetEntity();
    JsonNode configuration = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualNotificationTargetEntity.setConfiguration(configuration);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualNotificationTargetEntity.setExternalId(externalId);
    actualNotificationTargetEntity.setName("Name");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualNotificationTargetEntity.setTenantId(tenantId);
    String actualToStringResult = actualNotificationTargetEntity.toString();
    JsonNode actualConfiguration = actualNotificationTargetEntity.getConfiguration();
    UUID actualExternalId = actualNotificationTargetEntity.getExternalId();
    String actualName = actualNotificationTargetEntity.getName();
    UUID actualTenantId = actualNotificationTargetEntity.getTenantId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualExternalId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Name", actualName);
    assertEquals("NotificationTargetEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, name=Name, configuration={"
        + "\"isPublic\":true}, externalId=784f394c-42b6-435a-983c-b7beff2784f9)", actualToStringResult);
    assertNull(actualNotificationTargetEntity.getId());
    assertNull(actualNotificationTargetEntity.getUuid());
    assertEquals(0L, actualNotificationTargetEntity.getCreatedTime());
    assertSame(externalId, actualExternalId);
    assertSame(tenantId, actualTenantId);
    assertSame(configuration, actualConfiguration);
  }
}
