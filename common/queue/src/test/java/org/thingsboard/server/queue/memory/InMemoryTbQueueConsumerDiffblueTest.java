package org.thingsboard.server.queue.memory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueMsg;

class InMemoryTbQueueConsumerDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InMemoryTbQueueConsumer#InMemoryTbQueueConsumer(InMemoryStorage, String)}
   *   <li>{@link InMemoryTbQueueConsumer#commit()}
   *   <li>{@link InMemoryTbQueueConsumer#stop()}
   *   <li>{@link InMemoryTbQueueConsumer#getTopic()}
   *   <li>{@link InMemoryTbQueueConsumer#isStopped()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InMemoryTbQueueConsumer.<init>(InMemoryStorage, String)",
      "void InMemoryTbQueueConsumer.commit()", "String InMemoryTbQueueConsumer.getTopic()",
      "boolean InMemoryTbQueueConsumer.isStopped()", "void InMemoryTbQueueConsumer.stop()"})
  void testGettersAndSetters() {
    // Arrange and Act
    InMemoryTbQueueConsumer<TbQueueMsg> actualInMemoryTbQueueConsumer = new InMemoryTbQueueConsumer<>(
        new DefaultInMemoryStorage(), "Topic");
    actualInMemoryTbQueueConsumer.commit();
    actualInMemoryTbQueueConsumer.stop();
    String actualTopic = actualInMemoryTbQueueConsumer.getTopic();

    // Assert
    assertEquals("Topic", actualTopic);
    assertTrue(actualInMemoryTbQueueConsumer.isStopped());
  }

  /**
   * Test {@link InMemoryTbQueueConsumer#subscribe()}.
   * <p>
   * Method under test: {@link InMemoryTbQueueConsumer#subscribe()}
   */
  @Test
  @DisplayName("Test subscribe()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void InMemoryTbQueueConsumer.subscribe()"})
  void testSubscribe() {
    // Arrange
    InMemoryTbQueueConsumer<TbQueueMsg> inMemoryTbQueueConsumer = new InMemoryTbQueueConsumer<>(
        new DefaultInMemoryStorage(), "Topic");

    // Act
    inMemoryTbQueueConsumer.subscribe();

    // Assert
    List<String> fullTopicNames = inMemoryTbQueueConsumer.getFullTopicNames();
    assertEquals(1, fullTopicNames.size());
    assertEquals("Topic", fullTopicNames.get(0));
  }

  /**
   * Test {@link InMemoryTbQueueConsumer#poll(long)}.
   * <p>
   * Method under test: {@link InMemoryTbQueueConsumer#poll(long)}
   */
  @Test
  @DisplayName("Test poll(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List InMemoryTbQueueConsumer.poll(long)"})
  void testPoll() {
    // Arrange
    InMemoryTbQueueConsumer<TbQueueMsg> inMemoryTbQueueConsumer = new InMemoryTbQueueConsumer<>(
        new DefaultInMemoryStorage(), "Topic");

    // Act and Assert
    assertTrue(inMemoryTbQueueConsumer.poll(1L).isEmpty());
  }
}
