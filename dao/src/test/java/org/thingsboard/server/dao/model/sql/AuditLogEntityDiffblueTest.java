package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import org.junit.Test;
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

public class AuditLogEntityDiffblueTest {
  /**
   * Test {@link AuditLogEntity#equals(Object)}, and
   * {@link AuditLogEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AuditLogEntity#equals(Object)}
   *   <li>{@link AuditLogEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(auditLogEntity, auditLogEntity2);
    int expectedHashCodeResult = auditLogEntity.hashCode();
    assertEquals(expectedHashCodeResult, auditLogEntity2.hashCode());
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}, and
   * {@link AuditLogEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AuditLogEntity#equals(Object)}
   *   <li>{@link AuditLogEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(auditLogEntity, auditLogEntity);
    int expectedHashCodeResult = auditLogEntity.hashCode();
    assertEquals(expectedHashCodeResult, auditLogEntity.hashCode());
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(MissingNode.getInstance());
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(null);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(mock(JsonNode.class));
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Entity Name");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails(null);
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(null);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.FAILURE);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(null);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.DELETED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(3L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(UUID.randomUUID());
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(null);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(UUID.randomUUID());
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(null);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("janedoe");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName(null);
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(null);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.CUSTOMER);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(UUID.randomUUID());
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(null);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(UUID.randomUUID());
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(null);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("Entity Name");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName(null);
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    AuditLogEntity auditLogEntity2 = new AuditLogEntity();
    auditLogEntity2.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity2.setActionFailureDetails("Action Failure Details");
    auditLogEntity2.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity2.setActionType(ActionType.ADDED);
    auditLogEntity2.setCreatedTime(1L);
    auditLogEntity2.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity2.setEntityName("Entity Name");
    auditLogEntity2.setEntityType(EntityType.TENANT);
    auditLogEntity2.setId(ModelConstants.NULL_UUID);
    auditLogEntity2.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity2.setUserName("janedoe");
    auditLogEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, auditLogEntity2);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, null);
  }

  /**
   * Test {@link AuditLogEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(auditLogEntity, "Different type to AuditLogEntity");
  }

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
  public void testGettersAndSetters() {
    // Arrange and Act
    AuditLogEntity actualAuditLogEntity = new AuditLogEntity();
    JsonNode actionData = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualAuditLogEntity.setActionData(actionData);
    actualAuditLogEntity.setActionFailureDetails("Action Failure Details");
    actualAuditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    actualAuditLogEntity.setActionType(ActionType.ADDED);
    actualAuditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    actualAuditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    actualAuditLogEntity.setEntityName("Entity Name");
    actualAuditLogEntity.setEntityType(EntityType.TENANT);
    actualAuditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    UUID userId = ModelConstants.NULL_UUID;
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

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualCustomerId.toString());
    assertEquals("Action Failure Details", actualActionFailureDetails);
    assertEquals(
        "AuditLogEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, customerId=13814000-1dd2-11b2-8080"
            + "-808080808080, entityType=TENANT, entityId=13814000-1dd2-11b2-8080-808080808080, entityName=Entity"
            + " Name, userId=13814000-1dd2-11b2-8080-808080808080, userName=janedoe, actionType=ADDED, actionData={"
            + "\"isPublic\":true}, actionStatus=SUCCESS, actionFailureDetails=Action Failure Details)",
        actualToStringResult);
    assertEquals("Entity Name", actualEntityName);
    assertEquals("janedoe", actualUserName);
    assertEquals(0L, actualAuditLogEntity.getCreatedTime());
    assertEquals(EntityType.TENANT, actualEntityType);
    assertEquals(ActionStatus.SUCCESS, actualActionStatus);
    assertEquals(ActionType.ADDED, actualActionType);
    assertSame(actionData, actualActionData);
    assertSame(userId, actualCustomerId);
    assertSame(userId, actualEntityId);
    assertSame(userId, actualTenantId);
    assertSame(userId, actualUserId);
  }

  /**
   * Test {@link AuditLogEntity#AuditLogEntity(AuditLog)}.
   * <p>
   * Method under test: {@link AuditLogEntity#AuditLogEntity(AuditLog)}
   */
  @Test
  public void testNewAuditLogEntity() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setTenantId(null);
    auditLog.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    auditLog.setEntityId(null);
    auditLog.setUserId(null);

