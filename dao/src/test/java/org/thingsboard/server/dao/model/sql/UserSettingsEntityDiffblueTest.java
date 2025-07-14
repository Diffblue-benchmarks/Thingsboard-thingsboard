package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.settings.UserSettings;
import org.thingsboard.server.common.data.settings.UserSettingsType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

class UserSettingsEntityDiffblueTest {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(userSettingsEntity, userSettingsEntity2);
    int expectedHashCodeResult = userSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsEntity2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(null);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(null);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(userSettingsEntity, userSettingsEntity2);
    int expectedHashCodeResult = userSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsEntity2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType(null);
    userSettingsEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType(null);
    userSettingsEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(userSettingsEntity, userSettingsEntity2);
    int expectedHashCodeResult = userSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsEntity2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
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
    int expectedHashCodeResult = userSettingsEntity.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsEntity2.hashCode());
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(DoubleNode.valueOf(10.0d));
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(null);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType(null);
    userSettingsEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("org.thingsboard.server.dao.model.sql.UserSettingsEntity");
    userSettingsEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(ModelConstants.NULL_UUID);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(null);

    UserSettingsEntity userSettingsEntity2 = new UserSettingsEntity();
    userSettingsEntity2.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity2.setType("Type");
    userSettingsEntity2.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean UserSettingsEntity.equals(Object)",
    "int UserSettingsEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UserSettingsEntity userSettingsEntity = new UserSettingsEntity();
    userSettingsEntity.setSettings(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userSettingsEntity.setType("Type");
    userSettingsEntity.setUserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
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
  void testGettersAndSetters() {
    // Arrange and Act
    UserSettingsEntity actualUserSettingsEntity = new UserSettingsEntity();
    JsonNode settings = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualUserSettingsEntity.setSettings(settings);
    actualUserSettingsEntity.setType("Type");
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualUserSettingsEntity.setUserId(userId);
    String actualToStringResult = actualUserSettingsEntity.toString();
    JsonNode actualSettings = actualUserSettingsEntity.getSettings();
    String actualType = actualUserSettingsEntity.getType();
    UUID actualUserId = actualUserSettingsEntity.getUserId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualUserId.toString());
    assertEquals("Type", actualType);
    assertEquals(
        "UserSettingsEntity(userId=784f394c-42b6-435a-983c-b7beff2784f9, type=Type, settings={\"isPublic"
            + "\":true})",
        actualToStringResult);
    assertSame(userId, actualUserId);
    assertSame(settings, actualSettings);
  }

  /**
   * Test {@link UserSettingsEntity#UserSettingsEntity(UserSettings)}.
   *
   * <p>Method under test: {@link UserSettingsEntity#UserSettingsEntity(UserSettings)}
   */
  @Test
  @DisplayName("Test new UserSettingsEntity(UserSettings)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserSettingsEntity.<init>(UserSettings)"})
  void testNewUserSettingsEntity() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    userSettings.setUserId(new UserId(id));

    // Act
    UserSettingsEntity actualUserSettingsEntity = new UserSettingsEntity(userSettings);

    // Assert
    UUID userId = actualUserSettingsEntity.getUserId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", userId.toString());
    assertEquals("GENERAL", actualUserSettingsEntity.getType());
    assertNull(actualUserSettingsEntity.getSettings());
    assertSame(id, userId);
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
  @DisplayName(
      "Test new UserSettingsEntity(UserSettings); given empty array of byte; then Settings return MissingNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserSettingsEntity.<init>(UserSettings)"})
  void testNewUserSettingsEntity_givenEmptyArrayOfByte_thenSettingsReturnMissingNode() {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes(new byte[] {});
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

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
  @DisplayName(
      "Test new UserSettingsEntity(UserSettings); when UserSettings (default constructor) SettingsBytes is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void UserSettingsEntity.<init>(UserSettings)"})
  void testNewUserSettingsEntity_whenUserSettingsSettingsBytesIsNull() {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes(null);
    userSettings.setType(UserSettingsType.GENERAL);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    userSettings.setUserId(new UserId(id));

    // Act
    UserSettingsEntity actualUserSettingsEntity = new UserSettingsEntity(userSettings);

    // Assert
    UUID userId = actualUserSettingsEntity.getUserId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", userId.toString());
    assertEquals("GENERAL", actualUserSettingsEntity.getType());
    assertNull(actualUserSettingsEntity.getSettings());
    assertSame(id, userId);
  }

  /**
   * Test {@link UserSettingsEntity#toData()}.
   *
   * <ul>
   *   <li>Then return SettingsBytes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then return SettingsBytes is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UserSettings UserSettingsEntity.toData()"})
  void testToData_thenReturnSettingsBytesIsNull() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    UserId userId = new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    userSettings.setUserId(userId);

    // Act
    UserSettings actualToDataResult = new UserSettingsEntity(userSettings).toData();

    // Assert
    assertNull(actualToDataResult.getSettingsBytes());
    assertNull(actualToDataResult.getSettings());
    assertEquals(UserSettingsType.GENERAL, actualToDataResult.getType());
    assertEquals(userId, actualToDataResult.getUserId());
  }

  /**
   * Test {@link UserSettingsEntity#toData()}.
   *
   * <ul>
   *   <li>Then Settings return {@link MissingNode}.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); then Settings return MissingNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UserSettings UserSettingsEntity.toData()"})
  void testToData_thenSettingsReturnMissingNode() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes(new byte[] {});
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    UserSettings actualToDataResult = new UserSettingsEntity(userSettings).toData();

    // Assert
    assertTrue(actualToDataResult.getSettings() instanceof MissingNode);
    byte[] expectedSettingsBytes = "null".getBytes("UTF-8");
    assertArrayEquals(expectedSettingsBytes, actualToDataResult.getSettingsBytes());
  }
}
