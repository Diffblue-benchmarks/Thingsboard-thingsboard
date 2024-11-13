package org.thingsboard.rule.engine.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbMathResultDiffblueTest {
  /**
   * Test {@link TbMathResult#equals(Object)}, and
   * {@link TbMathResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMathResult#equals(Object)}
   *   <li>{@link TbMathResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMathResult tbMathResult = new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true,
        "Attribute Scope");
    TbMathResult tbMathResult2 = new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true,
        "Attribute Scope");

    // Act and Assert
    assertEquals(tbMathResult, tbMathResult2);
    int expectedHashCodeResult = tbMathResult.hashCode();
    assertEquals(expectedHashCodeResult, tbMathResult2.hashCode());
  }

  /**
   * Test {@link TbMathResult#equals(Object)}, and
   * {@link TbMathResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMathResult#equals(Object)}
   *   <li>{@link TbMathResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbMathResult tbMathResult = new TbMathResult(null, "Key", 42, true, true, "Attribute Scope");
    TbMathResult tbMathResult2 = new TbMathResult(null, "Key", 42, true, true, "Attribute Scope");

    // Act and Assert
    assertEquals(tbMathResult, tbMathResult2);
    int expectedHashCodeResult = tbMathResult.hashCode();
    assertEquals(expectedHashCodeResult, tbMathResult2.hashCode());
  }

  /**
   * Test {@link TbMathResult#equals(Object)}, and
   * {@link TbMathResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMathResult#equals(Object)}
   *   <li>{@link TbMathResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbMathResult tbMathResult = new TbMathResult(TbMathArgumentType.ATTRIBUTE, null, 42, true, true, "Attribute Scope");
    TbMathResult tbMathResult2 = new TbMathResult(TbMathArgumentType.ATTRIBUTE, null, 42, true, true,
        "Attribute Scope");

    // Act and Assert
    assertEquals(tbMathResult, tbMathResult2);
    int expectedHashCodeResult = tbMathResult.hashCode();
    assertEquals(expectedHashCodeResult, tbMathResult2.hashCode());
  }

  /**
   * Test {@link TbMathResult#equals(Object)}, and
   * {@link TbMathResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMathResult#equals(Object)}
   *   <li>{@link TbMathResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbMathResult tbMathResult = new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, null);
    TbMathResult tbMathResult2 = new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, null);

    // Act and Assert
    assertEquals(tbMathResult, tbMathResult2);
    int expectedHashCodeResult = tbMathResult.hashCode();
    assertEquals(expectedHashCodeResult, tbMathResult2.hashCode());
  }

  /**
   * Test {@link TbMathResult#equals(Object)}, and
   * {@link TbMathResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMathResult#equals(Object)}
   *   <li>{@link TbMathResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMathResult tbMathResult = new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true,
        "Attribute Scope");

    // Act and Assert
    assertEquals(tbMathResult, tbMathResult);
    int expectedHashCodeResult = tbMathResult.hashCode();
    assertEquals(expectedHashCodeResult, tbMathResult.hashCode());
  }

  /**
   * Test {@link TbMathResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMathResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbMathResult tbMathResult = new TbMathResult(null, "Key", 42, true, true, "Attribute Scope");

    // Act and Assert
    assertNotEquals(tbMathResult,
        new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, "Attribute Scope"));
  }

  /**
   * Test {@link TbMathResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMathResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMathResult tbMathResult = new TbMathResult(TbMathArgumentType.TIME_SERIES, "Key", 42, true, true,
        "Attribute Scope");

    // Act and Assert
    assertNotEquals(tbMathResult,
        new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, "Attribute Scope"));
  }

  /**
   * Test {@link TbMathResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMathResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbMathResult tbMathResult = new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Attribute Scope", 42, true, true,
        "Attribute Scope");

    // Act and Assert
    assertNotEquals(tbMathResult,
        new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, "Attribute Scope"));
  }

  /**
   * Test {@link TbMathResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMathResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbMathResult tbMathResult = new TbMathResult(TbMathArgumentType.ATTRIBUTE, null, 42, true, true, "Attribute Scope");

    // Act and Assert
    assertNotEquals(tbMathResult,
        new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, "Attribute Scope"));
  }

  /**
   * Test {@link TbMathResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMathResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbMathResult tbMathResult = new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 1, true, true, "Attribute Scope");

    // Act and Assert
    assertNotEquals(tbMathResult,
        new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, "Attribute Scope"));
  }

  /**
   * Test {@link TbMathResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMathResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbMathResult tbMathResult = new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, false, true,
        "Attribute Scope");

    // Act and Assert
    assertNotEquals(tbMathResult,
        new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, "Attribute Scope"));
  }

  /**
   * Test {@link TbMathResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMathResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbMathResult tbMathResult = new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, false,
        "Attribute Scope");

    // Act and Assert
    assertNotEquals(tbMathResult,
        new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, "Attribute Scope"));
  }

  /**
   * Test {@link TbMathResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMathResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbMathResult tbMathResult = new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, "Key");

    // Act and Assert
    assertNotEquals(tbMathResult,
        new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, "Attribute Scope"));
  }

  /**
   * Test {@link TbMathResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMathResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbMathResult tbMathResult = new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, null);

    // Act and Assert
    assertNotEquals(tbMathResult,
        new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, "Attribute Scope"));
  }

  /**
   * Test {@link TbMathResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMathResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, "Attribute Scope"), null);
  }

  /**
   * Test {@link TbMathResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMathResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true, "Attribute Scope"),
        "Different type to TbMathResult");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbMathResult#TbMathResult()}
   *   <li>{@link TbMathResult#setAddToBody(boolean)}
   *   <li>{@link TbMathResult#setAddToMetadata(boolean)}
   *   <li>{@link TbMathResult#setAttributeScope(String)}
   *   <li>{@link TbMathResult#setKey(String)}
   *   <li>{@link TbMathResult#setResultValuePrecision(int)}
   *   <li>{@link TbMathResult#setType(TbMathArgumentType)}
   *   <li>{@link TbMathResult#toString()}
   *   <li>{@link TbMathResult#getAttributeScope()}
   *   <li>{@link TbMathResult#getKey()}
   *   <li>{@link TbMathResult#getResultValuePrecision()}
   *   <li>{@link TbMathResult#getType()}
   *   <li>{@link TbMathResult#isAddToBody()}
   *   <li>{@link TbMathResult#isAddToMetadata()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbMathResult actualTbMathResult = new TbMathResult();
    actualTbMathResult.setAddToBody(true);
    actualTbMathResult.setAddToMetadata(true);
    actualTbMathResult.setAttributeScope("Attribute Scope");
    actualTbMathResult.setKey("Key");
    actualTbMathResult.setResultValuePrecision(42);
    actualTbMathResult.setType(TbMathArgumentType.ATTRIBUTE);
    String actualToStringResult = actualTbMathResult.toString();
    String actualAttributeScope = actualTbMathResult.getAttributeScope();
    String actualKey = actualTbMathResult.getKey();
    int actualResultValuePrecision = actualTbMathResult.getResultValuePrecision();
    TbMathArgumentType actualType = actualTbMathResult.getType();
    boolean actualIsAddToBodyResult = actualTbMathResult.isAddToBody();

    // Assert that nothing has changed
    assertEquals("Attribute Scope", actualAttributeScope);
    assertEquals("Key", actualKey);
    assertEquals("TbMathResult(type=ATTRIBUTE, key=Key, resultValuePrecision=42, addToBody=true, addToMetadata=true,"
        + " attributeScope=Attribute Scope)", actualToStringResult);
    assertEquals(42, actualResultValuePrecision);
    assertEquals(TbMathArgumentType.ATTRIBUTE, actualType);
    assertTrue(actualIsAddToBodyResult);
    assertTrue(actualTbMathResult.isAddToMetadata());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code ATTRIBUTE}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbMathResult#TbMathResult(TbMathArgumentType, String, int, boolean, boolean, String)}
   *   <li>{@link TbMathResult#setAddToBody(boolean)}
   *   <li>{@link TbMathResult#setAddToMetadata(boolean)}
   *   <li>{@link TbMathResult#setAttributeScope(String)}
   *   <li>{@link TbMathResult#setKey(String)}
   *   <li>{@link TbMathResult#setResultValuePrecision(int)}
   *   <li>{@link TbMathResult#setType(TbMathArgumentType)}
   *   <li>{@link TbMathResult#toString()}
   *   <li>{@link TbMathResult#getAttributeScope()}
   *   <li>{@link TbMathResult#getKey()}
   *   <li>{@link TbMathResult#getResultValuePrecision()}
   *   <li>{@link TbMathResult#getType()}
   *   <li>{@link TbMathResult#isAddToBody()}
   *   <li>{@link TbMathResult#isAddToMetadata()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'ATTRIBUTE'")
  void testGettersAndSetters_whenAttribute() {
    // Arrange and Act
    TbMathResult actualTbMathResult = new TbMathResult(TbMathArgumentType.ATTRIBUTE, "Key", 42, true, true,
        "Attribute Scope");
    actualTbMathResult.setAddToBody(true);
    actualTbMathResult.setAddToMetadata(true);
    actualTbMathResult.setAttributeScope("Attribute Scope");
    actualTbMathResult.setKey("Key");
    actualTbMathResult.setResultValuePrecision(42);
    actualTbMathResult.setType(TbMathArgumentType.ATTRIBUTE);
    String actualToStringResult = actualTbMathResult.toString();
    String actualAttributeScope = actualTbMathResult.getAttributeScope();
    String actualKey = actualTbMathResult.getKey();
    int actualResultValuePrecision = actualTbMathResult.getResultValuePrecision();
    TbMathArgumentType actualType = actualTbMathResult.getType();
    boolean actualIsAddToBodyResult = actualTbMathResult.isAddToBody();

    // Assert that nothing has changed
    assertEquals("Attribute Scope", actualAttributeScope);
    assertEquals("Key", actualKey);
    assertEquals("TbMathResult(type=ATTRIBUTE, key=Key, resultValuePrecision=42, addToBody=true, addToMetadata=true,"
        + " attributeScope=Attribute Scope)", actualToStringResult);
    assertEquals(42, actualResultValuePrecision);
    assertEquals(TbMathArgumentType.ATTRIBUTE, actualType);
    assertTrue(actualIsAddToBodyResult);
    assertTrue(actualTbMathResult.isAddToMetadata());
  }
}
