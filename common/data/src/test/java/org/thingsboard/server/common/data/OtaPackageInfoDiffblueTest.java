package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OtaPackageInfoDiffblueTest {
  /**
   * Test {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return HasData.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}
   */
  @Test
  @DisplayName("Test new OtaPackageInfo(OtaPackageInfo); given 'true'; then return HasData")
  void testNewOtaPackageInfo_givenTrue_thenReturnHasData() throws IOException {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setHasData(true);

    // Act
    OtaPackageInfo actualOtaPackageInfo = new OtaPackageInfo(otaPackageInfo);

    // Assert
    JsonNode additionalInfo = actualOtaPackageInfo.getAdditionalInfo();
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
    assertNull(actualOtaPackageInfo.getDataSize());
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
    assertNull(actualOtaPackageInfo.getChecksum());
    assertNull(actualOtaPackageInfo.getContentType());
    assertNull(actualOtaPackageInfo.getFileName());
    assertNull(actualOtaPackageInfo.getName());
    assertNull(actualOtaPackageInfo.getTag());
    assertNull(actualOtaPackageInfo.getTitle());
    assertNull(actualOtaPackageInfo.getUrl());
    assertNull(actualOtaPackageInfo.getVersion());
    assertNull(actualOtaPackageInfo.getUuidId());
    assertNull(actualOtaPackageInfo.getDeviceProfileId());
    assertNull(actualOtaPackageInfo.getId());
    assertNull(actualOtaPackageInfo.getTenantId());
    assertNull(actualOtaPackageInfo.getChecksumAlgorithm());
    assertNull(actualOtaPackageInfo.getType());
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
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualOtaPackageInfo.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
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
    assertFalse(actualOtaPackageInfo.hasUrl());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertTrue(actualOtaPackageInfo.isHasData());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}.
   * <ul>
   *   <li>When {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)} with
   * otaPackageInfo is {@link OtaPackageInfo#OtaPackageInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}
   */
  @Test
  @DisplayName("Test new OtaPackageInfo(OtaPackageInfo); when OtaPackageInfo(OtaPackageInfo) with otaPackageInfo is OtaPackageInfo()")
  void testNewOtaPackageInfo_whenOtaPackageInfoWithOtaPackageInfoIsOtaPackageInfo() throws IOException {
    // Arrange and Act
    OtaPackageInfo actualOtaPackageInfo = new OtaPackageInfo(new OtaPackageInfo(new OtaPackageInfo()));

    // Assert
    JsonNode additionalInfo = actualOtaPackageInfo.getAdditionalInfo();
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
    assertNull(actualOtaPackageInfo.getDataSize());
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
    assertNull(actualOtaPackageInfo.getChecksum());
    assertNull(actualOtaPackageInfo.getContentType());
    assertNull(actualOtaPackageInfo.getFileName());
    assertNull(actualOtaPackageInfo.getName());
    assertNull(actualOtaPackageInfo.getTag());
    assertNull(actualOtaPackageInfo.getTitle());
    assertNull(actualOtaPackageInfo.getUrl());
    assertNull(actualOtaPackageInfo.getVersion());
    assertNull(actualOtaPackageInfo.getUuidId());
    assertNull(actualOtaPackageInfo.getDeviceProfileId());
    assertNull(actualOtaPackageInfo.getId());
    assertNull(actualOtaPackageInfo.getTenantId());
    assertNull(actualOtaPackageInfo.getChecksumAlgorithm());
    assertNull(actualOtaPackageInfo.getType());
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
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualOtaPackageInfo.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
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
    assertFalse(actualOtaPackageInfo.hasUrl());
    assertFalse(actualOtaPackageInfo.isHasData());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}.
   * <ul>
   *   <li>When {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)} with
   * otaPackageInfo is {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}
   */
  @Test
  @DisplayName("Test new OtaPackageInfo(OtaPackageInfo); when OtaPackageInfo(OtaPackageInfo) with otaPackageInfo is OtaPackageInfo(OtaPackageInfo)")
  void testNewOtaPackageInfo_whenOtaPackageInfoWithOtaPackageInfoIsOtaPackageInfo2() throws IOException {
    // Arrange and Act
    OtaPackageInfo actualOtaPackageInfo = new OtaPackageInfo(
        new OtaPackageInfo(new OtaPackageInfo(new OtaPackageInfo())));

    // Assert
    JsonNode additionalInfo = actualOtaPackageInfo.getAdditionalInfo();
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
    assertNull(actualOtaPackageInfo.getDataSize());
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
    assertNull(actualOtaPackageInfo.getChecksum());
    assertNull(actualOtaPackageInfo.getContentType());
    assertNull(actualOtaPackageInfo.getFileName());
    assertNull(actualOtaPackageInfo.getName());
    assertNull(actualOtaPackageInfo.getTag());
    assertNull(actualOtaPackageInfo.getTitle());
    assertNull(actualOtaPackageInfo.getUrl());
    assertNull(actualOtaPackageInfo.getVersion());
    assertNull(actualOtaPackageInfo.getUuidId());
    assertNull(actualOtaPackageInfo.getDeviceProfileId());
    assertNull(actualOtaPackageInfo.getId());
    assertNull(actualOtaPackageInfo.getTenantId());
    assertNull(actualOtaPackageInfo.getChecksumAlgorithm());
    assertNull(actualOtaPackageInfo.getType());
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
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualOtaPackageInfo.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
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
    assertFalse(actualOtaPackageInfo.hasUrl());
    assertFalse(actualOtaPackageInfo.isHasData());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}.
   * <ul>
   *   <li>When {@link OtaPackageInfo#OtaPackageInfo()}.</li>
   *   <li>Then return not HasData.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}
   */
  @Test
  @DisplayName("Test new OtaPackageInfo(OtaPackageInfo); when OtaPackageInfo(); then return not HasData")
  void testNewOtaPackageInfo_whenOtaPackageInfo_thenReturnNotHasData() throws IOException {
    // Arrange and Act
    OtaPackageInfo actualOtaPackageInfo = new OtaPackageInfo(new OtaPackageInfo());

    // Assert
    JsonNode additionalInfo = actualOtaPackageInfo.getAdditionalInfo();
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
    assertNull(actualOtaPackageInfo.getDataSize());
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
    assertNull(actualOtaPackageInfo.getChecksum());
    assertNull(actualOtaPackageInfo.getContentType());
    assertNull(actualOtaPackageInfo.getFileName());
    assertNull(actualOtaPackageInfo.getName());
    assertNull(actualOtaPackageInfo.getTag());
    assertNull(actualOtaPackageInfo.getTitle());
    assertNull(actualOtaPackageInfo.getUrl());
    assertNull(actualOtaPackageInfo.getVersion());
    assertNull(actualOtaPackageInfo.getUuidId());
    assertNull(actualOtaPackageInfo.getDeviceProfileId());
    assertNull(actualOtaPackageInfo.getId());
    assertNull(actualOtaPackageInfo.getTenantId());
    assertNull(actualOtaPackageInfo.getChecksumAlgorithm());
    assertNull(actualOtaPackageInfo.getType());
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
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualOtaPackageInfo.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
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
    assertFalse(actualOtaPackageInfo.hasUrl());
    assertFalse(actualOtaPackageInfo.isHasData());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link OtaPackageInfo#getId()}.
   * <p>
   * Method under test: {@link OtaPackageInfo#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new OtaPackageInfo()).getId());
  }

  /**
   * Test {@link OtaPackageInfo#getCreatedTime()}.
   * <p>
   * Method under test: {@link OtaPackageInfo#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new OtaPackageInfo()).getCreatedTime());
  }

  /**
   * Test {@link OtaPackageInfo#hasUrl()}.
   * <ul>
   *   <li>Given {@link OtaPackageInfo#OtaPackageInfo()} Url is
   * {@link DataConstants#DEFAULT_SECRET_KEY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#hasUrl()}
   */
  @Test
  @DisplayName("Test hasUrl(); given OtaPackageInfo() Url is DEFAULT_SECRET_KEY; then return 'false'")
  void testHasUrl_givenOtaPackageInfoUrlIsDefault_secret_key_thenReturnFalse() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setUrl(DataConstants.DEFAULT_SECRET_KEY);

    // Act and Assert
    assertFalse(otaPackageInfo.hasUrl());
  }

  /**
   * Test {@link OtaPackageInfo#hasUrl()}.
   * <ul>
   *   <li>Given {@link OtaPackageInfo#OtaPackageInfo()} Url is {@code foo}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#hasUrl()}
   */
  @Test
  @DisplayName("Test hasUrl(); given OtaPackageInfo() Url is 'foo'; then return 'true'")
  void testHasUrl_givenOtaPackageInfoUrlIsFoo_thenReturnTrue() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setUrl("foo");

    // Act and Assert
    assertTrue(otaPackageInfo.hasUrl());
  }

  /**
   * Test {@link OtaPackageInfo#hasUrl()}.
   * <ul>
   *   <li>Given {@link OtaPackageInfo#OtaPackageInfo()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#hasUrl()}
   */
  @Test
  @DisplayName("Test hasUrl(); given OtaPackageInfo(); then return 'false'")
  void testHasUrl_givenOtaPackageInfo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OtaPackageInfo()).hasUrl());
  }

  /**
   * Test {@link OtaPackageInfo#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)} with
   * otaPackageInfo is {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given OtaPackageInfo(OtaPackageInfo) with otaPackageInfo is OtaPackageInfo(OtaPackageInfo)")
  void testGetAdditionalInfo_givenOtaPackageInfoWithOtaPackageInfoIsOtaPackageInfo() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new OtaPackageInfo(new OtaPackageInfo(new OtaPackageInfo()))).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link OtaPackageInfo#getAdditionalInfo()}.
   * <ul>
   *   <li>Given {@link OtaPackageInfo#OtaPackageInfo()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); given OtaPackageInfo(); then return 'null'")
  void testGetAdditionalInfo_givenOtaPackageInfo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new OtaPackageInfo()).getAdditionalInfo());
  }

  /**
   * Test {@link OtaPackageInfo#getAdditionalInfo()}.
   * <ul>
   *   <li>Then return {@link NullNode#instance}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#getAdditionalInfo()}
   */
  @Test
  @DisplayName("Test getAdditionalInfo(); then return instance")
  void testGetAdditionalInfo_thenReturnInstance() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new OtaPackageInfo(new OtaPackageInfo())).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}, and
   * {@link OtaPackageInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtaPackageInfo#equals(Object)}
   *   <li>{@link OtaPackageInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    OtaPackageInfo otaPackageInfo2 = new OtaPackageInfo();

    // Act and Assert
    assertEquals(otaPackageInfo, otaPackageInfo2);
    int expectedHashCodeResult = otaPackageInfo.hashCode();
    assertEquals(expectedHashCodeResult, otaPackageInfo2.hashCode());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}, and
   * {@link OtaPackageInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtaPackageInfo#equals(Object)}
   *   <li>{@link OtaPackageInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();

    // Act and Assert
    assertEquals(otaPackageInfo, otaPackageInfo);
    int expectedHashCodeResult = otaPackageInfo.hashCode();
    assertEquals(expectedHashCodeResult, otaPackageInfo.hashCode());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OtaPackage otaPackage = new OtaPackage();

    // Act and Assert
    assertNotEquals(otaPackage, new OtaPackageInfo());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo(new OtaPackageInfo());

    // Act and Assert
    assertNotEquals(otaPackageInfo, new OtaPackageInfo());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();

    // Act and Assert
    assertNotEquals(otaPackageInfo, new OtaPackage());
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(otaPackageInfo, otaPackage);
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OtaPackageInfo(), null);
  }

  /**
   * Test {@link OtaPackageInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OtaPackageInfo(), "Different type to OtaPackageInfo");
  }
}
