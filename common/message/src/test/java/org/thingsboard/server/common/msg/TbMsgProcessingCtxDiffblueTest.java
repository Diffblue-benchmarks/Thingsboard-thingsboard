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
package org.thingsboard.server.common.msg;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;

class TbMsgProcessingCtxDiffblueTest {
  /**
   * Method under test: {@link TbMsgProcessingCtx#pop()}
   */
  @Test
  void testPop() {
    // Arrange, Act and Assert
    assertNull((new TbMsgProcessingCtx()).pop());
  }

  /**
   * Method under test: {@link TbMsgProcessingCtx#pop()}
   */
  @Test
  void testPop2() {
    // Arrange
    TbMsgProcessingCtx tbMsgProcessingCtx = new TbMsgProcessingCtx();
    RuleChainId ruleChainId = new RuleChainId(UUID.randomUUID());
    RuleNodeId ruleNodeId = new RuleNodeId(UUID.randomUUID());
    tbMsgProcessingCtx.push(ruleChainId, ruleNodeId);

    // Act
    TbMsgProcessingStackItem actualPopResult = tbMsgProcessingCtx.pop();

    // Assert
    assertSame(ruleChainId, actualPopResult.getRuleChainId());
    assertSame(ruleNodeId, actualPopResult.getRuleNodeId());
  }
}
