package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.audit.ActionStatus;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.audit.AuditLog;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AuditLogId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

class AuditLogEntityDiffblueTest {
  /**
   * Test {@link AuditLogEntity#equals(Object)}, and {@link AuditLogEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuditLogEntity#equals(Object)}
   *   <li>{@link AuditLogEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(auditLogEntity, auditLogEntity2);
    int expectedHashCodeResult = auditLogEntity.hashCode();
    assertEquals(expectedHashCodeResult, auditLogEntity2.hashCode());
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}, and {@link AuditLogEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuditLogEntity#equals(Object)}
   *   <li>{@link AuditLogEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(auditLogEntity, auditLogEntity);
    int expectedHashCodeResult = auditLogEntity.hashCode();
    assertEquals(expectedHashCodeResult, auditLogEntity.hashCode());
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(DoubleNode.valueOf(10.0d));
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(null);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Entity Name");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails(null);
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(null);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.FAILURE);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(null);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.DELETED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(3L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(null);
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(null);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("janedoe");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName(null);
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(null);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.CUSTOMER);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(null);
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(null);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("Entity Name");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName(null);
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, null);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AuditLogEntity.equals(Object)", "int AuditLogEntity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(auditLogEntity, "Different type to AuditLogEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void AuditLogEntity.<init>()",
    "JsonNode AuditLogEntity.getActionData()",
    "String AuditLogEntity.getActionFailureDetails()",
    "ActionStatus AuditLogEntity.getActionStatus()",
    "ActionType AuditLogEntity.getActionType()",
    "UUID AuditLogEntity.getCustomerId()",
    "UUID AuditLogEntity.getEntityId()",
    "String AuditLogEntity.getEntityName()",
    "EntityType AuditLogEntity.getEntityType()",
    "UUID AuditLogEntity.getTenantId()",
    "UUID AuditLogEntity.getUserId()",
    "String AuditLogEntity.getUserName()",
    "void AuditLogEntity.setActionData(JsonNode)",
    "void AuditLogEntity.setActionFailureDetails(String)",
    "void AuditLogEntity.setActionStatus(ActionStatus)",
    "void AuditLogEntity.setActionType(ActionType)",
    "void AuditLogEntity.setCustomerId(UUID)",
    "void AuditLogEntity.setEntityId(UUID)",
    "void AuditLogEntity.setEntityName(String)",
    "void AuditLogEntity.setEntityType(EntityType)",
    "void AuditLogEntity.setTenantId(UUID)",
    "void AuditLogEntity.setUserId(UUID)",
    "void AuditLogEntity.setUserName(String)",
    "String AuditLogEntity.toString()"
  })
  void testGettersAndSetters() {
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

  /**
   * Test {@link AuditLogEntity#AuditLogEntity(AuditLog)}.
   *
   * <p>Method under test: {@link AuditLogEntity#AuditLogEntity(AuditLog)}
   */
  @Test
  @DisplayName("Test new AuditLogEntity(AuditLog)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AuditLogEntity.<init>(AuditLog)"})
  void testNewAuditLogEntity() {
    // Arrange
    AuditLog auditLog = new AuditLog(new AuditLog());
    auditLog.setId(null);
    auditLog.setTenantId(null);
    auditLog.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    auditLog.setEntityId(null);
    auditLog.setUserId(null);

    // Act
    AuditLogEntity actualAuditLogEntity = new AuditLogEntity(auditLog);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualAuditLogEntity.getCustomerId().toString());
    assertNull(actualAuditLogEntity.getEntityId());
    assertNull(actualAuditLogEntity.getTenantId());
    assertNull(actualAuditLogEntity.getEntityType());
    assertEquals(0L, actualAuditLogEntity.getCreatedTime());
  }

  /**
   * Test {@link AuditLogEntity#AuditLogEntity(AuditLog)}.
   *
   * <p>Method under test: {@link AuditLogEntity#AuditLogEntity(AuditLog)}
   */
  @Test
  @DisplayName("Test new AuditLogEntity(AuditLog)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AuditLogEntity.<init>(AuditLog)"})
  void testNewAuditLogEntity2() {
    // Arrange
    AuditLog auditLog = new AuditLog(new AuditLog());
    auditLog.setId(null);
    auditLog.setTenantId(ModelConstants.SYSTEM_TENANT);
    auditLog.setCustomerId(null);
    auditLog.setEntityId(null);
    auditLog.setUserId(null);

    // Act
    AuditLogEntity actualAuditLogEntity = new AuditLogEntity(auditLog);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualAuditLogEntity.getTenantId().toString());
    assertNull(actualAuditLogEntity.getCustomerId());
    assertNull(actualAuditLogEntity.getEntityId());
    assertNull(actualAuditLogEntity.getEntityType());
    assertEquals(0L, actualAuditLogEntity.getCreatedTime());
  }

  /**
   * Test {@link AuditLogEntity#AuditLogEntity(AuditLog)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#AuditLogEntity(AuditLog)}
   */
  @Test
  @DisplayName("Test new AuditLogEntity(AuditLog); given one; then return CreatedTime is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AuditLogEntity.<init>(AuditLog)"})
  void testNewAuditLogEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setCreatedTime(1L);

    // Act
    AuditLogEntity actualAuditLogEntity = new AuditLogEntity(auditLog);

    // Assert
    assertNull(actualAuditLogEntity.getCustomerId());
    assertNull(actualAuditLogEntity.getEntityId());
    assertNull(actualAuditLogEntity.getTenantId());
    assertNull(actualAuditLogEntity.getEntityType());
    assertEquals(1L, actualAuditLogEntity.getCreatedTime());
  }

  /**
   * Test {@link AuditLogEntity#AuditLogEntity(AuditLog)}.
   *
   * <ul>
   *   <li>Then return EntityType is {@code CUSTOMER}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#AuditLogEntity(AuditLog)}
   */
  @Test
  @DisplayName("Test new AuditLogEntity(AuditLog); then return EntityType is 'CUSTOMER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AuditLogEntity.<init>(AuditLog)"})
  void testNewAuditLogEntity_thenReturnEntityTypeIsCustomer() {
    // Arrange
    AuditLog auditLog = new AuditLog(new AuditLog());
    auditLog.setId(null);
    auditLog.setTenantId(null);
    auditLog.setCustomerId(null);
    auditLog.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    auditLog.setUserId(null);

    // Act
    AuditLogEntity actualAuditLogEntity = new AuditLogEntity(auditLog);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualAuditLogEntity.getEntityId().toString());
    assertNull(actualAuditLogEntity.getCustomerId());
    assertNull(actualAuditLogEntity.getTenantId());
    assertEquals(0L, actualAuditLogEntity.getCreatedTime());
    assertEquals(EntityType.CUSTOMER, actualAuditLogEntity.getEntityType());
  }

  /**
   * Test {@link AuditLogEntity#AuditLogEntity(AuditLog)}.
   *
   * <ul>
   *   <li>Then return EntityType is {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#AuditLogEntity(AuditLog)}
   */
  @Test
  @DisplayName("Test new AuditLogEntity(AuditLog); then return EntityType is 'TENANT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AuditLogEntity.<init>(AuditLog)"})
  void testNewAuditLogEntity_thenReturnEntityTypeIsTenant() {
    // Arrange
    AuditLog auditLog = new AuditLog(new AuditLog());
    auditLog.setId(null);
    auditLog.setTenantId(null);
    auditLog.setCustomerId(null);
    auditLog.setEntityId(ModelConstants.SYSTEM_TENANT);
    auditLog.setUserId(null);

    // Act
    AuditLogEntity actualAuditLogEntity = new AuditLogEntity(auditLog);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualAuditLogEntity.getEntityId().toString());
    assertNull(actualAuditLogEntity.getCustomerId());
    assertNull(actualAuditLogEntity.getTenantId());
    assertEquals(0L, actualAuditLogEntity.getCreatedTime());
    assertEquals(EntityType.TENANT, actualAuditLogEntity.getEntityType());
  }

  /**
   * Test {@link AuditLogEntity#AuditLogEntity(AuditLog)}.
   *
   * <ul>
   *   <li>Then return Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#AuditLogEntity(AuditLog)}
   */
  @Test
  @DisplayName(
      "Test new AuditLogEntity(AuditLog); then return Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AuditLogEntity.<init>(AuditLog)"})
  void testNewAuditLogEntity_thenReturnIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AuditLog auditLog = new AuditLog(new AuditLog());
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    auditLog.setId(new AuditLogId(id));
    auditLog.setTenantId(null);
    auditLog.setCustomerId(null);
    auditLog.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    auditLog.setUserId(null);

    // Act
    AuditLogEntity actualAuditLogEntity = new AuditLogEntity(auditLog);

    // Assert
    UUID id2 = actualAuditLogEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertSame(id, id2);
    assertSame(id, actualAuditLogEntity.getUuid());
  }

  /**
   * Test {@link AuditLogEntity#AuditLogEntity(AuditLog)}.
   *
   * <ul>
   *   <li>Then return UserId toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#AuditLogEntity(AuditLog)}
   */
  @Test
  @DisplayName(
      "Test new AuditLogEntity(AuditLog); then return UserId toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AuditLogEntity.<init>(AuditLog)"})
  void testNewAuditLogEntity_thenReturnUserIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AuditLog auditLog = new AuditLog(new AuditLog());
    auditLog.setId(null);
    auditLog.setTenantId(null);
    auditLog.setCustomerId(null);
    auditLog.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    auditLog.setUserId(new UserId(id));

    // Act
    AuditLogEntity actualAuditLogEntity = new AuditLogEntity(auditLog);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualAuditLogEntity.getEntityId().toString());
    UUID userId = actualAuditLogEntity.getUserId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", userId.toString());
    assertEquals(EntityType.CUSTOMER, actualAuditLogEntity.getEntityType());
    assertSame(id, userId);
  }

  /**
   * Test {@link AuditLogEntity#AuditLogEntity(AuditLog)}.
   *
   * <ul>
   *   <li>When {@link AuditLog#AuditLog()}.
   *   <li>Then return EntityId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#AuditLogEntity(AuditLog)}
   */
  @Test
  @DisplayName("Test new AuditLogEntity(AuditLog); when AuditLog(); then return EntityId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AuditLogEntity.<init>(AuditLog)"})
  void testNewAuditLogEntity_whenAuditLog_thenReturnEntityIdIsNull() {
    // Arrange and Act
    AuditLogEntity actualAuditLogEntity = new AuditLogEntity(new AuditLog());

    // Assert
    assertNull(actualAuditLogEntity.getCustomerId());
    assertNull(actualAuditLogEntity.getEntityId());
    assertNull(actualAuditLogEntity.getTenantId());
    assertNull(actualAuditLogEntity.getEntityType());
    assertEquals(0L, actualAuditLogEntity.getCreatedTime());
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AuditLogEntity#AuditLogEntity()} EntityType is {@code ASSET}.
   *   <li>Then EntityId return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AuditLogEntity() EntityType is 'ASSET'; then EntityId return AssetId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AuditLog AuditLogEntity.toData()"})
  void testToData_givenAuditLogEntityEntityTypeIsAsset_thenEntityIdReturnAssetId() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.ASSET);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(null);
    auditLogEntity.setCustomerId(null);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    auditLogEntity.setEntityId(entityId);
    auditLogEntity.setUserId(null);

    // Act and Assert
    EntityId entityId2 = auditLogEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof AssetId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ASSET, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AuditLogEntity#AuditLogEntity()} EntityType is {@code CUSTOMER}.
   *   <li>Then EntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AuditLogEntity() EntityType is 'CUSTOMER'; then EntityId return CustomerId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AuditLog AuditLogEntity.toData()"})
  void testToData_givenAuditLogEntityEntityTypeIsCustomer_thenEntityIdReturnCustomerId() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.CUSTOMER);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(null);
    auditLogEntity.setCustomerId(null);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    auditLogEntity.setEntityId(entityId);
    auditLogEntity.setUserId(null);

    // Act and Assert
    EntityId entityId2 = auditLogEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof CustomerId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AuditLogEntity#AuditLogEntity()} EntityType is {@code TENANT}.
   *   <li>Then EntityId return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AuditLogEntity() EntityType is 'TENANT'; then EntityId return TenantId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AuditLog AuditLogEntity.toData()"})
  void testToData_givenAuditLogEntityEntityTypeIsTenant_thenEntityIdReturnTenantId() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(null);
    auditLogEntity.setCustomerId(null);
    auditLogEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserId(null);

    // Act and Assert
    EntityId entityId = auditLogEntity.toData().getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId.getId().toString());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertFalse(entityId.isNullUid());
    assertFalse(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AuditLogEntity#AuditLogEntity()} EntityType is {@code USER}.
   *   <li>Then EntityId return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AuditLogEntity() EntityType is 'USER'; then EntityId return UserId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AuditLog AuditLogEntity.toData()"})
  void testToData_givenAuditLogEntityEntityTypeIsUser_thenEntityIdReturnUserId() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.USER);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(null);
    auditLogEntity.setCustomerId(null);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    auditLogEntity.setEntityId(entityId);
    auditLogEntity.setUserId(null);

    // Act and Assert
    EntityId entityId2 = auditLogEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof UserId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.USER, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AuditLogEntity#AuditLogEntity()}.
   *   <li>Then return ActionData is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given AuditLogEntity(); then return ActionData is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AuditLog AuditLogEntity.toData()"})
  void testToData_givenAuditLogEntity_thenReturnActionDataIsNull() {
    // Arrange and Act
    AuditLog actualToDataResult = new AuditLogEntity().toData();

    // Assert
    assertNull(actualToDataResult.getActionData());
    assertNull(actualToDataResult.getActionFailureDetails());
    assertNull(actualToDataResult.getEntityName());
    assertNull(actualToDataResult.getUserName());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getActionStatus());
    assertNull(actualToDataResult.getActionType());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return DashboardId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AuditLog AuditLogEntity.toData()"})
  void testToData_thenEntityIdReturnDashboardId() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.DASHBOARD);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(null);
    auditLogEntity.setCustomerId(null);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    auditLogEntity.setEntityId(entityId);
    auditLogEntity.setUserId(null);

    // Act and Assert
    EntityId entityId2 = auditLogEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof DashboardId);
    UUID id = entityId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.DASHBOARD, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertSame(entityId, id);
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   *
   * <ul>
   *   <li>Then return CustomerId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return CustomerId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AuditLog AuditLogEntity.toData()"})
  void testToData_thenReturnCustomerIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(null);
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    auditLogEntity.setCustomerId(customerId);
    auditLogEntity.setEntityId(null);
    auditLogEntity.setUserId(null);

    // Act and Assert
    CustomerId customerId2 = auditLogEntity.toData().getCustomerId();
    UUID id = customerId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertSame(customerId, id);
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return TenantId Id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AuditLog AuditLogEntity.toData()"})
  void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID tenantId = UUID.randomUUID();
    auditLogEntity.setTenantId(tenantId);
    auditLogEntity.setCustomerId(null);
    auditLogEntity.setEntityId(null);
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    auditLogEntity.setUserId(userId);

    // Act
    AuditLog actualToDataResult = auditLogEntity.toData();

    // Assert
    UserId userId2 = actualToDataResult.getUserId();
    UUID id = userId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertEquals(EntityType.USER, userId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(userId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(userId, id);
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return TenantId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AuditLog AuditLogEntity.toData()"})
  void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setCustomerId(null);
    auditLogEntity.setEntityId(null);
    auditLogEntity.setUserId(null);

    // Act and Assert
    TenantId tenantId = auditLogEntity.toData().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   *
   * <ul>
   *   <li>Then return UserId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return UserId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AuditLog AuditLogEntity.toData()"})
  void testToData_thenReturnUserIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    auditLogEntity.setTenantId(null);
    auditLogEntity.setCustomerId(null);
    auditLogEntity.setEntityId(null);
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    auditLogEntity.setUserId(userId);

    // Act and Assert
    UserId userId2 = auditLogEntity.toData().getUserId();
    UUID id = userId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.USER, userId2.getEntityType());
    assertFalse(userId2.isNullUid());
    assertSame(userId, id);
  }
}
