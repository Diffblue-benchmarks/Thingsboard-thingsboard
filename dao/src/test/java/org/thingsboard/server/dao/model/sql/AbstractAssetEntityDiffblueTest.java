package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
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

public class AbstractAssetEntityDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Asset AbstractAssetEntity.toAsset()"})
  public void testToAsset_givenAssetEntity_thenReturnExternalIdIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Asset AbstractAssetEntity.toAsset()"})
  public void testToAsset_thenReturnAssetProfileIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Asset AbstractAssetEntity.toAsset()"})
  public void testToAsset_thenReturnCustomerIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Asset AbstractAssetEntity.toAsset()"})
  public void testToAsset_thenReturnExternalIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Asset AbstractAssetEntity.toAsset()"})
  public void testToAsset_thenReturnTenantIdIdIsRandomUUID() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Asset AbstractAssetEntity.toAsset()"})
  public void testToAsset_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractAssetEntity.canEqual(Object)"})
  public void testCanEqual_whenAssetEntity_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractAssetEntity.canEqual(Object)"})
  public void testCanEqual_whenOther_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AbstractAssetEntity.equals(Object)",
    "int AbstractAssetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetEntity(), "Different type to AbstractAssetEntity");
  }

  /**
   * Test {@link AbstractAssetEntity#getAdditionalInfo()}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#getAdditionalInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"JsonNode AbstractAssetEntity.getAdditionalInfo()"})
  public void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getAdditionalInfo());
  }

  /**
   * Test {@link AbstractAssetEntity#getAssetProfileId()}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#getAssetProfileId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UUID AbstractAssetEntity.getAssetProfileId()"})
  public void testGetAssetProfileId() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getAssetProfileId());
  }

  /**
   * Test {@link AbstractAssetEntity#getCustomerId()}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#getCustomerId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UUID AbstractAssetEntity.getCustomerId()"})
  public void testGetCustomerId() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getCustomerId());
  }

  /**
   * Test {@link AbstractAssetEntity#getExternalId()}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#getExternalId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UUID AbstractAssetEntity.getExternalId()"})
  public void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getExternalId());
  }

  /**
   * Test {@link AbstractAssetEntity#getLabel()}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#getLabel()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractAssetEntity.getLabel()"})
  public void testGetLabel() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getLabel());
  }

  /**
   * Test {@link AbstractAssetEntity#getName()}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractAssetEntity.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getName());
  }

  /**
   * Test {@link AbstractAssetEntity#getTenantId()}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#getTenantId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UUID AbstractAssetEntity.getTenantId()"})
  public void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getTenantId());
  }

  /**
   * Test {@link AbstractAssetEntity#getType()}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#getType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractAssetEntity.getType()"})
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull(new AssetEntity().getType());
  }

  /**
   * Test {@link AbstractAssetEntity#setAdditionalInfo(JsonNode)}.
   *
   * <p>Method under test: {@link AbstractAssetEntity#setAdditionalInfo(JsonNode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractAssetEntity.setAdditionalInfo(JsonNode)"})
  public void testSetAdditionalInfo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractAssetEntity.setAssetProfileId(UUID)"})
  public void testSetAssetProfileId() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractAssetEntity.setCustomerId(UUID)"})
  public void testSetCustomerId() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractAssetEntity.setExternalId(UUID)"})
  public void testSetExternalId() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractAssetEntity.setLabel(String)"})
  public void testSetLabel() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractAssetEntity.setName(String)"})
  public void testSetName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractAssetEntity.setTenantId(UUID)"})
  public void testSetTenantId() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractAssetEntity.setType(String)"})
  public void testSetType() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractAssetEntity.toString()"})
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("AssetEntity()", new AssetEntity().toString());
  }
}
