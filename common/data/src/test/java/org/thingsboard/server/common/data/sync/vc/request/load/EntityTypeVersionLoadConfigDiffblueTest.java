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
package org.thingsboard.server.common.data.sync.vc.request.load;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class EntityTypeVersionLoadConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeVersionLoadConfig#equals(Object)}
   *   <li>{@link EntityTypeVersionLoadConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);

    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig2 = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig2.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig2.setLoadAttributes(true);
    entityTypeVersionLoadConfig2.setLoadCredentials(true);
    entityTypeVersionLoadConfig2.setLoadRelations(true);
    entityTypeVersionLoadConfig2.setRemoveOtherEntities(true);

    // Act and Assert
    assertEquals(entityTypeVersionLoadConfig, entityTypeVersionLoadConfig2);
    int expectedHashCodeResult = entityTypeVersionLoadConfig.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeVersionLoadConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeVersionLoadConfig#equals(Object)}
   *   <li>{@link EntityTypeVersionLoadConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);

    // Act and Assert
    assertEquals(entityTypeVersionLoadConfig, entityTypeVersionLoadConfig);
    int expectedHashCodeResult = entityTypeVersionLoadConfig.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeVersionLoadConfig.hashCode());
  }

  /**
   * Method under test: {@link EntityTypeVersionLoadConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(false);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);

    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig2 = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig2.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig2.setLoadAttributes(true);
    entityTypeVersionLoadConfig2.setLoadCredentials(true);
    entityTypeVersionLoadConfig2.setLoadRelations(true);
    entityTypeVersionLoadConfig2.setRemoveOtherEntities(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadConfig, entityTypeVersionLoadConfig2);
  }

  /**
   * Method under test: {@link EntityTypeVersionLoadConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(false);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);

    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig2 = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig2.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig2.setLoadAttributes(true);
    entityTypeVersionLoadConfig2.setLoadCredentials(true);
    entityTypeVersionLoadConfig2.setLoadRelations(true);
    entityTypeVersionLoadConfig2.setRemoveOtherEntities(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadConfig, entityTypeVersionLoadConfig2);
  }

  /**
   * Method under test: {@link EntityTypeVersionLoadConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(false);

    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig2 = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig2.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig2.setLoadAttributes(true);
    entityTypeVersionLoadConfig2.setLoadCredentials(true);
    entityTypeVersionLoadConfig2.setLoadRelations(true);
    entityTypeVersionLoadConfig2.setRemoveOtherEntities(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadConfig, entityTypeVersionLoadConfig2);
  }

  /**
   * Method under test: {@link EntityTypeVersionLoadConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadConfig, null);
  }

  /**
   * Method under test: {@link EntityTypeVersionLoadConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityTypeVersionLoadConfig entityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    entityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    entityTypeVersionLoadConfig.setLoadAttributes(true);
    entityTypeVersionLoadConfig.setLoadCredentials(true);
    entityTypeVersionLoadConfig.setLoadRelations(true);
    entityTypeVersionLoadConfig.setRemoveOtherEntities(true);

    // Act and Assert
    assertNotEquals(entityTypeVersionLoadConfig, "Different type to EntityTypeVersionLoadConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link EntityTypeVersionLoadConfig}
   *   <li>{@link EntityTypeVersionLoadConfig#setFindExistingEntityByName(boolean)}
   *   <li>{@link EntityTypeVersionLoadConfig#setRemoveOtherEntities(boolean)}
   *   <li>{@link EntityTypeVersionLoadConfig#toString()}
   *   <li>{@link EntityTypeVersionLoadConfig#isFindExistingEntityByName()}
   *   <li>{@link EntityTypeVersionLoadConfig#isRemoveOtherEntities()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntityTypeVersionLoadConfig actualEntityTypeVersionLoadConfig = new EntityTypeVersionLoadConfig();
    actualEntityTypeVersionLoadConfig.setFindExistingEntityByName(true);
    actualEntityTypeVersionLoadConfig.setRemoveOtherEntities(true);
    String actualToStringResult = actualEntityTypeVersionLoadConfig.toString();
    boolean actualIsFindExistingEntityByNameResult = actualEntityTypeVersionLoadConfig.isFindExistingEntityByName();
    boolean actualIsRemoveOtherEntitiesResult = actualEntityTypeVersionLoadConfig.isRemoveOtherEntities();

    // Assert that nothing has changed
    assertEquals("EntityTypeVersionLoadConfig(removeOtherEntities=true, findExistingEntityByName=true)",
        actualToStringResult);
    assertFalse(actualEntityTypeVersionLoadConfig.isLoadAttributes());
    assertFalse(actualEntityTypeVersionLoadConfig.isLoadCredentials());
    assertFalse(actualEntityTypeVersionLoadConfig.isLoadRelations());
    assertTrue(actualIsFindExistingEntityByNameResult);
    assertTrue(actualIsRemoveOtherEntitiesResult);
  }
}
