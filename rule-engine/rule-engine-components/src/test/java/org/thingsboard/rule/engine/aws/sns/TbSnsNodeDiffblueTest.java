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
package org.thingsboard.rule.engine.aws.sns;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.amazonaws.services.sns.AmazonSNS;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Callable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;

@ExtendWith(MockitoExtension.class)
class TbSnsNodeDiffblueTest {
  @Mock private AmazonSNS amazonSNS;

  @InjectMocks private TbSnsNode tbSnsNode;

  /**
   * Test {@link TbSnsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@code +}.
   * </ul>
   *
   * <p>Method under test: {@link TbSnsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given '+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSnsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenPlusSign() throws TbNodeException {
    // Arrange
    TbSnsNode tbSnsNode = new TbSnsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbSnsNodeConfiguration tbSnsNodeConfiguration = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration.setRegion("+");
    tbSnsNodeConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");
    tbSnsNodeConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");

    // Act
    tbSnsNode.init(ctx, new TbNodeConfiguration(new POJONode(tbSnsNodeConfiguration)));

    // Assert
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSnsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSnsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSnsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenRuntimeException_thenThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbSnsNode tbSnsNode = new TbSnsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenThrow(new RuntimeException());
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbSnsNode.init(ctx, new TbNodeConfiguration(data)));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSnsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@code us-east-2}.
   * </ul>
   *
   * <p>Method under test: {@link TbSnsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given 'us-east-2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSnsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenUsEast2() throws TbNodeException {
    // Arrange
    TbSnsNode tbSnsNode = new TbSnsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbSnsNodeConfiguration tbSnsNodeConfiguration = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration.setRegion("us-east-2");
    tbSnsNodeConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");
    tbSnsNodeConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");

    // Act
    tbSnsNode.init(ctx, new TbNodeConfiguration(new POJONode(tbSnsNodeConfiguration)));

    // Assert
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSnsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSnsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSnsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbSnsNode tbSnsNode = new TbSnsNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbSnsNodeConfiguration tbSnsNodeConfiguration = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");
    tbSnsNodeConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbSnsNode.init(ctx, new TbNodeConfiguration(new POJONode(tbSnsNodeConfiguration))));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSnsNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link TestDbCallbackExecutor#executeAsync(Callable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSnsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls executeAsync(Callable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSnsNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsExecuteAsync() {
    // Arrange
    TestDbCallbackExecutor testDbCallbackExecutor = mock(TestDbCallbackExecutor.class);
    SettableFuture<Object> delegate = SettableFuture.create();
    ForwardingApiFuture<Object> apiFuture =
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate));
    when(testDbCallbackExecutor.executeAsync(Mockito.<Callable<Object>>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getExternalCallExecutor()).thenReturn(testDbCallbackExecutor);
    TbMsg msg = mock(TbMsg.class);

    TbMsgMetaData tbMsgMetaData = mock(TbMsgMetaData.class);
    doNothing().when(tbMsgMetaData).putValue(Mockito.<String>any(), Mockito.<String>any());
    tbMsgMetaData.putValue("Failed to process pattern!", "42");

    // Act
    tbSnsNode.onMsg(ctx, msg);

    // Assert
    verify(testDbCallbackExecutor).executeAsync(isA(Callable.class));
    verify(ctx).getExternalCallExecutor();
    verify(tbMsgMetaData).putValue("Failed to process pattern!", "42");
  }

  /**
   * Test {@link TbSnsNode#destroy()}.
   *
   * <ul>
   *   <li>Given {@link AmazonSNS} {@link AmazonSNS#shutdown()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link TbSnsNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given AmazonSNS shutdown() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSnsNode.destroy()"})
  void testDestroy_givenAmazonSNSShutdownDoesNothing() {
    // Arrange
    doNothing().when(amazonSNS).shutdown();

    // Act
    tbSnsNode.destroy();

    // Assert
    verify(amazonSNS).shutdown();
  }

  /**
   * Test {@link TbSnsNode#destroy()}.
   *
   * <ul>
   *   <li>Given {@link AmazonSNS} {@link AmazonSNS#shutdown()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSnsNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given AmazonSNS shutdown() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSnsNode.destroy()"})
  void testDestroy_givenAmazonSNSShutdownThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(amazonSNS).shutdown();

    // Act
    tbSnsNode.destroy();

    // Assert
    verify(amazonSNS).shutdown();
  }
}
