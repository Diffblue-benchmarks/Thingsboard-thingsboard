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
package org.thingsboard.server.common.data.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class TbPairDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbPair#equals(Object)}
   *   <li>{@link TbPair#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of("First", "Second");
    TbPair<Object, Object> ofResult2 = TbPair.of("First", "Second");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Method under test: {@link TbPair#of(Object, Object)}
   */
  @Test
  void testOf() {
    // Arrange and Act
    TbPair<Object, Object> actualOfResult = TbPair.of("First", "Second");

    // Assert
    assertEquals("First", actualOfResult.getFirst());
    assertEquals("Second", actualOfResult.getSecond());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbPair#equals(Object)}
   *   <li>{@link TbPair#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of(null, "Second");
    TbPair<Object, Object> ofResult2 = TbPair.of(null, "Second");

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbPair#equals(Object)}
   *   <li>{@link TbPair#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of("First", null);
    TbPair<Object, Object> ofResult2 = TbPair.of("First", null);

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbPair#equals(Object)}
   *   <li>{@link TbPair#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of("First", "Second");

    // Act and Assert
    assertEquals(ofResult, ofResult);
    int expectedHashCodeResult = ofResult.hashCode();
    assertEquals(expectedHashCodeResult, ofResult.hashCode());
  }

  /**
   * Method under test: {@link TbPair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.<Object, Object>of(1, "Second");
    TbPair<Object, Object> ofResult2 = TbPair.of("First", "Second");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Method under test: {@link TbPair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of(null, "Second");
    TbPair<Object, Object> ofResult2 = TbPair.of("First", "Second");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Method under test: {@link TbPair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of(new TbPair<>("First", "Second"), "Second");
    TbPair<Object, Object> ofResult2 = TbPair.of("First", "Second");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Method under test: {@link TbPair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.<Object, Object>of("First", 1);
    TbPair<Object, Object> ofResult2 = TbPair.of("First", "Second");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Method under test: {@link TbPair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of("First", null);
    TbPair<Object, Object> ofResult2 = TbPair.of("First", "Second");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Method under test: {@link TbPair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of("First", new TbPair<>("First", "Second"));
    TbPair<Object, Object> ofResult2 = TbPair.of("First", "Second");

    // Act and Assert
    assertNotEquals(ofResult, ofResult2);
  }

  /**
   * Method under test: {@link TbPair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of("First", "Second");

    // Act and Assert
    assertNotEquals(ofResult, null);
  }

  /**
   * Method under test: {@link TbPair#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TbPair<Object, Object> ofResult = TbPair.of("First", "Second");

    // Act and Assert
    assertNotEquals(ofResult, "Different type to TbPair");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbPair#TbPair(Object, Object)}
   *   <li>{@link TbPair#setFirst(Object)}
   *   <li>{@link TbPair#setSecond(Object)}
   *   <li>{@link TbPair#toString()}
   *   <li>{@link TbPair#getFirst()}
   *   <li>{@link TbPair#getSecond()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TbPair<Object, Object> actualTbPair = new TbPair<>("First", "Second");
    actualTbPair.setFirst("First");
    actualTbPair.setSecond("Second");
    String actualToStringResult = actualTbPair.toString();
    Object actualFirst = actualTbPair.getFirst();

    // Assert that nothing has changed
    assertEquals("First", actualFirst);
    assertEquals("Second", actualTbPair.getSecond());
    assertEquals("TbPair(first=First, second=Second)", actualToStringResult);
  }
}
