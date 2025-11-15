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
import org.thingsboard.server.common.data.id.TenantId;

class TenantDiffblueTest {
  /**
   * Method under test: {@link Tenant#getTenantId()}
   */
  @Test
  void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getTenantId());
  }

  /**
   * Method under test: {@link Tenant#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getId());
  }

  /**
   * Method under test: {@link Tenant#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new Tenant()).getCreatedTime());
  }

  /**
   * Method under test: {@link Tenant#getCountry()}
   */
  @Test
  void testGetCountry() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getCountry());
  }

  /**
   * Method under test: {@link Tenant#getState()}
   */
  @Test
  void testGetState() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getState());
  }

  /**
   * Method under test: {@link Tenant#getCity()}
   */
  @Test
  void testGetCity() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getCity());
  }

  /**
   * Method under test: {@link Tenant#getAddress()}
   */
  @Test
  void testGetAddress() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getAddress());
  }

  /**
   * Method under test: {@link Tenant#getAddress2()}
   */
  @Test
  void testGetAddress2() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getAddress2());
  }

  /**
   * Method under test: {@link Tenant#getZip()}
   */
  @Test
  void testGetZip() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getZip());
  }

  /**
   * Method under test: {@link Tenant#getPhone()}
   */
  @Test
  void testGetPhone() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getPhone());
  }

  /**
   * Method under test: {@link Tenant#getEmail()}
   */
  @Test
  void testGetEmail() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getEmail());
  }

  /**
   * Method under test: {@link Tenant#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull((new Tenant()).getAdditionalInfo());
  }

  /**
   * Method under test: {@link Tenant#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo2() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new Tenant(new Tenant())).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Method under test: {@link Tenant#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo3() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new Tenant(new Tenant(new Tenant()))).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Tenant#equals(Object)}
   *   <li>{@link Tenant#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Tenant tenant = new Tenant();
    Tenant tenant2 = new Tenant();

    // Act and Assert
    assertEquals(tenant, tenant2);
    int expectedHashCodeResult = tenant.hashCode();
    assertEquals(expectedHashCodeResult, tenant2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Tenant#equals(Object)}
   *   <li>{@link Tenant#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Tenant tenant = new Tenant();

    // Act and Assert
    assertEquals(tenant, tenant);
    int expectedHashCodeResult = tenant.hashCode();
    assertEquals(expectedHashCodeResult, tenant.hashCode());
  }

  /**
   * Method under test: {@link Tenant#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Tenant tenant = new Tenant(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(tenant, new Tenant());
  }

  /**
   * Method under test: {@link Tenant#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Tenant tenant = new Tenant();

    // Act and Assert
    assertNotEquals(tenant, new TenantInfo());
  }

  /**
   * Method under test: {@link Tenant#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new Tenant(), mock(Customer.class));
  }

  /**
   * Method under test: {@link Tenant#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Tenant tenant = new Tenant();
    TenantInfo tenantInfo = mock(TenantInfo.class);
    when(tenantInfo.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tenant, tenantInfo);
  }

  /**
   * Method under test: {@link Tenant#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Tenant(), null);
  }

  /**
   * Method under test: {@link Tenant#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Tenant(), "Different type to Tenant");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Tenant#Tenant()}
   *   <li>{@link Tenant#setRegion(String)}
   *   <li>{@link Tenant#setTitle(String)}
   *   <li>{@link Tenant#setVersion(Long)}
   *   <li>{@link Tenant#toString()}
   *   <li>{@link Tenant#getName()}
   *   <li>{@link Tenant#getRegion()}
   *   <li>{@link Tenant#getTenantProfileId()}
   *   <li>{@link Tenant#getTitle()}
   *   <li>{@link Tenant#getVersion()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Tenant actualTenant = new Tenant();
    actualTenant.setRegion("us-east-2");
    actualTenant.setTitle("Dr");
    actualTenant.setVersion(1L);
    String actualToStringResult = actualTenant.toString();
    String actualName = actualTenant.getName();
    String actualRegion = actualTenant.getRegion();
    actualTenant.getTenantProfileId();
    String actualTitle = actualTenant.getTitle();
    Long actualVersion = actualTenant.getVersion();

    // Assert that nothing has changed
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualTitle);
    assertEquals("Tenant [title=Dr, region=us-east-2, tenantProfileId=null, additionalInfo=null, country=null,"
        + " state=null, city=null, address=null, address2=null, zip=null, phone=null, email=null, createdTime=0,"
        + " id=null]", actualToStringResult);
    assertEquals("us-east-2", actualRegion);
    assertEquals(0L, actualTenant.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Tenant#Tenant(TenantId)}
   *   <li>{@link Tenant#setRegion(String)}
   *   <li>{@link Tenant#setTitle(String)}
   *   <li>{@link Tenant#setVersion(Long)}
   *   <li>{@link Tenant#toString()}
   *   <li>{@link Tenant#getName()}
   *   <li>{@link Tenant#getRegion()}
   *   <li>{@link Tenant#getTenantProfileId()}
   *   <li>{@link Tenant#getTitle()}
   *   <li>{@link Tenant#getVersion()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    TenantId id = TenantId.SYS_TENANT_ID;

    // Act
    Tenant actualTenant = new Tenant(id);
    actualTenant.setRegion("us-east-2");
    actualTenant.setTitle("Dr");
    actualTenant.setVersion(1L);
    String actualToStringResult = actualTenant.toString();
    String actualName = actualTenant.getName();
    String actualRegion = actualTenant.getRegion();
    actualTenant.getTenantProfileId();
    String actualTitle = actualTenant.getTitle();
    Long actualVersion = actualTenant.getVersion();

    // Assert that nothing has changed
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualTitle);
    assertEquals(
        "Tenant [title=Dr, region=us-east-2, tenantProfileId=null, additionalInfo=null, country=null, state=null,"
            + " city=null, address=null, address2=null, zip=null, phone=null, email=null, createdTime=0, id=13814000"
            + "-1dd2-11b2-8080-808080808080]",
        actualToStringResult);
    assertEquals("us-east-2", actualRegion);
    assertEquals(0L, actualTenant.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
    TenantId expectedId = id.SYS_TENANT_ID;
    assertSame(expectedId, actualTenant.getId());
  }

  /**
   * Method under test: {@link Tenant#Tenant(Tenant)}
   */
  @Test
  void testNewTenant() throws IOException {
    // Arrange and Act
    Tenant actualTenant = new Tenant(new Tenant());

    // Assert
    JsonNode additionalInfo = actualTenant.getAdditionalInfo();
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
    assertNull(actualTenant.getVersion());
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
    assertNull(actualTenant.getAddress());
    assertNull(actualTenant.getAddress2());
    assertNull(actualTenant.getCity());
    assertNull(actualTenant.getCountry());
    assertNull(actualTenant.getEmail());
    assertNull(actualTenant.getName());
    assertNull(actualTenant.getPhone());
    assertNull(actualTenant.getRegion());
    assertNull(actualTenant.getState());
    assertNull(actualTenant.getTitle());
    assertNull(actualTenant.getZip());
    assertNull(actualTenant.getUuidId());
    assertNull(actualTenant.getId());
    assertNull(actualTenant.getTenantId());
    assertNull(actualTenant.getTenantProfileId());
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
    assertEquals(0L, actualTenant.getCreatedTime());
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
   * Method under test: {@link Tenant#Tenant(Tenant)}
   */
  @Test
  void testNewTenant2() throws IOException {
    // Arrange
    Tenant tenant = new Tenant(new Tenant());

    // Act
    Tenant actualTenant = new Tenant(tenant);

    // Assert
    JsonNode additionalInfo = actualTenant.getAdditionalInfo();
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
    assertNull(tenant.getVersion());
    assertNull(actualTenant.getVersion());
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
    assertNull(tenant.getAddress());
    assertNull(actualTenant.getAddress());
    assertNull(tenant.getAddress2());
    assertNull(actualTenant.getAddress2());
    assertNull(tenant.getCity());
    assertNull(actualTenant.getCity());
    assertNull(tenant.getCountry());
    assertNull(actualTenant.getCountry());
    assertNull(tenant.getEmail());
    assertNull(actualTenant.getEmail());
    assertNull(tenant.getName());
    assertNull(actualTenant.getName());
    assertNull(tenant.getPhone());
    assertNull(actualTenant.getPhone());
    assertNull(tenant.getRegion());
    assertNull(actualTenant.getRegion());
    assertNull(tenant.getState());
    assertNull(actualTenant.getState());
    assertNull(tenant.getTitle());
    assertNull(actualTenant.getTitle());
    assertNull(tenant.getZip());
    assertNull(actualTenant.getZip());
    assertNull(tenant.getUuidId());
    assertNull(actualTenant.getUuidId());
    assertNull(tenant.getId());
    assertNull(actualTenant.getId());
    assertNull(tenant.getTenantId());
    assertNull(actualTenant.getTenantId());
    assertNull(tenant.getTenantProfileId());
    assertNull(actualTenant.getTenantProfileId());
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
    assertEquals(0L, tenant.getCreatedTime());
    assertEquals(0L, actualTenant.getCreatedTime());
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
   * Method under test: {@link Tenant#Tenant(Tenant)}
   */
  @Test
  void testNewTenant3() throws IOException {
    // Arrange
    Tenant tenant = new Tenant(new Tenant(new Tenant()));

    // Act
    Tenant actualTenant = new Tenant(tenant);

    // Assert
    JsonNode additionalInfo = actualTenant.getAdditionalInfo();
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
    assertNull(tenant.getVersion());
    assertNull(actualTenant.getVersion());
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
    assertNull(tenant.getAddress());
    assertNull(actualTenant.getAddress());
    assertNull(tenant.getAddress2());
    assertNull(actualTenant.getAddress2());
    assertNull(tenant.getCity());
    assertNull(actualTenant.getCity());
    assertNull(tenant.getCountry());
    assertNull(actualTenant.getCountry());
    assertNull(tenant.getEmail());
    assertNull(actualTenant.getEmail());
    assertNull(tenant.getName());
    assertNull(actualTenant.getName());
    assertNull(tenant.getPhone());
    assertNull(actualTenant.getPhone());
    assertNull(tenant.getRegion());
    assertNull(actualTenant.getRegion());
    assertNull(tenant.getState());
    assertNull(actualTenant.getState());
    assertNull(tenant.getTitle());
    assertNull(actualTenant.getTitle());
    assertNull(tenant.getZip());
    assertNull(actualTenant.getZip());
    assertNull(tenant.getUuidId());
    assertNull(actualTenant.getUuidId());
    assertNull(tenant.getId());
    assertNull(actualTenant.getId());
    assertNull(tenant.getTenantId());
    assertNull(actualTenant.getTenantId());
    assertNull(tenant.getTenantProfileId());
    assertNull(actualTenant.getTenantProfileId());
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
    assertEquals(0L, tenant.getCreatedTime());
    assertEquals(0L, actualTenant.getCreatedTime());
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
