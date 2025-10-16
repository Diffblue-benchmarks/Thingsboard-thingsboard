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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleNodeId;

class RuleNodeInfoDiffblueTest {
  /**
   * Test {@link RuleNodeInfo#RuleNodeInfo(RuleNodeId, String, String)}.
   *
   * <p>Method under test: {@link RuleNodeInfo#RuleNodeInfo(RuleNodeId, String, String)}
   */
  @Test
  @DisplayName("Test new RuleNodeInfo(RuleNodeId, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeInfo.<init>(RuleNodeId, String, String)"})
  void testNewRuleNodeInfo() {
    // Arrange
    RuleNodeId id = new RuleNodeId(UUID.randomUUID());

    // Act
    RuleNodeInfo actualRuleNodeInfo = new RuleNodeInfo(id, "Rule Chain Name", "Rule Node Name");

    // Assert
    assertSame(id, actualRuleNodeInfo.getRuleNodeId());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeInfo#getRuleNodeId()}
   *   <li>{@link RuleNodeInfo#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeId RuleNodeInfo.getRuleNodeId()", "String RuleNodeInfo.toString()"})
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
}
