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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class TenantIdDiffblueTest {
  /**
   * Test {@link TenantId#fromUUID(UUID)}.
   *
   * <ul>
   *   <li>When {@link EntityId#NULL_UUID}.
   *   <li>Then return NullUid.
   * </ul>
   *
   * <p>Method under test: {@link TenantId#fromUUID(UUID)}
   */
  @Test
  @DisplayName("Test fromUUID(UUID); when NULL_UUID; then return NullUid")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId TenantId.fromUUID(UUID)"})
  void testFromUUID_whenNull_uuid_thenReturnNullUid() {
    // Arrange
    UUID id = EntityId.NULL_UUID;

    // Act
    TenantId actualFromUUIDResult = TenantId.fromUUID(id);

    // Assert
    assertEquals(EntityType.TENANT, actualFromUUIDResult.getEntityType());
    assertTrue(actualFromUUIDResult.isNullUid());
    assertTrue(actualFromUUIDResult.isSysTenantId());
    assertSame(id, actualFromUUIDResult.getId());
  }

  /**
   * Test {@link TenantId#fromUUID(UUID)}.
   *
   * <ul>
   *   <li>When randomUUID.
   *   <li>Then return not NullUid.
   * </ul>
   *
   * <p>Method under test: {@link TenantId#fromUUID(UUID)}
   */
  @Test
  @DisplayName("Test fromUUID(UUID); when randomUUID; then return not NullUid")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantId TenantId.fromUUID(UUID)"})
  void testFromUUID_whenRandomUUID_thenReturnNotNullUid() {
    // Arrange
    UUID id = UUID.randomUUID();

    // Act
    TenantId actualFromUUIDResult = TenantId.fromUUID(id);

    // Assert
    assertEquals(EntityType.TENANT, actualFromUUIDResult.getEntityType());
    assertFalse(actualFromUUIDResult.isNullUid());
    assertFalse(actualFromUUIDResult.isSysTenantId());
    assertSame(id, actualFromUUIDResult.getId());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantId#TenantId(UUID)}
   *   <li>{@link TenantId#getEntityType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantId.<init>(UUID)", "EntityType TenantId.getEntityType()"})
  void testGettersAndSetters() {
    // Arrange
    UUID id = EntityId.NULL_UUID;

    // Act
    TenantId actualTenantId = new TenantId(id);
    EntityType actualEntityType = actualTenantId.getEntityType();

    // Assert
    UUID id2 = actualTenantId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id2.toString());
    assertEquals(EntityType.TENANT, actualEntityType);
    assertSame(id, id2);
  }

  /**
   * Test {@link TenantId#isSysTenantId()}.
   *
   * <ul>
   *   <li>Given {@link TenantId#SYS_TENANT_ID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TenantId#isSysTenantId()}
   */
  @Test
  @DisplayName("Test isSysTenantId(); given SYS_TENANT_ID; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantId.isSysTenantId()"})
  void testIsSysTenantId_givenSys_tenant_id_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(TenantId.SYS_TENANT_ID.isSysTenantId());
  }

  /**
   * Test {@link TenantId#isSysTenantId()}.
   *
   * <ul>
   *   <li>Given {@link TenantId#TenantId(UUID)} with id is randomUUID.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TenantId#isSysTenantId()}
   */
  @Test
  @DisplayName(
      "Test isSysTenantId(); given TenantId(UUID) with id is randomUUID; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantId.isSysTenantId()"})
  void testIsSysTenantId_givenTenantIdWithIdIsRandomUUID_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TenantId(UUID.randomUUID()).isSysTenantId());
  }
}
