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
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.Authority;

class UserDiffblueTest {
  /**
   * Method under test: {@link User#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new User()).getId());
  }

  /**
   * Method under test: {@link User#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new User()).getCreatedTime());
  }

  /**
   * Method under test: {@link User#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo() {
    // Arrange, Act and Assert
    assertNull((new User()).getAdditionalInfo());
  }

  /**
   * Method under test: {@link User#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo2() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new User(new User())).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Method under test: {@link User#getAdditionalInfo()}
   */
  @Test
  void testGetAdditionalInfo3() {
    // Arrange and Act
    JsonNode actualAdditionalInfo = (new User(new User(new User()))).getAdditionalInfo();

    // Assert
    assertSame(((NullNode) actualAdditionalInfo).instance, actualAdditionalInfo);
  }

  /**
   * Method under test: {@link User#getTitle()}
   */
  @Test
  void testGetTitle() {
    // Arrange, Act and Assert
    assertNull((new User()).getTitle());
    assertEquals("Jane Doe", User.getTitle("jane.doe@example.org", "Jane", "Doe"));
    assertEquals("jane.doe@example.org", User.getTitle("jane.doe@example.org", null, null));
    assertEquals("Doe", User.getTitle("jane.doe@example.org", null, "Doe"));
    assertEquals("Doe", User.getTitle("jane.doe@example.org", DataConstants.DEFAULT_SECRET_KEY, "Doe"));
  }

  /**
   * Method under test: {@link User#getTitle()}
   */
  @Test
  void testGetTitle2() {
    // Arrange
    User user = new User();
    user.setLastName(null);
    user.setFirstName("foo");

    // Act and Assert
    assertEquals("foo", user.getTitle());
  }

  /**
   * Method under test: {@link User#getTitle()}
   */
  @Test
  void testGetTitle3() {
    // Arrange
    User user = new User();
    user.setLastName("foo");
    user.setFirstName(null);

    // Act and Assert
    assertEquals("foo", user.getTitle());
  }

  /**
   * Method under test: {@link User#getTitle()}
   */
  @Test
  void testGetTitle4() {
    // Arrange
    User user = new User();
    user.setLastName("foo");
    user.setFirstName("foo");

    // Act and Assert
    assertEquals("foo foo", user.getTitle());
  }

  /**
   * Method under test: {@link User#getTitle()}
   */
  @Test
  void testGetTitle5() {
    // Arrange
    User user = new User();
    user.setLastName(DataConstants.DEFAULT_SECRET_KEY);
    user.setFirstName("foo");

    // Act and Assert
    assertEquals("foo", user.getTitle());
  }

  /**
   * Method under test: {@link User#isSystemAdmin()}
   */
  @Test
  void testIsSystemAdmin() {
    // Arrange, Act and Assert
    assertTrue((new User()).isSystemAdmin());
  }

  /**
   * Method under test: {@link User#isSystemAdmin()}
   */
  @Test
  void testIsSystemAdmin2() {
    // Arrange
    User user = new User();
    user.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertTrue(user.isSystemAdmin());
  }

