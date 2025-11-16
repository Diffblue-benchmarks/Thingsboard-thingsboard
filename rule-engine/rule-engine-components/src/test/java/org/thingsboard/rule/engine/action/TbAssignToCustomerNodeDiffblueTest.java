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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbAssignToCustomerNodeDiffblueTest {
  /**
   * Test {@link TbAssignToCustomerNode#loadCustomerNodeActionConfig(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then return {@link TbAssignToCustomerNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAssignToCustomerNode#loadCustomerNodeActionConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadCustomerNodeActionConfig(TbNodeConfiguration); then return TbAssignToCustomerNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbAssignToCustomerNodeConfiguration TbAssignToCustomerNode.loadCustomerNodeActionConfig(TbNodeConfiguration)"
  })
  void testLoadCustomerNodeActionConfig_thenReturnTbAssignToCustomerNodeConfiguration()
      throws TbNodeException {
    // Arrange
    TbAssignToCustomerNode tbAssignToCustomerNode = new TbAssignToCustomerNode();
    TbAssignToCustomerNodeConfiguration tbAssignToCustomerNodeConfiguration =
        new TbAssignToCustomerNodeConfiguration();

    // Act
    TbAssignToCustomerNodeConfiguration actualLoadCustomerNodeActionConfigResult =
        tbAssignToCustomerNode.loadCustomerNodeActionConfig(
            new TbNodeConfiguration(new POJONode(tbAssignToCustomerNodeConfiguration)));

    // Assert
    assertSame(tbAssignToCustomerNodeConfiguration, actualLoadCustomerNodeActionConfigResult);
  }

  /**
   * Test new {@link TbAssignToCustomerNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbAssignToCustomerNode}
   */
  @Test
  @DisplayName("Test new TbAssignToCustomerNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAssignToCustomerNode.<init>()"})
  void testNewTbAssignToCustomerNode() {
    // Arrange, Act and Assert
    assertNull(new TbAssignToCustomerNode().config);
  }
}
