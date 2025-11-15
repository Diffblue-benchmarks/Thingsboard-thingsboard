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

class EntityTypeFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeFilter#equals(Object)}
   *   <li>{@link EntityTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityTypeFilter entityTypeFilter = new EntityTypeFilter();
    entityTypeFilter.setEntityType(EntityType.TENANT);

    EntityTypeFilter entityTypeFilter2 = new EntityTypeFilter();
    entityTypeFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertEquals(entityTypeFilter, entityTypeFilter2);
    int expectedHashCodeResult = entityTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeFilter#equals(Object)}
   *   <li>{@link EntityTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityTypeFilter entityTypeFilter = new EntityTypeFilter();
    entityTypeFilter.setEntityType(null);

    EntityTypeFilter entityTypeFilter2 = new EntityTypeFilter();
    entityTypeFilter2.setEntityType(null);

    // Act and Assert
    assertEquals(entityTypeFilter, entityTypeFilter2);
    int expectedHashCodeResult = entityTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityTypeFilter#equals(Object)}
   *   <li>{@link EntityTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityTypeFilter entityTypeFilter = new EntityTypeFilter();
    entityTypeFilter.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertEquals(entityTypeFilter, entityTypeFilter);
    int expectedHashCodeResult = entityTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityTypeFilter.hashCode());
  }

  /**
   * Method under test: {@link EntityTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityTypeFilter entityTypeFilter = new EntityTypeFilter();
    entityTypeFilter.setEntityType(null);

    EntityTypeFilter entityTypeFilter2 = new EntityTypeFilter();
    entityTypeFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityTypeFilter, entityTypeFilter2);
  }

  /**
   * Method under test: {@link EntityTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityTypeFilter entityTypeFilter = new EntityTypeFilter();
    entityTypeFilter.setEntityType(EntityType.CUSTOMER);

    EntityTypeFilter entityTypeFilter2 = new EntityTypeFilter();
    entityTypeFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityTypeFilter, entityTypeFilter2);
  }

  /**
   * Method under test: {@link EntityTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityTypeFilter entityTypeFilter = new EntityTypeFilter();
    entityTypeFilter.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityTypeFilter, null);
  }

  /**
   * Method under test: {@link EntityTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityTypeFilter entityTypeFilter = new EntityTypeFilter();
    entityTypeFilter.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityTypeFilter, "Different type to EntityTypeFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityTypeFilter}
   *   <li>{@link EntityTypeFilter#setEntityType(EntityType)}
   *   <li>{@link EntityTypeFilter#toString()}
   *   <li>{@link EntityTypeFilter#getEntityType()}
   *   <li>{@link EntityTypeFilter#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntityTypeFilter actualEntityTypeFilter = new EntityTypeFilter();
    actualEntityTypeFilter.setEntityType(EntityType.TENANT);
    String actualToStringResult = actualEntityTypeFilter.toString();
    EntityType actualEntityType = actualEntityTypeFilter.getEntityType();

    // Assert that nothing has changed
    assertEquals("EntityTypeFilter(entityType=TENANT)", actualToStringResult);
    assertEquals(EntityType.TENANT, actualEntityType);
    assertEquals(EntityFilterType.ENTITY_TYPE, actualEntityTypeFilter.getType());
  }
}
