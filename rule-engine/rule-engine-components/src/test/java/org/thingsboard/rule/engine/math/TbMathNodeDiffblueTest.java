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
package org.thingsboard.rule.engine.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.dao.attributes.BaseAttributesService;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;
import org.thingsboard.server.dao.timeseries.BaseTimeseriesService;

class TbMathNodeDiffblueTest {
  /**
   * Test {@link TbMathNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMathNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();
    TbContext ctx = mock(TbContext.class);

    ArrayList<TbMathArgument> arguments = new ArrayList<>();
    arguments.add(new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key"));

    TbMathNodeConfiguration tbMathNodeConfiguration = new TbMathNodeConfiguration();
    tbMathNodeConfiguration.setOperation(TbRuleNodeMathFunctionType.ADD);
    tbMathNodeConfiguration.setArguments(arguments);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbMathNode.init(ctx, new TbNodeConfiguration(new POJONode(tbMathNodeConfiguration))));
  }

  /**
   * Test {@link TbMathNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMathNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenThrowRuntimeException2() throws TbNodeException {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();
    TbContext ctx = mock(TbContext.class);

    ArrayList<TbMathArgument> arguments = new ArrayList<>();
    arguments.add(new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key"));
    arguments.add(new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key"));
    arguments.add(new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key"));

    TbMathNodeConfiguration tbMathNodeConfiguration = new TbMathNodeConfiguration();
    tbMathNodeConfiguration.setOperation(TbRuleNodeMathFunctionType.ADD);
    tbMathNodeConfiguration.setArguments(arguments);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbMathNode.init(ctx, new TbNodeConfiguration(new POJONode(tbMathNodeConfiguration))));
  }

  /**
   * Test {@link TbMathNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgCallback#EMPTY}.
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)} does nothing.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given EMPTY; when TbContext tellFailure(TbMsg, Throwable) does nothing; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMathNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenEmpty_whenTbContextTellFailureDoesNothing_thenCallsTellFailure() {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(null);
    when(msg.getCallback()).thenReturn(TbMsgCallback.EMPTY);

    // Act
    tbMathNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getCallback();
    verify(msg).getOriginator();
  }

  /**
   * Test {@link TbMathNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>When {@link TbContext}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given RuntimeException(); when TbContext; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMathNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenRuntimeException_whenTbContext_thenThrowRuntimeException() {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMathNode.onMsg(ctx, msg));
    verify(msg).getOriginator();
  }

  /**
   * Test {@link TbMathNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgCallback} {@link TbMsgCallback#isMsgValid()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link TbMsgCallback#isMsgValid()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgCallback isMsgValid() throw RuntimeException(); then calls isMsgValid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMathNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgCallbackIsMsgValidThrowRuntimeException_thenCallsIsMsgValid() {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    when(tbMsgCallback.isMsgValid()).thenThrow(new RuntimeException());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(null);
    when(msg.getCallback()).thenReturn(tbMsgCallback);

    // Act
    tbMathNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getCallback();
    verify(msg).getOriginator();
    verify(tbMsgCallback).isMsgValid();
  }

  /**
   * Test {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)}.
   *
   * <p>Method under test: {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional,
   * TbMathArgument)}
   */
  @Test
  @DisplayName("Test resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbMathNode.resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)"
  })
  void testResolveArguments() throws InterruptedException, ExecutionException {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    Optional<ObjectNode> msgBodyOpt = Optional.of(new ObjectNode(nc));

    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.MESSAGE_BODY, "Key");
    arg.setDefaultValue(10.0d);

    // Act
    ListenableFuture<TbMathArgumentValue> actualResolveArgumentsResult =
        tbMathNode.resolveArguments(ctx, msg, msgBodyOpt, arg);

    // Assert
    verify(msg).getData();
    verify(msg).getMetaData();
    assertEquals(10.0d, actualResolveArgumentsResult.get().getValue());
    assertTrue(actualResolveArgumentsResult.isDone());
  }

  /**
   * Test {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)}.
   *
   * <p>Method under test: {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional,
   * TbMathArgument)}
   */
  @Test
  @DisplayName("Test resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbMathNode.resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)"
  })
  void testResolveArguments2() throws InterruptedException, ExecutionException {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    Optional<ObjectNode> msgBodyOpt = Optional.of(new ObjectNode(nc));

    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.MESSAGE_METADATA, "Key");
    arg.setDefaultValue(10.0d);

    // Act
    ListenableFuture<TbMathArgumentValue> actualResolveArgumentsResult =
        tbMathNode.resolveArguments(ctx, msg, msgBodyOpt, arg);

    // Assert
    verify(msg).getData();
    verify(msg, atLeast(1)).getMetaData();
    assertEquals(10.0d, actualResolveArgumentsResult.get().getValue());
    assertTrue(actualResolveArgumentsResult.isDone());
  }

  /**
   * Test {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()} Value empty string is empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional,
   * TbMathArgument)}
   */
  @Test
  @DisplayName(
      "Test resolveArguments(TbContext, TbMsg, Optional, TbMathArgument); given TbMsgMetaData() Value empty string is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbMathNode.resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)"
  })
  void testResolveArguments_givenTbMsgMetaDataValueEmptyStringIsEmptyString()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();
    TbContext ctx = mock(TbContext.class);

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("", "");

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    Optional<ObjectNode> msgBodyOpt = Optional.of(new ObjectNode(nc));

    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.MESSAGE_BODY, "Key");
    arg.setDefaultValue(10.0d);

    // Act
    ListenableFuture<TbMathArgumentValue> actualResolveArgumentsResult =
        tbMathNode.resolveArguments(ctx, msg, msgBodyOpt, arg);

    // Assert
    verify(msg).getData();
    verify(msg).getMetaData();
    assertEquals(10.0d, actualResolveArgumentsResult.get().getValue());
    assertTrue(actualResolveArgumentsResult.isDone());
  }

  /**
   * Test {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When empty.
   *   <li>Then return {@link ListenableFuture#get()} Value is ten.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional,
   * TbMathArgument)}
   */
  @Test
  @DisplayName(
      "Test resolveArguments(TbContext, TbMsg, Optional, TbMathArgument); given ten; when empty; then return get() Value is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbMathNode.resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)"
  })
  void testResolveArguments_givenTen_whenEmpty_thenReturnGetValueIsTen()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());
    Optional<ObjectNode> msgBodyOpt = Optional.empty();

    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.MESSAGE_BODY, "Key");
    arg.setDefaultValue(10.0d);

    // Act
    ListenableFuture<TbMathArgumentValue> actualResolveArgumentsResult =
        tbMathNode.resolveArguments(ctx, msg, msgBodyOpt, arg);

    // Assert
    verify(msg).getData();
    verify(msg).getMetaData();
    assertEquals(10.0d, actualResolveArgumentsResult.get().getValue());
    assertTrue(actualResolveArgumentsResult.isDone());
  }

  /**
   * Test {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#getAttributesService()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional,
   * TbMathArgument)}
   */
  @Test
  @DisplayName(
      "Test resolveArguments(TbContext, TbMsg, Optional, TbMathArgument); then calls getAttributesService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbMathNode.resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)"
  })
  void testResolveArguments_thenCallsGetAttributesService() {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.getAttributesService()).thenReturn(new BaseAttributesService(new JpaAttributeDao()));

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenThrow(new RuntimeException());
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    Optional<ObjectNode> msgBodyOpt = Optional.of(new ObjectNode(nc));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            tbMathNode.resolveArguments(
                ctx, msg, msgBodyOpt, new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key")));
    verify(ctx).getAttributesService();
    verify(ctx).getTenantId();
    verify(msg).getData();
    verify(msg).getMetaData();
    verify(msg).getOriginator();
  }

  /**
   * Test {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional,
   * TbMathArgument)}
   */
  @Test
  @DisplayName(
      "Test resolveArguments(TbContext, TbMsg, Optional, TbMathArgument); then calls getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbMathNode.resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)"
  })
  void testResolveArguments_thenCallsGetTenantId() {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTimeseriesService()).thenReturn(new BaseTimeseriesService());
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenThrow(new RuntimeException());
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    Optional<ObjectNode> msgBodyOpt = Optional.of(new ObjectNode(nc));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            tbMathNode.resolveArguments(
                ctx, msg, msgBodyOpt, new TbMathArgument(TbMathArgumentType.TIME_SERIES, "Key")));
    verify(ctx).getTenantId();
    verify(ctx).getTimeseriesService();
    verify(msg).getData();
    verify(msg).getMetaData();
    verify(msg).getOriginator();
  }

  /**
   * Test {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getAttributesService()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional,
   * TbMathArgument)}
   */
  @Test
  @DisplayName(
      "Test resolveArguments(TbContext, TbMsg, Optional, TbMathArgument); when TbContext getAttributesService() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbMathNode.resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)"
  })
  void testResolveArguments_whenTbContextGetAttributesServiceThrowRuntimeException() {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getAttributesService()).thenThrow(new RuntimeException());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    Optional<ObjectNode> msgBodyOpt = Optional.of(new ObjectNode(nc));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            tbMathNode.resolveArguments(
                ctx, msg, msgBodyOpt, new TbMathArgument(TbMathArgumentType.ATTRIBUTE, "Key")));
    verify(ctx).getAttributesService();
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getTimeseriesService()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional,
   * TbMathArgument)}
   */
  @Test
  @DisplayName(
      "Test resolveArguments(TbContext, TbMsg, Optional, TbMathArgument); when TbContext getTimeseriesService() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbMathNode.resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)"
  })
  void testResolveArguments_whenTbContextGetTimeseriesServiceThrowRuntimeException() {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTimeseriesService()).thenThrow(new RuntimeException());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    Optional<ObjectNode> msgBodyOpt = Optional.of(new ObjectNode(nc));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            tbMathNode.resolveArguments(
                ctx, msg, msgBodyOpt, new TbMathArgument(TbMathArgumentType.TIME_SERIES, "Key")));
    verify(ctx).getTimeseriesService();
    verify(msg).getData();
    verify(msg).getMetaData();
  }
}
