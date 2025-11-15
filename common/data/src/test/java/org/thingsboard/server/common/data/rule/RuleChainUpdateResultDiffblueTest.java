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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RuleChainUpdateResultDiffblueTest {
  /**
   * Test {@link RuleChainUpdateResult#failed()}.
   * <p>
   * Method under test: {@link RuleChainUpdateResult#failed()}
   */
  @Test
  @DisplayName("Test failed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChainUpdateResult RuleChainUpdateResult.failed()"})
  void testFailed() {
    // Arrange and Act
    RuleChainUpdateResult actualFailedResult = RuleChainUpdateResult.failed();

    // Assert
    assertNull(actualFailedResult.getUpdatedRuleNodes());
    assertFalse(actualFailedResult.isSuccess());
  }

  /**
   * Test {@link RuleChainUpdateResult#successful(List)}.
   * <ul>
   *   <li>Then return UpdatedRuleNodes is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainUpdateResult#successful(List)}
   */
  @Test
  @DisplayName("Test successful(List); then return UpdatedRuleNodes is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChainUpdateResult RuleChainUpdateResult.successful(List)"})
  void testSuccessful_thenReturnUpdatedRuleNodesIsArrayList() {
    // Arrange
    ArrayList<RuleNodeUpdateResult> updatedRuleNodes = new ArrayList<>();
    RuleNode oldRuleNode = new RuleNode();
    updatedRuleNodes.add(new RuleNodeUpdateResult(oldRuleNode, new RuleNode()));

    // Act and Assert
    assertSame(updatedRuleNodes, RuleChainUpdateResult.successful(updatedRuleNodes).getUpdatedRuleNodes());
  }

  /**
   * Test {@link RuleChainUpdateResult#successful(List)}.
   * <ul>
   *   <li>Then return UpdatedRuleNodes size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainUpdateResult#successful(List)}
   */
  @Test
  @DisplayName("Test successful(List); then return UpdatedRuleNodes size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChainUpdateResult RuleChainUpdateResult.successful(List)"})
  void testSuccessful_thenReturnUpdatedRuleNodesSizeIsTwo() {
    // Arrange
    ArrayList<RuleNodeUpdateResult> updatedRuleNodes = new ArrayList<>();
    RuleNode oldRuleNode = new RuleNode();
    updatedRuleNodes.add(new RuleNodeUpdateResult(oldRuleNode, new RuleNode()));
    RuleNode oldRuleNode2 = new RuleNode();
    RuleNodeUpdateResult ruleNodeUpdateResult = new RuleNodeUpdateResult(oldRuleNode2, new RuleNode());

    updatedRuleNodes.add(ruleNodeUpdateResult);

    // Act and Assert
    List<RuleNodeUpdateResult> updatedRuleNodes2 = RuleChainUpdateResult.successful(updatedRuleNodes)
        .getUpdatedRuleNodes();
    assertEquals(2, updatedRuleNodes2.size());
    assertSame(ruleNodeUpdateResult, updatedRuleNodes2.get(1));
  }

  /**
   * Test {@link RuleChainUpdateResult#successful(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return UpdatedRuleNodes Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainUpdateResult#successful(List)}
   */
  @Test
  @DisplayName("Test successful(List); when ArrayList(); then return UpdatedRuleNodes Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RuleChainUpdateResult RuleChainUpdateResult.successful(List)"})
  void testSuccessful_whenArrayList_thenReturnUpdatedRuleNodesEmpty() {
    // Arrange and Act
    RuleChainUpdateResult actualSuccessfulResult = RuleChainUpdateResult.successful(new ArrayList<>());

    // Assert
    assertTrue(actualSuccessfulResult.getUpdatedRuleNodes().isEmpty());
    assertTrue(actualSuccessfulResult.isSuccess());
  }

  /**
   * Test {@link RuleChainUpdateResult#equals(Object)}, and {@link RuleChainUpdateResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainUpdateResult#equals(Object)}
   *   <li>{@link RuleChainUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainUpdateResult.equals(Object)", "int RuleChainUpdateResult.hashCode()"})
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
   * Test {@link RuleChainUpdateResult#equals(Object)}, and {@link RuleChainUpdateResult#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainUpdateResult#equals(Object)}
   *   <li>{@link RuleChainUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainUpdateResult.equals(Object)", "int RuleChainUpdateResult.hashCode()"})
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
   * Test {@link RuleChainUpdateResult#equals(Object)}, and {@link RuleChainUpdateResult#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainUpdateResult#equals(Object)}
   *   <li>{@link RuleChainUpdateResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainUpdateResult.equals(Object)", "int RuleChainUpdateResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainUpdateResult failedResult = RuleChainUpdateResult.failed();

    // Act and Assert
    assertEquals(failedResult, failedResult);
    int expectedHashCodeResult = failedResult.hashCode();
    assertEquals(expectedHashCodeResult, failedResult.hashCode());
  }

  /**
   * Test {@link RuleChainUpdateResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainUpdateResult.equals(Object)", "int RuleChainUpdateResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainUpdateResult successfulResult = RuleChainUpdateResult.successful(new ArrayList<>());

    // Act and Assert
    assertNotEquals(successfulResult, RuleChainUpdateResult.failed());
  }

  /**
   * Test {@link RuleChainUpdateResult#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainUpdateResult.equals(Object)", "int RuleChainUpdateResult.hashCode()"})
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
   * Test {@link RuleChainUpdateResult#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainUpdateResult.equals(Object)", "int RuleChainUpdateResult.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuleChainUpdateResult.failed(), null);
  }

  /**
   * Test {@link RuleChainUpdateResult#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleChainUpdateResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleChainUpdateResult.equals(Object)", "int RuleChainUpdateResult.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(RuleChainUpdateResult.failed(), "Different type to RuleChainUpdateResult");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleChainUpdateResult#toString()}
   *   <li>{@link RuleChainUpdateResult#getUpdatedRuleNodes()}
   *   <li>{@link RuleChainUpdateResult#isSuccess()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List RuleChainUpdateResult.getUpdatedRuleNodes()", "boolean RuleChainUpdateResult.isSuccess()",
      "String RuleChainUpdateResult.toString()"})
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
