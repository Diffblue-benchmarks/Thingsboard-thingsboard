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
package org.thingsboard.server.common.data.sync.ie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import org.thingsboard.server.common.data.sync.ie.EntityImportSettings.EntityImportSettingsBuilder;

@ContextConfiguration(classes = {EntityImportSettingsBuilder.class})
@ExtendWith(SpringExtension.class)
class EntityImportSettingsDiffblueTest {
  @Autowired
  private EntityImportSettingsBuilder entityImportSettingsBuilder;

  /**
   * Test EntityImportSettingsBuilder {@link EntityImportSettingsBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityImportSettingsBuilder#build()}
   *   <li>{@link EntityImportSettingsBuilder#saveAttributes(boolean)}
   *   <li>{@link EntityImportSettingsBuilder#saveCredentials(boolean)}
   *   <li>{@link EntityImportSettingsBuilder#updateRelations(boolean)}
   * </ul>
   */
  @Test
  @DisplayName("Test EntityImportSettingsBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityImportSettingsBuilder.<init>()",
      "EntityImportSettings EntityImportSettingsBuilder.build()",
      "EntityImportSettingsBuilder EntityImportSettingsBuilder.findExistingByName(boolean)",
      "EntityImportSettingsBuilder EntityImportSettingsBuilder.saveAttributes(boolean)",
      "EntityImportSettingsBuilder EntityImportSettingsBuilder.saveCredentials(boolean)",
      "String EntityImportSettingsBuilder.toString()",
      "EntityImportSettingsBuilder EntityImportSettingsBuilder.updateRelations(boolean)"})
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
   * Test {@link EntityImportSettings#equals(Object)}, and {@link EntityImportSettings#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityImportSettings.equals(Object)", "int EntityImportSettings.hashCode()"})
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
   * Test {@link EntityImportSettings#equals(Object)}, and {@link EntityImportSettings#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityImportSettings.equals(Object)", "int EntityImportSettings.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityImportSettings.equals(Object)", "int EntityImportSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityImportSettingsBuilder entityImportSettingsBuilder = mock(EntityImportSettingsBuilder.class);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityImportSettings.equals(Object)", "int EntityImportSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityImportSettingsBuilder entityImportSettingsBuilder = mock(EntityImportSettingsBuilder.class);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityImportSettings.equals(Object)", "int EntityImportSettings.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityImportSettingsBuilder entityImportSettingsBuilder = mock(EntityImportSettingsBuilder.class);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityImportSettings.equals(Object)", "int EntityImportSettings.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityImportSettings.equals(Object)", "int EntityImportSettings.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityImportSettings.<init>()",
      "void EntityImportSettings.<init>(boolean, boolean, boolean, boolean)",
      "boolean EntityImportSettings.isFindExistingByName()", "boolean EntityImportSettings.isSaveAttributes()",
      "boolean EntityImportSettings.isSaveCredentials()", "boolean EntityImportSettings.isUpdateRelations()",
      "void EntityImportSettings.setFindExistingByName(boolean)",
      "void EntityImportSettings.setSaveAttributes(boolean)", "void EntityImportSettings.setSaveCredentials(boolean)",
      "void EntityImportSettings.setUpdateRelations(boolean)", "String EntityImportSettings.toString()"})
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

    // Assert
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
   *   <li>{@link EntityImportSettings#EntityImportSettings(boolean, boolean, boolean, boolean)}
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityImportSettings.<init>()",
      "void EntityImportSettings.<init>(boolean, boolean, boolean, boolean)",
      "boolean EntityImportSettings.isFindExistingByName()", "boolean EntityImportSettings.isSaveAttributes()",
      "boolean EntityImportSettings.isSaveCredentials()", "boolean EntityImportSettings.isUpdateRelations()",
      "void EntityImportSettings.setFindExistingByName(boolean)",
      "void EntityImportSettings.setSaveAttributes(boolean)", "void EntityImportSettings.setSaveCredentials(boolean)",
      "void EntityImportSettings.setUpdateRelations(boolean)", "String EntityImportSettings.toString()"})
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

    // Assert
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
