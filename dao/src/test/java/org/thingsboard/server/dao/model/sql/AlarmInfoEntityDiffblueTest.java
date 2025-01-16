package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.AlarmAssignee;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.alarm.AlarmStatus;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class AlarmInfoEntityDiffblueTest {
  /**
   * Test {@link AlarmInfoEntity#equals(Object)}, and
   * {@link AlarmInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmInfoEntity#equals(Object)}
   *   <li>{@link AlarmInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel("Originator Label");
    alarmInfoEntity2.setOriginatorName("Originator Name");
    alarmInfoEntity2.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity2.setPropagate(true);
    alarmInfoEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity2.setPropagateToOwner(true);
    alarmInfoEntity2.setPropagateToTenant(true);
    alarmInfoEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity2.setStartTs(1L);
    alarmInfoEntity2.setStatus("Status");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(alarmInfoEntity, alarmInfoEntity2);
    int expectedHashCodeResult = alarmInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmInfoEntity2.hashCode());
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}, and
   * {@link AlarmInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmInfoEntity#equals(Object)}
   *   <li>{@link AlarmInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(alarmInfoEntity, alarmInfoEntity);
    int expectedHashCodeResult = alarmInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmInfoEntity.hashCode());
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(3L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel("Originator Label");
    alarmInfoEntity2.setOriginatorName("Originator Name");
    alarmInfoEntity2.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity2.setPropagate(true);
    alarmInfoEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity2.setPropagateToOwner(true);
    alarmInfoEntity2.setPropagateToTenant(true);
    alarmInfoEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity2.setStartTs(1L);
    alarmInfoEntity2.setStatus("Status");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("john.smith@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel("Originator Label");
    alarmInfoEntity2.setOriginatorName("Originator Name");
    alarmInfoEntity2.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity2.setPropagate(true);
    alarmInfoEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity2.setPropagateToOwner(true);
    alarmInfoEntity2.setPropagateToTenant(true);
    alarmInfoEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity2.setStartTs(1L);
    alarmInfoEntity2.setStatus("Status");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail(null);
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel("Originator Label");
    alarmInfoEntity2.setOriginatorName("Originator Name");
    alarmInfoEntity2.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity2.setPropagate(true);
    alarmInfoEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity2.setPropagateToOwner(true);
    alarmInfoEntity2.setPropagateToTenant(true);
    alarmInfoEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity2.setStartTs(1L);
    alarmInfoEntity2.setStatus("Status");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("John");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel("Originator Label");
    alarmInfoEntity2.setOriginatorName("Originator Name");
    alarmInfoEntity2.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity2.setPropagate(true);
    alarmInfoEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity2.setPropagateToOwner(true);
    alarmInfoEntity2.setPropagateToTenant(true);
    alarmInfoEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity2.setStartTs(1L);
    alarmInfoEntity2.setStatus("Status");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName(null);
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel("Originator Label");
    alarmInfoEntity2.setOriginatorName("Originator Name");
    alarmInfoEntity2.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity2.setPropagate(true);
    alarmInfoEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity2.setPropagateToOwner(true);
    alarmInfoEntity2.setPropagateToTenant(true);
    alarmInfoEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity2.setStartTs(1L);
    alarmInfoEntity2.setStatus("Status");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Smith");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel("Originator Label");
    alarmInfoEntity2.setOriginatorName("Originator Name");
    alarmInfoEntity2.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity2.setPropagate(true);
    alarmInfoEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity2.setPropagateToOwner(true);
    alarmInfoEntity2.setPropagateToTenant(true);
    alarmInfoEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity2.setStartTs(1L);
    alarmInfoEntity2.setStatus("Status");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName(null);
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel("Originator Label");
    alarmInfoEntity2.setOriginatorName("Originator Name");
    alarmInfoEntity2.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity2.setPropagate(true);
    alarmInfoEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity2.setPropagateToOwner(true);
    alarmInfoEntity2.setPropagateToTenant(true);
    alarmInfoEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity2.setStartTs(1L);
    alarmInfoEntity2.setStatus("Status");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(mock(JsonNode.class));
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel("Originator Label");
    alarmInfoEntity2.setOriginatorName("Originator Name");
    alarmInfoEntity2.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity2.setPropagate(true);
    alarmInfoEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity2.setPropagateToOwner(true);
    alarmInfoEntity2.setPropagateToTenant(true);
    alarmInfoEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity2.setStartTs(1L);
    alarmInfoEntity2.setStatus("Status");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Type");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel("Originator Label");
    alarmInfoEntity2.setOriginatorName("Originator Name");
    alarmInfoEntity2.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity2.setPropagate(true);
    alarmInfoEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity2.setPropagateToOwner(true);
    alarmInfoEntity2.setPropagateToTenant(true);
    alarmInfoEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity2.setStartTs(1L);
    alarmInfoEntity2.setStatus("Status");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel(null);
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel("Originator Label");
    alarmInfoEntity2.setOriginatorName("Originator Name");
    alarmInfoEntity2.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity2.setPropagate(true);
    alarmInfoEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity2.setPropagateToOwner(true);
    alarmInfoEntity2.setPropagateToTenant(true);
    alarmInfoEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity2.setStartTs(1L);
    alarmInfoEntity2.setStatus("Status");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Type");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel("Originator Label");
    alarmInfoEntity2.setOriginatorName("Originator Name");
    alarmInfoEntity2.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity2.setPropagate(true);
    alarmInfoEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity2.setPropagateToOwner(true);
    alarmInfoEntity2.setPropagateToTenant(true);
    alarmInfoEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity2.setStartTs(1L);
    alarmInfoEntity2.setStatus("Status");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName(null);
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel("Originator Label");
    alarmInfoEntity2.setOriginatorName("Originator Name");
    alarmInfoEntity2.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity2.setPropagate(true);
    alarmInfoEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity2.setPropagateToOwner(true);
    alarmInfoEntity2.setPropagateToTenant(true);
    alarmInfoEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity2.setStartTs(1L);
    alarmInfoEntity2.setStatus("Status");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Type");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel("Originator Label");
    alarmInfoEntity2.setOriginatorName("Originator Name");
    alarmInfoEntity2.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity2.setPropagate(true);
    alarmInfoEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity2.setPropagateToOwner(true);
    alarmInfoEntity2.setPropagateToTenant(true);
    alarmInfoEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity2.setStartTs(1L);
    alarmInfoEntity2.setStatus("Status");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus(null);
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setOriginatorLabel("Originator Label");
    alarmInfoEntity2.setOriginatorName("Originator Name");
    alarmInfoEntity2.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity2.setPropagate(true);
    alarmInfoEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity2.setPropagateToOwner(true);
    alarmInfoEntity2.setPropagateToTenant(true);
    alarmInfoEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity2.setStartTs(1L);
    alarmInfoEntity2.setStatus("Status");
    alarmInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmInfoEntity, null);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(alarmInfoEntity, "Different type to AlarmInfoEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AlarmInfoEntity}
   *   <li>{@link AlarmInfoEntity#setAssigneeEmail(String)}
   *   <li>{@link AlarmInfoEntity#setAssigneeFirstName(String)}
   *   <li>{@link AlarmInfoEntity#setAssigneeLastName(String)}
   *   <li>{@link AlarmInfoEntity#setOriginatorLabel(String)}
   *   <li>{@link AlarmInfoEntity#setOriginatorName(String)}
   *   <li>{@link AlarmInfoEntity#setStatus(String)}
   *   <li>{@link AlarmInfoEntity#toString()}
   *   <li>{@link AlarmInfoEntity#getAssigneeEmail()}
   *   <li>{@link AlarmInfoEntity#getAssigneeFirstName()}
   *   <li>{@link AlarmInfoEntity#getAssigneeLastName()}
   *   <li>{@link AlarmInfoEntity#getOriginatorLabel()}
   *   <li>{@link AlarmInfoEntity#getOriginatorName()}
   *   <li>{@link AlarmInfoEntity#getStatus()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    AlarmInfoEntity actualAlarmInfoEntity = new AlarmInfoEntity();
    actualAlarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    actualAlarmInfoEntity.setAssigneeFirstName("Jane");
    actualAlarmInfoEntity.setAssigneeLastName("Doe");
    actualAlarmInfoEntity.setOriginatorLabel("Originator Label");
    actualAlarmInfoEntity.setOriginatorName("Originator Name");
    actualAlarmInfoEntity.setStatus("Status");
    String actualToStringResult = actualAlarmInfoEntity.toString();
    String actualAssigneeEmail = actualAlarmInfoEntity.getAssigneeEmail();
    String actualAssigneeFirstName = actualAlarmInfoEntity.getAssigneeFirstName();
    String actualAssigneeLastName = actualAlarmInfoEntity.getAssigneeLastName();
    String actualOriginatorLabel = actualAlarmInfoEntity.getOriginatorLabel();
    String actualOriginatorName = actualAlarmInfoEntity.getOriginatorName();

    // Assert that nothing has changed
    assertEquals(
        "AlarmInfoEntity(originatorName=Originator Name, originatorLabel=Originator Label, assigneeFirstName=Jane,"
            + " assigneeLastName=Doe, assigneeEmail=jane.doe@example.org, status=Status)",
        actualToStringResult);
    assertEquals("Doe", actualAssigneeLastName);
    assertEquals("Jane", actualAssigneeFirstName);
    assertEquals("Originator Label", actualOriginatorLabel);
    assertEquals("Originator Name", actualOriginatorName);
    assertEquals("Status", actualAlarmInfoEntity.getStatus());
    assertEquals("jane.doe@example.org", actualAssigneeEmail);
    assertEquals(0L, actualAlarmInfoEntity.getCreatedTime());
    assertFalse(actualAlarmInfoEntity.isAcknowledged());
    assertFalse(actualAlarmInfoEntity.isCleared());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link AlarmInfoEntity} (default constructor) OriginatorType is
   * {@code USER}.</li>
   *   <li>Then Originator return {@link UserId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  public void testToData_givenAlarmInfoEntityOriginatorTypeIsUser_thenOriginatorReturnUserId() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.USER);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeId(null);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof UserId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EntityType.USER, originator.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link AlarmInfoEntity} (default constructor)
   * PropagateRelationTypes is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  public void testToData_givenAlarmInfoEntityPropagateRelationTypesIsEmptyString() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originator.getId().toString());
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertTrue(actualToDataResult.getPropagateRelationTypes().isEmpty());
    assertTrue(((TenantId) originator).isSysTenantId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link AlarmInfoEntity} (default constructor)
   * PropagateRelationTypes is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  public void testToData_givenAlarmInfoEntityPropagateRelationTypesIsNull() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes(null);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originator.getId().toString());
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertTrue(actualToDataResult.getPropagateRelationTypes().isEmpty());
    assertTrue(((TenantId) originator).isSysTenantId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   * <ul>
   *   <li>Then Originator return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  public void testToData_thenOriginatorReturnCustomerId() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorType(EntityType.CUSTOMER);
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes(null);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof CustomerId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.CUSTOMER, originator.getEntityType());
    assertTrue(actualToDataResult.getPropagateRelationTypes().isEmpty());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   * <ul>
   *   <li>Then Originator return {@link DashboardId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  public void testToData_thenOriginatorReturnDashboardId() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.DASHBOARD);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeId(null);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof DashboardId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.DASHBOARD, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   * <ul>
   *   <li>Then return Assignee LastName is {@code Doe}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnAssigneeLastNameIsDoe() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeId(ModelConstants.NULL_UUID);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    AlarmAssignee assignee = actualToDataResult.getAssignee();
    assertEquals("Doe", assignee.getLastName());
    assertEquals("Jane Doe", assignee.getTitle());
    assertEquals("Jane", assignee.getFirstName());
    assertEquals("jane.doe@example.org", assignee.getEmail());
    UserId assigneeId = actualToDataResult.getAssigneeId();
    assertEquals(EntityType.USER, assigneeId.getEntityType());
    assertTrue(assigneeId.isNullUid());
    assertEquals(assigneeId, assignee.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   * <ul>
   *   <li>Then return not Originator NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnNotOriginatorNullUid() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    UUID originatorId = UUID.randomUUID();
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeId(null);

    // Act and Assert
    EntityId originator = alarmInfoEntity.toData().getOriginator();
    assertTrue(originator instanceof TenantId);
    assertFalse(originator.isNullUid());
    assertFalse(((TenantId) originator).isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   * <ul>
   *   <li>Then return PropagateRelationTypes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnPropagateRelationTypesSizeIsOne() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeId(null);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originator.getId().toString());
    List<String> propagateRelationTypes = actualToDataResult.getPropagateRelationTypes();
    assertEquals(1, propagateRelationTypes.size());
    assertEquals("Propagate Relation Types", propagateRelationTypes.get(0));
    CustomerId customerId = actualToDataResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertTrue(customerId.isNullUid());
    assertTrue(((TenantId) originator).isSysTenantId());
    assertSame(originator, actualToDataResult.getTenantId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   * <ul>
   *   <li>Then return Status is {@code CLEARED_UNACK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnStatusIsClearedUnack() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(false);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(ModelConstants.NULL_UUID);
    alarmInfoEntity.setAssigneeId(null);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originator.getId().toString());
    assertEquals(AlarmStatus.CLEARED_UNACK, actualToDataResult.getStatus());
    assertFalse(actualToDataResult.isAcknowledged());
    assertTrue(((TenantId) originator).isSysTenantId());
    assertSame(originator, actualToDataResult.getTenantId());
  }
}
