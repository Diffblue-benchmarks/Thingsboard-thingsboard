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
package org.thingsboard.server.cache.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class EdgeCacheEvictEventDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeCacheEvictEvent#equals(Object)}
   *   <li>{@link EdgeCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(new TenantId(null), "New Name", "Old Name");
    EdgeCacheEvictEvent edgeCacheEvictEvent2 = new EdgeCacheEvictEvent(new TenantId(null), "New Name", "Old Name");

    // Act and Assert
    assertEquals(edgeCacheEvictEvent, edgeCacheEvictEvent2);
    int expectedHashCodeResult = edgeCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, edgeCacheEvictEvent2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeCacheEvictEvent#equals(Object)}
   *   <li>{@link EdgeCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(null, "New Name", "Old Name");
    EdgeCacheEvictEvent edgeCacheEvictEvent2 = new EdgeCacheEvictEvent(null, "New Name", "Old Name");

    // Act and Assert
    assertEquals(edgeCacheEvictEvent, edgeCacheEvictEvent2);
    int expectedHashCodeResult = edgeCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, edgeCacheEvictEvent2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeCacheEvictEvent#equals(Object)}
   *   <li>{@link EdgeCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(new TenantId(UUID.randomUUID()), "New Name",
        "Old Name");

    // Act and Assert
    assertEquals(edgeCacheEvictEvent, edgeCacheEvictEvent);
    int expectedHashCodeResult = edgeCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, edgeCacheEvictEvent.hashCode());
  }

  /**
   * Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(new TenantId(UUID.randomUUID()), "New Name",
        "Old Name");

    // Act and Assert
    assertNotEquals(edgeCacheEvictEvent,
        new EdgeCacheEvictEvent(new TenantId(UUID.randomUUID()), "New Name", "Old Name"));
  }

  /**
   * Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(null, "New Name", "Old Name");

    // Act and Assert
    assertNotEquals(edgeCacheEvictEvent,
        new EdgeCacheEvictEvent(new TenantId(UUID.randomUUID()), "New Name", "Old Name"));
  }

  /**
   * Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeCacheEvictEvent(new TenantId(UUID.randomUUID()), "New Name", "Old Name"), null);
  }

  /**
   * Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeCacheEvictEvent(new TenantId(UUID.randomUUID()), "New Name", "Old Name"),
        "Different type to EdgeCacheEvictEvent");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeCacheEvictEvent#EdgeCacheEvictEvent(TenantId, String, String)}
   *   <li>{@link EdgeCacheEvictEvent#toString()}
   *   <li>{@link EdgeCacheEvictEvent#getNewName()}
   *   <li>{@link EdgeCacheEvictEvent#getOldName()}
   *   <li>{@link EdgeCacheEvictEvent#getTenantId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    EdgeCacheEvictEvent actualEdgeCacheEvictEvent = new EdgeCacheEvictEvent(tenantId, "New Name", "Old Name");
    actualEdgeCacheEvictEvent.toString();
    String actualNewName = actualEdgeCacheEvictEvent.getNewName();
    String actualOldName = actualEdgeCacheEvictEvent.getOldName();

    // Assert
    assertEquals("New Name", actualNewName);
    assertEquals("Old Name", actualOldName);
    assertSame(tenantId, actualEdgeCacheEvictEvent.getTenantId());
  }
}