    // Act
    AuditLogEntity actualAuditLogEntity = new AuditLogEntity(auditLog);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualAuditLogEntity.getCustomerId().toString());
    assertNull(actualAuditLogEntity.getId());
    assertNull(actualAuditLogEntity.getUuid());
    assertNull(actualAuditLogEntity.getEntityId());
    assertNull(actualAuditLogEntity.getTenantId());
    assertNull(actualAuditLogEntity.getUserId());
    assertNull(actualAuditLogEntity.getEntityType());
    assertEquals(0L, actualAuditLogEntity.getCreatedTime());
  }

  /**
   * Test {@link AuditLogEntity#AuditLogEntity(AuditLog)}.
   * <p>
   * Method under test: {@link AuditLogEntity#AuditLogEntity(AuditLog)}
   */
  @Test
  public void testNewAuditLogEntity2() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setTenantId(ModelConstants.SYSTEM_TENANT);
    auditLog.setCustomerId(null);
    auditLog.setEntityId(null);
    auditLog.setUserId(null);

    // Act
    AuditLogEntity actualAuditLogEntity = new AuditLogEntity(auditLog);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualAuditLogEntity.getTenantId().toString());
    assertNull(actualAuditLogEntity.getId());
    assertNull(actualAuditLogEntity.getUuid());
    assertNull(actualAuditLogEntity.getCustomerId());
    assertNull(actualAuditLogEntity.getEntityId());
    assertNull(actualAuditLogEntity.getUserId());
    assertNull(actualAuditLogEntity.getEntityType());
    assertEquals(0L, actualAuditLogEntity.getCreatedTime());
  }

  /**
   * Test {@link AuditLogEntity#AuditLogEntity(AuditLog)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return CreatedTime is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#AuditLogEntity(AuditLog)}
   */
  @Test
  public void testNewAuditLogEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setCreatedTime(1L);

    // Act
    AuditLogEntity actualAuditLogEntity = new AuditLogEntity(auditLog);

    // Assert
    assertNull(actualAuditLogEntity.getId());
    assertNull(actualAuditLogEntity.getUuid());
    assertNull(actualAuditLogEntity.getCustomerId());
    assertNull(actualAuditLogEntity.getEntityId());
    assertNull(actualAuditLogEntity.getTenantId());
    assertNull(actualAuditLogEntity.getUserId());
    assertNull(actualAuditLogEntity.getEntityType());
    assertEquals(1L, actualAuditLogEntity.getCreatedTime());
  }

  /**
   * Test {@link AuditLogEntity#AuditLogEntity(AuditLog)}.
   * <ul>
   *   <li>Then return EntityType is {@code CUSTOMER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#AuditLogEntity(AuditLog)}
   */
  @Test
  public void testNewAuditLogEntity_thenReturnEntityTypeIsCustomer() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setTenantId(null);
    auditLog.setCustomerId(null);
    auditLog.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    auditLog.setUserId(null);

    // Act
    AuditLogEntity actualAuditLogEntity = new AuditLogEntity(auditLog);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualAuditLogEntity.getEntityId().toString());
    assertNull(actualAuditLogEntity.getId());
    assertNull(actualAuditLogEntity.getUuid());
    assertNull(actualAuditLogEntity.getCustomerId());
    assertNull(actualAuditLogEntity.getTenantId());
    assertNull(actualAuditLogEntity.getUserId());
    assertEquals(0L, actualAuditLogEntity.getCreatedTime());
    assertEquals(EntityType.CUSTOMER, actualAuditLogEntity.getEntityType());
  }

  /**
   * Test {@link AuditLogEntity#AuditLogEntity(AuditLog)}.
   * <ul>
   *   <li>Then return EntityType is {@code TENANT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#AuditLogEntity(AuditLog)}
   */
  @Test
  public void testNewAuditLogEntity_thenReturnEntityTypeIsTenant() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setTenantId(null);
    auditLog.setCustomerId(null);
    auditLog.setEntityId(ModelConstants.SYSTEM_TENANT);
    auditLog.setUserId(null);

    // Act
    AuditLogEntity actualAuditLogEntity = new AuditLogEntity(auditLog);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualAuditLogEntity.getEntityId().toString());
    assertNull(actualAuditLogEntity.getId());
    assertNull(actualAuditLogEntity.getUuid());
    assertNull(actualAuditLogEntity.getCustomerId());
    assertNull(actualAuditLogEntity.getTenantId());
    assertNull(actualAuditLogEntity.getUserId());
    assertEquals(0L, actualAuditLogEntity.getCreatedTime());
    assertEquals(EntityType.TENANT, actualAuditLogEntity.getEntityType());
  }

  /**
   * Test {@link AuditLogEntity#AuditLogEntity(AuditLog)}.
   * <ul>
   *   <li>Then return Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#AuditLogEntity(AuditLog)}
   */
  @Test
  public void testNewAuditLogEntity_thenReturnIdToStringIs138140001dd211b28080808080808080() {
    // Arrange and Act
    AuditLogEntity actualAuditLogEntity = new AuditLogEntity(new AuditLog(new AuditLogId(ModelConstants.NULL_UUID)));

    // Assert
    UUID id = actualAuditLogEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertNull(actualAuditLogEntity.getEntityId());
    assertNull(actualAuditLogEntity.getEntityType());
    assertSame(id, actualAuditLogEntity.getUuid());
  }

  /**
   * Test {@link AuditLogEntity#AuditLogEntity(AuditLog)}.
   * <ul>
   *   <li>Then return UserId toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#AuditLogEntity(AuditLog)}
   */
  @Test
  public void testNewAuditLogEntity_thenReturnUserIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AuditLog auditLog = new AuditLog();
    auditLog.setTenantId(null);
    auditLog.setCustomerId(null);
    auditLog.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    auditLog.setUserId(new UserId(ModelConstants.NULL_UUID));

    // Act
    AuditLogEntity actualAuditLogEntity = new AuditLogEntity(auditLog);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualAuditLogEntity.getEntityId().toString());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualAuditLogEntity.getUserId().toString());
    assertNull(actualAuditLogEntity.getId());
    assertNull(actualAuditLogEntity.getUuid());
    assertNull(actualAuditLogEntity.getCustomerId());
    assertNull(actualAuditLogEntity.getTenantId());
    assertEquals(0L, actualAuditLogEntity.getCreatedTime());
    assertEquals(EntityType.CUSTOMER, actualAuditLogEntity.getEntityType());
  }

  /**
   * Test {@link AuditLogEntity#AuditLogEntity(AuditLog)}.
   * <ul>
   *   <li>When {@link AuditLog#AuditLog()}.</li>
   *   <li>Then return EntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#AuditLogEntity(AuditLog)}
   */
  @Test
  public void testNewAuditLogEntity_whenAuditLog_thenReturnEntityIdIsNull() {
    // Arrange and Act
    AuditLogEntity actualAuditLogEntity = new AuditLogEntity(new AuditLog());

    // Assert
    assertNull(actualAuditLogEntity.getId());
    assertNull(actualAuditLogEntity.getUuid());
    assertNull(actualAuditLogEntity.getCustomerId());
    assertNull(actualAuditLogEntity.getEntityId());
    assertNull(actualAuditLogEntity.getTenantId());
    assertNull(actualAuditLogEntity.getUserId());
    assertNull(actualAuditLogEntity.getEntityType());
    assertEquals(0L, actualAuditLogEntity.getCreatedTime());
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   * <ul>
   *   <li>Given {@link AuditLogEntity#AuditLogEntity()} EntityType is
   * {@code ASSET}.</li>
   *   <li>Then EntityId return {@link AssetId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  public void testToData_givenAuditLogEntityEntityTypeIsAsset_thenEntityIdReturnAssetId() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.ASSET);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(null);
    auditLogEntity.setCustomerId(null);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(null);

    // Act and Assert
    EntityId entityId = auditLogEntity.toData().getEntityId();
    assertTrue(entityId instanceof AssetId);
    assertEquals(EntityType.ASSET, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   * <ul>
   *   <li>Given {@link AuditLogEntity#AuditLogEntity()} EntityType is
   * {@code CUSTOMER}.</li>
   *   <li>Then EntityId return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  public void testToData_givenAuditLogEntityEntityTypeIsCustomer_thenEntityIdReturnCustomerId() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.CUSTOMER);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(null);
    auditLogEntity.setCustomerId(null);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(null);

    // Act and Assert
    EntityId entityId = auditLogEntity.toData().getEntityId();
    assertTrue(entityId instanceof CustomerId);
    assertEquals(EntityType.CUSTOMER, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   * <ul>
   *   <li>Given {@link AuditLogEntity#AuditLogEntity()} EntityType is
   * {@code TENANT}.</li>
   *   <li>Then EntityId return {@link TenantId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  public void testToData_givenAuditLogEntityEntityTypeIsTenant_thenEntityIdReturnTenantId() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(null);
    auditLogEntity.setCustomerId(null);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(null);

    // Act and Assert
    EntityId entityId = auditLogEntity.toData().getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertTrue(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   * <ul>
   *   <li>Given {@link AuditLogEntity#AuditLogEntity()} EntityType is
   * {@code USER}.</li>
   *   <li>Then EntityId return {@link UserId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  public void testToData_givenAuditLogEntityEntityTypeIsUser_thenEntityIdReturnUserId() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.USER);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(null);
    auditLogEntity.setCustomerId(null);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(null);

    // Act and Assert
    EntityId entityId = auditLogEntity.toData().getEntityId();
    assertTrue(entityId instanceof UserId);
    assertEquals(EntityType.USER, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   * <ul>
   *   <li>Given {@link AuditLogEntity#AuditLogEntity()} TenantId is
   * randomUUID.</li>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  public void testToData_givenAuditLogEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);
    UUID tenantId = UUID.randomUUID();
    auditLogEntity.setTenantId(tenantId);
    auditLogEntity.setCustomerId(null);
    auditLogEntity.setEntityId(null);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    TenantId tenantId2 = auditLogEntity.toData().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   * <ul>
   *   <li>Given {@link AuditLogEntity#AuditLogEntity()} UserId is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return UserId EntityType is {@code USER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  public void testToData_givenAuditLogEntityUserIdIsNull_uuid_thenReturnUserIdEntityTypeIsUser() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(null);
    auditLogEntity.setCustomerId(null);
    auditLogEntity.setEntityId(null);
    auditLogEntity.setUserId(ModelConstants.NULL_UUID);

    // Act
    AuditLog actualToDataResult = auditLogEntity.toData();

    // Assert
    assertNull(actualToDataResult.getEntityId());
    UserId userId = actualToDataResult.getUserId();
    assertEquals(EntityType.USER, userId.getEntityType());
    assertTrue(userId.isNullUid());
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   * <ul>
   *   <li>Given {@link AuditLogEntity#AuditLogEntity()}.</li>
   *   <li>Then return ActionData is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  public void testToData_givenAuditLogEntity_thenReturnActionDataIsNull() {
    // Arrange and Act
    AuditLog actualToDataResult = (new AuditLogEntity()).toData();

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
   * <ul>
   *   <li>Then EntityId return {@link DashboardId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnDashboardId() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.DASHBOARD);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(null);
    auditLogEntity.setCustomerId(null);
    auditLogEntity.setEntityId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserId(null);

    // Act and Assert
    EntityId entityId = auditLogEntity.toData().getEntityId();
    assertTrue(entityId instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   * <ul>
   *   <li>Then return CustomerId EntityType is {@code CUSTOMER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  public void testToData_thenReturnCustomerIdEntityTypeIsCustomer() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(null);
    auditLogEntity.setCustomerId(ModelConstants.NULL_UUID);
    auditLogEntity.setEntityId(null);
    auditLogEntity.setUserId(null);

    // Act
    AuditLog actualToDataResult = auditLogEntity.toData();

    // Assert
    assertNull(actualToDataResult.getEntityId());
    CustomerId customerId = actualToDataResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link AuditLogEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AuditLogEntity auditLogEntity = new AuditLogEntity();
    auditLogEntity.setActionData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    auditLogEntity.setActionFailureDetails("Action Failure Details");
    auditLogEntity.setActionStatus(ActionStatus.SUCCESS);
    auditLogEntity.setActionType(ActionType.ADDED);
    auditLogEntity.setCreatedTime(1L);
    auditLogEntity.setEntityName("Entity Name");
    auditLogEntity.setEntityType(EntityType.TENANT);
    auditLogEntity.setId(ModelConstants.NULL_UUID);
    auditLogEntity.setUserName("janedoe");
    auditLogEntity.setUuid(ModelConstants.NULL_UUID);
    auditLogEntity.setTenantId(ModelConstants.NULL_UUID);
    auditLogEntity.setCustomerId(null);
    auditLogEntity.setEntityId(null);
    auditLogEntity.setUserId(null);

    // Act and Assert
    TenantId tenantId = auditLogEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
