package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class AbstractAssetEntityDiffblueTest {
  /**
   * Test {@link AbstractAssetEntity#toAsset()}.
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()} TenantId is randomUUID.</li>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#toAsset()}
   */
  @Test
  public void testToAsset_givenAssetEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    UUID tenantId = UUID.randomUUID();
    assetEntity.setTenantId(tenantId);
    assetEntity.setCustomerId(null);
    assetEntity.setAssetProfileId(null);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act and Assert
    TenantId tenantId2 = assetEntity.toAsset().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AbstractAssetEntity#toAsset()}.
   * <ul>
   *   <li>Given {@link AssetEntity#AssetEntity()}.</li>
   *   <li>Then return AssetProfileId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#toAsset()}
   */
  @Test
  public void testToAsset_givenAssetEntity_thenReturnAssetProfileIdIsNull() {
    // Arrange and Act
    Asset actualToAssetResult = (new AssetEntity()).toAsset();

    // Assert
    assertNull(actualToAssetResult.getExternalId());
    assertNull(actualToAssetResult.getAssetProfileId());
    assertNull(actualToAssetResult.getCustomerId());
    assertNull(actualToAssetResult.getTenantId());
  }

  /**
   * Test {@link AbstractAssetEntity#toAsset()}.
   * <ul>
   *   <li>Then return AssetProfileId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#toAsset()}
   */
  @Test
  public void testToAsset_thenReturnAssetProfileIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setTenantId(null);
    assetEntity.setCustomerId(null);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(null);

    // Act
    Asset actualToAssetResult = assetEntity.toAsset();

    // Assert
    AssetProfileId assetProfileId = actualToAssetResult.getAssetProfileId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", assetProfileId.getId().toString());
    assertNull(actualToAssetResult.getExternalId());
    assertNull(actualToAssetResult.getTenantId());
    assertEquals(EntityType.ASSET_PROFILE, assetProfileId.getEntityType());
    assertTrue(assetProfileId.isNullUid());
  }

  /**
   * Test {@link AbstractAssetEntity#toAsset()}.
   * <ul>
   *   <li>Then return CustomerId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#toAsset()}
   */
  @Test
  public void testToAsset_thenReturnCustomerIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setTenantId(null);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setAssetProfileId(null);
    assetEntity.setExternalId(null);

    // Act
    Asset actualToAssetResult = assetEntity.toAsset();

    // Assert
    CustomerId customerId = actualToAssetResult.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.getId().toString());
    assertNull(actualToAssetResult.getExternalId());
    assertNull(actualToAssetResult.getTenantId());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link AbstractAssetEntity#toAsset()}.
   * <ul>
   *   <li>Then return ExternalId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#toAsset()}
   */
  @Test
  public void testToAsset_thenReturnExternalIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setTenantId(null);
    assetEntity.setCustomerId(null);
    assetEntity.setAssetProfileId(null);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    Asset actualToAssetResult = assetEntity.toAsset();

    // Assert
    AssetId externalId = actualToAssetResult.getExternalId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", externalId.getId().toString());
    assertNull(actualToAssetResult.getTenantId());
    assertEquals(EntityType.ASSET, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
  }

  /**
   * Test {@link AbstractAssetEntity#toAsset()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#toAsset()}
   */
  @Test
  public void testToAsset_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setCustomerId(null);
    assetEntity.setAssetProfileId(null);
    assetEntity.setExternalId(null);

    // Act and Assert
    TenantId tenantId = assetEntity.toAsset().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AbstractAssetEntity#canEqual(Object)}.
   * <ul>
   *   <li>When {@link AssetEntity#AssetEntity()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#canEqual(Object)}
   */
  @Test
  public void testCanEqual_whenAssetEntity_thenReturnTrue() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    // Act and Assert
    assertTrue(assetEntity.canEqual(new AssetEntity()));
  }

  /**
   * Test {@link AbstractAssetEntity#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#canEqual(Object)}
   */
  @Test
  public void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AssetEntity()).canEqual("Other"));
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}, and
   * {@link AbstractAssetEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
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
   * Test {@link AbstractAssetEntity#equals(Object)}, and
   * {@link AbstractAssetEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(assetEntity, adminSettingsEntity);
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetEntity(), mock(AssetInfoEntity.class));
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(assetEntity, new AssetEntity());
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(assetEntity, new AssetEntity());
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setName("Name");

    // Act and Assert
    assertNotEquals(assetEntity, new AssetEntity());
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setType("Type");

    // Act and Assert
    assertNotEquals(assetEntity, new AssetEntity());
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setLabel("Label");

    // Act and Assert
    assertNotEquals(assetEntity, new AssetEntity());
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(assetEntity, new AssetEntity());
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(assetEntity, new AssetEntity());
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(assetEntity, new AssetEntity());
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(assetEntity, new AssetEntity());
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(assetEntity, assetEntity2);
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setCustomerId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(assetEntity, assetEntity2);
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setName("Name");

    // Act and Assert
    assertNotEquals(assetEntity, assetEntity2);
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setType("Type");

    // Act and Assert
    assertNotEquals(assetEntity, assetEntity2);
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setLabel("Label");

    // Act and Assert
    assertNotEquals(assetEntity, assetEntity2);
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(assetEntity, assetEntity2);
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setAssetProfileId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(assetEntity, assetEntity2);
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();

    AssetEntity assetEntity2 = new AssetEntity();
    assetEntity2.setExternalId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(assetEntity, assetEntity2);
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetEntity(), null);
  }

  /**
   * Test {@link AbstractAssetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractAssetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetEntity(), "Different type to AbstractAssetEntity");
  }

  /**
   * Test {@link AbstractAssetEntity#getAdditionalInfo()}.
   * <p>
   * Method under test: {@link AbstractAssetEntity#getAdditionalInfo()}
   */
  @Test
  public void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull((new AssetEntity()).getAdditionalInfo());
  }

  /**
   * Test {@link AbstractAssetEntity#getAssetProfileId()}.
   * <p>
   * Method under test: {@link AbstractAssetEntity#getAssetProfileId()}
   */
  @Test
  public void testGetAssetProfileId() {
    // Arrange, Act and Assert
    assertNull((new AssetEntity()).getAssetProfileId());
  }

  /**
   * Test {@link AbstractAssetEntity#getCustomerId()}.
   * <p>
   * Method under test: {@link AbstractAssetEntity#getCustomerId()}
   */
  @Test
  public void testGetCustomerId() {
    // Arrange, Act and Assert
    assertNull((new AssetEntity()).getCustomerId());
  }

  /**
   * Test {@link AbstractAssetEntity#getExternalId()}.
   * <p>
   * Method under test: {@link AbstractAssetEntity#getExternalId()}
   */
  @Test
  public void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new AssetEntity()).getExternalId());
  }

  /**
   * Test {@link AbstractAssetEntity#getLabel()}.
   * <p>
   * Method under test: {@link AbstractAssetEntity#getLabel()}
   */
  @Test
  public void testGetLabel() {
    // Arrange, Act and Assert
    assertNull((new AssetEntity()).getLabel());
  }

  /**
   * Test {@link AbstractAssetEntity#getName()}.
   * <p>
   * Method under test: {@link AbstractAssetEntity#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull((new AssetEntity()).getName());
  }

  /**
   * Test {@link AbstractAssetEntity#getTenantId()}.
   * <p>
   * Method under test: {@link AbstractAssetEntity#getTenantId()}
   */
  @Test
  public void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull((new AssetEntity()).getTenantId());
  }

  /**
   * Test {@link AbstractAssetEntity#getType()}.
   * <p>
   * Method under test: {@link AbstractAssetEntity#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull((new AssetEntity()).getType());
  }

  /**
   * Test {@link AbstractAssetEntity#setAdditionalInfo(JsonNode)}.
   * <p>
   * Method under test: {@link AbstractAssetEntity#setAdditionalInfo(JsonNode)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAssetEntity#setAssetProfileId(UUID)}
   */
  @Test
  public void testSetAssetProfileId() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    UUID assetProfileId = ModelConstants.NULL_UUID;

    // Act
    assetEntity.setAssetProfileId(assetProfileId);

    // Assert
    AssetProfileId assetProfileId2 = assetEntity.toData().getAssetProfileId();
    assertEquals(EntityType.ASSET_PROFILE, assetProfileId2.getEntityType());
    assertTrue(assetProfileId2.isNullUid());
    assertSame(assetProfileId, assetProfileId2.getId());
    assertSame(assetProfileId, assetEntity.getAssetProfileId());
  }

  /**
   * Test {@link AbstractAssetEntity#setCustomerId(UUID)}.
   * <p>
   * Method under test: {@link AbstractAssetEntity#setCustomerId(UUID)}
   */
  @Test
  public void testSetCustomerId() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    UUID customerId = ModelConstants.NULL_UUID;

    // Act
    assetEntity.setCustomerId(customerId);

    // Assert
    CustomerId customerId2 = assetEntity.toData().getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertTrue(customerId2.isNullUid());
    assertSame(customerId, customerId2.getId());
    assertSame(customerId, assetEntity.getCustomerId());
  }

  /**
   * Test {@link AbstractAssetEntity#setExternalId(UUID)}.
   * <p>
   * Method under test: {@link AbstractAssetEntity#setExternalId(UUID)}
   */
  @Test
  public void testSetExternalId() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    assetEntity.setExternalId(externalId);

    // Assert
    AssetId externalId2 = assetEntity.toData().getExternalId();
    assertEquals(EntityType.ASSET, externalId2.getEntityType());
    assertTrue(externalId2.isNullUid());
    assertSame(externalId, externalId2.getId());
    assertSame(externalId, assetEntity.getExternalId());
  }

  /**
   * Test {@link AbstractAssetEntity#setLabel(String)}.
   * <p>
   * Method under test: {@link AbstractAssetEntity#setLabel(String)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAssetEntity#setName(String)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAssetEntity#setTenantId(UUID)}
   */
  @Test
  public void testSetTenantId() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    assetEntity.setTenantId(tenantId);

    // Assert
    TenantId tenantId2 = assetEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(tenantId, assetEntity.getTenantId());
  }

  /**
   * Test {@link AbstractAssetEntity#setType(String)}.
   * <p>
   * Method under test: {@link AbstractAssetEntity#setType(String)}
   */
  @Test
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
   * <p>
   * Method under test: {@link AbstractAssetEntity#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("AssetEntity()", (new AssetEntity()).toString());
  }
}
