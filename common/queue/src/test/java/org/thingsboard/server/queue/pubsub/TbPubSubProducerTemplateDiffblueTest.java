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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueAdmin;
import org.thingsboard.server.queue.TbQueueMsg;

class TbPubSubProducerTemplateDiffblueTest {
  /**
   * Method under test:
   * {@link TbPubSubProducerTemplate#TbPubSubProducerTemplate(TbQueueAdmin, TbPubSubSettings, String)}
   */
  @Test
  void testNewTbPubSubProducerTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TbPubSubProducerTemplate<TbQueueMsg> actualTbPubSubProducerTemplate = new TbPubSubProducerTemplate<>(null,
        new TbPubSubSettings(), "Default Topic");

    // Assert
    assertEquals("Default Topic", actualTbPubSubProducerTemplate.getDefaultTopic());
  }

  /**
   * Method under test:
   * {@link TbPubSubProducerTemplate#TbPubSubProducerTemplate(TbQueueAdmin, TbPubSubSettings, String)}
   */
  @Test
  void testNewTbPubSubProducerTemplate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbPubSubAdmin admin = mock(TbPubSubAdmin.class);

    // Act
    TbPubSubProducerTemplate<TbQueueMsg> actualTbPubSubProducerTemplate = new TbPubSubProducerTemplate<>(admin,
        new TbPubSubSettings(), "Default Topic");

    // Assert
    assertEquals("Default Topic", actualTbPubSubProducerTemplate.getDefaultTopic());
  }
}
