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

class EntityViewInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewInfo#equals(Object)}
   *   <li>{@link EntityViewInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    EntityViewInfo entityViewInfo2 = new EntityViewInfo();

    // Act and Assert
    assertEquals(entityViewInfo, entityViewInfo2);
    int expectedHashCodeResult = entityViewInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityViewInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewInfo#equals(Object)}
   *   <li>{@link EntityViewInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo(new EntityView(), "Dr", true);
    EntityViewInfo entityViewInfo2 = new EntityViewInfo(new EntityView(), "Dr", true);

    // Act and Assert
    assertEquals(entityViewInfo, entityViewInfo2);
    int notExpectedHashCodeResult = entityViewInfo.hashCode();
    assertNotEquals(notExpectedHashCodeResult, entityViewInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewInfo#equals(Object)}
   *   <li>{@link EntityViewInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();

    // Act and Assert
    assertEquals(entityViewInfo, entityViewInfo);
    int expectedHashCodeResult = entityViewInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityViewInfo.hashCode());
  }

  /**
   * Method under test: {@link EntityViewInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo(new EntityView(), "Dr", true);

    // Act and Assert
    assertNotEquals(entityViewInfo, new EntityViewInfo());
  }

  /**
   * Method under test: {@link EntityViewInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewInfo(), mock(EntityView.class));
  }

  /**
   * Method under test: {@link EntityViewInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(entityViewInfo, new EntityViewInfo());
  }

  /**
   * Method under test: {@link EntityViewInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    entityViewInfo.setCustomerIsPublic(true);

    // Act and Assert
    assertNotEquals(entityViewInfo, new EntityViewInfo());
  }

  /**
   * Method under test: {@link EntityViewInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();

    EntityViewInfo entityViewInfo2 = new EntityViewInfo();
    entityViewInfo2.setCustomerTitle("Dr");

    // Act and Assert
    assertNotEquals(entityViewInfo, entityViewInfo2);
  }

  /**
   * Method under test: {@link EntityViewInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewInfo(), null);
  }

  /**
   * Method under test: {@link EntityViewInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewInfo(), "Different type to EntityViewInfo");
  }

  /**
   * Method under test:
   * {@link EntityViewInfo#EntityViewInfo(EntityView, String, boolean)}
   */
  @Test
  void testNewEntityViewInfo() throws IOException {
    // Arrange and Act
    EntityViewInfo actualEntityViewInfo = new EntityViewInfo(new EntityView(), "Dr", true);

    // Assert
    JsonNode additionalInfo = actualEntityViewInfo.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("Dr", actualEntityViewInfo.getCustomerTitle());
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
    assertNull(actualEntityViewInfo.getVersion());
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
    assertNull(actualEntityViewInfo.getName());
    assertNull(actualEntityViewInfo.getType());
    assertNull(actualEntityViewInfo.getUuidId());
    assertNull(actualEntityViewInfo.getCustomerId());
    assertNull(actualEntityViewInfo.getEntityId());
    assertNull(actualEntityViewInfo.getExternalId());
    assertNull(actualEntityViewInfo.getId());
    assertNull(actualEntityViewInfo.getTenantId());
    assertNull(actualEntityViewInfo.getKeys());
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
    assertEquals(0L, actualEntityViewInfo.getCreatedTime());
    assertEquals(0L, actualEntityViewInfo.getEndTimeMs());
    assertEquals(0L, actualEntityViewInfo.getStartTimeMs());
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
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertTrue(actualEntityViewInfo.isCustomerIsPublic());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link EntityViewInfo#EntityViewInfo(EntityView, String, boolean)}
   */
  @Test
  void testNewEntityViewInfo2() throws IOException {
    // Arrange
    EntityViewInfo entityView = new EntityViewInfo(new EntityView(), "Dr", true);

    // Act
    EntityViewInfo actualEntityViewInfo = new EntityViewInfo(entityView, "Mr", true);

    // Assert
    JsonNode additionalInfo = actualEntityViewInfo.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("Dr", entityView.getCustomerTitle());
    assertEquals("Mr", actualEntityViewInfo.getCustomerTitle());
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
    assertNull(entityView.getVersion());
    assertNull(actualEntityViewInfo.getVersion());
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
    assertNull(entityView.getName());
    assertNull(actualEntityViewInfo.getName());
    assertNull(entityView.getType());
    assertNull(actualEntityViewInfo.getType());
    assertNull(entityView.getUuidId());
    assertNull(actualEntityViewInfo.getUuidId());
    assertNull(entityView.getCustomerId());
    assertNull(actualEntityViewInfo.getCustomerId());
    assertNull(entityView.getEntityId());
    assertNull(actualEntityViewInfo.getEntityId());
    assertNull(entityView.getExternalId());
    assertNull(actualEntityViewInfo.getExternalId());
    assertNull(entityView.getId());
    assertNull(actualEntityViewInfo.getId());
    assertNull(entityView.getTenantId());
    assertNull(actualEntityViewInfo.getTenantId());
    assertNull(entityView.getKeys());
    assertNull(actualEntityViewInfo.getKeys());
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
    assertEquals(0L, entityView.getCreatedTime());
    assertEquals(0L, actualEntityViewInfo.getCreatedTime());
    assertEquals(0L, entityView.getEndTimeMs());
    assertEquals(0L, actualEntityViewInfo.getEndTimeMs());
    assertEquals(0L, entityView.getStartTimeMs());
    assertEquals(0L, actualEntityViewInfo.getStartTimeMs());
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
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertTrue(entityView.isCustomerIsPublic());
    assertTrue(actualEntityViewInfo.isCustomerIsPublic());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }
}
