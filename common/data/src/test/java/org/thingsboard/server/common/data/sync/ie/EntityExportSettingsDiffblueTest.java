package org.thingsboard.server.common.data.sync.ie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.sync.ie.EntityExportSettings.EntityExportSettingsBuilder;

@ContextConfiguration(classes = {EntityExportSettingsBuilder.class})
@ExtendWith(SpringExtension.class)
class EntityExportSettingsDiffblueTest {
  @Autowired private EntityExportSettingsBuilder entityExportSettingsBuilder;

  /**
   * Test EntityExportSettingsBuilder {@link EntityExportSettingsBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityExportSettingsBuilder#build()}
   *   <li>{@link EntityExportSettingsBuilder#exportAttributes(boolean)}
   *   <li>{@link EntityExportSettingsBuilder#exportCredentials(boolean)}
   *   <li>{@link EntityExportSettingsBuilder#exportRelations(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test EntityExportSettingsBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EntityExportSettingsBuilder.<init>()",
    "EntityExportSettings EntityExportSettingsBuilder.build()",
    "EntityExportSettingsBuilder EntityExportSettingsBuilder.exportAttributes(boolean)",
    "EntityExportSettingsBuilder EntityExportSettingsBuilder.exportCredentials(boolean)",
    "EntityExportSettingsBuilder EntityExportSettingsBuilder.exportRelations(boolean)",
    "String EntityExportSettingsBuilder.toString()"
  })
  void testEntityExportSettingsBuilderBuild() {
    // Arrange and Act
    EntityExportSettings actualBuildResult =
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(true)
            .build();

    // Assert
    assertTrue(actualBuildResult.isExportAttributes());
    assertTrue(actualBuildResult.isExportCredentials());
    assertTrue(actualBuildResult.isExportRelations());
  }

  /**
   * Test {@link EntityExportSettings#equals(Object)}, and {@link EntityExportSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityExportSettings#equals(Object)}
   *   <li>{@link EntityExportSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityExportSettings.equals(Object)",
    "int EntityExportSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityExportSettings buildResult =
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(true)
            .build();
    EntityExportSettings buildResult2 =
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(true)
            .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link EntityExportSettings#equals(Object)}, and {@link EntityExportSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityExportSettings#equals(Object)}
   *   <li>{@link EntityExportSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityExportSettings.equals(Object)",
    "int EntityExportSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityExportSettings buildResult =
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(true)
            .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link EntityExportSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityExportSettings.equals(Object)",
    "int EntityExportSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityExportSettingsBuilder entityExportSettingsBuilder =
        mock(EntityExportSettingsBuilder.class);
    when(entityExportSettingsBuilder.exportAttributes(anyBoolean()))
        .thenReturn(EntityExportSettings.builder());
    EntityExportSettings buildResult =
        entityExportSettingsBuilder
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(true)
            .build();
    EntityExportSettings buildResult2 =
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(true)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityExportSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityExportSettings.equals(Object)",
    "int EntityExportSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityExportSettingsBuilder entityExportSettingsBuilder =
        mock(EntityExportSettingsBuilder.class);
    when(entityExportSettingsBuilder.exportAttributes(anyBoolean()))
        .thenReturn(EntityExportSettings.builder());
    EntityExportSettings buildResult =
        entityExportSettingsBuilder
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(false)
            .build();
    EntityExportSettings buildResult2 =
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(true)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityExportSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityExportSettings.equals(Object)",
    "int EntityExportSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityExportSettingsBuilder entityExportSettingsBuilder =
        mock(EntityExportSettingsBuilder.class);
    when(entityExportSettingsBuilder.exportAttributes(anyBoolean()))
        .thenReturn(EntityExportSettings.builder());
    EntityExportSettings buildResult =
        entityExportSettingsBuilder
            .exportAttributes(true)
            .exportCredentials(false)
            .exportRelations(true)
            .build();
    EntityExportSettings buildResult2 =
        EntityExportSettings.builder()
            .exportAttributes(false)
            .exportCredentials(true)
            .exportRelations(true)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityExportSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityExportSettings.equals(Object)",
    "int EntityExportSettings.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityExportSettings buildResult =
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(true)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link EntityExportSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityExportSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntityExportSettings.equals(Object)",
    "int EntityExportSettings.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityExportSettings buildResult =
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(true)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EntityExportSettings");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityExportSettings#EntityExportSettings()}
   *   <li>{@link EntityExportSettings#setExportAttributes(boolean)}
   *   <li>{@link EntityExportSettings#setExportCredentials(boolean)}
   *   <li>{@link EntityExportSettings#setExportRelations(boolean)}
   *   <li>{@link EntityExportSettings#toString()}
   *   <li>{@link EntityExportSettings#isExportAttributes()}
   *   <li>{@link EntityExportSettings#isExportCredentials()}
   *   <li>{@link EntityExportSettings#isExportRelations()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EntityExportSettings.<init>()",
    "void EntityExportSettings.<init>(boolean, boolean, boolean)",
    "boolean EntityExportSettings.isExportAttributes()",
    "boolean EntityExportSettings.isExportCredentials()",
    "boolean EntityExportSettings.isExportRelations()",
    "void EntityExportSettings.setExportAttributes(boolean)",
    "void EntityExportSettings.setExportCredentials(boolean)",
    "void EntityExportSettings.setExportRelations(boolean)",
    "String EntityExportSettings.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityExportSettings actualEntityExportSettings = new EntityExportSettings();
    actualEntityExportSettings.setExportAttributes(true);
    actualEntityExportSettings.setExportCredentials(true);
    actualEntityExportSettings.setExportRelations(true);
    String actualToStringResult = actualEntityExportSettings.toString();
    boolean actualIsExportAttributesResult = actualEntityExportSettings.isExportAttributes();
    boolean actualIsExportCredentialsResult = actualEntityExportSettings.isExportCredentials();

    // Assert
    assertEquals(
        "EntityExportSettings(exportRelations=true, exportAttributes=true, exportCredentials=true)",
        actualToStringResult);
    assertTrue(actualIsExportAttributesResult);
    assertTrue(actualIsExportCredentialsResult);
    assertTrue(actualEntityExportSettings.isExportRelations());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityExportSettings#EntityExportSettings(boolean, boolean, boolean)}
   *   <li>{@link EntityExportSettings#setExportAttributes(boolean)}
   *   <li>{@link EntityExportSettings#setExportCredentials(boolean)}
   *   <li>{@link EntityExportSettings#setExportRelations(boolean)}
   *   <li>{@link EntityExportSettings#toString()}
   *   <li>{@link EntityExportSettings#isExportAttributes()}
   *   <li>{@link EntityExportSettings#isExportCredentials()}
   *   <li>{@link EntityExportSettings#isExportRelations()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EntityExportSettings.<init>()",
    "void EntityExportSettings.<init>(boolean, boolean, boolean)",
    "boolean EntityExportSettings.isExportAttributes()",
    "boolean EntityExportSettings.isExportCredentials()",
    "boolean EntityExportSettings.isExportRelations()",
    "void EntityExportSettings.setExportAttributes(boolean)",
    "void EntityExportSettings.setExportCredentials(boolean)",
    "void EntityExportSettings.setExportRelations(boolean)",
    "String EntityExportSettings.toString()"
  })
  void testGettersAndSetters_whenTrue() {
    // Arrange and Act
    EntityExportSettings actualEntityExportSettings = new EntityExportSettings(true, true, true);
    actualEntityExportSettings.setExportAttributes(true);
    actualEntityExportSettings.setExportCredentials(true);
    actualEntityExportSettings.setExportRelations(true);
    String actualToStringResult = actualEntityExportSettings.toString();
    boolean actualIsExportAttributesResult = actualEntityExportSettings.isExportAttributes();
    boolean actualIsExportCredentialsResult = actualEntityExportSettings.isExportCredentials();

    // Assert
    assertEquals(
        "EntityExportSettings(exportRelations=true, exportAttributes=true, exportCredentials=true)",
        actualToStringResult);
    assertTrue(actualIsExportAttributesResult);
    assertTrue(actualIsExportCredentialsResult);
    assertTrue(actualEntityExportSettings.isExportRelations());
  }
}
