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
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.widget.WidgetType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class WidgetTypeEntityDiffblueTest {
  /**
   * Test {@link WidgetTypeEntity#equals(Object)}, and
   * {@link WidgetTypeEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeEntity#equals(Object)}
   *   <li>{@link WidgetTypeEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    WidgetTypeEntity widgetTypeEntity2 = new WidgetTypeEntity();
    widgetTypeEntity2.setCreatedTime(1L);
    widgetTypeEntity2.setDeprecated(true);
    widgetTypeEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity2.setFqn("Fqn");
    widgetTypeEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setName("Name");
    widgetTypeEntity2.setScada(true);
    widgetTypeEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(widgetTypeEntity, widgetTypeEntity2);
    int expectedHashCodeResult = widgetTypeEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeEntity2.hashCode());
  }

  /**
   * Test {@link WidgetTypeEntity#equals(Object)}, and
   * {@link WidgetTypeEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeEntity#equals(Object)}
   *   <li>{@link WidgetTypeEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    // Act and Assert
    assertEquals(widgetTypeEntity, widgetTypeEntity);
    int expectedHashCodeResult = widgetTypeEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeEntity.hashCode());
  }

  /**
   * Test {@link WidgetTypeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(3L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    WidgetTypeEntity widgetTypeEntity2 = new WidgetTypeEntity();
    widgetTypeEntity2.setCreatedTime(1L);
    widgetTypeEntity2.setDeprecated(true);
    widgetTypeEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity2.setFqn("Fqn");
    widgetTypeEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setName("Name");
    widgetTypeEntity2.setScada(true);
    widgetTypeEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeEntity, widgetTypeEntity2);
  }

  /**
   * Test {@link WidgetTypeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(MissingNode.getInstance());
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    WidgetTypeEntity widgetTypeEntity2 = new WidgetTypeEntity();
    widgetTypeEntity2.setCreatedTime(1L);
    widgetTypeEntity2.setDeprecated(true);
    widgetTypeEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity2.setFqn("Fqn");
    widgetTypeEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setName("Name");
    widgetTypeEntity2.setScada(true);
    widgetTypeEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeEntity, widgetTypeEntity2);
  }

  /**
   * Test {@link WidgetTypeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(null);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    WidgetTypeEntity widgetTypeEntity2 = new WidgetTypeEntity();
    widgetTypeEntity2.setCreatedTime(1L);
    widgetTypeEntity2.setDeprecated(true);
    widgetTypeEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity2.setFqn("Fqn");
    widgetTypeEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setName("Name");
    widgetTypeEntity2.setScada(true);
    widgetTypeEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeEntity, widgetTypeEntity2);
  }

  /**
   * Test {@link WidgetTypeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(mock(JsonNode.class));
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    WidgetTypeEntity widgetTypeEntity2 = new WidgetTypeEntity();
    widgetTypeEntity2.setCreatedTime(1L);
    widgetTypeEntity2.setDeprecated(true);
    widgetTypeEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity2.setFqn("Fqn");
    widgetTypeEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setName("Name");
    widgetTypeEntity2.setScada(true);
    widgetTypeEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeEntity, widgetTypeEntity2);
  }

  /**
   * Test {@link WidgetTypeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeEntity, null);
  }

  /**
   * Test {@link WidgetTypeEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeEntity, "Different type to WidgetTypeEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link WidgetTypeEntity}
   *   <li>{@link WidgetTypeEntity#setDescriptor(JsonNode)}
   *   <li>{@link WidgetTypeEntity#toString()}
   *   <li>{@link WidgetTypeEntity#getDescriptor()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    WidgetTypeEntity actualWidgetTypeEntity = new WidgetTypeEntity();
    JsonNode descriptor = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualWidgetTypeEntity.setDescriptor(descriptor);
    String actualToStringResult = actualWidgetTypeEntity.toString();
    JsonNode actualDescriptor = actualWidgetTypeEntity.getDescriptor();

    // Assert that nothing has changed
    assertEquals("WidgetTypeEntity(descriptor={\"isPublic\":true})", actualToStringResult);
    assertEquals(0L, actualWidgetTypeEntity.getCreatedTime());
    assertFalse(actualWidgetTypeEntity.isDeprecated());
    assertFalse(actualWidgetTypeEntity.isScada());
    assertSame(descriptor, actualDescriptor);
  }

  /**
   * Test {@link WidgetTypeEntity#toData()}.
   * <ul>
   *   <li>Given {@link WidgetTypeEntity} (default constructor).</li>
   *   <li>Then return Descriptor is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeEntity#toData()}
   */
  @Test
  public void testToData_givenWidgetTypeEntity_thenReturnDescriptorIsNull() {
    // Arrange and Act
    WidgetType actualToDataResult = (new WidgetTypeEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getDescriptor());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getFqn());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    WidgetTypeId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(id.isNullUid());
    assertFalse(actualToDataResult.isDeprecated());
    assertFalse(actualToDataResult.isScada());
  }

  /**
   * Test {@link WidgetTypeEntity#toData()}.
   * <ul>
   *   <li>Then Descriptor iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeEntity#toData()}
   */
  @Test
  public void testToData_thenDescriptorIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);
    widgetTypeEntity.setTenantId(null);

    // Act
    WidgetType actualToDataResult = widgetTypeEntity.toData();

    // Assert
    JsonNode descriptor = actualToDataResult.getDescriptor();
    Iterator<JsonNode> iteratorResult = descriptor.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(descriptor instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = descriptor.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Fqn", actualToDataResult.getFqn());
    assertEquals("Name", actualToDataResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", descriptor.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, descriptor.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, descriptor.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(descriptor.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(descriptor.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(descriptor.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(descriptor.isBinary());
    assertFalse(descriptor.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(descriptor.isDouble());
    assertFalse(descriptor.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(descriptor.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(descriptor.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(descriptor.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(descriptor.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(descriptor.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(descriptor.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(descriptor.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(descriptor.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(descriptor.isTextual());
    assertFalse(descriptor.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(descriptor.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(descriptor.isObject());
    assertTrue(nextResult.isValueNode());
    WidgetTypeId id = actualToDataResult.getId();
    assertTrue(id.isNullUid());
    assertTrue(actualToDataResult.isDeprecated());
    assertTrue(actualToDataResult.isScada());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link WidgetTypeEntity#toData()}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeEntity#toData()}
   */
  @Test
  public void testToData_thenReturnNotTenantIdNullUid() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);
    UUID tenantId = UUID.randomUUID();
    widgetTypeEntity.setTenantId(tenantId);

    // Act and Assert
    TenantId tenantId2 = widgetTypeEntity.toData().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link WidgetTypeEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    WidgetTypeEntity widgetTypeEntity = new WidgetTypeEntity();
    widgetTypeEntity.setCreatedTime(1L);
    widgetTypeEntity.setDeprecated(true);
    widgetTypeEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeEntity.setFqn("Fqn");
    widgetTypeEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeEntity.setName("Name");
    widgetTypeEntity.setScada(true);
    widgetTypeEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeEntity.setVersion(1L);
    widgetTypeEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    TenantId tenantId = widgetTypeEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
