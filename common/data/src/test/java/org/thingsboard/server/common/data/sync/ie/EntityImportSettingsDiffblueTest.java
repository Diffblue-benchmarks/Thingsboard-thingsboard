package org.thingsboard.server.common.data.sync.ie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.sync.ie.EntityImportSettings.EntityImportSettingsBuilder;

class EntityImportSettingsDiffblueTest {
  /**
   * Test EntityImportSettingsBuilder {@link EntityImportSettingsBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityImportSettings.EntityImportSettingsBuilder#build()}
   *   <li>
   * {@link EntityImportSettings.EntityImportSettingsBuilder#saveAttributes(boolean)}
   *   <li>
   * {@link EntityImportSettings.EntityImportSettingsBuilder#saveCredentials(boolean)}
   *   <li>
   * {@link EntityImportSettings.EntityImportSettingsBuilder#updateRelations(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test EntityImportSettingsBuilder build()")
  void testEntityImportSettingsBuilderBuild() {
    // Arrange and Act
    EntityImportSettings actualBuildResult = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();

    // Assert
    assertFalse(actualBuildResult.isFindExistingByName());
    assertTrue(actualBuildResult.isSaveAttributes());
    assertTrue(actualBuildResult.isSaveCredentials());
    assertTrue(actualBuildResult.isUpdateRelations());
  }

  /**
   * Test {@link EntityImportSettings#equals(Object)}, and
   * {@link EntityImportSettings#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityImportSettings#equals(Object)}
   *   <li>{@link EntityImportSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityImportSettings buildResult = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    EntityImportSettings buildResult2 = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link EntityImportSettings#equals(Object)}, and
   * {@link EntityImportSettings#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityImportSettings#equals(Object)}
   *   <li>{@link EntityImportSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityImportSettings buildResult = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link EntityImportSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityImportSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityImportSettings.EntityImportSettingsBuilder entityImportSettingsBuilder = mock(
        EntityImportSettings.EntityImportSettingsBuilder.class);
    when(entityImportSettingsBuilder.saveAttributes(anyBoolean())).thenReturn(EntityImportSettings.builder());
    EntityImportSettings buildResult = entityImportSettingsBuilder.saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    EntityImportSettings buildResult2 = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityImportSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityImportSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityImportSettings.EntityImportSettingsBuilder entityImportSettingsBuilder = mock(
        EntityImportSettings.EntityImportSettingsBuilder.class);
    when(entityImportSettingsBuilder.saveAttributes(anyBoolean())).thenReturn(EntityImportSettings.builder());
    EntityImportSettings buildResult = entityImportSettingsBuilder.saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(false)
        .build();
    EntityImportSettings buildResult2 = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityImportSettings#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityImportSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityImportSettings.EntityImportSettingsBuilder entityImportSettingsBuilder = mock(
        EntityImportSettings.EntityImportSettingsBuilder.class);
    when(entityImportSettingsBuilder.saveAttributes(anyBoolean())).thenReturn(EntityImportSettings.builder());
    EntityImportSettings buildResult = entityImportSettingsBuilder.saveAttributes(true)
        .saveCredentials(false)
        .updateRelations(true)
        .build();
    EntityImportSettings buildResult2 = EntityImportSettings.builder()
        .saveAttributes(false)
        .saveCredentials(true)
        .updateRelations(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityImportSettings#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityImportSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityImportSettings buildResult = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link EntityImportSettings#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityImportSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityImportSettings buildResult = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EntityImportSettings");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityImportSettings#EntityImportSettings()}
   *   <li>{@link EntityImportSettings#setFindExistingByName(boolean)}
   *   <li>{@link EntityImportSettings#setSaveAttributes(boolean)}
   *   <li>{@link EntityImportSettings#setSaveCredentials(boolean)}
   *   <li>{@link EntityImportSettings#setUpdateRelations(boolean)}
   *   <li>{@link EntityImportSettings#toString()}
   *   <li>{@link EntityImportSettings#isFindExistingByName()}
   *   <li>{@link EntityImportSettings#isSaveAttributes()}
   *   <li>{@link EntityImportSettings#isSaveCredentials()}
   *   <li>{@link EntityImportSettings#isUpdateRelations()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    EntityImportSettings actualEntityImportSettings = new EntityImportSettings();
    actualEntityImportSettings.setFindExistingByName(true);
    actualEntityImportSettings.setSaveAttributes(true);
    actualEntityImportSettings.setSaveCredentials(true);
    actualEntityImportSettings.setUpdateRelations(true);
    String actualToStringResult = actualEntityImportSettings.toString();
    boolean actualIsFindExistingByNameResult = actualEntityImportSettings.isFindExistingByName();
    boolean actualIsSaveAttributesResult = actualEntityImportSettings.isSaveAttributes();
    boolean actualIsSaveCredentialsResult = actualEntityImportSettings.isSaveCredentials();

    // Assert that nothing has changed
    assertEquals(
        "EntityImportSettings(findExistingByName=true, updateRelations=true, saveAttributes=true, saveCredentials"
            + "=true)",
        actualToStringResult);
    assertTrue(actualIsFindExistingByNameResult);
    assertTrue(actualIsSaveAttributesResult);
    assertTrue(actualIsSaveCredentialsResult);
    assertTrue(actualEntityImportSettings.isUpdateRelations());
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
   * {@link EntityImportSettings#EntityImportSettings(boolean, boolean, boolean, boolean)}
   *   <li>{@link EntityImportSettings#setFindExistingByName(boolean)}
   *   <li>{@link EntityImportSettings#setSaveAttributes(boolean)}
   *   <li>{@link EntityImportSettings#setSaveCredentials(boolean)}
   *   <li>{@link EntityImportSettings#setUpdateRelations(boolean)}
   *   <li>{@link EntityImportSettings#toString()}
   *   <li>{@link EntityImportSettings#isFindExistingByName()}
   *   <li>{@link EntityImportSettings#isSaveAttributes()}
   *   <li>{@link EntityImportSettings#isSaveCredentials()}
   *   <li>{@link EntityImportSettings#isUpdateRelations()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'")
  void testGettersAndSetters_whenTrue() {
    // Arrange and Act
    EntityImportSettings actualEntityImportSettings = new EntityImportSettings(true, true, true, true);
    actualEntityImportSettings.setFindExistingByName(true);
    actualEntityImportSettings.setSaveAttributes(true);
    actualEntityImportSettings.setSaveCredentials(true);
    actualEntityImportSettings.setUpdateRelations(true);
    String actualToStringResult = actualEntityImportSettings.toString();
    boolean actualIsFindExistingByNameResult = actualEntityImportSettings.isFindExistingByName();
    boolean actualIsSaveAttributesResult = actualEntityImportSettings.isSaveAttributes();
    boolean actualIsSaveCredentialsResult = actualEntityImportSettings.isSaveCredentials();

    // Assert that nothing has changed
    assertEquals(
        "EntityImportSettings(findExistingByName=true, updateRelations=true, saveAttributes=true, saveCredentials"
            + "=true)",
        actualToStringResult);
    assertTrue(actualIsFindExistingByNameResult);
    assertTrue(actualIsSaveAttributesResult);
    assertTrue(actualIsSaveCredentialsResult);
    assertTrue(actualEntityImportSettings.isUpdateRelations());
  }
}
