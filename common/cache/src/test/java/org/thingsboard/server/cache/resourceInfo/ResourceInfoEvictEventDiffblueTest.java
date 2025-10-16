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
package org.thingsboard.server.cache.resourceInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;

class ResourceInfoEvictEventDiffblueTest {
  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}, and {@link
   * ResourceInfoEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceInfoEvictEvent#equals(Object)}
   *   <li>{@link ResourceInfoEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ResourceInfoEvictEvent resourceInfoEvictEvent = new ResourceInfoEvictEvent(null, null);
    ResourceInfoEvictEvent resourceInfoEvictEvent2 = new ResourceInfoEvictEvent(null, null);

    // Act and Assert
    assertEquals(resourceInfoEvictEvent, resourceInfoEvictEvent2);
    assertEquals(resourceInfoEvictEvent.hashCode(), resourceInfoEvictEvent2.hashCode());
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}, and {@link
   * ResourceInfoEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceInfoEvictEvent#equals(Object)}
   *   <li>{@link ResourceInfoEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ResourceInfoEvictEvent resourceInfoEvictEvent =
        new ResourceInfoEvictEvent(null, new TbResourceId(null));
    ResourceInfoEvictEvent resourceInfoEvictEvent2 =
        new ResourceInfoEvictEvent(null, new TbResourceId(null));

    // Act and Assert
    assertEquals(resourceInfoEvictEvent, resourceInfoEvictEvent2);
    assertEquals(resourceInfoEvictEvent.hashCode(), resourceInfoEvictEvent2.hashCode());
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}, and {@link
   * ResourceInfoEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceInfoEvictEvent#equals(Object)}
   *   <li>{@link ResourceInfoEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ResourceInfoEvictEvent resourceInfoEvictEvent =
        new ResourceInfoEvictEvent(tenantId, new TbResourceId(UUID.randomUUID()));

    // Act and Assert
    assertEquals(resourceInfoEvictEvent, resourceInfoEvictEvent);
    int expectedHashCodeResult = resourceInfoEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, resourceInfoEvictEvent.hashCode());
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ResourceInfoEvictEvent resourceInfoEvictEvent =
        new ResourceInfoEvictEvent(tenantId, new TbResourceId(UUID.randomUUID()));
    TenantId tenantId2 = new TenantId(UUID.randomUUID());
    ResourceInfoEvictEvent resourceInfoEvictEvent2 =
        new ResourceInfoEvictEvent(tenantId2, new TbResourceId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, resourceInfoEvictEvent2);
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ResourceInfoEvictEvent resourceInfoEvictEvent =
        new ResourceInfoEvictEvent(null, new TbResourceId(UUID.randomUUID()));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ResourceInfoEvictEvent resourceInfoEvictEvent2 =
        new ResourceInfoEvictEvent(tenantId, new TbResourceId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, resourceInfoEvictEvent2);
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ResourceInfoEvictEvent resourceInfoEvictEvent =
        new ResourceInfoEvictEvent(null, new TbResourceId(UUID.randomUUID()));
    ResourceInfoEvictEvent resourceInfoEvictEvent2 =
        new ResourceInfoEvictEvent(null, new TbResourceId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, resourceInfoEvictEvent2);
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ResourceInfoEvictEvent resourceInfoEvictEvent = new ResourceInfoEvictEvent(null, null);
    ResourceInfoEvictEvent resourceInfoEvictEvent2 =
        new ResourceInfoEvictEvent(null, new TbResourceId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, resourceInfoEvictEvent2);
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TenantId tenantId = new TenantId(null);
    ResourceInfoEvictEvent resourceInfoEvictEvent =
        new ResourceInfoEvictEvent(tenantId, new TbResourceId(UUID.randomUUID()));
    TenantId tenantId2 = new TenantId(null);
    ResourceInfoEvictEvent resourceInfoEvictEvent2 =
        new ResourceInfoEvictEvent(tenantId2, new TbResourceId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, resourceInfoEvictEvent2);
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ResourceInfoEvictEvent resourceInfoEvictEvent =
        new ResourceInfoEvictEvent(tenantId, new TbResourceId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, null);
  }

  /**
   * Test {@link ResourceInfoEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ResourceInfoEvictEvent.equals(Object)",
    "int ResourceInfoEvictEvent.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ResourceInfoEvictEvent resourceInfoEvictEvent =
        new ResourceInfoEvictEvent(tenantId, new TbResourceId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, "Different type to ResourceInfoEvictEvent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResourceInfoEvictEvent#ResourceInfoEvictEvent(TenantId, TbResourceId)}
   *   <li>{@link ResourceInfoEvictEvent#toString()}
   *   <li>{@link ResourceInfoEvictEvent#getResourceId()}
   *   <li>{@link ResourceInfoEvictEvent#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResourceInfoEvictEvent.<init>(TenantId, TbResourceId)",
    "TbResourceId ResourceInfoEvictEvent.getResourceId()",
    "TenantId ResourceInfoEvictEvent.getTenantId()",
    "java.lang.String ResourceInfoEvictEvent.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    TbResourceId resourceId = new TbResourceId(UUID.randomUUID());

    // Act
    ResourceInfoEvictEvent actualResourceInfoEvictEvent =
        new ResourceInfoEvictEvent(tenantId, resourceId);
    actualResourceInfoEvictEvent.toString();
    TbResourceId actualResourceId = actualResourceInfoEvictEvent.getResourceId();

    // Assert
    assertSame(resourceId, actualResourceId);
    assertSame(tenantId, actualResourceInfoEvictEvent.getTenantId());
  }
}
