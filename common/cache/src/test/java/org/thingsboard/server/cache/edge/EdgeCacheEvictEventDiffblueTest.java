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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class EdgeCacheEvictEventDiffblueTest {
  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}, and {@link EdgeCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeCacheEvictEvent#equals(Object)}
   *   <li>{@link EdgeCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCacheEvictEvent.equals(Object)",
    "int EdgeCacheEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(null, "New Name", "Old Name");
    EdgeCacheEvictEvent edgeCacheEvictEvent2 =
        new EdgeCacheEvictEvent(null, "New Name", "Old Name");

    // Act and Assert
    assertEquals(edgeCacheEvictEvent, edgeCacheEvictEvent2);
    assertEquals(edgeCacheEvictEvent.hashCode(), edgeCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}, and {@link EdgeCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeCacheEvictEvent#equals(Object)}
   *   <li>{@link EdgeCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCacheEvictEvent.equals(Object)",
    "int EdgeCacheEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(null, null, "Old Name");
    EdgeCacheEvictEvent edgeCacheEvictEvent2 = new EdgeCacheEvictEvent(null, null, "Old Name");

    // Act and Assert
    assertEquals(edgeCacheEvictEvent, edgeCacheEvictEvent2);
    assertEquals(edgeCacheEvictEvent.hashCode(), edgeCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}, and {@link EdgeCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeCacheEvictEvent#equals(Object)}
   *   <li>{@link EdgeCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCacheEvictEvent.equals(Object)",
    "int EdgeCacheEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(null, "New Name", null);
    EdgeCacheEvictEvent edgeCacheEvictEvent2 = new EdgeCacheEvictEvent(null, "New Name", null);

    // Act and Assert
    assertEquals(edgeCacheEvictEvent, edgeCacheEvictEvent2);
    assertEquals(edgeCacheEvictEvent.hashCode(), edgeCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}, and {@link EdgeCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeCacheEvictEvent#equals(Object)}
   *   <li>{@link EdgeCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCacheEvictEvent.equals(Object)",
    "int EdgeCacheEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent =
        new EdgeCacheEvictEvent(new TenantId(null), "New Name", "Old Name");
    EdgeCacheEvictEvent edgeCacheEvictEvent2 =
        new EdgeCacheEvictEvent(new TenantId(null), "New Name", "Old Name");

    // Act and Assert
    assertEquals(edgeCacheEvictEvent, edgeCacheEvictEvent2);
    assertEquals(edgeCacheEvictEvent.hashCode(), edgeCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}, and {@link EdgeCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeCacheEvictEvent#equals(Object)}
   *   <li>{@link EdgeCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCacheEvictEvent.equals(Object)",
    "int EdgeCacheEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent =
        new EdgeCacheEvictEvent(new TenantId(UUID.randomUUID()), "New Name", "Old Name");

    // Act and Assert
    assertEquals(edgeCacheEvictEvent, edgeCacheEvictEvent);
    int expectedHashCodeResult = edgeCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, edgeCacheEvictEvent.hashCode());
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCacheEvictEvent.equals(Object)",
    "int EdgeCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent =
        new EdgeCacheEvictEvent(new TenantId(UUID.randomUUID()), "New Name", "Old Name");

    // Act and Assert
    assertNotEquals(
        edgeCacheEvictEvent,
        new EdgeCacheEvictEvent(new TenantId(UUID.randomUUID()), "New Name", "Old Name"));
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCacheEvictEvent.equals(Object)",
    "int EdgeCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(null, "New Name", "Old Name");

    // Act and Assert
    assertNotEquals(
        edgeCacheEvictEvent,
        new EdgeCacheEvictEvent(new TenantId(UUID.randomUUID()), "New Name", "Old Name"));
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCacheEvictEvent.equals(Object)",
    "int EdgeCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(null, "Old Name", "Old Name");

    // Act and Assert
    assertNotEquals(edgeCacheEvictEvent, new EdgeCacheEvictEvent(null, "New Name", "Old Name"));
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCacheEvictEvent.equals(Object)",
    "int EdgeCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(null, null, "Old Name");

    // Act and Assert
    assertNotEquals(edgeCacheEvictEvent, new EdgeCacheEvictEvent(null, "New Name", "Old Name"));
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCacheEvictEvent.equals(Object)",
    "int EdgeCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(null, "New Name", "New Name");

    // Act and Assert
    assertNotEquals(edgeCacheEvictEvent, new EdgeCacheEvictEvent(null, "New Name", "Old Name"));
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCacheEvictEvent.equals(Object)",
    "int EdgeCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EdgeCacheEvictEvent edgeCacheEvictEvent = new EdgeCacheEvictEvent(null, "New Name", null);

    // Act and Assert
    assertNotEquals(edgeCacheEvictEvent, new EdgeCacheEvictEvent(null, "New Name", "Old Name"));
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCacheEvictEvent.equals(Object)",
    "int EdgeCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new EdgeCacheEvictEvent(new TenantId(UUID.randomUUID()), "New Name", "Old Name"), null);
  }

  /**
   * Test {@link EdgeCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeCacheEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeCacheEvictEvent.equals(Object)",
    "int EdgeCacheEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new EdgeCacheEvictEvent(new TenantId(UUID.randomUUID()), "New Name", "Old Name"),
        "Different type to EdgeCacheEvictEvent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeCacheEvictEvent#EdgeCacheEvictEvent(TenantId, String, String)}
   *   <li>{@link EdgeCacheEvictEvent#toString()}
   *   <li>{@link EdgeCacheEvictEvent#getNewName()}
   *   <li>{@link EdgeCacheEvictEvent#getOldName()}
   *   <li>{@link EdgeCacheEvictEvent#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EdgeCacheEvictEvent.<init>(TenantId, String, String)",
    "String EdgeCacheEvictEvent.getNewName()",
    "String EdgeCacheEvictEvent.getOldName()",
    "TenantId EdgeCacheEvictEvent.getTenantId()",
    "String EdgeCacheEvictEvent.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    EdgeCacheEvictEvent actualEdgeCacheEvictEvent =
        new EdgeCacheEvictEvent(tenantId, "New Name", "Old Name");
    actualEdgeCacheEvictEvent.toString();
    String actualNewName = actualEdgeCacheEvictEvent.getNewName();
    String actualOldName = actualEdgeCacheEvictEvent.getOldName();

    // Assert
    assertEquals("New Name", actualNewName);
    assertEquals("Old Name", actualOldName);
    assertSame(tenantId, actualEdgeCacheEvictEvent.getTenantId());
  }
}
