package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.DynamicValue;
import org.thingsboard.server.common.data.query.DynamicValueSourceType;
import org.thingsboard.server.common.data.query.FilterPredicateValue;

class DurationAlarmConditionSpecDiffblueTest {
  /**
   * Test {@link DurationAlarmConditionSpec#equals(Object)}, and {@link
   * DurationAlarmConditionSpec#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DurationAlarmConditionSpec#equals(Object)}
   *   <li>{@link DurationAlarmConditionSpec#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DurationAlarmConditionSpec.equals(Object)",
    "int DurationAlarmConditionSpec.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(
        new FilterPredicateValue<>(
            42L,
            42L,
            new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);

    DurationAlarmConditionSpec durationAlarmConditionSpec2 = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec2.setPredicate(
        new FilterPredicateValue<>(
            42L,
            42L,
            new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec2.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertEquals(durationAlarmConditionSpec, durationAlarmConditionSpec2);
    int expectedHashCodeResult = durationAlarmConditionSpec.hashCode();
    assertEquals(expectedHashCodeResult, durationAlarmConditionSpec2.hashCode());
  }

  /**
   * Test {@link DurationAlarmConditionSpec#equals(Object)}, and {@link
   * DurationAlarmConditionSpec#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DurationAlarmConditionSpec#equals(Object)}
   *   <li>{@link DurationAlarmConditionSpec#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DurationAlarmConditionSpec.equals(Object)",
    "int DurationAlarmConditionSpec.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(null);
    durationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);

    DurationAlarmConditionSpec durationAlarmConditionSpec2 = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec2.setPredicate(null);
    durationAlarmConditionSpec2.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertEquals(durationAlarmConditionSpec, durationAlarmConditionSpec2);
    int expectedHashCodeResult = durationAlarmConditionSpec.hashCode();
    assertEquals(expectedHashCodeResult, durationAlarmConditionSpec2.hashCode());
  }

  /**
   * Test {@link DurationAlarmConditionSpec#equals(Object)}, and {@link
   * DurationAlarmConditionSpec#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DurationAlarmConditionSpec#equals(Object)}
   *   <li>{@link DurationAlarmConditionSpec#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DurationAlarmConditionSpec.equals(Object)",
    "int DurationAlarmConditionSpec.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(
        new FilterPredicateValue<>(
            42L,
            42L,
            new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(null);

    DurationAlarmConditionSpec durationAlarmConditionSpec2 = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec2.setPredicate(
        new FilterPredicateValue<>(
            42L,
            42L,
            new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec2.setUnit(null);

    // Act and Assert
    assertEquals(durationAlarmConditionSpec, durationAlarmConditionSpec2);
    int expectedHashCodeResult = durationAlarmConditionSpec.hashCode();
    assertEquals(expectedHashCodeResult, durationAlarmConditionSpec2.hashCode());
  }

  /**
   * Test {@link DurationAlarmConditionSpec#equals(Object)}, and {@link
   * DurationAlarmConditionSpec#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DurationAlarmConditionSpec#equals(Object)}
   *   <li>{@link DurationAlarmConditionSpec#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DurationAlarmConditionSpec.equals(Object)",
    "int DurationAlarmConditionSpec.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(
        new FilterPredicateValue<>(
            42L,
            42L,
            new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertEquals(durationAlarmConditionSpec, durationAlarmConditionSpec);
    int expectedHashCodeResult = durationAlarmConditionSpec.hashCode();
    assertEquals(expectedHashCodeResult, durationAlarmConditionSpec.hashCode());
  }

  /**
   * Test {@link DurationAlarmConditionSpec#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DurationAlarmConditionSpec#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DurationAlarmConditionSpec.equals(Object)",
    "int DurationAlarmConditionSpec.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(
        new FilterPredicateValue<>(
            1L,
            42L,
            new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);

    DurationAlarmConditionSpec durationAlarmConditionSpec2 = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec2.setPredicate(
        new FilterPredicateValue<>(
            42L,
            42L,
            new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec2.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertNotEquals(durationAlarmConditionSpec, durationAlarmConditionSpec2);
  }

  /**
   * Test {@link DurationAlarmConditionSpec#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DurationAlarmConditionSpec#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DurationAlarmConditionSpec.equals(Object)",
    "int DurationAlarmConditionSpec.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(null);
    durationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);

    DurationAlarmConditionSpec durationAlarmConditionSpec2 = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec2.setPredicate(
        new FilterPredicateValue<>(
            42L,
            42L,
            new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec2.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertNotEquals(durationAlarmConditionSpec, durationAlarmConditionSpec2);
  }

  /**
   * Test {@link DurationAlarmConditionSpec#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DurationAlarmConditionSpec#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DurationAlarmConditionSpec.equals(Object)",
    "int DurationAlarmConditionSpec.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(
        new FilterPredicateValue<>(
            42L,
            42L,
            new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(null);

    DurationAlarmConditionSpec durationAlarmConditionSpec2 = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec2.setPredicate(
        new FilterPredicateValue<>(
            42L,
            42L,
            new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec2.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertNotEquals(durationAlarmConditionSpec, durationAlarmConditionSpec2);
  }

  /**
   * Test {@link DurationAlarmConditionSpec#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DurationAlarmConditionSpec#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DurationAlarmConditionSpec.equals(Object)",
    "int DurationAlarmConditionSpec.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(
        new FilterPredicateValue<>(
            42L,
            42L,
            new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(TimeUnit.MICROSECONDS);

    DurationAlarmConditionSpec durationAlarmConditionSpec2 = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec2.setPredicate(
        new FilterPredicateValue<>(
            42L,
            42L,
            new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec2.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertNotEquals(durationAlarmConditionSpec, durationAlarmConditionSpec2);
  }

  /**
   * Test {@link DurationAlarmConditionSpec#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DurationAlarmConditionSpec#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DurationAlarmConditionSpec.equals(Object)",
    "int DurationAlarmConditionSpec.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(
        new FilterPredicateValue<>(
            42L,
            42L,
            new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertNotEquals(durationAlarmConditionSpec, null);
  }

  /**
   * Test {@link DurationAlarmConditionSpec#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DurationAlarmConditionSpec#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DurationAlarmConditionSpec.equals(Object)",
    "int DurationAlarmConditionSpec.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(
        new FilterPredicateValue<>(
            42L,
            42L,
            new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertNotEquals(durationAlarmConditionSpec, "Different type to DurationAlarmConditionSpec");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DurationAlarmConditionSpec}
   *   <li>{@link DurationAlarmConditionSpec#setPredicate(FilterPredicateValue)}
   *   <li>{@link DurationAlarmConditionSpec#setUnit(TimeUnit)}
   *   <li>{@link DurationAlarmConditionSpec#toString()}
   *   <li>{@link DurationAlarmConditionSpec#getPredicate()}
   *   <li>{@link DurationAlarmConditionSpec#getType()}
   *   <li>{@link DurationAlarmConditionSpec#getUnit()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DurationAlarmConditionSpec.<init>()",
    "FilterPredicateValue DurationAlarmConditionSpec.getPredicate()",
    "AlarmConditionSpecType DurationAlarmConditionSpec.getType()",
    "TimeUnit DurationAlarmConditionSpec.getUnit()",
    "void DurationAlarmConditionSpec.setPredicate(FilterPredicateValue)",
    "void DurationAlarmConditionSpec.setUnit(TimeUnit)",
    "String DurationAlarmConditionSpec.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DurationAlarmConditionSpec actualDurationAlarmConditionSpec = new DurationAlarmConditionSpec();
    FilterPredicateValue<Long> predicate =
        new FilterPredicateValue<>(
            42L,
            42L,
            new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    actualDurationAlarmConditionSpec.setPredicate(predicate);
    actualDurationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);
    String actualToStringResult = actualDurationAlarmConditionSpec.toString();
    FilterPredicateValue<Long> actualPredicate = actualDurationAlarmConditionSpec.getPredicate();
    AlarmConditionSpecType actualType = actualDurationAlarmConditionSpec.getType();

    // Assert
    assertEquals(
        "DurationAlarmConditionSpec(unit=NANOSECONDS, predicate=FilterPredicateValue(defaultValue=42, userValue=42,"
            + " dynamicValue=DynamicValue(resolvedValue=null, sourceType=CURRENT_TENANT, sourceAttribute=Source"
            + " Attribute, inherit=false)))",
        actualToStringResult);
    assertEquals(TimeUnit.NANOSECONDS, actualDurationAlarmConditionSpec.getUnit());
    assertEquals(AlarmConditionSpecType.DURATION, actualType);
    assertSame(predicate, actualPredicate);
  }
}
