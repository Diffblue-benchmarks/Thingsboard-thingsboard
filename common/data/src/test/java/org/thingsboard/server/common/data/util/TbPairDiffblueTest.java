package org.thingsboard.server.common.data.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbPairDiffblueTest {
  /**
   * Test {@link TbPair#of(Object, Object)}.
   *
   * <p>Method under test: {@link TbPair#of(Object, Object)}
   */
  @Test
  @DisplayName("Test of(Object, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbPair TbPair.of(Object, Object)"})
  void testOf() {
    // Arrange and Act
    TbPair<Object, Object> actualOfResult = TbPair.of("First", "Second");

    // Assert
    assertEquals("First", actualOfResult.getFirst());
    assertEquals("Second", actualOfResult.getSecond());
  }

  /**
   * Test {@link TbPair#equals(Object)}, and {@link TbPair#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbPair#equals(Object)}
   *   <li>{@link TbPair#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbPair.equals(Object)", "int TbPair.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of("First", "Second");
    TbPair<Object, Object> ofResult2 = TbPair.of("First", "Second");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Test {@link TbPair#equals(Object)}, and {@link TbPair#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbPair#equals(Object)}
   *   <li>{@link TbPair#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbPair.equals(Object)", "int TbPair.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of(null, "Second");
    TbPair<Object, Object> ofResult2 = TbPair.of(null, "Second");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Test {@link TbPair#equals(Object)}, and {@link TbPair#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbPair#equals(Object)}
   *   <li>{@link TbPair#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbPair.equals(Object)", "int TbPair.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of("First", null);
    TbPair<Object, Object> ofResult2 = TbPair.of("First", null);

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Test {@link TbPair#equals(Object)}, and {@link TbPair#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbPair#equals(Object)}
   *   <li>{@link TbPair#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbPair.equals(Object)", "int TbPair.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of("First", "Second");

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Test {@link TbPair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbPair.equals(Object)", "int TbPair.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.<Object, Object>of(1, "Second");
    TbPair<Object, Object> ofResult2 = TbPair.of("First", "Second");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Test {@link TbPair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbPair.equals(Object)", "int TbPair.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of("First", "Second");
    TbPair<Object, Object> ofResult2 = TbPair.of(ofResult, "Second");
    TbPair<Object, Object> ofResult3 = TbPair.of("First", "Second");

    // Act and Assert
    assertNotEquals(ofResult2, ofResult3);
  }

  /**
   * Test {@link TbPair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbPair.equals(Object)", "int TbPair.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of(null, "Second");
    TbPair<Object, Object> ofResult2 = TbPair.of("First", "Second");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Test {@link TbPair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbPair.equals(Object)", "int TbPair.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.<Object, Object>of("First", 1);
    TbPair<Object, Object> ofResult2 = TbPair.of("First", "Second");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Test {@link TbPair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbPair.equals(Object)", "int TbPair.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of("First", "Second");
    TbPair<Object, Object> ofResult2 = TbPair.of("First", ofResult);
    TbPair<Object, Object> ofResult3 = TbPair.of("First", "Second");

    // Act and Assert
    assertNotEquals(ofResult2, ofResult3);
  }

  /**
   * Test {@link TbPair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbPair.equals(Object)", "int TbPair.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of("First", null);
    TbPair<Object, Object> ofResult2 = TbPair.of("First", "Second");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Test {@link TbPair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbPair.equals(Object)", "int TbPair.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of("First", "Second");

    // Act and Assert
    assertNotEquals(ofResult, null);
  }

  /**
   * Test {@link TbPair#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbPair#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbPair.equals(Object)", "int TbPair.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of("First", "Second");

    // Act and Assert
    assertNotEquals(ofResult, "Different type to TbPair");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbPair#TbPair(Object, Object)}
   *   <li>{@link TbPair#setFirst(Object)}
   *   <li>{@link TbPair#setSecond(Object)}
   *   <li>{@link TbPair#toString()}
   *   <li>{@link TbPair#getFirst()}
   *   <li>{@link TbPair#getSecond()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbPair.<init>(Object, Object)",
    "Object TbPair.getFirst()",
    "Object TbPair.getSecond()",
    "void TbPair.setFirst(Object)",
    "void TbPair.setSecond(Object)",
    "String TbPair.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbPair<Object, Object> actualTbPair = new TbPair<>("First", "Second");
    actualTbPair.setFirst("First");
    actualTbPair.setSecond("Second");
    String actualToStringResult = actualTbPair.toString();
    Object actualFirst = actualTbPair.getFirst();

    // Assert
    assertEquals("First", actualFirst);
    assertEquals("Second", actualTbPair.getSecond());
    assertEquals("TbPair(first=First, second=Second)", actualToStringResult);
  }
}
