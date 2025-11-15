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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;

class EdgeSearchQueryFilterDiffblueTest {
  /**
   * Test {@link EdgeSearchQueryFilter#equals(Object)}, and {@link EdgeSearchQueryFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeSearchQueryFilter#equals(Object)}
   *   <li>{@link EdgeSearchQueryFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeSearchQueryFilter.equals(Object)", "int EdgeSearchQueryFilter.hashCode()"})
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
   * Test {@link EdgeSearchQueryFilter#equals(Object)}, and {@link EdgeSearchQueryFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeSearchQueryFilter#equals(Object)}
   *   <li>{@link EdgeSearchQueryFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeSearchQueryFilter.equals(Object)", "int EdgeSearchQueryFilter.hashCode()"})
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
   * Test {@link EdgeSearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeSearchQueryFilter.equals(Object)", "int EdgeSearchQueryFilter.hashCode()"})
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
   * Test {@link EdgeSearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeSearchQueryFilter.equals(Object)", "int EdgeSearchQueryFilter.hashCode()"})
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
   * Test {@link EdgeSearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeSearchQueryFilter.equals(Object)", "int EdgeSearchQueryFilter.hashCode()"})
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
   * Test {@link EdgeSearchQueryFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeSearchQueryFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeSearchQueryFilter.equals(Object)", "int EdgeSearchQueryFilter.hashCode()"})
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeSearchQueryFilter.<init>()", "List EdgeSearchQueryFilter.getEdgeTypes()",
      "EntityFilterType EdgeSearchQueryFilter.getType()", "void EdgeSearchQueryFilter.setEdgeTypes(List)",
      "String EdgeSearchQueryFilter.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EdgeSearchQueryFilter actualEdgeSearchQueryFilter = new EdgeSearchQueryFilter();
    ArrayList<String> edgeTypes = new ArrayList<>();
    actualEdgeSearchQueryFilter.setEdgeTypes(edgeTypes);
    String actualToStringResult = actualEdgeSearchQueryFilter.toString();
    List<String> actualEdgeTypes = actualEdgeSearchQueryFilter.getEdgeTypes();
    EntityFilterType actualType = actualEdgeSearchQueryFilter.getType();

    // Assert
    assertEquals(
        "EdgeSearchQueryFilter(super=EntitySearchQueryFilter(rootEntity=null, relationType=null, direction=null,"
            + " maxLevel=0, fetchLastLevelOnly=false), edgeTypes=[])",
        actualToStringResult);
    assertNull(actualEdgeSearchQueryFilter.getRelationType());
    assertNull(actualEdgeSearchQueryFilter.getRootEntity());
    assertNull(actualEdgeSearchQueryFilter.getDirection());
    assertEquals(0, actualEdgeSearchQueryFilter.getMaxLevel());
    assertEquals(EntityFilterType.EDGE_SEARCH_QUERY, actualType);
    assertFalse(actualEdgeSearchQueryFilter.isFetchLastLevelOnly());
    assertTrue(actualEdgeTypes.isEmpty());
    assertSame(edgeTypes, actualEdgeTypes);
  }
}
