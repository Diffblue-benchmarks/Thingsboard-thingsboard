package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
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
  @Tag("MaintainedByDiffblue")
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
    int expectedHashCodeResult = alarmEntity.hashCode();
    assertEquals(expectedHashCodeResult, alarmEntity2.hashCode());
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  void testNewAlarmEntity_givenFoo_thenReturnToDataPropagateRelationTypesSizeIsOne() {
    // Arrange
    ArrayList<String> propagateRelationTypes = new ArrayList<>();
    propagateRelationTypes.add("foo");

    // Act
    AlarmEntity actualAlarmEntity =
        new AlarmEntity(
            new Alarm(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                BaseEntityService.NULL_CUSTOMER_ID,
                AlarmSeverity.CRITICAL,
                true,
                true,
                new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                1L,
                1L,
                1L,
                1L,
                1L,
                CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON,
                true,
                true,
                true,
                propagateRelationTypes));

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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  void testNewAlarmEntity_thenDetailsReturnObjectNode() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UserId assigneeId = new UserId(id);

    // Act
    AlarmEntity actualAlarmEntity =
        new AlarmEntity(
            new Alarm(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                BaseEntityService.NULL_CUSTOMER_ID,
                AlarmSeverity.CRITICAL,
                true,
                true,
                assigneeId,
                1L,
                1L,
                1L,
                1L,
                1L,
                CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON,
                true,
                true,
                true,
                new ArrayList<>()));

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
   *   <li>Then Details return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(AlarmInfo)}
   */
  @Test
  @DisplayName("Test new AlarmEntity(AlarmInfo); then Details return ObjectNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  void testNewAlarmEntity_thenDetailsReturnObjectNode2() {
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
    AlarmEntity actualAlarmEntity = new AlarmEntity(new AlarmInfo(alarm));

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
   * Test {@link AlarmEntity#AlarmEntity(Alarm)}.
   *
   * <ul>
   *   <li>Then return Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(Alarm)}
   */
  @Test
  @DisplayName(
      "Test new AlarmEntity(Alarm); then return Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  void testNewAlarmEntity_thenReturnIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    AlarmId id2 = new AlarmId(id);

    Alarm alarm = new Alarm(id2);
    alarm.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarm);

    // Assert
    Alarm toDataResult = actualAlarmEntity.toData();
    assertTrue(toDataResult.getOriginator() instanceof CustomerId);
    UUID id3 = actualAlarmEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id3.toString());
    assertEquals(id2, toDataResult.getId());
    assertSame(id, toDataResult.getUuidId());
    assertSame(id, id3);
    assertSame(id, actualAlarmEntity.getUuid());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  void testNewAlarmEntity_thenReturnIdToStringIs784f394c42b6435a983cB7beff2784f92() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);

    AlarmInfo alarmInfo = new AlarmInfo(alarm);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    AlarmId alarmId = new AlarmId(id);
    alarmInfo.setId(alarmId);
    alarmInfo.setTenantId(null);
    alarmInfo.setCustomerId(null);
    alarmInfo.setAssigneeId(null);
    alarmInfo.setPropagateRelationTypes(null);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarmInfo);

    // Assert
    Alarm toDataResult = actualAlarmEntity.toData();
    assertTrue(toDataResult.getOriginator() instanceof CustomerId);
    UUID id2 = actualAlarmEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertEquals(alarmId, toDataResult.getId());
    assertSame(id, toDataResult.getUuidId());
    assertSame(id, id2);
    assertSame(id, actualAlarmEntity.getUuid());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(Alarm)}.
   *
   * <ul>
   *   <li>Then return toData Originator EntityType is {@code CUSTOMER}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(Alarm)}
   */
  @Test
  @DisplayName(
      "Test new AlarmEntity(Alarm); then return toData Originator EntityType is 'CUSTOMER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  void testNewAlarmEntity_thenReturnToDataOriginatorEntityTypeIsCustomer() {
    // Arrange
    Alarm alarm = new Alarm();
    alarm.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarm);

    // Assert
    EntityId originator = actualAlarmEntity.toData().getOriginator();
    assertTrue(originator instanceof CustomerId);
    assertEquals(EntityType.CUSTOMER, originator.getEntityType());
    assertEquals(EntityType.CUSTOMER, actualAlarmEntity.getOriginatorType());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  void testNewAlarmEntity_thenReturnToDataOriginatorEntityTypeIsCustomer2() {
    // Arrange
    AlarmInfo alarmInfo = new AlarmInfo();
    alarmInfo.setOriginator(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    AlarmEntity actualAlarmEntity = new AlarmEntity(alarmInfo);

    // Assert
    EntityId originator = actualAlarmEntity.toData().getOriginator();
    assertTrue(originator instanceof CustomerId);
    assertEquals(EntityType.CUSTOMER, originator.getEntityType());
    assertEquals(EntityType.CUSTOMER, actualAlarmEntity.getOriginatorType());
  }

  /**
   * Test {@link AlarmEntity#AlarmEntity(Alarm)}.
   *
   * <ul>
   *   <li>Then return toData Originator EntityType is {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(Alarm)}
   */
  @Test
  @DisplayName("Test new AlarmEntity(Alarm); then return toData Originator EntityType is 'TENANT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmEntity.<init>(Alarm)"})
  void testNewAlarmEntity_thenReturnToDataOriginatorEntityTypeIsTenant() {
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
   *
   * <ul>
   *   <li>Then return toData Originator EntityType is {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link AlarmEntity#AlarmEntity(AlarmInfo)}
   */
  @Test
  @DisplayName(
      "Test new AlarmEntity(AlarmInfo); then return toData Originator EntityType is 'TENANT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AlarmEntity.<init>(AlarmInfo)"})
  void testNewAlarmEntity_thenReturnToDataOriginatorEntityTypeIsTenant2() {
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
}
