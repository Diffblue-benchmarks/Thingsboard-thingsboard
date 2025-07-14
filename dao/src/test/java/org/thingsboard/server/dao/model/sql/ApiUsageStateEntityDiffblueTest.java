package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

class ApiUsageStateEntityDiffblueTest {
  /**
   * Test {@link ApiUsageStateEntity#ApiUsageStateEntity()}.
   *
   * <p>Method under test: {@link ApiUsageStateEntity#ApiUsageStateEntity()}
   */
  @Test
  @DisplayName("Test new ApiUsageStateEntity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ApiUsageStateEntity.<init>()"})
  void testNewApiUsageStateEntity() {
    // Arrange and Act
    ApiUsageStateEntity actualApiUsageStateEntity = new ApiUsageStateEntity();

    // Assert
    assertNull(actualApiUsageStateEntity.getEntityType());
    assertNull(actualApiUsageStateEntity.getId());
    assertNull(actualApiUsageStateEntity.getUuid());
    assertNull(actualApiUsageStateEntity.getEntityId());
    assertNull(actualApiUsageStateEntity.getTenantId());
    assertEquals(0L, actualApiUsageStateEntity.getCreatedTime());
    assertEquals(ApiUsageStateValue.ENABLED, actualApiUsageStateEntity.getAlarmExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualApiUsageStateEntity.getDbStorageState());
    assertEquals(ApiUsageStateValue.ENABLED, actualApiUsageStateEntity.getEmailExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualApiUsageStateEntity.getJsExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualApiUsageStateEntity.getReExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualApiUsageStateEntity.getSmsExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualApiUsageStateEntity.getTbelExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualApiUsageStateEntity.getTransportState());
  }

  /**
   * Test {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}.
   *
   * <p>Method under test: {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}
   */
  @Test
  @DisplayName("Test new ApiUsageStateEntity(ApiUsageState)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ApiUsageStateEntity.<init>(ApiUsageState)"})
  void testNewApiUsageStateEntity2() {
    // Arrange
    ApiUsageState ur = new ApiUsageState(new ApiUsageState());
    ur.setId(null);
    ur.setTenantId(ModelConstants.SYSTEM_TENANT);
    ur.setEntityId(null);

    // Act
    ApiUsageStateEntity actualApiUsageStateEntity = new ApiUsageStateEntity(ur);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualApiUsageStateEntity.getTenantId().toString());
    assertNull(actualApiUsageStateEntity.getEntityType());
    assertNull(actualApiUsageStateEntity.getEntityId());
    assertEquals(0L, actualApiUsageStateEntity.getCreatedTime());
  }

  /**
   * Test {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}.
   *
   * <p>Method under test: {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}
   */
  @Test
  @DisplayName("Test new ApiUsageStateEntity(ApiUsageState)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ApiUsageStateEntity.<init>(ApiUsageState)"})
  void testNewApiUsageStateEntity3() {
    // Arrange
    ApiUsageState ur = new ApiUsageState(new ApiUsageState());
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ur.setId(new ApiUsageStateId(id));
    ur.setTenantId(null);
    ur.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    ApiUsageStateEntity actualApiUsageStateEntity = new ApiUsageStateEntity(ur);

    // Assert
    UUID id2 = actualApiUsageStateEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertSame(id, id2);
    assertSame(id, actualApiUsageStateEntity.getUuid());
  }

  /**
   * Test {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return EntityType is {@code CUSTOMER}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}
   */
  @Test
  @DisplayName(
      "Test new ApiUsageStateEntity(ApiUsageState); given NULL_CUSTOMER_ID; then return EntityType is 'CUSTOMER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ApiUsageStateEntity.<init>(ApiUsageState)"})
  void testNewApiUsageStateEntity_givenNull_customer_id_thenReturnEntityTypeIsCustomer() {
    // Arrange
    ApiUsageState ur = new ApiUsageState(new ApiUsageState());
    ur.setId(null);
    ur.setTenantId(null);
    ur.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    ApiUsageStateEntity actualApiUsageStateEntity = new ApiUsageStateEntity(ur);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualApiUsageStateEntity.getEntityId().toString());
    assertEquals("CUSTOMER", actualApiUsageStateEntity.getEntityType());
    assertNull(actualApiUsageStateEntity.getTenantId());
    assertEquals(0L, actualApiUsageStateEntity.getCreatedTime());
  }

  /**
   * Test {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}
   */
  @Test
  @DisplayName(
      "Test new ApiUsageStateEntity(ApiUsageState); given one; then return CreatedTime is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ApiUsageStateEntity.<init>(ApiUsageState)"})
  void testNewApiUsageStateEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    ApiUsageState ur = new ApiUsageState();
    ur.setCreatedTime(1L);

    // Act
    ApiUsageStateEntity actualApiUsageStateEntity = new ApiUsageStateEntity(ur);

    // Assert
    assertNull(actualApiUsageStateEntity.getEntityType());
    assertNull(actualApiUsageStateEntity.getEntityId());
    assertNull(actualApiUsageStateEntity.getTenantId());
    assertEquals(1L, actualApiUsageStateEntity.getCreatedTime());
  }

  /**
   * Test {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}.
   *
   * <ul>
   *   <li>Then return EntityType is {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}
   */
  @Test
  @DisplayName("Test new ApiUsageStateEntity(ApiUsageState); then return EntityType is 'TENANT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ApiUsageStateEntity.<init>(ApiUsageState)"})
  void testNewApiUsageStateEntity_thenReturnEntityTypeIsTenant() {
    // Arrange
    ApiUsageState ur = new ApiUsageState(new ApiUsageState());
    ur.setId(null);
    ur.setTenantId(null);
    ur.setEntityId(ModelConstants.SYSTEM_TENANT);

    // Act
    ApiUsageStateEntity actualApiUsageStateEntity = new ApiUsageStateEntity(ur);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualApiUsageStateEntity.getEntityId().toString());
    assertEquals("TENANT", actualApiUsageStateEntity.getEntityType());
    assertNull(actualApiUsageStateEntity.getTenantId());
    assertEquals(0L, actualApiUsageStateEntity.getCreatedTime());
  }

  /**
   * Test {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}.
   *
   * <ul>
   *   <li>When {@link ApiUsageState#ApiUsageState()}.
   *   <li>Then return EntityType is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}
   */
  @Test
  @DisplayName(
      "Test new ApiUsageStateEntity(ApiUsageState); when ApiUsageState(); then return EntityType is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ApiUsageStateEntity.<init>(ApiUsageState)"})
  void testNewApiUsageStateEntity_whenApiUsageState_thenReturnEntityTypeIsNull() {
    // Arrange and Act
    ApiUsageStateEntity actualApiUsageStateEntity = new ApiUsageStateEntity(new ApiUsageState());

    // Assert
    assertNull(actualApiUsageStateEntity.getEntityType());
    assertNull(actualApiUsageStateEntity.getEntityId());
    assertNull(actualApiUsageStateEntity.getTenantId());
    assertEquals(0L, actualApiUsageStateEntity.getCreatedTime());
  }

  /**
   * Test {@link ApiUsageStateEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageStateEntity#ApiUsageStateEntity()}.
   *   <li>Then return EntityId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given ApiUsageStateEntity(); then return EntityId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiUsageState ApiUsageStateEntity.toData()"})
  void testToData_givenApiUsageStateEntity_thenReturnEntityIdIsNull() {
    // Arrange and Act
    ApiUsageState actualToDataResult = new ApiUsageStateEntity().toData();

    // Assert
    assertNull(actualToDataResult.getEntityId());
    assertEquals(ApiUsageStateValue.ENABLED, actualToDataResult.getAlarmExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualToDataResult.getDbStorageState());
    assertEquals(ApiUsageStateValue.ENABLED, actualToDataResult.getEmailExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualToDataResult.getJsExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualToDataResult.getReExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualToDataResult.getSmsExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualToDataResult.getTbelExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualToDataResult.getTransportState());
  }

  /**
   * Test {@link ApiUsageStateEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return AlarmId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiUsageState ApiUsageStateEntity.toData()"})
  void testToData_thenEntityIdReturnAlarmId() {
    // Arrange
    ApiUsageState ur = new ApiUsageState(new ApiUsageState());
    ur.setId(null);
    ur.setTenantId(null);
    AlarmId entityId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ur.setEntityId(entityId);

    // Act and Assert
    EntityId entityId2 = new ApiUsageStateEntity(ur).toData().getEntityId();
    assertTrue(entityId2 instanceof AlarmId);
    assertEquals(entityId, entityId2);
  }

  /**
   * Test {@link ApiUsageStateEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return CustomerId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiUsageState ApiUsageStateEntity.toData()"})
  void testToData_thenEntityIdReturnCustomerId() {
    // Arrange
    ApiUsageState ur = new ApiUsageState(new ApiUsageState());
    ur.setId(null);
    ur.setTenantId(null);
    ur.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    EntityId entityId = new ApiUsageStateEntity(ur).toData().getEntityId();
    assertTrue(entityId instanceof CustomerId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.CUSTOMER, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link ApiUsageStateEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then EntityId return TenantId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiUsageState ApiUsageStateEntity.toData()"})
  void testToData_thenEntityIdReturnTenantId() {
    // Arrange
    ApiUsageState ur = new ApiUsageState(new ApiUsageState());
    ur.setId(null);
    ur.setTenantId(null);
    ur.setEntityId(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    EntityId entityId = new ApiUsageStateEntity(ur).toData().getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Test {@link ApiUsageStateEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return TenantId Id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiUsageState ApiUsageStateEntity.toData()"})
  void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    apiUsageStateEntity.setUuid(id);
    UUID tenantId = UUID.randomUUID();
    apiUsageStateEntity.setTenantId(tenantId);
    apiUsageStateEntity.setEntityId(null);

    // Act
    ApiUsageState actualToDataResult = apiUsageStateEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(id, uuidId);
    assertSame(id, actualToDataResult.getId().getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link ApiUsageStateEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return TenantId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiUsageState ApiUsageStateEntity.toData()"})
  void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    apiUsageStateEntity.setUuid(id);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityId(null);

    // Act
    ApiUsageState actualToDataResult = apiUsageStateEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(id, uuidId);
    assertSame(id, actualToDataResult.getId().getId());
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}, and {@link ApiUsageStateEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageStateEntity#equals(Object)}
   *   <li>{@link ApiUsageStateEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(apiUsageStateEntity, apiUsageStateEntity2);
    int expectedHashCodeResult = apiUsageStateEntity.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageStateEntity2.hashCode());
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}, and {@link ApiUsageStateEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageStateEntity#equals(Object)}
   *   <li>{@link ApiUsageStateEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(null);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(null);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(apiUsageStateEntity, apiUsageStateEntity2);
    int expectedHashCodeResult = apiUsageStateEntity.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageStateEntity2.hashCode());
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}, and {@link ApiUsageStateEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageStateEntity#equals(Object)}
   *   <li>{@link ApiUsageStateEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(apiUsageStateEntity, apiUsageStateEntity);
    int expectedHashCodeResult = apiUsageStateEntity.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageStateEntity.hashCode());
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(null);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(3L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(null);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(null);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(null);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType(null);
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("org.thingsboard.server.dao.model.sql.ApiUsageStateEntity");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(null);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(null);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(null);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(null);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(null);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(null);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, null);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, "Different type to ApiUsageStateEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageStateEntity#setAlarmExecState(ApiUsageStateValue)}
   *   <li>{@link ApiUsageStateEntity#setDbStorageState(ApiUsageStateValue)}
   *   <li>{@link ApiUsageStateEntity#setEmailExecState(ApiUsageStateValue)}
   *   <li>{@link ApiUsageStateEntity#setEntityId(UUID)}
   *   <li>{@link ApiUsageStateEntity#setEntityType(String)}
   *   <li>{@link ApiUsageStateEntity#setJsExecState(ApiUsageStateValue)}
   *   <li>{@link ApiUsageStateEntity#setReExecState(ApiUsageStateValue)}
   *   <li>{@link ApiUsageStateEntity#setSmsExecState(ApiUsageStateValue)}
   *   <li>{@link ApiUsageStateEntity#setTbelExecState(ApiUsageStateValue)}
   *   <li>{@link ApiUsageStateEntity#setTenantId(UUID)}
   *   <li>{@link ApiUsageStateEntity#setTransportState(ApiUsageStateValue)}
   *   <li>{@link ApiUsageStateEntity#toString()}
   *   <li>{@link ApiUsageStateEntity#getAlarmExecState()}
   *   <li>{@link ApiUsageStateEntity#getDbStorageState()}
   *   <li>{@link ApiUsageStateEntity#getEmailExecState()}
   *   <li>{@link ApiUsageStateEntity#getEntityId()}
   *   <li>{@link ApiUsageStateEntity#getEntityType()}
   *   <li>{@link ApiUsageStateEntity#getJsExecState()}
   *   <li>{@link ApiUsageStateEntity#getReExecState()}
   *   <li>{@link ApiUsageStateEntity#getSmsExecState()}
   *   <li>{@link ApiUsageStateEntity#getTbelExecState()}
   *   <li>{@link ApiUsageStateEntity#getTenantId()}
   *   <li>{@link ApiUsageStateEntity#getTransportState()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "ApiUsageStateValue ApiUsageStateEntity.getAlarmExecState()",
    "ApiUsageStateValue ApiUsageStateEntity.getDbStorageState()",
    "ApiUsageStateValue ApiUsageStateEntity.getEmailExecState()",
    "UUID ApiUsageStateEntity.getEntityId()",
    "String ApiUsageStateEntity.getEntityType()",
    "ApiUsageStateValue ApiUsageStateEntity.getJsExecState()",
    "ApiUsageStateValue ApiUsageStateEntity.getReExecState()",
    "ApiUsageStateValue ApiUsageStateEntity.getSmsExecState()",
    "ApiUsageStateValue ApiUsageStateEntity.getTbelExecState()",
    "UUID ApiUsageStateEntity.getTenantId()",
    "ApiUsageStateValue ApiUsageStateEntity.getTransportState()",
    "void ApiUsageStateEntity.setAlarmExecState(ApiUsageStateValue)",
    "void ApiUsageStateEntity.setDbStorageState(ApiUsageStateValue)",
    "void ApiUsageStateEntity.setEmailExecState(ApiUsageStateValue)",
    "void ApiUsageStateEntity.setEntityId(UUID)",
    "void ApiUsageStateEntity.setEntityType(String)",
    "void ApiUsageStateEntity.setJsExecState(ApiUsageStateValue)",
    "void ApiUsageStateEntity.setReExecState(ApiUsageStateValue)",
    "void ApiUsageStateEntity.setSmsExecState(ApiUsageStateValue)",
    "void ApiUsageStateEntity.setTbelExecState(ApiUsageStateValue)",
    "void ApiUsageStateEntity.setTenantId(UUID)",
    "void ApiUsageStateEntity.setTransportState(ApiUsageStateValue)",
    "String ApiUsageStateEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();

    // Act
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    apiUsageStateEntity.setEntityId(entityId);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    apiUsageStateEntity.setTenantId(tenantId);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    String actualToStringResult = apiUsageStateEntity.toString();
    ApiUsageStateValue actualAlarmExecState = apiUsageStateEntity.getAlarmExecState();
    ApiUsageStateValue actualDbStorageState = apiUsageStateEntity.getDbStorageState();
    ApiUsageStateValue actualEmailExecState = apiUsageStateEntity.getEmailExecState();
    UUID actualEntityId = apiUsageStateEntity.getEntityId();
    String actualEntityType = apiUsageStateEntity.getEntityType();
    ApiUsageStateValue actualJsExecState = apiUsageStateEntity.getJsExecState();
    ApiUsageStateValue actualReExecState = apiUsageStateEntity.getReExecState();
    ApiUsageStateValue actualSmsExecState = apiUsageStateEntity.getSmsExecState();
    ApiUsageStateValue actualTbelExecState = apiUsageStateEntity.getTbelExecState();
    UUID actualTenantId = apiUsageStateEntity.getTenantId();
    ApiUsageStateValue actualTransportState = apiUsageStateEntity.getTransportState();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEntityId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals(
        "ApiUsageStateEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, entityType=Entity Type, entityId"
            + "=784f394c-42b6-435a-983c-b7beff2784f9, transportState=ENABLED, dbStorageState=ENABLED, reExecState=ENABLED,"
            + " jsExecState=ENABLED, tbelExecState=ENABLED, emailExecState=ENABLED, smsExecState=ENABLED, alarmExecState"
            + "=ENABLED)",
        actualToStringResult);
    assertEquals("Entity Type", actualEntityType);
    assertEquals(ApiUsageStateValue.ENABLED, actualAlarmExecState);
    assertEquals(ApiUsageStateValue.ENABLED, actualDbStorageState);
    assertEquals(ApiUsageStateValue.ENABLED, actualEmailExecState);
    assertEquals(ApiUsageStateValue.ENABLED, actualJsExecState);
    assertEquals(ApiUsageStateValue.ENABLED, actualReExecState);
    assertEquals(ApiUsageStateValue.ENABLED, actualSmsExecState);
    assertEquals(ApiUsageStateValue.ENABLED, actualTbelExecState);
    assertEquals(ApiUsageStateValue.ENABLED, actualTransportState);
    assertSame(entityId, actualEntityId);
    assertSame(tenantId, actualTenantId);
  }
}
