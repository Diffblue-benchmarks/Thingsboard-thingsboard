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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelationsQuery;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationEntityTypeFilter;
import org.thingsboard.server.common.data.relation.RelationsSearchParameters;

class EdgeSearchQueryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeSearchQuery#equals(Object)}
   *   <li>{@link EdgeSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    EdgeSearchQuery edgeSearchQuery2 = new EdgeSearchQuery();

    // Act and Assert
    assertEquals(edgeSearchQuery, edgeSearchQuery2);
    int expectedHashCodeResult = edgeSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, edgeSearchQuery2.hashCode());
  }

  /**
   * Method under test: {@link EdgeSearchQuery#toEntitySearchQuery()}
   */
  @Test
  void testToEntitySearchQuery() {
    // Arrange and Act
    EntityRelationsQuery actualToEntitySearchQueryResult = (new EdgeSearchQuery()).toEntitySearchQuery();

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
   * Method under test: {@link EdgeSearchQuery#toEntitySearchQuery()}
   */
  @Test
  void testToEntitySearchQuery2() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeSearchQuery#equals(Object)}
   *   <li>{@link EdgeSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(EntityId.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters parameters = new RelationsSearchParameters(entityId, EntitySearchDirection.FROM, 3, true);

    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    edgeSearchQuery.setParameters(parameters);

    EdgeSearchQuery edgeSearchQuery2 = new EdgeSearchQuery();
    edgeSearchQuery2
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertEquals(edgeSearchQuery, edgeSearchQuery2);
    int expectedHashCodeResult = edgeSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, edgeSearchQuery2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeSearchQuery#equals(Object)}
   *   <li>{@link EdgeSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();

    // Act and Assert
    assertEquals(edgeSearchQuery, edgeSearchQuery);
    int expectedHashCodeResult = edgeSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, edgeSearchQuery.hashCode());
  }

  /**
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeSearchQuery(), 1);
  }

  /**
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    edgeSearchQuery
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(edgeSearchQuery, new EdgeSearchQuery());
  }

  /**
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    edgeSearchQuery.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(edgeSearchQuery, new EdgeSearchQuery());
  }

  /**
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    edgeSearchQuery.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(edgeSearchQuery, new EdgeSearchQuery());
  }

  /**
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();

    EdgeSearchQuery edgeSearchQuery2 = new EdgeSearchQuery();
    edgeSearchQuery2
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(edgeSearchQuery, edgeSearchQuery2);
  }

  /**
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();

    EdgeSearchQuery edgeSearchQuery2 = new EdgeSearchQuery();
    edgeSearchQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(edgeSearchQuery, edgeSearchQuery2);
  }

  /**
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();

    EdgeSearchQuery edgeSearchQuery2 = new EdgeSearchQuery();
    edgeSearchQuery2.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(edgeSearchQuery, edgeSearchQuery2);
  }

  /**
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(EntityId.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters parameters = new RelationsSearchParameters(entityId, EntitySearchDirection.FROM, 3, true);

    EdgeSearchQuery edgeSearchQuery = new EdgeSearchQuery();
    edgeSearchQuery.setParameters(parameters);

    // Act and Assert
    assertNotEquals(edgeSearchQuery, new EdgeSearchQuery());
  }

  /**
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeSearchQuery(), null);
  }

  /**
   * Method under test: {@link EdgeSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeSearchQuery(), "Different type to EdgeSearchQuery");
  }

  /**
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange and Act
    EdgeSearchQuery actualEdgeSearchQuery = new EdgeSearchQuery();
    ArrayList<String> edgeTypes = new ArrayList<>();
    actualEdgeSearchQuery.setEdgeTypes(edgeTypes);
    RelationsSearchParameters parameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);

    actualEdgeSearchQuery.setParameters(parameters);
    actualEdgeSearchQuery.setRelationType("Relation Type");
    String actualToStringResult = actualEdgeSearchQuery.toString();
    List<String> actualEdgeTypes = actualEdgeSearchQuery.getEdgeTypes();
    RelationsSearchParameters actualParameters = actualEdgeSearchQuery.getParameters();

    // Assert that nothing has changed
    assertEquals("EdgeSearchQuery(parameters=RelationsSearchParameters(rootId=13814000-1dd2-11b2-8080-808080808080,"
        + " rootType=TENANT, direction=FROM, relationTypeGroup=COMMON, maxLevel=3, fetchLastLevelOnly=true),"
        + " relationType=Relation Type, edgeTypes=[])", actualToStringResult);
    assertEquals("Relation Type", actualEdgeSearchQuery.getRelationType());
    assertTrue(actualEdgeTypes.isEmpty());
    assertSame(edgeTypes, actualEdgeTypes);
    assertSame(parameters, actualParameters);
  }
}
