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
package org.thingsboard.rule.engine.aws.lambda;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.dao.exception.DataValidationException;

class TbAwsLambdaNodeDiffblueTest {
  /**
   * Test {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeId#RuleNodeId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given RuleNodeId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsLambdaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenRuleNodeIdWithIdIsRandomUUID() throws TbNodeException {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenReturn(new RuleNode(new RuleNodeId(UUID.randomUUID())));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbAwsLambdaNode.init(ctx, new TbNodeConfiguration(new POJONode(null))));
    verify(ctx).getSelf();
  }

  /**
   * Test {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsLambdaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenThrowDataValidationException() throws TbNodeException {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> tbAwsLambdaNode.init(ctx, new TbNodeConfiguration(new POJONode(null))));
    verify(ctx).getSelf();
  }

  /**
   * Test {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code null}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when POJONode(Object) with v is 'null'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsLambdaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenPOJONodeWithVIsNull_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenReturn(new RuleNode());

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbAwsLambdaNode.init(ctx, new TbNodeConfiguration(new POJONode(null))));
    verify(ctx).getSelf();
  }

  /**
   * Test {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@link TbAwsLambdaNodeConfiguration}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when POJONode(Object) with v is TbAwsLambdaNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAwsLambdaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenPOJONodeWithVIsTbAwsLambdaNodeConfiguration()
      throws TbNodeException {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenReturn(new RuleNode());

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbAwsLambdaNode.init(
                ctx, new TbNodeConfiguration(new POJONode(new TbAwsLambdaNodeConfiguration()))));
    verify(ctx).getSelf();
  }
}
