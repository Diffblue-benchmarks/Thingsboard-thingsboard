/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OtaPackageInfoDiffblueTest {
  /**
   * Method under test: {@link OtaPackageInfo#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new OtaPackageInfo()).getId());
  }

  /**
   * Method under test: {@link OtaPackageInfo#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new OtaPackageInfo()).getCreatedTime());
  }

  /**
   * Method under test: {@link OtaPackageInfo#hasUrl()}
   */
  @Test
  void testHasUrl() {
    // Arrange, Act and Assert
    assertFalse((new OtaPackageInfo()).hasUrl());
  }

  /**
   * Method under test: {@link OtaPackageInfo#hasUrl()}
   */
  @Test
  void testHasUrl2() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setUrl(DataConstants.DEFAULT_SECRET_KEY);

    // Act and Assert
    assertFalse(otaPackageInfo.hasUrl());
  }

  /**
   * Method under test: {@link OtaPackageInfo#hasUrl()}
   */
  @Test
  void testHasUrl3() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setUrl("foo");

    // Act and Assert
    assertTrue(otaPackageInfo.hasUrl());
  }

  /**
   * Method under test: {@link OtaPackageInfo#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull((new OtaPackageInfo()).getAdditionalInfo());
  }

  /**
   * Method under test: {@link OtaPackageInfo#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo2() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new OtaPackageInfo(new OtaPackageInfo())).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Method under test: {@link OtaPackageInfo#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo3() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new OtaPackageInfo(new OtaPackageInfo(new OtaPackageInfo()))).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OtaPackageInfo#equals(Object)}
   *   <li>{@link OtaPackageInfo#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link OtaPackageInfo#equals(Object)}
   *   <li>{@link OtaPackageInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();

    // Act and Assert
    assertEquals(otaPackageInfo, otaPackageInfo);
    int expectedHashCodeResult = otaPackageInfo.hashCode();
    assertEquals(expectedHashCodeResult, otaPackageInfo.hashCode());
  }

  /**
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OtaPackage otaPackage = new OtaPackage();

    // Act and Assert
    assertNotEquals(otaPackage, new OtaPackageInfo());
  }

  /**
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo(new OtaPackageInfo());

    // Act and Assert
    assertNotEquals(otaPackageInfo, new OtaPackageInfo());
  }

  /**
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();

    // Act and Assert
    assertNotEquals(otaPackageInfo, new OtaPackage());
  }

  /**
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    OtaPackage otaPackage = mock(OtaPackage.class);
    when(otaPackage.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(otaPackageInfo, otaPackage);
  }

  /**
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OtaPackageInfo(), null);
  }

  /**
   * Method under test: {@link OtaPackageInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OtaPackageInfo(), "Different type to OtaPackageInfo");
  }

  /**
   * Method under test: {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}
   */
  @Test
  void testNewOtaPackageInfo() throws IOException {
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
   * Method under test: {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}
   */
  @Test
  void testNewOtaPackageInfo2() throws IOException {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo(new OtaPackageInfo());

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
    assertNull(otaPackageInfo.getDataSize());
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
    assertNull(otaPackageInfo.getChecksum());
    assertNull(actualOtaPackageInfo.getChecksum());
    assertNull(otaPackageInfo.getContentType());
    assertNull(actualOtaPackageInfo.getContentType());
    assertNull(otaPackageInfo.getFileName());
    assertNull(actualOtaPackageInfo.getFileName());
    assertNull(otaPackageInfo.getName());
    assertNull(actualOtaPackageInfo.getName());
    assertNull(otaPackageInfo.getTag());
    assertNull(actualOtaPackageInfo.getTag());
    assertNull(otaPackageInfo.getTitle());
    assertNull(actualOtaPackageInfo.getTitle());
    assertNull(otaPackageInfo.getUrl());
    assertNull(actualOtaPackageInfo.getUrl());
    assertNull(otaPackageInfo.getVersion());
    assertNull(actualOtaPackageInfo.getVersion());
    assertNull(otaPackageInfo.getUuidId());
    assertNull(actualOtaPackageInfo.getUuidId());
    assertNull(otaPackageInfo.getDeviceProfileId());
    assertNull(actualOtaPackageInfo.getDeviceProfileId());
    assertNull(otaPackageInfo.getId());
    assertNull(actualOtaPackageInfo.getId());
    assertNull(otaPackageInfo.getTenantId());
    assertNull(actualOtaPackageInfo.getTenantId());
    assertNull(otaPackageInfo.getChecksumAlgorithm());
    assertNull(actualOtaPackageInfo.getChecksumAlgorithm());
    assertNull(otaPackageInfo.getType());
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
    assertEquals(0L, otaPackageInfo.getCreatedTime());
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
    assertFalse(otaPackageInfo.hasUrl());
    assertFalse(actualOtaPackageInfo.hasUrl());
    assertFalse(otaPackageInfo.isHasData());
    assertFalse(actualOtaPackageInfo.isHasData());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}
   */
  @Test
  void testNewOtaPackageInfo3() throws IOException {
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
   * Method under test: {@link OtaPackageInfo#OtaPackageInfo(OtaPackageInfo)}
   */
  @Test
  void testNewOtaPackageInfo4() throws IOException {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo(new OtaPackageInfo(new OtaPackageInfo()));

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
    assertNull(otaPackageInfo.getDataSize());
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
    assertNull(otaPackageInfo.getChecksum());
    assertNull(actualOtaPackageInfo.getChecksum());
    assertNull(otaPackageInfo.getContentType());
    assertNull(actualOtaPackageInfo.getContentType());
    assertNull(otaPackageInfo.getFileName());
    assertNull(actualOtaPackageInfo.getFileName());
    assertNull(otaPackageInfo.getName());
    assertNull(actualOtaPackageInfo.getName());
    assertNull(otaPackageInfo.getTag());
    assertNull(actualOtaPackageInfo.getTag());
    assertNull(otaPackageInfo.getTitle());
    assertNull(actualOtaPackageInfo.getTitle());
    assertNull(otaPackageInfo.getUrl());
    assertNull(actualOtaPackageInfo.getUrl());
    assertNull(otaPackageInfo.getVersion());
    assertNull(actualOtaPackageInfo.getVersion());
    assertNull(otaPackageInfo.getUuidId());
    assertNull(actualOtaPackageInfo.getUuidId());
    assertNull(otaPackageInfo.getDeviceProfileId());
    assertNull(actualOtaPackageInfo.getDeviceProfileId());
    assertNull(otaPackageInfo.getId());
    assertNull(actualOtaPackageInfo.getId());
    assertNull(otaPackageInfo.getTenantId());
    assertNull(actualOtaPackageInfo.getTenantId());
    assertNull(otaPackageInfo.getChecksumAlgorithm());
    assertNull(actualOtaPackageInfo.getChecksumAlgorithm());
    assertNull(otaPackageInfo.getType());
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
    assertEquals(0L, otaPackageInfo.getCreatedTime());
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
    assertFalse(otaPackageInfo.hasUrl());
    assertFalse(actualOtaPackageInfo.hasUrl());
    assertFalse(otaPackageInfo.isHasData());
    assertFalse(actualOtaPackageInfo.isHasData());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }
}
