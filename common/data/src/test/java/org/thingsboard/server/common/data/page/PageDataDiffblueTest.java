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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;

class PageDataDiffblueTest {
  /**
   * Method under test: {@link PageData#emptyPageData()}
   */
  @Test
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
   * Method under test: {@link PageData#mapData(Function)}
   */
  @Test
  void testMapData() {
    // Arrange
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();

    // Act
    PageData<Object> actualMapDataResult = emptyPageDataResult.<Object>mapData(mock(Function.class));

    // Assert
    assertEquals(actualMapDataResult.EMPTY_PAGE_DATA, actualMapDataResult);
  }

  /**
   * Method under test: {@link PageData#mapData(Function)}
   */
  @Test
  void testMapData2() {
    // Arrange
    PageData<Object> pageData = new PageData<>(new ArrayList<>(), 3, 3L, true);

    // Act and Assert
    assertEquals(pageData, pageData.<Object>mapData(mock(Function.class)));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PageData#equals(Object)}
   *   <li>{@link PageData#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link PageData#equals(Object)}
   *   <li>{@link PageData#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link PageData#equals(Object)}
   *   <li>{@link PageData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();

    // Act and Assert
    assertEquals(emptyPageDataResult, emptyPageDataResult);
    int expectedHashCodeResult = emptyPageDataResult.hashCode();
    assertEquals(expectedHashCodeResult, emptyPageDataResult.hashCode());
  }

  /**
   * Method under test: {@link PageData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PageData<Object> pageData = new PageData<>(new ArrayList<>(), 1, 1L, true);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();

    // Act and Assert
    assertNotEquals(pageData, emptyPageDataResult);
  }

  /**
   * Method under test: {@link PageData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PageData<Object> pageData = new PageData<>(new ArrayList<>(), 0, 1L, true);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();

    // Act and Assert
    assertNotEquals(pageData, emptyPageDataResult);
  }

  /**
   * Method under test: {@link PageData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PageData<Object> pageData = new PageData<>(new ArrayList<>(), 0, 0L, true);
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();

    // Act and Assert
    assertNotEquals(pageData, emptyPageDataResult);
  }

  /**
   * Method under test: {@link PageData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();

    // Act and Assert
    assertNotEquals(emptyPageDataResult, null);
  }

  /**
   * Method under test: {@link PageData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();

    // Act and Assert
    assertNotEquals(emptyPageDataResult, "Different type to PageData");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PageData#toString()}
   *   <li>{@link PageData#getData()}
   *   <li>{@link PageData#getTotalElements()}
   *   <li>{@link PageData#getTotalPages()}
   *   <li>{@link PageData#hasNext()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PageData<Object> emptyPageDataResult = PageData.emptyPageData();

    // Act
    String actualToStringResult = emptyPageDataResult.toString();
    List<Object> actualData = emptyPageDataResult.getData();
    long actualTotalElements = emptyPageDataResult.getTotalElements();
    int actualTotalPages = emptyPageDataResult.getTotalPages();

    // Assert
    assertEquals("PageData(data=[], totalPages=0, totalElements=0, hasNext=false)", actualToStringResult);
    assertEquals(0, actualTotalPages);
    assertEquals(0L, actualTotalElements);
    assertFalse(emptyPageDataResult.hasNext());
    assertTrue(actualData.isEmpty());
  }

  /**
   * Method under test: {@link PageData#PageData()}
   */
  @Test
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
   * Method under test: {@link PageData#PageData(List, int, long, boolean)}
   */
  @Test
  void testNewPageData2() {
    // Arrange
    ArrayList<Object> data = new ArrayList<>();

    // Act
    PageData<Object> actualPageData = new PageData<>(data, 1, 1L, true);

    // Assert
    assertEquals(1, actualPageData.getTotalPages());
    assertEquals(1L, actualPageData.getTotalElements());
    List<Object> data2 = actualPageData.getData();
    assertTrue(data2.isEmpty());
    assertTrue(actualPageData.hasNext());
    assertSame(data, data2);
  }

  /**
   * Method under test: {@link PageData#PageData(List, int, long, boolean)}
   */
  @Test
  void testNewPageData3() {
    // Arrange
    ArrayList<Object> data = new ArrayList<>();
    data.add("42");

    // Act
    PageData<Object> actualPageData = new PageData<>(data, 1, 1L, true);

    // Assert
    List<Object> data2 = actualPageData.getData();
    assertEquals(1, data2.size());
    assertEquals("42", data2.get(0));
    assertEquals(1, actualPageData.getTotalPages());
    assertEquals(1L, actualPageData.getTotalElements());
    assertTrue(actualPageData.hasNext());
    assertSame(data, data2);
  }

  /**
   * Method under test: {@link PageData#PageData(List, int, long, boolean)}
   */
  @Test
  void testNewPageData4() {
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
}
