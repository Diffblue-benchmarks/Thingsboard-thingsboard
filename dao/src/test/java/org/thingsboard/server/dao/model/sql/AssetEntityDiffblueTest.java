package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

class AssetEntityDiffblueTest {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetEntity.equals(Object)", "int AssetEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setType("Type");
    assetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setVersion(1L);

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity2.setAssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity2.setCreatedTime(1L);
    assetEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity2.setLabel("Label");
    assetEntity2.setName("Name");
    assetEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity2.setType("Type");
    assetEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(assetEntity, assetEntity2);
    int expectedHashCodeResult = assetEntity.hashCode();
    assertEquals(expectedHashCodeResult, assetEntity2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetEntity.equals(Object)", "int AssetEntity.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setType("Type");
    assetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetEntity.equals(Object)", "int AssetEntity.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(DoubleNode.valueOf(10.0d));
    assetEntity.setAssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setType("Type");
    assetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setVersion(1L);

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity2.setAssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity2.setCreatedTime(1L);
    assetEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity2.setLabel("Label");
    assetEntity2.setName("Name");
    assetEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity2.setType("Type");
    assetEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetEntity.equals(Object)", "int AssetEntity.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setType("Type");
    assetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AssetEntity.equals(Object)", "int AssetEntity.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setType("Type");
    assetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetEntity.<init>()", "java.lang.String AssetEntity.toString()"})
  void testGettersAndSetters() {
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
  @DisplayName("Test new AssetEntity(Asset)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetEntity.<init>(Asset)"})
  void testNewAssetEntity() {
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
  @DisplayName("Test new AssetEntity(Asset)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetEntity.<init>(Asset)"})
  void testNewAssetEntity2() {
    // Arrange
    Asset asset = new Asset(new Asset());
    asset.setTenantId(null);
    asset.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    AssetProfileId assetProfileId = new AssetProfileId(id);
    asset.setAssetProfileId(assetProfileId);
    asset.setExternalId(null);

    // Act
    AssetEntity actualAssetEntity = new AssetEntity(asset);

    // Assert
    UUID assetProfileId2 = actualAssetEntity.getAssetProfileId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", assetProfileId2.toString());
    assertEquals(assetProfileId, actualAssetEntity.toData().getAssetProfileId());
    assertSame(id, assetProfileId2);
  }

  /**
   * Test {@link AssetEntity#AssetEntity(Asset)}.
   *
   * <p>Method under test: {@link AssetEntity#AssetEntity(Asset)}
   */
  @Test
  @DisplayName("Test new AssetEntity(Asset)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetEntity.<init>(Asset)"})
  void testNewAssetEntity3() {
    // Arrange
    Asset asset = new Asset(new Asset());
    asset.setTenantId(null);
    asset.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    asset.setAssetProfileId(null);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    AssetId externalId = new AssetId(id);
    asset.setExternalId(externalId);

    // Act
    AssetEntity actualAssetEntity = new AssetEntity(asset);

    // Assert
    UUID externalId2 = actualAssetEntity.getExternalId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", externalId2.toString());
    assertEquals(externalId, actualAssetEntity.toData().getExternalId());
    assertSame(id, externalId2);
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
  @DisplayName(
      "Test new AssetEntity(Asset); then return TenantId toString is '13814000-1dd2-11b2-8080-808080808080'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetEntity.<init>(Asset)"})
  void testNewAssetEntity_thenReturnTenantIdToStringIs138140001dd211b28080808080808080() {
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
  @DisplayName(
      "Test new AssetEntity(Asset); when Asset(); then toData AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetEntity.<init>(Asset)"})
  void testNewAssetEntity_whenAsset_thenToDataAdditionalInfoReturnNullNode() {
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
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link AssetEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given AssetEntity() TenantId is randomUUID; then return TenantId Id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Asset AssetEntity.toData()"})
  void testToData_givenAssetEntityTenantIdIsRandomUUID_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setCreatedTime(1L);
    assetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setType("Type");
    assetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setVersion(1L);
    UUID tenantId = UUID.randomUUID();
    assetEntity.setTenantId(tenantId);
    assetEntity.setCustomerId(null);
    assetEntity.setAssetProfileId(null);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetEntity.setExternalId(externalId);

    // Act
    Asset actualToDataResult = assetEntity.toData();

    // Assert
    AssetId externalId2 = actualToDataResult.getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ASSET, externalId2.getEntityType());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertEquals(externalId2, actualToDataResult.getId());
    assertSame(externalId, id);
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
  @DisplayName("Test toData(); given AssetEntity(); then AdditionalInfo return NullNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Asset AssetEntity.toData()"})
  void testToData_givenAssetEntity_thenAdditionalInfoReturnNullNode() {
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
   *   <li>Then return AssetProfileId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AssetEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return AssetProfileId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Asset AssetEntity.toData()"})
  void testToData_thenReturnAssetProfileIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setCreatedTime(1L);
    assetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setType("Type");
    assetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setVersion(1L);
    assetEntity.setTenantId(null);
    assetEntity.setCustomerId(null);
    UUID assetProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetEntity.setAssetProfileId(assetProfileId);
    assetEntity.setExternalId(null);

    // Act and Assert
    AssetProfileId assetProfileId2 = assetEntity.toData().getAssetProfileId();
    UUID id = assetProfileId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ASSET_PROFILE, assetProfileId2.getEntityType());
    assertFalse(assetProfileId2.isNullUid());
    assertSame(assetProfileId, id);
  }

  /**
   * Test {@link AssetEntity#toData()}.
   *
   * <ul>
   *   <li>Then return CustomerId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AssetEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return CustomerId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Asset AssetEntity.toData()"})
  void testToData_thenReturnCustomerIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setCreatedTime(1L);
    assetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setType("Type");
    assetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setVersion(1L);
    assetEntity.setTenantId(null);
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetEntity.setCustomerId(customerId);
    assetEntity.setAssetProfileId(null);
    assetEntity.setExternalId(null);

    // Act and Assert
    CustomerId customerId2 = assetEntity.toData().getCustomerId();
    UUID id = customerId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertSame(customerId, id);
  }

  /**
   * Test {@link AssetEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AssetEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return ExternalId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Asset AssetEntity.toData()"})
  void testToData_thenReturnExternalIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setCreatedTime(1L);
    assetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setType("Type");
    assetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setVersion(1L);
    assetEntity.setTenantId(null);
    assetEntity.setCustomerId(null);
    assetEntity.setAssetProfileId(null);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetEntity.setExternalId(externalId);

    // Act
    Asset actualToDataResult = assetEntity.toData();

    // Assert
    AssetId externalId2 = actualToDataResult.getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ASSET, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertEquals(externalId2, actualToDataResult.getId());
    assertSame(externalId, id);
  }

  /**
   * Test {@link AssetEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AssetEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return TenantId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Asset AssetEntity.toData()"})
  void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setCreatedTime(1L);
    assetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setType("Type");
    assetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setVersion(1L);
    assetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setCustomerId(null);
    assetEntity.setAssetProfileId(null);
    assetEntity.setExternalId(null);

    // Act and Assert
    TenantId tenantId = assetEntity.toData().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }
}
