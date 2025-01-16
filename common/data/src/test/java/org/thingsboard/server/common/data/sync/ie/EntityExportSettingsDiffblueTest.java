package org.thingsboard.server.common.data.sync.ie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.sync.ie.EntityExportSettings.EntityExportSettingsBuilder;

class EntityExportSettingsDiffblueTest {
  /**
   * Test EntityExportSettingsBuilder {@link EntityExportSettingsBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityExportSettings.EntityExportSettingsBuilder#build()}
   *   <li>
   * {@link EntityExportSettings.EntityExportSettingsBuilder#exportAttributes(boolean)}
   *   <li>
   * {@link EntityExportSettings.EntityExportSettingsBuilder#exportCredentials(boolean)}
   *   <li>
   * {@link EntityExportSettings.EntityExportSettingsBuilder#exportRelations(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test EntityExportSettingsBuilder build()")
  void testEntityExportSettingsBuilderBuild() {
    // Arrange and Act
    EntityExportSettings actualBuildResult = EntityExportSettings.builder()
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
   * Test {@link EntityExportSettings#equals(Object)}, and
   * {@link EntityExportSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityExportSettings#equals(Object)}
   *   <li>{@link EntityExportSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityExportSettings buildResult = EntityExportSettings.builder()
        .exportAttributes(true)
        .exportCredentials(true)
        .exportRelations(true)
        .build();
    EntityExportSettings buildResult2 = EntityExportSettings.builder()
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
   * Test {@link EntityExportSettings#equals(Object)}, and
   * {@link EntityExportSettings#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityExportSettings#equals(Object)}
   *   <li>{@link EntityExportSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityExportSettings buildResult = EntityExportSettings.builder()
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityExportSettings.EntityExportSettingsBuilder entityExportSettingsBuilder = mock(
        EntityExportSettings.EntityExportSettingsBuilder.class);
    when(entityExportSettingsBuilder.exportAttributes(anyBoolean())).thenReturn(EntityExportSettings.builder());
    EntityExportSettings buildResult = entityExportSettingsBuilder.exportAttributes(true)
        .exportCredentials(true)
        .exportRelations(true)
        .build();
    EntityExportSettings buildResult2 = EntityExportSettings.builder()
        .exportAttributes(true)
        .exportCredentials(true)
        .exportRelations(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityExportSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityExportSettings.EntityExportSettingsBuilder entityExportSettingsBuilder = mock(
        EntityExportSettings.EntityExportSettingsBuilder.class);
    when(entityExportSettingsBuilder.exportAttributes(anyBoolean())).thenReturn(EntityExportSettings.builder());
    EntityExportSettings buildResult = entityExportSettingsBuilder.exportAttributes(true)
        .exportCredentials(true)
        .exportRelations(false)
        .build();
    EntityExportSettings buildResult2 = EntityExportSettings.builder()
        .exportAttributes(true)
        .exportCredentials(true)
        .exportRelations(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityExportSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityExportSettings.EntityExportSettingsBuilder entityExportSettingsBuilder = mock(
        EntityExportSettings.EntityExportSettingsBuilder.class);
    when(entityExportSettingsBuilder.exportAttributes(anyBoolean())).thenReturn(EntityExportSettings.builder());
    EntityExportSettings buildResult = entityExportSettingsBuilder.exportAttributes(true)
        .exportCredentials(false)
        .exportRelations(true)
        .build();
    EntityExportSettings buildResult2 = EntityExportSettings.builder()
        .exportAttributes(false)
        .exportCredentials(true)
        .exportRelations(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityExportSettings#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityExportSettings buildResult = EntityExportSettings.builder()
        .exportAttributes(true)
        .exportCredentials(true)
        .exportRelations(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link EntityExportSettings#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityExportSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityExportSettings buildResult = EntityExportSettings.builder()
        .exportAttributes(true)
        .exportCredentials(true)
        .exportRelations(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EntityExportSettings");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange and Act
    EntityExportSettings actualEntityExportSettings = new EntityExportSettings();
    actualEntityExportSettings.setExportAttributes(true);
    actualEntityExportSettings.setExportCredentials(true);
    actualEntityExportSettings.setExportRelations(true);
    String actualToStringResult = actualEntityExportSettings.toString();
    boolean actualIsExportAttributesResult = actualEntityExportSettings.isExportAttributes();
    boolean actualIsExportCredentialsResult = actualEntityExportSettings.isExportCredentials();

    // Assert that nothing has changed
    assertEquals("EntityExportSettings(exportRelations=true, exportAttributes=true, exportCredentials=true)",
        actualToStringResult);
    assertTrue(actualIsExportAttributesResult);
    assertTrue(actualIsExportCredentialsResult);
    assertTrue(actualEntityExportSettings.isExportRelations());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityExportSettings#EntityExportSettings(boolean, boolean, boolean)}
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
  void testGettersAndSetters_whenTrue() {
    // Arrange and Act
    EntityExportSettings actualEntityExportSettings = new EntityExportSettings(true, true, true);
    actualEntityExportSettings.setExportAttributes(true);
    actualEntityExportSettings.setExportCredentials(true);
    actualEntityExportSettings.setExportRelations(true);
    String actualToStringResult = actualEntityExportSettings.toString();
    boolean actualIsExportAttributesResult = actualEntityExportSettings.isExportAttributes();
    boolean actualIsExportCredentialsResult = actualEntityExportSettings.isExportCredentials();

    // Assert that nothing has changed
    assertEquals("EntityExportSettings(exportRelations=true, exportAttributes=true, exportCredentials=true)",
        actualToStringResult);
    assertTrue(actualIsExportAttributesResult);
    assertTrue(actualIsExportCredentialsResult);
    assertTrue(actualEntityExportSettings.isExportRelations());
  }
}
