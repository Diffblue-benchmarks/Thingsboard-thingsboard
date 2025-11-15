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
package org.thingsboard.server.queue.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.junit.jupiter.api.Test;

class PropertyUtilsDiffblueTest {
  /**
   * Method under test: {@link PropertyUtils#getProps(String)}
   */
  @Test
  void testGetProps() {
    // Arrange and Act
    Map<String, String> actualProps = PropertyUtils.getProps(null);

    // Assert
    assertTrue(actualProps.isEmpty());
  }

  /**
   * Method under test: {@link PropertyUtils#getProps(String)}
   */
  @Test
  void testGetProps2() {
    // Arrange and Act
    Map<String, String> actualProps = PropertyUtils.getProps("");

    // Assert
    assertTrue(actualProps.isEmpty());
  }

  /**
   * Method under test: {@link PropertyUtils#getProps(String)}
   */
  @Test
  void testGetProps3() {
    // Arrange and Act
    Map<String, String> actualProps = PropertyUtils.getProps(";");

    // Assert
    assertTrue(actualProps.isEmpty());
  }

  /**
   * Method under test: {@link PropertyUtils#getProps(String)}
   */
  @Test
  void testGetProps4() {
    // Arrange and Act
    Map<String, String> actualProps = PropertyUtils.getProps(":");

    // Assert
    assertEquals(1, actualProps.size());
    assertEquals("", actualProps.get(""));
  }

  /**
   * Method under test: {@link PropertyUtils#getProps(String)}
   */
  @Test
  void testGetProps5() {
    // Arrange and Act
    Map<String, String> actualProps = PropertyUtils.getProps(";:");

    // Assert
    assertEquals(1, actualProps.size());
    assertEquals("", actualProps.get(""));
  }

  /**
   * Method under test: {@link PropertyUtils#getProps(Map, String)}
   */
  @Test
  void testGetProps6() {
    // Arrange and Act
    Map<String, String> actualProps = PropertyUtils.getProps(new HashMap<>(), null);

    // Assert
    assertTrue(actualProps.isEmpty());
  }

  /**
   * Method under test: {@link PropertyUtils#getProps(Map, String)}
   */
  @Test
  void testGetProps7() {
    // Arrange and Act
    Map<String, String> actualProps = PropertyUtils.getProps(new HashMap<>(), "");

    // Assert
    assertTrue(actualProps.isEmpty());
  }

  /**
   * Method under test: {@link PropertyUtils#getProps(Map, String)}
   */
  @Test
  void testGetProps8() {
    // Arrange and Act
    Map<String, String> actualProps = PropertyUtils.getProps(new HashMap<>(), ";");

    // Assert
    assertTrue(actualProps.isEmpty());
  }

  /**
   * Method under test: {@link PropertyUtils#getProps(Map, String)}
   */
  @Test
  void testGetProps9() {
    // Arrange and Act
    Map<String, String> actualProps = PropertyUtils.getProps(new HashMap<>(), ":");

    // Assert
    assertEquals(1, actualProps.size());
    assertEquals("", actualProps.get(""));
  }

  /**
   * Method under test: {@link PropertyUtils#getProps(Map, String, Function)}
   */
  @Test
  void testGetProps10() {
    // Arrange
    HashMap<String, String> defaultProperties = new HashMap<>();

    // Act
    Map<String, String> actualProps = PropertyUtils.getProps(defaultProperties, null, PropertyUtils::getProps);

    // Assert
    assertTrue(actualProps.isEmpty());
  }

  /**
   * Method under test: {@link PropertyUtils#getProps(Map, String, Function)}
   */
  @Test
  void testGetProps11() {
    // Arrange
    HashMap<String, String> defaultProperties = new HashMap<>();

    // Act
    Map<String, String> actualProps = PropertyUtils.getProps(defaultProperties, "", PropertyUtils::getProps);

    // Assert
    assertTrue(actualProps.isEmpty());
  }

  /**
   * Method under test: {@link PropertyUtils#getProps(Map, String, Function)}
   */
  @Test
  void testGetProps12() {
    // Arrange
    HashMap<String, String> defaultProperties = new HashMap<>();

    // Act
    Map<String, String> actualProps = PropertyUtils.getProps(defaultProperties, ";", PropertyUtils::getProps);

    // Assert
    assertTrue(actualProps.isEmpty());
  }

  /**
   * Method under test: {@link PropertyUtils#getProps(Map, String, Function)}
   */
  @Test
  void testGetProps13() {
    // Arrange
    HashMap<String, String> defaultProperties = new HashMap<>();

    // Act
    Map<String, String> actualProps = PropertyUtils.getProps(defaultProperties, ":", PropertyUtils::getProps);

    // Assert
    assertEquals(1, actualProps.size());
    assertEquals("", actualProps.get(""));
  }
}
