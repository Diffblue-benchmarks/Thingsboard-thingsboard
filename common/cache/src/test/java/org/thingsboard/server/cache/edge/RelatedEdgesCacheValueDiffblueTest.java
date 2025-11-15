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
package org.thingsboard.server.cache.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.page.PageData;

class RelatedEdgesCacheValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RelatedEdgesCacheValue#equals(Object)}
   *   <li>{@link RelatedEdgesCacheValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelatedEdgesCacheValue relatedEdgesCacheValue = new RelatedEdgesCacheValue();
    RelatedEdgesCacheValue relatedEdgesCacheValue2 = new RelatedEdgesCacheValue();

    // Act and Assert
    assertEquals(relatedEdgesCacheValue, relatedEdgesCacheValue2);
    int expectedHashCodeResult = relatedEdgesCacheValue.hashCode();
    assertEquals(expectedHashCodeResult, relatedEdgesCacheValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RelatedEdgesCacheValue#equals(Object)}
   *   <li>{@link RelatedEdgesCacheValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PageData<EdgeId> pageData = PageData.emptyPageData();
    RelatedEdgesCacheValue relatedEdgesCacheValue = new RelatedEdgesCacheValue(pageData);
    PageData<EdgeId> pageData2 = PageData.emptyPageData();
    RelatedEdgesCacheValue relatedEdgesCacheValue2 = new RelatedEdgesCacheValue(pageData2);

    // Act and Assert
    assertEquals(relatedEdgesCacheValue, relatedEdgesCacheValue2);
    int expectedHashCodeResult = relatedEdgesCacheValue.hashCode();
    assertEquals(expectedHashCodeResult, relatedEdgesCacheValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RelatedEdgesCacheValue#equals(Object)}
   *   <li>{@link RelatedEdgesCacheValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelatedEdgesCacheValue relatedEdgesCacheValue = new RelatedEdgesCacheValue();

    // Act and Assert
    assertEquals(relatedEdgesCacheValue, relatedEdgesCacheValue);
    int expectedHashCodeResult = relatedEdgesCacheValue.hashCode();
    assertEquals(expectedHashCodeResult, relatedEdgesCacheValue.hashCode());
  }

  /**
   * Method under test: {@link RelatedEdgesCacheValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PageData<EdgeId> pageData = PageData.emptyPageData();
    RelatedEdgesCacheValue relatedEdgesCacheValue = new RelatedEdgesCacheValue(pageData);

    // Act and Assert
    assertNotEquals(relatedEdgesCacheValue, new RelatedEdgesCacheValue());
  }

  /**
   * Method under test: {@link RelatedEdgesCacheValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelatedEdgesCacheValue relatedEdgesCacheValue = new RelatedEdgesCacheValue();
    PageData<EdgeId> pageData = PageData.emptyPageData();

    // Act and Assert
    assertNotEquals(relatedEdgesCacheValue, new RelatedEdgesCacheValue(pageData));
  }

  /**
   * Method under test: {@link RelatedEdgesCacheValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelatedEdgesCacheValue relatedEdgesCacheValue = new RelatedEdgesCacheValue(mock(PageData.class));

    // Act and Assert
    assertNotEquals(relatedEdgesCacheValue, new RelatedEdgesCacheValue());
  }

  /**
   * Method under test: {@link RelatedEdgesCacheValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RelatedEdgesCacheValue(), null);
  }

  /**
   * Method under test: {@link RelatedEdgesCacheValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RelatedEdgesCacheValue(), "Different type to RelatedEdgesCacheValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RelatedEdgesCacheValue#RelatedEdgesCacheValue()}
   *   <li>{@link RelatedEdgesCacheValue#setPageData(PageData)}
   *   <li>{@link RelatedEdgesCacheValue#toString()}
   *   <li>{@link RelatedEdgesCacheValue#getPageData()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RelatedEdgesCacheValue actualRelatedEdgesCacheValue = new RelatedEdgesCacheValue();
    PageData<EdgeId> pageData = PageData.emptyPageData();
    actualRelatedEdgesCacheValue.setPageData(pageData);
    String actualToStringResult = actualRelatedEdgesCacheValue.toString();
    PageData<EdgeId> actualPageData = actualRelatedEdgesCacheValue.getPageData();

    // Assert that nothing has changed
    assertEquals("RelatedEdgesCacheValue(pageData=PageData(data=[], totalPages=0, totalElements=0, hasNext=false))",
        actualToStringResult);
    assertSame(actualPageData.EMPTY_PAGE_DATA, actualPageData);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RelatedEdgesCacheValue#RelatedEdgesCacheValue(PageData)}
   *   <li>{@link RelatedEdgesCacheValue#setPageData(PageData)}
   *   <li>{@link RelatedEdgesCacheValue#toString()}
   *   <li>{@link RelatedEdgesCacheValue#getPageData()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    PageData<EdgeId> pageData = PageData.emptyPageData();

    // Act
    RelatedEdgesCacheValue actualRelatedEdgesCacheValue = new RelatedEdgesCacheValue(pageData);
    PageData<EdgeId> pageData2 = PageData.emptyPageData();
    actualRelatedEdgesCacheValue.setPageData(pageData2);
    String actualToStringResult = actualRelatedEdgesCacheValue.toString();
    PageData<EdgeId> actualPageData = actualRelatedEdgesCacheValue.getPageData();

    // Assert that nothing has changed
    assertEquals("RelatedEdgesCacheValue(pageData=PageData(data=[], totalPages=0, totalElements=0, hasNext=false))",
        actualToStringResult);
    assertSame(actualPageData.EMPTY_PAGE_DATA, actualPageData);
  }
}
