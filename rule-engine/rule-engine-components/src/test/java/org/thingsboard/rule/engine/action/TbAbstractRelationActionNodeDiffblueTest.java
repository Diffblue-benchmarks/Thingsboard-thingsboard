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
package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.EntityType;

class TbAbstractRelationActionNodeDiffblueTest {
  /**
   * Test {@link TbAbstractRelationActionNode#checkIfConfigEntityTypeIsSupported(EntityType)}.
   *
   * <ul>
   *   <li>When {@code ALARM}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractRelationActionNode#checkIfConfigEntityTypeIsSupported(EntityType)}
   */
  @Test
  @DisplayName(
      "Test checkIfConfigEntityTypeIsSupported(EntityType); when 'ALARM'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbAbstractRelationActionNode.checkIfConfigEntityTypeIsSupported(EntityType)"
  })
  void testCheckIfConfigEntityTypeIsSupported_whenAlarm_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange, Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> new TbCreateRelationNode().checkIfConfigEntityTypeIsSupported(EntityType.ALARM));
  }

  /**
   * Test {@link TbAbstractRelationActionNode#checkIfConfigEntityTypeIsSupported(EntityType)}.
   *
   * <ul>
   *   <li>When {@code ALARM}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractRelationActionNode#checkIfConfigEntityTypeIsSupported(EntityType)}
   */
  @Test
  @DisplayName(
      "Test checkIfConfigEntityTypeIsSupported(EntityType); when 'ALARM'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbAbstractRelationActionNode.checkIfConfigEntityTypeIsSupported(EntityType)"
  })
  void testCheckIfConfigEntityTypeIsSupported_whenAlarm_thenThrowTbNodeException2()
      throws TbNodeException {
    // Arrange, Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> new TbCreateRelationNode().checkIfConfigEntityTypeIsSupported(EntityType.ALARM));
  }

  /**
   * Test {@link TbAbstractRelationActionNode#checkIfConfigEntityTypeIsSupported(EntityType)}.
   *
   * <ul>
   *   <li>When {@code TENANT}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractRelationActionNode#checkIfConfigEntityTypeIsSupported(EntityType)}
   */
  @Test
  @DisplayName(
      "Test checkIfConfigEntityTypeIsSupported(EntityType); when 'TENANT'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbAbstractRelationActionNode.checkIfConfigEntityTypeIsSupported(EntityType)"
  })
  void testCheckIfConfigEntityTypeIsSupported_whenTenant_thenDoesNotThrow() throws TbNodeException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> new TbCreateRelationNode().checkIfConfigEntityTypeIsSupported(EntityType.TENANT));
  }

  /**
   * Test {@link TbAbstractRelationActionNode#checkIfConfigEntityTypeIsSupported(EntityType)}.
   *
   * <ul>
   *   <li>When {@code TENANT}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractRelationActionNode#checkIfConfigEntityTypeIsSupported(EntityType)}
   */
  @Test
  @DisplayName(
      "Test checkIfConfigEntityTypeIsSupported(EntityType); when 'TENANT'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbAbstractRelationActionNode.checkIfConfigEntityTypeIsSupported(EntityType)"
  })
  void testCheckIfConfigEntityTypeIsSupported_whenTenant_thenDoesNotThrow2()
      throws TbNodeException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> new TbCreateRelationNode().checkIfConfigEntityTypeIsSupported(EntityType.TENANT));
  }
}
