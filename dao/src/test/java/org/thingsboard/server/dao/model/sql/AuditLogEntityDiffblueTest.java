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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.audit.ActionStatus;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class AuditLogEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AuditLogEntity#AuditLogEntity()}
   *   <li>{@link AuditLogEntity#setActionData(JsonNode)}
   *   <li>{@link AuditLogEntity#setActionFailureDetails(String)}
   *   <li>{@link AuditLogEntity#setActionStatus(ActionStatus)}
   *   <li>{@link AuditLogEntity#setActionType(ActionType)}
   *   <li>{@link AuditLogEntity#setCustomerId(UUID)}
   *   <li>{@link AuditLogEntity#setEntityId(UUID)}
   *   <li>{@link AuditLogEntity#setEntityName(String)}
   *   <li>{@link AuditLogEntity#setEntityType(EntityType)}
   *   <li>{@link AuditLogEntity#setTenantId(UUID)}
   *   <li>{@link AuditLogEntity#setUserId(UUID)}
   *   <li>{@link AuditLogEntity#setUserName(String)}
   *   <li>{@link AuditLogEntity#toString()}
   *   <li>{@link AuditLogEntity#getActionData()}
   *   <li>{@link AuditLogEntity#getActionFailureDetails()}
   *   <li>{@link AuditLogEntity#getActionStatus()}
   *   <li>{@link AuditLogEntity#getActionType()}
   *   <li>{@link AuditLogEntity#getCustomerId()}
   *   <li>{@link AuditLogEntity#getEntityId()}
   *   <li>{@link AuditLogEntity#getEntityName()}
   *   <li>{@link AuditLogEntity#getEntityType()}
   *   <li>{@link AuditLogEntity#getTenantId()}
   *   <li>{@link AuditLogEntity#getUserId()}
   *   <li>{@link AuditLogEntity#getUserName()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AuditLogEntity.<init>()", "JsonNode AuditLogEntity.getActionData()",
      "String AuditLogEntity.getActionFailureDetails()", "ActionStatus AuditLogEntity.getActionStatus()",
      "ActionType AuditLogEntity.getActionType()", "UUID AuditLogEntity.getCustomerId()",
      "UUID AuditLogEntity.getEntityId()", "String AuditLogEntity.getEntityName()",
      "EntityType AuditLogEntity.getEntityType()", "UUID AuditLogEntity.getTenantId()",
      "UUID AuditLogEntity.getUserId()", "String AuditLogEntity.getUserName()",
      "void AuditLogEntity.setActionData(JsonNode)", "void AuditLogEntity.setActionFailureDetails(String)",
      "void AuditLogEntity.setActionStatus(ActionStatus)", "void AuditLogEntity.setActionType(ActionType)",
      "void AuditLogEntity.setCustomerId(UUID)", "void AuditLogEntity.setEntityId(UUID)",
      "void AuditLogEntity.setEntityName(String)", "void AuditLogEntity.setEntityType(EntityType)",
      "void AuditLogEntity.setTenantId(UUID)", "void AuditLogEntity.setUserId(UUID)",
      "void AuditLogEntity.setUserName(String)", "String AuditLogEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    AuditLogEntity actualAuditLogEntity = new AuditLogEntity();
    JsonNode actionData = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualAuditLogEntity.setActionData(actionData);
    actualAuditLogEntity.setActionFailureDetails("Action Failure Details");
    actualAuditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    actualAuditLogEntity.setActionType(ActionType.ADDED);
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualAuditLogEntity.setCustomerId(customerId);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualAuditLogEntity.setEntityId(entityId);
    actualAuditLogEntity.setEntityName("Entity Name");
    actualAuditLogEntity.setEntityType(EntityType.TENANT);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualAuditLogEntity.setTenantId(tenantId);
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualAuditLogEntity.setUserId(userId);
    actualAuditLogEntity.setUserName("janedoe");
    String actualToStringResult = actualAuditLogEntity.toString();
    JsonNode actualActionData = actualAuditLogEntity.getActionData();
    String actualActionFailureDetails = actualAuditLogEntity.getActionFailureDetails();
    ActionStatus actualActionStatus = actualAuditLogEntity.getActionStatus();
    ActionType actualActionType = actualAuditLogEntity.getActionType();
    UUID actualCustomerId = actualAuditLogEntity.getCustomerId();
    UUID actualEntityId = actualAuditLogEntity.getEntityId();
    String actualEntityName = actualAuditLogEntity.getEntityName();
    EntityType actualEntityType = actualAuditLogEntity.getEntityType();
    UUID actualTenantId = actualAuditLogEntity.getTenantId();
    UUID actualUserId = actualAuditLogEntity.getUserId();
    String actualUserName = actualAuditLogEntity.getUserName();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualCustomerId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEntityId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualUserId.toString());
    assertEquals("Action Failure Details", actualActionFailureDetails);
    assertEquals(
        "AuditLogEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, customerId=784f394c-42b6-435a-983c"
            + "-b7beff2784f9, entityType=TENANT, entityId=784f394c-42b6-435a-983c-b7beff2784f9, entityName=Entity"
            + " Name, userId=784f394c-42b6-435a-983c-b7beff2784f9, userName=janedoe, actionType=ADDED, actionData={"
            + "\"isPublic\":true}, actionStatus=SUCCESS, actionFailureDetails=Action Failure Details)",
        actualToStringResult);
    assertEquals("Entity Name", actualEntityName);
    assertEquals("janedoe", actualUserName);
    assertNull(actualAuditLogEntity.getId());
    assertNull(actualAuditLogEntity.getUuid());
    assertEquals(0L, actualAuditLogEntity.getCreatedTime());
    assertEquals(EntityType.TENANT, actualEntityType);
    assertEquals(ActionStatus.SUCCESS, actualActionStatus);
    assertEquals(ActionType.ADDED, actualActionType);
    assertSame(customerId, actualCustomerId);
    assertSame(entityId, actualEntityId);
    assertSame(tenantId, actualTenantId);
    assertSame(userId, actualUserId);
    assertSame(actionData, actualActionData);
  }
}
