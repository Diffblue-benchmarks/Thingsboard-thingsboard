package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.StringFilterPredicate.StringOperation;

class StringFilterPredicateDiffblueTest {
  /**
   * Test {@link StringFilterPredicate#equals(Object)}, and {@link StringFilterPredicate#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StringFilterPredicate#equals(Object)}
   *   <li>{@link StringFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringFilterPredicate.equals(Object)", "int StringFilterPredicate.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(StringOperation.EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate.setValue(value);

    StringFilterPredicate stringFilterPredicate2 = new StringFilterPredicate();
    stringFilterPredicate2.setIgnoreCase(true);
    stringFilterPredicate2.setOperation(StringOperation.EQUAL);
    FilterPredicateValue<String> value2 = FilterPredicateValue.fromString("42");
    stringFilterPredicate2.setValue(value2);

    // Act and Assert
    assertEquals(stringFilterPredicate, stringFilterPredicate2);
    int expectedHashCodeResult = stringFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, stringFilterPredicate2.hashCode());
  }

  /**
   * Test {@link StringFilterPredicate#equals(Object)}, and {@link StringFilterPredicate#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StringFilterPredicate#equals(Object)}
   *   <li>{@link StringFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringFilterPredicate.equals(Object)", "int StringFilterPredicate.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(null);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate.setValue(value);

    StringFilterPredicate stringFilterPredicate2 = new StringFilterPredicate();
    stringFilterPredicate2.setIgnoreCase(true);
    stringFilterPredicate2.setOperation(null);
    FilterPredicateValue<String> value2 = FilterPredicateValue.fromString("42");
    stringFilterPredicate2.setValue(value2);

    // Act and Assert
    assertEquals(stringFilterPredicate, stringFilterPredicate2);
    int expectedHashCodeResult = stringFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, stringFilterPredicate2.hashCode());
  }

  /**
   * Test {@link StringFilterPredicate#equals(Object)}, and {@link StringFilterPredicate#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StringFilterPredicate#equals(Object)}
   *   <li>{@link StringFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringFilterPredicate.equals(Object)", "int StringFilterPredicate.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(StringOperation.EQUAL);
    stringFilterPredicate.setValue(null);

    StringFilterPredicate stringFilterPredicate2 = new StringFilterPredicate();
    stringFilterPredicate2.setIgnoreCase(true);
    stringFilterPredicate2.setOperation(StringOperation.EQUAL);
    stringFilterPredicate2.setValue(null);

    // Act and Assert
    assertEquals(stringFilterPredicate, stringFilterPredicate2);
    int expectedHashCodeResult = stringFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, stringFilterPredicate2.hashCode());
  }

  /**
   * Test {@link StringFilterPredicate#equals(Object)}, and {@link StringFilterPredicate#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link StringFilterPredicate#equals(Object)}
   *   <li>{@link StringFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringFilterPredicate.equals(Object)", "int StringFilterPredicate.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(StringOperation.EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate.setValue(value);

    // Act and Assert
    assertEquals(stringFilterPredicate, stringFilterPredicate);
    int expectedHashCodeResult = stringFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, stringFilterPredicate.hashCode());
  }

  /**
   * Test {@link StringFilterPredicate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringFilterPredicate.equals(Object)", "int StringFilterPredicate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(false);
    stringFilterPredicate.setOperation(StringOperation.EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate.setValue(value);

    StringFilterPredicate stringFilterPredicate2 = new StringFilterPredicate();
    stringFilterPredicate2.setIgnoreCase(true);
    stringFilterPredicate2.setOperation(StringOperation.EQUAL);
    FilterPredicateValue<String> value2 = FilterPredicateValue.fromString("42");
    stringFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(stringFilterPredicate, stringFilterPredicate2);
  }

  /**
   * Test {@link StringFilterPredicate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringFilterPredicate.equals(Object)", "int StringFilterPredicate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(null);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate.setValue(value);

    StringFilterPredicate stringFilterPredicate2 = new StringFilterPredicate();
    stringFilterPredicate2.setIgnoreCase(true);
    stringFilterPredicate2.setOperation(StringOperation.EQUAL);
    FilterPredicateValue<String> value2 = FilterPredicateValue.fromString("42");
    stringFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(stringFilterPredicate, stringFilterPredicate2);
  }

  /**
   * Test {@link StringFilterPredicate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringFilterPredicate.equals(Object)", "int StringFilterPredicate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(StringOperation.NOT_EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate.setValue(value);

    StringFilterPredicate stringFilterPredicate2 = new StringFilterPredicate();
    stringFilterPredicate2.setIgnoreCase(true);
    stringFilterPredicate2.setOperation(StringOperation.EQUAL);
    FilterPredicateValue<String> value2 = FilterPredicateValue.fromString("42");
    stringFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(stringFilterPredicate, stringFilterPredicate2);
  }

  /**
   * Test {@link StringFilterPredicate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringFilterPredicate.equals(Object)", "int StringFilterPredicate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(StringOperation.EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("Value");
    stringFilterPredicate.setValue(value);

    StringFilterPredicate stringFilterPredicate2 = new StringFilterPredicate();
    stringFilterPredicate2.setIgnoreCase(true);
    stringFilterPredicate2.setOperation(StringOperation.EQUAL);
    FilterPredicateValue<String> value2 = FilterPredicateValue.fromString("42");
    stringFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(stringFilterPredicate, stringFilterPredicate2);
  }

  /**
   * Test {@link StringFilterPredicate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringFilterPredicate.equals(Object)", "int StringFilterPredicate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(StringOperation.EQUAL);
    stringFilterPredicate.setValue(null);

    StringFilterPredicate stringFilterPredicate2 = new StringFilterPredicate();
    stringFilterPredicate2.setIgnoreCase(true);
    stringFilterPredicate2.setOperation(StringOperation.EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate2.setValue(value);

    // Act and Assert
    assertNotEquals(stringFilterPredicate, stringFilterPredicate2);
  }

  /**
   * Test {@link StringFilterPredicate#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringFilterPredicate.equals(Object)", "int StringFilterPredicate.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(StringOperation.EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate.setValue(value);

    // Act and Assert
    assertNotEquals(stringFilterPredicate, null);
  }

  /**
   * Test {@link StringFilterPredicate#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringFilterPredicate.equals(Object)", "int StringFilterPredicate.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StringFilterPredicate stringFilterPredicate = new StringFilterPredicate();
    stringFilterPredicate.setIgnoreCase(true);
    stringFilterPredicate.setOperation(StringOperation.EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    stringFilterPredicate.setValue(value);

    // Act and Assert
    assertNotEquals(stringFilterPredicate, "Different type to StringFilterPredicate");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StringFilterPredicate}
   *   <li>{@link StringFilterPredicate#setIgnoreCase(boolean)}
   *   <li>{@link StringFilterPredicate#setOperation(StringOperation)}
   *   <li>{@link StringFilterPredicate#setValue(FilterPredicateValue)}
   *   <li>{@link StringFilterPredicate#toString()}
   *   <li>{@link StringFilterPredicate#getOperation()}
   *   <li>{@link StringFilterPredicate#getType()}
   *   <li>{@link StringFilterPredicate#getValue()}
   *   <li>{@link StringFilterPredicate#isIgnoreCase()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StringFilterPredicate.<init>()", "StringOperation StringFilterPredicate.getOperation()",
      "FilterPredicateType StringFilterPredicate.getType()", "FilterPredicateValue StringFilterPredicate.getValue()",
      "boolean StringFilterPredicate.isIgnoreCase()", "void StringFilterPredicate.setIgnoreCase(boolean)",
      "void StringFilterPredicate.setOperation(StringOperation)",
      "void StringFilterPredicate.setValue(FilterPredicateValue)", "String StringFilterPredicate.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    StringFilterPredicate actualStringFilterPredicate = new StringFilterPredicate();
    actualStringFilterPredicate.setIgnoreCase(true);
    actualStringFilterPredicate.setOperation(StringOperation.EQUAL);
    FilterPredicateValue<String> value = FilterPredicateValue.fromString("42");
    actualStringFilterPredicate.setValue(value);
    String actualToStringResult = actualStringFilterPredicate.toString();
    StringOperation actualOperation = actualStringFilterPredicate.getOperation();
    FilterPredicateType actualType = actualStringFilterPredicate.getType();
    FilterPredicateValue<String> actualValue = actualStringFilterPredicate.getValue();

    // Assert
    assertEquals("StringFilterPredicate(operation=EQUAL, value=FilterPredicateValue(defaultValue=42, userValue=null,"
        + " dynamicValue=null), ignoreCase=true)", actualToStringResult);
    assertEquals(FilterPredicateType.STRING, actualType);
    assertEquals(StringOperation.EQUAL, actualOperation);
    assertTrue(actualStringFilterPredicate.isIgnoreCase());
    assertSame(value, actualValue);
  }
}
