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
package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TbRuleEngineProducerProviderDiffblueTest {
  @InjectMocks
  private TbRuleEngineProducerProvider tbRuleEngineProducerProvider;

  /**
   * Test {@link TbRuleEngineProducerProvider#getTbVersionControlMsgProducer()}.
   * <p>
   * Method under test: {@link TbRuleEngineProducerProvider#getTbVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbVersionControlMsgProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.server.queue.TbQueueProducer TbRuleEngineProducerProvider.getTbVersionControlMsgProducer()"})
  void testGetTbVersionControlMsgProducer() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> tbRuleEngineProducerProvider.getTbVersionControlMsgProducer());
  }
}
