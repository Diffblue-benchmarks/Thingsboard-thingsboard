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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.cache.edge.RelatedEdgesCacheKey.RelatedEdgesCacheKeyBuilder;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;

class RelatedEdgesCacheKeyDiffblueTest {
  /**
   * Test {@link RelatedEdgesCacheKey#equals(Object)}, and {@link RelatedEdgesCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelatedEdgesCacheKey#equals(Object)}
   *   <li>{@link RelatedEdgesCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedEdgesCacheKey.equals(Object)",
    "int RelatedEdgesCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelatedEdgesCacheKey relatedEdgesCacheKey =
        RelatedEdgesCacheKey.builder().entityId(null).tenantId(null).build();
    RelatedEdgesCacheKey relatedEdgesCacheKey2 =
        RelatedEdgesCacheKey.builder().entityId(null).tenantId(null).build();

    // Act and Assert
    assertEquals(relatedEdgesCacheKey, relatedEdgesCacheKey2);
    assertEquals(relatedEdgesCacheKey.hashCode(), relatedEdgesCacheKey2.hashCode());
  }

  /**
   * Test {@link RelatedEdgesCacheKey#equals(Object)}, and {@link RelatedEdgesCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelatedEdgesCacheKey#equals(Object)}
   *   <li>{@link RelatedEdgesCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedEdgesCacheKey.equals(Object)",
    "int RelatedEdgesCacheKey.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelatedEdgesCacheKeyBuilder entityIdResult = RelatedEdgesCacheKey.builder().entityId(null);
    RelatedEdgesCacheKey relatedEdgesCacheKey = entityIdResult.tenantId(new TenantId(null)).build();

    RelatedEdgesCacheKeyBuilder entityIdResult2 = RelatedEdgesCacheKey.builder().entityId(null);
    RelatedEdgesCacheKey relatedEdgesCacheKey2 =
        entityIdResult2.tenantId(new TenantId(null)).build();

    // Act and Assert
    assertEquals(relatedEdgesCacheKey, relatedEdgesCacheKey2);
    assertEquals(relatedEdgesCacheKey.hashCode(), relatedEdgesCacheKey2.hashCode());
  }

  /**
   * Test {@link RelatedEdgesCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelatedEdgesCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedEdgesCacheKey.equals(Object)",
    "int RelatedEdgesCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RelatedEdgesCacheKeyBuilder entityIdResult = RelatedEdgesCacheKey.builder().entityId(null);
    RelatedEdgesCacheKey relatedEdgesCacheKey =
        entityIdResult.tenantId(new TenantId(UUID.randomUUID())).build();

    RelatedEdgesCacheKeyBuilder entityIdResult2 = RelatedEdgesCacheKey.builder().entityId(null);

    // Act and Assert
    assertNotEquals(
        relatedEdgesCacheKey, entityIdResult2.tenantId(new TenantId(UUID.randomUUID())).build());
  }

  /**
   * Test {@link RelatedEdgesCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelatedEdgesCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedEdgesCacheKey.equals(Object)",
    "int RelatedEdgesCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelatedEdgesCacheKey relatedEdgesCacheKey =
        RelatedEdgesCacheKey.builder().entityId(null).tenantId(null).build();

    RelatedEdgesCacheKeyBuilder entityIdResult = RelatedEdgesCacheKey.builder().entityId(null);

    // Act and Assert
    assertNotEquals(
        relatedEdgesCacheKey, entityIdResult.tenantId(new TenantId(UUID.randomUUID())).build());
  }

  /**
   * Test {@link RelatedEdgesCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelatedEdgesCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedEdgesCacheKey.equals(Object)",
    "int RelatedEdgesCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelatedEdgesCacheKeyBuilder builderResult = RelatedEdgesCacheKey.builder();
    RelatedEdgesCacheKey relatedEdgesCacheKey =
        builderResult.entityId(new AlarmId(UUID.randomUUID())).tenantId(null).build();

    // Act and Assert
    assertNotEquals(
        relatedEdgesCacheKey, RelatedEdgesCacheKey.builder().entityId(null).tenantId(null).build());
  }

  /**
   * Test {@link RelatedEdgesCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelatedEdgesCacheKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelatedEdgesCacheKey.equals(Object)",
    "int RelatedEdgesCacheKey.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RelatedEdgesCacheKey relatedEdgesCacheKey =
        RelatedEdgesCacheKey.builder().entityId(null).tenantId(null).build();

    RelatedEdgesCacheKeyBuilder builderResult = RelatedEdgesCacheKey.builder();

    // Act and Assert
    assertNotEquals(
        relatedEdgesCacheKey,
        builderResult.entityId(new AlarmId(UUID.randomUUID())).tenantId(null).build());
  }
}
