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
package org.thingsboard.server.queue.pubsub;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.gax.core.CredentialsProvider;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueAdmin;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.TbQueueMsgDecoder;

class TbPubSubConsumerTemplateDiffblueTest {
  /**
   * Method under test:
   * {@link TbPubSubConsumerTemplate#TbPubSubConsumerTemplate(TbQueueAdmin, TbPubSubSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  void testNewTbPubSubConsumerTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbPubSubSettings pubSubSettings = mock(TbPubSubSettings.class);
    when(pubSubSettings.getMaxMsgSize()).thenThrow(new RuntimeException("foo"));
    when(pubSubSettings.getCredentialsProvider()).thenReturn(mock(CredentialsProvider.class));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> new TbPubSubConsumerTemplate<>(null, pubSubSettings, "Topic", mock(TbQueueMsgDecoder.class)));

    verify(pubSubSettings).getCredentialsProvider();
    verify(pubSubSettings).getMaxMsgSize();
  }
}
