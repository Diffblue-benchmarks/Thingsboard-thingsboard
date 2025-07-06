package org.thingsboard.server.common.data.page;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.NullHandling;
import org.springframework.data.domain.Sort.Order;

class PageLinkDiffblueTest {
  /**
   * Test {@link PageLink#equals(Object)}, and {@link PageLink#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageLink#equals(Object)}
   *   <li>{@link PageLink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageLink.equals(Object)", "int PageLink.hashCode()"})
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
   * Test {@link PageLink#equals(Object)}, and {@link PageLink#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageLink#equals(Object)}
   *   <li>{@link PageLink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageLink.equals(Object)", "int PageLink.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PageLink pageLink = new PageLink(3, 1);
    TimePageLink timePageLink = mock(TimePageLink.class);
    when(timePageLink.getTextSearch()).thenReturn(null);
    when(timePageLink.getSortOrder()).thenReturn(null);
    when(timePageLink.getPage()).thenReturn(1);
    when(timePageLink.getPageSize()).thenReturn(3);
    when(timePageLink.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(pageLink, timePageLink);
    int notExpectedHashCodeResult = pageLink.hashCode();
    assertNotEquals(notExpectedHashCodeResult, timePageLink.hashCode());
  }

  /**
   * Test {@link PageLink#equals(Object)}, and {@link PageLink#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageLink#equals(Object)}
   *   <li>{@link PageLink#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageLink.equals(Object)", "int PageLink.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    // Act and Assert
    assertEquals(pageLink, pageLink);
    int expectedHashCodeResult = pageLink.hashCode();
    assertEquals(expectedHashCodeResult, pageLink.hashCode());
  }

  /**
   * Test {@link PageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageLink.equals(Object)", "int PageLink.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PageLink pageLink = new PageLink(1);

    // Act and Assert
    assertNotEquals(pageLink, new PageLink(3));
  }

  /**
   * Test {@link PageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageLink.equals(Object)", "int PageLink.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PageLink pageLink = new PageLink(3, 1);

    // Act and Assert
    assertNotEquals(pageLink, new PageLink(3));
  }

  /**
   * Test {@link PageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageLink.equals(Object)", "int PageLink.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    // Act and Assert
    assertNotEquals(pageLink, new TimePageLink(3));
  }

  /**
   * Test {@link PageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageLink.equals(Object)", "int PageLink.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PageLink pageLink = new PageLink(3);
    TimePageLink timePageLink = mock(TimePageLink.class);
    when(timePageLink.getTextSearch()).thenReturn(null);
    when(timePageLink.getSortOrder()).thenReturn(null);
    when(timePageLink.getPage()).thenReturn(1);
    when(timePageLink.getPageSize()).thenReturn(3);
    when(timePageLink.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(pageLink, timePageLink);
  }

  /**
   * Test {@link PageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageLink.equals(Object)", "int PageLink.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    PageLink pageLink = new PageLink(3, 1, "Text Search");
    TimePageLink timePageLink = mock(TimePageLink.class);
    when(timePageLink.getTextSearch()).thenReturn(null);
    when(timePageLink.getSortOrder()).thenReturn(null);
    when(timePageLink.getPage()).thenReturn(1);
    when(timePageLink.getPageSize()).thenReturn(3);
    when(timePageLink.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(pageLink, timePageLink);
  }

  /**
   * Test {@link PageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageLink.equals(Object)", "int PageLink.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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
   * Test {@link PageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageLink.equals(Object)", "int PageLink.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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
   * Test {@link PageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageLink.equals(Object)", "int PageLink.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PageLink(3), null);
  }

  /**
   * Test {@link PageLink#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageLink.equals(Object)", "int PageLink.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PageLink(3), "Different type to PageLink");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void PageLink.<init>(int)",
    "void PageLink.<init>(int, int)",
    "void PageLink.<init>(int, int, String)",
    "void PageLink.<init>(int, int, String, SortOrder)",
    "int PageLink.getPage()",
    "int PageLink.getPageSize()",
    "SortOrder PageLink.getSortOrder()",
    "String PageLink.getTextSearch()",
    "String PageLink.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    PageLink actualPageLink = new PageLink(3);
    String actualToStringResult = actualPageLink.toString();
    int actualPage = actualPageLink.getPage();
    int actualPageSize = actualPageLink.getPageSize();
    SortOrder actualSortOrder = actualPageLink.getSortOrder();

    // Assert
    assertEquals(
        "PageLink(textSearch=null, pageSize=3, page=0, sortOrder=null)", actualToStringResult);
    assertNull(actualPageLink.getTextSearch());
    assertNull(actualSortOrder);
    assertEquals(0, actualPage);
    assertEquals(3, actualPageSize);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void PageLink.<init>(int)",
    "void PageLink.<init>(int, int)",
    "void PageLink.<init>(int, int, String)",
    "void PageLink.<init>(int, int, String, SortOrder)",
    "int PageLink.getPage()",
    "int PageLink.getPageSize()",
    "SortOrder PageLink.getSortOrder()",
    "String PageLink.getTextSearch()",
    "String PageLink.toString()"
  })
  void testGettersAndSetters2() {
    // Arrange and Act
    PageLink actualPageLink = new PageLink(3, 1);
    String actualToStringResult = actualPageLink.toString();
    int actualPage = actualPageLink.getPage();
    int actualPageSize = actualPageLink.getPageSize();
    SortOrder actualSortOrder = actualPageLink.getSortOrder();

    // Assert
    assertEquals(
        "PageLink(textSearch=null, pageSize=3, page=1, sortOrder=null)", actualToStringResult);
    assertNull(actualPageLink.getTextSearch());
    assertNull(actualSortOrder);
    assertEquals(1, actualPage);
    assertEquals(3, actualPageSize);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void PageLink.<init>(int)",
    "void PageLink.<init>(int, int)",
    "void PageLink.<init>(int, int, String)",
    "void PageLink.<init>(int, int, String, SortOrder)",
    "int PageLink.getPage()",
    "int PageLink.getPageSize()",
    "SortOrder PageLink.getSortOrder()",
    "String PageLink.getTextSearch()",
    "String PageLink.toString()"
  })
  void testGettersAndSetters3() {
    // Arrange and Act
    PageLink actualPageLink = new PageLink(3, 1, "Text Search");
    String actualToStringResult = actualPageLink.toString();
    int actualPage = actualPageLink.getPage();
    int actualPageSize = actualPageLink.getPageSize();
    SortOrder actualSortOrder = actualPageLink.getSortOrder();

    // Assert
    assertEquals(
        "PageLink(textSearch=Text Search, pageSize=3, page=1, sortOrder=null)",
        actualToStringResult);
    assertEquals("Text Search", actualPageLink.getTextSearch());
    assertNull(actualSortOrder);
    assertEquals(1, actualPage);
    assertEquals(3, actualPageSize);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link SortOrder#BY_CREATED_TIME_DESC}.
   *   <li>Then return toString is a string.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @DisplayName(
      "Test getters and setters; when BY_CREATED_TIME_DESC; then return toString is a string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void PageLink.<init>(int)",
    "void PageLink.<init>(int, int)",
    "void PageLink.<init>(int, int, String)",
    "void PageLink.<init>(int, int, String, SortOrder)",
    "int PageLink.getPage()",
    "int PageLink.getPageSize()",
    "SortOrder PageLink.getSortOrder()",
    "String PageLink.getTextSearch()",
    "String PageLink.toString()"
  })
  void testGettersAndSetters_whenBy_created_time_desc_thenReturnToStringIsAString() {
    // Arrange and Act
    PageLink actualPageLink = new PageLink(3, 1, "Text Search", SortOrder.BY_CREATED_TIME_DESC);
    String actualToStringResult = actualPageLink.toString();
    int actualPage = actualPageLink.getPage();
    int actualPageSize = actualPageLink.getPageSize();
    SortOrder actualSortOrder = actualPageLink.getSortOrder();

    // Assert
    assertEquals(
        "PageLink(textSearch=Text Search, pageSize=3, page=1, sortOrder=SortOrder(property=createdTime,"
            + " direction=DESC))",
        actualToStringResult);
    assertEquals("Text Search", actualPageLink.getTextSearch());
    assertEquals(1, actualPage);
    assertEquals(3, actualPageSize);
    assertSame(actualSortOrder.BY_CREATED_TIME_DESC, actualSortOrder);
  }

  /**
   * Test {@link PageLink#PageLink(PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageLink#PageLink(int)} with pageSize is three.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#PageLink(PageLink)}
   */
  @Test
  @DisplayName("Test new PageLink(PageLink); then return PageLink(int) with pageSize is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageLink.<init>(PageLink)"})
  void testNewPageLink_thenReturnPageLinkWithPageSizeIsThree() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    // Act and Assert
    assertEquals(pageLink, new PageLink(pageLink));
  }

  /**
   * Test {@link PageLink#nextPageLink()}.
   *
   * <ul>
   *   <li>Given {@link PageLink#PageLink(int)} with pageSize is three.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#nextPageLink()}
   */
  @Test
  @DisplayName("Test nextPageLink(); given PageLink(int) with pageSize is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageLink PageLink.nextPageLink()"})
  void testNextPageLink_givenPageLinkWithPageSizeIsThree() {
    // Arrange and Act
    PageLink actualNextPageLinkResult = new PageLink(3).nextPageLink();

    // Assert
    assertNull(actualNextPageLinkResult.getTextSearch());
    assertNull(actualNextPageLinkResult.getSortOrder());
    assertEquals(1, actualNextPageLinkResult.getPage());
    assertEquals(3, actualNextPageLinkResult.getPageSize());
  }

  /**
   * Test {@link PageLink#nextPageLink()}.
   *
   * <ul>
   *   <li>Given {@link TimePageLink#TimePageLink(int)} with pageSize is three.
   *   <li>Then return {@link TimePageLink}.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#nextPageLink()}
   */
  @Test
  @DisplayName(
      "Test nextPageLink(); given TimePageLink(int) with pageSize is three; then return TimePageLink")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageLink PageLink.nextPageLink()"})
  void testNextPageLink_givenTimePageLinkWithPageSizeIsThree_thenReturnTimePageLink() {
    // Arrange and Act
    TimePageLink actualNextPageLinkResult = new TimePageLink(3).nextPageLink();

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
   * Test {@link PageLink#toSort(SortOrder, Map, boolean)} with {@code sortOrder}, {@code
   * columnMap}, {@code addDefaultSorting}.
   *
   * <p>Method under test: {@link PageLink#toSort(SortOrder, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toSort(SortOrder, Map, boolean) with 'sortOrder', 'columnMap', 'addDefaultSorting'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Sort PageLink.toSort(SortOrder, Map, boolean)"})
  void testToSortWithSortOrderColumnMapAddDefaultSorting() {
    // Arrange
    PageLink pageLink = new PageLink(3);
    SortOrder sortOrder = SortOrder.of("id", SortOrder.Direction.ASC);

    // Act and Assert
    List<Order> toListResult = pageLink.toSort(sortOrder, new HashMap<>(), true).toList();
    assertEquals(1, toListResult.size());
    assertEquals(
        toListResult.get(0).ignoreCase().ignoreCase(),
        toListResult.get(0).ignoreCase().ignoreCase());
  }

  /**
   * Test {@link PageLink#toSort(SortOrder, Map, boolean)} with {@code sortOrder}, {@code
   * columnMap}, {@code addDefaultSorting}.
   *
   * <ul>
   *   <li>Then return toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#toSort(SortOrder, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toSort(SortOrder, Map, boolean) with 'sortOrder', 'columnMap', 'addDefaultSorting'; then return toList size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Sort PageLink.toSort(SortOrder, Map, boolean)"})
  void testToSortWithSortOrderColumnMapAddDefaultSorting_thenReturnToListSizeIsTwo() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    // Act and Assert
    List<Order> toListResult =
        pageLink.toSort(SortOrder.BY_CREATED_TIME_DESC, new HashMap<>(), true).toList();
    assertEquals(2, toListResult.size());
    Order getResult = toListResult.get(1);
    assertEquals("id", getResult.getProperty());
    Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertEquals(
        toListResult.get(0).ignoreCase().ignoreCase(),
        toListResult.get(0).ignoreCase().ignoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
  }

  /**
   * Test {@link PageLink#toSort(SortOrder, Map, boolean)} with {@code sortOrder}, {@code
   * columnMap}, {@code addDefaultSorting}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#toSort(SortOrder, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toSort(SortOrder, Map, boolean) with 'sortOrder', 'columnMap', 'addDefaultSorting'; when 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Sort PageLink.toSort(SortOrder, Map, boolean)"})
  void testToSortWithSortOrderColumnMapAddDefaultSorting_whenFalse() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    // Act and Assert
    List<Order> toListResult =
        pageLink.toSort(SortOrder.BY_CREATED_TIME_DESC, new HashMap<>(), false).toList();
    assertEquals(1, toListResult.size());
    assertEquals(
        toListResult.get(0).ignoreCase().ignoreCase(),
        toListResult.get(0).ignoreCase().ignoreCase());
  }

  /**
   * Test {@link PageLink#toSort(SortOrder, Map, boolean)} with {@code sortOrder}, {@code
   * columnMap}, {@code addDefaultSorting}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()} {@code id} is {@code id}.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#toSort(SortOrder, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toSort(SortOrder, Map, boolean) with 'sortOrder', 'columnMap', 'addDefaultSorting'; when HashMap() 'id' is 'id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Sort PageLink.toSort(SortOrder, Map, boolean)"})
  void testToSortWithSortOrderColumnMapAddDefaultSorting_whenHashMapIdIsId() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    HashMap<String, String> columnMap = new HashMap<>();
    columnMap.put("id", "id");

    // Act and Assert
    List<Order> toListResult =
        pageLink.toSort(SortOrder.BY_CREATED_TIME_DESC, columnMap, true).toList();
    assertEquals(2, toListResult.size());
    Order getResult = toListResult.get(1);
    assertEquals("id", getResult.getProperty());
    Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(NullHandling.NATIVE, getResult.getNullHandling());
    assertEquals(NullHandling.NATIVE, ignoreCaseResult.getNullHandling());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult.isIgnoreCase());
    assertEquals(
        toListResult.get(0).ignoreCase().ignoreCase(),
        toListResult.get(0).ignoreCase().ignoreCase());
    assertEquals(ignoreCaseResult.ignoreCase(), ignoreCaseResult.ignoreCase());
  }

  /**
   * Test {@link PageLink#toSort(SortOrder, Map, boolean)} with {@code sortOrder}, {@code
   * columnMap}, {@code addDefaultSorting}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#toSort(SortOrder, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toSort(SortOrder, Map, boolean) with 'sortOrder', 'columnMap', 'addDefaultSorting'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Sort PageLink.toSort(SortOrder, Map, boolean)"})
  void testToSortWithSortOrderColumnMapAddDefaultSorting_whenNull() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    // Act and Assert
    List<Order> toListResult = pageLink.toSort((SortOrder) null, new HashMap<>(), true).toList();
    assertEquals(1, toListResult.size());
    assertEquals(
        toListResult.get(0).ignoreCase().ignoreCase(),
        toListResult.get(0).ignoreCase().ignoreCase());
  }

  /**
   * Test {@link PageLink#toSort(List, Map, boolean)} with {@code sortOrders}, {@code columnMap},
   * {@code addDefaultSorting}.
   *
   * <p>Method under test: {@link PageLink#toSort(List, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toSort(List, Map, boolean) with 'sortOrders', 'columnMap', 'addDefaultSorting'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Sort PageLink.toSort(List, Map, boolean)"})
  void testToSortWithSortOrdersColumnMapAddDefaultSorting() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.of("id", SortOrder.Direction.ASC));

    // Act and Assert
    List<Order> toListResult = pageLink.toSort(sortOrders, new HashMap<>(), true).toList();
    assertEquals(1, toListResult.size());
    Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    Order ignoreCaseResult2 = ignoreCaseResult.ignoreCase();
    assertEquals("id", ignoreCaseResult2.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult2.getDirection());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertFalse(ignoreCaseResult2.isDescending());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult2.isAscending());
  }

  /**
   * Test {@link PageLink#toSort(List, Map, boolean)} with {@code sortOrders}, {@code columnMap},
   * {@code addDefaultSorting}.
   *
   * <ul>
   *   <li>Given {@code id}.
   *   <li>When {@link HashMap#HashMap()} {@code id} is {@code id}.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#toSort(List, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toSort(List, Map, boolean) with 'sortOrders', 'columnMap', 'addDefaultSorting'; given 'id'; when HashMap() 'id' is 'id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Sort PageLink.toSort(List, Map, boolean)"})
  void testToSortWithSortOrdersColumnMapAddDefaultSorting_givenId_whenHashMapIdIsId() {
    // Arrange
    PageLink pageLink = new PageLink(3);
    ArrayList<SortOrder> sortOrders = new ArrayList<>();

    HashMap<String, String> columnMap = new HashMap<>();
    columnMap.put("id", "id");

    // Act and Assert
    List<Order> toListResult = pageLink.toSort(sortOrders, columnMap, true).toList();
    assertEquals(1, toListResult.size());
    Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    Order ignoreCaseResult2 = ignoreCaseResult.ignoreCase();
    assertEquals("id", ignoreCaseResult2.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult2.getDirection());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertFalse(ignoreCaseResult2.isDescending());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult2.isAscending());
  }

  /**
   * Test {@link PageLink#toSort(List, Map, boolean)} with {@code sortOrders}, {@code columnMap},
   * {@code addDefaultSorting}.
   *
   * <ul>
   *   <li>Then return toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#toSort(List, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toSort(List, Map, boolean) with 'sortOrders', 'columnMap', 'addDefaultSorting'; then return toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Sort PageLink.toSort(List, Map, boolean)"})
  void testToSortWithSortOrdersColumnMapAddDefaultSorting_thenReturnToListEmpty() {
    // Arrange
    PageLink pageLink = new PageLink(3);
    ArrayList<SortOrder> sortOrders = new ArrayList<>();

    // Act and Assert
    assertTrue(pageLink.toSort(sortOrders, new HashMap<>(), false).toList().isEmpty());
  }

  /**
   * Test {@link PageLink#toSort(List, Map, boolean)} with {@code sortOrders}, {@code columnMap},
   * {@code addDefaultSorting}.
   *
   * <ul>
   *   <li>Then return toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#toSort(List, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toSort(List, Map, boolean) with 'sortOrders', 'columnMap', 'addDefaultSorting'; then return toList size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Sort PageLink.toSort(List, Map, boolean)"})
  void testToSortWithSortOrdersColumnMapAddDefaultSorting_thenReturnToListSizeIsOne() {
    // Arrange
    PageLink pageLink = new PageLink(3);
    ArrayList<SortOrder> sortOrders = new ArrayList<>();

    // Act and Assert
    List<Order> toListResult = pageLink.toSort(sortOrders, new HashMap<>(), true).toList();
    assertEquals(1, toListResult.size());
    Order getResult = toListResult.get(0);
    assertEquals("id", getResult.getProperty());
    Order ignoreCaseResult = getResult.ignoreCase();
    assertEquals("id", ignoreCaseResult.getProperty());
    Order ignoreCaseResult2 = ignoreCaseResult.ignoreCase();
    assertEquals("id", ignoreCaseResult2.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult.getDirection());
    assertEquals(Direction.ASC, ignoreCaseResult2.getDirection());
    assertFalse(getResult.isDescending());
    assertFalse(ignoreCaseResult.isDescending());
    assertFalse(ignoreCaseResult2.isDescending());
    assertTrue(getResult.isAscending());
    assertTrue(ignoreCaseResult.isAscending());
    assertTrue(ignoreCaseResult2.isAscending());
  }

  /**
   * Test {@link PageLink#toSort(List, Map, boolean)} with {@code sortOrders}, {@code columnMap},
   * {@code addDefaultSorting}.
   *
   * <ul>
   *   <li>Then return toList size is three.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#toSort(List, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toSort(List, Map, boolean) with 'sortOrders', 'columnMap', 'addDefaultSorting'; then return toList size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Sort PageLink.toSort(List, Map, boolean)"})
  void testToSortWithSortOrdersColumnMapAddDefaultSorting_thenReturnToListSizeIsThree() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);

    // Act and Assert
    List<Order> toListResult = pageLink.toSort(sortOrders, new HashMap<>(), true).toList();
    assertEquals(3, toListResult.size());
    Order getResult = toListResult.get(2);
    assertEquals("id", getResult.getProperty());
    assertEquals(Direction.ASC, getResult.getDirection());
    assertEquals(NullHandling.NATIVE, getResult.getNullHandling());
    assertFalse(getResult.isDescending());
    assertFalse(getResult.isIgnoreCase());
    assertTrue(getResult.isAscending());
    assertEquals(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PageLink#toSort(List, Map, boolean)} with {@code sortOrders}, {@code columnMap},
   * {@code addDefaultSorting}.
   *
   * <ul>
   *   <li>Then return toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#toSort(List, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toSort(List, Map, boolean) with 'sortOrders', 'columnMap', 'addDefaultSorting'; then return toList size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Sort PageLink.toSort(List, Map, boolean)"})
  void testToSortWithSortOrdersColumnMapAddDefaultSorting_thenReturnToListSizeIsTwo() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);

    // Act and Assert
    List<Order> toListResult = pageLink.toSort(sortOrders, new HashMap<>(), true).toList();
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
   * Test {@link PageLink#isDefaultSortOrderAvailable(List)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#isDefaultSortOrderAvailable(List)}
   */
  @Test
  @DisplayName("Test isDefaultSortOrderAvailable(List); given BY_CREATED_TIME_DESC")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageLink.isDefaultSortOrderAvailable(List)"})
  void testIsDefaultSortOrderAvailable_givenBy_created_time_desc() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);

    // Act and Assert
    assertFalse(pageLink.isDefaultSortOrderAvailable(sortOrders));
  }

  /**
   * Test {@link PageLink#isDefaultSortOrderAvailable(List)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#isDefaultSortOrderAvailable(List)}
   */
  @Test
  @DisplayName("Test isDefaultSortOrderAvailable(List); given BY_CREATED_TIME_DESC")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageLink.isDefaultSortOrderAvailable(List)"})
  void testIsDefaultSortOrderAvailable_givenBy_created_time_desc2() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);
    sortOrders.add(SortOrder.BY_CREATED_TIME_DESC);

    // Act and Assert
    assertFalse(pageLink.isDefaultSortOrderAvailable(sortOrders));
  }

  /**
   * Test {@link PageLink#isDefaultSortOrderAvailable(List)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#isDefaultSortOrderAvailable(List)}
   */
  @Test
  @DisplayName("Test isDefaultSortOrderAvailable(List); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageLink.isDefaultSortOrderAvailable(List)"})
  void testIsDefaultSortOrderAvailable_thenReturnTrue() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    ArrayList<SortOrder> sortOrders = new ArrayList<>();
    sortOrders.add(SortOrder.of("id", SortOrder.Direction.ASC));

    // Act and Assert
    assertTrue(pageLink.isDefaultSortOrderAvailable(sortOrders));
  }

  /**
   * Test {@link PageLink#isDefaultSortOrderAvailable(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PageLink#isDefaultSortOrderAvailable(List)}
   */
  @Test
  @DisplayName("Test isDefaultSortOrderAvailable(List); when ArrayList(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageLink.isDefaultSortOrderAvailable(List)"})
  void testIsDefaultSortOrderAvailable_whenArrayList_thenReturnFalse() {
    // Arrange
    PageLink pageLink = new PageLink(3);

    // Act and Assert
    assertFalse(pageLink.isDefaultSortOrderAvailable(new ArrayList<>()));
  }
}
