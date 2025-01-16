package org.thingsboard.server.cache.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.TenantId;

class UserCacheKeyDiffblueTest {
  /**
   * Test {@link UserCacheKey#equals(Object)}, and
   * {@link UserCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserCacheKey#equals(Object)}
   *   <li>{@link UserCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserCacheKey userCacheKey = new UserCacheKey(new TenantId(null), "jane.doe@example.org");
    UserCacheKey userCacheKey2 = new UserCacheKey(new TenantId(null), "jane.doe@example.org");

    // Act and Assert
    assertEquals(userCacheKey, userCacheKey2);
    int expectedHashCodeResult = userCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, userCacheKey2.hashCode());
  }

  /**
   * Test {@link UserCacheKey#equals(Object)}, and
   * {@link UserCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserCacheKey#equals(Object)}
   *   <li>{@link UserCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserCacheKey userCacheKey = new UserCacheKey(new TenantId(null), null);
    UserCacheKey userCacheKey2 = new UserCacheKey(new TenantId(null), null);

    // Act and Assert
    assertEquals(userCacheKey, userCacheKey2);
    int expectedHashCodeResult = userCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, userCacheKey2.hashCode());
  }

  /**
   * Test {@link UserCacheKey#equals(Object)}, and
   * {@link UserCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserCacheKey#equals(Object)}
   *   <li>{@link UserCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserCacheKey userCacheKey = new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org");

    // Act and Assert
    assertEquals(userCacheKey, userCacheKey);
    int expectedHashCodeResult = userCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, userCacheKey.hashCode());
  }

  /**
   * Test {@link UserCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserCacheKey userCacheKey = new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org");

    // Act and Assert
    assertNotEquals(userCacheKey, new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org"));
  }

  /**
   * Test {@link UserCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org"),
        mock(AdminSettingsId.class));
  }

  /**
   * Test {@link UserCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserCacheKey userCacheKey = new UserCacheKey(new TenantId(null), "john.smith@example.org");

    // Act and Assert
    assertNotEquals(userCacheKey, new UserCacheKey(new TenantId(null), "jane.doe@example.org"));
  }

  /**
   * Test {@link UserCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserCacheKey userCacheKey = new UserCacheKey(new TenantId(null), null);

    // Act and Assert
    assertNotEquals(userCacheKey, new UserCacheKey(new TenantId(null), "jane.doe@example.org"));
  }

  /**
   * Test {@link UserCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org"), null);
  }

  /**
   * Test {@link UserCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org"),
        "Different type to UserCacheKey");
  }

  /**
   * Test {@link UserCacheKey#UserCacheKey(TenantId, String)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   *   <li>Then return not canEqual {@code Other}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCacheKey#UserCacheKey(TenantId, String)}
   */
  @Test
  @DisplayName("Test new UserCacheKey(TenantId, String); when TenantId(UUID) with id is randomUUID; then return not canEqual 'Other'")
  void testNewUserCacheKey_whenTenantIdWithIdIsRandomUUID_thenReturnNotCanEqualOther() {
    // Arrange, Act and Assert
    assertFalse((new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org")).canEqual("Other"));
  }
}
