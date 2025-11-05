package org.thingsboard.server.common.data.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.UserId;

class UserSettingsCompositeKeyDiffblueTest {
  /**
   * Test {@link UserSettingsCompositeKey#equals(Object)}, and {@link
   * UserSettingsCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSettingsCompositeKey#equals(Object)}
   *   <li>{@link UserSettingsCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsCompositeKey.equals(Object)",
    "int UserSettingsCompositeKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey();
    UserSettingsCompositeKey userSettingsCompositeKey2 = new UserSettingsCompositeKey();

    // Act and Assert
    assertEquals(userSettingsCompositeKey, userSettingsCompositeKey2);
    assertEquals(userSettingsCompositeKey.hashCode(), userSettingsCompositeKey2.hashCode());
  }

  /**
   * Test {@link UserSettingsCompositeKey#equals(Object)}, and {@link
   * UserSettingsCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSettingsCompositeKey#equals(Object)}
   *   <li>{@link UserSettingsCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsCompositeKey.equals(Object)",
    "int UserSettingsCompositeKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey =
        new UserSettingsCompositeKey(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Type");
    UserSettingsCompositeKey userSettingsCompositeKey2 =
        new UserSettingsCompositeKey(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Type");

    // Act and Assert
    assertEquals(userSettingsCompositeKey, userSettingsCompositeKey2);
    assertEquals(userSettingsCompositeKey.hashCode(), userSettingsCompositeKey2.hashCode());
  }

  /**
   * Test {@link UserSettingsCompositeKey#equals(Object)}, and {@link
   * UserSettingsCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSettingsCompositeKey#equals(Object)}
   *   <li>{@link UserSettingsCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsCompositeKey.equals(Object)",
    "int UserSettingsCompositeKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey();

    // Act and Assert
    assertEquals(userSettingsCompositeKey, userSettingsCompositeKey);
    int expectedHashCodeResult = userSettingsCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsCompositeKey.hashCode());
  }

  /**
   * Test {@link UserSettingsCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsCompositeKey.equals(Object)",
    "int UserSettingsCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey =
        new UserSettingsCompositeKey(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Type");

    // Act and Assert
    assertNotEquals(userSettingsCompositeKey, new UserSettingsCompositeKey());
  }

  /**
   * Test {@link UserSettingsCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsCompositeKey.equals(Object)",
    "int UserSettingsCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey();

    // Act and Assert
    assertNotEquals(
        userSettingsCompositeKey,
        new UserSettingsCompositeKey(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Type"));
  }

  /**
   * Test {@link UserSettingsCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsCompositeKey.equals(Object)",
    "int UserSettingsCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey();
    userSettingsCompositeKey.setType("Type");

    // Act and Assert
    assertNotEquals(userSettingsCompositeKey, new UserSettingsCompositeKey());
  }

  /**
   * Test {@link UserSettingsCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsCompositeKey.equals(Object)",
    "int UserSettingsCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey();

    UserSettingsCompositeKey userSettingsCompositeKey2 = new UserSettingsCompositeKey();
    userSettingsCompositeKey2.setType("Type");

    // Act and Assert
    assertNotEquals(userSettingsCompositeKey, userSettingsCompositeKey2);
  }

  /**
   * Test {@link UserSettingsCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsCompositeKey.equals(Object)",
    "int UserSettingsCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserSettingsCompositeKey(), null);
  }

  /**
   * Test {@link UserSettingsCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean UserSettingsCompositeKey.equals(Object)",
    "int UserSettingsCompositeKey.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserSettingsCompositeKey(), "Different type to UserSettingsCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSettingsCompositeKey#UserSettingsCompositeKey()}
   *   <li>{@link UserSettingsCompositeKey#setType(String)}
   *   <li>{@link UserSettingsCompositeKey#setUserId(UUID)}
   *   <li>{@link UserSettingsCompositeKey#toString()}
   *   <li>{@link UserSettingsCompositeKey#getType()}
   *   <li>{@link UserSettingsCompositeKey#getUserId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserSettingsCompositeKey.<init>()",
    "void UserSettingsCompositeKey.<init>(UUID, String)",
    "String UserSettingsCompositeKey.getType()",
    "UUID UserSettingsCompositeKey.getUserId()",
    "void UserSettingsCompositeKey.setType(String)",
    "void UserSettingsCompositeKey.setUserId(UUID)",
    "String UserSettingsCompositeKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    UserSettingsCompositeKey actualUserSettingsCompositeKey = new UserSettingsCompositeKey();
    actualUserSettingsCompositeKey.setType("Type");
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualUserSettingsCompositeKey.setUserId(userId);
    String actualToStringResult = actualUserSettingsCompositeKey.toString();
    String actualType = actualUserSettingsCompositeKey.getType();
    UUID actualUserId = actualUserSettingsCompositeKey.getUserId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualUserId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9_Type", actualToStringResult);
    assertEquals("Type", actualType);
    assertSame(userId, actualUserId);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserSettingsCompositeKey#UserSettingsCompositeKey(UUID, String)}
   *   <li>{@link UserSettingsCompositeKey#setType(String)}
   *   <li>{@link UserSettingsCompositeKey#setUserId(UUID)}
   *   <li>{@link UserSettingsCompositeKey#toString()}
   *   <li>{@link UserSettingsCompositeKey#getType()}
   *   <li>{@link UserSettingsCompositeKey#getUserId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserSettingsCompositeKey.<init>()",
    "void UserSettingsCompositeKey.<init>(UUID, String)",
    "String UserSettingsCompositeKey.getType()",
    "UUID UserSettingsCompositeKey.getUserId()",
    "void UserSettingsCompositeKey.setType(String)",
    "void UserSettingsCompositeKey.setUserId(UUID)",
    "String UserSettingsCompositeKey.toString()"
  })
  void testGettersAndSetters_whenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange and Act
    UserSettingsCompositeKey actualUserSettingsCompositeKey =
        new UserSettingsCompositeKey(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Type");
    actualUserSettingsCompositeKey.setType("Type");
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualUserSettingsCompositeKey.setUserId(userId);
    String actualToStringResult = actualUserSettingsCompositeKey.toString();
    String actualType = actualUserSettingsCompositeKey.getType();
    UUID actualUserId = actualUserSettingsCompositeKey.getUserId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualUserId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9_Type", actualToStringResult);
    assertEquals("Type", actualType);
    assertSame(userId, actualUserId);
  }

  /**
   * Test {@link UserSettingsCompositeKey#UserSettingsCompositeKey(UserSettings)}.
   *
   * <p>Method under test: {@link UserSettingsCompositeKey#UserSettingsCompositeKey(UserSettings)}
   */
  @Test
  @DisplayName("Test new UserSettingsCompositeKey(UserSettings)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserSettingsCompositeKey.<init>(UserSettings)"})
  void testNewUserSettingsCompositeKey() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    userSettings.setUserId(new UserId(id));

    // Act
    UserSettingsCompositeKey actualUserSettingsCompositeKey =
        new UserSettingsCompositeKey(userSettings);

    // Assert
    UUID userId = actualUserSettingsCompositeKey.getUserId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", userId.toString());
    assertEquals("GENERAL", actualUserSettingsCompositeKey.getType());
    assertSame(id, userId);
  }
}
