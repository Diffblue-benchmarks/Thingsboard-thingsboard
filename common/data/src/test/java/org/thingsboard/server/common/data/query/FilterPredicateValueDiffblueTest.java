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
package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class FilterPredicateValueDiffblueTest {
  /**
   * Method under test: {@link FilterPredicateValue#getValue()}
   */
  @Test
  void testGetValue() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertEquals("User Value", filterPredicateValue.getValue());
  }

  /**
   * Method under test: {@link FilterPredicateValue#getValue()}
   */
  @Test
  void testGetValue2() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", null,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertEquals("Default Value", filterPredicateValue.getValue());
  }

  /**
   * Method under test: {@link FilterPredicateValue#getValue()}
   */
  @Test
  void testGetValue3() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value");

    // Act and Assert
    assertEquals("Default Value", filterPredicateValue.getValue());
  }

  /**
   * Method under test: {@link FilterPredicateValue#getValue()}
   */
  @Test
  void testGetValue4() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");
    dynamicValue.setResolvedValue("Resolved Value");
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", null, dynamicValue);

    // Act and Assert
    assertEquals("Resolved Value", filterPredicateValue.getValue());
  }

  /**
   * Method under test: {@link FilterPredicateValue#fromDouble(double)}
   */
  @Test
  void testFromDouble() {
    // Arrange and Act
    FilterPredicateValue<Double> actualFromDoubleResult = FilterPredicateValue.fromDouble(10.0d);

    // Assert
    assertNull(actualFromDoubleResult.getUserValue());
    assertNull(actualFromDoubleResult.getDynamicValue());
    assertEquals(10.0d, actualFromDoubleResult.getDefaultValue().doubleValue());
    assertEquals(10.0d, actualFromDoubleResult.getValue().doubleValue());
  }

  /**
   * Method under test: {@link FilterPredicateValue#fromString(String)}
   */
  @Test
  void testFromString() {
    // Arrange and Act
    FilterPredicateValue<String> actualFromStringResult = FilterPredicateValue.fromString("42");

    // Assert
    assertEquals("42", actualFromStringResult.getDefaultValue());
    assertEquals("42", actualFromStringResult.getValue());
    assertNull(actualFromStringResult.getUserValue());
    assertNull(actualFromStringResult.getDynamicValue());
  }

  /**
   * Method under test: {@link FilterPredicateValue#fromBoolean(boolean)}
   */
  @Test
  void testFromBoolean() {
    // Arrange and Act
    FilterPredicateValue<Boolean> actualFromBooleanResult = FilterPredicateValue.fromBoolean(true);

    // Assert
    assertNull(actualFromBooleanResult.getUserValue());
    assertNull(actualFromBooleanResult.getDynamicValue());
    assertTrue(actualFromBooleanResult.getDefaultValue());
    assertTrue(actualFromBooleanResult.getValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FilterPredicateValue#equals(Object)}
   *   <li>{@link FilterPredicateValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    FilterPredicateValue<Object> filterPredicateValue2 = new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertEquals(filterPredicateValue, filterPredicateValue2);
    int expectedHashCodeResult = filterPredicateValue.hashCode();
    assertEquals(expectedHashCodeResult, filterPredicateValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FilterPredicateValue#equals(Object)}
   *   <li>{@link FilterPredicateValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>(null, "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    FilterPredicateValue<Object> filterPredicateValue2 = new FilterPredicateValue<>(null, "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertEquals(filterPredicateValue, filterPredicateValue2);
    int expectedHashCodeResult = filterPredicateValue.hashCode();
    assertEquals(expectedHashCodeResult, filterPredicateValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FilterPredicateValue#equals(Object)}
   *   <li>{@link FilterPredicateValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value");
    FilterPredicateValue<Object> filterPredicateValue2 = new FilterPredicateValue<>(filterPredicateValue, "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    FilterPredicateValue<Object> filterPredicateValue3 = new FilterPredicateValue<>("Default Value");
    FilterPredicateValue<Object> filterPredicateValue4 = new FilterPredicateValue<>(filterPredicateValue3, "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertEquals(filterPredicateValue2, filterPredicateValue4);
    int expectedHashCodeResult = filterPredicateValue2.hashCode();
    assertEquals(expectedHashCodeResult, filterPredicateValue4.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FilterPredicateValue#equals(Object)}
   *   <li>{@link FilterPredicateValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertEquals(filterPredicateValue, filterPredicateValue);
    int expectedHashCodeResult = filterPredicateValue.hashCode();
    assertEquals(expectedHashCodeResult, filterPredicateValue.hashCode());
  }

  /**
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>(42, "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertNotEquals(filterPredicateValue, new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
  }

  /**
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>(null, "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertNotEquals(filterPredicateValue, new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
  }

  /**
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value");
    FilterPredicateValue<Object> filterPredicateValue2 = new FilterPredicateValue<>(filterPredicateValue, "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertNotEquals(filterPredicateValue2, new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
  }

  /**
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DynamicValue<Object> dynamicValue = mock(DynamicValue.class);
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>(dynamicValue, "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertNotEquals(filterPredicateValue, new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
  }

  /**
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", 42,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertNotEquals(filterPredicateValue, new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
  }

  /**
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", null,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertNotEquals(filterPredicateValue, new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
  }

  /**
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value");
    FilterPredicateValue<Object> filterPredicateValue2 = new FilterPredicateValue<>("Default Value",
        filterPredicateValue, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertNotEquals(filterPredicateValue2, new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
  }

  /**
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(null, "Source Attribute"));

    // Act and Assert
    assertNotEquals(filterPredicateValue, new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
  }

  /**
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", "User Value", null);

    // Act and Assert
    assertNotEquals(filterPredicateValue, new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
  }

  /**
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertNotEquals(filterPredicateValue, null);
  }

  /**
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertNotEquals(filterPredicateValue, "Different type to FilterPredicateValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FilterPredicateValue#FilterPredicateValue(Object)}
   *   <li>{@link FilterPredicateValue#toString()}
   *   <li>{@link FilterPredicateValue#getDefaultValue()}
   *   <li>{@link FilterPredicateValue#getDynamicValue()}
   *   <li>{@link FilterPredicateValue#getUserValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    FilterPredicateValue<Object> actualFilterPredicateValue = new FilterPredicateValue<>("Default Value");
    String actualToStringResult = actualFilterPredicateValue.toString();
    Object actualDefaultValue = actualFilterPredicateValue.getDefaultValue();
    DynamicValue<Object> actualDynamicValue = actualFilterPredicateValue.getDynamicValue();

    // Assert
    assertEquals("Default Value", actualDefaultValue);
    assertEquals("FilterPredicateValue(defaultValue=Default Value, userValue=null, dynamicValue=null)",
        actualToStringResult);
    assertNull(actualFilterPredicateValue.getUserValue());
    assertNull(actualDynamicValue);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link FilterPredicateValue#FilterPredicateValue(Object, Object, DynamicValue)}
   *   <li>{@link FilterPredicateValue#toString()}
   *   <li>{@link FilterPredicateValue#getDefaultValue()}
   *   <li>{@link FilterPredicateValue#getDynamicValue()}
   *   <li>{@link FilterPredicateValue#getUserValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    // Act
    FilterPredicateValue<Object> actualFilterPredicateValue = new FilterPredicateValue<>("Default Value", "User Value",
        dynamicValue);
    String actualToStringResult = actualFilterPredicateValue.toString();
    Object actualDefaultValue = actualFilterPredicateValue.getDefaultValue();
    DynamicValue<Object> actualDynamicValue = actualFilterPredicateValue.getDynamicValue();

    // Assert
    assertEquals("Default Value", actualDefaultValue);
    assertEquals(
        "FilterPredicateValue(defaultValue=Default Value, userValue=User Value, dynamicValue=DynamicValue"
            + "(resolvedValue=null, sourceType=CURRENT_TENANT, sourceAttribute=Source Attribute, inherit=false))",
        actualToStringResult);
    assertEquals("User Value", actualFilterPredicateValue.getUserValue());
    assertSame(dynamicValue, actualDynamicValue);
  }
}
