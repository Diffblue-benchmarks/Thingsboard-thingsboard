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
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class ApiUsageStateEntityDiffblueTest {
  /**
   * Test {@link ApiUsageStateEntity#ApiUsageStateEntity()}.
   *
   * <p>Method under test: {@link ApiUsageStateEntity#ApiUsageStateEntity()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageStateEntity.<init>()"})
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
   *
   * <p>Method under test: {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageStateEntity.<init>(ApiUsageState)"})
  public void testNewApiUsageStateEntity2() {
    // Arrange
    ApiUsageState ur = new ApiUsageState((ApiUsageStateId) null);
    ur.setTenantId(ModelConstants.SYSTEM_TENANT);
    ur.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    ApiUsageStateEntity actualApiUsageStateEntity = new ApiUsageStateEntity(ur);

    // Assert
    UUID entityId = actualApiUsageStateEntity.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    assertEquals("CUSTOMER", actualApiUsageStateEntity.getEntityType());
    assertNull(actualApiUsageStateEntity.getId());
    assertNull(actualApiUsageStateEntity.getUuid());
    assertEquals(0L, actualApiUsageStateEntity.getCreatedTime());
    assertSame(entityId, actualApiUsageStateEntity.getTenantId());
  }

  /**
   * Test {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}.
   *
   * <p>Method under test: {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageStateEntity.<init>(ApiUsageState)"})
  public void testNewApiUsageStateEntity3() {
    // Arrange
    ApiUsageState ur = new ApiUsageState(new ApiUsageStateId(ModelConstants.NULL_UUID));
    ur.setTenantId(ModelConstants.SYSTEM_TENANT);
    ur.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    ApiUsageStateEntity actualApiUsageStateEntity = new ApiUsageStateEntity(ur);

    // Assert
    UUID id = actualApiUsageStateEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("CUSTOMER", actualApiUsageStateEntity.getEntityType());
    assertSame(id, actualApiUsageStateEntity.getUuid());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageStateEntity.<init>(ApiUsageState)"})
  public void testNewApiUsageStateEntity_givenOne_thenReturnCreatedTimeIsOne() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageStateEntity.<init>(ApiUsageState)"})
  public void testNewApiUsageStateEntity_thenReturnEntityTypeIsTenant() {
    // Arrange
    ApiUsageState ur = new ApiUsageState((ApiUsageStateId) null);
    ur.setTenantId(ModelConstants.SYSTEM_TENANT);
    ur.setEntityId(ModelConstants.SYSTEM_TENANT);

    // Act
    ApiUsageStateEntity actualApiUsageStateEntity = new ApiUsageStateEntity(ur);

    // Assert
    UUID entityId = actualApiUsageStateEntity.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.toString());
    assertEquals("TENANT", actualApiUsageStateEntity.getEntityType());
    assertNull(actualApiUsageStateEntity.getId());
    assertNull(actualApiUsageStateEntity.getUuid());
    assertEquals(0L, actualApiUsageStateEntity.getCreatedTime());
    assertSame(entityId, actualApiUsageStateEntity.getTenantId());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApiUsageStateEntity.<init>(ApiUsageState)"})
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
   *
   * <ul>
   *   <li>Given {@link ApiUsageStateEntity#ApiUsageStateEntity()}.
   *   <li>Then return UuidId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageState ApiUsageStateEntity.toData()"})
  public void testToData_givenApiUsageStateEntity_thenReturnUuidIdIsNull() {
    // Arrange and Act
    ApiUsageState actualToDataResult = new ApiUsageStateEntity().toData();

    // Assert
    assertNull(actualToDataResult.getUuidId());
    ApiUsageStateId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(id.isNullUid());
  }

  /**
   * Test {@link ApiUsageStateEntity#toData()}.
   *
   * <ul>
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageState ApiUsageStateEntity.toData()"})
  public void testToData_thenReturnNotTenantIdNullUid() {
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
    UUID tenantId = UUID.randomUUID();
    apiUsageStateEntity.setTenantId(tenantId);
    apiUsageStateEntity.setEntityId(null);

    // Act
    ApiUsageState actualToDataResult = apiUsageStateEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    ApiUsageStateId id = actualToDataResult.getId();
    assertTrue(id.isNullUid());
    assertSame(uuidId, id.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link ApiUsageStateEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ApiUsageState ApiUsageStateEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
    assertEquals(apiUsageStateEntity.hashCode(), apiUsageStateEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
    apiUsageStateEntity2.setAlarmExecState(null);
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
    assertEquals(apiUsageStateEntity.hashCode(), apiUsageStateEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
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
    apiUsageStateEntity2.setDbStorageState(null);
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
    assertEquals(apiUsageStateEntity.hashCode(), apiUsageStateEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
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
    apiUsageStateEntity2.setEmailExecState(null);
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
    assertEquals(apiUsageStateEntity.hashCode(), apiUsageStateEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
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
    apiUsageStateEntity2.setEntityId(null);
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
    assertEquals(apiUsageStateEntity.hashCode(), apiUsageStateEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
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
    apiUsageStateEntity2.setEntityType(null);
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
    assertEquals(apiUsageStateEntity.hashCode(), apiUsageStateEntity2.hashCode());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageStateEntity.equals(Object)",
    "int ApiUsageStateEntity.hashCode()"
  })
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualEntityId.toString());
    assertEquals(
        "ApiUsageStateEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, entityType=Entity Type, entityId"
            + "=13814000-1dd2-11b2-8080-808080808080, transportState=ENABLED, dbStorageState=ENABLED, reExecState=ENABLED,"
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
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageStateEntity.getTransportState());
    assertSame(tenantId, actualEntityId);
    assertSame(tenantId, actualTenantId);
  }
}
