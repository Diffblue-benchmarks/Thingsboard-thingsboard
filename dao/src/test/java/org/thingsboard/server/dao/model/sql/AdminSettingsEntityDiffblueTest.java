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

public class AdminSettingsEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AdminSettingsEntity#AdminSettingsEntity()}
   *   <li>{@link AdminSettingsEntity#setJsonValue(JsonNode)}
   *   <li>{@link AdminSettingsEntity#setKey(String)}
   *   <li>{@link AdminSettingsEntity#setTenantId(UUID)}
   *   <li>{@link AdminSettingsEntity#toString()}
   *   <li>{@link AdminSettingsEntity#getJsonValue()}
   *   <li>{@link AdminSettingsEntity#getKey()}
   *   <li>{@link AdminSettingsEntity#getTenantId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminSettingsEntity.<init>()", "JsonNode AdminSettingsEntity.getJsonValue()",
      "String AdminSettingsEntity.getKey()", "UUID AdminSettingsEntity.getTenantId()",
      "void AdminSettingsEntity.setJsonValue(JsonNode)", "void AdminSettingsEntity.setKey(String)",
      "void AdminSettingsEntity.setTenantId(UUID)", "String AdminSettingsEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    AdminSettingsEntity actualAdminSettingsEntity = new AdminSettingsEntity();
    JsonNode jsonValue = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualAdminSettingsEntity.setJsonValue(jsonValue);
    actualAdminSettingsEntity.setKey("Key");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualAdminSettingsEntity.setTenantId(tenantId);
    String actualToStringResult = actualAdminSettingsEntity.toString();
    JsonNode actualJsonValue = actualAdminSettingsEntity.getJsonValue();
    String actualKey = actualAdminSettingsEntity.getKey();
    UUID actualTenantId = actualAdminSettingsEntity.getTenantId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("AdminSettingsEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, key=Key, jsonValue={\"isPublic"
        + "\":true})", actualToStringResult);
    assertEquals("Key", actualKey);
    assertNull(actualAdminSettingsEntity.getId());
    assertNull(actualAdminSettingsEntity.getUuid());
    assertEquals(0L, actualAdminSettingsEntity.getCreatedTime());
    assertSame(tenantId, actualTenantId);
    assertSame(jsonValue, actualJsonValue);
  }
}
