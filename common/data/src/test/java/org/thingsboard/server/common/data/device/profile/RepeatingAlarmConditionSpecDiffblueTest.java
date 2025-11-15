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
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.DynamicValue;
import org.thingsboard.server.common.data.query.DynamicValueSourceType;
import org.thingsboard.server.common.data.query.FilterPredicateValue;

class RepeatingAlarmConditionSpecDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepeatingAlarmConditionSpec#equals(Object)}
   *   <li>{@link RepeatingAlarmConditionSpec#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec.setPredicate(new FilterPredicateValue<>(42, 42,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));

    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec2 = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec2.setPredicate(new FilterPredicateValue<>(42, 42,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));

    // Act and Assert
    assertEquals(repeatingAlarmConditionSpec, repeatingAlarmConditionSpec2);
    int expectedHashCodeResult = repeatingAlarmConditionSpec.hashCode();
    assertEquals(expectedHashCodeResult, repeatingAlarmConditionSpec2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RepeatingAlarmConditionSpec#equals(Object)}
   *   <li>{@link RepeatingAlarmConditionSpec#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link RepeatingAlarmConditionSpec#equals(Object)}
   *   <li>{@link RepeatingAlarmConditionSpec#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec.setPredicate(new FilterPredicateValue<>(42, 42,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));

    // Act and Assert
    assertEquals(repeatingAlarmConditionSpec, repeatingAlarmConditionSpec);
    int expectedHashCodeResult = repeatingAlarmConditionSpec.hashCode();
    assertEquals(expectedHashCodeResult, repeatingAlarmConditionSpec.hashCode());
  }

  /**
   * Method under test: {@link RepeatingAlarmConditionSpec#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec.setPredicate(new FilterPredicateValue<>(1, 42,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));

    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec2 = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec2.setPredicate(new FilterPredicateValue<>(42, 42,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));

    // Act and Assert
    assertNotEquals(repeatingAlarmConditionSpec, repeatingAlarmConditionSpec2);
  }

  /**
   * Method under test: {@link RepeatingAlarmConditionSpec#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec.setPredicate(new FilterPredicateValue<>(42, 42, mock(DynamicValue.class)));

    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec2 = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec2.setPredicate(new FilterPredicateValue<>(42, 42,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));

    // Act and Assert
    assertNotEquals(repeatingAlarmConditionSpec, repeatingAlarmConditionSpec2);
  }

  /**
   * Method under test: {@link RepeatingAlarmConditionSpec#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec.setPredicate(null);

    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec2 = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec2.setPredicate(new FilterPredicateValue<>(42, 42,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));

    // Act and Assert
    assertNotEquals(repeatingAlarmConditionSpec, repeatingAlarmConditionSpec2);
  }

  /**
   * Method under test: {@link RepeatingAlarmConditionSpec#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec.setPredicate(new FilterPredicateValue<>(42, 42,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));

    // Act and Assert
    assertNotEquals(repeatingAlarmConditionSpec, null);
  }

  /**
   * Method under test: {@link RepeatingAlarmConditionSpec#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RepeatingAlarmConditionSpec repeatingAlarmConditionSpec = new RepeatingAlarmConditionSpec();
    repeatingAlarmConditionSpec.setPredicate(new FilterPredicateValue<>(42, 42,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));

    // Act and Assert
    assertNotEquals(repeatingAlarmConditionSpec, "Different type to RepeatingAlarmConditionSpec");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link RepeatingAlarmConditionSpec}
   *   <li>{@link RepeatingAlarmConditionSpec#setPredicate(FilterPredicateValue)}
   *   <li>{@link RepeatingAlarmConditionSpec#toString()}
   *   <li>{@link RepeatingAlarmConditionSpec#getPredicate()}
   *   <li>{@link RepeatingAlarmConditionSpec#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    RepeatingAlarmConditionSpec actualRepeatingAlarmConditionSpec = new RepeatingAlarmConditionSpec();
    FilterPredicateValue<Integer> predicate = new FilterPredicateValue<>(42, 42,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    actualRepeatingAlarmConditionSpec.setPredicate(predicate);
    String actualToStringResult = actualRepeatingAlarmConditionSpec.toString();
    FilterPredicateValue<Integer> actualPredicate = actualRepeatingAlarmConditionSpec.getPredicate();

    // Assert that nothing has changed
    assertEquals(
        "RepeatingAlarmConditionSpec(predicate=FilterPredicateValue(defaultValue=42, userValue=42, dynamicValue"
            + "=DynamicValue(resolvedValue=null, sourceType=CURRENT_TENANT, sourceAttribute=Source Attribute,"
            + " inherit=false)))",
        actualToStringResult);
    assertEquals(AlarmConditionSpecType.REPEATING, actualRepeatingAlarmConditionSpec.getType());
    assertSame(predicate, actualPredicate);
  }
}
