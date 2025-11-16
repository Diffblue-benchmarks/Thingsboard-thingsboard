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
package org.thingsboard.server.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.NullHandling;
import org.springframework.data.domain.Sort.Order;
import org.thingsboard.server.common.data.EntityInfo;
import org.thingsboard.server.common.data.EntitySubtype;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.ToData;

public class DaoUtilDiffblueTest {
  /**
   * Test {@link DaoUtil#toPageData(Page)}.
   *
   * <ul>
   *   <li>Given {@link ToData} {@link ToData#toData()} return {@code Data}.
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#toPageData(Page)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DaoUtil.toPageData(Page)"})
  public void testToPageData_givenToDataToDataReturnData_thenReturnDataSizeIsOne() {
    // Arrange
    ToData<Object> toData = mock(ToData.class);
    when(toData.toData()).thenReturn("Data");

    ArrayList<ToData<Object>> content = new ArrayList<>();
    content.add(toData);

    // Act
    PageData<Object> actualToPageDataResult = DaoUtil.toPageData(new PageImpl<>(content));

    // Assert
    verify(toData).toData();
    List<Object> data = actualToPageDataResult.getData();
    assertEquals(1, data.size());
    assertEquals("Data", data.get(0));
    assertEquals(1L, actualToPageDataResult.getTotalElements());
  }

  /**
   * Test {@link DaoUtil#toPageData(Page)}.
   *
   * <ul>
   *   <li>When {@link PageImpl#PageImpl(List)} with content is {@link ArrayList#ArrayList()}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#toPageData(Page)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DaoUtil.toPageData(Page)"})
  public void testToPageData_whenPageImplWithContentIsArrayList_thenReturnTotalElementsIsZero() {
    // Arrange and Act
    PageData<Object> actualToPageDataResult = DaoUtil.toPageData(new PageImpl<>(new ArrayList<>()));

    // Assert
    assertEquals(0L, actualToPageDataResult.getTotalElements());
    assertEquals(1, actualToPageDataResult.getTotalPages());
    assertFalse(actualToPageDataResult.hasNext());
    assertTrue(actualToPageDataResult.getData().isEmpty());
  }

  /**
   * Test {@link DaoUtil#pageToPageData(Slice)}.
   *
   * <ul>
   *   <li>Then return TotalPages is zero.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#pageToPageData(Slice)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DaoUtil.pageToPageData(Slice)"})
  public void testPageToPageData_thenReturnTotalPagesIsZero() {
    // Arrange and Act
    PageData<Object> actualPageToPageDataResult =
        DaoUtil.pageToPageData(new SliceImpl<>(new ArrayList<>()));

    // Assert
    assertEquals(0, actualPageToPageDataResult.getTotalPages());
    assertEquals(0L, actualPageToPageDataResult.getTotalElements());
    assertFalse(actualPageToPageDataResult.hasNext());
    assertTrue(actualPageToPageDataResult.getData().isEmpty());
  }

  /**
   * Test {@link DaoUtil#pageToPageData(Slice)}.
   *
   * <ul>
   *   <li>When {@link PageImpl#PageImpl(List)} with content is {@link ArrayList#ArrayList()}.
   *   <li>Then return TotalPages is one.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#pageToPageData(Slice)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData DaoUtil.pageToPageData(Slice)"})
  public void testPageToPageData_whenPageImplWithContentIsArrayList_thenReturnTotalPagesIsOne() {
    // Arrange and Act
    PageData<Object> actualPageToPageDataResult =
        DaoUtil.pageToPageData(new PageImpl<>(new ArrayList<>()));

    // Assert
    assertEquals(0L, actualPageToPageDataResult.getTotalElements());
    assertEquals(1, actualPageToPageDataResult.getTotalPages());
    assertFalse(actualPageToPageDataResult.hasNext());
    assertTrue(actualPageToPageDataResult.getData().isEmpty());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, boolean)} with {@code pageLink}, {@code
   * addDefaultSorting}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageRequest}.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink, boolean)"})
  public void testToPageableWithPageLinkAddDefaultSorting_whenFirst_page_thenReturnPageRequest() {
    // Arrange and Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, true);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    assertEquals(0, actualToPageableResult.getPageNumber());
    assertEquals(0L, actualToPageableResult.getOffset());
    assertEquals(1000, actualToPageableResult.getPageSize());
    assertFalse(actualToPageableResult.hasPrevious());
    assertFalse(actualToPageableResult.isUnpaged());
    assertTrue(actualToPageableResult.isPaged());
    Pageable actualFirstResult = actualToPageableResult.first();
    assertEquals(actualToPageableResult, actualFirstResult);
    assertSame(actualToPageableResult, ((PageRequest) actualToPageableResult).previous());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, boolean)} with {@code pageLink}, {@code
   * columnMap}, {@code addDefaultSorting}.
   *
   * <ul>
   *   <li>Then return {@link PageRequest}.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink, Map, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink, Map, boolean)"})
  public void testToPageableWithPageLinkColumnMapAddDefaultSorting_thenReturnPageRequest() {
    // Arrange and Act
    Pageable actualToPageableResult =
        DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, new HashMap<>(), true);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    assertEquals(0, actualToPageableResult.getPageNumber());
    assertEquals(0L, actualToPageableResult.getOffset());
    assertEquals(1000, actualToPageableResult.getPageSize());
    assertFalse(actualToPageableResult.hasPrevious());
    assertFalse(actualToPageableResult.isUnpaged());
    assertTrue(actualToPageableResult.isPaged());
    Pageable actualFirstResult = actualToPageableResult.first();
    assertEquals(actualToPageableResult, actualFirstResult);
    assertSame(actualToPageableResult, ((PageRequest) actualToPageableResult).previous());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List)} with {@code pageLink}, {@code columnMap},
   * {@code sortOrders}.
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink, Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink, Map, List)"})
  public void testToPageableWithPageLinkColumnMapSortOrders() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();

    // Act
    Pageable actualToPageableResult =
        DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap, new ArrayList<>());

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(1, toListResult.size());
    Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult.getDirection());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List)} with {@code pageLink}, {@code columnMap},
   * {@code sortOrders}.
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink, Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink, Map, List)"})
  public void testToPageableWithPageLinkColumnMapSortOrders2() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();
    columnMap.put("id", "42");

    // Act
    Pageable actualToPageableResult =
        DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap, new ArrayList<>());

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(1, toListResult.size());
    Order getResult = toListResult.get(0);
    assertEquals("42", getResult.getProperty());
    Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("42", ignoreCaseResult.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult.getDirection());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List)} with {@code pageLink}, {@code columnMap},
   * {@code sortOrders}.
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink, Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink, Map, List)"})
  public void testToPageableWithPageLinkColumnMapSortOrders3() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.of("id", SortOrder.Direction.ASC));

    // Act
    Pageable actualToPageableResult =
        DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap, sortOrders);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(1, toListResult.size());
    Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult.getDirection());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List, boolean)} with {@code pageLink}, {@code
   * columnMap}, {@code sortOrders}, {@code addDefaultSorting}.
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink, Map, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink, Map, List, boolean)"})
  public void testToPageableWithPageLinkColumnMapSortOrdersAddDefaultSorting() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();

    // Act
    Pageable actualToPageableResult =
        DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap, new ArrayList<>(), true);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(1, toListResult.size());
    Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult.getDirection());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List, boolean)} with {@code pageLink}, {@code
   * columnMap}, {@code sortOrders}, {@code addDefaultSorting}.
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink, Map, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink, Map, List, boolean)"})
  public void testToPageableWithPageLinkColumnMapSortOrdersAddDefaultSorting2() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();
    columnMap.put("id", "42");

    // Act
    Pageable actualToPageableResult =
        DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap, new ArrayList<>(), true);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(1, toListResult.size());
    Order getResult = toListResult.get(0);
    assertEquals("42", getResult.getProperty());
    Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("42", ignoreCaseResult.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult.getDirection());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List, boolean)} with {@code pageLink}, {@code
   * columnMap}, {@code sortOrders}, {@code addDefaultSorting}.
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink, Map, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink, Map, List, boolean)"})
  public void testToPageableWithPageLinkColumnMapSortOrdersAddDefaultSorting3() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    Pageable actualToPageableResult =
        DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap, sortOrders, true);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(2, toListResult.size());
    Order getResult = toListResult.get(1);
    assertEquals("id", getResult.getProperty());
    Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List, boolean)} with {@code pageLink}, {@code
   * columnMap}, {@code sortOrders}, {@code addDefaultSorting}.
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink, Map, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink, Map, List, boolean)"})
  public void testToPageableWithPageLinkColumnMapSortOrdersAddDefaultSorting4() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    Pageable actualToPageableResult =
        DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap, sortOrders, true);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(3, toListResult.size());
    Order getResult = toListResult.get(2);
    assertEquals("id", getResult.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(NullHandling.NATIVE, getResult.getNullHandling());
    assertFalse(getResult.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(getResult.isAscending());
    Order expectedGetResult = toListResult.get(0);
    assertEquals(expectedGetResult, toListResult.get(1));
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List, boolean)} with {@code pageLink}, {@code
   * columnMap}, {@code sortOrders}, {@code addDefaultSorting}.
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink, Map, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink, Map, List, boolean)"})
  public void testToPageableWithPageLinkColumnMapSortOrdersAddDefaultSorting5() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.of("id", SortOrder.Direction.ASC));

    // Act
    Pageable actualToPageableResult =
        DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap, sortOrders, true);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(1, toListResult.size());
    Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult.getDirection());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List, boolean)} with {@code pageLink}, {@code
   * columnMap}, {@code sortOrders}, {@code addDefaultSorting}.
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink, Map, List, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink, Map, List, boolean)"})
  public void testToPageableWithPageLinkColumnMapSortOrdersAddDefaultSorting6() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();

    // Act
    Pageable actualToPageableResult =
        DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap, new ArrayList<>(), false);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    Sort sort = actualToPageableResult.getSort();
    assertTrue(sort.toList().isEmpty());
    Pageable nextResult = actualToPageableResult.next();
    assertEquals(actualToPageableResult, ((PageRequest) nextResult).previous());
    assertEquals(actualToPageableResult, actualToPageableResult.first().first());
    assertEquals(actualToPageableResult, nextResult.first());
    assertSame(sort, nextResult.getSort());
    assertSame(actualToPageableResult, ((PageRequest) actualToPageableResult).previous());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List)} with {@code pageLink}, {@code columnMap},
   * {@code sortOrders}.
   *
   * <ul>
   *   <li>Then return Sort toList size is three.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink, Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink, Map, List)"})
  public void testToPageableWithPageLinkColumnMapSortOrders_thenReturnSortToListSizeIsThree() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    Pageable actualToPageableResult =
        DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap, sortOrders);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(3, toListResult.size());
    Order getResult = toListResult.get(2);
    assertEquals("id", getResult.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(NullHandling.NATIVE, getResult.getNullHandling());
    assertFalse(getResult.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(getResult.isAscending());
    Order expectedGetResult = toListResult.get(0);
    assertEquals(expectedGetResult, toListResult.get(1));
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List)} with {@code pageLink}, {@code columnMap},
   * {@code sortOrders}.
   *
   * <ul>
   *   <li>Then return Sort toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink, Map, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink, Map, List)"})
  public void testToPageableWithPageLinkColumnMapSortOrders_thenReturnSortToListSizeIsTwo() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    Pageable actualToPageableResult =
        DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap, sortOrders);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(2, toListResult.size());
    Order getResult = toListResult.get(1);
    assertEquals("id", getResult.getProperty());
    Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map)} with {@code pageLink}, {@code columnMap}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageRequest}.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink, Map)"})
  public void testToPageableWithPageLinkColumnMap_whenFirst_page_thenReturnPageRequest() {
    // Arrange and Act
    Pageable actualToPageableResult =
        DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, new HashMap<>());

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    assertEquals(0, actualToPageableResult.getPageNumber());
    assertEquals(0L, actualToPageableResult.getOffset());
    assertEquals(1000, actualToPageableResult.getPageSize());
    assertFalse(actualToPageableResult.hasPrevious());
    assertFalse(actualToPageableResult.isUnpaged());
    assertTrue(actualToPageableResult.isPaged());
    Pageable actualFirstResult = actualToPageableResult.first();
    assertEquals(actualToPageableResult, actualFirstResult);
    assertSame(actualToPageableResult, ((PageRequest) actualToPageableResult).previous());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, List)} with {@code pageLink}, {@code sortOrders}.
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink, List)"})
  public void testToPageableWithPageLinkSortOrders() {
    // Arrange
    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.of("id", SortOrder.Direction.ASC));

    // Act
    Pageable actualToPageableResult =
        DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, sortOrders);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(1, toListResult.size());
    Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult.getDirection());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, List)} with {@code pageLink}, {@code sortOrders}.
   *
   * <ul>
   *   <li>Then return Sort toList size is three.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink, List)"})
  public void testToPageableWithPageLinkSortOrders_thenReturnSortToListSizeIsThree() {
    // Arrange
    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    Pageable actualToPageableResult =
        DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, sortOrders);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(3, toListResult.size());
    Order getResult = toListResult.get(2);
    assertEquals("id", getResult.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(NullHandling.NATIVE, getResult.getNullHandling());
    assertFalse(getResult.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(getResult.isAscending());
    Order expectedGetResult = toListResult.get(0);
    assertEquals(expectedGetResult, toListResult.get(1));
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, List)} with {@code pageLink}, {@code sortOrders}.
   *
   * <ul>
   *   <li>Then return Sort toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink, List)"})
  public void testToPageableWithPageLinkSortOrders_thenReturnSortToListSizeIsTwo() {
    // Arrange
    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    Pageable actualToPageableResult =
        DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, sortOrders);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(2, toListResult.size());
    Order getResult = toListResult.get(1);
    assertEquals("id", getResult.getProperty());
    Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, List)} with {@code pageLink}, {@code sortOrders}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Sort toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink, List)"})
  public void testToPageableWithPageLinkSortOrders_whenArrayList_thenReturnSortToListSizeIsOne() {
    // Arrange and Act
    Pageable actualToPageableResult =
        DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, new ArrayList<>());

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(1, toListResult.size());
    Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult.getDirection());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink)} with {@code pageLink}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageRequest}.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#toPageable(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Pageable DaoUtil.toPageable(PageLink)"})
  public void testToPageableWithPageLink_whenFirst_page_thenReturnPageRequest() {
    // Arrange and Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    assertEquals(0, actualToPageableResult.getPageNumber());
    assertEquals(0L, actualToPageableResult.getOffset());
    assertEquals(1000, actualToPageableResult.getPageSize());
    assertFalse(actualToPageableResult.hasPrevious());
    assertFalse(actualToPageableResult.isUnpaged());
    assertTrue(actualToPageableResult.isPaged());
    Pageable actualFirstResult = actualToPageableResult.first();
    assertEquals(actualToPageableResult, actualFirstResult);
    assertSame(actualToPageableResult, ((PageRequest) actualToPageableResult).previous());
  }

  /**
   * Test {@link DaoUtil#convertDataList(Collection)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#convertDataList(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DaoUtil.convertDataList(Collection)"})
  public void testConvertDataList_givenNull_whenLinkedHashSetAddNull_thenReturnEmpty() {
    // Arrange
    LinkedHashSet<? extends ToData<Object>> toDataList = new LinkedHashSet<>();
    toDataList.add(null);

    // Act
    List<Object> actualConvertDataListResult = DaoUtil.convertDataList(toDataList);

    // Assert
    assertTrue(actualConvertDataListResult.isEmpty());
  }

  /**
   * Test {@link DaoUtil#convertDataList(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#convertDataList(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DaoUtil.convertDataList(Collection)"})
  public void testConvertDataList_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualConvertDataListResult = DaoUtil.convertDataList(new ArrayList<>());

    // Assert
    assertTrue(actualConvertDataListResult.isEmpty());
  }

  /**
   * Test {@link DaoUtil#convertDataList(Collection)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#convertDataList(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DaoUtil.convertDataList(Collection)"})
  public void testConvertDataList_whenNull_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualConvertDataListResult = DaoUtil.convertDataList(null);

    // Assert
    assertTrue(actualConvertDataListResult.isEmpty());
  }

  /**
   * Test {@link DaoUtil#getData(Optional)} with {@code Optional}.
   *
   * <ul>
   *   <li>Given {@code Data}.
   *   <li>When {@link ToData} {@link ToData#toData()} return {@code Data}.
   *   <li>Then return {@code Data}.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#getData(Optional)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DaoUtil.getData(Optional)"})
  public void testGetDataWithOptional_givenData_whenToDataToDataReturnData_thenReturnData() {
    // Arrange
    ToData<Object> toData = mock(ToData.class);
    when(toData.toData()).thenReturn("Data");
    Optional<? extends ToData<Object>> data = Optional.of(toData);

    // Act
    Object actualData = DaoUtil.getData(data);

    // Assert
    verify(toData).toData();
    assertEquals("Data", actualData);
  }

  /**
   * Test {@link DaoUtil#getData(Optional)} with {@code Optional}.
   *
   * <ul>
   *   <li>When empty.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#getData(Optional)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DaoUtil.getData(Optional)"})
  public void testGetDataWithOptional_whenEmpty_thenReturnNull() {
    // Arrange
    Optional<? extends ToData<Object>> data = Optional.empty();

    // Act and Assert
    assertNull(DaoUtil.getData(data));
  }

  /**
   * Test {@link DaoUtil#getData(ToData)} with {@code ToData}.
   *
   * <ul>
   *   <li>Given {@code Data}.
   *   <li>When {@link ToData} {@link ToData#toData()} return {@code Data}.
   *   <li>Then return {@code Data}.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#getData(ToData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DaoUtil.getData(ToData)"})
  public void testGetDataWithToData_givenData_whenToDataToDataReturnData_thenReturnData() {
    // Arrange
    ToData<Object> data = mock(ToData.class);
    when(data.toData()).thenReturn("Data");

    // Act
    Object actualData = DaoUtil.getData(data);

    // Assert
    verify(data).toData();
    assertEquals("Data", actualData);
  }

  /**
   * Test {@link DaoUtil#getData(ToData)} with {@code ToData}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#getData(ToData)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DaoUtil.getData(ToData)"})
  public void testGetDataWithToData_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DaoUtil.getData((ToData<Object>) null));
  }

  /**
   * Test {@link DaoUtil#getId(UUIDBased)}.
   *
   * <ul>
   *   <li>Then return toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#getId(UUIDBased)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID DaoUtil.getId(UUIDBased)"})
  public void testGetId_thenReturnToStringIs138140001dd211b28080808080808080() {
    // Arrange, Act and Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        DaoUtil.getId(BaseEntityService.NULL_CUSTOMER_ID).toString());
  }

  /**
   * Test {@link DaoUtil#getId(UUIDBased)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#getId(UUIDBased)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID DaoUtil.getId(UUIDBased)"})
  public void testGetId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DaoUtil.getId(null));
  }

  /**
   * Test {@link DaoUtil#toUUIDs(List)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#toUUIDs(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DaoUtil.toUUIDs(List)"})
  public void testToUUIDs_givenNull_customer_id_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<UUIDBased> idBasedIds = new ArrayList<>();
    idBasedIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    idBasedIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<UUID> actualToUUIDsResult = DaoUtil.toUUIDs(idBasedIds);

    // Assert
    assertEquals(2, actualToUUIDsResult.size());
    UUID getResult = actualToUUIDsResult.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.toString());
    assertSame(getResult, actualToUUIDsResult.get(1));
  }

  /**
   * Test {@link DaoUtil#toUUIDs(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#toUUIDs(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DaoUtil.toUUIDs(List)"})
  public void testToUUIDs_givenNull_whenArrayListAddNull_thenReturnArrayList() {
    // Arrange
    ArrayList<? extends UUIDBased> idBasedIds = new ArrayList<>();
    idBasedIds.add(null);

    // Act
    List<UUID> actualToUUIDsResult = DaoUtil.toUUIDs(idBasedIds);

    // Assert
    assertEquals(idBasedIds, actualToUUIDsResult);
  }

  /**
   * Test {@link DaoUtil#toUUIDs(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#toUUIDs(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DaoUtil.toUUIDs(List)"})
  public void testToUUIDs_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<UUID> actualToUUIDsResult = DaoUtil.toUUIDs(new ArrayList<>());

    // Assert
    assertTrue(actualToUUIDsResult.isEmpty());
  }

  /**
   * Test {@link DaoUtil#fromUUIDs(List, Function)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link ModelConstants#NULL_UUID}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#fromUUIDs(List, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DaoUtil.fromUUIDs(List, Function)"})
  public void testFromUUIDs_givenNull_uuid_whenArrayListAddNull_uuid_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<UUID> uuids = new ArrayList<>();
    uuids.add(ModelConstants.NULL_UUID);
    uuids.add(ModelConstants.NULL_UUID);

    Function<UUID, Object> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<UUID>any())).thenReturn("Apply");

    // Act
    List<Object> actualFromUUIDsResult = DaoUtil.fromUUIDs(uuids, mapper);

    // Assert
    verify(mapper, atLeast(1)).apply(isA(UUID.class));
    assertEquals(2, actualFromUUIDsResult.size());
    assertEquals("Apply", actualFromUUIDsResult.get(0));
    assertEquals("Apply", actualFromUUIDsResult.get(1));
  }

  /**
   * Test {@link DaoUtil#fromUUIDs(List, Function)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#fromUUIDs(List, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DaoUtil.fromUUIDs(List, Function)"})
  public void testFromUUIDs_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualFromUUIDsResult = DaoUtil.fromUUIDs(new ArrayList<>(), mock(Function.class));

    // Assert
    assertTrue(actualFromUUIDsResult.isEmpty());
  }

  /**
   * Test {@link DaoUtil#toEntityId(UUID, Function)}.
   *
   * <ul>
   *   <li>Given {@code Apply}.
   *   <li>When {@link Function} {@link Function#apply(Object)} return {@code Apply}.
   *   <li>Then return {@code Apply}.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#toEntityId(UUID, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DaoUtil.toEntityId(UUID, Function)"})
  public void testToEntityId_givenApply_whenFunctionApplyReturnApply_thenReturnApply() {
    // Arrange
    Function<UUID, Object> creator = mock(Function.class);
    when(creator.apply(Mockito.<UUID>any())).thenReturn("Apply");

    // Act
    Object actualToEntityIdResult = DaoUtil.toEntityId(ModelConstants.NULL_UUID, creator);

    // Assert
    verify(creator).apply(isA(UUID.class));
    assertEquals("Apply", actualToEntityIdResult);
  }

  /**
   * Test {@link DaoUtil#toEntityId(UUID, Function)}.
   *
   * <ul>
   *   <li>When {@link Function}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#toEntityId(UUID, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Object DaoUtil.toEntityId(UUID, Function)"})
  public void testToEntityId_whenFunction_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DaoUtil.toEntityId(null, mock(Function.class)));
  }

  /**
   * Test {@link DaoUtil#processInBatches(Function, int, Consumer)}.
   *
   * <ul>
   *   <li>Given emptyPageData.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#processInBatches(Function, int, Consumer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DaoUtil.processInBatches(Function, int, Consumer)"})
  public void testProcessInBatches_givenEmptyPageData_thenCallsApply() {
    // Arrange
    Function<PageLink, PageData<Object>> finder = mock(Function.class);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(finder.apply(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    DaoUtil.processInBatches(finder, 3, mock(Consumer.class));

    // Assert
    verify(finder).apply(isA(PageLink.class));
  }

  /**
   * Test {@link DaoUtil#processBatches(Function, int, Consumer)}.
   *
   * <ul>
   *   <li>Given emptyPageData.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#processBatches(Function, int, Consumer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DaoUtil.processBatches(Function, int, Consumer)"})
  public void testProcessBatches_givenEmptyPageData_thenCallsAccept() {
    // Arrange
    Function<PageLink, PageData<Object>> finder = mock(Function.class);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(finder.apply(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    Consumer<PageData<Object>> processor = mock(Consumer.class);
    doNothing().when(processor).accept(Mockito.<PageData<Object>>any());

    // Act
    DaoUtil.processBatches(finder, 3, processor);

    // Assert
    verify(processor).accept(isA(PageData.class));
    verify(finder).apply(isA(PageLink.class));
  }

  /**
   * Test {@link DaoUtil#getStringId(UUIDBased)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#getStringId(UUIDBased)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DaoUtil.getStringId(UUIDBased)"})
  public void testGetStringId_whenNull_customer_id_thenReturn138140001dd211b28080808080808080() {
    // Arrange, Act and Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        DaoUtil.getStringId(BaseEntityService.NULL_CUSTOMER_ID));
  }

  /**
   * Test {@link DaoUtil#getStringId(UUIDBased)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#getStringId(UUIDBased)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DaoUtil.getStringId(UUIDBased)"})
  public void testGetStringId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DaoUtil.getStringId(null));
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}.
   *
   * <p>Method under test: {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DaoUtil.convertTenantEntityTypesToDto(UUID, EntityType, List)"})
  public void testConvertTenantEntityTypesToDto() {
    // Arrange
    ArrayList<String> types = new ArrayList<>();
    types.add("foo");

    // Act
    List<EntitySubtype> actualConvertTenantEntityTypesToDtoResult =
        DaoUtil.convertTenantEntityTypesToDto(ModelConstants.NULL_UUID, EntityType.TENANT, types);

    // Assert
    assertEquals(1, actualConvertTenantEntityTypesToDtoResult.size());
    EntitySubtype getResult = actualConvertTenantEntityTypesToDtoResult.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("foo", getResult.getType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DaoUtil.convertTenantEntityTypesToDto(UUID, EntityType, List)"})
  public void testConvertTenantEntityTypesToDto_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<String> types = new ArrayList<>();
    types.add("42");
    types.add("foo");

    // Act
    List<EntitySubtype> actualConvertTenantEntityTypesToDtoResult =
        DaoUtil.convertTenantEntityTypesToDto(ModelConstants.NULL_UUID, EntityType.TENANT, types);

    // Assert
    assertEquals(2, actualConvertTenantEntityTypesToDtoResult.size());
    assertEquals("42", actualConvertTenantEntityTypesToDtoResult.get(0).getType());
    EntitySubtype getResult = actualConvertTenantEntityTypesToDtoResult.get(1);
    assertEquals("foo", getResult.getType());
    assertEquals(EntityType.TENANT, getResult.getEntityType());
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}.
   *
   * <ul>
   *   <li>Then return not first TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DaoUtil.convertTenantEntityTypesToDto(UUID, EntityType, List)"})
  public void testConvertTenantEntityTypesToDto_thenReturnNotFirstTenantIdNullUid() {
    // Arrange
    UUID tenantUUID = UUID.randomUUID();

    ArrayList<String> types = new ArrayList<>();
    types.add("foo");

    // Act
    List<EntitySubtype> actualConvertTenantEntityTypesToDtoResult =
        DaoUtil.convertTenantEntityTypesToDto(tenantUUID, EntityType.TENANT, types);

    // Assert
    assertEquals(1, actualConvertTenantEntityTypesToDtoResult.size());
    EntitySubtype getResult = actualConvertTenantEntityTypesToDtoResult.get(0);
    assertEquals("foo", getResult.getType());
    TenantId tenantId = getResult.getTenantId();
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(tenantUUID, tenantId.getId());
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DaoUtil.convertTenantEntityTypesToDto(UUID, EntityType, List)"})
  public void testConvertTenantEntityTypesToDto_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<EntitySubtype> actualConvertTenantEntityTypesToDtoResult =
        DaoUtil.convertTenantEntityTypesToDto(
            ModelConstants.NULL_UUID, EntityType.TENANT, new ArrayList<>());

    // Assert
    assertTrue(actualConvertTenantEntityTypesToDtoResult.isEmpty());
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}.
   *
   * <p>Method under test: {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DaoUtil.convertTenantEntityInfosToDto(UUID, EntityType, List)"})
  public void testConvertTenantEntityInfosToDto() {
    // Arrange
    ArrayList<EntityInfo> entityInfos = new ArrayList<>();
    entityInfos.add(new EntityInfo(BaseEntityService.NULL_CUSTOMER_ID, "Name"));

    // Act
    List<EntitySubtype> actualConvertTenantEntityInfosToDtoResult =
        DaoUtil.convertTenantEntityInfosToDto(
            ModelConstants.NULL_UUID, EntityType.TENANT, entityInfos);

    // Assert
    assertEquals(1, actualConvertTenantEntityInfosToDtoResult.size());
    TenantId tenantId = actualConvertTenantEntityInfosToDtoResult.get(0).getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}.
   *
   * <ul>
   *   <li>Then return not first TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DaoUtil.convertTenantEntityInfosToDto(UUID, EntityType, List)"})
  public void testConvertTenantEntityInfosToDto_thenReturnNotFirstTenantIdNullUid() {
    // Arrange
    UUID tenantUUID = UUID.randomUUID();

    ArrayList<EntityInfo> entityInfos = new ArrayList<>();
    entityInfos.add(new EntityInfo(BaseEntityService.NULL_CUSTOMER_ID, "Name"));

    // Act
    List<EntitySubtype> actualConvertTenantEntityInfosToDtoResult =
        DaoUtil.convertTenantEntityInfosToDto(tenantUUID, EntityType.TENANT, entityInfos);

    // Assert
    assertEquals(1, actualConvertTenantEntityInfosToDtoResult.size());
    TenantId tenantId = actualConvertTenantEntityInfosToDtoResult.get(0).getTenantId();
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(tenantUUID, tenantId.getId());
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DaoUtil.convertTenantEntityInfosToDto(UUID, EntityType, List)"})
  public void testConvertTenantEntityInfosToDto_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<EntityInfo> entityInfos = new ArrayList<>();
    entityInfos.add(new EntityInfo(BaseEntityService.NULL_CUSTOMER_ID, "Name"));
    entityInfos.add(new EntityInfo(BaseEntityService.NULL_CUSTOMER_ID, "Name"));

    // Act
    List<EntitySubtype> actualConvertTenantEntityInfosToDtoResult =
        DaoUtil.convertTenantEntityInfosToDto(
            ModelConstants.NULL_UUID, EntityType.TENANT, entityInfos);

    // Assert
    assertEquals(2, actualConvertTenantEntityInfosToDtoResult.size());
    EntitySubtype expectedGetResult = actualConvertTenantEntityInfosToDtoResult.get(0);
    assertEquals(expectedGetResult, actualConvertTenantEntityInfosToDtoResult.get(1));
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DaoUtil.convertTenantEntityInfosToDto(UUID, EntityType, List)"})
  public void testConvertTenantEntityInfosToDto_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<EntitySubtype> actualConvertTenantEntityInfosToDtoResult =
        DaoUtil.convertTenantEntityInfosToDto(
            ModelConstants.NULL_UUID, EntityType.TENANT, new ArrayList<>());

    // Assert
    assertTrue(actualConvertTenantEntityInfosToDtoResult.isEmpty());
  }
}
