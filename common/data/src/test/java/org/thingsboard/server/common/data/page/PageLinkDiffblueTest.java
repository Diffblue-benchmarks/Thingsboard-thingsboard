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
package org.thingsboard.server.common.data.page;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Sort;

class PageLinkDiffblueTest {
  /**
   * Method under test: {@link PageLink#nextPageLink()}
   */
  @Test
  void testNextPageLink() {
    // Arrange and Act
    PageLink actualNextPageLinkResult = (new PageLink(3)).nextPageLink();

    // Assert
    assertNull(actualNextPageLinkResult.getTextSearch());
    assertNull(actualNextPageLinkResult.getSortOrder());
    assertEquals(1, actualNextPageLinkResult.getPage());
    assertEquals(3, actualNextPageLinkResult.getPageSize());
  }

  /**
   * Method under test: {@link PageLink#nextPageLink()}
   */
  @Test
  void testNextPageLink2() {
    // Arrange and Act
    TimePageLink actualNextPageLinkResult = (new TimePageLink(3)).nextPageLink();

    // Assert
    assertTrue(actualNextPageLinkResult instanceof TimePageLink);
    assertNull(((TimePageLink) actualNextPageLinkResult).getEndTime());
    assertNull(((TimePageLink) actualNextPageLinkResult).getStartTime());
    assertNull(actualNextPageLinkResult.getTextSearch());
    assertNull(actualNextPageLinkResult.getSortOrder());
    assertEquals(1, actualNextPageLinkResult.getPage());
    assertEquals(3, actualNextPageLinkResult.getPageSize());
  }

  /**
   * Method under test: {@link PageLink#toSort(List, Map, boolean)}
   */
  @Test
  void testToSort() {
    // Arrange
    PageLink pageLink = new PageLink(3);
    ArrayList<SortOrder> sortOrders = new ArrayList<>();

    // Act and Assert
    List<Sort.Order> toListResult = pageLink.toSort(sortOrders, new HashMap<>(), true).toList();
    assertEquals(1, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(Sort.Direction.ASC, getResult.getDirection());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
  }

  /**
   * Method under test: {@link PageLink#toSort(List, Map, boolean)}
   */
  @Test
  void testToSort2() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);

