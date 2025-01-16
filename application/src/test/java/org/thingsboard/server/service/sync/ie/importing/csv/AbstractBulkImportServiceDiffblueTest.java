package org.thingsboard.server.service.sync.ie.importing.csv;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LazilyParsedNumber;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.HasAdditionalInfo;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.oauth2.OAuth2Client;
import org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportColumnType;
import org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportRequest;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.service.asset.AssetBulkImportService;
import org.thingsboard.server.service.entitiy.asset.DefaultTbAssetService;
import org.thingsboard.server.service.sync.ie.importing.csv.AbstractBulkImportService.EntityData;
import org.thingsboard.server.service.sync.ie.importing.csv.AbstractBulkImportService.ParsedValue;

class AbstractBulkImportServiceDiffblueTest {
  /**
   * Test EntityData {@link EntityData#equals(Object)}, and
   * {@link EntityData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractBulkImportService.EntityData#equals(Object)}
   *   <li>{@link AbstractBulkImportService.EntityData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test EntityData equals(Object), and hashCode(); when other is equal; then return equal")
  void testEntityDataEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AbstractBulkImportService.EntityData entityData = new AbstractBulkImportService.EntityData();
    entityData.setLineNumber(2);

    AbstractBulkImportService.EntityData entityData2 = new AbstractBulkImportService.EntityData();
    entityData2.setLineNumber(2);

    // Act and Assert
    assertEquals(entityData, entityData2);
    int expectedHashCodeResult = entityData.hashCode();
    assertEquals(expectedHashCodeResult, entityData2.hashCode());
  }

  /**
   * Test EntityData {@link EntityData#equals(Object)}, and
   * {@link EntityData#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractBulkImportService.EntityData#equals(Object)}
   *   <li>{@link AbstractBulkImportService.EntityData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test EntityData equals(Object), and hashCode(); when other is same; then return equal")
  void testEntityDataEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AbstractBulkImportService.EntityData entityData = new AbstractBulkImportService.EntityData();
    entityData.setLineNumber(2);

    // Act and Assert
    assertEquals(entityData, entityData);
    int expectedHashCodeResult = entityData.hashCode();
    assertEquals(expectedHashCodeResult, entityData.hashCode());
  }

  /**
   * Test EntityData {@link EntityData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService.EntityData#equals(Object)}
   */
  @Test
  @DisplayName("Test EntityData equals(Object); when other is different; then return not equal")
  void testEntityDataEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AbstractBulkImportService.EntityData entityData = new AbstractBulkImportService.EntityData();
    entityData.setLineNumber(10);

    AbstractBulkImportService.EntityData entityData2 = new AbstractBulkImportService.EntityData();
    entityData2.setLineNumber(2);

