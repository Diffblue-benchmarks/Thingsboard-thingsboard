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
    UserCacheKey userCacheKey = new UserCacheKey(new TenantId(null), "jane.doe@example.org");
    UserCacheKey userCacheKey2 = new UserCacheKey(new TenantId(null), "jane.doe@example.org");

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
    UserCacheKey userCacheKey = new UserCacheKey(new TenantId(null), null);
    UserCacheKey userCacheKey2 = new UserCacheKey(new TenantId(null), null);

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
    UserCacheKey userCacheKey =
        new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org");

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

    // Act and Assert
    assertNotEquals(
        userCacheKey, new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org"));
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
    UserCacheKey userCacheKey = new UserCacheKey(new TenantId(null), "john.smith@example.org");

    // Act and Assert
    assertNotEquals(userCacheKey, new UserCacheKey(new TenantId(null), "jane.doe@example.org"));
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
    UserCacheKey userCacheKey = new UserCacheKey(new TenantId(null), null);

    // Act and Assert
    assertNotEquals(userCacheKey, new UserCacheKey(new TenantId(null), "jane.doe@example.org"));
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
    // Arrange, Act and Assert
    assertNotEquals(
        new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org"), null);
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
    // Arrange, Act and Assert
    assertNotEquals(
        new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org"),
        "Different type to UserCacheKey");
  }

  /**
   * Test {@link UserCacheKey#UserCacheKey(TenantId, String)}.
   *
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.
   *   <li>Then return not canEqual {@code Other}.
   * </ul>
   *
   * <p>Method under test: {@link UserCacheKey#UserCacheKey(TenantId, String)}
   */
  @Test
  @DisplayName(
      "Test new UserCacheKey(TenantId, String); when TenantId(UUID) with id is randomUUID; then return not canEqual 'Other'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserCacheKey.<init>(TenantId, String)"})
  void testNewUserCacheKey_whenTenantIdWithIdIsRandomUUID_thenReturnNotCanEqualOther() {
    // Arrange, Act and Assert
    assertFalse(
        new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org")
            .canEqual("Other"));
  }
}
