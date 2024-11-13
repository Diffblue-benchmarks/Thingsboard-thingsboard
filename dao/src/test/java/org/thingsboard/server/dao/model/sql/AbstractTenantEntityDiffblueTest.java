package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class AbstractTenantEntityDiffblueTest {
  /**
   * Test {@link AbstractTenantEntity#toTenant()}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#toTenant()}
   */
  @Test
  public void testToTenant() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);

    // Act
    Tenant actualToTenantResult = tenantEntity.toTenant();

    // Assert
    TenantProfileId tenantProfileId = actualToTenantResult.getTenantProfileId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantProfileId.getId().toString());
    assertNull(actualToTenantResult.getUuidId());
    assertNull(actualToTenantResult.getId().getId());
    assertEquals(EntityType.TENANT_PROFILE, tenantProfileId.getEntityType());
    assertTrue(tenantProfileId.isNullUid());
  }

  /**
   * Test {@link AbstractTenantEntity#toTenant()}.
   * <ul>
   *   <li>Given {@link TenantEntity#TenantEntity()} Uuid is randomUUID.</li>
   *   <li>Then return UuidId is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#toTenant()}
   */
  @Test
  public void testToTenant_givenTenantEntityUuidIsRandomUUID_thenReturnUuidIdIsRandomUUID() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    UUID id = UUID.randomUUID();
    tenantEntity.setUuid(id);

    // Act
    Tenant actualToTenantResult = tenantEntity.toTenant();

    // Assert
    assertSame(id, actualToTenantResult.getUuidId());
    assertSame(id, actualToTenantResult.getId().getId());
  }

  /**
   * Test {@link AbstractTenantEntity#toTenant()}.
   * <ul>
   *   <li>Given {@link TenantEntity#TenantEntity()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#toTenant()}
   */
  @Test
  public void testToTenant_givenTenantEntity_thenAdditionalInfoReturnNullNode() throws IOException {
    // Arrange and Act
    Tenant actualToTenantResult = (new TenantEntity()).toTenant();

    // Assert
    JsonNode additionalInfo = actualToTenantResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualToTenantResult.getVersion());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(actualToTenantResult.getAddress());
    assertNull(actualToTenantResult.getAddress2());
    assertNull(actualToTenantResult.getCity());
    assertNull(actualToTenantResult.getCountry());
    assertNull(actualToTenantResult.getEmail());
    assertNull(actualToTenantResult.getName());
    assertNull(actualToTenantResult.getPhone());
    assertNull(actualToTenantResult.getRegion());
    assertNull(actualToTenantResult.getState());
    assertNull(actualToTenantResult.getTitle());
    assertNull(actualToTenantResult.getZip());
    assertNull(actualToTenantResult.getUuidId());
    TenantId id = actualToTenantResult.getId();
    assertNull(id.getId());
    assertNull(actualToTenantResult.getTenantProfileId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualToTenantResult.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertEquals(EntityType.TENANT, id.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertFalse(id.isNullUid());
    assertFalse(id.isSysTenantId());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(id, actualToTenantResult.getTenantId());
  }

  /**
   * Test {@link AbstractTenantEntity#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#canEqual(Object)}
   */
  @Test
  public void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new TenantEntity()).canEqual("Other"));
  }

  /**
   * Test {@link AbstractTenantEntity#canEqual(Object)}.
   * <ul>
   *   <li>When {@link TenantEntity#TenantEntity()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#canEqual(Object)}
   */
  @Test
  public void testCanEqual_whenTenantEntity_thenReturnTrue() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act and Assert
    assertTrue(tenantEntity.canEqual(new TenantEntity()));
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}, and
   * {@link AbstractTenantEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    TenantEntity tenantEntity2 = new TenantEntity();

    // Act and Assert
    assertEquals(tenantEntity, tenantEntity2);
    int expectedHashCodeResult = tenantEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantEntity2.hashCode());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}, and
   * {@link AbstractTenantEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act and Assert
    assertEquals(tenantEntity, tenantEntity);
    int expectedHashCodeResult = tenantEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantEntity.hashCode());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

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
    assertNotEquals(tenantEntity, assetEntity);
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantEntity(), mock(TenantInfoEntity.class));
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setTitle("Dr");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setRegion("us-east-2");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setCountry("GB");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setState("MD");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setCity("Oxford");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAddress("42 Main St");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAddress2("42 Main St");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setZip("21654");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setPhone("6625550144");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(tenantEntity, new TenantEntity());
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setRegion("us-east-2");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setCountry("GB");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setState("MD");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setCity("Oxford");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setAddress("42 Main St");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setAddress2("42 Main St");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setZip("21654");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setPhone("6625550144");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    TenantEntity tenantEntity2 = new TenantEntity();
    tenantEntity2.setTenantProfileId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(tenantEntity, tenantEntity2);
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantEntity(), null);
  }

  /**
   * Test {@link AbstractTenantEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTenantEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantEntity(), "Different type to AbstractTenantEntity");
  }

  /**
   * Test {@link AbstractTenantEntity#getAdditionalInfo()}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#getAdditionalInfo()}
   */
  @Test
  public void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull((new TenantEntity()).getAdditionalInfo());
  }

  /**
   * Test {@link AbstractTenantEntity#getAddress()}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#getAddress()}
   */
  @Test
  public void testGetAddress() {
    // Arrange, Act and Assert
    assertNull((new TenantEntity()).getAddress());
  }

  /**
   * Test {@link AbstractTenantEntity#getAddress2()}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#getAddress2()}
   */
  @Test
  public void testGetAddress2() {
    // Arrange, Act and Assert
    assertNull((new TenantEntity()).getAddress2());
  }

  /**
   * Test {@link AbstractTenantEntity#getCity()}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#getCity()}
   */
  @Test
  public void testGetCity() {
    // Arrange, Act and Assert
    assertNull((new TenantEntity()).getCity());
  }

  /**
   * Test {@link AbstractTenantEntity#getCountry()}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#getCountry()}
   */
  @Test
  public void testGetCountry() {
    // Arrange, Act and Assert
    assertNull((new TenantEntity()).getCountry());
  }

  /**
   * Test {@link AbstractTenantEntity#getEmail()}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#getEmail()}
   */
  @Test
  public void testGetEmail() {
    // Arrange, Act and Assert
    assertNull((new TenantEntity()).getEmail());
  }

  /**
   * Test {@link AbstractTenantEntity#getPhone()}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#getPhone()}
   */
  @Test
  public void testGetPhone() {
    // Arrange, Act and Assert
    assertNull((new TenantEntity()).getPhone());
  }

  /**
   * Test {@link AbstractTenantEntity#getRegion()}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#getRegion()}
   */
  @Test
  public void testGetRegion() {
    // Arrange, Act and Assert
    assertNull((new TenantEntity()).getRegion());
  }

  /**
   * Test {@link AbstractTenantEntity#getState()}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#getState()}
   */
  @Test
  public void testGetState() {
    // Arrange, Act and Assert
    assertNull((new TenantEntity()).getState());
  }

  /**
   * Test {@link AbstractTenantEntity#getTenantProfileId()}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#getTenantProfileId()}
   */
  @Test
  public void testGetTenantProfileId() {
    // Arrange, Act and Assert
    assertNull((new TenantEntity()).getTenantProfileId());
  }

  /**
   * Test {@link AbstractTenantEntity#getTitle()}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#getTitle()}
   */
  @Test
  public void testGetTitle() {
    // Arrange, Act and Assert
    assertNull((new TenantEntity()).getTitle());
  }

  /**
   * Test {@link AbstractTenantEntity#getZip()}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#getZip()}
   */
  @Test
  public void testGetZip() {
    // Arrange, Act and Assert
    assertNull((new TenantEntity()).getZip());
  }

  /**
   * Test {@link AbstractTenantEntity#setAdditionalInfo(JsonNode)}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#setAdditionalInfo(JsonNode)}
   */
  @Test
  public void testSetAdditionalInfo() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    tenantEntity.setAdditionalInfo(additionalInfo);

    // Assert
    assertSame(additionalInfo, tenantEntity.toData().getAdditionalInfo());
    assertSame(additionalInfo, tenantEntity.getAdditionalInfo());
  }

  /**
   * Test {@link AbstractTenantEntity#setAddress(String)}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#setAddress(String)}
   */
  @Test
  public void testSetAddress() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setAddress("42 Main St");

    // Assert
    assertEquals("42 Main St", tenantEntity.toData().getAddress());
    assertEquals("42 Main St", tenantEntity.getAddress());
  }

  /**
   * Test {@link AbstractTenantEntity#setAddress2(String)}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#setAddress2(String)}
   */
  @Test
  public void testSetAddress2() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setAddress2("42 Main St");

    // Assert
    assertEquals("42 Main St", tenantEntity.toData().getAddress2());
    assertEquals("42 Main St", tenantEntity.getAddress2());
  }

  /**
   * Test {@link AbstractTenantEntity#setCity(String)}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#setCity(String)}
   */
  @Test
  public void testSetCity() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setCity("Oxford");

    // Assert
    assertEquals("Oxford", tenantEntity.toData().getCity());
    assertEquals("Oxford", tenantEntity.getCity());
  }

  /**
   * Test {@link AbstractTenantEntity#setCountry(String)}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#setCountry(String)}
   */
  @Test
  public void testSetCountry() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setCountry("GB");

    // Assert
    assertEquals("GB", tenantEntity.toData().getCountry());
    assertEquals("GB", tenantEntity.getCountry());
  }

  /**
   * Test {@link AbstractTenantEntity#setEmail(String)}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#setEmail(String)}
   */
  @Test
  public void testSetEmail() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setEmail("jane.doe@example.org");

    // Assert
    assertEquals("jane.doe@example.org", tenantEntity.toData().getEmail());
    assertEquals("jane.doe@example.org", tenantEntity.getEmail());
  }

  /**
   * Test {@link AbstractTenantEntity#setPhone(String)}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#setPhone(String)}
   */
  @Test
  public void testSetPhone() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setPhone("6625550144");

    // Assert
    assertEquals("6625550144", tenantEntity.toData().getPhone());
    assertEquals("6625550144", tenantEntity.getPhone());
  }

  /**
   * Test {@link AbstractTenantEntity#setRegion(String)}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#setRegion(String)}
   */
  @Test
  public void testSetRegion() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setRegion("us-east-2");

    // Assert
    assertEquals("us-east-2", tenantEntity.toData().getRegion());
    assertEquals("us-east-2", tenantEntity.getRegion());
  }

  /**
   * Test {@link AbstractTenantEntity#setState(String)}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#setState(String)}
   */
  @Test
  public void testSetState() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setState("MD");

    // Assert
    assertEquals("MD", tenantEntity.toData().getState());
    assertEquals("MD", tenantEntity.getState());
  }

  /**
   * Test {@link AbstractTenantEntity#setTenantProfileId(UUID)}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#setTenantProfileId(UUID)}
   */
  @Test
  public void testSetTenantProfileId() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    UUID tenantProfileId = ModelConstants.NULL_UUID;

    // Act
    tenantEntity.setTenantProfileId(tenantProfileId);

    // Assert
    TenantProfileId tenantProfileId2 = tenantEntity.toData().getTenantProfileId();
    assertEquals(EntityType.TENANT_PROFILE, tenantProfileId2.getEntityType());
    assertTrue(tenantProfileId2.isNullUid());
    assertSame(tenantProfileId, tenantProfileId2.getId());
    assertSame(tenantProfileId, tenantEntity.getTenantProfileId());
  }

  /**
   * Test {@link AbstractTenantEntity#setTitle(String)}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#setTitle(String)}
   */
  @Test
  public void testSetTitle() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setTitle("Dr");

    // Assert
    Tenant toDataResult = tenantEntity.toData();
    assertEquals("Dr", toDataResult.getName());
    assertEquals("Dr", toDataResult.getTitle());
    assertEquals("Dr", tenantEntity.getTitle());
  }

  /**
   * Test {@link AbstractTenantEntity#setZip(String)}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#setZip(String)}
   */
  @Test
  public void testSetZip() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();

    // Act
    tenantEntity.setZip("21654");

    // Assert
    assertEquals("21654", tenantEntity.toData().getZip());
    assertEquals("21654", tenantEntity.getZip());
  }

  /**
   * Test {@link AbstractTenantEntity#toString()}.
   * <p>
   * Method under test: {@link AbstractTenantEntity#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("TenantEntity()", (new TenantEntity()).toString());
  }
}
