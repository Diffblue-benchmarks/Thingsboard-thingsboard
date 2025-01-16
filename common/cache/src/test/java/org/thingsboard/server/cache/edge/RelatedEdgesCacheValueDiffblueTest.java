package org.thingsboard.server.cache.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.page.PageData;

class RelatedEdgesCacheValueDiffblueTest {
  /**
   * Test {@link RelatedEdgesCacheValue#equals(Object)}, and
   * {@link RelatedEdgesCacheValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelatedEdgesCacheValue#equals(Object)}
   *   <li>{@link RelatedEdgesCacheValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link RelatedEdgesCacheValue#equals(Object)}, and
   * {@link RelatedEdgesCacheValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelatedEdgesCacheValue#equals(Object)}
   *   <li>{@link RelatedEdgesCacheValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link RelatedEdgesCacheValue#equals(Object)}, and
   * {@link RelatedEdgesCacheValue#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelatedEdgesCacheValue#equals(Object)}
   *   <li>{@link RelatedEdgesCacheValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelatedEdgesCacheValue relatedEdgesCacheValue = new RelatedEdgesCacheValue();

    // Act and Assert
    assertEquals(relatedEdgesCacheValue, relatedEdgesCacheValue);
    int expectedHashCodeResult = relatedEdgesCacheValue.hashCode();
    assertEquals(expectedHashCodeResult, relatedEdgesCacheValue.hashCode());
  }

  /**
   * Test {@link RelatedEdgesCacheValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedEdgesCacheValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PageData<EdgeId> pageData = PageData.emptyPageData();
    RelatedEdgesCacheValue relatedEdgesCacheValue = new RelatedEdgesCacheValue(pageData);

    // Act and Assert
    assertNotEquals(relatedEdgesCacheValue, new RelatedEdgesCacheValue());
  }

  /**
   * Test {@link RelatedEdgesCacheValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedEdgesCacheValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelatedEdgesCacheValue relatedEdgesCacheValue = new RelatedEdgesCacheValue();
    PageData<EdgeId> pageData = PageData.emptyPageData();

    // Act and Assert
    assertNotEquals(relatedEdgesCacheValue, new RelatedEdgesCacheValue(pageData));
  }

  /**
   * Test {@link RelatedEdgesCacheValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedEdgesCacheValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelatedEdgesCacheValue relatedEdgesCacheValue = new RelatedEdgesCacheValue(mock(PageData.class));

    // Act and Assert
    assertNotEquals(relatedEdgesCacheValue, new RelatedEdgesCacheValue());
  }

  /**
   * Test {@link RelatedEdgesCacheValue#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedEdgesCacheValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RelatedEdgesCacheValue(), null);
  }

  /**
   * Test {@link RelatedEdgesCacheValue#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelatedEdgesCacheValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RelatedEdgesCacheValue(), "Different type to RelatedEdgesCacheValue");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelatedEdgesCacheValue#RelatedEdgesCacheValue()}
   *   <li>{@link RelatedEdgesCacheValue#setPageData(PageData)}
   *   <li>{@link RelatedEdgesCacheValue#toString()}
   *   <li>{@link RelatedEdgesCacheValue#getPageData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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
   * Test getters and setters.
   * <ul>
   *   <li>When emptyPageData.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelatedEdgesCacheValue#RelatedEdgesCacheValue(PageData)}
   *   <li>{@link RelatedEdgesCacheValue#setPageData(PageData)}
   *   <li>{@link RelatedEdgesCacheValue#toString()}
   *   <li>{@link RelatedEdgesCacheValue#getPageData()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when emptyPageData")
  void testGettersAndSetters_whenEmptyPageData() {
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
