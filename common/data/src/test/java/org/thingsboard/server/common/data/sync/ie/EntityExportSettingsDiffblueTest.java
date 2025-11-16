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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    EntityExportSettings actualEntityExportSettings =
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(true)
            .build();

    // Assert
    assertTrue(actualEntityExportSettings.isExportAttributes());
    assertTrue(actualEntityExportSettings.isExportCredentials());
    assertTrue(actualEntityExportSettings.isExportRelations());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityExportSettings.equals(Object)",
    "int EntityExportSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityExportSettings entityExportSettings =
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(true)
            .build();
    EntityExportSettings entityExportSettings2 =
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(true)
            .build();

    // Act and Assert
    assertEquals(entityExportSettings, entityExportSettings2);
    assertEquals(entityExportSettings.hashCode(), entityExportSettings2.hashCode());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityExportSettings.equals(Object)",
    "int EntityExportSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityExportSettings entityExportSettings =
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(true)
            .build();

    // Act and Assert
    assertEquals(entityExportSettings, entityExportSettings);
    int expectedHashCodeResult = entityExportSettings.hashCode();
    assertEquals(expectedHashCodeResult, entityExportSettings.hashCode());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityExportSettings.equals(Object)",
    "int EntityExportSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityExportSettings entityExportSettings =
        EntityExportSettings.builder()
            .exportAttributes(false)
            .exportCredentials(true)
            .exportRelations(true)
            .build();

    // Act and Assert
    assertNotEquals(
        entityExportSettings,
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(true)
            .build());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityExportSettings.equals(Object)",
    "int EntityExportSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityExportSettings entityExportSettings =
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(false)
            .exportRelations(true)
            .build();

    // Act and Assert
    assertNotEquals(
        entityExportSettings,
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(true)
            .build());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityExportSettings.equals(Object)",
    "int EntityExportSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityExportSettings entityExportSettings =
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(false)
            .build();

    // Act and Assert
    assertNotEquals(
        entityExportSettings,
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(true)
            .build());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityExportSettings.equals(Object)",
    "int EntityExportSettings.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(true)
            .build(),
        null);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityExportSettings.equals(Object)",
    "int EntityExportSettings.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        EntityExportSettings.builder()
            .exportAttributes(true)
            .exportCredentials(true)
            .exportRelations(true)
            .build(),
        "Different type to EntityExportSettings");
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
