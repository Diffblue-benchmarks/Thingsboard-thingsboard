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
package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ConsistentHashCircleDiffblueTest {
  /**
   * Method under test: {@link ConsistentHashCircle#put(long, Object)}
   */
  @Test
  void testPut() {
    // Arrange
    ConsistentHashCircle<Object> consistentHashCircle = new ConsistentHashCircle<>();

    // Act
    consistentHashCircle.put(81985529216486895L, "Instance");

    // Assert
    assertFalse(consistentHashCircle.isEmpty());
  }

  /**
   * Method under test: {@link ConsistentHashCircle#isEmpty()}
   */
  @Test
  void testIsEmpty() {
    // Arrange
    ConsistentHashCircle<Object> consistentHashCircle = new ConsistentHashCircle<>();

    // Act and Assert
    assertTrue(consistentHashCircle.isEmpty());
  }

  /**
   * Method under test: {@link ConsistentHashCircle#isEmpty()}
   */
  @Test
  void testIsEmpty2() {
    // Arrange
    ConsistentHashCircle<Object> consistentHashCircle = new ConsistentHashCircle<>();
    consistentHashCircle.put(81985529216486895L, "Instance");

    // Act and Assert
    assertFalse(consistentHashCircle.isEmpty());
  }

  /**
   * Method under test: {@link ConsistentHashCircle#containsKey(Long)}
   */
  @Test
  void testContainsKey() {
    // Arrange
    ConsistentHashCircle<Object> consistentHashCircle = new ConsistentHashCircle<>();

    // Act and Assert
    assertFalse(consistentHashCircle.containsKey(81985529216486895L));
  }

  /**
   * Method under test: {@link ConsistentHashCircle#containsKey(Long)}
   */
  @Test
  void testContainsKey2() {
    // Arrange
    ConsistentHashCircle<Object> consistentHashCircle = new ConsistentHashCircle<>();
    consistentHashCircle.put(81985529216486895L, "Instance");

    // Act and Assert
    assertTrue(consistentHashCircle.containsKey(81985529216486895L));
  }

  /**
   * Method under test: {@link ConsistentHashCircle#tailMap(Long)}
   */
  @Test
  void testTailMap() {
    // Arrange
    ConsistentHashCircle<Object> consistentHashCircle = new ConsistentHashCircle<>();

    // Act and Assert
    assertTrue(consistentHashCircle.tailMap(81985529216486895L).isEmpty());
  }

  /**
   * Method under test: {@link ConsistentHashCircle#firstKey()}
   */
  @Test
  void testFirstKey() {
    // Arrange
    ConsistentHashCircle<Object> consistentHashCircle = new ConsistentHashCircle<>();
    consistentHashCircle.put(81985529216486895L, "Instance");

    // Act and Assert
    assertEquals(81985529216486895L, consistentHashCircle.firstKey().longValue());
  }

  /**
   * Method under test: {@link ConsistentHashCircle#get(Long)}
   */
  @Test
  void testGet() {
    // Arrange
    ConsistentHashCircle<Object> consistentHashCircle = new ConsistentHashCircle<>();

    // Act and Assert
    assertNull(consistentHashCircle.get(81985529216486895L));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ConsistentHashCircle}
   */
  @Test
  void testNewConsistentHashCircle() {
    // Arrange and Act
    ConsistentHashCircle<Object> actualConsistentHashCircle = new ConsistentHashCircle<>();

    // Assert
    assertTrue(actualConsistentHashCircle.isEmpty());
  }
}
