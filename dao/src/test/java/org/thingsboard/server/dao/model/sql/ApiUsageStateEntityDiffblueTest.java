package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.UUID;
import org.junit.Test;
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

public class ApiUsageStateEntityDiffblueTest {
  /**
   * Test {@link ApiUsageStateEntity#ApiUsageStateEntity()}.
   * <p>
   * Method under test: {@link ApiUsageStateEntity#ApiUsageStateEntity()}
   */
  @Test
  public void testNewApiUsageStateEntity() {
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
   * <p>
   * Method under test:
   * {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}
   */
  @Test
  public void testNewApiUsageStateEntity2() {
    // Arrange
    ApiUsageState ur = new ApiUsageState();
    ur.setId(null);
    ur.setTenantId(ModelConstants.SYSTEM_TENANT);
    ur.setEntityId(null);

    // Act
    ApiUsageStateEntity actualApiUsageStateEntity = new ApiUsageStateEntity(ur);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualApiUsageStateEntity.getTenantId().toString());
    assertNull(actualApiUsageStateEntity.getEntityType());
    assertNull(actualApiUsageStateEntity.getId());
    assertNull(actualApiUsageStateEntity.getUuid());
    assertNull(actualApiUsageStateEntity.getEntityId());
    assertEquals(0L, actualApiUsageStateEntity.getCreatedTime());
  }

