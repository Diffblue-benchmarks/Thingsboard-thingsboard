package org.thingsboard.rule.engine.deduplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DeduplicationDataDiffblueTest {
  /**
   * Test {@link DeduplicationData#size()}.
   *
   * <p>Method under test: {@link DeduplicationData#size()}
   */
  @Test
  @DisplayName("Test size()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int DeduplicationData.size()"})
  void testSize() {
    // Arrange, Act and Assert
    assertEquals(0, new DeduplicationData().size());
  }

  /**
   * Test {@link DeduplicationData#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link DeduplicationData} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given DeduplicationData (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeduplicationData.isEmpty()"})
  void testIsEmpty_givenDeduplicationData_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new DeduplicationData().isEmpty());
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}, and {@link DeduplicationData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeduplicationData#equals(Object)}
   *   <li>{@link DeduplicationData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeduplicationData deduplicationData = new DeduplicationData();
    DeduplicationData deduplicationData2 = new DeduplicationData();

    // Act and Assert
    assertEquals(deduplicationData, deduplicationData2);
    int expectedHashCodeResult = deduplicationData.hashCode();
    assertEquals(expectedHashCodeResult, deduplicationData2.hashCode());
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}, and {@link DeduplicationData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeduplicationData#equals(Object)}
   *   <li>{@link DeduplicationData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeduplicationData deduplicationData = new DeduplicationData();

    // Act and Assert
    assertEquals(deduplicationData, deduplicationData);
    int expectedHashCodeResult = deduplicationData.hashCode();
    assertEquals(expectedHashCodeResult, deduplicationData.hashCode());
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeduplicationData(), 1);
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeduplicationData deduplicationData = new DeduplicationData();
    deduplicationData.setTickScheduled(true);

    // Act and Assert
    assertNotEquals(deduplicationData, new DeduplicationData());
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeduplicationData(), null);
  }

  /**
   * Test {@link DeduplicationData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeduplicationData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeduplicationData.equals(Object)",
    "int DeduplicationData.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeduplicationData(), "Different type to DeduplicationData");
  }
}
