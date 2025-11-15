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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;

class EdgeSearchQueryFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeSearchQueryFilter#equals(Object)}
   *   <li>{@link EdgeSearchQueryFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeSearchQueryFilter edgeSearchQueryFilter = new EdgeSearchQueryFilter();
    edgeSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    edgeSearchQueryFilter.setEdgeTypes(new ArrayList<>());
    edgeSearchQueryFilter.setFetchLastLevelOnly(true);
    edgeSearchQueryFilter.setMaxLevel(3);
    edgeSearchQueryFilter.setRelationType("Relation Type");
    edgeSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    EdgeSearchQueryFilter edgeSearchQueryFilter2 = new EdgeSearchQueryFilter();
    edgeSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    edgeSearchQueryFilter2.setEdgeTypes(new ArrayList<>());
    edgeSearchQueryFilter2.setFetchLastLevelOnly(true);
    edgeSearchQueryFilter2.setMaxLevel(3);
    edgeSearchQueryFilter2.setRelationType("Relation Type");
    edgeSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(edgeSearchQueryFilter, edgeSearchQueryFilter2);
    int expectedHashCodeResult = edgeSearchQueryFilter.hashCode();
    assertEquals(expectedHashCodeResult, edgeSearchQueryFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeSearchQueryFilter#equals(Object)}
   *   <li>{@link EdgeSearchQueryFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeSearchQueryFilter edgeSearchQueryFilter = new EdgeSearchQueryFilter();
    edgeSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    edgeSearchQueryFilter.setEdgeTypes(new ArrayList<>());
    edgeSearchQueryFilter.setFetchLastLevelOnly(true);
    edgeSearchQueryFilter.setMaxLevel(3);
    edgeSearchQueryFilter.setRelationType("Relation Type");
    edgeSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(edgeSearchQueryFilter, edgeSearchQueryFilter);
    int expectedHashCodeResult = edgeSearchQueryFilter.hashCode();
    assertEquals(expectedHashCodeResult, edgeSearchQueryFilter.hashCode());
  }

  /**
   * Method under test: {@link EdgeSearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeSearchQueryFilter edgeSearchQueryFilter = new EdgeSearchQueryFilter();
    edgeSearchQueryFilter.setDirection(null);
    edgeSearchQueryFilter.setEdgeTypes(new ArrayList<>());
    edgeSearchQueryFilter.setFetchLastLevelOnly(true);
    edgeSearchQueryFilter.setMaxLevel(3);
    edgeSearchQueryFilter.setRelationType("Relation Type");
    edgeSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    EdgeSearchQueryFilter edgeSearchQueryFilter2 = new EdgeSearchQueryFilter();
    edgeSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    edgeSearchQueryFilter2.setEdgeTypes(new ArrayList<>());
    edgeSearchQueryFilter2.setFetchLastLevelOnly(true);
    edgeSearchQueryFilter2.setMaxLevel(3);
    edgeSearchQueryFilter2.setRelationType("Relation Type");
    edgeSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(edgeSearchQueryFilter, edgeSearchQueryFilter2);
  }

  /**
   * Method under test: {@link EdgeSearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<String> edgeTypes = new ArrayList<>();
    edgeTypes.add("Relation Type");

    EdgeSearchQueryFilter edgeSearchQueryFilter = new EdgeSearchQueryFilter();
    edgeSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    edgeSearchQueryFilter.setEdgeTypes(edgeTypes);
    edgeSearchQueryFilter.setFetchLastLevelOnly(true);
    edgeSearchQueryFilter.setMaxLevel(3);
    edgeSearchQueryFilter.setRelationType("Relation Type");
    edgeSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    EdgeSearchQueryFilter edgeSearchQueryFilter2 = new EdgeSearchQueryFilter();
    edgeSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    edgeSearchQueryFilter2.setEdgeTypes(new ArrayList<>());
    edgeSearchQueryFilter2.setFetchLastLevelOnly(true);
    edgeSearchQueryFilter2.setMaxLevel(3);
    edgeSearchQueryFilter2.setRelationType("Relation Type");
    edgeSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(edgeSearchQueryFilter, edgeSearchQueryFilter2);
  }

  /**
   * Method under test: {@link EdgeSearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeSearchQueryFilter edgeSearchQueryFilter = new EdgeSearchQueryFilter();
    edgeSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    edgeSearchQueryFilter.setEdgeTypes(new ArrayList<>());
    edgeSearchQueryFilter.setFetchLastLevelOnly(true);
    edgeSearchQueryFilter.setMaxLevel(3);
    edgeSearchQueryFilter.setRelationType("Relation Type");
    edgeSearchQueryFilter.setRootEntity(mock(EntityId.class));

    EdgeSearchQueryFilter edgeSearchQueryFilter2 = new EdgeSearchQueryFilter();
    edgeSearchQueryFilter2.setDirection(EntitySearchDirection.FROM);
    edgeSearchQueryFilter2.setEdgeTypes(new ArrayList<>());
    edgeSearchQueryFilter2.setFetchLastLevelOnly(true);
    edgeSearchQueryFilter2.setMaxLevel(3);
    edgeSearchQueryFilter2.setRelationType("Relation Type");
    edgeSearchQueryFilter2.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(edgeSearchQueryFilter, edgeSearchQueryFilter2);
  }

  /**
   * Method under test: {@link EdgeSearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EdgeSearchQueryFilter edgeSearchQueryFilter = new EdgeSearchQueryFilter();
    edgeSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    edgeSearchQueryFilter.setEdgeTypes(new ArrayList<>());
    edgeSearchQueryFilter.setFetchLastLevelOnly(true);
    edgeSearchQueryFilter.setMaxLevel(3);
    edgeSearchQueryFilter.setRelationType("Relation Type");
    edgeSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(edgeSearchQueryFilter, null);
  }

  /**
   * Method under test: {@link EdgeSearchQueryFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EdgeSearchQueryFilter edgeSearchQueryFilter = new EdgeSearchQueryFilter();
    edgeSearchQueryFilter.setDirection(EntitySearchDirection.FROM);
    edgeSearchQueryFilter.setEdgeTypes(new ArrayList<>());
    edgeSearchQueryFilter.setFetchLastLevelOnly(true);
    edgeSearchQueryFilter.setMaxLevel(3);
    edgeSearchQueryFilter.setRelationType("Relation Type");
    edgeSearchQueryFilter.setRootEntity(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(edgeSearchQueryFilter, "Different type to EdgeSearchQueryFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EdgeSearchQueryFilter}
   *   <li>{@link EdgeSearchQueryFilter#setEdgeTypes(List)}
   *   <li>{@link EdgeSearchQueryFilter#toString()}
   *   <li>{@link EdgeSearchQueryFilter#getEdgeTypes()}
   *   <li>{@link EdgeSearchQueryFilter#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EdgeSearchQueryFilter actualEdgeSearchQueryFilter = new EdgeSearchQueryFilter();
    ArrayList<String> edgeTypes = new ArrayList<>();
    actualEdgeSearchQueryFilter.setEdgeTypes(edgeTypes);
    String actualToStringResult = actualEdgeSearchQueryFilter.toString();
    List<String> actualEdgeTypes = actualEdgeSearchQueryFilter.getEdgeTypes();
    EntityFilterType actualType = actualEdgeSearchQueryFilter.getType();

    // Assert that nothing has changed
    assertEquals(
        "EdgeSearchQueryFilter(super=EntitySearchQueryFilter(rootEntity=null, relationType=null, direction=null,"
            + " maxLevel=0, fetchLastLevelOnly=false), edgeTypes=[])",
        actualToStringResult);
    assertEquals(0, actualEdgeSearchQueryFilter.getMaxLevel());
    assertEquals(EntityFilterType.EDGE_SEARCH_QUERY, actualType);
    assertFalse(actualEdgeSearchQueryFilter.isFetchLastLevelOnly());
    assertTrue(actualEdgeTypes.isEmpty());
    assertSame(edgeTypes, actualEdgeTypes);
  }
}
