/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.DynamicValue;
import org.thingsboard.server.common.data.query.DynamicValueSourceType;
import org.thingsboard.server.common.data.query.FilterPredicateValue;

class DurationAlarmConditionSpecDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DurationAlarmConditionSpec#equals(Object)}
   *   <li>{@link DurationAlarmConditionSpec#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(new FilterPredicateValue<>(42L, 42L,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);

    DurationAlarmConditionSpec durationAlarmConditionSpec2 = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec2.setPredicate(new FilterPredicateValue<>(42L, 42L,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec2.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertEquals(durationAlarmConditionSpec, durationAlarmConditionSpec2);
    int expectedHashCodeResult = durationAlarmConditionSpec.hashCode();
    assertEquals(expectedHashCodeResult, durationAlarmConditionSpec2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DurationAlarmConditionSpec#equals(Object)}
   *   <li>{@link DurationAlarmConditionSpec#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link DurationAlarmConditionSpec#equals(Object)}
   *   <li>{@link DurationAlarmConditionSpec#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(new FilterPredicateValue<>(42L, 42L,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(null);

    DurationAlarmConditionSpec durationAlarmConditionSpec2 = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec2.setPredicate(new FilterPredicateValue<>(42L, 42L,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec2.setUnit(null);

    // Act and Assert
    assertEquals(durationAlarmConditionSpec, durationAlarmConditionSpec2);
    int expectedHashCodeResult = durationAlarmConditionSpec.hashCode();
    assertEquals(expectedHashCodeResult, durationAlarmConditionSpec2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DurationAlarmConditionSpec#equals(Object)}
   *   <li>{@link DurationAlarmConditionSpec#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(new FilterPredicateValue<>(42L, 42L,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertEquals(durationAlarmConditionSpec, durationAlarmConditionSpec);
    int expectedHashCodeResult = durationAlarmConditionSpec.hashCode();
    assertEquals(expectedHashCodeResult, durationAlarmConditionSpec.hashCode());
  }

  /**
   * Method under test: {@link DurationAlarmConditionSpec#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(new FilterPredicateValue<>(1L, 42L,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);

    DurationAlarmConditionSpec durationAlarmConditionSpec2 = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec2.setPredicate(new FilterPredicateValue<>(42L, 42L,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec2.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertNotEquals(durationAlarmConditionSpec, durationAlarmConditionSpec2);
  }

  /**
   * Method under test: {@link DurationAlarmConditionSpec#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(new FilterPredicateValue<>(42L, 42L, mock(DynamicValue.class)));
    durationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);

    DurationAlarmConditionSpec durationAlarmConditionSpec2 = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec2.setPredicate(new FilterPredicateValue<>(42L, 42L,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec2.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertNotEquals(durationAlarmConditionSpec, durationAlarmConditionSpec2);
  }

  /**
   * Method under test: {@link DurationAlarmConditionSpec#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(null);
    durationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);

    DurationAlarmConditionSpec durationAlarmConditionSpec2 = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec2.setPredicate(new FilterPredicateValue<>(42L, 42L,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec2.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertNotEquals(durationAlarmConditionSpec, durationAlarmConditionSpec2);
  }

  /**
   * Method under test: {@link DurationAlarmConditionSpec#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(new FilterPredicateValue<>(42L, 42L,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(null);

    DurationAlarmConditionSpec durationAlarmConditionSpec2 = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec2.setPredicate(new FilterPredicateValue<>(42L, 42L,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec2.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertNotEquals(durationAlarmConditionSpec, durationAlarmConditionSpec2);
  }

  /**
   * Method under test: {@link DurationAlarmConditionSpec#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(new FilterPredicateValue<>(42L, 42L,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(TimeUnit.MICROSECONDS);

    DurationAlarmConditionSpec durationAlarmConditionSpec2 = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec2.setPredicate(new FilterPredicateValue<>(42L, 42L,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec2.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertNotEquals(durationAlarmConditionSpec, durationAlarmConditionSpec2);
  }

  /**
   * Method under test: {@link DurationAlarmConditionSpec#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(new FilterPredicateValue<>(42L, 42L,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertNotEquals(durationAlarmConditionSpec, null);
  }

  /**
   * Method under test: {@link DurationAlarmConditionSpec#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DurationAlarmConditionSpec durationAlarmConditionSpec = new DurationAlarmConditionSpec();
    durationAlarmConditionSpec.setPredicate(new FilterPredicateValue<>(42L, 42L,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
    durationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);

    // Act and Assert
    assertNotEquals(durationAlarmConditionSpec, "Different type to DurationAlarmConditionSpec");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link DurationAlarmConditionSpec}
   *   <li>{@link DurationAlarmConditionSpec#setPredicate(FilterPredicateValue)}
   *   <li>{@link DurationAlarmConditionSpec#setUnit(TimeUnit)}
   *   <li>{@link DurationAlarmConditionSpec#toString()}
   *   <li>{@link DurationAlarmConditionSpec#getPredicate()}
   *   <li>{@link DurationAlarmConditionSpec#getType()}
   *   <li>{@link DurationAlarmConditionSpec#getUnit()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DurationAlarmConditionSpec actualDurationAlarmConditionSpec = new DurationAlarmConditionSpec();
    FilterPredicateValue<Long> predicate = new FilterPredicateValue<>(42L, 42L,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    actualDurationAlarmConditionSpec.setPredicate(predicate);
    actualDurationAlarmConditionSpec.setUnit(TimeUnit.NANOSECONDS);
    String actualToStringResult = actualDurationAlarmConditionSpec.toString();
    FilterPredicateValue<Long> actualPredicate = actualDurationAlarmConditionSpec.getPredicate();
    AlarmConditionSpecType actualType = actualDurationAlarmConditionSpec.getType();

    // Assert that nothing has changed
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
