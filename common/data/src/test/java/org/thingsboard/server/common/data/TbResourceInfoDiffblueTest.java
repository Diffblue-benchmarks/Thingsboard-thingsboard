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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DecimalNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.FloatNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.function.UnaryOperator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;

class TbResourceInfoDiffblueTest {
  /**
   * Method under test: {@link TbResourceInfo#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new TbResourceInfo()).getId());
  }

  /**
   * Method under test: {@link TbResourceInfo#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new TbResourceInfo()).getCreatedTime());
  }

  /**
   * Method under test: {@link TbResourceInfo#getLink()}
   */
  @Test
  void testGetLink() {
    // Arrange, Act and Assert
    assertNull((new TbResourceInfo()).getLink());
  }

  /**
   * Method under test: {@link TbResourceInfo#getLink()}
   */
  @Test
  void testGetLink2() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setResourceType(ResourceType.IMAGE);

    // Act and Assert
    assertEquals("/api/images/tenant/null", tbResourceInfo.getLink());
  }

  /**
   * Method under test: {@link TbResourceInfo#getLink()}
   */
  @Test
  void testGetLink3() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setTenantId(TenantId.SYS_TENANT_ID);
    tbResourceInfo.setResourceType(ResourceType.IMAGE);

    // Act and Assert
    assertEquals("/api/images/system/null", tbResourceInfo.getLink());
  }

  /**
   * Method under test: {@link TbResourceInfo#getLink()}
   */
  @Test
  void testGetLink4() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setTenantId(new TenantId(UUID.randomUUID()));
    tbResourceInfo.setResourceType(ResourceType.IMAGE);

    // Act and Assert
    assertEquals("/api/images/tenant/null", tbResourceInfo.getLink());
  }

  /**
   * Method under test: {@link TbResourceInfo#getPublicLink()}
   */
  @Test
  void testGetPublicLink() {
    // Arrange, Act and Assert
    assertNull((new TbResourceInfo()).getPublicLink());
  }

  /**
   * Method under test: {@link TbResourceInfo#getPublicLink()}
   */
  @Test
  void testGetPublicLink2() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setResourceType(ResourceType.IMAGE);
    tbResourceInfo.setPublic(false);

    // Act and Assert
    assertNull(tbResourceInfo.getPublicLink());
  }

  /**
   * Method under test: {@link TbResourceInfo#getPublicLink()}
   */
  @Test
  void testGetPublicLink3() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setResourceType(ResourceType.IMAGE);
    tbResourceInfo.setPublic(true);

    // Act and Assert
    assertEquals("/api/images/public/null", tbResourceInfo.getPublicLink());
  }

  /**
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  void testGetDescriptor() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    Class<Object> type = Object.class;

    // Act and Assert
    assertNull(tbResourceInfo.getDescriptor(type));
  }

  /**
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  void testGetDescriptor2() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptorValue("42");
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals("42", tbResourceInfo.getDescriptor(type));
  }

  /**
   * Method under test: {@link TbResourceInfo#getDescriptor(Class)}
   */
  @Test
  void testGetDescriptor3() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptorValue("Value");
    Class<Object> type = Object.class;

    // Act and Assert
    assertEquals("Value", tbResourceInfo.getDescriptor(type));
  }

  /**
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  void testUpdateDescriptor() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isNull());
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"Apply\"", descriptor.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  void testUpdateDescriptor2() throws JsonProcessingException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn(null);

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isNull());
    assertNull(tbResourceInfo.getDescriptor());
  }

  /**
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  void testUpdateDescriptor3() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn(42);

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isNull());
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof IntNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", descriptor.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, descriptor.getNodeType());
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
    assertFalse(descriptor.isLong());
    assertFalse(descriptor.isMissingNode());
    assertFalse(descriptor.isNull());
    assertFalse(descriptor.isObject());
    assertFalse(descriptor.isPojo());
    assertFalse(descriptor.isShort());
    assertFalse(descriptor.isTextual());
    assertFalse(((IntNode) descriptor).isNaN());
    assertFalse(descriptor.iterator().hasNext());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isInt());
    assertTrue(descriptor.isIntegralNumber());
    assertTrue(descriptor.isNumber());
    assertTrue(descriptor.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  void testUpdateDescriptor4() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn(1);

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isNull());
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof IntNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("1", descriptor.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, descriptor.getNodeType());
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
    assertFalse(descriptor.isLong());
    assertFalse(descriptor.isMissingNode());
    assertFalse(descriptor.isNull());
    assertFalse(descriptor.isObject());
    assertFalse(descriptor.isPojo());
    assertFalse(descriptor.isShort());
    assertFalse(descriptor.isTextual());
    assertFalse(((IntNode) descriptor).isNaN());
    assertFalse(descriptor.iterator().hasNext());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isInt());
    assertTrue(descriptor.isIntegralNumber());
    assertTrue(descriptor.isNumber());
    assertTrue(descriptor.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  void testUpdateDescriptor5() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn(DataConstants.DEFAULT_SECRET_KEY);

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isNull());
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"\"", descriptor.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  void testUpdateDescriptor6() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptorValue("Value");
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"Apply\"", descriptor.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  void testUpdateDescriptor7() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptorValue(42);
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"Apply\"", descriptor.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  void testUpdateDescriptor8() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"Apply\"", descriptor.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  void testUpdateDescriptor9() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(new BinaryNode("AXAXAXAX".getBytes("UTF-8")));
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"Apply\"", descriptor.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  void testUpdateDescriptor10() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(BooleanNode.getFalse());
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"Apply\"", descriptor.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  void testUpdateDescriptor11() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(NullNode.getInstance());
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isNull());
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"Apply\"", descriptor.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  void testUpdateDescriptor12() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(new DecimalNode(new BigDecimal("2.3")));
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"Apply\"", descriptor.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  void testUpdateDescriptor13() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(DoubleNode.valueOf(10.0d));
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"Apply\"", descriptor.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link TbResourceInfo#updateDescriptor(Class, UnaryOperator)}
   */
  @Test
  void testUpdateDescriptor14() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    tbResourceInfo.setDescriptor(FloatNode.valueOf(10.0f));
    Class<Object> type = Object.class;
    UnaryOperator<Object> updater = mock(UnaryOperator.class);
    when(updater.apply(Mockito.<Object>any())).thenReturn("Apply");

    // Act
    tbResourceInfo.updateDescriptor(type, updater);

    // Assert
    verify(updater).apply(isA(Object.class));
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"Apply\"", descriptor.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  void testSetDescriptorValue() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue("Value");

    // Assert
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"Value\"", descriptor.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  void testSetDescriptorValue2() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue(null);

    // Assert
    assertNull(tbResourceInfo.getDescriptor());
  }

  /**
   * Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  void testSetDescriptorValue3() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue(42);

    // Assert
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof IntNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", descriptor.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, descriptor.getNodeType());
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
    assertFalse(descriptor.isLong());
    assertFalse(descriptor.isMissingNode());
    assertFalse(descriptor.isNull());
    assertFalse(descriptor.isObject());
    assertFalse(descriptor.isPojo());
    assertFalse(descriptor.isShort());
    assertFalse(descriptor.isTextual());
    assertFalse(((IntNode) descriptor).isNaN());
    assertFalse(descriptor.iterator().hasNext());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isInt());
    assertTrue(descriptor.isIntegralNumber());
    assertTrue(descriptor.isNumber());
    assertTrue(descriptor.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  void testSetDescriptorValue4() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue(1);

    // Assert
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof IntNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("1", descriptor.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, descriptor.getNodeType());
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
    assertFalse(descriptor.isLong());
    assertFalse(descriptor.isMissingNode());
    assertFalse(descriptor.isNull());
    assertFalse(descriptor.isObject());
    assertFalse(descriptor.isPojo());
    assertFalse(descriptor.isShort());
    assertFalse(descriptor.isTextual());
    assertFalse(((IntNode) descriptor).isNaN());
    assertFalse(descriptor.iterator().hasNext());
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isInt());
    assertTrue(descriptor.isIntegralNumber());
    assertTrue(descriptor.isNumber());
    assertTrue(descriptor.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link TbResourceInfo#setDescriptorValue(Object)}
   */
  @Test
  void testSetDescriptorValue5() throws IOException {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act
    tbResourceInfo.setDescriptorValue(DataConstants.DEFAULT_SECRET_KEY);

    // Assert
    JsonNode descriptor = tbResourceInfo.getDescriptor();
    assertTrue(descriptor instanceof TextNode);
    JsonParser traverseResult = descriptor.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"\"", descriptor.toPrettyString());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertTrue(descriptor.isEmpty());
    assertTrue(descriptor.isTextual());
    assertTrue(descriptor.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfo#equals(Object)}
   *   <li>{@link TbResourceInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    TbResourceInfo tbResourceInfo2 = new TbResourceInfo();

    // Act and Assert
    assertEquals(tbResourceInfo, tbResourceInfo2);
    int expectedHashCodeResult = tbResourceInfo.hashCode();
    assertEquals(expectedHashCodeResult, tbResourceInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfo#equals(Object)}
   *   <li>{@link TbResourceInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act and Assert
    assertEquals(tbResourceInfo, tbResourceInfo);
    int expectedHashCodeResult = tbResourceInfo.hashCode();
    assertEquals(expectedHashCodeResult, tbResourceInfo.hashCode());
  }

  /**
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbResource tbResource = new TbResource();

    // Act and Assert
    assertNotEquals(tbResource, new TbResourceInfo());
  }

  /**
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo(new TbResourceId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResourceInfo());
  }

  /**
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();

    // Act and Assert
    assertNotEquals(tbResourceInfo, new TbResource());
  }

  /**
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbResourceInfo, tbResource);
  }

  /**
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbResourceInfo(), null);
  }

  /**
   * Method under test: {@link TbResourceInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbResourceInfo(), "Different type to TbResourceInfo");
  }

  /**
   * Method under test: {@link TbResourceInfo#getExternalId()}
   */
  @Test
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new TbResourceInfo()).getExternalId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfo#TbResourceInfo()}
   *   <li>{@link TbResourceInfo#setDescriptor(JsonNode)}
   *   <li>{@link TbResourceInfo#setEtag(String)}
   *   <li>{@link TbResourceInfo#setExternalId(TbResourceId)}
   *   <li>{@link TbResourceInfo#setFileName(String)}
   *   <li>{@link TbResourceInfo#setPublic(boolean)}
   *   <li>{@link TbResourceInfo#setPublicResourceKey(String)}
   *   <li>{@link TbResourceInfo#setResourceKey(String)}
   *   <li>{@link TbResourceInfo#setResourceSubType(ResourceSubType)}
   *   <li>{@link TbResourceInfo#setResourceType(ResourceType)}
   *   <li>{@link TbResourceInfo#setSearchText(String)}
   *   <li>{@link TbResourceInfo#setTenantId(TenantId)}
   *   <li>{@link TbResourceInfo#setTitle(String)}
   *   <li>{@link TbResourceInfo#toString()}
   *   <li>{@link TbResourceInfo#getDescriptor()}
   *   <li>{@link TbResourceInfo#getEtag()}
   *   <li>{@link TbResourceInfo#getFileName()}
   *   <li>{@link TbResourceInfo#getName()}
   *   <li>{@link TbResourceInfo#getPublicResourceKey()}
   *   <li>{@link TbResourceInfo#getResourceKey()}
   *   <li>{@link TbResourceInfo#getResourceSubType()}
   *   <li>{@link TbResourceInfo#getResourceType()}
   *   <li>{@link TbResourceInfo#getSearchText()}
   *   <li>{@link TbResourceInfo#getTenantId()}
   *   <li>{@link TbResourceInfo#getTitle()}
   *   <li>{@link TbResourceInfo#isPublic()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TbResourceInfo actualTbResourceInfo = new TbResourceInfo();
    MissingNode descriptor = MissingNode.getInstance();
    actualTbResourceInfo.setDescriptor(descriptor);
    actualTbResourceInfo.setEtag("Etag");
    TbResourceId externalId = new TbResourceId(EntityId.NULL_UUID);
    actualTbResourceInfo.setExternalId(externalId);
    actualTbResourceInfo.setFileName("foo.txt");
    actualTbResourceInfo.setPublic(true);
    actualTbResourceInfo.setPublicResourceKey("Public Resource Key");
    actualTbResourceInfo.setResourceKey("Resource Key");
    actualTbResourceInfo.setResourceSubType(ResourceSubType.IMAGE);
    actualTbResourceInfo.setResourceType(ResourceType.LWM2M_MODEL);
    actualTbResourceInfo.setSearchText("Search Text");
    actualTbResourceInfo.setTenantId(TenantId.SYS_TENANT_ID);
    actualTbResourceInfo.setTitle("Dr");
    String actualToStringResult = actualTbResourceInfo.toString();
    JsonNode actualDescriptor = actualTbResourceInfo.getDescriptor();
    String actualEtag = actualTbResourceInfo.getEtag();
    String actualFileName = actualTbResourceInfo.getFileName();
    String actualName = actualTbResourceInfo.getName();
    String actualPublicResourceKey = actualTbResourceInfo.getPublicResourceKey();
    String actualResourceKey = actualTbResourceInfo.getResourceKey();
    ResourceSubType actualResourceSubType = actualTbResourceInfo.getResourceSubType();
    ResourceType actualResourceType = actualTbResourceInfo.getResourceType();
    String actualSearchText = actualTbResourceInfo.getSearchText();
    TenantId actualTenantId = actualTbResourceInfo.getTenantId();
    String actualTitle = actualTbResourceInfo.getTitle();
    boolean actualIsPublicResult = actualTbResourceInfo.isPublic();

    // Assert that nothing has changed
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualSearchText);
    assertEquals("Dr", actualTitle);
    assertEquals("Etag", actualEtag);
    assertEquals("Public Resource Key", actualPublicResourceKey);
    assertEquals("Resource Key", actualResourceKey);
    assertEquals("TbResourceInfo(tenantId=13814000-1dd2-11b2-8080-808080808080, title=Dr, resourceType=LWM2M_MODEL,"
        + " resourceSubType=IMAGE, resourceKey=Resource Key, isPublic=true, publicResourceKey=Public Resource"
        + " Key, searchText=Dr, etag=Etag, fileName=foo.txt, descriptor=, externalId=13814000-1dd2-11b2-8080"
        + "-808080808080)", actualToStringResult);
    assertEquals("foo.txt", actualFileName);
    assertEquals(0L, actualTbResourceInfo.getCreatedTime());
    assertEquals(ResourceSubType.IMAGE, actualResourceSubType);
    assertEquals(ResourceType.LWM2M_MODEL, actualResourceType);
    assertTrue(actualIsPublicResult);
    assertSame(externalId, actualTbResourceInfo.getExternalId());
    assertSame(descriptor, actualDescriptor);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbResourceInfo#TbResourceInfo(TbResourceId)}
   *   <li>{@link TbResourceInfo#setDescriptor(JsonNode)}
   *   <li>{@link TbResourceInfo#setEtag(String)}
   *   <li>{@link TbResourceInfo#setExternalId(TbResourceId)}
   *   <li>{@link TbResourceInfo#setFileName(String)}
   *   <li>{@link TbResourceInfo#setPublic(boolean)}
   *   <li>{@link TbResourceInfo#setPublicResourceKey(String)}
   *   <li>{@link TbResourceInfo#setResourceKey(String)}
   *   <li>{@link TbResourceInfo#setResourceSubType(ResourceSubType)}
   *   <li>{@link TbResourceInfo#setResourceType(ResourceType)}
   *   <li>{@link TbResourceInfo#setSearchText(String)}
   *   <li>{@link TbResourceInfo#setTenantId(TenantId)}
   *   <li>{@link TbResourceInfo#setTitle(String)}
   *   <li>{@link TbResourceInfo#toString()}
   *   <li>{@link TbResourceInfo#getDescriptor()}
   *   <li>{@link TbResourceInfo#getEtag()}
   *   <li>{@link TbResourceInfo#getFileName()}
   *   <li>{@link TbResourceInfo#getName()}
   *   <li>{@link TbResourceInfo#getPublicResourceKey()}
   *   <li>{@link TbResourceInfo#getResourceKey()}
   *   <li>{@link TbResourceInfo#getResourceSubType()}
   *   <li>{@link TbResourceInfo#getResourceType()}
   *   <li>{@link TbResourceInfo#getSearchText()}
   *   <li>{@link TbResourceInfo#getTenantId()}
   *   <li>{@link TbResourceInfo#getTitle()}
   *   <li>{@link TbResourceInfo#isPublic()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    TbResourceId id = new TbResourceId(EntityId.NULL_UUID);

    // Act
    TbResourceInfo actualTbResourceInfo = new TbResourceInfo(id);
    MissingNode descriptor = MissingNode.getInstance();
    actualTbResourceInfo.setDescriptor(descriptor);
    actualTbResourceInfo.setEtag("Etag");
    TbResourceId externalId = new TbResourceId(EntityId.NULL_UUID);
    actualTbResourceInfo.setExternalId(externalId);
    actualTbResourceInfo.setFileName("foo.txt");
    actualTbResourceInfo.setPublic(true);
    actualTbResourceInfo.setPublicResourceKey("Public Resource Key");
    actualTbResourceInfo.setResourceKey("Resource Key");
    actualTbResourceInfo.setResourceSubType(ResourceSubType.IMAGE);
    actualTbResourceInfo.setResourceType(ResourceType.LWM2M_MODEL);
    actualTbResourceInfo.setSearchText("Search Text");
    actualTbResourceInfo.setTenantId(TenantId.SYS_TENANT_ID);
    actualTbResourceInfo.setTitle("Dr");
    String actualToStringResult = actualTbResourceInfo.toString();
    JsonNode actualDescriptor = actualTbResourceInfo.getDescriptor();
    String actualEtag = actualTbResourceInfo.getEtag();
    String actualFileName = actualTbResourceInfo.getFileName();
    String actualName = actualTbResourceInfo.getName();
    String actualPublicResourceKey = actualTbResourceInfo.getPublicResourceKey();
    String actualResourceKey = actualTbResourceInfo.getResourceKey();
    ResourceSubType actualResourceSubType = actualTbResourceInfo.getResourceSubType();
    ResourceType actualResourceType = actualTbResourceInfo.getResourceType();
    String actualSearchText = actualTbResourceInfo.getSearchText();
    TenantId actualTenantId = actualTbResourceInfo.getTenantId();
    String actualTitle = actualTbResourceInfo.getTitle();
    boolean actualIsPublicResult = actualTbResourceInfo.isPublic();

    // Assert that nothing has changed
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualSearchText);
    assertEquals("Dr", actualTitle);
    assertEquals("Etag", actualEtag);
    assertEquals("Public Resource Key", actualPublicResourceKey);
    assertEquals("Resource Key", actualResourceKey);
    assertEquals("TbResourceInfo(tenantId=13814000-1dd2-11b2-8080-808080808080, title=Dr, resourceType=LWM2M_MODEL,"
        + " resourceSubType=IMAGE, resourceKey=Resource Key, isPublic=true, publicResourceKey=Public Resource"
        + " Key, searchText=Dr, etag=Etag, fileName=foo.txt, descriptor=, externalId=13814000-1dd2-11b2-8080"
        + "-808080808080)", actualToStringResult);
    assertEquals("foo.txt", actualFileName);
    assertEquals(0L, actualTbResourceInfo.getCreatedTime());
    assertEquals(ResourceSubType.IMAGE, actualResourceSubType);
    assertEquals(ResourceType.LWM2M_MODEL, actualResourceType);
    assertTrue(actualIsPublicResult);
    assertSame(externalId, actualTbResourceInfo.getExternalId());
    assertSame(id, actualTbResourceInfo.getId());
    assertSame(descriptor, actualDescriptor);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Method under test: {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}
   */
  @Test
  void testNewTbResourceInfo() {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();

    // Act and Assert
    assertEquals(resourceInfo, new TbResourceInfo(resourceInfo));
  }

  /**
   * Method under test: {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}
   */
  @Test
  void testNewTbResourceInfo2() {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();
    resourceInfo.setDescriptorValue("Resource Info");

    // Act and Assert
    assertEquals(resourceInfo, new TbResourceInfo(resourceInfo));
  }

  /**
   * Method under test: {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}
   */
  @Test
  void testNewTbResourceInfo3() {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();
    resourceInfo.setDescriptor(MissingNode.getInstance());

    // Act and Assert
    assertEquals(resourceInfo, new TbResourceInfo(resourceInfo));
  }

  /**
   * Method under test: {@link TbResourceInfo#TbResourceInfo(TbResourceInfo)}
   */
  @Test
  void testNewTbResourceInfo4() {
    // Arrange
    TbResourceInfo resourceInfo = new TbResourceInfo();
    resourceInfo.setDescriptorValue(new TbResourceId(EntityId.NULL_UUID));

    // Act and Assert
    assertEquals(resourceInfo, new TbResourceInfo(resourceInfo));
  }
}
