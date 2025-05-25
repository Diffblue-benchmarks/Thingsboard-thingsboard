package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.vc.EntityVersionsDiff.EntityVersionsDiffBuilder;

class EntityVersionsDiffDiffblueTest {
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
}
