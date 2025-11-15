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
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.TenantId;

class UserCacheKeyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UserCacheKey#equals(Object)}
   *   <li>{@link UserCacheKey#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link UserCacheKey#equals(Object)}
   *   <li>{@link UserCacheKey#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link UserCacheKey#equals(Object)}
   *   <li>{@link UserCacheKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UserCacheKey userCacheKey = new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org");

    // Act and Assert
    assertEquals(userCacheKey, userCacheKey);
    int expectedHashCodeResult = userCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, userCacheKey.hashCode());
  }

  /**
   * Method under test: {@link UserCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserCacheKey userCacheKey = new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org");

    // Act and Assert
    assertNotEquals(userCacheKey, new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org"));
  }

  /**
   * Method under test: {@link UserCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org"),
        mock(AdminSettingsId.class));
  }

  /**
   * Method under test: {@link UserCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserCacheKey userCacheKey = new UserCacheKey(new TenantId(null), "john.smith@example.org");

    // Act and Assert
    assertNotEquals(userCacheKey, new UserCacheKey(new TenantId(null), "jane.doe@example.org"));
  }

  /**
   * Method under test: {@link UserCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserCacheKey userCacheKey = new UserCacheKey(new TenantId(null), null);

    // Act and Assert
    assertNotEquals(userCacheKey, new UserCacheKey(new TenantId(null), "jane.doe@example.org"));
  }

  /**
   * Method under test: {@link UserCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org"), null);
  }

  /**
   * Method under test: {@link UserCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org"),
        "Different type to UserCacheKey");
  }

  /**
   * Method under test: {@link UserCacheKey#UserCacheKey(TenantId, String)}
   */
  @Test
  void testNewUserCacheKey() {
    // Arrange, Act and Assert
    assertFalse((new UserCacheKey(new TenantId(UUID.randomUUID()), "jane.doe@example.org")).canEqual("Other"));
  }
}
