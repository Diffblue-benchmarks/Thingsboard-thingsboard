package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.AlarmAssignee;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.alarm.AlarmStatus;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.NotificationId;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.QueueStatsId;
import org.thingsboard.server.common.data.id.RpcId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class AlarmInfoEntityDiffblueTest {
  /**
   * Test {@link AlarmInfoEntity#equals(Object)}, and {@link AlarmInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmInfoEntity#equals(Object)}
   *   <li>{@link AlarmInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmInfoEntity.equals(Object)", "int AlarmInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(alarmInfoEntity, alarmInfoEntity2);
    int expectedHashCodeResult = alarmInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmInfoEntity2.hashCode());
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}, and {@link AlarmInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmInfoEntity#equals(Object)}
   *   <li>{@link AlarmInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmInfoEntity.equals(Object)", "int AlarmInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(alarmInfoEntity, alarmInfoEntity);
    int expectedHashCodeResult = alarmInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmInfoEntity.hashCode());
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmInfoEntity.equals(Object)", "int AlarmInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(3L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmInfoEntity.equals(Object)", "int AlarmInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("john.smith@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmInfoEntity.equals(Object)", "int AlarmInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail(null);
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmInfoEntity.equals(Object)", "int AlarmInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("John");
    alarmInfoEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmInfoEntity.equals(Object)", "int AlarmInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName(null);
    alarmInfoEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmInfoEntity.equals(Object)", "int AlarmInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeLastName("Smith");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmInfoEntity.equals(Object)", "int AlarmInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeLastName(null);
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmInfoEntity.equals(Object)", "int AlarmInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmInfoEntity.equals(Object)", "int AlarmInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmInfoEntity.equals(Object)", "int AlarmInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmInfoEntity.equals(Object)", "int AlarmInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmInfoEntity.equals(Object)", "int AlarmInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmInfoEntity.equals(Object)", "int AlarmInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmInfoEntity alarmInfoEntity2 = new AlarmInfoEntity();
    alarmInfoEntity2.setAckTs(1L);
    alarmInfoEntity2.setAcknowledged(true);
    alarmInfoEntity2.setAssignTs(1L);
    alarmInfoEntity2.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity2.setAssigneeFirstName("Jane");
    alarmInfoEntity2.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setAssigneeLastName("Doe");
    alarmInfoEntity2.setClearTs(1L);
    alarmInfoEntity2.setCleared(true);
    alarmInfoEntity2.setCreatedTime(1L);
    alarmInfoEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity2.setEndTs(1L);
    alarmInfoEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity2.setType("Type");
    alarmInfoEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmInfoEntity, alarmInfoEntity2);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmInfoEntity.equals(Object)", "int AlarmInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmInfoEntity, null);
  }

  /**
   * Test {@link AlarmInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AlarmInfoEntity.equals(Object)", "int AlarmInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmInfoEntity alarmInfoEntity = new AlarmInfoEntity();
    alarmInfoEntity.setAckTs(1L);
    alarmInfoEntity.setAcknowledged(true);
    alarmInfoEntity.setAssignTs(1L);
    alarmInfoEntity.setAssigneeEmail("jane.doe@example.org");
    alarmInfoEntity.setAssigneeFirstName("Jane");
    alarmInfoEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeLastName("Doe");
    alarmInfoEntity.setClearTs(1L);
    alarmInfoEntity.setCleared(true);
    alarmInfoEntity.setCreatedTime(1L);
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmInfoEntity, "Different type to AlarmInfoEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void AlarmInfoEntity.<init>()",
    "String AlarmInfoEntity.getAssigneeEmail()",
    "String AlarmInfoEntity.getAssigneeFirstName()",
    "String AlarmInfoEntity.getAssigneeLastName()",
    "String AlarmInfoEntity.getOriginatorLabel()",
    "String AlarmInfoEntity.getOriginatorName()",
    "String AlarmInfoEntity.getStatus()",
    "void AlarmInfoEntity.setAssigneeEmail(String)",
    "void AlarmInfoEntity.setAssigneeFirstName(String)",
    "void AlarmInfoEntity.setAssigneeLastName(String)",
    "void AlarmInfoEntity.setOriginatorLabel(String)",
    "void AlarmInfoEntity.setOriginatorName(String)",
    "void AlarmInfoEntity.setStatus(String)",
    "String AlarmInfoEntity.toString()"
  })
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

    // Assert
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
    assertNull(actualAlarmInfoEntity.getDetails());
    assertNull(actualAlarmInfoEntity.getPropagate());
    assertNull(actualAlarmInfoEntity.getPropagateToOwner());
    assertNull(actualAlarmInfoEntity.getPropagateToTenant());
    assertNull(actualAlarmInfoEntity.getAckTs());
    assertNull(actualAlarmInfoEntity.getAssignTs());
    assertNull(actualAlarmInfoEntity.getClearTs());
    assertNull(actualAlarmInfoEntity.getEndTs());
    assertNull(actualAlarmInfoEntity.getStartTs());
    assertNull(actualAlarmInfoEntity.getPropagateRelationTypes());
    assertNull(actualAlarmInfoEntity.getType());
    assertNull(actualAlarmInfoEntity.getId());
    assertNull(actualAlarmInfoEntity.getUuid());
    assertNull(actualAlarmInfoEntity.getAssigneeId());
    assertNull(actualAlarmInfoEntity.getCustomerId());
    assertNull(actualAlarmInfoEntity.getOriginatorId());
    assertNull(actualAlarmInfoEntity.getTenantId());
    assertNull(actualAlarmInfoEntity.getOriginatorType());
    assertNull(actualAlarmInfoEntity.getSeverity());
    assertEquals(0L, actualAlarmInfoEntity.getCreatedTime());
    assertFalse(actualAlarmInfoEntity.isAcknowledged());
    assertFalse(actualAlarmInfoEntity.isCleared());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfoEntity} (default constructor) OriginatorType is {@code ALARM}.
   *   <li>Then Originator return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_givenAlarmInfoEntityOriginatorTypeIsAlarm_thenOriginatorReturnAlarmId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.ALARM);

    // Act and Assert
    assertTrue(alarmInfoEntity.toData().getOriginator() instanceof AlarmId);
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfoEntity} (default constructor) OriginatorType is {@code ASSET}.
   *   <li>Then Originator return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_givenAlarmInfoEntityOriginatorTypeIsAsset_thenOriginatorReturnAssetId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.ASSET);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof AssetId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.ASSET, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfoEntity} (default constructor) OriginatorType is {@code EDGE}.
   *   <li>Then Originator return {@link EdgeId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_givenAlarmInfoEntityOriginatorTypeIsEdge_thenOriginatorReturnEdgeId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.EDGE);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof EdgeId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.EDGE, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfoEntity} (default constructor) OriginatorType is {@code QUEUE}.
   *   <li>Then Originator return {@link QueueId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_givenAlarmInfoEntityOriginatorTypeIsQueue_thenOriginatorReturnQueueId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.QUEUE);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof QueueId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.QUEUE, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfoEntity} (default constructor) OriginatorType is {@code RPC}.
   *   <li>Then Originator return {@link RpcId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_givenAlarmInfoEntityOriginatorTypeIsRpc_thenOriginatorReturnRpcId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.RPC);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof RpcId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.RPC, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfoEntity} (default constructor) OriginatorType is {@code USER}.
   *   <li>Then Originator return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
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
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.USER);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof UserId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.USER, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmInfoEntity} (default constructor) PropagateRelationTypes is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
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
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setCustomerId(customerId);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateRelationTypes(null);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeId(null);

    // Act and Assert
    CustomerId customerId2 = alarmInfoEntity.toData().getCustomerId();
    UUID id = customerId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertSame(customerId, id);
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link ApiUsageStateId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnApiUsageStateId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.API_USAGE_STATE);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof ApiUsageStateId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.API_USAGE_STATE, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link AssetProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnAssetProfileId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.ASSET_PROFILE);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof AssetProfileId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.ASSET_PROFILE, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.CUSTOMER);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof CustomerId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.CUSTOMER, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
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
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.DASHBOARD);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof DashboardId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.DASHBOARD, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnDeviceId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.DEVICE);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof DeviceId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.DEVICE, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link DeviceProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnDeviceProfileId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.DEVICE_PROFILE);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof DeviceProfileId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.DEVICE_PROFILE, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link DomainId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnDomainId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.DOMAIN);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof DomainId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.DOMAIN, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link EntityViewId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnEntityViewId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.ENTITY_VIEW);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof EntityViewId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.ENTITY_VIEW, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link MobileAppId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnMobileAppId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.MOBILE_APP);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof MobileAppId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.MOBILE_APP, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link NotificationId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnNotificationId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.NOTIFICATION);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof NotificationId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.NOTIFICATION, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link NotificationRequestId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnNotificationRequestId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.NOTIFICATION_REQUEST);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof NotificationRequestId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.NOTIFICATION_REQUEST, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link NotificationRuleId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnNotificationRuleId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.NOTIFICATION_RULE);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof NotificationRuleId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.NOTIFICATION_RULE, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link NotificationTargetId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnNotificationTargetId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.NOTIFICATION_TARGET);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof NotificationTargetId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.NOTIFICATION_TARGET, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link NotificationTemplateId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnNotificationTemplateId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.NOTIFICATION_TEMPLATE);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof NotificationTemplateId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link OAuth2ClientId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnOAuth2ClientId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.OAUTH2_CLIENT);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof OAuth2ClientId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.OAUTH2_CLIENT, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link OtaPackageId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnOtaPackageId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.OTA_PACKAGE);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof OtaPackageId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.OTA_PACKAGE, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link QueueStatsId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnQueueStatsId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.QUEUE_STATS);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof QueueStatsId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.QUEUE_STATS, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnRuleChainId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.RULE_CHAIN);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof RuleChainId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.RULE_CHAIN, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link RuleNodeId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnRuleNodeId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.RULE_NODE);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof RuleNodeId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.RULE_NODE, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link TbResourceId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnTbResourceId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.TB_RESOURCE);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TbResourceId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.TB_RESOURCE, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnTenantId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertFalse(((TenantId) originator).isSysTenantId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link TenantProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnTenantProfileId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.TENANT_PROFILE);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantProfileId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.TENANT_PROFILE, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link WidgetTypeId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnWidgetTypeId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.WIDGET_TYPE);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof WidgetTypeId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.WIDGET_TYPE, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link WidgetsBundleId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenOriginatorReturnWidgetsBundleId() {
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
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setOriginatorId(originatorId);
    alarmInfoEntity.setOriginatorLabel("Originator Label");
    alarmInfoEntity.setOriginatorName("Originator Name");
    alarmInfoEntity.setPropagate(true);
    alarmInfoEntity.setPropagateToOwner(true);
    alarmInfoEntity.setPropagateToTenant(true);
    alarmInfoEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmInfoEntity.setStartTs(1L);
    alarmInfoEntity.setStatus("Status");
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setTenantId(null);
    alarmInfoEntity.setCustomerId(null);
    alarmInfoEntity.setAssigneeId(null);
    alarmInfoEntity.setPropagateRelationTypes("");
    alarmInfoEntity.setOriginatorType(EntityType.WIDGETS_BUNDLE);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof WidgetsBundleId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.WIDGETS_BUNDLE, originator.getEntityType());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return AssigneeId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenReturnAssigneeIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
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
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID assigneeId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setAssigneeId(assigneeId);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    UserId assigneeId2 = actualToDataResult.getAssigneeId();
    UUID id = assigneeId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    AlarmAssignee assignee = actualToDataResult.getAssignee();
    assertEquals("Doe", assignee.getLastName());
    assertEquals("Jane Doe", assignee.getTitle());
    assertEquals("Jane", assignee.getFirstName());
    assertEquals("jane.doe@example.org", assignee.getEmail());
    assertEquals(EntityType.USER, assigneeId2.getEntityType());
    assertFalse(assigneeId2.isNullUid());
    assertEquals(assigneeId2, assignee.getId());
    assertSame(assigneeId, id);
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return CustomerId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
  public void testToData_thenReturnCustomerIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
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
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmInfoEntity.setCustomerId(customerId);
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeId(null);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    CustomerId customerId2 = actualToDataResult.getCustomerId();
    UUID id = customerId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    List<String> propagateRelationTypes = actualToDataResult.getPropagateRelationTypes();
    assertEquals(1, propagateRelationTypes.size());
    assertEquals("Propagate Relation Types", propagateRelationTypes.get(0));
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertSame(customerId, id);
  }

  /**
   * Test {@link AlarmInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return Status is {@code CLEARED_UNACK}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmInfoEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AlarmInfo AlarmInfoEntity.toData()"})
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
    alarmInfoEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmInfoEntity.setEndTs(1L);
    alarmInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    alarmInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setType("Type");
    alarmInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmInfoEntity.setAssigneeId(null);

    // Act
    AlarmInfo actualToDataResult = alarmInfoEntity.toData();

    // Assert
    List<String> propagateRelationTypes = actualToDataResult.getPropagateRelationTypes();
    assertEquals(1, propagateRelationTypes.size());
    assertEquals("Propagate Relation Types", propagateRelationTypes.get(0));
    assertEquals(AlarmStatus.CLEARED_UNACK, actualToDataResult.getStatus());
    assertFalse(actualToDataResult.isAcknowledged());
  }
}
