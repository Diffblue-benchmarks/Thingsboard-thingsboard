package org.thingsboard.server.common.data.page;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.page.PageDataIterable.FetchFunction;

class BasePageDataIterableDiffblueTest {
  /**
   * Test {@link BasePageDataIterable#iterator()}.
   * <p>
   * Method under test: {@link BasePageDataIterable#iterator()}
   */
  @Test
  @DisplayName("Test iterator()")
  void testIterator() {
    // Arrange
    PageDataIterable<Object> pageDataIterable = new PageDataIterable<>(mock(PageDataIterable.FetchFunction.class), 3);

    // Act
    Iterator<Object> actualIteratorResult = pageDataIterable.iterator();

    // Assert
    assertTrue(actualIteratorResult instanceof PageDataIterable);
    assertFalse(actualIteratorResult.hasNext());
    assertSame(pageDataIterable, actualIteratorResult);
  }

  /**
   * Test {@link BasePageDataIterable#hasNext()}.
   * <p>
   * Method under test: {@link BasePageDataIterable#hasNext()}
   */
  @Test
  @DisplayName("Test hasNext()")
  void testHasNext() {
    // Arrange
    PageDataIterable.FetchFunction<Object> function = mock(PageDataIterable.FetchFunction.class);
    when(function.fetch(Mockito.<PageLink>any())).thenReturn(new PageData<>(new ArrayList<>(), 1, 1L, true));
    PageDataIterable<Object> pageDataIterable = new PageDataIterable<>(function, 3);

    // Act
    boolean actualHasNextResult = pageDataIterable.hasNext();

    // Assert
    verify(function, atLeast(1)).fetch(Mockito.<PageLink>any());
    assertFalse(actualHasNextResult);
  }

  /**
   * Test {@link BasePageDataIterable#hasNext()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasePageDataIterable#hasNext()}
   */
  @Test
  @DisplayName("Test hasNext(); given ArrayList() add '42'; then return 'true'")
  void testHasNext_givenArrayListAdd42_thenReturnTrue() {
    // Arrange
    ArrayList<Object> data = new ArrayList<>();
    data.add("42");
    PageDataIterable.FetchFunction<Object> function = mock(PageDataIterable.FetchFunction.class);
    when(function.fetch(Mockito.<PageLink>any())).thenReturn(new PageData<>(data, 1, 1L, true));
    PageDataIterable<Object> pageDataIterable = new PageDataIterable<>(function, 3);

    // Act
    boolean actualHasNextResult = pageDataIterable.hasNext();

    // Assert
    verify(function).fetch(isA(PageLink.class));
    assertTrue(actualHasNextResult);
  }

