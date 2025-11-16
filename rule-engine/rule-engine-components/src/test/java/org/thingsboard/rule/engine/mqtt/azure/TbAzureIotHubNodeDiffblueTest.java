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
package org.thingsboard.rule.engine.mqtt.azure;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.rule.engine.credentials.ClientCredentials;
import org.thingsboard.rule.engine.credentials.CredentialsType;
import org.thingsboard.rule.engine.mqtt.TbMqttNodeConfiguration;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleNode;

class TbAzureIotHubNodeDiffblueTest {
  /**
   * Test {@link TbAzureIotHubNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link TbMqttNodeConfiguration} (default constructor) ClientId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbAzureIotHubNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given '42'; when TbMqttNodeConfiguration (default constructor) ClientId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAzureIotHubNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_given42_whenTbMqttNodeConfigurationClientIdIs42()
      throws TbNodeException {
    // Arrange
    TbAzureIotHubNode tbAzureIotHubNode = new TbAzureIotHubNode();

    RuleNode ruleNode = new RuleNode();
    ruleNode.setId(new RuleNodeId(UUID.randomUUID()));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getExternalCallExecutor()).thenThrow(new RuntimeException());
    when(ctx.getSelf()).thenReturn(ruleNode);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    ClientCredentials credentials = mock(ClientCredentials.class);
    when(credentials.getType()).thenReturn(CredentialsType.ANONYMOUS);

    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setClientId("42");
    tbMqttNodeConfiguration.setCredentials(credentials);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbAzureIotHubNode.init(
                ctx, new TbNodeConfiguration(new POJONode(tbMqttNodeConfiguration))));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).getSelf();
    verify(ctx).getTenantId();
    verify(ctx).isExternalNodeForceAck();
    verify(credentials, atLeast(1)).getType();
  }

  /**
   * Test {@link TbAzureIotHubNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAzureIotHubNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAzureIotHubNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbAzureIotHubNode tbAzureIotHubNode = new TbAzureIotHubNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenThrow(new RuntimeException());
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbAzureIotHubNode.init(ctx, new TbNodeConfiguration(data)));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbAzureIotHubNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAzureIotHubNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAzureIotHubNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbAzureIotHubNode tbAzureIotHubNode = new TbAzureIotHubNode();

    RuleNode ruleNode = new RuleNode();
    ruleNode.setId(new RuleNodeId(UUID.randomUUID()));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getExternalCallExecutor()).thenThrow(new RuntimeException());
    when(ctx.getSelf()).thenReturn(ruleNode);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    ClientCredentials credentials = mock(ClientCredentials.class);
    when(credentials.getType()).thenReturn(CredentialsType.ANONYMOUS);

    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setCredentials(credentials);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbAzureIotHubNode.init(
                ctx, new TbNodeConfiguration(new POJONode(tbMqttNodeConfiguration))));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).getSelf();
    verify(ctx).getTenantId();
    verify(ctx).isExternalNodeForceAck();
    verify(credentials, atLeast(1)).getType();
  }
}
