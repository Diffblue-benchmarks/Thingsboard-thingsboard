package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
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

class AbstractAssetEntityDiffblueTest {
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
  @Tag("MaintainedByDiffblue")
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
   *   <li>Then return AssetProfileId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAssetEntity#toAsset()}
   */
  @Test
  @DisplayName(
      "Test toAsset(); then return AssetProfileId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Asset AbstractAssetEntity.toAsset()"})
  void testToAsset_thenReturnAssetProfileIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setTenantId(null);
    assetEntity.setCustomerId(null);
    UUID assetProfileId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetEntity.setAssetProfileId(assetProfileId);
    assetEntity.setExternalId(null);

    // Act and Assert
    AssetProfileId assetProfileId2 = assetEntity.toAsset().getAssetProfileId();
    UUID id = assetProfileId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ASSET_PROFILE, assetProfileId2.getEntityType());
    assertFalse(assetProfileId2.isNullUid());
    assertSame(assetProfileId, id);
  }

  /**
   * Test {@link AbstractAssetEntity#toAsset()}.
   *
   * <ul>
   *   <li>Then return CustomerId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAssetEntity#toAsset()}
   */
  @Test
  @DisplayName(
      "Test toAsset(); then return CustomerId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Asset AbstractAssetEntity.toAsset()"})
  void testToAsset_thenReturnCustomerIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setTenantId(null);
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetEntity.setCustomerId(customerId);
    assetEntity.setAssetProfileId(null);
    assetEntity.setExternalId(null);

    // Act and Assert
    CustomerId customerId2 = assetEntity.toAsset().getCustomerId();
    UUID id = customerId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertSame(customerId, id);
  }

  /**
   * Test {@link AbstractAssetEntity#toAsset()}.
   *
   * <ul>
   *   <li>Then return ExternalId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAssetEntity#toAsset()}
   */
  @Test
  @DisplayName(
      "Test toAsset(); then return ExternalId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Asset AbstractAssetEntity.toAsset()"})
  void testToAsset_thenReturnExternalIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setTenantId(null);
    assetEntity.setCustomerId(null);
    assetEntity.setAssetProfileId(null);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetEntity.setExternalId(externalId);

    // Act and Assert
    AssetId externalId2 = assetEntity.toAsset().getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ASSET, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertSame(externalId, id);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Asset AbstractAssetEntity.toAsset()"})
  void testToAsset_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    UUID tenantId = UUID.randomUUID();
    assetEntity.setTenantId(tenantId);
    assetEntity.setCustomerId(null);
    assetEntity.setAssetProfileId(null);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    assetEntity.setExternalId(externalId);

    // Act
    Asset actualToAssetResult = assetEntity.toAsset();

    // Assert
    AssetId externalId2 = actualToAssetResult.getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.ASSET, externalId2.getEntityType());
    TenantId tenantId2 = actualToAssetResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(externalId, id);
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AbstractAssetEntity#toAsset()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractAssetEntity#toAsset()}
   */
  @Test
  @DisplayName(
      "Test toAsset(); then return TenantId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Asset AbstractAssetEntity.toAsset()"})
  void testToAsset_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    assetEntity.setCustomerId(null);
    assetEntity.setAssetProfileId(null);
    assetEntity.setExternalId(null);

    // Act and Assert
    TenantId tenantId = assetEntity.toAsset().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
    int expectedHashCodeResult = assetEntity.hashCode();
    assertEquals(expectedHashCodeResult, assetEntity2.hashCode());
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(assetEntity, new AssetEntity());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(assetEntity, new AssetEntity());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setName("Name");

    // Act and Assert
    assertNotEquals(assetEntity, new AssetEntity());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setType("Type");

    // Act and Assert
    assertNotEquals(assetEntity, new AssetEntity());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setLabel("Label");

    // Act and Assert
    assertNotEquals(assetEntity, new AssetEntity());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(assetEntity, new AssetEntity());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(assetEntity, new AssetEntity());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(assetEntity, new AssetEntity());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetEntity, new AssetEntity());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(assetEntity, assetEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setCustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(assetEntity, assetEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setName("Name");

    // Act and Assert
    assertNotEquals(assetEntity, assetEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setType("Type");

    // Act and Assert
    assertNotEquals(assetEntity, assetEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setLabel("Label");

    // Act and Assert
    assertNotEquals(assetEntity, assetEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(assetEntity, assetEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setAssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(assetEntity, assetEntity2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractAssetEntity.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("AssetEntity()", new AssetEntity().toString());
  }
}
