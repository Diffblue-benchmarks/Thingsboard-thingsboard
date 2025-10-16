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
package org.thingsboard.server.common.data.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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

class EdgeSearchQueryDiffblueTest {
  /**
   * Test {@link EdgeSearchQuery#toEntitySearchQuery()}.
   *
   * <ul>
   *   <li>Then return Filters first RelationType is {@code Contains}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSearchQuery#toEntitySearchQuery()}
   */
  @Test
  @DisplayName("Test toEntitySearchQuery(); then return Filters first RelationType is 'Contains'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelationsQuery EdgeSearchQuery.toEntitySearchQuery()"})
  void testToEntitySearchQuery_thenReturnFiltersFirstRelationTypeIsContains() {
    // Arrange and Act
    EntityRelationsQuery actualToEntitySearchQueryResult =
        new EdgeSearchQuery().toEntitySearchQuery();

    // Assert
    List<RelationEntityTypeFilter> filters = actualToEntitySearchQueryResult.getFilters();
    assertEquals(1, filters.size());
    RelationEntityTypeFilter getResult = filters.get(0);
    assertEquals("Contains", getResult.getRelationType());
    assertNull(actualToEntitySearchQueryResult.getParameters());
    List<EntityType> entityTypes = getResult.getEntityTypes();
    assertEquals(1, entityTypes.size());
    assertEquals(EntityType.EDGE, entityTypes.get(0));
    assertFalse(getResult.isNegate());
  }

  /**
   * Test {@link EdgeSearchQuery#toEntitySearchQuery()}.
   *
   * <ul>
   *   <li>Then return Filters first RelationType is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSearchQuery#toEntitySearchQuery()}
   */
  @Test
  @DisplayName("Test toEntitySearchQuery(); then return Filters first RelationType is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelationsQuery EdgeSearchQuery.toEntitySearchQuery()"})
  void testToEntitySearchQuery_thenReturnFiltersFirstRelationTypeIsFoo() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    edgeSearchQuery.setRelationType("foo");

    // Act
    EntityRelationsQuery actualToEntitySearchQueryResult = edgeSearchQuery.toEntitySearchQuery();

    // Assert
    List<RelationEntityTypeFilter> filters = actualToEntitySearchQueryResult.getFilters();
    assertEquals(1, filters.size());
    RelationEntityTypeFilter getResult = filters.get(0);
    assertEquals("foo", getResult.getRelationType());
    assertNull(actualToEntitySearchQueryResult.getParameters());
    List<EntityType> entityTypes = getResult.getEntityTypes();
    assertEquals(1, entityTypes.size());
    assertEquals(EntityType.EDGE, entityTypes.get(0));
    assertFalse(getResult.isNegate());
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}, and {@link EdgeSearchQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeSearchQuery#equals(Object)}
   *   <li>{@link EdgeSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSearchQuery.equals(Object)", "int EdgeSearchQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    EdgeSearchQuery edgeSearchQuery2 = new EdgeSearchQuery();

    // Act and Assert
    assertEquals(edgeSearchQuery, edgeSearchQuery2);
    assertEquals(edgeSearchQuery.hashCode(), edgeSearchQuery2.hashCode());
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}, and {@link EdgeSearchQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeSearchQuery#equals(Object)}
   *   <li>{@link EdgeSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSearchQuery.equals(Object)", "int EdgeSearchQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    edgeSearchQuery.setParameters(
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    EdgeSearchQuery edgeSearchQuery2 = new EdgeSearchQuery();
    edgeSearchQuery2.setParameters(
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertEquals(edgeSearchQuery, edgeSearchQuery2);
    assertEquals(edgeSearchQuery.hashCode(), edgeSearchQuery2.hashCode());
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}, and {@link EdgeSearchQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeSearchQuery#equals(Object)}
   *   <li>{@link EdgeSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSearchQuery.equals(Object)", "int EdgeSearchQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    edgeSearchQuery.setRelationType("Relation Type");

    EdgeSearchQuery edgeSearchQuery2 = new EdgeSearchQuery();
    edgeSearchQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertEquals(edgeSearchQuery, edgeSearchQuery2);
    assertEquals(edgeSearchQuery.hashCode(), edgeSearchQuery2.hashCode());
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}, and {@link EdgeSearchQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeSearchQuery#equals(Object)}
   *   <li>{@link EdgeSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSearchQuery.equals(Object)", "int EdgeSearchQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    edgeSearchQuery.setEdgeTypes(new ArrayList<>());

    EdgeSearchQuery edgeSearchQuery2 = new EdgeSearchQuery();
    edgeSearchQuery2.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(edgeSearchQuery, edgeSearchQuery2);
    assertEquals(edgeSearchQuery.hashCode(), edgeSearchQuery2.hashCode());
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}, and {@link EdgeSearchQuery#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeSearchQuery#equals(Object)}
   *   <li>{@link EdgeSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSearchQuery.equals(Object)", "int EdgeSearchQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();

    // Act and Assert
    assertEquals(edgeSearchQuery, edgeSearchQuery);
    int expectedHashCodeResult = edgeSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, edgeSearchQuery.hashCode());
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSearchQuery.equals(Object)", "int EdgeSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeSearchQuery(), 1);
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSearchQuery.equals(Object)", "int EdgeSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    edgeSearchQuery.setParameters(
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(edgeSearchQuery, new EdgeSearchQuery());
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSearchQuery.equals(Object)", "int EdgeSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    edgeSearchQuery.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(edgeSearchQuery, new EdgeSearchQuery());
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSearchQuery.equals(Object)", "int EdgeSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    edgeSearchQuery.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(edgeSearchQuery, new EdgeSearchQuery());
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSearchQuery.equals(Object)", "int EdgeSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();

    EdgeSearchQuery edgeSearchQuery2 = new EdgeSearchQuery();
    edgeSearchQuery2.setParameters(
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(edgeSearchQuery, edgeSearchQuery2);
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSearchQuery.equals(Object)", "int EdgeSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();

    EdgeSearchQuery edgeSearchQuery2 = new EdgeSearchQuery();
    edgeSearchQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(edgeSearchQuery, edgeSearchQuery2);
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSearchQuery.equals(Object)", "int EdgeSearchQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();

    EdgeSearchQuery edgeSearchQuery2 = new EdgeSearchQuery();
    edgeSearchQuery2.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(edgeSearchQuery, edgeSearchQuery2);
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSearchQuery.equals(Object)", "int EdgeSearchQuery.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeSearchQuery(), null);
  }

  /**
   * Test {@link EdgeSearchQuery#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSearchQuery.equals(Object)", "int EdgeSearchQuery.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeSearchQuery(), "Different type to EdgeSearchQuery");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EdgeSearchQuery}
   *   <li>{@link EdgeSearchQuery#setEdgeTypes(List)}
   *   <li>{@link EdgeSearchQuery#setParameters(RelationsSearchParameters)}
   *   <li>{@link EdgeSearchQuery#setRelationType(String)}
   *   <li>{@link EdgeSearchQuery#toString()}
   *   <li>{@link EdgeSearchQuery#getEdgeTypes()}
   *   <li>{@link EdgeSearchQuery#getParameters()}
   *   <li>{@link EdgeSearchQuery#getRelationType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EdgeSearchQuery.<init>()",
    "List EdgeSearchQuery.getEdgeTypes()",
    "RelationsSearchParameters EdgeSearchQuery.getParameters()",
    "String EdgeSearchQuery.getRelationType()",
    "void EdgeSearchQuery.setEdgeTypes(List)",
    "void EdgeSearchQuery.setParameters(RelationsSearchParameters)",
    "void EdgeSearchQuery.setRelationType(String)",
    "String EdgeSearchQuery.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EdgeSearchQuery actualEdgeSearchQuery = new EdgeSearchQuery();
    ArrayList<String> edgeTypes = new ArrayList<>();
    actualEdgeSearchQuery.setEdgeTypes(edgeTypes);
    RelationsSearchParameters parameters =
        new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true);
    actualEdgeSearchQuery.setParameters(parameters);
    actualEdgeSearchQuery.setRelationType("Relation Type");
    String actualToStringResult = actualEdgeSearchQuery.toString();
    List<String> actualEdgeTypes = actualEdgeSearchQuery.getEdgeTypes();
    RelationsSearchParameters actualParameters = actualEdgeSearchQuery.getParameters();

    // Assert
    assertEquals(
        "EdgeSearchQuery(parameters=RelationsSearchParameters(rootId=13814000-1dd2-11b2-8080-808080808080,"
            + " rootType=TENANT, direction=FROM, relationTypeGroup=COMMON, maxLevel=3, fetchLastLevelOnly=true),"
            + " relationType=Relation Type, edgeTypes=[])",
        actualToStringResult);
    assertEquals("Relation Type", actualEdgeSearchQuery.getRelationType());
    assertTrue(actualEdgeTypes.isEmpty());
    assertSame(edgeTypes, actualEdgeTypes);
    assertSame(parameters, actualParameters);
  }
}
