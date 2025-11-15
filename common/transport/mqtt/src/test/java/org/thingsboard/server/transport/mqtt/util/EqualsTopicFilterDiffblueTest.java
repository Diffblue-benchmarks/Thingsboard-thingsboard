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
package org.thingsboard.server.transport.mqtt.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class EqualsTopicFilterDiffblueTest {
  /**
   * Method under test: {@link EqualsTopicFilter#filter(String)}
   */
  @Test
  void testFilter() {
    // Arrange, Act and Assert
    assertFalse((new EqualsTopicFilter("Filter")).filter("Topic"));
    assertTrue((new EqualsTopicFilter("Topic")).filter("Topic"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EqualsTopicFilter#equals(Object)}
   *   <li>{@link EqualsTopicFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EqualsTopicFilter equalsTopicFilter = new EqualsTopicFilter("Filter");
    EqualsTopicFilter equalsTopicFilter2 = new EqualsTopicFilter("Filter");

    // Act and Assert
    assertEquals(equalsTopicFilter, equalsTopicFilter2);
    int expectedHashCodeResult = equalsTopicFilter.hashCode();
    assertEquals(expectedHashCodeResult, equalsTopicFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EqualsTopicFilter#equals(Object)}
   *   <li>{@link EqualsTopicFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EqualsTopicFilter equalsTopicFilter = new EqualsTopicFilter(null);
    EqualsTopicFilter equalsTopicFilter2 = new EqualsTopicFilter(null);

    // Act and Assert
    assertEquals(equalsTopicFilter, equalsTopicFilter2);
    int expectedHashCodeResult = equalsTopicFilter.hashCode();
    assertEquals(expectedHashCodeResult, equalsTopicFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EqualsTopicFilter#equals(Object)}
   *   <li>{@link EqualsTopicFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EqualsTopicFilter equalsTopicFilter = new EqualsTopicFilter("Filter");

    // Act and Assert
    assertEquals(equalsTopicFilter, equalsTopicFilter);
    int expectedHashCodeResult = equalsTopicFilter.hashCode();
    assertEquals(expectedHashCodeResult, equalsTopicFilter.hashCode());
  }

  /**
   * Method under test: {@link EqualsTopicFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EqualsTopicFilter equalsTopicFilter = new EqualsTopicFilter(null);

    // Act and Assert
    assertNotEquals(equalsTopicFilter, new EqualsTopicFilter("Filter"));
  }

  /**
   * Method under test: {@link EqualsTopicFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EqualsTopicFilter equalsTopicFilter = new EqualsTopicFilter(
        "org.thingsboard.server.transport.mqtt.util.EqualsTopicFilter");

    // Act and Assert
    assertNotEquals(equalsTopicFilter, new EqualsTopicFilter("Filter"));
  }

  /**
   * Method under test: {@link EqualsTopicFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EqualsTopicFilter("Filter"), null);
  }

  /**
   * Method under test: {@link EqualsTopicFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EqualsTopicFilter("Filter"), "Different type to EqualsTopicFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EqualsTopicFilter#EqualsTopicFilter(String)}
   *   <li>{@link EqualsTopicFilter#toString()}
   *   <li>{@link EqualsTopicFilter#getFilter()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EqualsTopicFilter actualEqualsTopicFilter = new EqualsTopicFilter("Filter");
    String actualToStringResult = actualEqualsTopicFilter.toString();

    // Assert
    assertEquals("EqualsTopicFilter(filter=Filter)", actualToStringResult);
    assertEquals("Filter", actualEqualsTopicFilter.getFilter());
  }
}
