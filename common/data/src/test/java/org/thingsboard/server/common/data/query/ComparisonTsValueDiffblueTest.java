package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComparisonTsValueDiffblueTest {
  /**
   * Test {@link ComparisonTsValue#equals(Object)}, and
   * {@link ComparisonTsValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ComparisonTsValue#equals(Object)}
   *   <li>{@link ComparisonTsValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ComparisonTsValue comparisonTsValue = new ComparisonTsValue();
    ComparisonTsValue comparisonTsValue2 = new ComparisonTsValue();

    // Act and Assert
    assertEquals(comparisonTsValue, comparisonTsValue2);
    int expectedHashCodeResult = comparisonTsValue.hashCode();
    assertEquals(expectedHashCodeResult, comparisonTsValue2.hashCode());
  }

  /**
   * Test {@link ComparisonTsValue#equals(Object)}, and
   * {@link ComparisonTsValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ComparisonTsValue#equals(Object)}
   *   <li>{@link ComparisonTsValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ComparisonTsValue comparisonTsValue = new ComparisonTsValue(TsValue.EMPTY, TsValue.EMPTY);
    ComparisonTsValue comparisonTsValue2 = new ComparisonTsValue(TsValue.EMPTY, TsValue.EMPTY);

    // Act and Assert
    assertEquals(comparisonTsValue, comparisonTsValue2);
    int expectedHashCodeResult = comparisonTsValue.hashCode();
    assertEquals(expectedHashCodeResult, comparisonTsValue2.hashCode());
  }

  /**
   * Test {@link ComparisonTsValue#equals(Object)}, and
   * {@link ComparisonTsValue#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ComparisonTsValue#equals(Object)}
   *   <li>{@link ComparisonTsValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ComparisonTsValue comparisonTsValue = new ComparisonTsValue();

    // Act and Assert
    assertEquals(comparisonTsValue, comparisonTsValue);
    int expectedHashCodeResult = comparisonTsValue.hashCode();
    assertEquals(expectedHashCodeResult, comparisonTsValue.hashCode());
  }

  /**
   * Test {@link ComparisonTsValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComparisonTsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ComparisonTsValue comparisonTsValue = new ComparisonTsValue(TsValue.EMPTY, TsValue.EMPTY);

    // Act and Assert
    assertNotEquals(comparisonTsValue, new ComparisonTsValue());
  }

  /**
   * Test {@link ComparisonTsValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComparisonTsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ComparisonTsValue comparisonTsValue = new ComparisonTsValue();

    // Act and Assert
    assertNotEquals(comparisonTsValue, new ComparisonTsValue(TsValue.EMPTY, TsValue.EMPTY));
  }

  /**
   * Test {@link ComparisonTsValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComparisonTsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ComparisonTsValue comparisonTsValue = new ComparisonTsValue();
    comparisonTsValue.setPrevious(TsValue.EMPTY);

    // Act and Assert
    assertNotEquals(comparisonTsValue, new ComparisonTsValue());
  }

  /**
   * Test {@link ComparisonTsValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComparisonTsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ComparisonTsValue comparisonTsValue = new ComparisonTsValue(mock(TsValue.class), TsValue.EMPTY);

    // Act and Assert
    assertNotEquals(comparisonTsValue, new ComparisonTsValue());
  }

  /**
   * Test {@link ComparisonTsValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComparisonTsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ComparisonTsValue comparisonTsValue = new ComparisonTsValue();

    ComparisonTsValue comparisonTsValue2 = new ComparisonTsValue();
    comparisonTsValue2.setPrevious(TsValue.EMPTY);

    // Act and Assert
    assertNotEquals(comparisonTsValue, comparisonTsValue2);
  }

  /**
   * Test {@link ComparisonTsValue#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComparisonTsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ComparisonTsValue(), null);
  }

  /**
   * Test {@link ComparisonTsValue#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComparisonTsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ComparisonTsValue(), "Different type to ComparisonTsValue");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ComparisonTsValue#ComparisonTsValue()}
   *   <li>{@link ComparisonTsValue#setCurrent(TsValue)}
   *   <li>{@link ComparisonTsValue#setPrevious(TsValue)}
   *   <li>{@link ComparisonTsValue#toString()}
   *   <li>{@link ComparisonTsValue#getCurrent()}
   *   <li>{@link ComparisonTsValue#getPrevious()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    ComparisonTsValue actualComparisonTsValue = new ComparisonTsValue();
    actualComparisonTsValue.setCurrent(TsValue.EMPTY);
    actualComparisonTsValue.setPrevious(TsValue.EMPTY);
    String actualToStringResult = actualComparisonTsValue.toString();
    TsValue actualCurrent = actualComparisonTsValue.getCurrent();
    TsValue actualPrevious = actualComparisonTsValue.getPrevious();

    // Assert that nothing has changed
    assertEquals(
        "ComparisonTsValue(current=TsValue(ts=0, value=, count=null), previous=TsValue(ts=0, value=," + " count=null))",
        actualToStringResult);
    TsValue tsValue = actualPrevious.EMPTY;
    assertSame(tsValue, actualCurrent);
    assertSame(tsValue, actualPrevious);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link TsValue#EMPTY}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ComparisonTsValue#ComparisonTsValue(TsValue, TsValue)}
   *   <li>{@link ComparisonTsValue#setCurrent(TsValue)}
   *   <li>{@link ComparisonTsValue#setPrevious(TsValue)}
   *   <li>{@link ComparisonTsValue#toString()}
   *   <li>{@link ComparisonTsValue#getCurrent()}
   *   <li>{@link ComparisonTsValue#getPrevious()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when EMPTY")
  void testGettersAndSetters_whenEmpty() {
    // Arrange and Act
    ComparisonTsValue actualComparisonTsValue = new ComparisonTsValue(TsValue.EMPTY, TsValue.EMPTY);
    actualComparisonTsValue.setCurrent(TsValue.EMPTY);
    actualComparisonTsValue.setPrevious(TsValue.EMPTY);
    String actualToStringResult = actualComparisonTsValue.toString();
    TsValue actualCurrent = actualComparisonTsValue.getCurrent();
    TsValue actualPrevious = actualComparisonTsValue.getPrevious();

    // Assert that nothing has changed
    assertEquals(
        "ComparisonTsValue(current=TsValue(ts=0, value=, count=null), previous=TsValue(ts=0, value=," + " count=null))",
        actualToStringResult);
    TsValue tsValue = actualPrevious.EMPTY;
    assertSame(tsValue, actualCurrent);
    assertSame(tsValue, actualPrevious);
  }
}
