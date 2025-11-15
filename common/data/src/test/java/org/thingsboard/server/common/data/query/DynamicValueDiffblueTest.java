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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class DynamicValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicValue#equals(Object)}
   *   <li>{@link DynamicValue#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicValue#equals(Object)}
   *   <li>{@link DynamicValue#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicValue#equals(Object)}
   *   <li>{@link DynamicValue#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicValue#equals(Object)}
   *   <li>{@link DynamicValue#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicValue#equals(Object)}
   *   <li>{@link DynamicValue#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    // Act and Assert
    assertEquals(dynamicValue, dynamicValue);
    int expectedHashCodeResult = dynamicValue.hashCode();
    assertEquals(expectedHashCodeResult, dynamicValue.hashCode());
  }

  /**
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(null, "Source Attribute");

    // Act and Assert
    assertNotEquals(dynamicValue, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_CUSTOMER, "Source Attribute");

    // Act and Assert
    assertNotEquals(dynamicValue, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, null);

    // Act and Assert
    assertNotEquals(dynamicValue, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT,
        "org.thingsboard.server.common.data.query.DynamicValue");

    // Act and Assert
    assertNotEquals(dynamicValue, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute",
        true);

    // Act and Assert
    assertNotEquals(dynamicValue, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");
    dynamicValue.setResolvedValue("Resolved Value");

    // Act and Assert
    assertNotEquals(dynamicValue, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    DynamicValue<Object> dynamicValue2 = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");
    dynamicValue2.setResolvedValue("Resolved Value");

    // Act and Assert
    assertNotEquals(dynamicValue, dynamicValue2);
  }

  /**
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");
    dynamicValue.setResolvedValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));

    // Act and Assert
    assertNotEquals(dynamicValue, new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
  }

  /**
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    // Act and Assert
    assertNotEquals(dynamicValue, null);
  }

  /**
   * Method under test: {@link DynamicValue#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DynamicValue<Object> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    // Act and Assert
    assertNotEquals(dynamicValue, "Different type to DynamicValue");
  }

  /**
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
  void testGettersAndSetters() {
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
  void testGettersAndSetters2() {
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
