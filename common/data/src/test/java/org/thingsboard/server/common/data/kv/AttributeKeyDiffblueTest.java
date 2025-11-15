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
package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class AttributeKeyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeKey#equals(Object)}
   *   <li>{@link AttributeKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AttributeKey attributeKey = new AttributeKey("Scope", "Attribute Key");
    AttributeKey attributeKey2 = new AttributeKey("Scope", "Attribute Key");

    // Act and Assert
    assertEquals(attributeKey, attributeKey2);
    int expectedHashCodeResult = attributeKey.hashCode();
    assertEquals(expectedHashCodeResult, attributeKey2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeKey#equals(Object)}
   *   <li>{@link AttributeKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AttributeKey attributeKey = new AttributeKey(null, "Attribute Key");
    AttributeKey attributeKey2 = new AttributeKey(null, "Attribute Key");

    // Act and Assert
    assertEquals(attributeKey, attributeKey2);
    int expectedHashCodeResult = attributeKey.hashCode();
    assertEquals(expectedHashCodeResult, attributeKey2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeKey#equals(Object)}
   *   <li>{@link AttributeKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AttributeKey attributeKey = new AttributeKey("Scope", null);
    AttributeKey attributeKey2 = new AttributeKey("Scope", null);

    // Act and Assert
    assertEquals(attributeKey, attributeKey2);
    int expectedHashCodeResult = attributeKey.hashCode();
    assertEquals(expectedHashCodeResult, attributeKey2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeKey#equals(Object)}
   *   <li>{@link AttributeKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AttributeKey attributeKey = new AttributeKey("Scope", "Attribute Key");

    // Act and Assert
    assertEquals(attributeKey, attributeKey);
    int expectedHashCodeResult = attributeKey.hashCode();
    assertEquals(expectedHashCodeResult, attributeKey.hashCode());
  }

  /**
   * Method under test: {@link AttributeKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AttributeKey attributeKey = new AttributeKey("Attribute Key", "Attribute Key");

    // Act and Assert
    assertNotEquals(attributeKey, new AttributeKey("Scope", "Attribute Key"));
  }

  /**
   * Method under test: {@link AttributeKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AttributeKey attributeKey = new AttributeKey(null, "Attribute Key");

    // Act and Assert
    assertNotEquals(attributeKey, new AttributeKey("Scope", "Attribute Key"));
  }

  /**
   * Method under test: {@link AttributeKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AttributeKey attributeKey = new AttributeKey("Scope", "Scope");

    // Act and Assert
    assertNotEquals(attributeKey, new AttributeKey("Scope", "Attribute Key"));
  }

  /**
   * Method under test: {@link AttributeKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AttributeKey attributeKey = new AttributeKey("Scope", null);

    // Act and Assert
    assertNotEquals(attributeKey, new AttributeKey("Scope", "Attribute Key"));
  }

  /**
   * Method under test: {@link AttributeKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AttributeKey("Scope", "Attribute Key"), null);
  }

  /**
   * Method under test: {@link AttributeKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AttributeKey("Scope", "Attribute Key"), "Different type to AttributeKey");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeKey#AttributeKey(String, String)}
   *   <li>{@link AttributeKey#toString()}
   *   <li>{@link AttributeKey#getAttributeKey()}
   *   <li>{@link AttributeKey#getScope()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AttributeKey actualAttributeKey = new AttributeKey("Scope", "Attribute Key");
    String actualToStringResult = actualAttributeKey.toString();
    String actualAttributeKey2 = actualAttributeKey.getAttributeKey();

    // Assert
    assertEquals("Attribute Key", actualAttributeKey2);
    assertEquals("AttributeKey(scope=Scope, attributeKey=Attribute Key)", actualToStringResult);
    assertEquals("Scope", actualAttributeKey.getScope());
  }
}
