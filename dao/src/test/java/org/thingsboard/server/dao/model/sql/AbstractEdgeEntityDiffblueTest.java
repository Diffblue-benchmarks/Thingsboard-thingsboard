package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class AbstractEdgeEntityDiffblueTest {
  /**
   * Test {@link AbstractEdgeEntity#toEdge()}.
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()} TenantId is randomUUID.</li>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEdgeEntity#toEdge()}
   */
  @Test
  public void testToEdge_givenEdgeEntityTenantIdIsRandomUUID_thenReturnNotTenantIdNullUid() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    UUID tenantId = UUID.randomUUID();
    edgeEntity.setTenantId(tenantId);
    edgeEntity.setCustomerId(null);
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);

    // Act and Assert
    TenantId tenantId2 = edgeEntity.toEdge().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AbstractEdgeEntity#toEdge()}.
   * <ul>
   *   <li>Given {@link EdgeEntity#EdgeEntity()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEdgeEntity#toEdge()}
   */
  @Test
  public void testToEdge_givenEdgeEntity_thenAdditionalInfoReturnNullNode() throws IOException {
    // Arrange and Act
    Edge actualToEdgeResult = (new EdgeEntity()).toEdge();

    // Assert
    JsonNode additionalInfo = actualToEdgeResult.getAdditionalInfo();
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
    assertNull(actualToEdgeResult.getVersion());
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
    assertNull(actualToEdgeResult.getLabel());
    assertNull(actualToEdgeResult.getName());
    assertNull(actualToEdgeResult.getRoutingKey());
    assertNull(actualToEdgeResult.getSecret());
    assertNull(actualToEdgeResult.getType());
    assertNull(actualToEdgeResult.getUuidId());
    EdgeId id = actualToEdgeResult.getId();
    assertNull(id.getId());
    assertNull(actualToEdgeResult.getCustomerId());
    assertNull(actualToEdgeResult.getRootRuleChainId());
    assertNull(actualToEdgeResult.getTenantId());
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
    assertEquals(0L, actualToEdgeResult.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertEquals(EntityType.EDGE, id.getEntityType());
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
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link AbstractEdgeEntity#toEdge()}.
   * <ul>
   *   <li>Then return CustomerId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEdgeEntity#toEdge()}
   */
  @Test
  public void testToEdge_thenReturnCustomerIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setTenantId(null);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setRootRuleChainId(null);

    // Act
    Edge actualToEdgeResult = edgeEntity.toEdge();

    // Assert
    CustomerId customerId = actualToEdgeResult.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.getId().toString());
    assertNull(actualToEdgeResult.getRootRuleChainId());
    assertNull(actualToEdgeResult.getTenantId());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link AbstractEdgeEntity#toEdge()}.
   * <ul>
   *   <li>Then return RootRuleChainId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEdgeEntity#toEdge()}
   */
  @Test
  public void testToEdge_thenReturnRootRuleChainIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setTenantId(null);
    edgeEntity.setCustomerId(null);
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);

    // Act
    Edge actualToEdgeResult = edgeEntity.toEdge();

    // Assert
    RuleChainId rootRuleChainId = actualToEdgeResult.getRootRuleChainId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", rootRuleChainId.getId().toString());
    assertNull(actualToEdgeResult.getTenantId());
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId.getEntityType());
    assertTrue(rootRuleChainId.isNullUid());
  }

  /**
   * Test {@link AbstractEdgeEntity#toEdge()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEdgeEntity#toEdge()}
   */
  @Test
  public void testToEdge_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setCustomerId(null);
    edgeEntity.setRootRuleChainId(null);

    // Act and Assert
    TenantId tenantId = edgeEntity.toEdge().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AbstractEdgeEntity#canEqual(Object)}.
   * <ul>
   *   <li>When {@link EdgeEntity#EdgeEntity()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEdgeEntity#canEqual(Object)}
   */
  @Test
  public void testCanEqual_whenEdgeEntity_thenReturnTrue() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    // Act and Assert
    assertTrue(edgeEntity.canEqual(new EdgeEntity()));
  }

  /**
   * Test {@link AbstractEdgeEntity#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEdgeEntity#canEqual(Object)}
   */
  @Test
  public void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new EdgeEntity()).canEqual("Other"));
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}, and
   * {@link AbstractEdgeEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    EdgeEntity edgeEntity2 = new EdgeEntity();

    // Act and Assert
    assertEquals(edgeEntity, edgeEntity2);
    int expectedHashCodeResult = edgeEntity.hashCode();
    assertEquals(expectedHashCodeResult, edgeEntity2.hashCode());
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}, and
   * {@link AbstractEdgeEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    // Act and Assert
    assertEquals(edgeEntity, edgeEntity);
    int expectedHashCodeResult = edgeEntity.hashCode();
    assertEquals(expectedHashCodeResult, edgeEntity.hashCode());
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

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
    assertNotEquals(edgeEntity, assetEntity);
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    EdgeEntity edgeEntity2 = mock(EdgeEntity.class);
    when(edgeEntity2.getVersion()).thenReturn(1L);
    when(edgeEntity2.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(edgeEntity2.getCreatedTime()).thenReturn(1L);
    when(edgeEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(edgeEntity, edgeEntity2);
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEntity(), null);
  }

  /**
   * Test {@link AbstractEdgeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEdgeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEntity(), "Different type to AbstractEdgeEntity");
  }

  /**
   * Test {@link AbstractEdgeEntity#getAdditionalInfo()}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#getAdditionalInfo()}
   */
  @Test
  public void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull((new EdgeEntity()).getAdditionalInfo());
  }

  /**
   * Test {@link AbstractEdgeEntity#getCustomerId()}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#getCustomerId()}
   */
  @Test
  public void testGetCustomerId() {
    // Arrange, Act and Assert
    assertNull((new EdgeEntity()).getCustomerId());
  }

  /**
   * Test {@link AbstractEdgeEntity#getLabel()}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#getLabel()}
   */
  @Test
  public void testGetLabel() {
    // Arrange, Act and Assert
    assertNull((new EdgeEntity()).getLabel());
  }

  /**
   * Test {@link AbstractEdgeEntity#getName()}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull((new EdgeEntity()).getName());
  }

  /**
   * Test {@link AbstractEdgeEntity#getRootRuleChainId()}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#getRootRuleChainId()}
   */
  @Test
  public void testGetRootRuleChainId() {
    // Arrange, Act and Assert
    assertNull((new EdgeEntity()).getRootRuleChainId());
  }

  /**
   * Test {@link AbstractEdgeEntity#getRoutingKey()}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#getRoutingKey()}
   */
  @Test
  public void testGetRoutingKey() {
    // Arrange, Act and Assert
    assertNull((new EdgeEntity()).getRoutingKey());
  }

  /**
   * Test {@link AbstractEdgeEntity#getSecret()}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#getSecret()}
   */
  @Test
  public void testGetSecret() {
    // Arrange, Act and Assert
    assertNull((new EdgeEntity()).getSecret());
  }

  /**
   * Test {@link AbstractEdgeEntity#getTenantId()}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#getTenantId()}
   */
  @Test
  public void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull((new EdgeEntity()).getTenantId());
  }

  /**
   * Test {@link AbstractEdgeEntity#getType()}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull((new EdgeEntity()).getType());
  }

  /**
   * Test {@link AbstractEdgeEntity#setAdditionalInfo(JsonNode)}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#setAdditionalInfo(JsonNode)}
   */
  @Test
  public void testSetAdditionalInfo() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    edgeEntity.setAdditionalInfo(additionalInfo);

    // Assert
    assertSame(additionalInfo, edgeEntity.toData().getAdditionalInfo());
    assertSame(additionalInfo, edgeEntity.getAdditionalInfo());
  }

  /**
   * Test {@link AbstractEdgeEntity#setCustomerId(UUID)}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#setCustomerId(UUID)}
   */
  @Test
  public void testSetCustomerId() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    UUID customerId = ModelConstants.NULL_UUID;

    // Act
    edgeEntity.setCustomerId(customerId);

    // Assert
    CustomerId customerId2 = edgeEntity.toData().getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertTrue(customerId2.isNullUid());
    assertSame(customerId, customerId2.getId());
    assertSame(customerId, edgeEntity.getCustomerId());
  }

  /**
   * Test {@link AbstractEdgeEntity#setLabel(String)}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#setLabel(String)}
   */
  @Test
  public void testSetLabel() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    // Act
    edgeEntity.setLabel("Label");

    // Assert
    assertEquals("Label", edgeEntity.toData().getLabel());
    assertEquals("Label", edgeEntity.getLabel());
  }

  /**
   * Test {@link AbstractEdgeEntity#setName(String)}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#setName(String)}
   */
  @Test
  public void testSetName() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    // Act
    edgeEntity.setName("Name");

    // Assert
    assertEquals("Name", edgeEntity.toData().getName());
    assertEquals("Name", edgeEntity.getName());
  }

  /**
   * Test {@link AbstractEdgeEntity#setRootRuleChainId(UUID)}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#setRootRuleChainId(UUID)}
   */
  @Test
  public void testSetRootRuleChainId() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    UUID rootRuleChainId = ModelConstants.NULL_UUID;

    // Act
    edgeEntity.setRootRuleChainId(rootRuleChainId);

    // Assert
    RuleChainId rootRuleChainId2 = edgeEntity.toData().getRootRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId2.getEntityType());
    assertTrue(rootRuleChainId2.isNullUid());
    assertSame(rootRuleChainId, rootRuleChainId2.getId());
    assertSame(rootRuleChainId, edgeEntity.getRootRuleChainId());
  }

  /**
   * Test {@link AbstractEdgeEntity#setRoutingKey(String)}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#setRoutingKey(String)}
   */
  @Test
  public void testSetRoutingKey() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    // Act
    edgeEntity.setRoutingKey("Routing Key");

    // Assert
    assertEquals("Routing Key", edgeEntity.toData().getRoutingKey());
    assertEquals("Routing Key", edgeEntity.getRoutingKey());
  }

  /**
   * Test {@link AbstractEdgeEntity#setSecret(String)}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#setSecret(String)}
   */
  @Test
  public void testSetSecret() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    // Act
    edgeEntity.setSecret("Secret");

    // Assert
    assertEquals("Secret", edgeEntity.toData().getSecret());
    assertEquals("Secret", edgeEntity.getSecret());
  }

  /**
   * Test {@link AbstractEdgeEntity#setTenantId(UUID)}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#setTenantId(UUID)}
   */
  @Test
  public void testSetTenantId() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    edgeEntity.setTenantId(tenantId);

    // Assert
    TenantId tenantId2 = edgeEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(tenantId, edgeEntity.getTenantId());
  }

  /**
   * Test {@link AbstractEdgeEntity#setType(String)}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#setType(String)}
   */
  @Test
  public void testSetType() {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();

    // Act
    edgeEntity.setType("Type");

    // Assert
    assertEquals("Type", edgeEntity.toData().getType());
    assertEquals("Type", edgeEntity.getType());
  }

  /**
   * Test {@link AbstractEdgeEntity#toString()}.
   * <p>
   * Method under test: {@link AbstractEdgeEntity#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("EdgeEntity()", (new EdgeEntity()).toString());
  }
}
