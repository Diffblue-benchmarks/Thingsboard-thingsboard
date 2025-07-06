package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();
    EntityVersionsDiffBuilder builderResult2 = EntityVersionsDiff.builder();
    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        builderResult2.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult2 =
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityVersionsDiffBuilder entityVersionsDiffBuilder = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(EntityVersionsDiff.builder());
    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        entityVersionsDiffBuilder.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();
    EntityVersionsDiffBuilder entityVersionsDiffBuilder2 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder2.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(EntityVersionsDiff.builder());
    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        entityVersionsDiffBuilder2.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult2 =
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityVersionsDiffBuilder entityVersionsDiffBuilder = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder.entityDataAtVersion2(Mockito.<EntityExportData<?>>any()))
        .thenReturn(EntityVersionsDiff.builder());
    EntityVersionsDiffBuilder entityVersionsDiffBuilder2 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder2.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(entityVersionsDiffBuilder);
    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        entityVersionsDiffBuilder2.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();
    EntityVersionsDiffBuilder entityVersionsDiffBuilder3 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder3.entityDataAtVersion2(Mockito.<EntityExportData<?>>any()))
        .thenReturn(EntityVersionsDiff.builder());
    EntityVersionsDiffBuilder entityVersionsDiffBuilder4 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder4.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(entityVersionsDiffBuilder3);
    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        entityVersionsDiffBuilder4.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult2 =
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntityVersionsDiffBuilder entityVersionsDiffBuilder = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder.entityDataAtVersion2(Mockito.<EntityExportData<?>>any()))
        .thenReturn(EntityVersionsDiff.builder());
    EntityVersionsDiffBuilder entityVersionsDiffBuilder2 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder2.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(entityVersionsDiffBuilder);
    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        entityVersionsDiffBuilder2.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff(null)
            .build();
    EntityVersionsDiffBuilder entityVersionsDiffBuilder3 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder3.entityDataAtVersion2(Mockito.<EntityExportData<?>>any()))
        .thenReturn(EntityVersionsDiff.builder());
    EntityVersionsDiffBuilder entityVersionsDiffBuilder4 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder4.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(entityVersionsDiffBuilder3);
    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        entityVersionsDiffBuilder4.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult2 =
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff(null)
            .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityVersionsDiffBuilder entityVersionsDiffBuilder = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(EntityVersionsDiff.builder());
    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        entityVersionsDiffBuilder.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult2 =
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityVersionsDiffBuilder entityVersionsDiffBuilder = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(EntityVersionsDiff.builder());
    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        entityVersionsDiffBuilder.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(null)
            .rawDiff("Raw Diff")
            .build();
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult2 =
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityVersionsDiffBuilder entityVersionsDiffBuilder = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(EntityVersionsDiff.builder());
    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        entityVersionsDiffBuilder.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiffBuilder entityDataAtVersion2Result =
        entityDataAtVersion1Result.entityDataAtVersion2(new EntityExportData<>());
    EntityVersionsDiff buildResult =
        entityDataAtVersion2Result
            .externalId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .rawDiff("Raw Diff")
            .build();
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult2 =
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityVersionsDiffBuilder entityVersionsDiffBuilder = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder.entityDataAtVersion2(Mockito.<EntityExportData<?>>any()))
        .thenReturn(EntityVersionsDiff.builder());
    EntityVersionsDiffBuilder entityVersionsDiffBuilder2 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder2.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(entityVersionsDiffBuilder);
    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        entityVersionsDiffBuilder2.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();
    EntityVersionsDiffBuilder entityVersionsDiffBuilder3 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder3.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(EntityVersionsDiff.builder());
    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        entityVersionsDiffBuilder3.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult2 =
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityVersionsDiffBuilder entityVersionsDiffBuilder = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder.entityDataAtVersion2(Mockito.<EntityExportData<?>>any()))
        .thenReturn(EntityVersionsDiff.builder());
    EntityVersionsDiffBuilder entityVersionsDiffBuilder2 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder2.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(entityVersionsDiffBuilder);
    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        entityVersionsDiffBuilder2.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff(null)
            .build();
    EntityVersionsDiffBuilder entityVersionsDiffBuilder3 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder3.entityDataAtVersion2(Mockito.<EntityExportData<?>>any()))
        .thenReturn(EntityVersionsDiff.builder());
    EntityVersionsDiffBuilder entityVersionsDiffBuilder4 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder4.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(entityVersionsDiffBuilder3);
    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        entityVersionsDiffBuilder4.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult2 =
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityVersionsDiffBuilder entityVersionsDiffBuilder = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder.entityDataAtVersion2(Mockito.<EntityExportData<?>>any()))
        .thenReturn(EntityVersionsDiff.builder());
    EntityVersionsDiffBuilder entityVersionsDiffBuilder2 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder2.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(entityVersionsDiffBuilder);
    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        entityVersionsDiffBuilder2.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("42")
            .build();
    EntityVersionsDiffBuilder entityVersionsDiffBuilder3 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder3.entityDataAtVersion2(Mockito.<EntityExportData<?>>any()))
        .thenReturn(EntityVersionsDiff.builder());
    EntityVersionsDiffBuilder entityVersionsDiffBuilder4 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder4.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(entityVersionsDiffBuilder3);
    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        entityVersionsDiffBuilder4.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult2 =
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiffBuilder entityVersionsDiffBuilder = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder.entityDataAtVersion2(Mockito.<EntityExportData<?>>any()))
        .thenReturn(builderResult);
    EntityVersionsDiffBuilder entityVersionsDiffBuilder2 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder2.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(entityVersionsDiffBuilder);
    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        entityVersionsDiffBuilder2.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();
    EntityVersionsDiffBuilder entityVersionsDiffBuilder3 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder3.entityDataAtVersion2(Mockito.<EntityExportData<?>>any()))
        .thenReturn(EntityVersionsDiff.builder());
    EntityVersionsDiffBuilder entityVersionsDiffBuilder4 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder4.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(entityVersionsDiffBuilder3);
    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        entityVersionsDiffBuilder4.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult2 =
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    builderResult.entityDataAtVersion2(new EntityExportData<>());
    EntityVersionsDiffBuilder entityVersionsDiffBuilder = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder.entityDataAtVersion2(Mockito.<EntityExportData<?>>any()))
        .thenReturn(builderResult);
    EntityVersionsDiffBuilder entityVersionsDiffBuilder2 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder2.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(entityVersionsDiffBuilder);
    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        entityVersionsDiffBuilder2.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();
    EntityVersionsDiffBuilder entityVersionsDiffBuilder3 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder3.entityDataAtVersion2(Mockito.<EntityExportData<?>>any()))
        .thenReturn(EntityVersionsDiff.builder());
    EntityVersionsDiffBuilder entityVersionsDiffBuilder4 = mock(EntityVersionsDiffBuilder.class);
    when(entityVersionsDiffBuilder4.entityDataAtVersion1(Mockito.<EntityExportData<?>>any()))
        .thenReturn(entityVersionsDiffBuilder3);
    EntityVersionsDiffBuilder entityDataAtVersion1Result2 =
        entityVersionsDiffBuilder4.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult2 =
        entityDataAtVersion1Result2
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityVersionsDiff.equals(Object)",
    "int EntityVersionsDiff.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityVersionsDiffBuilder builderResult = EntityVersionsDiff.builder();
    EntityVersionsDiffBuilder entityDataAtVersion1Result =
        builderResult.entityDataAtVersion1(new EntityExportData<>());
    EntityVersionsDiff buildResult =
        entityDataAtVersion1Result
            .entityDataAtVersion2(new EntityExportData<>())
            .externalId(TenantId.SYS_TENANT_ID)
            .rawDiff("Raw Diff")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EntityVersionsDiff");
  }
}