    // Act and Assert
    assertNotEquals(entityData, entityData2);
  }

  /**
   * Test EntityData {@link EntityData#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService.EntityData#equals(Object)}
   */
  @Test
  @DisplayName("Test EntityData equals(Object); when other is 'null'; then return not equal")
  void testEntityDataEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AbstractBulkImportService.EntityData entityData = new AbstractBulkImportService.EntityData();
    entityData.setLineNumber(2);

    // Act and Assert
    assertNotEquals(entityData, null);
  }

  /**
   * Test EntityData {@link EntityData#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService.EntityData#equals(Object)}
   */
  @Test
  @DisplayName("Test EntityData equals(Object); when other is wrong type; then return not equal")
  void testEntityDataEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AbstractBulkImportService.EntityData entityData = new AbstractBulkImportService.EntityData();
    entityData.setLineNumber(2);

    // Act and Assert
    assertNotEquals(entityData, "Different type to EntityData");
  }

  /**
   * Test EntityData getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link AbstractBulkImportService.EntityData}
   *   <li>{@link AbstractBulkImportService.EntityData#setLineNumber(int)}
   *   <li>{@link AbstractBulkImportService.EntityData#toString()}
   *   <li>{@link AbstractBulkImportService.EntityData#getFields()}
   *   <li>{@link AbstractBulkImportService.EntityData#getKvs()}
   *   <li>{@link AbstractBulkImportService.EntityData#getLineNumber()}
   * </ul>
   */
  @Test
  @DisplayName("Test EntityData getters and setters")
  void testEntityDataGettersAndSetters() {
    // Arrange and Act
    AbstractBulkImportService.EntityData actualEntityData = new AbstractBulkImportService.EntityData();
    actualEntityData.setLineNumber(2);
    String actualToStringResult = actualEntityData.toString();
    Map<BulkImportColumnType, String> actualFields = actualEntityData.getFields();
    Map<BulkImportRequest.ColumnMapping, AbstractBulkImportService.ParsedValue> actualKvs = actualEntityData.getKvs();

    // Assert that nothing has changed
    assertEquals("AbstractBulkImportService.EntityData(fields={}, kvs={}, lineNumber=2)", actualToStringResult);
    assertEquals(2, actualEntityData.getLineNumber());
    assertTrue(actualFields.isEmpty());
    assertTrue(actualKvs.isEmpty());
  }

  /**
   * Test
   * {@link AbstractBulkImportService#getOrCreateAdditionalInfoObj(HasAdditionalInfo)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link JsonNode#isNull()} return
   * {@code true}.</li>
   *   <li>Then calls {@link JsonNode#isNull()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService#getOrCreateAdditionalInfoObj(HasAdditionalInfo)}
   */
  @Test
  @DisplayName("Test getOrCreateAdditionalInfoObj(HasAdditionalInfo); given ArrayNode isNull() return 'true'; then calls isNull()")
  void testGetOrCreateAdditionalInfoObj_givenArrayNodeIsNullReturnTrue_thenCallsIsNull() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());
    AssetBulkImportService assetBulkImportService = new AssetBulkImportService(assetService, tbAssetService,
        new AssetProfileServiceImpl());
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.isNull()).thenReturn(true);
    HasAdditionalInfo entity = mock(HasAdditionalInfo.class);
    when(entity.getAdditionalInfo()).thenReturn(arrayNode);

    // Act
    ObjectNode actualOrCreateAdditionalInfoObj = assetBulkImportService.getOrCreateAdditionalInfoObj(entity);

    // Assert
    verify(arrayNode).isNull();
    verify(entity, atLeast(1)).getAdditionalInfo();
    JsonParser traverseResult = actualOrCreateAdditionalInfoObj.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", actualOrCreateAdditionalInfoObj.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
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
    assertEquals(0, actualOrCreateAdditionalInfoObj.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, actualOrCreateAdditionalInfoObj.getNodeType());
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
    assertFalse(actualOrCreateAdditionalInfoObj.isArray());
    assertFalse(actualOrCreateAdditionalInfoObj.isBigDecimal());
    assertFalse(actualOrCreateAdditionalInfoObj.isBigInteger());
    assertFalse(actualOrCreateAdditionalInfoObj.isBinary());
    assertFalse(actualOrCreateAdditionalInfoObj.isBoolean());
    assertFalse(actualOrCreateAdditionalInfoObj.isDouble());
    assertFalse(actualOrCreateAdditionalInfoObj.isFloat());
    assertFalse(actualOrCreateAdditionalInfoObj.isFloatingPointNumber());
    assertFalse(actualOrCreateAdditionalInfoObj.isInt());
    assertFalse(actualOrCreateAdditionalInfoObj.isIntegralNumber());
    assertFalse(actualOrCreateAdditionalInfoObj.isLong());
    assertFalse(actualOrCreateAdditionalInfoObj.isMissingNode());
    assertFalse(actualOrCreateAdditionalInfoObj.isNull());
    assertFalse(actualOrCreateAdditionalInfoObj.isNumber());
    assertFalse(actualOrCreateAdditionalInfoObj.isPojo());
    assertFalse(actualOrCreateAdditionalInfoObj.isShort());
    assertFalse(actualOrCreateAdditionalInfoObj.isTextual());
    assertFalse(actualOrCreateAdditionalInfoObj.isValueNode());
    assertFalse(actualOrCreateAdditionalInfoObj.iterator().hasNext());
    assertTrue(actualOrCreateAdditionalInfoObj.isContainerNode());
    assertTrue(actualOrCreateAdditionalInfoObj.isEmpty());
    assertTrue(actualOrCreateAdditionalInfoObj.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test
   * {@link AbstractBulkImportService#getOrCreateAdditionalInfoObj(HasAdditionalInfo)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link OAuth2Client#OAuth2Client()} AdditionalInfo is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService#getOrCreateAdditionalInfoObj(HasAdditionalInfo)}
   */
  @Test
  @DisplayName("Test getOrCreateAdditionalInfoObj(HasAdditionalInfo); given 'null'; when OAuth2Client() AdditionalInfo is 'null'")
  void testGetOrCreateAdditionalInfoObj_givenNull_whenOAuth2ClientAdditionalInfoIsNull() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());
    AssetBulkImportService assetBulkImportService = new AssetBulkImportService(assetService, tbAssetService,
        new AssetProfileServiceImpl());

    OAuth2Client entity = new OAuth2Client();
    entity.setAdditionalInfo(null);

    // Act
    ObjectNode actualOrCreateAdditionalInfoObj = assetBulkImportService.getOrCreateAdditionalInfoObj(entity);

    // Assert
    JsonParser traverseResult = actualOrCreateAdditionalInfoObj.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", actualOrCreateAdditionalInfoObj.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
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
    assertEquals(0, actualOrCreateAdditionalInfoObj.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, actualOrCreateAdditionalInfoObj.getNodeType());
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
    assertFalse(actualOrCreateAdditionalInfoObj.isArray());
    assertFalse(actualOrCreateAdditionalInfoObj.isBigDecimal());
    assertFalse(actualOrCreateAdditionalInfoObj.isBigInteger());
    assertFalse(actualOrCreateAdditionalInfoObj.isBinary());
    assertFalse(actualOrCreateAdditionalInfoObj.isBoolean());
    assertFalse(actualOrCreateAdditionalInfoObj.isDouble());
    assertFalse(actualOrCreateAdditionalInfoObj.isFloat());
    assertFalse(actualOrCreateAdditionalInfoObj.isFloatingPointNumber());
    assertFalse(actualOrCreateAdditionalInfoObj.isInt());
    assertFalse(actualOrCreateAdditionalInfoObj.isIntegralNumber());
    assertFalse(actualOrCreateAdditionalInfoObj.isLong());
    assertFalse(actualOrCreateAdditionalInfoObj.isMissingNode());
    assertFalse(actualOrCreateAdditionalInfoObj.isNull());
    assertFalse(actualOrCreateAdditionalInfoObj.isNumber());
    assertFalse(actualOrCreateAdditionalInfoObj.isPojo());
    assertFalse(actualOrCreateAdditionalInfoObj.isShort());
    assertFalse(actualOrCreateAdditionalInfoObj.isTextual());
    assertFalse(actualOrCreateAdditionalInfoObj.isValueNode());
    assertFalse(actualOrCreateAdditionalInfoObj.iterator().hasNext());
    assertTrue(actualOrCreateAdditionalInfoObj.isContainerNode());
    assertTrue(actualOrCreateAdditionalInfoObj.isEmpty());
    assertTrue(actualOrCreateAdditionalInfoObj.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test
   * {@link AbstractBulkImportService#getOrCreateAdditionalInfoObj(HasAdditionalInfo)}.
   * <ul>
   *   <li>When {@link OAuth2Client#OAuth2Client()} AdditionalInfo is Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService#getOrCreateAdditionalInfoObj(HasAdditionalInfo)}
   */
  @Test
  @DisplayName("Test getOrCreateAdditionalInfoObj(HasAdditionalInfo); when OAuth2Client() AdditionalInfo is Instance")
  void testGetOrCreateAdditionalInfoObj_whenOAuth2ClientAdditionalInfoIsInstance() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BaseAssetService assetService = new BaseAssetService();
    DefaultTbAssetService tbAssetService = new DefaultTbAssetService(new BaseAssetService());
    AssetBulkImportService assetBulkImportService = new AssetBulkImportService(assetService, tbAssetService,
        new AssetProfileServiceImpl());

    OAuth2Client entity = new OAuth2Client();
    entity.setAdditionalInfo(NullNode.getInstance());

    // Act
    ObjectNode actualOrCreateAdditionalInfoObj = assetBulkImportService.getOrCreateAdditionalInfoObj(entity);

    // Assert
    JsonParser traverseResult = actualOrCreateAdditionalInfoObj.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{ }", actualOrCreateAdditionalInfoObj.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
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
    assertEquals(0, actualOrCreateAdditionalInfoObj.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, actualOrCreateAdditionalInfoObj.getNodeType());
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
    assertFalse(actualOrCreateAdditionalInfoObj.isArray());
    assertFalse(actualOrCreateAdditionalInfoObj.isBigDecimal());
    assertFalse(actualOrCreateAdditionalInfoObj.isBigInteger());
    assertFalse(actualOrCreateAdditionalInfoObj.isBinary());
    assertFalse(actualOrCreateAdditionalInfoObj.isBoolean());
    assertFalse(actualOrCreateAdditionalInfoObj.isDouble());
    assertFalse(actualOrCreateAdditionalInfoObj.isFloat());
    assertFalse(actualOrCreateAdditionalInfoObj.isFloatingPointNumber());
    assertFalse(actualOrCreateAdditionalInfoObj.isInt());
    assertFalse(actualOrCreateAdditionalInfoObj.isIntegralNumber());
    assertFalse(actualOrCreateAdditionalInfoObj.isLong());
    assertFalse(actualOrCreateAdditionalInfoObj.isMissingNode());
    assertFalse(actualOrCreateAdditionalInfoObj.isNull());
    assertFalse(actualOrCreateAdditionalInfoObj.isNumber());
    assertFalse(actualOrCreateAdditionalInfoObj.isPojo());
    assertFalse(actualOrCreateAdditionalInfoObj.isShort());
    assertFalse(actualOrCreateAdditionalInfoObj.isTextual());
    assertFalse(actualOrCreateAdditionalInfoObj.isValueNode());
    assertFalse(actualOrCreateAdditionalInfoObj.iterator().hasNext());
    assertTrue(actualOrCreateAdditionalInfoObj.isContainerNode());
    assertTrue(actualOrCreateAdditionalInfoObj.isEmpty());
    assertTrue(actualOrCreateAdditionalInfoObj.isObject());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}, and
   * {@link ParsedValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractBulkImportService.ParsedValue#equals(Object)}
   *   <li>{@link AbstractBulkImportService.ParsedValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object), and hashCode(); when other is equal; then return equal")
  void testParsedValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AbstractBulkImportService.ParsedValue parsedValue = new AbstractBulkImportService.ParsedValue("Value",
        DataType.BOOLEAN);
    AbstractBulkImportService.ParsedValue parsedValue2 = new AbstractBulkImportService.ParsedValue("Value",
        DataType.BOOLEAN);

    // Act and Assert
    assertEquals(parsedValue, parsedValue2);
    int expectedHashCodeResult = parsedValue.hashCode();
    assertEquals(expectedHashCodeResult, parsedValue2.hashCode());
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}, and
   * {@link ParsedValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractBulkImportService.ParsedValue#equals(Object)}
   *   <li>{@link AbstractBulkImportService.ParsedValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object), and hashCode(); when other is equal; then return equal")
  void testParsedValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AbstractBulkImportService.ParsedValue parsedValue = new AbstractBulkImportService.ParsedValue(null,
        DataType.BOOLEAN);
    AbstractBulkImportService.ParsedValue parsedValue2 = new AbstractBulkImportService.ParsedValue(null,
        DataType.BOOLEAN);

    // Act and Assert
    assertEquals(parsedValue, parsedValue2);
    int expectedHashCodeResult = parsedValue.hashCode();
    assertEquals(expectedHashCodeResult, parsedValue2.hashCode());
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}, and
   * {@link ParsedValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractBulkImportService.ParsedValue#equals(Object)}
   *   <li>{@link AbstractBulkImportService.ParsedValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object), and hashCode(); when other is equal; then return equal")
  void testParsedValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AbstractBulkImportService.ParsedValue parsedValue = new AbstractBulkImportService.ParsedValue("Value", null);
    AbstractBulkImportService.ParsedValue parsedValue2 = new AbstractBulkImportService.ParsedValue("Value", null);

    // Act and Assert
    assertEquals(parsedValue, parsedValue2);
    int expectedHashCodeResult = parsedValue.hashCode();
    assertEquals(expectedHashCodeResult, parsedValue2.hashCode());
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}, and
   * {@link ParsedValue#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AbstractBulkImportService.ParsedValue#equals(Object)}
   *   <li>{@link AbstractBulkImportService.ParsedValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object), and hashCode(); when other is same; then return equal")
  void testParsedValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AbstractBulkImportService.ParsedValue parsedValue = new AbstractBulkImportService.ParsedValue("Value",
        DataType.BOOLEAN);

    // Act and Assert
    assertEquals(parsedValue, parsedValue);
    int expectedHashCodeResult = parsedValue.hashCode();
    assertEquals(expectedHashCodeResult, parsedValue.hashCode());
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService.ParsedValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object); when other is different; then return not equal")
  void testParsedValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AbstractBulkImportService.ParsedValue parsedValue = new AbstractBulkImportService.ParsedValue(42, DataType.BOOLEAN);

    // Act and Assert
    assertNotEquals(parsedValue, new AbstractBulkImportService.ParsedValue("Value", DataType.BOOLEAN));
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService.ParsedValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object); when other is different; then return not equal")
  void testParsedValueEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AbstractBulkImportService.ParsedValue parsedValue = new AbstractBulkImportService.ParsedValue(null,
        DataType.BOOLEAN);

    // Act and Assert
    assertNotEquals(parsedValue, new AbstractBulkImportService.ParsedValue("Value", DataType.BOOLEAN));
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService.ParsedValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object); when other is different; then return not equal")
  void testParsedValueEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AbstractBulkImportService.ParsedValue parsedValue = new AbstractBulkImportService.ParsedValue("Value", null);

    // Act and Assert
    assertNotEquals(parsedValue, new AbstractBulkImportService.ParsedValue("Value", DataType.BOOLEAN));
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService.ParsedValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object); when other is different; then return not equal")
  void testParsedValueEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AbstractBulkImportService.ParsedValue parsedValue = new AbstractBulkImportService.ParsedValue("Value",
        DataType.LONG);

    // Act and Assert
    assertNotEquals(parsedValue, new AbstractBulkImportService.ParsedValue("Value", DataType.BOOLEAN));
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService.ParsedValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object); when other is different; then return not equal")
  void testParsedValueEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AbstractBulkImportService.ParsedValue parsedValue = new AbstractBulkImportService.ParsedValue(
        new AbstractBulkImportService.ParsedValue("Value", DataType.BOOLEAN), DataType.BOOLEAN);

    // Act and Assert
    assertNotEquals(parsedValue, new AbstractBulkImportService.ParsedValue(null, DataType.BOOLEAN));
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService.ParsedValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object); when other is 'null'; then return not equal")
  void testParsedValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AbstractBulkImportService.ParsedValue("Value", DataType.BOOLEAN), null);
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService.ParsedValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object); when other is wrong type; then return not equal")
  void testParsedValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AbstractBulkImportService.ParsedValue("Value", DataType.BOOLEAN),
        "Different type to ParsedValue");
  }

  /**
   * Test ParsedValue getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link AbstractBulkImportService.ParsedValue#ParsedValue(Object, DataType)}
   *   <li>{@link AbstractBulkImportService.ParsedValue#toString()}
   *   <li>{@link AbstractBulkImportService.ParsedValue#getDataType()}
   *   <li>{@link AbstractBulkImportService.ParsedValue#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test ParsedValue getters and setters")
  void testParsedValueGettersAndSetters() {
    // Arrange and Act
    AbstractBulkImportService.ParsedValue actualParsedValue = new AbstractBulkImportService.ParsedValue("Value",
        DataType.BOOLEAN);
    String actualToStringResult = actualParsedValue.toString();
    DataType actualDataType = actualParsedValue.getDataType();

    // Assert
    assertEquals("AbstractBulkImportService.ParsedValue(value=Value, dataType=BOOLEAN)", actualToStringResult);
    assertEquals("Value", actualParsedValue.getValue());
    assertEquals(DataType.BOOLEAN, actualDataType);
  }

  /**
   * Test ParsedValue {@link ParsedValue#stringValue()}.
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService.ParsedValue#stringValue()}
   */
  @Test
  @DisplayName("Test ParsedValue stringValue()")
  void testParsedValueStringValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Value", (new AbstractBulkImportService.ParsedValue("Value", DataType.BOOLEAN)).stringValue());
  }

  /**
   * Test ParsedValue {@link ParsedValue#toJsonPrimitive()}.
   * <ul>
   *   <li>Then AsNumber return {@link LazilyParsedNumber}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService.ParsedValue#toJsonPrimitive()}
   */
  @Test
  @DisplayName("Test ParsedValue toJsonPrimitive(); then AsNumber return LazilyParsedNumber")
  void testParsedValueToJsonPrimitive_thenAsNumberReturnLazilyParsedNumber() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    JsonPrimitive actualToJsonPrimitiveResult = (new AbstractBulkImportService.ParsedValue("Value", DataType.STRING))
        .toJsonPrimitive();

    // Assert
    Number asNumber = actualToJsonPrimitiveResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("Value", actualToJsonPrimitiveResult.getAsString());
    assertEquals("Value", asNumber.toString());
    assertEquals('V', actualToJsonPrimitiveResult.getAsCharacter());
    assertTrue(actualToJsonPrimitiveResult.isString());
    assertSame(actualToJsonPrimitiveResult, actualToJsonPrimitiveResult.getAsJsonPrimitive());
  }

  /**
   * Test ParsedValue {@link ParsedValue#toJsonPrimitive()}.
   * <ul>
   *   <li>Then return AsCharacter is {@code t}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService.ParsedValue#toJsonPrimitive()}
   */
  @Test
  @DisplayName("Test ParsedValue toJsonPrimitive(); then return AsCharacter is 't'")
  void testParsedValueToJsonPrimitive_thenReturnAsCharacterIsT() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    JsonPrimitive actualToJsonPrimitiveResult = (new AbstractBulkImportService.ParsedValue(true, DataType.BOOLEAN))
        .toJsonPrimitive();

    // Assert
    assertEquals('t', actualToJsonPrimitiveResult.getAsCharacter());
    assertTrue(actualToJsonPrimitiveResult.getAsBoolean());
    assertTrue(actualToJsonPrimitiveResult.isBoolean());
    String expectedAsString = Boolean.TRUE.toString();
    assertEquals(expectedAsString, actualToJsonPrimitiveResult.getAsString());
    assertSame(actualToJsonPrimitiveResult, actualToJsonPrimitiveResult.getAsJsonPrimitive());
  }

  /**
   * Test ParsedValue {@link ParsedValue#toJsonPrimitive()}.
   * <ul>
   *   <li>Then return AsString is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService.ParsedValue#toJsonPrimitive()}
   */
  @Test
  @DisplayName("Test ParsedValue toJsonPrimitive(); then return AsString is '42'")
  void testParsedValueToJsonPrimitive_thenReturnAsStringIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    JsonPrimitive actualToJsonPrimitiveResult = (new AbstractBulkImportService.ParsedValue(42L, DataType.LONG))
        .toJsonPrimitive();

    // Assert
    assertEquals("42", actualToJsonPrimitiveResult.getAsString());
    BigInteger asBigInteger = actualToJsonPrimitiveResult.getAsBigInteger();
    assertEquals("42", asBigInteger.toString());
    assertEquals('4', actualToJsonPrimitiveResult.getAsCharacter());
    assertEquals(1, asBigInteger.getLowestSetBit());
    assertEquals(1, asBigInteger.signum());
    assertEquals(42, actualToJsonPrimitiveResult.getAsInt());
    assertEquals(42.0d, actualToJsonPrimitiveResult.getAsDouble());
    assertEquals(42.0f, actualToJsonPrimitiveResult.getAsFloat());
    assertEquals(42L, actualToJsonPrimitiveResult.getAsLong());
    assertEquals((short) 42, actualToJsonPrimitiveResult.getAsShort());
    BigDecimal expectedAsBigDecimal = new BigDecimal("42");
    assertEquals(expectedAsBigDecimal, actualToJsonPrimitiveResult.getAsBigDecimal());
    assertEquals('*', actualToJsonPrimitiveResult.getAsByte());
    assertSame(actualToJsonPrimitiveResult, actualToJsonPrimitiveResult.getAsJsonPrimitive());
    assertArrayEquals(new byte[]{'*'}, asBigInteger.toByteArray());
  }

  /**
   * Test ParsedValue {@link ParsedValue#toJsonPrimitive()}.
   * <ul>
   *   <li>Then return AsString is {@code 10.0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService.ParsedValue#toJsonPrimitive()}
   */
  @Test
  @DisplayName("Test ParsedValue toJsonPrimitive(); then return AsString is '10.0'")
  void testParsedValueToJsonPrimitive_thenReturnAsStringIs100() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    JsonPrimitive actualToJsonPrimitiveResult = (new AbstractBulkImportService.ParsedValue(10.0d, DataType.DOUBLE))
        .toJsonPrimitive();

    // Assert
    assertEquals("10.0", actualToJsonPrimitiveResult.getAsString());
    assertEquals('1', actualToJsonPrimitiveResult.getAsCharacter());
    assertEquals(10, actualToJsonPrimitiveResult.getAsInt());
    assertEquals(10.0d, actualToJsonPrimitiveResult.getAsDouble());
    assertEquals(10.0d, actualToJsonPrimitiveResult.getAsNumber().doubleValue());
    assertEquals(10.0f, actualToJsonPrimitiveResult.getAsFloat());
    assertEquals(10L, actualToJsonPrimitiveResult.getAsLong());
    assertEquals((short) 10, actualToJsonPrimitiveResult.getAsShort());
    BigDecimal expectedAsBigDecimal = new BigDecimal("10.0");
    assertEquals(expectedAsBigDecimal, actualToJsonPrimitiveResult.getAsBigDecimal());
    assertEquals('\n', actualToJsonPrimitiveResult.getAsByte());
    assertSame(actualToJsonPrimitiveResult, actualToJsonPrimitiveResult.getAsJsonPrimitive());
  }

  /**
   * Test ParsedValue {@link ParsedValue#toJsonPrimitive()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractBulkImportService.ParsedValue#toJsonPrimitive()}
   */
  @Test
  @DisplayName("Test ParsedValue toJsonPrimitive(); then return 'null'")
  void testParsedValueToJsonPrimitive_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new AbstractBulkImportService.ParsedValue("Value", DataType.JSON)).toJsonPrimitive());
  }
}
