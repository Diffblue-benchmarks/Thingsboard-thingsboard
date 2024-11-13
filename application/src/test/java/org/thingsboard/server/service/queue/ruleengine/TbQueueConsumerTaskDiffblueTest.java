package org.thingsboard.server.service.queue.ruleengine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueConsumer;
import org.thingsboard.server.queue.TbQueueMsg;

class TbQueueConsumerTaskDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueConsumerTask#TbQueueConsumerTask(Object, Supplier)}
   *   <li>{@link TbQueueConsumerTask#setTask(Future)}
   *   <li>{@link TbQueueConsumerTask#getKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbQueueConsumerTask<TbQueueMsg> actualTbQueueConsumerTask = new TbQueueConsumerTask<>("Key", mock(Supplier.class));
    actualTbQueueConsumerTask.setTask(new CompletableFuture<>());

    // Assert that nothing has changed
    assertEquals("Key", actualTbQueueConsumerTask.getKey());
  }

  /**
   * Test {@link TbQueueConsumerTask#isRunning()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueConsumerTask#isRunning()}
   */
  @Test
  @DisplayName("Test isRunning(); then return 'false'")
  void testIsRunning_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbQueueConsumerTask<TbQueueMsg> tbQueueConsumerTask = new TbQueueConsumerTask<>("Key", mock(Supplier.class));

    // Act and Assert
    assertFalse(tbQueueConsumerTask.isRunning());
  }

  /**
   * Test {@link TbQueueConsumerTask#isRunning()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbQueueConsumerTask#isRunning()}
   */
  @Test
  @DisplayName("Test isRunning(); then return 'true'")
  void testIsRunning_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbQueueConsumerTask<TbQueueMsg> tbQueueConsumerTask = new TbQueueConsumerTask<>("Key", mock(Supplier.class));
    tbQueueConsumerTask.setTask(new CompletableFuture<>());

    // Act and Assert
    assertTrue(tbQueueConsumerTask.isRunning());
  }
}
