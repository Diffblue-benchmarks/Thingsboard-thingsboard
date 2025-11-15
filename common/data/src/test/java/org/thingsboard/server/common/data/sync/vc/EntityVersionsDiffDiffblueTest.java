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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;

class EntityVersionsDiffDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityVersionsDiff.EntityVersionsDiffBuilder#build()}
   *   <li>
   * {@link EntityVersionsDiff.EntityVersionsDiffBuilder#entityDataAtVersion1(EntityExportData)}
   *   <li>
   * {@link EntityVersionsDiff.EntityVersionsDiffBuilder#entityDataAtVersion2(EntityExportData)}
   *   <li>{@link EntityVersionsDiff.EntityVersionsDiffBuilder#externalId(EntityId)}
   *   <li>{@link EntityVersionsDiff.EntityVersionsDiffBuilder#rawDiff(String)}
   * </ul>
   */
  @Test
  void testEntityVersionsDiffBuilderBuild() {
    // Arrange
    EntityVersionsDiff.EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityExportData<ExportableEntity<? extends EntityId>> entityDataAtVersion1 = new EntityExportData<>();
    EntityVersionsDiff.EntityVersionsDiffBuilder entityDataAtVersion1Result = builderResult
        .entityDataAtVersion1(entityDataAtVersion1);
    EntityExportData<ExportableEntity<? extends EntityId>> entityDataAtVersion2 = new EntityExportData<>();

    // Act
    EntityVersionsDiff actualBuildResult = entityDataAtVersion1Result.entityDataAtVersion2(entityDataAtVersion2)
        .externalId(TenantId.SYS_TENANT_ID)
        .rawDiff("Raw Diff")
        .build();

    // Assert
    assertTrue(actualBuildResult.getExternalId() instanceof TenantId);
    assertEquals("Raw Diff", actualBuildResult.getRawDiff());
    assertSame(entityDataAtVersion1, actualBuildResult.getEntityDataAtVersion1());
    assertSame(entityDataAtVersion2, actualBuildResult.getEntityDataAtVersion2());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityVersionsDiff#equals(Object)}
   *   <li>{@link EntityVersionsDiff#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityVersionsDiff.EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityVersionsDiff.EntityVersionsDiffBuilder entityDataAtVersion1Result = builderResult
        .entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult = entityDataAtVersion1Result.entityDataAtVersion2(new EntityExportData<>())
        .externalId(TenantId.SYS_TENANT_ID)
        .rawDiff("Raw Diff")
        .build();
    EntityVersionsDiff.EntityVersionsDiffBuilder builderResult2 = EntityVersionsDiff.builder();
    EntityVersionsDiff.EntityVersionsDiffBuilder entityDataAtVersion1Result2 = builderResult2
        .entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult2 = entityDataAtVersion1Result2.entityDataAtVersion2(new EntityExportData<>())
        .externalId(TenantId.SYS_TENANT_ID)
        .rawDiff("Raw Diff")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityVersionsDiff#equals(Object)}
   *   <li>{@link EntityVersionsDiff#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityVersionsDiff.EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityVersionsDiff.EntityVersionsDiffBuilder entityDataAtVersion1Result = builderResult
        .entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult = entityDataAtVersion1Result.entityDataAtVersion2(new EntityExportData<>())
        .externalId(TenantId.SYS_TENANT_ID)
        .rawDiff("Raw Diff")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link EntityVersionsDiff#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityVersionsDiff.EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityVersionsDiff.EntityVersionsDiffBuilder entityDataAtVersion1Result = builderResult
        .entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult = entityDataAtVersion1Result.entityDataAtVersion2(new EntityExportData<>())
        .externalId(TenantId.SYS_TENANT_ID)
        .rawDiff("Raw Diff")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link EntityVersionsDiff#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityVersionsDiff.EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityVersionsDiff.EntityVersionsDiffBuilder entityDataAtVersion1Result = builderResult
        .entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult = entityDataAtVersion1Result.entityDataAtVersion2(new EntityExportData<>())
        .externalId(TenantId.SYS_TENANT_ID)
        .rawDiff("Raw Diff")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EntityVersionsDiff");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityVersionsDiff#EntityVersionsDiff()}
   *   <li>{@link EntityVersionsDiff#setEntityDataAtVersion1(EntityExportData)}
   *   <li>{@link EntityVersionsDiff#setEntityDataAtVersion2(EntityExportData)}
   *   <li>{@link EntityVersionsDiff#setExternalId(EntityId)}
   *   <li>{@link EntityVersionsDiff#setRawDiff(String)}
   *   <li>{@link EntityVersionsDiff#toString()}
   *   <li>{@link EntityVersionsDiff#getEntityDataAtVersion1()}
   *   <li>{@link EntityVersionsDiff#getEntityDataAtVersion2()}
   *   <li>{@link EntityVersionsDiff#getExternalId()}
   *   <li>{@link EntityVersionsDiff#getRawDiff()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntityVersionsDiff actualEntityVersionsDiff = new EntityVersionsDiff();
    EntityExportData<ExportableEntity<? extends EntityId>> entityDataAtVersion1 = new EntityExportData<>();
    actualEntityVersionsDiff.setEntityDataAtVersion1(entityDataAtVersion1);
    EntityExportData<ExportableEntity<? extends EntityId>> entityDataAtVersion2 = new EntityExportData<>();
    actualEntityVersionsDiff.setEntityDataAtVersion2(entityDataAtVersion2);
    actualEntityVersionsDiff.setExternalId(TenantId.SYS_TENANT_ID);
    actualEntityVersionsDiff.setRawDiff("Raw Diff");
    String actualToStringResult = actualEntityVersionsDiff.toString();
    EntityExportData<?> actualEntityDataAtVersion1 = actualEntityVersionsDiff.getEntityDataAtVersion1();
    EntityExportData<?> actualEntityDataAtVersion2 = actualEntityVersionsDiff.getEntityDataAtVersion2();
    EntityId actualExternalId = actualEntityVersionsDiff.getExternalId();

    // Assert that nothing has changed
    assertEquals(
        "EntityVersionsDiff(externalId=13814000-1dd2-11b2-8080-808080808080, entityDataAtVersion1=EntityExportData"
            + "(entity=null, entityType=null, relations=null, attributes=null), entityDataAtVersion2=EntityExportData"
            + "(entity=null, entityType=null, relations=null, attributes=null), rawDiff=Raw Diff)",
        actualToStringResult);
    assertEquals("Raw Diff", actualEntityVersionsDiff.getRawDiff());
    assertSame(entityDataAtVersion1, actualEntityDataAtVersion1);
    assertSame(entityDataAtVersion2, actualEntityDataAtVersion2);
    assertSame(((TenantId) actualExternalId).SYS_TENANT_ID, actualExternalId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityVersionsDiff#EntityVersionsDiff(EntityId, EntityExportData, EntityExportData, String)}
   *   <li>{@link EntityVersionsDiff#setEntityDataAtVersion1(EntityExportData)}
   *   <li>{@link EntityVersionsDiff#setEntityDataAtVersion2(EntityExportData)}
   *   <li>{@link EntityVersionsDiff#setExternalId(EntityId)}
   *   <li>{@link EntityVersionsDiff#setRawDiff(String)}
   *   <li>{@link EntityVersionsDiff#toString()}
   *   <li>{@link EntityVersionsDiff#getEntityDataAtVersion1()}
   *   <li>{@link EntityVersionsDiff#getEntityDataAtVersion2()}
   *   <li>{@link EntityVersionsDiff#getExternalId()}
   *   <li>{@link EntityVersionsDiff#getRawDiff()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> entityDataAtVersion1 = new EntityExportData<>();

    // Act
    EntityVersionsDiff actualEntityVersionsDiff = new EntityVersionsDiff(TenantId.SYS_TENANT_ID, entityDataAtVersion1,
        new EntityExportData<>(), "Raw Diff");
    EntityExportData<ExportableEntity<? extends EntityId>> entityDataAtVersion12 = new EntityExportData<>();
    actualEntityVersionsDiff.setEntityDataAtVersion1(entityDataAtVersion12);
    EntityExportData<ExportableEntity<? extends EntityId>> entityDataAtVersion2 = new EntityExportData<>();
    actualEntityVersionsDiff.setEntityDataAtVersion2(entityDataAtVersion2);
    actualEntityVersionsDiff.setExternalId(TenantId.SYS_TENANT_ID);
    actualEntityVersionsDiff.setRawDiff("Raw Diff");
    String actualToStringResult = actualEntityVersionsDiff.toString();
    EntityExportData<?> actualEntityDataAtVersion1 = actualEntityVersionsDiff.getEntityDataAtVersion1();
    EntityExportData<?> actualEntityDataAtVersion2 = actualEntityVersionsDiff.getEntityDataAtVersion2();
    EntityId actualExternalId = actualEntityVersionsDiff.getExternalId();

    // Assert that nothing has changed
    assertEquals(
        "EntityVersionsDiff(externalId=13814000-1dd2-11b2-8080-808080808080, entityDataAtVersion1=EntityExportData"
            + "(entity=null, entityType=null, relations=null, attributes=null), entityDataAtVersion2=EntityExportData"
            + "(entity=null, entityType=null, relations=null, attributes=null), rawDiff=Raw Diff)",
        actualToStringResult);
    assertEquals("Raw Diff", actualEntityVersionsDiff.getRawDiff());
    assertSame(entityDataAtVersion12, actualEntityDataAtVersion1);
    assertSame(entityDataAtVersion2, actualEntityDataAtVersion2);
    assertSame(((TenantId) actualExternalId).SYS_TENANT_ID, actualExternalId);
  }
}
