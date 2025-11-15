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
package org.thingsboard.server.common.data.rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleNodeId;

class RuleNodeUpdateResultDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeUpdateResult#equals(Object)}
   *   <li>{@link RuleNodeUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleNode oldRuleNode = new RuleNode();
    RuleNodeUpdateResult ruleNodeUpdateResult = new RuleNodeUpdateResult(oldRuleNode, new RuleNode());
    RuleNode oldRuleNode2 = new RuleNode();
    RuleNodeUpdateResult ruleNodeUpdateResult2 = new RuleNodeUpdateResult(oldRuleNode2, new RuleNode());

    // Act and Assert
    assertEquals(ruleNodeUpdateResult, ruleNodeUpdateResult2);
    int expectedHashCodeResult = ruleNodeUpdateResult.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeUpdateResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeUpdateResult#equals(Object)}
   *   <li>{@link RuleNodeUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleNodeUpdateResult ruleNodeUpdateResult = new RuleNodeUpdateResult(null, new RuleNode());
    RuleNodeUpdateResult ruleNodeUpdateResult2 = new RuleNodeUpdateResult(null, new RuleNode());

    // Act and Assert
    assertEquals(ruleNodeUpdateResult, ruleNodeUpdateResult2);
    int expectedHashCodeResult = ruleNodeUpdateResult.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeUpdateResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeUpdateResult#equals(Object)}
   *   <li>{@link RuleNodeUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RuleNodeUpdateResult ruleNodeUpdateResult = new RuleNodeUpdateResult(new RuleNode(), null);
    RuleNodeUpdateResult ruleNodeUpdateResult2 = new RuleNodeUpdateResult(new RuleNode(), null);

    // Act and Assert
    assertEquals(ruleNodeUpdateResult, ruleNodeUpdateResult2);
    int expectedHashCodeResult = ruleNodeUpdateResult.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeUpdateResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeUpdateResult#equals(Object)}
   *   <li>{@link RuleNodeUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleNode oldRuleNode = new RuleNode();
    RuleNodeUpdateResult ruleNodeUpdateResult = new RuleNodeUpdateResult(oldRuleNode, new RuleNode());

    // Act and Assert
    assertEquals(ruleNodeUpdateResult, ruleNodeUpdateResult);
    int expectedHashCodeResult = ruleNodeUpdateResult.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeUpdateResult.hashCode());
  }

  /**
   * Method under test: {@link RuleNodeUpdateResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNodeUpdateResult ruleNodeUpdateResult = new RuleNodeUpdateResult(null, new RuleNode());
    RuleNode oldRuleNode = new RuleNode();

    // Act and Assert
    assertNotEquals(ruleNodeUpdateResult, new RuleNodeUpdateResult(oldRuleNode, new RuleNode()));
  }

  /**
   * Method under test: {@link RuleNodeUpdateResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleNode oldRuleNode = new RuleNode(new RuleNodeId(EntityId.NULL_UUID));
    RuleNodeUpdateResult ruleNodeUpdateResult = new RuleNodeUpdateResult(oldRuleNode, new RuleNode());
    RuleNode oldRuleNode2 = new RuleNode();

    // Act and Assert
    assertNotEquals(ruleNodeUpdateResult, new RuleNodeUpdateResult(oldRuleNode2, new RuleNode()));
  }

  /**
   * Method under test: {@link RuleNodeUpdateResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNode oldRuleNode = mock(RuleNode.class);
    RuleNodeUpdateResult ruleNodeUpdateResult = new RuleNodeUpdateResult(oldRuleNode, new RuleNode());
    RuleNode oldRuleNode2 = new RuleNode();

    // Act and Assert
    assertNotEquals(ruleNodeUpdateResult, new RuleNodeUpdateResult(oldRuleNode2, new RuleNode()));
  }

  /**
   * Method under test: {@link RuleNodeUpdateResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleNodeUpdateResult ruleNodeUpdateResult = new RuleNodeUpdateResult(new RuleNode(), null);
    RuleNode oldRuleNode = new RuleNode();

    // Act and Assert
    assertNotEquals(ruleNodeUpdateResult, new RuleNodeUpdateResult(oldRuleNode, new RuleNode()));
  }

  /**
   * Method under test: {@link RuleNodeUpdateResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleNode oldRuleNode = new RuleNode();
    RuleNodeUpdateResult ruleNodeUpdateResult = new RuleNodeUpdateResult(oldRuleNode,
        new RuleNode(new RuleNodeId(EntityId.NULL_UUID)));
    RuleNode oldRuleNode2 = new RuleNode();

    // Act and Assert
    assertNotEquals(ruleNodeUpdateResult, new RuleNodeUpdateResult(oldRuleNode2, new RuleNode()));
  }

  /**
   * Method under test: {@link RuleNodeUpdateResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleNode oldRuleNode = new RuleNode();

    // Act and Assert
    assertNotEquals(new RuleNodeUpdateResult(oldRuleNode, new RuleNode()), null);
  }

  /**
   * Method under test: {@link RuleNodeUpdateResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleNode oldRuleNode = new RuleNode();

    // Act and Assert
    assertNotEquals(new RuleNodeUpdateResult(oldRuleNode, new RuleNode()), "Different type to RuleNodeUpdateResult");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeUpdateResult#RuleNodeUpdateResult(RuleNode, RuleNode)}
   *   <li>{@link RuleNodeUpdateResult#toString()}
   *   <li>{@link RuleNodeUpdateResult#getNewRuleNode()}
   *   <li>{@link RuleNodeUpdateResult#getOldRuleNode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    RuleNode oldRuleNode = new RuleNode();
    RuleNode newRuleNode = new RuleNode();

    // Act
    RuleNodeUpdateResult actualRuleNodeUpdateResult = new RuleNodeUpdateResult(oldRuleNode, newRuleNode);
    String actualToStringResult = actualRuleNodeUpdateResult.toString();
    RuleNode actualNewRuleNode = actualRuleNodeUpdateResult.getNewRuleNode();

    // Assert
    assertEquals("RuleNodeUpdateResult(oldRuleNode=RuleNode(ruleChainId=null, type=null, name=null, debugMode=false,"
        + " singletonMode=false, queueName=null, configurationVersion=0, configuration=null, configurationBytes=null,"
        + " externalId=null), newRuleNode=RuleNode(ruleChainId=null, type=null, name=null, debugMode=false,"
        + " singletonMode=false, queueName=null, configurationVersion=0, configuration=null, configurationBytes=null,"
        + " externalId=null))", actualToStringResult);
    assertSame(newRuleNode, actualNewRuleNode);
    assertSame(oldRuleNode, actualRuleNodeUpdateResult.getOldRuleNode());
  }
}
