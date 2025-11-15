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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class EntityViewTypeFilterDiffblueTest {
  /**
   * Method under test: {@link EntityViewTypeFilter#getEntityViewTypes()}
   */
  @Test
  void testGetEntityViewTypes() {
    // Arrange and Act
    List<String> actualEntityViewTypes = (new EntityViewTypeFilter()).getEntityViewTypes();

    // Assert
    assertEquals(1, actualEntityViewTypes.size());
    assertNull(actualEntityViewTypes.get(0));
  }

  /**
   * Method under test: {@link EntityViewTypeFilter#getEntityViewTypes()}
   */
  @Test
  void testGetEntityViewTypes2() {
    // Arrange
    ArrayList<String> entityViewTypes = new ArrayList<>();
    entityViewTypes.add("foo");

    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewTypes(entityViewTypes);

    // Act
    List<String> actualEntityViewTypes = entityViewTypeFilter.getEntityViewTypes();

    // Assert
    assertEquals(1, actualEntityViewTypes.size());
    assertEquals("foo", actualEntityViewTypes.get(0));
    assertSame(entityViewTypes, actualEntityViewTypes);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewTypeFilter#equals(Object)}
   *   <li>{@link EntityViewTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewType("Entity View Type");
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    EntityViewTypeFilter entityViewTypeFilter2 = new EntityViewTypeFilter();
    entityViewTypeFilter2.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter2.setEntityViewType("Entity View Type");
    entityViewTypeFilter2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(entityViewTypeFilter, entityViewTypeFilter2);
    int expectedHashCodeResult = entityViewTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityViewTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewTypeFilter#equals(Object)}
   *   <li>{@link EntityViewTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ArrayList<String> entityViewTypes = new ArrayList<>();
    entityViewTypes.add("Entity View Type");

    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewType("Entity View Type");
    entityViewTypeFilter.setEntityViewTypes(entityViewTypes);

    EntityViewTypeFilter entityViewTypeFilter2 = new EntityViewTypeFilter();
    entityViewTypeFilter2.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter2.setEntityViewType("Entity View Type");
    entityViewTypeFilter2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(entityViewTypeFilter, entityViewTypeFilter2);
    int expectedHashCodeResult = entityViewTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityViewTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewTypeFilter#equals(Object)}
   *   <li>{@link EntityViewTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter(null);
    entityViewTypeFilter.setEntityViewType("Entity View Type");
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    EntityViewTypeFilter entityViewTypeFilter2 = new EntityViewTypeFilter();
    entityViewTypeFilter2.setEntityViewNameFilter(null);
    entityViewTypeFilter2.setEntityViewType("Entity View Type");
    entityViewTypeFilter2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(entityViewTypeFilter, entityViewTypeFilter2);
    int expectedHashCodeResult = entityViewTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityViewTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewTypeFilter#equals(Object)}
   *   <li>{@link EntityViewTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewType(null);
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    EntityViewTypeFilter entityViewTypeFilter2 = new EntityViewTypeFilter();
    entityViewTypeFilter2.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter2.setEntityViewType(null);
    entityViewTypeFilter2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(entityViewTypeFilter, entityViewTypeFilter2);
    int expectedHashCodeResult = entityViewTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityViewTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewTypeFilter#equals(Object)}
   *   <li>{@link EntityViewTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewType("Entity View Type");
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(entityViewTypeFilter, entityViewTypeFilter);
    int expectedHashCodeResult = entityViewTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityViewTypeFilter.hashCode());
  }

  /**
   * Method under test: {@link EntityViewTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Type");
    entityViewTypeFilter.setEntityViewType("Entity View Type");
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    EntityViewTypeFilter entityViewTypeFilter2 = new EntityViewTypeFilter();
    entityViewTypeFilter2.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter2.setEntityViewType("Entity View Type");
    entityViewTypeFilter2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityViewTypeFilter, entityViewTypeFilter2);
  }

  /**
   * Method under test: {@link EntityViewTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter(null);
    entityViewTypeFilter.setEntityViewType("Entity View Type");
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    EntityViewTypeFilter entityViewTypeFilter2 = new EntityViewTypeFilter();
    entityViewTypeFilter2.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter2.setEntityViewType("Entity View Type");
    entityViewTypeFilter2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityViewTypeFilter, entityViewTypeFilter2);
  }

  /**
   * Method under test: {@link EntityViewTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewType("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    EntityViewTypeFilter entityViewTypeFilter2 = new EntityViewTypeFilter();
    entityViewTypeFilter2.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter2.setEntityViewType("Entity View Type");
    entityViewTypeFilter2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityViewTypeFilter, entityViewTypeFilter2);
  }

  /**
   * Method under test: {@link EntityViewTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewType(null);
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    EntityViewTypeFilter entityViewTypeFilter2 = new EntityViewTypeFilter();
    entityViewTypeFilter2.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter2.setEntityViewType("Entity View Type");
    entityViewTypeFilter2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityViewTypeFilter, entityViewTypeFilter2);
  }

  /**
   * Method under test: {@link EntityViewTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ArrayList<String> entityViewTypes = new ArrayList<>();
    entityViewTypes.add("Entity View Name Filter");
    entityViewTypes.add("Entity View Type");

    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewType("Entity View Type");
    entityViewTypeFilter.setEntityViewTypes(entityViewTypes);

    EntityViewTypeFilter entityViewTypeFilter2 = new EntityViewTypeFilter();
    entityViewTypeFilter2.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter2.setEntityViewType("Entity View Type");
    entityViewTypeFilter2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityViewTypeFilter, entityViewTypeFilter2);
  }

  /**
   * Method under test: {@link EntityViewTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewType("Entity View Type");
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityViewTypeFilter, null);
  }

  /**
   * Method under test: {@link EntityViewTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityViewTypeFilter entityViewTypeFilter = new EntityViewTypeFilter();
    entityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    entityViewTypeFilter.setEntityViewType("Entity View Type");
    entityViewTypeFilter.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityViewTypeFilter, "Different type to EntityViewTypeFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityViewTypeFilter}
   *   <li>{@link EntityViewTypeFilter#setEntityViewNameFilter(String)}
   *   <li>{@link EntityViewTypeFilter#setEntityViewType(String)}
   *   <li>{@link EntityViewTypeFilter#setEntityViewTypes(List)}
   *   <li>{@link EntityViewTypeFilter#toString()}
   *   <li>{@link EntityViewTypeFilter#getEntityViewNameFilter()}
   *   <li>{@link EntityViewTypeFilter#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntityViewTypeFilter actualEntityViewTypeFilter = new EntityViewTypeFilter();
    actualEntityViewTypeFilter.setEntityViewNameFilter("Entity View Name Filter");
    actualEntityViewTypeFilter.setEntityViewType("Entity View Type");
    actualEntityViewTypeFilter.setEntityViewTypes(new ArrayList<>());
    String actualToStringResult = actualEntityViewTypeFilter.toString();
    String actualEntityViewNameFilter = actualEntityViewTypeFilter.getEntityViewNameFilter();

    // Assert that nothing has changed
    assertEquals("Entity View Name Filter", actualEntityViewNameFilter);
    assertEquals("EntityViewTypeFilter(entityViewType=Entity View Type, entityViewTypes=[Entity View Type], entityView"
        + "NameFilter=Entity View Name Filter)", actualToStringResult);
    assertEquals(EntityFilterType.ENTITY_VIEW_TYPE, actualEntityViewTypeFilter.getType());
  }
}
