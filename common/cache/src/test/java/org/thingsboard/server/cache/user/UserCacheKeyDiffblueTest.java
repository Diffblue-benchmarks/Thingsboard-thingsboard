package org.thingsboard.server.cache.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class UserCacheKeyDiffblueTest {
  /**
   * Test {@link UserCacheKey#equals(Object)}, and {@link UserCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserCacheKey#equals(Object)}
   *   <li>{@link UserCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCacheKey.equals(Object)", "int UserCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UserCacheKey userCacheKey = new UserCacheKey(tenantId, "jane.doe@example.org");
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UserCacheKey userCacheKey2 = new UserCacheKey(tenantId2, "jane.doe@example.org");

    // Act and Assert
    assertEquals(userCacheKey, userCacheKey2);
    assertEquals(userCacheKey.hashCode(), userCacheKey2.hashCode());
  }

  /**
   * Test {@link UserCacheKey#equals(Object)}, and {@link UserCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserCacheKey#equals(Object)}
   *   <li>{@link UserCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCacheKey.equals(Object)", "int UserCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UserCacheKey userCacheKey = new UserCacheKey(tenantId, null);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UserCacheKey userCacheKey2 = new UserCacheKey(tenantId2, null);

    // Act and Assert
    assertEquals(userCacheKey, userCacheKey2);
    assertEquals(userCacheKey.hashCode(), userCacheKey2.hashCode());
  }

  /**
   * Test {@link UserCacheKey#equals(Object)}, and {@link UserCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UserCacheKey#equals(Object)}
   *   <li>{@link UserCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCacheKey.equals(Object)", "int UserCacheKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UserCacheKey userCacheKey = new UserCacheKey(tenantId, "jane.doe@example.org");

    // Act and Assert
    assertEquals(userCacheKey, userCacheKey);
    int expectedHashCodeResult = userCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, userCacheKey.hashCode());
  }

  /**
   * Test {@link UserCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCacheKey.equals(Object)", "int UserCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserCacheKey userCacheKey =
        new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org");
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(userCacheKey, new UserCacheKey(tenantId, "jane.doe@example.org"));
  }

  /**
   * Test {@link UserCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCacheKey.equals(Object)", "int UserCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UserCacheKey userCacheKey = new UserCacheKey(tenantId, "john.smith@example.org");
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(userCacheKey, new UserCacheKey(tenantId2, "jane.doe@example.org"));
  }

  /**
   * Test {@link UserCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCacheKey.equals(Object)", "int UserCacheKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UserCacheKey userCacheKey = new UserCacheKey(tenantId, null);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(userCacheKey, new UserCacheKey(tenantId2, "jane.doe@example.org"));
  }

  /**
   * Test {@link UserCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCacheKey.equals(Object)", "int UserCacheKey.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(new UserCacheKey(tenantId, "jane.doe@example.org"), null);
  }

  /**
   * Test {@link UserCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UserCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean UserCacheKey.equals(Object)", "int UserCacheKey.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(
        new UserCacheKey(tenantId, "jane.doe@example.org"), "Different type to UserCacheKey");
  }

  /**
   * Test {@link UserCacheKey#UserCacheKey(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return not canEqual {@code Other}.
   * </ul>
   *
   * <p>Method under test: {@link UserCacheKey#UserCacheKey(TenantId, String)}
   */
  @Test
  @DisplayName("Test new UserCacheKey(TenantId, String); then return not canEqual 'Other'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserCacheKey.<init>(TenantId, String)"})
  void testNewUserCacheKey_thenReturnNotCanEqualOther() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertFalse(new UserCacheKey(tenantId, "jane.doe@example.org").canEqual("Other"));
  }

  /**
   * Test {@link UserCacheKey#toString()}.
   *
   * <p>Method under test: {@link UserCacheKey#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String UserCacheKey.toString()"})
  void testToString() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(
        "784f394c-42b6-435a-983c-b7beff2784f9_jane.doe@example.org",
        new UserCacheKey(tenantId, "jane.doe@example.org").toString());
  }
}
