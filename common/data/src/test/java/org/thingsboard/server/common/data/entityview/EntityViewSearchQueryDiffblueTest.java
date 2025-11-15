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

class EntityViewSearchQueryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewSearchQuery#equals(Object)}
   *   <li>{@link EntityViewSearchQuery#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link EntityViewSearchQuery#toEntitySearchQuery()}
   */
  @Test
  void testToEntitySearchQuery() {
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
   * Method under test: {@link EntityViewSearchQuery#toEntitySearchQuery()}
   */
  @Test
  void testToEntitySearchQuery2() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewSearchQuery#equals(Object)}
   *   <li>{@link EntityViewSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(EntityId.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters parameters = new RelationsSearchParameters(entityId, EntitySearchDirection.FROM, 3, true);

    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();
    entityViewSearchQuery.setParameters(parameters);

    EntityViewSearchQuery entityViewSearchQuery2 = new EntityViewSearchQuery();
    entityViewSearchQuery2
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertEquals(entityViewSearchQuery, entityViewSearchQuery2);
    int expectedHashCodeResult = entityViewSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, entityViewSearchQuery2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewSearchQuery#equals(Object)}
   *   <li>{@link EntityViewSearchQuery#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();

    // Act and Assert
    assertEquals(entityViewSearchQuery, entityViewSearchQuery);
    int expectedHashCodeResult = entityViewSearchQuery.hashCode();
    assertEquals(expectedHashCodeResult, entityViewSearchQuery.hashCode());
  }

  /**
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewSearchQuery(), 1);
  }

  /**
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();
    entityViewSearchQuery
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(entityViewSearchQuery, new EntityViewSearchQuery());
  }

  /**
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();
    entityViewSearchQuery.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(entityViewSearchQuery, new EntityViewSearchQuery());
  }

  /**
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();
    entityViewSearchQuery.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityViewSearchQuery, new EntityViewSearchQuery());
  }

  /**
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
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
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();

    EntityViewSearchQuery entityViewSearchQuery2 = new EntityViewSearchQuery();
    entityViewSearchQuery2.setRelationType("Relation Type");

    // Act and Assert
    assertNotEquals(entityViewSearchQuery, entityViewSearchQuery2);
  }

  /**
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();

    EntityViewSearchQuery entityViewSearchQuery2 = new EntityViewSearchQuery();
    entityViewSearchQuery2.setEntityViewTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(entityViewSearchQuery, entityViewSearchQuery2);
  }

  /**
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(EntityId.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters parameters = new RelationsSearchParameters(entityId, EntitySearchDirection.FROM, 3, true);

    EntityViewSearchQuery entityViewSearchQuery = new EntityViewSearchQuery();
    entityViewSearchQuery.setParameters(parameters);

    // Act and Assert
    assertNotEquals(entityViewSearchQuery, new EntityViewSearchQuery());
  }

  /**
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewSearchQuery(), null);
  }

  /**
   * Method under test: {@link EntityViewSearchQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewSearchQuery(), "Different type to EntityViewSearchQuery");
  }

  /**
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

    // Assert that nothing has changed
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
