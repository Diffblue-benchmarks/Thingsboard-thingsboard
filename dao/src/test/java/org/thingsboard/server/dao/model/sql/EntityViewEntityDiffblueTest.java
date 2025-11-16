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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.objects.TelemetryEntityView;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class EntityViewEntityDiffblueTest {
  /**
   * Test {@link EntityViewEntity#equals(Object)}, and {@link EntityViewEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityViewEntity#equals(Object)}
   *   <li>{@link EntityViewEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityViewEntity.equals(Object)", "int EntityViewEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    EntityViewEntity entityViewEntity2 = new EntityViewEntity();
    entityViewEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity2.setCreatedTime(1L);
    entityViewEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity2.setEndTs(1L);
    entityViewEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity2.setEntityType(EntityType.TENANT);
    entityViewEntity2.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity2.setId(ModelConstants.NULL_UUID);
    entityViewEntity2.setKeys("Keys");
    entityViewEntity2.setName("Name");
    entityViewEntity2.setStartTs(1L);
    entityViewEntity2.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity2.setType("Type");
    entityViewEntity2.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(entityViewEntity, entityViewEntity2);
    assertEquals(entityViewEntity.hashCode(), entityViewEntity2.hashCode());
  }

  /**
   * Test {@link EntityViewEntity#equals(Object)}, and {@link EntityViewEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityViewEntity#equals(Object)}
   *   <li>{@link EntityViewEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityViewEntity.equals(Object)", "int EntityViewEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    // Act and Assert
    assertEquals(entityViewEntity, entityViewEntity);
    int expectedHashCodeResult = entityViewEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityViewEntity.hashCode());
  }

  /**
   * Test {@link EntityViewEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityViewEntity.equals(Object)", "int EntityViewEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    EntityViewEntity entityViewEntity2 = new EntityViewEntity();
    entityViewEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity2.setCreatedTime(1L);
    entityViewEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity2.setEndTs(1L);
    entityViewEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity2.setEntityType(EntityType.TENANT);
    entityViewEntity2.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity2.setId(ModelConstants.NULL_UUID);
    entityViewEntity2.setKeys("Keys");
    entityViewEntity2.setName("Name");
    entityViewEntity2.setStartTs(1L);
    entityViewEntity2.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity2.setType("Type");
    entityViewEntity2.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
  }

  /**
   * Test {@link EntityViewEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityViewEntity.equals(Object)", "int EntityViewEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(entityViewEntity, null);
  }

  /**
   * Test {@link EntityViewEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityViewEntity.equals(Object)", "int EntityViewEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(entityViewEntity, "Different type to EntityViewEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityViewEntity#EntityViewEntity()}
   *   <li>{@link EntityViewEntity#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityViewEntity.<init>()",
    "java.lang.String EntityViewEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityViewEntity actualEntityViewEntity = new EntityViewEntity();

    // Assert
    assertEquals("EntityViewEntity()", actualEntityViewEntity.toString());
    assertNull(actualEntityViewEntity.getAdditionalInfo());
    assertNull(actualEntityViewEntity.getVersion());
    assertNull(actualEntityViewEntity.getKeys());
    assertNull(actualEntityViewEntity.getName());
    assertNull(actualEntityViewEntity.getType());
    assertNull(actualEntityViewEntity.getId());
    assertNull(actualEntityViewEntity.getUuid());
    assertNull(actualEntityViewEntity.getCustomerId());
    assertNull(actualEntityViewEntity.getEntityId());
    assertNull(actualEntityViewEntity.getExternalId());
    assertNull(actualEntityViewEntity.getTenantId());
    assertNull(actualEntityViewEntity.getEntityType());
    assertEquals(0L, actualEntityViewEntity.getCreatedTime());
    assertEquals(0L, actualEntityViewEntity.getEndTs());
    assertEquals(0L, actualEntityViewEntity.getStartTs());
  }

  /**
   * Test {@link EntityViewEntity#EntityViewEntity(EntityView)}.
   *
   * <p>Method under test: {@link EntityViewEntity#EntityViewEntity(EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewEntity.<init>(EntityView)"})
  public void testNewEntityViewEntity() {
    // Arrange
    EntityView entityView = new EntityView();
    entityView.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    EntityViewEntity actualEntityViewEntity = new EntityViewEntity(entityView);

    // Assert
    UUID tenantId = actualEntityViewEntity.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.toString());
    TenantId tenantId2 = actualEntityViewEntity.toData().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link EntityViewEntity#EntityViewEntity(EntityView)}.
   *
   * <p>Method under test: {@link EntityViewEntity#EntityViewEntity(EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewEntity.<init>(EntityView)"})
  public void testNewEntityViewEntity2() {
    // Arrange
    EntityView entityView = new EntityView();
    entityView.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    EntityViewEntity actualEntityViewEntity = new EntityViewEntity(entityView);

    // Assert
    UUID customerId = actualEntityViewEntity.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.toString());
    CustomerId customerId2 = actualEntityViewEntity.toData().getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertTrue(customerId2.isNullUid());
    assertSame(customerId, customerId2.getId());
  }

  /**
   * Test {@link EntityViewEntity#EntityViewEntity(EntityView)}.
   *
   * <ul>
   *   <li>Then return Keys is {@code {"timeseries":null,"attributes":null}}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewEntity#EntityViewEntity(EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewEntity.<init>(EntityView)"})
  public void testNewEntityViewEntity_thenReturnKeysIsTimeseriesNullAttributesNull() {
    // Arrange
    EntityView entityView = new EntityView();
    TelemetryEntityView keys = new TelemetryEntityView();
    entityView.setKeys(keys);

    // Act
    EntityViewEntity actualEntityViewEntity = new EntityViewEntity(entityView);

    // Assert
    assertEquals("{\"timeseries\":null,\"attributes\":null}", actualEntityViewEntity.getKeys());
    assertEquals(keys, actualEntityViewEntity.toData().getKeys());
  }

  /**
   * Test {@link EntityViewEntity#EntityViewEntity(EntityView)}.
   *
   * <ul>
   *   <li>Then toData EntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewEntity#EntityViewEntity(EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewEntity.<init>(EntityView)"})
  public void testNewEntityViewEntity_thenToDataEntityIdReturnCustomerId() {
    // Arrange
    EntityView entityView = new EntityView();
    entityView.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    EntityViewEntity actualEntityViewEntity = new EntityViewEntity(entityView);

    // Assert
    EntityId entityId = actualEntityViewEntity.toData().getEntityId();
    assertTrue(entityId instanceof CustomerId);
    UUID entityId2 = actualEntityViewEntity.getEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId2.toString());
    assertEquals(EntityType.CUSTOMER, entityId.getEntityType());
    assertEquals(EntityType.CUSTOMER, actualEntityViewEntity.getEntityType());
    assertTrue(entityId.isNullUid());
    assertSame(entityId2, entityId.getId());
  }

  /**
   * Test {@link EntityViewEntity#EntityViewEntity(EntityView)}.
   *
   * <ul>
   *   <li>Then toData EntityId return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewEntity#EntityViewEntity(EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewEntity.<init>(EntityView)"})
  public void testNewEntityViewEntity_thenToDataEntityIdReturnTenantId() {
    // Arrange
    EntityView entityView = new EntityView();
    entityView.setEntityId(ModelConstants.SYSTEM_TENANT);

    // Act
    EntityViewEntity actualEntityViewEntity = new EntityViewEntity(entityView);

    // Assert
    EntityId entityId = actualEntityViewEntity.toData().getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertEquals(EntityType.TENANT, actualEntityViewEntity.getEntityType());
    assertTrue(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Test {@link EntityViewEntity#EntityViewEntity(EntityView)}.
   *
   * <ul>
   *   <li>When {@link EntityView#EntityView()}.
   *   <li>Then return Keys is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewEntity#EntityViewEntity(EntityView)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityViewEntity.<init>(EntityView)"})
  public void testNewEntityViewEntity_whenEntityView_thenReturnKeysIsNull() {
    // Arrange and Act
    EntityViewEntity actualEntityViewEntity = new EntityViewEntity(new EntityView());

    // Assert
    assertNull(actualEntityViewEntity.getKeys());
    assertNull(actualEntityViewEntity.getCustomerId());
    assertNull(actualEntityViewEntity.getEntityId());
    assertNull(actualEntityViewEntity.getTenantId());
    assertNull(actualEntityViewEntity.getEntityType());
    EntityView toDataResult = actualEntityViewEntity.toData();
    assertNull(toDataResult.getCustomerId());
    assertNull(toDataResult.getEntityId());
    assertNull(toDataResult.getTenantId());
    assertNull(toDataResult.getKeys());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} EntityType is {@code ASSET}.
   *   <li>Then EntityId return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewEntity.toData()"})
  public void testToData_givenEntityViewEntityEntityTypeIsAsset_thenEntityIdReturnAssetId()
      throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityType(EntityType.ASSET);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act and Assert
    EntityId entityId = entityViewEntity.toData().getEntityId();
    assertTrue(entityId instanceof AssetId);
    assertEquals(EntityType.ASSET, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} EntityType is {@code USER}.
   *   <li>Then EntityId return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewEntity.toData()"})
  public void testToData_givenEntityViewEntityEntityTypeIsUser_thenEntityIdReturnUserId()
      throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityType(EntityType.USER);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act and Assert
    EntityId entityId = entityViewEntity.toData().getEntityId();
    assertTrue(entityId instanceof UserId);
    assertEquals(EntityType.USER, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} Keys is {@code foo}.
   *   <li>Then return Keys is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewEntity.toData()"})
  public void testToData_givenEntityViewEntityKeysIsFoo_thenReturnKeysIsNull() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("foo");

    // Act
    EntityView actualToDataResult = entityViewEntity.toData();

    // Assert
    EntityId entityId = actualToDataResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertNull(actualToDataResult.getKeys());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, actualToDataResult.getTenantId());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewEntity.toData()"})
  public void testToData_givenEntityViewEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    EntityView actualToDataResult = new EntityViewEntity().toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getEntityId());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(0L, actualToDataResult.getEndTimeMs());
    assertEquals(0L, actualToDataResult.getStartTimeMs());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewEntity.toData()"})
  public void testToData_thenEntityIdReturnCustomerId() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityType(EntityType.CUSTOMER);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act
    EntityView actualToDataResult = entityViewEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getEntityId() instanceof CustomerId);
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   *
   * <ul>
   *   <li>Then EntityId return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewEntity.toData()"})
  public void testToData_thenEntityIdReturnDashboardId() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityType(EntityType.DASHBOARD);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act and Assert
    EntityId entityId = entityViewEntity.toData().getEntityId();
    assertTrue(entityId instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   *
   * <ul>
   *   <li>Then return EntityId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewEntity.toData()"})
  public void testToData_thenReturnEntityIdIdToStringIs138140001dd211b28080808080808080()
      throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act
    EntityView actualToDataResult = entityViewEntity.toData();

    // Assert
    EntityId entityId = actualToDataResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, actualToDataResult.getTenantId());
  }

  /**
   * Test {@link EntityViewEntity#toData()}.
   *
   * <ul>
   *   <li>Then return not EntityId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityView EntityViewEntity.toData()"})
  public void testToData_thenReturnNotEntityIdNullUid() throws JsonProcessingException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    UUID entityId = UUID.randomUUID();
    entityViewEntity.setEntityId(entityId);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);

    JsonMapper jsonMapper = JsonMapper.builder().findAndAddModules().build();
    entityViewEntity.setKeys(jsonMapper.writeValueAsString(new TelemetryEntityView()));

    // Act and Assert
    EntityId entityId2 = entityViewEntity.toData().getEntityId();
    assertTrue(entityId2 instanceof TenantId);
    assertEquals(EntityType.TENANT, entityId2.getEntityType());
    assertFalse(entityId2.isNullUid());
    assertFalse(((TenantId) entityId2).isSysTenantId());
    assertSame(entityId, entityId2.getId());
  }
}
