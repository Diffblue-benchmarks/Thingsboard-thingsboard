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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EdgeTypeFilterDiffblueTest {
  /**
   * Test {@link EdgeTypeFilter#getEdgeTypes()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return first is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeTypeFilter#getEdgeTypes()}
   */
  @Test
  @DisplayName("Test getEdgeTypes(); given ArrayList() add 'foo'; then return first is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List EdgeTypeFilter.getEdgeTypes()"})
  void testGetEdgeTypes_givenArrayListAddFoo_thenReturnFirstIsFoo() {
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
   * Test {@link EdgeTypeFilter#getEdgeTypes()}.
   * <ul>
   *   <li>Given {@link EdgeTypeFilter} (default constructor).</li>
   *   <li>Then return first is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeTypeFilter#getEdgeTypes()}
   */
  @Test
  @DisplayName("Test getEdgeTypes(); given EdgeTypeFilter (default constructor); then return first is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List EdgeTypeFilter.getEdgeTypes()"})
  void testGetEdgeTypes_givenEdgeTypeFilter_thenReturnFirstIsNull() {
    // Arrange and Act
    List<String> actualEdgeTypes = (new EdgeTypeFilter()).getEdgeTypes();

    // Assert
    assertEquals(1, actualEdgeTypes.size());
    assertNull(actualEdgeTypes.get(0));
  }

  /**
   * Test {@link EdgeTypeFilter#equals(Object)}, and {@link EdgeTypeFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeTypeFilter#equals(Object)}
   *   <li>{@link EdgeTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeTypeFilter.equals(Object)", "int EdgeTypeFilter.hashCode()"})
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
   * Test {@link EdgeTypeFilter#equals(Object)}, and {@link EdgeTypeFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeTypeFilter#equals(Object)}
   *   <li>{@link EdgeTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeTypeFilter.equals(Object)", "int EdgeTypeFilter.hashCode()"})
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
   * Test {@link EdgeTypeFilter#equals(Object)}, and {@link EdgeTypeFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeTypeFilter#equals(Object)}
   *   <li>{@link EdgeTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeTypeFilter.equals(Object)", "int EdgeTypeFilter.hashCode()"})
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
   * Test {@link EdgeTypeFilter#equals(Object)}, and {@link EdgeTypeFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeTypeFilter#equals(Object)}
   *   <li>{@link EdgeTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeTypeFilter.equals(Object)", "int EdgeTypeFilter.hashCode()"})
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
   * Test {@link EdgeTypeFilter#equals(Object)}, and {@link EdgeTypeFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeTypeFilter#equals(Object)}
   *   <li>{@link EdgeTypeFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeTypeFilter.equals(Object)", "int EdgeTypeFilter.hashCode()"})
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
   * Test {@link EdgeTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeTypeFilter.equals(Object)", "int EdgeTypeFilter.hashCode()"})
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
   * Test {@link EdgeTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeTypeFilter.equals(Object)", "int EdgeTypeFilter.hashCode()"})
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
   * Test {@link EdgeTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeTypeFilter.equals(Object)", "int EdgeTypeFilter.hashCode()"})
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
   * Test {@link EdgeTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeTypeFilter.equals(Object)", "int EdgeTypeFilter.hashCode()"})
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
   * Test {@link EdgeTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeTypeFilter.equals(Object)", "int EdgeTypeFilter.hashCode()"})
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
   * Test {@link EdgeTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeTypeFilter.equals(Object)", "int EdgeTypeFilter.hashCode()"})
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
   * Test {@link EdgeTypeFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeTypeFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeTypeFilter.equals(Object)", "int EdgeTypeFilter.hashCode()"})
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeTypeFilter.<init>()", "String EdgeTypeFilter.getEdgeNameFilter()",
      "EntityFilterType EdgeTypeFilter.getType()", "void EdgeTypeFilter.setEdgeNameFilter(String)",
      "void EdgeTypeFilter.setEdgeType(String)", "void EdgeTypeFilter.setEdgeTypes(List)",
      "String EdgeTypeFilter.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EdgeTypeFilter actualEdgeTypeFilter = new EdgeTypeFilter();
    actualEdgeTypeFilter.setEdgeNameFilter("Edge Name Filter");
    actualEdgeTypeFilter.setEdgeType("Edge Type");
    actualEdgeTypeFilter.setEdgeTypes(new ArrayList<>());
    String actualToStringResult = actualEdgeTypeFilter.toString();
    String actualEdgeNameFilter = actualEdgeTypeFilter.getEdgeNameFilter();

    // Assert
    assertEquals("Edge Name Filter", actualEdgeNameFilter);
    assertEquals("EdgeTypeFilter(edgeType=Edge Type, edgeTypes=[Edge Type], edgeNameFilter=Edge Name Filter)",
        actualToStringResult);
    assertEquals(EntityFilterType.EDGE_TYPE, actualEdgeTypeFilter.getType());
  }
}
