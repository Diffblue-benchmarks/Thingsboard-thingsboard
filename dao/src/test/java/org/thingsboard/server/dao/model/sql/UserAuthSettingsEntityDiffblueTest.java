package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
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

class UserAuthSettingsEntityDiffblueTest {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity2.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
    int expectedHashCodeResult = userAuthSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userAuthSettingsEntity2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setTwoFaSettings(null);
    userAuthSettingsEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity2.setTwoFaSettings(null);
    userAuthSettingsEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
    int expectedHashCodeResult = userAuthSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userAuthSettingsEntity2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(null);
    userAuthSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity2.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(null);
    userAuthSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(userAuthSettingsEntity, userAuthSettingsEntity2);
    int expectedHashCodeResult = userAuthSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userAuthSettingsEntity2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(3L);
    userAuthSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity2.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setTwoFaSettings(DoubleNode.valueOf(10.0d));
    userAuthSettingsEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity2.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setTwoFaSettings(null);
    userAuthSettingsEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity2.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(ModelConstants.NULL_UUID);
    userAuthSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity2.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(null);
    userAuthSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    UserAuthSettingsEntity userAuthSettingsEntity2 = new UserAuthSettingsEntity();
    userAuthSettingsEntity2.setCreatedTime(1L);
    userAuthSettingsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity2.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserAuthSettingsEntity.equals(Object)",
    "int UserAuthSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setTwoFaSettings(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userAuthSettingsEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void UserAuthSettingsEntity.<init>()",
    "JsonNode UserAuthSettingsEntity.getTwoFaSettings()",
    "UUID UserAuthSettingsEntity.getUserId()",
    "void UserAuthSettingsEntity.setTwoFaSettings(JsonNode)",
    "void UserAuthSettingsEntity.setUserId(UUID)",
    "String UserAuthSettingsEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity = new UserAuthSettingsEntity();
    JsonNode twoFaSettings = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualUserAuthSettingsEntity.setTwoFaSettings(twoFaSettings);
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualUserAuthSettingsEntity.setUserId(userId);
    String actualToStringResult = actualUserAuthSettingsEntity.toString();
    JsonNode actualTwoFaSettings = actualUserAuthSettingsEntity.getTwoFaSettings();
    UUID actualUserId = actualUserAuthSettingsEntity.getUserId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualUserId.toString());
    assertEquals(
        "UserAuthSettingsEntity(userId=784f394c-42b6-435a-983c-b7beff2784f9, twoFaSettings={\"isPublic\":true})",
        actualToStringResult);
    assertNull(actualUserAuthSettingsEntity.getId());
    assertNull(actualUserAuthSettingsEntity.getUuid());
    assertEquals(0L, actualUserAuthSettingsEntity.getCreatedTime());
    assertSame(userId, actualUserId);
    assertSame(twoFaSettings, actualTwoFaSettings);
  }

  /**
   * Test {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}.
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}
   */
  @Test
  @DisplayName("Test new UserAuthSettingsEntity(UserAuthSettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserAuthSettingsEntity.<init>(UserAuthSettings)"})
  void testNewUserAuthSettingsEntity() {
    // Arrange
    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    userAuthSettings.setId(new UserAuthSettingsId(id));
    userAuthSettings.setUserId(null);
    userAuthSettings.setTwoFaSettings(null);

    // Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity =
        new UserAuthSettingsEntity(userAuthSettings);

    // Assert
    UUID id2 = actualUserAuthSettingsEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertSame(id, id2);
    assertSame(id, actualUserAuthSettingsEntity.getUuid());
  }

  /**
   * Test {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}.
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}
   */
  @Test
  @DisplayName("Test new UserAuthSettingsEntity(UserAuthSettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserAuthSettingsEntity.<init>(UserAuthSettings)"})
  void testNewUserAuthSettingsEntity2() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = new AccountTwoFaSettings();
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(
        new UserAuthSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    userAuthSettings.setUserId(new UserId(id));

    // Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity =
        new UserAuthSettingsEntity(userAuthSettings);

    // Assert
    JsonNode twoFaSettings2 = actualUserAuthSettingsEntity.getTwoFaSettings();
    Iterator<JsonNode> iteratorResult = twoFaSettings2.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(twoFaSettings2 instanceof ObjectNode);
    UUID userId = actualUserAuthSettingsEntity.getUserId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", userId.toString());
    assertEquals("{ }", nextResult.toPrettyString());
    assertEquals("{\r\n  \"configs\" : { }\r\n}", twoFaSettings2.toPrettyString());
    assertEquals(0, nextResult.size());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isEmpty());
    assertSame(id, userId);
  }

  /**
   * Test {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}.
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}
   */
  @Test
  @DisplayName("Test new UserAuthSettingsEntity(UserAuthSettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserAuthSettingsEntity.<init>(UserAuthSettings)"})
  void testNewUserAuthSettingsEntity3() {
    // Arrange
    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    configs.put(TwoFaProviderType.SMS, new BackupCodeTwoFaAccountConfig());

    AccountTwoFaSettings twoFaSettings = new AccountTwoFaSettings();
    twoFaSettings.setConfigs(configs);

    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(
        new UserAuthSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    JsonNode twoFaSettings2 = new UserAuthSettingsEntity(userAuthSettings).getTwoFaSettings();
    Iterator<JsonNode> iteratorResult = twoFaSettings2.iterator();
    JsonNode nextResult = iteratorResult.next();
    Iterator<JsonNode> iteratorResult2 = nextResult.iterator();
    assertTrue(iteratorResult2.next() instanceof ObjectNode);
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(twoFaSettings2 instanceof ObjectNode);
    assertEquals(
        "{\r\n"
            + "  \"SMS\" : {\r\n"
            + "    \"providerType\" : \"BACKUP_CODE\",\r\n"
            + "    \"useByDefault\" : false,\r\n"
            + "    \"codes\" : null,\r\n"
            + "    \"codesLeft\" : null\r\n"
            + "  }\r\n"
            + "}",
        nextResult.toPrettyString());
    assertEquals(
        "{\r\n"
            + "  \"configs\" : {\r\n"
            + "    \"SMS\" : {\r\n"
            + "      \"providerType\" : \"BACKUP_CODE\",\r\n"
            + "      \"useByDefault\" : false,\r\n"
            + "      \"codes\" : null,\r\n"
            + "      \"codesLeft\" : null\r\n"
            + "    }\r\n"
            + "  }\r\n"
            + "}",
        twoFaSettings2.toPrettyString());
    assertEquals(1, nextResult.size());
    assertFalse(nextResult.isEmpty());
    assertFalse(iteratorResult2.hasNext());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return UserId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}
   */
  @Test
  @DisplayName(
      "Test new UserAuthSettingsEntity(UserAuthSettings); given 'null'; then return UserId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserAuthSettingsEntity.<init>(UserAuthSettings)"})
  void testNewUserAuthSettingsEntity_givenNull_thenReturnUserIdIsNull() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = new AccountTwoFaSettings();
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(
        new UserAuthSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
    assertEquals("{ }", nextResult.toPrettyString());
    assertEquals("{\r\n  \"configs\" : { }\r\n}", twoFaSettings2.toPrettyString());
    assertNull(actualUserAuthSettingsEntity.getUserId());
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
  @DisplayName(
      "Test new UserAuthSettingsEntity(UserAuthSettings); given zero; then return CreatedTime is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserAuthSettingsEntity.<init>(UserAuthSettings)"})
  void testNewUserAuthSettingsEntity_givenZero_thenReturnCreatedTimeIsZero() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = new AccountTwoFaSettings();
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(0L);
    userAuthSettings.setId(
        new UserAuthSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    userAuthSettings.setUserId(new UserId(id));

    // Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity =
        new UserAuthSettingsEntity(userAuthSettings);

    // Assert
    JsonNode twoFaSettings2 = actualUserAuthSettingsEntity.getTwoFaSettings();
    Iterator<JsonNode> iteratorResult = twoFaSettings2.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(twoFaSettings2 instanceof ObjectNode);
    UUID userId = actualUserAuthSettingsEntity.getUserId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", userId.toString());
    assertEquals("{ }", nextResult.toPrettyString());
    assertEquals("{\r\n  \"configs\" : { }\r\n}", twoFaSettings2.toPrettyString());
    assertEquals(0, nextResult.size());
    assertEquals(0L, actualUserAuthSettingsEntity.getCreatedTime());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isEmpty());
    assertSame(id, userId);
  }

  /**
   * Test {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}.
   *
   * <ul>
   *   <li>Then return TwoFaSettings is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#UserAuthSettingsEntity(UserAuthSettings)}
   */
  @Test
  @DisplayName(
      "Test new UserAuthSettingsEntity(UserAuthSettings); then return TwoFaSettings is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserAuthSettingsEntity.<init>(UserAuthSettings)"})
  void testNewUserAuthSettingsEntity_thenReturnTwoFaSettingsIsNull() {
    // Arrange
    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(null);
    userAuthSettings.setUserId(null);
    userAuthSettings.setTwoFaSettings(null);

    // Act
    UserAuthSettingsEntity actualUserAuthSettingsEntity =
        new UserAuthSettingsEntity(userAuthSettings);

    // Assert
    assertNull(actualUserAuthSettingsEntity.getTwoFaSettings());
    assertNull(actualUserAuthSettingsEntity.getId());
    assertNull(actualUserAuthSettingsEntity.getUuid());
    assertNull(actualUserAuthSettingsEntity.getUserId());
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
  @DisplayName(
      "Test new UserAuthSettingsEntity(UserAuthSettings); when UserAuthSettings (default constructor) Id is 'null'; then return Id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserAuthSettingsEntity.<init>(UserAuthSettings)"})
  void testNewUserAuthSettingsEntity_whenUserAuthSettingsIdIsNull_thenReturnIdIsNull() {
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
    assertEquals("{ }", nextResult.toPrettyString());
    assertEquals("{\r\n  \"configs\" : { }\r\n}", twoFaSettings2.toPrettyString());
    assertNull(actualUserAuthSettingsEntity.getId());
    assertNull(actualUserAuthSettingsEntity.getUuid());
    assertNull(actualUserAuthSettingsEntity.getUserId());
    assertEquals(0, nextResult.size());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isEmpty());
  }

  /**
   * Test {@link UserAuthSettingsEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link UserAuthSettings} (default constructor) CreatedTime is one.
   *   <li>Then return {@link UserAuthSettings} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given UserAuthSettings (default constructor) CreatedTime is one; then return UserAuthSettings (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UserAuthSettings UserAuthSettingsEntity.toData()"})
  void testToData_givenUserAuthSettingsCreatedTimeIsOne_thenReturnUserAuthSettings() {
    // Arrange
    AccountTwoFaSettings twoFaSettings = new AccountTwoFaSettings();
    twoFaSettings.setConfigs(new LinkedHashMap<>());

    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(
        new UserAuthSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);

    // Act and Assert
    assertEquals(userAuthSettings, new UserAuthSettingsEntity(userAuthSettings).toData());
  }

  /**
   * Test {@link UserAuthSettingsEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link UserAuthSettingsEntity#UserAuthSettingsEntity()} TwoFaSettings is {@link
   *       POJONode#POJONode(Object)} with v is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given UserAuthSettingsEntity() TwoFaSettings is POJONode(Object) with v is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UserAuthSettings UserAuthSettingsEntity.toData()"})
  void testToData_givenUserAuthSettingsEntityTwoFaSettingsIsPOJONodeWithVIsNull() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    userAuthSettingsEntity.setUuid(id);
    userAuthSettingsEntity.setUserId(null);
    userAuthSettingsEntity.setTwoFaSettings(new POJONode(null));

    // Act
    UserAuthSettings actualToDataResult = userAuthSettingsEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertNull(actualToDataResult.getUserId());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertSame(id, uuidId);
    assertSame(id, actualToDataResult.getId().getId());
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
  @DisplayName("Test toData(); given UserAuthSettingsEntity(); then return UuidId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UserAuthSettings UserAuthSettingsEntity.toData()"})
  void testToData_givenUserAuthSettingsEntity_thenReturnUuidIdIsNull() {
    // Arrange and Act
    UserAuthSettings actualToDataResult = new UserAuthSettingsEntity().toData();

    // Assert
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getTwoFaSettings());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link UserAuthSettingsEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TwoFaSettings Configs size is one.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return TwoFaSettings Configs size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UserAuthSettings UserAuthSettingsEntity.toData()"})
  void testToData_thenReturnTwoFaSettingsConfigsSizeIsOne() {
    // Arrange
    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = new BackupCodeTwoFaAccountConfig();
    configs.put(TwoFaProviderType.SMS, backupCodeTwoFaAccountConfig);

    AccountTwoFaSettings twoFaSettings = new AccountTwoFaSettings();
    twoFaSettings.setConfigs(configs);

    UserAuthSettings userAuthSettings = new UserAuthSettings();
    userAuthSettings.setCreatedTime(1L);
    userAuthSettings.setId(
        new UserAuthSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    userAuthSettings.setTwoFaSettings(twoFaSettings);
    userAuthSettings.setUserId(null);

    // Act and Assert
    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs2 =
        new UserAuthSettingsEntity(userAuthSettings).toData().getTwoFaSettings().getConfigs();
    assertEquals(1, configs2.size());
    TwoFaAccountConfig getResult = configs2.get(TwoFaProviderType.SMS);
    assertTrue(getResult instanceof BackupCodeTwoFaAccountConfig);
    assertEquals(backupCodeTwoFaAccountConfig, getResult);
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
  @DisplayName(
      "Test toData(); then return TwoFaSettings is AccountTwoFaSettings (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UserAuthSettings UserAuthSettingsEntity.toData()"})
  void testToData_thenReturnTwoFaSettingsIsAccountTwoFaSettings() {
    // Arrange
    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(new LinkedHashMap<>());
    POJONode twoFaSettings = new POJONode(accountTwoFaSettings);

    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setUserId(null);
    userAuthSettingsEntity.setTwoFaSettings(twoFaSettings);

    // Act and Assert
    assertSame(accountTwoFaSettings, userAuthSettingsEntity.toData().getTwoFaSettings());
  }

  /**
   * Test {@link UserAuthSettingsEntity#toData()}.
   *
   * <ul>
   *   <li>Then return UserId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return UserId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UserAuthSettings UserAuthSettingsEntity.toData()"})
  void testToData_thenReturnUserIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userAuthSettingsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    userAuthSettingsEntity.setUserId(userId);
    userAuthSettingsEntity.setTwoFaSettings(null);

    // Act and Assert
    UserId userId2 = userAuthSettingsEntity.toData().getUserId();
    UUID id = userId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.USER, userId2.getEntityType());
    assertFalse(userId2.isNullUid());
    assertSame(userId, id);
  }

  /**
   * Test {@link UserAuthSettingsEntity#toData()}.
   *
   * <ul>
   *   <li>Then return UuidId toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link UserAuthSettingsEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return UuidId toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UserAuthSettings UserAuthSettingsEntity.toData()"})
  void testToData_thenReturnUuidIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    UserAuthSettingsEntity userAuthSettingsEntity = new UserAuthSettingsEntity();
    userAuthSettingsEntity.setCreatedTime(1L);
    userAuthSettingsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    userAuthSettingsEntity.setUuid(id);
    userAuthSettingsEntity.setUserId(null);
    userAuthSettingsEntity.setTwoFaSettings(NullNode.getInstance());

    // Act
    UserAuthSettings actualToDataResult = userAuthSettingsEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertNull(actualToDataResult.getUserId());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertSame(id, uuidId);
    assertSame(id, actualToDataResult.getId().getId());
  }
}
