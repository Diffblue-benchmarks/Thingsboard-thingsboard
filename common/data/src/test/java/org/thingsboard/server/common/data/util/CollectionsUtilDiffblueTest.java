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
package org.thingsboard.server.common.data.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import io.netty.channel.group.DefaultChannelGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.xerces.impl.dv.util.ByteListImpl;
import org.junit.jupiter.api.Test;

class CollectionsUtilDiffblueTest {
  /**
   * Method under test: {@link CollectionsUtil#isEmpty(Collection)}
   */
  @Test
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue(CollectionsUtil.isEmpty(new ArrayList<>()));
    assertTrue(CollectionsUtil.isEmpty(null));
  }

  /**
   * Method under test: {@link CollectionsUtil#isEmpty(Collection)}
   */
  @Test
  void testIsEmpty2() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionsUtil.isEmpty(collection));
  }

  /**
   * Method under test: {@link CollectionsUtil#isEmpty(Collection)}
   */
  @Test
  void testIsEmpty3() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionsUtil.isEmpty(collection));
  }

  /**
   * Method under test: {@link CollectionsUtil#isNotEmpty(Collection)}
   */
  @Test
  void testIsNotEmpty() {
    // Arrange, Act and Assert
    assertFalse(CollectionsUtil.isNotEmpty(new ArrayList<>()));
    assertFalse(CollectionsUtil.isNotEmpty(null));
  }

  /**
   * Method under test: {@link CollectionsUtil#isNotEmpty(Collection)}
   */
  @Test
  void testIsNotEmpty2() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertTrue(CollectionsUtil.isNotEmpty(collection));
  }

  /**
   * Method under test: {@link CollectionsUtil#isNotEmpty(Collection)}
   */
  @Test
  void testIsNotEmpty3() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");
    collection.add("42");

    // Act and Assert
    assertTrue(CollectionsUtil.isNotEmpty(collection));
  }

  /**
   * Method under test: {@link CollectionsUtil#diffSets(Set, Set)}
   */
  @Test
  void testDiffSets() {
    // Arrange
    HashSet<Object> a = new HashSet<>();

    // Act
    Set<Object> actualDiffSetsResult = CollectionsUtil.diffSets(a, new HashSet<>());

    // Assert
    assertTrue(actualDiffSetsResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionsUtil#diffSets(Set, Set)}
   */
  @Test
  void testDiffSets2() {
    // Arrange
    HashSet<Object> a = new HashSet<>();
    a.add("42");

    // Act
    Set<Object> actualDiffSetsResult = CollectionsUtil.diffSets(a, new HashSet<>());

    // Assert
    assertTrue(actualDiffSetsResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionsUtil#diffSets(Set, Set)}
   */
  @Test
  void testDiffSets3() {
    // Arrange
    HashSet<Object> a = new HashSet<>();
    a.add(mock(DefaultChannelGroup.class));

    // Act
    Set<Object> actualDiffSetsResult = CollectionsUtil.diffSets(a, new HashSet<>());

    // Assert
    assertTrue(actualDiffSetsResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionsUtil#diffSets(Set, Set)}
   */
  @Test
  void testDiffSets4() {
    // Arrange
    HashSet<Object> a = new HashSet<>();
    a.add(2);
    a.add("42");

    // Act
    Set<Object> actualDiffSetsResult = CollectionsUtil.diffSets(a, new HashSet<>());

    // Assert
    assertTrue(actualDiffSetsResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionsUtil#diffSets(Set, Set)}
   */
  @Test
  void testDiffSets5() {
    // Arrange
    HashSet<Object> a = new HashSet<>();

    HashSet<Object> b = new HashSet<>();
    b.add("42");

    // Act
    Set<Object> actualDiffSetsResult = CollectionsUtil.diffSets(a, b);

    // Assert
    assertEquals(1, actualDiffSetsResult.size());
  }

  /**
   * Method under test: {@link CollectionsUtil#diffSets(Set, Set)}
   */
  @Test
  void testDiffSets6() {
    // Arrange
    HashSet<Object> a = new HashSet<>();

    HashSet<Object> b = new HashSet<>();
    b.add(2);
    b.add("42");

    // Act
    Set<Object> actualDiffSetsResult = CollectionsUtil.diffSets(a, b);

    // Assert
    assertEquals(b, actualDiffSetsResult);
  }

  /**
   * Method under test: {@link CollectionsUtil#diffSets(Set, Set)}
   */
  @Test
  void testDiffSets7() {
    // Arrange
    HashSet<Object> a = new HashSet<>();
    a.add("42");

    HashSet<Object> b = new HashSet<>();
    b.add("42");

    // Act
    Set<Object> actualDiffSetsResult = CollectionsUtil.diffSets(a, b);

    // Assert
    assertTrue(actualDiffSetsResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionsUtil#diffLists(List, List)}
   */
  @Test
  void testDiffLists() {
    // Arrange
    ArrayList<Object> a = new ArrayList<>();

    // Act
    List<Object> actualDiffListsResult = CollectionsUtil.diffLists(a, new ArrayList<>());

    // Assert
    assertTrue(actualDiffListsResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionsUtil#diffLists(List, List)}
   */
  @Test
  void testDiffLists2() {
    // Arrange
    ArrayList<Object> a = new ArrayList<>();
    a.add("42");

    // Act
    List<Object> actualDiffListsResult = CollectionsUtil.diffLists(a, new ArrayList<>());

    // Assert
    assertTrue(actualDiffListsResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionsUtil#diffLists(List, List)}
   */
  @Test
  void testDiffLists3() {
    // Arrange
    ArrayList<Object> a = new ArrayList<>();
    a.add("42");
    a.add("42");

    // Act
    List<Object> actualDiffListsResult = CollectionsUtil.diffLists(a, new ArrayList<>());

    // Assert
    assertTrue(actualDiffListsResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionsUtil#diffLists(List, List)}
   */
  @Test
  void testDiffLists4() {
    // Arrange
    ArrayList<Object> a = new ArrayList<>();
    a.add(mock(ByteListImpl.class));

    // Act
    List<Object> actualDiffListsResult = CollectionsUtil.diffLists(a, new ArrayList<>());

    // Assert
    assertTrue(actualDiffListsResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionsUtil#diffLists(List, List)}
   */
  @Test
  void testDiffLists5() {
    // Arrange
    ArrayList<Object> a = new ArrayList<>();

    ArrayList<Object> b = new ArrayList<>();
    b.add("42");

    // Act
    List<Object> actualDiffListsResult = CollectionsUtil.diffLists(a, b);

    // Assert
    assertEquals(1, actualDiffListsResult.size());
    assertEquals("42", actualDiffListsResult.get(0));
  }

  /**
   * Method under test: {@link CollectionsUtil#diffLists(List, List)}
   */
  @Test
  void testDiffLists6() {
    // Arrange
    ArrayList<Object> a = new ArrayList<>();

    ArrayList<Object> b = new ArrayList<>();
    b.add("42");
    b.add("42");

    // Act
    List<Object> actualDiffListsResult = CollectionsUtil.diffLists(a, b);

    // Assert
    assertEquals(b, actualDiffListsResult);
  }

  /**
   * Method under test: {@link CollectionsUtil#diffLists(List, List)}
   */
  @Test
  void testDiffLists7() {
    // Arrange
    ArrayList<Object> a = new ArrayList<>();
    a.add("42");

    ArrayList<Object> b = new ArrayList<>();
    b.add("42");

    // Act
    List<Object> actualDiffListsResult = CollectionsUtil.diffLists(a, b);

    // Assert
    assertTrue(actualDiffListsResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionsUtil#contains(Collection, Object)}
   */
  @Test
  void testContains() {
    // Arrange, Act and Assert
    assertFalse(CollectionsUtil.contains(new ArrayList<>(), "Element"));
    assertFalse(CollectionsUtil.contains(null, "Element"));
  }

  /**
   * Method under test: {@link CollectionsUtil#contains(Collection, Object)}
   */
  @Test
  void testContains2() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionsUtil.contains(collection, "Element"));
  }

  /**
   * Method under test: {@link CollectionsUtil#contains(Collection, Object)}
   */
  @Test
  void testContains3() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionsUtil.contains(collection, "Element"));
  }

  /**
   * Method under test: {@link CollectionsUtil#contains(Collection, Object)}
   */
  @Test
  void testContains4() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertTrue(CollectionsUtil.contains(collection, "42"));
  }

  /**
   * Method under test: {@link CollectionsUtil#countNonNull(Object[])}
   */
  @Test
  void testCountNonNull() {
    // Arrange, Act and Assert
    assertEquals(1, CollectionsUtil.countNonNull(new Object[]{"Array"}));
    assertEquals(0, CollectionsUtil.countNonNull(new Object[]{null}));
  }

  /**
   * Method under test: {@link CollectionsUtil#mapOf(Object[])}
   */
  @Test
  void testMapOf() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CollectionsUtil.mapOf("Kvs"));
  }

  /**
   * Method under test: {@link CollectionsUtil#mapOf(Object[])}
   */
  @Test
  void testMapOf2() {
    // Arrange and Act
    Map<Object, Object> actualMapOfResult = CollectionsUtil.mapOf();

    // Assert
    assertTrue(actualMapOfResult.isEmpty());
  }

  /**
   * Method under test: {@link CollectionsUtil#mapOf(Object[])}
   */
  @Test
  void testMapOf3() {
    // Arrange and Act
    Map<Object, Object> actualMapOfResult = CollectionsUtil.mapOf("Kvs", "Kvs");

    // Assert
    assertEquals(1, actualMapOfResult.size());
    assertEquals("Kvs", actualMapOfResult.get("Kvs"));
  }

  /**
   * Method under test:
   * {@link CollectionsUtil#emptyOrContains(Collection, Object)}
   */
  @Test
  void testEmptyOrContains() {
    // Arrange, Act and Assert
    assertTrue(CollectionsUtil.emptyOrContains(new ArrayList<>(), "Element"));
    assertTrue(CollectionsUtil.emptyOrContains(null, "Element"));
  }

  /**
   * Method under test:
   * {@link CollectionsUtil#emptyOrContains(Collection, Object)}
   */
  @Test
  void testEmptyOrContains2() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionsUtil.emptyOrContains(collection, "Element"));
  }

  /**
   * Method under test:
   * {@link CollectionsUtil#emptyOrContains(Collection, Object)}
   */
  @Test
  void testEmptyOrContains3() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionsUtil.emptyOrContains(collection, "Element"));
  }

  /**
   * Method under test:
   * {@link CollectionsUtil#emptyOrContains(Collection, Object)}
   */
  @Test
  void testEmptyOrContains4() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertTrue(CollectionsUtil.emptyOrContains(collection, "42"));
  }
}
