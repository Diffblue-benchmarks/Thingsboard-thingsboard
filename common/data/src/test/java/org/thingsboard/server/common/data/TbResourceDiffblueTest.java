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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TbResourceId;

class TbResourceDiffblueTest {
  /**
   * Method under test: {@link TbResource#getEncodedData()}
   */
  @Test
  void testGetEncodedData() {
    // Arrange, Act and Assert
    assertNull((new TbResource()).getEncodedData());
  }

  /**
   * Method under test: {@link TbResource#setEncodedData(String)}
   */
  @Test
  void testSetEncodedData() {
    // Arrange
    TbResource tbResource = new TbResource();

    // Act
    tbResource.setEncodedData("Data");

    // Assert
    assertEquals("Data", tbResource.getEncodedData());
    assertArrayEquals(new byte[]{'\r', -85, 'Z'}, tbResource.getData());
  }

  /**
   * Method under test: {@link TbResource#getEncodedPreview()}
   */
  @Test
  void testGetEncodedPreview() {
    // Arrange, Act and Assert
    assertNull((new TbResource()).getEncodedPreview());
  }

  /**
   * Method under test: {@link TbResource#setEncodedPreview(String)}
   */
  @Test
  void testSetEncodedPreview() {
    // Arrange
    TbResource tbResource = new TbResource();

    // Act
    tbResource.setEncodedPreview("Preview");

    // Assert
    assertEquals("Preview=", tbResource.getEncodedPreview());
    assertArrayEquals(new byte[]{'>', -73, -81, -119, -20}, tbResource.getPreview());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbResource#equals(Object)}
   *   <li>{@link TbResource#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbResource tbResource = new TbResource();
    TbResource tbResource2 = new TbResource();

    // Act and Assert
    assertEquals(tbResource, tbResource2);
    int expectedHashCodeResult = tbResource.hashCode();
    assertEquals(expectedHashCodeResult, tbResource2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbResource#equals(Object)}
   *   <li>{@link TbResource#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbResource tbResource = new TbResource();

    // Act and Assert
    assertEquals(tbResource, tbResource);
    int expectedHashCodeResult = tbResource.hashCode();
    assertEquals(expectedHashCodeResult, tbResource.hashCode());
  }

  /**
   * Method under test: {@link TbResource#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbResource tbResource = new TbResource(new TbResourceId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(tbResource, new TbResource());
  }

  /**
   * Method under test: {@link TbResource#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TbResource(), mock(AdminSettings.class));
  }

  /**
   * Method under test: {@link TbResource#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbResource tbResource = new TbResource();
    tbResource.setEncodedData("Data");

    // Act and Assert
    assertNotEquals(tbResource, new TbResource());
  }

  /**
   * Method under test: {@link TbResource#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbResource tbResource = new TbResource();
    tbResource.setEncodedPreview("Preview");

    // Act and Assert
    assertNotEquals(tbResource, new TbResource());
  }

  /**
   * Method under test: {@link TbResource#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbResource(), null);
  }

  /**
   * Method under test: {@link TbResource#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbResource(), "Different type to TbResource");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbResource#TbResource()}
   *   <li>{@link TbResource#setData(byte[])}
   *   <li>{@link TbResource#setPreview(byte[])}
   *   <li>{@link TbResource#toString()}
   *   <li>{@link TbResource#getData()}
   *   <li>{@link TbResource#getPreview()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    TbResource actualTbResource = new TbResource();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    actualTbResource.setData(data);
    byte[] preview = "AXAXAXAX".getBytes("UTF-8");
    actualTbResource.setPreview(preview);
    String actualToStringResult = actualTbResource.toString();
    byte[] actualData = actualTbResource.getData();
    byte[] actualPreview = actualTbResource.getPreview();

    // Assert that nothing has changed
    assertEquals("TbResourceInfo(tenantId=null, title=null, resourceType=null, resourceSubType=null, resourceKey=null,"
        + " isPublic=false, publicResourceKey=null, searchText=null, etag=null, fileName=null, descriptor=null,"
        + " externalId=null)", actualToStringResult);
    assertEquals(0L, actualTbResource.getCreatedTime());
    assertFalse(actualTbResource.isPublic());
    assertSame(data, actualData);
    assertSame(preview, actualPreview);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbResource#TbResource(TbResourceId)}
   *   <li>{@link TbResource#setData(byte[])}
   *   <li>{@link TbResource#setPreview(byte[])}
   *   <li>{@link TbResource#toString()}
   *   <li>{@link TbResource#getData()}
   *   <li>{@link TbResource#getPreview()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() throws UnsupportedEncodingException {
    // Arrange
    TbResourceId id = new TbResourceId(EntityId.NULL_UUID);

    // Act
    TbResource actualTbResource = new TbResource(id);
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    actualTbResource.setData(data);
    byte[] preview = "AXAXAXAX".getBytes("UTF-8");
    actualTbResource.setPreview(preview);
    String actualToStringResult = actualTbResource.toString();
    byte[] actualData = actualTbResource.getData();
    byte[] actualPreview = actualTbResource.getPreview();

    // Assert that nothing has changed
    assertEquals("TbResourceInfo(tenantId=null, title=null, resourceType=null, resourceSubType=null, resourceKey=null,"
        + " isPublic=false, publicResourceKey=null, searchText=null, etag=null, fileName=null, descriptor=null,"
        + " externalId=null)", actualToStringResult);
    assertEquals(0L, actualTbResource.getCreatedTime());
    assertFalse(actualTbResource.isPublic());
    assertSame(id, actualTbResource.getId());
    assertSame(data, actualData);
    assertSame(preview, actualPreview);
  }

  /**
   * Method under test: {@link TbResource#TbResource(TbResource)}
   */
  @Test
  void testNewTbResource() {
    // Arrange
    TbResource resource = new TbResource();

    // Act and Assert
    assertEquals(resource, new TbResource(resource));
  }

  /**
   * Method under test: {@link TbResource#TbResource(TbResource)}
   */
  @Test
  void testNewTbResource2() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setDescriptorValue("Resource");

    // Act and Assert
    assertEquals(resource, new TbResource(resource));
  }

  /**
   * Method under test: {@link TbResource#TbResource(TbResource)}
   */
  @Test
  void testNewTbResource3() {
    // Arrange
    TbResource resource = new TbResource();
    resource.setDescriptorValue(new TbResourceId(EntityId.NULL_UUID));

    // Act and Assert
    assertEquals(resource, new TbResource(resource));
  }

  /**
   * Method under test: {@link TbResource#TbResource(TbResourceInfo)}
   */
  @Test
  void testNewTbResource4() {
    // Arrange and Act
    TbResource actualTbResource = new TbResource(new TbResourceInfo());

    // Assert
    assertNull(actualTbResource.getData());
    assertNull(actualTbResource.getPreview());
    assertNull(actualTbResource.getDescriptor());
    assertNull(actualTbResource.getEncodedData());
    assertNull(actualTbResource.getEncodedPreview());
    assertNull(actualTbResource.getEtag());
    assertNull(actualTbResource.getFileName());
    assertNull(actualTbResource.getLink());
    assertNull(actualTbResource.getName());
    assertNull(actualTbResource.getPublicLink());
    assertNull(actualTbResource.getPublicResourceKey());
    assertNull(actualTbResource.getResourceKey());
    assertNull(actualTbResource.getSearchText());
    assertNull(actualTbResource.getTitle());
    assertNull(actualTbResource.getUuidId());
    assertNull(actualTbResource.getResourceSubType());
    assertNull(actualTbResource.getResourceType());
    assertNull(actualTbResource.getExternalId());
    assertNull(actualTbResource.getId());
    assertNull(actualTbResource.getTenantId());
    assertEquals(0L, actualTbResource.getCreatedTime());
    assertFalse(actualTbResource.isPublic());
  }

  /**
   * Method under test: {@link TbResource#TbResource(TbResourceInfo)}
   */
  @Test
  void testNewTbResource5() throws IOException {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();
    resourceInfo.setDescriptorValue("Resource Info");

    // Act
    TbResource actualTbResource = new TbResource(resourceInfo);

    // Assert
    JsonNode descriptor = actualTbResource.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"Resource Info\"", descriptor.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(actualTbResource.getData());
    assertNull(actualTbResource.getPreview());
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
    assertNull(actualTbResource.getEncodedData());
    assertNull(actualTbResource.getEncodedPreview());
    assertNull(actualTbResource.getEtag());
    assertNull(actualTbResource.getFileName());
    assertNull(actualTbResource.getLink());
    assertNull(actualTbResource.getName());
    assertNull(actualTbResource.getPublicLink());
    assertNull(actualTbResource.getPublicResourceKey());
    assertNull(actualTbResource.getResourceKey());
    assertNull(actualTbResource.getSearchText());
    assertNull(actualTbResource.getTitle());
    assertNull(actualTbResource.getUuidId());
    assertNull(actualTbResource.getResourceSubType());
    assertNull(actualTbResource.getResourceType());
    assertNull(actualTbResource.getExternalId());
    assertNull(actualTbResource.getId());
    assertNull(actualTbResource.getTenantId());
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
    assertEquals(0, descriptor.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, actualTbResource.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.STRING, descriptor.getNodeType());
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
    assertFalse(descriptor.isArray());
    assertFalse(descriptor.isBigDecimal());
    assertFalse(descriptor.isBigInteger());
    assertFalse(descriptor.isBinary());
    assertFalse(descriptor.isBoolean());
    assertFalse(descriptor.isContainerNode());
    assertFalse(descriptor.isDouble());
    assertFalse(descriptor.isFloat());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(descriptor.isInt());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(descriptor.isLong());
    assertFalse(descriptor.isMissingNode());
    assertFalse(descriptor.isNull());
    assertFalse(descriptor.isNumber());
    assertFalse(descriptor.isObject());
    assertFalse(descriptor.isPojo());
    assertFalse(descriptor.isShort());
    assertFalse(descriptor.iterator().hasNext());
    assertFalse(actualTbResource.isPublic());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link TbResource#TbResource(TbResourceInfo)}
   */
  @Test
  void testNewTbResource6() throws IOException {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();
    resourceInfo.setDescriptorValue(new TbResourceId(EntityId.NULL_UUID));

    // Act
    TbResource actualTbResource = new TbResource(resourceInfo);

    // Assert
    JsonNode descriptor = actualTbResource.getDescriptor();
    assertTrue(descriptor instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = descriptor.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = nextResult2.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonParser traverseResult3 = descriptor.traverse();
    assertTrue(traverseResult3 instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    JsonStreamContext parsingContext3 = traverseResult3.getParsingContext();
    assertEquals("ROOT", parsingContext3.getTypeDesc());
    assertEquals("\"13814000-1dd2-11b2-8080-808080808080\"", nextResult2.toPrettyString());
    assertEquals("\"TB_RESOURCE\"", nextResult.toPrettyString());
    Version versionResult = traverseResult3.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\n  \"entityType\" : \"TB_RESOURCE\",\n  \"id\" : \"13814000-1dd2-11b2-8080-808080808080\"\n}",
        descriptor.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult3.getBinaryValue());
    assertNull(actualTbResource.getData());
    assertNull(actualTbResource.getPreview());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult3.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult3.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult3.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult3.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    assertNull(traverseResult3.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult3.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult3.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult3.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult3.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult3.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(traverseResult3.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(parsingContext3.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult3.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult3.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(traverseResult3.getValueAsString());
    assertNull(actualTbResource.getEncodedData());
    assertNull(actualTbResource.getEncodedPreview());
    assertNull(actualTbResource.getEtag());
    assertNull(actualTbResource.getFileName());
    assertNull(actualTbResource.getLink());
    assertNull(actualTbResource.getName());
    assertNull(actualTbResource.getPublicLink());
    assertNull(actualTbResource.getPublicResourceKey());
    assertNull(actualTbResource.getResourceKey());
    assertNull(actualTbResource.getSearchText());
    assertNull(actualTbResource.getTitle());
    assertNull(actualTbResource.getUuidId());
    assertNull(actualTbResource.getResourceSubType());
    assertNull(actualTbResource.getResourceType());
    assertNull(actualTbResource.getExternalId());
    assertNull(actualTbResource.getId());
    assertNull(actualTbResource.getTenantId());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult3.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult3.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult3.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult3.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, traverseResult3.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext3.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext3.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, parsingContext3.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0, nextResult2.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0.0d, traverseResult2.getValueAsDouble());
    assertEquals(0.0d, traverseResult3.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, traverseResult3.getValueAsLong());
    assertEquals(0L, actualTbResource.getCreatedTime());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(2, descriptor.size());
    assertEquals(JsonNodeType.OBJECT, descriptor.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult2.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult3.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult3.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult3.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult3.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult3.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult3.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult3.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(traverseResult3.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext3.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext3.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(parsingContext3.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(nextResult2.isArray());
    assertFalse(descriptor.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(nextResult2.isBigDecimal());
    assertFalse(descriptor.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(nextResult2.isBigInteger());
    assertFalse(descriptor.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(nextResult2.isBinary());
    assertFalse(descriptor.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(nextResult2.isBoolean());
    assertFalse(descriptor.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult2.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(nextResult2.isDouble());
    assertFalse(descriptor.isDouble());
    assertFalse(descriptor.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(nextResult2.isFloat());
    assertFalse(descriptor.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(nextResult2.isFloatingPointNumber());
    assertFalse(descriptor.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(nextResult2.isInt());
    assertFalse(descriptor.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(nextResult2.isIntegralNumber());
    assertFalse(descriptor.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(nextResult2.isLong());
    assertFalse(descriptor.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(nextResult2.isMissingNode());
    assertFalse(descriptor.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(nextResult2.isNull());
    assertFalse(descriptor.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(nextResult2.isNumber());
    assertFalse(descriptor.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult2.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(nextResult2.isPojo());
    assertFalse(descriptor.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(nextResult2.isShort());
    assertFalse(descriptor.isShort());
    assertFalse(descriptor.isTextual());
    assertFalse(descriptor.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualTbResource.isPublic());
    assertTrue(descriptor.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult2.isEmpty());
    assertTrue(descriptor.isObject());
    assertTrue(nextResult.isTextual());
    assertTrue(nextResult2.isTextual());
    assertTrue(nextResult.isValueNode());
    assertTrue(nextResult2.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult2.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(currentLocation, traverseResult3.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(versionResult, traverseResult2.version());
  }
}
