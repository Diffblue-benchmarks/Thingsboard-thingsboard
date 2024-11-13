package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DispatcherDiffblueTest {
  /**
   * Test {@link Dispatcher#equals(Object)}, and {@link Dispatcher#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Dispatcher#equals(Object)}
   *   <li>{@link Dispatcher#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link Dispatcher#equals(Object)}, and {@link Dispatcher#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Dispatcher#equals(Object)}
   *   <li>{@link Dispatcher#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link Dispatcher#equals(Object)}, and {@link Dispatcher#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Dispatcher#equals(Object)}
   *   <li>{@link Dispatcher#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link Dispatcher#equals(Object)}, and {@link Dispatcher#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Dispatcher#equals(Object)}
   *   <li>{@link Dispatcher#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Dispatcher dispatcher = new Dispatcher("42", ForkJoinPool.commonPool());

    // Act and Assert
    assertEquals(dispatcher, dispatcher);
    int expectedHashCodeResult = dispatcher.hashCode();
    assertEquals(expectedHashCodeResult, dispatcher.hashCode());
  }

  /**
   * Test {@link Dispatcher#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dispatcher#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Dispatcher dispatcher = new Dispatcher("Dispatcher Id", ForkJoinPool.commonPool());

    // Act and Assert
    assertNotEquals(dispatcher, new Dispatcher("42", ForkJoinPool.commonPool()));
  }

  /**
   * Test {@link Dispatcher#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dispatcher#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Dispatcher dispatcher = new Dispatcher(null, ForkJoinPool.commonPool());

    // Act and Assert
    assertNotEquals(dispatcher, new Dispatcher("42", ForkJoinPool.commonPool()));
  }

  /**
   * Test {@link Dispatcher#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dispatcher#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Dispatcher dispatcher = new Dispatcher("42", null);

    // Act and Assert
    assertNotEquals(dispatcher, new Dispatcher("42", ForkJoinPool.commonPool()));
  }

  /**
   * Test {@link Dispatcher#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dispatcher#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Dispatcher dispatcher = new Dispatcher("42", new ForkJoinPool());

    // Act and Assert
    assertNotEquals(dispatcher, new Dispatcher("42", ForkJoinPool.commonPool()));
  }

  /**
   * Test {@link Dispatcher#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dispatcher#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Dispatcher dispatcher = new Dispatcher("org.thingsboard.server.actors.Dispatcher",
        new ScheduledThreadPoolExecutor(1, mock(RejectedExecutionHandler.class)));

    // Act and Assert
    assertNotEquals(dispatcher, new Dispatcher("42", ForkJoinPool.commonPool()));
  }

  /**
   * Test {@link Dispatcher#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dispatcher#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Dispatcher("42", ForkJoinPool.commonPool()), null);
  }

  /**
   * Test {@link Dispatcher#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dispatcher#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Dispatcher("42", ForkJoinPool.commonPool()), "Different type to Dispatcher");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Dispatcher#Dispatcher(String, ExecutorService)}
   *   <li>{@link Dispatcher#toString()}
   *   <li>{@link Dispatcher#getDispatcherId()}
   *   <li>{@link Dispatcher#getExecutor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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
