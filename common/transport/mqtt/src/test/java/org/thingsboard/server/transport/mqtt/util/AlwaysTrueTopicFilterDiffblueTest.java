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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AlwaysTrueTopicFilterDiffblueTest {
  /**
   * Method under test: {@link AlwaysTrueTopicFilter#filter(String)}
   */
  @Test
  void testFilter() {
    // Arrange, Act and Assert
    assertTrue((new AlwaysTrueTopicFilter()).filter("Topic"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlwaysTrueTopicFilter#equals(Object)}
   *   <li>{@link AlwaysTrueTopicFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlwaysTrueTopicFilter alwaysTrueTopicFilter = new AlwaysTrueTopicFilter();
    AlwaysTrueTopicFilter alwaysTrueTopicFilter2 = new AlwaysTrueTopicFilter();

    // Act and Assert
    assertEquals(alwaysTrueTopicFilter, alwaysTrueTopicFilter2);
    int expectedHashCodeResult = alwaysTrueTopicFilter.hashCode();
    assertEquals(expectedHashCodeResult, alwaysTrueTopicFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlwaysTrueTopicFilter#equals(Object)}
   *   <li>{@link AlwaysTrueTopicFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlwaysTrueTopicFilter alwaysTrueTopicFilter = new AlwaysTrueTopicFilter();

    // Act and Assert
    assertEquals(alwaysTrueTopicFilter, alwaysTrueTopicFilter);
    int expectedHashCodeResult = alwaysTrueTopicFilter.hashCode();
    assertEquals(expectedHashCodeResult, alwaysTrueTopicFilter.hashCode());
  }

  /**
   * Method under test: {@link AlwaysTrueTopicFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlwaysTrueTopicFilter(), 1);
  }

  /**
   * Method under test: {@link AlwaysTrueTopicFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlwaysTrueTopicFilter(), null);
  }

  /**
   * Method under test: {@link AlwaysTrueTopicFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlwaysTrueTopicFilter(), "Different type to AlwaysTrueTopicFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AlwaysTrueTopicFilter}
   *   <li>{@link AlwaysTrueTopicFilter#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("AlwaysTrueTopicFilter()", (new AlwaysTrueTopicFilter()).toString());
  }
}