  /**
   * Test {@link BasePageDataIterable#hasNext()}.
   * <ul>
   *   <li>Given {@link FetchFunction} {@link FetchFunction#fetch(PageLink)} return
   * emptyPageData.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasePageDataIterable#hasNext()}
   */
  @Test
  @DisplayName("Test hasNext(); given FetchFunction fetch(PageLink) return emptyPageData; then return 'false'")
  void testHasNext_givenFetchFunctionFetchReturnEmptyPageData_thenReturnFalse() {
    // Arrange
    PageDataIterable.FetchFunction<Object> function = mock(PageDataIterable.FetchFunction.class);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(function.fetch(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageDataIterable<Object> pageDataIterable = new PageDataIterable<>(function, 3);

    // Act
    boolean actualHasNextResult = pageDataIterable.hasNext();

    // Assert
    verify(function).fetch(isA(PageLink.class));
    assertFalse(actualHasNextResult);
  }

  /**
   * Test {@link BasePageDataIterable#hasNext()}.
   * <ul>
   *   <li>Given {@link FetchFunction} {@link FetchFunction#fetch(PageLink)} return
   * {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasePageDataIterable#hasNext()}
   */
  @Test
  @DisplayName("Test hasNext(); given FetchFunction fetch(PageLink) return 'null'; then return 'false'")
  void testHasNext_givenFetchFunctionFetchReturnNull_thenReturnFalse() {
    // Arrange
    PageDataIterable.FetchFunction<Object> function = mock(PageDataIterable.FetchFunction.class);
    when(function.fetch(Mockito.<PageLink>any())).thenReturn(null);
    PageDataIterable<Object> pageDataIterable = new PageDataIterable<>(function, 3);

    // Act
    boolean actualHasNextResult = pageDataIterable.hasNext();

    // Assert
    verify(function).fetch(isA(PageLink.class));
    assertFalse(actualHasNextResult);
  }

  /**
   * Test {@link BasePageDataIterable#next()}.
   * <p>
   * Method under test: {@link BasePageDataIterable#next()}
   */
  @Test
  @DisplayName("Test next()")
  void testNext() {
    // Arrange
    PageDataIterable.FetchFunction<Object> function = mock(PageDataIterable.FetchFunction.class);
    when(function.fetch(Mockito.<PageLink>any())).thenReturn(new PageData<>(new ArrayList<>(), 1, 1L, true));
    PageDataIterable<Object> pageDataIterable = new PageDataIterable<>(function, 3);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> pageDataIterable.next());
    verify(function, atLeast(1)).fetch(Mockito.<PageLink>any());
  }

  /**
   * Test {@link BasePageDataIterable#next()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasePageDataIterable#next()}
   */
  @Test
  @DisplayName("Test next(); given ArrayList() add '42'; then return '42'")
  void testNext_givenArrayListAdd42_thenReturn42() {
    // Arrange
    ArrayList<Object> data = new ArrayList<>();
    data.add("42");
    PageDataIterable.FetchFunction<Object> function = mock(PageDataIterable.FetchFunction.class);
    when(function.fetch(Mockito.<PageLink>any())).thenReturn(new PageData<>(data, 1, 1L, true));
    PageDataIterable<Object> pageDataIterable = new PageDataIterable<>(function, 3);

    // Act
    Object actualNextResult = pageDataIterable.next();

    // Assert
    verify(function).fetch(isA(PageLink.class));
    assertEquals("42", actualNextResult);
  }

  /**
   * Test {@link BasePageDataIterable#next()}.
   * <ul>
   *   <li>Given {@link FetchFunction} {@link FetchFunction#fetch(PageLink)} return
   * emptyPageData.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasePageDataIterable#next()}
   */
  @Test
  @DisplayName("Test next(); given FetchFunction fetch(PageLink) return emptyPageData")
  void testNext_givenFetchFunctionFetchReturnEmptyPageData() {
    // Arrange
    PageDataIterable.FetchFunction<Object> function = mock(PageDataIterable.FetchFunction.class);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(function.fetch(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageDataIterable<Object> pageDataIterable = new PageDataIterable<>(function, 3);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> pageDataIterable.next());
    verify(function).fetch(isA(PageLink.class));
  }

  /**
   * Test {@link BasePageDataIterable#next()}.
   * <ul>
   *   <li>Given {@link FetchFunction} {@link FetchFunction#fetch(PageLink)} return
   * {@code null}.</li>
   *   <li>Then throw {@link NoSuchElementException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BasePageDataIterable#next()}
   */
  @Test
  @DisplayName("Test next(); given FetchFunction fetch(PageLink) return 'null'; then throw NoSuchElementException")
  void testNext_givenFetchFunctionFetchReturnNull_thenThrowNoSuchElementException() {
    // Arrange
    PageDataIterable.FetchFunction<Object> function = mock(PageDataIterable.FetchFunction.class);
    when(function.fetch(Mockito.<PageLink>any())).thenReturn(null);
    PageDataIterable<Object> pageDataIterable = new PageDataIterable<>(function, 3);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> pageDataIterable.next());
    verify(function).fetch(isA(PageLink.class));
  }
}
