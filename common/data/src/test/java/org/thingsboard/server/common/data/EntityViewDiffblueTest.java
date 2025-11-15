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
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.objects.TelemetryEntityView;

class EntityViewDiffblueTest {
  /**
   * Method under test: {@link EntityView#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new EntityView()).getId());
  }

  /**
   * Method under test: {@link EntityView#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new EntityView()).getCreatedTime());
  }

  /**
   * Method under test: {@link EntityView#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull((new EntityView()).getAdditionalInfo());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityView#equals(Object)}
   *   <li>{@link EntityView#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityView entityView = new EntityView();
    EntityView entityView2 = new EntityView();

    // Act and Assert
    assertEquals(entityView, entityView2);
    int expectedHashCodeResult = entityView.hashCode();
    assertEquals(expectedHashCodeResult, entityView2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityView#equals(Object)}
   *   <li>{@link EntityView#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityView entityView = new EntityView();

    // Act and Assert
    assertEquals(entityView, entityView);
    int expectedHashCodeResult = entityView.hashCode();
    assertEquals(expectedHashCodeResult, entityView.hashCode());
  }

  /**
   * Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewInfo entityViewInfo = new EntityViewInfo();

    // Act and Assert
    assertNotEquals(entityViewInfo, new EntityView());
  }

  /**
   * Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityView entityView = new EntityView();

    // Act and Assert
    assertNotEquals(entityView, new EntityViewInfo());
  }

  /**
   * Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityView(), mock(AdminSettings.class));
  }

  /**
   * Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityView entityView = new EntityView();
    EntityViewInfo entityViewInfo = mock(EntityViewInfo.class);
    when(entityViewInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(entityView, entityViewInfo);
  }

  /**
   * Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityView(), null);
  }

  /**
   * Method under test: {@link EntityView#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityView(), "Different type to EntityView");
  }

  /**
   * Method under test: {@link EntityView#getExternalId()}
   */
  @Test
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new EntityView()).getExternalId());
  }

  /**
   * Method under test: {@link EntityView#EntityView(EntityView)}
   */
  @Test
  void testNewEntityView() throws IOException {
    // Arrange and Act
    EntityView actualEntityView = new EntityView(new EntityView());

    // Assert
    JsonNode additionalInfo = actualEntityView.getAdditionalInfo();
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
    assertNull(actualEntityView.getVersion());
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
    assertNull(actualEntityView.getName());
    assertNull(actualEntityView.getType());
    assertNull(actualEntityView.getUuidId());
    assertNull(actualEntityView.getCustomerId());
    assertNull(actualEntityView.getEntityId());
    assertNull(actualEntityView.getExternalId());
    assertNull(actualEntityView.getId());
    assertNull(actualEntityView.getTenantId());
    assertNull(actualEntityView.getKeys());
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
    assertEquals(0L, actualEntityView.getCreatedTime());
    assertEquals(0L, actualEntityView.getEndTimeMs());
    assertEquals(0L, actualEntityView.getStartTimeMs());
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
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test:
   * {@link EntityView#EntityView(EntityId, TenantId, CustomerId, String, String, TelemetryEntityView, long, long, EntityViewId, Long)}
   */
  @Test
  void testNewEntityView2() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);
    TelemetryEntityView keys = new TelemetryEntityView();

    // Act
    EntityView actualEntityView = new EntityView(TenantId.SYS_TENANT_ID, tenantId, customerId, "Name", "Type", keys, 1L,
        1L, null, 1L);

    // Assert
    assertEquals("Name", actualEntityView.getName());
    assertEquals("Type", actualEntityView.getType());
    assertNull(actualEntityView.getAdditionalInfo());
    assertNull(actualEntityView.getUuidId());
    assertNull(actualEntityView.getExternalId());
    assertNull(actualEntityView.getId());
    assertEquals(0L, actualEntityView.getCreatedTime());
    assertEquals(1L, actualEntityView.getVersion().longValue());
    assertEquals(1L, actualEntityView.getEndTimeMs());
    assertEquals(1L, actualEntityView.getStartTimeMs());
    assertSame(customerId, actualEntityView.getCustomerId());
    assertSame(keys, actualEntityView.getKeys());
    TenantId tenantId2 = tenantId.SYS_TENANT_ID;
    assertSame(tenantId2, actualEntityView.getEntityId());
    assertSame(tenantId2, actualEntityView.getTenantId());
  }
}
