package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.BooleanFilterPredicate.BooleanOperation;

class BooleanFilterPredicateDiffblueTest {
  /**
   * Test {@link BooleanFilterPredicate#equals(Object)}, and {@link
   * BooleanFilterPredicate#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BooleanFilterPredicate#equals(Object)}
   *   <li>{@link BooleanFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BooleanFilterPredicate.equals(Object)",
    "int BooleanFilterPredicate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate.setValue(value);

    BooleanFilterPredicate booleanFilterPredicate2 = new BooleanFilterPredicate();
    booleanFilterPredicate2.setOperation(BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value2 = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate2.setValue(value2);

    // Act and Assert
    assertEquals(booleanFilterPredicate, booleanFilterPredicate2);
    assertEquals(booleanFilterPredicate.hashCode(), booleanFilterPredicate2.hashCode());
  }

  /**
   * Test {@link BooleanFilterPredicate#equals(Object)}, and {@link
   * BooleanFilterPredicate#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BooleanFilterPredicate#equals(Object)}
   *   <li>{@link BooleanFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BooleanFilterPredicate.equals(Object)",
    "int BooleanFilterPredicate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(null);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate.setValue(value);

    BooleanFilterPredicate booleanFilterPredicate2 = new BooleanFilterPredicate();
    booleanFilterPredicate2.setOperation(null);
    FilterPredicateValue<Boolean> value2 = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate2.setValue(value2);

    // Act and Assert
    assertEquals(booleanFilterPredicate, booleanFilterPredicate2);
    assertEquals(booleanFilterPredicate.hashCode(), booleanFilterPredicate2.hashCode());
  }

  /**
   * Test {@link BooleanFilterPredicate#equals(Object)}, and {@link
   * BooleanFilterPredicate#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BooleanFilterPredicate#equals(Object)}
   *   <li>{@link BooleanFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BooleanFilterPredicate.equals(Object)",
    "int BooleanFilterPredicate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(BooleanOperation.EQUAL);
    booleanFilterPredicate.setValue(null);

    BooleanFilterPredicate booleanFilterPredicate2 = new BooleanFilterPredicate();
    booleanFilterPredicate2.setOperation(BooleanOperation.EQUAL);
    booleanFilterPredicate2.setValue(null);

    // Act and Assert
    assertEquals(booleanFilterPredicate, booleanFilterPredicate2);
    assertEquals(booleanFilterPredicate.hashCode(), booleanFilterPredicate2.hashCode());
  }

  /**
   * Test {@link BooleanFilterPredicate#equals(Object)}, and {@link
   * BooleanFilterPredicate#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BooleanFilterPredicate#equals(Object)}
   *   <li>{@link BooleanFilterPredicate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BooleanFilterPredicate.equals(Object)",
    "int BooleanFilterPredicate.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate.setValue(value);

    // Act and Assert
    assertEquals(booleanFilterPredicate, booleanFilterPredicate);
    int expectedHashCodeResult = booleanFilterPredicate.hashCode();
    assertEquals(expectedHashCodeResult, booleanFilterPredicate.hashCode());
  }

  /**
   * Test {@link BooleanFilterPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BooleanFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BooleanFilterPredicate.equals(Object)",
    "int BooleanFilterPredicate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(null);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate.setValue(value);

    BooleanFilterPredicate booleanFilterPredicate2 = new BooleanFilterPredicate();
    booleanFilterPredicate2.setOperation(BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value2 = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(booleanFilterPredicate, booleanFilterPredicate2);
  }

  /**
   * Test {@link BooleanFilterPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BooleanFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BooleanFilterPredicate.equals(Object)",
    "int BooleanFilterPredicate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(BooleanOperation.NOT_EQUAL);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate.setValue(value);

    BooleanFilterPredicate booleanFilterPredicate2 = new BooleanFilterPredicate();
    booleanFilterPredicate2.setOperation(BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value2 = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate2.setValue(value2);

    // Act and Assert
    assertNotEquals(booleanFilterPredicate, booleanFilterPredicate2);
  }

  /**
   * Test {@link BooleanFilterPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BooleanFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BooleanFilterPredicate.equals(Object)",
    "int BooleanFilterPredicate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(BooleanOperation.EQUAL);
    booleanFilterPredicate.setValue(null);

    BooleanFilterPredicate booleanFilterPredicate2 = new BooleanFilterPredicate();
    booleanFilterPredicate2.setOperation(BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate2.setValue(value);

    // Act and Assert
    assertNotEquals(booleanFilterPredicate, booleanFilterPredicate2);
  }

  /**
   * Test {@link BooleanFilterPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BooleanFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BooleanFilterPredicate.equals(Object)",
    "int BooleanFilterPredicate.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(BooleanOperation.EQUAL);
    booleanFilterPredicate.setValue(
        new FilterPredicateValue<>(
            true,
            true,
            new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));

    BooleanFilterPredicate booleanFilterPredicate2 = new BooleanFilterPredicate();
    booleanFilterPredicate2.setOperation(BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate2.setValue(value);

    // Act and Assert
    assertNotEquals(booleanFilterPredicate, booleanFilterPredicate2);
  }

  /**
   * Test {@link BooleanFilterPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BooleanFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BooleanFilterPredicate.equals(Object)",
    "int BooleanFilterPredicate.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate.setValue(value);

    // Act and Assert
    assertNotEquals(booleanFilterPredicate, null);
  }

  /**
   * Test {@link BooleanFilterPredicate#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BooleanFilterPredicate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BooleanFilterPredicate.equals(Object)",
    "int BooleanFilterPredicate.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BooleanFilterPredicate booleanFilterPredicate = new BooleanFilterPredicate();
    booleanFilterPredicate.setOperation(BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    booleanFilterPredicate.setValue(value);

    // Act and Assert
    assertNotEquals(booleanFilterPredicate, "Different type to BooleanFilterPredicate");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BooleanFilterPredicate}
   *   <li>{@link BooleanFilterPredicate#setOperation(BooleanOperation)}
   *   <li>{@link BooleanFilterPredicate#setValue(FilterPredicateValue)}
   *   <li>{@link BooleanFilterPredicate#toString()}
   *   <li>{@link BooleanFilterPredicate#getOperation()}
   *   <li>{@link BooleanFilterPredicate#getType()}
   *   <li>{@link BooleanFilterPredicate#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BooleanFilterPredicate.<init>()",
    "BooleanOperation BooleanFilterPredicate.getOperation()",
    "FilterPredicateType BooleanFilterPredicate.getType()",
    "FilterPredicateValue BooleanFilterPredicate.getValue()",
    "void BooleanFilterPredicate.setOperation(BooleanOperation)",
    "void BooleanFilterPredicate.setValue(FilterPredicateValue)",
    "String BooleanFilterPredicate.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    BooleanFilterPredicate actualBooleanFilterPredicate = new BooleanFilterPredicate();
    actualBooleanFilterPredicate.setOperation(BooleanOperation.EQUAL);
    FilterPredicateValue<Boolean> value = FilterPredicateValue.fromBoolean(true);
    actualBooleanFilterPredicate.setValue(value);
    String actualToStringResult = actualBooleanFilterPredicate.toString();
    BooleanOperation actualOperation = actualBooleanFilterPredicate.getOperation();
    FilterPredicateType actualType = actualBooleanFilterPredicate.getType();

    // Assert
    assertEquals(
        "BooleanFilterPredicate(operation=EQUAL, value=FilterPredicateValue(defaultValue=true, userValue=null,"
            + " dynamicValue=null))",
        actualToStringResult);
    assertEquals(BooleanOperation.EQUAL, actualOperation);
    assertEquals(FilterPredicateType.BOOLEAN, actualType);
    assertSame(value, actualBooleanFilterPredicate.getValue());
  }
}
