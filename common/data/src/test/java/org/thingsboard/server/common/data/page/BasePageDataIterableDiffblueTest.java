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
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BasePageDataIterableDiffblueTest {
  /**
   * Method under test: {@link BasePageDataIterable#iterator()}
   */
  @Test
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
   * Method under test: {@link BasePageDataIterable#hasNext()}
   */
  @Test
  void testHasNext() {
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
   * Method under test: {@link BasePageDataIterable#hasNext()}
   */
  @Test
  void testHasNext2() {
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
   * Method under test: {@link BasePageDataIterable#hasNext()}
   */
  @Test
  void testHasNext3() {
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
   * Method under test: {@link BasePageDataIterable#hasNext()}
   */
  @Test
  void testHasNext4() {
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
   * Method under test: {@link BasePageDataIterable#next()}
   */
  @Test
  void testNext() {
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
   * Method under test: {@link BasePageDataIterable#next()}
   */
  @Test
  void testNext2() {
    // Arrange
    PageDataIterable.FetchFunction<Object> function = mock(PageDataIterable.FetchFunction.class);
    when(function.fetch(Mockito.<PageLink>any())).thenReturn(null);
    PageDataIterable<Object> pageDataIterable = new PageDataIterable<>(function, 3);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> pageDataIterable.next());
    verify(function).fetch(isA(PageLink.class));
  }

  /**
   * Method under test: {@link BasePageDataIterable#next()}
   */
  @Test
  void testNext3() {
    // Arrange
    PageDataIterable.FetchFunction<Object> function = mock(PageDataIterable.FetchFunction.class);
    when(function.fetch(Mockito.<PageLink>any())).thenReturn(new PageData<>(new ArrayList<>(), 1, 1L, true));
    PageDataIterable<Object> pageDataIterable = new PageDataIterable<>(function, 3);

    // Act and Assert
    assertThrows(NoSuchElementException.class, () -> pageDataIterable.next());
    verify(function, atLeast(1)).fetch(Mockito.<PageLink>any());
  }

  /**
   * Method under test: {@link BasePageDataIterable#next()}
   */
  @Test
  void testNext4() {
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
}
