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
import org.junit.jupiter.api.Test;

class RuleEngineExceptionDiffblueTest {
  /**
   * Method under test: {@link RuleEngineException#RuleEngineException(String)}
   */
  @Test
  void testNewRuleEngineException() {
    // Arrange and Act
    RuleEngineException actualRuleEngineException = new RuleEngineException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualRuleEngineException.getLocalizedMessage());
    assertEquals("An error occurred", actualRuleEngineException.getMessage());
    assertNull(actualRuleEngineException.getCause());
    assertEquals(0, actualRuleEngineException.getSuppressed().length);
  }

  /**
   * Method under test: {@link RuleEngineException#toJsonString(int)}
   */
  @Test
  void testToJsonString() {
    // Arrange, Act and Assert
    assertEquals("{\"message\":\"An ...[truncated 14 symbols]\"}",
        (new RuleEngineException("An error occurred")).toJsonString(3));
    assertEquals("{\"message\":\"Not...[truncated 24 symbols]\"}",
        (new RuleEngineException("Not all who wander are lost")).toJsonString(3));
    assertEquals("{\"message\":\"42\"}", (new RuleEngineException("42")).toJsonString(3));
    assertEquals("{\"message\":\"An error occurred\"}", (new RuleEngineException("An error occurred")).toJsonString(0));
    assertEquals(
        "{\"ruleNodeId\":\"13814000-1dd2-11b2-8080-808080808080\",\"ruleChainId\":\"13814000-1dd2-11b2-8080-808080808080"
            + "\",\"ruleNodeName\":\"Unknown\",\"ruleChainName\":\"message\",\"message\":\"An ...[truncated 14 symbols]\"}",
        (new RuleNodeException("An error occurred", "message", null)).toJsonString(3));
    assertEquals("{\"ruleNodeId\":\"13814000-1dd2-11b2-8080-808080808080\",\"ruleChainId\":\"13814000-1dd2-11b2-8080"
        + "-808080808080\",\"ruleNodeName\":\"Unknown\",\"ruleChainName\":\"ruleNodeId\",\"message\":\"An ...[truncated"
        + " 14 symbols]\"}", (new RuleNodeException("An error occurred", "ruleNodeId", null)).toJsonString(3));
  }

  /**
   * Method under test:
   * {@link RuleEngineException#truncateIfNecessary(String, int)}
   */
  @Test
  void testTruncateIfNecessary() {
    // Arrange, Act and Assert
    assertEquals("An ...[truncated 14 symbols]",
        (new RuleEngineException("An error occurred")).truncateIfNecessary("An error occurred", 3));
    assertNull((new RuleEngineException("An error occurred")).truncateIfNecessary(null, 0));
    assertEquals("An error occurred",
        (new RuleEngineException("An error occurred")).truncateIfNecessary("An error occurred", 0));
    assertEquals("42", (new RuleEngineException("An error occurred")).truncateIfNecessary("42", 3));
  }

  /**
   * Method under test: {@link RuleEngineException#RuleEngineException(String)}
   */
  @Test
  void testNewRuleEngineException2() {
    // Arrange and Act
    RuleEngineException actualRuleEngineException = new RuleEngineException(null);

    // Assert
    assertNull(actualRuleEngineException.getCause());
    assertEquals(0, actualRuleEngineException.getSuppressed().length);
    assertEquals(RuleNodeException.UNKNOWN, actualRuleEngineException.getLocalizedMessage());
    assertEquals(RuleNodeException.UNKNOWN, actualRuleEngineException.getMessage());
  }

  /**
   * Method under test:
   * {@link RuleEngineException#RuleEngineException(String, Throwable)}
   */
  @Test
  void testNewRuleEngineException3() {
    // Arrange
    Throwable t = new Throwable();

    // Act
    RuleEngineException actualRuleEngineException = new RuleEngineException("An error occurred", t);

    // Assert
    assertEquals("An error occurred", actualRuleEngineException.getLocalizedMessage());
    assertEquals("An error occurred", actualRuleEngineException.getMessage());
    assertEquals(0, actualRuleEngineException.getSuppressed().length);
    assertSame(t, actualRuleEngineException.getCause());
  }

  /**
   * Method under test:
   * {@link RuleEngineException#RuleEngineException(String, Throwable)}
   */
  @Test
  void testNewRuleEngineException4() {
    // Arrange
    Throwable t = new Throwable();

    // Act
    RuleEngineException actualRuleEngineException = new RuleEngineException(null, t);

    // Assert
    assertEquals(0, actualRuleEngineException.getSuppressed().length);
    assertEquals(RuleNodeException.UNKNOWN, actualRuleEngineException.getLocalizedMessage());
    assertEquals(RuleNodeException.UNKNOWN, actualRuleEngineException.getMessage());
    assertSame(t, actualRuleEngineException.getCause());
  }
}
