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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EntityRelationsQueryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityRelationsQuery#equals(Object)}
   *   <li>{@link EntityRelationsQuery#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(new ArrayList<>());
    entityRelationsQuery
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    EntityRelationsQuery entityRelationsQuery2 = new EntityRelationsQuery();
    entityRelationsQuery2.setFilters(new ArrayList<>());
    entityRelationsQuery2
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertEquals(entityRelationsQuery, entityRelationsQuery2);
    int expectedHashCodeResult = entityRelationsQuery.hashCode();
    assertEquals(expectedHashCodeResult, entityRelationsQuery2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityRelationsQuery#equals(Object)}
   *   <li>{@link EntityRelationsQuery#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(EntityId.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    RelationsSearchParameters parameters = new RelationsSearchParameters(entityId, EntitySearchDirection.FROM, 3, true);

    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(new ArrayList<>());
    entityRelationsQuery.setParameters(parameters);

    EntityRelationsQuery entityRelationsQuery2 = new EntityRelationsQuery();
    entityRelationsQuery2.setFilters(new ArrayList<>());
    entityRelationsQuery2
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertEquals(entityRelationsQuery, entityRelationsQuery2);
    int expectedHashCodeResult = entityRelationsQuery.hashCode();
    assertEquals(expectedHashCodeResult, entityRelationsQuery2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityRelationsQuery#equals(Object)}
   *   <li>{@link EntityRelationsQuery#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(new ArrayList<>());
    entityRelationsQuery.setParameters(null);

    EntityRelationsQuery entityRelationsQuery2 = new EntityRelationsQuery();
    entityRelationsQuery2.setFilters(new ArrayList<>());
    entityRelationsQuery2.setParameters(null);

    // Act and Assert
    assertEquals(entityRelationsQuery, entityRelationsQuery2);
    int expectedHashCodeResult = entityRelationsQuery.hashCode();
    assertEquals(expectedHashCodeResult, entityRelationsQuery2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityRelationsQuery#equals(Object)}
   *   <li>{@link EntityRelationsQuery#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(new ArrayList<>());
    entityRelationsQuery
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertEquals(entityRelationsQuery, entityRelationsQuery);
    int expectedHashCodeResult = entityRelationsQuery.hashCode();
    assertEquals(expectedHashCodeResult, entityRelationsQuery.hashCode());
  }

  /**
   * Method under test: {@link EntityRelationsQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<RelationEntityTypeFilter> filters = new ArrayList<>();
    filters.add(new RelationEntityTypeFilter());

    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(filters);
    entityRelationsQuery
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    EntityRelationsQuery entityRelationsQuery2 = new EntityRelationsQuery();
    entityRelationsQuery2.setFilters(new ArrayList<>());
    entityRelationsQuery2
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(entityRelationsQuery, entityRelationsQuery2);
  }

  /**
   * Method under test: {@link EntityRelationsQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(new ArrayList<>());
    entityRelationsQuery.setParameters(
        new RelationsSearchParameters(new AlarmId(EntityId.NULL_UUID), EntitySearchDirection.FROM, 3, true));

    EntityRelationsQuery entityRelationsQuery2 = new EntityRelationsQuery();
    entityRelationsQuery2.setFilters(new ArrayList<>());
    entityRelationsQuery2
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(entityRelationsQuery, entityRelationsQuery2);
  }

  /**
   * Method under test: {@link EntityRelationsQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(new ArrayList<>());
    entityRelationsQuery.setParameters(null);

    EntityRelationsQuery entityRelationsQuery2 = new EntityRelationsQuery();
    entityRelationsQuery2.setFilters(new ArrayList<>());
    entityRelationsQuery2
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(entityRelationsQuery, entityRelationsQuery2);
  }

  /**
   * Method under test: {@link EntityRelationsQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(new ArrayList<>());
    entityRelationsQuery
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(entityRelationsQuery, null);
  }

  /**
   * Method under test: {@link EntityRelationsQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(new ArrayList<>());
    entityRelationsQuery
        .setParameters(new RelationsSearchParameters(TenantId.SYS_TENANT_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertNotEquals(entityRelationsQuery, "Different type to EntityRelationsQuery");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityRelationsQuery}
   *   <li>{@link EntityRelationsQuery#setFilters(List)}
   *   <li>{@link EntityRelationsQuery#setParameters(RelationsSearchParameters)}
   *   <li>{@link EntityRelationsQuery#toString()}
   *   <li>{@link EntityRelationsQuery#getFilters()}
   *   <li>{@link EntityRelationsQuery#getParameters()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntityRelationsQuery actualEntityRelationsQuery = new EntityRelationsQuery();
    ArrayList<RelationEntityTypeFilter> filters = new ArrayList<>();
    actualEntityRelationsQuery.setFilters(filters);
    RelationsSearchParameters parameters = new RelationsSearchParameters(TenantId.SYS_TENANT_ID,
        EntitySearchDirection.FROM, 3, true);

    actualEntityRelationsQuery.setParameters(parameters);
    String actualToStringResult = actualEntityRelationsQuery.toString();
    List<RelationEntityTypeFilter> actualFilters = actualEntityRelationsQuery.getFilters();
    RelationsSearchParameters actualParameters = actualEntityRelationsQuery.getParameters();

    // Assert that nothing has changed
    assertEquals(
        "EntityRelationsQuery(parameters=RelationsSearchParameters(rootId=13814000-1dd2-11b2-8080-808080808080,"
            + " rootType=TENANT, direction=FROM, relationTypeGroup=COMMON, maxLevel=3, fetchLastLevelOnly=true),"
            + " filters=[])",
        actualToStringResult);
    assertTrue(actualFilters.isEmpty());
    assertSame(filters, actualFilters);
    assertSame(parameters, actualParameters);
  }
}
