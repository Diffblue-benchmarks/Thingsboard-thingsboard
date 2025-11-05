package org.thingsboard.rule.engine.mqtt.azure;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import io.netty.channel.DefaultEventLoop;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
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
   *   <li>Given {@link DefaultEventLoop#DefaultEventLoop()}.
   *   <li>Then calls {@link TbContext#getSharedEventLoop()}.
   * </ul>
   *
   * <p>Method under test: {@link TbAzureIotHubNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given DefaultEventLoop(); then calls getSharedEventLoop()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAzureIotHubNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenDefaultEventLoop_thenCallsGetSharedEventLoop()
      throws TbNodeException {
    // Arrange
    TbAzureIotHubNode tbAzureIotHubNode = new TbAzureIotHubNode();

    RuleNode ruleNode = new RuleNode();
    ruleNode.setId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSharedEventLoop()).thenReturn(new DefaultEventLoop());
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());
    when(ctx.getSelf()).thenReturn(ruleNode);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    ClientCredentials credentials = mock(ClientCredentials.class);
    when(credentials.getType()).thenReturn(CredentialsType.ANONYMOUS);

    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setCredentials(credentials);

    TbNodeConfiguration configuration = mock(TbNodeConfiguration.class);
    when(configuration.getData()).thenReturn(new POJONode(tbMqttNodeConfiguration));

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbAzureIotHubNode.init(ctx, configuration));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).getSelf();
    verify(ctx).getSharedEventLoop();
    verify(ctx).getTenantId();
    verify(ctx).isExternalNodeForceAck();
    verify(configuration).getData();
    verify(credentials, atLeast(1)).getType();
  }

  /**
   * Test {@link TbAzureIotHubNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@link TbMqttNodeConfiguration} (default constructor) ClientId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbAzureIotHubNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given TbMqttNodeConfiguration (default constructor) ClientId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAzureIotHubNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenTbMqttNodeConfigurationClientIdIs42()
      throws TbNodeException {
    // Arrange
    TbAzureIotHubNode tbAzureIotHubNode = new TbAzureIotHubNode();

    RuleNode ruleNode = new RuleNode();
    ruleNode.setId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getExternalCallExecutor()).thenThrow(new RuntimeException());
    when(ctx.getSelf()).thenReturn(ruleNode);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    ClientCredentials credentials = mock(ClientCredentials.class);
    when(credentials.getType()).thenReturn(CredentialsType.ANONYMOUS);

    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setClientId("42");
    tbMqttNodeConfiguration.setCredentials(credentials);

    TbNodeConfiguration configuration = mock(TbNodeConfiguration.class);
    when(configuration.getData()).thenReturn(new POJONode(tbMqttNodeConfiguration));

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbAzureIotHubNode.init(ctx, configuration));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).getSelf();
    verify(ctx).getTenantId();
    verify(ctx).isExternalNodeForceAck();
    verify(configuration).getData();
    verify(credentials, atLeast(1)).getType();
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
    ruleNode.setId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getExternalCallExecutor()).thenThrow(new RuntimeException());
    when(ctx.getSelf()).thenReturn(ruleNode);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    ClientCredentials credentials = mock(ClientCredentials.class);
    when(credentials.getType()).thenReturn(CredentialsType.ANONYMOUS);

    TbMqttNodeConfiguration tbMqttNodeConfiguration = new TbMqttNodeConfiguration();
    tbMqttNodeConfiguration.setCredentials(credentials);

    TbNodeConfiguration configuration = mock(TbNodeConfiguration.class);
    when(configuration.getData()).thenReturn(new POJONode(tbMqttNodeConfiguration));

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbAzureIotHubNode.init(ctx, configuration));
    verify(ctx).getExternalCallExecutor();
    verify(ctx).getSelf();
    verify(ctx).getTenantId();
    verify(ctx).isExternalNodeForceAck();
    verify(configuration).getData();
    verify(credentials, atLeast(1)).getType();
  }
}
