package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.Alarm.AlarmBuilder;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
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
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

class AlarmEntityDiffblueTest {
  /**
   * Test {@link AlarmEntity#equals(Object)}, and {@link AlarmEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmEntity#equals(Object)}
   *   <li>{@link AlarmEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmEntity.equals(Object)", "int AlarmEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setAckTs(1L);
    alarmEntity2.setAcknowledged(true);
    alarmEntity2.setAssignTs(1L);
    alarmEntity2.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity2.setClearTs(1L);
    alarmEntity2.setCleared(true);
    alarmEntity2.setCreatedTime(1L);
    alarmEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity2.setEndTs(1L);
    alarmEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity2.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity2.setOriginatorType(EntityType.TENANT);
    alarmEntity2.setPropagate(true);
    alarmEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity2.setPropagateToOwner(true);
    alarmEntity2.setPropagateToTenant(true);
    alarmEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity2.setStartTs(1L);
    alarmEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity2.setType("Type");
    alarmEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(alarmEntity, alarmEntity2);
    assertEquals(alarmEntity.hashCode(), alarmEntity2.hashCode());
  }

  /**
   * Test {@link AlarmEntity#equals(Object)}, and {@link AlarmEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmEntity#equals(Object)}
   *   <li>{@link AlarmEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmEntity.equals(Object)", "int AlarmEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(alarmEntity, alarmEntity);
    int expectedHashCodeResult = alarmEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmEntity.hashCode());
  }

  /**
   * Test {@link AlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmEntity.equals(Object)", "int AlarmEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(3L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setAckTs(1L);
    alarmEntity2.setAcknowledged(true);
    alarmEntity2.setAssignTs(1L);
    alarmEntity2.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity2.setClearTs(1L);
    alarmEntity2.setCleared(true);
    alarmEntity2.setCreatedTime(1L);
    alarmEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity2.setEndTs(1L);
    alarmEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity2.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity2.setOriginatorType(EntityType.TENANT);
    alarmEntity2.setPropagate(true);
    alarmEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity2.setPropagateToOwner(true);
    alarmEntity2.setPropagateToTenant(true);
    alarmEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity2.setStartTs(1L);
    alarmEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity2.setType("Type");
    alarmEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmEntity, alarmEntity2);
  }

  /**
   * Test {@link AlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmEntity.equals(Object)", "int AlarmEntity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmEntity, null);
  }

  /**
   * Test {@link AlarmEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmEntity.equals(Object)", "int AlarmEntity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(alarmEntity, "Different type to AlarmEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AlarmEntity#AlarmEntity()}
   *   <li>{@link AlarmEntity#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>()", "String AlarmEntity.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmEntity actualAlarmEntity = new AlarmEntity();

    // Assert
    assertEquals("AlarmEntity()", actualAlarmEntity.toString());
    assertNull(actualAlarmEntity.getDetails());
    assertNull(actualAlarmEntity.getPropagate());
    assertNull(actualAlarmEntity.getPropagateToOwner());
    assertNull(actualAlarmEntity.getPropagateToTenant());
    assertNull(actualAlarmEntity.getAckTs());
    assertNull(actualAlarmEntity.getAssignTs());
    assertNull(actualAlarmEntity.getClearTs());
    assertNull(actualAlarmEntity.getEndTs());
    assertNull(actualAlarmEntity.getStartTs());
    assertNull(actualAlarmEntity.getPropagateRelationTypes());
    assertNull(actualAlarmEntity.getType());
    assertNull(actualAlarmEntity.getId());
    assertNull(actualAlarmEntity.getUuid());
    assertNull(actualAlarmEntity.getAssigneeId());
    assertNull(actualAlarmEntity.getCustomerId());
    assertNull(actualAlarmEntity.getOriginatorId());
    assertNull(actualAlarmEntity.getTenantId());
    assertNull(actualAlarmEntity.getOriginatorType());
    assertNull(actualAlarmEntity.getSeverity());
    assertEquals(0L, actualAlarmEntity.getCreatedTime());
    assertFalse(actualAlarmEntity.isAcknowledged());
    assertFalse(actualAlarmEntity.isCleared());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(Alarm)}.
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(Alarm)}
   */
  @Test
  @DisplayName("Test new AlarmEntity(Alarm)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  void testNewAlarmEntity() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    alarm.setOriginator(ModelConstants.SYSTEM_TENANT);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarm);

    // Assert
    Alarm toDataResult = actualAlarmEntity.toData();
    EntityId originator = toDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    UUID customerId = actualAlarmEntity.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.toString());
    CustomerId customerId2 = toDataResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertTrue(customerId2.isNullUid());
    assertSame(customerId, originator.getId());
    assertSame(customerId, customerId2.getId());
    assertSame(customerId, actualAlarmEntity.getOriginatorId());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(AlarmInfo)}.
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(AlarmInfo)}
   */
  @Test
  @DisplayName("Test new AlarmEntity(AlarmInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  void testNewAlarmEntity2() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    alarmInfo.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    alarmInfo.setOriginator(ModelConstants.SYSTEM_TENANT);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarmInfo);

    // Assert
    Alarm toDataResult = actualAlarmEntity.toData();
    EntityId originator = toDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    UUID customerId = actualAlarmEntity.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.toString());
    CustomerId customerId2 = toDataResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertTrue(customerId2.isNullUid());
    assertSame(customerId, originator.getId());
    assertSame(customerId, customerId2.getId());
    assertSame(customerId, actualAlarmEntity.getOriginatorId());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(AlarmInfo)}.
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(AlarmInfo)}
   */
  @Test
  @DisplayName("Test new AlarmEntity(AlarmInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  void testNewAlarmEntity3() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);

    AlarmInfo alarmInfo = new AlarmInfo(alarm);
    alarmInfo.setId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    alarmInfo.setTenantId(ModelConstants.SYSTEM_TENANT);
    alarmInfo.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UserId assigneeId = new UserId(id);
    alarmInfo.setAssigneeId(assigneeId);
    alarmInfo.setPropagateRelationTypes(new ArrayList<>());

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarmInfo);

    // Assert
    UUID assigneeId2 = actualAlarmEntity.getAssigneeId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", assigneeId2.toString());
    assertEquals(assigneeId, actualAlarmEntity.toData().getAssigneeId());
    assertSame(id, assigneeId2);
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(Alarm)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return toData PropagateRelationTypes size is one.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(Alarm)}
   */
  @Test
  @DisplayName(
      "Test new AlarmEntity(Alarm); given 'foo'; then return toData PropagateRelationTypes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  void testNewAlarmEntity_givenFoo_thenReturnToDataPropagateRelationTypesSizeIsOne() {
    // Arrange
    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    propagateRelationTypes.add("foo");

    AlarmBuilder assignTsResult = Alarm.builder().ackTs(1L).acknowledged(true).assignTs(1L);
    Alarm alarm =
        assignTsResult
            .assigneeId(new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .clearTs(1L)
            .cleared(true)
            .customerId(BaseEntityService.NULL_CUSTOMER_ID)
            .details(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .endTs(1L)
            .originator(BaseEntityService.NULL_CUSTOMER_ID)
            .propagate(true)
            .propagateRelationTypes(propagateRelationTypes)
            .propagateToOwner(true)
            .propagateToTenant(true)
            .severity(AlarmSeverity.CRITICAL)
            .startTs(1L)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .type("Type")
            .build();

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarm);

    // Assert
    List<String> propagateRelationTypes2 = actualAlarmEntity.toData().getPropagateRelationTypes();
    assertEquals(1, propagateRelationTypes2.size());
    assertEquals("foo", propagateRelationTypes2.get(0));
    assertEquals("foo", actualAlarmEntity.getPropagateRelationTypes());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(Alarm)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return toData CreatedTime is three.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(Alarm)}
   */
  @Test
  @DisplayName("Test new AlarmEntity(Alarm); given three; then return toData CreatedTime is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  void testNewAlarmEntity_givenThree_thenReturnToDataCreatedTimeIsThree() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setCreatedTime(3L);
    alarm.setOriginator(ModelConstants.SYSTEM_TENANT);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarm);

    // Assert
    Alarm toDataResult = actualAlarmEntity.toData();
    EntityId originator = toDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertNull(actualAlarmEntity.getTenantId());
    assertNull(toDataResult.getTenantId());
    assertEquals(3L, toDataResult.getCreatedTime());
    assertEquals(3L, actualAlarmEntity.getCreatedTime());
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertEquals(EntityType.TENANT, actualAlarmEntity.getOriginatorType());
    assertTrue(((TenantId) originator).isSysTenantId());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(AlarmInfo)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return toData CreatedTime is three.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(AlarmInfo)}
   */
  @Test
  @DisplayName(
      "Test new AlarmEntity(AlarmInfo); given three; then return toData CreatedTime is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  void testNewAlarmEntity_givenThree_thenReturnToDataCreatedTimeIsThree2() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    alarmInfo.setCreatedTime(3L);
    alarmInfo.setOriginator(ModelConstants.SYSTEM_TENANT);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarmInfo);

    // Assert
    Alarm toDataResult = actualAlarmEntity.toData();
    EntityId originator = toDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertNull(actualAlarmEntity.getTenantId());
    assertNull(toDataResult.getTenantId());
    assertEquals(3L, toDataResult.getCreatedTime());
    assertEquals(3L, actualAlarmEntity.getCreatedTime());
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertEquals(EntityType.TENANT, actualAlarmEntity.getOriginatorType());
    assertTrue(((TenantId) originator).isSysTenantId());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(Alarm)}.
   *
   * <ul>
   *   <li>Then Details return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(Alarm)}
   */
  @Test
  @DisplayName("Test new AlarmEntity(Alarm); then Details return ObjectNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  void testNewAlarmEntity_thenDetailsReturnObjectNode() {
    // Arrange
    AlarmBuilder assignTsResult = Alarm.builder().ackTs(1L).acknowledged(true).assignTs(1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    AlarmBuilder propagateResult =
        assignTsResult
            .assigneeId(new UserId(id))
            .clearTs(1L)
            .cleared(true)
            .customerId(BaseEntityService.NULL_CUSTOMER_ID)
            .details(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .endTs(1L)
            .originator(BaseEntityService.NULL_CUSTOMER_ID)
            .propagate(true);
    Alarm alarm =
        propagateResult
            .propagateRelationTypes(new ArrayList<>())
            .propagateToOwner(true)
            .propagateToTenant(true)
            .severity(AlarmSeverity.CRITICAL)
            .startTs(1L)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .type("Type")
            .build();

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarm);

    // Assert
    assertTrue(actualAlarmEntity.getDetails() instanceof ObjectNode);
    assertEquals("Type", actualAlarmEntity.getType());
    assertEquals(1L, actualAlarmEntity.getAckTs().longValue());
    assertEquals(1L, actualAlarmEntity.getAssignTs().longValue());
    assertEquals(1L, actualAlarmEntity.getClearTs().longValue());
    assertEquals(1L, actualAlarmEntity.getEndTs().longValue());
    assertEquals(1L, actualAlarmEntity.getStartTs().longValue());
    assertEquals(AlarmSeverity.CRITICAL, actualAlarmEntity.getSeverity());
    assertTrue(actualAlarmEntity.getPropagate());
    assertTrue(actualAlarmEntity.getPropagateToOwner());
    assertTrue(actualAlarmEntity.getPropagateToTenant());
    assertTrue(actualAlarmEntity.isAcknowledged());
    assertTrue(actualAlarmEntity.isCleared());
    assertSame(id, actualAlarmEntity.getAssigneeId());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(AlarmInfo)}.
   *
   * <ul>
   *   <li>Then return Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(AlarmInfo)}
   */
  @Test
  @DisplayName(
      "Test new AlarmEntity(AlarmInfo); then return Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  void testNewAlarmEntity_thenReturnIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);

    AlarmInfo alarmInfo = new AlarmInfo(alarm);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    AlarmId alarmId = new AlarmId(id);
    alarmInfo.setId(alarmId);
    alarmInfo.setTenantId(ModelConstants.SYSTEM_TENANT);
    alarmInfo.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    alarmInfo.setAssigneeId(null);
    alarmInfo.setPropagateRelationTypes(new ArrayList<>());

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarmInfo);

    // Assert
    Alarm toDataResult = actualAlarmEntity.toData();
    EntityId originator = toDataResult.getOriginator();
    assertTrue(originator instanceof CustomerId);
    UUID id2 = actualAlarmEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    TenantId tenantId = toDataResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertEquals(alarmId, toDataResult.getId());
    assertEquals(toDataResult.getCustomerId(), originator);
    assertSame(id, toDataResult.getUuidId());
    assertSame(id, id2);
    assertSame(id, actualAlarmEntity.getUuid());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(AlarmInfo)}.
   *
   * <ul>
   *   <li>Then return TenantId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(AlarmInfo)}
   */
  @Test
  @DisplayName("Test new AlarmEntity(AlarmInfo); then return TenantId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  void testNewAlarmEntity_thenReturnTenantIdIsNull() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    alarmInfo.setOriginator(ModelConstants.SYSTEM_TENANT);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarmInfo);

    // Assert
    Alarm toDataResult = actualAlarmEntity.toData();
    EntityId originator = toDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertNull(actualAlarmEntity.getTenantId());
    assertNull(toDataResult.getTenantId());
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertEquals(EntityType.TENANT, actualAlarmEntity.getOriginatorType());
    assertTrue(((TenantId) originator).isSysTenantId());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(AlarmInfo)}.
   *
   * <ul>
   *   <li>Then return toData Originator EntityType is {@code CUSTOMER}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(AlarmInfo)}
   */
  @Test
  @DisplayName(
      "Test new AlarmEntity(AlarmInfo); then return toData Originator EntityType is 'CUSTOMER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  void testNewAlarmEntity_thenReturnToDataOriginatorEntityTypeIsCustomer() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    alarmInfo.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarmInfo);

    // Assert
    Alarm toDataResult = actualAlarmEntity.toData();
    EntityId originator = toDataResult.getOriginator();
    assertTrue(originator instanceof CustomerId);
    assertNull(actualAlarmEntity.getTenantId());
    assertNull(toDataResult.getTenantId());
    assertEquals(EntityType.CUSTOMER, originator.getEntityType());
    assertEquals(EntityType.CUSTOMER, actualAlarmEntity.getOriginatorType());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(AlarmInfo)}.
   *
   * <ul>
   *   <li>Then return toData PropagateRelationTypes size is one.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(AlarmInfo)}
   */
  @Test
  @DisplayName(
      "Test new AlarmEntity(AlarmInfo); then return toData PropagateRelationTypes size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  void testNewAlarmEntity_thenReturnToDataPropagateRelationTypesSizeIsOne() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);

    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    propagateRelationTypes.add("foo");

    AlarmInfo alarmInfo = new AlarmInfo(alarm);
    alarmInfo.setId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    alarmInfo.setTenantId(ModelConstants.SYSTEM_TENANT);
    alarmInfo.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    alarmInfo.setAssigneeId(null);
    alarmInfo.setPropagateRelationTypes(propagateRelationTypes);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarmInfo);

    // Assert
    List<String> propagateRelationTypes2 = actualAlarmEntity.toData().getPropagateRelationTypes();
    assertEquals(1, propagateRelationTypes2.size());
    assertEquals("foo", propagateRelationTypes2.get(0));
    assertEquals("foo", actualAlarmEntity.getPropagateRelationTypes());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(Alarm)}.
   *
   * <ul>
   *   <li>Then return toData TenantId is toData Originator.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(Alarm)}
   */
  @Test
  @DisplayName("Test new AlarmEntity(Alarm); then return toData TenantId is toData Originator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  void testNewAlarmEntity_thenReturnToDataTenantIdIsToDataOriginator() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setTenantId(ModelConstants.SYSTEM_TENANT);
    alarm.setOriginator(ModelConstants.SYSTEM_TENANT);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarm);

    // Assert
    Alarm toDataResult = actualAlarmEntity.toData();
    EntityId originator = toDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertEquals(EntityType.TENANT, actualAlarmEntity.getOriginatorType());
    assertTrue(((TenantId) originator).isSysTenantId());
    assertSame(originator, toDataResult.getTenantId());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(AlarmInfo)}.
   *
   * <ul>
   *   <li>Then return toData TenantId is toData Originator.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(AlarmInfo)}
   */
  @Test
  @DisplayName("Test new AlarmEntity(AlarmInfo); then return toData TenantId is toData Originator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  void testNewAlarmEntity_thenReturnToDataTenantIdIsToDataOriginator2() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    alarmInfo.setTenantId(ModelConstants.SYSTEM_TENANT);
    alarmInfo.setOriginator(ModelConstants.SYSTEM_TENANT);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarmInfo);

    // Assert
    Alarm toDataResult = actualAlarmEntity.toData();
    EntityId originator = toDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertEquals(EntityType.TENANT, actualAlarmEntity.getOriginatorType());
    assertTrue(((TenantId) originator).isSysTenantId());
    assertSame(originator, toDataResult.getTenantId());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(Alarm)}.
   *
   * <ul>
   *   <li>Then toData Originator return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(Alarm)}
   */
  @Test
  @DisplayName("Test new AlarmEntity(Alarm); then toData Originator return CustomerId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  void testNewAlarmEntity_thenToDataOriginatorReturnCustomerId() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarm);

    // Assert
    Alarm toDataResult = actualAlarmEntity.toData();
    EntityId originator = toDataResult.getOriginator();
    assertTrue(originator instanceof CustomerId);
    assertNull(actualAlarmEntity.getTenantId());
    assertNull(toDataResult.getTenantId());
    assertEquals(EntityType.CUSTOMER, originator.getEntityType());
    assertEquals(EntityType.CUSTOMER, actualAlarmEntity.getOriginatorType());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(Alarm)}.
   *
   * <ul>
   *   <li>When {@link Alarm#Alarm()} Originator is {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return TenantId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(Alarm)}
   */
  @Test
  @DisplayName(
      "Test new AlarmEntity(Alarm); when Alarm() Originator is SYSTEM_TENANT; then return TenantId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  void testNewAlarmEntity_whenAlarmOriginatorIsSystem_tenant_thenReturnTenantIdIsNull() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setOriginator(ModelConstants.SYSTEM_TENANT);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarm);

    // Assert
    Alarm toDataResult = actualAlarmEntity.toData();
    EntityId originator = toDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertNull(actualAlarmEntity.getTenantId());
    assertNull(toDataResult.getTenantId());
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertEquals(EntityType.TENANT, actualAlarmEntity.getOriginatorType());
    assertTrue(((TenantId) originator).isSysTenantId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} AssigneeId is {@code null}.
   *   <li>Then return AssigneeId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AlarmEntity() AssigneeId is 'null'; then return AssigneeId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_givenAlarmEntityAssigneeIdIsNull_thenReturnAssigneeIdIsNull() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(null);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.TENANT);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertNull(actualToDataResult.getAssigneeId());
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertFalse(((TenantId) originator).isSysTenantId());
    assertSame(originator, actualToDataResult.getTenantId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} CustomerId is {@code null}.
   *   <li>Then return CustomerId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AlarmEntity() CustomerId is 'null'; then return CustomerId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_givenAlarmEntityCustomerIdIsNull_thenReturnCustomerIdIsNull() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(null);
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.TENANT);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertNull(actualToDataResult.getCustomerId());
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertFalse(((TenantId) originator).isSysTenantId());
    assertSame(originator, actualToDataResult.getTenantId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} OriginatorType is {@code ALARM}.
   *   <li>Then Originator return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AlarmEntity() OriginatorType is 'ALARM'; then Originator return AlarmId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_givenAlarmEntityOriginatorTypeIsAlarm_thenOriginatorReturnAlarmId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.ALARM);

    // Act and Assert
    assertTrue(alarmEntity.toData().getOriginator() instanceof AlarmId);
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} OriginatorType is {@code ASSET}.
   *   <li>Then Originator return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AlarmEntity() OriginatorType is 'ASSET'; then Originator return AssetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_givenAlarmEntityOriginatorTypeIsAsset_thenOriginatorReturnAssetId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.ASSET);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof AssetId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.ASSET, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} OriginatorType is {@code DEVICE}.
   *   <li>Then Originator return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AlarmEntity() OriginatorType is 'DEVICE'; then Originator return DeviceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_givenAlarmEntityOriginatorTypeIsDevice_thenOriginatorReturnDeviceId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.DEVICE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof DeviceId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.DEVICE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} OriginatorType is {@code DOMAIN}.
   *   <li>Then Originator return {@link DomainId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AlarmEntity() OriginatorType is 'DOMAIN'; then Originator return DomainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_givenAlarmEntityOriginatorTypeIsDomain_thenOriginatorReturnDomainId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.DOMAIN);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof DomainId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.DOMAIN, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} OriginatorType is {@code EDGE}.
   *   <li>Then Originator return {@link EdgeId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AlarmEntity() OriginatorType is 'EDGE'; then Originator return EdgeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_givenAlarmEntityOriginatorTypeIsEdge_thenOriginatorReturnEdgeId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.EDGE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof EdgeId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.EDGE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} OriginatorType is {@code QUEUE}.
   *   <li>Then Originator return {@link QueueId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AlarmEntity() OriginatorType is 'QUEUE'; then Originator return QueueId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_givenAlarmEntityOriginatorTypeIsQueue_thenOriginatorReturnQueueId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.QUEUE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof QueueId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.QUEUE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} OriginatorType is {@code RPC}.
   *   <li>Then Originator return {@link RpcId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AlarmEntity() OriginatorType is 'RPC'; then Originator return RpcId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_givenAlarmEntityOriginatorTypeIsRpc_thenOriginatorReturnRpcId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.RPC);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof RpcId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.RPC, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} OriginatorType is {@code TENANT}.
   *   <li>Then return TenantId is Originator.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AlarmEntity() OriginatorType is 'TENANT'; then return TenantId is Originator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_givenAlarmEntityOriginatorTypeIsTenant_thenReturnTenantIdIsOriginator() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.TENANT);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertFalse(((TenantId) originator).isSysTenantId());
    assertSame(originator, actualToDataResult.getTenantId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} OriginatorType is {@code USER}.
   *   <li>Then Originator return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AlarmEntity() OriginatorType is 'USER'; then Originator return UserId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_givenAlarmEntityOriginatorTypeIsUser_thenOriginatorReturnUserId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.USER);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getOriginator() instanceof UserId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} PropagateRelationTypes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given AlarmEntity() PropagateRelationTypes is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_givenAlarmEntityPropagateRelationTypesIsNull() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes(null);
    alarmEntity.setOriginatorType(EntityType.TENANT);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertFalse(((TenantId) originator).isSysTenantId());
    assertSame(originator, actualToDataResult.getTenantId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} TenantId is {@code null}.
   *   <li>Then return TenantId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AlarmEntity() TenantId is 'null'; then return TenantId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_givenAlarmEntityTenantIdIsNull_thenReturnTenantIdIsNull() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(null);
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.TENANT);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertFalse(((TenantId) originator).isSysTenantId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link ApiUsageStateId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return ApiUsageStateId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnApiUsageStateId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.API_USAGE_STATE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof ApiUsageStateId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.API_USAGE_STATE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link AssetProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return AssetProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnAssetProfileId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.ASSET_PROFILE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof AssetProfileId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.ASSET_PROFILE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return CustomerId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnCustomerId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.CUSTOMER);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getOriginator() instanceof CustomerId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return DashboardId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnDashboardId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.DASHBOARD);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof DashboardId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.DASHBOARD, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link DeviceProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return DeviceProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnDeviceProfileId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.DEVICE_PROFILE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof DeviceProfileId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.DEVICE_PROFILE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link EntityViewId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return EntityViewId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnEntityViewId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.ENTITY_VIEW);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof EntityViewId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.ENTITY_VIEW, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link MobileAppId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return MobileAppId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnMobileAppId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.MOBILE_APP);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof MobileAppId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.MOBILE_APP, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link NotificationId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return NotificationId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnNotificationId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.NOTIFICATION);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof NotificationId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.NOTIFICATION, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link NotificationRequestId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return NotificationRequestId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnNotificationRequestId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.NOTIFICATION_REQUEST);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof NotificationRequestId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_REQUEST, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link NotificationRuleId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return NotificationRuleId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnNotificationRuleId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.NOTIFICATION_RULE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof NotificationRuleId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_RULE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link NotificationTargetId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return NotificationTargetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnNotificationTargetId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.NOTIFICATION_TARGET);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof NotificationTargetId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TARGET, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link NotificationTemplateId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return NotificationTemplateId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnNotificationTemplateId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.NOTIFICATION_TEMPLATE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof NotificationTemplateId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link OAuth2ClientId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return OAuth2ClientId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnOAuth2ClientId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.OAUTH2_CLIENT);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof OAuth2ClientId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.OAUTH2_CLIENT, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link OtaPackageId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return OtaPackageId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnOtaPackageId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.OTA_PACKAGE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof OtaPackageId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.OTA_PACKAGE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link QueueStatsId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return QueueStatsId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnQueueStatsId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.QUEUE_STATS);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof QueueStatsId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.QUEUE_STATS, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return RuleChainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnRuleChainId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.RULE_CHAIN);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof RuleChainId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link RuleNodeId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return RuleNodeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnRuleNodeId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.RULE_NODE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof RuleNodeId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.RULE_NODE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link TbResourceId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return TbResourceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnTbResourceId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.TB_RESOURCE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TbResourceId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TB_RESOURCE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link TenantProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return TenantProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnTenantProfileId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.TENANT_PROFILE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantProfileId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EntityType.TENANT_PROFILE, originator.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link WidgetTypeId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return WidgetTypeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnWidgetTypeId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.WIDGET_TYPE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof WidgetTypeId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EntityType.WIDGET_TYPE, originator.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link WidgetsBundleId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Originator return WidgetsBundleId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenOriginatorReturnWidgetsBundleId() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.WIDGETS_BUNDLE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof WidgetsBundleId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EntityType.WIDGETS_BUNDLE, originator.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then return Originator Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return Originator Id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenReturnOriginatorIdIsRandomUUID() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID originatorId = UUID.randomUUID();
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.TENANT);

    // Act and Assert
    EntityId originator = alarmEntity.toData().getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertFalse(((TenantId) originator).isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then return PropagateRelationTypes size is two.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return PropagateRelationTypes size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  void testToData_thenReturnPropagateRelationTypesSizeIsTwo() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setOriginatorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setAssigneeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    alarmEntity.setPropagateRelationTypes("foo,bar");
    alarmEntity.setOriginatorType(EntityType.TENANT);

    // Act and Assert
    List<String> propagateRelationTypes = alarmEntity.toData().getPropagateRelationTypes();
    assertEquals(2, propagateRelationTypes.size());
    assertEquals("bar", propagateRelationTypes.get(1));
    assertEquals("foo", propagateRelationTypes.get(0));
  }
}
