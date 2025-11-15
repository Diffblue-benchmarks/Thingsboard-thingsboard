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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class FirstEventActivityStrategyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FirstEventActivityStrategy#equals(Object)}
   *   <li>{@link FirstEventActivityStrategy#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FirstEventActivityStrategy firstEventActivityStrategy = new FirstEventActivityStrategy();
    FirstEventActivityStrategy firstEventActivityStrategy2 = new FirstEventActivityStrategy();

    // Act and Assert
    assertEquals(firstEventActivityStrategy, firstEventActivityStrategy2);
    int expectedHashCodeResult = firstEventActivityStrategy.hashCode();
    assertEquals(expectedHashCodeResult, firstEventActivityStrategy2.hashCode());
  }

  /**
   * Method under test: {@link FirstEventActivityStrategy#onActivity()}
   */
  @Test
  void testOnActivity() {
    // Arrange, Act and Assert
    assertTrue((new FirstEventActivityStrategy()).onActivity());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FirstEventActivityStrategy#equals(Object)}
   *   <li>{@link FirstEventActivityStrategy#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FirstEventActivityStrategy firstEventActivityStrategy = new FirstEventActivityStrategy();

    // Act and Assert
    assertEquals(firstEventActivityStrategy, firstEventActivityStrategy);
    int expectedHashCodeResult = firstEventActivityStrategy.hashCode();
    assertEquals(expectedHashCodeResult, firstEventActivityStrategy.hashCode());
  }

  /**
   * Method under test: {@link FirstEventActivityStrategy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FirstEventActivityStrategy(), 1);
  }

  /**
   * Method under test: {@link FirstEventActivityStrategy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FirstEventActivityStrategy(), null);
  }

  /**
   * Method under test: {@link FirstEventActivityStrategy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new FirstEventActivityStrategy(), "Different type to FirstEventActivityStrategy");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link FirstEventActivityStrategy}
   *   <li>{@link FirstEventActivityStrategy#onReportingPeriodEnd()}
   *   <li>{@link FirstEventActivityStrategy#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    FirstEventActivityStrategy actualFirstEventActivityStrategy = new FirstEventActivityStrategy();
    boolean actualOnReportingPeriodEndResult = actualFirstEventActivityStrategy.onReportingPeriodEnd();

    // Assert
    assertEquals("FirstEventActivityStrategy(firstEventReceived=false)", actualFirstEventActivityStrategy.toString());
    assertFalse(actualOnReportingPeriodEndResult);
  }
}
