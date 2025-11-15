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
package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class EntityNameFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityNameFilter#equals(Object)}
   *   <li>{@link EntityNameFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter("Entity Name Filter");
    entityNameFilter.setEntityType(EntityType.TENANT);

    EntityNameFilter entityNameFilter2 = new EntityNameFilter();
    entityNameFilter2.setEntityNameFilter("Entity Name Filter");
    entityNameFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertEquals(entityNameFilter, entityNameFilter2);
    int expectedHashCodeResult = entityNameFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityNameFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityNameFilter#equals(Object)}
   *   <li>{@link EntityNameFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter(null);
    entityNameFilter.setEntityType(EntityType.TENANT);

    EntityNameFilter entityNameFilter2 = new EntityNameFilter();
    entityNameFilter2.setEntityNameFilter(null);
    entityNameFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertEquals(entityNameFilter, entityNameFilter2);
    int expectedHashCodeResult = entityNameFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityNameFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityNameFilter#equals(Object)}
   *   <li>{@link EntityNameFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter("Entity Name Filter");
    entityNameFilter.setEntityType(null);

    EntityNameFilter entityNameFilter2 = new EntityNameFilter();
    entityNameFilter2.setEntityNameFilter("Entity Name Filter");
    entityNameFilter2.setEntityType(null);

    // Act and Assert
    assertEquals(entityNameFilter, entityNameFilter2);
    int expectedHashCodeResult = entityNameFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityNameFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityNameFilter#equals(Object)}
   *   <li>{@link EntityNameFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter("Entity Name Filter");
    entityNameFilter.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertEquals(entityNameFilter, entityNameFilter);
    int expectedHashCodeResult = entityNameFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityNameFilter.hashCode());
  }

  /**
   * Method under test: {@link EntityNameFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter(null);
    entityNameFilter.setEntityType(EntityType.TENANT);

    EntityNameFilter entityNameFilter2 = new EntityNameFilter();
    entityNameFilter2.setEntityNameFilter("Entity Name Filter");
    entityNameFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityNameFilter, entityNameFilter2);
  }

  /**
   * Method under test: {@link EntityNameFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter("org.thingsboard.server.common.data.query.EntityNameFilter");
    entityNameFilter.setEntityType(EntityType.TENANT);

    EntityNameFilter entityNameFilter2 = new EntityNameFilter();
    entityNameFilter2.setEntityNameFilter("Entity Name Filter");
    entityNameFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityNameFilter, entityNameFilter2);
  }

  /**
   * Method under test: {@link EntityNameFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter("Entity Name Filter");
    entityNameFilter.setEntityType(null);

    EntityNameFilter entityNameFilter2 = new EntityNameFilter();
    entityNameFilter2.setEntityNameFilter("Entity Name Filter");
    entityNameFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityNameFilter, entityNameFilter2);
  }

  /**
   * Method under test: {@link EntityNameFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter("Entity Name Filter");
    entityNameFilter.setEntityType(EntityType.CUSTOMER);

    EntityNameFilter entityNameFilter2 = new EntityNameFilter();
    entityNameFilter2.setEntityNameFilter("Entity Name Filter");
    entityNameFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityNameFilter, entityNameFilter2);
  }

  /**
   * Method under test: {@link EntityNameFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter("Entity Name Filter");
    entityNameFilter.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityNameFilter, null);
  }

  /**
   * Method under test: {@link EntityNameFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityNameFilter entityNameFilter = new EntityNameFilter();
    entityNameFilter.setEntityNameFilter("Entity Name Filter");
    entityNameFilter.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityNameFilter, "Different type to EntityNameFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityNameFilter}
   *   <li>{@link EntityNameFilter#setEntityNameFilter(String)}
   *   <li>{@link EntityNameFilter#setEntityType(EntityType)}
   *   <li>{@link EntityNameFilter#toString()}
   *   <li>{@link EntityNameFilter#getEntityNameFilter()}
   *   <li>{@link EntityNameFilter#getEntityType()}
   *   <li>{@link EntityNameFilter#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntityNameFilter actualEntityNameFilter = new EntityNameFilter();
    actualEntityNameFilter.setEntityNameFilter("Entity Name Filter");
    actualEntityNameFilter.setEntityType(EntityType.TENANT);
    String actualToStringResult = actualEntityNameFilter.toString();
    String actualEntityNameFilter2 = actualEntityNameFilter.getEntityNameFilter();
    EntityType actualEntityType = actualEntityNameFilter.getEntityType();

    // Assert that nothing has changed
    assertEquals("Entity Name Filter", actualEntityNameFilter2);
    assertEquals("EntityNameFilter(entityType=TENANT, entityNameFilter=Entity Name Filter)", actualToStringResult);
    assertEquals(EntityType.TENANT, actualEntityType);
    assertEquals(EntityFilterType.ENTITY_NAME, actualEntityNameFilter.getType());
  }
}
