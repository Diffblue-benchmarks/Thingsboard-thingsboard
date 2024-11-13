package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
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
   * Test {@link AssetInfoEntity#equals(Object)}, and
   * {@link AssetInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AssetInfoEntity#equals(Object)}
   *   <li>{@link AssetInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();

    // Act and Assert
    assertEquals(assetInfoEntity, assetInfoEntity2);
    int expectedHashCodeResult = assetInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, assetInfoEntity2.hashCode());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}, and
   * {@link AssetInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AssetInfoEntity#equals(Object)}
   *   <li>{@link AssetInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setCustomerTitle("Dr");

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setCustomerTitle("Dr");

    // Act and Assert
    assertEquals(assetInfoEntity, assetInfoEntity2);
    int expectedHashCodeResult = assetInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, assetInfoEntity2.hashCode());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}, and
   * {@link AssetInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AssetInfoEntity#equals(Object)}
   *   <li>{@link AssetInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setAssetProfileName("foo.txt");

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setAssetProfileName("foo.txt");

    // Act and Assert
    assertEquals(assetInfoEntity, assetInfoEntity2);
    int expectedHashCodeResult = assetInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, assetInfoEntity2.hashCode());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}, and
   * {@link AssetInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AssetInfoEntity#equals(Object)}
   *   <li>{@link AssetInfoEntity#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetInfoEntity(), mock(AlarmCommentEntity.class));
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(assetInfoEntity, new AssetInfoEntity());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setCustomerIsPublic(true);

    // Act and Assert
    assertNotEquals(assetInfoEntity, new AssetInfoEntity());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setAssetProfileName("foo.txt");

    // Act and Assert
    assertNotEquals(assetInfoEntity, new AssetInfoEntity());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(assetInfoEntity, new AssetInfoEntity());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(assetInfoEntity, assetInfoEntity2);
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();

    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();
    assetInfoEntity2.setAssetProfileName("foo.txt");

    // Act and Assert
    assertNotEquals(assetInfoEntity, assetInfoEntity2);
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetInfoEntity(), null);
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetInfoEntity(), "Different type to AssetInfoEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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

    // Assert that nothing has changed
    assertEquals("AssetInfoEntity(customerTitle=Dr, customerIsPublic=true, assetProfileName=foo.txt)",
        actualToStringResult);
    assertEquals("Dr", actualCustomerTitle);
    assertEquals("foo.txt", actualAssetProfileName);
    assertEquals(0L, actualAssetInfoEntity.getCreatedTime());
    assertTrue(actualIsCustomerIsPublicResult);
  }

  /**
   * Test
   * {@link AssetInfoEntity#AssetInfoEntity(AssetEntity, String, Object, String)}.
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetInfoEntity#AssetInfoEntity(AssetEntity, String, Object, String)}
   */
  @Test
  public void testNewAssetInfoEntity_whenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
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
    AssetInfoEntity actualAssetInfoEntity = new AssetInfoEntity(assetEntity, "Dr",
        new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)), "foo.txt");

    // Assert
    JsonNode additionalInfo = actualAssetInfoEntity.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    AssetInfo toDataResult = actualAssetInfoEntity.toData();
    AssetId expectedId = toDataResult.getExternalId();
    assertEquals(expectedId, toDataResult.getId());
    assertSame(additionalInfo, toDataResult.getAdditionalInfo());
  }

  /**
   * Test
   * {@link AssetInfoEntity#AssetInfoEntity(AssetEntity, String, Object, String)}.
   * <ul>
   *   <li>When {@link BigIntegerNode#BigIntegerNode(BigInteger)} with v is valueOf
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetInfoEntity#AssetInfoEntity(AssetEntity, String, Object, String)}
   */
  @Test
  public void testNewAssetInfoEntity_whenBigIntegerNodeWithVIsValueOfOne() {
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
    AssetInfoEntity actualAssetInfoEntity = new AssetInfoEntity(assetEntity, "Dr",
        new BigIntegerNode(BigInteger.valueOf(1L)), "foo.txt");

    // Assert
    JsonNode additionalInfo = actualAssetInfoEntity.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    AssetInfo toDataResult = actualAssetInfoEntity.toData();
    AssetId expectedId = toDataResult.getExternalId();
    assertEquals(expectedId, toDataResult.getId());
    assertSame(additionalInfo, toDataResult.getAdditionalInfo());
  }

  /**
   * Test
   * {@link AssetInfoEntity#AssetInfoEntity(AssetEntity, String, Object, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetInfoEntity#AssetInfoEntity(AssetEntity, String, Object, String)}
   */
  @Test
  public void testNewAssetInfoEntity_whenNull() {
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
    JsonNode additionalInfo = actualAssetInfoEntity.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
    AssetInfo toDataResult = actualAssetInfoEntity.toData();
    AssetId expectedId = toDataResult.getExternalId();
    assertEquals(expectedId, toDataResult.getId());
    assertSame(additionalInfo, toDataResult.getAdditionalInfo());
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link AssetInfoEntity#AssetInfoEntity()} TenantId is
   * randomUUID.</li>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  public void testToData_givenAssetInfoEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    UUID tenantId = UUID.randomUUID();
    assetInfoEntity.setTenantId(tenantId);
    assetInfoEntity.setCustomerId(null);
    assetInfoEntity.setAssetProfileId(null);
    assetInfoEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act and Assert
    TenantId tenantId2 = assetInfoEntity.toData().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link AssetInfoEntity#AssetInfoEntity()}.</li>
   *   <li>Then return AssetProfileId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  public void testToData_givenAssetInfoEntity_thenReturnAssetProfileIdIsNull() {
    // Arrange and Act
    AssetInfo actualToDataResult = (new AssetInfoEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getAssetProfileId());
    assertNull(actualToDataResult.getCustomerId());
    assertNull(actualToDataResult.getTenantId());
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   * <ul>
   *   <li>Then return AssetProfileId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnAssetProfileIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setTenantId(null);
    assetInfoEntity.setCustomerId(null);
    assetInfoEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetInfoEntity.setExternalId(null);

    // Act
    AssetInfo actualToDataResult = assetInfoEntity.toData();

    // Assert
    AssetProfileId assetProfileId = actualToDataResult.getAssetProfileId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", assetProfileId.getId().toString());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.ASSET_PROFILE, assetProfileId.getEntityType());
    assertTrue(assetProfileId.isNullUid());
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   * <ul>
   *   <li>Then return CustomerId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnCustomerIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setTenantId(null);
    assetInfoEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetInfoEntity.setAssetProfileId(null);
    assetInfoEntity.setExternalId(null);

    // Act
    AssetInfo actualToDataResult = assetInfoEntity.toData();

    // Assert
    CustomerId customerId = actualToDataResult.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.getId().toString());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link AssetInfoEntity#toData()}.
   * <ul>
   *   <li>Then return ExternalId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnExternalIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setTenantId(null);
    assetInfoEntity.setCustomerId(null);
    assetInfoEntity.setAssetProfileId(null);
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
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    assetInfoEntity.setCustomerId(null);
    assetInfoEntity.setAssetProfileId(null);
    assetInfoEntity.setExternalId(null);

    // Act and Assert
    TenantId tenantId = assetInfoEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