  /**
   * Test {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}.
   * <p>
   * Method under test:
   * {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}
   */
  @Test
  public void testNewApiUsageStateEntity3() {
    // Arrange
    ApiUsageState ur = new ApiUsageState();
    ur.setId(new ApiUsageStateId(ModelConstants.NULL_UUID));
    ur.setTenantId(null);
    ur.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    ApiUsageStateEntity actualApiUsageStateEntity = new ApiUsageStateEntity(ur);

    // Assert
    UUID id = actualApiUsageStateEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualApiUsageStateEntity.getEntityId().toString());
    assertEquals("CUSTOMER", actualApiUsageStateEntity.getEntityType());
    assertSame(id, actualApiUsageStateEntity.getUuid());
  }

  /**
   * Test {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return EntityType is {@code CUSTOMER}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}
   */
  @Test
  public void testNewApiUsageStateEntity_givenNull_customer_id_thenReturnEntityTypeIsCustomer() {
    // Arrange
    ApiUsageState ur = new ApiUsageState();
    ur.setId(null);
    ur.setTenantId(null);
    ur.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    ApiUsageStateEntity actualApiUsageStateEntity = new ApiUsageStateEntity(ur);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualApiUsageStateEntity.getEntityId().toString());
    assertEquals("CUSTOMER", actualApiUsageStateEntity.getEntityType());
    assertNull(actualApiUsageStateEntity.getId());
    assertNull(actualApiUsageStateEntity.getUuid());
    assertNull(actualApiUsageStateEntity.getTenantId());
    assertEquals(0L, actualApiUsageStateEntity.getCreatedTime());
  }

  /**
   * Test {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return CreatedTime is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}
   */
  @Test
  public void testNewApiUsageStateEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    ApiUsageState ur = new ApiUsageState();
    ur.setCreatedTime(1L);

    // Act
    ApiUsageStateEntity actualApiUsageStateEntity = new ApiUsageStateEntity(ur);

    // Assert
    assertNull(actualApiUsageStateEntity.getEntityType());
    assertNull(actualApiUsageStateEntity.getId());
    assertNull(actualApiUsageStateEntity.getUuid());
    assertNull(actualApiUsageStateEntity.getEntityId());
    assertNull(actualApiUsageStateEntity.getTenantId());
    assertEquals(1L, actualApiUsageStateEntity.getCreatedTime());
  }

  /**
   * Test {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}.
   * <ul>
   *   <li>Then return EntityType is {@code TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}
   */
  @Test
  public void testNewApiUsageStateEntity_thenReturnEntityTypeIsTenant() {
    // Arrange
    ApiUsageState ur = new ApiUsageState();
    ur.setId(null);
    ur.setTenantId(null);
    ur.setEntityId(ModelConstants.SYSTEM_TENANT);

    // Act
    ApiUsageStateEntity actualApiUsageStateEntity = new ApiUsageStateEntity(ur);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualApiUsageStateEntity.getEntityId().toString());
    assertEquals("TENANT", actualApiUsageStateEntity.getEntityType());
    assertNull(actualApiUsageStateEntity.getId());
    assertNull(actualApiUsageStateEntity.getUuid());
    assertNull(actualApiUsageStateEntity.getTenantId());
    assertEquals(0L, actualApiUsageStateEntity.getCreatedTime());
  }

  /**
   * Test {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}.
   * <ul>
   *   <li>When {@link ApiUsageState#ApiUsageState()}.</li>
   *   <li>Then return EntityType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}
   */
  @Test
  public void testNewApiUsageStateEntity_whenApiUsageState_thenReturnEntityTypeIsNull() {
    // Arrange and Act
    ApiUsageStateEntity actualApiUsageStateEntity = new ApiUsageStateEntity(new ApiUsageState());

    // Assert
    assertNull(actualApiUsageStateEntity.getEntityType());
    assertNull(actualApiUsageStateEntity.getId());
    assertNull(actualApiUsageStateEntity.getUuid());
    assertNull(actualApiUsageStateEntity.getEntityId());
    assertNull(actualApiUsageStateEntity.getTenantId());
    assertEquals(0L, actualApiUsageStateEntity.getCreatedTime());
  }

  /**
   * Test {@link ApiUsageStateEntity#toData()}.
   * <ul>
   *   <li>Given {@link ApiUsageState#ApiUsageState()} EntityId is
   * {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then EntityId return {@link TenantId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#toData()}
   */
  @Test
  public void testToData_givenApiUsageStateEntityIdIsSystem_tenant_thenEntityIdReturnTenantId() {
    // Arrange
    ApiUsageState ur = new ApiUsageState();
    ur.setEntityId(ModelConstants.SYSTEM_TENANT);

    // Act
    ApiUsageState actualToDataResult = (new ApiUsageStateEntity(ur)).toData();

    // Assert
    EntityId entityId = actualToDataResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertNull(actualToDataResult.getAlarmExecState());
    assertNull(actualToDataResult.getDbStorageState());
    assertNull(actualToDataResult.getEmailExecState());
    assertNull(actualToDataResult.getJsExecState());
    assertNull(actualToDataResult.getReExecState());
    assertNull(actualToDataResult.getSmsExecState());
    assertNull(actualToDataResult.getTbelExecState());
    assertNull(actualToDataResult.getTransportState());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Test {@link ApiUsageStateEntity#toData()}.
   * <ul>
   *   <li>Given {@link ApiUsageStateEntity#ApiUsageStateEntity()}.</li>
   *   <li>Then return EntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#toData()}
   */
  @Test
  public void testToData_givenApiUsageStateEntity_thenReturnEntityIdIsNull() {
    // Arrange and Act
    ApiUsageState actualToDataResult = (new ApiUsageStateEntity()).toData();

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
   * <ul>
   *   <li>Then EntityId return {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnAlarmId() {
    // Arrange
    ApiUsageState ur = new ApiUsageState();
    AlarmId entityId = new AlarmId(ModelConstants.NULL_UUID);
    ur.setEntityId(entityId);

    // Act
    ApiUsageState actualToDataResult = (new ApiUsageStateEntity(ur)).toData();

    // Assert
    EntityId entityId2 = actualToDataResult.getEntityId();
    assertTrue(entityId2 instanceof AlarmId);
    assertNull(actualToDataResult.getAlarmExecState());
    assertNull(actualToDataResult.getDbStorageState());
    assertNull(actualToDataResult.getEmailExecState());
    assertNull(actualToDataResult.getJsExecState());
    assertNull(actualToDataResult.getReExecState());
    assertNull(actualToDataResult.getSmsExecState());
    assertNull(actualToDataResult.getTbelExecState());
    assertNull(actualToDataResult.getTransportState());
    assertEquals(entityId, entityId2);
  }

  /**
   * Test {@link ApiUsageStateEntity#toData()}.
   * <ul>
   *   <li>Then EntityId return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#toData()}
   */
  @Test
  public void testToData_thenEntityIdReturnCustomerId() {
    // Arrange
    ApiUsageState ur = new ApiUsageState();
    ur.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    ApiUsageState actualToDataResult = (new ApiUsageStateEntity(ur)).toData();

    // Assert
    EntityId entityId = actualToDataResult.getEntityId();
    assertTrue(entityId instanceof CustomerId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertNull(actualToDataResult.getAlarmExecState());
    assertNull(actualToDataResult.getDbStorageState());
    assertNull(actualToDataResult.getEmailExecState());
    assertNull(actualToDataResult.getJsExecState());
    assertNull(actualToDataResult.getReExecState());
    assertNull(actualToDataResult.getSmsExecState());
    assertNull(actualToDataResult.getTbelExecState());
    assertNull(actualToDataResult.getTransportState());
    assertEquals(EntityType.CUSTOMER, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link ApiUsageStateEntity#toData()}.
   * <ul>
   *   <li>Then return UuidId toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#toData()}
   */
  @Test
  public void testToData_thenReturnUuidIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityId(null);

    // Act
    ApiUsageState actualToDataResult = apiUsageStateEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    ApiUsageStateId id = actualToDataResult.getId();
    assertTrue(id.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}, and
   * {@link ApiUsageStateEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageStateEntity#equals(Object)}
   *   <li>{@link ApiUsageStateEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(apiUsageStateEntity, apiUsageStateEntity2);
    int expectedHashCodeResult = apiUsageStateEntity.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageStateEntity2.hashCode());
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}, and
   * {@link ApiUsageStateEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageStateEntity#equals(Object)}
   *   <li>{@link ApiUsageStateEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(apiUsageStateEntity, apiUsageStateEntity);
    int expectedHashCodeResult = apiUsageStateEntity.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageStateEntity.hashCode());
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(null);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(3L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(null);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(null);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.randomUUID());
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(null);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType(null);
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("org.thingsboard.server.dao.model.sql.ApiUsageStateEntity");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(null);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(null);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(null);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(null);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.randomUUID());
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(null);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(null);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, null);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, "Different type to ApiUsageStateEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();

    // Act
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    UUID tenantId = ModelConstants.NULL_UUID;
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

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals("ApiUsageStateEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, entityType=Entity Type, entityId"
        + "=13814000-1dd2-11b2-8080-808080808080, transportState=ENABLED, dbStorageState=ENABLED, reExecState=ENABLED,"
        + " jsExecState=ENABLED, tbelExecState=ENABLED, emailExecState=ENABLED, smsExecState=ENABLED, alarmExecState"
        + "=ENABLED)", actualToStringResult);
    assertEquals("Entity Type", actualEntityType);
    assertEquals(ApiUsageStateValue.ENABLED, actualAlarmExecState);
    assertEquals(ApiUsageStateValue.ENABLED, actualDbStorageState);
    assertEquals(ApiUsageStateValue.ENABLED, actualEmailExecState);
    assertEquals(ApiUsageStateValue.ENABLED, actualJsExecState);
    assertEquals(ApiUsageStateValue.ENABLED, actualReExecState);
    assertEquals(ApiUsageStateValue.ENABLED, actualSmsExecState);
    assertEquals(ApiUsageStateValue.ENABLED, actualTbelExecState);
    assertEquals(ApiUsageStateValue.ENABLED, actualTransportState);
    assertSame(tenantId, actualEntityId);
    assertSame(tenantId, actualTenantId);
  }
}
