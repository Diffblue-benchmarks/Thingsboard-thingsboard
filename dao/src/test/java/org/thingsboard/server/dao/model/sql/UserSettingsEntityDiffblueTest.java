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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.settings.UserSettings;
import org.thingsboard.server.common.data.settings.UserSettingsType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class UserSettingsEntityDiffblueTest {
  /**
   * Test {@link UserSettingsEntity#equals(Object)}, and {@link UserSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSettingsEntity#equals(Object)}
   *   <li>{@link UserSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userSettingsEntity, userSettingsEntity2);
    assertEquals(userSettingsEntity.hashCode(), userSettingsEntity2.hashCode());
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}, and {@link UserSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSettingsEntity#equals(Object)}
   *   <li>{@link UserSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(null);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(null);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userSettingsEntity, userSettingsEntity2);
    assertEquals(userSettingsEntity.hashCode(), userSettingsEntity2.hashCode());
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}, and {@link UserSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSettingsEntity#equals(Object)}
   *   <li>{@link UserSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType(null);
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType(null);
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userSettingsEntity, userSettingsEntity2);
    assertEquals(userSettingsEntity.hashCode(), userSettingsEntity2.hashCode());
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}, and {@link UserSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSettingsEntity#equals(Object)}
   *   <li>{@link UserSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(null);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(null);

    // Act and Assert
    assertEquals(userSettingsEntity, userSettingsEntity2);
    assertEquals(userSettingsEntity.hashCode(), userSettingsEntity2.hashCode());
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}, and {@link UserSettingsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSettingsEntity#equals(Object)}
   *   <li>{@link UserSettingsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(userSettingsEntity, userSettingsEntity);
    int expectedHashCodeResult = userSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsEntity.hashCode());
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(DoubleNode.valueOf(10.0d));
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userSettingsEntity, userSettingsEntity2);
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(null);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userSettingsEntity, userSettingsEntity2);
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType(null);
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userSettingsEntity, userSettingsEntity2);
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("org.thingsboard.server.dao.model.sql.UserSettingsEntity");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userSettingsEntity, userSettingsEntity2);
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(UUID.randomUUID());

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userSettingsEntity, userSettingsEntity2);
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(null);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userSettingsEntity, userSettingsEntity2);
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userSettingsEntity, null);
  }

  /**
   * Test {@link UserSettingsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(userSettingsEntity, "Different type to UserSettingsEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSettingsEntity#UserSettingsEntity()}
   *   <li>{@link UserSettingsEntity#setSettings(JsonNode)}
   *   <li>{@link UserSettingsEntity#setType(String)}
   *   <li>{@link UserSettingsEntity#setUserId(UUID)}
   *   <li>{@link UserSettingsEntity#toString()}
   *   <li>{@link UserSettingsEntity#getSettings()}
   *   <li>{@link UserSettingsEntity#getType()}
   *   <li>{@link UserSettingsEntity#getUserId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserSettingsEntity.<init>()",
    "JsonNode UserSettingsEntity.getSettings()",
    "String UserSettingsEntity.getType()",
    "UUID UserSettingsEntity.getUserId()",
    "void UserSettingsEntity.setSettings(JsonNode)",
    "void UserSettingsEntity.setType(String)",
    "void UserSettingsEntity.setUserId(UUID)",
    "String UserSettingsEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    UserSettingsEntity actualUserSettingsEntity = new UserSettingsEntity();
    JsonNode settings = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualUserSettingsEntity.setSettings(settings);
    actualUserSettingsEntity.setType("Type");
    UUID userId = ModelConstants.NULL_UUID;
    actualUserSettingsEntity.setUserId(userId);
    String actualToStringResult = actualUserSettingsEntity.toString();
    JsonNode actualSettings = actualUserSettingsEntity.getSettings();
    String actualType = actualUserSettingsEntity.getType();
    UUID actualUserId = actualUserSettingsEntity.getUserId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualUserId.toString());
    assertEquals("Type", actualType);
    assertEquals(
        "UserSettingsEntity(userId=13814000-1dd2-11b2-8080-808080808080, type=Type, settings={\"isPublic"
            + "\":true})",
        actualToStringResult);
    assertSame(settings, actualSettings);
    assertSame(userId, actualUserId);
  }

  /**
   * Test {@link UserSettingsEntity#UserSettingsEntity(UserSettings)}.
   *
   * <p>Method under test: {@link UserSettingsEntity#UserSettingsEntity(UserSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserSettingsEntity.<init>(UserSettings)"})
  public void testNewUserSettingsEntity() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(new UserId(ModelConstants.NULL_UUID));

    // Act
    UserSettingsEntity actualUserSettingsEntity = new UserSettingsEntity(userSettings);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualUserSettingsEntity.getUserId().toString());
    assertEquals("GENERAL", actualUserSettingsEntity.getType());
    assertNull(actualUserSettingsEntity.getSettings());
  }

  /**
   * Test {@link UserSettingsEntity#UserSettingsEntity(UserSettings)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   *   <li>Then Settings return {@link MissingNode}.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsEntity#UserSettingsEntity(UserSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserSettingsEntity.<init>(UserSettings)"})
  public void testNewUserSettingsEntity_givenEmptyArrayOfByte_thenSettingsReturnMissingNode() {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes(new byte[] {});
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertTrue(new UserSettingsEntity(userSettings).getSettings() instanceof MissingNode);
  }

  /**
   * Test {@link UserSettingsEntity#UserSettingsEntity(UserSettings)}.
   *
   * <ul>
   *   <li>When {@link UserSettings} (default constructor) SettingsBytes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsEntity#UserSettingsEntity(UserSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserSettingsEntity.<init>(UserSettings)"})
  public void testNewUserSettingsEntity_whenUserSettingsSettingsBytesIsNull() {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes(null);
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(new UserId(ModelConstants.NULL_UUID));

    // Act
    UserSettingsEntity actualUserSettingsEntity = new UserSettingsEntity(userSettings);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualUserSettingsEntity.getUserId().toString());
    assertEquals("GENERAL", actualUserSettingsEntity.getType());
    assertNull(actualUserSettingsEntity.getSettings());
  }
}
