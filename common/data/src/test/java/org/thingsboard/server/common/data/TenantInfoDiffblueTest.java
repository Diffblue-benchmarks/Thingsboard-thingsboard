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
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class TenantInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantInfo#equals(Object)}
   *   <li>{@link TenantInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantInfo tenantInfo = new TenantInfo();
    TenantInfo tenantInfo2 = new TenantInfo();

    // Act and Assert
    assertEquals(tenantInfo, tenantInfo2);
    int expectedHashCodeResult = tenantInfo.hashCode();
    assertEquals(expectedHashCodeResult, tenantInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantInfo#equals(Object)}
   *   <li>{@link TenantInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantInfo tenantInfo = new TenantInfo();

    // Act and Assert
    assertEquals(tenantInfo, tenantInfo);
    int expectedHashCodeResult = tenantInfo.hashCode();
    assertEquals(expectedHashCodeResult, tenantInfo.hashCode());
  }

  /**
   * Method under test: {@link TenantInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantInfo tenantInfo = new TenantInfo(new Tenant(), "foo.txt");

    // Act and Assert
    assertNotEquals(tenantInfo, new TenantInfo());
  }

  /**
   * Method under test: {@link TenantInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantInfo tenantInfo = new TenantInfo();

    // Act and Assert
    assertNotEquals(tenantInfo, new TenantInfo(new Tenant(), "foo.txt"));
  }

  /**
   * Method under test: {@link TenantInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Tenant tenant = mock(Tenant.class);
    when(tenant.getAdditionalInfo()).thenReturn(MissingNode.getInstance());
    when(tenant.getVersion()).thenReturn(1L);
    when(tenant.getAddress()).thenReturn("42 Main St");
    when(tenant.getAddress2()).thenReturn("42 Main St");
    when(tenant.getCity()).thenReturn("Oxford");
    when(tenant.getCountry()).thenReturn("GB");
    when(tenant.getEmail()).thenReturn("jane.doe@example.org");
    when(tenant.getPhone()).thenReturn("6625550144");
    when(tenant.getRegion()).thenReturn("us-east-2");
    when(tenant.getState()).thenReturn("MD");
    when(tenant.getTitle()).thenReturn("Dr");
    when(tenant.getZip()).thenReturn("21654");
    when(tenant.getCreatedTime()).thenReturn(1L);
    when(tenant.getId()).thenReturn(TenantId.SYS_TENANT_ID);
    when(tenant.getTenantProfileId()).thenReturn(null);
    TenantInfo tenantInfo = new TenantInfo(tenant, "foo.txt");

    // Act and Assert
    assertNotEquals(tenantInfo, new TenantInfo());
  }

  /**
   * Method under test: {@link TenantInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantInfo(), null);
  }

  /**
   * Method under test: {@link TenantInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantInfo(), "Different type to TenantInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantInfo#TenantInfo()}
   *   <li>{@link TenantInfo#setTenantProfileName(String)}
   *   <li>{@link TenantInfo#toString()}
   *   <li>{@link TenantInfo#getTenantProfileName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TenantInfo actualTenantInfo = new TenantInfo();
    actualTenantInfo.setTenantProfileName("foo.txt");
    String actualToStringResult = actualTenantInfo.toString();

    // Assert that nothing has changed
    assertEquals("TenantInfo(tenantProfileName=foo.txt)", actualToStringResult);
    assertEquals("foo.txt", actualTenantInfo.getTenantProfileName());
    assertEquals(0L, actualTenantInfo.getCreatedTime());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantInfo#TenantInfo(TenantId)}
   *   <li>{@link TenantInfo#setTenantProfileName(String)}
   *   <li>{@link TenantInfo#toString()}
   *   <li>{@link TenantInfo#getTenantProfileName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    // Act
    TenantInfo actualTenantInfo = new TenantInfo(tenantId);
    actualTenantInfo.setTenantProfileName("foo.txt");
    String actualToStringResult = actualTenantInfo.toString();

    // Assert that nothing has changed
    assertEquals("TenantInfo(tenantProfileName=foo.txt)", actualToStringResult);
    assertEquals("foo.txt", actualTenantInfo.getTenantProfileName());
    assertEquals(0L, actualTenantInfo.getCreatedTime());
    TenantId expectedId = tenantId.SYS_TENANT_ID;
    assertSame(expectedId, actualTenantInfo.getId());
  }

  /**
   * Method under test: {@link TenantInfo#TenantInfo(Tenant, String)}
   */
  @Test
  void testNewTenantInfo() throws IOException {
    // Arrange and Act
    TenantInfo actualTenantInfo = new TenantInfo(new Tenant(), "foo.txt");

    // Assert
    JsonNode additionalInfo = actualTenantInfo.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("foo.txt", actualTenantInfo.getTenantProfileName());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(actualTenantInfo.getVersion());
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
    assertNull(actualTenantInfo.getAddress());
    assertNull(actualTenantInfo.getAddress2());
    assertNull(actualTenantInfo.getCity());
    assertNull(actualTenantInfo.getCountry());
    assertNull(actualTenantInfo.getEmail());
    assertNull(actualTenantInfo.getName());
    assertNull(actualTenantInfo.getPhone());
    assertNull(actualTenantInfo.getRegion());
    assertNull(actualTenantInfo.getState());
    assertNull(actualTenantInfo.getTitle());
    assertNull(actualTenantInfo.getZip());
    assertNull(actualTenantInfo.getUuidId());
    assertNull(actualTenantInfo.getId());
    assertNull(actualTenantInfo.getTenantId());
    assertNull(actualTenantInfo.getTenantProfileId());
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
    assertEquals(0L, actualTenantInfo.getCreatedTime());
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
}
