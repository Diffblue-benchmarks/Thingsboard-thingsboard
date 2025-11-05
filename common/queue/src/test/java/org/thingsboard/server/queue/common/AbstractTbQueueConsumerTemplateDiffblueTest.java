package org.thingsboard.server.queue.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.TbQueueMsgDecoder;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusConsumerTemplate;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings;

class AbstractTbQueueConsumerTemplateDiffblueTest {
  /**
   * Test {@link AbstractTbQueueConsumerTemplate#poll(long)}.
   *
   * <p>Method under test: {@link AbstractTbQueueConsumerTemplate#poll(long)}
   */
  @Test
  @DisplayName("Test poll(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AbstractTbQueueConsumerTemplate.poll(long)"})
  void testPoll() {
    // Arrange
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate =
        new TbServiceBusConsumerTemplate<>(
            null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act and Assert
    assertTrue(tbServiceBusConsumerTemplate.poll(1L).isEmpty());
  }

  /**
   * Test {@link AbstractTbQueueConsumerTemplate#stop()}.
   *
   * <p>Method under test: {@link AbstractTbQueueConsumerTemplate#stop()}
   */
  @Test
  @DisplayName("Test stop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbQueueConsumerTemplate.stop()"})
  void testStop() {
    // Arrange
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate =
        new TbServiceBusConsumerTemplate<>(
            null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbServiceBusConsumerTemplate.stop();

    // Assert
    assertTrue(tbServiceBusConsumerTemplate.isStopped());
  }

  /**
   * Test {@link AbstractTbQueueConsumerTemplate#unsubscribe()}.
   *
   * <p>Method under test: {@link AbstractTbQueueConsumerTemplate#unsubscribe()}
   */
  @Test
  @DisplayName("Test unsubscribe()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbQueueConsumerTemplate.unsubscribe()"})
  void testUnsubscribe() {
    // Arrange
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate =
        new TbServiceBusConsumerTemplate<>(
            null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbServiceBusConsumerTemplate.unsubscribe();

    // Assert
    assertTrue(tbServiceBusConsumerTemplate.isStopped());
  }

  /**
   * Test {@link AbstractTbQueueConsumerTemplate#isStopped()}.
   *
   * <p>Method under test: {@link AbstractTbQueueConsumerTemplate#isStopped()}
   */
  @Test
  @DisplayName("Test isStopped()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTbQueueConsumerTemplate.isStopped()"})
  void testIsStopped() {
    // Arrange
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate =
        new TbServiceBusConsumerTemplate<>(
            null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act and Assert
    assertFalse(tbServiceBusConsumerTemplate.isStopped());
  }

  /**
   * Test {@link AbstractTbQueueConsumerTemplate#getFullTopicNames()}.
   *
   * <p>Method under test: {@link AbstractTbQueueConsumerTemplate#getFullTopicNames()}
   */
  @Test
  @DisplayName("Test getFullTopicNames()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AbstractTbQueueConsumerTemplate.getFullTopicNames()"})
  void testGetFullTopicNames() {
    // Arrange
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate =
        new TbServiceBusConsumerTemplate<>(
            null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act and Assert
    assertTrue(tbServiceBusConsumerTemplate.getFullTopicNames().isEmpty());
  }

  /**
   * Test {@link AbstractTbQueueConsumerTemplate#isLongPollingSupported()}.
   *
   * <p>Method under test: {@link AbstractTbQueueConsumerTemplate#isLongPollingSupported()}
   */
  @Test
  @DisplayName("Test isLongPollingSupported()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTbQueueConsumerTemplate.isLongPollingSupported()"})
  void testIsLongPollingSupported() {
    // Arrange
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate =
        new TbServiceBusConsumerTemplate<>(
            null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act and Assert
    assertFalse(tbServiceBusConsumerTemplate.isLongPollingSupported());
  }

  /**
   * Test {@link AbstractTbQueueConsumerTemplate#getTopic()}.
   *
   * <p>Method under test: {@link AbstractTbQueueConsumerTemplate#getTopic()}
   */
  @Test
  @DisplayName("Test getTopic()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AbstractTbQueueConsumerTemplate.getTopic()"})
  void testGetTopic() {
    // Arrange
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate =
        new TbServiceBusConsumerTemplate<>(
            null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act and Assert
    assertEquals("Topic", tbServiceBusConsumerTemplate.getTopic());
  }
}
