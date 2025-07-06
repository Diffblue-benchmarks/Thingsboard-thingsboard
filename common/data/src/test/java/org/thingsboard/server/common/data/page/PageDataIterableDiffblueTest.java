package org.thingsboard.server.common.data.page;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.page.PageDataIterable.FetchFunction;

class PageDataIterableDiffblueTest {
  /**
   * Test {@link PageDataIterable#PageDataIterable(FetchFunction, int)}.
   *
   * <p>Method under test: {@link PageDataIterable#PageDataIterable(FetchFunction, int)}
   */
  @Test
  @DisplayName("Test new PageDataIterable(FetchFunction, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageDataIterable.<init>(FetchFunction, int)"})
  void testNewPageDataIterable() {
    // Arrange and Act
    PageDataIterable<Object> actualPageDataIterable =
        new PageDataIterable<>(mock(FetchFunction.class), 3);

    // Assert
    assertFalse(actualPageDataIterable.hasNext());
  }

  /**
   * Test {@link PageDataIterable#fetchPageData(PageLink)}.
   *
   * <p>Method under test: {@link PageDataIterable#fetchPageData(PageLink)}
   */
  @Test
  @DisplayName("Test fetchPageData(PageLink)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData PageDataIterable.fetchPageData(PageLink)"})
  void testFetchPageData() {
    // Arrange
    FetchFunction<Object> function = mock(FetchFunction.class);
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
