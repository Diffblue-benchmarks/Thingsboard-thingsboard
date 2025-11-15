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

class EdgeTypeFilterDiffblueTest {
  /**
   * Method under test: {@link EdgeTypeFilter#getEdgeTypes()}
   */
  @Test
  void testGetEdgeTypes() {
    // Arrange and Act
    List<String> actualEdgeTypes = (new EdgeTypeFilter()).getEdgeTypes();

    // Assert
    assertEquals(1, actualEdgeTypes.size());
    assertNull(actualEdgeTypes.get(0));
  }

  /**
   * Method under test: {@link EdgeTypeFilter#getEdgeTypes()}
   */
  @Test
  void testGetEdgeTypes2() {
    // Arrange
    ArrayList<String> edgeTypes = new ArrayList<>();
    edgeTypes.add("foo");

    EdgeTypeFilter edgeTypeFilter = new EdgeTypeFilter();
    edgeTypeFilter.setEdgeTypes(edgeTypes);

    // Act
    List<String> actualEdgeTypes = edgeTypeFilter.getEdgeTypes();

    // Assert
    assertEquals(1, actualEdgeTypes.size());
    assertEquals("foo", actualEdgeTypes.get(0));
    assertSame(edgeTypes, actualEdgeTypes);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeTypeFilter#equals(Object)}
   *   <li>{@link EdgeTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeTypeFilter edgeTypeFilter = new EdgeTypeFilter();
    edgeTypeFilter.setEdgeNameFilter("Edge Name Filter");
    edgeTypeFilter.setEdgeType("Edge Type");
    edgeTypeFilter.setEdgeTypes(new ArrayList<>());

    EdgeTypeFilter edgeTypeFilter2 = new EdgeTypeFilter();
    edgeTypeFilter2.setEdgeNameFilter("Edge Name Filter");
    edgeTypeFilter2.setEdgeType("Edge Type");
    edgeTypeFilter2.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(edgeTypeFilter, edgeTypeFilter2);
    int expectedHashCodeResult = edgeTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, edgeTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeTypeFilter#equals(Object)}
   *   <li>{@link EdgeTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ArrayList<String> edgeTypes = new ArrayList<>();
    edgeTypes.add("Edge Type");

    EdgeTypeFilter edgeTypeFilter = new EdgeTypeFilter();
    edgeTypeFilter.setEdgeNameFilter("Edge Name Filter");
    edgeTypeFilter.setEdgeType("Edge Type");
    edgeTypeFilter.setEdgeTypes(edgeTypes);

    EdgeTypeFilter edgeTypeFilter2 = new EdgeTypeFilter();
    edgeTypeFilter2.setEdgeNameFilter("Edge Name Filter");
    edgeTypeFilter2.setEdgeType("Edge Type");
    edgeTypeFilter2.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(edgeTypeFilter, edgeTypeFilter2);
    int expectedHashCodeResult = edgeTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, edgeTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeTypeFilter#equals(Object)}
   *   <li>{@link EdgeTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EdgeTypeFilter edgeTypeFilter = new EdgeTypeFilter();
    edgeTypeFilter.setEdgeNameFilter(null);
    edgeTypeFilter.setEdgeType("Edge Type");
    edgeTypeFilter.setEdgeTypes(new ArrayList<>());

    EdgeTypeFilter edgeTypeFilter2 = new EdgeTypeFilter();
    edgeTypeFilter2.setEdgeNameFilter(null);
    edgeTypeFilter2.setEdgeType("Edge Type");
    edgeTypeFilter2.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(edgeTypeFilter, edgeTypeFilter2);
    int expectedHashCodeResult = edgeTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, edgeTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeTypeFilter#equals(Object)}
   *   <li>{@link EdgeTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EdgeTypeFilter edgeTypeFilter = new EdgeTypeFilter();
    edgeTypeFilter.setEdgeNameFilter("Edge Name Filter");
    edgeTypeFilter.setEdgeType(null);
    edgeTypeFilter.setEdgeTypes(new ArrayList<>());

    EdgeTypeFilter edgeTypeFilter2 = new EdgeTypeFilter();
    edgeTypeFilter2.setEdgeNameFilter("Edge Name Filter");
    edgeTypeFilter2.setEdgeType(null);
    edgeTypeFilter2.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(edgeTypeFilter, edgeTypeFilter2);
    int expectedHashCodeResult = edgeTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, edgeTypeFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeTypeFilter#equals(Object)}
   *   <li>{@link EdgeTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeTypeFilter edgeTypeFilter = new EdgeTypeFilter();
    edgeTypeFilter.setEdgeNameFilter("Edge Name Filter");
    edgeTypeFilter.setEdgeType("Edge Type");
    edgeTypeFilter.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertEquals(edgeTypeFilter, edgeTypeFilter);
    int expectedHashCodeResult = edgeTypeFilter.hashCode();
    assertEquals(expectedHashCodeResult, edgeTypeFilter.hashCode());
  }

  /**
   * Method under test: {@link EdgeTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeTypeFilter edgeTypeFilter = new EdgeTypeFilter();
    edgeTypeFilter.setEdgeNameFilter("Edge Type");
    edgeTypeFilter.setEdgeType("Edge Type");
    edgeTypeFilter.setEdgeTypes(new ArrayList<>());

    EdgeTypeFilter edgeTypeFilter2 = new EdgeTypeFilter();
    edgeTypeFilter2.setEdgeNameFilter("Edge Name Filter");
    edgeTypeFilter2.setEdgeType("Edge Type");
    edgeTypeFilter2.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(edgeTypeFilter, edgeTypeFilter2);
  }

  /**
   * Method under test: {@link EdgeTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeTypeFilter edgeTypeFilter = new EdgeTypeFilter();
    edgeTypeFilter.setEdgeNameFilter(null);
    edgeTypeFilter.setEdgeType("Edge Type");
    edgeTypeFilter.setEdgeTypes(new ArrayList<>());

    EdgeTypeFilter edgeTypeFilter2 = new EdgeTypeFilter();
    edgeTypeFilter2.setEdgeNameFilter("Edge Name Filter");
    edgeTypeFilter2.setEdgeType("Edge Type");
    edgeTypeFilter2.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(edgeTypeFilter, edgeTypeFilter2);
  }

  /**
   * Method under test: {@link EdgeTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeTypeFilter edgeTypeFilter = new EdgeTypeFilter();
    edgeTypeFilter.setEdgeNameFilter("Edge Name Filter");
    edgeTypeFilter.setEdgeType("Edge Name Filter");
    edgeTypeFilter.setEdgeTypes(new ArrayList<>());

    EdgeTypeFilter edgeTypeFilter2 = new EdgeTypeFilter();
    edgeTypeFilter2.setEdgeNameFilter("Edge Name Filter");
    edgeTypeFilter2.setEdgeType("Edge Type");
    edgeTypeFilter2.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(edgeTypeFilter, edgeTypeFilter2);
  }

  /**
   * Method under test: {@link EdgeTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeTypeFilter edgeTypeFilter = new EdgeTypeFilter();
    edgeTypeFilter.setEdgeNameFilter("Edge Name Filter");
    edgeTypeFilter.setEdgeType(null);
    edgeTypeFilter.setEdgeTypes(new ArrayList<>());

    EdgeTypeFilter edgeTypeFilter2 = new EdgeTypeFilter();
    edgeTypeFilter2.setEdgeNameFilter("Edge Name Filter");
    edgeTypeFilter2.setEdgeType("Edge Type");
    edgeTypeFilter2.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(edgeTypeFilter, edgeTypeFilter2);
  }

  /**
   * Method under test: {@link EdgeTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ArrayList<String> edgeTypes = new ArrayList<>();
    edgeTypes.add("Edge Name Filter");
    edgeTypes.add("Edge Type");

    EdgeTypeFilter edgeTypeFilter = new EdgeTypeFilter();
    edgeTypeFilter.setEdgeNameFilter("Edge Name Filter");
    edgeTypeFilter.setEdgeType("Edge Type");
    edgeTypeFilter.setEdgeTypes(edgeTypes);

    EdgeTypeFilter edgeTypeFilter2 = new EdgeTypeFilter();
    edgeTypeFilter2.setEdgeNameFilter("Edge Name Filter");
    edgeTypeFilter2.setEdgeType("Edge Type");
    edgeTypeFilter2.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(edgeTypeFilter, edgeTypeFilter2);
  }

  /**
   * Method under test: {@link EdgeTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EdgeTypeFilter edgeTypeFilter = new EdgeTypeFilter();
    edgeTypeFilter.setEdgeNameFilter("Edge Name Filter");
    edgeTypeFilter.setEdgeType("Edge Type");
    edgeTypeFilter.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(edgeTypeFilter, null);
  }

  /**
   * Method under test: {@link EdgeTypeFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EdgeTypeFilter edgeTypeFilter = new EdgeTypeFilter();
    edgeTypeFilter.setEdgeNameFilter("Edge Name Filter");
    edgeTypeFilter.setEdgeType("Edge Type");
    edgeTypeFilter.setEdgeTypes(new ArrayList<>());

    // Act and Assert
    assertNotEquals(edgeTypeFilter, "Different type to EdgeTypeFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EdgeTypeFilter}
   *   <li>{@link EdgeTypeFilter#setEdgeNameFilter(String)}
   *   <li>{@link EdgeTypeFilter#setEdgeType(String)}
   *   <li>{@link EdgeTypeFilter#setEdgeTypes(List)}
   *   <li>{@link EdgeTypeFilter#toString()}
   *   <li>{@link EdgeTypeFilter#getEdgeNameFilter()}
   *   <li>{@link EdgeTypeFilter#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EdgeTypeFilter actualEdgeTypeFilter = new EdgeTypeFilter();
    actualEdgeTypeFilter.setEdgeNameFilter("Edge Name Filter");
    actualEdgeTypeFilter.setEdgeType("Edge Type");
    actualEdgeTypeFilter.setEdgeTypes(new ArrayList<>());
    String actualToStringResult = actualEdgeTypeFilter.toString();
    String actualEdgeNameFilter = actualEdgeTypeFilter.getEdgeNameFilter();

    // Assert that nothing has changed
    assertEquals("Edge Name Filter", actualEdgeNameFilter);
    assertEquals("EdgeTypeFilter(edgeType=Edge Type, edgeTypes=[Edge Type], edgeNameFilter=Edge Name Filter)",
        actualToStringResult);
    assertEquals(EntityFilterType.EDGE_TYPE, actualEdgeTypeFilter.getType());
  }
}
