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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.EntityType;

class TbCreateRelationNodeDiffblueTest {
  /**
   * Test {@link TbCreateRelationNode#loadEntityNodeActionConfig(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then return {@link TbCreateRelationNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * TbCreateRelationNode#loadEntityNodeActionConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadEntityNodeActionConfig(TbNodeConfiguration); then return TbCreateRelationNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbCreateRelationNodeConfiguration TbCreateRelationNode.loadEntityNodeActionConfig(TbNodeConfiguration)"
  })
  void testLoadEntityNodeActionConfig_thenReturnTbCreateRelationNodeConfiguration()
      throws TbNodeException {
    // Arrange
    TbCreateRelationNode tbCreateRelationNode = new TbCreateRelationNode();

    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    tbCreateRelationNodeConfiguration.setEntityType(EntityType.TENANT);

    // Act
    TbCreateRelationNodeConfiguration actualLoadEntityNodeActionConfigResult =
        tbCreateRelationNode.loadEntityNodeActionConfig(
            new TbNodeConfiguration(new POJONode(tbCreateRelationNodeConfiguration)));

    // Assert
    assertSame(tbCreateRelationNodeConfiguration, actualLoadEntityNodeActionConfigResult);
  }

  /**
   * Test {@link TbCreateRelationNode#loadEntityNodeActionConfig(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbCreateRelationNode#loadEntityNodeActionConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadEntityNodeActionConfig(TbNodeConfiguration); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbCreateRelationNodeConfiguration TbCreateRelationNode.loadEntityNodeActionConfig(TbNodeConfiguration)"
  })
  void testLoadEntityNodeActionConfig_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbCreateRelationNode tbCreateRelationNode = new TbCreateRelationNode();

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbCreateRelationNode.loadEntityNodeActionConfig(
                new TbNodeConfiguration(new POJONode(new TbCreateRelationNodeConfiguration()))));
  }

  /**
   * Test new {@link TbCreateRelationNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbCreateRelationNode}
   */
  @Test
  @DisplayName("Test new TbCreateRelationNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCreateRelationNode.<init>()"})
  void testNewTbCreateRelationNode() {
    // Arrange, Act and Assert
    assertNull(new TbCreateRelationNode().config);
  }
}
