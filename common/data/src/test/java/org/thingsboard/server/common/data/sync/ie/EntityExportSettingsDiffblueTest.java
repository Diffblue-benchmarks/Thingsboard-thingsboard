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
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class EntityExportSettingsDiffblueTest {
  /**
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
   * Methods under test:
   * <ul>
   *   <li>{@link EntityExportSettings#equals(Object)}
   *   <li>{@link EntityExportSettings#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link EntityExportSettings#equals(Object)}
   *   <li>{@link EntityExportSettings#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link EntityExportSettings#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityExportSettings#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityExportSettings#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityExportSettings#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityExportSettings#equals(Object)}
   */
  @Test
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
  void testGettersAndSetters2() {
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
