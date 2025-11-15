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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.junit.jupiter.api.Test;

class DispatcherDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Dispatcher#equals(Object)}
   *   <li>{@link Dispatcher#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Dispatcher dispatcher = new Dispatcher("42", ForkJoinPool.commonPool());
    Dispatcher dispatcher2 = new Dispatcher("42", ForkJoinPool.commonPool());

    // Act and Assert
    assertEquals(dispatcher, dispatcher2);
    int expectedHashCodeResult = dispatcher.hashCode();
    assertEquals(expectedHashCodeResult, dispatcher2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Dispatcher#equals(Object)}
   *   <li>{@link Dispatcher#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Dispatcher dispatcher = new Dispatcher(null, ForkJoinPool.commonPool());
    Dispatcher dispatcher2 = new Dispatcher(null, ForkJoinPool.commonPool());

    // Act and Assert
    assertEquals(dispatcher, dispatcher2);
    int expectedHashCodeResult = dispatcher.hashCode();
    assertEquals(expectedHashCodeResult, dispatcher2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Dispatcher#equals(Object)}
   *   <li>{@link Dispatcher#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Dispatcher dispatcher = new Dispatcher("42", null);
    Dispatcher dispatcher2 = new Dispatcher("42", null);

    // Act and Assert
    assertEquals(dispatcher, dispatcher2);
    int expectedHashCodeResult = dispatcher.hashCode();
    assertEquals(expectedHashCodeResult, dispatcher2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Dispatcher#equals(Object)}
   *   <li>{@link Dispatcher#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Dispatcher dispatcher = new Dispatcher("42", ForkJoinPool.commonPool());

    // Act and Assert
    assertEquals(dispatcher, dispatcher);
    int expectedHashCodeResult = dispatcher.hashCode();
    assertEquals(expectedHashCodeResult, dispatcher.hashCode());
  }

  /**
   * Method under test: {@link Dispatcher#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Dispatcher dispatcher = new Dispatcher("Dispatcher Id", ForkJoinPool.commonPool());

    // Act and Assert
    assertNotEquals(dispatcher, new Dispatcher("42", ForkJoinPool.commonPool()));
  }

  /**
   * Method under test: {@link Dispatcher#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Dispatcher dispatcher = new Dispatcher(null, ForkJoinPool.commonPool());

    // Act and Assert
    assertNotEquals(dispatcher, new Dispatcher("42", ForkJoinPool.commonPool()));
  }

  /**
   * Method under test: {@link Dispatcher#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Dispatcher dispatcher = new Dispatcher("42", null);

    // Act and Assert
    assertNotEquals(dispatcher, new Dispatcher("42", ForkJoinPool.commonPool()));
  }

  /**
   * Method under test: {@link Dispatcher#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Dispatcher dispatcher = new Dispatcher("42", new ForkJoinPool());

    // Act and Assert
    assertNotEquals(dispatcher, new Dispatcher("42", ForkJoinPool.commonPool()));
  }

  /**
   * Method under test: {@link Dispatcher#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Dispatcher dispatcher = new Dispatcher("org.thingsboard.server.actors.Dispatcher",
        new ScheduledThreadPoolExecutor(1, mock(RejectedExecutionHandler.class)));

    // Act and Assert
    assertNotEquals(dispatcher, new Dispatcher("42", ForkJoinPool.commonPool()));
  }

  /**
   * Method under test: {@link Dispatcher#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Dispatcher("42", ForkJoinPool.commonPool()), null);
  }

  /**
   * Method under test: {@link Dispatcher#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Dispatcher("42", ForkJoinPool.commonPool()), "Different type to Dispatcher");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Dispatcher#Dispatcher(String, ExecutorService)}
   *   <li>{@link Dispatcher#toString()}
   *   <li>{@link Dispatcher#getDispatcherId()}
   *   <li>{@link Dispatcher#getExecutor()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ForkJoinPool executor = ForkJoinPool.commonPool();

    // Act
    Dispatcher actualDispatcher = new Dispatcher("42", executor);
    actualDispatcher.toString();
    String actualDispatcherId = actualDispatcher.getDispatcherId();

    // Assert
    assertEquals("42", actualDispatcherId);
    assertSame(executor, actualDispatcher.getExecutor());
  }
}
