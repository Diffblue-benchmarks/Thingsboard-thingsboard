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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
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
   * <ul>
   *   <li>Given {@link ToData} {@link ToData#toData()} return {@code Data}.</li>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toPageData(Page)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link PageImpl#PageImpl(List)} with content is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toPageData(Page)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#pageToPageData(Slice)}
   */
  @Test
  public void testPageToPageData_given42_whenArrayListAdd42_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<Object> content = new ArrayList<>();
    content.add("42");

    // Act
    PageData<Object> actualPageToPageDataResult = DaoUtil.pageToPageData(new PageImpl<>(content));

    // Assert
    List<Object> data = actualPageToPageDataResult.getData();
    assertEquals(1, data.size());
    assertEquals("42", data.get(0));
    assertEquals(1L, actualPageToPageDataResult.getTotalElements());
  }

  /**
   * Test {@link DaoUtil#pageToPageData(Slice)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#pageToPageData(Slice)}
   */
  @Test
  public void testPageToPageData_thenReturnTotalElementsIsZero() {
    // Arrange and Act
    PageData<Object> actualPageToPageDataResult = DaoUtil.pageToPageData(new PageImpl<>(new ArrayList<>()));

    // Assert
    assertEquals(0L, actualPageToPageDataResult.getTotalElements());
    assertEquals(1, actualPageToPageDataResult.getTotalPages());
    assertFalse(actualPageToPageDataResult.hasNext());
    assertTrue(actualPageToPageDataResult.getData().isEmpty());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, boolean)} with {@code pageLink},
   * {@code addDefaultSorting}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageRequest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, boolean)}
   */
  @Test
  public void testToPageableWithPageLinkAddDefaultSorting_whenFirst_page_thenReturnPageRequest() {
    // Arrange and Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, true);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    Sort sort = actualToPageableResult.getSort();
    List<Sort.Order> toListResult = sort.toList();
    assertEquals(1, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(0, actualToPageableResult.getPageNumber());
    assertEquals(0L, actualToPageableResult.getOffset());
    Pageable nextResult = actualToPageableResult.next();
    assertEquals(1, nextResult.getPageNumber());
    Pageable nextResult2 = nextResult.next();
    Pageable nextResult3 = nextResult2.next();
    Pageable nextResult4 = nextResult3.next();
    assertEquals(1000, nextResult4.getPageSize());
    assertEquals(1000, nextResult3.getPageSize());
    assertEquals(1000, nextResult2.getPageSize());
    assertEquals(1000, nextResult.getPageSize());
    assertEquals(1000, actualToPageableResult.getPageSize());
    assertEquals(1000L, nextResult.getOffset());
    assertEquals(2, nextResult2.getPageNumber());
    assertEquals(2000L, nextResult2.getOffset());
    assertEquals(3, nextResult3.getPageNumber());
    assertEquals(3000L, nextResult3.getOffset());
    assertEquals(4, nextResult4.getPageNumber());
    assertEquals(4000L, nextResult4.getOffset());
    assertEquals(Sort.Direction.ASC, getResult.getDirection());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertFalse(actualToPageableResult.hasPrevious());
    assertFalse(nextResult4.isUnpaged());
    assertFalse(nextResult3.isUnpaged());
    assertFalse(nextResult2.isUnpaged());
    assertFalse(nextResult.isUnpaged());
    assertFalse(actualToPageableResult.isUnpaged());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(nextResult4.hasPrevious());
    assertTrue(nextResult3.hasPrevious());
    assertTrue(nextResult2.hasPrevious());
    assertTrue(nextResult.hasPrevious());
    assertTrue(nextResult4.isPaged());
    assertTrue(nextResult3.isPaged());
    assertTrue(nextResult2.isPaged());
    assertTrue(nextResult.isPaged());
    assertTrue(actualToPageableResult.isPaged());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
    assertEquals(actualToPageableResult, ((PageRequest) nextResult).previous());
    assertEquals(actualToPageableResult, nextResult4.first());
    assertEquals(actualToPageableResult, nextResult3.first());
    assertEquals(actualToPageableResult, nextResult2.first());
    assertEquals(actualToPageableResult, nextResult.first());
    assertEquals(actualToPageableResult, actualToPageableResult.first());
    assertSame(sort, nextResult4.getSort());
    assertSame(sort, nextResult3.getSort());
    assertSame(sort, nextResult2.getSort());
    assertSame(sort, nextResult.getSort());
    assertSame(actualToPageableResult, ((PageRequest) actualToPageableResult).previous());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, boolean)} with
   * {@code pageLink}, {@code columnMap}, {@code addDefaultSorting}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, Map, boolean)}
   */
  @Test
  public void testToPageableWithPageLinkColumnMapAddDefaultSorting_givenFoo() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();
    columnMap.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap, true);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    Sort sort = actualToPageableResult.getSort();
    List<Sort.Order> toListResult = sort.toList();
    assertEquals(1, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(0, actualToPageableResult.getPageNumber());
    assertEquals(0L, actualToPageableResult.getOffset());
    Pageable nextResult = actualToPageableResult.next();
    assertEquals(1, nextResult.getPageNumber());
    Pageable nextResult2 = nextResult.next();
    Pageable nextResult3 = nextResult2.next();
    Pageable nextResult4 = nextResult3.next();
    assertEquals(1000, nextResult4.getPageSize());
    assertEquals(1000, nextResult3.getPageSize());
    assertEquals(1000, nextResult2.getPageSize());
    assertEquals(1000, nextResult.getPageSize());
    assertEquals(1000, actualToPageableResult.getPageSize());
    assertEquals(1000L, nextResult.getOffset());
    assertEquals(2, nextResult2.getPageNumber());
    assertEquals(2000L, nextResult2.getOffset());
    assertEquals(3, nextResult3.getPageNumber());
    assertEquals(3000L, nextResult3.getOffset());
    assertEquals(4, nextResult4.getPageNumber());
    assertEquals(4000L, nextResult4.getOffset());
    assertEquals(Sort.Direction.ASC, getResult.getDirection());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertFalse(actualToPageableResult.hasPrevious());
    assertFalse(nextResult4.isUnpaged());
    assertFalse(nextResult3.isUnpaged());
    assertFalse(nextResult2.isUnpaged());
    assertFalse(nextResult.isUnpaged());
    assertFalse(actualToPageableResult.isUnpaged());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(nextResult4.hasPrevious());
    assertTrue(nextResult3.hasPrevious());
    assertTrue(nextResult2.hasPrevious());
    assertTrue(nextResult.hasPrevious());
    assertTrue(nextResult4.isPaged());
    assertTrue(nextResult3.isPaged());
    assertTrue(nextResult2.isPaged());
    assertTrue(nextResult.isPaged());
    assertTrue(actualToPageableResult.isPaged());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
    assertEquals(actualToPageableResult, ((PageRequest) nextResult).previous());
    assertEquals(actualToPageableResult, nextResult4.first());
    assertEquals(actualToPageableResult, nextResult3.first());
    assertEquals(actualToPageableResult, nextResult2.first());
    assertEquals(actualToPageableResult, nextResult.first());
    assertEquals(actualToPageableResult, actualToPageableResult.first());
    assertSame(sort, nextResult4.getSort());
    assertSame(sort, nextResult3.getSort());
    assertSame(sort, nextResult2.getSort());
    assertSame(sort, nextResult.getSort());
    assertSame(actualToPageableResult, ((PageRequest) actualToPageableResult).previous());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, boolean)} with
   * {@code pageLink}, {@code columnMap}, {@code addDefaultSorting}.
   * <ul>
   *   <li>Then return {@link PageRequest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, Map, boolean)}
   */
  @Test
  public void testToPageableWithPageLinkColumnMapAddDefaultSorting_thenReturnPageRequest() {
    // Arrange and Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, new HashMap<>(), true);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    Sort sort = actualToPageableResult.getSort();
    List<Sort.Order> toListResult = sort.toList();
    assertEquals(1, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(0, actualToPageableResult.getPageNumber());
    assertEquals(0L, actualToPageableResult.getOffset());
    Pageable nextResult = actualToPageableResult.next();
    assertEquals(1, nextResult.getPageNumber());
    Pageable nextResult2 = nextResult.next();
    Pageable nextResult3 = nextResult2.next();
    Pageable nextResult4 = nextResult3.next();
    assertEquals(1000, nextResult4.getPageSize());
    assertEquals(1000, nextResult3.getPageSize());
    assertEquals(1000, nextResult2.getPageSize());
    assertEquals(1000, nextResult.getPageSize());
    assertEquals(1000, actualToPageableResult.getPageSize());
    assertEquals(1000L, nextResult.getOffset());
    assertEquals(2, nextResult2.getPageNumber());
    assertEquals(2000L, nextResult2.getOffset());
    assertEquals(3, nextResult3.getPageNumber());
    assertEquals(3000L, nextResult3.getOffset());
    assertEquals(4, nextResult4.getPageNumber());
    assertEquals(4000L, nextResult4.getOffset());
    assertEquals(Sort.Direction.ASC, getResult.getDirection());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertFalse(actualToPageableResult.hasPrevious());
    assertFalse(nextResult4.isUnpaged());
    assertFalse(nextResult3.isUnpaged());
    assertFalse(nextResult2.isUnpaged());
    assertFalse(nextResult.isUnpaged());
    assertFalse(actualToPageableResult.isUnpaged());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(nextResult4.hasPrevious());
    assertTrue(nextResult3.hasPrevious());
    assertTrue(nextResult2.hasPrevious());
    assertTrue(nextResult.hasPrevious());
    assertTrue(nextResult4.isPaged());
    assertTrue(nextResult3.isPaged());
    assertTrue(nextResult2.isPaged());
    assertTrue(nextResult.isPaged());
    assertTrue(actualToPageableResult.isPaged());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
    assertEquals(actualToPageableResult, ((PageRequest) nextResult).previous());
    assertEquals(actualToPageableResult, nextResult4.first());
    assertEquals(actualToPageableResult, nextResult3.first());
    assertEquals(actualToPageableResult, nextResult2.first());
    assertEquals(actualToPageableResult, nextResult.first());
    assertEquals(actualToPageableResult, actualToPageableResult.first());
    assertSame(sort, nextResult4.getSort());
    assertSame(sort, nextResult3.getSort());
    assertSame(sort, nextResult2.getSort());
    assertSame(sort, nextResult.getSort());
    assertSame(actualToPageableResult, ((PageRequest) actualToPageableResult).previous());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List)} with {@code pageLink},
   * {@code columnMap}, {@code sortOrders}.
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, Map, List)}
   */
  @Test
  public void testToPageableWithPageLinkColumnMapSortOrders() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();

    // Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap,
        new ArrayList<>());

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    Pageable nextResult = actualToPageableResult.next().next();
    Pageable nextResult2 = nextResult.first().next();
    PageRequest previousResult = ((PageRequest) nextResult2).previous();
    assertEquals(0, previousResult.getPageNumber());
    Pageable firstResult = nextResult.next().first().first();
    assertEquals(0, firstResult.getPageNumber());
    assertEquals(0L, previousResult.getOffset());
    assertEquals(0L, firstResult.getOffset());
    Sort sort = actualToPageableResult.getSort();
    assertEquals(1, sort.toList().size());
    assertEquals(1000, previousResult.getPageSize());
    assertEquals(1000, firstResult.getPageSize());
    assertFalse(previousResult.hasPrevious());
    assertFalse(firstResult.hasPrevious());
    assertFalse(previousResult.isUnpaged());
    assertFalse(firstResult.isUnpaged());
    assertFalse(nextResult2.next().isUnpaged());
    assertTrue(previousResult.isPaged());
    assertTrue(firstResult.isPaged());
    assertEquals(actualToPageableResult, previousResult.first());
    assertEquals(actualToPageableResult, firstResult.first());
    assertSame(sort, previousResult.getSort());
    assertSame(sort, firstResult.getSort());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List)} with {@code pageLink},
   * {@code columnMap}, {@code sortOrders}.
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, Map, List)}
   */
  @Test
  public void testToPageableWithPageLinkColumnMapSortOrders2() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.of("id", SortOrder.Direction.ASC));

    // Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap, sortOrders);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    Pageable nextResult = actualToPageableResult.next().next();
    Pageable nextResult2 = nextResult.first().next();
    PageRequest previousResult = ((PageRequest) nextResult2).previous();
    assertEquals(0, previousResult.getPageNumber());
    Pageable firstResult = nextResult.next().first().first();
    assertEquals(0, firstResult.getPageNumber());
    assertEquals(0L, previousResult.getOffset());
    assertEquals(0L, firstResult.getOffset());
    Sort sort = actualToPageableResult.getSort();
    assertEquals(1, sort.toList().size());
    assertEquals(1000, previousResult.getPageSize());
    assertEquals(1000, firstResult.getPageSize());
    assertFalse(previousResult.hasPrevious());
    assertFalse(firstResult.hasPrevious());
    assertFalse(previousResult.isUnpaged());
    assertFalse(firstResult.isUnpaged());
    assertFalse(nextResult2.next().isUnpaged());
    assertTrue(previousResult.isPaged());
    assertTrue(firstResult.isPaged());
    assertEquals(actualToPageableResult, previousResult.first());
    assertEquals(actualToPageableResult, firstResult.first());
    assertSame(sort, previousResult.getSort());
    assertSame(sort, firstResult.getSort());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List)} with {@code pageLink},
   * {@code columnMap}, {@code sortOrders}.
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, Map, List)}
   */
  @Test
  public void testToPageableWithPageLinkColumnMapSortOrders3() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.of("id", SortOrder.Direction.ASC));
    sortOrders.add(SortOrder.of("id", SortOrder.Direction.ASC));

    // Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap, sortOrders);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Sort.Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(2, toListResult.size());
    assertEquals(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List)} with {@code pageLink},
   * {@code columnMap}, {@code sortOrders}.
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, Map, List)}
   */
  @Test
  public void testToPageableWithPageLinkColumnMapSortOrders4() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap, sortOrders);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Sort.Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(2, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("Property", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("Property", ignoreCaseResult.getProperty());
    assertEquals("Property", ignoreCaseResult.ignoreCase().getProperty());
    Sort.Order ignoreCaseResult2 = toListResult.get(1).ignoreCase();
    assertEquals("id", ignoreCaseResult2.getProperty());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult2.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult2.getNullHandling());
    assertFalse(ignoreCaseResult2.isDescending());
    assertTrue(ignoreCaseResult2.isAscending());
    assertTrue(ignoreCaseResult2.isIgnoreCase());
    assertEquals(ignoreCaseResult2.ignoreCase(), ignoreCaseResult2.ignoreCase());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List, boolean)} with
   * {@code pageLink}, {@code columnMap}, {@code sortOrders},
   * {@code addDefaultSorting}.
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, Map, List, boolean)}
   */
  @Test
  public void testToPageableWithPageLinkColumnMapSortOrdersAddDefaultSorting() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();

    // Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap,
        new ArrayList<>(), true);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    Sort sort = actualToPageableResult.getSort();
    assertEquals(1, sort.toList().size());
    Pageable nextResult = actualToPageableResult.next().next();
    PageRequest previousResult = ((PageRequest) nextResult.first().next()).previous();
    assertEquals(actualToPageableResult, previousResult.first());
    Pageable firstResult = nextResult.next().first().first();
    assertEquals(actualToPageableResult, firstResult.first());
    assertSame(sort, previousResult.getSort());
    assertSame(sort, firstResult.getSort());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List, boolean)} with
   * {@code pageLink}, {@code columnMap}, {@code sortOrders},
   * {@code addDefaultSorting}.
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, Map, List, boolean)}
   */
  @Test
  public void testToPageableWithPageLinkColumnMapSortOrdersAddDefaultSorting2() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.of("id", SortOrder.Direction.ASC));

    // Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap, sortOrders,
        true);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    Sort sort = actualToPageableResult.getSort();
    assertEquals(1, sort.toList().size());
    Pageable nextResult = actualToPageableResult.next().next();
    PageRequest previousResult = ((PageRequest) nextResult.first().next()).previous();
    assertEquals(actualToPageableResult, previousResult.first());
    Pageable firstResult = nextResult.next().first().first();
    assertEquals(actualToPageableResult, firstResult.first());
    assertSame(sort, previousResult.getSort());
    assertSame(sort, firstResult.getSort());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List, boolean)} with
   * {@code pageLink}, {@code columnMap}, {@code sortOrders},
   * {@code addDefaultSorting}.
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, Map, List, boolean)}
   */
  @Test
  public void testToPageableWithPageLinkColumnMapSortOrdersAddDefaultSorting3() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.of("id", SortOrder.Direction.ASC));
    sortOrders.add(SortOrder.of("id", SortOrder.Direction.ASC));

    // Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap, sortOrders,
        true);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Sort.Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(2, toListResult.size());
    assertEquals(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List, boolean)} with
   * {@code pageLink}, {@code columnMap}, {@code sortOrders},
   * {@code addDefaultSorting}.
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, Map, List, boolean)}
   */
  @Test
  public void testToPageableWithPageLinkColumnMapSortOrdersAddDefaultSorting4() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap, sortOrders,
        true);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Sort.Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(2, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("Property", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("Property", ignoreCaseResult.getProperty());
    assertEquals("Property", ignoreCaseResult.ignoreCase().getProperty());
    Sort.Order ignoreCaseResult2 = toListResult.get(1).ignoreCase();
    assertEquals("id", ignoreCaseResult2.getProperty());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult2.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult2.getNullHandling());
    assertFalse(ignoreCaseResult2.isDescending());
    assertTrue(ignoreCaseResult2.isAscending());
    assertTrue(ignoreCaseResult2.isIgnoreCase());
    assertEquals(ignoreCaseResult2.ignoreCase(), ignoreCaseResult2.ignoreCase());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List, boolean)} with
   * {@code pageLink}, {@code columnMap}, {@code sortOrders},
   * {@code addDefaultSorting}.
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, Map, List, boolean)}
   */
  @Test
  public void testToPageableWithPageLinkColumnMapSortOrdersAddDefaultSorting5() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();

    // Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap,
        new ArrayList<>(), false);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    Sort sort = actualToPageableResult.getSort();
    assertTrue(sort.toList().isEmpty());
    Pageable nextResult = actualToPageableResult.next();
    assertEquals(actualToPageableResult, ((PageRequest) nextResult).previous());
    Pageable nextResult2 = nextResult.next();
    Pageable nextResult3 = nextResult2.next();
    Pageable nextResult4 = nextResult3.next();
    assertEquals(actualToPageableResult, nextResult4.first());
    assertEquals(actualToPageableResult, nextResult3.first());
    assertEquals(actualToPageableResult, nextResult2.first());
    assertEquals(actualToPageableResult, nextResult.first());
    assertEquals(actualToPageableResult, actualToPageableResult.first());
    assertSame(sort, nextResult4.getSort());
    assertSame(sort, nextResult3.getSort());
    assertSame(sort, nextResult2.getSort());
    assertSame(sort, nextResult.getSort());
    assertSame(actualToPageableResult, ((PageRequest) actualToPageableResult).previous());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List, boolean)} with
   * {@code pageLink}, {@code columnMap}, {@code sortOrders},
   * {@code addDefaultSorting}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, Map, List, boolean)}
   */
  @Test
  public void testToPageableWithPageLinkColumnMapSortOrdersAddDefaultSorting_givenBiFunction() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();
    columnMap.computeIfPresent("id", mock(BiFunction.class));
    columnMap.put("id", "id");

    // Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap,
        new ArrayList<>(), true);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    Sort sort = actualToPageableResult.getSort();
    assertEquals(1, sort.toList().size());
    Pageable nextResult = actualToPageableResult.next().next();
    PageRequest previousResult = ((PageRequest) nextResult.first().next()).previous();
    assertEquals(actualToPageableResult, previousResult.first());
    Pageable firstResult = nextResult.next().first().first();
    assertEquals(actualToPageableResult, firstResult.first());
    assertSame(sort, previousResult.getSort());
    assertSame(sort, firstResult.getSort());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List, boolean)} with
   * {@code pageLink}, {@code columnMap}, {@code sortOrders},
   * {@code addDefaultSorting}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code id} is {@code id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, Map, List, boolean)}
   */
  @Test
  public void testToPageableWithPageLinkColumnMapSortOrdersAddDefaultSorting_whenHashMapIdIsId() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();
    columnMap.put("id", "id");

    // Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap,
        new ArrayList<>(), true);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    Sort sort = actualToPageableResult.getSort();
    assertEquals(1, sort.toList().size());
    Pageable nextResult = actualToPageableResult.next().next();
    PageRequest previousResult = ((PageRequest) nextResult.first().next()).previous();
    assertEquals(actualToPageableResult, previousResult.first());
    Pageable firstResult = nextResult.next().first().first();
    assertEquals(actualToPageableResult, firstResult.first());
    assertSame(sort, previousResult.getSort());
    assertSame(sort, firstResult.getSort());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List)} with {@code pageLink},
   * {@code columnMap}, {@code sortOrders}.
   * <ul>
   *   <li>Given {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, Map, List)}
   */
  @Test
  public void testToPageableWithPageLinkColumnMapSortOrders_givenBiFunction() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();
    columnMap.computeIfPresent("id", mock(BiFunction.class));
    columnMap.put("id", "id");

    // Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap,
        new ArrayList<>());

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    Pageable nextResult = actualToPageableResult.next().next();
    Pageable nextResult2 = nextResult.first().next();
    PageRequest previousResult = ((PageRequest) nextResult2).previous();
    assertEquals(0, previousResult.getPageNumber());
    Pageable firstResult = nextResult.next().first().first();
    assertEquals(0, firstResult.getPageNumber());
    assertEquals(0L, previousResult.getOffset());
    assertEquals(0L, firstResult.getOffset());
    Sort sort = actualToPageableResult.getSort();
    assertEquals(1, sort.toList().size());
    assertEquals(1000, previousResult.getPageSize());
    assertEquals(1000, firstResult.getPageSize());
    assertFalse(previousResult.hasPrevious());
    assertFalse(firstResult.hasPrevious());
    assertFalse(previousResult.isUnpaged());
    assertFalse(firstResult.isUnpaged());
    assertFalse(nextResult2.next().isUnpaged());
    assertTrue(previousResult.isPaged());
    assertTrue(firstResult.isPaged());
    assertEquals(actualToPageableResult, previousResult.first());
    assertEquals(actualToPageableResult, firstResult.first());
    assertSame(sort, previousResult.getSort());
    assertSame(sort, firstResult.getSort());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map, List)} with {@code pageLink},
   * {@code columnMap}, {@code sortOrders}.
   * <ul>
   *   <li>Given {@code id}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code id} is {@code id}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, Map, List)}
   */
  @Test
  public void testToPageableWithPageLinkColumnMapSortOrders_givenId_whenHashMapIdIsId() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();
    columnMap.put("id", "id");

    // Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap,
        new ArrayList<>());

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    Pageable nextResult = actualToPageableResult.next().next();
    Pageable nextResult2 = nextResult.first().next();
    PageRequest previousResult = ((PageRequest) nextResult2).previous();
    assertEquals(0, previousResult.getPageNumber());
    Pageable firstResult = nextResult.next().first().first();
    assertEquals(0, firstResult.getPageNumber());
    assertEquals(0L, previousResult.getOffset());
    assertEquals(0L, firstResult.getOffset());
    Sort sort = actualToPageableResult.getSort();
    assertEquals(1, sort.toList().size());
    assertEquals(1000, previousResult.getPageSize());
    assertEquals(1000, firstResult.getPageSize());
    assertFalse(previousResult.hasPrevious());
    assertFalse(firstResult.hasPrevious());
    assertFalse(previousResult.isUnpaged());
    assertFalse(firstResult.isUnpaged());
    assertFalse(nextResult2.next().isUnpaged());
    assertTrue(previousResult.isPaged());
    assertTrue(firstResult.isPaged());
    assertEquals(actualToPageableResult, previousResult.first());
    assertEquals(actualToPageableResult, firstResult.first());
    assertSame(sort, previousResult.getSort());
    assertSame(sort, firstResult.getSort());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map)} with {@code pageLink},
   * {@code columnMap}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, Map)}
   */
  @Test
  public void testToPageableWithPageLinkColumnMap_givenFoo() {
    // Arrange
    HashMap<String, String> columnMap = new HashMap<>();
    columnMap.computeIfPresent("foo", mock(BiFunction.class));

    // Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, columnMap);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    Sort sort = actualToPageableResult.getSort();
    List<Sort.Order> toListResult = sort.toList();
    assertEquals(1, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(0, actualToPageableResult.getPageNumber());
    assertEquals(0L, actualToPageableResult.getOffset());
    Pageable nextResult = actualToPageableResult.next();
    assertEquals(1, nextResult.getPageNumber());
    Pageable nextResult2 = nextResult.next();
    Pageable nextResult3 = nextResult2.next();
    Pageable nextResult4 = nextResult3.next();
    assertEquals(1000, nextResult4.getPageSize());
    assertEquals(1000, nextResult3.getPageSize());
    assertEquals(1000, nextResult2.getPageSize());
    assertEquals(1000, nextResult.getPageSize());
    assertEquals(1000, actualToPageableResult.getPageSize());
    assertEquals(1000L, nextResult.getOffset());
    assertEquals(2, nextResult2.getPageNumber());
    assertEquals(2000L, nextResult2.getOffset());
    assertEquals(3, nextResult3.getPageNumber());
    assertEquals(3000L, nextResult3.getOffset());
    assertEquals(4, nextResult4.getPageNumber());
    assertEquals(4000L, nextResult4.getOffset());
    assertEquals(Sort.Direction.ASC, getResult.getDirection());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertFalse(actualToPageableResult.hasPrevious());
    assertFalse(nextResult4.isUnpaged());
    assertFalse(nextResult3.isUnpaged());
    assertFalse(nextResult2.isUnpaged());
    assertFalse(nextResult.isUnpaged());
    assertFalse(actualToPageableResult.isUnpaged());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(nextResult4.hasPrevious());
    assertTrue(nextResult3.hasPrevious());
    assertTrue(nextResult2.hasPrevious());
    assertTrue(nextResult.hasPrevious());
    assertTrue(nextResult4.isPaged());
    assertTrue(nextResult3.isPaged());
    assertTrue(nextResult2.isPaged());
    assertTrue(nextResult.isPaged());
    assertTrue(actualToPageableResult.isPaged());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
    assertEquals(actualToPageableResult, ((PageRequest) nextResult).previous());
    assertEquals(actualToPageableResult, nextResult4.first());
    assertEquals(actualToPageableResult, nextResult3.first());
    assertEquals(actualToPageableResult, nextResult2.first());
    assertEquals(actualToPageableResult, nextResult.first());
    assertEquals(actualToPageableResult, actualToPageableResult.first());
    assertSame(sort, nextResult4.getSort());
    assertSame(sort, nextResult3.getSort());
    assertSame(sort, nextResult2.getSort());
    assertSame(sort, nextResult.getSort());
    assertSame(actualToPageableResult, ((PageRequest) actualToPageableResult).previous());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, Map)} with {@code pageLink},
   * {@code columnMap}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageRequest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, Map)}
   */
  @Test
  public void testToPageableWithPageLinkColumnMap_whenFirst_page_thenReturnPageRequest() {
    // Arrange and Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, new HashMap<>());

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    Sort sort = actualToPageableResult.getSort();
    List<Sort.Order> toListResult = sort.toList();
    assertEquals(1, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(0, actualToPageableResult.getPageNumber());
    assertEquals(0L, actualToPageableResult.getOffset());
    Pageable nextResult = actualToPageableResult.next();
    assertEquals(1, nextResult.getPageNumber());
    Pageable nextResult2 = nextResult.next();
    Pageable nextResult3 = nextResult2.next();
    Pageable nextResult4 = nextResult3.next();
    assertEquals(1000, nextResult4.getPageSize());
    assertEquals(1000, nextResult3.getPageSize());
    assertEquals(1000, nextResult2.getPageSize());
    assertEquals(1000, nextResult.getPageSize());
    assertEquals(1000, actualToPageableResult.getPageSize());
    assertEquals(1000L, nextResult.getOffset());
    assertEquals(2, nextResult2.getPageNumber());
    assertEquals(2000L, nextResult2.getOffset());
    assertEquals(3, nextResult3.getPageNumber());
    assertEquals(3000L, nextResult3.getOffset());
    assertEquals(4, nextResult4.getPageNumber());
    assertEquals(4000L, nextResult4.getOffset());
    assertEquals(Sort.Direction.ASC, getResult.getDirection());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertFalse(actualToPageableResult.hasPrevious());
    assertFalse(nextResult4.isUnpaged());
    assertFalse(nextResult3.isUnpaged());
    assertFalse(nextResult2.isUnpaged());
    assertFalse(nextResult.isUnpaged());
    assertFalse(actualToPageableResult.isUnpaged());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(nextResult4.hasPrevious());
    assertTrue(nextResult3.hasPrevious());
    assertTrue(nextResult2.hasPrevious());
    assertTrue(nextResult.hasPrevious());
    assertTrue(nextResult4.isPaged());
    assertTrue(nextResult3.isPaged());
    assertTrue(nextResult2.isPaged());
    assertTrue(nextResult.isPaged());
    assertTrue(actualToPageableResult.isPaged());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
    assertEquals(actualToPageableResult, ((PageRequest) nextResult).previous());
    assertEquals(actualToPageableResult, nextResult4.first());
    assertEquals(actualToPageableResult, nextResult3.first());
    assertEquals(actualToPageableResult, nextResult2.first());
    assertEquals(actualToPageableResult, nextResult.first());
    assertEquals(actualToPageableResult, actualToPageableResult.first());
    assertSame(sort, nextResult4.getSort());
    assertSame(sort, nextResult3.getSort());
    assertSame(sort, nextResult2.getSort());
    assertSame(sort, nextResult.getSort());
    assertSame(actualToPageableResult, ((PageRequest) actualToPageableResult).previous());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, List)} with {@code pageLink},
   * {@code sortOrders}.
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, List)}
   */
  @Test
  public void testToPageableWithPageLinkSortOrders() {
    // Arrange and Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, new ArrayList<>());

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    Pageable nextResult = actualToPageableResult.next().next();
    Pageable nextResult2 = nextResult.first().next();
    PageRequest previousResult = ((PageRequest) nextResult2).previous();
    assertEquals(0, previousResult.getPageNumber());
    Pageable firstResult = nextResult.next().first().first();
    assertEquals(0, firstResult.getPageNumber());
    assertEquals(0L, previousResult.getOffset());
    assertEquals(0L, firstResult.getOffset());
    Sort sort = actualToPageableResult.getSort();
    assertEquals(1, sort.toList().size());
    assertEquals(1000, previousResult.getPageSize());
    assertEquals(1000, firstResult.getPageSize());
    assertFalse(previousResult.hasPrevious());
    assertFalse(firstResult.hasPrevious());
    assertFalse(previousResult.isUnpaged());
    assertFalse(firstResult.isUnpaged());
    assertFalse(nextResult2.next().isUnpaged());
    assertTrue(previousResult.isPaged());
    assertTrue(firstResult.isPaged());
    assertEquals(actualToPageableResult, previousResult.first());
    assertEquals(actualToPageableResult, firstResult.first());
    assertSame(sort, previousResult.getSort());
    assertSame(sort, firstResult.getSort());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, List)} with {@code pageLink},
   * {@code sortOrders}.
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, List)}
   */
  @Test
  public void testToPageableWithPageLinkSortOrders2() {
    // Arrange
    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.of("id", SortOrder.Direction.ASC));

    // Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, sortOrders);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    Pageable nextResult = actualToPageableResult.next().next();
    Pageable nextResult2 = nextResult.first().next();
    PageRequest previousResult = ((PageRequest) nextResult2).previous();
    assertEquals(0, previousResult.getPageNumber());
    Pageable firstResult = nextResult.next().first().first();
    assertEquals(0, firstResult.getPageNumber());
    assertEquals(0L, previousResult.getOffset());
    assertEquals(0L, firstResult.getOffset());
    Sort sort = actualToPageableResult.getSort();
    assertEquals(1, sort.toList().size());
    assertEquals(1000, previousResult.getPageSize());
    assertEquals(1000, firstResult.getPageSize());
    assertFalse(previousResult.hasPrevious());
    assertFalse(firstResult.hasPrevious());
    assertFalse(previousResult.isUnpaged());
    assertFalse(firstResult.isUnpaged());
    assertFalse(nextResult2.next().isUnpaged());
    assertTrue(previousResult.isPaged());
    assertTrue(firstResult.isPaged());
    assertEquals(actualToPageableResult, previousResult.first());
    assertEquals(actualToPageableResult, firstResult.first());
    assertSame(sort, previousResult.getSort());
    assertSame(sort, firstResult.getSort());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, List)} with {@code pageLink},
   * {@code sortOrders}.
   * <ul>
   *   <li>Then return Sort toList first Property is {@code Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, List)}
   */
  @Test
  public void testToPageableWithPageLinkSortOrders_thenReturnSortToListFirstPropertyIsProperty() {
    // Arrange
    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, sortOrders);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Sort.Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(2, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("Property", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("Property", ignoreCaseResult.getProperty());
    assertEquals("Property", ignoreCaseResult.ignoreCase().getProperty());
    Sort.Order ignoreCaseResult2 = toListResult.get(1).ignoreCase();
    assertEquals("id", ignoreCaseResult2.getProperty());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult2.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult2.getNullHandling());
    assertFalse(ignoreCaseResult2.isDescending());
    assertTrue(ignoreCaseResult2.isAscending());
    assertTrue(ignoreCaseResult2.isIgnoreCase());
    assertEquals(ignoreCaseResult2.ignoreCase(), ignoreCaseResult2.ignoreCase());
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink, List)} with {@code pageLink},
   * {@code sortOrders}.
   * <ul>
   *   <li>Then return Sort toList second is Sort toList first.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink, List)}
   */
  @Test
  public void testToPageableWithPageLinkSortOrders_thenReturnSortToListSecondIsSortToListFirst() {
    // Arrange
    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.of("id", SortOrder.Direction.ASC));
    sortOrders.add(SortOrder.of("id", SortOrder.Direction.ASC));

    // Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE, sortOrders);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    List<Sort.Order> toListResult = actualToPageableResult.getSort().toList();
    assertEquals(2, toListResult.size());
    assertEquals(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link DaoUtil#toPageable(PageLink)} with {@code pageLink}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageRequest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toPageable(PageLink)}
   */
  @Test
  public void testToPageableWithPageLink_whenFirst_page_thenReturnPageRequest() {
    // Arrange and Act
    Pageable actualToPageableResult = DaoUtil.toPageable(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    assertTrue(actualToPageableResult instanceof PageRequest);
    Sort sort = actualToPageableResult.getSort();
    List<Sort.Order> toListResult = sort.toList();
    assertEquals(1, toListResult.size());
    Sort.Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Sort.Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(0, actualToPageableResult.getPageNumber());
    assertEquals(0L, actualToPageableResult.getOffset());
    Pageable nextResult = actualToPageableResult.next();
    assertEquals(1, nextResult.getPageNumber());
    Pageable nextResult2 = nextResult.next();
    Pageable nextResult3 = nextResult2.next();
    Pageable nextResult4 = nextResult3.next();
    assertEquals(1000, nextResult4.getPageSize());
    assertEquals(1000, nextResult3.getPageSize());
    assertEquals(1000, nextResult2.getPageSize());
    assertEquals(1000, nextResult.getPageSize());
    assertEquals(1000, actualToPageableResult.getPageSize());
    assertEquals(1000L, nextResult.getOffset());
    assertEquals(2, nextResult2.getPageNumber());
    assertEquals(2000L, nextResult2.getOffset());
    assertEquals(3, nextResult3.getPageNumber());
    assertEquals(3000L, nextResult3.getOffset());
    assertEquals(4, nextResult4.getPageNumber());
    assertEquals(4000L, nextResult4.getOffset());
    assertEquals(Sort.Direction.ASC, getResult.getDirection());
    assertEquals(Sort.Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(Sort.NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(Sort.NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertFalse(actualToPageableResult.hasPrevious());
    assertFalse(nextResult4.isUnpaged());
    assertFalse(nextResult3.isUnpaged());
    assertFalse(nextResult2.isUnpaged());
    assertFalse(nextResult.isUnpaged());
    assertFalse(actualToPageableResult.isUnpaged());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(nextResult4.hasPrevious());
    assertTrue(nextResult3.hasPrevious());
    assertTrue(nextResult2.hasPrevious());
    assertTrue(nextResult.hasPrevious());
    assertTrue(nextResult4.isPaged());
    assertTrue(nextResult3.isPaged());
    assertTrue(nextResult2.isPaged());
    assertTrue(nextResult.isPaged());
    assertTrue(actualToPageableResult.isPaged());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
    assertEquals(actualToPageableResult, ((PageRequest) nextResult).previous());
    assertEquals(actualToPageableResult, nextResult4.first());
    assertEquals(actualToPageableResult, nextResult3.first());
    assertEquals(actualToPageableResult, nextResult2.first());
    assertEquals(actualToPageableResult, nextResult.first());
    assertEquals(actualToPageableResult, actualToPageableResult.first());
    assertSame(sort, nextResult4.getSort());
    assertSame(sort, nextResult3.getSort());
    assertSame(sort, nextResult2.getSort());
    assertSame(sort, nextResult.getSort());
    assertSame(actualToPageableResult, ((PageRequest) actualToPageableResult).previous());
  }

  /**
   * Test {@link DaoUtil#convertDataList(Collection)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#convertDataList(Collection)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@link ToData}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#convertDataList(Collection)}
   */
  @Test
  public void testConvertDataList_whenArrayListAddToData_thenReturnSizeIsTwo() {
    // Arrange
    ToData<Object> toData = mock(ToData.class);
    when(toData.toData()).thenReturn("Data");
    ToData<Object> toData2 = mock(ToData.class);
    when(toData2.toData()).thenReturn("Data");

    ArrayList<ToData<Object>> toDataList = new ArrayList<>();
    toDataList.add(toData2);
    toDataList.add(toData);

    // Act
    List<Object> actualConvertDataListResult = DaoUtil.convertDataList(toDataList);

    // Assert
    verify(toData2).toData();
    verify(toData).toData();
    assertEquals(2, actualConvertDataListResult.size());
    assertEquals("Data", actualConvertDataListResult.get(0));
    assertEquals("Data", actualConvertDataListResult.get(1));
  }

  /**
   * Test {@link DaoUtil#convertDataList(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#convertDataList(Collection)}
   */
  @Test
  public void testConvertDataList_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualConvertDataListResult = DaoUtil.convertDataList(new ArrayList<>());

    // Assert
    assertTrue(actualConvertDataListResult.isEmpty());
  }

  /**
   * Test {@link DaoUtil#convertDataList(Collection)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#convertDataList(Collection)}
   */
  @Test
  public void testConvertDataList_whenNull_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualConvertDataListResult = DaoUtil.convertDataList(null);

    // Assert
    assertTrue(actualConvertDataListResult.isEmpty());
  }

  /**
   * Test {@link DaoUtil#getData(ToData)} with {@code ToData}.
   * <ul>
   *   <li>Given {@code Data}.</li>
   *   <li>When {@link ToData} {@link ToData#toData()} return {@code Data}.</li>
   *   <li>Then return {@code Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#getData(ToData)}
   */
  @Test
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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#getData(ToData)}
   */
  @Test
  public void testGetDataWithToData_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DaoUtil.getData((ToData<Object>) null));
  }

  /**
   * Test {@link DaoUtil#getId(UUIDBased)}.
   * <ul>
   *   <li>Then return toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#getId(UUIDBased)}
   */
  @Test
  public void testGetId_thenReturnToStringIs138140001dd211b28080808080808080() {
    // Arrange, Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", DaoUtil.getId(BaseEntityService.NULL_CUSTOMER_ID).toString());
  }

  /**
   * Test {@link DaoUtil#getId(UUIDBased)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#getId(UUIDBased)}
   */
  @Test
  public void testGetId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DaoUtil.getId(null));
  }

  /**
   * Test {@link DaoUtil#toUUIDs(List)}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toUUIDs(List)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toUUIDs(List)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toUUIDs(List)}
   */
  @Test
  public void testToUUIDs_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<UUID> actualToUUIDsResult = DaoUtil.toUUIDs(new ArrayList<>());

    // Assert
    assertTrue(actualToUUIDsResult.isEmpty());
  }

  /**
   * Test {@link DaoUtil#fromUUIDs(List, Function)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#fromUUIDs(List, Function)}
   */
  @Test
  public void testFromUUIDs_givenNull_uuid_whenArrayListAddNull_uuid_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<UUID> uuids = new ArrayList<>();
    uuids.add(ModelConstants.NULL_UUID);
    Function<UUID, Object> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<UUID>any())).thenReturn("Apply");

    // Act
    List<Object> actualFromUUIDsResult = DaoUtil.fromUUIDs(uuids, mapper);

    // Assert
    verify(mapper).apply(isA(UUID.class));
    assertEquals(1, actualFromUUIDsResult.size());
    assertEquals("Apply", actualFromUUIDsResult.get(0));
  }

  /**
   * Test {@link DaoUtil#fromUUIDs(List, Function)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#fromUUIDs(List, Function)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#fromUUIDs(List, Function)}
   */
  @Test
  public void testFromUUIDs_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualFromUUIDsResult = DaoUtil.<Object>fromUUIDs(new ArrayList<>(), mock(Function.class));

    // Assert
    assertTrue(actualFromUUIDsResult.isEmpty());
  }

  /**
   * Test {@link DaoUtil#toEntityId(UUID, Function)}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>When {@link Function} {@link Function#apply(Object)} return
   * {@code Apply}.</li>
   *   <li>Then return {@code Apply}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toEntityId(UUID, Function)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link Function}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#toEntityId(UUID, Function)}
   */
  @Test
  public void testToEntityId_whenFunction_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DaoUtil.<Object>toEntityId(null, mock(Function.class)));
  }

  /**
   * Test {@link DaoUtil#processInBatches(Function, int, Consumer)}.
   * <ul>
   *   <li>Given emptyPageData.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#processInBatches(Function, int, Consumer)}
   */
  @Test
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
   * <ul>
   *   <li>Given emptyPageData.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#processBatches(Function, int, Consumer)}
   */
  @Test
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
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#getStringId(UUIDBased)}
   */
  @Test
  public void testGetStringId_whenNull_customer_id_thenReturn138140001dd211b28080808080808080() {
    // Arrange, Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", DaoUtil.getStringId(BaseEntityService.NULL_CUSTOMER_ID));
  }

  /**
   * Test {@link DaoUtil#getStringId(UUIDBased)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#getStringId(UUIDBased)}
   */
  @Test
  public void testGetStringId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DaoUtil.getStringId(null));
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}.
   * <p>
   * Method under test:
   * {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}
   */
  @Test
  public void testConvertTenantEntityTypesToDto() {
    // Arrange
    UUID tenantUUID = ModelConstants.NULL_UUID;

    // Act
    List<EntitySubtype> actualConvertTenantEntityTypesToDtoResult = DaoUtil.convertTenantEntityTypesToDto(tenantUUID,
        EntityType.TENANT, new ArrayList<>());

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantUUID.toString());
    assertTrue(actualConvertTenantEntityTypesToDtoResult.isEmpty());
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}.
   * <p>
   * Method under test:
   * {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}
   */
  @Test
  public void testConvertTenantEntityTypesToDto2() {
    // Arrange
    ArrayList<String> types = new ArrayList<>();
    types.add("foo");

    // Act
    List<EntitySubtype> actualConvertTenantEntityTypesToDtoResult = DaoUtil
        .convertTenantEntityTypesToDto(ModelConstants.NULL_UUID, EntityType.TENANT, types);

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
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}
   */
  @Test
  public void testConvertTenantEntityTypesToDto_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<String> types = new ArrayList<>();
    types.add("42");
    types.add("foo");

    // Act
    List<EntitySubtype> actualConvertTenantEntityTypesToDtoResult = DaoUtil
        .convertTenantEntityTypesToDto(ModelConstants.NULL_UUID, EntityType.TENANT, types);

    // Assert
    assertEquals(2, actualConvertTenantEntityTypesToDtoResult.size());
    assertEquals("42", actualConvertTenantEntityTypesToDtoResult.get(0).getType());
    EntitySubtype getResult = actualConvertTenantEntityTypesToDtoResult.get(1);
    assertEquals("foo", getResult.getType());
    assertEquals(EntityType.TENANT, getResult.getEntityType());
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}.
   * <ul>
   *   <li>Then return not first TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}
   */
  @Test
  public void testConvertTenantEntityTypesToDto_thenReturnNotFirstTenantIdNullUid() {
    // Arrange
    UUID tenantUUID = UUID.randomUUID();

    ArrayList<String> types = new ArrayList<>();
    types.add("foo");

    // Act
    List<EntitySubtype> actualConvertTenantEntityTypesToDtoResult = DaoUtil.convertTenantEntityTypesToDto(tenantUUID,
        EntityType.TENANT, types);

    // Assert
    assertEquals(1, actualConvertTenantEntityTypesToDtoResult.size());
    TenantId tenantId = actualConvertTenantEntityTypesToDtoResult.get(0).getTenantId();
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(tenantUUID, tenantId.getId());
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}.
   * <p>
   * Method under test:
   * {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}
   */
  @Test
  public void testConvertTenantEntityInfosToDto() {
    // Arrange
    UUID tenantUUID = ModelConstants.NULL_UUID;

    // Act
    List<EntitySubtype> actualConvertTenantEntityInfosToDtoResult = DaoUtil.convertTenantEntityInfosToDto(tenantUUID,
        EntityType.TENANT, new ArrayList<>());

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantUUID.toString());
    assertTrue(actualConvertTenantEntityInfosToDtoResult.isEmpty());
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}.
   * <p>
   * Method under test:
   * {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}
   */
  @Test
  public void testConvertTenantEntityInfosToDto2() {
    // Arrange
    ArrayList<EntityInfo> entityInfos = new ArrayList<>();
    entityInfos.add(new EntityInfo(BaseEntityService.NULL_CUSTOMER_ID, "Name"));

    // Act
    List<EntitySubtype> actualConvertTenantEntityInfosToDtoResult = DaoUtil
        .convertTenantEntityInfosToDto(ModelConstants.NULL_UUID, EntityType.TENANT, entityInfos);

    // Assert
    assertEquals(1, actualConvertTenantEntityInfosToDtoResult.size());
    TenantId tenantId = actualConvertTenantEntityInfosToDtoResult.get(0).getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}.
   * <ul>
   *   <li>Then return not first TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}
   */
  @Test
  public void testConvertTenantEntityInfosToDto_thenReturnNotFirstTenantIdNullUid() {
    // Arrange
    UUID tenantUUID = UUID.randomUUID();

    ArrayList<EntityInfo> entityInfos = new ArrayList<>();
    entityInfos.add(new EntityInfo(BaseEntityService.NULL_CUSTOMER_ID, "Name"));

    // Act
    List<EntitySubtype> actualConvertTenantEntityInfosToDtoResult = DaoUtil.convertTenantEntityInfosToDto(tenantUUID,
        EntityType.TENANT, entityInfos);

    // Assert
    assertEquals(1, actualConvertTenantEntityInfosToDtoResult.size());
    TenantId tenantId = actualConvertTenantEntityInfosToDtoResult.get(0).getTenantId();
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(tenantUUID, tenantId.getId());
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}
   */
  @Test
  public void testConvertTenantEntityInfosToDto_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<EntityInfo> entityInfos = new ArrayList<>();
    entityInfos.add(new EntityInfo(BaseEntityService.NULL_CUSTOMER_ID, "Name"));
    entityInfos.add(new EntityInfo(BaseEntityService.NULL_CUSTOMER_ID, "Name"));

    // Act
    List<EntitySubtype> actualConvertTenantEntityInfosToDtoResult = DaoUtil
        .convertTenantEntityInfosToDto(ModelConstants.NULL_UUID, EntityType.TENANT, entityInfos);

    // Assert
    assertEquals(2, actualConvertTenantEntityInfosToDtoResult.size());
    assertEquals(actualConvertTenantEntityInfosToDtoResult.get(0), actualConvertTenantEntityInfosToDtoResult.get(1));
  }
}
