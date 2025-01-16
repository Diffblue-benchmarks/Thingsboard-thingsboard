package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FilterPredicateValueDiffblueTest {
  /**
   * Test {@link FilterPredicateValue#equals(Object)}, and
   * {@link FilterPredicateValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FilterPredicateValue#equals(Object)}
   *   <li>{@link FilterPredicateValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link FilterPredicateValue#equals(Object)}, and
   * {@link FilterPredicateValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FilterPredicateValue#equals(Object)}
   *   <li>{@link FilterPredicateValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link FilterPredicateValue#equals(Object)}, and
   * {@link FilterPredicateValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FilterPredicateValue#equals(Object)}
   *   <li>{@link FilterPredicateValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link FilterPredicateValue#equals(Object)}, and
   * {@link FilterPredicateValue#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FilterPredicateValue#equals(Object)}
   *   <li>{@link FilterPredicateValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * Test {@link FilterPredicateValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>(42, "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertNotEquals(filterPredicateValue, new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
  }

  /**
   * Test {@link FilterPredicateValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>(null, "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertNotEquals(filterPredicateValue, new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
  }

  /**
   * Test {@link FilterPredicateValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link FilterPredicateValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link FilterPredicateValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", 42,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertNotEquals(filterPredicateValue, new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
  }

  /**
   * Test {@link FilterPredicateValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", null,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertNotEquals(filterPredicateValue, new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
  }

  /**
   * Test {@link FilterPredicateValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link FilterPredicateValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(null, "Source Attribute"));

    // Act and Assert
    assertNotEquals(filterPredicateValue, new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
  }

  /**
   * Test {@link FilterPredicateValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", "User Value", null);

    // Act and Assert
    assertNotEquals(filterPredicateValue, new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute")));
  }

  /**
   * Test {@link FilterPredicateValue#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertNotEquals(filterPredicateValue, null);
  }

  /**
   * Test {@link FilterPredicateValue#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterPredicateValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertNotEquals(filterPredicateValue, "Different type to FilterPredicateValue");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@code User Value}.</li>
   *   <li>Then return toString is a string.</li>
   * </ul>
   * <p>
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
  @DisplayName("Test getters and setters; when 'User Value'; then return toString is a string")
  void testGettersAndSetters_whenUserValue_thenReturnToStringIsAString() {
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

  /**
   * Test {@link FilterPredicateValue#getValue()}.
   * <ul>
   *   <li>Given {@link FilterPredicateValue#FilterPredicateValue(Object)} with
   * {@code Default Value}.</li>
   *   <li>Then return {@code Default Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterPredicateValue#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given FilterPredicateValue(Object) with 'Default Value'; then return 'Default Value'")
  void testGetValue_givenFilterPredicateValueWithDefaultValue_thenReturnDefaultValue() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value");

    // Act and Assert
    assertEquals("Default Value", filterPredicateValue.getValue());
  }

  /**
   * Test {@link FilterPredicateValue#getValue()}.
   * <ul>
   *   <li>Then return {@code Default Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterPredicateValue#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); then return 'Default Value'")
  void testGetValue_thenReturnDefaultValue() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", null,
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertEquals("Default Value", filterPredicateValue.getValue());
  }

  /**
   * Test {@link FilterPredicateValue#getValue()}.
   * <ul>
   *   <li>Then return {@code Resolved Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterPredicateValue#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); then return 'Resolved Value'")
  void testGetValue_thenReturnResolvedValue() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");
    dynamicValue.setResolvedValue("Resolved Value");
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", null, dynamicValue);

    // Act and Assert
    assertEquals("Resolved Value", filterPredicateValue.getValue());
  }

  /**
   * Test {@link FilterPredicateValue#getValue()}.
   * <ul>
   *   <li>Then return {@code User Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterPredicateValue#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); then return 'User Value'")
  void testGetValue_thenReturnUserValue() {
    // Arrange
    FilterPredicateValue<Object> filterPredicateValue = new FilterPredicateValue<>("Default Value", "User Value",
        new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertEquals("User Value", filterPredicateValue.getValue());
  }

  /**
   * Test {@link FilterPredicateValue#fromDouble(double)}.
   * <p>
   * Method under test: {@link FilterPredicateValue#fromDouble(double)}
   */
  @Test
  @DisplayName("Test fromDouble(double)")
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
   * Test {@link FilterPredicateValue#fromString(String)}.
   * <p>
   * Method under test: {@link FilterPredicateValue#fromString(String)}
   */
  @Test
  @DisplayName("Test fromString(String)")
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
   * Test {@link FilterPredicateValue#fromBoolean(boolean)}.
   * <p>
   * Method under test: {@link FilterPredicateValue#fromBoolean(boolean)}
   */
  @Test
  @DisplayName("Test fromBoolean(boolean)")
  void testFromBoolean() {
    // Arrange and Act
    FilterPredicateValue<Boolean> actualFromBooleanResult = FilterPredicateValue.fromBoolean(true);

    // Assert
    assertNull(actualFromBooleanResult.getUserValue());
    assertNull(actualFromBooleanResult.getDynamicValue());
    assertTrue(actualFromBooleanResult.getDefaultValue());
    assertTrue(actualFromBooleanResult.getValue());
  }
}