  /**
   * Method under test: {@link User#isSystemAdmin()}
   */
  @Test
  void testIsSystemAdmin3() {
    // Arrange
    User user = new User();
    user.setTenantId(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertFalse(user.isSystemAdmin());
  }

  /**
   * Method under test: {@link User#isTenantAdmin()}
   */
  @Test
  void testIsTenantAdmin() {
    // Arrange, Act and Assert
    assertFalse((new User()).isTenantAdmin());
  }

  /**
   * Method under test: {@link User#isTenantAdmin()}
   */
  @Test
  void testIsTenantAdmin2() {
    // Arrange
    User user = new User();
    user.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertFalse(user.isTenantAdmin());
  }

  /**
   * Method under test: {@link User#isTenantAdmin()}
   */
  @Test
  void testIsTenantAdmin3() {
    // Arrange
    User user = new User();
    user.setTenantId(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertTrue(user.isTenantAdmin());
  }

  /**
   * Method under test: {@link User#isTenantAdmin()}
   */
  @Test
  void testIsTenantAdmin4() {
    // Arrange
    User user = new User();
    user.setCustomerId(new CustomerId(EntityId.NULL_UUID));
    user.setTenantId(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertTrue(user.isTenantAdmin());
  }

  /**
   * Method under test: {@link User#isTenantAdmin()}
   */
  @Test
  void testIsTenantAdmin5() {
    // Arrange
    User user = new User();
    user.setCustomerId(new CustomerId(UUID.randomUUID()));
    user.setTenantId(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertFalse(user.isTenantAdmin());
  }

  /**
   * Method under test: {@link User#isCustomerUser()}
   */
  @Test
  void testIsCustomerUser() {
    // Arrange, Act and Assert
    assertFalse((new User()).isCustomerUser());
  }

  /**
   * Method under test: {@link User#isCustomerUser()}
   */
  @Test
  void testIsCustomerUser2() {
    // Arrange
    User user = new User();
    user.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertFalse(user.isCustomerUser());
  }

  /**
   * Method under test: {@link User#isCustomerUser()}
   */
  @Test
  void testIsCustomerUser3() {
    // Arrange
    User user = new User();
    user.setTenantId(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertFalse(user.isCustomerUser());
  }

  /**
   * Method under test: {@link User#isCustomerUser()}
   */
  @Test
  void testIsCustomerUser4() {
    // Arrange
    User user = new User();
    user.setCustomerId(new CustomerId(EntityId.NULL_UUID));
    user.setTenantId(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertFalse(user.isCustomerUser());
  }

  /**
   * Method under test: {@link User#isCustomerUser()}
   */
  @Test
  void testIsCustomerUser5() {
    // Arrange
    User user = new User();
    user.setCustomerId(new CustomerId(UUID.randomUUID()));
    user.setTenantId(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertTrue(user.isCustomerUser());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link User#equals(Object)}
   *   <li>{@link User#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    User user = new User();
    User user2 = new User();

    // Act and Assert
    assertEquals(user, user2);
    int expectedHashCodeResult = user.hashCode();
    assertEquals(expectedHashCodeResult, user2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link User#equals(Object)}
   *   <li>{@link User#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    User user = new User();

    // Act and Assert
    assertEquals(user, user);
    int expectedHashCodeResult = user.hashCode();
    assertEquals(expectedHashCodeResult, user.hashCode());
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    User user = new User(new User());

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new User(), mock(AdminSettings.class));
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    User user = new User();
    user.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    User user = new User();
    user.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    User user = new User();
    user.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    User user = new User();
    user.setAuthority(Authority.SYS_ADMIN);

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    User user = new User();
    user.setFirstName("Jane");

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    User user = new User();
    user.setLastName("Doe");

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    User user = new User();
    user.setPhone("6625550144");

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    User user = new User();
    user.setVersion(1L);

    // Act and Assert
    assertNotEquals(user, new User());
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    User user = new User();

    User user2 = new User();
    user2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(user, user2);
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    User user = new User();

    User user2 = new User();
    user2.setCustomerId(new CustomerId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(user, user2);
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    User user = new User();

    User user2 = new User();
    user2.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(user, user2);
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    User user = new User();

    User user2 = new User();
    user2.setAuthority(Authority.SYS_ADMIN);

    // Act and Assert
    assertNotEquals(user, user2);
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    User user = new User();

    User user2 = new User();
    user2.setFirstName("Jane");

    // Act and Assert
    assertNotEquals(user, user2);
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    User user = new User();

    User user2 = new User();
    user2.setLastName("Doe");

    // Act and Assert
    assertNotEquals(user, user2);
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    User user = new User();

    User user2 = new User();
    user2.setPhone("6625550144");

    // Act and Assert
    assertNotEquals(user, user2);
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    User user = new User();

    User user2 = new User();
    user2.setVersion(1L);

    // Act and Assert
    assertNotEquals(user, user2);
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new User(), null);
  }

  /**
   * Method under test: {@link User#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new User(), "Different type to User");
  }

  /**
   * Method under test: {@link User#User(User)}
   */
  @Test
  void testNewUser() throws IOException {
    // Arrange and Act
    User actualUser = new User(new User());

    // Assert
    JsonNode additionalInfo = actualUser.getAdditionalInfo();
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
    assertNull(actualUser.getVersion());
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
    assertNull(actualUser.getEmail());
    assertNull(actualUser.getFirstName());
    assertNull(actualUser.getLastName());
    assertNull(actualUser.getName());
    assertNull(actualUser.getPhone());
    assertNull(actualUser.getTitle());
    assertNull(actualUser.getUuidId());
    assertNull(actualUser.getCustomerId());
    assertNull(actualUser.getTenantId());
    assertNull(actualUser.getId());
    assertNull(actualUser.getAuthority());
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
    assertEquals(0L, actualUser.getCreatedTime());
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
    assertFalse(actualUser.isCustomerUser());
    assertFalse(actualUser.isTenantAdmin());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertTrue(actualUser.isSystemAdmin());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link User#User(User)}
   */
  @Test
  void testNewUser2() throws IOException {
    // Arrange
    User user = new User(new User());

    // Act
    User actualUser = new User(user);

    // Assert
    JsonNode additionalInfo = actualUser.getAdditionalInfo();
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
    assertNull(user.getVersion());
    assertNull(actualUser.getVersion());
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
    assertNull(user.getEmail());
    assertNull(actualUser.getEmail());
    assertNull(user.getFirstName());
    assertNull(actualUser.getFirstName());
    assertNull(user.getLastName());
    assertNull(actualUser.getLastName());
    assertNull(user.getName());
    assertNull(actualUser.getName());
    assertNull(user.getPhone());
    assertNull(actualUser.getPhone());
    assertNull(user.getTitle());
    assertNull(actualUser.getTitle());
    assertNull(user.getUuidId());
    assertNull(actualUser.getUuidId());
    assertNull(user.getCustomerId());
    assertNull(actualUser.getCustomerId());
    assertNull(user.getTenantId());
    assertNull(actualUser.getTenantId());
    assertNull(user.getId());
    assertNull(actualUser.getId());
    assertNull(user.getAuthority());
    assertNull(actualUser.getAuthority());
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
    assertEquals(0L, user.getCreatedTime());
    assertEquals(0L, actualUser.getCreatedTime());
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
    assertFalse(user.isCustomerUser());
    assertFalse(actualUser.isCustomerUser());
    assertFalse(user.isTenantAdmin());
    assertFalse(actualUser.isTenantAdmin());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertTrue(user.isSystemAdmin());
    assertTrue(actualUser.isSystemAdmin());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link User#User(User)}
   */
  @Test
  void testNewUser3() throws IOException {
    // Arrange
    User user = new User(new User(new User()));

    // Act
    User actualUser = new User(user);

    // Assert
    JsonNode additionalInfo = actualUser.getAdditionalInfo();
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
    assertNull(user.getVersion());
    assertNull(actualUser.getVersion());
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
    assertNull(user.getEmail());
    assertNull(actualUser.getEmail());
    assertNull(user.getFirstName());
    assertNull(actualUser.getFirstName());
    assertNull(user.getLastName());
    assertNull(actualUser.getLastName());
    assertNull(user.getName());
    assertNull(actualUser.getName());
    assertNull(user.getPhone());
    assertNull(actualUser.getPhone());
    assertNull(user.getTitle());
    assertNull(actualUser.getTitle());
    assertNull(user.getUuidId());
    assertNull(actualUser.getUuidId());
    assertNull(user.getCustomerId());
    assertNull(actualUser.getCustomerId());
    assertNull(user.getTenantId());
    assertNull(actualUser.getTenantId());
    assertNull(user.getId());
    assertNull(actualUser.getId());
    assertNull(user.getAuthority());
    assertNull(actualUser.getAuthority());
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
    assertEquals(0L, user.getCreatedTime());
    assertEquals(0L, actualUser.getCreatedTime());
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
    assertFalse(user.isCustomerUser());
    assertFalse(actualUser.isCustomerUser());
    assertFalse(user.isTenantAdmin());
    assertFalse(actualUser.isTenantAdmin());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertTrue(user.isSystemAdmin());
    assertTrue(actualUser.isSystemAdmin());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getColumnNr());
    assertEquals(StringUtils.INDEX_NOT_FOUND, currentLocation.getLineNr());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }
}
