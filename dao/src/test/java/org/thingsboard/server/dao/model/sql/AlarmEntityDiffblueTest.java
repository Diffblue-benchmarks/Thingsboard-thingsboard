package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.AlarmInfo;
import org.thingsboard.server.common.data.alarm.AlarmSeverity;
import org.thingsboard.server.common.data.alarm.AlarmStatus;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class AlarmEntityDiffblueTest {
  /**
   * Test {@link AlarmEntity#equals(Object)}, and {@link AlarmEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmEntity#equals(Object)}
   *   <li>{@link AlarmEntity#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = alarmEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmEntity2.hashCode());
  }

  /**
   * Test {@link AlarmEntity#equals(Object)}, and {@link AlarmEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmEntity#equals(Object)}
   *   <li>{@link AlarmEntity#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
    alarmEntity.setDetails(mock(JsonNode.class));
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEntity#equals(Object)}
   */
  @Test
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmEntity#AlarmEntity()}
   *   <li>{@link AlarmEntity#toString()}
   * </ul>
   */
  @Test
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
   * <p>
   * Method under test: {@link AlarmEntity#AlarmEntity(Alarm)}
   */
  @Test
  public void testNewAlarmEntity() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarm);

    // Assert
    Alarm toDataResult = actualAlarmEntity.toData();
    EntityId originator = toDataResult.getOriginator();
    assertTrue(originator instanceof CustomerId);
    UUID originatorId = actualAlarmEntity.getOriginatorId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originatorId.toString());
    assertNull(toDataResult.getDetails());
    assertNull(actualAlarmEntity.getDetails());
    assertNull(toDataResult.getName());
    assertNull(toDataResult.getType());
    assertNull(actualAlarmEntity.getType());
    assertNull(actualAlarmEntity.getAssigneeId());
    assertNull(actualAlarmEntity.getCustomerId());
    assertNull(actualAlarmEntity.getTenantId());
    assertNull(toDataResult.getSeverity());
    assertNull(actualAlarmEntity.getSeverity());
    assertNull(toDataResult.getCustomerId());
    assertNull(toDataResult.getTenantId());
    assertNull(toDataResult.getAssigneeId());
    assertEquals(0L, actualAlarmEntity.getAckTs().longValue());
    assertEquals(0L, actualAlarmEntity.getAssignTs().longValue());
    assertEquals(0L, actualAlarmEntity.getClearTs().longValue());
    assertEquals(0L, actualAlarmEntity.getEndTs().longValue());
    assertEquals(0L, actualAlarmEntity.getStartTs().longValue());
    assertEquals(0L, toDataResult.getAckTs());
    assertEquals(0L, toDataResult.getAssignTs());
    assertEquals(0L, toDataResult.getClearTs());
    assertEquals(0L, toDataResult.getEndTs());
    assertEquals(0L, toDataResult.getStartTs());
    assertEquals(EntityType.CUSTOMER, originator.getEntityType());
    assertEquals(AlarmStatus.ACTIVE_UNACK, toDataResult.getStatus());
    assertFalse(toDataResult.isAcknowledged());
    assertFalse(toDataResult.isCleared());
    assertFalse(toDataResult.isPropagate());
    assertFalse(toDataResult.isPropagateToOwner());
    assertFalse(toDataResult.isPropagateToTenant());
    assertFalse(actualAlarmEntity.getPropagate());
    assertFalse(actualAlarmEntity.getPropagateToOwner());
    assertFalse(actualAlarmEntity.getPropagateToTenant());
    assertFalse(actualAlarmEntity.isAcknowledged());
    assertFalse(actualAlarmEntity.isCleared());
    assertTrue(originator.isNullUid());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(Alarm)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then return toData PropagateRelationTypes size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEntity#AlarmEntity(Alarm)}
   */
  @Test
  public void testNewAlarmEntity_givenFoo_thenReturnToDataPropagateRelationTypesSizeIsOne() {
    // Arrange
    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    propagateRelationTypes.add("foo");

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(new Alarm(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, "Type", BaseEntityService.NULL_CUSTOMER_ID, AlarmSeverity.CRITICAL, true,
        true, new UserId(ModelConstants.NULL_UUID), 1L, 1L, 1L, 1L, 1L,
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON, true, true, true, propagateRelationTypes));

    // Assert
    List<String> propagateRelationTypes2 = actualAlarmEntity.toData().getPropagateRelationTypes();
    assertEquals(1, propagateRelationTypes2.size());
    assertEquals("foo", propagateRelationTypes2.get(0));
    assertEquals("foo", actualAlarmEntity.getPropagateRelationTypes());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(AlarmInfo)}.
   * <ul>
   *   <li>Then toData Originator return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEntity#AlarmEntity(AlarmInfo)}
   */
  @Test
  public void testNewAlarmEntity_thenToDataOriginatorReturnCustomerId() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    alarmInfo.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarmInfo);

    // Assert
    Alarm toDataResult = actualAlarmEntity.toData();
    EntityId originator = toDataResult.getOriginator();
    assertTrue(originator instanceof CustomerId);
    assertEquals("", actualAlarmEntity.getPropagateRelationTypes());
    UUID originatorId = actualAlarmEntity.getOriginatorId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originatorId.toString());
    assertNull(toDataResult.getDetails());
    assertNull(actualAlarmEntity.getDetails());
    assertNull(toDataResult.getName());
    assertNull(toDataResult.getType());
    assertNull(actualAlarmEntity.getType());
    assertNull(toDataResult.getUuidId());
    AlarmId id = toDataResult.getId();
    assertNull(id.getId());
    assertNull(actualAlarmEntity.getId());
    assertNull(actualAlarmEntity.getUuid());
    assertNull(actualAlarmEntity.getAssigneeId());
    assertNull(actualAlarmEntity.getCustomerId());
    assertNull(actualAlarmEntity.getTenantId());
    assertNull(toDataResult.getSeverity());
    assertNull(actualAlarmEntity.getSeverity());
    assertNull(toDataResult.getCustomerId());
    assertNull(toDataResult.getDashboardId());
    assertNull(toDataResult.getTenantId());
    assertNull(toDataResult.getAssigneeId());
    assertEquals(0L, actualAlarmEntity.getAckTs().longValue());
    assertEquals(0L, actualAlarmEntity.getAssignTs().longValue());
    assertEquals(0L, actualAlarmEntity.getClearTs().longValue());
    assertEquals(0L, actualAlarmEntity.getEndTs().longValue());
    assertEquals(0L, actualAlarmEntity.getStartTs().longValue());
    assertEquals(0L, toDataResult.getAckTs());
    assertEquals(0L, toDataResult.getAssignTs());
    assertEquals(0L, toDataResult.getClearTs());
    assertEquals(0L, toDataResult.getCreatedTime());
    assertEquals(0L, toDataResult.getEndTs());
    assertEquals(0L, toDataResult.getStartTs());
    assertEquals(0L, actualAlarmEntity.getCreatedTime());
    assertEquals(EntityType.ALARM, id.getEntityType());
    assertEquals(EntityType.CUSTOMER, originator.getEntityType());
    assertEquals(EntityType.CUSTOMER, actualAlarmEntity.getOriginatorType());
    assertEquals(AlarmStatus.ACTIVE_UNACK, toDataResult.getStatus());
    assertFalse(toDataResult.isAcknowledged());
    assertFalse(toDataResult.isCleared());
    assertFalse(toDataResult.isPropagate());
    assertFalse(toDataResult.isPropagateToOwner());
    assertFalse(toDataResult.isPropagateToTenant());
    assertFalse(id.isNullUid());
    assertFalse(actualAlarmEntity.getPropagate());
    assertFalse(actualAlarmEntity.getPropagateToOwner());
    assertFalse(actualAlarmEntity.getPropagateToTenant());
    assertFalse(actualAlarmEntity.isAcknowledged());
    assertFalse(actualAlarmEntity.isCleared());
    assertTrue(toDataResult.getPropagateRelationTypes().isEmpty());
    assertTrue(originator.isNullUid());
    assertSame(originatorId, originator.getId());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(Alarm)}.
   * <ul>
   *   <li>Then toData Originator return {@link TenantId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEntity#AlarmEntity(Alarm)}
   */
  @Test
  public void testNewAlarmEntity_thenToDataOriginatorReturnTenantId() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setOriginator(ModelConstants.SYSTEM_TENANT);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarm);

    // Assert
    EntityId originator = actualAlarmEntity.toData().getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertEquals(EntityType.TENANT, actualAlarmEntity.getOriginatorType());
    assertTrue(((TenantId) originator).isSysTenantId());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(AlarmInfo)}.
   * <ul>
   *   <li>Then toData Originator return {@link TenantId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEntity#AlarmEntity(AlarmInfo)}
   */
  @Test
  public void testNewAlarmEntity_thenToDataOriginatorReturnTenantId2() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    alarmInfo.setOriginator(ModelConstants.SYSTEM_TENANT);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarmInfo);

    // Assert
    EntityId originator = actualAlarmEntity.toData().getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertEquals(EntityType.TENANT, actualAlarmEntity.getOriginatorType());
    assertTrue(((TenantId) originator).isSysTenantId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} OriginatorType is
   * {@code ALARM}.</li>
   *   <li>Then Originator return {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEntity#toData()}
   */
  @Test
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
    alarmEntity.setPropagateRelationTypes(null);
    alarmEntity.setOriginatorType(EntityType.ALARM);
    alarmEntity.setTenantId(null);
    alarmEntity.setCustomerId(null);
    alarmEntity.setAssigneeId(null);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getOriginator() instanceof AlarmId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertNull(actualToDataResult.getAssigneeId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} OriginatorType is
   * {@code ASSET}.</li>
   *   <li>Then Originator return {@link AssetId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEntity#toData()}
   */
  @Test
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
    alarmEntity.setPropagateRelationTypes(null);
    alarmEntity.setOriginatorType(EntityType.ASSET);
    alarmEntity.setTenantId(null);
    alarmEntity.setCustomerId(null);
    alarmEntity.setAssigneeId(null);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof AssetId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertNull(actualToDataResult.getAssigneeId());
    assertEquals(EntityType.ASSET, originator.getEntityType());
    assertTrue(originator.isNullUid());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} OriginatorType is
   * {@code DEVICE}.</li>
   *   <li>Then Originator return {@link DeviceId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEntity#toData()}
   */
  @Test
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
    alarmEntity.setPropagateRelationTypes(null);
    alarmEntity.setOriginatorType(EntityType.DEVICE);
    alarmEntity.setTenantId(null);
    alarmEntity.setCustomerId(null);
    alarmEntity.setAssigneeId(null);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof DeviceId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertNull(actualToDataResult.getAssigneeId());
    assertEquals(EntityType.DEVICE, originator.getEntityType());
    assertTrue(originator.isNullUid());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} OriginatorType is
   * {@code TENANT}.</li>
   *   <li>Then Originator return {@link TenantId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  public void testToData_givenAlarmEntityOriginatorTypeIsTenant_thenOriginatorReturnTenantId() {
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
    alarmEntity.setPropagateRelationTypes(null);
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setTenantId(null);
    alarmEntity.setCustomerId(null);
    alarmEntity.setAssigneeId(null);

    // Act and Assert
    EntityId originator = alarmEntity.toData().getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originator.getId().toString());
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertTrue(((TenantId) originator).isSysTenantId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} OriginatorType is
   * {@code USER}.</li>
   *   <li>Then Originator return {@link UserId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEntity#toData()}
   */
  @Test
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
    alarmEntity.setPropagateRelationTypes(null);
    alarmEntity.setOriginatorType(EntityType.USER);
    alarmEntity.setTenantId(null);
    alarmEntity.setCustomerId(null);
    alarmEntity.setAssigneeId(null);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof UserId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertNull(actualToDataResult.getAssigneeId());
    assertEquals(EntityType.USER, originator.getEntityType());
    assertTrue(originator.isNullUid());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   * <ul>
   *   <li>Given {@link AlarmEntity#AlarmEntity()} TenantId is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return TenantId is Originator.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  public void testToData_givenAlarmEntityTenantIdIsNull_uuid_thenReturnTenantIdIsOriginator() {
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
    alarmEntity.setPropagateRelationTypes(null);
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setTenantId(ModelConstants.NULL_UUID);
    alarmEntity.setCustomerId(null);
    alarmEntity.setAssigneeId(null);

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
   * <ul>
   *   <li>Then Originator return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEntity#toData()}
   */
  @Test
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
    alarmEntity.setPropagateRelationTypes(null);
    alarmEntity.setOriginatorType(EntityType.CUSTOMER);
    alarmEntity.setTenantId(null);
    alarmEntity.setCustomerId(null);
    alarmEntity.setAssigneeId(null);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof CustomerId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertNull(actualToDataResult.getAssigneeId());
    assertEquals(EntityType.CUSTOMER, originator.getEntityType());
    assertTrue(originator.isNullUid());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   * <ul>
   *   <li>Then Originator return {@link DashboardId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEntity#toData()}
   */
  @Test
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
    alarmEntity.setPropagateRelationTypes(null);
    alarmEntity.setOriginatorType(EntityType.DASHBOARD);
    alarmEntity.setTenantId(null);
    alarmEntity.setCustomerId(null);
    alarmEntity.setAssigneeId(null);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof DashboardId);
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
    assertNull(actualToDataResult.getAssigneeId());
    assertEquals(EntityType.DASHBOARD, originator.getEntityType());
    assertTrue(originator.isNullUid());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   * <ul>
   *   <li>Then return AssigneeId EntityType is {@code USER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  public void testToData_thenReturnAssigneeIdEntityTypeIsUser() {
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
    alarmEntity.setPropagateRelationTypes(null);
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setTenantId(null);
    alarmEntity.setCustomerId(null);
    alarmEntity.setAssigneeId(ModelConstants.NULL_UUID);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originator.getId().toString());
    assertEquals(EntityType.TENANT, originator.getEntityType());
    UserId assigneeId = actualToDataResult.getAssigneeId();
    assertEquals(EntityType.USER, assigneeId.getEntityType());
    assertTrue(assigneeId.isNullUid());
    assertTrue(((TenantId) originator).isSysTenantId());
  }

  /**
   * Test {@link AlarmEntity#toData()}.
   * <ul>
   *   <li>Then return CustomerId EntityType is {@code CUSTOMER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmEntity#toData()}
   */
  @Test
  public void testToData_thenReturnCustomerIdEntityTypeIsCustomer() {
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
    alarmEntity.setPropagateRelationTypes(null);
    alarmEntity.setOriginatorType(EntityType.TENANT);
    alarmEntity.setTenantId(null);
    alarmEntity.setCustomerId(ModelConstants.NULL_UUID);
    alarmEntity.setAssigneeId(null);

    // Act
    Alarm actualToDataResult = alarmEntity.toData();

    // Assert
    EntityId originator = actualToDataResult.getOriginator();
    assertTrue(originator instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originator.getId().toString());
    CustomerId customerId = actualToDataResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertEquals(EntityType.TENANT, originator.getEntityType());
    assertTrue(customerId.isNullUid());
    assertTrue(((TenantId) originator).isSysTenantId());
  }
}
