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
package org.thingsboard.server.common.data.relation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class RelationEntityTypeFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RelationEntityTypeFilter#equals(Object)}
   *   <li>{@link RelationEntityTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelationEntityTypeFilter relationEntityTypeFilter = new RelationEntityTypeFilter();
    RelationEntityTypeFilter relationEntityTypeFilter2 = new RelationEntityTypeFilter();

    // Act and Assert
    assertEquals(relationEntityTypeFilter, relationEntityTypeFilter2);
    int expectedHashCodeResult = relationEntityTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, relationEntityTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RelationEntityTypeFilter#equals(Object)}
   *   <li>{@link RelationEntityTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelationEntityTypeFilter relationEntityTypeFilter = new RelationEntityTypeFilter("Relation Type",
        new ArrayList<>());
    RelationEntityTypeFilter relationEntityTypeFilter2 = new RelationEntityTypeFilter("Relation Type",
        new ArrayList<>());

    // Act and Assert
    assertEquals(relationEntityTypeFilter, relationEntityTypeFilter2);
    int expectedHashCodeResult = relationEntityTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, relationEntityTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RelationEntityTypeFilter#equals(Object)}
   *   <li>{@link RelationEntityTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelationEntityTypeFilter relationEntityTypeFilter = new RelationEntityTypeFilter();

    // Act and Assert
    assertEquals(relationEntityTypeFilter, relationEntityTypeFilter);
    int expectedHashCodeResult = relationEntityTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, relationEntityTypeFilter.hashCode());
  }

  /**
   * Method under test: {@link RelationEntityTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RelationEntityTypeFilter relationEntityTypeFilter = new RelationEntityTypeFilter("Relation Type",
        new ArrayList<>());

    // Act and Assert
    assertNotEquals(relationEntityTypeFilter, new RelationEntityTypeFilter());
  }

  /**
   * Method under test: {@link RelationEntityTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelationEntityTypeFilter relationEntityTypeFilter = new RelationEntityTypeFilter("Relation Type", new ArrayList<>(),
        true);

    // Act and Assert
    assertNotEquals(relationEntityTypeFilter, new RelationEntityTypeFilter());
  }

  /**
   * Method under test: {@link RelationEntityTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelationEntityTypeFilter relationEntityTypeFilter = new RelationEntityTypeFilter();

    // Act and Assert
    assertNotEquals(relationEntityTypeFilter, new RelationEntityTypeFilter("Relation Type", new ArrayList<>()));
  }

  /**
   * Method under test: {@link RelationEntityTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RelationEntityTypeFilter relationEntityTypeFilter = new RelationEntityTypeFilter();
    relationEntityTypeFilter.setEntityTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(relationEntityTypeFilter, new RelationEntityTypeFilter());
  }

  /**
   * Method under test: {@link RelationEntityTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RelationEntityTypeFilter relationEntityTypeFilter = new RelationEntityTypeFilter();

    RelationEntityTypeFilter relationEntityTypeFilter2 = new RelationEntityTypeFilter();
    relationEntityTypeFilter2.setEntityTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(relationEntityTypeFilter, relationEntityTypeFilter2);
  }

  /**
   * Method under test: {@link RelationEntityTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RelationEntityTypeFilter(), null);
  }

  /**
   * Method under test: {@link RelationEntityTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RelationEntityTypeFilter(), "Different type to RelationEntityTypeFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RelationEntityTypeFilter#RelationEntityTypeFilter()}
   *   <li>{@link RelationEntityTypeFilter#setEntityTypes(List)}
   *   <li>{@link RelationEntityTypeFilter#setNegate(boolean)}
   *   <li>{@link RelationEntityTypeFilter#setRelationType(String)}
   *   <li>{@link RelationEntityTypeFilter#toString()}
   *   <li>{@link RelationEntityTypeFilter#getEntityTypes()}
   *   <li>{@link RelationEntityTypeFilter#getRelationType()}
   *   <li>{@link RelationEntityTypeFilter#isNegate()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RelationEntityTypeFilter actualRelationEntityTypeFilter = new RelationEntityTypeFilter();
    ArrayList<EntityType> entityTypes = new ArrayList<>();
    actualRelationEntityTypeFilter.setEntityTypes(entityTypes);
    actualRelationEntityTypeFilter.setNegate(true);
    actualRelationEntityTypeFilter.setRelationType("Relation Type");
    String actualToStringResult = actualRelationEntityTypeFilter.toString();
    List<EntityType> actualEntityTypes = actualRelationEntityTypeFilter.getEntityTypes();
    String actualRelationType = actualRelationEntityTypeFilter.getRelationType();
    boolean actualIsNegateResult = actualRelationEntityTypeFilter.isNegate();

    // Assert that nothing has changed
    assertEquals("Relation Type", actualRelationType);
    assertEquals("RelationEntityTypeFilter(relationType=Relation Type, entityTypes=[], negate=true)",
        actualToStringResult);
    assertTrue(actualEntityTypes.isEmpty());
    assertTrue(actualIsNegateResult);
    assertSame(entityTypes, actualEntityTypes);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RelationEntityTypeFilter#RelationEntityTypeFilter(String, List)}
   *   <li>{@link RelationEntityTypeFilter#setEntityTypes(List)}
   *   <li>{@link RelationEntityTypeFilter#setNegate(boolean)}
   *   <li>{@link RelationEntityTypeFilter#setRelationType(String)}
   *   <li>{@link RelationEntityTypeFilter#toString()}
   *   <li>{@link RelationEntityTypeFilter#getEntityTypes()}
   *   <li>{@link RelationEntityTypeFilter#getRelationType()}
   *   <li>{@link RelationEntityTypeFilter#isNegate()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    RelationEntityTypeFilter actualRelationEntityTypeFilter = new RelationEntityTypeFilter("Relation Type",
        new ArrayList<>());
    ArrayList<EntityType> entityTypes = new ArrayList<>();
    actualRelationEntityTypeFilter.setEntityTypes(entityTypes);
    actualRelationEntityTypeFilter.setNegate(true);
    actualRelationEntityTypeFilter.setRelationType("Relation Type");
    String actualToStringResult = actualRelationEntityTypeFilter.toString();
    List<EntityType> actualEntityTypes = actualRelationEntityTypeFilter.getEntityTypes();
    String actualRelationType = actualRelationEntityTypeFilter.getRelationType();
    boolean actualIsNegateResult = actualRelationEntityTypeFilter.isNegate();

    // Assert that nothing has changed
    assertEquals("Relation Type", actualRelationType);
    assertEquals("RelationEntityTypeFilter(relationType=Relation Type, entityTypes=[], negate=true)",
        actualToStringResult);
    assertTrue(actualEntityTypes.isEmpty());
    assertTrue(actualIsNegateResult);
    assertSame(entityTypes, actualEntityTypes);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RelationEntityTypeFilter#RelationEntityTypeFilter(String, List, boolean)}
   *   <li>{@link RelationEntityTypeFilter#setEntityTypes(List)}
   *   <li>{@link RelationEntityTypeFilter#setNegate(boolean)}
   *   <li>{@link RelationEntityTypeFilter#setRelationType(String)}
   *   <li>{@link RelationEntityTypeFilter#toString()}
   *   <li>{@link RelationEntityTypeFilter#getEntityTypes()}
   *   <li>{@link RelationEntityTypeFilter#getRelationType()}
   *   <li>{@link RelationEntityTypeFilter#isNegate()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() {
    // Arrange and Act
    RelationEntityTypeFilter actualRelationEntityTypeFilter = new RelationEntityTypeFilter("Relation Type",
        new ArrayList<>(), true);
    ArrayList<EntityType> entityTypes = new ArrayList<>();
    actualRelationEntityTypeFilter.setEntityTypes(entityTypes);
    actualRelationEntityTypeFilter.setNegate(true);
    actualRelationEntityTypeFilter.setRelationType("Relation Type");
    String actualToStringResult = actualRelationEntityTypeFilter.toString();
    List<EntityType> actualEntityTypes = actualRelationEntityTypeFilter.getEntityTypes();
    String actualRelationType = actualRelationEntityTypeFilter.getRelationType();
    boolean actualIsNegateResult = actualRelationEntityTypeFilter.isNegate();

    // Assert that nothing has changed
    assertEquals("Relation Type", actualRelationType);
    assertEquals("RelationEntityTypeFilter(relationType=Relation Type, entityTypes=[], negate=true)",
        actualToStringResult);
    assertTrue(actualEntityTypes.isEmpty());
    assertTrue(actualIsNegateResult);
    assertSame(entityTypes, actualEntityTypes);
  }
}
