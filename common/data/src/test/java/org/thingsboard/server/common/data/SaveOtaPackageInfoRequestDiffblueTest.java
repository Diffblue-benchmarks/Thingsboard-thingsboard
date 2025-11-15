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

class SaveOtaPackageInfoRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SaveOtaPackageInfoRequest#equals(Object)}
   *   <li>{@link SaveOtaPackageInfoRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SaveOtaPackageInfoRequest saveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest();
    SaveOtaPackageInfoRequest saveOtaPackageInfoRequest2 = new SaveOtaPackageInfoRequest();

    // Act and Assert
    assertEquals(saveOtaPackageInfoRequest, saveOtaPackageInfoRequest2);
    int expectedHashCodeResult = saveOtaPackageInfoRequest.hashCode();
    assertEquals(expectedHashCodeResult, saveOtaPackageInfoRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SaveOtaPackageInfoRequest#equals(Object)}
   *   <li>{@link SaveOtaPackageInfoRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SaveOtaPackageInfoRequest saveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest();

    // Act and Assert
    assertEquals(saveOtaPackageInfoRequest, saveOtaPackageInfoRequest);
    int expectedHashCodeResult = saveOtaPackageInfoRequest.hashCode();
    assertEquals(expectedHashCodeResult, saveOtaPackageInfoRequest.hashCode());
  }

  /**
   * Method under test: {@link SaveOtaPackageInfoRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SaveOtaPackageInfoRequest saveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest(new OtaPackageInfo(), true);

    // Act and Assert
    assertNotEquals(saveOtaPackageInfoRequest, new SaveOtaPackageInfoRequest());
  }

  /**
   * Method under test: {@link SaveOtaPackageInfoRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new SaveOtaPackageInfoRequest(), mock(OtaPackage.class));
  }

  /**
   * Method under test: {@link SaveOtaPackageInfoRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SaveOtaPackageInfoRequest saveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest();
    saveOtaPackageInfoRequest.setUsesUrl(true);

    // Act and Assert
    assertNotEquals(saveOtaPackageInfoRequest, new SaveOtaPackageInfoRequest());
  }

  /**
   * Method under test: {@link SaveOtaPackageInfoRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SaveOtaPackageInfoRequest(), null);
  }

  /**
   * Method under test: {@link SaveOtaPackageInfoRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SaveOtaPackageInfoRequest(), "Different type to SaveOtaPackageInfoRequest");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest()}
   *   <li>{@link SaveOtaPackageInfoRequest#setUsesUrl(boolean)}
   *   <li>{@link SaveOtaPackageInfoRequest#toString()}
   *   <li>{@link SaveOtaPackageInfoRequest#isUsesUrl()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SaveOtaPackageInfoRequest actualSaveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest();
    actualSaveOtaPackageInfoRequest.setUsesUrl(true);
    String actualToStringResult = actualSaveOtaPackageInfoRequest.toString();
    boolean actualIsUsesUrlResult = actualSaveOtaPackageInfoRequest.isUsesUrl();

    // Assert that nothing has changed
    assertEquals("SaveOtaPackageInfoRequest(usesUrl=true)", actualToStringResult);
    assertEquals(0L, actualSaveOtaPackageInfoRequest.getCreatedTime());
    assertFalse(actualSaveOtaPackageInfoRequest.isHasData());
    assertTrue(actualIsUsesUrlResult);
  }

  /**
   * Method under test:
   * {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(OtaPackageInfo, boolean)}
   */
  @Test
  void testNewSaveOtaPackageInfoRequest() throws IOException {
    // Arrange and Act
    SaveOtaPackageInfoRequest actualSaveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest(new OtaPackageInfo(),
        true);

    // Assert
    JsonNode additionalInfo = actualSaveOtaPackageInfoRequest.getAdditionalInfo();
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
    assertNull(actualSaveOtaPackageInfoRequest.getDataSize());
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
    assertNull(actualSaveOtaPackageInfoRequest.getChecksum());
    assertNull(actualSaveOtaPackageInfoRequest.getContentType());
    assertNull(actualSaveOtaPackageInfoRequest.getFileName());
    assertNull(actualSaveOtaPackageInfoRequest.getName());
    assertNull(actualSaveOtaPackageInfoRequest.getTag());
    assertNull(actualSaveOtaPackageInfoRequest.getTitle());
    assertNull(actualSaveOtaPackageInfoRequest.getUrl());
    assertNull(actualSaveOtaPackageInfoRequest.getVersion());
    assertNull(actualSaveOtaPackageInfoRequest.getUuidId());
    assertNull(actualSaveOtaPackageInfoRequest.getDeviceProfileId());
    assertNull(actualSaveOtaPackageInfoRequest.getId());
    assertNull(actualSaveOtaPackageInfoRequest.getTenantId());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksumAlgorithm());
    assertNull(actualSaveOtaPackageInfoRequest.getType());
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
    assertEquals(0L, actualSaveOtaPackageInfoRequest.getCreatedTime());
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
    assertFalse(actualSaveOtaPackageInfoRequest.hasUrl());
    assertFalse(actualSaveOtaPackageInfoRequest.isHasData());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertTrue(actualSaveOtaPackageInfoRequest.isUsesUrl());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(OtaPackageInfo, boolean)}
   */
  @Test
  void testNewSaveOtaPackageInfoRequest2() throws IOException {
    // Arrange and Act
    SaveOtaPackageInfoRequest actualSaveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest(
        new OtaPackageInfo(new OtaPackageInfo()), true);

    // Assert
    JsonNode additionalInfo = actualSaveOtaPackageInfoRequest.getAdditionalInfo();
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
    assertNull(actualSaveOtaPackageInfoRequest.getDataSize());
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
    assertNull(actualSaveOtaPackageInfoRequest.getChecksum());
    assertNull(actualSaveOtaPackageInfoRequest.getContentType());
    assertNull(actualSaveOtaPackageInfoRequest.getFileName());
    assertNull(actualSaveOtaPackageInfoRequest.getName());
    assertNull(actualSaveOtaPackageInfoRequest.getTag());
    assertNull(actualSaveOtaPackageInfoRequest.getTitle());
    assertNull(actualSaveOtaPackageInfoRequest.getUrl());
    assertNull(actualSaveOtaPackageInfoRequest.getVersion());
    assertNull(actualSaveOtaPackageInfoRequest.getUuidId());
    assertNull(actualSaveOtaPackageInfoRequest.getDeviceProfileId());
    assertNull(actualSaveOtaPackageInfoRequest.getId());
    assertNull(actualSaveOtaPackageInfoRequest.getTenantId());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksumAlgorithm());
    assertNull(actualSaveOtaPackageInfoRequest.getType());
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
    assertEquals(0L, actualSaveOtaPackageInfoRequest.getCreatedTime());
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
    assertFalse(actualSaveOtaPackageInfoRequest.hasUrl());
    assertFalse(actualSaveOtaPackageInfoRequest.isHasData());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertTrue(actualSaveOtaPackageInfoRequest.isUsesUrl());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(OtaPackageInfo, boolean)}
   */
  @Test
  void testNewSaveOtaPackageInfoRequest3() throws IOException {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setHasData(true);

    // Act
    SaveOtaPackageInfoRequest actualSaveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest(otaPackageInfo, true);

    // Assert
    JsonNode additionalInfo = actualSaveOtaPackageInfoRequest.getAdditionalInfo();
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
    assertNull(actualSaveOtaPackageInfoRequest.getDataSize());
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
    assertNull(actualSaveOtaPackageInfoRequest.getChecksum());
    assertNull(actualSaveOtaPackageInfoRequest.getContentType());
    assertNull(actualSaveOtaPackageInfoRequest.getFileName());
    assertNull(actualSaveOtaPackageInfoRequest.getName());
    assertNull(actualSaveOtaPackageInfoRequest.getTag());
    assertNull(actualSaveOtaPackageInfoRequest.getTitle());
    assertNull(actualSaveOtaPackageInfoRequest.getUrl());
    assertNull(actualSaveOtaPackageInfoRequest.getVersion());
    assertNull(actualSaveOtaPackageInfoRequest.getUuidId());
    assertNull(actualSaveOtaPackageInfoRequest.getDeviceProfileId());
    assertNull(actualSaveOtaPackageInfoRequest.getId());
    assertNull(actualSaveOtaPackageInfoRequest.getTenantId());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksumAlgorithm());
    assertNull(actualSaveOtaPackageInfoRequest.getType());
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
    assertEquals(0L, actualSaveOtaPackageInfoRequest.getCreatedTime());
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
    assertFalse(actualSaveOtaPackageInfoRequest.hasUrl());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertTrue(actualSaveOtaPackageInfoRequest.isHasData());
    assertTrue(actualSaveOtaPackageInfoRequest.isUsesUrl());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(OtaPackageInfo, boolean)}
   */
  @Test
  void testNewSaveOtaPackageInfoRequest4() throws IOException {
    // Arrange and Act
    SaveOtaPackageInfoRequest actualSaveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest(
        new OtaPackageInfo(new OtaPackageInfo(new OtaPackageInfo())), true);

    // Assert
    JsonNode additionalInfo = actualSaveOtaPackageInfoRequest.getAdditionalInfo();
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
    assertNull(actualSaveOtaPackageInfoRequest.getDataSize());
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
    assertNull(actualSaveOtaPackageInfoRequest.getChecksum());
    assertNull(actualSaveOtaPackageInfoRequest.getContentType());
    assertNull(actualSaveOtaPackageInfoRequest.getFileName());
    assertNull(actualSaveOtaPackageInfoRequest.getName());
    assertNull(actualSaveOtaPackageInfoRequest.getTag());
    assertNull(actualSaveOtaPackageInfoRequest.getTitle());
    assertNull(actualSaveOtaPackageInfoRequest.getUrl());
    assertNull(actualSaveOtaPackageInfoRequest.getVersion());
    assertNull(actualSaveOtaPackageInfoRequest.getUuidId());
    assertNull(actualSaveOtaPackageInfoRequest.getDeviceProfileId());
    assertNull(actualSaveOtaPackageInfoRequest.getId());
    assertNull(actualSaveOtaPackageInfoRequest.getTenantId());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksumAlgorithm());
    assertNull(actualSaveOtaPackageInfoRequest.getType());
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
    assertEquals(0L, actualSaveOtaPackageInfoRequest.getCreatedTime());
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
    assertFalse(actualSaveOtaPackageInfoRequest.hasUrl());
    assertFalse(actualSaveOtaPackageInfoRequest.isHasData());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertTrue(actualSaveOtaPackageInfoRequest.isUsesUrl());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(SaveOtaPackageInfoRequest)}
   */
  @Test
  void testNewSaveOtaPackageInfoRequest5() throws IOException {
    // Arrange and Act
    SaveOtaPackageInfoRequest actualSaveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest(
        new SaveOtaPackageInfoRequest());

    // Assert
    JsonNode additionalInfo = actualSaveOtaPackageInfoRequest.getAdditionalInfo();
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
    assertNull(actualSaveOtaPackageInfoRequest.getDataSize());
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
    assertNull(actualSaveOtaPackageInfoRequest.getChecksum());
    assertNull(actualSaveOtaPackageInfoRequest.getContentType());
    assertNull(actualSaveOtaPackageInfoRequest.getFileName());
    assertNull(actualSaveOtaPackageInfoRequest.getName());
    assertNull(actualSaveOtaPackageInfoRequest.getTag());
    assertNull(actualSaveOtaPackageInfoRequest.getTitle());
    assertNull(actualSaveOtaPackageInfoRequest.getUrl());
    assertNull(actualSaveOtaPackageInfoRequest.getVersion());
    assertNull(actualSaveOtaPackageInfoRequest.getUuidId());
    assertNull(actualSaveOtaPackageInfoRequest.getDeviceProfileId());
    assertNull(actualSaveOtaPackageInfoRequest.getId());
    assertNull(actualSaveOtaPackageInfoRequest.getTenantId());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksumAlgorithm());
    assertNull(actualSaveOtaPackageInfoRequest.getType());
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
    assertEquals(0L, actualSaveOtaPackageInfoRequest.getCreatedTime());
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
    assertFalse(actualSaveOtaPackageInfoRequest.hasUrl());
    assertFalse(actualSaveOtaPackageInfoRequest.isHasData());
    assertFalse(actualSaveOtaPackageInfoRequest.isUsesUrl());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(SaveOtaPackageInfoRequest)}
   */
  @Test
  void testNewSaveOtaPackageInfoRequest6() throws IOException {
    // Arrange and Act
    SaveOtaPackageInfoRequest actualSaveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest(
        new SaveOtaPackageInfoRequest(new OtaPackageInfo(), true));

    // Assert
    JsonNode additionalInfo = actualSaveOtaPackageInfoRequest.getAdditionalInfo();
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
    assertNull(actualSaveOtaPackageInfoRequest.getDataSize());
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
    assertNull(actualSaveOtaPackageInfoRequest.getChecksum());
    assertNull(actualSaveOtaPackageInfoRequest.getContentType());
    assertNull(actualSaveOtaPackageInfoRequest.getFileName());
    assertNull(actualSaveOtaPackageInfoRequest.getName());
    assertNull(actualSaveOtaPackageInfoRequest.getTag());
    assertNull(actualSaveOtaPackageInfoRequest.getTitle());
    assertNull(actualSaveOtaPackageInfoRequest.getUrl());
    assertNull(actualSaveOtaPackageInfoRequest.getVersion());
    assertNull(actualSaveOtaPackageInfoRequest.getUuidId());
    assertNull(actualSaveOtaPackageInfoRequest.getDeviceProfileId());
    assertNull(actualSaveOtaPackageInfoRequest.getId());
    assertNull(actualSaveOtaPackageInfoRequest.getTenantId());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksumAlgorithm());
    assertNull(actualSaveOtaPackageInfoRequest.getType());
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
    assertEquals(0L, actualSaveOtaPackageInfoRequest.getCreatedTime());
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
    assertFalse(actualSaveOtaPackageInfoRequest.hasUrl());
    assertFalse(actualSaveOtaPackageInfoRequest.isHasData());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertTrue(actualSaveOtaPackageInfoRequest.isUsesUrl());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(SaveOtaPackageInfoRequest)}
   */
  @Test
  void testNewSaveOtaPackageInfoRequest7() throws IOException {
    // Arrange and Act
    SaveOtaPackageInfoRequest actualSaveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest(
        new SaveOtaPackageInfoRequest(new OtaPackageInfo(new OtaPackageInfo()), true));

    // Assert
    JsonNode additionalInfo = actualSaveOtaPackageInfoRequest.getAdditionalInfo();
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
    assertNull(actualSaveOtaPackageInfoRequest.getDataSize());
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
    assertNull(actualSaveOtaPackageInfoRequest.getChecksum());
    assertNull(actualSaveOtaPackageInfoRequest.getContentType());
    assertNull(actualSaveOtaPackageInfoRequest.getFileName());
    assertNull(actualSaveOtaPackageInfoRequest.getName());
    assertNull(actualSaveOtaPackageInfoRequest.getTag());
    assertNull(actualSaveOtaPackageInfoRequest.getTitle());
    assertNull(actualSaveOtaPackageInfoRequest.getUrl());
    assertNull(actualSaveOtaPackageInfoRequest.getVersion());
    assertNull(actualSaveOtaPackageInfoRequest.getUuidId());
    assertNull(actualSaveOtaPackageInfoRequest.getDeviceProfileId());
    assertNull(actualSaveOtaPackageInfoRequest.getId());
    assertNull(actualSaveOtaPackageInfoRequest.getTenantId());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksumAlgorithm());
    assertNull(actualSaveOtaPackageInfoRequest.getType());
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
    assertEquals(0L, actualSaveOtaPackageInfoRequest.getCreatedTime());
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
    assertFalse(actualSaveOtaPackageInfoRequest.hasUrl());
    assertFalse(actualSaveOtaPackageInfoRequest.isHasData());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertTrue(actualSaveOtaPackageInfoRequest.isUsesUrl());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }
}
