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
package org.thingsboard.server.queue.azure.servicebus;

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
class TbServiceBusProducerTemplateDiffblueTest {
  @Mock
  private TbQueueAdmin tbQueueAdmin;

  @Mock
  private TbServiceBusSettings tbServiceBusSettings;

  /**
   * Test {@link TbServiceBusProducerTemplate#TbServiceBusProducerTemplate(TbQueueAdmin, TbServiceBusSettings, String)}.
   * <p>
   * Method under test: {@link TbServiceBusProducerTemplate#TbServiceBusProducerTemplate(TbQueueAdmin, TbServiceBusSettings, String)}
   */
  @Test
  @DisplayName("Test new TbServiceBusProducerTemplate(TbQueueAdmin, TbServiceBusSettings, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbServiceBusProducerTemplate.<init>(TbQueueAdmin, TbServiceBusSettings, String)"})
  void testNewTbServiceBusProducerTemplate() {
    // Arrange and Act
    TbServiceBusProducerTemplate<TbQueueMsg> actualTbServiceBusProducerTemplate = new TbServiceBusProducerTemplate<>(
        tbQueueAdmin, tbServiceBusSettings, "Default Topic");

    // Assert
    assertEquals("Default Topic", actualTbServiceBusProducerTemplate.getDefaultTopic());
  }
}
