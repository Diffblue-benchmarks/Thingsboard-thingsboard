package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

class AbstractAssetEntityDiffblueTest {
  /**
   * Test {@link AbstractAssetEntity#toAsset()}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAssetEntity#toAsset()}
   */
  @Test
  @DisplayName(
      "Test toAsset(); given AssetEntity() TenantId is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset AbstractAssetEntity.toAsset()"})
  void testToAsset_givenAssetEntityTenantIdIsFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetEntity.setCustomerId(customerId);
    UUID assetProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetEntity.setAssetProfileId(assetProfileId);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetEntity.setExternalId(externalId);

    // Act
    Asset actualToAssetResult = assetEntity.toAsset();

    // Assert
    AssetId externalId2 = actualToAssetResult.getExternalId();
    assertEquals(EntityType.ASSET, externalId2.getEntityType());
    AssetProfileId assetProfileId2 = actualToAssetResult.getAssetProfileId();
    assertEquals(EntityType.ASSET_PROFILE, assetProfileId2.getEntityType());
    CustomerId customerId2 = actualToAssetResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    TenantId tenantId = actualToAssetResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(assetProfileId2.isNullUid());
    assertFalse(customerId2.isNullUid());
    assertFalse(externalId2.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(assetProfileId, assetProfileId2.getId());
    assertSame(customerId, customerId2.getId());
    assertSame(externalId, externalId2.getId());
  }

  /**
   * Test {@link AbstractAssetEntity#toAsset()}.
   *
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()}.
   *   <li>Then return ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAssetEntity#toAsset()}
   */
  @Test
  @DisplayName("Test toAsset(); given AssetEntity(); then return ExternalId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset AbstractAssetEntity.toAsset()"})
  void testToAsset_givenAssetEntity_thenReturnExternalIdIsNull() {
    // Arrange and Act
    Asset actualToAssetResult = new AssetEntity().toAsset();

    // Assert
    assertNull(actualToAssetResult.getExternalId());
    assertNull(actualToAssetResult.getAssetProfileId());
    assertNull(actualToAssetResult.getCustomerId());
    assertNull(actualToAssetResult.getTenantId());
  }

  /**
   * Test {@link AbstractAssetEntity#toAsset()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAssetEntity#toAsset()}
   */
  @Test
  @DisplayName("Test toAsset(); then return TenantId Id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset AbstractAssetEntity.toAsset()"})
  void testToAsset_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    UUID tenantId = UUID.randomUUID();
    assetEntity.setTenantId(tenantId);
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetEntity.setCustomerId(customerId);
    UUID assetProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetEntity.setAssetProfileId(assetProfileId);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetEntity.setExternalId(externalId);

    // Act
    Asset actualToAssetResult = assetEntity.toAsset();

    // Assert
    AssetId externalId2 = actualToAssetResult.getExternalId();
    assertEquals(EntityType.ASSET, externalId2.getEntityType());
    AssetProfileId assetProfileId2 = actualToAssetResult.getAssetProfileId();
    assertEquals(EntityType.ASSET_PROFILE, assetProfileId2.getEntityType());
    CustomerId customerId2 = actualToAssetResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    TenantId tenantId2 = actualToAssetResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(assetProfileId2.isNullUid());
    assertFalse(customerId2.isNullUid());
    assertFalse(externalId2.isNullUid());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(assetProfileId, assetProfileId2.getId());
    assertSame(customerId, customerId2.getId());
    assertSame(externalId, externalId2.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AbstractAssetEntity#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link AssetEntity#AssetEntity()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAssetEntity#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when AssetEntity(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractAssetEntity.canEqual(Object)"})
  void testCanEqual_whenAssetEntity_thenReturnTrue() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    // Act and Assert
    assertTrue(assetEntity.canEqual(new AssetEntity()));
  }

  /**
   * Test {@link AbstractAssetEntity#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAssetEntity#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractAssetEntity.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new AssetEntity().canEqual("Other"));
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}, and {@link AbstractAssetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    AssetEntity assetEntity2 = new AssetEntity();

    // Act and Assert
    assertEquals(assetEntity, assetEntity2);
    assertEquals(assetEntity.hashCode(), assetEntity2.hashCode());
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}, and {@link AbstractAssetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    // Act and Assert
    assertEquals(assetEntity, assetEntity);
    int expectedHashCodeResult = assetEntity.hashCode();
    assertEquals(expectedHashCodeResult, assetEntity.hashCode());
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    adminSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(assetEntity, adminSettingsEntity);
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AssetEntity assetEntity2 = mock(AssetEntity.class);
    when(assetEntity2.getVersion()).thenReturn(1L);
    when(assetEntity2.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(assetEntity2.getCreatedTime()).thenReturn(1L);
    when(assetEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(assetEntity, assetEntity2);
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetEntity(), null);
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetEntity(), "Different type to AbstractAssetEntity");
  }

  /**
   * Test {@link AbstractAssetEntity#getAdditionalInfo()}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode AbstractAssetEntity.getAdditionalInfo()"})
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getAdditionalInfo());
  }

  /**
   * Test {@link AbstractAssetEntity#getAssetProfileId()}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#getAssetProfileId()}
   */
  @Test
  @DisplayName("Test getAssetProfileId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractAssetEntity.getAssetProfileId()"})
  void testGetAssetProfileId() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getAssetProfileId());
  }

  /**
   * Test {@link AbstractAssetEntity#getCustomerId()}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#getCustomerId()}
   */
  @Test
  @DisplayName("Test getCustomerId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractAssetEntity.getCustomerId()"})
  void testGetCustomerId() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getCustomerId());
  }

  /**
   * Test {@link AbstractAssetEntity#getExternalId()}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractAssetEntity.getExternalId()"})
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getExternalId());
  }

  /**
   * Test {@link AbstractAssetEntity#getLabel()}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#getLabel()}
   */
  @Test
  @DisplayName("Test getLabel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractAssetEntity.getLabel()"})
  void testGetLabel() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getLabel());
  }

  /**
   * Test {@link AbstractAssetEntity#getName()}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractAssetEntity.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getName());
  }

  /**
   * Test {@link AbstractAssetEntity#getTenantId()}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractAssetEntity.getTenantId()"})
  void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getTenantId());
  }

  /**
   * Test {@link AbstractAssetEntity#getType()}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractAssetEntity.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getType());
  }

  /**
   * Test {@link AbstractAssetEntity#setAdditionalInfo(JsonNode)}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#setAdditionalInfo(JsonNode)}
   */
  @Test
  @DisplayName("Test setAdditionalInfo(JsonNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAssetEntity.setAdditionalInfo(JsonNode)"})
  void testSetAdditionalInfo() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    assetEntity.setAdditionalInfo(additionalInfo);

    // Assert
    assertSame(additionalInfo, assetEntity.toData().getAdditionalInfo());
    assertSame(additionalInfo, assetEntity.getAdditionalInfo());
  }

  /**
   * Test {@link AbstractAssetEntity#setAssetProfileId(UUID)}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#setAssetProfileId(UUID)}
   */
  @Test
  @DisplayName("Test setAssetProfileId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAssetEntity.setAssetProfileId(UUID)"})
  void testSetAssetProfileId() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    UUID assetProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    assetEntity.setAssetProfileId(assetProfileId);

    // Assert
    AssetProfileId assetProfileId2 = assetEntity.toData().getAssetProfileId();
    assertEquals(EntityType.ASSET_PROFILE, assetProfileId2.getEntityType());
    assertFalse(assetProfileId2.isNullUid());
    assertSame(assetProfileId, assetProfileId2.getId());
    assertSame(assetProfileId, assetEntity.getAssetProfileId());
  }

  /**
   * Test {@link AbstractAssetEntity#setCustomerId(UUID)}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#setCustomerId(UUID)}
   */
  @Test
  @DisplayName("Test setCustomerId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAssetEntity.setCustomerId(UUID)"})
  void testSetCustomerId() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    assetEntity.setCustomerId(customerId);

    // Assert
    CustomerId customerId2 = assetEntity.toData().getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertSame(customerId, customerId2.getId());
    assertSame(customerId, assetEntity.getCustomerId());
  }

  /**
   * Test {@link AbstractAssetEntity#setExternalId(UUID)}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#setExternalId(UUID)}
   */
  @Test
  @DisplayName("Test setExternalId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAssetEntity.setExternalId(UUID)"})
  void testSetExternalId() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    assetEntity.setExternalId(externalId);

    // Assert
    AssetId externalId2 = assetEntity.toData().getExternalId();
    assertEquals(EntityType.ASSET, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertSame(externalId, externalId2.getId());
    assertSame(externalId, assetEntity.getExternalId());
  }

  /**
   * Test {@link AbstractAssetEntity#setLabel(String)}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#setLabel(String)}
   */
  @Test
  @DisplayName("Test setLabel(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAssetEntity.setLabel(String)"})
  void testSetLabel() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    // Act
    assetEntity.setLabel("Label");

    // Assert
    assertEquals("Label", assetEntity.toData().getLabel());
    assertEquals("Label", assetEntity.getLabel());
  }

  /**
   * Test {@link AbstractAssetEntity#setName(String)}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAssetEntity.setName(String)"})
  void testSetName() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    // Act
    assetEntity.setName("Name");

    // Assert
    assertEquals("Name", assetEntity.toData().getName());
    assertEquals("Name", assetEntity.getName());
  }

  /**
   * Test {@link AbstractAssetEntity#setTenantId(UUID)}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#setTenantId(UUID)}
   */
  @Test
  @DisplayName("Test setTenantId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAssetEntity.setTenantId(UUID)"})
  void testSetTenantId() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    assetEntity.setTenantId(tenantId);

    // Assert
    TenantId tenantId2 = assetEntity.toData().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId2.getId().toString());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, assetEntity.getTenantId());
  }

  /**
   * Test {@link AbstractAssetEntity#setType(String)}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#setType(String)}
   */
  @Test
  @DisplayName("Test setType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractAssetEntity.setType(String)"})
  void testSetType() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    // Act
    assetEntity.setType("Type");

    // Assert
    assertEquals("Type", assetEntity.toData().getType());
    assertEquals("Type", assetEntity.getType());
  }

  /**
   * Test {@link AbstractAssetEntity#toString()}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractAssetEntity.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("AssetEntity()", new AssetEntity().toString());
  }
}
