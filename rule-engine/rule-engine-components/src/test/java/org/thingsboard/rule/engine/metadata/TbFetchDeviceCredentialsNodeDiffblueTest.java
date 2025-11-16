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
package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbFetchDeviceCredentialsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given AlarmId(UUID) with id is randomUUID; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbFetchDeviceCredentialsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenAlarmIdWithIdIsRandomUUID_thenCallsTellFailure()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    tbFetchDeviceCredentialsNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getOriginator();
  }

  /**
   * Test {@link TbFetchDeviceCredentialsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#getDeviceCredentialsService()}.
   * </ul>
   *
   * <p>Method under test: {@link TbFetchDeviceCredentialsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls getDeviceCredentialsService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbFetchDeviceCredentialsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsGetDeviceCredentialsService()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceCredentialsService()).thenThrow(new RuntimeException());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(new DeviceId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbFetchDeviceCredentialsNode.onMsg(ctx, msg));
    verify(ctx).getDeviceCredentialsService();
    verify(msg, atLeast(1)).getOriginator();
  }

  /**
   * Test {@link TbFetchDeviceCredentialsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbFetchDeviceCredentialsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbContext tellFailure(TbMsg, Throwable) throw RuntimeException(); then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbFetchDeviceCredentialsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContextTellFailureThrowRuntimeException_thenCallsTellFailure()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();

    TbContext ctx = mock(TbContext.class);
    doThrow(new RuntimeException())
        .when(ctx)
        .tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbFetchDeviceCredentialsNode.onMsg(ctx, msg));
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getOriginator();
  }

  /**
   * Test {@link TbFetchDeviceCredentialsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#getOriginator()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbFetchDeviceCredentialsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbMsg getOriginator() throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbFetchDeviceCredentialsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbMsgGetOriginatorThrowRuntimeException_thenThrowRuntimeException()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    TbFetchDeviceCredentialsNode tbFetchDeviceCredentialsNode = new TbFetchDeviceCredentialsNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbFetchDeviceCredentialsNode.onMsg(ctx, msg));
    verify(msg).getOriginator();
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
