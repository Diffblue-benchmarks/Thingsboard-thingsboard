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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.rule.RuleNode;

class RuleNodeExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeException#getRuleChainId()}
   *   <li>{@link RuleNodeException#getRuleChainName()}
   *   <li>{@link RuleNodeException#getRuleNodeId()}
   *   <li>{@link RuleNodeException#getRuleNodeName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    RuleNodeException ruleNodeException = new RuleNodeException("An error occurred", "Rule Chain Name", new RuleNode());

    // Act
    RuleChainId actualRuleChainId = ruleNodeException.getRuleChainId();
    String actualRuleChainName = ruleNodeException.getRuleChainName();
    RuleNodeId actualRuleNodeId = ruleNodeException.getRuleNodeId();

    // Assert
    assertEquals("Rule Chain Name", actualRuleChainName);
    assertNull(ruleNodeException.getRuleNodeName());
    assertNull(actualRuleChainId);
    assertNull(actualRuleNodeId);
  }

  /**
   * Method under test: {@link RuleNodeException#toJsonString(int)}
   */
  @Test
  void testToJsonString() {
    // Arrange, Act and Assert
    assertEquals(
        "{\"ruleNodeId\":\"13814000-1dd2-11b2-8080-808080808080\",\"ruleChainId\":\"13814000-1dd2-11b2-8080-808080808080"
            + "\",\"ruleNodeName\":\"Unknown\",\"ruleChainName\":\"Rule Chain Name\",\"message\":\"An ...[truncated 14"
            + " symbols]\"}",
        (new RuleNodeException("An error occurred", "Rule Chain Name", null)).toJsonString(3));
    assertEquals(
        "{\"ruleNodeId\":\"13814000-1dd2-11b2-8080-808080808080\",\"ruleChainId\":\"13814000-1dd2-11b2-8080-808080808080"
            + "\",\"ruleNodeName\":\"Unknown\",\"ruleChainName\":\"Rule Chain Name\",\"message\":\"42\"}",
        (new RuleNodeException("42", "Rule Chain Name", null)).toJsonString(3));
    assertEquals(
        "{\"ruleNodeId\":\"13814000-1dd2-11b2-8080-808080808080\",\"ruleChainId\":\"13814000-1dd2-11b2-8080-808080808080"
            + "\",\"ruleNodeName\":\"Unknown\",\"ruleChainName\":\"Rule Chain Name\",\"message\":\"An error occurred\"}",
        (new RuleNodeException("An error occurred", "Rule Chain Name", null)).toJsonString(0));
  }

  /**
   * Method under test:
   * {@link RuleNodeException#RuleNodeException(String, String, RuleNode)}
   */
  @Test
  void testNewRuleNodeException() {
    // Arrange and Act
    RuleNodeException actualRuleNodeException = new RuleNodeException("An error occurred", "Rule Chain Name",
        new RuleNode());

    // Assert
    assertEquals("An error occurred", actualRuleNodeException.getLocalizedMessage());
    assertEquals("An error occurred", actualRuleNodeException.getMessage());
    assertEquals("Rule Chain Name", actualRuleNodeException.getRuleChainName());
    assertNull(actualRuleNodeException.getRuleNodeName());
    assertNull(actualRuleNodeException.getCause());
    assertNull(actualRuleNodeException.getRuleChainId());
    assertNull(actualRuleNodeException.getRuleNodeId());
    assertEquals(0, actualRuleNodeException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link RuleNodeException#RuleNodeException(String, String, RuleNode)}
   */
  @Test
  void testNewRuleNodeException2() {
    // Arrange and Act
    RuleNodeException actualRuleNodeException = new RuleNodeException(null, "Rule Chain Name", null);

    // Assert
    RuleChainId ruleChainId = actualRuleNodeException.getRuleChainId();
    UUID id = ruleChainId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("Rule Chain Name", actualRuleNodeException.getRuleChainName());
    assertNull(actualRuleNodeException.getCause());
    assertEquals(0, actualRuleNodeException.getSuppressed().length);
    assertEquals(EntityType.RULE_CHAIN, ruleChainId.getEntityType());
    RuleNodeId ruleNodeId = actualRuleNodeException.getRuleNodeId();
    assertEquals(EntityType.RULE_NODE, ruleNodeId.getEntityType());
    assertTrue(ruleChainId.isNullUid());
    assertTrue(ruleNodeId.isNullUid());
    assertEquals(RuleNodeException.UNKNOWN, actualRuleNodeException.getLocalizedMessage());
    assertEquals(RuleNodeException.UNKNOWN, actualRuleNodeException.getMessage());
    assertEquals(RuleNodeException.UNKNOWN, actualRuleNodeException.getRuleNodeName());
    assertSame(id, ruleNodeId.getId());
  }
}
