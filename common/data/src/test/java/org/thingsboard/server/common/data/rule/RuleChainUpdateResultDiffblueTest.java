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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RuleChainUpdateResultDiffblueTest {
  /**
   * Method under test: {@link RuleChainUpdateResult#failed()}
   */
  @Test
  void testFailed() {
    // Arrange and Act
    RuleChainUpdateResult actualFailedResult = RuleChainUpdateResult.failed();

    // Assert
    assertNull(actualFailedResult.getUpdatedRuleNodes());
    assertFalse(actualFailedResult.isSuccess());
  }

  /**
   * Method under test: {@link RuleChainUpdateResult#successful(List)}
   */
  @Test
  void testSuccessful() {
    // Arrange
    ArrayList<RuleNodeUpdateResult> updatedRuleNodes = new ArrayList<>();

    // Act
    RuleChainUpdateResult actualSuccessfulResult = RuleChainUpdateResult.successful(updatedRuleNodes);

    // Assert
    List<RuleNodeUpdateResult> updatedRuleNodes2 = actualSuccessfulResult.getUpdatedRuleNodes();
    assertTrue(updatedRuleNodes2.isEmpty());
    assertTrue(actualSuccessfulResult.isSuccess());
    assertSame(updatedRuleNodes, updatedRuleNodes2);
  }

  /**
   * Method under test: {@link RuleChainUpdateResult#successful(List)}
   */
  @Test
  void testSuccessful2() {
    // Arrange
    ArrayList<RuleNodeUpdateResult> updatedRuleNodes = new ArrayList<>();
    RuleNode oldRuleNode = new RuleNode();
    updatedRuleNodes.add(new RuleNodeUpdateResult(oldRuleNode, new RuleNode()));

    // Act
    RuleChainUpdateResult actualSuccessfulResult = RuleChainUpdateResult.successful(updatedRuleNodes);

    // Assert
    assertTrue(actualSuccessfulResult.isSuccess());
    assertSame(updatedRuleNodes, actualSuccessfulResult.getUpdatedRuleNodes());
  }

  /**
   * Method under test: {@link RuleChainUpdateResult#successful(List)}
   */
  @Test
  void testSuccessful3() {
    // Arrange
    ArrayList<RuleNodeUpdateResult> updatedRuleNodes = new ArrayList<>();
    RuleNode oldRuleNode = new RuleNode();
    updatedRuleNodes.add(new RuleNodeUpdateResult(oldRuleNode, new RuleNode()));
    RuleNode oldRuleNode2 = new RuleNode();
    updatedRuleNodes.add(new RuleNodeUpdateResult(oldRuleNode2, new RuleNode()));

    // Act
    RuleChainUpdateResult actualSuccessfulResult = RuleChainUpdateResult.successful(updatedRuleNodes);

    // Assert
    assertTrue(actualSuccessfulResult.isSuccess());
    assertSame(updatedRuleNodes, actualSuccessfulResult.getUpdatedRuleNodes());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainUpdateResult#equals(Object)}
   *   <li>{@link RuleChainUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainUpdateResult failedResult = RuleChainUpdateResult.failed();
    RuleChainUpdateResult failedResult2 = RuleChainUpdateResult.failed();

    // Act and Assert
    assertEquals(failedResult, failedResult2);
    int expectedHashCodeResult = failedResult.hashCode();
    assertEquals(expectedHashCodeResult, failedResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainUpdateResult#equals(Object)}
   *   <li>{@link RuleChainUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleChainUpdateResult successfulResult = RuleChainUpdateResult.successful(new ArrayList<>());
    RuleChainUpdateResult successfulResult2 = RuleChainUpdateResult.successful(new ArrayList<>());

    // Act and Assert
    assertEquals(successfulResult, successfulResult2);
    int expectedHashCodeResult = successfulResult.hashCode();
    assertEquals(expectedHashCodeResult, successfulResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainUpdateResult#equals(Object)}
   *   <li>{@link RuleChainUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainUpdateResult failedResult = RuleChainUpdateResult.failed();

    // Act and Assert
    assertEquals(failedResult, failedResult);
    int expectedHashCodeResult = failedResult.hashCode();
    assertEquals(expectedHashCodeResult, failedResult.hashCode());
  }

  /**
   * Method under test: {@link RuleChainUpdateResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainUpdateResult successfulResult = RuleChainUpdateResult.successful(new ArrayList<>());

    // Act and Assert
    assertNotEquals(successfulResult, RuleChainUpdateResult.failed());
  }

  /**
   * Method under test: {@link RuleChainUpdateResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<RuleNodeUpdateResult> updatedRuleNodes = new ArrayList<>();
    RuleNode oldRuleNode = new RuleNode();
    updatedRuleNodes.add(new RuleNodeUpdateResult(oldRuleNode, new RuleNode()));
    RuleChainUpdateResult successfulResult = RuleChainUpdateResult.successful(updatedRuleNodes);

    // Act and Assert
    assertNotEquals(successfulResult, RuleChainUpdateResult.successful(new ArrayList<>()));
  }

  /**
   * Method under test: {@link RuleChainUpdateResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<RuleNodeUpdateResult> updatedRuleNodes = new ArrayList<>();
    RuleNode oldRuleNode = mock(RuleNode.class);
    updatedRuleNodes.add(new RuleNodeUpdateResult(oldRuleNode, new RuleNode()));
    RuleChainUpdateResult successfulResult = RuleChainUpdateResult.successful(updatedRuleNodes);

    // Act and Assert
    assertNotEquals(successfulResult, RuleChainUpdateResult.successful(new ArrayList<>()));
  }

  /**
   * Method under test: {@link RuleChainUpdateResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuleChainUpdateResult.failed(), null);
  }

  /**
   * Method under test: {@link RuleChainUpdateResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuleChainUpdateResult.failed(), "Different type to RuleChainUpdateResult");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainUpdateResult#toString()}
   *   <li>{@link RuleChainUpdateResult#getUpdatedRuleNodes()}
   *   <li>{@link RuleChainUpdateResult#isSuccess()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    RuleChainUpdateResult failedResult = RuleChainUpdateResult.failed();

    // Act
    String actualToStringResult = failedResult.toString();
    List<RuleNodeUpdateResult> actualUpdatedRuleNodes = failedResult.getUpdatedRuleNodes();

    // Assert
    assertEquals("RuleChainUpdateResult(success=false, updatedRuleNodes=null)", actualToStringResult);
    assertNull(actualUpdatedRuleNodes);
    assertFalse(failedResult.isSuccess());
  }
}
