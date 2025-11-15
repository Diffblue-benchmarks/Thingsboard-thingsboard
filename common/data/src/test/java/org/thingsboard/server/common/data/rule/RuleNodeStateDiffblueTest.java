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
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;

class RuleNodeStateDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeState#equals(Object)}
   *   <li>{@link RuleNodeState#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    RuleNodeState ruleNodeState2 = new RuleNodeState();

    // Act and Assert
    assertEquals(ruleNodeState, ruleNodeState2);
    int expectedHashCodeResult = ruleNodeState.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeState2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeState#equals(Object)}
   *   <li>{@link RuleNodeState#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));

    RuleNodeState ruleNodeState2 = new RuleNodeState();
    ruleNodeState2.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));

    // Act and Assert
    assertEquals(ruleNodeState, ruleNodeState2);
    int expectedHashCodeResult = ruleNodeState.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeState2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeState#equals(Object)}
   *   <li>{@link RuleNodeState#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(TenantId.SYS_TENANT_ID);

    RuleNodeState ruleNodeState2 = new RuleNodeState();
    ruleNodeState2.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(ruleNodeState, ruleNodeState2);
    int expectedHashCodeResult = ruleNodeState.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeState2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeState#equals(Object)}
   *   <li>{@link RuleNodeState#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setStateData("MD");

    RuleNodeState ruleNodeState2 = new RuleNodeState();
    ruleNodeState2.setStateData("MD");

    // Act and Assert
    assertEquals(ruleNodeState, ruleNodeState2);
    int expectedHashCodeResult = ruleNodeState.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeState2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeState#equals(Object)}
   *   <li>{@link RuleNodeState#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();

    // Act and Assert
    assertEquals(ruleNodeState, ruleNodeState);
    int expectedHashCodeResult = ruleNodeState.hashCode();
    assertEquals(expectedHashCodeResult, ruleNodeState.hashCode());
  }

  /**
   * Method under test: {@link RuleNodeState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleNodeState(), 1);
  }

  /**
   * Method under test: {@link RuleNodeState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(ruleNodeState, new RuleNodeState());
  }

  /**
   * Method under test: {@link RuleNodeState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(ruleNodeState, new RuleNodeState());
  }

  /**
   * Method under test: {@link RuleNodeState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setStateData("MD");

    // Act and Assert
    assertNotEquals(ruleNodeState, new RuleNodeState());
  }

  /**
   * Method under test: {@link RuleNodeState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();

    RuleNodeState ruleNodeState2 = new RuleNodeState();
    ruleNodeState2.setRuleNodeId(new RuleNodeId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(ruleNodeState, ruleNodeState2);
  }

  /**
   * Method under test: {@link RuleNodeState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();

    RuleNodeState ruleNodeState2 = new RuleNodeState();
    ruleNodeState2.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(ruleNodeState, ruleNodeState2);
  }

  /**
   * Method under test: {@link RuleNodeState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();

    RuleNodeState ruleNodeState2 = new RuleNodeState();
    ruleNodeState2.setStateData("MD");

    // Act and Assert
    assertNotEquals(ruleNodeState, ruleNodeState2);
  }

  /**
   * Method under test: {@link RuleNodeState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setRuleNodeId(mock(RuleNodeId.class));

    // Act and Assert
    assertNotEquals(ruleNodeState, new RuleNodeState());
  }

  /**
   * Method under test: {@link RuleNodeState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleNodeState(), null);
  }

  /**
   * Method under test: {@link RuleNodeState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleNodeState(), "Different type to RuleNodeState");
  }

  /**
   * Method under test: {@link RuleNodeState#RuleNodeState(RuleNodeState)}
   */
  @Test
  void testNewRuleNodeState() {
    // Arrange
    RuleNodeState event = new RuleNodeState();

    // Act and Assert
    assertEquals(event, new RuleNodeState(event));
  }
}
