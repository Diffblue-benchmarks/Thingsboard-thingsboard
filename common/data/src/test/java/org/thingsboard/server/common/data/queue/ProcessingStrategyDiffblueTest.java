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
package org.thingsboard.server.common.data.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class ProcessingStrategyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProcessingStrategy#equals(Object)}
   *   <li>{@link ProcessingStrategy#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act and Assert
    assertEquals(processingStrategy, processingStrategy2);
    int expectedHashCodeResult = processingStrategy.hashCode();
    assertEquals(expectedHashCodeResult, processingStrategy2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProcessingStrategy#equals(Object)}
   *   <li>{@link ProcessingStrategy#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(null);

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(null);

    // Act and Assert
    assertEquals(processingStrategy, processingStrategy2);
    int expectedHashCodeResult = processingStrategy.hashCode();
    assertEquals(expectedHashCodeResult, processingStrategy2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProcessingStrategy#equals(Object)}
   *   <li>{@link ProcessingStrategy#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act and Assert
    assertEquals(processingStrategy, processingStrategy);
    int expectedHashCodeResult = processingStrategy.hashCode();
    assertEquals(expectedHashCodeResult, processingStrategy.hashCode());
  }

  /**
   * Method under test: {@link ProcessingStrategy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(0.5d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act and Assert
    assertNotEquals(processingStrategy, processingStrategy2);
  }

  /**
   * Method under test: {@link ProcessingStrategy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(3L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act and Assert
    assertNotEquals(processingStrategy, processingStrategy2);
  }

  /**
   * Method under test: {@link ProcessingStrategy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(3L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act and Assert
    assertNotEquals(processingStrategy, processingStrategy2);
  }

  /**
   * Method under test: {@link ProcessingStrategy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(3);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act and Assert
    assertNotEquals(processingStrategy, processingStrategy2);
  }

  /**
   * Method under test: {@link ProcessingStrategy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(null);

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act and Assert
    assertNotEquals(processingStrategy, processingStrategy2);
  }

  /**
   * Method under test: {@link ProcessingStrategy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES_AND_TIMED_OUT);

    ProcessingStrategy processingStrategy2 = new ProcessingStrategy();
    processingStrategy2.setFailurePercentage(10.0d);
    processingStrategy2.setMaxPauseBetweenRetries(1L);
    processingStrategy2.setPauseBetweenRetries(1L);
    processingStrategy2.setRetries(1);
    processingStrategy2.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act and Assert
    assertNotEquals(processingStrategy, processingStrategy2);
  }

  /**
   * Method under test: {@link ProcessingStrategy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act and Assert
    assertNotEquals(processingStrategy, null);
  }

  /**
   * Method under test: {@link ProcessingStrategy#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);

    // Act and Assert
    assertNotEquals(processingStrategy, "Different type to ProcessingStrategy");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ProcessingStrategy}
   *   <li>{@link ProcessingStrategy#setFailurePercentage(double)}
   *   <li>{@link ProcessingStrategy#setMaxPauseBetweenRetries(long)}
   *   <li>{@link ProcessingStrategy#setPauseBetweenRetries(long)}
   *   <li>{@link ProcessingStrategy#setRetries(int)}
   *   <li>{@link ProcessingStrategy#setType(ProcessingStrategyType)}
   *   <li>{@link ProcessingStrategy#toString()}
   *   <li>{@link ProcessingStrategy#getFailurePercentage()}
   *   <li>{@link ProcessingStrategy#getMaxPauseBetweenRetries()}
   *   <li>{@link ProcessingStrategy#getPauseBetweenRetries()}
   *   <li>{@link ProcessingStrategy#getRetries()}
   *   <li>{@link ProcessingStrategy#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ProcessingStrategy actualProcessingStrategy = new ProcessingStrategy();
    actualProcessingStrategy.setFailurePercentage(10.0d);
    actualProcessingStrategy.setMaxPauseBetweenRetries(1L);
    actualProcessingStrategy.setPauseBetweenRetries(1L);
    actualProcessingStrategy.setRetries(1);
    actualProcessingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);
    String actualToStringResult = actualProcessingStrategy.toString();
    double actualFailurePercentage = actualProcessingStrategy.getFailurePercentage();
    long actualMaxPauseBetweenRetries = actualProcessingStrategy.getMaxPauseBetweenRetries();
    long actualPauseBetweenRetries = actualProcessingStrategy.getPauseBetweenRetries();
    int actualRetries = actualProcessingStrategy.getRetries();

    // Assert that nothing has changed
    assertEquals("ProcessingStrategy(type=SKIP_ALL_FAILURES, retries=1, failurePercentage=10.0, pauseBetweenRetries=1,"
        + " maxPauseBetweenRetries=1)", actualToStringResult);
    assertEquals(1, actualRetries);
    assertEquals(10.0d, actualFailurePercentage);
    assertEquals(1L, actualMaxPauseBetweenRetries);
    assertEquals(1L, actualPauseBetweenRetries);
    assertEquals(ProcessingStrategyType.SKIP_ALL_FAILURES, actualProcessingStrategy.getType());
  }
}
