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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.queue.TbQueueAdmin;
import org.thingsboard.server.queue.TbQueueMsg;

@ExtendWith(MockitoExtension.class)
class TbPubSubProducerTemplateDiffblueTest {
  @Mock
  private TbPubSubSettings tbPubSubSettings;

  @Mock
  private TbQueueAdmin tbQueueAdmin;

  /**
   * Test {@link TbPubSubProducerTemplate#TbPubSubProducerTemplate(TbQueueAdmin, TbPubSubSettings, String)}.
   * <p>
   * Method under test: {@link TbPubSubProducerTemplate#TbPubSubProducerTemplate(TbQueueAdmin, TbPubSubSettings, String)}
   */
  @Test
  @DisplayName("Test new TbPubSubProducerTemplate(TbQueueAdmin, TbPubSubSettings, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbPubSubProducerTemplate.<init>(TbQueueAdmin, TbPubSubSettings, String)"})
  void testNewTbPubSubProducerTemplate() {
    // Arrange and Act
    TbPubSubProducerTemplate<TbQueueMsg> actualTbPubSubProducerTemplate = new TbPubSubProducerTemplate<>(tbQueueAdmin,
        tbPubSubSettings, "Default Topic");

    // Assert
    assertEquals("Default Topic", actualTbPubSubProducerTemplate.getDefaultTopic());
  }
}
