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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class EntityListFilterDiffblueTest {
  /**
   * Test {@link EntityListFilter#equals(Object)}, and {@link EntityListFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityListFilter#equals(Object)}
   *   <li>{@link EntityListFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityListFilter.equals(Object)", "int EntityListFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityListFilter entityListFilter = new EntityListFilter();
    entityListFilter.setEntityList(new ArrayList<>());
    entityListFilter.setEntityType(EntityType.TENANT);

    EntityListFilter entityListFilter2 = new EntityListFilter();
    entityListFilter2.setEntityList(new ArrayList<>());
    entityListFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertEquals(entityListFilter, entityListFilter2);
    int expectedHashCodeResult = entityListFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityListFilter2.hashCode());
  }

  /**
   * Test {@link EntityListFilter#equals(Object)}, and {@link EntityListFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityListFilter#equals(Object)}
   *   <li>{@link EntityListFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityListFilter.equals(Object)", "int EntityListFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityListFilter entityListFilter = new EntityListFilter();
    entityListFilter.setEntityList(new ArrayList<>());
    entityListFilter.setEntityType(null);

    EntityListFilter entityListFilter2 = new EntityListFilter();
    entityListFilter2.setEntityList(new ArrayList<>());
    entityListFilter2.setEntityType(null);

    // Act and Assert
    assertEquals(entityListFilter, entityListFilter2);
    int expectedHashCodeResult = entityListFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityListFilter2.hashCode());
  }

  /**
   * Test {@link EntityListFilter#equals(Object)}, and {@link EntityListFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityListFilter#equals(Object)}
   *   <li>{@link EntityListFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityListFilter.equals(Object)", "int EntityListFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityListFilter entityListFilter = new EntityListFilter();
    entityListFilter.setEntityList(new ArrayList<>());
    entityListFilter.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertEquals(entityListFilter, entityListFilter);
    int expectedHashCodeResult = entityListFilter.hashCode();
    assertEquals(expectedHashCodeResult, entityListFilter.hashCode());
  }

  /**
   * Test {@link EntityListFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityListFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityListFilter.equals(Object)", "int EntityListFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<String> entityList = new ArrayList<>();
    entityList.add("foo");

    EntityListFilter entityListFilter = new EntityListFilter();
    entityListFilter.setEntityList(entityList);
    entityListFilter.setEntityType(EntityType.TENANT);

    EntityListFilter entityListFilter2 = new EntityListFilter();
    entityListFilter2.setEntityList(new ArrayList<>());
    entityListFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityListFilter, entityListFilter2);
  }

  /**
   * Test {@link EntityListFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityListFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityListFilter.equals(Object)", "int EntityListFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityListFilter entityListFilter = new EntityListFilter();
    entityListFilter.setEntityList(new ArrayList<>());
    entityListFilter.setEntityType(null);

    EntityListFilter entityListFilter2 = new EntityListFilter();
    entityListFilter2.setEntityList(new ArrayList<>());
    entityListFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityListFilter, entityListFilter2);
  }

  /**
   * Test {@link EntityListFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityListFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityListFilter.equals(Object)", "int EntityListFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityListFilter entityListFilter = new EntityListFilter();
    entityListFilter.setEntityList(new ArrayList<>());
    entityListFilter.setEntityType(EntityType.CUSTOMER);

    EntityListFilter entityListFilter2 = new EntityListFilter();
    entityListFilter2.setEntityList(new ArrayList<>());
    entityListFilter2.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityListFilter, entityListFilter2);
  }

  /**
   * Test {@link EntityListFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityListFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityListFilter.equals(Object)", "int EntityListFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityListFilter entityListFilter = new EntityListFilter();
    entityListFilter.setEntityList(new ArrayList<>());
    entityListFilter.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityListFilter, null);
  }

  /**
   * Test {@link EntityListFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityListFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityListFilter.equals(Object)", "int EntityListFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityListFilter entityListFilter = new EntityListFilter();
    entityListFilter.setEntityList(new ArrayList<>());
    entityListFilter.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertNotEquals(entityListFilter, "Different type to EntityListFilter");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityListFilter}
   *   <li>{@link EntityListFilter#setEntityList(List)}
   *   <li>{@link EntityListFilter#setEntityType(EntityType)}
   *   <li>{@link EntityListFilter#toString()}
   *   <li>{@link EntityListFilter#getEntityList()}
   *   <li>{@link EntityListFilter#getEntityType()}
   *   <li>{@link EntityListFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityListFilter.<init>()", "List EntityListFilter.getEntityList()",
      "EntityType EntityListFilter.getEntityType()", "EntityFilterType EntityListFilter.getType()",
      "void EntityListFilter.setEntityList(List)", "void EntityListFilter.setEntityType(EntityType)",
      "String EntityListFilter.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EntityListFilter actualEntityListFilter = new EntityListFilter();
    ArrayList<String> entityList = new ArrayList<>();
    actualEntityListFilter.setEntityList(entityList);
    actualEntityListFilter.setEntityType(EntityType.TENANT);
    String actualToStringResult = actualEntityListFilter.toString();
    List<String> actualEntityList = actualEntityListFilter.getEntityList();
    EntityType actualEntityType = actualEntityListFilter.getEntityType();

    // Assert
    assertEquals("EntityListFilter(entityType=TENANT, entityList=[])", actualToStringResult);
    assertEquals(EntityType.TENANT, actualEntityType);
    assertEquals(EntityFilterType.ENTITY_LIST, actualEntityListFilter.getType());
    assertTrue(actualEntityList.isEmpty());
    assertSame(entityList, actualEntityList);
  }
}
