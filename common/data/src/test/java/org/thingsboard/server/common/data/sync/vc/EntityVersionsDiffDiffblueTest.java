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
package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.DeviceExportData;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.vc.EntityVersionsDiff.EntityVersionsDiffBuilder;

class EntityVersionsDiffDiffblueTest {
  /**
   * Test {@link EntityVersionsDiff#equals(Object)}, and {@link EntityVersionsDiff#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityVersionsDiff#equals(Object)}
   *   <li>{@link EntityVersionsDiff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff entityVersionsDiff =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    EntityVersionsDiffBuilder builderResult2 = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        builderResult2.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff entityVersionsDiff2 =
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    // Act and Assert
    assertEquals(entityVersionsDiff, entityVersionsDiff2);
    assertEquals(entityVersionsDiff.hashCode(), entityVersionsDiff2.hashCode());
  }

  /**
   * Test {@link EntityVersionsDiff#equals(Object)}, and {@link EntityVersionsDiff#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityVersionsDiff#equals(Object)}
   *   <li>{@link EntityVersionsDiff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        EntityVersionsDiff.builder().entityDataAtVersion1(null);
    EntityVersionsDiff entityVersionsDiff =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        EntityVersionsDiff.builder().entityDataAtVersion1(null);
    EntityVersionsDiff entityVersionsDiff2 =
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    // Act and Assert
    assertEquals(entityVersionsDiff, entityVersionsDiff2);
    assertEquals(entityVersionsDiff.hashCode(), entityVersionsDiff2.hashCode());
  }

  /**
   * Test {@link EntityVersionsDiff#equals(Object)}, and {@link EntityVersionsDiff#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityVersionsDiff#equals(Object)}
   *   <li>{@link EntityVersionsDiff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityVersionsDiff entityVersionsDiff =
        builderResult
            .entityDataAtVersion1(new EntityExportData<>())
            .entityDataAtVersion2(null)
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    EntityVersionsDiffBuilder builderResult2 = EntityVersionsDiff.builder();
    EntityVersionsDiff entityVersionsDiff2 =
        builderResult2
            .entityDataAtVersion1(new EntityExportData<>())
            .entityDataAtVersion2(null)
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    // Act and Assert
    assertEquals(entityVersionsDiff, entityVersionsDiff2);
    assertEquals(entityVersionsDiff.hashCode(), entityVersionsDiff2.hashCode());
  }

  /**
   * Test {@link EntityVersionsDiff#equals(Object)}, and {@link EntityVersionsDiff#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityVersionsDiff#equals(Object)}
   *   <li>{@link EntityVersionsDiff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff entityVersionsDiff =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(null)
            .rawDiff("Raw Diff")
            .build();

    EntityVersionsDiffBuilder builderResult2 = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        builderResult2.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff entityVersionsDiff2 =
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(null)
            .rawDiff("Raw Diff")
            .build();

    // Act and Assert
    assertEquals(entityVersionsDiff, entityVersionsDiff2);
    assertEquals(entityVersionsDiff.hashCode(), entityVersionsDiff2.hashCode());
  }

  /**
   * Test {@link EntityVersionsDiff#equals(Object)}, and {@link EntityVersionsDiff#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityVersionsDiff#equals(Object)}
   *   <li>{@link EntityVersionsDiff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff entityVersionsDiff =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff(null)
            .build();

    EntityVersionsDiffBuilder builderResult2 = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        builderResult2.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff entityVersionsDiff2 =
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff(null)
            .build();

    // Act and Assert
    assertEquals(entityVersionsDiff, entityVersionsDiff2);
    assertEquals(entityVersionsDiff.hashCode(), entityVersionsDiff2.hashCode());
  }

  /**
   * Test {@link EntityVersionsDiff#equals(Object)}, and {@link EntityVersionsDiff#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityVersionsDiff#equals(Object)}
   *   <li>{@link EntityVersionsDiff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff entityVersionsDiff =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    // Act and Assert
    assertEquals(entityVersionsDiff, entityVersionsDiff);
    int expectedHashCodeResult = entityVersionsDiff.hashCode();
    assertEquals(expectedHashCodeResult, entityVersionsDiff.hashCode());
  }

  /**
   * Test {@link EntityVersionsDiff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityVersionsDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        builderResult.entityDataAtVersion1(new DeviceExportData());
    EntityVersionsDiff entityVersionsDiff =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    EntityVersionsDiffBuilder builderResult2 = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        builderResult2.entityDataAtVersion1(new EntityExportData<>());

    // Act and Assert
    assertNotEquals(
        entityVersionsDiff,
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build());
  }

  /**
   * Test {@link EntityVersionsDiff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityVersionsDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        EntityVersionsDiff.builder().entityDataAtVersion1(null);
    EntityVersionsDiff entityVersionsDiff =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        builderResult.entityDataAtVersion1(new EntityExportData<>());

    // Act and Assert
    assertNotEquals(
        entityVersionsDiff,
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build());
  }

  /**
   * Test {@link EntityVersionsDiff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityVersionsDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff entityVersionsDiff =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new DeviceExportData())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    EntityVersionsDiffBuilder builderResult2 = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        builderResult2.entityDataAtVersion1(new EntityExportData<>());

    // Act and Assert
    assertNotEquals(
        entityVersionsDiff,
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build());
  }

  /**
   * Test {@link EntityVersionsDiff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityVersionsDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityVersionsDiff entityVersionsDiff =
        builderResult
            .entityDataAtVersion1(new EntityExportData<>())
            .entityDataAtVersion2(null)
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    EntityVersionsDiffBuilder builderResult2 = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        builderResult2.entityDataAtVersion1(new EntityExportData<>());

    // Act and Assert
    assertNotEquals(
        entityVersionsDiff,
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build());
  }

  /**
   * Test {@link EntityVersionsDiff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityVersionsDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff entityVersionsDiff =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(null)
            .rawDiff("Raw Diff")
            .build();

    EntityVersionsDiffBuilder builderResult2 = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        builderResult2.entityDataAtVersion1(new EntityExportData<>());

    // Act and Assert
    assertNotEquals(
        entityVersionsDiff,
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build());
  }

  /**
   * Test {@link EntityVersionsDiff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityVersionsDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        builderResult.entityDataAtVersion1(new EntityExportData<>());

    EntityVersionsDiffBuilder entityDataAtVersion2Result =
        entityDataAtVersion1Result.entityDataAtVersion2(new EntityExportData<>());
    EntityVersionsDiff entityVersionsDiff =
        entityDataAtVersion2Result
            .externalId(new AlarmId(EntityId.NULL_UUID))
            .rawDiff("Raw Diff")
            .build();

    EntityVersionsDiffBuilder builderResult2 = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        builderResult2.entityDataAtVersion1(new EntityExportData<>());

    // Act and Assert
    assertNotEquals(
        entityVersionsDiff,
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build());
  }

  /**
   * Test {@link EntityVersionsDiff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityVersionsDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff entityVersionsDiff =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff(null)
            .build();

    EntityVersionsDiffBuilder builderResult2 = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        builderResult2.entityDataAtVersion1(new EntityExportData<>());

    // Act and Assert
    assertNotEquals(
        entityVersionsDiff,
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build());
  }

  /**
   * Test {@link EntityVersionsDiff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityVersionsDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff entityVersionsDiff =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("42")
            .build();

    EntityVersionsDiffBuilder builderResult2 = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        builderResult2.entityDataAtVersion1(new EntityExportData<>());

    // Act and Assert
    assertNotEquals(
        entityVersionsDiff,
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build());
  }

  /**
   * Test {@link EntityVersionsDiff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityVersionsDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        builderResult.entityDataAtVersion1(new EntityExportData<>());

    // Act and Assert
    assertNotEquals(
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build(),
        null);
  }

  /**
   * Test {@link EntityVersionsDiff#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityVersionsDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();

    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        builderResult.entityDataAtVersion1(new EntityExportData<>());

    // Act and Assert
    assertNotEquals(
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build(),
        "Different type to EntityVersionsDiff");
  }
}
