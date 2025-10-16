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
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbQueueConsumerTemplate#poll(long)}
   */
  @Test
  @DisplayName("Test poll(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AbstractTbQueueConsumerTemplate.poll(long)"})
  void testPoll_thenReturnEmpty() {
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
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbQueueConsumerTemplate#isStopped()}
   */
  @Test
  @DisplayName("Test isStopped(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTbQueueConsumerTemplate.isStopped()"})
  void testIsStopped_thenReturnFalse() {
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
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbQueueConsumerTemplate#getFullTopicNames()}
   */
  @Test
  @DisplayName("Test getFullTopicNames(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AbstractTbQueueConsumerTemplate.getFullTopicNames()"})
  void testGetFullTopicNames_thenReturnEmpty() {
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
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbQueueConsumerTemplate#isLongPollingSupported()}
   */
  @Test
  @DisplayName("Test isLongPollingSupported(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTbQueueConsumerTemplate.isLongPollingSupported()"})
  void testIsLongPollingSupported_thenReturnFalse() {
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
   * <ul>
   *   <li>Then return {@code Topic}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbQueueConsumerTemplate#getTopic()}
   */
  @Test
  @DisplayName("Test getTopic(); then return 'Topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AbstractTbQueueConsumerTemplate.getTopic()"})
  void testGetTopic_thenReturnTopic() {
    // Arrange
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate =
        new TbServiceBusConsumerTemplate<>(
            null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act and Assert
    assertEquals("Topic", tbServiceBusConsumerTemplate.getTopic());
  }
}
