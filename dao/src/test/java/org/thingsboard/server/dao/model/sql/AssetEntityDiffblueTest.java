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
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class AssetEntityDiffblueTest {
  /**
   * Test {@link AssetEntity#equals(Object)}, and {@link AssetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetEntity#equals(Object)}
   *   <li>{@link AssetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetEntity.equals(Object)", "int AssetEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity2.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity2.setCreatedTime(1L);
    assetEntity2.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetEntity2.setId(ModelConstants.NULL_UUID);
    assetEntity2.setLabel("Label");
    assetEntity2.setName("Name");
    assetEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetEntity2.setType("Type");
    assetEntity2.setUuid(ModelConstants.NULL_UUID);
    assetEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(assetEntity, assetEntity2);
    assertEquals(assetEntity.hashCode(), assetEntity2.hashCode());
  }

  /**
   * Test {@link AssetEntity#equals(Object)}, and {@link AssetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetEntity#equals(Object)}
   *   <li>{@link AssetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetEntity.equals(Object)", "int AssetEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    // Act and Assert
    assertEquals(assetEntity, assetEntity);
    int expectedHashCodeResult = assetEntity.hashCode();
    assertEquals(expectedHashCodeResult, assetEntity.hashCode());
  }

  /**
   * Test {@link AssetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetEntity.equals(Object)", "int AssetEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity2.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity2.setCreatedTime(1L);
    assetEntity2.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity2.setExternalId(ModelConstants.NULL_UUID);
    assetEntity2.setId(ModelConstants.NULL_UUID);
    assetEntity2.setLabel("Label");
    assetEntity2.setName("Name");
    assetEntity2.setTenantId(ModelConstants.NULL_UUID);
    assetEntity2.setType("Type");
    assetEntity2.setUuid(ModelConstants.NULL_UUID);
    assetEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetEntity, assetEntity2);
  }

  /**
   * Test {@link AssetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetEntity.equals(Object)", "int AssetEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetEntity, null);
  }

  /**
   * Test {@link AssetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetEntity.equals(Object)", "int AssetEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetEntity, "Different type to AssetEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetEntity#AssetEntity()}
   *   <li>{@link AssetEntity#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetEntity.<init>()", "java.lang.String AssetEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    AssetEntity actualAssetEntity = new AssetEntity();

    // Assert
    assertEquals("AssetEntity()", actualAssetEntity.toString());
    assertNull(actualAssetEntity.getAdditionalInfo());
    assertNull(actualAssetEntity.getVersion());
    assertNull(actualAssetEntity.getLabel());
    assertNull(actualAssetEntity.getName());
    assertNull(actualAssetEntity.getType());
    assertNull(actualAssetEntity.getId());
    assertNull(actualAssetEntity.getUuid());
    assertNull(actualAssetEntity.getAssetProfileId());
    assertNull(actualAssetEntity.getCustomerId());
    assertNull(actualAssetEntity.getExternalId());
    assertNull(actualAssetEntity.getTenantId());
    assertEquals(0L, actualAssetEntity.getCreatedTime());
  }

  /**
   * Test {@link AssetEntity#AssetEntity(Asset)}.
   *
   * <p>Method under test: {@link AssetEntity#AssetEntity(Asset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetEntity.<init>(Asset)"})
  public void testNewAssetEntity() {
    // Arrange
    Asset asset = new Asset(new Asset());
    asset.setTenantId(null);
    asset.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    asset.setAssetProfileId(null);
    asset.setExternalId(null);

    // Act
    AssetEntity actualAssetEntity = new AssetEntity(asset);

    // Assert
    UUID customerId = actualAssetEntity.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.toString());
    CustomerId customerId2 = actualAssetEntity.toData().getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertTrue(customerId2.isNullUid());
    assertSame(customerId, customerId2.getId());
  }

  /**
   * Test {@link AssetEntity#AssetEntity(Asset)}.
   *
   * <p>Method under test: {@link AssetEntity#AssetEntity(Asset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetEntity.<init>(Asset)"})
  public void testNewAssetEntity2() {
    // Arrange
    Asset asset = new Asset(new Asset());
    asset.setTenantId(null);
    asset.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    AssetProfileId assetProfileId = new AssetProfileId(ModelConstants.NULL_UUID);
    asset.setAssetProfileId(assetProfileId);
    asset.setExternalId(null);

    // Act
    AssetEntity actualAssetEntity = new AssetEntity(asset);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualAssetEntity.getAssetProfileId().toString());
    assertEquals(assetProfileId, actualAssetEntity.toData().getAssetProfileId());
  }

  /**
   * Test {@link AssetEntity#AssetEntity(Asset)}.
   *
   * <p>Method under test: {@link AssetEntity#AssetEntity(Asset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetEntity.<init>(Asset)"})
  public void testNewAssetEntity3() {
    // Arrange
    Asset asset = new Asset(new Asset());
    asset.setTenantId(null);
    asset.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    asset.setAssetProfileId(null);
    AssetId externalId = new AssetId(ModelConstants.NULL_UUID);
    asset.setExternalId(externalId);

    // Act
    AssetEntity actualAssetEntity = new AssetEntity(asset);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualAssetEntity.getExternalId().toString());
    assertEquals(externalId, actualAssetEntity.toData().getExternalId());
  }

  /**
   * Test {@link AssetEntity#AssetEntity(Asset)}.
   *
   * <ul>
   *   <li>Then return TenantId toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link AssetEntity#AssetEntity(Asset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetEntity.<init>(Asset)"})
  public void testNewAssetEntity_thenReturnTenantIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    Asset asset = new Asset(new Asset());
    asset.setTenantId(ModelConstants.SYSTEM_TENANT);
    asset.setCustomerId(null);
    asset.setAssetProfileId(null);
    asset.setExternalId(null);

    // Act
    AssetEntity actualAssetEntity = new AssetEntity(asset);

    // Assert
    UUID tenantId = actualAssetEntity.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.toString());
    TenantId tenantId2 = actualAssetEntity.toData().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AssetEntity#AssetEntity(Asset)}.
   *
   * <ul>
   *   <li>When {@link Asset#Asset()}.
   *   <li>Then toData AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link AssetEntity#AssetEntity(Asset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetEntity.<init>(Asset)"})
  public void testNewAssetEntity_whenAsset_thenToDataAdditionalInfoReturnNullNode() {
    // Arrange and Act
    AssetEntity actualAssetEntity = new AssetEntity(new Asset());

    // Assert
    assertTrue(actualAssetEntity.toData().getAdditionalInfo() instanceof NullNode);
    assertNull(actualAssetEntity.getAdditionalInfo());
  }

  /**
   * Test {@link AssetEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is randomUUID.
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link AssetEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset AssetEntity.toData()"})
  public void testToData_givenAssetEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setCreatedTime(1L);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);
    UUID tenantId = UUID.randomUUID();
    assetEntity.setTenantId(tenantId);
    assetEntity.setCustomerId(null);
    assetEntity.setAssetProfileId(null);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    Asset actualToDataResult = assetEntity.toData();

    // Assert
    AssetId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.ASSET, externalId.getEntityType());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualToDataResult.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AssetEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link AssetEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset AssetEntity.toData()"})
  public void testToData_givenAssetEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    Asset actualToDataResult = new AssetEntity().toData();

    // Assert
    assertTrue(actualToDataResult.getAdditionalInfo() instanceof NullNode);
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getLabel());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getUuidId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link AssetEntity#toData()}.
   *
   * <ul>
   *   <li>Then return AssetProfileId EntityType is {@code ASSET_PROFILE}.
   * </ul>
   *
   * <p>Method under test: {@link AssetEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset AssetEntity.toData()"})
  public void testToData_thenReturnAssetProfileIdEntityTypeIsAssetProfile() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setCreatedTime(1L);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);
    assetEntity.setTenantId(null);
    assetEntity.setCustomerId(null);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(null);

    // Act
    Asset actualToDataResult = assetEntity.toData();

    // Assert
    AssetProfileId assetProfileId = actualToDataResult.getAssetProfileId();
    assertEquals(EntityType.ASSET_PROFILE, assetProfileId.getEntityType());
    assertTrue(assetProfileId.isNullUid());
    assertTrue(actualToDataResult.getId().isNullUid());
  }

  /**
   * Test {@link AssetEntity#toData()}.
   *
   * <ul>
   *   <li>Then return CustomerId EntityType is {@code CUSTOMER}.
   * </ul>
   *
   * <p>Method under test: {@link AssetEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset AssetEntity.toData()"})
  public void testToData_thenReturnCustomerIdEntityTypeIsCustomer() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setCreatedTime(1L);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);
    assetEntity.setTenantId(null);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setAssetProfileId(null);
    assetEntity.setExternalId(null);

    // Act
    Asset actualToDataResult = assetEntity.toData();

    // Assert
    CustomerId customerId = actualToDataResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
    assertTrue(actualToDataResult.getId().isNullUid());
  }

  /**
   * Test {@link AssetEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId EntityType is {@code ASSET}.
   * </ul>
   *
   * <p>Method under test: {@link AssetEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset AssetEntity.toData()"})
  public void testToData_thenReturnExternalIdEntityTypeIsAsset() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setCreatedTime(1L);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);
    assetEntity.setTenantId(null);
    assetEntity.setCustomerId(null);
    assetEntity.setAssetProfileId(null);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    Asset actualToDataResult = assetEntity.toData();

    // Assert
    AssetId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.ASSET, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualToDataResult.getId());
  }

  /**
   * Test {@link AssetEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link AssetEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset AssetEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setCreatedTime(1L);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setCustomerId(null);
    assetEntity.setAssetProfileId(null);
    assetEntity.setExternalId(null);

    // Act and Assert
    TenantId tenantId = assetEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
