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

class RegexTopicFilterDiffblueTest {
  /**
   * Method under test: {@link RegexTopicFilter#filter(String)}
   */
  @Test
  void testFilter() {
    // Arrange, Act and Assert
    assertTrue((new RegexTopicFilter(".*")).filter("Topic"));
    assertFalse((new RegexTopicFilter("U")).filter("Topic"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RegexTopicFilter#equals(Object)}
   *   <li>{@link RegexTopicFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RegexTopicFilter regexTopicFilter = new RegexTopicFilter(".*");

    // Act and Assert
    assertEquals(regexTopicFilter, regexTopicFilter);
    int expectedHashCodeResult = regexTopicFilter.hashCode();
    assertEquals(expectedHashCodeResult, regexTopicFilter.hashCode());
  }

  /**
   * Method under test: {@link RegexTopicFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RegexTopicFilter regexTopicFilter = new RegexTopicFilter(".*");

    // Act and Assert
    assertNotEquals(regexTopicFilter, new RegexTopicFilter(".*"));
  }

  /**
   * Method under test: {@link RegexTopicFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RegexTopicFilter(".*"), null);
  }

  /**
   * Method under test: {@link RegexTopicFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RegexTopicFilter(".*"), "Different type to RegexTopicFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RegexTopicFilter#toString()}
   *   <li>{@link RegexTopicFilter#getRegex()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    RegexTopicFilter regexTopicFilter = new RegexTopicFilter(".*");

    // Act
    String actualToStringResult = regexTopicFilter.toString();

    // Assert
    assertEquals(".*", regexTopicFilter.getRegex().pattern());
    assertEquals("RegexTopicFilter(regex=.*)", actualToStringResult);
  }

  /**
   * Method under test: {@link RegexTopicFilter#RegexTopicFilter(String)}
   */
  @Test
  void testNewRegexTopicFilter() {
    // Arrange, Act and Assert
    assertEquals(".*", (new RegexTopicFilter(".*")).getRegex().pattern());
  }
}
