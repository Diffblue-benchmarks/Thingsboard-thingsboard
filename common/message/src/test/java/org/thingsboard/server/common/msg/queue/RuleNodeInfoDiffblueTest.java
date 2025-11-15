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
package org.thingsboard.server.common.msg.queue;

import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleNodeId;

class RuleNodeInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeInfo#getRuleNodeId()}
   *   <li>{@link RuleNodeInfo#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    RuleNodeId id = new RuleNodeId(UUID.randomUUID());
    RuleNodeInfo ruleNodeInfo = new RuleNodeInfo(id, "Rule Chain Name", "Rule Node Name");

    // Act
    RuleNodeId actualRuleNodeId = ruleNodeInfo.getRuleNodeId();
    ruleNodeInfo.toString();

    // Assert
    assertSame(id, actualRuleNodeId);
  }

  /**
   * Method under test:
   * {@link RuleNodeInfo#RuleNodeInfo(RuleNodeId, String, String)}
   */
  @Test
  void testNewRuleNodeInfo() {
    // Arrange
    RuleNodeId id = new RuleNodeId(UUID.randomUUID());

    // Act and Assert
    assertSame(id, (new RuleNodeInfo(id, "Rule Chain Name", "Rule Node Name")).getRuleNodeId());
  }
}
