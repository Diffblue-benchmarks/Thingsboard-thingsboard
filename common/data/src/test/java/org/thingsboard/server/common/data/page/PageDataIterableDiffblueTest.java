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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PageDataIterableDiffblueTest {
  /**
   * Method under test: {@link PageDataIterable#fetchPageData(PageLink)}
   */
  @Test
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

  /**
   * Method under test:
   * {@link PageDataIterable#PageDataIterable(PageDataIterable.FetchFunction, int)}
   */
  @Test
  void testNewPageDataIterable() {
    // Arrange and Act
    PageDataIterable<Object> actualPageDataIterable = new PageDataIterable<>(mock(PageDataIterable.FetchFunction.class),
        3);

    // Assert
    assertFalse(actualPageDataIterable.hasNext());
  }
}
