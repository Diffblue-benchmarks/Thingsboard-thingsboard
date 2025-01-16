package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DynamicValueDiffblueTest {
  /**
   * Test {@link DynamicValue#equals(Object)}, and
   * {@link DynamicValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicValue#equals(Object)}
   *   <li>{@link DynamicValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");
    DynamicValue<Object> dynamicValue2 = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    // Act and Assert
    assertEquals(dynamicValue, dynamicValue2);
    int expectedHashCodeResult = dynamicValue.hashCode();
    assertEquals(expectedHashCodeResult, dynamicValue2.hashCode());
  }

  /**
   * Test {@link DynamicValue#equals(Object)}, and
   * {@link DynamicValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicValue#equals(Object)}
   *   <li>{@link DynamicValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(null, "Source Attribute");
    DynamicValue<Object> dynamicValue2 = new DynamicValue<>(null, "Source Attribute");

    // Act and Assert
    assertEquals(dynamicValue, dynamicValue2);
    int expectedHashCodeResult = dynamicValue.hashCode();
    assertEquals(expectedHashCodeResult, dynamicValue2.hashCode());
  }

  /**
   * Test {@link DynamicValue#equals(Object)}, and
   * {@link DynamicValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicValue#equals(Object)}
   *   <li>{@link DynamicValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, null);
    DynamicValue<Object> dynamicValue2 = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, null);

    // Act and Assert
    assertEquals(dynamicValue, dynamicValue2);
    int expectedHashCodeResult = dynamicValue.hashCode();
    assertEquals(expectedHashCodeResult, dynamicValue2.hashCode());
  }

  /**
   * Test {@link DynamicValue#equals(Object)}, and
   * {@link DynamicValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicValue#equals(Object)}
   *   <li>{@link DynamicValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");
    dynamicValue.setResolvedValue("Resolved Value");

    DynamicValue<Object> dynamicValue2 = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");
    dynamicValue2.setResolvedValue("Resolved Value");

    // Act and Assert
    assertEquals(dynamicValue, dynamicValue2);
    int expectedHashCodeResult = dynamicValue.hashCode();
    assertEquals(expectedHashCodeResult, dynamicValue2.hashCode());
  }

  /**
   * Test {@link DynamicValue#equals(Object)}, and
   * {@link DynamicValue#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicValue#equals(Object)}
   *   <li>{@link DynamicValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    // Act and Assert
    assertEquals(dynamicValue, dynamicValue);
    int expectedHashCodeResult = dynamicValue.hashCode();
    assertEquals(expectedHashCodeResult, dynamicValue.hashCode());
  }

  /**
   * Test {@link DynamicValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(null, "Source Attribute");

    // Act and Assert
    assertNotEquals(dynamicValue, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test {@link DynamicValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_CUSTOMER, "Source Attribute");

    // Act and Assert
    assertNotEquals(dynamicValue, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test {@link DynamicValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, null);

    // Act and Assert
    assertNotEquals(dynamicValue, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test {@link DynamicValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT,
        "org.thingsboard.server.common.data.query.DynamicValue");

    // Act and Assert
    assertNotEquals(dynamicValue, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test {@link DynamicValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute",
        true);

    // Act and Assert
    assertNotEquals(dynamicValue, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test {@link DynamicValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");
    dynamicValue.setResolvedValue("Resolved Value");

    // Act and Assert
    assertNotEquals(dynamicValue, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test {@link DynamicValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    DynamicValue<Object> dynamicValue2 = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");
    dynamicValue2.setResolvedValue("Resolved Value");

    // Act and Assert
    assertNotEquals(dynamicValue, dynamicValue2);
  }

  /**
   * Test {@link DynamicValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");
    dynamicValue.setResolvedValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertNotEquals(dynamicValue, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Test {@link DynamicValue#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    // Act and Assert
    assertNotEquals(dynamicValue, null);
  }

  /**
   * Test {@link DynamicValue#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    // Act and Assert
    assertNotEquals(dynamicValue, "Different type to DynamicValue");
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Source Attribute}.</li>
   *   <li>Then return not Inherit.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicValue#DynamicValue(DynamicValueSourceType, String)}
   *   <li>{@link DynamicValue#setResolvedValue(Object)}
   *   <li>{@link DynamicValue#toString()}
   *   <li>{@link DynamicValue#getResolvedValue()}
   *   <li>{@link DynamicValue#getSourceAttribute()}
   *   <li>{@link DynamicValue#getSourceType()}
   *   <li>{@link DynamicValue#isInherit()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Source Attribute'; then return not Inherit")
  void testGettersAndSetters_whenSourceAttribute_thenReturnNotInherit() {
    // Arrange and Act
    DynamicValue<Object> actualDynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT,
        "Source Attribute");
    actualDynamicValue.setResolvedValue("Resolved Value");
    String actualToStringResult = actualDynamicValue.toString();
    Object actualResolvedValue = actualDynamicValue.getResolvedValue();
    String actualSourceAttribute = actualDynamicValue.getSourceAttribute();
    DynamicValueSourceType actualSourceType = actualDynamicValue.getSourceType();

    // Assert that nothing has changed
    assertEquals(
        "DynamicValue(resolvedValue=Resolved Value, sourceType=CURRENT_TENANT, sourceAttribute=Source Attribute,"
            + " inherit=false)",
        actualToStringResult);
    assertEquals("Resolved Value", actualResolvedValue);
    assertEquals("Source Attribute", actualSourceAttribute);
    assertEquals(DynamicValueSourceType.CURRENT_TENANT, actualSourceType);
    assertFalse(actualDynamicValue.isInherit());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return Inherit.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DynamicValue#DynamicValue(DynamicValueSourceType, String, boolean)}
   *   <li>{@link DynamicValue#setResolvedValue(Object)}
   *   <li>{@link DynamicValue#toString()}
   *   <li>{@link DynamicValue#getResolvedValue()}
   *   <li>{@link DynamicValue#getSourceAttribute()}
   *   <li>{@link DynamicValue#getSourceType()}
   *   <li>{@link DynamicValue#isInherit()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'true'; then return Inherit")
  void testGettersAndSetters_whenTrue_thenReturnInherit() {
    // Arrange and Act
    DynamicValue<Object> actualDynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT,
        "Source Attribute", true);
    actualDynamicValue.setResolvedValue("Resolved Value");
    String actualToStringResult = actualDynamicValue.toString();
    Object actualResolvedValue = actualDynamicValue.getResolvedValue();
    String actualSourceAttribute = actualDynamicValue.getSourceAttribute();
    DynamicValueSourceType actualSourceType = actualDynamicValue.getSourceType();

    // Assert that nothing has changed
    assertEquals(
        "DynamicValue(resolvedValue=Resolved Value, sourceType=CURRENT_TENANT, sourceAttribute=Source Attribute,"
            + " inherit=true)",
        actualToStringResult);
    assertEquals("Resolved Value", actualResolvedValue);
    assertEquals("Source Attribute", actualSourceAttribute);
    assertEquals(DynamicValueSourceType.CURRENT_TENANT, actualSourceType);
    assertTrue(actualDynamicValue.isInherit());
  }
}
