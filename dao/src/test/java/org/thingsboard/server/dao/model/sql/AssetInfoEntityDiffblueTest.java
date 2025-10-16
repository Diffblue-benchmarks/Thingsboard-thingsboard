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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.AssetInfo;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class AssetInfoEntityDiffblueTest {
  /**
   * Test {@link AssetInfoEntity#equals(Object)}, and {@link AssetInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetInfoEntity#equals(Object)}
   *   <li>{@link AssetInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();

    // Act and Assert
    assertEquals(assetInfoEntity, assetInfoEntity2);
    assertEquals(assetInfoEntity.hashCode(), assetInfoEntity2.hashCode());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}, and {@link AssetInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetInfoEntity#equals(Object)}
   *   <li>{@link AssetInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setCustomerTitle("Dr");

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setCustomerTitle("Dr");

    // Act and Assert
    assertEquals(assetInfoEntity, assetInfoEntity2);
    assertEquals(assetInfoEntity.hashCode(), assetInfoEntity2.hashCode());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}, and {@link AssetInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetInfoEntity#equals(Object)}
   *   <li>{@link AssetInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setAssetProfileName("foo.txt");

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setAssetProfileName("foo.txt");

    // Act and Assert
    assertEquals(assetInfoEntity, assetInfoEntity2);
    assertEquals(assetInfoEntity.hashCode(), assetInfoEntity2.hashCode());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}, and {@link AssetInfoEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetInfoEntity#equals(Object)}
   *   <li>{@link AssetInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();

    // Act and Assert
    assertEquals(assetInfoEntity, assetInfoEntity);
    int expectedHashCodeResult = assetInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, assetInfoEntity.hashCode());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();

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
    assertNotEquals(assetInfoEntity, assetEntity);
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(assetInfoEntity, new AssetInfoEntity());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setCustomerIsPublic(true);

    // Act and Assert
    assertNotEquals(assetInfoEntity, new AssetInfoEntity());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setAssetProfileName("foo.txt");

    // Act and Assert
    assertNotEquals(assetInfoEntity, new AssetInfoEntity());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(assetInfoEntity, new AssetInfoEntity());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(assetInfoEntity, assetInfoEntity2);
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setAssetProfileName("foo.txt");

    // Act and Assert
    assertNotEquals(assetInfoEntity, assetInfoEntity2);
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetInfoEntity(), null);
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetInfoEntity(), "Different type to AssetInfoEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetInfoEntity#AssetInfoEntity()}
   *   <li>{@link AssetInfoEntity#setAssetProfileName(String)}
   *   <li>{@link AssetInfoEntity#setCustomerIsPublic(boolean)}
   *   <li>{@link AssetInfoEntity#setCustomerTitle(String)}
   *   <li>{@link AssetInfoEntity#toString()}
   *   <li>{@link AssetInfoEntity#getAssetProfileName()}
   *   <li>{@link AssetInfoEntity#getCustomerTitle()}
   *   <li>{@link AssetInfoEntity#isCustomerIsPublic()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AssetInfoEntity.<init>()",
    "String AssetInfoEntity.getAssetProfileName()",
    "String AssetInfoEntity.getCustomerTitle()",
    "boolean AssetInfoEntity.isCustomerIsPublic()",
    "void AssetInfoEntity.setAssetProfileName(String)",
    "void AssetInfoEntity.setCustomerIsPublic(boolean)",
    "void AssetInfoEntity.setCustomerTitle(String)",
    "String AssetInfoEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    AssetInfoEntity actualAssetInfoEntity = new AssetInfoEntity();
    actualAssetInfoEntity.setAssetProfileName("foo.txt");
    actualAssetInfoEntity.setCustomerIsPublic(true);
    actualAssetInfoEntity.setCustomerTitle("Dr");
    String actualToStringResult = actualAssetInfoEntity.toString();
    String actualAssetProfileName = actualAssetInfoEntity.getAssetProfileName();
    String actualCustomerTitle = actualAssetInfoEntity.getCustomerTitle();
    boolean actualIsCustomerIsPublicResult = actualAssetInfoEntity.isCustomerIsPublic();

    // Assert
    assertEquals(
        "AssetInfoEntity(customerTitle=Dr, customerIsPublic=true, assetProfileName=foo.txt)",
        actualToStringResult);
    assertEquals("Dr", actualCustomerTitle);
    assertEquals("foo.txt", actualAssetProfileName);
    assertNull(actualAssetInfoEntity.getAdditionalInfo());
    assertNull(actualAssetInfoEntity.getVersion());
    assertNull(actualAssetInfoEntity.getLabel());
    assertNull(actualAssetInfoEntity.getName());
    assertNull(actualAssetInfoEntity.getType());
    assertNull(actualAssetInfoEntity.getId());
    assertNull(actualAssetInfoEntity.getUuid());
    assertNull(actualAssetInfoEntity.getAssetProfileId());
    assertNull(actualAssetInfoEntity.getCustomerId());
    assertNull(actualAssetInfoEntity.getExternalId());
    assertNull(actualAssetInfoEntity.getTenantId());
    assertEquals(0L, actualAssetInfoEntity.getCreatedTime());
    assertTrue(actualIsCustomerIsPublicResult);
  }

  /**
   * Test {@link AssetInfoEntity#AssetInfoEntity(AssetEntity, String, Object, String)}.
   *
   * <p>Method under test: {@link AssetInfoEntity#AssetInfoEntity(AssetEntity, String, Object,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetInfoEntity.<init>(AssetEntity, String, Object, String)"})
  public void testNewAssetInfoEntity() {
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

    // Act
    AssetInfoEntity actualAssetInfoEntity = new AssetInfoEntity(assetEntity, "Dr", null, "foo.txt");

    // Assert
    assertTrue(actualAssetInfoEntity.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("Dr", actualAssetInfoEntity.getCustomerTitle());
    assertEquals("Label", actualAssetInfoEntity.getLabel());
    assertEquals("Name", actualAssetInfoEntity.getName());
    assertEquals("Type", actualAssetInfoEntity.getType());
    assertEquals("foo.txt", actualAssetInfoEntity.getAssetProfileName());
    assertEquals(1L, actualAssetInfoEntity.getVersion().longValue());
    assertEquals(1L, actualAssetInfoEntity.getCreatedTime());
    assertFalse(actualAssetInfoEntity.isCustomerIsPublic());
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AssetInfoEntity#AssetInfoEntity()} TenantId is randomUUID.
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  public void testToData_givenAssetInfoEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    UUID tenantId = UUID.randomUUID();
    assetInfoEntity.setTenantId(tenantId);

    // Act and Assert
    TenantId tenantId2 = assetInfoEntity.toData().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link AssetInfoEntity#AssetInfoEntity()}.
   *   <li>Then AdditionalInfo return {@link NullNode}.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  public void testToData_givenAssetInfoEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    AssetInfo actualToDataResult = new AssetInfoEntity().toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getAssetProfileId());
    assertNull(actualToDataResult.getCustomerId());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isMissingNode());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return AdditionalInfo is Instance.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  public void testToData_thenReturnAdditionalInfoIsInstance() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    MissingNode additionalInfo = MissingNode.getInstance();
    assetInfoEntity.setAdditionalInfo(additionalInfo);

    // Act and Assert
    assertSame(additionalInfo, assetInfoEntity.toData().getAdditionalInfo());
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return AssetProfileId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  public void testToData_thenReturnAssetProfileIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setAssetProfileId(ModelConstants.NULL_UUID);

    // Act
    AssetInfo actualToDataResult = assetInfoEntity.toData();

    // Assert
    AssetProfileId assetProfileId = actualToDataResult.getAssetProfileId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", assetProfileId.getId().toString());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.ASSET_PROFILE, assetProfileId.getEntityType());
    assertTrue(assetProfileId.isNullUid());
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return CustomerId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  public void testToData_thenReturnCustomerIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setCustomerId(ModelConstants.NULL_UUID);

    // Act
    AssetInfo actualToDataResult = assetInfoEntity.toData();

    // Assert
    CustomerId customerId = actualToDataResult.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.getId().toString());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  public void testToData_thenReturnExternalIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    AssetInfo actualToDataResult = assetInfoEntity.toData();

    // Assert
    AssetId externalId = actualToDataResult.getExternalId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", externalId.getId().toString());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.ASSET, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo AssetInfoEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    TenantId tenantId = assetInfoEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
