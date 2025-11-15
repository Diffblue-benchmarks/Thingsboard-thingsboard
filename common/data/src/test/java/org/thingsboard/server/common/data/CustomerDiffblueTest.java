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
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class CustomerDiffblueTest {
  /**
   * Method under test: {@link Customer#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new Customer()).getId());
  }

  /**
   * Method under test: {@link Customer#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new Customer()).getCreatedTime());
  }

  /**
   * Method under test: {@link Customer#getCountry()}
   */
  @Test
  void testGetCountry() {
    // Arrange, Act and Assert
    assertNull((new Customer()).getCountry());
  }

  /**
   * Method under test: {@link Customer#getState()}
   */
  @Test
  void testGetState() {
    // Arrange, Act and Assert
    assertNull((new Customer()).getState());
  }

  /**
   * Method under test: {@link Customer#getCity()}
   */
  @Test
  void testGetCity() {
    // Arrange, Act and Assert
    assertNull((new Customer()).getCity());
  }

  /**
   * Method under test: {@link Customer#getAddress()}
   */
  @Test
  void testGetAddress() {
    // Arrange, Act and Assert
    assertNull((new Customer()).getAddress());
  }

  /**
   * Method under test: {@link Customer#getAddress2()}
   */
  @Test
  void testGetAddress2() {
    // Arrange, Act and Assert
    assertNull((new Customer()).getAddress2());
  }

  /**
   * Method under test: {@link Customer#getZip()}
   */
  @Test
  void testGetZip() {
    // Arrange, Act and Assert
    assertNull((new Customer()).getZip());
  }

  /**
   * Method under test: {@link Customer#getPhone()}
   */
  @Test
  void testGetPhone() {
    // Arrange, Act and Assert
    assertNull((new Customer()).getPhone());
  }

  /**
   * Method under test: {@link Customer#getEmail()}
   */
  @Test
  void testGetEmail() {
    // Arrange, Act and Assert
    assertNull((new Customer()).getEmail());
  }

  /**
   * Method under test: {@link Customer#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull((new Customer()).getAdditionalInfo());
  }

  /**
   * Method under test: {@link Customer#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo2() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new Customer(new Customer())).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Method under test: {@link Customer#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo3() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new Customer(new Customer(new Customer()))).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Method under test: {@link Customer#isPublic()}
   */
  @Test
  void testIsPublic() {
    // Arrange, Act and Assert
    assertFalse((new Customer()).isPublic());
    assertFalse((new Customer(new Customer())).isPublic());
    assertFalse((new Customer(new Customer(new Customer()))).isPublic());
  }

  /**
   * Method under test: {@link Customer#toShortCustomerInfo()}
   */
  @Test
  void testToShortCustomerInfo() {
    // Arrange and Act
    ShortCustomerInfo actualToShortCustomerInfoResult = (new Customer()).toShortCustomerInfo();

    // Assert
    assertNull(actualToShortCustomerInfoResult.getTitle());
    assertNull(actualToShortCustomerInfoResult.getCustomerId());
    assertFalse(actualToShortCustomerInfoResult.isPublic());
  }

  /**
   * Method under test: {@link Customer#toShortCustomerInfo()}
   */
  @Test
  void testToShortCustomerInfo2() {
    // Arrange and Act
    ShortCustomerInfo actualToShortCustomerInfoResult = (new Customer(new Customer())).toShortCustomerInfo();

    // Assert
    assertNull(actualToShortCustomerInfoResult.getTitle());
    assertNull(actualToShortCustomerInfoResult.getCustomerId());
    assertFalse(actualToShortCustomerInfoResult.isPublic());
  }

  /**
   * Method under test: {@link Customer#toShortCustomerInfo()}
   */
  @Test
  void testToShortCustomerInfo3() {
    // Arrange and Act
    ShortCustomerInfo actualToShortCustomerInfoResult = (new Customer(new Customer(new Customer())))
        .toShortCustomerInfo();

    // Assert
    assertNull(actualToShortCustomerInfoResult.getTitle());
    assertNull(actualToShortCustomerInfoResult.getCustomerId());
    assertFalse(actualToShortCustomerInfoResult.isPublic());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Customer#equals(Object)}
   *   <li>{@link Customer#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Customer customer = new Customer();
    Customer customer2 = new Customer();

    // Act and Assert
    assertEquals(customer, customer2);
    int expectedHashCodeResult = customer.hashCode();
    assertEquals(expectedHashCodeResult, customer2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Customer#equals(Object)}
   *   <li>{@link Customer#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Customer customer = new Customer();
    customer.setTenantId(TenantId.SYS_TENANT_ID);

    Customer customer2 = new Customer();
    customer2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(customer, customer2);
    int expectedHashCodeResult = customer.hashCode();
    assertEquals(expectedHashCodeResult, customer2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Customer#equals(Object)}
   *   <li>{@link Customer#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Customer customer = new Customer();
    customer.setTitle("Dr");

    Customer customer2 = new Customer();
    customer2.setTitle("Dr");

    // Act and Assert
    assertEquals(customer, customer2);
    int expectedHashCodeResult = customer.hashCode();
    assertEquals(expectedHashCodeResult, customer2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Customer#equals(Object)}
   *   <li>{@link Customer#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Customer customer = new Customer();
    customer.setExternalId(new CustomerId(EntityId.NULL_UUID));

    Customer customer2 = new Customer();
    customer2.setExternalId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertEquals(customer, customer2);
    int expectedHashCodeResult = customer.hashCode();
    assertEquals(expectedHashCodeResult, customer2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Customer#equals(Object)}
   *   <li>{@link Customer#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    Customer customer = new Customer();
    customer.setVersion(1L);

    Customer customer2 = new Customer();
    customer2.setVersion(1L);

    // Act and Assert
    assertEquals(customer, customer2);
    int expectedHashCodeResult = customer.hashCode();
    assertEquals(expectedHashCodeResult, customer2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Customer#equals(Object)}
   *   <li>{@link Customer#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Customer customer = new Customer();

    // Act and Assert
    assertEquals(customer, customer);
    int expectedHashCodeResult = customer.hashCode();
    assertEquals(expectedHashCodeResult, customer.hashCode());
  }

  /**
   * Method under test: {@link Customer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Customer customer = new Customer(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(customer, new Customer());
  }

  /**
   * Method under test: {@link Customer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new Customer(), mock(AdminSettings.class));
  }

  /**
   * Method under test: {@link Customer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Customer customer = new Customer();
    customer.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(customer, new Customer());
  }

  /**
   * Method under test: {@link Customer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Customer customer = new Customer();
    customer.setTitle("Dr");

    // Act and Assert
    assertNotEquals(customer, new Customer());
  }

  /**
   * Method under test: {@link Customer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Customer customer = new Customer();
    customer.setExternalId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(customer, new Customer());
  }

  /**
   * Method under test: {@link Customer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Customer customer = new Customer();
    customer.setVersion(1L);

    // Act and Assert
    assertNotEquals(customer, new Customer());
  }

  /**
   * Method under test: {@link Customer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Customer customer = new Customer();

    Customer customer2 = new Customer();
    customer2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(customer, customer2);
  }

  /**
   * Method under test: {@link Customer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Customer customer = new Customer();

    Customer customer2 = new Customer();
    customer2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(customer, customer2);
  }

  /**
   * Method under test: {@link Customer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Customer customer = new Customer();

    Customer customer2 = new Customer();
    customer2.setExternalId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(customer, customer2);
  }

  /**
   * Method under test: {@link Customer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Customer customer = new Customer();

    Customer customer2 = new Customer();
    customer2.setVersion(1L);

    // Act and Assert
    assertNotEquals(customer, customer2);
  }

  /**
   * Method under test: {@link Customer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Customer(), null);
  }

  /**
   * Method under test: {@link Customer#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Customer(), "Different type to Customer");
  }

  /**
   * Method under test: {@link Customer#getExternalId()}
   */
  @Test
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new Customer()).getExternalId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Customer#Customer()}
   *   <li>{@link Customer#setExternalId(CustomerId)}
   *   <li>{@link Customer#setTenantId(TenantId)}
   *   <li>{@link Customer#setTitle(String)}
   *   <li>{@link Customer#setVersion(Long)}
   *   <li>{@link Customer#toString()}
   *   <li>{@link Customer#getName()}
   *   <li>{@link Customer#getTenantId()}
   *   <li>{@link Customer#getTitle()}
   *   <li>{@link Customer#getVersion()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Customer actualCustomer = new Customer();
    CustomerId externalId = new CustomerId(EntityId.NULL_UUID);
    actualCustomer.setExternalId(externalId);
    actualCustomer.setTenantId(TenantId.SYS_TENANT_ID);
    actualCustomer.setTitle("Dr");
    actualCustomer.setVersion(1L);
    String actualToStringResult = actualCustomer.toString();
    String actualName = actualCustomer.getName();
    TenantId actualTenantId = actualCustomer.getTenantId();
    String actualTitle = actualCustomer.getTitle();
    Long actualVersion = actualCustomer.getVersion();

    // Assert that nothing has changed
    assertEquals("Customer [title=Dr, tenantId=13814000-1dd2-11b2-8080-808080808080, additionalInfo=null, country=null,"
        + " state=null, city=null, address=null, address2=null, zip=null, phone=null, email=null, createdTime=0,"
        + " id=null]", actualToStringResult);
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualTitle);
    assertEquals(0L, actualCustomer.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
    assertSame(externalId, actualCustomer.getExternalId());
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Customer#Customer(CustomerId)}
   *   <li>{@link Customer#setExternalId(CustomerId)}
   *   <li>{@link Customer#setTenantId(TenantId)}
   *   <li>{@link Customer#setTitle(String)}
   *   <li>{@link Customer#setVersion(Long)}
   *   <li>{@link Customer#toString()}
   *   <li>{@link Customer#getName()}
   *   <li>{@link Customer#getTenantId()}
   *   <li>{@link Customer#getTitle()}
   *   <li>{@link Customer#getVersion()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    CustomerId id = new CustomerId(EntityId.NULL_UUID);

    // Act
    Customer actualCustomer = new Customer(id);
    CustomerId externalId = new CustomerId(EntityId.NULL_UUID);
    actualCustomer.setExternalId(externalId);
    actualCustomer.setTenantId(TenantId.SYS_TENANT_ID);
    actualCustomer.setTitle("Dr");
    actualCustomer.setVersion(1L);
    String actualToStringResult = actualCustomer.toString();
    String actualName = actualCustomer.getName();
    TenantId actualTenantId = actualCustomer.getTenantId();
    String actualTitle = actualCustomer.getTitle();
    Long actualVersion = actualCustomer.getVersion();

    // Assert that nothing has changed
    assertEquals("Customer [title=Dr, tenantId=13814000-1dd2-11b2-8080-808080808080, additionalInfo=null, country=null,"
        + " state=null, city=null, address=null, address2=null, zip=null, phone=null, email=null, createdTime=0,"
        + " id=13814000-1dd2-11b2-8080-808080808080]", actualToStringResult);
    assertEquals("Dr", actualName);
    assertEquals("Dr", actualTitle);
    assertEquals(0L, actualCustomer.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
    assertSame(externalId, actualCustomer.getExternalId());
    assertSame(id, actualCustomer.getId());
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Method under test: {@link Customer#Customer(Customer)}
   */
  @Test
  void testNewCustomer() throws IOException {
    // Arrange and Act
    Customer actualCustomer = new Customer(new Customer());

    // Assert
    JsonNode additionalInfo = actualCustomer.getAdditionalInfo();
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
    assertNull(actualCustomer.getVersion());
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
    assertNull(actualCustomer.getAddress());
    assertNull(actualCustomer.getAddress2());
    assertNull(actualCustomer.getCity());
    assertNull(actualCustomer.getCountry());
    assertNull(actualCustomer.getEmail());
    assertNull(actualCustomer.getName());
    assertNull(actualCustomer.getPhone());
    assertNull(actualCustomer.getState());
    assertNull(actualCustomer.getTitle());
    assertNull(actualCustomer.getZip());
    ShortCustomerInfo toShortCustomerInfoResult = actualCustomer.toShortCustomerInfo();
    assertNull(toShortCustomerInfoResult.getTitle());
    assertNull(actualCustomer.getUuidId());
    assertNull(actualCustomer.getExternalId());
    assertNull(actualCustomer.getId());
    assertNull(toShortCustomerInfoResult.getCustomerId());
    assertNull(actualCustomer.getTenantId());
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
    assertEquals(0L, actualCustomer.getCreatedTime());
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
    assertFalse(toShortCustomerInfoResult.isPublic());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link Customer#Customer(Customer)}
   */
  @Test
  void testNewCustomer2() throws IOException {
    // Arrange
    Customer customer = new Customer(new Customer());

    // Act
    Customer actualCustomer = new Customer(customer);

    // Assert
    JsonNode additionalInfo = actualCustomer.getAdditionalInfo();
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
    assertNull(customer.getVersion());
    assertNull(actualCustomer.getVersion());
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
    assertNull(customer.getAddress());
    assertNull(actualCustomer.getAddress());
    assertNull(customer.getAddress2());
    assertNull(actualCustomer.getAddress2());
    assertNull(customer.getCity());
    assertNull(actualCustomer.getCity());
    assertNull(customer.getCountry());
    assertNull(actualCustomer.getCountry());
    assertNull(customer.getEmail());
    assertNull(actualCustomer.getEmail());
    assertNull(customer.getName());
    assertNull(actualCustomer.getName());
    assertNull(customer.getPhone());
    assertNull(actualCustomer.getPhone());
    assertNull(customer.getState());
    assertNull(actualCustomer.getState());
    assertNull(customer.getTitle());
    assertNull(actualCustomer.getTitle());
    assertNull(customer.getZip());
    assertNull(actualCustomer.getZip());
    ShortCustomerInfo toShortCustomerInfoResult = customer.toShortCustomerInfo();
    assertNull(toShortCustomerInfoResult.getTitle());
    ShortCustomerInfo toShortCustomerInfoResult2 = actualCustomer.toShortCustomerInfo();
    assertNull(toShortCustomerInfoResult2.getTitle());
    assertNull(customer.getUuidId());
    assertNull(actualCustomer.getUuidId());
    assertNull(customer.getExternalId());
    assertNull(actualCustomer.getExternalId());
    assertNull(customer.getId());
    assertNull(actualCustomer.getId());
    assertNull(toShortCustomerInfoResult.getCustomerId());
    assertNull(toShortCustomerInfoResult2.getCustomerId());
    assertNull(customer.getTenantId());
    assertNull(actualCustomer.getTenantId());
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
    assertEquals(0L, customer.getCreatedTime());
    assertEquals(0L, actualCustomer.getCreatedTime());
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
    assertFalse(toShortCustomerInfoResult.isPublic());
    assertFalse(toShortCustomerInfoResult2.isPublic());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link Customer#Customer(Customer)}
   */
  @Test
  void testNewCustomer3() throws IOException {
    // Arrange
    Customer customer = new Customer(new Customer(new Customer()));

    // Act
    Customer actualCustomer = new Customer(customer);

    // Assert
    JsonNode additionalInfo = actualCustomer.getAdditionalInfo();
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
    assertNull(customer.getVersion());
    assertNull(actualCustomer.getVersion());
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
    assertNull(customer.getAddress());
    assertNull(actualCustomer.getAddress());
    assertNull(customer.getAddress2());
    assertNull(actualCustomer.getAddress2());
    assertNull(customer.getCity());
    assertNull(actualCustomer.getCity());
    assertNull(customer.getCountry());
    assertNull(actualCustomer.getCountry());
    assertNull(customer.getEmail());
    assertNull(actualCustomer.getEmail());
    assertNull(customer.getName());
    assertNull(actualCustomer.getName());
    assertNull(customer.getPhone());
    assertNull(actualCustomer.getPhone());
    assertNull(customer.getState());
    assertNull(actualCustomer.getState());
    assertNull(customer.getTitle());
    assertNull(actualCustomer.getTitle());
    assertNull(customer.getZip());
    assertNull(actualCustomer.getZip());
    ShortCustomerInfo toShortCustomerInfoResult = customer.toShortCustomerInfo();
    assertNull(toShortCustomerInfoResult.getTitle());
    ShortCustomerInfo toShortCustomerInfoResult2 = actualCustomer.toShortCustomerInfo();
    assertNull(toShortCustomerInfoResult2.getTitle());
    assertNull(customer.getUuidId());
    assertNull(actualCustomer.getUuidId());
    assertNull(customer.getExternalId());
    assertNull(actualCustomer.getExternalId());
    assertNull(customer.getId());
    assertNull(actualCustomer.getId());
    assertNull(toShortCustomerInfoResult.getCustomerId());
    assertNull(toShortCustomerInfoResult2.getCustomerId());
    assertNull(customer.getTenantId());
    assertNull(actualCustomer.getTenantId());
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
    assertEquals(0L, customer.getCreatedTime());
    assertEquals(0L, actualCustomer.getCreatedTime());
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
    assertFalse(toShortCustomerInfoResult.isPublic());
    assertFalse(toShortCustomerInfoResult2.isPublic());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }
}
