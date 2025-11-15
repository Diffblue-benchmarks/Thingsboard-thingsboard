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
package org.thingsboard.server.common.transport.activity.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class FirstAndLastEventActivityStrategyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FirstAndLastEventActivityStrategy#equals(Object)}
   *   <li>{@link FirstAndLastEventActivityStrategy#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FirstAndLastEventActivityStrategy firstAndLastEventActivityStrategy = new FirstAndLastEventActivityStrategy();
    FirstAndLastEventActivityStrategy firstAndLastEventActivityStrategy2 = new FirstAndLastEventActivityStrategy();

    // Act and Assert
    assertEquals(firstAndLastEventActivityStrategy, firstAndLastEventActivityStrategy2);
    int expectedHashCodeResult = firstAndLastEventActivityStrategy.hashCode();
    assertEquals(expectedHashCodeResult, firstAndLastEventActivityStrategy2.hashCode());
  }

  /**
   * Method under test: {@link FirstAndLastEventActivityStrategy#onActivity()}
   */
  @Test
  void testOnActivity() {
    // Arrange, Act and Assert
    assertTrue((new FirstAndLastEventActivityStrategy()).onActivity());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FirstAndLastEventActivityStrategy#equals(Object)}
   *   <li>{@link FirstAndLastEventActivityStrategy#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FirstAndLastEventActivityStrategy firstAndLastEventActivityStrategy = new FirstAndLastEventActivityStrategy();

    // Act and Assert
    assertEquals(firstAndLastEventActivityStrategy, firstAndLastEventActivityStrategy);
    int expectedHashCodeResult = firstAndLastEventActivityStrategy.hashCode();
    assertEquals(expectedHashCodeResult, firstAndLastEventActivityStrategy.hashCode());
  }

  /**
   * Method under test: {@link FirstAndLastEventActivityStrategy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FirstAndLastEventActivityStrategy(), 1);
  }

  /**
   * Method under test: {@link FirstAndLastEventActivityStrategy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FirstAndLastEventActivityStrategy(), null);
  }

  /**
   * Method under test: {@link FirstAndLastEventActivityStrategy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FirstAndLastEventActivityStrategy(), "Different type to FirstAndLastEventActivityStrategy");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link FirstAndLastEventActivityStrategy}
   *   <li>{@link FirstAndLastEventActivityStrategy#onReportingPeriodEnd()}
   *   <li>{@link FirstAndLastEventActivityStrategy#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    FirstAndLastEventActivityStrategy actualFirstAndLastEventActivityStrategy = new FirstAndLastEventActivityStrategy();
    boolean actualOnReportingPeriodEndResult = actualFirstAndLastEventActivityStrategy.onReportingPeriodEnd();

    // Assert
    assertEquals("FirstAndLastEventActivityStrategy(firstEventReceived=false)",
        actualFirstAndLastEventActivityStrategy.toString());
    assertTrue(actualOnReportingPeriodEndResult);
  }
}
