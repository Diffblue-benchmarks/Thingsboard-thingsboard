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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.vc.EntityVersionsDiff.EntityVersionsDiffBuilder;

@ContextConfiguration(classes = {EntityVersionsDiffBuilder.class})
@ExtendWith(SpringExtension.class)
class EntityVersionsDiffDiffblueTest {
  @Autowired
  private EntityVersionsDiffBuilder entityVersionsDiffBuilder;

  /**
   * Test EntityVersionsDiffBuilder {@link EntityVersionsDiffBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityVersionsDiffBuilder#build()}
   *   <li>{@link EntityVersionsDiffBuilder#entityDataAtVersion1(EntityExportData)}
   *   <li>{@link EntityVersionsDiffBuilder#entityDataAtVersion2(EntityExportData)}
   *   <li>{@link EntityVersionsDiffBuilder#externalId(EntityId)}
   *   <li>{@link EntityVersionsDiffBuilder#rawDiff(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test EntityVersionsDiffBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityVersionsDiffBuilder.<init>()", "EntityVersionsDiff EntityVersionsDiffBuilder.build()",
      "EntityVersionsDiffBuilder EntityVersionsDiffBuilder.entityDataAtVersion1(EntityExportData)",
      "EntityVersionsDiffBuilder EntityVersionsDiffBuilder.entityDataAtVersion2(EntityExportData)",
      "EntityVersionsDiffBuilder EntityVersionsDiffBuilder.externalId(EntityId)",
      "EntityVersionsDiffBuilder EntityVersionsDiffBuilder.rawDiff(String)",
      "String EntityVersionsDiffBuilder.toString()"})
  void testEntityVersionsDiffBuilderBuild() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityExportData<ExportableEntity<? extends EntityId>> entityDataAtVersion1 = new EntityExportData<>();
    EntityVersionsDiffBuilder entityDataAtVersion1Result = builderResult.entityDataAtVersion1(entityDataAtVersion1);
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
   * Test {@link EntityVersionsDiff#equals(Object)}, and {@link EntityVersionsDiff#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityVersionsDiff#equals(Object)}
   *   <li>{@link EntityVersionsDiff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityVersionsDiff.equals(Object)", "int EntityVersionsDiff.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityVersionsDiffBuilder entityDataAtVersion1Result = builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult = entityDataAtVersion1Result.entityDataAtVersion2(new EntityExportData<>())
        .externalId(TenantId.SYS_TENANT_ID)
        .rawDiff("Raw Diff")
        .build();
    EntityVersionsDiffBuilder builderResult2 = EntityVersionsDiff.builder();
    EntityVersionsDiffBuilder entityDataAtVersion1Result2 = builderResult2
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
   * Test {@link EntityVersionsDiff#equals(Object)}, and {@link EntityVersionsDiff#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityVersionsDiff#equals(Object)}
   *   <li>{@link EntityVersionsDiff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityVersionsDiff.equals(Object)", "int EntityVersionsDiff.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityVersionsDiffBuilder entityDataAtVersion1Result = builderResult.entityDataAtVersion1(new EntityExportData<>());
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
   * Test {@link EntityVersionsDiff#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityVersionsDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityVersionsDiff.equals(Object)", "int EntityVersionsDiff.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityVersionsDiffBuilder entityDataAtVersion1Result = builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult = entityDataAtVersion1Result.entityDataAtVersion2(new EntityExportData<>())
        .externalId(TenantId.SYS_TENANT_ID)
        .rawDiff("Raw Diff")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link EntityVersionsDiff#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityVersionsDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityVersionsDiff.equals(Object)", "int EntityVersionsDiff.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityVersionsDiffBuilder entityDataAtVersion1Result = builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult = entityDataAtVersion1Result.entityDataAtVersion2(new EntityExportData<>())
        .externalId(TenantId.SYS_TENANT_ID)
        .rawDiff("Raw Diff")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EntityVersionsDiff");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityVersionsDiff.<init>()",
      "void EntityVersionsDiff.<init>(EntityId, EntityExportData, EntityExportData, String)",
      "EntityExportData EntityVersionsDiff.getEntityDataAtVersion1()",
      "EntityExportData EntityVersionsDiff.getEntityDataAtVersion2()", "EntityId EntityVersionsDiff.getExternalId()",
      "String EntityVersionsDiff.getRawDiff()", "void EntityVersionsDiff.setEntityDataAtVersion1(EntityExportData)",
      "void EntityVersionsDiff.setEntityDataAtVersion2(EntityExportData)",
      "void EntityVersionsDiff.setExternalId(EntityId)", "void EntityVersionsDiff.setRawDiff(String)",
      "String EntityVersionsDiff.toString()"})
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

    // Assert
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityVersionsDiff#EntityVersionsDiff(EntityId, EntityExportData, EntityExportData, String)}
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
  @DisplayName("Test getters and setters; when SYS_TENANT_ID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityVersionsDiff.<init>()",
      "void EntityVersionsDiff.<init>(EntityId, EntityExportData, EntityExportData, String)",
      "EntityExportData EntityVersionsDiff.getEntityDataAtVersion1()",
      "EntityExportData EntityVersionsDiff.getEntityDataAtVersion2()", "EntityId EntityVersionsDiff.getExternalId()",
      "String EntityVersionsDiff.getRawDiff()", "void EntityVersionsDiff.setEntityDataAtVersion1(EntityExportData)",
      "void EntityVersionsDiff.setEntityDataAtVersion2(EntityExportData)",
      "void EntityVersionsDiff.setExternalId(EntityId)", "void EntityVersionsDiff.setRawDiff(String)",
      "String EntityVersionsDiff.toString()"})
  void testGettersAndSetters_whenSys_tenant_id() {
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

    // Assert
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
