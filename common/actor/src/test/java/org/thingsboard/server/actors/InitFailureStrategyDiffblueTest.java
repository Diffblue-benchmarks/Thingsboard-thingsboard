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
package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class InitFailureStrategyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link InitFailureStrategy#toString()}
   *   <li>{@link InitFailureStrategy#getRetryDelay()}
   *   <li>{@link InitFailureStrategy#isStop()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    InitFailureStrategy retryImmediatelyResult = InitFailureStrategy.retryImmediately();

    // Act
    String actualToStringResult = retryImmediatelyResult.toString();
    long actualRetryDelay = retryImmediatelyResult.getRetryDelay();

    // Assert
    assertEquals("InitFailureStrategy(stop=false, retryDelay=0)", actualToStringResult);
    assertEquals(0L, actualRetryDelay);
    assertFalse(retryImmediatelyResult.isStop());
  }

  /**
   * Method under test: {@link InitFailureStrategy#retryImmediately()}
   */
  @Test
  void testRetryImmediately() {
    // Arrange and Act
    InitFailureStrategy actualRetryImmediatelyResult = InitFailureStrategy.retryImmediately();

    // Assert
    assertEquals(0L, actualRetryImmediatelyResult.getRetryDelay());
    assertFalse(actualRetryImmediatelyResult.isStop());
  }

  /**
   * Method under test: {@link InitFailureStrategy#retryWithDelay(long)}
   */
  @Test
  void testRetryWithDelay() {
    // Arrange and Act
    InitFailureStrategy actualRetryWithDelayResult = InitFailureStrategy.retryWithDelay(1L);

    // Assert
    assertEquals(1L, actualRetryWithDelayResult.getRetryDelay());
    assertFalse(actualRetryWithDelayResult.isStop());
  }

  /**
   * Method under test: {@link InitFailureStrategy#stop()}
   */
  @Test
  void testStop() {
    // Arrange and Act
    InitFailureStrategy actualStopResult = InitFailureStrategy.stop();

    // Assert
    assertEquals(0L, actualStopResult.getRetryDelay());
    assertTrue(actualStopResult.isStop());
  }
}
