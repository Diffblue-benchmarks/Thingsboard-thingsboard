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
package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class UUIDBasedDiffblueTest {
  /**
   * Method under test: {@link UUIDBased#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", (new AdminSettingsId(EntityId.NULL_UUID)).getId().toString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UUIDBased#equals(Object)}
   *   <li>{@link UUIDBased#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    TenantId tenantId2 = TenantId.SYS_TENANT_ID;

    // Act and Assert
    assertEquals(tenantId, tenantId2);
    int expectedHashCodeResult = tenantId.hashCode();
    assertEquals(expectedHashCodeResult, tenantId2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UUIDBased#equals(Object)}
   *   <li>{@link UUIDBased#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantId tenantId = new TenantId(EntityId.NULL_UUID);
    TenantId tenantId2 = TenantId.SYS_TENANT_ID;

    // Act and Assert
    assertEquals(tenantId, tenantId2);
    int expectedHashCodeResult = tenantId.hashCode();
    assertEquals(expectedHashCodeResult, tenantId2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link UUIDBased#equals(Object)}
   *   <li>{@link UUIDBased#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    // Act and Assert
    assertEquals(tenantId, tenantId);
    int expectedHashCodeResult = tenantId.hashCode();
    assertEquals(expectedHashCodeResult, tenantId.hashCode());
  }

  /**
   * Method under test: {@link UUIDBased#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", (new AdminSettingsId(EntityId.NULL_UUID)).toString());
  }

  /**
   * Method under test: {@link UUIDBased#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TenantId.SYS_TENANT_ID, 1);
    assertNotEquals(new TenantId(UUID.randomUUID()), TenantId.SYS_TENANT_ID);
    assertNotEquals(new TenantId(null), TenantId.SYS_TENANT_ID);
    assertNotEquals(new TenantId(EntityId.NULL_UUID), mock(AlarmCommentId.class));
  }

  /**
   * Method under test: {@link UUIDBased#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TenantId.SYS_TENANT_ID, null);
  }

  /**
   * Method under test: {@link UUIDBased#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TenantId.SYS_TENANT_ID, "Different type to UUIDBased");
  }
}
