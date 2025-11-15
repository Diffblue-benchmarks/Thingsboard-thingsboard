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
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class TenantIdDiffblueTest {
  /**
   * Method under test: {@link TenantId#fromUUID(UUID)}
   */
  @Test
  void testFromUUID() {
    // Arrange
    UUID id = EntityId.NULL_UUID;

    // Act
    TenantId actualFromUUIDResult = TenantId.fromUUID(id);

    // Assert
    UUID id2 = actualFromUUIDResult.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id2.toString());
    assertEquals(EntityType.TENANT, actualFromUUIDResult.getEntityType());
    assertTrue(actualFromUUIDResult.isNullUid());
    assertTrue(actualFromUUIDResult.isSysTenantId());
    assertSame(id, id2);
  }

  /**
   * Method under test: {@link TenantId#fromUUID(UUID)}
   */
  @Test
  void testFromUUID2() {
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
   * Method under test: {@link TenantId#isSysTenantId()}
   */
  @Test
  void testIsSysTenantId() {
    // Arrange, Act and Assert
    assertTrue(TenantId.SYS_TENANT_ID.isSysTenantId());
    assertFalse((new TenantId(UUID.randomUUID())).isSysTenantId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantId#TenantId(UUID)}
   *   <li>{@link TenantId#getEntityType()}
   * </ul>
   */
  @Test
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
}
