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
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.TenantInfo;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class TenantInfoEntityDiffblueTest {
  /**
   * Test {@link TenantInfoEntity#equals(Object)}, and
   * {@link TenantInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantInfoEntity#equals(Object)}
   *   <li>{@link TenantInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity();
    TenantInfoEntity tenantInfoEntity2 = new TenantInfoEntity();

    // Act and Assert
    assertEquals(tenantInfoEntity, tenantInfoEntity2);
    int expectedHashCodeResult = tenantInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantInfoEntity2.hashCode());
  }

  /**
   * Test {@link TenantInfoEntity#equals(Object)}, and
   * {@link TenantInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantInfoEntity#equals(Object)}
   *   <li>{@link TenantInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity(new TenantEntity(), "foo.txt");
    TenantInfoEntity tenantInfoEntity2 = new TenantInfoEntity(new TenantEntity(), "foo.txt");

    // Act and Assert
    assertEquals(tenantInfoEntity, tenantInfoEntity2);
    int expectedHashCodeResult = tenantInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantInfoEntity2.hashCode());
  }

  /**
   * Test {@link TenantInfoEntity#equals(Object)}, and
   * {@link TenantInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantInfoEntity#equals(Object)}
   *   <li>{@link TenantInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity();

    // Act and Assert
    assertEquals(tenantInfoEntity, tenantInfoEntity);
    int expectedHashCodeResult = tenantInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, tenantInfoEntity.hashCode());
  }

  /**
   * Test {@link TenantInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity(new TenantEntity(), "foo.txt");

    // Act and Assert
    assertNotEquals(tenantInfoEntity, new TenantInfoEntity());
  }

  /**
   * Test {@link TenantInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity();

    // Act and Assert
    assertNotEquals(tenantInfoEntity, new TenantInfoEntity(new TenantEntity(), "foo.txt"));
  }

  /**
   * Test {@link TenantInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity();

    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(mock(JsonNode.class));
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(ModelConstants.NULL_UUID);
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");

    // Act and Assert
    assertNotEquals(tenantInfoEntity, tenantEntity);
  }

  /**
   * Test {@link TenantInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity();
    tenantInfoEntity.setTitle("Dr");

    // Act and Assert
    assertNotEquals(tenantInfoEntity, new TenantInfoEntity());
  }

  /**
   * Test {@link TenantInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantInfoEntity(), null);
  }

  /**
   * Test {@link TenantInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantInfoEntity(), "Different type to TenantInfoEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantInfoEntity#TenantInfoEntity()}
   *   <li>{@link TenantInfoEntity#setTenantProfileName(String)}
   *   <li>{@link TenantInfoEntity#toString()}
   *   <li>{@link TenantInfoEntity#getTenantProfileName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TenantInfoEntity actualTenantInfoEntity = new TenantInfoEntity();
    actualTenantInfoEntity.setTenantProfileName("foo.txt");
    String actualToStringResult = actualTenantInfoEntity.toString();

    // Assert that nothing has changed
    assertEquals("TenantInfoEntity(tenantProfileName=foo.txt)", actualToStringResult);
    assertEquals("foo.txt", actualTenantInfoEntity.getTenantProfileName());
    assertEquals(0L, actualTenantInfoEntity.getCreatedTime());
  }

  /**
   * Test {@link TenantInfoEntity#TenantInfoEntity(TenantEntity, String)}.
   * <p>
   * Method under test:
   * {@link TenantInfoEntity#TenantInfoEntity(TenantEntity, String)}
   */
  @Test
  public void testNewTenantInfoEntity() throws IOException {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("42 Main St");
    tenantEntity.setAddress2("42 Main St");
    tenantEntity.setCity("Oxford");
    tenantEntity.setCountry("GB");
    tenantEntity.setCreatedTime(1L);
    tenantEntity.setEmail("jane.doe@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("6625550144");
    tenantEntity.setRegion("us-east-2");
    tenantEntity.setState("MD");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity.setTitle("Dr");
    tenantEntity.setUuid(ModelConstants.NULL_UUID);
    tenantEntity.setVersion(1L);
    tenantEntity.setZip("21654");

    // Act
    TenantInfoEntity actualTenantInfoEntity = new TenantInfoEntity(tenantEntity, "foo.txt");

    // Assert
    JsonNode additionalInfo = actualTenantInfoEntity.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantInfo toDataResult = actualTenantInfoEntity.toData();
    UUID uuidId = toDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    UUID id = actualTenantInfoEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("21654", toDataResult.getZip());
    assertEquals("21654", actualTenantInfoEntity.getZip());
    assertEquals("42 Main St", toDataResult.getAddress());
    assertEquals("42 Main St", toDataResult.getAddress2());
    assertEquals("42 Main St", actualTenantInfoEntity.getAddress());
    assertEquals("42 Main St", actualTenantInfoEntity.getAddress2());
    assertEquals("6625550144", toDataResult.getPhone());
    assertEquals("6625550144", actualTenantInfoEntity.getPhone());
    assertEquals("Dr", toDataResult.getName());
    assertEquals("Dr", toDataResult.getTitle());
    assertEquals("Dr", actualTenantInfoEntity.getTitle());
    assertEquals("GB", toDataResult.getCountry());
    assertEquals("GB", actualTenantInfoEntity.getCountry());
    assertEquals("MD", toDataResult.getState());
    assertEquals("MD", actualTenantInfoEntity.getState());
    assertEquals("Oxford", toDataResult.getCity());
    assertEquals("Oxford", actualTenantInfoEntity.getCity());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("foo.txt", toDataResult.getTenantProfileName());
    assertEquals("foo.txt", actualTenantInfoEntity.getTenantProfileName());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("jane.doe@example.org", toDataResult.getEmail());
    assertEquals("jane.doe@example.org", actualTenantInfoEntity.getEmail());
    assertEquals("us-east-2", toDataResult.getRegion());
    assertEquals("us-east-2", actualTenantInfoEntity.getRegion());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
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
    assertEquals(1, additionalInfo.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, toDataResult.getVersion().longValue());
    assertEquals(1L, actualTenantInfoEntity.getVersion().longValue());
    assertEquals(1L, toDataResult.getCreatedTime());
    assertEquals(1L, actualTenantInfoEntity.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    TenantId id2 = toDataResult.getId();
    assertEquals(EntityType.TENANT, id2.getEntityType());
    TenantProfileId tenantProfileId = toDataResult.getTenantProfileId();
    assertEquals(EntityType.TENANT_PROFILE, tenantProfileId.getEntityType());
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
    assertFalse(additionalInfo.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(additionalInfo.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(additionalInfo.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(additionalInfo.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(additionalInfo.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(additionalInfo.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(additionalInfo.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(id2.isNullUid());
    assertTrue(tenantProfileId.isNullUid());
    assertTrue(id2.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(id2, toDataResult.getTenantId());
    assertSame(uuidId, id2.getId());
    assertSame(id, tenantProfileId.getId());
    assertSame(id, actualTenantInfoEntity.getUuid());
    assertSame(id, actualTenantInfoEntity.getTenantProfileId());
    assertSame(additionalInfo, toDataResult.getAdditionalInfo());
  }

  /**
   * Test {@link TenantInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link TenantInfoEntity#TenantInfoEntity()} Uuid is
   * randomUUID.</li>
   *   <li>Then return UuidId is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantInfoEntity#toData()}
   */
  @Test
  public void testToData_givenTenantInfoEntityUuidIsRandomUUID_thenReturnUuidIdIsRandomUUID() {
    // Arrange
    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity();
    UUID id = UUID.randomUUID();
    tenantInfoEntity.setUuid(id);

    // Act
    TenantInfo actualToDataResult = tenantInfoEntity.toData();

    // Assert
    assertSame(id, actualToDataResult.getUuidId());
    assertSame(id, actualToDataResult.getId().getId());
  }

  /**
   * Test {@link TenantInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link TenantInfoEntity#TenantInfoEntity()}.</li>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantInfoEntity#toData()}
   */
  @Test
  public void testToData_givenTenantInfoEntity_thenAdditionalInfoReturnNullNode() throws IOException {
    // Arrange and Act
    TenantInfo actualToDataResult = (new TenantInfoEntity()).toData();

    // Assert
    JsonNode additionalInfo = actualToDataResult.getAdditionalInfo();
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
    assertNull(actualToDataResult.getVersion());
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
    assertNull(actualToDataResult.getAddress());
    assertNull(actualToDataResult.getAddress2());
    assertNull(actualToDataResult.getCity());
    assertNull(actualToDataResult.getCountry());
    assertNull(actualToDataResult.getEmail());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getPhone());
    assertNull(actualToDataResult.getRegion());
    assertNull(actualToDataResult.getState());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getZip());
    assertNull(actualToDataResult.getTenantProfileName());
    assertNull(actualToDataResult.getUuidId());
    TenantId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getTenantProfileId());
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
    assertEquals(0L, actualToDataResult.getCreatedTime());
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
    assertSame(id, actualToDataResult.getTenantId());
  }

  /**
   * Test {@link TenantInfoEntity#toData()}.
   * <ul>
   *   <li>Then return TenantProfileId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantProfileIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    TenantInfoEntity tenantInfoEntity = new TenantInfoEntity();
    tenantInfoEntity.setTenantProfileId(ModelConstants.NULL_UUID);

    // Act
    TenantInfo actualToDataResult = tenantInfoEntity.toData();

    // Assert
    TenantProfileId tenantProfileId = actualToDataResult.getTenantProfileId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantProfileId.getId().toString());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    assertEquals(EntityType.TENANT_PROFILE, tenantProfileId.getEntityType());
    assertTrue(tenantProfileId.isNullUid());
  }
}
