package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class AbstractEntityViewEntityDiffblueTest {
  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys(null);

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    EntityViewId externalId = actualToEntityViewResult.getExternalId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", externalId.getId().toString());
    assertNull(actualToEntityViewResult.getEntityId());
    assertEquals(EntityType.ENTITY_VIEW, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    CustomerId customerId = actualToEntityViewResult.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.getId().toString());
    assertNull(actualToEntityViewResult.getEntityId());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} EntityType is
   * {@code USER}.</li>
   *   <li>Then EntityId return {@link UserId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_givenEntityViewEntityEntityTypeIsUser_thenEntityIdReturnUserId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.USER);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId instanceof UserId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.USER, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} Keys is
   * {@code 42}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_givenEntityViewEntityKeysIs42_thenAdditionalInfoReturnNullNode() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys("42");

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    JsonNode additionalInfo = actualToEntityViewResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualToEntityViewResult.getCustomerId());
    assertNull(actualToEntityViewResult.getEntityId());
    assertNull(actualToEntityViewResult.getExternalId());
    assertNull(actualToEntityViewResult.getTenantId());
    assertEquals(0, additionalInfo.size());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} Keys is empty
   * string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_givenEntityViewEntityKeysIsEmptyString() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys("");

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    JsonNode additionalInfo = actualToEntityViewResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualToEntityViewResult.getCustomerId());
    assertNull(actualToEntityViewResult.getEntityId());
    assertNull(actualToEntityViewResult.getExternalId());
    assertNull(actualToEntityViewResult.getTenantId());
    assertEquals(0, additionalInfo.size());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()} Keys is
   * {@code foo}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_givenEntityViewEntityKeysIsFoo_thenAdditionalInfoReturnNullNode() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys("foo");

    // Act
    EntityView actualToEntityViewResult = entityViewEntity.toEntityView();

    // Assert
    JsonNode additionalInfo = actualToEntityViewResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualToEntityViewResult.getCustomerId());
    assertNull(actualToEntityViewResult.getEntityId());
    assertNull(actualToEntityViewResult.getExternalId());
    assertNull(actualToEntityViewResult.getTenantId());
    assertEquals(0, additionalInfo.size());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Given {@link EntityViewEntity#EntityViewEntity()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_givenEntityViewEntity_thenAdditionalInfoReturnNullNode() {
    // Arrange and Act
    EntityView actualToEntityViewResult = (new EntityViewEntity()).toEntityView();

    // Assert
    JsonNode additionalInfo = actualToEntityViewResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(actualToEntityViewResult.getCustomerId());
    assertNull(actualToEntityViewResult.getEntityId());
    assertNull(actualToEntityViewResult.getExternalId());
    assertNull(actualToEntityViewResult.getTenantId());
    assertEquals(0, additionalInfo.size());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.iterator().hasNext());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_thenAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    JsonNode additionalInfo = entityViewEntity.toEntityView().getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(1, additionalInfo.size());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
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
    assertFalse(nextResult.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Then EntityId return {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_thenEntityIdReturnAlarmId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.ALARM);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId instanceof AlarmId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.ALARM, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Then EntityId return {@link AssetId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_thenEntityIdReturnAssetId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.ASSET);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId instanceof AssetId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.ASSET, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Then EntityId return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_thenEntityIdReturnCustomerId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.CUSTOMER);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId instanceof CustomerId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.CUSTOMER, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Then EntityId return {@link DashboardId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_thenEntityIdReturnDashboardId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.DASHBOARD);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId instanceof DashboardId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.DASHBOARD, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Then EntityId return {@link DeviceId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_thenEntityIdReturnDeviceId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.DEVICE);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId instanceof DeviceId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.DEVICE, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Then EntityId return {@link EntityViewId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_thenEntityIdReturnEntityViewId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.ENTITY_VIEW);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId instanceof EntityViewId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.ENTITY_VIEW, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Then EntityId return {@link RuleChainId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_thenEntityIdReturnRuleChainId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.RULE_CHAIN);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId instanceof RuleChainId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Then EntityId return {@link RuleNodeId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_thenEntityIdReturnRuleNodeId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.RULE_NODE);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId instanceof RuleNodeId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.RULE_NODE, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Then EntityId return {@link TenantId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_thenEntityIdReturnTenantId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Then EntityId return {@link WidgetsBundleId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_thenEntityIdReturnWidgetsBundleId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityType(EntityType.WIDGETS_BUNDLE);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setTenantId(null);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    EntityId entityId = entityViewEntity.toEntityView().getEntityId();
    assertTrue(entityId instanceof WidgetsBundleId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals(EntityType.WIDGETS_BUNDLE, entityId.getEntityType());
    assertTrue(entityId.isNullUid());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_thenReturnNotTenantIdNullUid() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    UUID tenantId = UUID.randomUUID();
    entityViewEntity.setTenantId(tenantId);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys("foo");

    // Act and Assert
    TenantId tenantId2 = entityViewEntity.toEntityView().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_thenReturnNotTenantIdNullUid2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    UUID tenantId = UUID.randomUUID();
    entityViewEntity.setTenantId(tenantId);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys("42");

    // Act and Assert
    TenantId tenantId2 = entityViewEntity.toEntityView().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toEntityView()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toEntityView()}
   */
  @Test
  public void testToEntityView_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setEntityId(null);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setCustomerId(null);
    entityViewEntity.setExternalId(null);
    entityViewEntity.setKeys(null);

    // Act and Assert
    TenantId tenantId = entityViewEntity.toEntityView().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#canEqual(Object)}.
   * <ul>
   *   <li>When {@link EntityViewEntity#EntityViewEntity()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#canEqual(Object)}
   */
  @Test
  public void testCanEqual_whenEntityViewEntity_thenReturnTrue() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act and Assert
    assertTrue(entityViewEntity.canEqual(new EntityViewEntity()));
  }

  /**
   * Test {@link AbstractEntityViewEntity#canEqual(Object)}.
   * <ul>
   *   <li>When {@code Other}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#canEqual(Object)}
   */
  @Test
  public void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new EntityViewEntity()).canEqual("Other"));
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}, and
   * {@link AbstractEntityViewEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    EntityViewEntity entityViewEntity2 = new EntityViewEntity();

    // Act and Assert
    assertEquals(entityViewEntity, entityViewEntity2);
    int expectedHashCodeResult = entityViewEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityViewEntity2.hashCode());
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}, and
   * {@link AbstractEntityViewEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act and Assert
    assertEquals(entityViewEntity, entityViewEntity);
    int expectedHashCodeResult = entityViewEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityViewEntity.hashCode());
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

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
    assertNotEquals(entityViewEntity, assetEntity);
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    EntityViewEntity entityViewEntity2 = mock(EntityViewEntity.class);
    when(entityViewEntity2.getVersion()).thenReturn(1L);
    when(entityViewEntity2.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityViewEntity2.getCreatedTime()).thenReturn(1L);
    when(entityViewEntity2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityViewEntity, entityViewEntity2);
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewEntity(), null);
  }

  /**
   * Test {@link AbstractEntityViewEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewEntity(), "Different type to AbstractEntityViewEntity");
  }

  /**
   * Test {@link AbstractEntityViewEntity#getAdditionalInfo()}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#getAdditionalInfo()}
   */
  @Test
  public void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull((new EntityViewEntity()).getAdditionalInfo());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getCustomerId()}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#getCustomerId()}
   */
  @Test
  public void testGetCustomerId() {
    // Arrange, Act and Assert
    assertNull((new EntityViewEntity()).getCustomerId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getEndTs()}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#getEndTs()}
   */
  @Test
  public void testGetEndTs() {
    // Arrange, Act and Assert
    assertEquals(0L, (new EntityViewEntity()).getEndTs());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getEntityId()}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#getEntityId()}
   */
  @Test
  public void testGetEntityId() {
    // Arrange, Act and Assert
    assertNull((new EntityViewEntity()).getEntityId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getEntityType()}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertNull((new EntityViewEntity()).getEntityType());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getExternalId()}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#getExternalId()}
   */
  @Test
  public void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new EntityViewEntity()).getExternalId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getKeys()}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#getKeys()}
   */
  @Test
  public void testGetKeys() {
    // Arrange, Act and Assert
    assertNull((new EntityViewEntity()).getKeys());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getName()}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull((new EntityViewEntity()).getName());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getStartTs()}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#getStartTs()}
   */
  @Test
  public void testGetStartTs() {
    // Arrange, Act and Assert
    assertEquals(0L, (new EntityViewEntity()).getStartTs());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getTenantId()}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#getTenantId()}
   */
  @Test
  public void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull((new EntityViewEntity()).getTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#getType()}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange, Act and Assert
    assertNull((new EntityViewEntity()).getType());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setAdditionalInfo(JsonNode)}.
   * <p>
   * Method under test:
   * {@link AbstractEntityViewEntity#setAdditionalInfo(JsonNode)}
   */
  @Test
  public void testSetAdditionalInfo() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    JsonNode additionalInfo = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    entityViewEntity.setAdditionalInfo(additionalInfo);

    // Assert
    assertSame(additionalInfo, entityViewEntity.toData().getAdditionalInfo());
    assertSame(additionalInfo, entityViewEntity.getAdditionalInfo());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setCustomerId(UUID)}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#setCustomerId(UUID)}
   */
  @Test
  public void testSetCustomerId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    UUID customerId = ModelConstants.NULL_UUID;

    // Act
    entityViewEntity.setCustomerId(customerId);

    // Assert
    CustomerId customerId2 = entityViewEntity.toData().getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    assertTrue(customerId2.isNullUid());
    assertSame(customerId, customerId2.getId());
    assertSame(customerId, entityViewEntity.getCustomerId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setEndTs(long)}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#setEndTs(long)}
   */
  @Test
  public void testSetEndTs() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act
    entityViewEntity.setEndTs(1L);

    // Assert
    assertEquals(1L, entityViewEntity.toData().getEndTimeMs());
    assertEquals(1L, entityViewEntity.getEndTs());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setEntityId(UUID)}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#setEntityId(UUID)}
   */
  @Test
  public void testSetEntityId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    UUID entityId = ModelConstants.NULL_UUID;

    // Act
    entityViewEntity.setEntityId(entityId);

    // Assert
    assertSame(entityId, entityViewEntity.getEntityId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setEntityType(EntityType)}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#setEntityType(EntityType)}
   */
  @Test
  public void testSetEntityType() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act
    entityViewEntity.setEntityType(EntityType.TENANT);

    // Assert
    assertEquals(EntityType.TENANT, entityViewEntity.getEntityType());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setExternalId(UUID)}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#setExternalId(UUID)}
   */
  @Test
  public void testSetExternalId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    entityViewEntity.setExternalId(externalId);

    // Assert
    EntityViewId externalId2 = entityViewEntity.toData().getExternalId();
    assertEquals(EntityType.ENTITY_VIEW, externalId2.getEntityType());
    assertTrue(externalId2.isNullUid());
    assertSame(externalId, externalId2.getId());
    assertSame(externalId, entityViewEntity.getExternalId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setKeys(String)}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#setKeys(String)}
   */
  @Test
  public void testSetKeys() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act
    entityViewEntity.setKeys("Keys");

    // Assert
    assertEquals("Keys", entityViewEntity.getKeys());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setName(String)}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#setName(String)}
   */
  @Test
  public void testSetName() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act
    entityViewEntity.setName("Name");

    // Assert
    assertEquals("Name", entityViewEntity.toData().getName());
    assertEquals("Name", entityViewEntity.getName());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setStartTs(long)}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#setStartTs(long)}
   */
  @Test
  public void testSetStartTs() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act
    entityViewEntity.setStartTs(1L);

    // Assert
    assertEquals(1L, entityViewEntity.toData().getStartTimeMs());
    assertEquals(1L, entityViewEntity.getStartTs());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setTenantId(UUID)}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#setTenantId(UUID)}
   */
  @Test
  public void testSetTenantId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    entityViewEntity.setTenantId(tenantId);

    // Assert
    TenantId tenantId2 = entityViewEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertSame(tenantId, entityViewEntity.getTenantId());
  }

  /**
   * Test {@link AbstractEntityViewEntity#setType(String)}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#setType(String)}
   */
  @Test
  public void testSetType() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();

    // Act
    entityViewEntity.setType("Type");

    // Assert
    assertEquals("Type", entityViewEntity.toData().getType());
    assertEquals("Type", entityViewEntity.getType());
  }

  /**
   * Test {@link AbstractEntityViewEntity#toString()}.
   * <p>
   * Method under test: {@link AbstractEntityViewEntity#toString()}
   */
  @Test
  public void testToString() {
    // Arrange, Act and Assert
    assertEquals("EntityViewEntity()", (new EntityViewEntity()).toString());
  }
}
