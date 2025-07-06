package org.thingsboard.server.common.data.page;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PageDataDiffblueTest {
  /**
   * Test {@link PageData#PageData()}.
   *
   * <p>Method under test: {@link PageData#PageData()}
   */
  @Test
  @DisplayName("Test new PageData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageData.<init>()"})
  void testNewPageData() {
    // Arrange and Act
    PageData<Object> actualPageData = new PageData<>();

    // Assert
    assertEquals(0, actualPageData.getTotalPages());
    assertEquals(0L, actualPageData.getTotalElements());
    assertFalse(actualPageData.hasNext());
    assertTrue(actualPageData.getData().isEmpty());
  }

  /**
   * Test {@link PageData#PageData(List, int, long, boolean)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Data is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PageData#PageData(List, int, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PageData(List, int, long, boolean); given '42'; when ArrayList() add '42'; then return Data is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageData.<init>(List, int, long, boolean)"})
  void testNewPageData_given42_whenArrayListAdd42_thenReturnDataIsArrayList() {
    // Arrange
    ArrayList<Object> data = new ArrayList<>();
    data.add("42");

    // Act
    PageData<Object> actualPageData = new PageData<>(data, 1, 1L, true);

    // Assert
    assertEquals(1, actualPageData.getTotalPages());
    assertEquals(1L, actualPageData.getTotalElements());
    assertTrue(actualPageData.hasNext());
    assertSame(data, actualPageData.getData());
  }

  /**
   * Test {@link PageData#PageData(List, int, long, boolean)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Data is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PageData#PageData(List, int, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PageData(List, int, long, boolean); given '42'; when ArrayList() add '42'; then return Data is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageData.<init>(List, int, long, boolean)"})
  void testNewPageData_given42_whenArrayListAdd42_thenReturnDataIsArrayList2() {
    // Arrange
    ArrayList<Object> data = new ArrayList<>();
    data.add("42");
    data.add("42");

    // Act
    PageData<Object> actualPageData = new PageData<>(data, 1, 1L, true);

    // Assert
    assertEquals(1, actualPageData.getTotalPages());
    assertEquals(1L, actualPageData.getTotalElements());
    assertTrue(actualPageData.hasNext());
    assertSame(data, actualPageData.getData());
  }

  /**
   * Test {@link PageData#PageData(List, int, long, boolean)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Data Empty.
   * </ul>
   *
   * <p>Method under test: {@link PageData#PageData(List, int, long, boolean)}
   */
  @Test
  @DisplayName(
      "Test new PageData(List, int, long, boolean); when ArrayList(); then return Data Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageData.<init>(List, int, long, boolean)"})
  void testNewPageData_whenArrayList_thenReturnDataEmpty() {
    // Arrange and Act
    PageData<Object> actualPageData = new PageData<>(new ArrayList<>(), 1, 1L, true);

    // Assert
    assertEquals(1, actualPageData.getTotalPages());
    assertEquals(1L, actualPageData.getTotalElements());
    assertTrue(actualPageData.getData().isEmpty());
    assertTrue(actualPageData.hasNext());
  }

  /**
   * Test {@link PageData#emptyPageData()}.
   *
   * <p>Method under test: {@link PageData#emptyPageData()}
   */
  @Test
  @DisplayName("Test emptyPageData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData PageData.emptyPageData()"})
  void testEmptyPageData() {
    // Arrange and Act
    PageData<Object> actualEmptyPageDataResult = PageData.emptyPageData();

    // Assert
    assertEquals(0, actualEmptyPageDataResult.getTotalPages());
    assertEquals(0L, actualEmptyPageDataResult.getTotalElements());
    assertFalse(actualEmptyPageDataResult.hasNext());
    assertTrue(actualEmptyPageDataResult.getData().isEmpty());
  }

  /**
   * Test {@link PageData#equals(Object)}, and {@link PageData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageData#equals(Object)}
   *   <li>{@link PageData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageData.equals(Object)", "int PageData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    PageData<Object> emptyPageDataResult2 = PageData.emptyPageData();

    // Act and Assert
    assertEquals(emptyPageDataResult, emptyPageDataResult2);
    int expectedHashCodeResult = emptyPageDataResult.hashCode();
    assertEquals(expectedHashCodeResult, emptyPageDataResult2.hashCode());
  }

  /**
   * Test {@link PageData#equals(Object)}, and {@link PageData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageData#equals(Object)}
   *   <li>{@link PageData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageData.equals(Object)", "int PageData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PageData<Object> pageData = new PageData<>();
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();

    // Act and Assert
    assertEquals(pageData, emptyPageDataResult);
    int expectedHashCodeResult = pageData.hashCode();
    assertEquals(expectedHashCodeResult, emptyPageDataResult.hashCode());
  }

  /**
   * Test {@link PageData#equals(Object)}, and {@link PageData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageData#equals(Object)}
   *   <li>{@link PageData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageData.equals(Object)", "int PageData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();

    // Act and Assert
    assertEquals(emptyPageDataResult, emptyPageDataResult);
    int expectedHashCodeResult = emptyPageDataResult.hashCode();
    assertEquals(expectedHashCodeResult, emptyPageDataResult.hashCode());
  }

  /**
   * Test {@link PageData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageData.equals(Object)", "int PageData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PageData<Object> pageData = new PageData<>(new ArrayList<>(), 1, 1L, true);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();

    // Act and Assert
    assertNotEquals(pageData, emptyPageDataResult);
  }

  /**
   * Test {@link PageData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageData.equals(Object)", "int PageData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PageData<Object> pageData = new PageData<>(new ArrayList<>(), 0, 1L, true);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();

    // Act and Assert
    assertNotEquals(pageData, emptyPageDataResult);
  }

  /**
   * Test {@link PageData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageData.equals(Object)", "int PageData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PageData<Object> pageData = new PageData<>(new ArrayList<>(), 0, 0L, true);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();

    // Act and Assert
    assertNotEquals(pageData, emptyPageDataResult);
  }

  /**
   * Test {@link PageData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageData.equals(Object)", "int PageData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();

    // Act and Assert
    assertNotEquals(emptyPageDataResult, null);
  }

  /**
   * Test {@link PageData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PageData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PageData.equals(Object)", "int PageData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();

    // Act and Assert
    assertNotEquals(emptyPageDataResult, "Different type to PageData");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PageData#toString()}
   *   <li>{@link PageData#getData()}
   *   <li>{@link PageData#getTotalElements()}
   *   <li>{@link PageData#getTotalPages()}
   *   <li>{@link PageData#hasNext()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "List PageData.getData()",
    "long PageData.getTotalElements()",
    "int PageData.getTotalPages()",
    "boolean PageData.hasNext()",
    "String PageData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();

    // Act
    String actualToStringResult = emptyPageDataResult.toString();
    List<Object> actualData = emptyPageDataResult.getData();
    long actualTotalElements = emptyPageDataResult.getTotalElements();
    int actualTotalPages = emptyPageDataResult.getTotalPages();

    // Assert
    assertEquals(
        "PageData(data=[], totalPages=0, totalElements=0, hasNext=false)", actualToStringResult);
    assertEquals(0, actualTotalPages);
    assertEquals(0L, actualTotalElements);
    assertFalse(emptyPageDataResult.hasNext());
    assertTrue(actualData.isEmpty());
  }

  /**
   * Test {@link PageData#mapData(Function)}.
   *
   * <p>Method under test: {@link PageData#mapData(Function)}
   */
  @Test
  @DisplayName("Test mapData(Function)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData PageData.mapData(Function)"})
  void testMapData() {
    // Arrange
    PageData<Object> pageData = new PageData<>(new ArrayList<>(), 3, 3L, true);

    // Act and Assert
    assertEquals(pageData, pageData.<Object>mapData(mock(Function.class)));
  }

  /**
   * Test {@link PageData#mapData(Function)}.
   *
   * <ul>
   *   <li>Given emptyPageData.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link PageData#mapData(Function)}
   */
  @Test
  @DisplayName("Test mapData(Function); given emptyPageData; then return EMPTY_PAGE_DATA")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData PageData.mapData(Function)"})
  void testMapData_givenEmptyPageData_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();

    // Act
    PageData<Object> actualMapDataResult =
        emptyPageDataResult.<Object>mapData(mock(Function.class));

    // Assert
    assertEquals(actualMapDataResult.EMPTY_PAGE_DATA, actualMapDataResult);
  }
}