    // Act and Assert
    List<Sort.Order> toListResult = pageLink.toSort(sortOrders, new HashMap<>(), true).toList();
    assertEquals(2, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("createdTime", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("createdTime", ignoreCaseResult.getProperty());
    Sort.Order getResult2 = toListResult.get(1);
    assertEquals("id", getResult2.getProperty());
    Sort.Order ignoreCaseResult2 = getResult2.ignoreCase();
    assertEquals("id", ignoreCaseResult2.getProperty());
    assertEquals(Sort.Direction.ASC, getResult2.getDirection());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult2.getDirection());
    assertEquals(Sort.Direction.DESC, getResult.getDirection());
    assertEquals(Sort.Direction.DESC, ignoreCaseResult.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, getResult2.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult2.getNullHandling());
    assertFalse(getResult.isAscending());
    assertFalse(ignoreCaseResult.isAscending());
    assertFalse(getResult2.isDescending());
    assertFalse(ignoreCaseResult2.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertFalse(getResult2.isIgnoreCase());
    assertTrue(getResult2.isAscending());
    assertTrue(ignoreCaseResult2.isAscending());
    assertTrue(getResult.isDescending());
    assertTrue(ignoreCaseResult.isDescending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertTrue(ignoreCaseResult2.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
    assertEquals(ignoreCaseResult2.ignoreCase(), ignoreCaseResult2.ignoreCase());
  }

  /**
   * Method under test: {@link PageLink#toSort(List, Map, boolean)}
   */
  @Test
  void testToSort3() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);

    // Act and Assert
    List<Sort.Order> toListResult = pageLink.toSort(sortOrders, new HashMap<>(), true).toList();
    assertEquals(3, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("createdTime", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("createdTime", ignoreCaseResult.getProperty());
    Sort.Order getResult2 = toListResult.get(2);
    assertEquals("id", getResult2.getProperty());
    Sort.Order ignoreCaseResult2 = getResult2.ignoreCase();
    assertEquals("id", ignoreCaseResult2.getProperty());
    assertEquals(Sort.Direction.ASC, getResult2.getDirection());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult2.getDirection());
    assertEquals(Sort.Direction.DESC, getResult.getDirection());
    assertEquals(Sort.Direction.DESC, ignoreCaseResult.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, getResult2.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult2.getNullHandling());
    assertFalse(getResult.isAscending());
    assertFalse(ignoreCaseResult.isAscending());
    assertFalse(getResult2.isDescending());
    assertFalse(ignoreCaseResult2.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertFalse(getResult2.isIgnoreCase());
    assertTrue(getResult2.isAscending());
    assertTrue(ignoreCaseResult2.isAscending());
    assertTrue(getResult.isDescending());
    assertTrue(ignoreCaseResult.isDescending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertTrue(ignoreCaseResult2.isIgnoreCase());
    assertEquals(getResult, toListResult.get(1));
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
    assertEquals(ignoreCaseResult2.ignoreCase(), ignoreCaseResult2.ignoreCase());
  }

  /**
   * Method under test: {@link PageLink#toSort(List, Map, boolean)}
   */
  @Test
  void testToSort4() {
    // Arrange
    PageLink pageLink = new PageLink(3);
    ArrayList<SortOrder> sortOrders = new ArrayList<>();

    HashMap<String, String> columnMap = new HashMap<>();
    columnMap.put("id", "id");

    // Act and Assert
    List<Sort.Order> toListResult = pageLink.toSort(sortOrders, columnMap, true).toList();
    assertEquals(1, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(Sort.Direction.ASC, getResult.getDirection());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
  }

  /**
   * Method under test: {@link PageLink#toSort(List, Map, boolean)}
   */
  @Test
  void testToSort5() {
    // Arrange
    PageLink pageLink = new PageLink(3);
    ArrayList<SortOrder> sortOrders = new ArrayList<>();

    HashMap<String, String> columnMap = new HashMap<>();
    columnMap.computeIfPresent("id", mock(BiFunction.class));
    columnMap.put("id", "id");

    // Act and Assert
    List<Sort.Order> toListResult = pageLink.toSort(sortOrders, columnMap, true).toList();
    assertEquals(1, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(Sort.Direction.ASC, getResult.getDirection());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
  }

  /**
   * Method under test: {@link PageLink#toSort(List, Map, boolean)}
   */
  @Test
  void testToSort6() {
    // Arrange
    PageLink pageLink = new PageLink(3);
    ArrayList<SortOrder> sortOrders = new ArrayList<>();

    // Act and Assert
    assertTrue(pageLink.toSort(sortOrders, new HashMap<>(), false).toList().isEmpty());
  }

  /**
   * Method under test: {@link PageLink#toSort(List, Map, boolean)}
   */
  @Test
  void testToSort7() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.of("id", SortOrder.Direction.ASC));

    // Act and Assert
    List<Sort.Order> toListResult = pageLink.toSort(sortOrders, new HashMap<>(), true).toList();
    assertEquals(1, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(Sort.Direction.ASC, getResult.getDirection());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
  }

  /**
   * Method under test: {@link PageLink#toSort(SortOrder, Map, boolean)}
   */
  @Test
  void testToSort8() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    // Act and Assert
    List<Sort.Order> toListResult = pageLink.toSort(SortOrder.BY_CREATED_TIME_DESC, new HashMap<>(), true).toList();
    assertEquals(2, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("createdTime", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("createdTime", ignoreCaseResult.getProperty());
    Sort.Order getResult2 = toListResult.get(1);
    assertEquals("id", getResult2.getProperty());
    Sort.Order ignoreCaseResult2 = getResult2.ignoreCase();
    assertEquals("id", ignoreCaseResult2.getProperty());
    assertEquals(Sort.Direction.ASC, getResult2.getDirection());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult2.getDirection());
    assertEquals(Sort.Direction.DESC, getResult.getDirection());
    assertEquals(Sort.Direction.DESC, ignoreCaseResult.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, getResult2.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult2.getNullHandling());
    assertFalse(getResult.isAscending());
    assertFalse(ignoreCaseResult.isAscending());
    assertFalse(getResult2.isDescending());
    assertFalse(ignoreCaseResult2.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertFalse(getResult2.isIgnoreCase());
    assertTrue(getResult2.isAscending());
    assertTrue(ignoreCaseResult2.isAscending());
    assertTrue(getResult.isDescending());
    assertTrue(ignoreCaseResult.isDescending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertTrue(ignoreCaseResult2.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
    assertEquals(ignoreCaseResult2.ignoreCase(), ignoreCaseResult2.ignoreCase());
  }

  /**
   * Method under test: {@link PageLink#toSort(SortOrder, Map, boolean)}
   */
  @Test
  void testToSort9() {
    // Arrange
    PageLink pageLink = new PageLink(3);
    SortOrder sortOrder = SortOrder.of("id", SortOrder.Direction.ASC);

    // Act and Assert
    List<Sort.Order> toListResult = pageLink.toSort(sortOrder, new HashMap<>(), true).toList();
    assertEquals(1, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(Sort.Direction.ASC, getResult.getDirection());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
  }

  /**
   * Method under test: {@link PageLink#toSort(SortOrder, Map, boolean)}
   */
  @Test
  void testToSort10() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    // Act and Assert
    List<Sort.Order> toListResult = pageLink.toSort((SortOrder) null, new HashMap<>(), true).toList();
    assertEquals(1, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(Sort.Direction.ASC, getResult.getDirection());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
  }

  /**
   * Method under test: {@link PageLink#toSort(SortOrder, Map, boolean)}
   */
  @Test
  void testToSort11() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    HashMap<String, String> columnMap = new HashMap<>();
    columnMap.put("id", "id");

    // Act and Assert
    List<Sort.Order> toListResult = pageLink.toSort(SortOrder.BY_CREATED_TIME_DESC, columnMap, true).toList();
    assertEquals(2, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("createdTime", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("createdTime", ignoreCaseResult.getProperty());
    Sort.Order getResult2 = toListResult.get(1);
    assertEquals("id", getResult2.getProperty());
    Sort.Order ignoreCaseResult2 = getResult2.ignoreCase();
    assertEquals("id", ignoreCaseResult2.getProperty());
    assertEquals(Sort.Direction.ASC, getResult2.getDirection());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult2.getDirection());
    assertEquals(Sort.Direction.DESC, getResult.getDirection());
    assertEquals(Sort.Direction.DESC, ignoreCaseResult.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, getResult2.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult2.getNullHandling());
    assertFalse(getResult.isAscending());
    assertFalse(ignoreCaseResult.isAscending());
    assertFalse(getResult2.isDescending());
    assertFalse(ignoreCaseResult2.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertFalse(getResult2.isIgnoreCase());
    assertTrue(getResult2.isAscending());
    assertTrue(ignoreCaseResult2.isAscending());
    assertTrue(getResult.isDescending());
    assertTrue(ignoreCaseResult.isDescending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertTrue(ignoreCaseResult2.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
    assertEquals(ignoreCaseResult2.ignoreCase(), ignoreCaseResult2.ignoreCase());
  }

  /**
   * Method under test: {@link PageLink#toSort(SortOrder, Map, boolean)}
   */
  @Test
  void testToSort12() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    HashMap<String, String> columnMap = new HashMap<>();
    columnMap.computeIfPresent("id", mock(BiFunction.class));
    columnMap.put("id", "id");

    // Act and Assert
    List<Sort.Order> toListResult = pageLink.toSort(SortOrder.BY_CREATED_TIME_DESC, columnMap, true).toList();
    assertEquals(2, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("createdTime", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("createdTime", ignoreCaseResult.getProperty());
    Sort.Order getResult2 = toListResult.get(1);
    assertEquals("id", getResult2.getProperty());
    Sort.Order ignoreCaseResult2 = getResult2.ignoreCase();
    assertEquals("id", ignoreCaseResult2.getProperty());
    assertEquals(Sort.Direction.ASC, getResult2.getDirection());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult2.getDirection());
    assertEquals(Sort.Direction.DESC, getResult.getDirection());
    assertEquals(Sort.Direction.DESC, ignoreCaseResult.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, getResult2.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult2.getNullHandling());
    assertFalse(getResult.isAscending());
    assertFalse(ignoreCaseResult.isAscending());
    assertFalse(getResult2.isDescending());
    assertFalse(ignoreCaseResult2.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertFalse(getResult2.isIgnoreCase());
    assertTrue(getResult2.isAscending());
    assertTrue(ignoreCaseResult2.isAscending());
    assertTrue(getResult.isDescending());
    assertTrue(ignoreCaseResult.isDescending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertTrue(ignoreCaseResult2.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
    assertEquals(ignoreCaseResult2.ignoreCase(), ignoreCaseResult2.ignoreCase());
  }

  /**
   * Method under test: {@link PageLink#toSort(SortOrder, Map, boolean)}
   */
  @Test
  void testToSort13() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    // Act and Assert
    List<Sort.Order> toListResult = pageLink.toSort(SortOrder.BY_CREATED_TIME_DESC, new HashMap<>(), false).toList();
    assertEquals(1, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("createdTime", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("createdTime", ignoreCaseResult.getProperty());
    assertEquals(Sort.Direction.DESC, getResult.getDirection());
    assertEquals(Sort.Direction.DESC, ignoreCaseResult.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertFalse(getResult.isAscending());
    assertFalse(ignoreCaseResult.isAscending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(getResult.isDescending());
    assertTrue(ignoreCaseResult.isDescending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
  }

  /**
   * Method under test: {@link PageLink#isDefaultSortOrderAvailable(List)}
   */
  @Test
  void testIsDefaultSortOrderAvailable() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    // Act and Assert
    assertFalse(pageLink.isDefaultSortOrderAvailable(new ArrayList<>()));
  }

  /**
   * Method under test: {@link PageLink#isDefaultSortOrderAvailable(List)}
   */
  @Test
  void testIsDefaultSortOrderAvailable2() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);

    // Act and Assert
    assertFalse(pageLink.isDefaultSortOrderAvailable(sortOrders));
  }

  /**
   * Method under test: {@link PageLink#isDefaultSortOrderAvailable(List)}
   */
  @Test
  void testIsDefaultSortOrderAvailable3() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);

    // Act and Assert
    assertFalse(pageLink.isDefaultSortOrderAvailable(sortOrders));
  }

  /**
   * Method under test: {@link PageLink#isDefaultSortOrderAvailable(List)}
   */
  @Test
  void testIsDefaultSortOrderAvailable4() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.of("id", SortOrder.Direction.ASC));

    // Act and Assert
    assertTrue(pageLink.isDefaultSortOrderAvailable(sortOrders));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PageLink#equals(Object)}
   *   <li>{@link PageLink#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PageLink pageLink = new PageLink(3);
    PageLink pageLink2 = new PageLink(3);

    // Act and Assert
    assertEquals(pageLink, pageLink2);
    int expectedHashCodeResult = pageLink.hashCode();
    assertEquals(expectedHashCodeResult, pageLink2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PageLink#equals(Object)}
   *   <li>{@link PageLink#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    // Act and Assert
    assertEquals(pageLink, pageLink);
    int expectedHashCodeResult = pageLink.hashCode();
    assertEquals(expectedHashCodeResult, pageLink.hashCode());
  }

  /**
   * Method under test: {@link PageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PageLink pageLink = new PageLink(1);

    // Act and Assert
    assertNotEquals(pageLink, new PageLink(3));
  }

  /**
   * Method under test: {@link PageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PageLink pageLink = new PageLink(3, 1);

    // Act and Assert
    assertNotEquals(pageLink, new PageLink(3));
  }

  /**
   * Method under test: {@link PageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    // Act and Assert
    assertNotEquals(pageLink, new TimePageLink(3, 1));
  }

  /**
   * Method under test: {@link PageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PageLink pageLink = new PageLink(3);
    TimePageLink timePageLink = mock(TimePageLink.class);
    when(timePageLink.getPage()).thenReturn(1);
    when(timePageLink.getTextSearch()).thenReturn("Text Search");
    when(timePageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(timePageLink.getPageSize()).thenReturn(3);
    when(timePageLink.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(pageLink, timePageLink);
  }

  /**
   * Method under test: {@link PageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    PageLink pageLink = new PageLink(3, 1);
    TimePageLink timePageLink = mock(TimePageLink.class);
    when(timePageLink.getPage()).thenReturn(1);
    when(timePageLink.getTextSearch()).thenReturn("Text Search");
    when(timePageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(timePageLink.getPageSize()).thenReturn(3);
    when(timePageLink.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(pageLink, timePageLink);
  }

  /**
   * Method under test: {@link PageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    PageLink pageLink = new PageLink(3, 1, "Text Search");
    TimePageLink timePageLink = mock(TimePageLink.class);
    when(timePageLink.getPage()).thenReturn(1);
    when(timePageLink.getTextSearch()).thenReturn("Text Search");
    when(timePageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(timePageLink.getPageSize()).thenReturn(3);
    when(timePageLink.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(pageLink, timePageLink);
  }

  /**
   * Method under test: {@link PageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    PageLink pageLink = new PageLink(3, 1, "id");
    TimePageLink timePageLink = mock(TimePageLink.class);
    when(timePageLink.getPage()).thenReturn(1);
    when(timePageLink.getTextSearch()).thenReturn("Text Search");
    when(timePageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(timePageLink.getPageSize()).thenReturn(3);
    when(timePageLink.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(pageLink, timePageLink);
  }

  /**
   * Method under test: {@link PageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PageLink(3), null);
  }

  /**
   * Method under test: {@link PageLink#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PageLink(3), "Different type to PageLink");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PageLink#PageLink(int)}
   *   <li>{@link PageLink#toString()}
   *   <li>{@link PageLink#getPage()}
   *   <li>{@link PageLink#getPageSize()}
   *   <li>{@link PageLink#getSortOrder()}
   *   <li>{@link PageLink#getTextSearch()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    PageLink actualPageLink = new PageLink(3);
    String actualToStringResult = actualPageLink.toString();
    int actualPage = actualPageLink.getPage();
    int actualPageSize = actualPageLink.getPageSize();
    SortOrder actualSortOrder = actualPageLink.getSortOrder();

    // Assert
    assertEquals("PageLink(textSearch=null, pageSize=3, page=0, sortOrder=null)", actualToStringResult);
    assertNull(actualPageLink.getTextSearch());
    assertNull(actualSortOrder);
    assertEquals(0, actualPage);
    assertEquals(3, actualPageSize);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PageLink#PageLink(int, int)}
   *   <li>{@link PageLink#toString()}
   *   <li>{@link PageLink#getPage()}
   *   <li>{@link PageLink#getPageSize()}
   *   <li>{@link PageLink#getSortOrder()}
   *   <li>{@link PageLink#getTextSearch()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    PageLink actualPageLink = new PageLink(3, 1);
    String actualToStringResult = actualPageLink.toString();
    int actualPage = actualPageLink.getPage();
    int actualPageSize = actualPageLink.getPageSize();
    SortOrder actualSortOrder = actualPageLink.getSortOrder();

    // Assert
    assertEquals("PageLink(textSearch=null, pageSize=3, page=1, sortOrder=null)", actualToStringResult);
    assertNull(actualPageLink.getTextSearch());
    assertNull(actualSortOrder);
    assertEquals(1, actualPage);
    assertEquals(3, actualPageSize);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PageLink#PageLink(int, int, String)}
   *   <li>{@link PageLink#toString()}
   *   <li>{@link PageLink#getPage()}
   *   <li>{@link PageLink#getPageSize()}
   *   <li>{@link PageLink#getSortOrder()}
   *   <li>{@link PageLink#getTextSearch()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() {
    // Arrange and Act
    PageLink actualPageLink = new PageLink(3, 1, "Text Search");
    String actualToStringResult = actualPageLink.toString();
    int actualPage = actualPageLink.getPage();
    int actualPageSize = actualPageLink.getPageSize();
    SortOrder actualSortOrder = actualPageLink.getSortOrder();

    // Assert
    assertEquals("PageLink(textSearch=Text Search, pageSize=3, page=1, sortOrder=null)", actualToStringResult);
    assertEquals("Text Search", actualPageLink.getTextSearch());
    assertNull(actualSortOrder);
    assertEquals(1, actualPage);
    assertEquals(3, actualPageSize);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PageLink#PageLink(int, int, String, SortOrder)}
   *   <li>{@link PageLink#toString()}
   *   <li>{@link PageLink#getPage()}
   *   <li>{@link PageLink#getPageSize()}
   *   <li>{@link PageLink#getSortOrder()}
   *   <li>{@link PageLink#getTextSearch()}
   * </ul>
   */
  @Test
  void testGettersAndSetters4() {
    // Arrange and Act
    PageLink actualPageLink = new PageLink(3, 1, "Text Search", SortOrder.BY_CREATED_TIME_DESC);
    String actualToStringResult = actualPageLink.toString();
    int actualPage = actualPageLink.getPage();
    int actualPageSize = actualPageLink.getPageSize();
    SortOrder actualSortOrder = actualPageLink.getSortOrder();

    // Assert
    assertEquals("PageLink(textSearch=Text Search, pageSize=3, page=1, sortOrder=SortOrder(property=createdTime,"
        + " direction=DESC))", actualToStringResult);
    assertEquals("Text Search", actualPageLink.getTextSearch());
    assertEquals(1, actualPage);
    assertEquals(3, actualPageSize);
    assertSame(actualSortOrder.BY_CREATED_TIME_DESC, actualSortOrder);
  }

  /**
   * Method under test: {@link PageLink#PageLink(PageLink)}
   */
  @Test
  void testNewPageLink() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    // Act and Assert
    assertEquals(pageLink, new PageLink(pageLink));
  }
}
