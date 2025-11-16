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
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.UserAuthSettingsId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.UserAuthSettings;
import org.thingsboard.server.common.data.security.model.mfa.account.AccountTwoFaSettings;
import org.thingsboard.server.common.data.security.model.mfa.account.BackupCodeTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.account.TwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class UserAuthSettingsEntityDiffblueTest {
  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}, and {@link
   * UserAuthSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserAuthSettingsEntity#equals(Object)}
   *   <li>{@link UserAuthSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
    assertEquals(userAuthSettingsEntity.hashCode(), userAuthSettingsEntity2.hashCode());
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}, and {@link
   * UserAuthSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserAuthSettingsEntity#equals(Object)}
   *   <li>{@link UserAuthSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(null);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setTwoFaSettings(null);
    userAuthSettingsEntity2.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
    assertEquals(userAuthSettingsEntity.hashCode(), userAuthSettingsEntity2.hashCode());
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}, and {@link
   * UserAuthSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserAuthSettingsEntity#equals(Object)}
   *   <li>{@link UserAuthSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(null);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(null);
    userAuthSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
    assertEquals(userAuthSettingsEntity.hashCode(), userAuthSettingsEntity2.hashCode());
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}, and {@link
   * UserAuthSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserAuthSettingsEntity#equals(Object)}
   *   <li>{@link UserAuthSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userAuthSettingsEntity, userAuthSettingsEntity);
    int expectedHashCodeResult = userAuthSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userAuthSettingsEntity.hashCode());
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(3L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(DoubleNode.valueOf(10.0d));
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(null);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(UUID.randomUUID());
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(null);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userAuthSettingsEntity, null);
  }

  /**
   * Test {@link UserAuthSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userAuthSettingsEntity, "Different type to UserAuthSettingsEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserAuthSettingsEntity#UserAuthSettingsEntity()}
   *   <li>{@link UserAuthSettingsEntity#setTwoFaSettings(JsonNode)}
   *   <li>{@link UserAuthSettingsEntity#setUserId(UUID)}
   *   <li>{@link UserAuthSettingsEntity#toString()}
   *   <li>{@link UserAuthSettingsEntity#getTwoFaSettings()}
   *   <li>{@link UserAuthSettingsEntity#getUserId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserAuthSettingsEntity.<init>()",
    "JsonNode UserAuthSettingsEntity.getTwoFaSettings()",
    "UUID UserAuthSettingsEntity.getUserId()",
    "void UserAuthSettingsEntity.setTwoFaSettings(JsonNode)",
    "void UserAuthSettingsEntity.setUserId(UUID)",
    "String UserAuthSettingsEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity = new UserAuthSettingsEntity();
    JsonNode twoFaSettings = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualUserAuthSettingsEntity.setTwoFaSettings(twoFaSettings);
    UUID userId = ModelConstants.NULL_UUID;
    actualUserAuthSettingsEntity.setUserId(userId);
    String actualToStringResult = actualUserAuthSettingsEntity.toString();
    JsonNode actualTwoFaSettings = actualUserAuthSettingsEntity.getTwoFaSettings();
    UUID actualUserId = actualUserAuthSettingsEntity.getUserId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualUserId.toString());
    assertEquals(
        "UserAuthSettingsEntity(userId=13814000-1dd2-11b2-8080-808080808080, twoFaSettings={\"isPublic\":true})",
        actualToStringResult);
    assertNull(actualUserAuthSettingsEntity.getId());
    assertNull(actualUserAuthSettingsEntity.getUuid());
    assertEquals(0L, actualUserAuthSettingsEntity.getCreatedTime());
    assertSame(twoFaSettings, actualTwoFaSettings);
    assertSame(userId, actualUserId);
  }

  /**
   * Test {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}.
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserAuthSettingsEntity.<init>(UserAuthSettings)"})
  public void testNewUserAuthSettingsEntity() {
    // Arrange
    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(ModelConstants.NULL_UUID));
    userAuthSettings.setUserId(null);
    userAuthSettings.setTwoFaSettings(null);

    // Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity =
        new UserAuthSettingsEntity(userAuthSettings);

    // Assert
    UUID id = actualUserAuthSettingsEntity.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertNull(actualUserAuthSettingsEntity.getTwoFaSettings());
    assertNull(actualUserAuthSettingsEntity.getUserId());
    assertEquals(1L, actualUserAuthSettingsEntity.getCreatedTime());
    assertSame(id, actualUserAuthSettingsEntity.getUuid());
  }

  /**
   * Test {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}.
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserAuthSettingsEntity.<init>(UserAuthSettings)"})
  public void testNewUserAuthSettingsEntity2() {
    // Arrange
    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    configs.put(TwoFaProviderType.TOTP, new BackupCodeTwoFaAccountConfig());

    AccountTwoFaSettings twoFaSettings = new AccountTwoFaSettings();
    twoFaSettings.setConfigs(configs);

    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(ModelConstants.NULL_UUID));
    userAuthSettings.setUserId(null);
    userAuthSettings.setTwoFaSettings(twoFaSettings);

    // Act and Assert
    JsonNode twoFaSettings2 = new UserAuthSettingsEntity(userAuthSettings).getTwoFaSettings();
    Iterator<JsonNode> iteratorResult = twoFaSettings2.iterator();
    JsonNode nextResult = iteratorResult.next();
    Iterator<JsonNode> iteratorResult2 = nextResult.iterator();
    assertTrue(iteratorResult2.next() instanceof ObjectNode);
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(twoFaSettings2 instanceof ObjectNode);
    assertEquals(1, nextResult.size());
    assertFalse(nextResult.isEmpty());
    assertFalse(iteratorResult2.hasNext());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}.
   *
   * <ul>
   *   <li>Given {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserAuthSettingsEntity.<init>(UserAuthSettings)"})
  public void testNewUserAuthSettingsEntity_givenUserIdWithIdIsNull_uuid() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = new AccountTwoFaSettings();
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(ModelConstants.NULL_UUID));
    userAuthSettings.setUserId(new UserId(ModelConstants.NULL_UUID));
    userAuthSettings.setTwoFaSettings(twoFaSettings);

    // Act and Assert
    JsonNode twoFaSettings2 = new UserAuthSettingsEntity(userAuthSettings).getTwoFaSettings();
    Iterator<JsonNode> iteratorResult = twoFaSettings2.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(twoFaSettings2 instanceof ObjectNode);
    assertEquals(0, nextResult.size());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isEmpty());
  }

  /**
   * Test {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then return CreatedTime is zero.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserAuthSettingsEntity.<init>(UserAuthSettings)"})
  public void testNewUserAuthSettingsEntity_givenZero_thenReturnCreatedTimeIsZero() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = new AccountTwoFaSettings();
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(0L);
    userAuthSettings.setId(new UserAuthSettingsId(ModelConstants.NULL_UUID));
    userAuthSettings.setUserId(null);
    userAuthSettings.setTwoFaSettings(twoFaSettings);

    // Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity =
        new UserAuthSettingsEntity(userAuthSettings);

    // Assert
    JsonNode twoFaSettings2 = actualUserAuthSettingsEntity.getTwoFaSettings();
    Iterator<JsonNode> iteratorResult = twoFaSettings2.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(twoFaSettings2 instanceof ObjectNode);
    assertEquals(0, nextResult.size());
    assertEquals(0L, actualUserAuthSettingsEntity.getCreatedTime());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isEmpty());
  }

  /**
   * Test {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}.
   *
   * <ul>
   *   <li>Then return UserId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserAuthSettingsEntity.<init>(UserAuthSettings)"})
  public void testNewUserAuthSettingsEntity_thenReturnUserIdIsNull() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = new AccountTwoFaSettings();
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(new UserAuthSettingsId(ModelConstants.NULL_UUID));
    userAuthSettings.setUserId(null);
    userAuthSettings.setTwoFaSettings(twoFaSettings);

    // Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity =
        new UserAuthSettingsEntity(userAuthSettings);

    // Assert
    assertTrue(actualUserAuthSettingsEntity.getTwoFaSettings() instanceof ObjectNode);
    assertNull(actualUserAuthSettingsEntity.getUserId());
    assertEquals(1L, actualUserAuthSettingsEntity.getCreatedTime());
  }

  /**
   * Test {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}.
   *
   * <ul>
   *   <li>When {@link UserAuthSettings} (default constructor) Id is {@code null}.
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserAuthSettingsEntity.<init>(UserAuthSettings)"})
  public void testNewUserAuthSettingsEntity_whenUserAuthSettingsIdIsNull_thenReturnIdIsNull() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = new AccountTwoFaSettings();
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(null);
    userAuthSettings.setUserId(null);
    userAuthSettings.setTwoFaSettings(twoFaSettings);

    // Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity =
        new UserAuthSettingsEntity(userAuthSettings);

    // Assert
    JsonNode twoFaSettings2 = actualUserAuthSettingsEntity.getTwoFaSettings();
    Iterator<JsonNode> iteratorResult = twoFaSettings2.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(twoFaSettings2 instanceof ObjectNode);
    assertNull(actualUserAuthSettingsEntity.getId());
    assertNull(actualUserAuthSettingsEntity.getUuid());
    assertEquals(0, nextResult.size());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isEmpty());
  }

  /**
   * Test {@link UserAuthSettingsEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link UserAuthSettingsEntity#UserAuthSettingsEntity()} TwoFaSettings is {@link
   *       BinaryNode#BinaryNode(byte[])} with data is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserAuthSettings UserAuthSettingsEntity.toData()"})
  public void testToData_givenUserAuthSettingsEntityTwoFaSettingsIsBinaryNodeWithDataIsNull() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setTwoFaSettings(new BinaryNode(null));

    // Act
    UserAuthSettings actualToDataResult = userAuthSettingsEntity.toData();

    // Assert
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getUserId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link UserAuthSettingsEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link UserAuthSettingsEntity#UserAuthSettingsEntity()} TwoFaSettings is Instance.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserAuthSettings UserAuthSettingsEntity.toData()"})
  public void testToData_givenUserAuthSettingsEntityTwoFaSettingsIsInstance() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setTwoFaSettings(NullNode.getInstance());

    // Act
    UserAuthSettings actualToDataResult = userAuthSettingsEntity.toData();

    // Assert
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getUserId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link UserAuthSettingsEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link UserAuthSettingsEntity#UserAuthSettingsEntity()}.
   *   <li>Then return UuidId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserAuthSettings UserAuthSettingsEntity.toData()"})
  public void testToData_givenUserAuthSettingsEntity_thenReturnUuidIdIsNull() {
    // Arrange and Act
    UserAuthSettings actualToDataResult = new UserAuthSettingsEntity().toData();

    // Assert
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getUserId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link UserAuthSettingsEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TwoFaSettings is {@link AccountTwoFaSettings} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserAuthSettings UserAuthSettingsEntity.toData()"})
  public void testToData_thenReturnTwoFaSettingsIsAccountTwoFaSettings() {
    // Arrange
    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(new LinkedHashMap<>());
    POJONode twoFaSettings = new POJONode(accountTwoFaSettings);

    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(twoFaSettings);

    // Act and Assert
    assertSame(accountTwoFaSettings, userAuthSettingsEntity.toData().getTwoFaSettings());
  }

  /**
   * Test {@link UserAuthSettingsEntity#toData()}.
   *
   * <ul>
   *   <li>Then return UuidId toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserAuthSettings UserAuthSettingsEntity.toData()"})
  public void testToData_thenReturnUuidIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setTwoFaSettings(new POJONode(null));

    // Act
    UserAuthSettings actualToDataResult = userAuthSettingsEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    UserId userId = actualToDataResult.getUserId();
    assertEquals(EntityType.USER, userId.getEntityType());
    assertTrue(userId.isNullUid());
    assertSame(uuidId, actualToDataResult.getId().getId());
    assertSame(uuidId, userId.getId());
  }
}
