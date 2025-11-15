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
package org.thingsboard.server.common.data.sync.ie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AttributeExportDataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeExportData#equals(Object)}
   *   <li>{@link AttributeExportData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("42");

    AttributeExportData attributeExportData2 = new AttributeExportData();
    attributeExportData2.setBooleanValue(true);
    attributeExportData2.setDoubleValue(10.0d);
    attributeExportData2.setJsonValue("42");
    attributeExportData2.setKey("Key");
    attributeExportData2.setLastUpdateTs(1L);
    attributeExportData2.setLongValue(42L);
    attributeExportData2.setStrValue("42");

    // Act and Assert
    assertEquals(attributeExportData, attributeExportData2);
    int expectedHashCodeResult = attributeExportData.hashCode();
    assertEquals(expectedHashCodeResult, attributeExportData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeExportData#equals(Object)}
   *   <li>{@link AttributeExportData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(null);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("42");

    AttributeExportData attributeExportData2 = new AttributeExportData();
    attributeExportData2.setBooleanValue(null);
    attributeExportData2.setDoubleValue(10.0d);
    attributeExportData2.setJsonValue("42");
    attributeExportData2.setKey("Key");
    attributeExportData2.setLastUpdateTs(1L);
    attributeExportData2.setLongValue(42L);
    attributeExportData2.setStrValue("42");

    // Act and Assert
    assertEquals(attributeExportData, attributeExportData2);
    int expectedHashCodeResult = attributeExportData.hashCode();
    assertEquals(expectedHashCodeResult, attributeExportData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeExportData#equals(Object)}
   *   <li>{@link AttributeExportData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(null);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("42");

    AttributeExportData attributeExportData2 = new AttributeExportData();
    attributeExportData2.setBooleanValue(true);
    attributeExportData2.setDoubleValue(null);
    attributeExportData2.setJsonValue("42");
    attributeExportData2.setKey("Key");
    attributeExportData2.setLastUpdateTs(1L);
    attributeExportData2.setLongValue(42L);
    attributeExportData2.setStrValue("42");

    // Act and Assert
    assertEquals(attributeExportData, attributeExportData2);
    int expectedHashCodeResult = attributeExportData.hashCode();
    assertEquals(expectedHashCodeResult, attributeExportData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeExportData#equals(Object)}
   *   <li>{@link AttributeExportData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue(null);
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("42");

    AttributeExportData attributeExportData2 = new AttributeExportData();
    attributeExportData2.setBooleanValue(true);
    attributeExportData2.setDoubleValue(10.0d);
    attributeExportData2.setJsonValue(null);
    attributeExportData2.setKey("Key");
    attributeExportData2.setLastUpdateTs(1L);
    attributeExportData2.setLongValue(42L);
    attributeExportData2.setStrValue("42");

    // Act and Assert
    assertEquals(attributeExportData, attributeExportData2);
    int expectedHashCodeResult = attributeExportData.hashCode();
    assertEquals(expectedHashCodeResult, attributeExportData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeExportData#equals(Object)}
   *   <li>{@link AttributeExportData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("42");

    // Act and Assert
    assertEquals(attributeExportData, attributeExportData);
    int expectedHashCodeResult = attributeExportData.hashCode();
    assertEquals(expectedHashCodeResult, attributeExportData.hashCode());
  }

  /**
   * Method under test: {@link AttributeExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(false);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("42");

    AttributeExportData attributeExportData2 = new AttributeExportData();
    attributeExportData2.setBooleanValue(true);
    attributeExportData2.setDoubleValue(10.0d);
    attributeExportData2.setJsonValue("42");
    attributeExportData2.setKey("Key");
    attributeExportData2.setLastUpdateTs(1L);
    attributeExportData2.setLongValue(42L);
    attributeExportData2.setStrValue("42");

    // Act and Assert
    assertNotEquals(attributeExportData, attributeExportData2);
  }

  /**
   * Method under test: {@link AttributeExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(null);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("42");

    AttributeExportData attributeExportData2 = new AttributeExportData();
    attributeExportData2.setBooleanValue(true);
    attributeExportData2.setDoubleValue(10.0d);
    attributeExportData2.setJsonValue("42");
    attributeExportData2.setKey("Key");
    attributeExportData2.setLastUpdateTs(1L);
    attributeExportData2.setLongValue(42L);
    attributeExportData2.setStrValue("42");

    // Act and Assert
    assertNotEquals(attributeExportData, attributeExportData2);
  }

  /**
   * Method under test: {@link AttributeExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(null);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("42");

    AttributeExportData attributeExportData2 = new AttributeExportData();
    attributeExportData2.setBooleanValue(true);
    attributeExportData2.setDoubleValue(10.0d);
    attributeExportData2.setJsonValue("42");
    attributeExportData2.setKey("Key");
    attributeExportData2.setLastUpdateTs(1L);
    attributeExportData2.setLongValue(42L);
    attributeExportData2.setStrValue("42");

    // Act and Assert
    assertNotEquals(attributeExportData, attributeExportData2);
  }

  /**
   * Method under test: {@link AttributeExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(0.5d);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("42");

    AttributeExportData attributeExportData2 = new AttributeExportData();
    attributeExportData2.setBooleanValue(true);
    attributeExportData2.setDoubleValue(10.0d);
    attributeExportData2.setJsonValue("42");
    attributeExportData2.setKey("Key");
    attributeExportData2.setLastUpdateTs(1L);
    attributeExportData2.setLongValue(42L);
    attributeExportData2.setStrValue("42");

    // Act and Assert
    assertNotEquals(attributeExportData, attributeExportData2);
  }

  /**
   * Method under test: {@link AttributeExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue("Key");
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("42");

    AttributeExportData attributeExportData2 = new AttributeExportData();
    attributeExportData2.setBooleanValue(true);
    attributeExportData2.setDoubleValue(10.0d);
    attributeExportData2.setJsonValue("42");
    attributeExportData2.setKey("Key");
    attributeExportData2.setLastUpdateTs(1L);
    attributeExportData2.setLongValue(42L);
    attributeExportData2.setStrValue("42");

    // Act and Assert
    assertNotEquals(attributeExportData, attributeExportData2);
  }

  /**
   * Method under test: {@link AttributeExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue(null);
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("42");

    AttributeExportData attributeExportData2 = new AttributeExportData();
    attributeExportData2.setBooleanValue(true);
    attributeExportData2.setDoubleValue(10.0d);
    attributeExportData2.setJsonValue("42");
    attributeExportData2.setKey("Key");
    attributeExportData2.setLastUpdateTs(1L);
    attributeExportData2.setLongValue(42L);
    attributeExportData2.setStrValue("42");

    // Act and Assert
    assertNotEquals(attributeExportData, attributeExportData2);
  }

  /**
   * Method under test: {@link AttributeExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey("42");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("42");

    AttributeExportData attributeExportData2 = new AttributeExportData();
    attributeExportData2.setBooleanValue(true);
    attributeExportData2.setDoubleValue(10.0d);
    attributeExportData2.setJsonValue("42");
    attributeExportData2.setKey("Key");
    attributeExportData2.setLastUpdateTs(1L);
    attributeExportData2.setLongValue(42L);
    attributeExportData2.setStrValue("42");

    // Act and Assert
    assertNotEquals(attributeExportData, attributeExportData2);
  }

  /**
   * Method under test: {@link AttributeExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey(null);
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("42");

    AttributeExportData attributeExportData2 = new AttributeExportData();
    attributeExportData2.setBooleanValue(true);
    attributeExportData2.setDoubleValue(10.0d);
    attributeExportData2.setJsonValue("42");
    attributeExportData2.setKey("Key");
    attributeExportData2.setLastUpdateTs(1L);
    attributeExportData2.setLongValue(42L);
    attributeExportData2.setStrValue("42");

    // Act and Assert
    assertNotEquals(attributeExportData, attributeExportData2);
  }

  /**
   * Method under test: {@link AttributeExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(3L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("42");

    AttributeExportData attributeExportData2 = new AttributeExportData();
    attributeExportData2.setBooleanValue(true);
    attributeExportData2.setDoubleValue(10.0d);
    attributeExportData2.setJsonValue("42");
    attributeExportData2.setKey("Key");
    attributeExportData2.setLastUpdateTs(1L);
    attributeExportData2.setLongValue(42L);
    attributeExportData2.setStrValue("42");

    // Act and Assert
    assertNotEquals(attributeExportData, attributeExportData2);
  }

  /**
   * Method under test: {@link AttributeExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(null);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("42");

    AttributeExportData attributeExportData2 = new AttributeExportData();
    attributeExportData2.setBooleanValue(true);
    attributeExportData2.setDoubleValue(10.0d);
    attributeExportData2.setJsonValue("42");
    attributeExportData2.setKey("Key");
    attributeExportData2.setLastUpdateTs(1L);
    attributeExportData2.setLongValue(42L);
    attributeExportData2.setStrValue("42");

    // Act and Assert
    assertNotEquals(attributeExportData, attributeExportData2);
  }

  /**
   * Method under test: {@link AttributeExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(1L);
    attributeExportData.setStrValue("42");

    AttributeExportData attributeExportData2 = new AttributeExportData();
    attributeExportData2.setBooleanValue(true);
    attributeExportData2.setDoubleValue(10.0d);
    attributeExportData2.setJsonValue("42");
    attributeExportData2.setKey("Key");
    attributeExportData2.setLastUpdateTs(1L);
    attributeExportData2.setLongValue(42L);
    attributeExportData2.setStrValue("42");

    // Act and Assert
    assertNotEquals(attributeExportData, attributeExportData2);
  }

  /**
   * Method under test: {@link AttributeExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(null);
    attributeExportData.setStrValue("42");

    AttributeExportData attributeExportData2 = new AttributeExportData();
    attributeExportData2.setBooleanValue(true);
    attributeExportData2.setDoubleValue(10.0d);
    attributeExportData2.setJsonValue("42");
    attributeExportData2.setKey("Key");
    attributeExportData2.setLastUpdateTs(1L);
    attributeExportData2.setLongValue(42L);
    attributeExportData2.setStrValue("42");

    // Act and Assert
    assertNotEquals(attributeExportData, attributeExportData2);
  }

  /**
   * Method under test: {@link AttributeExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("Key");

    AttributeExportData attributeExportData2 = new AttributeExportData();
    attributeExportData2.setBooleanValue(true);
    attributeExportData2.setDoubleValue(10.0d);
    attributeExportData2.setJsonValue("42");
    attributeExportData2.setKey("Key");
    attributeExportData2.setLastUpdateTs(1L);
    attributeExportData2.setLongValue(42L);
    attributeExportData2.setStrValue("42");

    // Act and Assert
    assertNotEquals(attributeExportData, attributeExportData2);
  }

  /**
   * Method under test: {@link AttributeExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue(null);

    AttributeExportData attributeExportData2 = new AttributeExportData();
    attributeExportData2.setBooleanValue(true);
    attributeExportData2.setDoubleValue(10.0d);
    attributeExportData2.setJsonValue("42");
    attributeExportData2.setKey("Key");
    attributeExportData2.setLastUpdateTs(1L);
    attributeExportData2.setLongValue(42L);
    attributeExportData2.setStrValue("42");

    // Act and Assert
    assertNotEquals(attributeExportData, attributeExportData2);
  }

  /**
   * Method under test: {@link AttributeExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("42");

    // Act and Assert
    assertNotEquals(attributeExportData, null);
  }

  /**
   * Method under test: {@link AttributeExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AttributeExportData attributeExportData = new AttributeExportData();
    attributeExportData.setBooleanValue(true);
    attributeExportData.setDoubleValue(10.0d);
    attributeExportData.setJsonValue("42");
    attributeExportData.setKey("Key");
    attributeExportData.setLastUpdateTs(1L);
    attributeExportData.setLongValue(42L);
    attributeExportData.setStrValue("42");

    // Act and Assert
    assertNotEquals(attributeExportData, "Different type to AttributeExportData");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AttributeExportData}
   *   <li>{@link AttributeExportData#setBooleanValue(Boolean)}
   *   <li>{@link AttributeExportData#setDoubleValue(Double)}
   *   <li>{@link AttributeExportData#setJsonValue(String)}
   *   <li>{@link AttributeExportData#setKey(String)}
   *   <li>{@link AttributeExportData#setLastUpdateTs(Long)}
   *   <li>{@link AttributeExportData#setLongValue(Long)}
   *   <li>{@link AttributeExportData#setStrValue(String)}
   *   <li>{@link AttributeExportData#toString()}
   *   <li>{@link AttributeExportData#getBooleanValue()}
   *   <li>{@link AttributeExportData#getDoubleValue()}
   *   <li>{@link AttributeExportData#getJsonValue()}
   *   <li>{@link AttributeExportData#getKey()}
   *   <li>{@link AttributeExportData#getLastUpdateTs()}
   *   <li>{@link AttributeExportData#getLongValue()}
   *   <li>{@link AttributeExportData#getStrValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AttributeExportData actualAttributeExportData = new AttributeExportData();
    actualAttributeExportData.setBooleanValue(true);
    actualAttributeExportData.setDoubleValue(10.0d);
    actualAttributeExportData.setJsonValue("42");
    actualAttributeExportData.setKey("Key");
    actualAttributeExportData.setLastUpdateTs(1L);
    actualAttributeExportData.setLongValue(42L);
    actualAttributeExportData.setStrValue("42");
    String actualToStringResult = actualAttributeExportData.toString();
    Boolean actualBooleanValue = actualAttributeExportData.getBooleanValue();
    Double actualDoubleValue = actualAttributeExportData.getDoubleValue();
    String actualJsonValue = actualAttributeExportData.getJsonValue();
    String actualKey = actualAttributeExportData.getKey();
    Long actualLastUpdateTs = actualAttributeExportData.getLastUpdateTs();
    Long actualLongValue = actualAttributeExportData.getLongValue();

    // Assert that nothing has changed
    assertEquals("42", actualJsonValue);
    assertEquals("42", actualAttributeExportData.getStrValue());
    assertEquals(
        "AttributeExportData(key=Key, lastUpdateTs=1, booleanValue=true, strValue=42, longValue=42, doubleValue=10.0,"
            + " jsonValue=42)",
        actualToStringResult);
    assertEquals("Key", actualKey);
    assertEquals(10.0d, actualDoubleValue.doubleValue());
    assertEquals(1L, actualLastUpdateTs.longValue());
    assertEquals(42L, actualLongValue.longValue());
    assertTrue(actualBooleanValue);
  }
}
