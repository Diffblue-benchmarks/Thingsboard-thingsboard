/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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

public class AlarmEntityDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmEntity.equals(Object)", "int AlarmEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setAckTs(1L);
    alarmEntity2.setAcknowledged(true);
    alarmEntity2.setAssignTs(1L);
    alarmEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity2.setClearTs(1L);
    alarmEntity2.setCleared(true);
    alarmEntity2.setCreatedTime(1L);
    alarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity2.setEndTs(1L);
    alarmEntity2.setId(ModelConstants.NULL_UUID);
    alarmEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity2.setOriginatorType(EntityType.TENANT);
    alarmEntity2.setPropagate(true);
    alarmEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity2.setPropagateToOwner(true);
    alarmEntity2.setPropagateToTenant(true);
    alarmEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity2.setStartTs(1L);
    alarmEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity2.setType("Type");
    alarmEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmEntity.equals(Object)", "int AlarmEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmEntity.equals(Object)", "int AlarmEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(3L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);

    AlarmEntity alarmEntity2 = new AlarmEntity();
    alarmEntity2.setAckTs(1L);
    alarmEntity2.setAcknowledged(true);
    alarmEntity2.setAssignTs(1L);
    alarmEntity2.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity2.setClearTs(1L);
    alarmEntity2.setCleared(true);
    alarmEntity2.setCreatedTime(1L);
    alarmEntity2.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity2.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity2.setEndTs(1L);
    alarmEntity2.setId(ModelConstants.NULL_UUID);
    alarmEntity2.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity2.setOriginatorType(EntityType.TENANT);
    alarmEntity2.setPropagate(true);
    alarmEntity2.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity2.setPropagateToOwner(true);
    alarmEntity2.setPropagateToTenant(true);
    alarmEntity2.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity2.setStartTs(1L);
    alarmEntity2.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity2.setType("Type");
    alarmEntity2.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmEntity.equals(Object)", "int AlarmEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AlarmEntity.equals(Object)", "int AlarmEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AlarmEntity alarmEntity = new AlarmEntity();
    alarmEntity.setAckTs(1L);
    alarmEntity.setAcknowledged(true);
    alarmEntity.setAssignTs(1L);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setClearTs(1L);
    alarmEntity.setCleared(true);
    alarmEntity.setCreatedTime(1L);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setDetails(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmEntity.setEndTs(1L);
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateRelationTypes("Propagate Relation Types");
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>()", "String AlarmEntity.toString()"})
  public void testGettersAndSetters() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  public void testNewAlarmEntity() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  public void testNewAlarmEntity2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  public void testNewAlarmEntity3() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);

    AlarmInfo alarmInfo = new AlarmInfo(alarm);
    alarmInfo.setId(new AlarmId(ModelConstants.NULL_UUID));
    alarmInfo.setTenantId(ModelConstants.SYSTEM_TENANT);
    alarmInfo.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    UserId assigneeId = new UserId(ModelConstants.NULL_UUID);
    alarmInfo.setAssigneeId(assigneeId);
    alarmInfo.setPropagateRelationTypes(new ArrayList<>());

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarmInfo);

    // Assert
    UUID assigneeId2 = actualAlarmEntity.getAssigneeId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", assigneeId2.toString());
    Alarm toDataResult = actualAlarmEntity.toData();
    assertEquals(assigneeId, toDataResult.getAssigneeId());
    assertSame(assigneeId2, toDataResult.getUuidId());
    assertSame(assigneeId2, toDataResult.getId().getId());
    assertSame(assigneeId2, actualAlarmEntity.getId());
    assertSame(assigneeId2, actualAlarmEntity.getUuid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  public void testNewAlarmEntity_givenFoo_thenReturnToDataPropagateRelationTypesSizeIsOne() {
    // Arrange
    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    propagateRelationTypes.add("foo");

    AlarmBuilder assignTsResult = Alarm.builder().ackTs(1L).acknowledged(true).assignTs(1L);
    Alarm alarm =
        assignTsResult
            .assigneeId(new UserId(ModelConstants.NULL_UUID))
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  public void testNewAlarmEntity_givenThree_thenReturnToDataCreatedTimeIsThree() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  public void testNewAlarmEntity_givenThree_thenReturnToDataCreatedTimeIsThree2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  public void testNewAlarmEntity_thenDetailsReturnObjectNode() {
    // Arrange
    AlarmBuilder assignTsResult = Alarm.builder().ackTs(1L).acknowledged(true).assignTs(1L);

    AlarmBuilder propagateResult =
        assignTsResult
            .assigneeId(new UserId(ModelConstants.NULL_UUID))
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
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(AlarmInfo)}.
   *
   * <ul>
   *   <li>Then return Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(AlarmInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  public void testNewAlarmEntity_thenReturnIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);

    AlarmInfo alarmInfo = new AlarmInfo(alarm);
    alarmInfo.setId(new AlarmId(ModelConstants.NULL_UUID));
    alarmInfo.setTenantId(ModelConstants.SYSTEM_TENANT);
    alarmInfo.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    alarmInfo.setAssigneeId(null);
    alarmInfo.setPropagateRelationTypes(new ArrayList<>());

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarmInfo);

    // Assert
    UUID id = actualAlarmEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    Alarm toDataResult = actualAlarmEntity.toData();
    assertSame(id, toDataResult.getUuidId());
    assertSame(id, toDataResult.getId().getId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  public void testNewAlarmEntity_thenReturnTenantIdIsNull() {
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
   *   <li>Then return toData PropagateRelationTypes size is one.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(AlarmInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  public void testNewAlarmEntity_thenReturnToDataPropagateRelationTypesSizeIsOne() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);

    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    propagateRelationTypes.add("foo");

    AlarmInfo alarmInfo = new AlarmInfo(alarm);
    alarmInfo.setId(new AlarmId(ModelConstants.NULL_UUID));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  public void testNewAlarmEntity_thenReturnToDataTenantIdIsToDataOriginator() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  public void testNewAlarmEntity_thenReturnToDataTenantIdIsToDataOriginator2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  public void testNewAlarmEntity_thenToDataOriginatorReturnCustomerId() {
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
   * Test {@link AlarmEntity#AlarmEntity(AlarmInfo)}.
   *
   * <ul>
   *   <li>Then toData Originator return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(AlarmInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  public void testNewAlarmEntity_thenToDataOriginatorReturnCustomerId2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  public void testNewAlarmEntity_whenAlarmOriginatorIsSystem_tenant_thenReturnTenantIdIsNull() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_givenAlarmEntityAssigneeIdIsNull_thenReturnAssigneeIdIsNull() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(null);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.TENANT);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originator.getId().toString());
    assertNull(actualToDataResult.getAssigneeId());
    assertTrue(((TenantId) originator).isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_givenAlarmEntityCustomerIdIsNull_thenReturnCustomerIdIsNull() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(null);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.TENANT);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originator.getId().toString());
    assertNull(actualToDataResult.getCustomerId());
    assertTrue(((TenantId) originator).isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_givenAlarmEntityOriginatorTypeIsAlarm_thenOriginatorReturnAlarmId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.ALARM);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getOriginator() instanceof AlarmId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_givenAlarmEntityOriginatorTypeIsAsset_thenOriginatorReturnAssetId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.ASSET);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof AssetId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.ASSET, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_givenAlarmEntityOriginatorTypeIsDevice_thenOriginatorReturnDeviceId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.DEVICE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof DeviceId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.DEVICE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_givenAlarmEntityOriginatorTypeIsDomain_thenOriginatorReturnDomainId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.DOMAIN);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof DomainId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.DOMAIN, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_givenAlarmEntityOriginatorTypeIsEdge_thenOriginatorReturnEdgeId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.EDGE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof EdgeId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.EDGE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_givenAlarmEntityOriginatorTypeIsQueue_thenOriginatorReturnQueueId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.QUEUE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof QueueId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.QUEUE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_givenAlarmEntityOriginatorTypeIsRpc_thenOriginatorReturnRpcId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.RPC);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof RpcId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.RPC, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_givenAlarmEntityOriginatorTypeIsUser_thenOriginatorReturnUserId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.USER);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getOriginator() instanceof UserId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_givenAlarmEntityPropagateRelationTypesIsNull() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes(null);
    alarmEntity.setOriginatorType(EntityType.TENANT);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originator.getId().toString());
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertTrue(((TenantId) originator).isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_givenAlarmEntityTenantIdIsNull_thenReturnTenantIdIsNull() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(null);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.TENANT);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originator.getId().toString());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertTrue(((TenantId) originator).isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnApiUsageStateId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.API_USAGE_STATE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof ApiUsageStateId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.API_USAGE_STATE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnAssetProfileId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.ASSET_PROFILE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof AssetProfileId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.ASSET_PROFILE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnCustomerId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.CUSTOMER);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getOriginator() instanceof CustomerId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnDashboardId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.DASHBOARD);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

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
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then Originator return {@link DeviceProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnDeviceProfileId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.DEVICE_PROFILE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof DeviceProfileId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.DEVICE_PROFILE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnEntityViewId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.ENTITY_VIEW);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof EntityViewId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.ENTITY_VIEW, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnMobileAppId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.MOBILE_APP);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof MobileAppId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.MOBILE_APP, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnNotificationId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.NOTIFICATION);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof NotificationId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.NOTIFICATION, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnNotificationRequestId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.NOTIFICATION_REQUEST);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof NotificationRequestId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_REQUEST, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnNotificationRuleId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.NOTIFICATION_RULE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof NotificationRuleId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_RULE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnNotificationTargetId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.NOTIFICATION_TARGET);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof NotificationTargetId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TARGET, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnNotificationTemplateId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.NOTIFICATION_TEMPLATE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof NotificationTemplateId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnOAuth2ClientId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.OAUTH2_CLIENT);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof OAuth2ClientId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.OAUTH2_CLIENT, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnOtaPackageId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.OTA_PACKAGE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof OtaPackageId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.OTA_PACKAGE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnQueueStatsId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.QUEUE_STATS);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof QueueStatsId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.QUEUE_STATS, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnRuleChainId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.RULE_CHAIN);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof RuleChainId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnRuleNodeId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.RULE_NODE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof RuleNodeId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.RULE_NODE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnTbResourceId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.TB_RESOURCE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TbResourceId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TB_RESOURCE, originator.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnTenantProfileId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.TENANT_PROFILE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantProfileId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EntityType.TENANT_PROFILE, originator.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnWidgetTypeId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.WIDGET_TYPE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof WidgetTypeId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EntityType.WIDGET_TYPE, originator.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenOriginatorReturnWidgetsBundleId() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.WIDGETS_BUNDLE);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof WidgetsBundleId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EntityType.WIDGETS_BUNDLE, originator.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then return not Originator NullUid.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenReturnNotOriginatorNullUid() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    UUID originatorId = UUID.randomUUID();
    alarmEntity.setOriginatorId(originatorId);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.TENANT);

    // Act and Assert
    EntityId originator = alarmEntity.toData().getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertFalse(originator.isNullUid());
    assertFalse(((TenantId) originator).isSysTenantId());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   *
   * <ul>
   *   <li>Then return Originator EntityType is {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenReturnOriginatorEntityTypeIsTenant() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("");
    alarmEntity.setOriginatorType(EntityType.TENANT);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originator.getId().toString());
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertTrue(((TenantId) originator).isSysTenantId());
    assertSame(originator, actualToDataResult.getTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Alarm AlarmEntity.toData()"})
  public void testToData_thenReturnPropagateRelationTypesSizeIsTwo() {
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
    alarmEntity.setId(ModelConstants.NULL_UUID);
    alarmEntity.setOriginatorId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagate(true);
    alarmEntity.setPropagateToOwner(true);
    alarmEntity.setPropagateToTenant(true);
    alarmEntity.setSeverity(AlarmSeverity.CRITICAL);
    alarmEntity.setStartTs(1L);
    alarmEntity.setType("Type");
    alarmEntity.setUuid(ModelConstants.NULL_UUID);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);
    alarmEntity.setPropagateRelationTypes("foo,bar");
    alarmEntity.setOriginatorType(EntityType.TENANT);

    // Act and Assert
    List<String> propagateRelationTypes = alarmEntity.toData().getPropagateRelationTypes();
    assertEquals(2, propagateRelationTypes.size());
    assertEquals("bar", propagateRelationTypes.get(1));
    assertEquals("foo", propagateRelationTypes.get(0));
  }
}
