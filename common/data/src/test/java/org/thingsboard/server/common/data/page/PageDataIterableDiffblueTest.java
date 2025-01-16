package org.thingsboard.server.common.data.page;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PageDataIterableDiffblueTest {
  /**
   * Test {@link PageDataIterable#PageDataIterable(FetchFunction, int)}.
   * <p>
   * Method under test:
   * {@link PageDataIterable#PageDataIterable(PageDataIterable.FetchFunction, int)}
   */
  @Test
  @DisplayName("Test new PageDataIterable(FetchFunction, int)")
  void testNewPageDataIterable() {
    // Arrange and Act
    PageDataIterable<Object> actualPageDataIterable = new PageDataIterable<>(mock(PageDataIterable.FetchFunction.class),
        3);

    // Assert
    assertFalse(actualPageDataIterable.hasNext());
  }

  /**
   * Test {@link PageDataIterable#fetchPageData(PageLink)}.
   * <p>
   * Method under test: {@link PageDataIterable#fetchPageData(PageLink)}
   */
  @Test
  @DisplayName("Test fetchPageData(PageLink)")
  void testFetchPageData() {
    // Arrange
    PageDataIterable.FetchFunction<Object> function = mock(PageDataIterable.FetchFunction.class);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();
    when(function.fetch(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageDataIterable<Object> pageDataIterable = new PageDataIterable<>(function, 3);

    // Act
    PageData<Object> actualFetchPageDataResult = pageDataIterable.fetchPageData(new PageLink(3));

    // Assert
    verify(function).fetch(isA(PageLink.class));
    assertSame(actualFetchPageDataResult.EMPTY_PAGE_DATA, actualFetchPageDataResult);
  }
}
