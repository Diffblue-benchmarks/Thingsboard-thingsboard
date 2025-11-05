package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;

class TbFetchDeviceCredentialsNodeDiffblueTest {
  /**
   * Test {@link TbFetchDeviceCredentialsNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then return FetchTo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbFetchDeviceCredentialsNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbNodeConfiguration); then return FetchTo is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbFetchDeviceCredentialsNodeConfiguration TbFetchDeviceCredentialsNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_thenReturnFetchToIsNull() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    TbFetchDeviceCredentialsNodeConfiguration tbFetchDeviceCredentialsNodeConfiguration =
        new TbFetchDeviceCredentialsNodeConfiguration();

    // Act
    TbFetchDeviceCredentialsNodeConfiguration actualLoadNodeConfigurationResult =
        tbFetchDeviceCredentialsNode.loadNodeConfiguration(
            new TbNodeConfiguration(new POJONode(tbFetchDeviceCredentialsNodeConfiguration)));

    // Assert
    assertNull(actualLoadNodeConfigurationResult.getFetchTo());
    assertSame(tbFetchDeviceCredentialsNodeConfiguration, actualLoadNodeConfigurationResult);
  }

  /**
   * Test {@link TbFetchDeviceCredentialsNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbFetchDeviceCredentialsNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbNodeConfiguration); when POJONode(Object) with v is 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbFetchDeviceCredentialsNodeConfiguration TbFetchDeviceCredentialsNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_whenPOJONodeWithVIsNull_thenReturnNull() throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    // Act
    TbFetchDeviceCredentialsNodeConfiguration actualLoadNodeConfigurationResult =
        tbFetchDeviceCredentialsNode.loadNodeConfiguration(
            new TbNodeConfiguration(new POJONode(null)));

    // Assert
    assertNull(actualLoadNodeConfigurationResult);
  }

  /**
   * Test {@link TbFetchDeviceCredentialsNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is Instance.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbFetchDeviceCredentialsNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbNodeConfiguration); when TbNodeConfiguration(JsonNode) with data is Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbFetchDeviceCredentialsNodeConfiguration TbFetchDeviceCredentialsNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_whenTbNodeConfigurationWithDataIsInstance()
      throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    // Act
    TbFetchDeviceCredentialsNodeConfiguration actualLoadNodeConfigurationResult =
        tbFetchDeviceCredentialsNode.loadNodeConfiguration(
            new TbNodeConfiguration(NullNode.getInstance()));

    // Assert
    assertNull(actualLoadNodeConfigurationResult);
  }

  /**
   * Test {@link TbFetchDeviceCredentialsNode#loadNodeConfiguration(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbFetchDeviceCredentialsNode#loadNodeConfiguration(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbNodeConfiguration); when TbNodeConfiguration(JsonNode) with data is 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbFetchDeviceCredentialsNodeConfiguration TbFetchDeviceCredentialsNode.loadNodeConfiguration(TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_whenTbNodeConfigurationWithDataIsNull_thenReturnNull()
      throws TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    // Act
    TbFetchDeviceCredentialsNodeConfiguration actualLoadNodeConfigurationResult =
        tbFetchDeviceCredentialsNode.loadNodeConfiguration(new TbNodeConfiguration(null));

    // Assert
    assertNull(actualLoadNodeConfigurationResult);
  }

  /**
   * Test {@link TbFetchDeviceCredentialsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbFetchDeviceCredentialsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbFetchDeviceCredentialsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenRuntimeException_thenThrowRuntimeException()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceCredentialsService()).thenThrow(new RuntimeException());
    DeviceId originator = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbFetchDeviceCredentialsNode.onMsg(ctx, msg));
    verify(ctx).getDeviceCredentialsService();
  }

  /**
   * Test {@link TbFetchDeviceCredentialsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)} does nothing.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbFetchDeviceCredentialsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbContext tellFailure(TbMsg, Throwable) does nothing; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbFetchDeviceCredentialsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContextTellFailureDoesNothing_thenCallsTellFailure()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbFetchDeviceCredentialsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbFetchDeviceCredentialsNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then Second return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link TbFetchDeviceCredentialsNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then Second return DoubleNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbPair TbFetchDeviceCredentialsNode.upgrade(int, JsonNode)"})
  void testUpgrade_whenOne_thenSecondReturnDoubleNode() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act
    TbPair<Boolean, JsonNode> actualUpgradeResult =
        new TbFetchDeviceCredentialsNode().upgrade(1, oldConfiguration);

    // Assert
    JsonNode second = actualUpgradeResult.getSecond();
    assertTrue(second instanceof DoubleNode);
    assertFalse(actualUpgradeResult.getFirst());
    assertSame(oldConfiguration, second);
  }

  /**
   * Test new {@link TbFetchDeviceCredentialsNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * TbFetchDeviceCredentialsNode}
   */
  @Test
  @DisplayName("Test new TbFetchDeviceCredentialsNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbFetchDeviceCredentialsNode.<init>()"})
  void testNewTbFetchDeviceCredentialsNode() {
    // Arrange and Act
    TbFetchDeviceCredentialsNode actualTbFetchDeviceCredentialsNode =
        new TbFetchDeviceCredentialsNode();

    // Assert
    assertNull(actualTbFetchDeviceCredentialsNode.config);
    assertNull(actualTbFetchDeviceCredentialsNode.fetchTo);
  }
}
