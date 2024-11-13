package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TsValueDiffblueTest {
  /**
   * Test {@link TsValue#TsValue(long, String)}.
   * <p>
   * Method under test: {@link TsValue#TsValue(long, String)}
   */
  @Test
  @DisplayName("Test new TsValue(long, String)")
  void testNewTsValue() {
    // Arrange and Act
    TsValue actualTsValue = new TsValue(1L, "42");

    // Assert
    assertEquals("42", actualTsValue.getValue());
    assertNull(actualTsValue.getCount());
    assertEquals(1L, actualTsValue.getTs());
  }

  /**
   * Test {@link TsValue#TsValue(long, String, Long)}.
   * <p>
   * Method under test: {@link TsValue#TsValue(long, String, Long)}
   */
  @Test
  @DisplayName("Test new TsValue(long, String, Long)")
  void testNewTsValue2() {
    // Arrange and Act
    TsValue actualTsValue = new TsValue(1L, "42", 3L);

    // Assert
    assertEquals("42", actualTsValue.getValue());
    assertEquals(1L, actualTsValue.getTs());
    assertEquals(3L, actualTsValue.getCount().longValue());
  }

  /**
   * Test {@link TsValue#equals(Object)}, and {@link TsValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsValue#equals(Object)}
   *   <li>{@link TsValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsValue tsValue = TsValue.EMPTY;
    TsValue tsValue2 = TsValue.EMPTY;

    // Act and Assert
    assertEquals(tsValue, tsValue2);
    int expectedHashCodeResult = tsValue.hashCode();
    assertEquals(expectedHashCodeResult, tsValue2.hashCode());
  }

  /**
   * Test {@link TsValue#equals(Object)}, and {@link TsValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsValue#equals(Object)}
   *   <li>{@link TsValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TsValue tsValue = new TsValue(1L, "42");
    TsValue tsValue2 = new TsValue(1L, "42");

    // Act and Assert
    assertEquals(tsValue, tsValue2);
    int expectedHashCodeResult = tsValue.hashCode();
    assertEquals(expectedHashCodeResult, tsValue2.hashCode());
  }

  /**
   * Test {@link TsValue#equals(Object)}, and {@link TsValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsValue#equals(Object)}
   *   <li>{@link TsValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TsValue tsValue = new TsValue(1L, "42", 3L);
    TsValue tsValue2 = new TsValue(1L, "42", 3L);

    // Act and Assert
    assertEquals(tsValue, tsValue2);
    int expectedHashCodeResult = tsValue.hashCode();
    assertEquals(expectedHashCodeResult, tsValue2.hashCode());
  }

  /**
   * Test {@link TsValue#equals(Object)}, and {@link TsValue#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsValue#equals(Object)}
   *   <li>{@link TsValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsValue tsValue = TsValue.EMPTY;

    // Act and Assert
    assertEquals(tsValue, tsValue);
    int expectedHashCodeResult = tsValue.hashCode();
    assertEquals(expectedHashCodeResult, tsValue.hashCode());
  }

  /**
   * Test {@link TsValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsValue(1L, "42"), TsValue.EMPTY);
    assertNotEquals(new TsValue(0L, "42"), TsValue.EMPTY);
    assertNotEquals(new TsValue(0L, null), TsValue.EMPTY);
  }

  /**
   * Test {@link TsValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TsValue tsValue = new TsValue(1L, "42");

    // Act and Assert
    assertNotEquals(tsValue, new TsValue(1L, "42", 3L));
  }

  /**
   * Test {@link TsValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TsValue tsValue = new TsValue(1L, "42", 3L);

    // Act and Assert
    assertNotEquals(tsValue, new TsValue(1L, "42"));
  }

  /**
   * Test {@link TsValue#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TsValue.EMPTY, null);
  }

  /**
   * Test {@link TsValue#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TsValue.EMPTY, "Different type to TsValue");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsValue#toString()}
   *   <li>{@link TsValue#getCount()}
   *   <li>{@link TsValue#getTs()}
   *   <li>{@link TsValue#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TsValue tsValue = new TsValue(1L, "42");

    // Act
    String actualToStringResult = tsValue.toString();
    Long actualCount = tsValue.getCount();
    long actualTs = tsValue.getTs();

    // Assert
    assertEquals("42", tsValue.getValue());
    assertEquals("TsValue(ts=1, value=42, count=null)", actualToStringResult);
    assertNull(actualCount);
    assertEquals(1L, actualTs);
  }
}
