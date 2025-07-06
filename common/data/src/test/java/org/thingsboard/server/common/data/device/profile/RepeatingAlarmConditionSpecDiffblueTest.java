package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.DynamicValue;
import org.thingsboard.server.common.data.query.DynamicValueSourceType;
import org.thingsboard.server.common.data.query.FilterPredicateValue;

class RepeatingAlarmConditionSpecDiffblueTest {
  /**
   * Test {@link RepeatingAlarmConditionSpec#equals(Object)}, and {@link
   * RepeatingAlarmConditionSpec#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepeatingAlarmConditionSpec#equals(Object)}
   *   <li>{@link RepeatingAlarmConditionSpec#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepeatingAlarmConditionSpec.equals(Object)",
    "int RepeatingAlarmConditionSpec.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec.setPredicate(
        new FilterPredicateValue<>(
            42, 42, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));

    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec2 = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec2.setPredicate(
        new FilterPredicateValue<>(
            42, 42, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));

    // Act and Assert
    assertEquals(repeatingAlarmConditionSpec, repeatingAlarmConditionSpec2);
    int expectedHashCodeResult = repeatingAlarmConditionSpec.hashCode();
    assertEquals(expectedHashCodeResult, repeatingAlarmConditionSpec2.hashCode());
  }

  /**
   * Test {@link RepeatingAlarmConditionSpec#equals(Object)}, and {@link
   * RepeatingAlarmConditionSpec#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepeatingAlarmConditionSpec#equals(Object)}
   *   <li>{@link RepeatingAlarmConditionSpec#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepeatingAlarmConditionSpec.equals(Object)",
    "int RepeatingAlarmConditionSpec.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec.setPredicate(null);

    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec2 = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec2.setPredicate(null);

    // Act and Assert
    assertEquals(repeatingAlarmConditionSpec, repeatingAlarmConditionSpec2);
    int expectedHashCodeResult = repeatingAlarmConditionSpec.hashCode();
    assertEquals(expectedHashCodeResult, repeatingAlarmConditionSpec2.hashCode());
  }

  /**
   * Test {@link RepeatingAlarmConditionSpec#equals(Object)}, and {@link
   * RepeatingAlarmConditionSpec#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RepeatingAlarmConditionSpec#equals(Object)}
   *   <li>{@link RepeatingAlarmConditionSpec#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepeatingAlarmConditionSpec.equals(Object)",
    "int RepeatingAlarmConditionSpec.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec.setPredicate(
        new FilterPredicateValue<>(
            42, 42, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));

    // Act and Assert
    assertEquals(repeatingAlarmConditionSpec, repeatingAlarmConditionSpec);
    int expectedHashCodeResult = repeatingAlarmConditionSpec.hashCode();
    assertEquals(expectedHashCodeResult, repeatingAlarmConditionSpec.hashCode());
  }

  /**
   * Test {@link RepeatingAlarmConditionSpec#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepeatingAlarmConditionSpec#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepeatingAlarmConditionSpec.equals(Object)",
    "int RepeatingAlarmConditionSpec.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec.setPredicate(
        new FilterPredicateValue<>(
            1, 42, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));

    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec2 = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec2.setPredicate(
        new FilterPredicateValue<>(
            42, 42, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));

    // Act and Assert
    assertNotEquals(repeatingAlarmConditionSpec, repeatingAlarmConditionSpec2);
  }

  /**
   * Test {@link RepeatingAlarmConditionSpec#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepeatingAlarmConditionSpec#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepeatingAlarmConditionSpec.equals(Object)",
    "int RepeatingAlarmConditionSpec.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec.setPredicate(null);

    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec2 = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec2.setPredicate(
        new FilterPredicateValue<>(
            42, 42, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));

    // Act and Assert
    assertNotEquals(repeatingAlarmConditionSpec, repeatingAlarmConditionSpec2);
  }

  /**
   * Test {@link RepeatingAlarmConditionSpec#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepeatingAlarmConditionSpec#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepeatingAlarmConditionSpec.equals(Object)",
    "int RepeatingAlarmConditionSpec.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec.setPredicate(
        new FilterPredicateValue<>(
            42, 42, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));

    // Act and Assert
    assertNotEquals(repeatingAlarmConditionSpec, null);
  }

  /**
   * Test {@link RepeatingAlarmConditionSpec#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RepeatingAlarmConditionSpec#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RepeatingAlarmConditionSpec.equals(Object)",
    "int RepeatingAlarmConditionSpec.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec.setPredicate(
        new FilterPredicateValue<>(
            42, 42, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));

    // Act and Assert
    assertNotEquals(repeatingAlarmConditionSpec, "Different type to RepeatingAlarmConditionSpec");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link RepeatingAlarmConditionSpec}
   *   <li>{@link RepeatingAlarmConditionSpec#setPredicate(FilterPredicateValue)}
   *   <li>{@link RepeatingAlarmConditionSpec#toString()}
   *   <li>{@link RepeatingAlarmConditionSpec#getPredicate()}
   *   <li>{@link RepeatingAlarmConditionSpec#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void RepeatingAlarmConditionSpec.<init>()",
    "FilterPredicateValue RepeatingAlarmConditionSpec.getPredicate()",
    "AlarmConditionSpecType RepeatingAlarmConditionSpec.getType()",
    "void RepeatingAlarmConditionSpec.setPredicate(FilterPredicateValue)",
    "String RepeatingAlarmConditionSpec.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RepeatingAlarmConditionSpec actualRepeatingAlarmConditionSpec =
        new RepeatingAlarmConditionSpec();
    FilterPredicateValue<Integer> predicate =
        new FilterPredicateValue<>(
            42, 42, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    actualRepeatingAlarmConditionSpec.setPredicate(predicate);
    String actualToStringResult = actualRepeatingAlarmConditionSpec.toString();
    FilterPredicateValue<Integer> actualPredicate =
        actualRepeatingAlarmConditionSpec.getPredicate();

    // Assert
    assertEquals(
        "RepeatingAlarmConditionSpec(predicate=FilterPredicateValue(defaultValue=42, userValue=42, dynamicValue"
            + "=DynamicValue(resolvedValue=null, sourceType=CURRENT_TENANT, sourceAttribute=Source Attribute,"
            + " inherit=false)))",
        actualToStringResult);
    assertEquals(AlarmConditionSpecType.REPEATING, actualRepeatingAlarmConditionSpec.getType());
    assertSame(predicate, actualPredicate);
  }
}
