package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.TbMsg;

class TbUnassignFromCustomerNodeDiffblueTest {
  /**
   * Test {@link TbUnassignFromCustomerNode#createCustomerIfNotExists()}.
   *
   * <p>Method under test: {@link TbUnassignFromCustomerNode#createCustomerIfNotExists()}
   */
  @Test
  @DisplayName("Test createCustomerIfNotExists()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbUnassignFromCustomerNode.createCustomerIfNotExists()"})
  void testCreateCustomerIfNotExists() {
    // Arrange, Act and Assert
    assertFalse(new TbUnassignFromCustomerNode().createCustomerIfNotExists());
  }

  /**
   * Test {@link TbUnassignFromCustomerNode#loadCustomerNodeActionConfig(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then return CustomerNamePattern is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbUnassignFromCustomerNode#loadCustomerNodeActionConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadCustomerNodeActionConfig(TbNodeConfiguration); then return CustomerNamePattern is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbUnassignFromCustomerNodeConfiguration TbUnassignFromCustomerNode.loadCustomerNodeActionConfig(TbNodeConfiguration)"
  })
  void testLoadCustomerNodeActionConfig_thenReturnCustomerNamePatternIsNull()
      throws TbNodeException {
    // Arrange
    TbUnassignFromCustomerNode tbUnassignFromCustomerNode = new TbUnassignFromCustomerNode();
    TbUnassignFromCustomerNodeConfiguration tbUnassignFromCustomerNodeConfiguration =
        new TbUnassignFromCustomerNodeConfiguration();

    // Act
    TbUnassignFromCustomerNodeConfiguration actualLoadCustomerNodeActionConfigResult =
        tbUnassignFromCustomerNode.loadCustomerNodeActionConfig(
            new TbNodeConfiguration(new POJONode(tbUnassignFromCustomerNodeConfiguration)));

    // Assert
    assertNull(actualLoadCustomerNodeActionConfigResult.getCustomerNamePattern());
    assertSame(tbUnassignFromCustomerNodeConfiguration, actualLoadCustomerNodeActionConfigResult);
  }

  /**
   * Test {@link TbUnassignFromCustomerNode#processCustomerAction(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TestDbCallbackExecutor} (default constructor).
   *   <li>Then return {@link ListenableFuture#get()} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUnassignFromCustomerNode#processCustomerAction(TbContext,
   * TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processCustomerAction(TbContext, TbMsg); given TestDbCallbackExecutor (default constructor); then return get() is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbUnassignFromCustomerNode.processCustomerAction(TbContext, TbMsg)"
  })
  void testProcessCustomerAction_givenTestDbCallbackExecutor_thenReturnGetIsNull()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbUnassignFromCustomerNode tbUnassignFromCustomerNode = new TbUnassignFromCustomerNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    ListenableFuture<Void> actualProcessCustomerActionResult =
        tbUnassignFromCustomerNode.processCustomerAction(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).getTenantId();
    assertNull(actualProcessCustomerActionResult.get());
    assertTrue(actualProcessCustomerActionResult.isDone());
  }

  /**
   * Test new {@link TbUnassignFromCustomerNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * TbUnassignFromCustomerNode}
   */
  @Test
  @DisplayName("Test new TbUnassignFromCustomerNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbUnassignFromCustomerNode.<init>()"})
  void testNewTbUnassignFromCustomerNode() {
    // Arrange, Act and Assert
    assertNull(new TbUnassignFromCustomerNode().config);
  }
}
