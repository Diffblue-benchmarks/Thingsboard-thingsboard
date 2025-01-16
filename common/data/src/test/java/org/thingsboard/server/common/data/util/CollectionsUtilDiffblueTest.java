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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CollectionsUtilDiffblueTest {
  /**
   * Test {@link CollectionsUtil#isEmpty(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#isEmpty(Collection)}
   */
  @Test
  @DisplayName("Test isEmpty(Collection); given '42'; when ArrayList() add '42'; then return 'false'")
  void testIsEmpty_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionsUtil.isEmpty(collection));
  }

  /**
   * Test {@link CollectionsUtil#isEmpty(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#isEmpty(Collection)}
   */
  @Test
  @DisplayName("Test isEmpty(Collection); given '42'; when ArrayList() add '42'; then return 'false'")
  void testIsEmpty_given42_whenArrayListAdd42_thenReturnFalse2() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionsUtil.isEmpty(collection));
  }

  /**
   * Test {@link CollectionsUtil#isEmpty(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#isEmpty(Collection)}
   */
  @Test
  @DisplayName("Test isEmpty(Collection); when ArrayList(); then return 'true'")
  void testIsEmpty_whenArrayList_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CollectionsUtil.isEmpty(new ArrayList<>()));
  }

  /**
   * Test {@link CollectionsUtil#isEmpty(Collection)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#isEmpty(Collection)}
   */
  @Test
  @DisplayName("Test isEmpty(Collection); when 'null'; then return 'true'")
  void testIsEmpty_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CollectionsUtil.isEmpty(null));
  }

  /**
   * Test {@link CollectionsUtil#isNotEmpty(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#isNotEmpty(Collection)}
   */
  @Test
  @DisplayName("Test isNotEmpty(Collection); given '42'; when ArrayList() add '42'; then return 'true'")
  void testIsNotEmpty_given42_whenArrayListAdd42_thenReturnTrue() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertTrue(CollectionsUtil.isNotEmpty(collection));
  }

  /**
   * Test {@link CollectionsUtil#isNotEmpty(Collection)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#isNotEmpty(Collection)}
   */
  @Test
  @DisplayName("Test isNotEmpty(Collection); given '42'; when ArrayList() add '42'; then return 'true'")
  void testIsNotEmpty_given42_whenArrayListAdd42_thenReturnTrue2() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");
    collection.add("42");

    // Act and Assert
    assertTrue(CollectionsUtil.isNotEmpty(collection));
  }

  /**
   * Test {@link CollectionsUtil#isNotEmpty(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#isNotEmpty(Collection)}
   */
  @Test
  @DisplayName("Test isNotEmpty(Collection); when ArrayList(); then return 'false'")
  void testIsNotEmpty_whenArrayList_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CollectionsUtil.isNotEmpty(new ArrayList<>()));
  }

  /**
   * Test {@link CollectionsUtil#isNotEmpty(Collection)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#isNotEmpty(Collection)}
   */
  @Test
  @DisplayName("Test isNotEmpty(Collection); when 'null'; then return 'false'")
  void testIsNotEmpty_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CollectionsUtil.isNotEmpty(null));
  }

  /**
   * Test {@link CollectionsUtil#diffSets(Set, Set)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#diffSets(Set, Set)}
   */
  @Test
  @DisplayName("Test diffSets(Set, Set); given '42'; when HashSet() add '42'; then return Empty")
  void testDiffSets_given42_whenHashSetAdd42_thenReturnEmpty() {
    // Arrange
    HashSet<Object> a = new HashSet<>();
    a.add("42");

    // Act
    Set<Object> actualDiffSetsResult = CollectionsUtil.diffSets(a, new HashSet<>());

    // Assert
    assertTrue(actualDiffSetsResult.isEmpty());
  }

  /**
   * Test {@link CollectionsUtil#diffSets(Set, Set)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#diffSets(Set, Set)}
   */
  @Test
  @DisplayName("Test diffSets(Set, Set); given '42'; when HashSet() add '42'; then return Empty")
  void testDiffSets_given42_whenHashSetAdd42_thenReturnEmpty2() {
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
   * Test {@link CollectionsUtil#diffSets(Set, Set)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#diffSets(Set, Set)}
   */
  @Test
  @DisplayName("Test diffSets(Set, Set); given '42'; when HashSet() add '42'; then return size is one")
  void testDiffSets_given42_whenHashSetAdd42_thenReturnSizeIsOne() {
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
   * Test {@link CollectionsUtil#diffSets(Set, Set)}.
   * <ul>
   *   <li>Given {@link DefaultChannelGroup}.</li>
   *   <li>When {@link HashSet#HashSet()} add {@link DefaultChannelGroup}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#diffSets(Set, Set)}
   */
  @Test
  @DisplayName("Test diffSets(Set, Set); given DefaultChannelGroup; when HashSet() add DefaultChannelGroup")
  void testDiffSets_givenDefaultChannelGroup_whenHashSetAddDefaultChannelGroup() {
    // Arrange
    HashSet<Object> a = new HashSet<>();
    a.add(mock(DefaultChannelGroup.class));

    // Act
    Set<Object> actualDiffSetsResult = CollectionsUtil.diffSets(a, new HashSet<>());

    // Assert
    assertTrue(actualDiffSetsResult.isEmpty());
  }

  /**
   * Test {@link CollectionsUtil#diffSets(Set, Set)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link HashSet#HashSet()} add two.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#diffSets(Set, Set)}
   */
  @Test
  @DisplayName("Test diffSets(Set, Set); given two; when HashSet() add two; then return Empty")
  void testDiffSets_givenTwo_whenHashSetAddTwo_thenReturnEmpty() {
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
   * Test {@link CollectionsUtil#diffSets(Set, Set)}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>When {@link HashSet#HashSet()} add two.</li>
   *   <li>Then return {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#diffSets(Set, Set)}
   */
  @Test
  @DisplayName("Test diffSets(Set, Set); given two; when HashSet() add two; then return HashSet()")
  void testDiffSets_givenTwo_whenHashSetAddTwo_thenReturnHashSet() {
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
   * Test {@link CollectionsUtil#diffSets(Set, Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#diffSets(Set, Set)}
   */
  @Test
  @DisplayName("Test diffSets(Set, Set); when HashSet(); then return Empty")
  void testDiffSets_whenHashSet_thenReturnEmpty() {
    // Arrange
    HashSet<Object> a = new HashSet<>();

    // Act
    Set<Object> actualDiffSetsResult = CollectionsUtil.diffSets(a, new HashSet<>());

    // Assert
    assertTrue(actualDiffSetsResult.isEmpty());
  }

  /**
   * Test {@link CollectionsUtil#diffLists(List, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#diffLists(List, List)}
   */
  @Test
  @DisplayName("Test diffLists(List, List); given '42'; when ArrayList() add '42'; then return ArrayList()")
  void testDiffLists_given42_whenArrayListAdd42_thenReturnArrayList() {
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
   * Test {@link CollectionsUtil#diffLists(List, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#diffLists(List, List)}
   */
  @Test
  @DisplayName("Test diffLists(List, List); given '42'; when ArrayList() add '42'; then return Empty")
  void testDiffLists_given42_whenArrayListAdd42_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> a = new ArrayList<>();
    a.add("42");

    // Act
    List<Object> actualDiffListsResult = CollectionsUtil.diffLists(a, new ArrayList<>());

    // Assert
    assertTrue(actualDiffListsResult.isEmpty());
  }

  /**
   * Test {@link CollectionsUtil#diffLists(List, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#diffLists(List, List)}
   */
  @Test
  @DisplayName("Test diffLists(List, List); given '42'; when ArrayList() add '42'; then return Empty")
  void testDiffLists_given42_whenArrayListAdd42_thenReturnEmpty2() {
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
   * Test {@link CollectionsUtil#diffLists(List, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#diffLists(List, List)}
   */
  @Test
  @DisplayName("Test diffLists(List, List); given '42'; when ArrayList() add '42'; then return Empty")
  void testDiffLists_given42_whenArrayListAdd42_thenReturnEmpty3() {
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
   * Test {@link CollectionsUtil#diffLists(List, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#diffLists(List, List)}
   */
  @Test
  @DisplayName("Test diffLists(List, List); given '42'; when ArrayList() add '42'; then return size is one")
  void testDiffLists_given42_whenArrayListAdd42_thenReturnSizeIsOne() {
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
   * Test {@link CollectionsUtil#diffLists(List, List)}.
   * <ul>
   *   <li>Given {@link ByteListImpl}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ByteListImpl}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#diffLists(List, List)}
   */
  @Test
  @DisplayName("Test diffLists(List, List); given ByteListImpl; when ArrayList() add ByteListImpl; then return Empty")
  void testDiffLists_givenByteListImpl_whenArrayListAddByteListImpl_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> a = new ArrayList<>();
    a.add(mock(ByteListImpl.class));

    // Act
    List<Object> actualDiffListsResult = CollectionsUtil.diffLists(a, new ArrayList<>());

    // Assert
    assertTrue(actualDiffListsResult.isEmpty());
  }

  /**
   * Test {@link CollectionsUtil#diffLists(List, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#diffLists(List, List)}
   */
  @Test
  @DisplayName("Test diffLists(List, List); when ArrayList(); then return Empty")
  void testDiffLists_whenArrayList_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> a = new ArrayList<>();

    // Act
    List<Object> actualDiffListsResult = CollectionsUtil.diffLists(a, new ArrayList<>());

    // Assert
    assertTrue(actualDiffListsResult.isEmpty());
  }

  /**
   * Test {@link CollectionsUtil#contains(Collection, Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#contains(Collection, Object)}
   */
  @Test
  @DisplayName("Test contains(Collection, Object); given '42'; when '42'; then return 'true'")
  void testContains_given42_when42_thenReturnTrue() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertTrue(CollectionsUtil.contains(collection, "42"));
  }

  /**
   * Test {@link CollectionsUtil#contains(Collection, Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#contains(Collection, Object)}
   */
  @Test
  @DisplayName("Test contains(Collection, Object); given '42'; when ArrayList() add '42'; then return 'false'")
  void testContains_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionsUtil.contains(collection, "Element"));
  }

  /**
   * Test {@link CollectionsUtil#contains(Collection, Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#contains(Collection, Object)}
   */
  @Test
  @DisplayName("Test contains(Collection, Object); given '42'; when ArrayList() add '42'; then return 'false'")
  void testContains_given42_whenArrayListAdd42_thenReturnFalse2() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionsUtil.contains(collection, "Element"));
  }

  /**
   * Test {@link CollectionsUtil#contains(Collection, Object)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#contains(Collection, Object)}
   */
  @Test
  @DisplayName("Test contains(Collection, Object); when ArrayList(); then return 'false'")
  void testContains_whenArrayList_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CollectionsUtil.contains(new ArrayList<>(), "Element"));
  }

  /**
   * Test {@link CollectionsUtil#contains(Collection, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#contains(Collection, Object)}
   */
  @Test
  @DisplayName("Test contains(Collection, Object); when 'null'; then return 'false'")
  void testContains_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CollectionsUtil.contains(null, "Element"));
  }

  /**
   * Test {@link CollectionsUtil#countNonNull(Object[])}.
   * <ul>
   *   <li>When array of {@link Object} with {@code Array}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#countNonNull(Object[])}
   */
  @Test
  @DisplayName("Test countNonNull(Object[]); when array of Object with 'Array'; then return one")
  void testCountNonNull_whenArrayOfObjectWithArray_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, CollectionsUtil.countNonNull(new Object[]{"Array"}));
  }

  /**
   * Test {@link CollectionsUtil#countNonNull(Object[])}.
   * <ul>
   *   <li>When array of {@link Object} with {@code null}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#countNonNull(Object[])}
   */
  @Test
  @DisplayName("Test countNonNull(Object[]); when array of Object with 'null'; then return zero")
  void testCountNonNull_whenArrayOfObjectWithNull_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, CollectionsUtil.countNonNull(new Object[]{null}));
  }

  /**
   * Test {@link CollectionsUtil#mapOf(Object[])}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#mapOf(Object[])}
   */
  @Test
  @DisplayName("Test mapOf(Object[]); then return Empty")
  void testMapOf_thenReturnEmpty() {
    // Arrange and Act
    Map<Object, Object> actualMapOfResult = CollectionsUtil.mapOf();

    // Assert
    assertTrue(actualMapOfResult.isEmpty());
  }

  /**
   * Test {@link CollectionsUtil#mapOf(Object[])}.
   * <ul>
   *   <li>When {@code Kvs} and {@code Kvs}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#mapOf(Object[])}
   */
  @Test
  @DisplayName("Test mapOf(Object[]); when 'Kvs' and 'Kvs'; then return size is one")
  void testMapOf_whenKvsAndKvs_thenReturnSizeIsOne() {
    // Arrange and Act
    Map<Object, Object> actualMapOfResult = CollectionsUtil.mapOf("Kvs", "Kvs");

    // Assert
    assertEquals(1, actualMapOfResult.size());
    assertEquals("Kvs", actualMapOfResult.get("Kvs"));
  }

  /**
   * Test {@link CollectionsUtil#mapOf(Object[])}.
   * <ul>
   *   <li>When {@code Kvs}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CollectionsUtil#mapOf(Object[])}
   */
  @Test
  @DisplayName("Test mapOf(Object[]); when 'Kvs'; then throw IllegalArgumentException")
  void testMapOf_whenKvs_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> CollectionsUtil.mapOf("Kvs"));
  }

  /**
   * Test {@link CollectionsUtil#emptyOrContains(Collection, Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionsUtil#emptyOrContains(Collection, Object)}
   */
  @Test
  @DisplayName("Test emptyOrContains(Collection, Object); given '42'; when '42'; then return 'true'")
  void testEmptyOrContains_given42_when42_thenReturnTrue() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertTrue(CollectionsUtil.emptyOrContains(collection, "42"));
  }

  /**
   * Test {@link CollectionsUtil#emptyOrContains(Collection, Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionsUtil#emptyOrContains(Collection, Object)}
   */
  @Test
  @DisplayName("Test emptyOrContains(Collection, Object); given '42'; when ArrayList() add '42'; then return 'false'")
  void testEmptyOrContains_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionsUtil.emptyOrContains(collection, "Element"));
  }

  /**
   * Test {@link CollectionsUtil#emptyOrContains(Collection, Object)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionsUtil#emptyOrContains(Collection, Object)}
   */
  @Test
  @DisplayName("Test emptyOrContains(Collection, Object); given '42'; when ArrayList() add '42'; then return 'false'")
  void testEmptyOrContains_given42_whenArrayListAdd42_thenReturnFalse2() {
    // Arrange
    ArrayList<Object> collection = new ArrayList<>();
    collection.add("42");
    collection.add("42");

    // Act and Assert
    assertFalse(CollectionsUtil.emptyOrContains(collection, "Element"));
  }

  /**
   * Test {@link CollectionsUtil#emptyOrContains(Collection, Object)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionsUtil#emptyOrContains(Collection, Object)}
   */
  @Test
  @DisplayName("Test emptyOrContains(Collection, Object); when ArrayList(); then return 'true'")
  void testEmptyOrContains_whenArrayList_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CollectionsUtil.emptyOrContains(new ArrayList<>(), "Element"));
  }

  /**
   * Test {@link CollectionsUtil#emptyOrContains(Collection, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CollectionsUtil#emptyOrContains(Collection, Object)}
   */
  @Test
  @DisplayName("Test emptyOrContains(Collection, Object); when 'null'; then return 'true'")
  void testEmptyOrContains_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CollectionsUtil.emptyOrContains(null, "Element"));
  }
}
