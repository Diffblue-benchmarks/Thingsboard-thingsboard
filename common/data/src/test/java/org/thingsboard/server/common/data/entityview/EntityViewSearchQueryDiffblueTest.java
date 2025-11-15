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
package org.thingsboard.server.common.data.entityview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelationsQuery;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationEntityTypeFilter;
import org.thingsboard.server.common.data.relation.RelationsSearchParameters;

class EntityViewSearchQueryDiffblueTest {
  /**
   * Test {@link EntityViewSearchQuery#toEntitySearchQuery()}.
   * <ul>
   *   <li>Then return Filters first RelationType is {@code Contains}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewSearchQuery#toEntitySearchQuery()}
   */
  @Test
  @DisplayName("Test toEntitySearchQuery(); then return Filters first RelationType is 'Contains'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityRelationsQuery EntityViewSearchQuery.toEntitySearchQuery()"})
  void testToEntitySearchQuery_thenReturnFiltersFirstRelationTypeIsContains() {
    // Arrange and Act
    EntityRelationsQuery actualToEntitySearchQueryResult = (new EntityViewSearchQuery()).toEntitySearchQuery();

    // Assert
    List<RelationEntityTypeFilter> filters = actualToEntitySearchQueryResult.getFilters();
    assertEquals(1, filters.size());
    RelationEntityTypeFilter getResult = filters.get(0);
    assertEquals("Contains", getResult.getRelationType());
    assertNull(actualToEntitySearchQueryResult.getParameters());
    List<EntityType> entityTypes = getResult.getEntityTypes();
    assertEquals(1, entityTypes.size());
    assertEquals(EntityType.ENTITY_VIEW, entityTypes.get(0));
    assertFalse(getResult.isNegate());
  }

  /**
   * Test {@link EntityViewSearchQuery#toEntitySearchQuery()}.
   * <ul>
   *   <li>Then return Filters first RelationType is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewSearchQuery#toEntitySearchQuery()}
   */
  @Test
  @DisplayName("Test toEntitySearchQuery(); then return Filters first RelationType is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityRelationsQuery EntityViewSearchQuery.toEntitySearchQuery()"})
  void testToEntitySearchQuery_thenReturnFiltersFirstRelationTypeIsFoo() {
    // Arrange
    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();
    entityViewSearchQuery.setRelationType("foo");

    // Act
    EntityRelationsQuery actualToEntitySearchQueryResult = entityViewSearchQuery.toEntitySearchQuery();

    // Assert
    List<RelationEntityTypeFilter> filters = actualToEntitySearchQueryResult.getFilters();
    assertEquals(1, filters.size());
    RelationEntityTypeFilter getResult = filters.get(0);
    assertEquals("foo", getResult.getRelationType());
    assertNull(actualToEntitySearchQueryResult.getParameters());
    List<EntityType> entityTypes = getResult.getEntityTypes();
    assertEquals(1, entityTypes.size());
    assertEquals(EntityType.ENTITY_VIEW, entityTypes.get(0));
    assertFalse(getResult.isNegate());
  }

  /**
   * Test {@link EntityViewSearchQuery#equals(Object)}, and {@link EntityViewSearchQuery#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewSearchQuery#equals(Object)}
   *   <li>{@link EntityViewSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityViewSearchQuery.equals(Object)", "int EntityViewSearchQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();
    EntityViewSearchQuery entityViewSearchQuery2 = new EntityViewSearchQuery();

    // Act and Assert
    assertEquals(entityViewSearchQuery, entityViewSearchQuery2);
    int expectedHashCodeResult = entityViewSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, entityViewSearchQuery2.hashCode());
  }

  /**
   * Test {@link EntityViewSearchQuery#equals(Object)}, and {@link EntityViewSearchQuery#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewSearchQuery#equals(Object)}
   *   <li>{@link EntityViewSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityViewSearchQuery.equals(Object)", "int EntityViewSearchQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();
    entityViewSearchQuery
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    EntityViewSearchQuery entityViewSearchQuery2 = new EntityViewSearchQuery();
    entityViewSearchQuery2
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertEquals(entityViewSearchQuery, entityViewSearchQuery2);
    int expectedHashCodeResult = entityViewSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, entityViewSearchQuery2.hashCode());
  }

  /**
   * Test {@link EntityViewSearchQuery#equals(Object)}, and {@link EntityViewSearchQuery#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewSearchQuery#equals(Object)}
   *   <li>{@link EntityViewSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityViewSearchQuery.equals(Object)", "int EntityViewSearchQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();
    entityViewSearchQuery.setRelationType("Relation Type");

    EntityViewSearchQuery entityViewSearchQuery2 = new EntityViewSearchQuery();
    entityViewSearchQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertEquals(entityViewSearchQuery, entityViewSearchQuery2);
    int expectedHashCodeResult = entityViewSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, entityViewSearchQuery2.hashCode());
  }

  /**
   * Test {@link EntityViewSearchQuery#equals(Object)}, and {@link EntityViewSearchQuery#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewSearchQuery#equals(Object)}
   *   <li>{@link EntityViewSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityViewSearchQuery.equals(Object)", "int EntityViewSearchQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();
    entityViewSearchQuery.setEntityViewTypes(new ArrayList<>());

    EntityViewSearchQuery entityViewSearchQuery2 = new EntityViewSearchQuery();
    entityViewSearchQuery2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(entityViewSearchQuery, entityViewSearchQuery2);
    int expectedHashCodeResult = entityViewSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, entityViewSearchQuery2.hashCode());
  }

  /**
   * Test {@link EntityViewSearchQuery#equals(Object)}, and {@link EntityViewSearchQuery#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewSearchQuery#equals(Object)}
   *   <li>{@link EntityViewSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityViewSearchQuery.equals(Object)", "int EntityViewSearchQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();

    // Act and Assert
    assertEquals(entityViewSearchQuery, entityViewSearchQuery);
    int expectedHashCodeResult = entityViewSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, entityViewSearchQuery.hashCode());
  }

  /**
   * Test {@link EntityViewSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityViewSearchQuery.equals(Object)", "int EntityViewSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewSearchQuery(), 1);
  }

  /**
   * Test {@link EntityViewSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityViewSearchQuery.equals(Object)", "int EntityViewSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();
    entityViewSearchQuery
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(entityViewSearchQuery, new EntityViewSearchQuery());
  }

  /**
   * Test {@link EntityViewSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityViewSearchQuery.equals(Object)", "int EntityViewSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();
    entityViewSearchQuery.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(entityViewSearchQuery, new EntityViewSearchQuery());
  }

  /**
   * Test {@link EntityViewSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityViewSearchQuery.equals(Object)", "int EntityViewSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();
    entityViewSearchQuery.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityViewSearchQuery, new EntityViewSearchQuery());
  }

  /**
   * Test {@link EntityViewSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityViewSearchQuery.equals(Object)", "int EntityViewSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();

    EntityViewSearchQuery entityViewSearchQuery2 = new EntityViewSearchQuery();
    entityViewSearchQuery2
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(entityViewSearchQuery, entityViewSearchQuery2);
  }

  /**
   * Test {@link EntityViewSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityViewSearchQuery.equals(Object)", "int EntityViewSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();

    EntityViewSearchQuery entityViewSearchQuery2 = new EntityViewSearchQuery();
    entityViewSearchQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(entityViewSearchQuery, entityViewSearchQuery2);
  }

  /**
   * Test {@link EntityViewSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityViewSearchQuery.equals(Object)", "int EntityViewSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();

    EntityViewSearchQuery entityViewSearchQuery2 = new EntityViewSearchQuery();
    entityViewSearchQuery2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityViewSearchQuery, entityViewSearchQuery2);
  }

  /**
   * Test {@link EntityViewSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityViewSearchQuery.equals(Object)", "int EntityViewSearchQuery.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewSearchQuery(), null);
  }

  /**
   * Test {@link EntityViewSearchQuery#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityViewSearchQuery.equals(Object)", "int EntityViewSearchQuery.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewSearchQuery(), "Different type to EntityViewSearchQuery");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityViewSearchQuery}
   *   <li>{@link EntityViewSearchQuery#setEntityViewTypes(List)}
   *   <li>{@link EntityViewSearchQuery#setParameters(RelationsSearchParameters)}
   *   <li>{@link EntityViewSearchQuery#setRelationType(String)}
   *   <li>{@link EntityViewSearchQuery#toString()}
   *   <li>{@link EntityViewSearchQuery#getEntityViewTypes()}
   *   <li>{@link EntityViewSearchQuery#getParameters()}
   *   <li>{@link EntityViewSearchQuery#getRelationType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityViewSearchQuery.<init>()", "List EntityViewSearchQuery.getEntityViewTypes()",
      "RelationsSearchParameters EntityViewSearchQuery.getParameters()",
      "String EntityViewSearchQuery.getRelationType()", "void EntityViewSearchQuery.setEntityViewTypes(List)",
      "void EntityViewSearchQuery.setParameters(RelationsSearchParameters)",
      "void EntityViewSearchQuery.setRelationType(String)", "String EntityViewSearchQuery.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EntityViewSearchQuery actualEntityViewSearchQuery = new EntityViewSearchQuery();
    ArrayList<String> entityViewTypes = new ArrayList<>();
    actualEntityViewSearchQuery.setEntityViewTypes(entityViewTypes);
    RelationsSearchParameters parameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);

    actualEntityViewSearchQuery.setParameters(parameters);
    actualEntityViewSearchQuery.setRelationType("Relation Type");
    String actualToStringResult = actualEntityViewSearchQuery.toString();
    List<String> actualEntityViewTypes = actualEntityViewSearchQuery.getEntityViewTypes();
    RelationsSearchParameters actualParameters = actualEntityViewSearchQuery.getParameters();

    // Assert
    assertEquals(
        "EntityViewSearchQuery(parameters=RelationsSearchParameters(rootId=13814000-1dd2-11b2-8080-808080808080,"
            + " rootType=TENANT, direction=FROM, relationTypeGroup=COMMON, maxLevel=3, fetchLastLevelOnly=true),"
            + " relationType=Relation Type, entityViewTypes=[])",
        actualToStringResult);
    assertEquals("Relation Type", actualEntityViewSearchQuery.getRelationType());
    assertTrue(actualEntityViewTypes.isEmpty());
    assertSame(entityViewTypes, actualEntityViewTypes);
    assertSame(parameters, actualParameters);
  }
}
