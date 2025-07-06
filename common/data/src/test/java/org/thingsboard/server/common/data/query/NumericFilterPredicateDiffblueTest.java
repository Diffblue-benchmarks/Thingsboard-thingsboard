package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.NumericFilterPredicate.NumericOperation;

class NumericFilterPredicateDiffblueTest {
  /**
   * Test {@link NumericFilterPredicate#equals(Object)}, and {@link
   * NumericFilterPredicate#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NumericFilterPredicate#equals(Object)}
   *   <li>{@link NumericFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NumericFilterPredicate.equals(Object)",
    "int NumericFilterPredicate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(NumericOperation.EQUAL);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate.setValue(value);

    NumericFilterPredicate numericFilterPredicate2 = new NumericFilterPredicate();
    numericFilterPredicate2.setOperation(NumericOperation.EQUAL);
    FilterPredicateValue<Double> value2 = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate2.setValue(value2);

    // Act and Assert
    assertEquals(numericFilterPredicate, numericFilterPredicate2);
    int expectedHashCodeResult = numericFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, numericFilterPredicate2.hashCode());
  }

  /**
   * Test {@link NumericFilterPredicate#equals(Object)}, and {@link
   * NumericFilterPredicate#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NumericFilterPredicate#equals(Object)}
   *   <li>{@link NumericFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NumericFilterPredicate.equals(Object)",
    "int NumericFilterPredicate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(null);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate.setValue(value);

    NumericFilterPredicate numericFilterPredicate2 = new NumericFilterPredicate();
    numericFilterPredicate2.setOperation(null);
    FilterPredicateValue<Double> value2 = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate2.setValue(value2);

    // Act and Assert
    assertEquals(numericFilterPredicate, numericFilterPredicate2);
    int expectedHashCodeResult = numericFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, numericFilterPredicate2.hashCode());
  }

  /**
   * Test {@link NumericFilterPredicate#equals(Object)}, and {@link
   * NumericFilterPredicate#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NumericFilterPredicate#equals(Object)}
   *   <li>{@link NumericFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NumericFilterPredicate.equals(Object)",
    "int NumericFilterPredicate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(NumericOperation.EQUAL);
    numericFilterPredicate.setValue(null);

    NumericFilterPredicate numericFilterPredicate2 = new NumericFilterPredicate();
    numericFilterPredicate2.setOperation(NumericOperation.EQUAL);
    numericFilterPredicate2.setValue(null);

    // Act and Assert
    assertEquals(numericFilterPredicate, numericFilterPredicate2);
    int expectedHashCodeResult = numericFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, numericFilterPredicate2.hashCode());
  }

  /**
   * Test {@link NumericFilterPredicate#equals(Object)}, and {@link
   * NumericFilterPredicate#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NumericFilterPredicate#equals(Object)}
   *   <li>{@link NumericFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NumericFilterPredicate.equals(Object)",
    "int NumericFilterPredicate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(NumericOperation.EQUAL);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate.setValue(value);

    // Act and Assert
    assertEquals(numericFilterPredicate, numericFilterPredicate);
    int expectedHashCodeResult = numericFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, numericFilterPredicate.hashCode());
  }

  /**
   * Test {@link NumericFilterPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NumericFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NumericFilterPredicate.equals(Object)",
    "int NumericFilterPredicate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(null);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate.setValue(value);

    NumericFilterPredicate numericFilterPredicate2 = new NumericFilterPredicate();
    numericFilterPredicate2.setOperation(NumericOperation.EQUAL);
    FilterPredicateValue<Double> value2 = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(numericFilterPredicate, numericFilterPredicate2);
  }

  /**
   * Test {@link NumericFilterPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NumericFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NumericFilterPredicate.equals(Object)",
    "int NumericFilterPredicate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(NumericOperation.NOT_EQUAL);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate.setValue(value);

    NumericFilterPredicate numericFilterPredicate2 = new NumericFilterPredicate();
    numericFilterPredicate2.setOperation(NumericOperation.EQUAL);
    FilterPredicateValue<Double> value2 = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(numericFilterPredicate, numericFilterPredicate2);
  }

  /**
   * Test {@link NumericFilterPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NumericFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NumericFilterPredicate.equals(Object)",
    "int NumericFilterPredicate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(NumericOperation.EQUAL);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(0.5d);
    numericFilterPredicate.setValue(value);

    NumericFilterPredicate numericFilterPredicate2 = new NumericFilterPredicate();
    numericFilterPredicate2.setOperation(NumericOperation.EQUAL);
    FilterPredicateValue<Double> value2 = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(numericFilterPredicate, numericFilterPredicate2);
  }

  /**
   * Test {@link NumericFilterPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NumericFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NumericFilterPredicate.equals(Object)",
    "int NumericFilterPredicate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(NumericOperation.EQUAL);
    numericFilterPredicate.setValue(null);

    NumericFilterPredicate numericFilterPredicate2 = new NumericFilterPredicate();
    numericFilterPredicate2.setOperation(NumericOperation.EQUAL);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate2.setValue(value);

    // Act and Assert
    assertNotEquals(numericFilterPredicate, numericFilterPredicate2);
  }

  /**
   * Test {@link NumericFilterPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NumericFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NumericFilterPredicate.equals(Object)",
    "int NumericFilterPredicate.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(NumericOperation.EQUAL);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate.setValue(value);

    // Act and Assert
    assertNotEquals(numericFilterPredicate, null);
  }

  /**
   * Test {@link NumericFilterPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NumericFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean NumericFilterPredicate.equals(Object)",
    "int NumericFilterPredicate.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NumericFilterPredicate numericFilterPredicate = new NumericFilterPredicate();
    numericFilterPredicate.setOperation(NumericOperation.EQUAL);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    numericFilterPredicate.setValue(value);

    // Act and Assert
    assertNotEquals(numericFilterPredicate, "Different type to NumericFilterPredicate");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link NumericFilterPredicate}
   *   <li>{@link NumericFilterPredicate#setOperation(NumericOperation)}
   *   <li>{@link NumericFilterPredicate#setValue(FilterPredicateValue)}
   *   <li>{@link NumericFilterPredicate#toString()}
   *   <li>{@link NumericFilterPredicate#getOperation()}
   *   <li>{@link NumericFilterPredicate#getType()}
   *   <li>{@link NumericFilterPredicate#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void NumericFilterPredicate.<init>()",
    "NumericOperation NumericFilterPredicate.getOperation()",
    "FilterPredicateType NumericFilterPredicate.getType()",
    "FilterPredicateValue NumericFilterPredicate.getValue()",
    "void NumericFilterPredicate.setOperation(NumericOperation)",
    "void NumericFilterPredicate.setValue(FilterPredicateValue)",
    "String NumericFilterPredicate.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    NumericFilterPredicate actualNumericFilterPredicate = new NumericFilterPredicate();
    actualNumericFilterPredicate.setOperation(NumericOperation.EQUAL);
    FilterPredicateValue<Double> value = FilterPredicateValue.fromDouble(10.0d);
    actualNumericFilterPredicate.setValue(value);
    String actualToStringResult = actualNumericFilterPredicate.toString();
    NumericOperation actualOperation = actualNumericFilterPredicate.getOperation();
    FilterPredicateType actualType = actualNumericFilterPredicate.getType();

    // Assert
    assertEquals(
        "NumericFilterPredicate(operation=EQUAL, value=FilterPredicateValue(defaultValue=10.0, userValue=null,"
            + " dynamicValue=null))",
        actualToStringResult);
    assertEquals(FilterPredicateType.NUMERIC, actualType);
    assertEquals(NumericOperation.EQUAL, actualOperation);
    assertSame(value, actualNumericFilterPredicate.getValue());
  }
}
