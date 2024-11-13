package org.thingsboard.server.common.data.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.UserId;

class UserSettingsCompositeKeyDiffblueTest {
  /**
   * Test {@link UserSettingsCompositeKey#equals(Object)}, and
   * {@link UserSettingsCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserSettingsCompositeKey#equals(Object)}
   *   <li>{@link UserSettingsCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey();
    UserSettingsCompositeKey userSettingsCompositeKey2 = new UserSettingsCompositeKey();

    // Act and Assert
    assertEquals(userSettingsCompositeKey, userSettingsCompositeKey2);
    int expectedHashCodeResult = userSettingsCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsCompositeKey2.hashCode());
  }

  /**
   * Test {@link UserSettingsCompositeKey#equals(Object)}, and
   * {@link UserSettingsCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserSettingsCompositeKey#equals(Object)}
   *   <li>{@link UserSettingsCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey(EntityId.NULL_UUID, "Type");
    UserSettingsCompositeKey userSettingsCompositeKey2 = new UserSettingsCompositeKey(EntityId.NULL_UUID, "Type");

    // Act and Assert
    assertEquals(userSettingsCompositeKey, userSettingsCompositeKey2);
    int expectedHashCodeResult = userSettingsCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, userSettingsCompositeKey2.hashCode());
  }

  /**
   * Test {@link UserSettingsCompositeKey#equals(Object)}, and
   * {@link UserSettingsCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserSettingsCompositeKey#equals(Object)}
   *   <li>{@link UserSettingsCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey(EntityId.NULL_UUID, "Type");

    // Act and Assert
    assertNotEquals(userSettingsCompositeKey, new UserSettingsCompositeKey());
  }

  /**
   * Test {@link UserSettingsCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey();

    // Act and Assert
    assertNotEquals(userSettingsCompositeKey, new UserSettingsCompositeKey(EntityId.NULL_UUID, "Type"));
  }

  /**
   * Test {@link UserSettingsCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey();
    userSettingsCompositeKey.setType("Type");

    // Act and Assert
    assertNotEquals(userSettingsCompositeKey, new UserSettingsCompositeKey());
  }

  /**
   * Test {@link UserSettingsCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getType()).thenReturn(UserSettingsType.GENERAL);
    when(userSettings.getUserId()).thenReturn(new UserId(EntityId.NULL_UUID));
    UserSettingsCompositeKey userSettingsCompositeKey = new UserSettingsCompositeKey(userSettings);

    // Act and Assert
    assertNotEquals(userSettingsCompositeKey, new UserSettingsCompositeKey());
  }

  /**
   * Test {@link UserSettingsCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserSettingsCompositeKey(), null);
  }

  /**
   * Test {@link UserSettingsCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserSettingsCompositeKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserSettingsCompositeKey(), "Different type to UserSettingsCompositeKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange and Act
    UserSettingsCompositeKey actualUserSettingsCompositeKey = new UserSettingsCompositeKey();
    actualUserSettingsCompositeKey.setType("Type");
    UUID userId = EntityId.NULL_UUID;
    actualUserSettingsCompositeKey.setUserId(userId);
    String actualToStringResult = actualUserSettingsCompositeKey.toString();
    String actualType = actualUserSettingsCompositeKey.getType();
    UUID actualUserId = actualUserSettingsCompositeKey.getUserId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualUserId.toString());
    assertEquals("13814000-1dd2-11b2-8080-808080808080_Type", actualToStringResult);
    assertEquals("Type", actualType);
    assertSame(userId, actualUserId);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link EntityId#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Methods under test:
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
  @DisplayName("Test getters and setters; when NULL_UUID")
  void testGettersAndSetters_whenNull_uuid() {
    // Arrange and Act
    UserSettingsCompositeKey actualUserSettingsCompositeKey = new UserSettingsCompositeKey(EntityId.NULL_UUID, "Type");
    actualUserSettingsCompositeKey.setType("Type");
    UUID userId = EntityId.NULL_UUID;
    actualUserSettingsCompositeKey.setUserId(userId);
    String actualToStringResult = actualUserSettingsCompositeKey.toString();
    String actualType = actualUserSettingsCompositeKey.getType();
    UUID actualUserId = actualUserSettingsCompositeKey.getUserId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualUserId.toString());
    assertEquals("13814000-1dd2-11b2-8080-808080808080_Type", actualToStringResult);
    assertEquals("Type", actualType);
    assertSame(userId, actualUserId);
  }

  /**
   * Test {@link UserSettingsCompositeKey#UserSettingsCompositeKey(UserSettings)}.
   * <p>
   * Method under test:
   * {@link UserSettingsCompositeKey#UserSettingsCompositeKey(UserSettings)}
   */
  @Test
  @DisplayName("Test new UserSettingsCompositeKey(UserSettings)")
  void testNewUserSettingsCompositeKey() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(new UserId(EntityId.NULL_UUID));

    // Act
    UserSettingsCompositeKey actualUserSettingsCompositeKey = new UserSettingsCompositeKey(userSettings);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualUserSettingsCompositeKey.getUserId().toString());
    assertEquals("GENERAL", actualUserSettingsCompositeKey.getType());
  }
}
